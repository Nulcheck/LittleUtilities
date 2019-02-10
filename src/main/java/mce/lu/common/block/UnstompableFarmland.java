package mce.lu.common.block;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.FarmlandWaterManager;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IPlantable;

public class UnstompableFarmland extends BlockFarmlandBase {
	public UnstompableFarmland(String name) {
		super(name);
		this.setSoundType(SoundType.GROUND);
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		int i = ((Integer) state.getValue(MOISTURE)).intValue();

		if (!this.hasWater(world, pos) && !world.isRainingAt(pos.up())) {
			if (i > 0)
				world.setBlockState(pos, state.withProperty(MOISTURE, Integer.valueOf(i - 1)), 2);
		} else if (i < 7)
			world.setBlockState(pos, state.withProperty(MOISTURE, Integer.valueOf(7)), 2);
	}

	@Override
	public void onFallenUpon(World world, BlockPos pos, Entity entity, float fallDistance) {
		if (ForgeHooks.onFarmlandTrample(world, pos, ModBlocks.UNSTOMPABLE_FARMLAND.getDefaultState(), fallDistance,
				entity))
			return;
	}

	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction,
			IPlantable p) {
		EnumPlantType plantType = p.getPlantType(world, pos.offset(EnumFacing.DOWN));

		switch (plantType) {
		case Crop:
			return world.getBlockState(pos).getBlock() == this;
		case Plains:
			return world.getBlockState(pos).getBlock() == this;
		default:
			break;
		}

		return false;
	}

	private boolean hasWater(World world, BlockPos pos) {
		for (BlockPos.MutableBlockPos mutablePos : BlockPos.getAllInBoxMutable(pos.add(-4, 0, -4), pos.add(4, 1, 4))) {
			if (world.getBlockState(mutablePos).getMaterial() == Material.WATER)
				return true;
		}

		return FarmlandWaterManager.hasBlockWaterTicket(world, pos);
	}
}
