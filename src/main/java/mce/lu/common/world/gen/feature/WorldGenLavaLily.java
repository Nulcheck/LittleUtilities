package mce.lu.common.world.gen.feature;

import java.util.Random;

import mce.lu.common.block.ModBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenLavaLily extends WorldGenerator implements IWorldGenerator {
	BlockPos pos;

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		if (world.provider.getDimension() == 1)
			generateNether(chunkGenerator, random, chunkX, chunkZ, world,
					world.getChunkFromChunkCoords(chunkX, chunkZ).getPos());
	}

	public void generateNether(IChunkGenerator chunkGenerator, Random random, int chunkX, int chunkZ, World world,
			ChunkPos pos) {
		generateLavaLily(chunkGenerator, world, random, chunkX * 16, chunkZ * 16, pos);
	}

	public void generateLavaLily(IChunkGenerator chunkGenerator, World world, Random rand, int chunkX, int chunkZ,
			ChunkPos blockPos) {
		if (TerrainGen.populate(chunkGenerator, world, rand, chunkX, chunkZ, false,
				PopulateChunkEvent.Populate.EventType.NETHER_LAVA)) {
			for (int lilyGen = 0; lilyGen < 6; ++lilyGen) { // 6 is lily per chunk
				int xCoord = rand.nextInt(16) + 8;
				int zCoord = rand.nextInt(16) + 8;
				int yRange = world.getHeight(blockPos.getBlock(xCoord, 0, zCoord).add(xCoord, 0, zCoord)).getY() * 2;

				// lavaLilyGen = new WorldGenLavaLily();

				if (yRange > 0) {
					int yCoord = rand.nextInt(yRange);
					BlockPos lilyPos;
					BlockPos lilySoilBlock;

					for (lilyPos = blockPos.getBlock(xCoord, yCoord, zCoord).add(xCoord, yCoord, zCoord); lilyPos
							.getY() > 0; lilyPos = lilySoilBlock) {
						lilySoilBlock = lilyPos.down();

						if (!world.isAirBlock(lilySoilBlock)) {
							break;
						}
					}
					generate(world, rand, lilyPos);
				}
			}
		}
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		for (int i = 0; i < 10; ++i) {
			int j = pos.getX() + rand.nextInt(8) - rand.nextInt(8);
			int k = pos.getY() + rand.nextInt(4) - rand.nextInt(4);
			int l = pos.getZ() + rand.nextInt(8) - rand.nextInt(8);

			if (world.isAirBlock(new BlockPos(j, k, l))
					&& ModBlocks.LAVA_LILY.canPlaceBlockAt(world, new BlockPos(j, k, l))) {
				world.setBlockState(new BlockPos(j, k, l), ModBlocks.LAVA_LILY.getDefaultState(), 2);
			}
		}
		return true;
	}
}