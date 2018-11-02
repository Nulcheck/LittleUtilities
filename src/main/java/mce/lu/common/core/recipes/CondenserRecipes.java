package mce.lu.common.core.recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import mce.lu.common.block.ModBlocks;
import mce.lu.common.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CondenserRecipes {
	public static final CondenserRecipes base = new CondenserRecipes();
	private Map<ItemStack, ItemStack> conMap = new HashMap<ItemStack, ItemStack>();
	private Map<ItemStack, Float> expMap = new HashMap<ItemStack, Float>();

	public static CondenserRecipes instance() {
		return base;
	}

	public CondenserRecipes() {
		// Condensed Items
		this.addRecipe(new ItemStack(Items.GHAST_TEAR), new ItemStack(ModBlocks.GHAST_TEAR_BLOCK), 5f);
		this.addRecipe(new ItemStack(Items.BLAZE_ROD), new ItemStack(ModBlocks.BLAZE_ROD_BLOCK), 2f);
		this.addRecipe(new ItemStack(Items.PORKCHOP), new ItemStack(ModBlocks.PORK_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.COOKED_PORKCHOP), new ItemStack(ModBlocks.COOKED_PORK_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.BEEF), new ItemStack(ModBlocks.BEEF_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.COOKED_BEEF), new ItemStack(ModBlocks.COOKED_BEEF_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.CHICKEN), new ItemStack(ModBlocks.CHICKEN_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.COOKED_CHICKEN), new ItemStack(ModBlocks.COOKED_CHICKEN_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.MUTTON), new ItemStack(ModBlocks.MUTTON_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.COOKED_MUTTON), new ItemStack(ModBlocks.COOKED_MUTTON_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.RABBIT), new ItemStack(ModBlocks.RABBIT_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.COOKED_RABBIT), new ItemStack(ModBlocks.COOKED_RABBIT_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.FISH, 0), new ItemStack(ModBlocks.COD_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.FISH, 1), new ItemStack(ModBlocks.SALMON_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.FISH, 2), new ItemStack(ModBlocks.TROPICAL_FISH_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.FISH, 3), new ItemStack(ModBlocks.PUFFERFISH_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.COOKED_FISH, 0), new ItemStack(ModBlocks.COOKED_COD_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.COOKED_FISH, 1), new ItemStack(ModBlocks.COOKED_SALMON_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.ROTTEN_FLESH), new ItemStack(ModBlocks.ROTTEN_FLESH_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.APPLE), new ItemStack(ModBlocks.APPLE_BLOCK), 0.6f);
		this.addRecipe(new ItemStack(Items.BREAD), new ItemStack(ModBlocks.BREAD_BLOCK), 0.6f);
		this.addRecipe(new ItemStack(Items.COOKIE), new ItemStack(ModBlocks.COOKIE_BLOCK), 0.6f);
		this.addRecipe(new ItemStack(Items.SPIDER_EYE), new ItemStack(ModBlocks.SPIDER_EYE_BLOCK), 0.4f);
		this.addRecipe(new ItemStack(Items.FERMENTED_SPIDER_EYE), new ItemStack(ModBlocks.FERMENTED_SPIDER_EYE_BLOCK),
				0.5f);
		this.addRecipe(new ItemStack(Items.CARROT), new ItemStack(ModBlocks.CARROT_BLOCK), 0.2f);
		this.addRecipe(new ItemStack(Items.POTATO), new ItemStack(ModBlocks.POTATO_BLOCK), 0.2f);
		this.addRecipe(new ItemStack(Items.BAKED_POTATO), new ItemStack(ModBlocks.BAKED_POTATO_BLOCK), 0.2f);
		this.addRecipe(new ItemStack(Items.GUNPOWDER), new ItemStack(ModBlocks.GUNPOWDER_BLOCK), 0.3f);
		this.addRecipe(new ItemStack(Items.FLINT), new ItemStack(ModBlocks.FLINT_BLOCK), 0.3f);
		this.addRecipe(new ItemStack(Items.NETHER_STAR), new ItemStack(ModBlocks.NETHER_STAR_BLOCK), 10f);
		this.addRecipe(new ItemStack(Items.PAPER), new ItemStack(ModBlocks.PAPER_BLOCK), 0.4f);
		this.addRecipe(new ItemStack(Items.ENDER_PEARL), new ItemStack(ModBlocks.ENDER_PEARL_BLOCK), 4f);
		this.addRecipe(new ItemStack(Items.ENDER_EYE), new ItemStack(ModBlocks.ENDER_EYE_BLOCK), 5f);
		this.addRecipe(new ItemStack(Items.MAGMA_CREAM), new ItemStack(ModBlocks.MAGMA_CREAM_BLOCK), 2f);
		this.addRecipe(new ItemStack(Items.FEATHER), new ItemStack(ModBlocks.FEATHER_BLOCK), 0.3f);
		this.addRecipe(new ItemStack(Items.EGG), new ItemStack(ModBlocks.EGG_BLOCK), 0.3f);
		this.addRecipe(new ItemStack(Items.SUGAR), new ItemStack(ModBlocks.SUGAR_BLOCK), 0.3f);
		this.addRecipe(new ItemStack(ModItems.SPONGE), new ItemStack(Blocks.SPONGE), 0.5f);

		// Vanilla Stuff (Idk why you'd use this.)
		this.addRecipe(new ItemStack(Items.COAL, 1, 0), new ItemStack(Blocks.COAL_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.IRON_INGOT), new ItemStack(Blocks.IRON_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.GOLD_INGOT), new ItemStack(Blocks.GOLD_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.DYE, 1, 4), new ItemStack(Blocks.LAPIS_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.DIAMOND), new ItemStack(Blocks.DIAMOND_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.EMERALD), new ItemStack(Blocks.EMERALD_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.REDSTONE), new ItemStack(Blocks.REDSTONE_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.SNOWBALL), new ItemStack(Blocks.SNOW), 0.5f);
		this.addRecipe(new ItemStack(Items.SLIME_BALL), new ItemStack(Blocks.SLIME_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.BONE), new ItemStack(Blocks.BONE_BLOCK), 0.3f);
		this.addRecipe(new ItemStack(Items.STRING), new ItemStack(Blocks.WOOL, 1, 0), 0.3f);
		this.addRecipe(new ItemStack(Items.WHEAT), new ItemStack(Blocks.HAY_BLOCK), 0.3f);
		this.addRecipe(new ItemStack(Items.MELON), new ItemStack(Blocks.MELON_BLOCK), 0.3f);
		this.addRecipe(new ItemStack(Items.NETHERBRICK), new ItemStack(Blocks.NETHER_BRICK), 0.3f);
		this.addRecipe(new ItemStack(Items.NETHER_WART), new ItemStack(Blocks.NETHER_WART_BLOCK), 0.3f);
		this.addRecipe(new ItemStack(Items.QUARTZ), new ItemStack(Blocks.QUARTZ_BLOCK), 0.3f);
		this.addRecipe(new ItemStack(Items.GLOWSTONE_DUST), new ItemStack(Blocks.GLOWSTONE), 0.3f);
		this.addRecipe(new ItemStack(Items.PRISMARINE_CRYSTALS), new ItemStack(Blocks.SEA_LANTERN), 0.3f);
		this.addRecipe(new ItemStack(Items.PRISMARINE_SHARD), new ItemStack(Blocks.PRISMARINE, 1, 0), 0.3f);
		this.addRecipe(new ItemStack(Blocks.ICE), new ItemStack(Blocks.PACKED_ICE), 0.3f);
		this.addRecipe(new ItemStack(Blocks.SAND, 1, 0), new ItemStack(Blocks.SANDSTONE, 1, 0), 0.5f);
		this.addRecipe(new ItemStack(Blocks.SAND, 1, 1), new ItemStack(Blocks.SANDSTONE, 1, 1), 0.5f);

		// Compact Blocks
		this.addRecipe(new ItemStack(Blocks.COBBLESTONE), new ItemStack(ModBlocks.COMPACT_COBBLE), 0.1f);
		this.addRecipe(new ItemStack(Blocks.DIRT), new ItemStack(ModBlocks.COMPACT_DIRT), 0.1f);
		this.addRecipe(new ItemStack(Blocks.GRASS), new ItemStack(ModBlocks.COMPACT_DIRT), 0.1f);
		this.addRecipe(new ItemStack(Blocks.GRASS_PATH), new ItemStack(ModBlocks.COMPACT_DIRT), 0.1f);
		this.addRecipe(new ItemStack(Blocks.GRAVEL), new ItemStack(ModBlocks.COMPACT_GRAVEL), 0.1f);
		this.addRecipe(new ItemStack(Blocks.NETHERRACK), new ItemStack(ModBlocks.COMPACT_NETHERRACK), 0.2f);
	}

	/**
	 * No XP given from recipe if this is used!
	 * 
	 * @param in
	 * @param out
	 */
	public void addRecipe(ItemStack in, ItemStack out) {
		this.addRecipe(in, out, 0f);
	}

	/**
	 * 
	 * @param in
	 * @param out
	 * @param exp
	 */
	public void addRecipe(ItemStack in, ItemStack out, float exp) {
		this.conMap.put(in, out);
		this.expMap.put(out, Float.valueOf(exp));
	}

	public ItemStack getInput(ItemStack stack) {
		Iterator<Entry<ItemStack, ItemStack>> iter = this.conMap.entrySet().iterator();
		Entry<ItemStack, ItemStack> entry;

		do {
			if (!iter.hasNext()) {
				return null;
			}

			entry = iter.next();
		} while (!this.input(stack, entry.getKey()));

		return stack;
	}

	private boolean input(ItemStack in, ItemStack out) {
		return in.getItem() == out.getItem();
	}

	public ItemStack getCondensingResult(ItemStack stack) {
		Iterator<Entry<ItemStack, ItemStack>> iter = this.conMap.entrySet().iterator();
		Entry<ItemStack, ItemStack> entry;

		do {
			if (!iter.hasNext()) {
				return null;
			}

			entry = iter.next();
		} while (!this.output(stack, entry.getKey()));

		return entry.getValue();
	}

	private boolean output(ItemStack in, ItemStack out) {
		return out.getItem() == in.getItem();
	}

	public Map<ItemStack, ItemStack> getRecipeList() {
		return this.conMap;
	}

	public static boolean isRecipe(ItemStack input) {
		return instance().getCondensingResult(input) != null;
	}

	public float expHandling(ItemStack stack) {
		float ret = stack.getItem().getSmeltingExperience(stack);
		if (ret != -1)
			return ret;

		Iterator<Entry<ItemStack, Float>> iter = this.expMap.entrySet().iterator();
		Entry<ItemStack, Float> entry;

		do {
			if (!iter.hasNext()) {
				return 0.0F;
			}

			entry = iter.next();
		} while (!this.output(stack, (ItemStack) entry.getKey()));

		return ((Float) entry.getValue()).floatValue();
	}
}
