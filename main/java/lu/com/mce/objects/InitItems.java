package lu.com.mce.objects;

import java.util.ArrayList;
import java.util.List;

import lu.com.mce.util.ItemBase;
import net.minecraft.item.Item;

public class InitItems {
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item SPONGE = new ItemBase("sponge");
	public static final Item PURE_QUARTZ = new ItemBase("pure_quartz");
	public static final Item LEATHER_SCRAPS = new ItemBase("leather_scraps");
}
