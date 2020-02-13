package mce.lu.common.entity.tile;

import java.util.Arrays;

import javax.annotation.Nullable;

import mce.lu.common.block.utility.BlockDehydrator;
import mce.lu.common.container.ContainerDehydrator;
import mce.lu.common.core.recipes.DehydratorRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBoat;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

public class TileEntityDehydrator extends TileEntityLockable implements ITickable, ISidedInventory {
	private static final int[] SLOT_INPUT = new int[] { 0 };
	private static final int[] SLOT_OUTPUT = new int[] { 1 };
	private static final int[] SLOT_FUEL = new int[] { 2 };
	public FluidTank fluidTank = new FluidTank(16000);
	public NonNullList<ItemStack> slots = NonNullList.<ItemStack>withSize(3, ItemStack.EMPTY);
	private String customName;
	private int speed, cookTime, tileBurnTime, itemBurnTime;
	
	@Override
	public int getSizeInventory() {
		return this.slots.size();
	}

	@Override
	public boolean isEmpty() {
		for(ItemStack stack : this.slots)
			if(!stack.isEmpty())
				return false;
		return true;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return this.slots.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		return ItemStackHelper.getAndSplit(this.slots, index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.getAndRemove(this.slots, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		ItemStack stack2 = this.slots.get(index);
		boolean flag = !stack.isEmpty() && stack.isItemEqual(stack2) && ItemStack.areItemStackTagsEqual(stack, stack2);
		this.slots.set(index, stack);

		if (stack.getCount() > this.getInventoryStackLimit())
			stack.setCount(this.getInventoryStackLimit());

		if (index == 0 && !flag) {
			this.speed = this.getDryingTime();
			this.cookTime = 0;
			this.markDirty();
		}
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
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
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		this.slots = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(tag, this.slots);

		this.tileBurnTime = tag.getInteger("BurnTime");
		this.cookTime = tag.getInteger("CookTime");
		this.speed = tag.getInteger("Speed");
		this.itemBurnTime = getItemBurnTime(this.slots.get(2));

		if (tag.hasKey("CustomName", 8))
			this.customName = tag.getString("CustomName");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setInteger("BurnTime", (short) this.tileBurnTime);
		tag.setInteger("CookTime", (short) this.cookTime);
		tag.setInteger("Speed", (short) this.speed);
		ItemStackHelper.saveAllItems(tag, this.slots);

		if (this.hasCustomName())
			tag.setString("CustomName", this.customName);

		return tag;
	}

	public boolean isBurning() {
		return this.tileBurnTime > 0;
	}

	@SideOnly(Side.CLIENT)
	public static boolean isBurning(IInventory inv) {
		return inv.getField(2) > 0;
	}

	@Override
	public void update() {
		boolean flag = this.isBurning();
		boolean flag1 = false;

		if (this.isBurning())
			--this.tileBurnTime;

		if (!this.world.isRemote) {
			ItemStack fuelStack = this.slots.get(2);

			if (this.isBurning() || !fuelStack.isEmpty() && !((ItemStack) this.slots.get(0)).isEmpty()) {
				if (!this.isBurning() && this.canDry()) {
					this.tileBurnTime = getItemBurnTime(fuelStack);
					this.itemBurnTime = this.tileBurnTime;

					if (this.isBurning()) {
						flag1 = true;

						if (!fuelStack.isEmpty()) {
							Item item = fuelStack.getItem();
							fuelStack.shrink(1);

							if (fuelStack.isEmpty()) {
								ItemStack fuelItemBucket = item.getContainerItem(fuelStack);
								this.slots.set(2, fuelItemBucket);
							}
						}
					}
				}

				if (this.isBurning() && this.canDry()) {
					++this.cookTime;

					if (this.cookTime == this.getDryingTime()) {
						this.cookTime = 0;
						this.speed = this.getDryingTime();
						this.dryItem();
						flag1 = true;
					}
				} else
					this.cookTime = 0;
			} else if (!this.isBurning() && this.cookTime > 0)
				this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.getDryingTime());

			if (flag != this.isBurning()) {
				flag1 = true;
				BlockDehydrator.setState(this.isBurning(), this.world, this.pos);
			}
		}

		if (flag1)
			this.markDirty();
	}

	public void setDryingTime() {
		this.speed = DehydratorRecipes.instance().getTime(Arrays.asList(this.fluidTank.getFluid(), this.slots.get(0)));
	}

	public int getDryingTime() {
		return speed;
	}

	public static int getItemBurnTime(ItemStack stack) {
		if (stack.isEmpty())
			return 0;
		else {
			int burnTime = ForgeEventFactory.getItemBurnTime(stack);
			if (burnTime >= 0)
				return burnTime;
			Item item = stack.getItem();

			if (item == Item.getItemFromBlock(Blocks.WOODEN_SLAB))
				return 150;
			else if (item == Item.getItemFromBlock(Blocks.WOOL))
				return 100;
			else if (item == Item.getItemFromBlock(Blocks.CARPET))
				return 67;
			else if (item == Item.getItemFromBlock(Blocks.LADDER))
				return 300;
			else if (item == Item.getItemFromBlock(Blocks.WOODEN_BUTTON))
				return 100;
			else if (Block.getBlockFromItem(item).getDefaultState().getMaterial() == Material.WOOD)
				return 300;
			else if (item == Item.getItemFromBlock(Blocks.COAL_BLOCK))
				return 16000;
			else if (item instanceof ItemTool && "WOOD".equals(((ItemTool) item).getToolMaterialName()))
				return 200;
			else if (item instanceof ItemSword && "WOOD".equals(((ItemSword) item).getToolMaterialName()))
				return 200;
			else if (item instanceof ItemHoe && "WOOD".equals(((ItemHoe) item).getMaterialName()))
				return 200;
			else if (item == Items.STICK)
				return 100;
			else if (item != Items.BOW && item != Items.FISHING_ROD) {
				if (item == Items.SIGN)
					return 200;
				else if (item == Items.COAL)
					return 1600;
				else if (item == Items.LAVA_BUCKET)
					return 20000;
				else if (item != Item.getItemFromBlock(Blocks.SAPLING) && item != Items.BOWL) {
					if (item == Items.BLAZE_ROD)
						return 2400;
					else if (item instanceof ItemDoor && item != Items.IRON_DOOR)
						return 200;
					else
						return item instanceof ItemBoat ? 400 : 0;
				} else
					return 100;
			} else
				return 300;
		}
	}

	public static boolean isItemFuel(ItemStack stack) {
		return getItemBurnTime(stack) > 0;
	}

	public boolean canDry() {
		ItemStack inputStack = this.slots.get(0);
		FluidTank inputFluidStack = this.fluidTank;
		ItemStack recipeResultStack = DehydratorRecipes.instance()
				.getRecipeResult(Arrays.asList(inputFluidStack.getFluid(), inputStack));
		ItemStack outputStack = this.slots.get(1);

		if (((ItemStack) inputStack).isEmpty() && inputFluidStack.getFluidAmount() <= 0) {
			return false;
		} else {
			if (recipeResultStack.isEmpty())
				return false;
			else {
				// If input slot OR fluid slot is less than recipe calls for, you can't dry
				if (DehydratorRecipes.isItemInRecipe(inputStack))
					if (inputStack
							.getCount() < ((ItemStack) DehydratorRecipes.instance().getInputs(recipeResultStack).get(1))
									.getCount())
						return false;

				if (DehydratorRecipes.isFluidInRecipe(inputFluidStack.getFluid()))
					if (inputFluidStack.getFluidAmount() < ((FluidStack) DehydratorRecipes.instance()
							.getInputs(recipeResultStack).get(0)).amount)
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
						&& outputStack.getCount() + recipeResultStack.getCount() <= outputStack.getMaxStackSize()) {
					setDryingTime();
					return true;
				} else {
					setDryingTime();
					return outputStack.getCount() + recipeResultStack.getCount() <= recipeResultStack.getMaxStackSize();
				}
			}
		}
	}

