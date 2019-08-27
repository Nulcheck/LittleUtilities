package mce.lu.common.item;

import mce.lu.common.block.ModBlocks;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.util.BlockSnapshot;
import net.minecraftforge.event.ForgeEventFactory;

public class ItemLavaLily extends ItemColoredBase {
	public ItemLavaLily(Block block) {
		super(block, false);
	}

	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);
		RayTraceResult trace = this.rayTrace(world, player, true);

		if (trace == null) {
			return new ActionResult<ItemStack>(EnumActionResult.PASS, stack);
		} else {
			if (trace.typeOfHit == RayTraceResult.Type.BLOCK) {
				BlockPos tracePos = trace.getBlockPos();

				if (!world.isBlockModifiable(player, tracePos)
						|| !player.canPlayerEdit(tracePos.offset(trace.sideHit), trace.sideHit, stack)) {
					return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack);
				}

				BlockPos posUp = tracePos.up();
				IBlockState iblockstate = world.getBlockState(tracePos);

				if (iblockstate.getMaterial() == Material.LAVA
						&& ((Integer) iblockstate.getValue(BlockLiquid.LEVEL)).intValue() == 0
						&& world.isAirBlock(posUp)) {
					// special case for handling block placement with lilies
					BlockSnapshot blocksnapshot = BlockSnapshot.getBlockSnapshot(world, posUp);
					world.setBlockState(posUp, ModBlocks.LAVA_LILY.getDefaultState());
					if (ForgeEventFactory.onPlayerBlockPlace(player, blocksnapshot, EnumFacing.UP, hand).isCanceled()) {
						blocksnapshot.restore(true, false);
						return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack);
					}

					world.setBlockState(posUp, ModBlocks.LAVA_LILY.getDefaultState(), 11);

					if (player instanceof EntityPlayerMP)
						CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP) player, posUp, stack);

					if (!player.capabilities.isCreativeMode)
						stack.shrink(1);

					player.addStat(StatList.getObjectUseStats(this));
					world.playSound(player, tracePos, SoundEvents.BLOCK_WATERLILY_PLACE, SoundCategory.BLOCKS, 1.0F,
							1.0F);
					return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
				}
			}

			return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack);
		}
	}
}
