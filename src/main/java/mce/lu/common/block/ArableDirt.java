package mce.lu.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.BlockReed;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class ArableDirt extends BlockBase {
	public ArableDirt(String name, Material mat) {
		super(name, mat);
		this.setTickRandomly(true);
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(world, pos, state, rand);
		Block block = world.getBlockState(pos.up()).getBlock();

		if (block instanceof BlockReed || block instanceof BlockCactus || block instanceof DyeReeds) {
			boolean sameBlock = true;
			int height = 1;

			while (sameBlock) {
				if (world.getBlockState(pos.up(height)).getBlock() != null) {
					Block blockAbove = world.getBlockState(pos.up(height)).getBlock();

					if (blockAbove.getClass() == block.getClass()) {
						for (int i = 0; i < 10; i++)
							blockAbove.updateTick(world, pos.up(height), world.getBlockState(pos.up(height)), rand);
						height++;
					} else
						sameBlock = false;
				} else
					sameBlock = false;
			}
		} else if (block instanceof IPlantable || block instanceof IGrowable) {
			block.updateTick(world, pos.up(), world.getBlockState(pos.up()), rand);
		}
	}

	public boolean hasWater(World world, BlockPos pos) {
		return true;
	}

	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction,
			IPlantable p) {
		EnumPlantType plantType = p.getPlantType(world, pos.offset(EnumFacing.UP));

		if (p instanceof IPlantable || p instanceof IGrowable)
			return true;

		switch (plantType) {
		case Beach:
			return true;
		case Cave:
			return true;
		case Desert:
			return true;
		case Nether:
			return true;
		case Plains:
			return true;
		default:
			break;
		}

		return false;
	}
}
