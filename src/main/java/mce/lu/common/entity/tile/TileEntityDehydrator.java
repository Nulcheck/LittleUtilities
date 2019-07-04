package mce.lu.common.entity.tile;

import javax.annotation.Nullable;

import mce.lu.common.container.ContainerDehydrator;
import mce.lu.common.core.recipes.DehydratorRecipes;
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
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;
import net.xendric.xenlib.common.util.DoubleInputHandler;

public class TileEntityDehydrator extends TileEntityLockable implements ITickable, ISidedInventory {
	private static final int[] SLOT_INPUT = new int[] { 0 };
	private static final int[] SLOT_OUTPUT = new int[] { 1 };
	private FluidTank fluidTank = new FluidTank(16000);
	public NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(2, ItemStack.EMPTY);
	private String customName;

	public ItemStack inputStack = this.stacks.get(0);
	public FluidTank inputFluidStack = this.fluidTank;
	public ItemStack recipeResultStack = DehydratorRecipes.instance()
			.getRecipeResult(new DoubleInputHandler(inputFluidStack.getFluid(), inputStack));
	public ItemStack outputStack = this.stacks.get(1);

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

		if (!this.world.isRemote && this.canDry()) {
			setDryingTime();
			++this.time;

			if (this.time >= this.speed) {
				this.time = 0;

				if (!this.stacks.get(0).isEmpty())
					this.speed = this.getDryingTime(this.stacks.get(0));
				else if (this.fluidTank.getFluidAmount() > 0)
					this.speed = this.getDryingTime(this.fluidTank.getFluid());
				else
					this.speed = 0;

				this.dryStack();
				flag1 = true;
			}
		} else
			this.time = 0;

		if (flag1)
			this.markDirty();
	}

	public void setDryingTime() {
		/*
		 * ItemStack inputStack = this.stacks.get(0); FluidTank inputFluidStack =
		 * this.fluidTank; ItemStack recipeResultStack = DehydratorRecipes.instance()
		 * .getRecipeResult(new DoubleInputHandler(inputFluidStack.getFluid(),
		 * inputStack));
		 */
		this.speed = DehydratorRecipes.getTime();
	}

	public int getDryingTime(ItemStack stack) {
		return this.speed;
	}

	public int getDryingTime(FluidStack stack) {
		return this.speed;
	}

	public boolean canDry() {
		if (((ItemStack) inputStack).isEmpty() && inputFluidStack.getFluidAmount() <= 0
				|| (((ItemStack) inputStack).isEmpty() || inputFluidStack.getFluidAmount() <= 0)) {
			return false;
		} else {
			if (recipeResultStack.isEmpty())
				return false;
			else {
				// If input slot OR fluid slot has less than recipe amount calls for, you can't
				// dry
				if (inputStack.getCount() < DehydratorRecipes.getInputs(recipeResultStack).getItemInput1().getCount())
					return false;

				if (inputFluidStack
						.getFluidAmount() < DehydratorRecipes.getInputs(recipeResultStack).getFluidInput1().amount)
					return false;

				// If output slot is empty, you can dry
				if (outputStack.isEmpty())
					return true;

				/*
				 * If output item is NOT equal to the same item as the output in the recipe
				 * list, you CAN'T dry
				 */
				if (!outputStack.isItemEqual(recipeResultStack))
					return false;

				// If stack size in output is less than 64, you can dry
				if (outputStack.getCount() + recipeResultStack.getCount() <= this.getInventoryStackLimit()
						&& outputStack.getCount() + recipeResultStack.getCount() <= outputStack.getMaxStackSize())
					return true;
				else
					return outputStack.getCount() + recipeResultStack.getCount() <= recipeResultStack.getMaxStackSize();
			}
		}
	}

	public void dryStack() {
		if (this.canDry()) {
			if (outputStack.isEmpty())
				this.stacks.set(1, recipeResultStack).copy();
			else if (outputStack.getItem() == recipeResultStack.getItem())
				outputStack.grow(recipeResultStack.getCount());

			if (DehydratorRecipes.getInputs(recipeResultStack).getItemInput1() != null)
				inputStack.shrink(DehydratorRecipes.getInputs(recipeResultStack).getItemInput1().getCount());

			if (DehydratorRecipes.getInputs(recipeResultStack).getFluidInput1() != null)
				inputFluidStack.drain(DehydratorRecipes.getInputs(recipeResultStack).getFluidInput1().amount, true);

			if (inputStack.getCount() <= 0)
				inputStack.isEmpty();
		}
	}

	@Override
	public int getSizeInventory() {
		return this.stacks.size();
	}

	@Override
	public boolean isEmpty() {
		return false;
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
			this.speed = this.getDryingTime(stack);
			this.time = 0;
			this.markDirty();
		}
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
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

	@Override
	public String getName() {
		return this.hasCustomName() ? this.customName : "container.dehydrator";
	}

	@Override
	public boolean hasCustomName() {
		return this.customName != null && !this.customName.isEmpty();
	}

	public void setCustomInventoryName(String name) {
		this.customName = name;
	}

	@Override
	public Container createContainer(InventoryPlayer playerInv, EntityPlayer playerIn) {
		return new ContainerDehydrator(playerInv, this);
	}

	@Override
	public String getGuiID() {
		return "littleutilities:dehydrator";
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		if (side == EnumFacing.DOWN)
			return SLOT_OUTPUT;
		else
			return SLOT_INPUT;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		return this.isItemValidForSlot(index, itemStackIn);
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		return true;
	}

	IItemHandler handlerTop = new SidedInvWrapper(this, EnumFacing.UP);
	IItemHandler handlerBottom = new SidedInvWrapper(this, EnumFacing.DOWN);
	IItemHandler handlerSide = new SidedInvWrapper(this, EnumFacing.WEST);

	@Override
	public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY
				|| capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY)
			return true;
		return super.hasCapability(capability, facing);
	}

	@Override
	public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
		if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY)
			return (T) fluidTank;
		if (facing != null && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			if (facing == EnumFacing.DOWN)
				return (T) handlerBottom;
			else if (facing == EnumFacing.UP)
				return (T) handlerTop;
			else
				return (T) handlerSide;
		return super.getCapability(capability, facing);
	}

	public int getFluidAmount() {
		return fluidTank.getFluidAmount();
	}

	public int getFluidCapacity() {
		return fluidTank.getCapacity();
	}
}
