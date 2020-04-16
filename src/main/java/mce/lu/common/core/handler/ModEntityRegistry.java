package mce.lu.common.core.handler;

import mce.lu.common.LittleUtilities;
import mce.lu.common.entity.EntityFireproofItem;
import mce.lu.common.util.References;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntityRegistry {
	public static void registerEntities() {
		EntityRegistry.registerModEntity(new ResourceLocation(References.MOD_ID, "fireproofed_item"),
				EntityFireproofItem.class, "fireproofed_item", 1, LittleUtilities.instance, 80, 3, true);
	}
}
