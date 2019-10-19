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
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class DehydratorRecipes {
	public static final DehydratorRecipes base = new DehydratorRecipes();
	private final Map<List<Object>, ItemStack> recipeMap = Maps.<List<Object>, ItemStack>newHashMap();
	private final Map<List<Object>, Integer> timeMap = Maps.<List<Object>, Integer>newHashMap();

	public static DehydratorRecipes instance() {
		return base;
	}

	public DehydratorRecipes() {
		// Items Only
		this.addRecipe(new ItemStack(Blocks.SPONGE, 1, 1), new ItemStack(Blocks.SPONGE, 1, 0), 50);

		// Fluid Only
		this.addRecipe(new FluidStack(ModFluids.PIGMENT_BLACK_FLUID, Fluid.BUCKET_VOLUME),
				new ItemStack(ModItems.PIGMENT_BLACK), 10);
		this.addRecipe(new FluidStack(ModFluids.PIGMENT_RED_FLUID, Fluid.BUCKET_VOLUME),
				new ItemStack(ModItems.PIGMENT_RED), 10);
		this.addRecipe(new FluidStack(ModFluids.PIGMENT_GREEN_FLUID, Fluid.BUCKET_VOLUME),
				new ItemStack(ModItems.PIGMENT_GREEN), 10);
		this.addRecipe(new FluidStack(ModFluids.PIGMENT_BROWN_FLUID, Fluid.BUCKET_VOLUME),
				new ItemStack(ModItems.PIGMENT_BROWN), 10);
		this.addRecipe(new FluidStack(ModFluids.PIGMENT_BLUE_FLUID, Fluid.BUCKET_VOLUME),
				new ItemStack(ModItems.PIGMENT_BLUE), 10);
		this.addRecipe(new FluidStack(ModFluids.PIGMENT_PURPLE_FLUID, Fluid.BUCKET_VOLUME),
				new ItemStack(ModItems.PIGMENT_PURPLE), 10);
		this.addRecipe(new FluidStack(ModFluids.PIGMENT_CYAN_FLUID, Fluid.BUCKET_VOLUME),
				new ItemStack(ModItems.PIGMENT_CYAN), 10);
		this.addRecipe(new FluidStack(ModFluids.PIGMENT_LIGHT_GRAY_FLUID, Fluid.BUCKET_VOLUME),
				new ItemStack(ModItems.PIGMENT_LIGHT_GRAY), 10);
		this.addRecipe(new FluidStack(ModFluids.PIGMENT_GRAY_FLUID, Fluid.BUCKET_VOLUME),
				new ItemStack(ModItems.PIGMENT_GRAY), 10);
		this.addRecipe(new FluidStack(ModFluids.PIGMENT_PINK_FLUID, Fluid.BUCKET_VOLUME),
				new ItemStack(ModItems.PIGMENT_PINK), 10);
		this.addRecipe(new FluidStack(ModFluids.PIGMENT_LIME_FLUID, Fluid.BUCKET_VOLUME),
				new ItemStack(ModItems.PIGMENT_LIME), 10);
		this.addRecipe(new FluidStack(ModFluids.PIGMENT_YELLOW_FLUID, Fluid.BUCKET_VOLUME),
				new ItemStack(ModItems.PIGMENT_YELLOW), 10);
		this.addRecipe(new FluidStack(ModFluids.PIGMENT_LIGHT_BLUE_FLUID, Fluid.BUCKET_VOLUME),
				new ItemStack(ModItems.PIGMENT_LIGHT_BLUE), 10);
		this.addRecipe(new FluidStack(ModFluids.PIGMENT_MAGENTA_FLUID, Fluid.BUCKET_VOLUME),
				new ItemStack(ModItems.PIGMENT_MAGENTA), 10);
		this.addRecipe(new FluidStack(ModFluids.PIGMENT_ORANGE_FLUID, Fluid.BUCKET_VOLUME),
				new ItemStack(ModItems.PIGMENT_ORANGE), 10);
		this.addRecipe(new FluidStack(ModFluids.PIGMENT_WHITE_FLUID, Fluid.BUCKET_VOLUME),
				new ItemStack(ModItems.PIGMENT_WHITE), 10);
	}

	public void addRecipe(ItemStack itemInput, ItemStack output, int time) {
		recipeMap.put(Arrays.asList(null, itemInput), output);
		timeMap.put(Arrays.asList(null, itemInput), time);
	}

	public void addRecipe(FluidStack fluidInput, ItemStack output, int time) {
		recipeMap.put(Arrays.asList(fluidInput, ItemStack.EMPTY), output);
		timeMap.put(Arrays.asList(fluidInput, ItemStack.EMPTY), time);
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

	public static boolean isItemInRecipe(ItemStack stack) {
		return (instance().getRecipeResult(Arrays.asList(null, stack)).isEmpty()) ? false : true;
	}

	public static boolean isFluidInRecipe(FluidStack stack) {
		return (instance().getRecipeResult(Arrays.asList(stack, ItemStack.EMPTY)).isEmpty()) ? false : true;
	}

	public Map<List<Object>, ItemStack> getRecipeMap() {
		return recipeMap;
	}
}
