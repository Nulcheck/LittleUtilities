package lu.com.mce.handlers.registers;

import cpw.mods.fml.common.registry.GameRegistry;
import lu.com.mce.common.mod_lu;
import lu.com.mce.items.blocks.ItemBlockEdible;
import lu.com.mce.items.blocks.ItemBlockMeta;

public class BlockRegistry {
	public static void registerBlocks() {
		GameRegistry.registerBlock(mod_lu.condenser, "condenser");
		GameRegistry.registerBlock(mod_lu.ghastTearBlock, "ghastTearBlock");
		GameRegistry.registerBlock(mod_lu.blazeRodBlock, "blazeRodBlock");
		GameRegistry.registerBlock(mod_lu.porkBlock, ItemBlockEdible.class, mod_lu.porkBlock.getUnlocalizedName());
		GameRegistry.registerBlock(mod_lu.cookedPorkBlock, ItemBlockEdible.class, mod_lu.cookedPorkBlock.getUnlocalizedName());
		GameRegistry.registerBlock(mod_lu.beefBlock, ItemBlockEdible.class, mod_lu.beefBlock.getUnlocalizedName());
		GameRegistry.registerBlock(mod_lu.cookedBeefBlock, ItemBlockEdible.class, mod_lu.cookedBeefBlock.getUnlocalizedName());
		GameRegistry.registerBlock(mod_lu.chickenBlock, ItemBlockEdible.class, mod_lu.chickenBlock.getUnlocalizedName());
		GameRegistry.registerBlock(mod_lu.cookedChickenBlock, ItemBlockEdible.class, mod_lu.cookedChickenBlock.getUnlocalizedName());
		GameRegistry.registerBlock(mod_lu.fishBlock, ItemBlockEdible.class, mod_lu.fishBlock.getUnlocalizedName());
		GameRegistry.registerBlock(mod_lu.cookedFishBlock, ItemBlockEdible.class, mod_lu.cookedFishBlock.getUnlocalizedName());
		GameRegistry.registerBlock(mod_lu.salmonBlock, ItemBlockEdible.class, mod_lu.salmonBlock.getUnlocalizedName());
		GameRegistry.registerBlock(mod_lu.cookedSalmonBlock, ItemBlockEdible.class, mod_lu.cookedSalmonBlock.getUnlocalizedName());
		GameRegistry.registerBlock(mod_lu.clownfishBlock, ItemBlockEdible.class, mod_lu.clownfishBlock.getUnlocalizedName());
		GameRegistry.registerBlock(mod_lu.pufferfishBlock, ItemBlockEdible.class, mod_lu.pufferfishBlock.getUnlocalizedName());
		GameRegistry.registerBlock(mod_lu.rottenFleshBlock, ItemBlockEdible.class, mod_lu.rottenFleshBlock.getUnlocalizedName());
		GameRegistry.registerBlock(mod_lu.appleBlock, ItemBlockEdible.class, mod_lu.appleBlock.getUnlocalizedName());
		GameRegistry.registerBlock(mod_lu.breadBlock, ItemBlockEdible.class, mod_lu.breadBlock.getUnlocalizedName());
		GameRegistry.registerBlock(mod_lu.cookieBlock, ItemBlockEdible.class, mod_lu.cookieBlock.getUnlocalizedName());
		GameRegistry.registerBlock(mod_lu.spiderEyeBlock, ItemBlockEdible.class, mod_lu.spiderEyeBlock.getUnlocalizedName());
		GameRegistry.registerBlock(mod_lu.fSpiderEyeBlock, "fSpiderEyeBlock");
		GameRegistry.registerBlock(mod_lu.carrotBlock, ItemBlockEdible.class, mod_lu.carrotBlock.getUnlocalizedName());
		GameRegistry.registerBlock(mod_lu.potatoBlock, ItemBlockEdible.class, mod_lu.potatoBlock.getUnlocalizedName());
		GameRegistry.registerBlock(mod_lu.bakedPotatoBlock, ItemBlockEdible.class, mod_lu.bakedPotatoBlock.getUnlocalizedName());
		GameRegistry.registerBlock(mod_lu.gunpowderBlock, "gunpowderBlock");
		GameRegistry.registerBlock(mod_lu.flintBlock, "flintBlock");
		GameRegistry.registerBlock(mod_lu.netherStarBlock, "netherStarBlock");
		GameRegistry.registerBlock(mod_lu.paperBlock, "paperBlock");
		GameRegistry.registerBlock(mod_lu.slimeBlock, "slimeBlock");
		GameRegistry.registerBlock(mod_lu.enderPerlBlock, ItemBlockMeta.class, mod_lu.enderPerlBlock.getUnlocalizedName());
		GameRegistry.registerBlock(mod_lu.enderEyeBlock, "enderEyeBlock");
		GameRegistry.registerBlock(mod_lu.boneBlock, "boneBlock");
		GameRegistry.registerBlock(mod_lu.magmaCreamBlock, "magmaCreamBlock");
		GameRegistry.registerBlock(mod_lu.featherBlock, "featherBlock");
		GameRegistry.registerBlock(mod_lu.eggBlock, "eggBlock");
		GameRegistry.registerBlock(mod_lu.sugarBlock, "sugarBlock");

		// Compact Blocks
		GameRegistry.registerBlock(mod_lu.compCobble, "compCobble");
		GameRegistry.registerBlock(mod_lu.compDirt, "compDirt");
		GameRegistry.registerBlock(mod_lu.compGravel, "compGravel");
		GameRegistry.registerBlock(mod_lu.compNetherrack, "compNetherrack");

	}
}
