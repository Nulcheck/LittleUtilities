package mce.lu.api;

import javax.annotation.Nonnull;

import mce.lu.common.core.recipes.CondenserRecipes;
import net.minecraft.item.ItemStack;

public class LittleUtilitiesAPI {
	/**
	 * Adds a recipe to the condenser.
	 * 
	 * @param stackIn
	 * @param stackOut
	 */
	public static void addCondenserRecipe(@Nonnull ItemStack stackIn, @Nonnull ItemStack stackOut) {
		CondenserRecipes.instance().addRecipe(stackIn, stackOut);
	}
}