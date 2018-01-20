package lu.com.mce.handlers.registers;

import cpw.mods.fml.common.registry.GameRegistry;
import lu.com.mce.common.mod_lu;
import lu.com.mce.items.blocks.ItemBlockMeta;

public class BlockRegistry {
	public static void registerBlocks() {
		GameRegistry.registerBlock(mod_lu.condenser, "condenser");
		GameRegistry.registerBlock(mod_lu.ghastTearBlock, "ghastTearBlock");
		GameRegistry.registerBlock(mod_lu.blazeRodBlock, "blazeRodBlock");
		GameRegistry.registerBlock(mod_lu.porkBlock, ItemBlockMeta.class, "pork");
		GameRegistry.registerBlock(mod_lu.cookedPorkBlock, ItemBlockMeta.class, "cookedPork");
		GameRegistry.registerBlock(mod_lu.beefBlock, ItemBlockMeta.class, "beef");
		GameRegistry.registerBlock(mod_lu.cookedBeefBlock, ItemBlockMeta.class, "cookedBeef");
		GameRegistry.registerBlock(mod_lu.chickenBlock, ItemBlockMeta.class, "chicken");
		GameRegistry.registerBlock(mod_lu.cookedChickenBlock, ItemBlockMeta.class, "cookedChicken");
		GameRegistry.registerBlock(mod_lu.fishBlock, ItemBlockMeta.class, "fish");
		GameRegistry.registerBlock(mod_lu.cookedFishBlock, ItemBlockMeta.class, "cookedFish");
		GameRegistry.registerBlock(mod_lu.salmonBlock, ItemBlockMeta.class, "salmon");
		GameRegistry.registerBlock(mod_lu.cookedSalmonBlock, ItemBlockMeta.class, "cookedSalmon");
		GameRegistry.registerBlock(mod_lu.clownfishBlock, ItemBlockMeta.class, "clownfish");
		GameRegistry.registerBlock(mod_lu.pufferfishBlock, ItemBlockMeta.class, "puff");
		GameRegistry.registerBlock(mod_lu.rottenFleshBlock, ItemBlockMeta.class, "rottenFleshBlock");
		GameRegistry.registerBlock(mod_lu.appleBlock, ItemBlockMeta.class, "appleBlock");
		GameRegistry.registerBlock(mod_lu.breadBlock, ItemBlockMeta.class, "breadBlock");
		GameRegistry.registerBlock(mod_lu.cookieBlock, ItemBlockMeta.class, "cookieBlock");
		GameRegistry.registerBlock(mod_lu.spiderEyeBlock, ItemBlockMeta.class, "spiderEyeBlock");
		GameRegistry.registerBlock(mod_lu.fSpiderEyeBlock, "fSpiderEyeBlock");
		GameRegistry.registerBlock(mod_lu.carrotBlock, ItemBlockMeta.class, "carrotBlock");
		GameRegistry.registerBlock(mod_lu.potatoBlock, ItemBlockMeta.class, "potatoBlock");
		GameRegistry.registerBlock(mod_lu.gunpowderBlock, "gunpowderBlock");
	}
}
