package lu.com.mce.entity.particles;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

public class EntityParticleFX extends EntityFX {
	float dustParticleScale;
	int index, multi;

	/**
	 * 
	 * @param world
	 * @param moveX
	 * @param moveY
	 * @param moveZ
	 * @param size
	 * @param x
	 * @param y
	 * @param z
	 * @param r
	 * @param g
	 * @param b
	 * @param index
	 * @param multi
	 */
	public EntityParticleFX(World world, double moveX, double moveY, double moveZ, double size, double x, double y, double z, float r, float g, float b, int index, int multi) {
		super(world, moveX, moveY, moveZ, x, y, z);
		this.motionX *= 0.10000000149011612D;
		this.motionY *= 0.25000000149011612D;
		this.motionZ *= 0.10000000149011612D;

		if (y == 0.0F) {
			y = 1.0F;
		}

		this.index = index;
		this.multi = multi;

		float f4 = (float) Math.random() * 0.2F + 0.6F;
		this.particleRed = (float) (((Math.random() * 0.20000000298023224D) + r) * y * f4);
		this.particleGreen = (float) (((Math.random() * 0.20000000298023224D) + g) * y * f4);
		this.particleBlue = (float) (((Math.random() * 0.20000000298023224D) + b) * y * f4);
		this.particleScale *= 0.5F;
		this.particleScale *= size;
		this.dustParticleScale = this.particleScale;
		this.particleMaxAge = (int) (8.0D / (Math.random() * 0.8D + .2D));
		this.particleMaxAge = (int) ((float) this.particleMaxAge * size);
		this.noClip = false;
	}

	public void renderParticle(Tessellator tes, float moveX, float moveY, float moveZ, float x, float y, float z) {
		float f6 = ((float) this.particleAge + moveX) / (float) this.particleMaxAge * 32.0F;

		if (f6 < 0.0F) {
			f6 = 0.0F;
		}

		if (f6 > 1.0F) {
			f6 = 1.0F;
		}

		this.particleScale = this.dustParticleScale * f6;
		super.renderParticle(tes, moveX, moveY, moveZ, x, y, z);
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;

		if (this.particleAge++ >= this.particleMaxAge) {
			this.setDead();
		}

		this.setParticleTextureIndex(this.index - this.particleAge * this.multi / this.particleMaxAge);
		if (this.worldObj.isRemote) {
			this.moveEntity(this.motionX, this.motionY, this.motionZ);
		}

		if (this.posY == this.prevPosY) {
			this.motionX *= 1.1D;
			this.motionZ *= 1.1D;
		}

		this.motionX *= 0.9599999785423279D;
		this.motionY *= 0.9599999785423279D;
		this.motionZ *= 0.9599999785423279D;

		if (this.onGround) {
			this.motionX *= 0.699999988079071D;
			this.motionZ *= 0.699999988079071D;
		}
	}
}
