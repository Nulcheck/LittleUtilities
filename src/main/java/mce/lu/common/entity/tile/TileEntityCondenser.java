package mce.lu.common.entity.tile;

import mce.lu.common.core.recipes.CondenserRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityCondenser extends TileEntity implements ICapabilityProvider {
	private ItemStackHandler stackHandler;

	public int speed;
	public int time;

	public TileEntityCondenser() {
		this.stackHandler = new ItemStackHandler(2);
	}

	public String getInvName() {
		return "container.condenser";
	}

	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		this.stackHandler.deserializeNBT(tag.getCompoundTag("ItemStackHandler"));
		super.readFromNBT(tag);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tag) {
		tag.setTag("ItemStackHandler", this.stackHandler.serializeNBT());
		return super.writeToNBT(tag);
	}

	public void update() {
		boolean flag1 = false;

		if (canCondense() && !this.world.isRemote) {
			this.time++;

			if (this.time >= this.speed) {
				this.time = 0;
				this.condenseItem();
				flag1 = true;
			}
		} else {
			this.time = 0;
		}

		if (flag1) {
			this.markDirty();
		}
	}

	public boolean canCondense() {
		if (this.stackHandler.getStackInSlot(0).isEmpty()) {
			return false;
		} else {
			ItemStack stack = CondenserRecipes.condensing().getCondensingResult(this.stackHandler.getStackInSlot(0));
			ItemStack stack2 = this.stackHandler.getStackInSlot(1);

			if (stack2.isEmpty())
				return true;
			else if (!stack2.isItemEqual(stack))
				return false;
			else if (stack2.getCount() + stack.getCount() <= this.getInventoryStackLimit()
					&& stack2.getCount() + stack.getCount() <= stack2.getMaxStackSize())
				return true;
			else
				return stack2.getCount() + stack.getCount() <= stack.getMaxStackSize();
		}
	}

	public void condenseItem() {
		if (this.canCondense()) {
			ItemStack stack = this.stackHandler.getStackInSlot(0);
			ItemStack stack2 = CondenserRecipes.instance().getCondensingResult(stack);
			ItemStack stack3 = this.stackHandler.getStackInSlot(1);

			if (stack3.isEmpty())
				this.stackHandler.setStackInSlot(1, stack2.copy());
			else if (stack3.getItem() == stack2.getItem())
				stack3.grow(stack2.getCount());

			stack.shrink(9);
		}
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return (T) this.stackHandler;
		return super.getCapability(capability, facing);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return true;
		return super.hasCapability(capability, facing);
	}
}
