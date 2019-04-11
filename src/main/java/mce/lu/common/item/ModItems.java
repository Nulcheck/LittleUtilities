package mce.lu.common.item;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class ModItems {
	public static final List<Item> ITEMS = new ArrayList<Item>();

	public static final Item WRENCH = new Wrench("lu_wrench");
	public static final Item SPONGE = new ItemBase("sponge");
	public static final Item PURE_QUARTZ = new ItemBase("pure_quartz");
	public static final Item LEATHER_SCRAPS = new ItemBase("leather_scraps");
	public static final Item ZOMBIE_CURING_KIT = new ItemBase("zombie_curing_kit");
	public static final Item HEATING_ELEMENT = new ItemBase("heating_element");
	public static final Item FERTILIZER = new Fertilizer("fertilizer");
	public static final Item CACTUS_FIBER = new ItemBase("cactus_fiber");
	public static final Item CACTUS_TWINE = new ItemBase("cactus_twine");

	// public static final Item OBSIDIAN_BOAT = new
	// ObsidianBoat("obsidian_boat");

	// Pigments
	public static final Item PIGMENT_BLACK = new ItemBase("pigment_black");
	public static final Item PIGMENT_RED = new ItemBase("pigment_red");
	public static final Item PIGMENT_GREEN = new ItemBase("pigment_green");
	public static final Item PIGMENT_BROWN = new ItemBase("pigment_brown");
	public static final Item PIGMENT_BLUE = new ItemBase("pigment_blue");
	public static final Item PIGMENT_PURPLE = new ItemBase("pigment_purple");
	public static final Item PIGMENT_CYAN = new ItemBase("pigment_cyan");
	public static final Item PIGMENT_LIGHT_GRAY = new ItemBase("pigment_light_gray");
	public static final Item PIGMENT_GRAY = new ItemBase("pigment_gray");
	public static final Item PIGMENT_PINK = new ItemBase("pigment_pink");
	public static final Item PIGMENT_LIME = new ItemBase("pigment_lime");
	public static final Item PIGMENT_YELLOW = new ItemBase("pigment_yellow");
	public static final Item PIGMENT_LIGHT_BLUE = new ItemBase("pigment_light_blue");
	public static final Item PIGMENT_MAGENTA = new ItemBase("pigment_magenta");
	public static final Item PIGMENT_ORANGE = new ItemBase("pigment_orange");
	public static final Item PIGMENT_WHITE = new ItemBase("pigment_white");

	// Liquid Pigments
	public static final Item BUCKET_PIGMENT_BLACK = new ItemBase("bucket_pigment_black");
	public static final Item BUCKET_PIGMENT_RED = new ItemBase("bucket_pigment_red");
	public static final Item BUCKET_PIGMENT_GREEN = new ItemBase("bucket_pigment_green");
	public static final Item BUCKET_PIGMENT_BROWN = new ItemBase("bucket_pigment_brown");
	public static final Item BUCKET_PIGMENT_BLUE = new ItemBase("bucket_pigment_blue");
	public static final Item BUCKET_PIGMENT_PURPLE = new ItemBase("bucket_pigment_purple");
	public static final Item BUCKET_PIGMENT_CYAN = new ItemBase("bucket_pigment_cyan");
	public static final Item BUCKET_PIGMENT_LIGHT_GRAY = new ItemBase("bucket_pigment_light_gray");
	public static final Item BUCKET_PIGMENT_GRAY = new ItemBase("bucket_pigment_gray");
	public static final Item BUCKET_PIGMENT_PINK = new ItemBase("bucket_pigment_pink");
	public static final Item BUCKET_PIGMENT_LIME = new ItemBase("bucket_pigment_lime");
	public static final Item BUCKET_PIGMENT_YELLOW = new ItemBase("bucket_pigment_yellow");
	public static final Item BUCKET_PIGMENT_LIGHT_BLUE = new ItemBase("bucket_pigment_light_blue");
	public static final Item BUCKET_PIGMENT_MAGENTA = new ItemBase("bucket_pigment_magenta");
	public static final Item BUCKET_PIGMENT_ORANGE = new ItemBase("bucket_pigment_orange");
	public static final Item BUCKET_PIGMENT_WHITE = new ItemBase("bucket_pigment_white");

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> e) {
		e.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
}