package mce.lu.client.core.proxy;

import com.google.common.collect.ImmutableList;

import mce.lu.common.core.proxy.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.DefaultStateMapper;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;

/**
 * Here to properly render/model edible blocks so the mod works for server.
 * (Putting this in the ModelHandler class crashes the game)
 */
public class ClientProxy extends ServerProxy {
	public static void registerItemBlockModel(Block block, ItemBlock item, String name) {
		StateMapperBase mapper = new DefaultStateMapper();
		BlockStateContainer stateContainer = block.getBlockState();
		ImmutableList<IBlockState> values = stateContainer.getValidStates();

		for (IBlockState state : values) {
			String stringProperties = mapper.getPropertyString(state.getProperties());
			registerItemModel(Item.getItemFromBlock(block), block.getMetaFromState(state), stringProperties);
		}
	}

	public static void registerItemModel(Item item, int meta, String name) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), name));
	}
}
