package mce.lu.common.util;

import mce.lu.common.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDict {
	public static void registerOreDict() {
		// Pigments
		OreDictionary.registerOre("pigmentBlack", new ItemStack(ModItems.PIGMENT_BLACK));
		OreDictionary.registerOre("pigmentRed", new ItemStack(ModItems.PIGMENT_RED));
		OreDictionary.registerOre("pigmentGreen", new ItemStack(ModItems.PIGMENT_GREEN));
		OreDictionary.registerOre("pigmentBrown", new ItemStack(ModItems.PIGMENT_BROWN));
		OreDictionary.registerOre("pigmentBlue", new ItemStack(ModItems.PIGMENT_BLUE));
		OreDictionary.registerOre("pigmentPurple", new ItemStack(ModItems.PIGMENT_PURPLE));
		OreDictionary.registerOre("pigmentCyan", new ItemStack(ModItems.PIGMENT_CYAN));
		OreDictionary.registerOre("pigmentLightGray", new ItemStack(ModItems.PIGMENT_LIGHT_GRAY));
		OreDictionary.registerOre("pigmentGray", new ItemStack(ModItems.PIGMENT_GRAY));
		OreDictionary.registerOre("pigmentPink", new ItemStack(ModItems.PIGMENT_PINK));
		OreDictionary.registerOre("pigmentLime", new ItemStack(ModItems.PIGMENT_LIME));
		OreDictionary.registerOre("pigmentYellow", new ItemStack(ModItems.PIGMENT_YELLOW));
		OreDictionary.registerOre("pigmentLightBlue", new ItemStack(ModItems.PIGMENT_LIGHT_BLUE));
		OreDictionary.registerOre("pigmentMagenta", new ItemStack(ModItems.PIGMENT_MAGENTA));
		OreDictionary.registerOre("pigmentOrange", new ItemStack(ModItems.PIGMENT_ORANGE));
		OreDictionary.registerOre("pigmentWhite", new ItemStack(ModItems.PIGMENT_WHITE));

		OreDictionary.registerOre("dyeBlack", new ItemStack(ModItems.PIGMENT_BLACK));
		OreDictionary.registerOre("dyeRed",new ItemStack( ModItems.PIGMENT_RED));
		OreDictionary.registerOre("dyeGreen",new ItemStack( ModItems.PIGMENT_GREEN));
		OreDictionary.registerOre("dyeBrown", new ItemStack(ModItems.PIGMENT_BROWN));
		OreDictionary.registerOre("dyeBlue", new ItemStack(ModItems.PIGMENT_BLUE));
		OreDictionary.registerOre("dyePurple", new ItemStack(ModItems.PIGMENT_PURPLE));
		OreDictionary.registerOre("dyeCyan", new ItemStack(ModItems.PIGMENT_CYAN));
		OreDictionary.registerOre("dyeLightGray", new ItemStack(ModItems.PIGMENT_LIGHT_GRAY));
		OreDictionary.registerOre("dyeGray", new ItemStack(ModItems.PIGMENT_GRAY));
		OreDictionary.registerOre("dyePink", new ItemStack(ModItems.PIGMENT_PINK));
		OreDictionary.registerOre("dyeLime",new ItemStack( ModItems.PIGMENT_LIME));
		OreDictionary.registerOre("dyeYellow", new ItemStack(ModItems.PIGMENT_YELLOW));
		OreDictionary.registerOre("dyeLightBlue", new ItemStack(ModItems.PIGMENT_LIGHT_BLUE));
		OreDictionary.registerOre("dyeMagenta", new ItemStack(ModItems.PIGMENT_MAGENTA));
		OreDictionary.registerOre("dyeOrange", new ItemStack(ModItems.PIGMENT_ORANGE));
		OreDictionary.registerOre("dyeWhite", new ItemStack(ModItems.PIGMENT_WHITE));

		OreDictionary.registerOre("dye", new ItemStack(ModItems.PIGMENT_BLACK));
		OreDictionary.registerOre("dye", new ItemStack(ModItems.PIGMENT_RED));
		OreDictionary.registerOre("dye", new ItemStack(ModItems.PIGMENT_GREEN));
		OreDictionary.registerOre("dye", new ItemStack(ModItems.PIGMENT_BROWN));
		OreDictionary.registerOre("dye", new ItemStack(ModItems.PIGMENT_BLUE));
		OreDictionary.registerOre("dye", new ItemStack(ModItems.PIGMENT_PURPLE));
		OreDictionary.registerOre("dye", new ItemStack(ModItems.PIGMENT_CYAN));
		OreDictionary.registerOre("dye", new ItemStack(ModItems.PIGMENT_LIGHT_GRAY));
		OreDictionary.registerOre("dye", new ItemStack(ModItems.PIGMENT_GRAY));
		OreDictionary.registerOre("dye", new ItemStack(ModItems.PIGMENT_PINK));
		OreDictionary.registerOre("dye", new ItemStack(ModItems.PIGMENT_LIME));
		OreDictionary.registerOre("dye", new ItemStack(ModItems.PIGMENT_YELLOW));
		OreDictionary.registerOre("dye", new ItemStack(ModItems.PIGMENT_LIGHT_BLUE));
		OreDictionary.registerOre("dye", new ItemStack(ModItems.PIGMENT_MAGENTA));
		OreDictionary.registerOre("dye", new ItemStack(ModItems.PIGMENT_ORANGE));
		OreDictionary.registerOre("dye", new ItemStack(ModItems.PIGMENT_WHITE));

		OreDictionary.registerOre("gemQuartz", new ItemStack(ModItems.PURE_QUARTZ));

		OreDictionary.registerOre("stone", new ItemStack(Blocks.STONE, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("stone", new ItemStack(Blocks.STONEBRICK, 1, OreDictionary.WILDCARD_VALUE));
	}
}
