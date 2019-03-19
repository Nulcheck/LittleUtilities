package mce.lu.common.block;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockShulkerBox;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SpikeBlock extends BlockDirectionalBase {
	protected static final AxisAlignedBB SPIKES_DOWN = new AxisAlignedBB(0d, 0.5d, 0d, 1d, 1d, 1d);
	protected static final AxisAlignedBB SPIKES_UP = new AxisAlignedBB(0d, 0d, 0d, 1d, 0.5d, 1d);
	protected static final AxisAlignedBB SPIKES_NORTH = new AxisAlignedBB(0d, 0d, 0.5d, 1d, 1d, 1d);
	protected static final AxisAlignedBB SPIKES_SOUTH = new AxisAlignedBB(0d, 0d, 0d, 1d, 1d, 0.5d);
	protected static final AxisAlignedBB SPIKES_EAST = new AxisAlignedBB(0d, 0d, 0d, 0.5d, 1d, 1d);
	protected static final AxisAlignedBB SPIKES_WEST = new AxisAlignedBB(0.5d, 0d, 0d, 1d, 1d, 1d);
	public final DamageSource SPIKES = new DamageSource("spikes");

	public SpikeBlock(String name, Material mat) {
		super(name, mat);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP));
	}

	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
		if (entity instanceof EntityLivingBase) {
			if (state.getBlock() == ModBlocks.POISON_SPIKES)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.POISON, 600, 3));
			
			if(state.getBlock() == ModBlocks.FIRE_SPIKES)
				entity.setFire(8);

			entity.attackEntityFrom(SPIKES, 1.5f);
		}
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		EnumFacing facing = (EnumFacing) state.getValue(FACING);

		switch (facing) {
		default:
		case DOWN:
			return SPIKES_DOWN;
		case UP:
			return SPIKES_UP;
		case NORTH:
			return SPIKES_NORTH;
		case SOUTH:
			return SPIKES_SOUTH;
		case EAST:
			return SPIKES_EAST;
		case WEST:
			return SPIKES_WEST;
		}
	}

	@Nullable
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
		return NULL_AABB;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean canPlaceBlockOnSide(World world, BlockPos pos, EnumFacing side) {
		return canPlaceBlock(world, pos, side);
	}

	@Override
	public boolean canPlaceBlockAt(World world, BlockPos pos) {
		for (EnumFacing facing : EnumFacing.values()) {
			if (canPlaceBlock(world, pos, facing))
				return true;
		}
		return false;
	}

	/**
	 * Gets the block it's being placed on and checks to see if it's solid
	 * 
	 * @param world
	 * @param pos
	 * @param dir
	 * @return
	 */
	protected static boolean canPlaceBlock(World world, BlockPos pos, EnumFacing dir) {
		BlockPos offsetPos = pos.offset(dir.getOpposite());
		IBlockState state = world.getBlockState(offsetPos);
		boolean flag = state.getBlockFaceShape(world, offsetPos, dir) == BlockFaceShape.SOLID;
		Block block = state.getBlock();

		if (dir == EnumFacing.UP)
			return !isExceptionBlockForAttaching(block) && flag;
		else
			return !isExceptBlockForAttachWithPiston(block) && flag;
	}

	/**
	 * Similar to vanilla's function, but I want to place spikes on glass,
	 * glowstone, etc, so I removed them from the list.
	 * 
	 * Glass, Stained Glass, Glowstone, Ice, Sea Lantern
	 * 
	 * @param block
	 * @return
	 */
	protected static boolean isExceptionBlockForAttaching(Block block) {
		return block instanceof BlockShulkerBox || block instanceof BlockLeaves || block instanceof BlockTrapDoor
				|| block == Blocks.BEACON || block == Blocks.CAULDRON;
	}

	protected static boolean isExceptBlockForAttachWithPiston(Block block) {
		return isExceptionBlockForAttaching(block) || block == Blocks.PISTON || block == Blocks.STICKY_PISTON
				|| block == Blocks.PISTON_HEAD;
	}

	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer) {
		return canPlaceBlock(world, pos, facing) ? this.getDefaultState().withProperty(FACING, facing)
				: this.getDefaultState().withProperty(FACING, EnumFacing.UP);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	/**
	 * Returns the blockstate with the given rotation from the passed
	 * blockstate. If inapplicable, returns the passed blockstate.
	 */
	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(FACING, rot.rotate((EnumFacing) state.getValue(FACING)));
	}

	/**
	 * Returns the blockstate with the given mirror of the passed blockstate. If
	 * inapplicable, returns the passed blockstate.
	 */
	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirror) {
		return state.withRotation(mirror.toRotation((EnumFacing) state.getValue(FACING)));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING });
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing facing;

		switch (meta & 7) {
		case 0:
			facing = EnumFacing.DOWN;
			break;
		case 1:
			facing = EnumFacing.EAST;
			break;
		case 2:
			facing = EnumFacing.WEST;
			break;
		case 3:
			facing = EnumFacing.SOUTH;
			break;
		case 4:
			facing = EnumFacing.NORTH;
			break;
		case 5:
		default:
			facing = EnumFacing.UP;
		}

		return this.getDefaultState().withProperty(FACING, facing);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int i;

		switch ((EnumFacing) state.getValue(FACING)) {
		case EAST:
			i = 1;
			break;
		case WEST:
			i = 2;
			break;
		case SOUTH:
			i = 3;
			break;
		case NORTH:
			i = 4;
			break;
		case UP:
		default:
			i = 5;
			break;
		case DOWN:
			i = 0;
		}

		return i;
	}

	/**
	 * Get the geometry of the queried face at the given position and state.
	 * This is used to decide whether things like buttons are allowed to be
	 * placed on the face, or how glass panes connect to the face, among other
	 * things.
	 * <p>
	 * Common values are {@code SOLID}, which is the default, and
	 * {@code UNDEFINED}, which represents something that does not fit the other
	 * descriptions and will generally cause other things not to connect to the
	 * face.
	 * 
	 * @return an approximation of the form of the given face
	 */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}
}
