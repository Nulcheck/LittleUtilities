package mce.lu.api.waila;

import java.util.List;

import mce.lu.common.block.ModBlocks;
import mce.lu.common.entity.tile.TileEntityLightSensor;
import mce.lu.common.entity.tile.TileEntitySnowMelter;
import mce.lu.common.util.References;
import mce.lu.common.util.config.LUConfigManager;
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

		reg.registerHeadProvider(provider, TileEntitySnowMelter.class);
		reg.registerHeadProvider(provider, TileEntityLightSensor.class);

		reg.registerBodyProvider(provider, TileEntitySnowMelter.class);
		reg.registerBodyProvider(provider, TileEntityLightSensor.class);
	}

	@Override
	@Method(modid = References.WAILA)
	public List<String> getWailaHead(ItemStack stack, List<String> tip, IWailaDataAccessor accessor,
			IWailaConfigHandler config) {
		return tip;
	}

	@Override
	@Method(modid = References.WAILA)
	public List<String> getWailaBody(ItemStack stack, List<String> tip, IWailaDataAccessor accessor,
			IWailaConfigHandler config) {
		Block block = accessor.getBlock();

		if (block == ModBlocks.SNOW_MELTER) {
			tip.add("Range: " + LUConfigManager.modConfig.features.snowMelterRange);
		}

		return tip;
	}

	@Override
	@Method(modid = References.WAILA)
	public List<String> getWailaTail(ItemStack stack, List<String> tip, IWailaDataAccessor accessor,
			IWailaConfigHandler config) {
		return tip;
	}

	@Override
	@Method(modid = References.MOD_ID)
	public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world,
			BlockPos pos) {
		return tag;
	}
}
