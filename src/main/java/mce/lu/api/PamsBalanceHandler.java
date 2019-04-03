package mce.lu.api;

import static com.pam.harvestcraft.HarvestCraft.config;

import com.pam.harvestcraft.config.ConfigHandler;

import net.minecraftforge.fml.common.Loader;

public class PamsBalanceHandler {
	public static PamsBalanceHandler pam;
	static boolean mod = (Loader.isModLoaded("harvestcraft") && ConfigHandler.enablevanillafoodBalance);

	public static int porkAmount = mod ? 1 : 3;
	public static float porkSat = mod ? config.snacksaturation : 0.3f;

	public static int cookedPorkAmount = mod ? 2 : 8;
	public static float cookedPorkSat = mod ? config.snacksaturation : 0.8f;

	public static int beefAmount = mod ? 1 : 3;
	public static float beefSat = mod ? config.snacksaturation : 0.3f;

	public static int cookedBeefAmount = mod ? 2 : 8;
	public static float cookedBeefSat = mod ? config.snacksaturation : 0.8f;

	public static int chickenAmount = mod ? 1 : 2;
	public static float chickenSat = mod ? config.snacksaturation : 0.3f;

	public static int cookedChickenAmount = mod ? 2 : 6;
	public static float cookedChickenSat = mod ? config.snacksaturation : 0.6f;

	public static int rabbitAmount = mod ? 1 : 3;
	public static float rabbitSat = mod ? config.snacksaturation : 0.3f;

	public static int cookedRabbitAmount = mod ? 2 : 5;
	public static float cookedRabbitSat = mod ? config.snacksaturation : 0.6f;

	public static int muttonAmount = mod ? 1 : 2;
	public static float muttonSat = mod ? config.snacksaturation : 0.3f;

	public static int cookedMuttonAmount = mod ? 2 : 5;
	public static float cookedMuttonSat = mod ? config.snacksaturation : 0.8f;

	public static int codAmount = mod ? 1 : 2;
	public static float codSat = mod ? config.snacksaturation : 0.4f;

	public static int cookedCodAmount = mod ? 2 : 5;
	public static float cookedCodSat = mod ? config.snacksaturation : 0.6f;

	public static int salmonAmount = mod ? 1 : 2;
	public static float salmonSat = mod ? config.snacksaturation : 0.2f;

	public static int cookedSalmonAmount = mod ? 2 : 6;
	public static float cookedSalmonSat = mod ? config.snacksaturation : 0.6f;

	public static float tropicalFishSat = mod ? config.snacksaturation : 0.2f;
	public static float pufferSat = mod ? config.snacksaturation : 0.2f;

	public static int rottenFleshAmount = mod ? 2 : 4;

	public static int appleAmount = mod ? config.cropfoodRestore : 4;
	public static float appleSat = mod ? config.cropsaturationRestore : 0.3f;

	public static int breadAmount = mod ? 3 : 5;
	public static float breadSat = mod ? config.mealsaturation : 0.6f;

	public static float cookieSat = mod ? config.mealsaturation : 0.1f;

	public static int spiderEyeAmount = mod ? 1 : 2;
	public static float spiderEyeSat = mod ? config.snacksaturation : 0.8f;

	public static int carrotAmount = mod ? config.cropfoodRestore : 4;
	public static float carrotSat = mod ? config.cropsaturationRestore : 0.6f;

	public static int goldenCarrotAmount = mod ? config.cropfoodRestore * 2 : 6;
	public static float goldenCarrotSat = mod ? config.cropsaturationRestore * 2 : 1.2f;

	public static int potatoAmount = mod ? config.cropfoodRestore : 1;
	public static float potatoSat = mod ? config.cropsaturationRestore : 0.3f;

	public static int bakedPotatoAmount = mod ? 2 : 5;
	public static float bakedPotatoSat = mod ? config.mealsaturation : 0.6f;

	public static int beetrootAmount = mod ? config.cropfoodRestore : 1;
	public static float beetrootSat = mod ? config.cropsaturationRestore : 0.6f;
}
