package mce.lu.common.core.recipes;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import net.minecraft.client.util.RecipeItemHelper;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.RecipeMatcher;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class PigmentMixerShapelessRecipes extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {
	private final ItemStack recipeOutput;
	public final NonNullList<Ingredient> recipeItems;
	private final String group;
	private final boolean isSimple;

	public PigmentMixerShapelessRecipes(String group, ItemStack output, NonNullList<Ingredient> ing) {
		this.group = group;
		this.recipeOutput = output;
		this.recipeItems = ing;
		boolean simple = true;
		for (Ingredient i : ing)
			simple &= i.isSimple();
		this.isSimple = simple;
	}

	public String getGroup() {
		return this.group;
	}

	public ItemStack getRecipeOutput() {
		return this.recipeOutput;
	}

	public NonNullList<Ingredient> getIngredients() {
		return this.recipeItems;
	}

	public NonNullList<ItemStack> getRemainingItems(InventoryCrafting inv) {
		NonNullList<ItemStack> list = NonNullList.<ItemStack>withSize(inv.getSizeInventory(), ItemStack.EMPTY);

		for (int i = 0; i < list.size(); ++i) {
			ItemStack stack = inv.getStackInSlot(i);
			list.set(i, ForgeHooks.getContainerItem(stack));
		}

		return list;
	}

	public boolean matches(InventoryCrafting inv, World world) {
		int ingredCount = 0;
		RecipeItemHelper itemHelper = new RecipeItemHelper();
		List<ItemStack> inputs = Lists.newArrayList();

		for (int i = 0; i < inv.getHeight(); ++i) {
			for (int j = 0; j < inv.getWidth(); ++j) {
				ItemStack stack = inv.getStackInRowAndColumn(j, i);

				if (!stack.isEmpty()) {
					++ingredCount;
					if (this.isSimple)
						itemHelper.accountStack(stack, 1);
					else
						inputs.add(stack);
				}
			}
		}

		if (ingredCount != this.recipeItems.size())
			return false;

		if (this.isSimple)
			return itemHelper.canCraft(this, null);

		return RecipeMatcher.findMatches(inputs, this.recipeItems) != null;
	}

	public ItemStack getCraftingResult(InventoryCrafting inv) {
		return this.recipeOutput.copy();
	}

	public static Ingredient deserializeIngredient(@Nullable JsonElement json) {
		if (json != null && !json.isJsonNull()) {
			if (json.isJsonObject())
				return Ingredient.fromStacks(deserializeItem(json.getAsJsonObject(), false));
			else if (!json.isJsonArray())
				throw new JsonSyntaxException("LUERR: Expected item to be object or array of objects");
			else {
				JsonArray array = json.getAsJsonArray();

				if (array.size() == 0)
					throw new JsonSyntaxException(
							"LUERR: Item array cannot be empty, at least one item must be defined");
				else {
					ItemStack[] stack = new ItemStack[array.size()];

					for (int i = 0; i < array.size(); ++i)
						stack[i] = deserializeItem(JsonUtils.getJsonObject(array.get(i), "item"), false);

					return Ingredient.fromStacks(stack);
				}
			}
		} else
			throw new JsonSyntaxException("LUERR: Item cannot be null");
	}

	public static ItemStack deserializeItem(JsonObject json, boolean useCount) {
		String s = JsonUtils.getString(json, "item");
		Item item = Item.REGISTRY.getObject(new ResourceLocation(s));

		if (item == null)
			throw new JsonSyntaxException("LUERR: Unknown item '" + s + "'");

		else if (item.getHasSubtypes() && !json.has("data"))
			throw new JsonParseException("LUERR: Missing data for item '" + s + "'");

		else {
			int i = JsonUtils.getInt(json, "data", 0);
			int j = useCount ? JsonUtils.getInt(json, "count", 1) : 1;
			return new ItemStack(item, j, i);
		}
	}

	public static PigmentMixerShapelessRecipes deserialize(JsonObject json) {
		String s = JsonUtils.getString(json, "group", "");
		NonNullList<Ingredient> list = deserializeIngredients(JsonUtils.getJsonArray(json, "ingredients"));

		if (list.isEmpty())
			throw new JsonParseException("LUERR: No ingredients for shapeless recipe");

		else if (list.size() > 4) //
			throw new JsonParseException("LUERR: Too many ingredients for recipe");

		else {
			ItemStack stack = deserializeItem(JsonUtils.getJsonObject(json, "result"), true);
			return new PigmentMixerShapelessRecipes(s, stack, list);
		}
	}

	private static NonNullList<Ingredient> deserializeIngredients(JsonArray array) {
		NonNullList<Ingredient> list = NonNullList.<Ingredient>create();

		for (int i = 0; i < array.size(); ++i) {
			Ingredient ing = deserializeIngredient(array.get(i));

			if (ing != Ingredient.EMPTY)
				list.add(ing);
		}

		return list;
	}

	public boolean canFit(int width, int height) {
		return width * height >= this.recipeItems.size();
	}
}