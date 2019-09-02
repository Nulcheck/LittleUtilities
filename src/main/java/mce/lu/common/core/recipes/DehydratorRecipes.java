package mce.lu.common.core.recipes;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

import mce.lu.common.block.ModFluids;
import mce.lu.common.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class DehydratorRecipes {
	public static final DehydratorRecipes base = new DehydratorRecipes();
	private final Map<List<Object>, ItemStack> recipeMap = Maps.<List<Object>, ItemStack>newHashMap();
	private final Map<List<Object>, Integer> timeMap = Maps.<List<Object>, Integer>newHashMap();

	public static DehydratorRecipes instance() {
		return base;
	}

	public DehydratorRecipes() {
		this.addRecipe(new ItemStack(Blocks.SPONGE, 1, 1), new ItemStack(Blocks.SPONGE, 1, 0), 50);
		this.addRecipe(new FluidStack(ModFluids.PIGMENT_BLACK_FLUID, 500), new ItemStack(ModItems.PIGMENT_BLACK), 10);
	}

	public void addRecipe(ItemStack itemInput, ItemStack output, int time) {
		this.addRecipe(null, itemInput, output, time);
	}

	public void addRecipe(FluidStack fluidInput, ItemStack output, int time) {
		this.addRecipe(fluidInput, ItemStack.EMPTY, output, time);
	}

	public void addRecipe(FluidStack fluidInput, ItemStack itemInput, ItemStack output, int timeIn) {
		recipeMap.put(Arrays.asList(fluidInput, itemInput), output);
		timeMap.put(Arrays.asList(fluidInput, itemInput), timeIn);
	}

	public int getTime(List<Object> inputs) {
		for (Entry<List<Object>, Integer> entry : instance().timeMap.entrySet()) {
			if (compareKeyStacks(inputs, entry.getKey()))
				return entry.getValue();
		}
		return 0;
	}

	public ItemStack getRecipeResult(List<Object> inputs) {
		for (Entry<List<Object>, ItemStack> entry : recipeMap.entrySet()) {
			if (compareKeyStacks(inputs, entry.getKey()))
				return entry.getValue();
		}
		return ItemStack.EMPTY;
	}

	public List<Object> getInputs(ItemStack outputStack) {
		for (Entry<List<Object>, ItemStack> entry : instance().recipeMap.entrySet()) {
			if (compareValueStacks(outputStack, entry.getValue()))
				return entry.getKey();
		}
		return null;
	}

	private boolean compareKeyStacks(List<Object> inputs, List<Object> keyStack) {
		return keyStack.equals(inputs) && (((ItemStack) keyStack.get(1)).getMetadata() == 32767
				|| ((ItemStack) keyStack.get(1)).getMetadata() == ((ItemStack) inputs.get(1)).getMetadata());
	}

	private boolean compareValueStacks(ItemStack outputStack, ItemStack valueStack) {
		return (valueStack.getItem() == outputStack.getItem()
				&& (valueStack.getMetadata() == 32767 || valueStack.getMetadata() == outputStack.getMetadata()));
	}

	public static boolean isRecipe(FluidStack fluid, ItemStack stack) {
		return instance().getRecipeResult(Arrays.asList(fluid, stack)) != null;
	}

	public Map<List<Object>, ItemStack> getRecipeMap() {
		return recipeMap;
	}
}
