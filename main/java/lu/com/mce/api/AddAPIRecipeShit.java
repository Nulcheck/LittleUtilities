package lu.com.mce.api;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class AddAPIRecipeShit {
	public static final AddAPIRecipeShit recipes = new AddAPIRecipeShit();

	public static AddAPIRecipeShit getInstance() {
		return recipes;
	}

	public void recipes() {
		RecipeAPI.addCondenserRecipe(new ItemStack(Items.arrow, 9), new ItemStack(Blocks.sand));
	}
}
