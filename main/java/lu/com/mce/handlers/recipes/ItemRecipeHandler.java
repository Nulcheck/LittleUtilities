package lu.com.mce.handlers.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import lu.com.mce.common.mod_lu;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ItemRecipeHandler {
	public static void registerCrafting() {
		GameRegistry.addRecipe(new ItemStack(Items.blaze_rod), "p", "p", 'p', new ItemStack(Items.blaze_powder));

		GameRegistry.addRecipe(new ItemStack(Items.bone), "p", "p", "p", 'p', new ItemStack(Items.dye, 1, 15));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.rotten_flesh), new ItemStack(Items.fermented_spider_eye), new ItemStack(Items.porkchop));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.rotten_flesh), new ItemStack(Items.fermented_spider_eye), new ItemStack(Items.cooked_porkchop));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.rotten_flesh), new ItemStack(Items.fermented_spider_eye), new ItemStack(Items.beef));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.rotten_flesh), new ItemStack(Items.fermented_spider_eye), new ItemStack(Items.cooked_beef));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.rotten_flesh), new ItemStack(Items.fermented_spider_eye), new ItemStack(Items.chicken));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.rotten_flesh), new ItemStack(Items.fermented_spider_eye), new ItemStack(Items.cooked_chicken));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.name_tag), new ItemStack(Items.lead), new ItemStack(Items.paper));

		GameRegistry.addRecipe(new ItemStack(Items.saddle), "lll", "lil", "i i", 'l', new ItemStack(Items.leather), 'i', new ItemStack(Items.iron_ingot));

		GameRegistry.addRecipe(new ItemStack(Items.iron_horse_armor), "  i", "isi", "i i", 's', new ItemStack(Items.saddle), 'i', new ItemStack(Items.iron_ingot));

		GameRegistry.addRecipe(new ItemStack(Items.golden_horse_armor), "  i", "isi", "i i", 's', new ItemStack(Items.saddle), 'i', new ItemStack(Items.gold_ingot));

		GameRegistry.addRecipe(new ItemStack(Items.diamond_horse_armor), "  i", "isi", "i i", 's', new ItemStack(Items.saddle), 'i', new ItemStack(Items.diamond));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.quartz, 4), new ItemStack(Blocks.quartz_block));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.clay_ball, 4), new ItemStack(Blocks.clay));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.snowball, 4), new ItemStack(Blocks.snow));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.glowstone_dust, 4), new ItemStack(Blocks.glowstone));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.netherbrick, 4), new ItemStack(Blocks.nether_brick));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.brick, 4), new ItemStack(Blocks.brick_block));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.string, 4), new ItemStack(Blocks.wool));

		// Reverse Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(Items.ghast_tear, 9), new ItemStack(mod_lu.ghastTearBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.blaze_rod, 9), new ItemStack(mod_lu.blazeRodBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.fermented_spider_eye, 9), new ItemStack(mod_lu.fSpiderEyeBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.gunpowder, 9), new ItemStack(mod_lu.gunpowderBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.nether_star, 9), new ItemStack(mod_lu.netherStarBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.paper, 9), new ItemStack(mod_lu.paperBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.slime_ball, 9), new ItemStack(mod_lu.slimeBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.ender_eye, 9), new ItemStack(mod_lu.enderEyeBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.bone, 9), new ItemStack(mod_lu.boneBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.magma_cream, 9), new ItemStack(mod_lu.magmaCreamBlock));

		// Meta recipes
		for (int i = 0; i < 10; ++i) {
			GameRegistry.addShapelessRecipe(new ItemStack(Items.porkchop, 9 - i), new ItemStack(mod_lu.porkBlock, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.cooked_porkchop, 9 - i), new ItemStack(mod_lu.cookedPorkBlock, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.beef, 9 - i), new ItemStack(mod_lu.beefBlock, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.cooked_beef, 9 - i), new ItemStack(mod_lu.cookedBeefBlock, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.chicken, 9 - i), new ItemStack(mod_lu.chickenBlock, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.cooked_chicken, 9 - i), new ItemStack(mod_lu.cookedChickenBlock, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.fish, 9 - i, 1), new ItemStack(mod_lu.fishBlock, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.fish, 9 - i, 1), new ItemStack(mod_lu.salmonBlock, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.fish, 9 - i, 2), new ItemStack(mod_lu.clownfishBlock, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.fish, 9 - i, 3), new ItemStack(mod_lu.pufferfishBlock, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.cooked_fished, 9 - i, 0), new ItemStack(mod_lu.cookedFishBlock, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.cooked_fished, 9 - i, 1), new ItemStack(mod_lu.cookedSalmonBlock, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.rotten_flesh, 9 - i), new ItemStack(mod_lu.rottenFleshBlock, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.apple, 9 - i), new ItemStack(mod_lu.appleBlock, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.bread, 9 - i), new ItemStack(mod_lu.breadBlock, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.cookie, 9 - i), new ItemStack(mod_lu.cookieBlock, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.spider_eye, 9 - i), new ItemStack(mod_lu.spiderEyeBlock, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.carrot, 9 - i), new ItemStack(mod_lu.carrotBlock, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.potato, 9 - i), new ItemStack(mod_lu.potatoBlock, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.ender_pearl, 9 - i), new ItemStack(mod_lu.enderPerlBlock, 1, i));
		}
	}
}
