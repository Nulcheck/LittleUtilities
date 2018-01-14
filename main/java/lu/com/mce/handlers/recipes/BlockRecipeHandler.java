package lu.com.mce.handlers.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class BlockRecipeHandler {
	public static void registerCrafting() {
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 0), new ItemStack(Blocks.glass),
				new ItemStack(Items.dye, 1, 15));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 1), new ItemStack(Blocks.glass),
				new ItemStack(Items.dye, 1, 14));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 2), new ItemStack(Blocks.glass),
				new ItemStack(Items.dye, 1, 13));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 3), new ItemStack(Blocks.glass),
				new ItemStack(Items.dye, 1, 12));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 4), new ItemStack(Blocks.glass),
				new ItemStack(Items.dye, 1, 11));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 5), new ItemStack(Blocks.glass),
				new ItemStack(Items.dye, 1, 10));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 6), new ItemStack(Blocks.glass),
				new ItemStack(Items.dye, 1, 9));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 7), new ItemStack(Blocks.glass),
				new ItemStack(Items.dye, 1, 8));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 8), new ItemStack(Blocks.glass),
				new ItemStack(Items.dye, 1, 7));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 9), new ItemStack(Blocks.glass),
				new ItemStack(Items.dye, 1, 6));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 10), new ItemStack(Blocks.glass),
				new ItemStack(Items.dye, 1, 5));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 11), new ItemStack(Blocks.glass),
				new ItemStack(Items.dye, 1, 4));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 12), new ItemStack(Blocks.glass),
				new ItemStack(Items.dye, 1, 3));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 13), new ItemStack(Blocks.glass),
				new ItemStack(Items.dye, 1, 2));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 14), new ItemStack(Blocks.glass),
				new ItemStack(Items.dye, 1, 1));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass, 1, 15), new ItemStack(Blocks.glass),
				new ItemStack(Items.dye, 1, 0));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 0),
				new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 15));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 1),
				new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 14));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 2),
				new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 13));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 3),
				new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 12));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 4),
				new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 11));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 5),
				new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 10));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 6),
				new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 9));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 7),
				new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 8));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 8),
				new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 7));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 9),
				new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 6));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 10),
				new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 5));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 11),
				new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 4));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 12),
				new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 3));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 13),
				new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 2));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 14),
				new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 1));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 15),
				new ItemStack(Blocks.glass_pane), new ItemStack(Items.dye, 1, 0));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Blocks.torch, 4), "f", "s",
				'f', new ItemStack(Items.blaze_powder), 's', "stickWood"));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.gravel), new ItemStack(Items.flint),
				new ItemStack(Blocks.cobblestone));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.mossy_cobblestone), new ItemStack(Blocks.cobblestone),
				new ItemStack(Blocks.vine));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stonebrick, 1, 1), new ItemStack(Blocks.stonebrick),
				new ItemStack(Blocks.vine));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.cobblestone_wall, 1, 1),
				new ItemStack(Blocks.cobblestone_wall, 1, 0), new ItemStack(Blocks.vine));

		GameRegistry.addRecipe(new ItemStack(Blocks.web), "s s", " s ", "s s", 's', new ItemStack(Items.string));
	}
}
