package mce.lu.client.core.handler;

import mce.lu.common.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class RecipeHandler {
	public static void registerSmeltingRecipe() {
		if (OreDictionary.doesOreNameExist("itemSilicon") || OreDictionary.doesOreNameExist("ingotSilicon")) {
			for (ItemStack stack : OreDictionary.getOres("itemSilicon"))
				GameRegistry.addSmelting(ModItems.PURE_QUARTZ, stack, 0.5f);

			for (ItemStack stack : OreDictionary.getOres("ingotSilicon"))
				GameRegistry.addSmelting(ModItems.PURE_QUARTZ, stack, 0.5f);
		}
	}
}
