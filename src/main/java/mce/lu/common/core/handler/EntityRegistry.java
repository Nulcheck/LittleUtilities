package mce.lu.common.core.handler;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import mce.lu.common.entity.EntityObsidianBoat;
import mce.lu.common.util.References;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class EntityRegistry {
	public static final Set<EntityEntry> ENTITIES = ImmutableSet.of(EntityEntryBuilder.create()
			.entity(EntityObsidianBoat.class).id(new ResourceLocation(References.MOD_ID, "obsidian_boat"), 0)
			.name("obsidian_boat").tracker(80, 3, true).build());

	@SubscribeEvent
	public static void registerEntities(RegistryEvent.Register<EntityEntry> e) {
		IForgeRegistry<EntityEntry> reg = e.getRegistry();

		for (EntityEntry entry : ENTITIES) {
			reg.register(entry);
		}
	}
}
