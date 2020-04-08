package mce.lu.api.jei;

import java.util.ArrayList;
import java.util.List;

import mce.lu.common.block.ModBlocks;
import mce.lu.common.item.ModItems;
import mce.lu.common.util.LU_Util;
import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IModRegistry;
import net.minecraft.item.ItemStack;

@SuppressWarnings("deprecation")
@mezz.jei.api.JEIPlugin
public class JEIHandler extends BlankModPlugin {
	@Override
	public void register(IModRegistry reg) {
		List<ItemStack> PIGMENT_LIST = new ArrayList<>();
		List<ItemStack> REEDS_LIST = new ArrayList<>();
		List<ItemStack> FOOD_BLOCKS_LIST = new ArrayList<>();

		for (int i = 0; i < 16; ++i) {
			PIGMENT_LIST.add(new ItemStack(LU_Util.PIGMENTS[i]));
			REEDS_LIST.add(new ItemStack(LU_Util.REEDS[i]));
		}

		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.PORK_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.COOKED_PORK_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.BEEF_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.COOKED_BEEF_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.CHICKEN_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.COOKED_CHICKEN_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.RABBIT_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.COOKED_RABBIT_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.MUTTON_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.COOKED_MUTTON_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.COD_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.COOKED_COD_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.SALMON_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.COOKED_SALMON_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.TROPICAL_FISH_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.PUFFERFISH_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.ROTTEN_FLESH_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.APPLE_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.GOLDEN_APPLE_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.NOTCH_APPLE_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.BREAD_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.COOKIE_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.SPIDER_EYE_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.CARROT_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.GOLDEN_CARROT_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.POTATO_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.BAKED_POTATO_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.POISONOUS_POTATO_BLOCK));
		FOOD_BLOCKS_LIST.add(new ItemStack(ModBlocks.BEETROOT_BLOCK));

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
		reg.addDescription(new ItemStack(ModBlocks.ENDER_EYE_BLOCK),
				ModBlocks.ENDER_EYE_BLOCK.getUnlocalizedName() + ".guide");
		reg.addDescription(new ItemStack(ModBlocks.GHAST_TEAR_BLOCK),
				ModBlocks.GHAST_TEAR_BLOCK.getUnlocalizedName() + ".guide");
		reg.addDescription(new ItemStack(ModBlocks.NETHER_STAR_BLOCK),
				ModBlocks.NETHER_STAR_BLOCK.getUnlocalizedName() + ".guide");
		reg.addDescription(REEDS_LIST, "reeds.guide");
		reg.addDescription(FOOD_BLOCKS_LIST, "foodblocks.guide");

		// Items
		reg.addDescription(new ItemStack(ModItems.SPONGE), ModItems.SPONGE.getUnlocalizedName() + ".guide");
		reg.addDescription(new ItemStack(ModItems.ZOMBIE_CURING_KIT),
				ModItems.ZOMBIE_CURING_KIT.getUnlocalizedName() + ".guide");
		reg.addDescription(new ItemStack(ModItems.FERTILIZER), ModItems.FERTILIZER.getUnlocalizedName() + ".guide");
		reg.addDescription(new ItemStack(ModItems.LAVA_BOTTLE), ModItems.LAVA_BOTTLE.getUnlocalizedName() + ".guide");
		reg.addDescription(PIGMENT_LIST, "pigments.guide");
	}
}