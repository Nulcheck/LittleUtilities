package mce.lu.common.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.xendric.xenlib.client.core.proxy.ClientProxy;

public class BlockStairsBase extends BlockStairs {
	public BlockStairsBase(String name, Material mat, List<Block> blockList, List<Item> itemList,
			IBlockState modelState) {
		super(modelState);

		setUnlocalizedName(name);
		setRegistryName(name);

		blockList.add(this);
		itemList.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	public BlockStairsBase(String name, Material mat, List<Block> blockList, List<Item> itemList, SoundType sound,
			IBlockState modelState) {
		this(name, mat, blockList, itemList, modelState);
		this.blockSoundType = sound;
	}

	@SideOnly(Side.CLIENT)
	public void registerItemModels() {
		ClientProxy.registerItemModel(Item.getItemFromBlock(this), 0, "inventory");
	}
}
