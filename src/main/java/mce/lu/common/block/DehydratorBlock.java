package mce.lu.common.block;

import java.util.List;

import mce.lu.client.core.handler.GuiHandler;
import mce.lu.common.LittleUtilities;
import mce.lu.common.entity.tile.TileEntityDehydrator;
import mce.lu.common.util.ModStatsList;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.xendric.xenlib.common.core.block.BlockContainerBase;

public class DehydratorBlock extends BlockContainerBase {
	public DehydratorBlock(String name, Material mat, List<Block> blockList, List<Item> itemList) {
		super(name, mat, blockList, itemList);
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!player.isSneaking()) {
			player.openGui(LittleUtilities.instance, GuiHandler.DEHYDRATOR, world, pos.getX(), pos.getY(), pos.getZ());
			player.addStat(ModStatsList.DEHYDRATOR_INTERACTION);
			return true;
		} else
			return false;
	}

	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntity tile = world.getTileEntity(pos);

		if (tile instanceof TileEntityDehydrator) {
			InventoryHelper.dropInventoryItems(world, pos, (TileEntityDehydrator) tile);
			world.updateComparatorOutputLevel(pos, this);
		}

		super.breakBlock(world, pos, state);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityDehydrator();
	}

	@Override
	public boolean hasComparatorInputOverride(IBlockState state) {
		return true;
	}

	@Override
	public int getComparatorInputOverride(IBlockState state, World world, BlockPos pos) {
		return Container.calcRedstone(world.getTileEntity(pos));
	}
}
