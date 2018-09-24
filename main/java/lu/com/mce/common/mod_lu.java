package lu.com.mce.common;

import lu.com.mce.blocks.Condenser;
import lu.com.mce.blocks.EdibleBlock;
import lu.com.mce.blocks.ModBlocks;
import lu.com.mce.blocks.ModBlocks.BlazeRodBlock;
import lu.com.mce.blocks.ModBlocks.BoneBlock;
import lu.com.mce.blocks.ModBlocks.BoundsBlock;
import lu.com.mce.blocks.ModBlocks.CompactDirt;
import lu.com.mce.blocks.ModBlocks.CompactNetherrack;
import lu.com.mce.blocks.ModBlocks.EnderEyeBlock;
import lu.com.mce.blocks.ModBlocks.EnderPerlBlock;
import lu.com.mce.blocks.ModBlocks.GhastTearBlock;
import lu.com.mce.blocks.ModBlocks.NetherStarBlock;
import lu.com.mce.blocks.ModBlocks.PufferfishBlock;
import lu.com.mce.blocks.ModBlocks.SlimeBlock;
import lu.com.mce.events.ChatEvent;
import lu.com.mce.events.GameEvent;
import lu.com.mce.handlers.PlayerHandler;
import lu.com.mce.proxy.CommonProxy;
import lu.com.mce.util.ModCreativeTab;
import lu.com.mce.util.References;
import lu.com.mce.util.updater.CheckVersion;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = References.MOD_ID, name = References.NAME, version = References.VERSION)
public class mod_lu {
	@Instance
	public static mod_lu instance;

