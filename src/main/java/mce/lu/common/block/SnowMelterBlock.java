package mce.lu.common.block;

import mce.lu.common.entity.tile.TileEntitySnowMelter;
import mce.lu.common.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class SnowMelterBlock extends BlockContainerBase {
	private static boolean isPowered;

	public SnowMelterBlock(String name, Material mat) {
		super(name, mat);
		this.setTickRandomly(true);
	}

	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		super.onBlockAdded(world, pos, state);

		if (TileEntitySnowMelter.getRedstoneMode()) {
			if (world.isBlockPowered(pos) || world.isBlockIndirectlyGettingPowered(pos) >= 1)
				setIsPowered(true);
			else
				setIsPowered(false);
		} else {
			setIsPowered(false);
		}
	}

	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
		if (TileEntitySnowMelter.getRedstoneMode()) {
			if (world.isBlockPowered(pos) || world.isBlockIndirectlyGettingPowered(pos) >= 1)
				setIsPowered(true);
			else
				setIsPowered(false);
		} else {
			setIsPowered(false);
		}
	}

	/**
	 * Is is getting redstone power?
	 */
	public static boolean getIsPowered() {
		return isPowered;
	}

	public static boolean setIsPowered(boolean isPoweredIn) {
		return isPowered = isPoweredIn;
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		TileEntitySnowMelter tile = (TileEntitySnowMelter) world.getTileEntity(pos);

		if (!world.isRemote) {
			if (!player.isSneaking() && !player.getHeldItemMainhand().isEmpty()
					&& player.getHeldItemMainhand().getItem() == ModItems.WRENCH) {
				tile.changeRange();

				if (TileEntitySnowMelter.getRange() >= 8)
					TileEntitySnowMelter.setRange(1);

				player.sendMessage(new TextComponentString("Range: " + TileEntitySnowMelter.getRange()));
			}

			else if (player.isSneaking()) {
				if (player.getHeldItemMainhand().getItem() == ModItems.WRENCH
						&& !player.getHeldItemMainhand().isEmpty()) {
					System.out.println("DOES IT FUCKING WORK NOW");
					TileEntitySnowMelter.setRedstoneMode(!TileEntitySnowMelter.getRedstoneMode());
					player.sendMessage(
							new TextComponentString("Redstone Mode: " + TileEntitySnowMelter.getRedstoneMode()));
				} else {
					player.sendMessage(
							new TextComponentString("Redstone Mode: " + TileEntitySnowMelter.getRedstoneMode()));
					player.sendMessage(new TextComponentString("Range: " + TileEntitySnowMelter.getRange()));
				}
			}

			else {
				tile.meltSnow();
			}
		}

		return true;

	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntitySnowMelter();
	}
}
