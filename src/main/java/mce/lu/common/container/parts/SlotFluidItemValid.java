package mce.lu.common.container.parts;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class SlotFluidItemValid extends Slot {
	ISlotFluidItemValidator validator;

	public SlotFluidItemValid(ISlotFluidItemValidator validSlot, IInventory inventory, int index, int x, int y) {
		super(inventory, index, x, y);
		this.validator = validSlot;
	}

	/*
	 * @Override public boolean func_75214_a(ItemStack stack) { return
	 * validator.isItemValid(stack); }
	 */
	
	public boolean isItemFluidValid(FluidStack fluid, ItemStack stack) {
		return validator.isItemFluidValid(fluid, stack);
	}
}
