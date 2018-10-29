package mce.lu.common.block;

import mce.lu.client.core.handler.ModelHandler;
import mce.lu.client.render.IModelRegister;
import mce.lu.common.LittleUtilities;
import mce.lu.common.item.ModItems;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockContainerBase extends BlockContainer implements IModelRegister {
	public BlockContainerBase(String name, Material mat) {
		super(mat);

		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(LittleUtilities.lu);

		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	public void registerItemModels() {
		ModelHandler.registerItemModel(Item.getItemFromBlock(this), 0, "inventory");
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return null;
	}
}