	public void dryItem() {
		ItemStack inputStack = this.slots.get(0);
		FluidTank inputFluidStack = this.fluidTank;
		ItemStack recipeResultStack = DehydratorRecipes.instance()
				.getRecipeResult(Arrays.asList(inputFluidStack.getFluid(), inputStack));
		ItemStack outputStack = this.slots.get(1);

		if (this.canDry()) {
			if (outputStack.isEmpty())
				this.slots.set(1, recipeResultStack).copy();
			else if (outputStack.getItem() == recipeResultStack.getItem())
				outputStack.grow(recipeResultStack.getCount());

			if (DehydratorRecipes.isItemInRecipe(inputStack))
				inputStack.shrink(
						((ItemStack) DehydratorRecipes.instance().getInputs(recipeResultStack).get(1)).getCount());

			if (DehydratorRecipes.isFluidInRecipe(inputFluidStack.getFluid()))
				inputFluidStack.drain(
						((FluidStack) DehydratorRecipes.instance().getInputs(recipeResultStack).get(0)).amount, true);

			if (inputStack.getCount() <= 0)
				inputStack.isEmpty();
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
	public int getField(int id) {
		switch (id) {
		case 0:
			return this.cookTime;
		case 1:
			return this.speed;
		case 2:
			return this.tileBurnTime;
		case 3:
			return this.itemBurnTime;
		default:
			return 0;
		}
	}

	@Override
	public void setField(int id, int value) {
		switch (id) {
		case 0:
			this.cookTime = value;
			break;
		case 1:
			this.speed = value;
			break;
		case 2:
			this.tileBurnTime = value;
			break;
		case 3:
			this.itemBurnTime = value;
		}
	}

	@Override
	public int getFieldCount() {
		return 4;
	}

	@Override
	public void clear() {
		this.slots.clear();
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		if (index == 1)
			return false;
		else if (index != 1)
			return true;
		else {
			ItemStack stack2 = this.slots.get(2);
			return isItemFuel(stack) || SlotFurnaceFuel.isBucket(stack) && stack2.getItem() != Items.BUCKET;
		}
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		if (side == EnumFacing.DOWN)
			return SLOT_OUTPUT;
		else
			return side == EnumFacing.UP ? SLOT_INPUT : SLOT_OUTPUT;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		return this.isItemValidForSlot(index, itemStackIn);
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		if (direction == EnumFacing.DOWN && index == 2) {
			Item item = stack.getItem();
			if (item != Items.WATER_BUCKET && item != Items.BUCKET)
				return false;
		}
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

	@SuppressWarnings("unchecked")
	@Override
	@Nullable
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

	public FluidTank getTank() {
		return fluidTank;
	}

	public FluidStack getTankFluid() {
		return fluidTank.getFluid();
	}

	public int getScaledProgress(int scale) {
		int burn = getField(3);
		int tileBurn = getField(2);
		return burn != 0 && tileBurn != 0 ? burn * scale / tileBurn : 0;
	}

	public int getScaledSpeed(int scale) {
		int time = getField(0);
		int speed = getField(1);
		return speed != 0 && time != 0 ? time * scale / speed : 0;
	}
}
