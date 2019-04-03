package mce.lu.common.entity.tile;

import javax.annotation.Nullable;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;

public class TileEntityAquaReservoir extends TileEntity {
	static int INT_MAX = Integer.MAX_VALUE;
	public FluidTank fluidTank = new Tank(16000);

	@Override
	public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
		return capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
	}

	@Override
	public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
		if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY)
			return (T) fluidTank;
		return super.getCapability(capability, facing);
	}

	public int getFluidAmount() {
		return fluidTank.getFluidAmount();
	}

	public int getFluidCapacity() {
		return fluidTank.getCapacity();
	}

	private static class Tank extends FluidTank {
		private static final FluidStack MAX_WATER = new FluidStack(FluidRegistry.WATER, INT_MAX);

		public Tank(int capacity) {
			super(capacity);
		}

		@Override
		public FluidStack getFluid() {
			return MAX_WATER;
		}

		@Override
		public int getFluidAmount() {
			return INT_MAX;
		}

		@Override
		public int getCapacity() {
			return INT_MAX;
		}

		@Override
		public int fill(FluidStack resource, boolean doFill) {
			if (resource.getFluid() == FluidRegistry.WATER)
				return resource.amount;
			return super.fill(resource, doFill);
		}

		@Override
		public FluidStack drain(FluidStack resource, boolean doDrain) {
			if (resource.getFluid() == FluidRegistry.WATER)
				return resource.copy();
			return super.drain(resource, doDrain);
		}

		@Override
		public FluidStack drain(int maxDrain, boolean doDrain) {
			return new FluidStack(FluidRegistry.WATER, maxDrain);
		}
	}
}
