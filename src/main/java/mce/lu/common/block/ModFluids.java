package mce.lu.common.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluids {
	public static final Material LIQUID_PIGMENT = new MaterialLiquid(MapColor.WATER);

	public static final FluidBase PIGMENT_BLACK_FLUID = new FluidBase("pigment_black_fluid",
			new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/water_flow"),
			EnumDyeColor.BLACK.getColorValue()).setMaterial(LIQUID_PIGMENT);

	public static final FluidBase PIGMENT_RED_FLUID = new FluidBase("pigment_red_fluid",
			new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/water_flow"),
			EnumDyeColor.RED.getColorValue()).setMaterial(LIQUID_PIGMENT);

	public static final FluidBase PIGMENT_GREEN_FLUID = new FluidBase("pigment_green_fluid",
			new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/water_flow"),
			EnumDyeColor.GREEN.getColorValue()).setMaterial(LIQUID_PIGMENT);

	public static final FluidBase PIGMENT_BROWN_FLUID = new FluidBase("pigment_brown_fluid",
			new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/water_flow"),
			EnumDyeColor.BROWN.getColorValue()).setMaterial(LIQUID_PIGMENT);

	public static final FluidBase PIGMENT_BLUE_FLUID = new FluidBase("pigment_blue_fluid",
			new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/water_flow"),
			EnumDyeColor.BLUE.getColorValue()).setMaterial(LIQUID_PIGMENT);

	public static final FluidBase PIGMENT_PURPLE_FLUID = new FluidBase("pigment_purple_fluid",
			new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/water_flow"),
			EnumDyeColor.PURPLE.getColorValue()).setMaterial(LIQUID_PIGMENT);

	public static final FluidBase PIGMENT_CYAN_FLUID = new FluidBase("pigment_cyan_fluid",
			new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/water_flow"),
			EnumDyeColor.CYAN.getColorValue()).setMaterial(LIQUID_PIGMENT);

	public static final FluidBase PIGMENT_LIGHT_GRAY_FLUID = new FluidBase("pigment_light_gray_fluid",
			new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/water_flow"),
			EnumDyeColor.SILVER.getColorValue()).setMaterial(LIQUID_PIGMENT);

	public static final FluidBase PIGMENT_GRAY_FLUID = new FluidBase("pigment_gray_fluid",
			new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/water_flow"),
			EnumDyeColor.GRAY.getColorValue()).setMaterial(LIQUID_PIGMENT);

	public static final FluidBase PIGMENT_PINK_FLUID = new FluidBase("pigment_pink_fluid",
			new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/water_flow"),
			EnumDyeColor.PINK.getColorValue()).setMaterial(LIQUID_PIGMENT);

	public static final FluidBase PIGMENT_LIME_FLUID = new FluidBase("pigment_lime_fluid",
			new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/water_flow"),
			EnumDyeColor.LIME.getColorValue()).setMaterial(LIQUID_PIGMENT);

	public static final FluidBase PIGMENT_YELLOW_FLUID = new FluidBase("pigment_yellow_fluid",
			new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/water_flow"),
			EnumDyeColor.YELLOW.getColorValue()).setMaterial(LIQUID_PIGMENT);

	public static final FluidBase PIGMENT_LIGHT_BLUE_FLUID = new FluidBase("pigment_light_blue_fluid",
			new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/water_flow"),
			EnumDyeColor.LIGHT_BLUE.getColorValue()).setMaterial(LIQUID_PIGMENT);

	public static final FluidBase PIGMENT_MAGNETA_FLUID = new FluidBase("pigment_magenta_fluid",
			new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/water_flow"),
			EnumDyeColor.MAGENTA.getColorValue()).setMaterial(LIQUID_PIGMENT);

	public static final FluidBase PIGMENT_ORANGE_FLUID = new FluidBase("pigment_orange_fluid",
			new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/water_flow"),
			EnumDyeColor.ORANGE.getColorValue()).setMaterial(LIQUID_PIGMENT);

	public static final FluidBase PIGMENT_WHITE_FLUID = new FluidBase("pigment_white_fluid",
			new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/water_flow"),
			EnumDyeColor.WHITE.getColorValue()).setMaterial(LIQUID_PIGMENT);

	public static final Fluid[] PIGMENT_FLUIDS = { PIGMENT_BLACK_FLUID, PIGMENT_RED_FLUID, PIGMENT_GREEN_FLUID,
			PIGMENT_BROWN_FLUID, PIGMENT_BLUE_FLUID, PIGMENT_PURPLE_FLUID, PIGMENT_CYAN_FLUID, PIGMENT_LIGHT_GRAY_FLUID,
			PIGMENT_GRAY_FLUID, PIGMENT_PINK_FLUID, PIGMENT_LIME_FLUID, PIGMENT_YELLOW_FLUID, PIGMENT_LIGHT_BLUE_FLUID,
			PIGMENT_MAGNETA_FLUID, PIGMENT_ORANGE_FLUID, PIGMENT_WHITE_FLUID };

	public static void registerFluids() {
		for (int i = 0; i < 16; i++) {
			FluidRegistry.registerFluid(PIGMENT_FLUIDS[i]);
			FluidRegistry.addBucketForFluid(PIGMENT_FLUIDS[i]);
		}
	}
}
