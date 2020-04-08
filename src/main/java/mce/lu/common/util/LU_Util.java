package mce.lu.common.util;

import mce.lu.common.block.ModBlocks;
import mce.lu.common.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class LU_Util {
	public static ResourceLocation MC_BLOCK_SHEET = new ResourceLocation("textures/atlas/blocks.png");
	public static Item[] PIGMENTS = { ModItems.PIGMENT_BLACK, ModItems.PIGMENT_RED, ModItems.PIGMENT_GREEN,
			ModItems.PIGMENT_BROWN, ModItems.PIGMENT_BLUE, ModItems.PIGMENT_PURPLE, ModItems.PIGMENT_CYAN,
			ModItems.PIGMENT_LIGHT_GRAY, ModItems.PIGMENT_GRAY, ModItems.PIGMENT_PINK, ModItems.PIGMENT_LIME,
			ModItems.PIGMENT_YELLOW, ModItems.PIGMENT_LIGHT_BLUE, ModItems.PIGMENT_MAGENTA, ModItems.PIGMENT_ORANGE,
			ModItems.PIGMENT_WHITE };
	public static Block[] REEDS = { ModBlocks.REEDS_BLACK, ModBlocks.REEDS_RED, ModBlocks.REEDS_GREEN,
			ModBlocks.REEDS_BROWN, ModBlocks.REEDS_BLUE, ModBlocks.REEDS_PURPLE, ModBlocks.REEDS_CYAN,
			ModBlocks.REEDS_LIGHT_GRAY, ModBlocks.REEDS_GRAY, ModBlocks.REEDS_PINK, ModBlocks.REEDS_LIME,
			ModBlocks.REEDS_YELLOW, ModBlocks.REEDS_LIGHT_BLUE, ModBlocks.REEDS_MAGENTA, ModBlocks.REEDS_ORANGE,
			ModBlocks.REEDS_WHITE };

	public static void setBlockTextureSheet() {
		Minecraft.getMinecraft().renderEngine.bindTexture(MC_BLOCK_SHEET);
	}

	public static void setGlColorFromInt(int color) {
		float red = (float) (color >> 16 & 255) / 255f;
		float green = (float) (color >> 8 & 255) / 255f;
		float blue = (float) (color & 255) / 255f;
		GlStateManager.color(red, green, blue);
	}

	public static TextureAtlasSprite getFluidTexture(Fluid fluid) {
		if (fluid == null)
			fluid = FluidRegistry.WATER;
		return getTexture(fluid.getStill());
	}

	public static TextureAtlasSprite getFluidTexture(FluidStack fluid) {
		if (fluid == null || fluid.getFluid().getStill(fluid) == null)
			fluid = new FluidStack(FluidRegistry.WATER, 1);
		return getTexture(fluid.getFluid().getStill(fluid));
	}

	public static TextureAtlasSprite getTexture(String location) {
		return Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(location);
	}

	public static TextureAtlasSprite getTexture(ResourceLocation location) {
		return getTexture(location.toString());
	}
}
