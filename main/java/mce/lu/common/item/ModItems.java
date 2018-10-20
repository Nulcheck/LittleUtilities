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

	public static final Item SPONGE = new ItemBase("sponge");
	public static final Item PURE_QUARTZ = new ItemBase("pure_quartz");
	public static final Item LEATHER_SCRAPS = new ItemBase("leather_scraps");
	public static final Item RED_PILL = new ItemBase("red_pill");
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> e) {
		e.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
}
