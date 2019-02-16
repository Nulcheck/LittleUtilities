package mce.lu.common.core.recipes;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

import mce.lu.common.block.ModBlocks;
import mce.lu.common.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CondenserRecipes {
	public static final CondenserRecipes base = new CondenserRecipes();
	private final Map<ItemStack, ItemStack> recipeMap = Maps.<ItemStack, ItemStack>newHashMap();

	public static CondenserRecipes instance() {
		return base;
	}

	public CondenserRecipes() {
		// Condensed Items
		this.addRecipe(new ItemStack(Items.GHAST_TEAR, 9), new ItemStack(ModBlocks.GHAST_TEAR_BLOCK));
		this.addRecipe(new ItemStack(Items.BLAZE_ROD, 9), new ItemStack(ModBlocks.BLAZE_ROD_BLOCK));
		this.addRecipe(new ItemStack(Items.PORKCHOP, 9), new ItemStack(ModBlocks.PORK_BLOCK));
		this.addRecipe(new ItemStack(Items.COOKED_PORKCHOP, 9), new ItemStack(ModBlocks.COOKED_PORK_BLOCK));
		this.addRecipe(new ItemStack(Items.BEEF, 9), new ItemStack(ModBlocks.BEEF_BLOCK));
		this.addRecipe(new ItemStack(Items.COOKED_BEEF, 9), new ItemStack(ModBlocks.COOKED_BEEF_BLOCK));
		this.addRecipe(new ItemStack(Items.CHICKEN, 9), new ItemStack(ModBlocks.CHICKEN_BLOCK));
		this.addRecipe(new ItemStack(Items.COOKED_CHICKEN, 9), new ItemStack(ModBlocks.COOKED_CHICKEN_BLOCK));
		this.addRecipe(new ItemStack(Items.MUTTON, 9), new ItemStack(ModBlocks.MUTTON_BLOCK));
		this.addRecipe(new ItemStack(Items.COOKED_MUTTON, 9), new ItemStack(ModBlocks.COOKED_MUTTON_BLOCK));
		this.addRecipe(new ItemStack(Items.RABBIT, 9), new ItemStack(ModBlocks.RABBIT_BLOCK));
		this.addRecipe(new ItemStack(Items.COOKED_RABBIT, 9), new ItemStack(ModBlocks.COOKED_RABBIT_BLOCK));
		this.addRecipe(new ItemStack(Items.FISH, 9, 0), new ItemStack(ModBlocks.COD_BLOCK));
		this.addRecipe(new ItemStack(Items.FISH, 9, 1), new ItemStack(ModBlocks.SALMON_BLOCK));
		this.addRecipe(new ItemStack(Items.FISH, 9, 2), new ItemStack(ModBlocks.TROPICAL_FISH_BLOCK));
		this.addRecipe(new ItemStack(Items.FISH, 9, 3), new ItemStack(ModBlocks.PUFFERFISH_BLOCK));
		this.addRecipe(new ItemStack(Items.COOKED_FISH, 9, 0), new ItemStack(ModBlocks.COOKED_COD_BLOCK));
		this.addRecipe(new ItemStack(Items.COOKED_FISH, 9, 1), new ItemStack(ModBlocks.COOKED_SALMON_BLOCK));
		this.addRecipe(new ItemStack(Items.ROTTEN_FLESH, 9), new ItemStack(ModBlocks.ROTTEN_FLESH_BLOCK));
		this.addRecipe(new ItemStack(Items.APPLE, 9), new ItemStack(ModBlocks.APPLE_BLOCK));
		this.addRecipe(new ItemStack(Items.BREAD, 9), new ItemStack(ModBlocks.BREAD_BLOCK));
		this.addRecipe(new ItemStack(Items.COOKIE, 9), new ItemStack(ModBlocks.COOKIE_BLOCK));
		this.addRecipe(new ItemStack(Items.SPIDER_EYE, 9), new ItemStack(ModBlocks.SPIDER_EYE_BLOCK));
		this.addRecipe(new ItemStack(Items.FERMENTED_SPIDER_EYE, 9),
				new ItemStack(ModBlocks.FERMENTED_SPIDER_EYE_BLOCK));
		this.addRecipe(new ItemStack(Items.CARROT, 9), new ItemStack(ModBlocks.CARROT_BLOCK));
		this.addRecipe(new ItemStack(Items.POTATO, 9), new ItemStack(ModBlocks.POTATO_BLOCK));
		this.addRecipe(new ItemStack(Items.BAKED_POTATO, 9), new ItemStack(ModBlocks.BAKED_POTATO_BLOCK));
		this.addRecipe(new ItemStack(Items.GUNPOWDER, 9), new ItemStack(ModBlocks.GUNPOWDER_BLOCK));
		this.addRecipe(new ItemStack(Items.FLINT, 9), new ItemStack(ModBlocks.FLINT_BLOCK));
		this.addRecipe(new ItemStack(Items.NETHER_STAR, 9), new ItemStack(ModBlocks.NETHER_STAR_BLOCK));
		this.addRecipe(new ItemStack(Items.PAPER, 9), new ItemStack(ModBlocks.PAPER_BLOCK));
		this.addRecipe(new ItemStack(Items.ENDER_PEARL, 9), new ItemStack(ModBlocks.ENDER_PEARL_BLOCK));
		this.addRecipe(new ItemStack(Items.ENDER_EYE, 9), new ItemStack(ModBlocks.ENDER_EYE_BLOCK));
		this.addRecipe(new ItemStack(Items.MAGMA_CREAM, 9), new ItemStack(ModBlocks.MAGMA_CREAM_BLOCK));
		this.addRecipe(new ItemStack(Items.FEATHER, 9), new ItemStack(ModBlocks.FEATHER_BLOCK));
		this.addRecipe(new ItemStack(Items.EGG, 9), new ItemStack(ModBlocks.EGG_BLOCK));
		this.addRecipe(new ItemStack(Items.SUGAR, 9), new ItemStack(ModBlocks.SUGAR_BLOCK));
		this.addRecipe(new ItemStack(Items.BONE, 9), new ItemStack(ModBlocks.BONE_BLOCK));
		this.addRecipe(new ItemStack(ModItems.SPONGE, 9), new ItemStack(Blocks.SPONGE));
		this.addRecipe(new ItemStack(ModItems.PURE_QUARTZ, 9), new ItemStack(ModBlocks.PURE_QUARTZ_BLOCK));
		this.addRecipe(new ItemStack(Items.DYE, 9, 0), new ItemStack(ModBlocks.DYE_BLACK_BLOCK));
		this.addRecipe(new ItemStack(Items.DYE, 9, 1), new ItemStack(ModBlocks.DYE_RED_BLOCK));
		this.addRecipe(new ItemStack(Items.DYE, 9, 2), new ItemStack(ModBlocks.DYE_GREEN_BLOCK));
		this.addRecipe(new ItemStack(Items.DYE, 9, 3), new ItemStack(ModBlocks.DYE_BROWN_BLOCK));
		this.addRecipe(new ItemStack(Items.DYE, 9, 5), new ItemStack(ModBlocks.DYE_PURPLE_BLOCK));
		this.addRecipe(new ItemStack(Items.DYE, 9, 6), new ItemStack(ModBlocks.DYE_CYAN_BLOCK));
		this.addRecipe(new ItemStack(Items.DYE, 9, 7), new ItemStack(ModBlocks.DYE_LIGHT_GRAY_BLOCK));
		this.addRecipe(new ItemStack(Items.DYE, 9, 8), new ItemStack(ModBlocks.DYE_GRAY_BLOCK));
		this.addRecipe(new ItemStack(Items.DYE, 9, 9), new ItemStack(ModBlocks.DYE_PINK_BLOCK));
		this.addRecipe(new ItemStack(Items.DYE, 9, 10), new ItemStack(ModBlocks.DYE_LIME_BLOCK));
		this.addRecipe(new ItemStack(Items.DYE, 9, 11), new ItemStack(ModBlocks.DYE_YELLOW_BLOCK));
		this.addRecipe(new ItemStack(Items.DYE, 9, 12), new ItemStack(ModBlocks.DYE_LIGHT_BLUE_BLOCK));
		this.addRecipe(new ItemStack(Items.DYE, 9, 13), new ItemStack(ModBlocks.DYE_MAGENTA_BLOCK));
		this.addRecipe(new ItemStack(Items.DYE, 9, 14), new ItemStack(ModBlocks.DYE_ORANGE_BLOCK));
		this.addRecipe(new ItemStack(ModItems.PIGMENT_BLACK, 9), new ItemStack(ModBlocks.PIGMENT_BLACK_BLOCK));
		this.addRecipe(new ItemStack(ModItems.PIGMENT_RED, 9), new ItemStack(ModBlocks.PIGMENT_RED_BLOCK));
		this.addRecipe(new ItemStack(ModItems.PIGMENT_GREEN, 9), new ItemStack(ModBlocks.PIGMENT_GREEN_BLOCK));
		this.addRecipe(new ItemStack(ModItems.PIGMENT_BROWN, 9), new ItemStack(ModBlocks.PIGMENT_BROWN_BLOCK));
		this.addRecipe(new ItemStack(ModItems.PIGMENT_BLUE, 9), new ItemStack(ModBlocks.PIGMENT_BLUE_BLOCK));
		this.addRecipe(new ItemStack(ModItems.PIGMENT_PURPLE, 9), new ItemStack(ModBlocks.PIGMENT_PURPLE_BLOCK));
		this.addRecipe(new ItemStack(ModItems.PIGMENT_CYAN, 9), new ItemStack(ModBlocks.PIGMENT_CYAN_BLOCK));
		this.addRecipe(new ItemStack(ModItems.PIGMENT_LIGHT_GRAY, 9),
				new ItemStack(ModBlocks.PIGMENT_LIGHT_GRAY_BLOCK));
		this.addRecipe(new ItemStack(ModItems.PIGMENT_GRAY, 9), new ItemStack(ModBlocks.PIGMENT_GRAY_BLOCK));
		this.addRecipe(new ItemStack(ModItems.PIGMENT_PINK, 9), new ItemStack(ModBlocks.PIGMENT_PINK_BLOCK));
		this.addRecipe(new ItemStack(ModItems.PIGMENT_LIME, 9), new ItemStack(ModBlocks.PIGMENT_LIME_BLOCK));
		this.addRecipe(new ItemStack(ModItems.PIGMENT_YELLOW, 9), new ItemStack(ModBlocks.PIGMENT_YELLOW_BLOCK));
		this.addRecipe(new ItemStack(ModItems.PIGMENT_LIGHT_BLUE, 9),
				new ItemStack(ModBlocks.PIGMENT_LIGHT_BLUE_BLOCK));
		this.addRecipe(new ItemStack(ModItems.PIGMENT_MAGENTA, 9), new ItemStack(ModBlocks.PIGMENT_MAGENTA_BLOCK));
		this.addRecipe(new ItemStack(ModItems.PIGMENT_ORANGE, 9), new ItemStack(ModBlocks.PIGMENT_ORANGE_BLOCK));
		this.addRecipe(new ItemStack(ModItems.PIGMENT_WHITE, 9), new ItemStack(ModBlocks.PIGMENT_WHITE_BLOCK));
		this.addRecipe(new ItemStack(Items.GOLDEN_APPLE, 9, 0), new ItemStack(ModBlocks.GOLDEN_APPLE_BLOCK));
		this.addRecipe(new ItemStack(Items.GOLDEN_APPLE, 9, 1), new ItemStack(ModBlocks.NOTCH_APPLE_BLOCK));
		this.addRecipe(new ItemStack(Items.GOLDEN_CARROT, 9), new ItemStack(ModBlocks.GOLDEN_CARROT_BLOCK));
		this.addRecipe(new ItemStack(Items.SPECKLED_MELON, 9), new ItemStack(ModBlocks.GLISTERING_MELON));
		this.addRecipe(new ItemStack(Items.COAL, 9, 1), new ItemStack(ModBlocks.CHARCOAL_BLOCK));
		this.addRecipe(new ItemStack(Items.BLAZE_POWDER), new ItemStack(ModBlocks.BLAZE_POWDER_BLOCK));
		this.addRecipe(new ItemStack(Items.POISONOUS_POTATO, 9), new ItemStack(ModBlocks.POISONOUS_POTATO_BLOCK));
		this.addRecipe(new ItemStack(Items.BEETROOT, 9), new ItemStack(ModBlocks.BEETROOT_BLOCK));
		
		this.addRecipe(new ItemStack(ModItems.CACTUS_FIBER, 9), new ItemStack(ModItems.CACTUS_TWINE));
		this.addRecipe(new ItemStack(ModItems.CACTUS_TWINE, 9), new ItemStack(Items.STRING));

		// Vanilla Stuff (Idk why you'd use this.)
		this.addRecipe(new ItemStack(Items.COAL, 9, 0), new ItemStack(Blocks.COAL_BLOCK));
		this.addRecipe(new ItemStack(Items.IRON_INGOT, 9), new ItemStack(Blocks.IRON_BLOCK));
		this.addRecipe(new ItemStack(Items.GOLD_INGOT, 9), new ItemStack(Blocks.GOLD_BLOCK));
		this.addRecipe(new ItemStack(Items.DYE, 9, 4), new ItemStack(Blocks.LAPIS_BLOCK));
		this.addRecipe(new ItemStack(Items.DIAMOND, 9), new ItemStack(Blocks.DIAMOND_BLOCK));
		this.addRecipe(new ItemStack(Items.EMERALD, 9), new ItemStack(Blocks.EMERALD_BLOCK));
		this.addRecipe(new ItemStack(Items.REDSTONE, 9), new ItemStack(Blocks.REDSTONE_BLOCK));
		this.addRecipe(new ItemStack(Items.SNOWBALL, 9), new ItemStack(Blocks.SNOW));
		this.addRecipe(new ItemStack(Items.SLIME_BALL, 9), new ItemStack(Blocks.SLIME_BLOCK));
		this.addRecipe(new ItemStack(Items.DYE, 9, 15), new ItemStack(Blocks.BONE_BLOCK));
		this.addRecipe(new ItemStack(Items.STRING, 9), new ItemStack(Blocks.WOOL, 1, 0));
		this.addRecipe(new ItemStack(Items.WHEAT, 9), new ItemStack(Blocks.HAY_BLOCK));
		this.addRecipe(new ItemStack(Items.MELON, 9), new ItemStack(Blocks.MELON_BLOCK));
		this.addRecipe(new ItemStack(Items.NETHERBRICK, 9), new ItemStack(Blocks.NETHER_BRICK));
		this.addRecipe(new ItemStack(Items.NETHER_WART, 9), new ItemStack(Blocks.NETHER_WART_BLOCK));
		this.addRecipe(new ItemStack(Items.QUARTZ, 9), new ItemStack(Blocks.QUARTZ_BLOCK));
		this.addRecipe(new ItemStack(Items.GLOWSTONE_DUST, 9), new ItemStack(Blocks.GLOWSTONE));
		this.addRecipe(new ItemStack(Items.PRISMARINE_CRYSTALS, 9), new ItemStack(Blocks.SEA_LANTERN));
		this.addRecipe(new ItemStack(Items.PRISMARINE_SHARD, 9), new ItemStack(Blocks.PRISMARINE, 1, 0));
		this.addRecipe(new ItemStack(Blocks.ICE, 9), new ItemStack(Blocks.PACKED_ICE));
		this.addRecipe(new ItemStack(Blocks.SAND, 9, 0), new ItemStack(Blocks.SANDSTONE, 1, 0));
		this.addRecipe(new ItemStack(Blocks.SAND, 9, 1), new ItemStack(Blocks.SANDSTONE, 1, 1));
		this.addRecipe(new ItemStack(Blocks.BROWN_MUSHROOM, 9, 0), new ItemStack(Blocks.BROWN_MUSHROOM_BLOCK));
		this.addRecipe(new ItemStack(Blocks.RED_MUSHROOM, 9, 0), new ItemStack(Blocks.RED_MUSHROOM_BLOCK));

		// Compact Blocks
		this.addRecipe(new ItemStack(Blocks.COBBLESTONE, 9), new ItemStack(ModBlocks.COMPACT_COBBLE));
		this.addRecipe(new ItemStack(Blocks.DIRT, 9), new ItemStack(ModBlocks.COMPACT_DIRT));
		this.addRecipe(new ItemStack(Blocks.GRASS, 9), new ItemStack(ModBlocks.COMPACT_DIRT));
		this.addRecipe(new ItemStack(Blocks.GRASS_PATH, 9), new ItemStack(ModBlocks.COMPACT_DIRT));
		this.addRecipe(new ItemStack(Blocks.GRAVEL, 9), new ItemStack(ModBlocks.COMPACT_GRAVEL));
		this.addRecipe(new ItemStack(Blocks.NETHERRACK, 9), new ItemStack(ModBlocks.COMPACT_NETHERRACK));
		this.addRecipe(new ItemStack(Blocks.DRAGON_EGG, 9), new ItemStack(ModBlocks.COMPACT_DRAGON_EGG));
		this.addRecipe(new ItemStack(Blocks.STONE, 9, 1), new ItemStack(ModBlocks.COMPACT_GRANITE));
		this.addRecipe(new ItemStack(Blocks.STONE, 9, 3), new ItemStack(ModBlocks.COMPACT_DIORITE));
		this.addRecipe(new ItemStack(Blocks.STONE, 9, 5), new ItemStack(ModBlocks.COMPACT_ANDESITE));
		this.addRecipe(new ItemStack(Blocks.SOUL_SAND, 9), new ItemStack(ModBlocks.COMPACT_SOUL_SAND));
		this.addRecipe(new ItemStack(Blocks.OBSIDIAN, 9), new ItemStack(ModBlocks.COMPACT_OBSIDIAN));
	}

	/**
	 * Adds a recipe to the condenser.
	 * 
	 * @param stackIn
	 * @param amount
	 * @param metadata
	 * @param out
	 */
	public void addRecipe(ItemStack stackIn, ItemStack stackOut) {
		recipeMap.put(stackIn, stackOut);
	}

	/**
	 * Returns recipe result of an item.
	 * 
	 * @param stack
	 * @return ItemStack
	 */
	public ItemStack getRecipeResult(ItemStack stack) {
		for (Entry<ItemStack, ItemStack> entry : recipeMap.entrySet()) {
			if (compareStacks(stack, entry.getKey()))
				return entry.getValue();
		}

		return ItemStack.EMPTY;
	}

	/**
	 * Compares two itemstacks to ensure they are the same. Both item and meta.
	 * 
	 * @param stack1
	 * @param stack2
	 * @return boolean
	 */
	private boolean compareStacks(ItemStack stack1, ItemStack stack2) {
		return stack2.getItem() == stack1.getItem()
				&& (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}

	public Map<ItemStack, ItemStack> getRecipeList() {
		return recipeMap;
	}

	/**
	 * This is for the slot validator, to check if an item is apart of a recipe.
	 * 
	 * @param inputStack
	 * @return boolean
	 */
	public static boolean isRecipe(ItemStack input) {
		return instance().getRecipeResult(input) != null;
	}
}
