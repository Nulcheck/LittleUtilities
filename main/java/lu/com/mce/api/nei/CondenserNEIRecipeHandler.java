package lu.com.mce.api.nei;

import java.awt.Rectangle;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import lu.com.mce.gui.CondenserGui;
import lu.com.mce.handlers.recipes.CondenserRecipes;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;

public class CondenserNEIRecipeHandler extends TemplateRecipeHandler {
	public TemplateRecipeHandler newInstance() {
		return super.newInstance();
	}

	public void loadTransferRects() {
		transferRects.add(new RecipeTransferRect(new Rectangle(75, 23, 24, 16), "lu.con"));
	}

	public Class<? extends GuiContainer> getGuiClass() {
		return CondenserGui.class;
	}

	public String getGuiTexture() {
		return "mod_lu:textures/gui/condenser.png";
	}

	public String getRecipeName() {
		return NEIClientUtils.translate("lu.con");
	}

	public String getOverlayIdentifier() {
		return "lu.con";
	}

	@Override
	public void loadCraftingRecipes(String outputId, Object... results) {
		if (outputId.equals("lu.con") && getClass() == CondenserNEIRecipeHandler.class) {
			Map<ItemStack, ItemStack> recipes = CondenserRecipes.instance().getRecipeList();
			for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet()) {
				arecipes.add(new ConPair(recipe.getKey(), recipe.getValue()));
			}
		} else {
			super.loadCraftingRecipes(outputId, results);
		}
	}

	@Override
	public void loadCraftingRecipes(ItemStack result) {
		Map<ItemStack, ItemStack> recipes = CondenserRecipes.instance().getRecipeList();
		for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet()) {
			if (NEIServerUtils.areStacksSameType(recipe.getValue(), result)) {
				arecipes.add(new ConPair(recipe.getKey(), recipe.getValue()));
			}
		}
	}

	@Override
	public void loadUsageRecipes(String inputId, Object... ingredients) {
		if (inputId.equals("lu.con") && getClass() == CondenserNEIRecipeHandler.class) {
			loadCraftingRecipes("lu.con");
		} else {
			super.loadUsageRecipes(inputId, ingredients);
		}
	}

	@Override
	public void loadUsageRecipes(ItemStack ingredient) {
		Map<ItemStack, ItemStack> recipes = CondenserRecipes.instance().getRecipeList();
		for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet()) {
			if (NEIServerUtils.areStacksSameTypeCrafting(recipe.getKey(), ingredient)) {
				ConPair arecipe = new ConPair(recipe.getKey(), recipe.getValue());
				arecipe.setIngredientPermutation(Arrays.asList(arecipe.in), ingredient);
				arecipes.add(arecipe);
			}
		}
	}

	public class ConPair extends CachedRecipe {
		PositionedStack in;
		PositionedStack out;

		public ConPair(ItemStack in, ItemStack out) {
			// in.stackSize = 1;
			this.in = new PositionedStack(in, 51, 24);
			this.out = new PositionedStack(out, 111, 24);
		}

		public List<PositionedStack> getIngredients() {
			return getCycledIngredients(cycleticks / 48, Arrays.asList(in));
		}

		public PositionedStack getResult() {
			return out;
		}
	}
}
