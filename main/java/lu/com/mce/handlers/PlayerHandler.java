package lu.com.mce.handlers;

import com.mojang.realmsclient.gui.ChatFormatting;

import lu.com.mce.util.UsernameHandler;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.util.text.event.HoverEvent.Action;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.common.ForgeVersion.Status;
import net.minecraftforge.event.entity.player.PlayerEvent.NameFormat;
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

	@SubscribeEvent
	public void addPatreonTag(NameFormat e) throws Exception {
		TextComponentString patreonTag = new TextComponentString(TextFormatting.GOLD + "[" + TextFormatting.DARK_PURPLE
				+ "p" + TextFormatting.GOLD + "] " + TextFormatting.RESET);
		Style hoverEvent = new Style()
				.setHoverEvent(new HoverEvent(Action.SHOW_TEXT, new TextComponentString("Patreon of MCE626!")))
				.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://patreon.com/MCE626"));

		if (e.getUsername().equals(UsernameHandler.getUsernames())) {
			e.getEntityPlayer().addPrefix(patreonTag.setStyle(hoverEvent));
		}
	}
}
