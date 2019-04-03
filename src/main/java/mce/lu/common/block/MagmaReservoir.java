package mce.lu.common.block;

import mce.lu.api.LittleUtilitiesHandlers;
import mce.lu.common.entity.tile.TileEntityMagmaReservoir;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MagmaReservoir extends BlockContainerBase {
	public MagmaReservoir(String name, Material mat) {
		super(name, mat);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityMagmaReservoir();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack heldItem = player.getHeldItem(hand);
		ItemStack resultStack = LittleUtilitiesHandlers.getReservoirOutput(heldItem);

		// For items that can hold fluids
		if (!resultStack.isEmpty()) {
			NBTTagCompound tag = heldItem.getTagCompound();
			ItemStack newStack = resultStack.copy();

			if (tag != null)
				newStack.setTagCompound(tag);
			if (heldItem.getCount() <= 1)
				player.setHeldItem(hand, newStack);
			else {
				if (player.inventory.addItemStackToInventory(newStack))
					heldItem.shrink(1);
			}

			world.playSound(null, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1f,
					world.rand.nextFloat() + 0.5f);
			return true;
		} else {
			TileEntity tile = world.getTileEntity(pos);
			if (tile != null) {
				IFluidHandler fluidHandler = tile.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY,
						facing);
				if (fluidHandler == null) {
					//
				} else {
					if (!FluidUtil.interactWithFluidHandler(player, hand, fluidHandler)) {
						//
					}
				}
				return !heldItem.isEmpty() && !(heldItem.getItem() instanceof ItemBlock);
			}
		}
		return true;
	}
}
