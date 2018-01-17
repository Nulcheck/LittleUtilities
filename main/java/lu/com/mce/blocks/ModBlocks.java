package lu.com.mce.blocks;

import java.util.List;
import java.util.Random;

import lu.com.mce.common.mod_lu;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

				if (d1 < (double) x || d1 > (double) (x + 1) || d2 < 0.0D || d2 > (double) (y + 1) || d3 < (double) z
						|| d3 > (double) (z + 1)) {
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

				if (d1 < (double) x || d1 > (double) (x + 1) || d2 < 0.0D || d2 > (double) (y + 1) || d3 < (double) z
						|| d3 > (double) (z + 1)) {
					mod_lu.proxy.spawnParticle(world, x, y, z, "blazeRodFx");
				}
			}
		}
	}
}
