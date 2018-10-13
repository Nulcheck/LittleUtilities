package lu.com.mce.util.config;

import lu.com.mce.util.References;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.RequiresMcRestart;
import net.minecraftforge.common.config.Config.Type;

@Config(modid = References.MOD_ID, type = Type.INSTANCE, name = References.NAME, category = "vanilla recipes")
public class ConfigHandler {
	@Name("name_tag")
	@Comment("Should you be able to craft Name Tags?")
	@RequiresMcRestart
	public static boolean nameTagRecipe = true;

	@Name("saddle")
	@Comment("Should you be able to craft Saddles?")
	@RequiresMcRestart
	public static boolean saddleRecipe = true;

	@Name("horse_armors")
	@Comment("Should you be able to craft Horse Armors?")
	@RequiresMcRestart
	public static boolean horseArmorsRecipe = true;
}
