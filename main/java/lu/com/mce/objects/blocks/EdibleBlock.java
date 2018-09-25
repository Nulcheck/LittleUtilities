package lu.com.mce.objects.blocks;

import lu.com.mce.objects.InitBlocks;
import lu.com.mce.util.BlockBase;
import lu.com.mce.util.EnumAmount;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class EdibleBlock extends BlockBase {
	public int lvl;
	public float sat;
	private Potion potion;
	private int potionDuration;
	private int potionAmplifier;
	private float potionEffectProbability;

	int meta = getMetaFromState(blockState.getBaseState());
	double maxY = (float) (meta * 2) / 18f;
	double d = 0.0625d;

	protected final AxisAlignedBB BLOCK_AABB = new AxisAlignedBB(0d, 0d, 0d, 1d, 1d - maxY, 1d);
	protected final AxisAlignedBB BLOCK_PUFFER_AABB = new AxisAlignedBB(0d + d, 0d, 0d + d, 1d - d, 1d - maxY, 1d - d);
	public static final PropertyEnum<EnumAmount> AMOUNT = PropertyEnum.<EnumAmount>create("amount", EnumAmount.class);

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
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public int damageDropped(int meta) {
		return meta;
	}

	/*
	 * public void setBlockBoundsForItemRender() { this.setBlockBounds(0f, 0f,
	 * 0f, 1f, 1f, 1f); }
	 */

	public AxisAlignedBB getCollisionBoundingBoxFromPool(IBlockState blockState, IBlockAccess world, BlockPos pos) {
		if (world.getBlockState(pos) == InitBlocks.PUFFERFISH_BLOCK)
			return BLOCK_PUFFER_AABB;
		else
			return BLOCK_AABB;
	}

	public AxisAlignedBB getSelectedBoundingBoxFromPool(IBlockState state, World world, BlockPos pos) {
		if (world.getBlockState(pos) == InitBlocks.PUFFERFISH_BLOCK)
			return BLOCK_PUFFER_AABB;
		else
			return BLOCK_AABB;
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
		if (!world.isRemote && this.potion.getIdFromPotion(potion) > 0
				&& world.rand.nextFloat() < this.potionEffectProbability) {
			player.addPotionEffect(new PotionEffect(this.potion, this.potionDuration * 20, this.potionAmplifier));
		}

		if (player.canEat(false)) {
			player.getFoodStats().addStats(lvl, sat);
			int meta = getMetaFromState(state) + 1;
			world.playSound(player, pos, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.MASTER, 0.5f,
					world.rand.nextFloat() * 0.1F + 0.9F);

			if (meta >= 9) {
				world.playSound(player, pos, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.MASTER, 0.5f,
						world.rand.nextFloat() * 0.1F + 0.9F);
				world.setBlockToAir(pos);
			}
		}
	}

	public EdibleBlock setPotionEffect(Potion potion, int dur, int amp, float prob) {
		this.potion = potion;
		this.potionDuration = dur;
		this.potionAmplifier = amp;
		this.potionEffectProbability = prob;
		return this;
	}

	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(AMOUNT, EnumAmount.byMetadata(meta));
	}

	public int getMetaFromState(IBlockState state) {
		return ((EnumAmount) state.getValue(AMOUNT)).getMetadata();
	}
}
