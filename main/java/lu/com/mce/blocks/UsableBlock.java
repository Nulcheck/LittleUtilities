package lu.com.mce.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class UsableBlock extends Block {
	private int potionId;
	private int potionDuration;
	private int potionAmplifier;
	private float potionEffectProbability;

	public UsableBlock(Material mat) {
		super(mat);
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public int getDamageValue(World world, int x, int y, int z) {
		return super.getDamageValue(world, x, y, z) & 9;
	}

	public int damageDropped(int meta) {
		return meta;
	}

	public static int getMeta(int meta) {
		return ~meta & 8;
	}

	public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z) {
		int meta = block.getBlockMetadata(x, y, z);
		float f1 = (float) (meta * 2) / 18f;
		this.setBlockBounds(0f, 0f, 0f, 1F, 1f - f1, 1F);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		float f1 = (float) (meta * 2) / 18f;
		return AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) z, (double) x + 1, (double) y + 1 - f1, (double) z + 1);

	}

	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		float f1 = (float) (meta * 2) / 18f;
		return AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) z, (double) x + 1, (double) y + 1 - f1, (double) z + 1);
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
		if(!player.isSneaking()){
			this.useBlock(world, x, y, z, player);
			return true;
		} else {
			return false;
		}
	}

	private void useBlock(World world, int x, int y, int z, EntityPlayer player) {
		if (!world.isRemote && this.potionId > 0 && world.rand.nextFloat() < this.potionEffectProbability) {
			player.addPotionEffect(new PotionEffect(this.potionId, this.potionDuration * 20, this.potionAmplifier));
		}

		int meta = world.getBlockMetadata(x, y, z) + 1;

		if (meta >= 9) {
			world.setBlockToAir(x, y, z);
		} else {
			world.setBlockMetadataWithNotify(x, y, z, meta, 2);
		}
	}

	public UsableBlock setPotionEffect(int id, int dur, int amp, float prob) {
		this.potionId = id;
		this.potionDuration = dur;
		this.potionAmplifier = amp;
		this.potionEffectProbability = prob;
		return this;
	}
}
