package lu.com.mce.handlers;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.common.ForgeVersion.Status;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class PlayerHandler {
	@SubscribeEvent
	public void onPlayerLogin(PlayerLoggedInEvent e) {
		try {
			if (ForgeVersion.getResult(Loader.instance().activeModContainer()).status == Status.OUTDATED) {
				e.player.sendMessage(new TextComponentString(ChatFormatting.AQUA + "New LittleUtilities Update! "));
			}
		} catch (Exception ex) {
			System.out.println("An error has occurred while checking for LittleUtilities updates!\nError ID: LU000");
			ex.printStackTrace();
		}
	}
}
