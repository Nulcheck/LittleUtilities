package mce.lu.api.waila;

import java.util.List;

import mce.lu.common.block.ModBlocks;
import mce.lu.common.entity.tile.TileEntitySnowMelter;
import mce.lu.common.util.References;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaRegistrar;
import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
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
		Block block = data.getBlock();
		TileEntity tile = data.getTileEntity();
		NBTTagCompound tag = data.getNBTData();

		int snowMelterRange = data.getNBTInteger(data.getNBTData(), "SnowMelterRange");
		boolean snowMelterRedstoneMode = tag.getBoolean("SnowMelterRedstoneMode");

		// Snow Melter
		if (tile instanceof TileEntitySnowMelter) {
			list.add(I18n.format("waila.lu.snowmelter.redstonemode") + ": " + snowMelterRedstoneMode);
			list.add(I18n.format("waila.lu.snowmelter.range") + ": " + snowMelterRange + " / 7");
		}

		// Normal Blocks
		if (block == ModBlocks.BLAZE_ROD_BLOCK || block == ModBlocks.BLAZE_POWDER_BLOCK
				|| block == ModBlocks.BLAZE_BARS)
			list.add(I18n.format("waila.lu.condensed_block.hot") + "!");

		if (block == ModBlocks.PUFFERFISH_BLOCK)
			list.add(I18n.format("waila.lu.condensed_block.poisonous") + "!");
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
