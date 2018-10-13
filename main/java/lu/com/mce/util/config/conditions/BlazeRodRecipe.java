package lu.com.mce.util.config.conditions;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import lu.com.mce.util.config.ConfigHandler;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class BlazeRodRecipe implements IConditionFactory {
	public BooleanSupplier parse(JsonContext context, JsonObject json) {
		return () -> ConfigHandler.SubCategory.blazeRodRecipe;
	}
}
