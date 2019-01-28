package mce.lu.common.container.parts;

import com.google.common.collect.Lists;

import mce.lu.common.core.recipes.PigmentMixerRecipeManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class SlotPigmentMixerCrafting extends Slot {
	private final InventoryCrafting craftMatrix;
	private final EntityPlayer player;
	private int amountCrafted;

	public SlotPigmentMixerCrafting(EntityPlayer player, InventoryCrafting craftInv, IInventory inv, int slotIndex,
			int xPos, int yPos) {
		super(inv, slotIndex, xPos, yPos);
		this.player = player;
		this.craftMatrix = craftInv;
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return false;
	}

	@Override
	public ItemStack decrStackSize(int amount) {
		if (this.getHasStack())
			this.amountCrafted += Math.min(amount, this.getStack().getCount());
		return super.decrStackSize(amount);
	}

	@Override
	protected void onCrafting(ItemStack stack, int amount) {
		this.amountCrafted += amount;
		this.onCrafting(stack);
	}

	@Override
	protected void onSwapCraft(int amount) {
		this.amountCrafted += amount;
	}

	@Override
	public void onCrafting(ItemStack stack) {
		if (this.amountCrafted > 0) {
			stack.onCrafting(this.player.world, this.player, this.amountCrafted);
			FMLCommonHandler.instance().firePlayerCraftingEvent(this.player, stack, craftMatrix);
		}

		this.amountCrafted = 0;
		InventoryCraftResult craftResult = (InventoryCraftResult) this.inventory;
		IRecipe recipe = craftResult.getRecipeUsed();

		if (recipe != null && !recipe.isDynamic()) {
			this.player.unlockRecipes(Lists.newArrayList(recipe));
			craftResult.setRecipeUsed((IRecipe) null);
		}
	}

	@Override
	public ItemStack onTake(EntityPlayer player, ItemStack stack) {
		this.onCrafting(stack);
		ForgeHooks.setCraftingPlayer(player);
		NonNullList<ItemStack> list = PigmentMixerRecipeManager.getRemainingItems(this.craftMatrix, player.world);
		ForgeHooks.setCraftingPlayer(null);

		for (int i = 0; i < list.size(); ++i) {
			ItemStack stack1 = this.craftMatrix.getStackInSlot(i);
			ItemStack stack2 = list.get(i);

			if (!stack1.isEmpty()) {
				this.craftMatrix.decrStackSize(i, 1);
				stack1 = this.craftMatrix.getStackInSlot(i);
			}

			if (!stack2.isEmpty()) {
				if (stack1.isEmpty())
					this.craftMatrix.setInventorySlotContents(i, stack2);
				else if (ItemStack.areItemsEqual(stack1, stack2) && ItemStack.areItemStackTagsEqual(stack1, stack2)) {
					stack2.grow(stack1.getCount());
					this.craftMatrix.setInventorySlotContents(i, stack2);
				} else if (!this.player.inventory.addItemStackToInventory(stack2))
					this.player.dropItem(stack2, false);
			}
		}
		return stack;
	}
}
