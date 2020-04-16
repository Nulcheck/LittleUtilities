package mce.lu.common.event;

import java.util.Random;

import mce.lu.common.block.ModBlocks;
import mce.lu.common.item.ModItems;
import mce.lu.common.util.config.LUConfigManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSponge;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class OtherEvent {
	@SubscribeEvent
	public static void entityDamageEvent(AttackEntityEvent e) {
		if (LUConfigManager.modConfig.modEvents.blazeRodEvent) {
			if (!e.getEntityPlayer().getHeldItemMainhand().isEmpty()
					&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.BLAZE_ROD)
				e.getTarget().setFire(8);
			e.setResult(Result.ALLOW);
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
}