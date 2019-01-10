package mce.lu.client.core.handler;

import mce.lu.common.block.ModBlocks;
import mce.lu.common.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class RecipeHandler {
	static ResourceLocation group = new ResourceLocation("recipes");
	static World world;
	static BlockPos pos;
	static Block block;

	public static void registerSmelting() {
		if (OreDictionary.doesOreNameExist("itemSilicon") || OreDictionary.doesOreNameExist("ingotSilicon")) {
			GameRegistry.addSmelting(Blocks.SANDSTONE, new ItemStack(ModItems.PURE_QUARTZ), 0.1f);
			GameRegistry.addSmelting(Blocks.RED_SANDSTONE, new ItemStack(ModItems.PURE_QUARTZ), 0.1f);
			
			for (ItemStack stack : OreDictionary.getOres("itemSilicon"))
				GameRegistry.addSmelting(ModItems.PURE_QUARTZ, stack, 0.5f);

			for (ItemStack stack : OreDictionary.getOres("ingotSilicon"))
				GameRegistry.addSmelting(ModItems.PURE_QUARTZ, stack, 0.5f);
		}
		
		GameRegistry.addSmelting(Items.ROTTEN_FLESH, new ItemStack(ModItems.LEATHER_SCRAPS), 0);
	}

	public static void registerMetaCrafting() {
		// Meta Recipes
		for (int i = 0; i < 9; i++) {
			GameRegistry.addShapelessRecipe(new ResourceLocation("PORK_BLOCK" + i), group,
					new ItemStack(Items.PORKCHOP, 9 - i),
					Ingredient.fromStacks(new ItemStack(ModBlocks.PORK_BLOCK, 1, i)));

			GameRegistry.addShapelessRecipe(new ResourceLocation("COOKED_PORK_BLOCK" + i), group,
					new ItemStack(Items.COOKED_PORKCHOP, 9 - i),
					Ingredient.fromStacks(new ItemStack(ModBlocks.COOKED_PORK_BLOCK, 1, i)));

			GameRegistry.addShapelessRecipe(new ResourceLocation("BEEF_BLOCK" + i), group, new ItemStack(Items.BEEF, 9 - i),
					Ingredient.fromStacks(new ItemStack(ModBlocks.BEEF_BLOCK, 1, i)));

			GameRegistry.addShapelessRecipe(new ResourceLocation("COOKED_BEEF_BLOCK" + i), group,
					new ItemStack(Items.COOKED_BEEF, 9 - i),
					Ingredient.fromStacks(new ItemStack(ModBlocks.COOKED_BEEF_BLOCK, 1, i)));

			GameRegistry.addShapelessRecipe(new ResourceLocation("CHICKEN_BLOCK" + i), group,
					new ItemStack(Items.CHICKEN, 9 - i),
					Ingredient.fromStacks(new ItemStack(ModBlocks.CHICKEN_BLOCK, 1, i)));

			GameRegistry.addShapelessRecipe(new ResourceLocation("COOKED_CHICKEN_BLOCK" + i), group,
					new ItemStack(Items.COOKED_CHICKEN, 9 - i),
					Ingredient.fromStacks(new ItemStack(ModBlocks.COOKED_CHICKEN_BLOCK, 1, i)));
			
			GameRegistry.addShapelessRecipe(new ResourceLocation("MUTTON_BLOCK" + i), group,
					new ItemStack(Items.MUTTON, 9 - i),
					Ingredient.fromStacks(new ItemStack(ModBlocks.MUTTON_BLOCK, 1, i)));

			GameRegistry.addShapelessRecipe(new ResourceLocation("COOKED_MUTTON_BLOCK" + i), group,
					new ItemStack(Items.COOKED_MUTTON, 9 - i),
					Ingredient.fromStacks(new ItemStack(ModBlocks.COOKED_MUTTON_BLOCK, 1, i)));
			
			GameRegistry.addShapelessRecipe(new ResourceLocation("RABBIT_BLOCK" + i), group,
					new ItemStack(Items.RABBIT, 9 - i),
					Ingredient.fromStacks(new ItemStack(ModBlocks.RABBIT_BLOCK, 1, i)));

			GameRegistry.addShapelessRecipe(new ResourceLocation("COOKED_RABBIT_BLOCK" + i), group,
					new ItemStack(Items.COOKED_RABBIT, 9 - i),
					Ingredient.fromStacks(new ItemStack(ModBlocks.COOKED_RABBIT_BLOCK, 1, i)));

			GameRegistry.addShapelessRecipe(new ResourceLocation("COD_BLOCK" + i), group,
					new ItemStack(Items.FISH, 9 - i, 1),
					Ingredient.fromStacks(new ItemStack(ModBlocks.COD_BLOCK, 1, i)));

			GameRegistry.addShapelessRecipe(new ResourceLocation("SALMON_BLOCK" + i), group,
					new ItemStack(Items.FISH, 9 - i, 1),
					Ingredient.fromStacks(new ItemStack(ModBlocks.SALMON_BLOCK, 1, i)));

			GameRegistry.addShapelessRecipe(new ResourceLocation("TROPICAL_FISH_BLOCK" + i), group,
					new ItemStack(Items.FISH, 9 - i, 2),
					Ingredient.fromStacks(new ItemStack(ModBlocks.TROPICAL_FISH_BLOCK, 1, i)));

			GameRegistry.addShapelessRecipe(new ResourceLocation("PUFFERFISH_BLOCK" + i), group,
					new ItemStack(Items.FISH, 9 - i, 3),
					Ingredient.fromStacks(new ItemStack(ModBlocks.PUFFERFISH_BLOCK, 1, i)));

			GameRegistry.addShapelessRecipe(new ResourceLocation("COOKED_COD_BLOCK" + i), group,
					new ItemStack(Items.COOKED_FISH, 9 - i, 0),
					Ingredient.fromStacks(new ItemStack(ModBlocks.COOKED_COD_BLOCK, 1, i)));

			GameRegistry.addShapelessRecipe(new ResourceLocation("COOKED_SALMON_BLOCK" + i), group,
					new ItemStack(Items.COOKED_FISH, 9 - i, 1),
					Ingredient.fromStacks(new ItemStack(ModBlocks.COOKED_SALMON_BLOCK, 1, i)));

			GameRegistry.addShapelessRecipe(new ResourceLocation("ROTTEN_FLESH_BLOCK" + i), group,
					new ItemStack(Items.ROTTEN_FLESH, 9 - i),
					Ingredient.fromStacks(new ItemStack(ModBlocks.ROTTEN_FLESH_BLOCK, 1, i)));

			GameRegistry.addShapelessRecipe(new ResourceLocation("APPLE_BLOCK" + i), group,
					new ItemStack(Items.APPLE, 9 - i),
					Ingredient.fromStacks(new ItemStack(ModBlocks.APPLE_BLOCK, 1, i)));

			GameRegistry.addShapelessRecipe(new ResourceLocation("BREAD_BLOCK" + i), group,
					new ItemStack(Items.BREAD, 9 - i),
					Ingredient.fromStacks(new ItemStack(ModBlocks.BREAD_BLOCK, 1, i)));

			GameRegistry.addShapelessRecipe(new ResourceLocation("COOKIE_BLOCK" + i), group,
					new ItemStack(Items.COOKIE, 9 - i),
					Ingredient.fromStacks(new ItemStack(ModBlocks.COOKIE_BLOCK, 1, i)));

			GameRegistry.addShapelessRecipe(new ResourceLocation("SPIDER_EYE_BLOCK" + i), group,
					new ItemStack(Items.SPIDER_EYE, 9 - i),
					Ingredient.fromStacks(new ItemStack(ModBlocks.SPIDER_EYE_BLOCK, 1, i)));

			GameRegistry.addShapelessRecipe(new ResourceLocation("CARROT_BLOCK" + i), group,
					new ItemStack(Items.CARROT, 9 - i),
					Ingredient.fromStacks(new ItemStack(ModBlocks.CARROT_BLOCK, 1, i)));

			GameRegistry.addShapelessRecipe(new ResourceLocation("POTATO_BLOCK" + i), group,
					new ItemStack(Items.POTATO, 9 - i),
					Ingredient.fromStacks(new ItemStack(ModBlocks.POTATO_BLOCK, 1, i)));

			GameRegistry.addShapelessRecipe(new ResourceLocation("BAKED_POTATO_BLOCK" + i), group,
					new ItemStack(Items.BAKED_POTATO, 9 - i),
					Ingredient.fromStacks(new ItemStack(ModBlocks.BAKED_POTATO_BLOCK, 1, i)));

			GameRegistry.addShapelessRecipe(new ResourceLocation("ENDER_PEARL_BLOCK" + i), group,
					new ItemStack(Items.ENDER_PEARL, 9 - i),
					Ingredient.fromStacks(new ItemStack(ModBlocks.ENDER_PEARL_BLOCK, 1, i)));
		}
	}
}
