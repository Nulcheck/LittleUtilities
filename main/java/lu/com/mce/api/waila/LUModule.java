package lu.com.mce.api.waila;

import lu.com.mce.blocks.EdibleBlock;
import lu.com.mce.blocks.ModBlocks.BlazeRodBlock;
import lu.com.mce.blocks.UsableBlock;
import mcp.mobius.waila.api.impl.ModuleRegistrar;

public class LUModule {
	// Blocks
	public static Class<?> edibleBlock = EdibleBlock.class;
	public static Class<?> usableBlock = UsableBlock.class;
	public static Class<?> blazeRodBlock = BlazeRodBlock.class;

	public static void register() {
		ModuleRegistrar.instance().registerBodyProvider(new HUDHandlerLU(), edibleBlock);
		ModuleRegistrar.instance().registerBodyProvider(new HUDHandlerLU(), usableBlock);
		ModuleRegistrar.instance().registerTailProvider(new HUDHandlerLU(), blazeRodBlock);
	}
}
