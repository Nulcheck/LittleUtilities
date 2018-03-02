package lu.com.mce.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import lu.com.mce.common.mod_lu;
import lu.com.mce.handlers.registers.AchRegistry;
import net.minecraft.item.Item;

public class AchievementHandler {
	@SubscribeEvent
	public void onCraft(PlayerEvent.ItemCraftedEvent e) {
		if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_lu.condenser)))
			e.player.addStat(AchRegistry.con, 1);

		//// Condenser Achievements
		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_lu.ghastTearBlock)))
			e.player.addStat(AchRegistry.ghastTear, 1);

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_lu.blazeRodBlock)))
			e.player.addStat(AchRegistry.blazeRod1, 1);

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_lu.netherStarBlock)))
			e.player.addStat(AchRegistry.netherStar, 1);

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_lu.enderEyeBlock)))
			e.player.addStat(AchRegistry.enderEye, 1);
	}
}
