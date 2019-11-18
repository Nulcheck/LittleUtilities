package mce.lu.client.core.handler;

import mce.lu.common.block.ModBlocks;
import mce.lu.common.block.ModFluids;
import mce.lu.common.util.References;
import net.minecraft.item.Item;
import net.xendric.xenlib.client.core.proxy.ClientProxy;

public class FluidRenderHandler {
	static String modid = References.MOD_ID;

	public static void renderFluids() {
		ClientProxy.registerFluidModel(Item.getItemFromBlock(ModBlocks.PIGMENT_BLACK_FLUID_BLOCK),
				ModBlocks.PIGMENT_BLACK_FLUID_BLOCK, modid, ModFluids.PIGMENT_BLACK_FLUID.getName());

		ClientProxy.registerFluidModel(Item.getItemFromBlock(ModBlocks.PIGMENT_RED_FLUID_BLOCK),
				ModBlocks.PIGMENT_RED_FLUID_BLOCK, modid, ModFluids.PIGMENT_RED_FLUID.getName());

		ClientProxy.registerFluidModel(Item.getItemFromBlock(ModBlocks.PIGMENT_GREEN_FLUID_BLOCK),
				ModBlocks.PIGMENT_GREEN_FLUID_BLOCK, modid, ModFluids.PIGMENT_GREEN_FLUID.getName());

		ClientProxy.registerFluidModel(Item.getItemFromBlock(ModBlocks.PIGMENT_BROWN_FLUID_BLOCK),
				ModBlocks.PIGMENT_BROWN_FLUID_BLOCK, modid, ModFluids.PIGMENT_BROWN_FLUID.getName());

		ClientProxy.registerFluidModel(Item.getItemFromBlock(ModBlocks.PIGMENT_BLUE_FLUID_BLOCK),
				ModBlocks.PIGMENT_BLUE_FLUID_BLOCK, modid, ModFluids.PIGMENT_BLUE_FLUID.getName());

		ClientProxy.registerFluidModel(Item.getItemFromBlock(ModBlocks.PIGMENT_PURPLE_FLUID_BLOCK),
				ModBlocks.PIGMENT_PURPLE_FLUID_BLOCK, modid, ModFluids.PIGMENT_PURPLE_FLUID.getName());

		ClientProxy.registerFluidModel(Item.getItemFromBlock(ModBlocks.PIGMENT_CYAN_FLUID_BLOCK),
				ModBlocks.PIGMENT_CYAN_FLUID_BLOCK, modid, ModFluids.PIGMENT_CYAN_FLUID.getName());

		ClientProxy.registerFluidModel(Item.getItemFromBlock(ModBlocks.PIGMENT_LIGHT_GRAY_FLUID_BLOCK),
				ModBlocks.PIGMENT_LIGHT_GRAY_FLUID_BLOCK, modid, ModFluids.PIGMENT_LIGHT_GRAY_FLUID.getName());

		ClientProxy.registerFluidModel(Item.getItemFromBlock(ModBlocks.PIGMENT_GRAY_FLUID_BLOCK),
				ModBlocks.PIGMENT_GRAY_FLUID_BLOCK, modid, ModFluids.PIGMENT_GRAY_FLUID.getName());

		ClientProxy.registerFluidModel(Item.getItemFromBlock(ModBlocks.PIGMENT_PINK_FLUID_BLOCK),
				ModBlocks.PIGMENT_PINK_FLUID_BLOCK, modid, ModFluids.PIGMENT_PINK_FLUID.getName());

		ClientProxy.registerFluidModel(Item.getItemFromBlock(ModBlocks.PIGMENT_LIME_FLUID_BLOCK),
				ModBlocks.PIGMENT_LIME_FLUID_BLOCK, modid, ModFluids.PIGMENT_LIME_FLUID.getName());

		ClientProxy.registerFluidModel(Item.getItemFromBlock(ModBlocks.PIGMENT_YELLOW_FLUID_BLOCK),
				ModBlocks.PIGMENT_YELLOW_FLUID_BLOCK, modid, ModFluids.PIGMENT_YELLOW_FLUID.getName());

		ClientProxy.registerFluidModel(Item.getItemFromBlock(ModBlocks.PIGMENT_LIGHT_BLUE_FLUID_BLOCK),
				ModBlocks.PIGMENT_LIGHT_BLUE_FLUID_BLOCK, modid, ModFluids.PIGMENT_LIGHT_BLUE_FLUID.getName());

		ClientProxy.registerFluidModel(Item.getItemFromBlock(ModBlocks.PIGMENT_MAGENTA_FLUID_BLOCK),
				ModBlocks.PIGMENT_MAGENTA_FLUID_BLOCK, modid, ModFluids.PIGMENT_MAGENTA_FLUID.getName());

		ClientProxy.registerFluidModel(Item.getItemFromBlock(ModBlocks.PIGMENT_ORANGE_FLUID_BLOCK),
				ModBlocks.PIGMENT_ORANGE_FLUID_BLOCK, modid, ModFluids.PIGMENT_ORANGE_FLUID.getName());

		ClientProxy.registerFluidModel(Item.getItemFromBlock(ModBlocks.PIGMENT_WHITE_FLUID_BLOCK),
				ModBlocks.PIGMENT_WHITE_FLUID_BLOCK, modid, ModFluids.PIGMENT_WHITE_FLUID.getName());
	}
}
