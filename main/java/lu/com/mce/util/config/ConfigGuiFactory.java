package lu.com.mce.util.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import lu.com.mce.util.References;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.DummyConfigElement.DummyCategoryElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.GuiConfigEntries;
import net.minecraftforge.fml.client.config.GuiConfigEntries.CategoryEntry;
import net.minecraftforge.fml.client.config.IConfigElement;

public class ConfigGuiFactory implements IModGuiFactory {
	public void initialize(Minecraft minecraftInstance) {
	}

	public Class<? extends GuiScreen> mainConfigGuiClass() {
		return ConfigGui.class;
	}

	public boolean hasConfigGui() {
		return true;
	}

	public GuiScreen createConfigGui(GuiScreen parentScreen) {
		return new ConfigGui(parentScreen);
	}

	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
		return null;
	}

	public static class ConfigGui extends GuiConfig {
		public ConfigGui(GuiScreen parentScreen) {
			super(parentScreen, getConfigElements(), References.MOD_ID, false, false, I18n.format("gui.config.title"));
		}
	}

	private static List<IConfigElement> getConfigElements() {
		List<IConfigElement> list = new ArrayList<IConfigElement>();
		list.add(new DummyCategoryElement(I18n.format("gui.config.category.vanilla_recipes"),
				"gui.config.category.vanilla_recipes", CategoryEntryRecipes.class));
		return list;
	}

	public static class CategoryEntryRecipes extends CategoryEntry {

		public CategoryEntryRecipes(GuiConfig owningScreen, GuiConfigEntries owningEntryList,
				IConfigElement configElement) {
			super(owningScreen, owningEntryList, configElement);
		}

		protected GuiScreen buildChildScreen() {
			Configuration config = ConfigHandler.getConfig();
			ConfigElement categoryRecipes = new ConfigElement(
					config.getCategory(ConfigHandler.CATEGORY_VANILLA_RECIPES));
			List<IConfigElement> propertiesOnScreen = categoryRecipes.getChildElements();
			String windowTitle = I18n.format("gui.config.category.vanilla_recipes");

			return new GuiConfig(owningScreen, propertiesOnScreen, owningScreen.modID,
					this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
					this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart, windowTitle);
		}
	}
}
