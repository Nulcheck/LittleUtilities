package lu.com.mce.common;

import java.util.logging.Logger;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import lu.com.mce.api.waila.LUModule;
import lu.com.mce.blocks.Condenser;
import lu.com.mce.blocks.EdibleBlock;
import lu.com.mce.blocks.ModBlocks;
import lu.com.mce.blocks.ModBlocks.BlazeRodBlock;
import lu.com.mce.blocks.ModBlocks.BoneBlock;
import lu.com.mce.blocks.ModBlocks.BoundsBlock;
import lu.com.mce.blocks.ModBlocks.CompactDirt;
import lu.com.mce.blocks.ModBlocks.CompactNetherrack;
import lu.com.mce.blocks.ModBlocks.EnderPerlBlock;
import lu.com.mce.blocks.ModBlocks.GhastTearBlock;
import lu.com.mce.blocks.ModBlocks.NetherStarBlock;
import lu.com.mce.blocks.ModBlocks.PufferfishBlock;
import lu.com.mce.blocks.ModBlocks.SlimeBlock;
import lu.com.mce.events.ChatEvent;
import lu.com.mce.events.GameEvent;
import lu.com.mce.handlers.AchievementHandler;
import lu.com.mce.handlers.GuiHandler;
import lu.com.mce.handlers.PlayerHandler;
import lu.com.mce.handlers.recipes.BlockRecipeHandler;
import lu.com.mce.handlers.recipes.ItemRecipeHandler;
import lu.com.mce.handlers.registers.AchRegistry;
import lu.com.mce.handlers.registers.BlockRegistry;
import lu.com.mce.handlers.registers.ItemRegistry;
import lu.com.mce.handlers.registers.TileEntityRegistry;
import lu.com.mce.util.ModCreativeTab;
import lu.com.mce.util.updater.CheckVersion;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = mod_lu.modid, name = mod_lu.name, version = mod_lu.version)
public class mod_lu {
	@Mod.Instance("mod_lu")
	public static mod_lu instance;

	public static final int renderId = RenderingRegistry.getNextAvailableRenderId();

	public static final String modid = "mod_lu";
	public static final String version = "1.4";
	public static final String name = "LittleUtilities";

	@SidedProxy(clientSide = "lu.com.mce.client.ClientProxy", serverSide = "lu.com.mce.common.CommonProxy")
	public static CommonProxy proxy;
	public static Logger log = Logger.getLogger("Minecraft");
	public static boolean ebm = Loader.isModLoaded("mod_ebm");

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
	public static Block gunpowderBlock;
	public static Block flintBlock;
	public static Block netherStarBlock;
	public static Block paperBlock;
	public static Block slimeBlock;
	public static Block enderPerlBlock;
	public static Block enderEyeBlock;
	public static Block boneBlock;
	public static Block magmaCreamBlock;
	public static Block stickBlock;
	public static Block dyeBlock; // Maybe

	// Compact Blocks
	public static Block compCobble;
	public static Block compDirt;
	public static Block compNetherrack;

	// Items
	public static Item sponge;

	public static final int condenserGUI = 0;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		new CheckVersion();
		condenser = new Condenser(Material.ground).setBlockName("condenser").setBlockTextureName("mod_lu:condenser").setCreativeTab(lu).setStepSound(Block.soundTypeStone);

		//// TODO: Condensed Blocks
		ghastTearBlock = new GhastTearBlock(Material.glass).setBlockName("ghastTearBlock").setBlockTextureName("mod_lu:ghast_tear").setCreativeTab(lu).setStepSound(Block.soundTypeGlass)
				.setLightLevel(0.4f);

		blazeRodBlock = new BlazeRodBlock(Material.ground).setBlockName("blazeRodBlock").setBlockTextureName("mod_lu:blaze_rod").setCreativeTab(lu).setStepSound(Block.soundTypeStone)
				.setLightLevel(1f);

		porkBlock = new EdibleBlock(Material.ground, 3, 0.3f).setBlockName("pork").setBlockTextureName("mod_lu:pork").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		cookedPorkBlock = new EdibleBlock(Material.ground, 8, 0.8f).setBlockName("cookedPork").setBlockTextureName("mod_lu:cooked_pork").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		beefBlock = new EdibleBlock(Material.ground, 3, 0.3f).setBlockName("beef").setBlockTextureName("mod_lu:beef").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		cookedBeefBlock = new EdibleBlock(Material.ground, 8, 0.8f).setBlockName("cookedBeef").setBlockTextureName("mod_lu:cooked_beef").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		chickenBlock = ((EdibleBlock) new EdibleBlock(Material.ground, 2, 0.3f).setBlockName("chicken").setBlockTextureName("mod_lu:chicken").setCreativeTab(lu).setStepSound(Block.soundTypeGravel))
				.setPotionEffect(Potion.hunger.id, 30, 0, 0.3F);

		cookedChickenBlock = new EdibleBlock(Material.ground, 6, 0.6f).setBlockName("cookedChicken").setBlockTextureName("mod_lu:cooked_chicken").setCreativeTab(lu)
				.setStepSound(Block.soundTypeGravel);

