package mce.lu.common.util.config;

import mce.lu.common.util.References;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.RequiresMcRestart;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
@Config(modid = References.MOD_ID, type = Type.INSTANCE, name = References.NAME)
public class LUConfigManager {
	@Name("Vanilla Recipes")
	@Comment("These are recipes added by the mod to get vanilla items.")
	public static VanillaRecipes vanillaRecipes = new VanillaRecipes();

	@Name("Mod Config")
	@Comment("These options are about recipes, events, items and blocks from the mod itself. Nothing vanilla here.")
	public static ModConfig modConfig = new ModConfig();

	public static class VanillaRecipes {
		@Name("Saddles")
		@Comment("Should you be able to craft saddles?")
		@RequiresMcRestart
		public boolean saddleRecipe = true;

		@Name("Horse Armors")
		@Comment("Should you be able to craft horse armors?")
		@RequiresMcRestart
		public boolean horseArmorsRecipe = true;

		@Name("Colored Glass")
		@Comment("Should you be able to craft *one* colored glass/glass pane?")
		@RequiresMcRestart
		public boolean coloredGlassRecipe = true;

		@Name("Rotten Flesh")
		@Comment("Should you be able to craft rotten flesh? (Fermented Spider Eye + Meat)")
		@RequiresMcRestart
		public boolean rottenFleshRecipe = true;

		@Name("Blaze Rods")
		@Comment("Should you be able to craft blaze rods from blaze powder?")
		@RequiresMcRestart
		public boolean blazeRodRecipe = true;

		@Name("Bones")
		@Comment("Should you be able to craft bones from bonemeal?")
		@RequiresMcRestart
		public boolean boneRecipe = true;

		@Name("Gravel")
		@Comment("Should you be able to craft gravel? (Flint + Cobblestone)")
		@RequiresMcRestart
		public boolean gravelRecipe = true;

		@Name("Name Tags")
		@Comment("Should you be able to craft name tags?")
		@RequiresMcRestart
		public boolean nameTagRecipe = true;

		@Name("Torch from Blaze Powder")
		@Comment("Should you be able to craft torches with blaze power?")
		@RequiresMcRestart
		public boolean blazePowderTorchRecipe = true;

		@Name("Cobwebs")
		@Comment("Should you be able to craft cobwebs from string?")
		@RequiresMcRestart
		public boolean cobwebRecipe = true;

		@Name("Mossy Stones")
		@Comment("Should you be able to craft mossy stone stuff? (Cobblestone/Stone Bricks/Cobblestone Wall + Vines)")
		@RequiresMcRestart
		public boolean mossyStonesRecipe = true;

		@Name("Clay Balls")
		@Comment("Should you be able to craft clay balls from a clay block?")
		@RequiresMcRestart
		public boolean clayBallRecipe = true;

		@Name("Snowballs")
		@Comment("Should you be able to craft snowballs from a snow block?")
		@RequiresMcRestart
		public boolean snowballRecipe = true;

		@Name("Glowstone Dust")
		@Comment("Should you be able to craft glowstone dust from a glowstone block?")
		@RequiresMcRestart
		public boolean glowstoneDustRecipe = true;
	}

	public static class ModConfig {
		@Name("Recipes")
		@Comment("These mainly deal with recipes of items from the mod.")
		public Recipes modRecipes = new Recipes();

		@Name("Events")
		@Comment("These are events that the mod adds such as mob drops, dungeon loot, etc.")
		public Events modEvents = new Events();

		public static class Recipes {
			@Name("Pure Quartz")
			@Comment("Should you be able to craft pure quartz? (To get silicon if a mod has it)")
			@RequiresMcRestart
			public boolean pureQuartzRecipe = true;

			@Name("Leather Scraps")
			@Comment("Should some mobs drop leather scraps, and can you craft leather from this? (Both drops and crafting will be toggled)")
			@RequiresMcRestart
			public boolean leatherScraps = true;

			@Name("Zombie Curing Kit")
			@Comment("Should you be able to craft the zombie curing kit?")
			@RequiresMcRestart
			public boolean zombieCuringKit = true;
		}

		public static class Events {
			@Name("Blaze Rod Sets Mobs on Fire")
			@Comment("Should you be able to set mobs/players on fire just by hitting them with a blaze rod?")
			@RequiresMcRestart
			public boolean blazeRodEvent = true;

			@Name("Dye Block by Right Clicking")
			@Comment("Should you be able to dye a block (Glass, Wool, Terracotta, etc) just by holding a dye and right clicking the block?")
			@RequiresMcRestart
			public boolean dyeEvent = true;
		}
	}

	@EventBusSubscriber
	public static class Handler {
		@SubscribeEvent
		public void onConfigChangedEvent(OnConfigChangedEvent e) {
			if (e.getModID().equals(References.MOD_ID))
				ConfigManager.sync(References.MOD_ID, Type.INSTANCE);
		}
	}
}
