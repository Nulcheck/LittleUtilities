package mce.lu.common.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class FluidBase extends BlockFluidBase {
	public FluidBase(String name, Fluid fluid, Material material, List<Block> blockList, List<Item> itemList, MapColor mapColor) {
		super(fluid, material, mapColor);
		
		setUnlocalizedName(name);
		setRegistryName(name);

		blockList.add(this);
		itemList.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	public int place(World world, BlockPos pos, FluidStack fluidStack, boolean doPlace) {
		return 0;
	}

	public FluidStack drain(World world, BlockPos pos, boolean doDrain) {
		return null;
	}

	public boolean canDrain(World world, BlockPos pos) {
		return false;
	}

	public int getQuantaValue(IBlockAccess world, BlockPos pos) {
		return 0;
	}

	public boolean canCollideCheck(IBlockState state, boolean fullHit) {
		return false;
	}

	public int getMaxRenderHeightMeta() {
		return 0;
	}
}
