package mce.lu.common.item;

import java.util.ArrayList;
import java.util.List;

import mce.lu.common.LittleUtilities;
import net.minecraft.item.Item;
import net.xendric.xenlib.common.core.item.ItemBase;

public class ModItems {
	public static final List<Item> ITEMS = new ArrayList<Item>();

	public static final Item SPONGE = new ItemBase("sponge", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item PURE_QUARTZ = new ItemBase("pure_quartz", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item LEATHER_SCRAPS = new ItemBase("leather_scraps", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item ZOMBIE_CURING_KIT = new ItemBase("zombie_curing_kit", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item HEATING_ELEMENT = new ItemBase("heating_element", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item FERTILIZER = new Fertilizer("fertilizer", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item CACTUS_FIBER = new ItemBase("cactus_fiber", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item CACTUS_TWINE = new ItemBase("cactus_twine", ITEMS).setCreativeTab(LittleUtilities.lu);

	// public static final Item OBSIDIAN_BOAT = new
	// ObsidianBoat("obsidian_boat");

	// Pigments
	public static final Item PIGMENT_BLACK = new ItemBase("pigment_black", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_RED = new ItemBase("pigment_red", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_GREEN = new ItemBase("pigment_green", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_BROWN = new ItemBase("pigment_brown", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_BLUE = new ItemBase("pigment_blue", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_PURPLE = new ItemBase("pigment_purple", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_CYAN = new ItemBase("pigment_cyan", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_LIGHT_GRAY = new ItemBase("pigment_light_gray", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_GRAY = new ItemBase("pigment_gray", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_PINK = new ItemBase("pigment_pink", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_LIME = new ItemBase("pigment_lime", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_YELLOW = new ItemBase("pigment_yellow", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_LIGHT_BLUE = new ItemBase("pigment_light_blue", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_MAGENTA = new ItemBase("pigment_magenta", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_ORANGE = new ItemBase("pigment_orange", ITEMS).setCreativeTab(LittleUtilities.lu);
	public static final Item PIGMENT_WHITE = new ItemBase("pigment_white", ITEMS).setCreativeTab(LittleUtilities.lu);

	// Liquid Pigments
	public static final Item BUCKET_PIGMENT_BLACK = new ItemBase("bucket_pigment_black", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item BUCKET_PIGMENT_RED = new ItemBase("bucket_pigment_red", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item BUCKET_PIGMENT_GREEN = new ItemBase("bucket_pigment_green", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item BUCKET_PIGMENT_BROWN = new ItemBase("bucket_pigment_brown", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item BUCKET_PIGMENT_BLUE = new ItemBase("bucket_pigment_blue", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item BUCKET_PIGMENT_PURPLE = new ItemBase("bucket_pigment_purple", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item BUCKET_PIGMENT_CYAN = new ItemBase("bucket_pigment_cyan", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item BUCKET_PIGMENT_LIGHT_GRAY = new ItemBase("bucket_pigment_light_gray", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item BUCKET_PIGMENT_GRAY = new ItemBase("bucket_pigment_gray", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item BUCKET_PIGMENT_PINK = new ItemBase("bucket_pigment_pink", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item BUCKET_PIGMENT_LIME = new ItemBase("bucket_pigment_lime", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item BUCKET_PIGMENT_YELLOW = new ItemBase("bucket_pigment_yellow", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item BUCKET_PIGMENT_LIGHT_BLUE = new ItemBase("bucket_pigment_light_blue", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item BUCKET_PIGMENT_MAGENTA = new ItemBase("bucket_pigment_magenta", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item BUCKET_PIGMENT_ORANGE = new ItemBase("bucket_pigment_orange", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Item BUCKET_PIGMENT_WHITE = new ItemBase("bucket_pigment_white", ITEMS)
			.setCreativeTab(LittleUtilities.lu);
}