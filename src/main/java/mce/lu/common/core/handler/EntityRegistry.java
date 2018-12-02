package mce.lu.common.core.handler;

import mce.lu.common.entity.EntityObsidianBoat;
import mce.lu.common.util.References;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;

@EventBusSubscriber
public class EntityRegistry {
	public static final EntityEntry OBSIDIAN_BOAT = new EntityEntry(EntityObsidianBoat.class,
			References.MOD_ID + ":obsidian_boat").setRegistryName(References.MOD_ID, "obsidian_boat");;

	@SubscribeEvent
	public static void registerEntities(RegistryEvent.Register<EntityEntry> e) {
		e.getRegistry().register(OBSIDIAN_BOAT);
	}
}
