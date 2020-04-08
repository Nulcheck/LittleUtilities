package mce.lu.api.jei;

import java.util.ArrayList;
import java.util.List;

import mce.lu.common.block.ModBlocks;
import mce.lu.common.item.ModItems;
import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IModRegistry;
import net.minecraft.item.ItemStack;

@SuppressWarnings("deprecation")
@mezz.jei.api.JEIPlugin
public class JEIHandler extends BlankModPlugin {
	@Override
	public void register(IModRegistry reg) {
		List<ItemStack> pigments = new ArrayList<>();
		for (int i = 0; i < 16; ++i)
			pigments.add(new ItemStack(ModItems.PIGMENTS[i]));

		// Blocks
		reg.addDescription(new ItemStack(ModBlocks.CONDENSER), ModBlocks.CONDENSER.getUnlocalizedName() + ".guide");
		reg.addDescription(new ItemStack(ModBlocks.SNOW_MELTER), ModBlocks.SNOW_MELTER.getUnlocalizedName() + ".guide");
		reg.addDescription(new ItemStack(ModBlocks.AQUA_RESERVOIR),
				ModBlocks.AQUA_RESERVOIR.getUnlocalizedName() + ".guide");
		reg.addDescription(new ItemStack(ModBlocks.MAGMA_RESERVOIR),
				ModBlocks.MAGMA_RESERVOIR.getUnlocalizedName() + ".guide");
		reg.addDescription(new ItemStack(ModBlocks.FERTILE_DIRT),
				ModBlocks.FERTILE_DIRT.getUnlocalizedName() + ".guide");
		reg.addDescription(new ItemStack(ModBlocks.FERTILE_FARMLAND),
				ModBlocks.FERTILE_FARMLAND.getUnlocalizedName() + ".guide");
		reg.addDescription(new ItemStack(ModBlocks.ARABLE_DIRT), ModBlocks.ARABLE_DIRT.getUnlocalizedName() + ".guide");
		reg.addDescription(new ItemStack(ModBlocks.ARABLE_FARMLAND),
				ModBlocks.ARABLE_FARMLAND.getUnlocalizedName() + ".guide");
		reg.addDescription(new ItemStack(ModBlocks.UNSTOMPABLE_FARMLAND),
				ModBlocks.UNSTOMPABLE_FARMLAND.getUnlocalizedName() + ".guide");
		reg.addDescription(new ItemStack(ModBlocks.SPIKES), ModBlocks.SPIKES.getUnlocalizedName() + ".guide");
		reg.addDescription(new ItemStack(ModBlocks.POISON_SPIKES),
				ModBlocks.POISON_SPIKES.getUnlocalizedName() + ".guide");
		reg.addDescription(new ItemStack(ModBlocks.FIRE_SPIKES), ModBlocks.FIRE_SPIKES.getUnlocalizedName() + ".guide");
		reg.addDescription(new ItemStack(ModBlocks.BLAZE_BARS), ModBlocks.BLAZE_BARS.getUnlocalizedName() + ".guide");
		reg.addDescription(new ItemStack(ModBlocks.BLAZE_ROD_BLOCK),
				ModBlocks.BLAZE_ROD_BLOCK.getUnlocalizedName() + ".guide");
		reg.addDescription(new ItemStack(ModBlocks.BLAZE_POWDER_BLOCK),
				ModBlocks.BLAZE_POWDER_BLOCK.getUnlocalizedName() + ".guide");
		reg.addDescription(new ItemStack(ModBlocks.GUNPOWDER_BLOCK),
				ModBlocks.GUNPOWDER_BLOCK.getUnlocalizedName() + ".guide");
		reg.addDescription(new ItemStack(ModBlocks.PAPER_BLOCK), ModBlocks.PAPER_BLOCK.getUnlocalizedName() + ".guide");
		reg.addDescription(new ItemStack(ModBlocks.FEATHER_BLOCK),
				ModBlocks.FEATHER_BLOCK.getUnlocalizedName() + ".guide");
		reg.addDescription(new ItemStack(ModBlocks.ENDER_PEARL_BLOCK),
				ModBlocks.ENDER_PEARL_BLOCK.getUnlocalizedName() + ".guide");
		reg.addDescription(new ItemStack(ModBlocks.COMPACT_DRAGON_EGG),
				ModBlocks.COMPACT_DRAGON_EGG.getUnlocalizedName() + ".guide");

		// Items
		reg.addDescription(new ItemStack(ModItems.SPONGE), ModItems.SPONGE.getUnlocalizedName() + ".guide");
		reg.addDescription(new ItemStack(ModItems.ZOMBIE_CURING_KIT),
				ModItems.ZOMBIE_CURING_KIT.getUnlocalizedName() + ".guide");
		reg.addDescription(new ItemStack(ModItems.FERTILIZER), ModItems.FERTILIZER.getUnlocalizedName() + ".guide");
		reg.addDescription(new ItemStack(ModItems.LAVA_BOTTLE), ModItems.LAVA_BOTTLE.getUnlocalizedName() + ".guide");
		reg.addDescription(pigments, "pigments.guide");
	}
}