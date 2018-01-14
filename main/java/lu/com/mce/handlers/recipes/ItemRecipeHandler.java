package lu.com.mce.handlers.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRecipeHandler {
	public static void registerCrafting() {
		GameRegistry.addRecipe(new ItemStack(Items.blaze_rod), "p", "p", 'p', new ItemStack(Items.blaze_powder));

		GameRegistry.addRecipe(new ItemStack(Items.bone), "p", "p", "p", 'p', new ItemStack(Items.dye, 1, 15));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.rotten_flesh), new ItemStack(Items.fermented_spider_eye),
				new ItemStack(Items.porkchop));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.rotten_flesh), new ItemStack(Items.fermented_spider_eye),
				new ItemStack(Items.cooked_porkchop));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.rotten_flesh), new ItemStack(Items.fermented_spider_eye),
				new ItemStack(Items.beef));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.rotten_flesh), new ItemStack(Items.fermented_spider_eye),
				new ItemStack(Items.cooked_beef));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.rotten_flesh), new ItemStack(Items.fermented_spider_eye),
				new ItemStack(Items.chicken));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.rotten_flesh), new ItemStack(Items.fermented_spider_eye),
				new ItemStack(Items.cooked_chicken));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.name_tag), new ItemStack(Items.lead),
				new ItemStack(Items.paper));

		GameRegistry.addRecipe(new ItemStack(Items.saddle), "lll", "lil", "i i", 'l', new ItemStack(Items.leather), 'i',
				new ItemStack(Items.iron_ingot));

		GameRegistry.addRecipe(new ItemStack(Items.iron_horse_armor), "  i", "isi", "i i", 's',
				new ItemStack(Items.saddle), 'i', new ItemStack(Items.iron_ingot));

		GameRegistry.addRecipe(new ItemStack(Items.golden_horse_armor), "  i", "isi", "i i", 's',
				new ItemStack(Items.saddle), 'i', new ItemStack(Items.gold_ingot));

		GameRegistry.addRecipe(new ItemStack(Items.diamond_horse_armor), "  i", "isi", "i i", 's',
				new ItemStack(Items.saddle), 'i', new ItemStack(Items.diamond));
	}
}
