package mce.lu.common.core.handler;

import mce.lu.common.entity.tile.TileEntityCondenser;
import mce.lu.common.util.References;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityRegistry {
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityCondenser.class, References.MOD_ID + ":condenser");
	}
}
