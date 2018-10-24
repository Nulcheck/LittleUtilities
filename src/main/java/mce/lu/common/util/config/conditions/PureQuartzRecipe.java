package mce.lu.common.util.config.conditions;

import java.util.function.BooleanSupplier;
import java.util.logging.Level;

import com.google.gson.JsonObject;

import mce.lu.common.LittleUtilities;
import mce.lu.common.util.config.LUConfigManager;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;
import net.minecraftforge.oredict.OreDictionary;

public class PureQuartzRecipe implements IConditionFactory {
	public BooleanSupplier parse(JsonContext context, JsonObject json) {
		if (OreDictionary.doesOreNameExist("ingotSilicon") || OreDictionary.doesOreNameExist("itemSilicon")) {
			LittleUtilities.logger.log(Level.INFO,
					"Found a mod with silicon in the ore dictionary. Enabling pure quartz.");
			return () -> LUConfigManager.pureQuartzRecipe;
		} else {
			LittleUtilities.logger.log(Level.INFO,
					"Did not find a mod with silicon in the ore dictionary. Disabling pure quartz.");
			return () -> false;
		}
	}
}
