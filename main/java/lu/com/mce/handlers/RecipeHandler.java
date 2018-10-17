package lu.com.mce.handlers;

import lu.com.mce.objects.InitItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class RecipeHandler {
	public static void registerSmeltingRecipe() {
		if (OreDictionary.doesOreNameExist("itemSilicon") || OreDictionary.doesOreNameExist("ingotSilicon")) {
			for (ItemStack stack : OreDictionary.getOres("itemSilicon"))
				GameRegistry.addSmelting(InitItems.PURE_QUARTZ, stack, 0.5f);

			for (ItemStack stack : OreDictionary.getOres("ingotSilicon"))
				GameRegistry.addSmelting(InitItems.PURE_QUARTZ, stack, 0.5f);
		}
	}
}
