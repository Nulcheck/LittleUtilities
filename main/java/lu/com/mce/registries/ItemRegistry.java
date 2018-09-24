package lu.com.mce.registries;

import lu.com.mce.objects.items.ModItems;
import lu.com.mce.util.IHasModel;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class ItemRegistry {
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> e) {
		e.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent e) {
		for(Item item : ModItems.ITEMS){
			if(item instanceof IHasModel){
				((IHasModel) item).registerModels();
			}
		}
	}
}
