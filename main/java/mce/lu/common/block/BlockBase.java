package mce.lu.common.block;

import mce.lu.client.core.handler.ModelHandler;
import mce.lu.client.render.IModelRegister;
import mce.lu.common.LittleUtilities;
import mce.lu.common.item.ItemBlockEdible;
import mce.lu.common.item.ItemBlockUsable;
import mce.lu.common.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBase extends Block implements IModelRegister {
	public BlockBase(String name, Material mat) {
		super(mat);

		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(LittleUtilities.lu);

		ModBlocks.BLOCKS.add(this);
		if (this instanceof EdibleBlock)
			ModItems.ITEMS.add(new ItemBlockEdible(this).setRegistryName(this.getRegistryName()));
		else if (this instanceof UsableBlock)
			ModItems.ITEMS.add(new ItemBlockUsable(this).setRegistryName(this.getRegistryName()));
		else
			ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	public void registerItemModels() {
		if (this instanceof EdibleBlock)
			ModelHandler.registerItemBlockModel(this, new ItemBlockEdible(this), "inventory");
		else if (this instanceof UsableBlock)
			ModelHandler.registerItemBlockModel(this, new ItemBlockUsable(this), "inventory");
		else
			ModelHandler.registerItemModel(Item.getItemFromBlock(this), 0, "inventory");
	}
}