package mce.lu.common.event;

import mce.lu.common.block.ModBlocks;
import mce.lu.common.item.ModItems;
import mce.lu.common.util.References;
import mce.lu.common.util.config.LUConfigManager;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class GameEvent {
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

			if (LUConfigManager.modConfig.modRecipes.pureQuartzRecipe)
				e.getTable().getPool("main").addEntry(pureQuartzEntry);
		}
	}

	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public static void onInteractEvent(PlayerInteractEvent e) {
		BlockPos pos = e.getPos();
		IBlockState state = e.getWorld().getBlockState(pos);
		// TileEntity te = e.getWorld().getTileEntity(pos);

		// Dye a block in world.
		if (LUConfigManager.modConfig.modEvents.dyeEvent) {
			for (int i = 0; i <= 15; i++) {
				if (!e.getEntityPlayer().getHeldItemMainhand().isEmpty()
						&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.DYE
						&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 15 - i
						&& e.getWorld().getBlockState(pos).getBlock() == Blocks.WOOL
						&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i) {
					e.getWorld().setBlockState(pos, Blocks.WOOL.getBlockState().getBlock().getStateFromMeta(i));
					e.getEntityPlayer().getHeldItemMainhand().shrink(1);
				}

				else if (!e.getEntityPlayer().getHeldItemMainhand().isEmpty()
						&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.DYE
						&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 15 - i
						&& (e.getWorld().getBlockState(pos).getBlock() == Blocks.GLASS
								|| e.getWorld().getBlockState(pos).getBlock() == Blocks.STAINED_GLASS)
						&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i) {
					e.getWorld().setBlockState(pos,
							Blocks.STAINED_GLASS.getBlockState().getBlock().getStateFromMeta(i));
					e.getEntityPlayer().getHeldItemMainhand().shrink(1);
				}

				else if (!e.getEntityPlayer().getHeldItemMainhand().isEmpty()
						&& e.getEntityPlayer().getHeldItemMainhand().getItem() == ModItems.SPONGE
						&& e.getWorld().getBlockState(pos).getBlock() == Blocks.STAINED_GLASS) {
					e.getWorld().setBlockState(pos, Blocks.GLASS.getDefaultState());
				}

				else if (!e.getEntityPlayer().getHeldItemMainhand().isEmpty()
						&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.DYE
						&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 15 - i
						&& (e.getWorld().getBlockState(pos).getBlock() == Blocks.GLASS_PANE
								|| e.getWorld().getBlockState(pos).getBlock() == Blocks.STAINED_GLASS_PANE)
						&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i) {
					e.getWorld().setBlockState(pos,
							Blocks.STAINED_GLASS_PANE.getBlockState().getBlock().getStateFromMeta(i));
					e.getEntityPlayer().getHeldItemMainhand().shrink(1);
				}

				else if (!e.getEntityPlayer().getHeldItemMainhand().isEmpty()
						&& e.getEntityPlayer().getHeldItemMainhand().getItem() == ModItems.SPONGE
						&& e.getWorld().getBlockState(pos).getBlock() == Blocks.STAINED_GLASS_PANE) {
					e.getWorld().setBlockState(pos, Blocks.GLASS_PANE.getDefaultState());
				}

				else if (!e.getEntityPlayer().getHeldItemMainhand().isEmpty()
						&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.DYE
						&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 15 - i
						&& (e.getWorld().getBlockState(pos).getBlock() == Blocks.HARDENED_CLAY
								|| e.getWorld().getBlockState(pos).getBlock() == Blocks.STAINED_HARDENED_CLAY)
						&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i) {
					e.getWorld().setBlockState(pos,
							Blocks.STAINED_HARDENED_CLAY.getBlockState().getBlock().getStateFromMeta(i));
					e.getEntityPlayer().getHeldItemMainhand().shrink(1);
				}

				else if (!e.getEntityPlayer().getHeldItemMainhand().isEmpty()
						&& e.getEntityPlayer().getHeldItemMainhand().getItem() == ModItems.SPONGE
						&& e.getWorld().getBlockState(pos).getBlock() == Blocks.STAINED_HARDENED_CLAY) {
					e.getWorld().setBlockState(pos, Blocks.HARDENED_CLAY.getDefaultState());
				}

				else if (!e.getEntityPlayer().getHeldItemMainhand().isEmpty()
						&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.DYE
						&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 15 - i
						&& e.getWorld().getBlockState(pos).getBlock() == Blocks.CARPET
						&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i) {
					e.getWorld().setBlockState(pos, Blocks.CARPET.getBlockState().getBlock().getStateFromMeta(i));
					e.getEntityPlayer().getHeldItemMainhand().shrink(1);
				}

				else if (!e.getEntityPlayer().getHeldItemMainhand().isEmpty()
						&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.DYE
						&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 15 - i
						&& e.getWorld().getBlockState(pos).getBlock() == Blocks.CONCRETE
						&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i) {
					e.getWorld().setBlockState(pos, Blocks.CONCRETE.getBlockState().getBlock().getStateFromMeta(i));
					e.getEntityPlayer().getHeldItemMainhand().shrink(1);
				}

				else if (!e.getEntityPlayer().getHeldItemMainhand().isEmpty()
						&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.DYE
						&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 15 - i
						&& e.getWorld().getBlockState(pos).getBlock() == Blocks.CONCRETE_POWDER
						&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i) {
					e.getWorld().setBlockState(pos,
							Blocks.CONCRETE_POWDER.getBlockState().getBlock().getStateFromMeta(i));
					e.getEntityPlayer().getHeldItemMainhand().shrink(1);
				}

				// Color Bed, but only does 1 part, not both..
				/*
				 * else if (e.getEntityPlayer().isSneaking() &&
				 * !e.getEntityPlayer().getHeldItemMainhand().isEmpty() &&
				 * e.getEntityPlayer().getHeldItemMainhand().getItem() ==
				 * Items.DYE &&
				 * e.getEntityPlayer().getHeldItemMainhand().getItemDamage() ==
				 * 15 - i && e.getWorld().getTileEntity(pos) instanceof
				 * TileEntityBed && ((TileEntityBed)
				 * te).getColor().getMetadata() != i) {
				 * if(((TileEntityBed)te).isHeadPiece()){ ((TileEntityBed)
				 * te).setColor(EnumDyeColor.byMetadata(i)); } else {
				 * ((TileEntityBed) te).setColor(EnumDyeColor.byMetadata(i)); }
				 * e.getEntityPlayer().getHeldItemMainhand().shrink(1); }
				 */
			}
		}

		// Condensed Usable Blocks
		if (e.getEntityPlayer().isSneaking() && !e.getEntityPlayer().getHeldItemMainhand().isEmpty()
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
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.ENDER_PEARL
				&& e.getWorld().getBlockState(pos).getBlock() == ModBlocks.ENDER_PEARL_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}
	}
}