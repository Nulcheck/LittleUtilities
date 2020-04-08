package mce.lu.common.event;

import mce.lu.common.item.ModItems;
import mce.lu.common.util.References;
import mce.lu.common.util.config.LUConfigManager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class LoadLootTableEvent {
	static LootEntry skullEntry = new LootEntryItem(new ItemStack(Items.SKULL, 1, 0).getItem(), 45, 2,
			new LootFunction[0], new LootCondition[0], References.MOD_ID + "skullEntry");

	static LootEntry curingKitEntry = new LootEntryItem(ModItems.ZOMBIE_CURING_KIT, 18, 1, new LootFunction[0],
			new LootCondition[0], References.MOD_ID + "curingKitEntry");

	static LootEntry pureQuartzEntry = new LootEntryItem(ModItems.PURE_QUARTZ, 35, 3, new LootFunction[0],
			new LootCondition[0], References.MOD_ID + "pureQuartzEntry");

	static LootEntry cactusTwineEntry = new LootEntryItem(ModItems.CACTUS_TWINE, 40, 4, new LootFunction[0],
			new LootCondition[0], References.MOD_ID + "pureQuartzEntry");

	@SubscribeEvent
	public static void loadLoot(LootTableLoadEvent e) {
		if (e.getName().equals(LootTableList.CHESTS_SIMPLE_DUNGEON)) {
			e.getTable().getPool("main").addEntry(skullEntry);
			e.getTable().getPool("main").addEntry(curingKitEntry);

			if (LUConfigManager.modConfig.loot.pureQuartzLoot)
				e.getTable().getPool("main").addEntry(pureQuartzEntry);
		}

		if (e.getName().equals(LootTableList.CHESTS_JUNGLE_TEMPLE)) {
			e.getTable().getPool("main").addEntry(skullEntry);
			e.getTable().getPool("main").addEntry(curingKitEntry);

			if (LUConfigManager.modConfig.loot.pureQuartzLoot)
				e.getTable().getPool("main").addEntry(pureQuartzEntry);
		}

		if (e.getName().equals(LootTableList.CHESTS_ABANDONED_MINESHAFT)) {
			e.getTable().getPool("main").addEntry(skullEntry);
			e.getTable().getPool("main").addEntry(curingKitEntry);

			if (LUConfigManager.modConfig.loot.pureQuartzLoot)
				e.getTable().getPool("main").addEntry(pureQuartzEntry);
		}

		if (e.getName().equals(LootTableList.CHESTS_DESERT_PYRAMID)) {
			e.getTable().getPool("main").addEntry(skullEntry);
			e.getTable().getPool("main").addEntry(curingKitEntry);
			e.getTable().getPool("main").addEntry(cactusTwineEntry);

			if (LUConfigManager.modConfig.loot.pureQuartzLoot)
				e.getTable().getPool("main").addEntry(pureQuartzEntry);
		}
	}
}
