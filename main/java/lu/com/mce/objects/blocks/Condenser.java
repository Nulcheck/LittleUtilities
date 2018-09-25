package lu.com.mce.objects.blocks;

import java.util.Random;

import lu.com.mce.entity.tile.TileEntityCondenser;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Condenser extends BlockContainer implements ITileEntityProvider {
	private Random rand = new Random();

	public Condenser(Material mat) {
		super(mat);
	}

	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityCondenser();
	}

	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		// player.openGui(mod_lu.instance, mod_lu.condenserGUI, world, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}

	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntityCondenser entity = (TileEntityCondenser) world.getTileEntity(pos);

		if (entity != null) {
			for (int i = 0; i < entity.getSizeInv(); i++) {
				ItemStack stack = entity.getStackInSlot(i);

				if (stack != null) {
					float f = this.rand.nextFloat() * .8f + .1f;
					float f1 = this.rand.nextFloat() * .8f + .1f;
					float f2 = this.rand.nextFloat() * .8f + .1f;

					while (stack.getCount() > 0) {
						int j = this.rand.nextInt(21) + 10;

						if (j > stack.getCount()) {
							j = stack.getCount();
						}

						stack.shrink(j);

						EntityItem item = new EntityItem(world, (double) ((float) pos.getX() + f),
								(double) ((float) pos.getY() + f1), (double) ((float) pos.getZ() + f2),
								new ItemStack(stack.getItem(), j, stack.getItemDamage()));

						// Check items for tag and load it
						if (stack.hasTagCompound()) {
							item.getItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
						}

						// Set motion to dropped items
						float f3 = .05f;
						item.motionX = (double) ((float) this.rand.nextGaussian() * f3);
						item.motionY = (double) ((float) this.rand.nextGaussian() * f3 + .2f);
						item.motionZ = (double) ((float) this.rand.nextGaussian() * f3);

						world.spawnEntity(item);
					}
				}
			}
			world.getBlockState(pos);
		}
		super.breakBlock(world, pos, state);
	}

	public boolean hasComparatorInputOverride() {
		return true;
	}

	public int getComparatorInputOverride(IBlockState blockState, World world, BlockPos pos) {
		return Container.calcRedstoneFromInventory((IInventory) world.getTileEntity(pos));
	}
}
