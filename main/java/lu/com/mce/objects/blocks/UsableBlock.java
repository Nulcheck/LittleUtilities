package lu.com.mce.objects.blocks;

import lu.com.mce.util.BlockBase;
import lu.com.mce.util.EnumAmount;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
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
	public static final PropertyEnum<EnumAmount> AMOUNT = PropertyEnum.create("amount", EnumAmount.class);
	private Potion potion;
	private int potionDuration;
	private int potionAmplifier;
	private float potionEffectProbability;

	int meta = getMetaFromState(blockState.getBaseState());
	double subtractY = (float) (meta * 2) / 18f;

	public UsableBlock(String name, Material mat) {
		super(name, mat);
		this.setDefaultState(this.blockState.getBaseState().withProperty(AMOUNT, EnumAmount.NINE));
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0d, 0d, 0d, 1d, 1d - subtractY, 1d);
	}

	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos) {
		return new AxisAlignedBB(0d, 0d, 0d, 1d, 1d - subtractY, 1d);
	}
	
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
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

		int metaState = getMetaFromState(state);
		int meta = metaState + 1;
		System.out.println(meta);

		if (metaState >= 9)
			world.setBlockToAir(pos);
		
		getStateFromMeta(meta);
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

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { AMOUNT });
	}
}
