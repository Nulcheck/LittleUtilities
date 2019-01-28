package mce.lu.common.container;

import mce.lu.common.block.ModBlocks;
import mce.lu.common.container.parts.SlotPigmentMixerCrafting;
import mce.lu.common.core.recipes.PigmentMixerRecipeManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ContainerPigmentMixer extends Container {
	public InventoryCrafting craftMatrix = new InventoryCrafting(this, 2, 2);
	public InventoryCraftResult craftResult = new InventoryCraftResult();
	private final World world;
	private final BlockPos pos;
	private final EntityPlayer player;

	public ContainerPigmentMixer(InventoryPlayer inv, World world, BlockPos pos) {
		this.world = world;
		this.pos = pos;
		this.player = inv.player;

		// Output slot
		this.addSlotToContainer(
				new SlotPigmentMixerCrafting(inv.player, this.craftMatrix, this.craftResult, 0, 124, 35));

		// 2 x 2 crafting slots
		for (int i = 0; i < 2; ++i) {
			for (int j = 0; j < 2; ++j) {
				this.addSlotToContainer(new Slot(this.craftMatrix, j + i * 2, 47 + j * 18, 26 + i * 18));
			}
		}

		// Player Inventory
		for (int k = 0; k < 3; ++k) {
			for (int i1 = 0; i1 < 9; ++i1) {
				this.addSlotToContainer(new Slot(inv, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
			}
		}

		// Player Hotbar
		for (int l = 0; l < 9; ++l) {
			this.addSlotToContainer(new Slot(inv, l, 8 + l * 18, 142));
		}
	}

	// Callback for when crafting matrix is changed.
	@Override
	public void onCraftMatrixChanged(IInventory inv) {
		this.slotChangedPigmentMixerGrid(this.world, this.player, this.craftMatrix, this.craftResult);
	}

	// Custom listener so I can have custom recipe system separate from crafting
	// table's system and recipes.
	private void slotChangedPigmentMixerGrid(World world, EntityPlayer player, InventoryCrafting craftMatrix,
			InventoryCraftResult craftResult) {
			// EntityPlayerMP mp = (EntityPlayerMP) player;
			ItemStack stack = ItemStack.EMPTY;
			IRecipe recipe = PigmentMixerRecipeManager.findMatchingRecipe(craftMatrix, world);

			if (recipe != null && (recipe.isDynamic() || !world.getGameRules().getBoolean("doLimitedCrafting"))) {
				craftResult.setRecipeUsed(recipe);
				stack = recipe.getCraftingResult(craftMatrix);
			}

			craftResult.setInventorySlotContents(0, stack);
			// mp.connection.sendPacket(new SPacketSetSlot(this.windowId, 0, stack));
	}

	// Determines if player can use container
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		if (this.world.getBlockState(this.pos).getBlock() != ModBlocks.PIGMENT_MIXER)
			return false;
		else
			return player.getDistanceSq((double) this.pos.getX() + 0.5d, (double) this.pos.getY() + 0.5d,
					(double) this.pos.getZ() + 0.5d) <= 64d;
	}

	// Handles shift clicking
	public ItemStack transferStackInSlot(EntityPlayer player, int index) {
		ItemStack stack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack()) {
			ItemStack stack1 = slot.getStack();
			stack = stack1.copy();

			if (index == 0) {
				stack1.getItem().onCreated(stack1, this.world, player);

				if (!this.mergeItemStack(stack1, 5, 41, true))
					return ItemStack.EMPTY;

				slot.onSlotChange(stack1, stack);
			} else if (index >= 5 && index < 32) {
				if (!this.mergeItemStack(stack1, 32, 41, false))
					return ItemStack.EMPTY;
			} else if (index >= 32 && index < 41) {
				if (!this.mergeItemStack(stack1, 5, 32, false))
					return ItemStack.EMPTY;
			} else if (!this.mergeItemStack(stack1, 5, 41, false))
				return ItemStack.EMPTY;

			if (stack1.isEmpty())
				slot.putStack(ItemStack.EMPTY);
			else
				slot.onSlotChanged();

			if (stack1.getCount() == stack.getCount())
				return ItemStack.EMPTY;

			slot.onTake(player, stack1);

			/*
			 * if (index == 0) player.dropItem(stack2, false);
			 */
		}

		return stack;
	}

	@Override
	public boolean canMergeSlot(ItemStack stack, Slot slot) {
		return slot.inventory != this.craftResult && super.canMergeSlot(stack, slot);
	}
}
