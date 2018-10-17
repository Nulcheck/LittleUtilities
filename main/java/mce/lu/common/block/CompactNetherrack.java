package mce.lu.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class CompactNetherrack extends BlockBase {
	public CompactNetherrack(String name, Material mat) {
		super(name, mat);
	}

	public boolean isFireSource(World world, int x, int y, int z, EnumFacing side) {
		if (side == EnumFacing.UP)
			return true;
		else
			return false;
	}
}
