package lu.com.mce.blocks;

import java.util.Random;

import lu.com.mce.common.mod_lu;
import lu.com.mce.entity.tile.TileEntityCondenser;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Condenser extends BlockContainer {
	private Random rand = new Random();

	public Condenser(Material mat) {
		super(mat);
	}

	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityCondenser();
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitx,
			float hity, float hitz) {
		player.openGui(mod_lu.instance, mod_lu.condenserGUI, world, x, y, z);
		return true;
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		TileEntityCondenser entity = (TileEntityCondenser) world.getTileEntity(x, y, z);

		if (entity != null) {
			for (int i = 0; i < entity.getSizeInv(); i++) {
				ItemStack stack = entity.getStackInSlot(i);

				if (stack != null) {
					float f = this.rand.nextFloat() * .8f + .1f;
					float f1 = this.rand.nextFloat() * .8f + .1f;
					float f2 = this.rand.nextFloat() * .8f + .1f;

					while (stack.stackSize > 0) {
						int j = this.rand.nextInt(21) + 10;

						if (j > stack.stackSize) {
							j = stack.stackSize;
						}

						stack.stackSize -= j;

						EntityItem item = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1),
								(double) ((float) z + f2), new ItemStack(stack.getItem(), j, stack.getItemDamage()));

						// Check items for tag and load it
						if (stack.hasTagCompound()) {
							item.getEntityItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
						}

						// Set motion to dropped items
						float f3 = .05f;
						item.motionX = (double) ((float) this.rand.nextGaussian() * f3);
						item.motionY = (double) ((float) this.rand.nextGaussian() * f3 + .2f);
						item.motionZ = (double) ((float) this.rand.nextGaussian() * f3);

						world.spawnEntityInWorld(item);
					}
				}
			}
			world.getBlock(x, y, z);
		}
		super.breakBlock(world, x, y, z, block, meta);
	}

	public boolean hasComparatorInputOverride() {
		return true;
	}

	public int getComparatorInputOverride(World world, int x, int y, int z, int i) {
		return Container.calcRedstoneFromInventory((IInventory) world.getTileEntity(x, y, z));
	}
}
