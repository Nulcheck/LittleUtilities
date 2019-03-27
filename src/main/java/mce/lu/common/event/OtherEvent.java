package mce.lu.common.event;

import java.util.Random;

import mce.lu.common.block.ModBlocks;
import mce.lu.common.item.ModItems;
import mce.lu.common.util.References;
import mce.lu.common.util.config.LUConfigManager;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
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
			e.getWorld().setBlockState(pos, ModBlocks.UNSTOMPABLE_FARMLAND.getDefaultState(), 2);
			e.getCurrent().damageItem(1, e.getEntityPlayer());
			e.getWorld().playSound(e.getEntityPlayer(), pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F,
					1.0F);
		}

		if (block == ModBlocks.FERTILE_DIRT) {
			e.getWorld().setBlockState(e.getPos(), ModBlocks.FERTILE_FARMLAND.getDefaultState(), 2);
			e.getWorld().playSound(e.getEntityPlayer(), pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F,
					1.0F);
		}

		if (block == ModBlocks.ARABLE_DIRT) {
			e.getWorld().setBlockState(e.getPos(), ModBlocks.ARABLE_FARMLAND.getDefaultState(), 2);
			e.getWorld().playSound(e.getEntityPlayer(), pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F,
					1.0F);
		}
	}

	@SubscribeEvent
	public static void loadLoot(LootTableLoadEvent e) {
		LootEntry skullEntry = new LootEntryItem(new ItemStack(Items.SKULL, 1, 0).getItem(), 45, 1, new LootFunction[0],
				new LootCondition[0], References.MOD_ID + "skullEntry");

		LootEntry curingKitEntry = new LootEntryItem(ModItems.ZOMBIE_CURING_KIT, 40, 1, new LootFunction[0],
				new LootCondition[0], References.MOD_ID + "curingKitEntry");

		LootEntry pureQuartzEntry = new LootEntryItem(ModItems.PURE_QUARTZ, 35, 3, new LootFunction[0],
				new LootCondition[0], References.MOD_ID + "pureQuartzEntry");

		if (e.getName().equals(LootTableList.CHESTS_SIMPLE_DUNGEON)) {
			e.getTable().getPool("main").addEntry(skullEntry);
			e.getTable().getPool("main").addEntry(curingKitEntry);
		}

		if (e.getName().equals(LootTableList.CHESTS_JUNGLE_TEMPLE)) {
			e.getTable().getPool("main").addEntry(skullEntry);
			e.getTable().getPool("main").addEntry(curingKitEntry);
		}

		if (e.getName().equals(LootTableList.CHESTS_ABANDONED_MINESHAFT)) {
			e.getTable().getPool("main").addEntry(skullEntry);
			e.getTable().getPool("main").addEntry(curingKitEntry);

			if (LUConfigManager.modConfig.loot.pureQuartzLoot)
				e.getTable().getPool("main").addEntry(pureQuartzEntry);
		}
	}

	@SubscribeEvent
	public static void onBlockDrops(BlockEvent.HarvestDropsEvent e) {
		Random rand = new Random();

		if (LUConfigManager.modConfig.features.cactusFiberDrops && e.getHarvester() != null
				&& e.getState().getBlock() == Blocks.CACTUS)
			e.getDrops().add(new ItemStack(ModItems.CACTUS_FIBER, rand.nextInt(2)));
	}

	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public static void onInteractEvent(RightClickBlock e) {
		BlockPos pos = e.getPos();
		ItemStack stack = e.getEntityPlayer().getHeldItemMainhand();
		IBlockState state = e.getWorld().getBlockState(pos);

		// Dirt into Path
		if (!stack.isEmpty() && stack.getItem() instanceof ItemSpade) {
			if (e.getWorld().getBlockState(pos).getBlock() == Blocks.DIRT) {
				e.getWorld().setBlockState(pos, Blocks.GRASS_PATH.getDefaultState(), 2);
				e.getWorld().playSound(e.getEntityPlayer(), pos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS,
						1.0F, 1.0F);
			}
		}

		// Spikes
		if (!stack.isEmpty() && stack.getItem() == Items.SPIDER_EYE) {
			if (e.getWorld().getBlockState(pos).getBlock() == ModBlocks.SPIKES) {
				e.getWorld().setBlockState(pos,
						ModBlocks.POISON_SPIKES.getStateFromMeta(ModBlocks.POISON_SPIKES.getMetaFromState(state)), 2);

				if (!e.getEntityPlayer().isCreative())
					stack.shrink(1);
			}
		}

		if (!stack.isEmpty() && (stack.getItem() == Items.WATER_BUCKET || stack.getItem() == ModItems.SPONGE)) {
			if (e.getWorld().getBlockState(pos).getBlock() == ModBlocks.POISON_SPIKES) {
				e.getWorld().setBlockState(pos,
						ModBlocks.SPIKES.getStateFromMeta(ModBlocks.SPIKES.getMetaFromState(state)), 2);

				if (!e.getEntityPlayer().isCreative() && stack.getItem() == Items.WATER_BUCKET) {
					stack.shrink(1);
					e.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(Items.BUCKET, 1));
				}
			}
		}

		// Fertile and Arable Blocks
		if (e.getEntityPlayer().isSneaking() && !stack.isEmpty() && stack.getItem() == ModItems.FERTILIZER
				&& stack.getCount() >= 4) {
			if (e.getWorld().getBlockState(pos).getBlock() == Blocks.DIRT
					|| e.getWorld().getBlockState(pos).getBlock() == Blocks.GRASS) {
				e.getWorld().setBlockState(pos, ModBlocks.FERTILE_DIRT.getDefaultState(), 2);
				if (!e.getEntityPlayer().capabilities.isCreativeMode)
					stack.shrink(4);
			}

			if (e.getWorld().getBlockState(pos).getBlock() == Blocks.FARMLAND) {
				e.getWorld().setBlockState(pos, ModBlocks.FERTILE_FARMLAND.getDefaultState(), 2);
				if (!e.getEntityPlayer().capabilities.isCreativeMode)
					stack.shrink(4);
			}
		}

		if (!stack.isEmpty() && stack.getItem() == Items.COAL && stack.getItemDamage() == 1 && stack.getCount() >= 2) {
			if (e.getWorld().getBlockState(pos).getBlock() == ModBlocks.FERTILE_DIRT) {
				e.getWorld().setBlockState(pos, ModBlocks.ARABLE_DIRT.getDefaultState(), 2);
				if (!e.getEntityPlayer().capabilities.isCreativeMode)
					stack.shrink(2);
			}

			if (e.getWorld().getBlockState(pos).getBlock() == ModBlocks.FERTILE_FARMLAND) {
				e.getWorld().setBlockState(pos, ModBlocks.ARABLE_FARMLAND.getDefaultState(), 2);
				if (!e.getEntityPlayer().capabilities.isCreativeMode)
					stack.shrink(2);
			}
		}

		if (e.getEntityPlayer().isSneaking()) {
			// To lava blocks
			if (e.getHand().equals(EnumHand.MAIN_HAND) && !stack.isEmpty() && stack.getItem() == Items.LAVA_BUCKET) {
				if (e.getWorld().getBlockState(pos).getBlock() == Blocks.STONE) {
					e.getWorld().setBlockState(pos, ModBlocks.LAVA_STONE.getDefaultState(), 2);
					stack.shrink(1);
					e.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(Items.BUCKET, 1));
				}

				else if (e.getWorld().getBlockState(pos).getBlock() == Blocks.COBBLESTONE) {
					e.getWorld().setBlockState(pos, ModBlocks.LAVA_COBBLESTONE.getDefaultState(), 2);
					stack.shrink(1);
					e.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(Items.BUCKET, 1));
				}

				else if (e.getWorld().getBlockState(pos).getBlock() == Blocks.OBSIDIAN) {
					e.getWorld().setBlockState(pos, ModBlocks.LAVA_OBSIDIAN.getDefaultState(), 2);
					stack.shrink(1);
					e.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(Items.BUCKET, 1));
				}
			}

			// From lava blocks
			else if (e.getHand().equals(EnumHand.MAIN_HAND) && !stack.isEmpty() && stack.getItem() == Items.BUCKET) {
				if (e.getWorld().getBlockState(pos).getBlock() == ModBlocks.LAVA_STONE) {
					e.getWorld().setBlockState(pos, Blocks.STONE.getDefaultState(), 2);
					e.getEntityPlayer().getHeldItemMainhand().shrink(1);
					e.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(Items.LAVA_BUCKET, 1));
				}

				else if (e.getWorld().getBlockState(pos).getBlock() == ModBlocks.LAVA_COBBLESTONE) {
					e.getWorld().setBlockState(pos, Blocks.COBBLESTONE.getDefaultState(), 2);
					e.getEntityPlayer().getHeldItemMainhand().shrink(1);
					e.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(Items.LAVA_BUCKET, 1));
				}

				else if (e.getWorld().getBlockState(pos).getBlock() == ModBlocks.LAVA_OBSIDIAN) {
					e.getWorld().setBlockState(pos, Blocks.OBSIDIAN.getBlockState().getBaseState(), 2);
					e.getEntityPlayer().getHeldItemMainhand().shrink(1);
					e.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(Items.LAVA_BUCKET, 1));
				}
			}
		}
	}
}