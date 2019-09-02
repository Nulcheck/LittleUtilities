package mce.lu.common.container.parts;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public interface ISlotFluidItemValidator {
	boolean isItemFluidValid(FluidStack fluid, ItemStack stack);
}
