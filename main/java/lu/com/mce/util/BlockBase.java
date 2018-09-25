package lu.com.mce.util;

import lu.com.mce.common.mod_lu;
import lu.com.mce.objects.InitBlocks;
import lu.com.mce.objects.InitItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {
	public BlockBase(String name, Material mat) {
		super(mat);

		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(mod_lu.lu);

		InitBlocks.BLOCKS.add(this);
		InitItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	public void registerModels() {
		mod_lu.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
