package lu.com.mce.proxy;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}

	public void spawnParticle(World world, double posX, double posY, double posZ, String type) {
		Minecraft minecraft = Minecraft.getMinecraft();
		Random rand = world.rand;

		if (minecraft != null && minecraft.getRenderViewEntity() != null && minecraft.effectRenderer != null) {
			int particleSetting = minecraft.gameSettings.particleSetting;
			if (particleSetting == 1 && world.rand.nextInt(3) == 0)
				particleSetting = 2;

			double entityX = minecraft.getRenderViewEntity().posX - posX;
			double entityY = minecraft.getRenderViewEntity().posY - posY;
			double entityZ = minecraft.getRenderViewEntity().posZ - posZ;

			if (entityX * entityX + entityY * entityY + entityZ * entityZ > 16d * 16d) {
				return;
			} else if (particleSetting > 1) {
				return;
			} else {
				Particle fx = null;

				// world, moveX, moveY, moveZ, speedX, speedY, speedZ
				if (type.equals("ghastTearFX")) {
					fx = new Particle(world, posX + rand.nextDouble(), posY + rand.nextDouble(),
							posZ + rand.nextDouble(), 0d, 0d, 0d);
					fx.setRBGColorF(0.8f, 0.8f, 0.85f);
					fx.setParticleTextureIndex(EnumParticleTypes.EXPLOSION_NORMAL.getParticleID());
					fx.multiplyVelocity(0f);
				}

				else if (type.equals("blazeRodFX")) {
					fx = new Particle(world, posX + rand.nextDouble(), posY + rand.nextDouble(),
							posZ + rand.nextDouble(), 0d, 0d, 0d);
					fx.setRBGColorF(0.9f, 0.6f, 0.3f);
					fx.setParticleTextureIndex(EnumParticleTypes.EXPLOSION_NORMAL.getParticleID());
					fx.multiplyVelocity(0f);
				}

				else if (type.equals("netherStarFX")) {
					fx = new Particle(world, posX + rand.nextDouble(), posY + rand.nextDouble(),
							posZ + rand.nextDouble(), 0d, 0d, 0d);
					fx.setRBGColorF(1f, 1f, 1f);
					fx.setParticleTextureIndex(EnumParticleTypes.CRIT_MAGIC.getParticleID());
					fx.multiplyVelocity(0f);
				}

				else if (type.equals("enderPearlFX")) {
					fx = new Particle(world, posX + rand.nextDouble(), posY + rand.nextDouble(),
							posZ + rand.nextDouble(), 0d, 0d, 0d);
					fx.setRBGColorF(1f, 0.3f, 0.9f);
					fx.setParticleTextureIndex(EnumParticleTypes.FALLING_DUST.getParticleID());
					fx.multiplyVelocity(0f);
				}

				else if (type.equals("enderEyeFX")) {
					fx = new Particle(world, posX + rand.nextDouble(), posY + rand.nextDouble(),
							posZ + rand.nextDouble(),0d, 0d, 0d);
					fx.setRBGColorF(1f, 0.3f, 0.9f);
					fx.setParticleTextureIndex(EnumParticleTypes.FALLING_DUST.getParticleID());
					fx.multiplyVelocity(0f);
				}

				if (fx != null) {
					minecraft.effectRenderer.addEffect(fx);
				}
			}
		}
	}
}
