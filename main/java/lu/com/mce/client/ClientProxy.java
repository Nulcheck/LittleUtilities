package lu.com.mce.client;

import java.util.Random;

import lu.com.mce.common.CommonProxy;
import lu.com.mce.entity.particles.EntityParticleFX;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy {
	public void registerRenders() {
	}

	//// Particles
	public void spawnParticle(World world, double posX, double posY, double posZ, String type) {
		Minecraft minecraft = Minecraft.getMinecraft();
		Random rand = world.rand;

		if (minecraft != null && minecraft.renderViewEntity != null && minecraft.effectRenderer != null) {
			int particleSetting = minecraft.gameSettings.particleSetting;

			if (particleSetting == 1 && world.rand.nextInt(3) == 0) {
				particleSetting = 2;
			}

			double entityX = minecraft.renderViewEntity.posX - posX;
			double entityY = minecraft.renderViewEntity.posY - posY;
			double entityZ = minecraft.renderViewEntity.posZ - posZ;

			if (entityX * entityX + entityY * entityY + entityZ * entityZ > 16.0D * 16.0D) {
				return;
			} else if (particleSetting > 1) {
				return;
			} else {
				EntityFX particle = null;

				// world, x, y, z, moveX, moveY, moveZ, red, green, blue, index
				if (type.equals("ghastTearFx")) {
					particle = new EntityParticleFX(world, posX + rand.nextDouble(), posY + rand.nextDouble(),
							posZ + rand.nextDouble(), 0d, 0d, 0d, 0.8f, 0.8f, 0.85f, 3);
				}

				else if (type.equals("blazeRodFx")) {
					particle = new EntityParticleFX(world, posX + rand.nextDouble(), posY + rand.nextDouble(),
							posZ + rand.nextDouble(), 0d, 0d, 0d, 0.9f, 0.6f, 0.3f, 3);
				}

				if (particle != null) {
					minecraft.effectRenderer.addEffect(particle);
				}
			}
		}
	}
}
