package lu.com.mce.registries;

import lu.com.mce.entity.tile.TileEntityCondenser;
import lu.com.mce.util.References;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityRegistry {
	public static void teRegistry() {
		GameRegistry.registerTileEntity(TileEntityCondenser.class, References.MOD_ID + "TileEntityCondenser");
	}
}
