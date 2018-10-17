package mce.lu.common.util.config.conditions;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import mce.lu.common.util.config.LUConfigManager;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class PureQuartzRecipe implements IConditionFactory {
	public BooleanSupplier parse(JsonContext context, JsonObject json) {
		return () -> LUConfigManager.pureQuartzRecipe;
	}
}
