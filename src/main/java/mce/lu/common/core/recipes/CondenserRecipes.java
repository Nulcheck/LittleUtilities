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

	public static CondenserRecipes condensing() {
		return base;
	}

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
		this.addRecipe(new ItemStack(Items.FERMENTED_SPIDER_EYE, 9),
				new ItemStack(ModBlocks.FERMENTED_SPIDER_EYE_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.CARROT, 9), new ItemStack(ModBlocks.CARROT_BLOCK), 0.2f);
		this.addRecipe(new ItemStack(Items.POTATO, 9), new ItemStack(ModBlocks.POTATO_BLOCK), 0.2f);
		this.addRecipe(new ItemStack(Items.BAKED_POTATO, 9), new ItemStack(ModBlocks.BAKED_POTATO_BLOCK), 0.2f);
		this.addRecipe(new ItemStack(Items.GUNPOWDER, 9), new ItemStack(ModBlocks.GUNPOWDER_BLOCK), 0.3f);
		this.addRecipe(new ItemStack(Items.FLINT, 9), new ItemStack(ModBlocks.FLINT_BLOCK), 0.3f);
		this.addRecipe(new ItemStack(Items.NETHER_STAR, 9), new ItemStack(ModBlocks.NETHER_STAR_BLOCK), 10f);
		this.addRecipe(new ItemStack(Items.PAPER, 9), new ItemStack(ModBlocks.PAPER_BLOCK), 0.4f);
		this.addRecipe(new ItemStack(Items.SLIME_BALL, 9), new ItemStack(Blocks.SLIME_BLOCK), 0.5f);
		this.addRecipe(new ItemStack(Items.ENDER_PEARL, 9), new ItemStack(ModBlocks.ENDER_PEARL_BLOCK), 4f);
		this.addRecipe(new ItemStack(Items.ENDER_EYE, 9), new ItemStack(ModBlocks.ENDER_EYE_BLOCK), 5f);
		this.addRecipe(new ItemStack(Items.BONE, 9), new ItemStack(Blocks.BONE_BLOCK), 0.3f);
		this.addRecipe(new ItemStack(Items.MAGMA_CREAM, 9), new ItemStack(ModBlocks.MAGMA_CREAM_BLOCK), 2f);
		this.addRecipe(new ItemStack(Items.FEATHER, 9), new ItemStack(ModBlocks.FEATHER_BLOCK), 0.3f);
		this.addRecipe(new ItemStack(Items.EGG, 9), new ItemStack(ModBlocks.EGG_BLOCK), 0.3f);
		this.addRecipe(new ItemStack(Items.SUGAR, 9), new ItemStack(ModBlocks.SUGAR_BLOCK), 0.3f);
		this.addRecipe(new ItemStack(ModItems.SPONGE, 9), new ItemStack(Blocks.SPONGE), 0.5f);

		// Compact Blocks
		this.addRecipe(new ItemStack(Blocks.COBBLESTONE, 9), new ItemStack(ModBlocks.COMPACT_COBBLE), 0.1f);
		this.addRecipe(new ItemStack(Blocks.DIRT, 9), new ItemStack(ModBlocks.COMPACT_DIRT), 0.1f);
		this.addRecipe(new ItemStack(Blocks.GRAVEL, 9), new ItemStack(ModBlocks.COMPACT_GRAVEL), 0.1f);
		this.addRecipe(new ItemStack(Blocks.NETHERRACK, 9), new ItemStack(ModBlocks.COMPACT_NETHERRACK), 0.2f);
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

	public static CondenserRecipes instance() {
		return base;
	}
}
