package mce.lu.client.render.entity;

import mce.lu.client.render.entity.layers.LayerChromaCowHide;
import mce.lu.common.entity.passive.EntityChromaCow;
import mce.lu.common.util.References;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderChromaCow extends RenderLiving<EntityChromaCow> {
	private static final ResourceLocation CHROMA_COW_BASE = new ResourceLocation(References.MOD_ID,
			"textures/entity/chroma_cow/chroma_cow.png");

	public RenderChromaCow(RenderManager manager) {
		super(manager, new ModelCow(), 0.7f);
		this.addLayer(new LayerChromaCowHide(this));
	}

	protected ResourceLocation getEntityTexture(EntityChromaCow cow) {
		return CHROMA_COW_BASE;
	}
}
