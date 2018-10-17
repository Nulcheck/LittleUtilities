package mce.lu.common.event;

import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.util.text.event.HoverEvent.Action;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChatEvent {
	@SubscribeEvent
	public void chat(ClientChatReceivedEvent e) {
		if (e.getMessage().getUnformattedText().contains("New LittleUtilities Update! ")) {
			e.getMessage().appendSibling(
					new TextComponentString("[Click Here]").setStyle(new Style().setColor(TextFormatting.GOLD)
							.setHoverEvent(new HoverEvent(Action.SHOW_TEXT,
									new TextComponentString("New update!")))
							.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL,
									"https://minecraft.curseforge.com/projects/littleutilities"))));
		}
	}
}
