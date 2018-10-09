package lu.com.mce.objects.blocks;

import lu.com.mce.objects.InitBlocks;
import lu.com.mce.util.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class EdibleBlock extends BlockBase {
	public static final PropertyInteger AMOUNT = PropertyInteger.create("amount", 0, 8);
	public int lvl;
	public float sat;
	private int potion;
	private int potionDuration;
	private int potionAmplifier;
	private float potionEffectProbability;

	/**
	 * 
	 * @param name
	 * @param mat
	 * @param lvl
	 * @param sat
	 */
	public EdibleBlock(String name, Material mat, int lvl, float sat) {
		super(name, mat);
		this.lvl = lvl;
		this.sat = sat;
		this.setDefaultState(this.blockState.getBaseState().withProperty(AMOUNT, 0));
	}

	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
		int meta = getMetaFromState(state);
		double subtractY = (float) (meta * 2) / 18f;
		double d = 0.0625d;

		if (world.getBlockState(pos) == InitBlocks.PUFFERFISH_BLOCK)
			return new AxisAlignedBB(0d + d, 0d, 0d + d, 1d - d, 1d - subtractY, 1d - d);
		else
			return new AxisAlignedBB(0d, 0d, 0d, 1d, 1d - subtractY, 1d);
	}

	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}

	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!player.isSneaking()) {
			this.eatBlock(world, pos, state, player);
			return true;
		} else {
			return false;
		}
	}

	private void eatBlock(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
		if (!world.isRemote && this.potion > 0
				&& world.rand.nextFloat() < this.potionEffectProbability) {
			player.addPotionEffect(new PotionEffect(Potion.getPotionById(this.potion), this.potionDuration, this.potionAmplifier));
		}

		if (player.canEat(false)) {
			int metaState = getMetaFromState(state);
			int meta = metaState += 1;

			player.getFoodStats().addStats(lvl, sat);
			world.playSound(player, pos, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.MASTER, 0.5f,
					world.rand.nextFloat() * 0.1F + 0.9F);

			if (meta >= 8) {
				world.playSound(player, pos, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.MASTER, 0.5f,
						world.rand.nextFloat() * 0.1F + 0.9F);
				world.setBlockToAir(pos);
			} else {
				world.setBlockState(pos, getStateFromMeta(meta), 1);
			}
		}
	}

	public EdibleBlock setPotionEffect(int potion, int dur, int amp, float prob) {
		this.potion = potion;
		this.potionDuration = dur;
		this.potionAmplifier = amp;
		this.potionEffectProbability = prob;
		return this;
	}

	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(AMOUNT, meta);
	}

	public int getMetaFromState(IBlockState state) {
		return state.getValue(AMOUNT);
	}

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { AMOUNT });
	}
}
