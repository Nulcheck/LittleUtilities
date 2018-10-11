package lu.com.mce.util;

import java.util.Random;

import lu.com.mce.entity.particles.ParticleEnderFX;
import lu.com.mce.entity.particles.ParticleMagicFX;
import lu.com.mce.entity.particles.ParticleSmokeFX;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.world.World;

public class ParticleManager {
	private static Minecraft minecraft = Minecraft.getMinecraft();
	
	/**
	 * 
	 * @param world
	 * @param posX
	 * @param posY
	 * @param posZ
	 * @param type
	 * @return
	 */
	public static Particle spawnParticle(World world, double posX, double posY, double posZ, String type) {
		Random rand = world.rand;
		
		if (minecraft != null && minecraft.getRenderViewEntity() != null && minecraft.effectRenderer != null) {
			int particleSetting = minecraft.gameSettings.particleSetting;
			if (particleSetting == 1 && world.rand.nextInt(3) == 0)
				particleSetting = 2;

			double entityX = minecraft.getRenderViewEntity().posX - posX;
			double entityY = minecraft.getRenderViewEntity().posY - posY;
			double entityZ = minecraft.getRenderViewEntity().posZ - posZ;

			if (entityX * entityX + entityY * entityY + entityZ * entityZ > 16d * 16d) {
				return null;
			} else if (particleSetting > 1) {
				return null;
			} else {
				Particle fx = null;

				// world, moveX, moveY, moveZ, speedX, speedY, speedZ, size
				if (type.equals("ghastTearFX")) {
					fx = new ParticleSmokeFX(world, posX + rand.nextDouble(), posY + rand.nextDouble(),
							posZ + rand.nextDouble(), 0d, 0d, 0d);
					fx.setRBGColorF(0.8f, 0.8f, 0.85f);
					fx.multipleParticleScaleBy(0.3f);
					fx.setMaxAge(8);
				}

				else if (type.equals("blazeRodFX")) {
					fx = new ParticleSmokeFX(world, posX + rand.nextDouble(), posY + rand.nextDouble(),
							posZ + rand.nextDouble(), 0d, 0d, 0d);
					fx.setRBGColorF(0.9f, 0.6f, 0.3f);
					fx.multipleParticleScaleBy(0.3f);
					fx.setMaxAge(8);
				}

				else if (type.equals("netherStarFX")) {
					fx = new ParticleMagicFX(world, posX + rand.nextDouble(), posY + rand.nextDouble(),
							posZ + rand.nextDouble(), 0d, 0d, 0d);
					fx.setRBGColorF(1f, 1f, 1f);
					fx.setMaxAge(5);
					fx.nextTextureIndexX();
				}

				if (type.equals("enderPearlFX")) {
					fx = new ParticleEnderFX(world, posX + rand.nextDouble(), posY + rand.nextDouble(),
							posZ + rand.nextDouble(), 0d, 0d, 0d);
					fx.setRBGColorF(1f, 0.3f, 0.9f);
					fx.setMaxAge(10);
				}

				else if (type.equals("enderEyeFX")) {
					fx = new ParticleEnderFX(world, posX + rand.nextDouble(), posY + rand.nextDouble(),
							posZ + rand.nextDouble(), 0d, 0d, 0d);
					fx.setRBGColorF(1f, 0.3f, 0.9f);
					fx.setMaxAge(10);
				}

				if (fx != null) {
					Minecraft.getMinecraft().effectRenderer.addEffect(fx);
					return fx;
				}
			}
		}
		return null;
	}
}
