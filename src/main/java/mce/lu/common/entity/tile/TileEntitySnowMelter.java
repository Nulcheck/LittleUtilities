package mce.lu.common.entity.tile;

import mce.lu.common.block.BlockBase;
import mce.lu.common.block.SnowMelterBlock;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

public class TileEntitySnowMelter extends TileEntity implements ITickable {
	private int tickCount;
	public static int range;
	private final int maxRange = 7;
	private final int minRange = 1;
	public static boolean redstoneMode;

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);

		redstoneMode = tag.getBoolean("RedstoneMode");
		SnowMelterBlock.setIsPowered(tag.getBoolean("Powered"));
		range = tag.getInteger("Range");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);

		tag.setBoolean("RedstoneMode", redstoneMode);
		tag.setBoolean("Powered", SnowMelterBlock.getIsPowered());
		tag.setInteger("Range", range);
		return tag;
	}

	public static int getRange() {
		return range;
	}

	public static int setRange(int rangeIn) {
		return range = rangeIn;
	}

	/**
	 * Should it be toggled on/off by redstone? Otherwise it would stay on.
	 */
	public static boolean getRedstoneMode() {
		return redstoneMode;
	}

	public static boolean setRedstoneMode(boolean redstoneModeIn) {
		return redstoneMode = redstoneModeIn;
	}

	public void changeRange() {
		int range = getRange();
		if (range <= 8) {
			setRange(range += 1);
			++range;
		}
	}

	public void meltSnow() {
		// int range = LUConfigManager.modConfig.features.snowMelterRange;

		for (BlockPos.MutableBlockPos mutablePos : BlockPos.getAllInBoxMutable(
				this.getPos().add(-range, -range, -range), this.getPos().add(range, range, range))) {
			Block block = this.getWorld().getBlockState(mutablePos).getBlock();

			if (block == Blocks.SNOW_LAYER)
				this.getWorld().setBlockToAir(mutablePos);

			else if (block == Blocks.SNOW) {
				block.dropBlockAsItem(this.getWorld(), this.getPos(), this.getWorld().getBlockState(this.getPos()), 0);
				this.getWorld().setBlockToAir(mutablePos);
			}

			else if (block == Blocks.ICE)
				BlockBase.turnIntoWater(this.getWorld(), mutablePos);
		}
	}

	@Override
	public void update() {
		if (!this.getWorld().isRemote) {
			if (getRange() < minRange)
				setRange(minRange);
			if (getRange() > maxRange)
				setRange(maxRange);

			if (getRedstoneMode() && SnowMelterBlock.getIsPowered()) {
				tickCount++;
				if (tickCount == 30) {
					meltSnow();
					tickCount = 0;
				}
			}

			else if (!getRedstoneMode()) {
				tickCount++;
				if (tickCount == 30) {
					meltSnow();
					tickCount = 0;
				}
			}
		}
	}
}
