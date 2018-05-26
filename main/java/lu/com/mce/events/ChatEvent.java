package lu.com.mce.events;

import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.util.text.event.HoverEvent.Action;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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
