package mce.lu.api;

import net.minecraft.item.ItemStack;

public interface IReservoirHandler {
	ItemStack getReservoirOutput(ItemStack stack);
}
