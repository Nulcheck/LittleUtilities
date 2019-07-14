package mce.lu.common.core.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import mce.lu.common.entity.passive.EntityChromaCow;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.advancements.ICriterionTrigger;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CommonProxy {
	private static Method CriteriaRegister;

	public void preInit(FMLPreInitializationEvent e) {
		EntityChromaCow.initialize(0);
	}

	public void init(FMLInitializationEvent e) {
	}

	public static <T extends ICriterionInstance> ICriterionTrigger<T> registerAdvancementTrigger(
			ICriterionTrigger<T> trigger) {
		if (CriteriaRegister == null) {
			CriteriaRegister = ReflectionHelper.findMethod(CriteriaTriggers.class, "register", "func_192118_a",
					ICriterionTrigger.class);
			CriteriaRegister.setAccessible(true);
		}

		try {
			trigger = (ICriterionTrigger<T>) CriteriaRegister.invoke(null, trigger);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException err) {
			err.printStackTrace();
		}

		return trigger;
	}
}
