package mce.lu.common.core.handler;

import java.util.Random;

import mce.lu.common.util.config.LUConfigManager;
import mce.lu.common.world.gen.feature.WorldGenDyeReed;
import mce.lu.common.world.gen.feature.WorldGenLavaLily;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BiomeDecoratorHandler extends BiomeDecorator {
	protected WorldGenDyeReed dyeReedGen;
	protected WorldGenLavaLily lavaLilyGen;

	public BiomeDecoratorHandler() {
		super();
	}

	@Override
	public void decorate(World world, Random rand, Biome biome, BlockPos pos) {
		if (decorating) {
			throw new RuntimeException("LittleUtilities already decorating biomes!");
		} else {
			chunkPos = pos;
			genDecorations(biome, world, rand);
			decorating = false;
		}
	}

	@Override
	protected void genDecorations(Biome biome, World world, Random rand) {
		generateDyeReeds(world, biome, rand, new ChunkPos(chunkPos), chunkPos);
	}

	public void generateDyeReeds(World world, Biome biome, Random rand, ChunkPos chunkPos, BlockPos blockPos) {
		if (TerrainGen.decorate(world, rand, chunkPos, DecorateBiomeEvent.Decorate.EventType.REED)) {
			for (int reedGen = 0; reedGen < LUConfigManager.modConfig.features.dyeReedsPerChunk; ++reedGen) {
				int xCoord = rand.nextInt(16) + 8;
				int zCoord = rand.nextInt(16) + 8;
				int yRange = world.getHeight(blockPos.add(xCoord, 0, zCoord)).getY() + 32;

				dyeReedGen = new WorldGenDyeReed();

				if (yRange > 0) {
					int yCoord = rand.nextInt(yRange);
					BlockPos reedPos = blockPos.add(xCoord, yCoord, zCoord);

					if (LUConfigManager.modConfig.features.generateDyeReeds)
						dyeReedGen.generate(world, rand, reedPos);
				}
			}
		}
	}
}
