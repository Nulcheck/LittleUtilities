package mce.lu.client.core.handler;

import mce.lu.common.block.ModFluids;
import mce.lu.common.util.References;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(value = Side.CLIENT)
public class FluidRenderHandler {
	public static final FluidRenderHandler instance = new FluidRenderHandler();
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent e) {
		instance.registerFluidModels();
	}

	private void registerFluidModels() {
		ModFluids.FLUID_BLOCKS.forEach(this::registerFluidModel);
	}
	
	/**
	 * For fluid block and item models.
	 * 
	 * @param fluidBlock The fluid's block (IFluidBlock)
	 */
	public void registerFluidModel(IFluidBlock fluidBlock) {
		Item item = Item.getItemFromBlock((Block) fluidBlock);
		assert item != Items.AIR;
		ModelBakery.registerItemVariants(item);
		ModelResourceLocation resource = new ModelResourceLocation(References.MOD_ID + ":fluid",
				fluidBlock.getFluid().getName());

		ModelLoader.setCustomMeshDefinition(item, stack -> resource);
		ModelLoader.setCustomStateMapper((Block) fluidBlock, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return resource;
			}
		});
	}
}
