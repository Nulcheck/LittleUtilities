package mce.lu.common.core.recipes;

import java.util.Map;
import java.util.Map.Entry;

import gnu.trove.map.hash.THashMap;
import mce.lu.common.block.ModBlocks;
import mce.lu.common.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.xendric.xenlib.common.util.DoubleInputHandler;

public class DehydratorRecipes {
	public static final DehydratorRecipes base = new DehydratorRecipes();
	private static Map<DoubleInputHandler, ItemStack> recipeMap = new THashMap<>();
	public static int time;

	public static DehydratorRecipes instance() {
		return base;
	}

	public DehydratorRecipes() {
		this.addRecipe(new FluidStack(ModBlocks.PIGMENT_BLACK_FLUID, 1000), new ItemStack(ModItems.PIGMENT_BLACK, 1), 50);
		this.addRecipe(new ItemStack(ModItems.PIGMENT_BLACK, 2), new ItemStack(ModItems.PIGMENT_BLACK, 1), 50);
	}

	public DoubleInputHandler addRecipe(ItemStack itemInput, ItemStack output, int time) {
		return addRecipe(null, itemInput, output, time);
	}

	public DoubleInputHandler addRecipe(FluidStack fluidInput, ItemStack output, int time) {
		return addRecipe(fluidInput, ItemStack.EMPTY, output, time);
	}

	public DoubleInputHandler addRecipe(FluidStack fluidInput, ItemStack itemInput, ItemStack output, int time) {
		DoubleInputHandler recipe = new DoubleInputHandler(fluidInput, itemInput);
		recipeMap.put(recipe, output);
		DehydratorRecipes.time = time;
		return recipe;
	}

	public static int getTime() {
		return time;
	}

	public ItemStack getRecipeResult(DoubleInputHandler inputs) {
		for (Entry<DoubleInputHandler, ItemStack> entry : recipeMap.entrySet()) {
			if (compareKeyStacks(inputs, entry.getKey()))
				return entry.getValue();
		}
		return ItemStack.EMPTY;
	}

	public static DoubleInputHandler getInputs(ItemStack outputStack) {
		for (Entry<DoubleInputHandler, ItemStack> entry : recipeMap.entrySet()) {
			if (compareValueStacks(outputStack, entry.getValue()))
				return entry.getKey();
		}
		return null;
	}
	
	private boolean compareKeyStacks(DoubleInputHandler inputs, DoubleInputHandler keyStack) {
		return (keyStack.getItemInput1().getItem() == inputs.getItemInput1().getItem()
				&& (keyStack.getItemInput1().getMetadata() == 32767
						|| keyStack.getItemInput1().getMetadata() == inputs.getItemInput1().getMetadata()))
				|| (keyStack.getFluidInput1().getFluid() == inputs.getFluidInput1().getFluid());
	}

	private static boolean compareValueStacks(ItemStack outputStack, ItemStack valueStack) {
		return (valueStack.getItem() == outputStack.getItem()
				&& (valueStack.getMetadata() == 32767 || valueStack.getMetadata() == outputStack.getMetadata()));
	}

	public static boolean isRecipe(DoubleInputHandler inputs) {
		return instance().getRecipeResult(inputs) != null;
	}
}
