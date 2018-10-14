package lu.com.mce.objects;

import java.util.ArrayList;
import java.util.List;

import lu.com.mce.objects.blocks.EdibleBlock;
import lu.com.mce.objects.blocks.ModBlocks.BlazeRodBlock;
import lu.com.mce.objects.blocks.ModBlocks.BoundsBlock;
import lu.com.mce.objects.blocks.ModBlocks.CompactDirt;
import lu.com.mce.objects.blocks.ModBlocks.CompactNetherrack;
import lu.com.mce.objects.blocks.ModBlocks.EnderEyeBlock;
import lu.com.mce.objects.blocks.ModBlocks.EnderPearlBlock;
import lu.com.mce.objects.blocks.ModBlocks.FeatherBlock;
import lu.com.mce.objects.blocks.ModBlocks.GhastTearBlock;
import lu.com.mce.objects.blocks.ModBlocks.NetherStarBlock;
import lu.com.mce.objects.blocks.ModBlocks.PufferfishBlock;
import lu.com.mce.util.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.MobEffects;

public class InitBlocks {
	public static final List<Block> BLOCKS = new ArrayList<Block>();

	public static final Block CONDENSER = new BlockBase("condenser", Material.ROCK);

	//// CONDENSED ITEM BLOCKS
	public static final Block GHAST_TEAR_BLOCK = new GhastTearBlock("ghast_tear_block", Material.GLASS)
			.setLightLevel(0.4f);
	public static final Block BLAZE_ROD_BLOCK = new BlazeRodBlock("blaze_rod_block", Material.GLASS).setLightLevel(1f);
	public static final Block NETHER_STAR_BLOCK = new NetherStarBlock("nether_star_block", Material.GLASS);
	public static final Block GUNPOWDER_BLOCK = new BoundsBlock("gunpowder_block", Material.SAND, 0.05d);
	public static final Block FLINT_BLOCK = new BlockBase("flint_block", Material.CLAY);
	public static final Block PAPER_BLOCK = new BlockBase("paper_block", Material.GROUND);
	public static final Block ENDER_EYE_BLOCK = new EnderEyeBlock("ender_eye_block", Material.ROCK);
	public static final Block MAGMA_CREAM_BLOCK = new BlockBase("magma_cream_block", Material.CLAY)
			.setLightLevel(0.45f);
	public static final Block FEATHER_BLOCK = new FeatherBlock("feather_block", Material.CLOTH);
	public static final Block EGG_BLOCK = new BlockBase("egg_block", Material.WOOD);
	public static final Block SUGAR_BLOCK = new BoundsBlock("sugar_block", Material.SAND, 0.05d);
	public static final Block FERMENTED_SPIDER_EYE_BLOCK = new BlockBase("fermented_spider_eye_block", Material.CLAY);

	// USEABLE BLOCKS
	public static final Block ENDER_PEARL_BLOCK = new EnderPearlBlock("ender_pearl_block", Material.GLASS);

	// EDIBLE BLOCKS
	public static final Block PORK_BLOCK = new EdibleBlock("pork_block", Material.CLAY, 3, 0.3f);
	public static final Block COOKED_PORK_BLOCK = new EdibleBlock("cooked_pork_block", Material.CLAY, 8, 0.8f);
	public static final Block BEEF_BLOCK = new EdibleBlock("beef_block", Material.CLAY, 3, 0.3f);
	public static final Block COOKED_BEEF_BLOCK = new EdibleBlock("cooked_beef_block", Material.CLAY, 8, 0.8f);
	public static final Block CHICKEN_BLOCK = ((EdibleBlock) new EdibleBlock("chicken_block", Material.CLAY, 2, 0.3f))
			.setPotionEffect(MobEffects.HUNGER, 30, 0, 0.3f);
	public static final Block COOKED_CHICKEN_BLOCK = new EdibleBlock("cooked_chicken_block", Material.CLAY, 6, 0.6f);
	public static final Block RABBIT_BLOCK = new EdibleBlock("rabbit_block", Material.CLAY, 3, 0.3f);
	public static final Block COOKED_RABBIT_BLOCK = new EdibleBlock("cooked_rabbit_block", Material.CLAY, 5, 0.6f);
	public static final Block MUTTON_BLOCK = new EdibleBlock("mutton_block", Material.CLAY, 2, 0.3f);
	public static final Block COOKED_MUTTON_BLOCK = new EdibleBlock("cooked_mutton_block", Material.CLAY, 6, 0.8f);
	public static final Block COD_BLOCK = new EdibleBlock("cod_block", Material.CLAY, 2, 0.4f);
	public static final Block COOKED_COD_BLOCK = new EdibleBlock("cooked_cod_block", Material.CLAY, 5, 0.6f);
	public static final Block SALMON_BLOCK = new EdibleBlock("salmon_block", Material.CLAY, 2, 0.2f);
	public static final Block COOKED_SALMON_BLOCK = new EdibleBlock("cooked_salmon_block", Material.CLAY, 6, 0.6f);
	public static final Block TROPICAL_FISH_BLOCK = new EdibleBlock("tropical_fish_block", Material.CLAY, 1, 0.2f);
	public static final Block PUFFERFISH_BLOCK = new PufferfishBlock("pufferfish_block", Material.CLAY, 1, 0.2f);
	public static final Block ROTTEN_FLESH_BLOCK = ((EdibleBlock) new EdibleBlock("rotten_flesh_block", Material.CLAY,
			4, 0.1f)).setPotionEffect(MobEffects.HUNGER, 30, 0, 0.8f);
	public static final Block APPLE_BLOCK = new EdibleBlock("apple_block", Material.CLAY, 4, 0.3f);
	public static final Block BREAD_BLOCK = new EdibleBlock("bread_block", Material.CLAY, 5, 0.6f);
	public static final Block COOKIE_BLOCK = new EdibleBlock("cookie_block", Material.CLAY, 2, 0.1f);
	public static final Block SPIDER_EYE_BLOCK = ((EdibleBlock) new EdibleBlock("spider_eye_block", Material.CLAY, 2,
			0.8f)).setPotionEffect(MobEffects.POISON, 30, 0, 1f);
	public static final Block CARROT_BLOCK = new EdibleBlock("carrot_block", Material.CLAY, 4, 0.6f);
	public static final Block POTATO_BLOCK = new EdibleBlock("potato_block", Material.CLAY, 1, 0.3f);
	public static final Block BAKED_POTATO_BLOCK = new EdibleBlock("baked_potato_block", Material.CLAY, 6, 0.6f);

	//// COMPACT BLOCKS
	public static final Block COMPACT_COBBLE = new BlockBase("compact_cobble", Material.ROCK);
	public static final Block COMPACT_DIRT = new CompactDirt("compact_dirt", Material.CLAY);
	public static final Block COMPACT_GRAVEL = new BlockBase("compact_gravel", Material.CLAY);
	public static final Block COMPACT_NETHERRACK = new CompactNetherrack("compact_netherrack", Material.ROCK);
}