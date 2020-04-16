package mce.lu.common.event;

import mce.lu.common.block.ModBlocks;
import mce.lu.common.item.ModItems;
import mce.lu.common.util.RayTraceHelper;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.stats.StatList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class BlockInteractEvent {
	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public static void onInteractEvent(RightClickBlock e) {
		BlockPos pos = e.getPos();
		ItemStack stack = e.getItemStack();
		IBlockState state = e.getWorld().getBlockState(pos);
		RayTraceHelper rayHelper = new RayTraceHelper();

		// Lava Bottle
		if (!stack.isEmpty() && stack.getItem() == Items.GLASS_BOTTLE) {
			// For clicking liquids
			RayTraceResult trace = rayHelper.rayTrace(e.getWorld(), e.getEntityPlayer(), true);

			if (trace == null) {
				e.setResult(Result.DEFAULT);
			} else {
				BlockPos tracePos = trace.getBlockPos();
				if (e.getWorld().getBlockState(tracePos).getMaterial() == Material.LAVA) {
					e.getWorld().playSound(e.getEntityPlayer(), e.getEntityPlayer().posX, e.getEntityPlayer().posY,
							e.getEntityPlayer().posZ, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1f, 1f);
					if (!e.getEntityPlayer().isCreative())
						stack.shrink(1);
					e.getEntityPlayer().addStat(StatList.getObjectUseStats(Items.GLASS_BOTTLE));
					e.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(ModItems.LAVA_BOTTLE));
					e.setUseItem(Result.ALLOW);
				}
			}
		}

		// Slime into magma slime
		if (!stack.isEmpty() && stack.getItem() == Items.BLAZE_POWDER) {
			if (e.getWorld().getBlockState(pos).getBlock() == Blocks.SLIME_BLOCK) {
				e.getWorld().setBlockState(pos, ModBlocks.MAGMA_SLIME_BLOCK.getDefaultState());
				e.getWorld().playSound(e.getEntityPlayer(), e.getEntityPlayer().posX, e.getEntityPlayer().posY,
						e.getEntityPlayer().posZ, SoundEvents.BLOCK_SLIME_STEP, SoundCategory.NEUTRAL, 1f, 1f);
				if (!e.getEntityPlayer().isCreative())
					stack.shrink(1);
				e.setResult(Result.ALLOW);
			}
		}

		// Dirt into Path
		if (!stack.isEmpty() && stack.getItem() instanceof ItemSpade) {
			if (state.getBlock() == Blocks.DIRT && e.getWorld().getBlockState(pos.up()).getMaterial() == Material.AIR) {
				e.getWorld().setBlockState(pos, Blocks.GRASS_PATH.getDefaultState());
				e.getWorld().playSound(e.getEntityPlayer(), pos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS,
						1.0F, 1.0F);
				if (!e.getEntityPlayer().isCreative())
					e.getItemStack().damageItem(1, e.getEntityPlayer());
				e.setUseItem(Result.ALLOW);
			}
		}

		// Spikes
		if (!stack.isEmpty() && stack.getItem() == Items.SPIDER_EYE) {
			if (e.getWorld().getBlockState(pos).getBlock() == ModBlocks.SPIKES) {
				e.getWorld().setBlockState(pos,
						ModBlocks.POISON_SPIKES.getStateFromMeta(ModBlocks.POISON_SPIKES.getMetaFromState(state)));

				if (!e.getEntityPlayer().isCreative())
					stack.shrink(1);
				e.setResult(Result.ALLOW);
			}
		}

		ItemStack waterBottle = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.WATER);
		if (!stack.isEmpty() && (stack.getItem() == Items.WATER_BUCKET || stack.getItem() == ModItems.SPONGE
				|| stack.getItem() == waterBottle.getItem())) {
			if (e.getWorld().getBlockState(pos).getBlock() == ModBlocks.POISON_SPIKES) {
				e.getWorld().setBlockState(pos,
						ModBlocks.SPIKES.getStateFromMeta(ModBlocks.SPIKES.getMetaFromState(state)));

				if (!e.getEntityPlayer().isCreative()) {
					if (stack.getItem() == Items.WATER_BUCKET) {
						stack.shrink(1);
						e.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(Items.BUCKET));
					}

					if (stack.getItem() == waterBottle.getItem()) {
						stack.shrink(1);
						e.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
					}
				}
			}
			e.setResult(Result.ALLOW);
		}

		// Fertile and Arable Blocks
		if (e.getEntityPlayer().isSneaking() && !stack.isEmpty() && stack.getItem() == ModItems.FERTILIZER
				&& stack.getCount() >= 4) {
			if (e.getWorld().getBlockState(pos).getBlock() == Blocks.DIRT
					|| e.getWorld().getBlockState(pos).getBlock() == Blocks.GRASS) {
				e.getWorld().setBlockState(pos, ModBlocks.FERTILE_DIRT.getDefaultState());
				if (!e.getEntityPlayer().isCreative())
					stack.shrink(4);
				e.setResult(Result.ALLOW);
			}

			if (e.getWorld().getBlockState(pos).getBlock() == Blocks.FARMLAND
					|| e.getWorld().getBlockState(pos).getBlock() == ModBlocks.UNSTOMPABLE_FARMLAND) {
				e.getWorld().setBlockState(pos, ModBlocks.FERTILE_FARMLAND.getDefaultState());
				if (!e.getEntityPlayer().isCreative())
					stack.shrink(4);
				e.setResult(Result.ALLOW);
			}
		}

		if (!stack.isEmpty() && stack.getItem() == Items.COAL && stack.getItemDamage() == 1 && stack.getCount() >= 2) {
			if (e.getWorld().getBlockState(pos).getBlock() == ModBlocks.FERTILE_DIRT) {
				e.getWorld().setBlockState(pos, ModBlocks.ARABLE_DIRT.getDefaultState());
				if (!e.getEntityPlayer().isCreative())
					stack.shrink(2);
				e.setResult(Result.ALLOW);
			}

			if (e.getWorld().getBlockState(pos).getBlock() == ModBlocks.FERTILE_FARMLAND) {
				e.getWorld().setBlockState(pos, ModBlocks.ARABLE_FARMLAND.getDefaultState());
				if (!e.getEntityPlayer().isCreative())
					stack.shrink(2);
				e.setResult(Result.ALLOW);
			}
		}

		if (e.getEntityPlayer().isSneaking()) {
			// To lava blocks
			if (!stack.isEmpty() && stack.getItem() == Items.LAVA_BUCKET) {
				if (e.getWorld().getBlockState(pos).getBlock() == Blocks.STONE) {
					e.getWorld().setBlockState(pos, ModBlocks.LAVA_STONE.getDefaultState());
					if (!e.getEntityPlayer().isCreative()) {
						stack.shrink(1);
						e.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(Items.BUCKET));
					}
					e.setResult(Result.ALLOW);
				}

				else if (e.getWorld().getBlockState(pos).getBlock() == Blocks.COBBLESTONE) {
					e.getWorld().setBlockState(pos, ModBlocks.LAVA_COBBLESTONE.getDefaultState());
					if (!e.getEntityPlayer().isCreative()) {
						stack.shrink(1);
						e.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(Items.BUCKET));
					}
					e.setResult(Result.ALLOW);
				}

				else if (e.getWorld().getBlockState(pos).getBlock() == Blocks.OBSIDIAN) {
					e.getWorld().setBlockState(pos, ModBlocks.LAVA_OBSIDIAN.getDefaultState());
					if (!e.getEntityPlayer().isCreative()) {
						stack.shrink(1);
						e.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(Items.BUCKET));
					}
					e.setResult(Result.ALLOW);
				}
			}

			// From lava blocks
			else if (!stack.isEmpty() && stack.getItem() == Items.BUCKET) {
				if (e.getWorld().getBlockState(pos).getBlock() == ModBlocks.LAVA_STONE) {
					e.getWorld().setBlockState(pos, Blocks.STONE.getDefaultState());
					if (!e.getEntityPlayer().isCreative()) {
						stack.shrink(1);
						e.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(Items.LAVA_BUCKET));
					}
					e.setResult(Result.ALLOW);
				}

				else if (e.getWorld().getBlockState(pos).getBlock() == ModBlocks.LAVA_COBBLESTONE) {
					e.getWorld().setBlockState(pos, Blocks.COBBLESTONE.getDefaultState());
					if (!e.getEntityPlayer().isCreative()) {
						stack.shrink(1);
						e.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(Items.LAVA_BUCKET));
					}
					e.setResult(Result.ALLOW);
				}

				else if (e.getWorld().getBlockState(pos).getBlock() == ModBlocks.LAVA_OBSIDIAN) {
					e.getWorld().setBlockState(pos, Blocks.OBSIDIAN.getBlockState().getBaseState());
					if (!e.getEntityPlayer().isCreative()) {
						stack.shrink(1);
						e.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(Items.LAVA_BUCKET));
					}
					e.setResult(Result.ALLOW);
				}
			}
		}
	}
}
