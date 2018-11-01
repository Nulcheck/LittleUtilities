package mce.lu.common.container.parts;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotValid extends Slot {
	ISlotValidator validator;

	public SlotValid(ISlotValidator vali, IInventory inv, int index, int x, int y) {
		super(inv, index, x, y);
		this.validator = vali;
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return validator.isItemValid(stack);
	}
}
