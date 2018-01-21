package lu.com.mce.blocks;

import java.util.List;
import java.util.Random;

import lu.com.mce.common.mod_lu;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockNetherrack;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class ModBlocks extends Block {
	public ModBlocks(Material mat) {
		super(mat);
	}

	public static class GhastTearBlock extends Block {
		public GhastTearBlock(Material mat) {
			super(mat);
		}

		public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
			double d0 = 0.0625d;

			for (int l = 0; l < 6; ++l) {
				double d1 = (double) ((float) x + rand.nextFloat());
				double d2 = (double) ((float) y + rand.nextFloat());
				double d3 = (double) ((float) z + rand.nextFloat());

				if (l == 0 && !world.getBlock(x, y + 1, z).isOpaqueCube()) {
					d2 = (double) (y + 1) + d0;
				}

				if (l == 1 && !world.getBlock(x, y - 1, z).isOpaqueCube()) {
					d2 = (double) (y + 0) - d0;
				}

				if (l == 2 && !world.getBlock(x, y, z + 1).isOpaqueCube()) {
					d3 = (double) (z + 1) + d0;
				}

				if (l == 3 && !world.getBlock(x, y, z - 1).isOpaqueCube()) {
					d3 = (double) (z + 0) - d0;
				}

				if (l == 4 && !world.getBlock(x + 1, y, z).isOpaqueCube()) {
					d1 = (double) (x + 1) + d0;
				}

				if (l == 5 && !world.getBlock(x - 1, y, z).isOpaqueCube()) {
					d1 = (double) (x + 0) - d0;
				}

				if (d1 < (double) x || d1 > (double) (x + 1) || d2 < 0.0D || d2 > (double) (y + 1) || d3 < (double) z || d3 > (double) (z + 1)) {
					mod_lu.proxy.spawnParticle(world, x, y, z, "ghastTearFx");
				}
			}
		}
	}

	public static class BlazeRodBlock extends Block {
		public BlazeRodBlock(Material mat) {
			super(mat);
		}

		public void onEntityWalking(World world, int x, int y, int z, Entity e) {
			e.setFire(8);
			super.onEntityWalking(world, x, y, z, e);
		}

		public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side) {
			if (side == ForgeDirection.UP)
				return true;
			else
				return false;
		}

		public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
			double d0 = 0.0625d;

			for (int l = 0; l < 6; ++l) {
				double d1 = (double) ((float) x + rand.nextFloat());
				double d2 = (double) ((float) y + rand.nextFloat());
				double d3 = (double) ((float) z + rand.nextFloat());

				if (l == 0 && !world.getBlock(x, y + 1, z).isOpaqueCube()) {
					d2 = (double) (y + 1) + d0;
				}

				if (l == 1 && !world.getBlock(x, y - 1, z).isOpaqueCube()) {
					d2 = (double) (y + 0) - d0;
				}

				if (l == 2 && !world.getBlock(x, y, z + 1).isOpaqueCube()) {
					d3 = (double) (z + 1) + d0;
				}

				if (l == 3 && !world.getBlock(x, y, z - 1).isOpaqueCube()) {
					d3 = (double) (z + 0) - d0;
				}

				if (l == 4 && !world.getBlock(x + 1, y, z).isOpaqueCube()) {
					d1 = (double) (x + 1) + d0;
				}

				if (l == 5 && !world.getBlock(x - 1, y, z).isOpaqueCube()) {
					d1 = (double) (x + 0) - d0;
				}

				if (d1 < (double) x || d1 > (double) (x + 1) || d2 < 0.0D || d2 > (double) (y + 1) || d3 < (double) z || d3 > (double) (z + 1)) {
					mod_lu.proxy.spawnParticle(world, x, y, z, "blazeRodFx");
				}
			}
		}
	}

	public static class NetherStarBlock extends Block {
		public NetherStarBlock(Material mat) {
			super(mat);
		}

		public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
			double d0 = 0.0625d;

			for (int l = 0; l < 6; ++l) {
				double d1 = (double) ((float) x + rand.nextFloat());
				double d2 = (double) ((float) y + rand.nextFloat());
				double d3 = (double) ((float) z + rand.nextFloat());

				if (l == 0 && !world.getBlock(x, y + 1, z).isOpaqueCube()) {
					d2 = (double) (y + 1) + d0;
				}

				if (l == 1 && !world.getBlock(x, y - 1, z).isOpaqueCube()) {
					d2 = (double) (y + 0) - d0;
				}

				if (l == 2 && !world.getBlock(x, y, z + 1).isOpaqueCube()) {
					d3 = (double) (z + 1) + d0;
				}

				if (l == 3 && !world.getBlock(x, y, z - 1).isOpaqueCube()) {
					d3 = (double) (z + 0) - d0;
				}

				if (l == 4 && !world.getBlock(x + 1, y, z).isOpaqueCube()) {
					d1 = (double) (x + 1) + d0;
				}

				if (l == 5 && !world.getBlock(x - 1, y, z).isOpaqueCube()) {
					d1 = (double) (x + 0) - d0;
				}

				if (d1 < (double) x || d1 > (double) (x + 1) || d2 < 0.0D || d2 > (double) (y + 1) || d3 < (double) z || d3 > (double) (z + 1)) {
					mod_lu.proxy.spawnParticle(world, x, y, z, "netherStarFx");
				}
			}
		}
	}

	public static class BoundsBlock extends Block {
		float f;

		public BoundsBlock(Material mat, float maxY) {
			super(mat);
			this.f = maxY;
			float f1 = 1f - maxY;

			this.setBlockBounds(0f, 0f, 0f, 1f, f1, 1f);
		}

		public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
			return AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) z, (double) (x + 1), (double) ((float) (y + 1) - f), (double) (z + 1));
		}

		public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
			return AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) z, (double) (x + 1), (double) ((float) (y + 1) - f), (double) (z + 1));
		}

		public boolean renderAsNormalBlock() {
			return false;
		}

		public boolean isOpaqueCube() {
			return false;
		}
	}

	public static class SlimeBlock extends Block {
		public SlimeBlock(Material mat) {
			super(mat);
			// this.slipperiness = 0.8f;
		}

		public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity e) {
			e.motionY *= -1.2d;
		}

		public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
			return AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) z, (double) (x + 1), (double) ((float) (y + 0.625d)), (double) (z + 1));
		}
	}

	public static class EnderPerlBlock extends UsableBlock {
		public EnderPerlBlock(Material mat) {
			super(mat);
		}

		public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
			Random rand = new Random();
			super.onBlockActivated(world, x, y, z, player, meta, hitX, hitY, hitZ);

			int dx = (int) (player.posX + -rand.nextInt(16));
			int dy = (int) (player.posY + -rand.nextInt(16));
			int dz = (int) (player.posZ + -rand.nextInt(16));
			boolean isSafe = checkNewPos(world, dx, dy, dz);
			while (!isSafe) {
				dy++;
				isSafe = checkNewPos(world, dx, dy, dz);
			}

			player.setPosition(dx, dy, dz);
			return true;
		}

		public boolean doesBlockExist(World world, int x, int y, int z) {
			if (world.getBlock(x, y, z) == Blocks.air)
				return false;
			return true;
		}

		public boolean checkNewPos(World world, int x, int y, int z) {
			if ((!doesBlockExist(world, x, y, z)) && (!doesBlockExist(world, x, y + 1, z)))
				return true;
			return false;
		}
	}

	public static class CompactDirt extends BlockDirt {
		public CompactDirt() {
			super();
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(this, 1, 0));
		}
	}

	public static class CompactNetherrack extends BlockNetherrack {
		public CompactNetherrack() {
			super();
		}

		public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side) {
			if (side == ForgeDirection.UP)
				return true;
			else
				return false;
		}
	}
}
