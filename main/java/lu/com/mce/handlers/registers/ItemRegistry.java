package lu.com.mce.handlers.registers;

import cpw.mods.fml.common.registry.GameRegistry;
import lu.com.mce.common.mod_lu;

public class ItemRegistry {
	public static void registerItems() {
		GameRegistry.registerItem(mod_lu.sponge, "sponge");
	}
}
