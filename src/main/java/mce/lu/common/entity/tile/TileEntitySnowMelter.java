package mce.lu.common.entity.tile;

import mce.lu.common.block.SnowMelterBlock;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.xendric.xenlib.common.core.block.BlockBase;

public class TileEntitySnowMelter extends TileEntity implements ITickable {
	private int tickCount, range;
	private final int maxRange = 7;
	private final int minRange = 1;
	private boolean redstoneMode;
	private boolean isPowered;
	SnowMelterBlock snowMelter;

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);

		setRedstoneMode(tag.getBoolean("RedstoneMode"));
		setIsPowered(tag.getBoolean("Powered"));
		setRange(tag.getInteger("Range"));
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);

		tag.setBoolean("RedstoneMode", getRedstoneMode());
		tag.setBoolean("Powered", getIsPowered());
		tag.setInteger("Range", getRange());
		return tag;
	}

	public int getRange() {
		return range;
	}

	public int setRange(int rangeIn) {
		return range = rangeIn;
	}

	/**
	 * Should it be toggled on/off by redstone? Otherwise it would stay on.
	 */
	public boolean getRedstoneMode() {
		return redstoneMode;
	}

	public boolean setRedstoneMode(boolean redstoneModeIn) {
		return redstoneMode = redstoneModeIn;
	}

	/**
	 * Is is getting redstone power?
	 */
	public boolean getIsPowered() {
		return isPowered;
	}

	public boolean setIsPowered(boolean isPoweredIn) {
		return isPowered = isPoweredIn;
	}

	public void changeRange() {
		int range = getRange();
		if (range <= 8) {
			setRange(range += 1);
			++range;
		}
	}

	public void meltSnow() {
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

			if (getRedstoneMode()) {
				if (getIsPowered()) {
					tickCount++;
					if (tickCount == 30) {
						meltSnow();
						tickCount = 0;
					}
				}
			} else {
				tickCount++;
				if (tickCount == 30) {
					meltSnow();
					tickCount = 0;
				}
			}
		}
	}
}
