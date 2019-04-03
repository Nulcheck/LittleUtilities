package mce.lu.api;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

import mce.lu.common.util.Util;
import net.minecraft.item.ItemStack;

public class LittleUtilitiesHandlers {
	private static final Map<ItemStack, IReservoirHandler> reservoirHandlers = Maps.newHashMap();

	public static void addAquaReservoirHandler(ItemStack stack, IReservoirHandler handler) {
		reservoirHandlers.put(stack, handler);
	}

	public static ItemStack getReservoirOutput(ItemStack stack) {
		if (stack.isEmpty())
			return ItemStack.EMPTY;

		for (Entry<ItemStack, IReservoirHandler> entry : reservoirHandlers.entrySet()) {
			if (Util.itemStacksEqualWithWildcard(entry.getKey(), stack))
				return entry.getValue().getReservoirOutput(stack);
		}
		return ItemStack.EMPTY;
	}
}
