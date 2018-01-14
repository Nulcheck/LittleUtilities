package lu.com.mce.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.event.HoverEvent.Action;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;

public class ChatEvent {
	@SubscribeEvent
	public void chat(ClientChatReceivedEvent e) {
		if (e.message.getUnformattedText().contains("New LittleUtilities Update! ")) {
			e.message.appendSibling(
					new ChatComponentText("[Click Here]").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GOLD)
							.setChatHoverEvent(new HoverEvent(Action.SHOW_TEXT,
									new ChatComponentText("New update!")))
							.setChatClickEvent(new ClickEvent(net.minecraft.event.ClickEvent.Action.OPEN_URL,
									"https://minecraft.curseforge.com/projects/littleutilities"))));
		}
	}
}
