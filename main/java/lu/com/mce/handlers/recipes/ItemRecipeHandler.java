package lu.com.mce.handlers.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRecipeHandler {
	public static void registerCrafting() {
		GameRegistry.addRecipe(new ItemStack(Items.BLAZE_ROD), "p", "p", 'p', new ItemStack(Items.BLAZE_POWDER));

		GameRegistry.addRecipe(new ItemStack(Items.BONE), "p", "p", 'p', new ItemStack(Items.DYE, 1, 15));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.ROTTEN_FLESH), new ItemStack(Items.FERMENTED_SPIDER_EYE),
				new ItemStack(Items.PORKCHOP));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.ROTTEN_FLESH), new ItemStack(Items.FERMENTED_SPIDER_EYE),
				new ItemStack(Items.COOKED_PORKCHOP));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.ROTTEN_FLESH), new ItemStack(Items.FERMENTED_SPIDER_EYE),
				new ItemStack(Items.BEEF));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.ROTTEN_FLESH), new ItemStack(Items.FERMENTED_SPIDER_EYE),
				new ItemStack(Items.COOKED_BEEF));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.ROTTEN_FLESH), new ItemStack(Items.FERMENTED_SPIDER_EYE),
				new ItemStack(Items.CHICKEN));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.ROTTEN_FLESH), new ItemStack(Items.FERMENTED_SPIDER_EYE),
				new ItemStack(Items.COOKED_CHICKEN));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.NAME_TAG), new ItemStack(Items.LEAD),
				new ItemStack(Items.PAPER));

		GameRegistry.addRecipe(new ItemStack(Items.SADDLE), "lll", "lil", "i i", 'l', new ItemStack(Items.LEATHER), 'i',
				new ItemStack(Items.IRON_INGOT));

		GameRegistry.addRecipe(new ItemStack(Items.IRON_HORSE_ARMOR), "  i", "isi", "i i", 's',
				new ItemStack(Items.SADDLE), 'i', new ItemStack(Items.IRON_INGOT));

		GameRegistry.addRecipe(new ItemStack(Items.GOLDEN_HORSE_ARMOR), "  i", "isi", "i i", 's',
				new ItemStack(Items.SADDLE), 'i', new ItemStack(Items.GOLD_INGOT));

		GameRegistry.addRecipe(new ItemStack(Items.DIAMOND_HORSE_ARMOR), "  i", "isi", "i i", 's',
				new ItemStack(Items.SADDLE), 'i', new ItemStack(Items.DIAMOND));
	}
}
