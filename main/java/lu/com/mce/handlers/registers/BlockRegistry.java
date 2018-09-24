package lu.com.mce.handlers.registers;

import lu.com.mce.common.mod_lu;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockRegistry {
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> e) {
		e.getRegistry().register(mod_lu.condenser);
		e.getRegistry().register(mod_lu.ghastTearBlock);
		e.getRegistry().register(mod_lu.blazeRodBlock);
		e.getRegistry().register(mod_lu.porkBlock);
		e.getRegistry().register(mod_lu.cookedPorkBlock); //ItemBlock
		e.getRegistry().register(mod_lu.beefBlock); //ItemBlock
		e.getRegistry().register(mod_lu.cookedBeefBlock); //ItemBlock
		e.getRegistry().register(mod_lu.chickenBlock); //ItemBlock
		e.getRegistry().register(mod_lu.cookedChickenBlock); //ItemBlock
		e.getRegistry().register(mod_lu.fishBlock); //ItemBlock
		e.getRegistry().register(mod_lu.cookedFishBlock); //ItemBlock
		e.getRegistry().register(mod_lu.salmonBlock); //ItemBlock
		e.getRegistry().register(mod_lu.cookedSalmonBlock); //ItemBlock
		e.getRegistry().register(mod_lu.clownfishBlock); //ItemBlock
		e.getRegistry().register(mod_lu.pufferfishBlock); //ItemBlock
		e.getRegistry().register(mod_lu.rottenFleshBlock); //ItemBlock
		e.getRegistry().register(mod_lu.appleBlock); //ItemBlock
		e.getRegistry().register(mod_lu.breadBlock); //ItemBlock
		e.getRegistry().register(mod_lu.cookieBlock); //ItemBlock
		e.getRegistry().register(mod_lu.spiderEyeBlock); //ItemBlock
		e.getRegistry().register(mod_lu.fSpiderEyeBlock);
		e.getRegistry().register(mod_lu.carrotBlock); //ItemBlock
		e.getRegistry().register(mod_lu.potatoBlock); //ItemBlock
		e.getRegistry().register(mod_lu.bakedPotatoBlock); //ItemBlock
		e.getRegistry().register(mod_lu.gunpowderBlock);
		e.getRegistry().register(mod_lu.flintBlock);
		e.getRegistry().register(mod_lu.netherStarBlock);
		e.getRegistry().register(mod_lu.paperBlock);
		e.getRegistry().register(mod_lu.slimeBlock);
		e.getRegistry().register(mod_lu.enderPerlBlock); //ItemBlock Meta
		e.getRegistry().register(mod_lu.enderEyeBlock);
		e.getRegistry().register(mod_lu.boneBlock);
		e.getRegistry().register(mod_lu.magmaCreamBlock);
		e.getRegistry().register(mod_lu.featherBlock);
		e.getRegistry().register(mod_lu.eggBlock);
		e.getRegistry().register(mod_lu.sugarBlock);

		// Compact Blocks
		e.getRegistry().register(mod_lu.compCobble);
		e.getRegistry().register(mod_lu.compDirt);
		e.getRegistry().register(mod_lu.compGravel);
		e.getRegistry().register(mod_lu.compNetherrack);

	}
}
