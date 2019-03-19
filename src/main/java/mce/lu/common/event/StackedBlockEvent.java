package mce.lu.common.event;

import mce.lu.common.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class StackedBlockEvent {
	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public static void onInteractEvent(PlayerInteractEvent e) {
		BlockPos pos = e.getPos();
		IBlockState state = e.getWorld().getBlockState(pos);
		ItemStack stack = e.getEntityPlayer().getHeldItemMainhand();
		Block block = e.getWorld().getBlockState(pos).getBlock();

		boolean sneak = e.getEntityPlayer().isSneaking();
		boolean creative = e.getEntityPlayer().isCreative();

		// Usable Blocks
		if (sneak && !stack.isEmpty() && stack.getItem() == Items.ENDER_PEARL && block == ModBlocks.ENDER_PEARL_BLOCK
				&& block.getMetaFromState(state) < 9 && block.getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, block.getStateFromMeta(block.getMetaFromState(state) - 1));

			if (!creative)
				stack.shrink(1);
		}

		// Edible Blocks
		else if (sneak && !stack.isEmpty() && stack.getItem() == Items.PORKCHOP && block == ModBlocks.PORK_BLOCK
				&& block.getMetaFromState(state) < 9 && block.getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, block.getStateFromMeta(block.getMetaFromState(state) - 1));

			if (!creative)
				stack.shrink(1);
		}

		else if (sneak && !stack.isEmpty() && stack.getItem() == Items.COOKED_PORKCHOP
				&& block == ModBlocks.COOKED_PORK_BLOCK && block.getMetaFromState(state) < 9
				&& block.getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, block.getStateFromMeta(block.getMetaFromState(state) - 1));

			if (!creative)
				stack.shrink(1);
		}

		else if (sneak && !stack.isEmpty() && stack.getItem() == Items.BEEF && block == ModBlocks.BEEF_BLOCK
				&& block.getMetaFromState(state) < 9 && block.getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, block.getStateFromMeta(block.getMetaFromState(state) - 1));

			if (!creative)
				stack.shrink(1);
		}

		else if (sneak && !stack.isEmpty() && stack.getItem() == Items.COOKED_BEEF
				&& block == ModBlocks.COOKED_BEEF_BLOCK && block.getMetaFromState(state) < 9
				&& block.getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, block.getStateFromMeta(block.getMetaFromState(state) - 1));

			if (!creative)
				stack.shrink(1);
		}

		else if (sneak && !stack.isEmpty() && stack.getItem() == Items.CHICKEN && block == ModBlocks.CHICKEN_BLOCK
				&& block.getMetaFromState(state) < 9 && block.getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, block.getStateFromMeta(block.getMetaFromState(state) - 1));

			if (!creative)
				stack.shrink(1);
		}

		else if (sneak && !stack.isEmpty() && stack.getItem() == Items.COOKED_CHICKEN
				&& block == ModBlocks.COOKED_CHICKEN_BLOCK && block.getMetaFromState(state) < 9
				&& block.getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, block.getStateFromMeta(block.getMetaFromState(state) - 1));

			if (!creative)
				stack.shrink(1);
		}

		else if (sneak && !stack.isEmpty() && stack.getItem() == Items.FISH && stack.getItemDamage() == 0
				&& block == ModBlocks.COD_BLOCK && block.getMetaFromState(state) < 9
				&& block.getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, block.getStateFromMeta(block.getMetaFromState(state) - 1));

			if (!creative)
				stack.shrink(1);
		}

		else if (sneak && !stack.isEmpty() && stack.getItem() == Items.COOKED_FISH && stack.getItemDamage() == 0
				&& block == ModBlocks.COOKED_COD_BLOCK && block.getMetaFromState(state) < 9
				&& block.getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, block.getStateFromMeta(block.getMetaFromState(state) - 1));

			if (!creative)
				stack.shrink(1);
		}

		else if (sneak && !stack.isEmpty() && stack.getItem() == Items.FISH && stack.getItemDamage() == 1
				&& block == ModBlocks.SALMON_BLOCK && block.getMetaFromState(state) < 9
				&& block.getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, block.getStateFromMeta(block.getMetaFromState(state) - 1));

			if (!creative)
				stack.shrink(1);
		}

		else if (sneak && !stack.isEmpty() && stack.getItem() == Items.COOKED_FISH && stack.getItemDamage() == 1
				&& block == ModBlocks.COOKED_SALMON_BLOCK && block.getMetaFromState(state) < 9
				&& block.getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, block.getStateFromMeta(block.getMetaFromState(state) - 1));

			if (!creative)
				stack.shrink(1);
		}

		else if (sneak && !stack.isEmpty() && stack.getItem() == Items.FISH && stack.getItemDamage() == 2
				&& block == ModBlocks.TROPICAL_FISH_BLOCK && block.getMetaFromState(state) < 9
				&& block.getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, block.getStateFromMeta(block.getMetaFromState(state) - 1));

			if (!creative)
				stack.shrink(1);
		}

		else if (sneak && !stack.isEmpty() && stack.getItem() == Items.FISH && stack.getItemDamage() == 3
				&& block == ModBlocks.PUFFERFISH_BLOCK && block.getMetaFromState(state) < 9
				&& block.getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, block.getStateFromMeta(block.getMetaFromState(state) - 1));

			if (!creative)
				stack.shrink(1);
		}

		else if (sneak && !stack.isEmpty() && stack.getItem() == Items.ROTTEN_FLESH
				&& block == ModBlocks.ROTTEN_FLESH_BLOCK && block.getMetaFromState(state) < 9
				&& block.getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, block.getStateFromMeta(block.getMetaFromState(state) - 1));

			if (!creative)
				stack.shrink(1);
		}

		else if (sneak && !stack.isEmpty() && stack.getItem() == Items.APPLE && block == ModBlocks.APPLE_BLOCK
				&& block.getMetaFromState(state) < 9 && block.getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, block.getStateFromMeta(block.getMetaFromState(state) - 1));

			if (!creative)
				stack.shrink(1);
		}

		else if (sneak && !stack.isEmpty() && stack.getItem() == Items.GOLDEN_APPLE && stack.getItemDamage() == 0
				&& block == ModBlocks.GOLDEN_APPLE_BLOCK && block.getMetaFromState(state) < 9
				&& block.getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, block.getStateFromMeta(block.getMetaFromState(state) - 1));

			if (!creative)
				stack.shrink(1);
		}

		else if (sneak && !stack.isEmpty() && stack.getItem() == Items.GOLDEN_APPLE && stack.getItemDamage() == 1
				&& block == ModBlocks.NOTCH_APPLE_BLOCK && block.getMetaFromState(state) < 9
				&& block.getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, block.getStateFromMeta(block.getMetaFromState(state) - 1));

			if (!creative)
				stack.shrink(1);
		}

		else if (sneak && !stack.isEmpty() && stack.getItem() == Items.BREAD && block == ModBlocks.BREAD_BLOCK
				&& block.getMetaFromState(state) < 9 && block.getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, block.getStateFromMeta(block.getMetaFromState(state) - 1));

			if (!creative)
				stack.shrink(1);
		}

		else if (sneak && !stack.isEmpty() && stack.getItem() == Items.COOKIE && block == ModBlocks.COOKIE_BLOCK
				&& block.getMetaFromState(state) < 9 && block.getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, block.getStateFromMeta(block.getMetaFromState(state) - 1));

			if (!creative)
				stack.shrink(1);
		}

		else if (sneak && !stack.isEmpty() && stack.getItem() == Items.SPIDER_EYE && block == ModBlocks.SPIDER_EYE_BLOCK
				&& block.getMetaFromState(state) < 9 && block.getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, block.getStateFromMeta(block.getMetaFromState(state) - 1));

			if (!creative)
				stack.shrink(1);
		}

		else if (sneak && !stack.isEmpty() && stack.getItem() == Items.CARROT && block == ModBlocks.CARROT_BLOCK
				&& block.getMetaFromState(state) < 9 && block.getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, block.getStateFromMeta(block.getMetaFromState(state) - 1));

			if (!creative)
				stack.shrink(1);
		}

		else if (sneak && !stack.isEmpty() && stack.getItem() == Items.GOLDEN_CARROT
				&& block == ModBlocks.GOLDEN_CARROT_BLOCK && block.getMetaFromState(state) < 9
				&& block.getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, block.getStateFromMeta(block.getMetaFromState(state) - 1));

			if (!creative)
				stack.shrink(1);
		}

		else if (sneak && !stack.isEmpty() && stack.getItem() == Items.POTATO && block == ModBlocks.POTATO_BLOCK
				&& block.getMetaFromState(state) < 9 && block.getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, block.getStateFromMeta(block.getMetaFromState(state) - 1));

			if (!creative)
				stack.shrink(1);
		}

		else if (sneak && !stack.isEmpty() && stack.getItem() == Items.BAKED_POTATO
				&& block == ModBlocks.BAKED_POTATO_BLOCK && block.getMetaFromState(state) < 9
				&& block.getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, block.getStateFromMeta(block.getMetaFromState(state) - 1));

			if (!creative)
				stack.shrink(1);
		}

		else if (sneak && !stack.isEmpty() && stack.getItem() == Items.POISONOUS_POTATO
				&& block == ModBlocks.POISONOUS_POTATO_BLOCK && block.getMetaFromState(state) < 9
				&& block.getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, block.getStateFromMeta(block.getMetaFromState(state) - 1));

			if (!creative)
				stack.shrink(1);
		}

		else if (sneak && !stack.isEmpty() && stack.getItem() == Items.BEETROOT && block == ModBlocks.BEETROOT_BLOCK
				&& block.getMetaFromState(state) < 9 && block.getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, block.getStateFromMeta(block.getMetaFromState(state) - 1));

			if (!creative)
				stack.shrink(1);
		}
	}
}
