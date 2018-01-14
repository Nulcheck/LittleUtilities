package lu.com.mce.events;

import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Items;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HitEvent {
	@SubscribeEvent
	public void setEntityOnFire(AttackEntityEvent e) {
		if (e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.BLAZE_ROD
				&& e.getTarget() instanceof EntityLiving) {
			e.getTarget().setFire(8);
		}
	}
}