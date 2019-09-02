package mce.lu.common.item;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.xendric.xenlib.common.core.item.ItemBase;

public class LavaBottle extends ItemBase {
	public LavaBottle(String name, List<Item> itemList) {
		super(name, itemList);
	}

	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);
		RayTraceResult trace = this.rayTrace(world, player, true);

		if (trace == null)
			return new ActionResult(EnumActionResult.PASS, stack);
		else {
			if (trace.typeOfHit == RayTraceResult.Type.BLOCK) {
				BlockPos pos = trace.getBlockPos();

				if (world.getBlockState(pos).getMaterial() == Material.LAVA) {
					world.playSound(player, player.posX, player.posY, player.posZ, SoundEvents.ITEM_BOTTLE_EMPTY,
							SoundCategory.NEUTRAL, 1f, 1f);
					return new ActionResult(EnumActionResult.SUCCESS,
							this.turnBottleIntoItem(stack, player, new ItemStack(Items.GLASS_BOTTLE)));
				}
			}
			return new ActionResult(EnumActionResult.PASS, stack);
		}
	}

	protected ItemStack turnBottleIntoItem(ItemStack heldItem, EntityPlayer player, ItemStack newItem) {
		heldItem.shrink(1);
		player.addStat(StatList.getObjectUseStats(this));

		if (heldItem.isEmpty())
			return newItem;
		else {
			if (!player.inventory.addItemStackToInventory(newItem))
				player.dropItem(newItem, false);
			return heldItem;
		}
	}
}
