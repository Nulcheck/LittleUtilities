package mce.lu.common.core.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import mce.lu.common.event.trigger.ModTriggers;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.ICriterionTrigger;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CommonProxy {
	public void preInit(FMLPreInitializationEvent e) {
	}

	public void init(FMLInitializationEvent e) {
		Method method;
		method = ReflectionHelper.findMethod(CriteriaTriggers.class, "register", "func_192118_a",
				ICriterionTrigger.class);
		method.setAccessible(true);

		for (int i = 0; i < ModTriggers.TRIGGER_ARRAY.length; i++) {
			try {
				method.invoke(null, ModTriggers.TRIGGER_ARRAY[i]);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException err) {
				err.printStackTrace();
			}
		}
	}
}
