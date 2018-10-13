package lu.com.mce.util.config;

import java.util.logging.Level;

import lu.com.mce.main.mod_lu;
import lu.com.mce.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	private static final String CATEGORY_VANILLA_RECIPES = "Vanilla Recipes";
	
	public static boolean nameTagRecipe = true;
	
	public static void readConfig(){
		Configuration config = CommonProxy.config;
		try{
			config.load();
			initConfig(config);
		} catch (Exception ex){
			mod_lu.logger.log(Level.SEVERE, "An error has occurred! Error ID: LU100", ex);
		} finally {
			if(config.hasChanged())
				config.save();
		}
	}
	
	private static void initConfig(Configuration config){
		config.addCustomCategoryComment(CATEGORY_VANILLA_RECIPES, "Should you be able to craft these things. These are recipes for vanilla stuff that the mod adds.");
		nameTagRecipe = config.getBoolean("Name Tag", CATEGORY_VANILLA_RECIPES, nameTagRecipe, "Craft Name Tags?");
	}
}