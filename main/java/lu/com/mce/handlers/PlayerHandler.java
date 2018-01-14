package lu.com.mce.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import lu.com.mce.util.updater.UpdateInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class PlayerHandler {
	private boolean newUpdate;

	public PlayerHandler() {
		try {
			if (Integer.parseInt(UpdateInfo.getLatestVersion()) > UpdateInfo.thisVersion) {
				this.newUpdate = true;
			}
		} catch (Exception e) {
			System.out.println("An error has occurred while checking for LittleUtilities updates!");
			e.printStackTrace();
		}
	}

	@SubscribeEvent
	public void onPlayerLogin(PlayerLoggedInEvent e) {
		onLogin(e.player);
	}

	public void onLogin(EntityPlayer player) {
		if (newUpdate) {
			player.addChatComponentMessage(
					new ChatComponentText(EnumChatFormatting.AQUA + "New LittleUtilites Update! "));
		}
	}
}
