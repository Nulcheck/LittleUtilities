package mce.lu.common.event;

import java.lang.reflect.Field;

import mce.lu.common.entity.EntityFireproofItem;
import mce.lu.common.item.ItemLavaLily;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class FireproofItemEvent {
	private static Field ageField = ObfuscationReflectionHelper.findField(EntityItem.class, "age");
	private static Field delayField = ObfuscationReflectionHelper.findField(EntityItem.class, "delayBeforeCanPickup");

	@SubscribeEvent
	public void onItemCreate(EntityJoinWorldEvent event) {
		Entity entity = event.getEntity();
		World world = event.getWorld();

		if (entity instanceof EntityItem && !(entity instanceof EntityFireproofItem)) {
			EntityItem item = (EntityItem) entity;
			ItemStack stack = item.getItem();

			if (stack.getItem() instanceof ItemLavaLily) {
				ItemStack newStack = stack.copy();
				EntityFireproofItem fItem = new EntityFireproofItem(world, item.posX, item.posY, item.posZ, newStack);

				int age = item.getAge();
				try {
					int delay = delayField.getInt(item);
					delayField.setInt(fItem, delay);
					ageField.setInt(fItem, age);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}

				fItem.motionX = item.motionX;
				fItem.motionY = item.motionY;
				fItem.motionZ = item.motionZ;

				world.removeEntity(item);
				world.spawnEntity(fItem);
				event.setCanceled(true);
			}
		}
	}
}
