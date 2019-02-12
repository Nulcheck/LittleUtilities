package mce.lu.common.item;

import javax.annotation.Nullable;

import mce.lu.common.util.Util;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.event.ForgeEventFactory;

public class Fertilizer extends ItemBase {
	public Fertilizer(String name) {
		super(name);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {
		ItemStack stack = player.getHeldItem(hand);

		if (!player.canPlayerEdit(pos.offset(facing), facing, stack))
			return EnumActionResult.FAIL;
		else {
			if (applyFertilizer(stack, world, pos, player, hand)) {
				if (!world.isRemote)
					world.playEvent(2005, pos, 0);
				return EnumActionResult.SUCCESS;
			}

			return EnumActionResult.PASS;
		}
	}

	public static boolean applyFertilizer(ItemStack stack, World world, BlockPos pos) {
		if (world instanceof WorldServer)
			return applyFertilizer(stack, world, pos, FakePlayerFactory.getMinecraft((WorldServer) world), null);
		return false;
	}

	public static boolean applyFertilizer(ItemStack stack, World world, BlockPos pos, EntityPlayer player,
			@Nullable EnumHand hand) {
		IBlockState state = world.getBlockState(pos);

		int hook = ForgeEventFactory.onApplyBonemeal(player, world, pos, state, stack, hand);
		if (hook != 0)
			return hook > 0;

		if (state.getBlock() instanceof IGrowable) {
			IGrowable plant = (IGrowable) state.getBlock();

			if (plant.canGrow(world, pos, state, world.isRemote)) {
				if (!world.isRemote) {
					if (plant.canUseBonemeal(world, world.rand, pos, state)) {
						if (Util.doesMethodExist(BlockCrops.class, "func_185525_y"))
							Util.setMethod(BlockCrops.class, "func_185525_y", true);
						else if (state.getBlock() instanceof BlockSapling)
							world.setBlockState(pos, state.withProperty(BlockSapling.STAGE, 1), 2);
						else
							plant.grow(world, world.rand, pos, state);
					}
					stack.shrink(1);
				}
				return true;
			}
		}
		return false;
	}
}
