package lu.com.mce.api;

import java.util.concurrent.atomic.AtomicBoolean;

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
	 * @return
	 */
	public static boolean addCondenserRecipe(ItemStack in, ItemStack out, float exp) {
		try {
			itemIn = in;
			itemOut = out;
			expOut = exp;

			Object items = LUClassAccess.condenserRecipes.getConstructor(new Class[] { ItemStack.class }).newInstance(new Object[] { in, out, exp });
			Object recipe = LUClassAccess.condenserRecipes.getMethod("addRecipe", new Class[] { LUClassAccess.condenserRecipes }).invoke(null, new Object[] { items });
			return true;
		} catch (Exception e) {
			System.out.println("");
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * No XP given from recipe if this is used!
	 * 
	 * @param in
	 * @param out
	 * @return
	 */
	public static boolean addCondenserRecipe(ItemStack in, ItemStack out) {
		try {
			itemIn = in;
			itemOut = out;

			Object items = LUClassAccess.condenserRecipes.getConstructor(new Class[] { ItemStack.class }).newInstance(new Object[] { in, out });
			Object recipe = LUClassAccess.condenserRecipes.getMethod("addRecipe", new Class[] { LUClassAccess.condenserRecipes }).invoke(null, new Object[] { items });
			return true;
		} catch (Exception e) {
			System.out.println("");
			e.printStackTrace();
		}

		return false;
	}

	public static class LUClassAccess {
		static {
			AtomicBoolean isInstalled = new AtomicBoolean(true);

			condenserRecipes = RecipeAPI.getClass("lu.com.mce.handlers.recipes.CondenserRecipes", isInstalled);
		}

		static final Class condenserRecipes;
	}

	private static Class getClass(String name, AtomicBoolean isInstalled) {
		try {
			return Class.forName(name);
		} catch (ClassNotFoundException e) {
			isInstalled.set(false);
			return null;
		}
	}
}
