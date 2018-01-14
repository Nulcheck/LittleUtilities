package lu.com.mce.handlers.recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import lu.com.mce.common.mod_lu;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class CondenserRecipes {
	public static final CondenserRecipes base = new CondenserRecipes();
	private Map conMap = new HashMap();
	private Map expMap = new HashMap();

	public static CondenserRecipes condensing() {
		return base;
	}

	public CondenserRecipes() {
		// Condensed Blocks
		this.addRecipe(new ItemStack(Items.ghast_tear, 9), new ItemStack(mod_lu.ghastTearBlock), 5f);
		this.addRecipe(new ItemStack(Items.blaze_rod, 9), new ItemStack(mod_lu.blazeRodBlock), 5f);
		this.addRecipe(new ItemStack(Items.porkchop, 9), new ItemStack(mod_lu.porkBlock, 1, 0), 0.5f);
		this.addRecipe(new ItemStack(Items.cooked_porkchop, 9), new ItemStack(mod_lu.porkBlock, 1, 1), 0.5f);
		this.addRecipe(new ItemStack(Items.beef, 9), new ItemStack(mod_lu.beefBlock, 1, 0), 0.5f);
		this.addRecipe(new ItemStack(Items.cooked_beef, 9), new ItemStack(mod_lu.beefBlock, 1, 1), 0.5f);
		this.addRecipe(new ItemStack(Items.chicken, 9), new ItemStack(mod_lu.chickenBlock, 1, 0), 0.5f);
		this.addRecipe(new ItemStack(Items.cooked_chicken, 9), new ItemStack(mod_lu.chickenBlock, 1, 1), 0.5f);
		this.addRecipe(new ItemStack(Items.fish, 9, 0), new ItemStack(mod_lu.fishBlock, 1, 0), 0.5f);
		this.addRecipe(new ItemStack(Items.fish, 9, 1), new ItemStack(mod_lu.fishBlock, 1, 1), 0.5f);
		this.addRecipe(new ItemStack(Items.fish, 9, 2), new ItemStack(mod_lu.fishBlock, 1, 2), 0.5f);
		this.addRecipe(new ItemStack(Items.fish, 9, 3), new ItemStack(mod_lu.fishBlock, 1, 3), 0.5f);
		this.addRecipe(new ItemStack(Items.cooked_fished, 9, 0), new ItemStack(mod_lu.fishBlock, 1, 4), 0.5f);
		this.addRecipe(new ItemStack(Items.cooked_fished, 9, 1), new ItemStack(mod_lu.fishBlock, 1, 5), 0.5f);
		this.addRecipe(new ItemStack(Items.rotten_flesh, 9), new ItemStack(mod_lu.rottenFleshBlock), 0.5f);
		this.addRecipe(new ItemStack(Items.apple, 9), new ItemStack(mod_lu.appleBlock), 0.6f);

		// Reverse Recipes
		this.addRecipe(new ItemStack(mod_lu.ghastTearBlock), new ItemStack(Items.ghast_tear, 9), 5f);
		this.addRecipe(new ItemStack(mod_lu.blazeRodBlock), new ItemStack(Items.blaze_rod, 9), 5f);
		this.addRecipe(new ItemStack(mod_lu.porkBlock, 1, 0), new ItemStack(Items.porkchop, 9), 0.5f);
		this.addRecipe(new ItemStack(mod_lu.porkBlock, 1, 1), new ItemStack(Items.cooked_porkchop, 9), 0.5f);
		this.addRecipe(new ItemStack(mod_lu.beefBlock, 1, 0), new ItemStack(Items.beef, 9), 0.5f);
		this.addRecipe(new ItemStack(mod_lu.beefBlock, 1, 1), new ItemStack(Items.cooked_beef, 9), 0.5f);
		this.addRecipe(new ItemStack(mod_lu.chickenBlock, 1, 0), new ItemStack(Items.chicken, 9), 0.5f);
		this.addRecipe(new ItemStack(mod_lu.chickenBlock, 1, 1), new ItemStack(Items.cooked_chicken, 9), 0.5f);
		this.addRecipe(new ItemStack(mod_lu.fishBlock, 1, 0), new ItemStack(Items.fish, 9, 0), 0.5f);
		this.addRecipe(new ItemStack(mod_lu.fishBlock, 1, 1), new ItemStack(Items.fish, 9, 1), 0.5f);
		this.addRecipe(new ItemStack(mod_lu.fishBlock, 1, 2), new ItemStack(Items.fish, 9, 2), 0.5f);
		this.addRecipe(new ItemStack(mod_lu.fishBlock, 1, 3), new ItemStack(Items.fish, 9, 3), 0.5f);
		this.addRecipe(new ItemStack(mod_lu.fishBlock, 1, 4), new ItemStack(Items.cooked_fished, 9, 0), 0.5f);
		this.addRecipe(new ItemStack(mod_lu.fishBlock, 1, 5), new ItemStack(Items.cooked_fished, 9, 1), 0.5f);
		this.addRecipe(new ItemStack(mod_lu.rottenFleshBlock), new ItemStack(Items.rotten_flesh, 9), 0.5f);
		this.addRecipe(new ItemStack(mod_lu.appleBlock), new ItemStack(Items.apple, 9), 0.6f);
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
		Iterator iter = this.conMap.entrySet().iterator();
		Entry entry;

		do {
			if (!iter.hasNext()) {
				return null;
			}

			entry = (Entry) iter.next();
		} while (!this.input(stack, (ItemStack) entry.getKey()));

		return stack;
	}

	private boolean input(ItemStack in, ItemStack out) {
		return in.getItem() == out.getItem();
	}

	public ItemStack getCondensingResult(ItemStack stack) {
		Iterator iter = this.conMap.entrySet().iterator();
		Entry entry;

		do {
			if (!iter.hasNext()) {
				return null;
			}

			entry = (Entry) iter.next();
		} while (!this.output(stack, (ItemStack) entry.getKey()));

		return (ItemStack) entry.getValue();
	}

	private boolean output(ItemStack in, ItemStack out) {
		return out.getItem() == in.getItem();
	}

	public Map getRecipeList() {
		return this.conMap;
	}

	public float expHandling(ItemStack stack) {
		float ret = stack.getItem().getSmeltingExperience(stack);
		if (ret != -1)
			return ret;

		Iterator iter = this.expMap.entrySet().iterator();
		Entry entry;

		do {
			if (!iter.hasNext()) {
				return 0.0F;
			}

			entry = (Entry) iter.next();
		} while (!this.output(stack, (ItemStack) entry.getKey()));

		return ((Float) entry.getValue()).floatValue();
	}

	public static CondenserRecipes instance() {
		return base;
	}

	public ItemStack findMatchingRecipe(InventoryCrafting inv, World world) {
		int j;

		for (j = 0; j < this.conMap.size(); ++j) {
			IRecipe irecipe = (IRecipe) this.conMap.get(j);

			if (irecipe.matches(inv, world)) {
				return irecipe.getCraftingResult(inv);
			}
		}

		return null;
	}
}
