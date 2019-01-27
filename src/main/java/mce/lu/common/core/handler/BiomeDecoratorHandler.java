package mce.lu.common.core.handler;

import java.util.Random;

import mce.lu.common.util.config.LUConfigManager;
import mce.lu.common.world.gen.feature.WorldGenDyeReed;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BiomeDecoratorHandler extends BiomeDecorator {
	protected WorldGenDyeReed dyeReedGen;

	public BiomeDecoratorHandler() {
		super();
	}

	@Override
	public void decorate(World world, Random rand, Biome biome, BlockPos pos) {
		if (decorating) {
			throw new RuntimeException("LittleUtilities already decorating!");
		} else {
			chunkPos = pos;
			genDecorations(biome, world, rand);
			decorating = false;
		}
	}

	@Override
	protected void genDecorations(Biome biome, World world, Random rand) {
		// MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(world, rand,
		// chunkPos));

		generateDyeReeds(world, biome, rand, chunkPos);

		// MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(world,
		// rand, chunkPos));
	}

	@SuppressWarnings("deprecation")
	public void generateDyeReeds(World world, Biome biome, Random rand, BlockPos chunkPos) {
		if (TerrainGen.decorate(world, rand, chunkPos, DecorateBiomeEvent.Decorate.EventType.REED)) {
			for (int reedGen = 0; reedGen < LUConfigManager.modConfig.features.dyeReedsPerChunk; ++reedGen) {
				int xCoord = rand.nextInt(16) + 8;
				int zCoord = rand.nextInt(16) + 8;
				int yRange = world.getHeight(chunkPos.add(xCoord, 0, zCoord)).getY() + 32;

				dyeReedGen = new WorldGenDyeReed();

				if (yRange > 0) {
					int yCoord = rand.nextInt(yRange);
					BlockPos reedPos = chunkPos.add(xCoord, yCoord, zCoord);

					if (LUConfigManager.modConfig.features.generateDyeReeds)
						dyeReedGen.generate(world, rand, reedPos);
				}
			}
		}
	}
}
