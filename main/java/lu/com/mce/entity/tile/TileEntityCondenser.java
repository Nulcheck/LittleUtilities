package lu.com.mce.entity.tile;

import lu.com.mce.handlers.recipes.CondenserRecipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCondenser extends TileEntity implements ISidedInventory {
	public static final int[] input_slot = new int[] { 0 };
	public static final int[] output_slot = new int[] { 1 };
	private ItemStack[] slots = new ItemStack[2];

	private String isInvNameLocalized;
	private String ln;

	public int speed;
	public int time;

	public int getSizeInv() {
		return this.slots.length;
	}

	public void setGuiDisplayName(String dn) {
		this.ln = dn;
	}

	public boolean isInvNameLocalized() {
		return this.isInvNameLocalized != null && this.ln.length() > 0;
	}

	public String getInvName() {
		return this.isInvNameLocalized() ? this.ln : "container.condenser";
	}

	public int getSizeInventory() {
		return 0;
	}

	public ItemStack getStackInSlot(int i) {
		return this.slots[i];
	}

	public ItemStack decrStackSize(int i, int j) {
		if (this.slots[i] != null) {
			ItemStack stack;

			if (this.slots[i].stackSize <= j) {
				stack = this.slots[i];
				this.slots[i] = null;
				return stack;
			} else {
				stack = this.slots[i].splitStack(j);

				if (this.slots[i].stackSize == 0) {
					this.slots[i] = null;
				}
				return stack;
			}
		}
		return null;
	}

	public ItemStack getStackInSlotOnClosing(int i) {
		if (this.slots[i] != null) {
			ItemStack stack = this.slots[i];
			this.slots[i] = null;
			return stack;
		}
		return null;
	}

	public void setInventorySlotContents(int i, ItemStack stack) {
		this.slots[i] = stack;

		if (stack != null && stack.stackSize > this.getInventoryStackLimit())
			stack.stackSize = this.getInventoryStackLimit();
	}

	public int getInventoryStackLimit() {
		return 64;
	}

	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		NBTTagList list = new NBTTagList();

		tag.setInteger("Time", this.time);

		for (int i = 0; i < this.slots.length; i++) {
			if (this.slots[i] != null) {
				NBTTagCompound comp = new NBTTagCompound();
				comp.setByte("Slot", (byte) i);
				this.slots[i].writeToNBT(comp);
				list.appendTag(comp);
			}
		}
		tag.setTag("Items", list);

		if (this.isInvNameLocalized())
			tag.setString("CustomName", this.ln);
	}

	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		NBTTagList list = new NBTTagList();
		this.slots = new ItemStack[this.getSizeInv()];

		for (int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound comp = (NBTTagCompound) list.getCompoundTagAt(i);
			byte b = comp.getByte("Slot");

			if (b >= 0 && b < this.slots.length) {
				this.slots[b] = ItemStack.loadItemStackFromNBT(comp);
			}
		}

		this.time = tag.getInteger("Time");

		if (tag.hasKey("CustomName"))
			this.ln = tag.getString("CustomName");
	}

	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false
				: player.getDistanceSq((double) this.xCoord + 0.5d, (double) this.yCoord + 0.5d,
						(double) this.zCoord + 0.5d) <= 64d;
	}

	public void openChest() {
	}

	public void closeChest() {
	}

	public void updateEntity() {
		boolean flag1 = false;

		if (canCondense() && checkSlot() && !this.worldObj.isRemote) {
			this.time++;

			if (this.time >= this.speed) {
				this.time = 0;
				this.condenseItem();
				flag1 = true;
			}
		} else {
			this.time = 0;
		}

		if (flag1)
			this.onInventoryChanged();
	}

	public boolean checkSlot() {
		ItemStack stack = CondenserRecipes.condensing().getInput(this.slots[0]);
		if (this.slots[0] == stack)
			return true;
		else
			return false;
	}

	public boolean canCondense() {
		if (this.slots[0] == null) {
			return false;
		} else {
			ItemStack stack = CondenserRecipes.condensing().getCondensingResult(this.slots[0]);

			if (this.slots[0] == null)
				return false;

			if (this.slots[0].getItem() instanceof ItemBlock && this.slots[0].stackSize >= 1)
				return true;
			
			if (this.slots[0].getItem() instanceof Item && this.slots[0].stackSize < 9)
				return false;

			if (this.slots[1] == null)
				return true;

			if (!this.slots[1].isItemEqual(stack))
				return false;

			int result = this.slots[1].stackSize + stack.stackSize;
			return (result <= getInventoryStackLimit() && result <= stack.getMaxStackSize());
		}
	}

	public void condenseItem() {
		ItemStack stack = CondenserRecipes.condensing().getCondensingResult(this.slots[0]);

		if (this.slots[1] == null)
			this.slots[1] = stack.copy();

		else if (this.slots[1].isItemEqual(stack))
			this.slots[1].stackSize += stack.stackSize;

		if (this.slots[0].getItem() instanceof ItemBlock && this.slots[0].stackSize >= 1)
			--this.slots[0].stackSize;

		if (this.slots[0].getItem() instanceof Item && this.slots[0].stackSize >= 9)
			this.slots[0].stackSize -= 9;

		if (this.slots[0].stackSize <= 0)
			this.slots[0] = null;
	}

	public void onInventoryChanged() {
	}

	public boolean isItemValidForSlot(int i, ItemStack stack) {
		return i == 1 ? false : true;
	}

	public int[] getAccessibleSlotsFromSide(int side) {
		return side == 0 ? input_slot : side == 1 ? output_slot : null;
	}

	public boolean canInsertItem(int i, ItemStack stack, int j) {
		return this.isItemValidForSlot(i, stack);
	}

	public boolean canExtractItem(int i, ItemStack stack, int j) {
		return j != 0 || i != 1;
	}

	public String getInventoryName() {
		return null;
	}

	public boolean hasCustomInventoryName() {
		return false;
	}

	public void openInventory() {
	}

	public void closeInventory() {
	}
}
