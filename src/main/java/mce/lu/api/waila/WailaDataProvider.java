package mce.lu.api.waila;

import java.util.List;
import java.util.Random;

import mce.lu.common.block.EdibleBlock;
import mce.lu.common.block.ModBlocks;
import mce.lu.common.block.UsableBlock;
import mce.lu.common.entity.tile.TileEntitySnowMelter;
import mce.lu.common.util.References;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaRegistrar;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional.Interface;
import net.minecraftforge.fml.common.Optional.Method;

@Interface(iface = "mcp.modius.waila.api.IWailaDataProvider", modid = References.WAILA)
public class WailaDataProvider implements IWailaDataProvider {
	@Method(modid = References.WAILA)
	public static void register(IWailaRegistrar reg) {
		WailaDataProvider provider = new WailaDataProvider();

		reg.registerBodyProvider(provider, TileEntitySnowMelter.class);
		reg.registerNBTProvider(provider, TileEntitySnowMelter.class);
	}

	@Override
	@Method(modid = References.WAILA)
	public List<String> getWailaHead(ItemStack stack, List<String> list, IWailaDataAccessor data,
			IWailaConfigHandler config) {
		return list;
	}

	@Override
	@Method(modid = References.WAILA)
	public List<String> getWailaBody(ItemStack stack, List<String> list, IWailaDataAccessor data,
			IWailaConfigHandler config) {
		Random rand = new Random();
		int i = rand.nextInt(150);

		Block block = data.getBlock();
		TileEntity tile = data.getTileEntity();
		NBTTagCompound tag = data.getNBTData();

		int snowMelterRange = data.getNBTInteger(data.getNBTData(), "SnowMelterRange");
		boolean snowMelterRedstoneMode = tag.getBoolean("SnowMelterRedstoneMode");

		// Snow Melter
		if (tile instanceof TileEntitySnowMelter) {
			list.add("Range: " + snowMelterRange);
			list.add("Redstone Mode: " + snowMelterRedstoneMode);
		}

		// Normal Blocks
		if (block == ModBlocks.BLAZE_ROD_BLOCK || block == ModBlocks.BLAZE_POWDER_BLOCK
				|| block == ModBlocks.BLAZE_BARS)
			list.add("Hot!");

		if (block == ModBlocks.PUFFERFISH_BLOCK)
			list.add("Poisonous!");

		// Edible and Usable Blocks
		if (block instanceof EdibleBlock) {
			int meta = 9 - data.getMetadata();

			if (meta > 1)
				list.add(meta + " Bites Left");

			else if (meta == 1) {
				if (i == 23)
					list.add(meta + " Byte Left");
				else
					list.add(meta + " Bite Left");
			}
		}

		if (block instanceof UsableBlock) {
			int meta = 9 - data.getMetadata();

			if (meta > 1)
				list.add(meta + " Uses Left");

			else if (meta == 1)
				list.add(meta + " Use Left");
		}

		return list;
	}

	@Override
	@Method(modid = References.WAILA)
	public List<String> getWailaTail(ItemStack stack, List<String> list, IWailaDataAccessor data,
			IWailaConfigHandler config) {
		return list;
	}

	@Override
	@Method(modid = References.MOD_ID)
	public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world,
			BlockPos pos) {
		try {
			Integer snowMelterRange = -1;
			Boolean snowMelterRedstoneMode = false;

			if (te instanceof TileEntitySnowMelter) {
				snowMelterRange = (Integer) TileEntitySnowMelter.class.getMethod("getRange").invoke(te);
				snowMelterRedstoneMode = (Boolean) TileEntitySnowMelter.class.getMethod("getRedstoneMode").invoke(te);
			}

			tag.setInteger("SnowMelterRange", snowMelterRange);
			tag.setBoolean("SnowMelterRedstoneMode", snowMelterRedstoneMode);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return tag;
	}
}
