package mce.lu.common.event;

import mce.lu.common.item.ModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteractSpecific;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CureEvent {
	@SubscribeEvent
	public void cureZombie(EntityInteractSpecific e) {
		if (!e.getWorld().isRemote && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == ModItems.RED_PILL) {
			if (e.getTarget() instanceof EntityZombieVillager) {
				EntityVillager villager = new EntityVillager(e.getWorld());
				e.getTarget().getEntityWorld().setEntityState(e.getTarget(), (byte) 16);

				// Set villager traits from zombie villager
				villager.copyLocationAndAnglesFrom(e.getTarget());
				villager.setProfession(((EntityZombieVillager) e.getTarget()).getForgeProfession());
				villager.finalizeMobSpawn(e.getWorld().getDifficultyForLocation(new BlockPos(villager)), (IEntityLivingData) null, false);
				villager.setLookingForHome();

				// Remove zombie villager
				e.getWorld().removeEntity(e.getTarget());
				villager.setNoAI(((EntityLiving) e.getTarget()).isAIDisabled());

				if (((EntityLivingBase) e.getTarget()).isChild()) {
					villager.setGrowingAge(-24000);
				}

				// Set custom name if it had one
				if (e.getTarget().hasCustomName()) {
					villager.setCustomNameTag(e.getTarget().getCustomNameTag());
					villager.setAlwaysRenderNameTag(e.getTarget().getAlwaysRenderNameTag());
				}

				// Spawn normal villager (with the profession)
				e.getWorld().spawnEntity(villager);

				EntityPlayer entityplayer = e.getWorld().getPlayerEntityByUUID(e.getEntityPlayer().getUniqueID());
				if (entityplayer instanceof EntityPlayerMP)
					CriteriaTriggers.CURED_ZOMBIE_VILLAGER.trigger((EntityPlayerMP) entityplayer,
							(EntityZombie) e.getTarget(), villager);

				e.getWorld().playEvent((EntityPlayer) null, 1027,
						new BlockPos((int) e.getPos().getX(), (int) e.getPos().getY(), (int) e.getPos().getZ()), 0);

				if (!e.getEntityPlayer().isCreative())
					e.getEntityPlayer().getHeldItemMainhand().shrink(1);
			}
		}
	}
}
