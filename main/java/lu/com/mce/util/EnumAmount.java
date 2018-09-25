package lu.com.mce.util;

import net.minecraft.util.IStringSerializable;

public enum EnumAmount implements IStringSerializable {
	NINE(0,"0"), EIGHT(1,"1"), SEVEN(2,"2"), SIX(3,"3"), FIVE(4,"4"), FOUR(5,"5"), THREE(6,"6"), TWO(7,"7"), ONE(8,"8");

	private static final EnumAmount[] LOOKUP = new EnumAmount[values().length];
	private final int meta;
	private final String name;

	EnumAmount(int meta, String name) {
		this.meta = meta;
		this.name = name;
	}

	public int getMetadata() {
		return this.meta;
	}

	public String getName() {
		return this.name;
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