	@SidedProxy(clientSide = References.CLIENT_PROXY_CLASS, serverSide = References.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;

	// TODO: Top
	public static Block condenser;

	//// Condensed Blocks
	public static Block ghastTearBlock;
	public static Block blazeRodBlock;
	public static Block porkBlock;
	public static Block cookedPorkBlock;
	public static Block beefBlock;
	public static Block cookedBeefBlock;
	public static Block chickenBlock;
	public static Block cookedChickenBlock;
	public static Block fishBlock;
	public static Block cookedFishBlock;
	public static Block salmonBlock;
	public static Block cookedSalmonBlock;
	public static Block clownfishBlock;
	public static Block pufferfishBlock;
	public static Block rottenFleshBlock;
	public static Block appleBlock;
	public static Block breadBlock;
	public static Block cookieBlock;
	public static Block spiderEyeBlock;
	public static Block fSpiderEyeBlock;
	public static Block carrotBlock;
	public static Block potatoBlock;
	public static Block bakedPotatoBlock;
	public static Block gunpowderBlock;
	public static Block flintBlock;
	public static Block netherStarBlock;
	public static Block paperBlock;
	public static Block slimeBlock;
	public static Block enderPerlBlock;
	public static Block enderEyeBlock;
	public static Block boneBlock;
	public static Block magmaCreamBlock;
	public static Block dyeBlock; // Maybe
	public static Block featherBlock;
	public static Block eggBlock;
	public static Block sugarBlock;

	// Compact Blocks
	public static Block compCobble;
	public static Block compDirt;
	public static Block compGravel;
	public static Block compNetherrack;

	// Items
	public static Item sponge;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent e) {
		new CheckVersion();

		condenser = new Condenser(Material.GROUND).setBlockName("condenser").setBlockTextureName("mod_lu:condenser")
				.setCreativeTab(lu).setStepSound(Block.soundTypeStone);

		//// TODO: Condensed Blocks
		ghastTearBlock = new GhastTearBlock(Material.glass).setBlockName("ghastTearBlock")
				.setBlockTextureName("mod_lu:ghast_tear").setCreativeTab(lu).setStepSound(Block.soundTypeGlass)
				.setLightLevel(0.4f);

		blazeRodBlock = new BlazeRodBlock(Material.GROUND).setBlockName("blazeRodBlock")
				.setBlockTextureName("mod_lu:blaze_rod").setCreativeTab(lu).setStepSound(Block.soundTypeStone)
				.setLightLevel(1f);

		porkBlock = new EdibleBlock(Material.GROUND, 3, 0.3f).setBlockName("pork").setBlockTextureName("mod_lu:pork")
				.setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		cookedPorkBlock = new EdibleBlock(Material.GROUND, 8, 0.8f).setBlockName("cookedPork")
				.setBlockTextureName("mod_lu:cooked_pork").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		beefBlock = new EdibleBlock(Material.GROUND, 3, 0.3f).setBlockName("beef").setBlockTextureName("mod_lu:beef")
				.setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		cookedBeefBlock = new EdibleBlock(Material.GROUND, 8, 0.8f).setBlockName("cookedBeef")
				.setBlockTextureName("mod_lu:cooked_beef").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		chickenBlock = ((EdibleBlock) new EdibleBlock(Material.GROUND, 2, 0.3f).setBlockName("chicken")
				.setBlockTextureName("mod_lu:chicken").setCreativeTab(lu).setStepSound(Block.soundTypeGravel))
						.setPotionEffect(Potion.hunger.id, 30, 0, 0.3F);

		cookedChickenBlock = new EdibleBlock(Material.GROUND, 6, 0.6f).setBlockName("cookedChicken")
				.setBlockTextureName("mod_lu:cooked_chicken").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		fishBlock = new EdibleBlock(Material.GROUND, 2, 0.4f).setBlockName("fish").setBlockTextureName("mod_lu:fish")
				.setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		cookedFishBlock = new EdibleBlock(Material.GROUND, 5, 0.6f).setBlockName("cookedFish")
				.setBlockTextureName("mod_lu:cooked_fish").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		salmonBlock = new EdibleBlock(Material.GROUND, 2, 0.2f).setBlockName("salmon")
				.setBlockTextureName("mod_lu:salmon").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		cookedSalmonBlock = new EdibleBlock(Material.GROUND, 6, 0.6f).setBlockName("cookedSalmon")
				.setBlockTextureName("mod_lu:cooked_salmon").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		clownfishBlock = new EdibleBlock(Material.GROUND, 1, 0.2f).setBlockName("clownfish")
				.setBlockTextureName("mod_lu:clownfish").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		pufferfishBlock = new PufferfishBlock(Material.GROUND, 1, 0.2f).setBlockName("puff")
				.setBlockTextureName("mod_lu:pufferfish").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		rottenFleshBlock = ((EdibleBlock) new EdibleBlock(Material.GROUND, 4, 0.1f).setBlockName("rottenFleshBlock")
				.setBlockTextureName("mod_lu:rotten_flesh").setCreativeTab(lu).setStepSound(Block.soundTypeGravel))
						.setPotionEffect(Potion.hunger.id, 30, 0, 0.8f);

		appleBlock = new EdibleBlock(Material.GROUND, 4, 0.3f).setBlockName("appleBlock")
				.setBlockTextureName("mod_lu:apple").setCreativeTab(lu).setStepSound(Block.soundTypeWood);

		breadBlock = new EdibleBlock(Material.GROUND, 5, 0.6f).setBlockName("breadBlock")
				.setBlockTextureName("mod_lu:bread").setCreativeTab(lu).setStepSound(Block.soundTypeCloth);

		cookieBlock = new EdibleBlock(Material.GROUND, 2, 0.1f).setBlockName("cookieBlock")
				.setBlockTextureName("mod_lu:cookie").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		spiderEyeBlock = new EdibleBlock(Material.GROUND, 2, 0.8f).setBlockName("spiderEyeBlock")
				.setBlockTextureName("mod_lu:spider_eye").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		fSpiderEyeBlock = new ModBlocks(Material.GROUND).setBlockName("fSpiderEyeBlock")
				.setBlockTextureName("mod_lu:fermented_spider_eye").setCreativeTab(lu)
				.setStepSound(Block.soundTypeGravel);

		carrotBlock = new EdibleBlock(Material.gourd, 4, 0.6f).setBlockName("carrotBlock")
				.setBlockTextureName("mod_lu:carrot").setCreativeTab(lu).setStepSound(Block.soundTypeWood);

		potatoBlock = new EdibleBlock(Material.gourd, 1, 0.3f).setBlockName("potatoBlock")
				.setBlockTextureName("mod_lu:potato").setCreativeTab(lu).setStepSound(Block.soundTypeWood);

		bakedPotatoBlock = new EdibleBlock(Material.gourd, 6, 0.6f).setBlockName("bakedPotatoBlock")
				.setBlockTextureName("mod_lu:baked_potato").setCreativeTab(lu).setStepSound(Block.soundTypeWood);

		gunpowderBlock = new BoundsBlock(Material.GROUND, 0.05f).setBlockName("gunpowderBlock")
				.setBlockTextureName("mod_lu:gunpowder").setCreativeTab(lu).setStepSound(Block.soundTypeSand);

		flintBlock = new ModBlocks(Material.GROUND).setBlockName("flintBlock").setBlockTextureName("mod_lu:flint")
				.setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		netherStarBlock = new NetherStarBlock(Material.GROUND).setBlockName("netherStarBlock")
				.setBlockTextureName("mod_lu:nether_star").setCreativeTab(lu).setStepSound(Block.soundTypeGlass);

		paperBlock = new ModBlocks(Material.GROUND).setBlockName("paperBlock").setBlockTextureName("mod_lu:paper")
				.setCreativeTab(lu).setStepSound(Block.soundTypeGrass);

		slimeBlock = new SlimeBlock(Material.clay).setBlockName("slimeBlock").setBlockTextureName("mod_lu:slime")
				.setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		enderPerlBlock = new EnderPerlBlock(Material.GROUND).setBlockName("enderPerlBlock")
				.setBlockTextureName("mod_lu:ender_perl").setCreativeTab(lu).setStepSound(Block.soundTypeStone);

		enderEyeBlock = new EnderEyeBlock(Material.GROUND).setBlockName("enderEyeBlock")
				.setBlockTextureName("mod_lu:ender_eye").setCreativeTab(lu).setStepSound(Block.soundTypeGlass);

		boneBlock = new BoneBlock(Material.rock).setBlockName("boneBlock").setBlockTextureName("mod_lu:bone")
				.setCreativeTab(lu).setStepSound(Block.soundTypeStone);

		magmaCreamBlock = new ModBlocks(Material.clay).setBlockName("magmaCreamBlock")
				.setBlockTextureName("mod_lu:magma_cream").setCreativeTab(lu).setStepSound(Block.soundTypeGravel)
				.setLightLevel(0.45f);

		featherBlock = new ModBlocks(Material.cloth).setBlockName("featherBlock").setBlockTextureName("mod_lu:feather")
				.setCreativeTab(lu).setStepSound(Block.soundTypeCloth);

		eggBlock = new ModBlocks(Material.ground).setBlockName("eggBlock").setBlockTextureName("mod_lu:egg")
				.setCreativeTab(lu).setStepSound(Block.soundTypeWood);

		sugarBlock = new BoundsBlock(Material.ground, 0.05f).setBlockName("sugarBlock")
				.setBlockTextureName("mod_lu:sugar").setCreativeTab(lu).setStepSound(Block.soundTypeSand);

		//// TODO: Compact Blocks
		compCobble = new ModBlocks(Material.rock).setBlockName("compCobble")
				.setBlockTextureName("mod_lu:compact_cobble").setCreativeTab(lu).setStepSound(Block.soundTypePiston);

		compDirt = new CompactDirt().setBlockName("compDirt").setBlockTextureName("mod_lu:compact_dirt")
				.setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		compGravel = new ModBlocks(Material.ground).setBlockName("compGravel")
				.setBlockTextureName("mod_lu:compact_gravel").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		compNetherrack = new CompactNetherrack().setBlockName("compNetherrack")
				.setBlockTextureName("mod_lu:compact_netherrack").setCreativeTab(lu)
				.setStepSound(Block.soundTypePiston);

		//// TODO: Items
		sponge = new Item().setUnlocalizedName("sponge").setTextureName("mod_lu:sponge").setCreativeTab(lu);

		MinecraftForge.EVENT_BUS.register(new ChatEvent());
		MinecraftForge.EVENT_BUS.register(new GameEvent());
		FMLCommonHandler.instance().bus().register(new GameEvent());
		FMLCommonHandler.instance().bus().register(new PlayerHandler());
	}
	
	public static CreativeTabs lu = new ModCreativeTab("lu");

	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.registerRenders();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
	}
}