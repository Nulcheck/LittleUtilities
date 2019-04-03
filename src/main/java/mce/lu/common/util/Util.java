package mce.lu.common.util;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class Util {
	public static boolean itemStacksEqualWithWildcard(ItemStack stack1, ItemStack stack2) {
		return !(stack1.isEmpty() || stack2.isEmpty()) && stack1.getItem() == stack2.getItem()
				&& (stack1.getItemDamage() == stack2.getItemDamage()
						|| stack1.getItemDamage() == OreDictionary.WILDCARD_VALUE
						|| stack2.getItemDamage() == OreDictionary.WILDCARD_VALUE);
	}

	/*
	 * public static boolean doesMethodExist(Class<?> clazz, String methodName)
	 * { boolean result = false; for (Method method :
	 * clazz.getDeclaredMethods()) { if (method.getName().equals(methodName)) {
	 * result = true; break; } } return result; }
	 */
}
