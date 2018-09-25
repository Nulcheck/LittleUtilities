package lu.com.mce.util;

import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.IStringSerializable;

public enum EnumAmount implements IStringSerializable {
	NINE(0), EIGHT(1), SEVEN(2), SIX(3), FIVE(4), FOUR(5), THREE(6), TWO(7), ONE(8);

	private static final EnumAmount[] LOOKUP = new EnumAmount[values().length];
	private final int meta;

	EnumAmount(int meta) {
		this.meta = meta;
	}

	public int getMetadata() {
		return this.meta;
	}

	public String getName() {
		return null;
	}

	public static EnumAmount byMetadata(int meta) {
		if (meta < 0 || meta >= LOOKUP.length) {
			meta = 0;
		}
		return LOOKUP[meta];
	}

	static {
		for (EnumAmount amount : values()) {
			LOOKUP[amount.getMetadata()] = amount;
		}
	}
}
