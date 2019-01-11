package mce.lu.common.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class EggBlock extends BlockBase {
	public EggBlock(String name, Material mat) {
		super(name, mat);
		this.setSoundType(SoundType.WOOD);
	}
}
