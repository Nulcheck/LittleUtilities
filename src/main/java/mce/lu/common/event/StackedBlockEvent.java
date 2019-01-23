package mce.lu.common.event;

import mce.lu.common.block.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
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

		// Usable Blocks
		if (e.getEntityPlayer().isSneaking() && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.ENDER_PEARL
				&& e.getWorld().getBlockState(pos).getBlock() == ModBlocks.ENDER_PEARL_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		// Edible Blocks
		else if (e.getEntityPlayer().isSneaking() && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.PORKCHOP
				&& e.getWorld().getBlockState(pos).getBlock() == ModBlocks.PORK_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.COOKED_PORKCHOP
				&& e.getWorld().getBlockState(pos).getBlock() == ModBlocks.COOKED_PORK_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.BEEF
				&& e.getWorld().getBlockState(pos).getBlock() == ModBlocks.BEEF_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.COOKED_BEEF
				&& e.getWorld().getBlockState(pos).getBlock() == ModBlocks.COOKED_BEEF_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.CHICKEN
				&& e.getWorld().getBlockState(pos).getBlock() == ModBlocks.CHICKEN_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.COOKED_CHICKEN
				&& e.getWorld().getBlockState(pos).getBlock() == ModBlocks.COOKED_CHICKEN_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.FISH
				&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 0
				&& e.getWorld().getBlockState(pos).getBlock() == ModBlocks.COD_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.COOKED_FISH
				&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 0
				&& e.getWorld().getBlockState(pos).getBlock() == ModBlocks.COOKED_COD_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.FISH
				&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 1
				&& e.getWorld().getBlockState(pos).getBlock() == ModBlocks.SALMON_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.COOKED_FISH
				&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 1
				&& e.getWorld().getBlockState(pos).getBlock() == ModBlocks.COOKED_SALMON_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.FISH
				&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 2
				&& e.getWorld().getBlockState(pos).getBlock() == ModBlocks.TROPICAL_FISH_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.FISH
				&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 3
				&& e.getWorld().getBlockState(pos).getBlock() == ModBlocks.PUFFERFISH_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.ROTTEN_FLESH
				&& e.getWorld().getBlockState(pos).getBlock() == ModBlocks.ROTTEN_FLESH_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.APPLE
				&& e.getWorld().getBlockState(pos).getBlock() == ModBlocks.APPLE_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.GOLDEN_APPLE
				&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 0
				&& e.getWorld().getBlockState(pos).getBlock() == ModBlocks.GOLDEN_APPLE_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.GOLDEN_APPLE
				&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 1
				&& e.getWorld().getBlockState(pos).getBlock() == ModBlocks.NOTCH_APPLE_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.BREAD
				&& e.getWorld().getBlockState(pos).getBlock() == ModBlocks.BREAD_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.COOKIE
				&& e.getWorld().getBlockState(pos).getBlock() == ModBlocks.COOKIE_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.SPIDER_EYE
				&& e.getWorld().getBlockState(pos).getBlock() == ModBlocks.SPIDER_EYE_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.CARROT
				&& e.getWorld().getBlockState(pos).getBlock() == ModBlocks.CARROT_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.GOLDEN_CARROT
				&& e.getWorld().getBlockState(pos).getBlock() == ModBlocks.GOLDEN_CARROT_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.POTATO
				&& e.getWorld().getBlockState(pos).getBlock() == ModBlocks.POTATO_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.BAKED_POTATO
				&& e.getWorld().getBlockState(pos).getBlock() == ModBlocks.BAKED_POTATO_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.POISONOUS_POTATO
				&& e.getWorld().getBlockState(pos).getBlock() == ModBlocks.POISONOUS_POTATO_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.BEETROOT
				&& e.getWorld().getBlockState(pos).getBlock() == ModBlocks.BEETROOT_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}
	}
}
