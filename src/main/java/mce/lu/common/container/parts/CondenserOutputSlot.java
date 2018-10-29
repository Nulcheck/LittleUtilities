package mce.lu.common.container.parts;

import mce.lu.common.core.recipes.CondenserRecipes;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
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

		if (!this.thePlayer.world.isRemote) {
			int i = this.removeCount;
			float f = CondenserRecipes.condensing().expHandling(stack);

			if (f == 0.0F) {
				i = 0;
			} else if (f < 1.0F) {
				int j = MathHelper.floor((float) i * f);

				if (j < MathHelper.ceil((float) i * f) && (float) Math.random() < (float) i * f - (float) j) {
					++j;
				}

				i = j;
			}

			while (i > 0) {
				int k = EntityXPOrb.getXPSplit(i);
				i -= k;
				this.thePlayer.world.spawnEntity(new EntityXPOrb(this.thePlayer.world, this.thePlayer.posX,
						this.thePlayer.posY + 0.5D, this.thePlayer.posZ + 0.5D, k));
			}
		}

		this.removeCount = 0;

		FMLCommonHandler.instance().firePlayerCraftingEvent(thePlayer, stack, thePlayer.inventory);

		// Custom Achievements/Advancements below
	}
}