package lu.com.mce.handlers.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import lu.com.mce.blocks.EdibleBlock;
import lu.com.mce.common.mod_lu;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class BlockRecipeHandler {
	@SuppressWarnings("unchecked")
	public static void registerCrafting() {
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 0), new ItemStack(Blocks.glass), new ItemStack(Items.dye, 1, 15));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 1), new ItemStack(Blocks.glass), new ItemStack(Items.dye, 1, 14));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 2), new ItemStack(Blocks.glass), new ItemStack(Items.dye, 1, 13));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 3), new ItemStack(Blocks.glass), new ItemStack(Items.dye, 1, 12));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 4), new ItemStack(Blocks.glass), new ItemStack(Items.dye, 1, 11));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 5), new ItemStack(Blocks.glass), new ItemStack(Items.dye, 1, 10));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 6), new ItemStack(Blocks.glass), new ItemStack(Items.dye, 1, 9));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 7), new ItemStack(Blocks.glass), new ItemStack(Items.dye, 1, 8));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 8), new ItemStack(Blocks.glass), new ItemStack(Items.dye, 1, 7));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 9), new ItemStack(Blocks.glass), new ItemStack(Items.dye, 1, 6));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 10), new ItemStack(Blocks.glass), new ItemStack(Items.dye, 1, 5));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 11), new ItemStack(Blocks.glass), new ItemStack(Items.dye, 1, 4));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 12), new ItemStack(Blocks.glass), new ItemStack(Items.dye, 1, 3));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 13), new ItemStack(Blocks.glass), new ItemStack(Items.dye, 1, 2));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 14), new ItemStack(Blocks.glass), new ItemStack(Items.dye, 1, 1));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 15), new ItemStack(Blocks.glass), new ItemStack(Items.dye, 1, 0));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 0), new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 15));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 1), new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 14));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 2), new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 13));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 3), new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 12));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 4), new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 11));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 5), new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 10));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 6), new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 9));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 7), new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 8));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 8), new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 7));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 9), new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 6));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 10), new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 5));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 11), new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 4));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 12), new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 3));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 13), new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 2));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 14), new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 1));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 15), new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 0));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Blocks.torch, 4), "f", "s", 'f', new ItemStack(Items.blaze_powder), 's', "stickWood"));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.gravel), new ItemStack(Items.flint), new ItemStack(Blocks.cobblestone));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.mossy_cobblestone), new ItemStack(Blocks.cobblestone), new ItemStack(Blocks.vine));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stonebrick, 1, 1), new ItemStack(Blocks.stonebrick), new ItemStack(Blocks.vine));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.cobblestone_wall, 1, 1), new ItemStack(Blocks.cobblestone_wall, 1, 0), new ItemStack(Blocks.vine));

		GameRegistry.addRecipe(new ItemStack(Blocks.web), "s s", " s ", "s s", 's', new ItemStack(Items.string));

		GameRegistry.addRecipe(new ItemStack(mod_lu.condenser), "*", '*', new ItemStack(Blocks.dirt));

		// Reverse Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(Items.ghast_tear, 9), new ItemStack(mod_lu.ghastTearBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.blaze_rod, 9), new ItemStack(mod_lu.blazeRodBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.fermented_spider_eye, 9), new ItemStack(mod_lu.fSpiderEyeBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.gunpowder, 9), new ItemStack(mod_lu.gunpowderBlock));

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
		}
	}
}
