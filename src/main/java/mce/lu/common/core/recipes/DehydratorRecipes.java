package mce.lu.common.core.recipes;

import java.util.Map;
import java.util.Map.Entry;

import gnu.trove.map.hash.THashMap;
import mce.lu.common.block.ModFluids;
import mce.lu.common.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
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
		this.addRecipe(new FluidStack(ModFluids.PIGMENT_BLACK_FLUID, Fluid.BUCKET_VOLUME), new ItemStack(ModItems.PIGMENT_BLACK), 50);
	}

	public void addRecipe(ItemStack itemInput, ItemStack output, int time) {
		this.addRecipe(FluidStackEmpty.EMPTY, itemInput, output, time);
	}

	public void addRecipe(FluidStack fluidInput, ItemStack output, int time) {
		this.addRecipe(fluidInput, ItemStack.EMPTY, output, time);
	}

	public void addRecipe(FluidStack fluidInput, ItemStack itemInput, ItemStack output, int timeIn) {
		DoubleInputHandler inputs = new DoubleInputHandler(fluidInput, itemInput);
		recipeMap.put(inputs, output);
		setTime(timeIn);
	}

	public static int getTime() {
		return time;
	}

	private int setTime(int timeIn) {
		return time = timeIn;
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

	public static class FluidStackEmpty extends FluidStack {
		public static final FluidStack EMPTY = new FluidStack((Fluid) null, 0);

		public FluidStackEmpty(Fluid fluid, int amount) {
			super(fluid, amount);
		}
	}
}
