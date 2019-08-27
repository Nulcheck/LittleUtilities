package mce.lu.common.event;

import mce.lu.common.core.handler.BiomeDecoratorHandler;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class DecorateEvent {
	@SubscribeEvent
	public static void decorate(DecorateBiomeEvent e) {
		BiomeDecoratorHandler decor = new BiomeDecoratorHandler();

		if (TerrainGen.decorate(e.getWorld(), e.getRand(), e.getChunkPos(), DecorateBiomeEvent.Decorate.EventType.REED))
			decor.decorate(e.getWorld(), e.getRand(), e.getWorld().getBiome(e.getPos()), e.getPos());
	}
}
