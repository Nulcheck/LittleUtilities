package lu.com.mce.handlers.registers;

import cpw.mods.fml.common.registry.GameRegistry;
import lu.com.mce.entity.tile.TileEntityCondenser;

public class TileEntityRegistry {
	public static void teRegistry() {
		GameRegistry.registerTileEntity(TileEntityCondenser.class, "te_con");
	}
}
