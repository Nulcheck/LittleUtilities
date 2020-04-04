package mce.lu.common.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public abstract class BlockSlabBase extends BlockSlab {
	public BlockSlabBase(String name, Material mat, List<Block> blockList, List<Item> itemList) {
		super(mat);
		IBlockState state = this.blockState.getBaseState();

		if (!this.isDouble())
			state = state.withProperty(HALF, BlockSlabBase.EnumBlockHalf.BOTTOM);

		setUnlocalizedName(name);
		setRegistryName(name);

		blockList.add(this);
		itemList.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	public BlockSlabBase(String name, Material mat, List<Block> blockList, List<Item> itemList, SoundType sound) {
		this(name, mat, blockList, itemList);
		this.blockSoundType = sound;
		IBlockState state = this.blockState.getBaseState();

		if (!this.isDouble())
			state = state.withProperty(HALF, BlockSlabBase.EnumBlockHalf.BOTTOM);
	}

	@Override
	public abstract String getUnlocalizedName(int meta);

	@Override
	public abstract boolean isDouble();

	@Override
	public abstract IProperty<?> getVariantProperty();

	@Override
	public abstract Comparable<?> getTypeForItem(ItemStack stack);

	public IBlockState getStateFromMeta(int meta) {
		IBlockState state = this.getDefaultState();
		if (!this.isDouble())
			state = state.withProperty(HALF,
					(meta & 8) == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);
		return state;
	}

	public int getMetaFromState(IBlockState state) {
		int i = 0;
		if (!this.isDouble() && state.getValue(HALF) == BlockSlab.EnumBlockHalf.TOP)
			i |= 8;
		return i;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return this.isDouble() ? new BlockStateContainer(this)
				: new BlockStateContainer(this, new IProperty[] { HALF });
	}
}
