package mce.lu.client.render.entity.layers;

import mce.lu.client.render.entity.RenderChromaCow;
import mce.lu.common.entity.passive.EntityChromaCow;
import mce.lu.common.util.References;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ResourceLocation;

public class LayerChromaCowHide implements LayerRenderer<EntityChromaCow> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID,
			"textures/entity/chroma_cow/chroma_cow_hide.png");
	private final RenderChromaCow renderer;
	private final ModelCow model = new ModelCow();

	public LayerChromaCowHide(RenderChromaCow rendererIn) {
		this.renderer = rendererIn;
	}

	@Override
	public void doRenderLayer(EntityChromaCow cowIn, float limbSwing, float limbSwingAmount, float partialTicks,
			float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		if (!cowIn.isInvisible()) {
			this.renderer.bindTexture(TEXTURE);

			if (cowIn.hasCustomName() && "jeb_".equals(cowIn.getCustomNameTag())) {
				int i = cowIn.ticksExisted / 25 + cowIn.getEntityId();
				int j = EnumDyeColor.values().length;
				int k = i % j;
				int l = (i + 1) % j;
				float f = ((float) (cowIn.ticksExisted % 25) + partialTicks) / 25.0F;
				float[] afloat1 = EntityChromaCow.getDyeRgb(EnumDyeColor.byMetadata(k));
				float[] afloat2 = EntityChromaCow.getDyeRgb(EnumDyeColor.byMetadata(l));
				GlStateManager.color(afloat1[0] * (1.0F - f) + afloat2[0] * f, afloat1[1] * (1.0F - f) + afloat2[1] * f,
						afloat1[2] * (1.0F - f) + afloat2[2] * f);
			} else {
				float[] afloat = EntityChromaCow.getDyeRgb(cowIn.getHideColor());
				GlStateManager.color(afloat[0], afloat[1], afloat[2]);
			}
			
			this.model.setModelAttributes(this.renderer.getMainModel());
			this.model.setLivingAnimations(cowIn, limbSwing, limbSwingAmount, partialTicks);
			this.model.render(cowIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		}
	}

	@Override
	public boolean shouldCombineTextures() {
		return true;
	}
}
