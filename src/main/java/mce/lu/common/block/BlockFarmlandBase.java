package mce.lu.common.block;

import mce.lu.client.core.proxy.ClientProxy;
import mce.lu.client.render.IModelRegister;
import mce.lu.common.LittleUtilities;
import mce.lu.common.item.ModItems;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.FarmlandWaterManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFarmlandBase extends BlockFarmland implements IModelRegister {
	public BlockFarmlandBase(String name) {
		super();

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
	
	public boolean hasWater(World world, BlockPos pos) {
		for (BlockPos.MutableBlockPos mutablePos : BlockPos.getAllInBoxMutable(pos.add(-4, 0, -4), pos.add(4, 1, 4))) {
			if (world.getBlockState(mutablePos).getMaterial() == Material.WATER)
				return true;
		}

		return FarmlandWaterManager.hasBlockWaterTicket(world, pos);
	}
}
