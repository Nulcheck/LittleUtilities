package mce.lu.common.container;

import mce.lu.common.container.parts.CondenserOutputSlot;
import mce.lu.common.core.recipes.CondenserRecipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerCondenser extends Container {
	// private TileEntityCondenser condenser;
	private final IInventory tileCondenser;

	public int lastTime;
	public int lastSpeed;

	public ContainerCondenser(InventoryPlayer playerInv, IInventory tileInv) {
		this.tileCondenser = tileInv;
		/*
		 * IItemHandler handler =
		 * condenserInv.getCapability(CapabilityItemHandler.
		 * ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
		 */

		this.addSlotToContainer(new Slot(this.tileCondenser, 0, 56, 35)); // Input;
		this.addSlotToContainer(new CondenserOutputSlot(playerInv.player, this.tileCondenser, 1, 116, 35)); // Output

		// Player Inventory
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		// Player Hotbar
		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(playerInv, i, 8 + i * 18, 142));
		}
	}

	@Override
	public void addListener(IContainerListener listener) {
		super.addListener(listener);
		listener.sendAllWindowProperties(this, this.tileCondenser);
	}

	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < this.listeners.size(); i++) {
			IContainerListener listener = this.listeners.get(i);

			if (this.lastTime != this.tileCondenser.getField(0))
				listener.sendWindowProperty(this, 0, this.tileCondenser.getField(0));
			if (this.lastSpeed != this.tileCondenser.getField(1))
				listener.sendWindowProperty(this, 1, this.tileCondenser.getField(1));
		}

		this.lastTime = this.tileCondenser.getField(0);
		this.lastSpeed = this.tileCondenser.getField(1);
	}

	@Override
	public void updateProgressBar(int id, int value) {
		this.tileCondenser.setField(id, value);
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.tileCondenser.isUsableByPlayer(player);
	}

	/**
	 * Shift clicking item stack handling
	 */
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index) {
		ItemStack stack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack()) {
			ItemStack stack1 = slot.getStack();
			stack = stack1.copy();

			// Output
			if (index == 1) {
				if (!this.mergeItemStack(stack1, 2, 38, true))
					return ItemStack.EMPTY;
				slot.onSlotChange(stack1, stack);
			}
			// If selected slot is not input(s) and fuel (if there is fuel slot)
			else if (index != 0) {
				if (CondenserRecipes.instance().getCondensingResult(stack1) != null) {
					// 0 is input slot
					if (!this.mergeItemStack(stack1, 0, 0, false))
						return ItemStack.EMPTY;
				}
				// These below are for moving within inventory
				else if (index >= 2 && index < 29) {
					if (!this.mergeItemStack(stack1, 29, 38, false))
						return ItemStack.EMPTY;
				} else if (index >= 29 && index < 40) {
					if (!this.mergeItemStack(stack1, 2, 29, false))
						return ItemStack.EMPTY;
				}
			}
			// From inventory or fuel/output to inventory
			else if (!this.mergeItemStack(stack1, 2, 38, false))
				return ItemStack.EMPTY;

			// Left over
			if (stack1.isEmpty())
				slot.putStack(ItemStack.EMPTY);
			else
				slot.onSlotChanged();

			if (stack1.getCount() == stack.getCount())
				return ItemStack.EMPTY;

			slot.onTake(player, stack1);
		}

		return stack;
	}
}
