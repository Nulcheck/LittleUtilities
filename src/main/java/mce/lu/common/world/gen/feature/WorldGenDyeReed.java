package mce.lu.common.world.gen.feature;

import java.util.Random;

import mce.lu.common.block.ModBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDyeReed extends WorldGenerator {
	public BlockPos chunkPos;

	public boolean generate(World world, Random rand, BlockPos pos) {
		int l = rand.nextInt(15);
		for (int i = 0; i < 20; ++i) {
			BlockPos blockPos = pos.add(rand.nextInt(4) - rand.nextInt(4), 0, rand.nextInt(4) - rand.nextInt(4));

			if (world.isAirBlock(blockPos)) {
				BlockPos blockpos1 = blockPos.down();

				if (world.getBlockState(blockpos1.west()).getMaterial() == Material.WATER
						|| world.getBlockState(blockpos1.east()).getMaterial() == Material.WATER
						|| world.getBlockState(blockpos1.north()).getMaterial() == Material.WATER
						|| world.getBlockState(blockpos1.south()).getMaterial() == Material.WATER) {
					int j = 2 + rand.nextInt(rand.nextInt(3) + 1);

					for (int k = 0; k < j; ++k) {
						if (l == 0) {
							if (ModBlocks.REEDS_BLACK.canBlockStay(world, blockPos))
								world.setBlockState(blockPos.up(k), ModBlocks.REEDS_BLACK.getDefaultState(), 2);
						}

						if (l == 1) {
							if (ModBlocks.REEDS_RED.canBlockStay(world, blockPos))
								world.setBlockState(blockPos.up(k), ModBlocks.REEDS_RED.getDefaultState(), 2);
						}

						if (l == 2) {
							if (ModBlocks.REEDS_GREEN.canBlockStay(world, blockPos))
								world.setBlockState(blockPos.up(k), ModBlocks.REEDS_GREEN.getDefaultState(), 2);
						}

						if (l == 3) {
							if (ModBlocks.REEDS_BROWN.canBlockStay(world, blockPos))
								world.setBlockState(blockPos.up(k), ModBlocks.REEDS_BROWN.getDefaultState(), 2);
						}

						if (l == 4) {
							if (ModBlocks.REEDS_BLUE.canBlockStay(world, blockPos))
								world.setBlockState(blockPos.up(k), ModBlocks.REEDS_BLUE.getDefaultState(), 2);
						}

						if (l == 5) {
							if (ModBlocks.REEDS_PURPLE.canBlockStay(world, blockPos))
								world.setBlockState(blockPos.up(k), ModBlocks.REEDS_PURPLE.getDefaultState(), 2);
						}

						if (l == 6) {
							if (ModBlocks.REEDS_CYAN.canBlockStay(world, blockPos))
								world.setBlockState(blockPos.up(k), ModBlocks.REEDS_CYAN.getDefaultState(), 2);
						}

						if (l == 7) {
							if (ModBlocks.REEDS_LIGHT_GRAY.canBlockStay(world, blockPos))
								world.setBlockState(blockPos.up(k), ModBlocks.REEDS_LIGHT_GRAY.getDefaultState(), 2);
						}

						if (l == 8) {
							if (ModBlocks.REEDS_GRAY.canBlockStay(world, blockPos))
								world.setBlockState(blockPos.up(k), ModBlocks.REEDS_GRAY.getDefaultState(), 2);
						}

						if (l == 9) {
							if (ModBlocks.REEDS_PINK.canBlockStay(world, blockPos))
								world.setBlockState(blockPos.up(k), ModBlocks.REEDS_PINK.getDefaultState(), 2);
						}

						if (l == 10) {
							if (ModBlocks.REEDS_LIME.canBlockStay(world, blockPos))
								world.setBlockState(blockPos.up(k), ModBlocks.REEDS_LIME.getDefaultState(), 2);
						}

						if (l == 11) {
							if (ModBlocks.REEDS_YELLOW.canBlockStay(world, blockPos))
								world.setBlockState(blockPos.up(k), ModBlocks.REEDS_YELLOW.getDefaultState(), 2);
						}

						if (l == 12) {
							if (ModBlocks.REEDS_LIGHT_BLUE.canBlockStay(world, blockPos))
								world.setBlockState(blockPos.up(k), ModBlocks.REEDS_LIGHT_BLUE.getDefaultState(), 2);
						}

						if (l == 13) {
							if (ModBlocks.REEDS_MAGENTA.canBlockStay(world, blockPos))
								world.setBlockState(blockPos.up(k), ModBlocks.REEDS_MAGENTA.getDefaultState(), 2);
						}

						if (l == 14) {
							if (ModBlocks.REEDS_ORANGE.canBlockStay(world, blockPos))
								world.setBlockState(blockPos.up(k), ModBlocks.REEDS_ORANGE.getDefaultState(), 2);
						}

						if (l == 15) {
							if (ModBlocks.REEDS_WHITE.canBlockStay(world, blockPos))
								world.setBlockState(blockPos.up(k), ModBlocks.REEDS_WHITE.getDefaultState(), 2);
						}
					}
				}
			}
		}

		return true;
	}
}