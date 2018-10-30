package mce.lu.client.core.handler;

import mce.lu.client.render.IModelRegister;
import mce.lu.common.block.ModBlocks;
import mce.lu.common.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class ModelHandler {
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent e) {
		for (Item item : ModItems.ITEMS) {
			if (item instanceof IModelRegister) {
				((IModelRegister) item).registerItemModels();
			}
		}

		for (Block block : ModBlocks.BLOCKS) {
			if (block instanceof IModelRegister) {
				((IModelRegister) block).registerItemModels();
			}
		}
	}
}