		fishBlock = new EdibleBlock(Material.ground, 2, 0.4f).setBlockName("fish").setBlockTextureName("mod_lu:fish").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		cookedFishBlock = new EdibleBlock(Material.ground, 5, 0.6f).setBlockName("cookedFish").setBlockTextureName("mod_lu:cooked_fish").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		salmonBlock = new EdibleBlock(Material.ground, 2, 0.2f).setBlockName("salmon").setBlockTextureName("mod_lu:salmon").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		cookedSalmonBlock = new EdibleBlock(Material.ground, 6, 0.6f).setBlockName("cookedSalmon").setBlockTextureName("mod_lu:cooked_salmon").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		clownfishBlock = new EdibleBlock(Material.ground, 1, 0.2f).setBlockName("clownfish").setBlockTextureName("mod_lu:clownfish").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		pufferfishBlock = new PufferfishBlock(Material.ground, 1, 0.2f).setBlockName("puff").setBlockTextureName("mod_lu:pufferfish").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		rottenFleshBlock = ((EdibleBlock) new EdibleBlock(Material.ground, 4, 0.1f).setBlockName("rottenFleshBlock").setBlockTextureName("mod_lu:rotten_flesh").setCreativeTab(lu)
				.setStepSound(Block.soundTypeGravel)).setPotionEffect(Potion.hunger.id, 30, 0, 0.8f);

		appleBlock = new EdibleBlock(Material.ground, 4, 0.3f).setBlockName("appleBlock").setBlockTextureName("mod_lu:apple").setCreativeTab(lu).setStepSound(Block.soundTypeWood);

		breadBlock = new EdibleBlock(Material.ground, 5, 0.6f).setBlockName("breadBlock").setBlockTextureName("mod_lu:bread").setCreativeTab(lu).setStepSound(Block.soundTypeCloth);

		cookieBlock = new EdibleBlock(Material.ground, 2, 0.1f).setBlockName("cookieBlock").setBlockTextureName("mod_lu:cookie").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		spiderEyeBlock = new EdibleBlock(Material.ground, 2, 0.8f).setBlockName("spiderEyeBlock").setBlockTextureName("mod_lu:spider_eye").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		fSpiderEyeBlock = new ModBlocks(Material.ground).setBlockName("fSpiderEyeBlock").setBlockTextureName("mod_lu:fermented_spider_eye").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		carrotBlock = new EdibleBlock(Material.gourd, 4, 0.6f).setBlockName("carrotBlock").setBlockTextureName("mod_lu:carrot").setCreativeTab(lu).setStepSound(Block.soundTypeWood);

		potatoBlock = new EdibleBlock(Material.gourd, 1, 0.3f).setBlockName("potatoBlock").setBlockTextureName("mod_lu:potato").setCreativeTab(lu).setStepSound(Block.soundTypeWood);

		gunpowderBlock = new BoundsBlock(Material.ground, 0.1f).setBlockName("gunpowderBlock").setBlockTextureName("mod_lu:gunpowder").setCreativeTab(lu).setStepSound(Block.soundTypeSand);

		flintBlock = new ModBlocks(Material.ground).setBlockName("flintBlock").setBlockTextureName("mod_lu:flint").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		netherStarBlock = new NetherStarBlock(Material.ground).setBlockName("netherStarBlock").setBlockTextureName("mod_lu:nether_star").setCreativeTab(lu).setStepSound(Block.soundTypeGlass);

		paperBlock = new ModBlocks(Material.ground).setBlockName("paperBlock").setBlockTextureName("mod_lu:paper").setCreativeTab(lu).setStepSound(Block.soundTypeGrass);

		slimeBlock = new SlimeBlock(Material.clay).setBlockName("slimeBlock").setBlockTextureName("mod_lu:slime").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		enderPerlBlock = new EnderPerlBlock(Material.ground).setBlockName("enderPerlBlock").setBlockTextureName("mod_lu:ender_perl").setCreativeTab(lu).setStepSound(Block.soundTypeStone);

		enderEyeBlock = new ModBlocks(Material.ground).setBlockName("enderEyeBlock").setBlockTextureName("mod_lu:ender_eye").setCreativeTab(lu).setStepSound(Block.soundTypeGlass);

		boneBlock = new BoneBlock(Material.rock).setBlockName("boneBlock").setBlockTextureName("mod_lu:bone").setCreativeTab(lu).setStepSound(Block.soundTypeStone);

		magmaCreamBlock = new ModBlocks(Material.clay).setBlockName("magmaCreamBlock").setBlockTextureName("mod_lu:magma_cream").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		//// TODO: Compact Blocks
		compCobble = new ModBlocks(Material.rock).setBlockName("compCobble").setBlockTextureName("mod_lu:compact_cobble").setCreativeTab(lu).setStepSound(Block.soundTypePiston);

		compDirt = new CompactDirt().setBlockName("compDirt").setBlockTextureName("mod_lu:compact_dirt").setCreativeTab(lu).setStepSound(Block.soundTypeGravel);

		compNetherrack = new CompactNetherrack().setBlockName("compNetherrack").setBlockTextureName("mod_lu:compact_netherrack").setCreativeTab(lu).setStepSound(Block.soundTypePiston);

		//// TODO: Items
		sponge = new Item().setUnlocalizedName("sponge").setCreativeTab(lu);

		MinecraftForge.EVENT_BUS.register(new ChatEvent());
		MinecraftForge.EVENT_BUS.register(new GameEvent());
		FMLCommonHandler.instance().bus().register(new GameEvent());
		FMLCommonHandler.instance().bus().register(new PlayerHandler());
		FMLCommonHandler.instance().bus().register(new AchievementHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(mod_lu.instance, new GuiHandler());
	}

	@EventHandler
	public void processIMC(FMLInterModComms.IMCEvent e) {
		if (Loader.isModLoaded("Waila")) {
			LUModule.register();
			log.info("Loaded integration with Waila.");
		}
	}

	public static CreativeTabs lu = new ModCreativeTab("LU");

	@EventHandler
	public void load(FMLInitializationEvent event) {
		BlockRegistry.registerBlocks();
		ItemRegistry.registerItems();

		BlockRecipeHandler.registerCrafting();
		ItemRecipeHandler.registerCrafting();

		TileEntityRegistry.teRegistry();

		AchRegistry.registerAch();
		AchRegistry.namingAch();
		proxy.registerRenders();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {}
}