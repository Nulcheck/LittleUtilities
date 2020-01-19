package mce.lu.common.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class Util {
	public static ResourceLocation MC_BLOCK_SHEET = new ResourceLocation("textures/atlas/blocks.png");

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
