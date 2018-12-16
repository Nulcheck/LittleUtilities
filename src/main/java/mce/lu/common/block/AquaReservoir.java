package mce.lu.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AquaReservoir extends BlockBase {
	public AquaReservoir(String name, Material mat) {
		super(name, mat);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		// Gives water if empty bucket
		if (!player.getHeldItemMainhand().isEmpty() && player.getHeldItemMainhand().getItem() == Items.BUCKET) {
			player.getHeldItemMainhand().shrink(1);
			player.inventory.addItemStackToInventory(new ItemStack(Items.WATER_BUCKET, 1));
			return true;
		}

		// Empties water bucket
		if (!player.getHeldItemMainhand().isEmpty() && player.getHeldItemMainhand().getItem() == Items.WATER_BUCKET) {
			player.getHeldItemMainhand().shrink(1);
			player.inventory.addItemStackToInventory(new ItemStack(Items.BUCKET, 1));
			return true;
		}

		else {
			return false;
		}
	}
}
