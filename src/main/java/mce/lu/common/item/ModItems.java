package mce.lu.common.item;

import java.util.ArrayList;
import java.util.List;

import mce.lu.common.LittleUtilities;
import net.minecraft.item.Item;
import net.xendric.xenlib.common.core.item.ItemBase;

public class ModItems {
	public static final List<Item> ITEMS = new ArrayList<>();

	public static final Item SPONGE = new ItemBase("sponge", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item PURE_QUARTZ = new ItemBase("pure_quartz", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item LEATHER_SCRAPS = new ItemBase("leather_scraps", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item ZOMBIE_CURING_KIT = new ItemBase("zombie_curing_kit", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item HEATING_ELEMENT = new ItemBase("heating_element", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item FERTILIZER = new ItemFertilizer("fertilizer", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item CACTUS_FIBER = new ItemBase("cactus_fiber", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item CACTUS_TWINE = new ItemBase("cactus_twine", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item REINFORCED_NETHERBRICK = new ItemBase("reinforced_netherbrick", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item REINFORCED_NETHERBRICK_PLATE = new ItemBase("reinforced_netherbrick_plate", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item LAVA_BOTTLE = new ItemLavaBottle("lava_bottle", ITEMS).setCreativeTab(LittleUtilities.lu);
	// public static final Item POWDER_MILK = new ItemBase("powder_milk",
	// ITEMS).setCreativeTab(LittleUtilities.lu);

	// public static final Item OBSIDIAN_BOAT = new
	// ObsidianBoat("obsidian_boat");

	// Pigments
	public static final Item PIGMENT_BLACK = new ItemBase("pigment_black_item", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_RED = new ItemBase("pigment_red_item", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_GREEN = new ItemBase("pigment_green_item", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_BROWN = new ItemBase("pigment_brown_item", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_BLUE = new ItemBase("pigment_blue_item", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_PURPLE = new ItemBase("pigment_purple_item", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_CYAN = new ItemBase("pigment_cyan_item", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_LIGHT_GRAY = new ItemBase("pigment_light_gray_item", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_GRAY = new ItemBase("pigment_gray_item", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_PINK = new ItemBase("pigment_pink_item", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_LIME = new ItemBase("pigment_lime_item", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_YELLOW = new ItemBase("pigment_yellow_item", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_LIGHT_BLUE = new ItemBase("pigment_light_blue_item", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_MAGENTA = new ItemBase("pigment_magenta_item", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_ORANGE = new ItemBase("pigment_orange_item", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_WHITE = new ItemBase("pigment_white_item", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
}