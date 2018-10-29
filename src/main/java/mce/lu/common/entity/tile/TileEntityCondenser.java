package mce.lu.common.entity.tile;

import javax.annotation.Nullable;

import mce.lu.common.container.ContainerCondenser;
import mce.lu.common.core.recipes.CondenserRecipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

public class TileEntityCondenser extends TileEntityLockable implements ITickable, ISidedInventory {
	private static final int[] SLOT_INPUT = new int[] { 0 };
	private static final int[] SLOT_OUTPUT = new int[] { 1 };
	private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(2, ItemStack.EMPTY);
	private String customName;

	private int speed;
	private int time;

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		this.stacks = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(tag, this.stacks);
		this.time = tag.getInteger("Time");
		this.speed = tag.getInteger("Speed");

		if (tag.hasKey("CustomName", 8))
			this.customName = tag.getString("CustomName");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setInteger("Time", (short) this.time);
		tag.setInteger("Speed", (short) this.speed);
		ItemStackHelper.saveAllItems(tag, this.stacks);

		if (this.hasCustomName())
			tag.setString("CustomName", this.customName);

		return tag;
	}

	@Override
	public void update() {
		boolean flag1 = false;

		if (!this.world.isRemote && canCondense()) {
			++this.time;

			if (this.time >= this.speed) {
				this.time = 0;
				this.speed = this.getCondencingTime(this.stacks.get(0));
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

	public int getCondencingTime(ItemStack stack) {
		return 0;
	}

	public boolean canCondense() {
		if (((ItemStack) this.stacks.get(0)).isEmpty()) {
			return false;
		} else {
			ItemStack recipeResultStack = CondenserRecipes.condensing().getCondensingResult(this.stacks.get(0));
			ItemStack outputStack = this.stacks.get(1);

			// You can't condense if input slot is empty. Duh..
			if (recipeResultStack.isEmpty())
				return false;

			// If input slot has less than 9 items, you can't condense
			if (this.stacks.get(0).getCount() < 9)
				return false;

			// If output slot is empty, you can condense
			if (outputStack.isEmpty())
				return true;

			/*
			 * If output item is NOT equal to the same item as the output in the
			 * recipe, you CAN'T condense
			 */
			if (!outputStack.isItemEqual(recipeResultStack))
				return false;

			// If stack size in output is less than 64, you can condense
			if (outputStack.getCount() + recipeResultStack.getCount() <= this.getInventoryStackLimit()
					&& outputStack.getCount() + recipeResultStack.getCount() <= outputStack.getMaxStackSize())
				return true;
			else
				return outputStack.getCount() + recipeResultStack.getCount() <= recipeResultStack.getMaxStackSize();
		}
	}

	public void condenseItem() {
		if (this.canCondense()) {
			ItemStack inputStack = this.stacks.get(0);
			ItemStack recipeResultStack = CondenserRecipes.instance().getCondensingResult(inputStack);
			ItemStack outputStack = this.stacks.get(1);

			if (outputStack.isEmpty())
				this.stacks.set(1, recipeResultStack.copy());
			else if (outputStack.getItem() == recipeResultStack.getItem())
				outputStack.grow(recipeResultStack.getCount());

			inputStack.shrink(9);
			
			if(inputStack.getCount() <= 0)
				inputStack.isEmpty();
		}
	}

	public String getGuiID() {
		return "littleutilities:condenser";
	}

	public Container createContainer(InventoryPlayer playerInv, EntityPlayer player) {
		return new ContainerCondenser(playerInv, this);
	}

	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public String getName() {
		return this.hasCustomName() ? this.customName : "container.condenser";
	}

	@Override
	public boolean hasCustomName() {
		return this.customName != null && !this.customName.isEmpty();
	}

	public void setCustomInventoryName(String name) {
		this.customName = name;
	}

	/**
	 * Return number of slots in inventory.
	 */
	@Override
	public int getSizeInventory() {
		return this.stacks.size();
	}

	@Override
	public boolean isEmpty() {
		for (ItemStack stack : this.stacks) {
			if (!stack.isEmpty())
				return false;
		}
		return true;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return this.stacks.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		return ItemStackHelper.getAndSplit(this.stacks, index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.getAndRemove(this.stacks, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		ItemStack stack2 = this.stacks.get(index);
		boolean flag = !stack.isEmpty() && stack.isItemEqual(stack2) && ItemStack.areItemStackTagsEqual(stack, stack2);
		this.stacks.set(index, stack);

		if (stack.getCount() > this.getInventoryStackLimit())
			stack.setCount(this.getInventoryStackLimit());

		if (index == 0 && !flag) {
			this.speed = this.getCondencingTime(stack);
			this.time = 0;
			this.markDirty();
		}
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		if (this.world.getTileEntity(this.pos) != this)
			return false;
		else
			return player.getDistanceSq((double) this.pos.getX() + 0.5d, (double) this.pos.getY() + 0.5d,
					(double) this.pos.getZ() + 0.5d) <= 64d;
	}

	@Override
	public void openInventory(EntityPlayer player) {
	}

	@Override
	public void closeInventory(EntityPlayer player) {
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return index == 1 ? false : true;
	}

	public int[] getSlotsForFace(EnumFacing side) {
		if (side == EnumFacing.DOWN)
			return SLOT_OUTPUT;
		else
			return side == EnumFacing.UP ? SLOT_INPUT : SLOT_OUTPUT;
	}

	public boolean canInsertItem(int index, ItemStack stack, EnumFacing dir) {
		return this.isItemValidForSlot(index, stack);
	}

	public boolean canExtractItem(int index, ItemStack stack, EnumFacing dir) {
		return true;
	}

	@Override
	public int getField(int id) {
		switch (id) {
		case 0:
			return this.time;
		case 1:
			return this.speed;
		default:
			return 0;
		}
	}

	@Override
	public void setField(int id, int value) {
		switch (id) {
		case 0:
			this.time = value;
			break;
		case 1:
			this.speed = value;
		}
	}

	@Override
	public int getFieldCount() {
		return 2;
	}

	@Override
	public void clear() {
		this.stacks.clear();
	}

	IItemHandler handlerTop = new SidedInvWrapper(this, EnumFacing.UP);
	IItemHandler handlerBottom = new SidedInvWrapper(this, EnumFacing.DOWN);
	IItemHandler handlerSide = new SidedInvWrapper(this, EnumFacing.WEST);

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return true;
		return super.hasCapability(capability, facing);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Nullable
	public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
		if (facing != null && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			if (facing == EnumFacing.DOWN)
				return (T) handlerBottom;
			else if (facing == EnumFacing.UP)
				return (T) handlerTop;
			else
				return (T) handlerSide;
		return super.getCapability(capability, facing);
	}
}
