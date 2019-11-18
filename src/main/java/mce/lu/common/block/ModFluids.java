package mce.lu.common.block;

import mce.lu.common.util.References;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.xendric.xenlib.common.core.block.FluidBase;

public class ModFluids {
	public static final Material LIQUID_PIGMENT = new MaterialLiquid(MapColor.WATER);

	public static final Fluid PIGMENT_BLACK_FLUID = new FluidBase("pigment_black_fluid",
			new ResourceLocation(References.MOD_ID, "blocks/pigment_black_fluid_still"),
			new ResourceLocation(References.MOD_ID, "blocks/pigment_black_fluid_flow"), null)
					.setMaterial(LIQUID_PIGMENT);

	public static final Fluid PIGMENT_RED_FLUID = new FluidBase("pigment_red_fluid",
			new ResourceLocation(References.MOD_ID, "blocks/pigment_red_fluid_still"),
			new ResourceLocation(References.MOD_ID, "blocks/pigment_red_fluid_flow"), null).setMaterial(LIQUID_PIGMENT);

	public static final Fluid PIGMENT_GREEN_FLUID = new FluidBase("pigment_green_fluid",
			new ResourceLocation(References.MOD_ID, "blocks/pigment_green_fluid_still"),
			new ResourceLocation(References.MOD_ID, "blocks/pigment_green_fluid_flow"), null)
					.setMaterial(LIQUID_PIGMENT);

	public static final Fluid PIGMENT_BROWN_FLUID = new FluidBase("pigment_brown_fluid",
			new ResourceLocation(References.MOD_ID, "blocks/pigment_brown_fluid_still"),
			new ResourceLocation(References.MOD_ID, "blocks/pigment_brown_fluid_flow"), null)
					.setMaterial(LIQUID_PIGMENT);

	public static final Fluid PIGMENT_BLUE_FLUID = new FluidBase("pigment_blue_fluid",
			new ResourceLocation(References.MOD_ID, "blocks/pigment_blue_fluid_still"),
			new ResourceLocation(References.MOD_ID, "blocks/pigment_blue_fluid_flow"), null)
					.setMaterial(LIQUID_PIGMENT);

	public static final Fluid PIGMENT_PURPLE_FLUID = new FluidBase("pigment_purple_fluid",
			new ResourceLocation(References.MOD_ID, "blocks/pigment_purple_fluid_still"),
			new ResourceLocation(References.MOD_ID, "blocks/pigment_purple_fluid_flow"), null)
					.setMaterial(LIQUID_PIGMENT);

	public static final Fluid PIGMENT_CYAN_FLUID = new FluidBase("pigment_cyan_fluid",
			new ResourceLocation(References.MOD_ID, "blocks/pigment_cyan_fluid_still"),
			new ResourceLocation(References.MOD_ID, "blocks/pigment_cyan_fluid_flow"), null)
					.setMaterial(LIQUID_PIGMENT);

	public static final Fluid PIGMENT_LIGHT_GRAY_FLUID = new FluidBase("pigment_light_gray_fluid",
			new ResourceLocation(References.MOD_ID, "blocks/pigment_light_gray_fluid_still"),
			new ResourceLocation(References.MOD_ID, "blocks/pigment_light_gray_fluid_flow"), null)
					.setMaterial(LIQUID_PIGMENT);

	public static final Fluid PIGMENT_GRAY_FLUID = new FluidBase("pigment_gray_fluid",
			new ResourceLocation(References.MOD_ID, "blocks/pigment_gray_fluid_still"),
			new ResourceLocation(References.MOD_ID, "blocks/pigment_gray_fluid_flow"), null)
					.setMaterial(LIQUID_PIGMENT);

	public static final Fluid PIGMENT_PINK_FLUID = new FluidBase("pigment_pink_fluid",
			new ResourceLocation(References.MOD_ID, "blocks/pigment_pink_fluid_still"),
			new ResourceLocation(References.MOD_ID, "blocks/pigment_pink_fluid_flow"), null)
					.setMaterial(LIQUID_PIGMENT);

	public static final Fluid PIGMENT_LIME_FLUID = new FluidBase("pigment_lime_fluid",
			new ResourceLocation(References.MOD_ID, "blocks/pigment_lime_fluid_still"),
			new ResourceLocation(References.MOD_ID, "blocks/pigment_lime_fluid_flow"), null)
					.setMaterial(LIQUID_PIGMENT);

	public static final Fluid PIGMENT_YELLOW_FLUID = new FluidBase("pigment_yellow_fluid",
			new ResourceLocation(References.MOD_ID, "blocks/pigment_yellow_fluid_still"),
			new ResourceLocation(References.MOD_ID, "blocks/pigment_yellow_fluid_flow"), null)
					.setMaterial(LIQUID_PIGMENT);

	public static final Fluid PIGMENT_LIGHT_BLUE_FLUID = new FluidBase("pigment_light_blue_fluid",
			new ResourceLocation(References.MOD_ID, "blocks/pigment_light_blue_fluid_still"),
			new ResourceLocation(References.MOD_ID, "blocks/pigment_light_blue_fluid_flow"), null)
					.setMaterial(LIQUID_PIGMENT);

	public static final Fluid PIGMENT_MAGENTA_FLUID = new FluidBase("pigment_magenta_fluid",
			new ResourceLocation(References.MOD_ID, "blocks/pigment_magenta_fluid_still"),
			new ResourceLocation(References.MOD_ID, "blocks/pigment_magenta_fluid_flow"), null)
					.setMaterial(LIQUID_PIGMENT);

	public static final Fluid PIGMENT_ORANGE_FLUID = new FluidBase("pigment_orange_fluid",
			new ResourceLocation(References.MOD_ID, "blocks/pigment_orange_fluid_still"),
			new ResourceLocation(References.MOD_ID, "blocks/pigment_orange_fluid_flow"), null)
					.setMaterial(LIQUID_PIGMENT);

	public static final Fluid PIGMENT_WHITE_FLUID = new FluidBase("pigment_white_fluid",
			new ResourceLocation(References.MOD_ID, "blocks/pigment_white_fluid_still"),
			new ResourceLocation(References.MOD_ID, "blocks/pigment_white_fluid_flow"), null)
					.setMaterial(LIQUID_PIGMENT);

	public static final Fluid[] PIGMENT_FLUIDS = { PIGMENT_BLACK_FLUID, PIGMENT_RED_FLUID, PIGMENT_GREEN_FLUID,
			PIGMENT_BROWN_FLUID, PIGMENT_BLUE_FLUID, PIGMENT_PURPLE_FLUID, PIGMENT_CYAN_FLUID, PIGMENT_LIGHT_GRAY_FLUID,
			PIGMENT_GRAY_FLUID, PIGMENT_PINK_FLUID, PIGMENT_LIME_FLUID, PIGMENT_YELLOW_FLUID, PIGMENT_LIGHT_BLUE_FLUID,
			PIGMENT_MAGENTA_FLUID, PIGMENT_ORANGE_FLUID, PIGMENT_WHITE_FLUID };

	public static void registerFluids() {
		for (int i = 0; i < 16; ++i) {
			FluidRegistry.registerFluid(PIGMENT_FLUIDS[i]);
			FluidRegistry.addBucketForFluid(PIGMENT_FLUIDS[i]);
		}
	}
}
