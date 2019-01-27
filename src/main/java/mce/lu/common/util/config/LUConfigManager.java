package mce.lu.common.util.config;

import mce.lu.common.util.References;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.RangeInt;
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

		@Name("Vines")
		@Comment("Should you be able to craft vines from tall grass and slime balls?")
		@RequiresMcRestart
		public boolean vinesRecipe = true;

		@Name("Prismarine Shards")
		@Comment("Should you be able to get prismarine shards back from prismarine blocks?")
		@RequiresMcRestart
		public boolean prismarineShardsRecipe = true;

		@Name("Prismarine Crystals")
		@Comment("Should you be able to get prismarine crystals back from sea lanterns?")
		@RequiresMcRestart
		public boolean prismarineCrystalsRecipe = true;
	}

	public static class ModConfig {
		@Name("Recipes")
		@Comment("These mainly deal with recipes of items from the mod.")
		public Recipes modRecipes = new Recipes();

		@Name("Events")
		@Comment("These are events that the mod adds such as mob drops, dungeon loot, etc.")
		public Events modEvents = new Events();

		@Name("Blocks/Items Features")
		@Comment("Block or item features.")
		public Features features = new Features();

		@Name("Loot Generation")
		@Comment("Dungeon Loot!")
		public Loot loot = new Loot();

		public static class Recipes {
			@Name("Pure Quartz")
			@Comment("Should you be able to smelt pure quartz into silicon?")
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

		public static class Features {
			@Name("Snow Melter Range")
			@Comment({
					"The range of the snow melter. Min 1, and a max of 7 blocks in each direction. The full 7 blocks in each direction (plus the position of the block itself) is almost a full chunks worth.",
					"[Default: 3]" })
			@RangeInt(min = 1, max = 7)
			@RequiresMcRestart
			public int snowMelterRange = 3;

			@Name("Generate Dye Reeds")
			@Comment("Should dye reeds generate?")
			@RequiresMcRestart
			public boolean generateDyeReeds = true;

			@Name("Dye Reeds Per Chunk")
			@Comment({ "How many dye reeds per chunk should generate?", "[Default: 23]" })
			@RangeInt(min = 1, max = 50)
			@RequiresMcRestart
			public int dyeReedsPerChunk = 23;
		}

		public static class Loot {
			@Name("Pure Quartz")
			@Comment("Should you be able to find pure quartz in dungeon loot?")
			@RequiresMcRestart
			public boolean pureQuartzLoot = true;
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
