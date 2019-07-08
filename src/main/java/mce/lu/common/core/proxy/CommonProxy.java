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

	public boolean handleMaterialAcceleration(Entity entity, Material mat) {
		World world = entity.world;
		AxisAlignedBB AABB = entity.getEntityBoundingBox().grow(0.0D, -0.4000000059604645D, 0.0D).shrink(0.001D);

		int aaXMin = MathHelper.floor(AABB.minX);
		int aaXMax = MathHelper.ceil(AABB.maxX);
		int aaYMin = MathHelper.floor(AABB.minY);
		int aaYMax = MathHelper.ceil(AABB.maxY);
		int aaZMin = MathHelper.floor(AABB.minZ);
		int aaZMax = MathHelper.ceil(AABB.maxZ);

		boolean successful = false;
		Vec3d vec = Vec3d.ZERO;
		BlockPos.PooledMutableBlockPos poolPos = BlockPos.PooledMutableBlockPos.retain();

		for (int currentAAX = aaXMin; currentAAX < aaXMax; ++currentAAX) {
			for (int currentAAY = aaYMin; currentAAY < aaYMax; ++currentAAY) {
				for (int currentAAZ = aaZMin; currentAAZ < aaZMax; ++currentAAZ) {
					poolPos.setPos(currentAAX, currentAAY, currentAAZ);
					IBlockState state = world.getBlockState(poolPos);
					Block block = state.getBlock();

					Boolean result = block.isEntityInsideMaterial(world, poolPos, state, entity, aaYMax, mat, false);
					if (result != null && result == true) {
						successful = true;
						vec = block.modifyAcceleration(world, poolPos, entity, vec);
						continue;
					} else if (result != null && result == false)
						continue;

					if (state.getMaterial() == mat) {
						double newAAY = currentAAY + 1
								- BlockLiquid.getLiquidHeightPercent(state.getValue(BlockLiquid.LEVEL).intValue());

						if (aaYMax >= newAAY) {
							successful = true;
							vec = block.modifyAcceleration(world, poolPos, entity, vec);
						}
					}
				}
			}
		}

		poolPos.release();

		if (vec.lengthVector() > 0.0D && entity.isPushedByWater()) {
			vec = vec.normalize();
			double addMotion = 0.014D;
			entity.motionX += vec.x * addMotion;
			entity.motionY += vec.y * addMotion;
			entity.motionZ += vec.z * addMotion;
		}

		entity.fallDistance = 0.0F;
		return successful;
	}
}
