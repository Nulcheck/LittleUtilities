package mce.lu.common.block;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import com.google.common.base.Preconditions;

import mce.lu.common.util.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.xendric.xenlib.client.core.proxy.ClientProxy;

public class ModFluids {
	public static final Material LIQUID_PIGMENT = new MaterialLiquid(MapColor.WATER);
	public static final Set<Fluid> FLUIDS = new HashSet<>();
	public static final Set<IFluidBlock> FLUID_BLOCKS = new HashSet<>();

	public static final Fluid PIGMENT_BLACK_FLUID = createFluid("pigment_black",
			fluid -> new BlockFluidClassic(fluid, LIQUID_PIGMENT));

	public static final Fluid PIGMENT_RED_FLUID = createFluid("pigment_red",
			fluid -> new BlockFluidClassic(fluid, LIQUID_PIGMENT));

	public static final Fluid PIGMENT_GREEN_FLUID = createFluid("pigment_green",
			fluid -> new BlockFluidClassic(fluid, LIQUID_PIGMENT));

	public static final Fluid PIGMENT_BROWN_FLUID = createFluid("pigment_brown",
			fluid -> new BlockFluidClassic(fluid, LIQUID_PIGMENT));

	public static final Fluid PIGMENT_BLUE_FLUID = createFluid("pigment_blue",
			fluid -> new BlockFluidClassic(fluid, LIQUID_PIGMENT));

	public static final Fluid PIGMENT_PURPLE_FLUID = createFluid("pigment_purple",
			fluid -> new BlockFluidClassic(fluid, LIQUID_PIGMENT));

	public static final Fluid PIGMENT_CYAN_FLUID = createFluid("pigment_cyan",
			fluid -> new BlockFluidClassic(fluid, LIQUID_PIGMENT));

	public static final Fluid PIGMENT_LIGHT_GRAY_FLUID = createFluid("pigment_light_gray",
			fluid -> new BlockFluidClassic(fluid, LIQUID_PIGMENT));

	public static final Fluid PIGMENT_GRAY_FLUID = createFluid("pigment_gray",
			fluid -> new BlockFluidClassic(fluid, LIQUID_PIGMENT));

	public static final Fluid PIGMENT_PINK_FLUID = createFluid("pigment_pink",
			fluid -> new BlockFluidClassic(fluid, LIQUID_PIGMENT));

	public static final Fluid PIGMENT_LIME_FLUID = createFluid("pigment_lime",
			fluid -> new BlockFluidClassic(fluid, LIQUID_PIGMENT));

	public static final Fluid PIGMENT_YELLOW_FLUID = createFluid("pigment_yellow",
			fluid -> new BlockFluidClassic(fluid, LIQUID_PIGMENT));

	public static final Fluid PIGMENT_LIGHT_BLUE_FLUID = createFluid("pigment_light_blue",
			fluid -> new BlockFluidClassic(fluid, LIQUID_PIGMENT));

	public static final Fluid PIGMENT_MAGENTA_FLUID = createFluid("pigment_magenta",
			fluid -> new BlockFluidClassic(fluid, LIQUID_PIGMENT));

	public static final Fluid PIGMENT_ORANGE_FLUID = createFluid("pigment_orange",
			fluid -> new BlockFluidClassic(fluid, LIQUID_PIGMENT));

	public static final Fluid PIGMENT_WHITE_FLUID = createFluid("pigment_white",
			fluid -> new BlockFluidClassic(fluid, LIQUID_PIGMENT));

	// Fluid creation and registry stuff
	public static <T extends Block & IFluidBlock> Fluid createFluid(String name, Function<Fluid, T> blockFactory) {
		final ResourceLocation still = new ResourceLocation(References.MOD_ID, "blocks/fluid_" + name + "_still");
		final ResourceLocation flow = new ResourceLocation(References.MOD_ID, "blocks/fluid_" + name + "_flow");

		Fluid fluid = new Fluid(name, still, flow);
		FluidRegistry.registerFluid(fluid);
		FLUID_BLOCKS.add(blockFactory.apply(fluid));
		FLUIDS.add(fluid);

		return fluid;
	}

	@EventBusSubscriber
	public static class FluidRegistryHandler {
		@SubscribeEvent
		public static void registerFluidBlocks(RegistryEvent.Register<Block> e) {
			IForgeRegistry<Block> registry = e.getRegistry();

			for (IFluidBlock fluidBlock : FLUID_BLOCKS) {
				Block block = (Block) fluidBlock;
				block.setRegistryName(References.MOD_ID, "fluid." + fluidBlock.getFluid().getName());
				registry.register(block);
			}
		}
	}

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void registerItems(final RegistryEvent.Register<Item> e) {
		IForgeRegistry<Item> registry = e.getRegistry();

		for (IFluidBlock fluidBlock : FLUID_BLOCKS) {
			Block block = (Block) fluidBlock;
			ItemBlock itemBlock = new ItemBlock(block);
			ResourceLocation name = Preconditions.checkNotNull(block.getRegistryName());
			itemBlock.setRegistryName(name);
			registry.register(itemBlock);
		}

		for (Fluid fluid : FLUIDS) {
			FluidRegistry.addBucketForFluid(fluid);
		}
	}
}
