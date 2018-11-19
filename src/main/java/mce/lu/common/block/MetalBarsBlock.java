package mce.lu.common.block;

import mce.lu.client.core.proxy.ClientProxy;
import mce.lu.client.render.IModelRegister;
import mce.lu.common.LittleUtilities;
import mce.lu.common.item.ModItems;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MetalBarsBlock extends BlockPane implements IModelRegister {
	public MetalBarsBlock(String name, Material mat, boolean canDrop) {
		super(mat, canDrop);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(LittleUtilities.lu);

		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	public void registerItemModels() {
		ClientProxy.registerItemModel(Item.getItemFromBlock(this), 0, "inventory");
	}
	
	@Override
	public void onEntityWalk(World world, BlockPos pos, Entity entity) {
		if(world.getBlockState(pos).getBlock() == ModBlocks.BLAZE_BARS)
			entity.setFire(8);
	}
}
