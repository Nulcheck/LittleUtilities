package lu.com.mce.blocks;

import lu.com.mce.common.mod_lu;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class EdibleBlock extends Block {
	public int lvl;
	public float sat;
	private int potionId;
	private int potionDuration;
	private int potionAmplifier;
	private float potionEffectProbability;
	float f1;

	public EdibleBlock(Material mat, int lvl, float sat) {
		super(mat);
		this.lvl = lvl;
		this.sat = sat;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public int damageDropped(int meta) {
		return meta;
	}

	public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z) {
		int meta = block.getBlockMetadata(x, y, z);
		f1 = (float) (meta * 2) / 18f;
		this.setBlockBounds(0f, 0f, 0f, 1F, 1f - f1, 1F);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		float f = 0.0625F;
		if (world.getBlock(x, y, z) == mod_lu.pufferfishBlock)
			return AxisAlignedBB.getBoundingBox((double) x + f, (double) y, (double) z + f, (double) x + 1 - f, (double) y + 1 - f1, (double) z + 1 - f);
		else
			return AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) z, (double) x + 1, (double) y + 1 - f1, (double) z + 1);
	}

	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
		float f = 0.0625F;
		if (world.getBlock(x, y, z) == mod_lu.pufferfishBlock)
			return AxisAlignedBB.getBoundingBox((double) x + f, (double) y, (double) z + f, (double) x + 1 - f, (double) y + 1 - f1, (double) z + 1 - f);
		else
			return AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) z, (double) x + 1, (double) y + 1 - f1, (double) z + 1);
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
		if (!player.isSneaking()) {
			this.eatBlock(world, x, y, z, player);
			return true;
		} else {
			return false;
		}
	}

	private void eatBlock(World world, int x, int y, int z, EntityPlayer player) {
		if (!world.isRemote && this.potionId > 0 && world.rand.nextFloat() < this.potionEffectProbability) {
			player.addPotionEffect(new PotionEffect(this.potionId, this.potionDuration * 20, this.potionAmplifier));
		}

		if (player.canEat(false)) {
			player.getFoodStats().addStats(lvl, sat);
			int meta = world.getBlockMetadata(x, y, z) + 1;
			world.playSoundAtEntity(player, "random.eat", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);

			if (meta >= 9) {
				world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
				world.setBlockToAir(x, y, z);
			} else {
				world.setBlockMetadataWithNotify(x, y, z, meta, 2);
			}
		}
	}

	public EdibleBlock setPotionEffect(int id, int dur, int amp, float prob) {
		this.potionId = id;
		this.potionDuration = dur;
		this.potionAmplifier = amp;
		this.potionEffectProbability = prob;
		return this;
	}
}
