package mce.lu.common.item;

import java.util.List;

import javax.annotation.Nullable;

import mce.lu.client.core.handler.ModelHandler;
import mce.lu.client.render.IModelRegister;
import mce.lu.common.LittleUtilities;
import mce.lu.common.util.config.LUConfigManager;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class ItemBase extends Item implements IModelRegister {
	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(LittleUtilities.lu);

		ModItems.ITEMS.add(this);
	}

	@SideOnly(Side.CLIENT)
	public void registerItemModels() {
		ModelHandler.registerItemModel(this, 0, "inventory");
	}

	/*
	 * Items that are disabled in the config will show a tooltip saying they are
	 * disabled. Easier to understand if a modpack creator disables something,
	 * and you're not sure.
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
		if (stack.getItem() == ModItems.PURE_QUARTZ) {
			if (!OreDictionary.doesOreNameExist("itemSilicon") || !OreDictionary.doesOreNameExist("ingotSilicon"))
				list.add(TextFormatting.RED
						+ "Did not find a mod with silicon.\nCrafting this item is disabled!");
			
			else if (!LUConfigManager.modConfig.modRecipes.pureQuartzRecipe)
				list.add(TextFormatting.RED + "Disabled in config!");
		}

		else if (!LUConfigManager.modConfig.modRecipes.leatherScraps && stack.getItem() == ModItems.LEATHER_SCRAPS)
			list.add(TextFormatting.RED + "Disabled in config!");

		else if (!LUConfigManager.modConfig.modRecipes.zombieCuringKit && stack.getItem() == ModItems.ZOMBIE_CURING_KIT)
			list.add(TextFormatting.RED + "Disabled in config!");
	}
}