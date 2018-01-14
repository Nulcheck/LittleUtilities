package lu.com.mce.api.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Optional;
import lu.com.mce.common.mod_lu;

/**
 * This class hides things from the NEI sidebar thing and registers recipe
 * handlers.
 */

@Optional.Interface(iface = "codechicken.nei.api.API", modid = "NotEnoughItems")
public class NEILUConfig implements IConfigureNEI {
	@Optional.Method(modid = "NotEnoughItems")
	public String getName() {
		return "LittleUtilities NEI Plugin";
	}

	@Optional.Method(modid = "NotEnoughItems")
	public String getVersion() {
		return mod_lu.class.getAnnotation(Mod.class).version();
	}

	@Optional.Method(modid = "NotEnoughItems")
	public void loadConfig() {
		// Recipe Lookup
		API.registerRecipeHandler(new CondenserNEIRecipeHandler());
		API.registerUsageHandler(new CondenserNEIRecipeHandler());
	}
}
