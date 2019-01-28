package mce.lu.common.core.recipes;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;

import javax.annotation.Nullable;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespaced;
import net.minecraft.world.World;
import net.minecraftforge.registries.GameData;

public class PigmentMixerRecipeManager {
	private static final Logger LOGGER = LogManager.getLogger();
	private static int nextId;
	public static final RegistryNamespaced<ResourceLocation, IRecipe> REGISTRY = GameData.getWrapper(IRecipe.class);

	public static boolean init() {
		try {

			return parseJsonRecipes();
		} catch (Throwable err) {
			return false;
		}
	}

	private static boolean parseJsonRecipes() {
		FileSystem fs = null;
		Gson gson = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().create();
		boolean flag1;

		try {
			URL url = PigmentMixerRecipeManager.class.getResource("/assets/littleutilities");

			if (url != null) {
				URI uri = url.toURI();
				Path path;

				if ("file".equals(uri.getScheme()))
					path = Paths.get(PigmentMixerRecipeManager.class
							.getResource("/assets/littleutilities/recipes/pigmentmixer").toURI());
				else {
					if (!"jar".equals(uri.getScheme())) {
						LOGGER.error("LUERR: Unsupported scheme " + uri + " trying to list all recipes");
						boolean flag2 = false;
						return flag2;
					}

					fs = FileSystems.newFileSystem(uri, Collections.emptyMap());
					path = fs.getPath("/assets/littleutilities/recipes/pigmentmixer");
				}

				Iterator<Path> iter = Files.walk(path).iterator();

				while (iter.hasNext()) {
					Path path1 = iter.next();

					if ("json".equals(FilenameUtils.getExtension(path1.toString()))) {
						Path path2 = path.relativize(path1);
						String s = FilenameUtils.removeExtension(path2.toString()).replaceAll("\\\\", "/");
						ResourceLocation rl = new ResourceLocation(s);
						BufferedReader reader = null;

						try {
							boolean flag;

							try {
								reader = Files.newBufferedReader(path1);
								register(s, parseRecipeJson(
										(JsonObject) JsonUtils.fromJson(gson, reader, JsonObject.class)));
							} catch (JsonParseException exp) {
								LOGGER.error("LUERR: Parsing error loading recipe " + rl, (Throwable) exp);
								flag = false;
								return flag;
							} catch (IOException ioExp) {
								LOGGER.error("LUERR: Couldn't read recipe " + rl + " from " + path1, (Throwable) ioExp);
								flag = false;
								return flag;
							}
						} finally {
							IOUtils.closeQuietly((Reader) reader);
						}
					}
				}

				return true;
			}

			LOGGER.error("LUERR: Coudn't find root assets");
			;
			flag1 = false;
		} catch (IOException | URISyntaxException exp) {
			LOGGER.error("LUERR: Coudn't get a list of all recipe files", (Throwable) exp);
			flag1 = false;
			return flag1;
		} finally {
			IOUtils.closeQuietly((Closeable) fs);
		}

		return flag1;
	}

	private static IRecipe parseRecipeJson(JsonObject json) {
		String s = JsonUtils.getString(json, "type");

		if ("crafting_shapeless".equals(s))
			return PigmentMixerShapelessRecipes.deserialize(json);
		else
			throw new JsonSyntaxException("LUERR: Invalid or unsupported recipe type '" + s + "'");
	}

	private static void register(String name, IRecipe recipe) {
		register(new ResourceLocation(name), recipe);
	}

	private static void register(ResourceLocation name, IRecipe recipe) {
		if (REGISTRY.containsKey(name))
			throw new IllegalStateException("LUERR: Duplicate recipe ignored with ID " + name);
		else
			REGISTRY.register(nextId++, name, recipe);
	}

	public static ItemStack findMatchingResult(InventoryCrafting craftMatrix, World world) {
		for (IRecipe recipe : REGISTRY) {
			if (recipe.matches(craftMatrix, world))
				return recipe.getCraftingResult(craftMatrix);
		}

		return ItemStack.EMPTY;
	}

	@Nullable
	public static IRecipe findMatchingRecipe(InventoryCrafting craftMatrix, World world) {
		for (IRecipe recipe : REGISTRY) {
			if (recipe.matches(craftMatrix, world))
				return recipe;
		}

		return null;
	}

	public static NonNullList<ItemStack> getRemainingItems(InventoryCrafting craftMatrix, World world) {
		for (IRecipe recipe : REGISTRY) {
			if (recipe.matches(craftMatrix, world))
				return recipe.getRemainingItems(craftMatrix);
		}

		NonNullList<ItemStack> list = NonNullList.<ItemStack>withSize(craftMatrix.getSizeInventory(), ItemStack.EMPTY);
		for (int i = 0; i < list.size(); ++i)
			list.set(i, craftMatrix.getStackInSlot(i));

		return list;
	}

	@Nullable
	public static IRecipe getRecipe(ResourceLocation name) {
		return REGISTRY.getObject(name);
	}
}
