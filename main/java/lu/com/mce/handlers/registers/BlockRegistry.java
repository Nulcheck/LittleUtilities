package lu.com.mce.handlers.registers;

import cpw.mods.fml.common.registry.GameRegistry;
import lu.com.mce.common.mod_lu;
import lu.com.mce.items.blocks.ItemFishBlock;
import lu.com.mce.items.blocks.ItemMeatBlock;

public class BlockRegistry {
	public static void registerBlocks() {
		GameRegistry.registerBlock(mod_lu.condenser, "condenser");
		GameRegistry.registerBlock(mod_lu.ghastTearBlock, "ghastTearBlock");
		GameRegistry.registerBlock(mod_lu.blazeRodBlock, "blazeRodBlock");
		GameRegistry.registerBlock(mod_lu.porkBlock, ItemMeatBlock.class, mod_lu.porkBlock.getUnlocalizedName());
		GameRegistry.registerBlock(mod_lu.beefBlock, ItemMeatBlock.class, mod_lu.beefBlock.getUnlocalizedName());
		GameRegistry.registerBlock(mod_lu.chickenBlock, ItemMeatBlock.class, mod_lu.chickenBlock.getUnlocalizedName());
		GameRegistry.registerBlock(mod_lu.fishBlock, ItemFishBlock.class, mod_lu.fishBlock.getUnlocalizedName());
		GameRegistry.registerBlock(mod_lu.rottenFleshBlock, "rottenFleshBlock");
		GameRegistry.registerBlock(mod_lu.appleBlock, "appleBlock");
		GameRegistry.registerBlock(mod_lu.breadBlock, "breadBlock");
		GameRegistry.registerBlock(mod_lu.cookieBlock, "cookieBlock");
	}
}
