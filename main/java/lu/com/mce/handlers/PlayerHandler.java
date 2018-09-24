package lu.com.mce.handlers;

import com.mojang.realmsclient.gui.ChatFormatting;

import lu.com.mce.util.updater.UpdateInfo;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class PlayerHandler {
	private boolean newUpdate;
	
	public PlayerHandler(){
		try{
			if(Integer.parseInt(UpdateInfo.getLatestVersion()) > UpdateInfo.thisVersion){
				this.newUpdate = true;
			}
		} catch(Exception e){
			System.out.println("An error has occurred while checking for LittleUtilities updates! Error ID: 001");
			e.printStackTrace();
		}
	}
	
	@SubscribeEvent
	public void onPlayerLogin(PlayerLoggedInEvent e){
		if(newUpdate){
			e.player.sendMessage(new TextComponentString(ChatFormatting.AQUA + "New LittleUtilities Update! "));
		}
	}
}
