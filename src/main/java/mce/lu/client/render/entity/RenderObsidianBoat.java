package mce.lu.client.render.entity;

import mce.lu.client.model.ObsidianBoatModel;
import mce.lu.common.entity.EntityObsidianBoat;
import mce.lu.common.util.References;
import net.minecraft.client.model.IMultipassModel;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderObsidianBoat extends Render<EntityObsidianBoat> {
	private static final ResourceLocation BOAT_TEXTURE = new ResourceLocation(References.MOD_ID,
			"textures/entity/obsidian_boat.png");
	protected ObsidianBoatModel modelBoat = new ObsidianBoatModel();

	public RenderObsidianBoat(RenderManager renderManagerIn) {
		super(renderManagerIn);
		this.shadowSize = 0.5F;
	}

	public void doRender(EntityObsidianBoat entity, double x, double y, double z, float entityYaw, float partialTicks) {
		GlStateManager.pushMatrix();
		this.setupTranslation(x, y, z);
		this.setupRotation(entity, entityYaw, partialTicks);
		this.bindEntityTexture(entity);

		if (this.renderOutlines) {
			GlStateManager.enableColorMaterial();
			GlStateManager.enableOutlineMode(this.getTeamColor(entity));
		}

		this.modelBoat.render(entity, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

		if (this.renderOutlines) {
			GlStateManager.disableOutlineMode();
			GlStateManager.disableColorMaterial();
		}

		GlStateManager.popMatrix();
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	public void setupRotation(EntityObsidianBoat p_188311_1_, float p_188311_2_, float p_188311_3_) {
		GlStateManager.rotate(180.0F - p_188311_2_, 0.0F, 1.0F, 0.0F);
		float f = (float) p_188311_1_.getTimeSinceHit() - p_188311_3_;
		float f1 = p_188311_1_.getDamageTaken() - p_188311_3_;

		if (f1 < 0.0F) {
			f1 = 0.0F;
		}

		if (f > 0.0F) {
			GlStateManager.rotate(MathHelper.sin(f) * f * f1 / 10.0F * (float) p_188311_1_.getForwardDirection(), 1.0F,
					0.0F, 0.0F);
		}

		GlStateManager.scale(-1.0F, -1.0F, 1.0F);
	}

	public void setupTranslation(double x, double y, double z) {
		GlStateManager.translate((float) x, (float) y + 0.375F, (float) z);
	}

	@Override
	public RenderManager getRenderManager() {
		return super.getRenderManager();
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(EntityObsidianBoat entity) {
		return BOAT_TEXTURE;
	}

	public boolean isMultipass() {
		return true;
	}

	public void renderMultipass(EntityObsidianBoat entity, double x, double y, double z, float pitch, float yaw) {
		GlStateManager.pushMatrix();
		this.setupTranslation(x, y, z);
		this.setupRotation(entity, pitch, yaw);
		this.bindEntityTexture(entity);
		((IMultipassModel) this.modelBoat).renderMultipass(entity, yaw, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GlStateManager.popMatrix();
	}
}