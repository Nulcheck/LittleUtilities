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
	private final Map<ItemStack, Float> xpMap = Maps.<ItemStack, Float>newHashMap();

	public static CondenserRecipes instance() { return base; }
	
	public CondenserRecipes() {
		// Condensed Items
		this.addRecipe(new ItemStack(Items.GHAST_TEAR, 9), new ItemStack(ModBlocks.GHAST_TEAR_BLOCK), 5f);
		this.addRecipe(new ItemStack(Items.BLAZE_ROD, 9), new ItemStack(ModBlocks.BLAZE_ROD_BLOCK), 2f);
		this.addRecipe(new ItemStack(Items.PORKCHOP, 9), new ItemStack(ModBlocks.PORK_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.COOKED_PORKCHOP, 9), new ItemStack(ModBlocks.COOKED_PORK_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.BEEF, 9), new ItemStack(ModBlocks.BEEF_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.COOKED_BEEF, 9), new ItemStack(ModBlocks.COOKED_BEEF_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.CHICKEN, 9), new ItemStack(ModBlocks.CHICKEN_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.COOKED_CHICKEN, 9), new ItemStack(ModBlocks.COOKED_CHICKEN_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.MUTTON, 9), new ItemStack(ModBlocks.MUTTON_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.COOKED_MUTTON, 9), new ItemStack(ModBlocks.COOKED_MUTTON_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.RABBIT, 9), new ItemStack(ModBlocks.RABBIT_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.COOKED_RABBIT, 9), new ItemStack(ModBlocks.COOKED_RABBIT_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.FISH, 9, 0), new ItemStack(ModBlocks.COD_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.FISH, 9, 1), new ItemStack(ModBlocks.SALMON_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.FISH, 9, 2), new ItemStack(ModBlocks.TROPICAL_FISH_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.FISH, 9, 3), new ItemStack(ModBlocks.PUFFERFISH_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.COOKED_FISH, 9, 0), new ItemStack(ModBlocks.COOKED_COD_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.COOKED_FISH, 9, 1), new ItemStack(ModBlocks.COOKED_SALMON_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.ROTTEN_FLESH, 9), new ItemStack(ModBlocks.ROTTEN_FLESH_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.APPLE, 9), new ItemStack(ModBlocks.APPLE_BLOCK), 0.6f);
		this.addRecipe(new ItemStack(Items.BREAD, 9), new ItemStack(ModBlocks.BREAD_BLOCK), 0.6f);
		this.addRecipe(new ItemStack(Items.COOKIE, 9), new ItemStack(ModBlocks.COOKIE_BLOCK), 0.6f);
		this.addRecipe(new ItemStack(Items.SPIDER_EYE, 9), new ItemStack(ModBlocks.SPIDER_EYE_BLOCK), 0.4f);
		this.addRecipe(new ItemStack(Items.FERMENTED_SPIDER_EYE, 9), new ItemStack(ModBlocks.FERMENTED_SPIDER_EYE_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.CARROT, 9), new ItemStack(ModBlocks.CARROT_BLOCK), 0.2f);
		this.addRecipe(new ItemStack(Items.POTATO, 9), new ItemStack(ModBlocks.POTATO_BLOCK), 0.2f);
		this.addRecipe(new ItemStack(Items.BAKED_POTATO, 9), new ItemStack(ModBlocks.BAKED_POTATO_BLOCK), 0.2f);
		this.addRecipe(new ItemStack(Items.GUNPOWDER, 9), new ItemStack(ModBlocks.GUNPOWDER_BLOCK), 0.3f);
		this.addRecipe(new ItemStack(Items.FLINT, 9), new ItemStack(ModBlocks.FLINT_BLOCK), 0.3f);
		this.addRecipe(new ItemStack(Items.NETHER_STAR, 9), new ItemStack(ModBlocks.NETHER_STAR_BLOCK), 10f);
		this.addRecipe(new ItemStack(Items.PAPER, 9), new ItemStack(ModBlocks.PAPER_BLOCK), 0.4f);
		this.addRecipe(new ItemStack(Items.ENDER_PEARL, 9), new ItemStack(ModBlocks.ENDER_PEARL_BLOCK), 4f);
		this.addRecipe(new ItemStack(Items.ENDER_EYE, 9), new ItemStack(ModBlocks.ENDER_EYE_BLOCK), 5f);
		this.addRecipe(new ItemStack(Items.MAGMA_CREAM, 9), new ItemStack(ModBlocks.MAGMA_CREAM_BLOCK), 2f);
		this.addRecipe(new ItemStack(Items.FEATHER, 9), new ItemStack(ModBlocks.FEATHER_BLOCK), 0.3f);
		this.addRecipe(new ItemStack(Items.EGG, 9), new ItemStack(ModBlocks.EGG_BLOCK), 0.3f);
		this.addRecipe(new ItemStack(Items.SUGAR, 9), new ItemStack(ModBlocks.SUGAR_BLOCK), 0.3f);
		this.addRecipe(new ItemStack(ModItems.SPONGE, 9), new ItemStack(Blocks.SPONGE), 0.5f);

		// Vanilla Stuff (Idk why you'd use this.)
		this.addRecipe(new ItemStack(Items.COAL, 9, 0), new ItemStack(Blocks.COAL_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.IRON_INGOT, 9), new ItemStack(Blocks.IRON_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.GOLD_INGOT, 9), new ItemStack(Blocks.GOLD_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.DYE, 9, 4), new ItemStack(Blocks.LAPIS_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.DIAMOND, 9), new ItemStack(Blocks.DIAMOND_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.EMERALD, 9), new ItemStack(Blocks.EMERALD_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.REDSTONE, 9), new ItemStack(Blocks.REDSTONE_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.SNOWBALL, 9), new ItemStack(Blocks.SNOW), 0.5f);
		this.addRecipe(new ItemStack(Items.SLIME_BALL, 9), new ItemStack(Blocks.SLIME_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.BONE, 9), new ItemStack(Blocks.BONE_BLOCK), 0.3f);
		this.addRecipe(new ItemStack(Items.STRING, 9), new ItemStack(Blocks.WOOL, 1, 0), 0.3f);
		this.addRecipe(new ItemStack(Items.WHEAT, 9), new ItemStack(Blocks.HAY_BLOCK), 0.3f);
		this.addRecipe(new ItemStack(Items.MELON, 9), new ItemStack(Blocks.MELON_BLOCK), 0.3f);
		this.addRecipe(new ItemStack(Items.NETHERBRICK, 9), new ItemStack(Blocks.NETHER_BRICK), 0.3f);
		this.addRecipe(new ItemStack(Items.NETHER_WART, 9), new ItemStack(Blocks.NETHER_WART_BLOCK), 0.3f);
		this.addRecipe(new ItemStack(Items.QUARTZ, 9), new ItemStack(Blocks.QUARTZ_BLOCK), 0.3f);
		this.addRecipe(new ItemStack(Items.GLOWSTONE_DUST, 9), new ItemStack(Blocks.GLOWSTONE), 0.3f);
		this.addRecipe(new ItemStack(Items.PRISMARINE_CRYSTALS, 9), new ItemStack(Blocks.SEA_LANTERN), 0.3f);
		this.addRecipe(new ItemStack(Items.PRISMARINE_SHARD, 9), new ItemStack(Blocks.PRISMARINE, 1, 0), 0.3f);
		this.addRecipe(new ItemStack(Blocks.ICE, 9), new ItemStack(Blocks.PACKED_ICE), 0.3f);
		this.addRecipe(new ItemStack(Blocks.SAND, 9, 0), new ItemStack(Blocks.SANDSTONE, 1, 0), 0.5f);
		this.addRecipe(new ItemStack(Blocks.SAND, 9, 1), new ItemStack(Blocks.SANDSTONE, 1, 1), 0.5f);

		// Compact Blocks
		this.addRecipe(new ItemStack(Blocks.COBBLESTONE, 9), new ItemStack(ModBlocks.COMPACT_COBBLE), 0.1f);
		this.addRecipe(new ItemStack(Blocks.DIRT, 9), new ItemStack(ModBlocks.COMPACT_DIRT), 0.1f);
		this.addRecipe(new ItemStack(Blocks.GRASS, 9), new ItemStack(ModBlocks.COMPACT_DIRT), 0.1f);
		this.addRecipe(new ItemStack(Blocks.GRASS_PATH, 9), new ItemStack(ModBlocks.COMPACT_DIRT), 0.1f);
		this.addRecipe(new ItemStack(Blocks.GRAVEL, 9), new ItemStack(ModBlocks.COMPACT_GRAVEL), 0.1f);
		this.addRecipe(new ItemStack(Blocks.NETHERRACK, 9), new ItemStack(ModBlocks.COMPACT_NETHERRACK), 0.2f);
	}

	/**
	 * Adds a recipe to the condenser.
	 * 
	 * @param stackIn
	 * @param amount
	 * @param metadata
	 * @param out
	 * @param XP
	 */
	public void addRecipe(ItemStack stackIn, ItemStack stackOut, float XP) {
		recipeMap.put(stackIn, stackOut);
		xpMap.put(stackOut, Float.valueOf(XP));
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

	/**
	 * Return experience you get from a recipe.
	 * 
	 * @param stack
	 * @return float
	 */
	public float getRecipeExperience(ItemStack stack) {
		float ret = stack.getItem().getSmeltingExperience(stack);
		if (ret != -1)
			return ret;

		for (Entry<ItemStack, Float> entry : xpMap.entrySet()) {
			if (compareStacks(stack, entry.getKey()))
				return ((Float) entry.getValue()).floatValue();
		}

		return 0f;
	}
}
