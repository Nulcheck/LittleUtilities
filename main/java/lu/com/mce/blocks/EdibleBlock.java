package lu.com.mce.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class EdibleBlock extends Block {
	public int lvl;
	public float sat;

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
		float f1 = (float) (meta * 2) / 18f;
		this.setBlockBounds(0f, 0f, 0f, 1F, 1f - f1, 1F);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		float f1 = (float) (meta * 2) / 18f;
		return AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) z, (double) x + 1, (double) y + 1 - f1,
				(double) z + 1);

	}

	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		float f1 = (float) (meta * 2) / 18f;
		return AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) z, (double) x + 1, (double) y + 1 - f1,
				(double) z + 1);
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX,
			float hitY, float hitZ) {
		this.eatBlock(world, x, y, z, player);
		return true;
	}

	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
		this.eatBlock(world, x, y, z, player);
	}

	private void eatBlock(World world, int x, int y, int z, EntityPlayer player) {
		if (player.canEat(false)) {
			player.getFoodStats().addStats(lvl, sat);
			int meta = world.getBlockMetadata(x, y, z) + 1;

			if (meta >= 9) {
				world.setBlockToAir(x, y, z);
			} else {
				world.setBlockMetadataWithNotify(x, y, z, meta, 2);
			}
		}
	}
}
