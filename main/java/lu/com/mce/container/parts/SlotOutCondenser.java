package lu.com.mce.container.parts;

import cpw.mods.fml.common.FMLCommonHandler;
import lu.com.mce.handlers.recipes.CondenserRecipes;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

public class SlotOutCondenser extends Slot {
	private EntityPlayer thePlayer;
	private int number;

	public SlotOutCondenser(EntityPlayer player, IInventory inv, int x, int y, int z) {
		super(inv, x, y, z);
		this.thePlayer = player;
	}

	public boolean isItemValid(ItemStack stack) {
		return false;
	}

	public ItemStack decrStackSize(int i) {
		if (this.getHasStack()) {
			this.number += Math.min(i, this.getStack().stackSize);
		}

		return super.decrStackSize(i);
	}

	public void onPickupFromSlot(EntityPlayer player, ItemStack stack) {
		this.onCrafting(stack);
		super.onPickupFromSlot(player, stack);
	}

	protected void onCrafting(ItemStack stack, int i) {
		this.number += i;
		this.onCrafting(stack);
	}

	protected void onCrafting(ItemStack stack) {
		stack.onCrafting(this.thePlayer.worldObj, this.thePlayer, this.number);

		if (!this.thePlayer.worldObj.isRemote) {
			int i = this.number;
			float f = CondenserRecipes.condensing().expHandling(stack);
			int j;

			if (f == 0.0F) {
				i = 0;
			} else if (f < 1.0F) {
				j = MathHelper.floor_float((float) i * f);

				if (j < MathHelper.ceiling_float_int((float) i * f)
						&& (float) Math.random() < (float) i * f - (float) j) {
					++j;
				}

				i = j;
			}

			while (i > 0) {
				j = EntityXPOrb.getXPSplit(i);
				i -= j;
				this.thePlayer.worldObj.spawnEntityInWorld(new EntityXPOrb(this.thePlayer.worldObj, this.thePlayer.posX,
						this.thePlayer.posY + 0.5D, this.thePlayer.posZ + 0.5D, j));
			}
		}

		this.number = 0;

		FMLCommonHandler.instance().firePlayerCraftingEvent(thePlayer, stack, thePlayer.inventory);
	}
}