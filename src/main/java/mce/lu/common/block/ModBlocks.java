package mce.lu.common.block;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.MobEffects;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class ModBlocks {
	public static final List<Block> BLOCKS = new ArrayList<Block>();

	public static final Block CONDENSER = new Condenser("condenser", Material.ROCK).setHardness(1.5f);
	public static final Block SNOW_MELTER = new SnowMelter("snow_melter", Material.IRON).setHardness(1.2f);

	//// CONDENSED ITEM BLOCKS
	public static final Block GHAST_TEAR_BLOCK = new GhastTearBlock("ghast_tear_block", Material.GLASS)
			.setLightLevel(0.4f).setHardness(1f);
	public static final Block BLAZE_ROD_BLOCK = new BlazeRodBlock("blaze_rod_block", Material.GLASS).setLightLevel(1f)
			.setHardness(1f);
	public static final Block NETHER_STAR_BLOCK = new NetherStarBlock("nether_star_block", Material.GLASS)
			.setHardness(2f);
	public static final Block GUNPOWDER_BLOCK = new BoundsBlock("gunpowder_block", Material.SAND, 0.0625d)
			.setHardness(0.5f);
	public static final Block FLINT_BLOCK = new BlockBase("flint_block", Material.CLAY).setHardness(0.7f);
	public static final Block PAPER_BLOCK = new BlockBase("paper_block", Material.GROUND).setHardness(0.6f);
	public static final Block ENDER_EYE_BLOCK = new EnderEyeBlock("ender_eye_block", Material.ROCK).setHardness(1f);
	public static final Block MAGMA_CREAM_BLOCK = new BlockBase("magma_cream_block", Material.CLAY).setLightLevel(0.45f)
			.setHardness(0.8f);
	public static final Block FEATHER_BLOCK = new FeatherBlock("feather_block", Material.CLOTH).setHardness(0.5f);
	public static final Block EGG_BLOCK = new BlockBase("egg_block", Material.WOOD).setHardness(0.5f);
	public static final Block SUGAR_BLOCK = new BoundsBlock("sugar_block", Material.SAND, 0.0625d).setHardness(0.5f);
	public static final Block FERMENTED_SPIDER_EYE_BLOCK = new BlockBase("fermented_spider_eye_block", Material.CLAY)
			.setHardness(0.6f);

	// USEABLE BLOCKS
	public static final Block ENDER_PEARL_BLOCK = new EnderPearlBlock("ender_pearl_block", Material.GLASS)
			.setHardness(1f);

	// EDIBLE BLOCKS
	public static final Block PORK_BLOCK = new EdibleBlock("pork_block", Material.CLAY, 3, 0.3f).setHardness(0.8f);
	public static final Block COOKED_PORK_BLOCK = new EdibleBlock("cooked_pork_block", Material.CLAY, 8, 0.8f)
			.setHardness(0.8f);
	public static final Block BEEF_BLOCK = new EdibleBlock("beef_block", Material.CLAY, 3, 0.3f).setHardness(0.8f);
	public static final Block COOKED_BEEF_BLOCK = new EdibleBlock("cooked_beef_block", Material.CLAY, 8, 0.8f)
			.setHardness(0.8f);
	public static final Block CHICKEN_BLOCK = ((EdibleBlock) new EdibleBlock("chicken_block", Material.CLAY, 2, 0.3f))
			.setPotionEffect(MobEffects.HUNGER, 30, 0, 0.3f).setHardness(0.8f);
	public static final Block COOKED_CHICKEN_BLOCK = new EdibleBlock("cooked_chicken_block", Material.CLAY, 6, 0.6f)
			.setHardness(0.8f);
	public static final Block RABBIT_BLOCK = new EdibleBlock("rabbit_block", Material.CLAY, 3, 0.3f).setHardness(0.8f);
	public static final Block COOKED_RABBIT_BLOCK = new EdibleBlock("cooked_rabbit_block", Material.CLAY, 5, 0.6f)
			.setHardness(0.8f);
	public static final Block MUTTON_BLOCK = new EdibleBlock("mutton_block", Material.CLAY, 2, 0.3f).setHardness(0.8f);
	public static final Block COOKED_MUTTON_BLOCK = new EdibleBlock("cooked_mutton_block", Material.CLAY, 6, 0.8f)
			.setHardness(0.8f);
	public static final Block COD_BLOCK = new EdibleBlock("cod_block", Material.CLAY, 2, 0.4f).setHardness(0.8f);
	public static final Block COOKED_COD_BLOCK = new EdibleBlock("cooked_cod_block", Material.CLAY, 5, 0.6f)
			.setHardness(0.8f);
	public static final Block SALMON_BLOCK = new EdibleBlock("salmon_block", Material.CLAY, 2, 0.2f).setHardness(0.8f);
	public static final Block COOKED_SALMON_BLOCK = new EdibleBlock("cooked_salmon_block", Material.CLAY, 6, 0.6f)
			.setHardness(0.8f);
	public static final Block TROPICAL_FISH_BLOCK = new EdibleBlock("tropical_fish_block", Material.CLAY, 1, 0.2f)
			.setHardness(0.8f);
	public static final Block PUFFERFISH_BLOCK = new PufferfishBlock("pufferfish_block", Material.CLAY, 1, 0.2f)
			.setHardness(0.8f);
	public static final Block ROTTEN_FLESH_BLOCK = ((EdibleBlock) new EdibleBlock("rotten_flesh_block", Material.CLAY,
			4, 0.1f)).setPotionEffect(MobEffects.HUNGER, 30, 0, 0.8f).setHardness(0.8f);
	public static final Block APPLE_BLOCK = new EdibleBlock("apple_block", Material.CLAY, 4, 0.3f).setHardness(0.9f);
	public static final Block BREAD_BLOCK = new EdibleBlock("bread_block", Material.CLAY, 5, 0.6f).setHardness(0.6f);
	public static final Block COOKIE_BLOCK = new EdibleBlock("cookie_block", Material.CLAY, 2, 0.1f).setHardness(0.5f);
	public static final Block SPIDER_EYE_BLOCK = ((EdibleBlock) new EdibleBlock("spider_eye_block", Material.CLAY, 2,
			0.8f)).setPotionEffect(MobEffects.POISON, 30, 0, 1f).setHardness(0.8f);
	public static final Block CARROT_BLOCK = new EdibleBlock("carrot_block", Material.CLAY, 4, 0.6f).setHardness(0.8f);
	public static final Block POTATO_BLOCK = new EdibleBlock("potato_block", Material.CLAY, 1, 0.3f).setHardness(0.8f);
	public static final Block BAKED_POTATO_BLOCK = new EdibleBlock("baked_potato_block", Material.CLAY, 6, 0.6f)
			.setHardness(0.6f);

	//// COMPACT BLOCKS
	public static final Block COMPACT_COBBLE = new BlockBase("compact_cobble", Material.ROCK).setHardness(2.2f);
	public static final Block COMPACT_DIRT = new BlockBase("compact_dirt", Material.CLAY).setHardness(1f);
	public static final Block COMPACT_GRAVEL = new BlockBase("compact_gravel", Material.CLAY).setHardness(0.9f);
	public static final Block COMPACT_NETHERRACK = new CompactNetherrack("compact_netherrack", Material.ROCK)
			.setHardness(0.8f);
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> e) {
		e.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
	}
}