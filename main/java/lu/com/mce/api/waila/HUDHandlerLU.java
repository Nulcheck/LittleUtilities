package lu.com.mce.api.waila;

import java.util.List;
import java.util.Random;

import lu.com.mce.blocks.EdibleBlock;
import lu.com.mce.blocks.UsableBlock;
import lu.com.mce.common.mod_lu;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class HUDHandlerLU implements IWailaDataProvider {
	public ItemStack getWailaStack(IWailaDataAccessor data, IWailaConfigHandler config) {
		return null;
	}

	public List<String> getWailaHead(ItemStack stack, List<String> list, IWailaDataAccessor data, IWailaConfigHandler config) {
		return list;
	}

	public List<String> getWailaBody(ItemStack stack, List<String> list, IWailaDataAccessor data, IWailaConfigHandler config) {
		Random rand = new Random();
		int i = rand.nextInt(150);
		if (data.getBlock() instanceof EdibleBlock) {
			int meta = 9 - data.getMetadata();

			if (meta > 1)
				list.add(meta + " Bites Left");

			else if (meta == 1)
				if (i == 23)
					list.add(meta + "Byte Left");
				else
					list.add(meta + " Bite Left");
		}

		else if (data.getBlock() instanceof UsableBlock) {
			int meta = 9 - data.getMetadata();

			if (meta > 1)
				list.add(meta + " Uses Left");

			else if (meta == 1)
				list.add(meta + " Use Left");
		}
		return list;
	}

	public List<String> getWailaTail(ItemStack stack, List<String> list, IWailaDataAccessor data, IWailaConfigHandler config) {
		if (stack.getItem() == Item.getItemFromBlock(mod_lu.blazeRodBlock))
			list.add("Hot!");

		return list;
	}

	public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, int x, int y, int z) {
		return null;
	}
}
