package mce.lu.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CompactNetherrack extends BlockBase {
	public CompactNetherrack(String name, Material mat) {
		super(name, mat);
	}

	@Override
	public boolean isFireSource(World world, BlockPos pos, EnumFacing side) {
		if (side == EnumFacing.UP)
			return true;
		else
			return false;
	}
}
