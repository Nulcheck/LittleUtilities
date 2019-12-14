package mce.lu.client.core.handler;

import mce.lu.common.block.ModFluids;
import mce.lu.common.util.References;
import net.minecraftforge.fluids.IFluidBlock;
import net.xendric.xenlib.client.core.proxy.ClientProxy;

public class FluidRenderHandler {
	static String modid = References.MOD_ID;

	public static void renderFluids() {
		for (IFluidBlock fluidBlock : ModFluids.FLUID_BLOCKS) {
			ClientProxy.registerFluidModel(References.MOD_ID, fluidBlock);
		}
	}
}
