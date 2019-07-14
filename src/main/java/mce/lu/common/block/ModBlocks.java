package mce.lu.common.block;

import java.util.ArrayList;
import java.util.List;

import mce.lu.api.PamsBalanceHandler;
import mce.lu.common.LittleUtilities;
import mce.lu.common.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.MobEffects;
import net.xendric.xenlib.common.core.block.BlockBase;
import net.xendric.xenlib.common.core.block.BlockBoundsBase;
import net.xendric.xenlib.common.core.block.BlockEdible;
import net.xendric.xenlib.common.core.block.BlockFluidBase;
import net.xendric.xenlib.common.core.block.BlockPaneBase;

public class ModBlocks {
	public static final List<Block> BLOCKS = new ArrayList<>();
	public static final Material UTIL_ROCK = new Material(MapColor.STONE);
	public static final Material UTIL_METAL = new Material(MapColor.IRON);

	//// UTILITY
	public static final Block CONDENSER = new CondenserBlock("lu_condenser", UTIL_ROCK, BLOCKS, ModItems.ITEMS)
			.setCreativeTab(LittleUtilities.lu).setHardness(1.5f);
	public static final Block SNOW_MELTER = new SnowMelterBlock("snow_melter", UTIL_METAL, BLOCKS, ModItems.ITEMS)
			.setCreativeTab(LittleUtilities.lu).setHardness(1.2f);
	public static final Block AQUA_RESERVOIR = new AquaReservoir("aqua_reservoir", UTIL_METAL, BLOCKS, ModItems.ITEMS)
			.setCreativeTab(LittleUtilities.lu).setHardness(1f);
	public static final Block MAGMA_RESERVOIR = new MagmaReservoir("magma_reservoir", UTIL_METAL, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(1f).setLightLevel(1f);
	public static final Block FERTILE_DIRT = new FertileDirt("fertile_dirt", Material.GROUND, BLOCKS, ModItems.ITEMS)
			.setCreativeTab(LittleUtilities.lu).setHardness(0.5f);
	public static final Block FERTILE_FARMLAND = new FertileFarmland("fertile_farmland", BLOCKS, ModItems.ITEMS)
			.setCreativeTab(LittleUtilities.lu).setHardness(0.5f);
	public static final Block ARABLE_DIRT = new ArableDirt("arable_dirt", Material.GROUND, BLOCKS, ModItems.ITEMS)
			.setCreativeTab(LittleUtilities.lu).setHardness(0.5f);
	public static final Block ARABLE_FARMLAND = new ArableFarmland("arable_farmland", BLOCKS, ModItems.ITEMS)
			.setCreativeTab(LittleUtilities.lu).setHardness(0.5f);
	public static final Block UNSTOMPABLE_FARMLAND = new UnstompableFarmland("unstompable_farmland", BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(0.5f);
	public static final Block SPIKES = new SpikeBlock("spike_block", UTIL_METAL, BLOCKS, ModItems.ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Block POISON_SPIKES = new SpikeBlock("poison_spike_block", UTIL_METAL, BLOCKS, ModItems.ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Block FIRE_SPIKES = new SpikeBlock("fire_spike_block", UTIL_METAL, BLOCKS, ModItems.ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Block DEHYDRATOR = new DehydratorBlock("dehydrator", UTIL_METAL, BLOCKS, ModItems.ITEMS)
			.setCreativeTab(LittleUtilities.lu);

	//// NORMAL
	public static final Block GOLD_BARS = new BlockPaneBase("gold_bars", UTIL_METAL, BLOCKS, ModItems.ITEMS, true)
			.setCreativeTab(LittleUtilities.lu);
	public static final Block DIAMOND_BARS = new BlockPaneBase("diamond_bars", UTIL_METAL, BLOCKS, ModItems.ITEMS, true)
			.setCreativeTab(LittleUtilities.lu);
	public static final Block LAPIS_BARS = new BlockPaneBase("lapis_bars", UTIL_METAL, BLOCKS, ModItems.ITEMS, true)
			.setCreativeTab(LittleUtilities.lu);
	public static final Block OBSIDIAN_BARS = new BlockPaneBase("obsidian_bars", UTIL_METAL, BLOCKS, ModItems.ITEMS,
			true).setCreativeTab(LittleUtilities.lu);
	public static final Block BLAZE_BARS = new BlockPaneBase("blaze_bars", UTIL_METAL, BLOCKS, ModItems.ITEMS, true)
			.setCreativeTab(LittleUtilities.lu);
	public static final Block LAVA_STONE = new BlockBase("lava_stone", Material.ROCK, BLOCKS, ModItems.ITEMS)
			.setCreativeTab(LittleUtilities.lu).setHardness(1.5f).setLightLevel(1f);
	public static final Block LAVA_COBBLESTONE = new BlockBase("lava_cobblestone", Material.ROCK, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(2f).setLightLevel(1f);
	public static final Block LAVA_OBSIDIAN = new BlockBase("lava_obsidian", Material.ROCK, BLOCKS, ModItems.ITEMS)
			.setCreativeTab(LittleUtilities.lu).setHardness(50f).setLightLevel(1f);
	public static final Block PURE_QUARTZ_BLOCK = new BlockBase("pure_quartz_block", Material.ROCK, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(1.2f);

	// Liquid Pigments
	public static final BlockFluidBase PIGMENT_BLACK_FLUID_BLOCK = (BlockFluidBase) new BlockFluidBase(
			"pigment_black_fluid_block", ModFluids.PIGMENT_BLACK_FLUID, ModFluids.LIQUID_PIGMENT, MapColor.BLACK, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu);

	// Dye Reeds
	public static final DyeReeds REEDS_BLACK = (DyeReeds) new DyeReeds("reeds_black", Material.PLANTS, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(0f);
	public static final DyeReeds REEDS_RED = (DyeReeds) new DyeReeds("reeds_red", Material.PLANTS, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(0f);
	public static final DyeReeds REEDS_GREEN = (DyeReeds) new DyeReeds("reeds_green", Material.PLANTS, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(0f);
	public static final DyeReeds REEDS_BROWN = (DyeReeds) new DyeReeds("reeds_brown", Material.PLANTS, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(0f);
	public static final DyeReeds REEDS_BLUE = (DyeReeds) new DyeReeds("reeds_blue", Material.PLANTS, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(0f);
	public static final DyeReeds REEDS_PURPLE = (DyeReeds) new DyeReeds("reeds_purple", Material.PLANTS, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(0f);
	public static final DyeReeds REEDS_CYAN = (DyeReeds) new DyeReeds("reeds_cyan", Material.PLANTS, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(0f);
	public static final DyeReeds REEDS_LIGHT_GRAY = (DyeReeds) new DyeReeds("reeds_light_gray", Material.PLANTS, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(0f);
	public static final DyeReeds REEDS_GRAY = (DyeReeds) new DyeReeds("reeds_gray", Material.PLANTS, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(0f);
	public static final DyeReeds REEDS_PINK = (DyeReeds) new DyeReeds("reeds_pink", Material.PLANTS, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(0f);
	public static final DyeReeds REEDS_LIME = (DyeReeds) new DyeReeds("reeds_lime", Material.PLANTS, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(0f);
	public static final DyeReeds REEDS_YELLOW = (DyeReeds) new DyeReeds("reeds_yellow", Material.PLANTS, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(0f);
	public static final DyeReeds REEDS_LIGHT_BLUE = (DyeReeds) new DyeReeds("reeds_light_blue", Material.PLANTS, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(0f);
	public static final DyeReeds REEDS_MAGENTA = (DyeReeds) new DyeReeds("reeds_magenta", Material.PLANTS, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(0f);
	public static final DyeReeds REEDS_ORANGE = (DyeReeds) new DyeReeds("reeds_orange", Material.PLANTS, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(0f);
	public static final DyeReeds REEDS_WHITE = (DyeReeds) new DyeReeds("reeds_white", Material.PLANTS, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(0f);

	//// CONDENSED ITEM BLOCKS
	public static final Block GHAST_TEAR_BLOCK = new GhastTearBlock("ghast_tear_block", Material.GLASS, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setLightLevel(0.4f).setHardness(1f);
	public static final Block BLAZE_ROD_BLOCK = new BlazeRodBlock("blaze_rod_block", Material.GLASS, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setLightLevel(1f).setHardness(1f);
	public static final Block BLAZE_POWDER_BLOCK = new BlazeRodBlock("blaze_powder_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, SoundType.GROUND).setCreativeTab(LittleUtilities.lu).setLightLevel(8f);
	public static final Block NETHER_STAR_BLOCK = new NetherStarBlock("nether_star_block", Material.GLASS, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(2f);
	public static final Block GUNPOWDER_BLOCK = new GunpowderBlock("gunpowder_block", Material.SAND, BLOCKS,
			ModItems.ITEMS, 0d, 0d, 0d, 0d, 0.0625d, 0d).setCreativeTab(LittleUtilities.lu).setHardness(0.5f);
	public static final Block FLINT_BLOCK = new BlockBase("flint_block", Material.CLAY, BLOCKS, ModItems.ITEMS)
			.setCreativeTab(LittleUtilities.lu).setHardness(0.7f);
	public static final Block PAPER_BLOCK = new PaperBlock("paper_block", Material.GROUND, BLOCKS, ModItems.ITEMS)
			.setCreativeTab(LittleUtilities.lu).setHardness(0.6f);
	public static final Block ENDER_EYE_BLOCK = new EnderEyeBlock("ender_eye_block", Material.ROCK, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(1f);
	public static final Block MAGMA_CREAM_BLOCK = new BlockBase("magma_cream_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setLightLevel(0.45f).setHardness(0.8f);
	public static final Block FEATHER_BLOCK = new FeatherBlock("feather_block", Material.CLOTH, BLOCKS, ModItems.ITEMS)
			.setCreativeTab(LittleUtilities.lu).setHardness(0.5f);
	public static final Block EGG_BLOCK = new BlockBase("egg_block", Material.GROUND, BLOCKS, ModItems.ITEMS,
			SoundType.WOOD).setCreativeTab(LittleUtilities.lu).setHardness(0.5f);
	public static final Block SUGAR_BLOCK = new BlockBoundsBase("sugar_block", Material.SAND, BLOCKS, ModItems.ITEMS,
			0d, 0d, 0d, 0d, 0.0625d, 0d).setCreativeTab(LittleUtilities.lu).setHardness(0.5f);
	public static final Block FERMENTED_SPIDER_EYE_BLOCK = new BlockBase("fermented_spider_eye_block", Material.CLAY,
			BLOCKS, ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(0.6f);
	public static final Block GLISTERING_MELON = new BlockBase("glistering_melon_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, SoundType.WOOD).setCreativeTab(LittleUtilities.lu).setHardness(0.6f);
	public static final Block BONE_BLOCK = new BoneBlock("bone_block", UTIL_ROCK, BLOCKS, ModItems.ITEMS)
			.setCreativeTab(LittleUtilities.lu).setHardness(1f);
	public static final Block CHARCOAL_BLOCK = new BlockBase("charcoal_block", Material.ROCK, BLOCKS, ModItems.ITEMS)
			.setCreativeTab(LittleUtilities.lu);
	public static final Block PRISMARINE_CRYSTAL_BLOCK = new BlockBase("prismarine_crystal_block", UTIL_ROCK, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu);

	// DYES
	public static final Block DYE_BLACK_BLOCK = new BlockBase("dye_black_block", Material.CLAY, BLOCKS, ModItems.ITEMS,
			SoundType.GROUND).setCreativeTab(LittleUtilities.lu).setHardness(0.3f);
	public static final Block DYE_RED_BLOCK = new BlockBase("dye_red_block", Material.CLAY, BLOCKS, ModItems.ITEMS,
			SoundType.GROUND).setCreativeTab(LittleUtilities.lu).setHardness(0.3f);
	public static final Block DYE_GREEN_BLOCK = new BlockBase("dye_green_block", Material.CLAY, BLOCKS, ModItems.ITEMS,
			SoundType.GROUND).setCreativeTab(LittleUtilities.lu).setHardness(0.3f);
	public static final Block DYE_BROWN_BLOCK = new BlockBase("dye_brown_block", Material.CLAY, BLOCKS, ModItems.ITEMS,
			SoundType.GROUND).setCreativeTab(LittleUtilities.lu).setHardness(0.3f);
	public static final Block DYE_PURPLE_BLOCK = new BlockBase("dye_purple_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, SoundType.GROUND).setCreativeTab(LittleUtilities.lu).setHardness(0.3f);
	public static final Block DYE_CYAN_BLOCK = new BlockBase("dye_cyan_block", Material.CLAY, BLOCKS, ModItems.ITEMS,
			SoundType.GROUND).setCreativeTab(LittleUtilities.lu).setHardness(0.3f);
	public static final Block DYE_LIGHT_GRAY_BLOCK = new BlockBase("dye_light_gray_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, SoundType.GROUND).setCreativeTab(LittleUtilities.lu).setHardness(0.3f);
	public static final Block DYE_GRAY_BLOCK = new BlockBase("dye_gray_block", Material.CLAY, BLOCKS, ModItems.ITEMS,
			SoundType.GROUND).setCreativeTab(LittleUtilities.lu).setHardness(0.3f);
	public static final Block DYE_PINK_BLOCK = new BlockBase("dye_pink_block", Material.CLAY, BLOCKS, ModItems.ITEMS,
			SoundType.GROUND).setCreativeTab(LittleUtilities.lu).setHardness(0.3f);
	public static final Block DYE_LIME_BLOCK = new BlockBase("dye_lime_block", Material.CLAY, BLOCKS, ModItems.ITEMS,
			SoundType.GROUND).setCreativeTab(LittleUtilities.lu).setHardness(0.3f);
	public static final Block DYE_YELLOW_BLOCK = new BlockBase("dye_yellow_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, SoundType.GROUND).setCreativeTab(LittleUtilities.lu).setHardness(0.3f);
	public static final Block DYE_LIGHT_BLUE_BLOCK = new BlockBase("dye_light_blue_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, SoundType.GROUND).setCreativeTab(LittleUtilities.lu).setHardness(0.3f);
	public static final Block DYE_MAGENTA_BLOCK = new BlockBase("dye_magenta_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, SoundType.GROUND).setCreativeTab(LittleUtilities.lu).setHardness(0.3f);
	public static final Block DYE_ORANGE_BLOCK = new BlockBase("dye_orange_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, SoundType.GROUND).setCreativeTab(LittleUtilities.lu).setHardness(0.3f);

	// PIGMENTS
	public static final Block PIGMENT_BLACK_BLOCK = new BlockBase("pigment_black_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, SoundType.SAND).setCreativeTab(LittleUtilities.lu).setHardness(0.2f);
	public static final Block PIGMENT_RED_BLOCK = new BlockBase("pigment_red_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, SoundType.SAND).setCreativeTab(LittleUtilities.lu).setHardness(0.2f);
	public static final Block PIGMENT_GREEN_BLOCK = new BlockBase("pigment_green_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, SoundType.SAND).setCreativeTab(LittleUtilities.lu).setHardness(0.2f);
	public static final Block PIGMENT_BROWN_BLOCK = new BlockBase("pigment_brown_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, SoundType.SAND).setCreativeTab(LittleUtilities.lu).setHardness(0.2f);
	public static final Block PIGMENT_BLUE_BLOCK = new BlockBase("pigment_blue_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, SoundType.SAND).setCreativeTab(LittleUtilities.lu).setHardness(0.2f);
	public static final Block PIGMENT_PURPLE_BLOCK = new BlockBase("pigment_purple_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, SoundType.SAND).setCreativeTab(LittleUtilities.lu).setHardness(0.2f);
	public static final Block PIGMENT_CYAN_BLOCK = new BlockBase("pigment_cyan_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, SoundType.SAND).setCreativeTab(LittleUtilities.lu).setHardness(0.2f);
	public static final Block PIGMENT_LIGHT_GRAY_BLOCK = new BlockBase("pigment_light_gray_block", Material.CLAY,
			BLOCKS, ModItems.ITEMS, SoundType.SAND).setCreativeTab(LittleUtilities.lu).setHardness(0.2f);
	public static final Block PIGMENT_GRAY_BLOCK = new BlockBase("pigment_gray_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, SoundType.SAND).setCreativeTab(LittleUtilities.lu).setHardness(0.2f);
	public static final Block PIGMENT_PINK_BLOCK = new BlockBase("pigment_pink_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, SoundType.SAND).setCreativeTab(LittleUtilities.lu).setHardness(0.2f);
	public static final Block PIGMENT_LIME_BLOCK = new BlockBase("pigment_lime_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, SoundType.SAND).setCreativeTab(LittleUtilities.lu).setHardness(0.2f);
	public static final Block PIGMENT_YELLOW_BLOCK = new BlockBase("pigment_yellow_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, SoundType.SAND).setCreativeTab(LittleUtilities.lu).setHardness(0.2f);
	public static final Block PIGMENT_LIGHT_BLUE_BLOCK = new BlockBase("pigment_light_blue_block", Material.CLAY,
			BLOCKS, ModItems.ITEMS, SoundType.SAND).setCreativeTab(LittleUtilities.lu).setHardness(0.2f);
	public static final Block PIGMENT_MAGENTA_BLOCK = new BlockBase("pigment_magenta_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, SoundType.SAND).setCreativeTab(LittleUtilities.lu).setHardness(0.2f);
	public static final Block PIGMENT_ORANGE_BLOCK = new BlockBase("pigment_orange_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, SoundType.SAND).setCreativeTab(LittleUtilities.lu).setHardness(0.2f);
	public static final Block PIGMENT_WHITE_BLOCK = new BlockBase("pigment_white_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, SoundType.SAND).setCreativeTab(LittleUtilities.lu).setHardness(0.2f);

	// USEABLE BLOCKS
	public static final Block ENDER_PEARL_BLOCK = new EnderPearlBlock("ender_pearl_block", Material.GLASS, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(1f);

	// EDIBLE BLOCKS
	public static final Block PORK_BLOCK = new BlockEdible("pork_block", Material.CLAY, BLOCKS, ModItems.ITEMS,
			PamsBalanceHandler.porkAmount, PamsBalanceHandler.porkSat).setCreativeTab(LittleUtilities.lu)
					.setHardness(0.8f);
	public static final Block COOKED_PORK_BLOCK = new BlockEdible("cooked_pork_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, 8, 0.8f).setCreativeTab(LittleUtilities.lu).setHardness(0.8f);
	public static final Block BEEF_BLOCK = new BlockEdible("beef_block", Material.CLAY, BLOCKS, ModItems.ITEMS,
			PamsBalanceHandler.beefAmount, PamsBalanceHandler.beefSat).setCreativeTab(LittleUtilities.lu)
					.setHardness(0.8f);
	public static final Block COOKED_BEEF_BLOCK = new BlockEdible("cooked_beef_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, PamsBalanceHandler.cookedBeefAmount, PamsBalanceHandler.cookedBeefSat)
					.setCreativeTab(LittleUtilities.lu).setHardness(0.8f);
	public static final Block CHICKEN_BLOCK = ((BlockEdible) new BlockEdible("chicken_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, PamsBalanceHandler.chickenAmount, PamsBalanceHandler.chickenSat))
					.setPotionEffect(MobEffects.HUNGER, 30, 0, 0.3f).setCreativeTab(LittleUtilities.lu)
					.setHardness(0.8f);
	public static final Block COOKED_CHICKEN_BLOCK = new BlockEdible("cooked_chicken_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, PamsBalanceHandler.cookedChickenAmount, PamsBalanceHandler.cookedChickenSat)
					.setCreativeTab(LittleUtilities.lu).setHardness(0.8f);
	public static final Block RABBIT_BLOCK = new BlockEdible("rabbit_block", Material.CLAY, BLOCKS, ModItems.ITEMS,
			PamsBalanceHandler.rabbitAmount, PamsBalanceHandler.rabbitSat).setCreativeTab(LittleUtilities.lu)
					.setHardness(0.8f);
	public static final Block COOKED_RABBIT_BLOCK = new BlockEdible("cooked_rabbit_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, PamsBalanceHandler.cookedRabbitAmount, PamsBalanceHandler.cookedRabbitSat)
					.setCreativeTab(LittleUtilities.lu).setHardness(0.8f);
	public static final Block MUTTON_BLOCK = new BlockEdible("mutton_block", Material.CLAY, BLOCKS, ModItems.ITEMS,
			PamsBalanceHandler.muttonAmount, PamsBalanceHandler.muttonSat).setCreativeTab(LittleUtilities.lu)
					.setHardness(0.8f);
	public static final Block COOKED_MUTTON_BLOCK = new BlockEdible("cooked_mutton_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, PamsBalanceHandler.cookedMuttonAmount, PamsBalanceHandler.cookedMuttonSat)
					.setCreativeTab(LittleUtilities.lu).setHardness(0.8f);
	public static final Block COD_BLOCK = new BlockEdible("cod_block", Material.CLAY, BLOCKS, ModItems.ITEMS,
			PamsBalanceHandler.codAmount, PamsBalanceHandler.codSat).setCreativeTab(LittleUtilities.lu)
					.setHardness(0.8f);
	public static final Block COOKED_COD_BLOCK = new BlockEdible("cooked_cod_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, PamsBalanceHandler.cookedCodAmount, PamsBalanceHandler.cookedCodSat)
					.setCreativeTab(LittleUtilities.lu).setHardness(0.8f);
	public static final Block SALMON_BLOCK = new BlockEdible("salmon_block", Material.CLAY, BLOCKS, ModItems.ITEMS,
			PamsBalanceHandler.salmonAmount, PamsBalanceHandler.salmonSat).setCreativeTab(LittleUtilities.lu)
					.setHardness(0.8f);
	public static final Block COOKED_SALMON_BLOCK = new BlockEdible("cooked_salmon_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, PamsBalanceHandler.cookedSalmonAmount, PamsBalanceHandler.cookedSalmonSat)
					.setCreativeTab(LittleUtilities.lu).setHardness(0.8f);
	public static final Block TROPICAL_FISH_BLOCK = new BlockEdible("tropical_fish_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, 1, PamsBalanceHandler.tropicalFishSat).setCreativeTab(LittleUtilities.lu).setHardness(0.8f);
	public static final Block PUFFERFISH_BLOCK = new PufferfishBlock("pufferfish_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, 1, PamsBalanceHandler.pufferSat).setCreativeTab(LittleUtilities.lu).setHardness(0.8f);
	public static final Block ROTTEN_FLESH_BLOCK = ((BlockEdible) new BlockEdible("rotten_flesh_block", Material.CLAY,
			BLOCKS, ModItems.ITEMS, PamsBalanceHandler.rottenFleshAmount, 0.1f))
					.setPotionEffect(MobEffects.HUNGER, 30, 0, 0.8f).setCreativeTab(LittleUtilities.lu)
					.setHardness(0.8f);
	public static final Block APPLE_BLOCK = new BlockEdible("apple_block", Material.CLAY, BLOCKS, ModItems.ITEMS,
			PamsBalanceHandler.appleAmount, PamsBalanceHandler.appleSat).setCreativeTab(LittleUtilities.lu)
					.setHardness(0.9f);
	public static final Block GOLDEN_APPLE_BLOCK = new GoldenAppleBlock("golden_apple_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, 4, 1.2f).setCreativeTab(LittleUtilities.lu).setHardness(0.9f);
	public static final Block NOTCH_APPLE_BLOCK = new GoldenAppleBlock("notch_apple_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, 4, 1.2f).setCreativeTab(LittleUtilities.lu).setHardness(0.9f);
	public static final Block BREAD_BLOCK = new BlockEdible("bread_block", Material.CLAY, BLOCKS, ModItems.ITEMS,
			PamsBalanceHandler.breadAmount, PamsBalanceHandler.breadSat).setCreativeTab(LittleUtilities.lu)
					.setHardness(0.6f);
	public static final Block COOKIE_BLOCK = new BlockEdible("cookie_block", Material.CLAY, BLOCKS, ModItems.ITEMS, 2,
			PamsBalanceHandler.cookieSat).setCreativeTab(LittleUtilities.lu).setHardness(0.5f);
	public static final Block SPIDER_EYE_BLOCK = ((BlockEdible) new BlockEdible("spider_eye_block", Material.CLAY,
			BLOCKS, ModItems.ITEMS, PamsBalanceHandler.spiderEyeAmount, PamsBalanceHandler.spiderEyeSat))
					.setPotionEffect(MobEffects.POISON, 30, 0, 1f).setCreativeTab(LittleUtilities.lu).setHardness(0.8f);
	public static final Block CARROT_BLOCK = new BlockEdible("carrot_block", Material.CLAY, BLOCKS, ModItems.ITEMS,
			PamsBalanceHandler.carrotAmount, PamsBalanceHandler.carrotSat).setCreativeTab(LittleUtilities.lu)
					.setHardness(0.8f);
	public static final Block GOLDEN_CARROT_BLOCK = new BlockEdible("golden_carrot_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, PamsBalanceHandler.goldenCarrotAmount, PamsBalanceHandler.goldenCarrotSat)
					.setCreativeTab(LittleUtilities.lu).setHardness(0.8f);
	public static final Block POTATO_BLOCK = new BlockEdible("potato_block", Material.CLAY, BLOCKS, ModItems.ITEMS,
			PamsBalanceHandler.potatoAmount, PamsBalanceHandler.potatoSat).setCreativeTab(LittleUtilities.lu)
					.setHardness(0.8f);
	public static final Block BAKED_POTATO_BLOCK = new BlockEdible("baked_potato_block", Material.CLAY, BLOCKS,
			ModItems.ITEMS, PamsBalanceHandler.bakedPotatoAmount, PamsBalanceHandler.bakedPotatoSat)
					.setCreativeTab(LittleUtilities.lu).setHardness(0.6f);
	public static final Block POISONOUS_POTATO_BLOCK = ((BlockEdible) new BlockEdible("poisonous_potato_block",
			Material.CLAY, BLOCKS, ModItems.ITEMS, PamsBalanceHandler.potatoAmount, PamsBalanceHandler.potatoSat))
					.setPotionEffect(MobEffects.POISON, 100, 0, 0.6F).setCreativeTab(LittleUtilities.lu)
					.setHardness(0.8f);
	public static final Block BEETROOT_BLOCK = new BlockEdible("beetroot_block", Material.CLAY, BLOCKS, ModItems.ITEMS,
			PamsBalanceHandler.beetrootAmount, PamsBalanceHandler.beetrootSat).setCreativeTab(LittleUtilities.lu)
					.setHardness(0.8f);

	//// COMPACT BLOCKS
	public static final Block COMPACT_COBBLE = new BlockBase("compact_cobble", Material.ROCK, BLOCKS, ModItems.ITEMS)
			.setCreativeTab(LittleUtilities.lu).setHardness(2.2f);
	public static final Block COMPACT_DIRT = new BlockBase("compact_dirt", Material.CLAY, BLOCKS, ModItems.ITEMS)
			.setCreativeTab(LittleUtilities.lu).setHardness(1f);
	public static final Block COMPACT_GRAVEL = new BlockBase("compact_gravel", Material.CLAY, BLOCKS, ModItems.ITEMS)
			.setCreativeTab(LittleUtilities.lu).setHardness(0.9f);
	public static final Block COMPACT_NETHERRACK = new CompactNetherrackBlock("compact_netherrack", Material.ROCK,
			BLOCKS, ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(0.8f);
	public static final Block COMPACT_GRANITE = new BlockBase("compact_granite", Material.ROCK, BLOCKS, ModItems.ITEMS)
			.setCreativeTab(LittleUtilities.lu).setHardness(2.2f);
	public static final Block COMPACT_DIORITE = new BlockBase("compact_diorite", Material.ROCK, BLOCKS, ModItems.ITEMS)
			.setCreativeTab(LittleUtilities.lu).setHardness(2.2f);
	public static final Block COMPACT_ANDESITE = new BlockBase("compact_andesite", Material.ROCK, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(2.2f);
	public static final Block COMPACT_SOUL_SAND = new CompactSoulSand("compact_soul_sand", Material.SAND, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(1f);
	public static final Block COMPACT_OBSIDIAN = new BlockBase("compact_obsidian", Material.ROCK, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(50f).setResistance(2000f);
	public static final Block COMPACT_DRAGON_EGG = new BlockBase("compact_dragon_egg", Material.DRAGON_EGG, BLOCKS,
			ModItems.ITEMS).setCreativeTab(LittleUtilities.lu).setHardness(3f).setResistance(20f);
}