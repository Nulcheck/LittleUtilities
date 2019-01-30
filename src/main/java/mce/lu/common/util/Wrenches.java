package mce.lu.common.util;

import net.minecraft.item.ItemStack;

public class Wrenches {
	private static Class<?> wrenchClass;
	public static final String[] WRENCHES = { "mce.lu.common.item.Wrench", "buildcraft.api.tools.IToolWrench",
			"cofh.api.item.IToolHammer", "ic2.core.item.tool.ItemToolWrench" };

	public Wrenches() {
		Class<?> wrench = null;

		try {
			for (int i = 0; i < WRENCHES.length;) {
				wrench = Class.forName(WRENCHES[i]);
			}
		} catch (ClassNotFoundException err) {
		}

		wrenchClass = wrench;
	}

	public static ItemStack get(ItemStack stack) {
		return wrenchClass != null && wrenchClass.isInstance(stack.getItem()) ? stack : null;
	}
}
