package mce.lu.common.block;

import mce.lu.client.core.proxy.ClientProxy;
import mce.lu.client.render.IModelRegister;
import mce.lu.common.LittleUtilities;
import mce.lu.common.item.ItemBlockEdible;
import mce.lu.common.item.ItemBlockUsable;
import mce.lu.common.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
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
			ClientProxy.registerItemBlockModel(this, new ItemBlockEdible(this), "inventory");
		else if (this instanceof UsableBlock)
			ClientProxy.registerItemBlockModel(this, new ItemBlockUsable(this), "inventory");
		else
			ClientProxy.registerItemModel(Item.getItemFromBlock(this), 0, "inventory");
	}
	
	public static void turnIntoWater(World world, BlockPos pos) {
		if (world.provider.doesWaterVaporize())
			world.setBlockToAir(pos);
		else {
			world.getBlockState(pos).getBlock().dropBlockAsItem(world, pos, world.getBlockState(pos), 0);
			world.setBlockState(pos, Blocks.WATER.getDefaultState());
			world.neighborChanged(pos, Blocks.WATER, pos);
		}
	}
}