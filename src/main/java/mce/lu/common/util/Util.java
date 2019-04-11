package mce.lu.common.util;

import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class Util {
	public static String[] dyes = { "Black", "Red", "Green", "Brown", "Blue", "Purple", "Cyan", "LightGray", "Gray",
			"Pink", "Lime", "Yellow", "LightBlue", "Magenta", "Orange", "White" };

	public static EnumDyeColor[] enumDyes = { EnumDyeColor.BLACK, EnumDyeColor.RED, EnumDyeColor.GREEN,
			EnumDyeColor.BROWN, EnumDyeColor.BLUE, EnumDyeColor.PURPLE, EnumDyeColor.CYAN, EnumDyeColor.SILVER,
			EnumDyeColor.GRAY, EnumDyeColor.PINK, EnumDyeColor.LIME, EnumDyeColor.YELLOW, EnumDyeColor.LIGHT_BLUE,
			EnumDyeColor.MAGENTA, EnumDyeColor.ORANGE, EnumDyeColor.WHITE };

	public static boolean itemStacksEqualWithWildcard(ItemStack stack1, ItemStack stack2) {
		return !(stack1.isEmpty() || stack2.isEmpty()) && stack1.getItem() == stack2.getItem()
				&& (stack1.getItemDamage() == stack2.getItemDamage()
						|| stack1.getItemDamage() == OreDictionary.WILDCARD_VALUE
						|| stack2.getItemDamage() == OreDictionary.WILDCARD_VALUE);
	}

	// Might be useful someday
	/*
	 * public static boolean doesMethodExist(Class<?> clazz, String methodName)
	 * { boolean result = false; for (Method method ))
	 * clazz.getDeclaredMethods()) { if (method.getName().equals(methodName)) {
	 * result = true; break; } } return result; }
	 */

	/**
	 * Takes any item with "dye*Color*" and returns the EnumDyeColor. Used for
	 * dying entities based on ore dictionary.
	 * 
	 * Looks through ore dictionary for "dye*Color*", compares it with the dyes array
	 */
	public static class EnumDyeColorHelper {
		public static EnumDyeColor byOreDictDyeName(ItemStack stackIn) {
			// Loop 0 to 15. 16 dye colors
			for (int i = 0; i < 16; i++) {
				String stringDye = "dye" + dyes[i];
				String stringOreDyes = OreDictionary.getOreName(OreDictionary.getOreID(stringDye));

				// Loop through dictionary for stacks with tag "dye<Color>"
				for (ItemStack stack : OreDictionary.getOres(stringDye)) {
					if (stackIn.getItem() == stack.getItem()) {
						// If dictionary string tag is equal to "dye<Color>"
						// Return the correct EnumDyeColor
						if (stringOreDyes.equals(stringDye))
							return EnumDyeColor.byDyeDamage(i);
					}
				}
			}
			return null;
		}
	}
}
