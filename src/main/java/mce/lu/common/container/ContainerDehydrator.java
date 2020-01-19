package mce.lu.common.container;

import java.util.Arrays;

import mce.lu.common.container.parts.DehydratorOutputSlot;
import mce.lu.common.core.recipes.DehydratorRecipes;
import mce.lu.common.entity.tile.TileEntityDehydrator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.xendric.xenlib.common.container.parts.ISlotValidator;
import net.xendric.xenlib.common.container.parts.SlotValid;

public class ContainerDehydrator extends Container implements ISlotValidator {
	private final IInventory iTile;
	public TileEntityDehydrator tile;
	public int lastTime, lastSpeed, lastTileTime, lastItemTime;

	public ContainerDehydrator(InventoryPlayer playerInv, IInventory tileInv) {
		this.iTile = tileInv;

		this.addSlotToContainer(new SlotValid(this, this.iTile, 0, 56, 17)); // Input
		this.addSlotToContainer(new DehydratorOutputSlot(playerInv.player, this.iTile, 1, 116, 35)); // Output
		this.addSlotToContainer(new SlotFurnaceFuel(tileInv, 2, 56, 53)); // Fuel

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
	public boolean isItemValid(ItemStack stack) {
		return DehydratorRecipes.isItemInRecipe(stack);
	}

	@Override
	public void addListener(IContainerListener listener) {
		super.addListener(listener);
		listener.sendAllWindowProperties(this, this.iTile);
	}

	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < this.listeners.size(); ++i) {
			IContainerListener listener = this.listeners.get(i);

			if (this.lastTime != this.iTile.getField(0))
				listener.sendWindowProperty(this, 0, this.iTile.getField(0));
			if (this.lastSpeed != this.iTile.getField(1))
				listener.sendWindowProperty(this, 1, this.iTile.getField(1));
			if (this.lastTileTime != this.iTile.getField(2))
				listener.sendWindowProperty(this, 2, this.iTile.getField(2));
			if (this.lastItemTime != this.iTile.getField(3))
				listener.sendWindowProperty(this, 3, this.iTile.getField(3));
		}

		this.lastTime = this.iTile.getField(0);
		this.lastSpeed = this.iTile.getField(1);
		this.lastTileTime = this.iTile.getField(2);
		this.lastItemTime = this.iTile.getField(3);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void updateProgressBar(int id, int value) {
		this.iTile.setField(id, value);
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.iTile.isUsableByPlayer(player);
	}

	/**
	 * Shift clicking item stack handling
	 */
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index) {
		ItemStack stack1 = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack()) {
			ItemStack stack2 = slot.getStack();
			stack1 = stack2.copy();

			if (index == 2) {
				if (!this.mergeItemStack(stack2, 3, 39, true))
					return ItemStack.EMPTY;

				slot.onSlotChange(stack2, stack1);
			} else if (index != 1 && index != 0) {
				if (!DehydratorRecipes.instance().getRecipeResult(Arrays.asList(null, stack2)).isEmpty()) {
					if (!this.mergeItemStack(stack2, 0, 1, false))
						return ItemStack.EMPTY;

				} else if (TileEntityFurnace.isItemFuel(stack2)) {
					if (!this.mergeItemStack(stack2, 1, 2, false))
						return ItemStack.EMPTY;

				} else if (index >= 3 && index < 30) {
					if (!this.mergeItemStack(stack2, 30, 39, false))
						return ItemStack.EMPTY;

				} else if (index >= 30 && index < 39 && !this.mergeItemStack(stack2, 3, 30, false))
					return ItemStack.EMPTY;

			} else if (!this.mergeItemStack(stack2, 3, 39, false))
				return ItemStack.EMPTY;

			if (stack2.isEmpty())
				slot.putStack(ItemStack.EMPTY);
			else
				slot.onSlotChanged();

			if (stack2.getCount() == stack1.getCount())
				return ItemStack.EMPTY;

			slot.onTake(player, stack2);
		}

		return stack1;
	}
}
