package lu.com.mce.api;

import lu.com.mce.handlers.recipes.CondenserRecipes;
import net.minecraft.item.ItemStack;

public class RecipeAPI {
	public static ItemStack itemIn;
	public static ItemStack itemOut;
	public static float expOut;

	/**
	 * 
	 * @param in
	 * @param out
	 * @param exp
	 * @return boolean
	 */
	public static void addCondenserRecipe(ItemStack in, ItemStack out, float exp) {
		itemIn = in;
		itemOut = out;
		expOut = exp;

		CondenserRecipes.instance().addRecipe(in, out, exp);
	}

	/**
	 * No XP given from recipe if this method used!
	 * 
	 * @param in
	 * @param out
	 * @return boolean
	 */
	public static void addCondenserRecipe(ItemStack in, ItemStack out) {
		itemIn = in;
		itemOut = out;

		CondenserRecipes.instance().addRecipe(in, out);
	}
}
