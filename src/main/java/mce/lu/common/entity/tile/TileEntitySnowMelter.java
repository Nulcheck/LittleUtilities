package mce.lu.common.entity.tile;

import mce.lu.common.block.BlockBase;
import mce.lu.common.block.SnowMelter;
import mce.lu.common.util.config.LUConfigManager;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

public class TileEntitySnowMelter extends TileEntity implements ITickable {
	private int tickCount;
	
	@Override
	public void readFromNBT(NBTTagCompound tag){
		super.readFromNBT(tag);
		
		SnowMelter.isActive = tag.getBoolean("Powered");
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tag){
		super.writeToNBT(tag);
		
		tag.setBoolean("Powered", SnowMelter.isActive);
		return tag;
	}
	
	public void meltSnow() {
		int range = LUConfigManager.modConfig.features.snowMelterRange;

		for (BlockPos.MutableBlockPos mutablePos : BlockPos.getAllInBoxMutable(this.getPos().add(-range, -range, -range),
				this.getPos().add(range, range, range))) {
			Block block = this.getWorld().getBlockState(mutablePos).getBlock();

			if (block == Blocks.SNOW_LAYER)
				this.getWorld().setBlockToAir(mutablePos);
			
			else if (block == Blocks.SNOW){
				block.dropBlockAsItem(this.getWorld(), this.getPos(), this.getWorld().getBlockState(this.getPos()), 0);
				this.getWorld().setBlockToAir(mutablePos);
			}

			else if (block == Blocks.ICE)
				BlockBase.turnIntoWater(this.getWorld(), mutablePos);
		}
	}
	
	@Override
	public void update(){
		if(!this.getWorld().isRemote){
			if(SnowMelter.isActive){
				tickCount++;
				if(tickCount == 30){
					meltSnow();
					tickCount = 0;
				}
			}
		}
	}
}
