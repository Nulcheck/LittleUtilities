package mce.lu.common.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BlockCementBricksSlab extends BlockSlabBase {
	public BlockCementBricksSlab(String name, Material mat, List<Block> blockList, List<Item> itemList) {
		super(name, mat, blockList, itemList);
	}

	public boolean isDouble() {
		return false;
	}

	@Override
	public String getUnlocalizedName(int meta) {
		return super.getUnlocalizedName();
	}

	@Override
	public IProperty<?> getVariantProperty() {
		return null;
	}

	@Override
	public Comparable<?> getTypeForItem(ItemStack stack) {
		return (Comparable<?>) this;
	}

	public static class BlockCementBricksSlabDouble extends BlockSlabBase {
		public BlockCementBricksSlabDouble(String name, Material mat, List<Block> blockList, List<Item> itemList) {
			super(name, mat, blockList, itemList);
		}

		public boolean isDouble() {
			return true;
		}

		@Override
		public String getUnlocalizedName(int meta) {
			return super.getUnlocalizedName();
		}

		@Override
		public IProperty<?> getVariantProperty() {
			return null;
		}

		@Override
		public Comparable<?> getTypeForItem(ItemStack stack) {
			return (Comparable<?>) this;
		}
	}
}
