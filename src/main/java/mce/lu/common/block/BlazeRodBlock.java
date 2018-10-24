package mce.lu.common.block;

import java.util.Random;

import mce.lu.client.core.handler.ParticleManager;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlazeRodBlock extends BlockBase {
	public BlazeRodBlock(String name, Material mat) {
		super(name, mat);
	}

	@Override
	public void onEntityWalk(World world, BlockPos pos, Entity e) {
		e.setFire(8);
		super.onEntityWalk(world, pos, e);
	}

	@Override
	public boolean isFireSource(World world, BlockPos pos, EnumFacing side) {
		if (side == EnumFacing.UP)
			return true;
		else
			return false;
	}

	@Override
	public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
		double d0 = 0.0625d;

		for (int l = 0; l < 6; ++l) {
			double d1 = (double) ((float) pos.getX() + rand.nextFloat());
			double d2 = (double) ((float) pos.getY() + rand.nextFloat());
			double d3 = (double) ((float) pos.getZ() + rand.nextFloat());

			if (l == 0 && !world.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).isOpaqueCube()) {
				d2 = (double) (pos.getY() + 1) + d0;
			}

			if (l == 1 && !world.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())).isOpaqueCube()) {
				d2 = (double) (pos.getY() + 0) - d0;
			}

			if (l == 2 && !world.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1)).isOpaqueCube()) {
				d3 = (double) (pos.getZ() + 1) + d0;
			}

			if (l == 3 && !world.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1)).isOpaqueCube()) {
				d3 = (double) (pos.getZ() + 0) - d0;
			}

			if (l == 4 && !world.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())).isOpaqueCube()) {
				d1 = (double) (pos.getX() + 1) + d0;
			}

			if (l == 5 && !world.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())).isOpaqueCube()) {
				d1 = (double) (pos.getX() + 0) - d0;
			}

			if (d1 < (double) pos.getX() || d1 > (double) (pos.getX() + 1) || d2 < 0.0D
					|| d2 > (double) (pos.getY() + 1) || d3 < (double) pos.getZ() || d3 > (double) (pos.getZ() + 1)) {
				ParticleManager.spawnParticle(world, pos.getX(), pos.getY(), pos.getZ(), "blazeRodFX");
			}
		}
	}
}
