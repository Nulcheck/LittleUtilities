package mce.lu.common.container;

import mce.lu.common.container.parts.DehydratorOutputSlot;
import mce.lu.common.core.recipes.CondenserRecipes;
import mce.lu.common.core.recipes.DehydratorRecipes;
import mce.lu.common.entity.tile.TileEntityDehydrator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.xendric.xenlib.common.container.parts.ISlotValidator;
import net.xendric.xenlib.common.container.parts.SlotValid;
import net.xendric.xenlib.common.util.DoubleInputHandler;

public class ContainerDehydrator extends Container implements ISlotValidator {
	private final IInventory tileDehydrator;
	private TileEntityDehydrator tile;
	public int lastTime, lastSpeed;

	public ContainerDehydrator(InventoryPlayer playerInv, IInventory tileInv) {
		this.tileDehydrator = tileInv;

		this.addSlotToContainer(new SlotValid(this, this.tileDehydrator, 0, 56, 35)); // Input
		this.addSlotToContainer(new DehydratorOutputSlot(playerInv.player, this.tileDehydrator, 1, 116, 35)); // Output

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
		return tile.canDry();
	}

	@Override
	public boolean isItemValid(DoubleInputHandler inputs) {
		return DehydratorRecipes.isRecipe(inputs);
	}

	@Override
	public boolean isFluidValid(FluidStack stack) {
		return tile.canDry();
	}

	@Override
	public void addListener(IContainerListener listener) {
		super.addListener(listener);
		listener.sendAllWindowProperties(this, this.tileDehydrator);
	}

	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < this.listeners.size(); ++i) {
			IContainerListener listener = this.listeners.get(i);

			if (this.lastTime != this.tileDehydrator.getField(0))
				listener.sendWindowProperty(this, 0, this.tileDehydrator.getField(0));
			if (this.lastSpeed != this.tileDehydrator.getField(1))
				listener.sendWindowProperty(this, 1, this.tileDehydrator.getField(1));
		}

		this.lastTime = this.tileDehydrator.getField(0);
		this.lastSpeed = this.tileDehydrator.getField(1);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void updateProgressBar(int id, int value) {
		this.tileDehydrator.setField(id, value);
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.tileDehydrator.isUsableByPlayer(player);
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
				if (!CondenserRecipes.instance().getRecipeResult(stack1).isEmpty()) {
					// Inventory to input slot
					if (!this.mergeItemStack(stack1, 0, 1, false))
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
