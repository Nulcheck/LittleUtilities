package lu.com.mce.handlers.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import lu.com.mce.common.mod_lu;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

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

		GameRegistry.addShapelessRecipe(new ItemStack(Items.quartz, 4), new ItemStack(Blocks.quartz_block));
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.clay_ball, 4), new ItemStack(Blocks.clay));
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.snowball, 4), new ItemStack(Blocks.snow));
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.glowstone_dust, 4), new ItemStack(Blocks.glowstone));
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.netherbrick, 4), new ItemStack(Blocks.nether_brick));
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.brick, 4), new ItemStack(Blocks.brick_block));
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.string, 4), new ItemStack(Blocks.wool));
	}
}
