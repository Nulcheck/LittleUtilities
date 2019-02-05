package mce.lu.common.util;

import mce.lu.common.item.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

public class WrenchHandler {
	public static boolean holdingWrench(EntityPlayer player) {
		EnumHand hand = EnumHand.MAIN_HAND;
		ItemStack stack = player.getHeldItem(hand);

		if (stack.isEmpty()) {
			hand = EnumHand.OFF_HAND;
			stack = player.getHeldItem(hand);
		}

		if (stack.isEmpty())
			return false;

		if (stack.getItem() == ModItems.WRENCH)
			return true;

		return false;
	}
}