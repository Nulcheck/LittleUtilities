package mce.lu.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLiquidPigment extends BlockFluidClassic {
	float red, green, blue = 1f;

	public BlockLiquidPigment(Fluid fluid, Material mat) {
		super(fluid, mat);
	}

	/*
	 * public BlockLiquidPigment setColor(EnumDyeColor c) { return
	 * setColor(((Integer.valueOf(c.getColorValue()) >> 16) & 255) / 255f,
	 * ((Integer.valueOf(c.getColorValue()) >> 8) & 255) / 255f,
	 * (Integer.valueOf(c.getColorValue()) & 255) / 255f); }
	 */

	public BlockLiquidPigment setColor(int c) {
		return setColor(((c >> 16) & 255) / 255f, ((c >> 8) & 255) / 255f, (c & 255) / 255f);
	}

	public BlockLiquidPigment setColor(float redIn, float greenIn, float blueIn) {
		this.red = redIn;
		this.green = greenIn;
		this.blue = blueIn;

		return this;
	}

	@Override
	public Boolean isEntityInsideMaterial(IBlockAccess world, BlockPos pos, IBlockState state, Entity entity,
			double yToTest, Material mat, boolean testingHead) {
		if (this.density < 0)
			return false;

		if (testingHead)
			return true;
		return super.isEntityInsideMaterial(world, pos, state, entity, yToTest, mat, testingHead);
	}

	@Override
	public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, SpawnPlacementType type) {
		return false;
	}

	@Override
	public boolean canDisplace(IBlockAccess world, BlockPos pos) {
		return super.canDisplace(world, pos);
	}

	public float getRed() {
		return red;
	}

	public float getGreen() {
		return green;
	}

	public float getBlue() {
		return blue;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Vec3d getFogColor(World world, BlockPos pos, IBlockState state, Entity entity, Vec3d originalColor,
			float particleTicks) {
		return new Vec3d(getRed(), getGreen(), getBlue());
	}
}
