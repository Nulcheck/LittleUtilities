package mce.lu.common.block;

import java.util.List;

import mce.lu.client.core.handler.GuiHandler;
import mce.lu.common.LittleUtilities;
import mce.lu.common.entity.tile.TileEntityDehydrator;
import mce.lu.common.util.ModStatsList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.xendric.xenlib.common.core.block.BlockContainerBase;

public class DehydratorBlock extends BlockContainerBase {
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	private static boolean isActive;
	private static boolean keepInv;

	public DehydratorBlock(String name, Material mat, List<Block> blockList, List<Item> itemList) {
		super(name, mat, blockList, itemList);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		this.setDefaultFacing(world, pos, state);
	}

	public void setDefaultFacing(World world, BlockPos pos, IBlockState state) {
		if (!world.isRemote) {
			IBlockState state1 = world.getBlockState(pos.north());
			IBlockState state2 = world.getBlockState(pos.south());
			IBlockState state3 = world.getBlockState(pos.west());
			IBlockState state4 = world.getBlockState(pos.east());
			EnumFacing facing = (EnumFacing) state.getValue(FACING);

			if (facing == EnumFacing.NORTH && state.isFullBlock() && !state2.isFullBlock())
				facing = EnumFacing.SOUTH;
			else if (facing == EnumFacing.SOUTH && state2.isFullBlock() && !state1.isFullBlock())
				facing = EnumFacing.NORTH;
			else if (facing == EnumFacing.WEST && state3.isFullBlock() && !state4.isFullBlock())
				facing = EnumFacing.EAST;
			else if (facing == EnumFacing.EAST && state4.isFullBlock() && !state3.isFullBlock())
				facing = EnumFacing.WEST;

			world.setBlockState(pos, state.withProperty(FACING, facing), 2);
		}
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (world.isRemote)
			return true;
		else {
			TileEntity tile = world.getTileEntity(pos);

			if (tile instanceof TileEntityDehydrator) {
				player.openGui(LittleUtilities.instance, GuiHandler.DEHYDRATOR, world, pos.getX(), pos.getY(),
						pos.getZ());
				player.addStat(ModStatsList.DEHYDRATOR_INTERACTION);
			}
			return true;
		}
	}

	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		if (!keepInv) {
			TileEntity tile = world.getTileEntity(pos);
			if (tile instanceof TileEntityDehydrator) {
				InventoryHelper.dropInventoryItems(world, pos, (TileEntityDehydrator) tile);
				world.updateComparatorOutputLevel(pos, this);
			}
		}
		super.breakBlock(world, pos, state);
	}

	public static void setState(boolean active, World world, BlockPos pos) {
		IBlockState state = world.getBlockState(pos);
		TileEntity tile = world.getTileEntity(pos);
		keepInv = true;
		isActive = active;

		if (active)
			world.setBlockState(pos,
					ModBlocks.DEHYDRATOR.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3);
		else
			world.setBlockState(pos,
					ModBlocks.DEHYDRATOR.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3);

		keepInv = false;
		if (tile != null) {
			tile.validate();
			world.setTileEntity(pos, tile);
		}
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

	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing facing = EnumFacing.getFront(meta);
		if (facing.getAxis() == EnumFacing.Axis.Y)
			facing = EnumFacing.NORTH;
		return this.getDefaultState().withProperty(FACING, facing);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing) state.getValue(FACING)).getIndex();
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(FACING, rot.rotate((EnumFacing) state.getValue(FACING)));
	}

	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirr) {
		return state.withRotation(mirr.toRotation((EnumFacing) state.getValue(FACING)));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING });
	}
}
