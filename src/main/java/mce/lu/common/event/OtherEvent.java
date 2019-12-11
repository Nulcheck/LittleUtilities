package mce.lu.common.event;

import java.util.Random;

import mce.lu.common.block.ModBlocks;
import mce.lu.common.item.ModItems;
import mce.lu.common.util.RayTraceHelper;
import mce.lu.common.util.config.LUConfigManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSponge;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class OtherEvent {
	@SubscribeEvent
	public static void setEntityOnFire(AttackEntityEvent e) {
		if (LUConfigManager.modConfig.modEvents.blazeRodEvent) {
			if (!e.getEntityPlayer().getHeldItemMainhand().isEmpty()
					&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.BLAZE_ROD)
				e.getTarget().setFire(8);
		}
	}

	@SubscribeEvent
	public static void mobDrops(LivingDropsEvent e) {
		if (LUConfigManager.modConfig.modRecipes.leatherScraps) {
			if (e.getEntityLiving() instanceof EntityPig)
				e.getEntityLiving().dropItem(ModItems.LEATHER_SCRAPS, 2);
			if (e.getEntityLiving() instanceof EntitySheep)
				e.getEntityLiving().dropItem(ModItems.LEATHER_SCRAPS, 2);
			if (e.getEntityLiving() instanceof EntityWolf)
				e.getEntityLiving().dropItem(ModItems.LEATHER_SCRAPS, 2);
			if (e.getEntityLiving() instanceof EntityPolarBear)
				e.getEntityLiving().dropItem(ModItems.LEATHER_SCRAPS, 3);
		}
	}

	@SubscribeEvent
	public static void fuelBurnTime(FurnaceFuelBurnTimeEvent e) {
		Item item = e.getItemStack().getItem();

		if (item == Item.getItemFromBlock(ModBlocks.PAPER_BLOCK))
			e.setBurnTime(200);
		else if (item == Item.getItemFromBlock(ModBlocks.BLAZE_ROD_BLOCK))
			e.setBurnTime(21600);
		else
			e.setBurnTime(-1);
	}

	@SubscribeEvent
	public static void onTilled(UseHoeEvent e) {
		BlockPos pos = e.getPos();
		Block block = e.getWorld().getBlockState(e.getPos()).getBlock();

		if (e.getEntityPlayer().isSneaking() && (block == Blocks.DIRT || block == Blocks.GRASS)) {
			e.getWorld().setBlockState(pos, ModBlocks.UNSTOMPABLE_FARMLAND.getDefaultState());
			e.getWorld().playSound(e.getEntityPlayer(), pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F,
					1.0F);
			e.setResult(Result.ALLOW);
		}

		if (block == ModBlocks.FERTILE_DIRT) {
			e.getWorld().setBlockState(e.getPos(), ModBlocks.FERTILE_FARMLAND.getDefaultState());
			e.getWorld().playSound(e.getEntityPlayer(), pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F,
					1.0F);
			e.setResult(Result.ALLOW);
		}

		if (block == ModBlocks.ARABLE_DIRT) {
			e.getWorld().setBlockState(e.getPos(), ModBlocks.ARABLE_FARMLAND.getDefaultState());
			e.getWorld().playSound(e.getEntityPlayer(), pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F,
					1.0F);
			e.setResult(Result.ALLOW);
		}
	}

	@SubscribeEvent
	public static void onBlockDrops(BlockEvent.HarvestDropsEvent e) {
		Random rand = new Random();

		if (LUConfigManager.modConfig.features.cactusFiberDrops && e.getHarvester() != null
				&& e.getState().getBlock() == Blocks.CACTUS)
			e.getDrops().add(new ItemStack(ModItems.CACTUS_FIBER, rand.nextInt(2)));
	}

	@SubscribeEvent
	public static void onPlaceEvent(BlockEvent.EntityPlaceEvent e) {
		BlockPos pos = e.getPos();
		if (e.getWorld().provider.getDimension() == -1) {
			if (e.getPlacedBlock() == Blocks.SPONGE.getDefaultState().withProperty(BlockSponge.WET,
					Boolean.valueOf(true))) {
				e.getWorld().setBlockState(pos,
						Blocks.SPONGE.getDefaultState().withProperty(BlockSponge.WET, Boolean.valueOf(false)));
				e.setResult(Result.ALLOW);
			}
		}
	}

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
					stack.shrink(1);

					e.getEntityPlayer().addStat(StatList.getObjectUseStats(Items.GLASS_BOTTLE));
					e.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(ModItems.LAVA_BOTTLE));
					e.setUseItem(Result.ALLOW);
				}
			}
		}

		// Dirt into Path
		if (!stack.isEmpty() && stack.getItem() instanceof ItemSpade) {
			if (state.getBlock() == Blocks.DIRT && e.getWorld().getBlockState(pos.up()).getMaterial() == Material.AIR) {
				e.getWorld().setBlockState(pos, Blocks.GRASS_PATH.getDefaultState());
				e.getWorld().playSound(e.getEntityPlayer(), pos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS,
						1.0F, 1.0F);
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
						e.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(Items.BUCKET, 1));
						e.setResult(Result.ALLOW);
					}

					if (stack.getItem() == waterBottle.getItem()) {
						stack.shrink(1);
						e.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE, 1));
						e.setResult(Result.ALLOW);
					}
				}
			}
		}

		// Fertile and Arable Blocks
		if (e.getEntityPlayer().isSneaking() && !stack.isEmpty() && stack.getItem() == ModItems.FERTILIZER
				&& stack.getCount() >= 4) {
			if (e.getWorld().getBlockState(pos).getBlock() == Blocks.DIRT
					|| e.getWorld().getBlockState(pos).getBlock() == Blocks.GRASS) {
				e.getWorld().setBlockState(pos, ModBlocks.FERTILE_DIRT.getDefaultState());
				if (!e.getEntityPlayer().capabilities.isCreativeMode)
					stack.shrink(4);
				e.setResult(Result.ALLOW);
			}

			if (e.getWorld().getBlockState(pos).getBlock() == Blocks.FARMLAND) {
				e.getWorld().setBlockState(pos, ModBlocks.FERTILE_FARMLAND.getDefaultState());
				if (!e.getEntityPlayer().capabilities.isCreativeMode)
					stack.shrink(4);
				e.setResult(Result.ALLOW);
			}
		}

		if (!stack.isEmpty() && stack.getItem() == Items.COAL && stack.getItemDamage() == 1 && stack.getCount() >= 2) {
			if (e.getWorld().getBlockState(pos).getBlock() == ModBlocks.FERTILE_DIRT) {
				e.getWorld().setBlockState(pos, ModBlocks.ARABLE_DIRT.getDefaultState());
				if (!e.getEntityPlayer().capabilities.isCreativeMode)
					stack.shrink(2);
				e.setResult(Result.ALLOW);
			}

			if (e.getWorld().getBlockState(pos).getBlock() == ModBlocks.FERTILE_FARMLAND) {
				e.getWorld().setBlockState(pos, ModBlocks.ARABLE_FARMLAND.getDefaultState());
				if (!e.getEntityPlayer().capabilities.isCreativeMode)
					stack.shrink(2);
				e.setResult(Result.ALLOW);
			}
		}

		if (e.getEntityPlayer().isSneaking()) {
			// To lava blocks
			if (e.getHand().equals(EnumHand.MAIN_HAND) && !stack.isEmpty() && stack.getItem() == Items.LAVA_BUCKET) {
				if (e.getWorld().getBlockState(pos).getBlock() == Blocks.STONE) {
					e.getWorld().setBlockState(pos, ModBlocks.LAVA_STONE.getDefaultState());
					stack.shrink(1);
					e.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(Items.BUCKET, 1));
					e.setResult(Result.ALLOW);
				}

				else if (e.getWorld().getBlockState(pos).getBlock() == Blocks.COBBLESTONE) {
					e.getWorld().setBlockState(pos, ModBlocks.LAVA_COBBLESTONE.getDefaultState());
					stack.shrink(1);
					e.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(Items.BUCKET, 1));
					e.setResult(Result.ALLOW);
				}

				else if (e.getWorld().getBlockState(pos).getBlock() == Blocks.OBSIDIAN) {
					e.getWorld().setBlockState(pos, ModBlocks.LAVA_OBSIDIAN.getDefaultState());
					stack.shrink(1);
					e.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(Items.BUCKET, 1));
					e.setResult(Result.ALLOW);
				}
			}

			// From lava blocks
			else if (e.getHand().equals(EnumHand.MAIN_HAND) && !stack.isEmpty() && stack.getItem() == Items.BUCKET) {
				if (e.getWorld().getBlockState(pos).getBlock() == ModBlocks.LAVA_STONE) {
					e.getWorld().setBlockState(pos, Blocks.STONE.getDefaultState());
					e.getEntityPlayer().getHeldItemMainhand().shrink(1);
					e.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(Items.LAVA_BUCKET, 1));
					e.setResult(Result.ALLOW);
				}

				else if (e.getWorld().getBlockState(pos).getBlock() == ModBlocks.LAVA_COBBLESTONE) {
					e.getWorld().setBlockState(pos, Blocks.COBBLESTONE.getDefaultState());
					e.getEntityPlayer().getHeldItemMainhand().shrink(1);
					e.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(Items.LAVA_BUCKET, 1));
					e.setResult(Result.ALLOW);
				}

				else if (e.getWorld().getBlockState(pos).getBlock() == ModBlocks.LAVA_OBSIDIAN) {
					e.getWorld().setBlockState(pos, Blocks.OBSIDIAN.getBlockState().getBaseState());
					e.getEntityPlayer().getHeldItemMainhand().shrink(1);
					e.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(Items.LAVA_BUCKET, 1));
					e.setResult(Result.ALLOW);
				}
			}
		}
	}
}