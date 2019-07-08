package mce.lu.common.event;

import java.awt.Color;

import mce.lu.common.LittleUtilities;
import mce.lu.common.block.ModBlocks;
import mce.lu.common.block.ModFluids;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.EntityViewRenderEvent.FogColors;
import net.minecraftforge.client.event.EntityViewRenderEvent.FogDensity;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

@EventBusSubscriber
public class ModFluidEvent {
	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent e) {
		if (e.phase == TickEvent.Phase.START && e.player.world.isRemote) {
			EntityPlayer player = e.player;
			LittleUtilities.proxy.handleMaterialAcceleration(player,
					ModBlocks.PIGMENT_BLACK_FLUID_BLOCK.getDefaultState().getMaterial());
		}
	}

	@SubscribeEvent
	public void onFogDensty(FogDensity e) {
		if (e.getEntity().isInsideOfMaterial(ModFluids.LIQUID_PIGMENT))
			e.setDensity(0.5f);
		else
			e.setDensity(0.0001f);
		e.setCanceled(true);
	}

	@SubscribeEvent
	public void onFogColor(FogColors e) {
		if (e.getEntity().isInsideOfMaterial(ModFluids.LIQUID_PIGMENT)) {
			Color color = Color.BLACK;
			e.setRed(color.getRed());
			e.setGreen(color.getGreen());
			e.setBlue(color.getBlue());
		}
	}
}
