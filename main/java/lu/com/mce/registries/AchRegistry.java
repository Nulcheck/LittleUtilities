package lu.com.mce.registries;

import cpw.mods.fml.common.registry.LanguageRegistry;
import lu.com.mce.common.mod_lu;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;

public class AchRegistry {
	public static Achievement con;
	public static Achievement ghastTear;
	public static Achievement blazeRod1;
	public static Achievement netherStar;
	public static Achievement enderEye;

	public static AchievementPage page;

	public static void registerAch() {
		// 1st # is horz, 2nd # is vert
		con = new Achievement("achievement.con", "con", 0, 0, Item.getItemFromBlock(mod_lu.condenser), AchievementList.openInventory).registerStat();

		ghastTear = new Achievement("achievement.ghastTear", "ghastTear", 0, -1, Item.getItemFromBlock(mod_lu.ghastTearBlock), con).registerStat();

		blazeRod1 = new Achievement("achievement.blazeRod1", "blazeRod1", -1, -1, Item.getItemFromBlock(mod_lu.blazeRodBlock), con).registerStat();

		netherStar = new Achievement("achievement.netherStar", "netherStar", 1, -1, Item.getItemFromBlock(mod_lu.netherStarBlock), con).registerStat().setSpecial();

		enderEye = new Achievement("achievement.enderEye", "enderEye", -2, -1, Item.getItemFromBlock(mod_lu.enderEyeBlock), con).registerStat();

		page = new AchievementPage("\u00A7aLittleUtilities", con, ghastTear, blazeRod1, netherStar, enderEye);
		AchievementPage.registerAchievementPage(page);
	}

	@SuppressWarnings("deprecation")
	private static void addName(String ach, String lang, String name) {
		LanguageRegistry.instance().addStringLocalization("achievement." + ach, lang, name);
	}

	@SuppressWarnings("deprecation")
	private static void addDesc(String ach, String lang, String name) {
		LanguageRegistry.instance().addStringLocalization("achievement." + ach + ".desc", lang, name);
	}

	public static void namingAch() {
		addName("con", "en_US", "Condensed Blocks");
		addDesc("con", "en_US", "Condense all the things!");

		addName("ghastTear", "en_US", "Cry Some More");
		addDesc("ghastTear", "en_US", "Make a Ghast Tear block");

		addName("blazeRod1", "en_US", "Burn Baby, Burn!");
		addDesc("blazeRod1", "en_US", "Make a Blaze Rod block");

		addName("netherStar", "en_US", "Stars in the Night Sky");
		addDesc("netherStar", "en_US", "Make a Nether Star block");
		
		addName("enderEye", "en_US", "Staring Contest!");
		addDesc("enderEye", "en_US", "Make an Ender Eye block");
	}
}
