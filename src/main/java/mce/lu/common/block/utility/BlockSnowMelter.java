package mce.lu.common.block.utility;

import java.util.List;

import mce.lu.common.entity.tile.TileEntitySnowMelter;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.xendric.xenlib.common.core.block.BlockContainerBase;
import net.xendric.xenlib.common.util.WrenchHandler;

public class BlockSnowMelter extends BlockContainerBase {
	public BlockSnowMelter(String name, Material mat, List<Block> blockList, List<Item> itemList) {
		super(name, mat, blockList, itemList);
		this.setTickRandomly(true);
	}

	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		super.onBlockAdded(world, pos, state);
		TileEntitySnowMelter tile = (TileEntitySnowMelter) world.getTileEntity(pos);

		if (tile.getRedstoneMode()) {
			if (world.isBlockPowered(pos) || world.isBlockIndirectlyGettingPowered(pos) >= 1)
				tile.setIsPowered(true);
			else
				tile.setIsPowered(false);
		} else {
			tile.setIsPowered(false);
		}
	}

	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
		TileEntitySnowMelter tile = (TileEntitySnowMelter) world.getTileEntity(pos);

		if (tile.getRedstoneMode()) {
			if (world.isBlockPowered(pos) || world.isBlockIndirectlyGettingPowered(pos) >= 1)
				tile.setIsPowered(true);
			else
				tile.setIsPowered(false);
		} else {
			tile.setIsPowered(false);
		}
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ);
		TileEntitySnowMelter tile = (TileEntitySnowMelter) world.getTileEntity(pos);

		// TODO: Use any wrench from any mod
		if (!world.isRemote) {
			if (player.isSneaking()) {
				if (WrenchHandler.holdingWrench(player)) {
					tile.setRedstoneMode(!tile.getRedstoneMode());
					player.sendMessage(new TextComponentString("Redstone Mode: " + tile.getRedstoneMode()));
				} else {
					player.sendMessage(new TextComponentString("Redstone Mode: " + tile.getRedstoneMode()));
					player.sendMessage(new TextComponentString("Range: " + tile.getRange() + " / 7"));
				}
			}

			if (!player.isSneaking()) {
				if (WrenchHandler.holdingWrench(player)) {
					tile.changeRange();

					if (tile.getRange() >= 8)
						tile.setRange(1);

					player.sendMessage(new TextComponentString("Range: " + tile.getRange()));
				} else
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
