package mce.lu.common.util;

import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;
import net.minecraft.util.text.TextComponentTranslation;

public class ModStatsList extends StatList {
	public static final StatBase CONDENSER_INTERACTION = (new StatBase("stat.condenserInteraction",
			new TextComponentTranslation("stat.condenserInteraction", new Object[0]))).registerStat();

	public static final StatBase DEHYDRATOR_INTERACTION = (new StatBase("stat.dehydratorInteraction",
			new TextComponentTranslation("stat.dehydratorInteraction", new Object[0]))).registerStat();

	public static final StatBase PIGMENT_MIXER_INTERACTION = (new StatBase("state.pigmentMixerInteraction",
			new TextComponentTranslation("stat.pigmentMixerInteraction", new Object[0]))).registerStat();
}