package lu.com.mce.objects.blocks;

import lu.com.mce.util.BlockBase;
import lu.com.mce.util.EnumAmount;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class UsableBlock extends BlockBase {
	private Potion potion;
	private int potionDuration;
	private int potionAmplifier;
	private float potionEffectProbability;

	int meta = getMetaFromState(blockState.getBaseState());
	double maxY = (float) (meta * 2) / 18f;

	protected final AxisAlignedBB BLOCK_AABB = new AxisAlignedBB(0d, 0d, 0d, 1d, 1d - maxY, 1d);
	public static final PropertyEnum<EnumAmount> AMOUNT = PropertyEnum.<EnumAmount>create("amount", EnumAmount.class);

	public UsableBlock(String name, Material mat) {
		super(name, mat);
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	public boolean isOpaqueCube(IBlockState state) {
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
		return BLOCK_AABB;
	}

	public AxisAlignedBB getSelectedBoundingBoxFromPool(IBlockState state, World world, BlockPos pos) {
		return BLOCK_AABB;
	}

	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!player.isSneaking()) {
			this.useBlock(world, pos, state, player);
			return true;
		} else {
			return false;
		}
	}

	private void useBlock(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
		if (!world.isRemote && this.potion.getIdFromPotion(potion) > 0
				&& world.rand.nextFloat() < this.potionEffectProbability) {
			player.addPotionEffect(new PotionEffect(this.potion, this.potionDuration * 20, this.potionAmplifier));
		}

		int meta = getMetaFromState(state) + 1;

		if (meta >= 9)
			world.setBlockToAir(pos);
	}

	public UsableBlock setPotionEffect(Potion potion, int dur, int amp, float prob) {
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
