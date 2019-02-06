package mce.lu.common.container.parts;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class CondenserOutputSlot extends Slot {
	private EntityPlayer thePlayer;
	private int removeCount;

	public CondenserOutputSlot(EntityPlayer player, IInventory inv, int index, int posX, int posY) {
		super(inv, index, posX, posY);
		this.thePlayer = player;
	}

	// Cannot place anything into the output slot yourself.
	@Override
	public boolean isItemValid(ItemStack stack) {
		return false;
	}

	@Override
	public ItemStack decrStackSize(int amount) {
		if (this.getHasStack()) {
			this.removeCount += Math.min(amount, this.getStack().getCount());
		}

		return super.decrStackSize(amount);
	}

	@Override
	public ItemStack onTake(EntityPlayer player, ItemStack stack) {
		this.onCrafting(stack);
		super.onTake(player, stack);
		return stack;
	}

	@Override
	protected void onCrafting(ItemStack stack, int amount) {
		this.removeCount += amount;
		this.onCrafting(stack);
	}

	@Override
	protected void onCrafting(ItemStack stack) {
		stack.onCrafting(this.thePlayer.world, this.thePlayer, this.removeCount);

		this.removeCount = 0;
		FMLCommonHandler.instance().firePlayerCraftingEvent(thePlayer, stack, thePlayer.inventory);
	}
}