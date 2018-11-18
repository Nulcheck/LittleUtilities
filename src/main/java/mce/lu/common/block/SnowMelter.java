package mce.lu.common.block;

import mce.lu.common.entity.tile.TileEntitySnowMelter;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SnowMelter extends BlockContainerBase {
	public static boolean isActive;

	public SnowMelter(String name, Material mat) {
		super(name, mat);
		this.setTickRandomly(true);
	}
	
	public void onBlockAdded(World world, BlockPos pos, IBlockState state){
		super.onBlockAdded(world, pos, state);
		
		if(world.isBlockPowered(pos) || world.isBlockIndirectlyGettingPowered(pos) >= 1)
			isActive = true;
		else
			isActive = false;
	}

	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
		if (world.isBlockPowered(pos) || world.isBlockIndirectlyGettingPowered(pos) >= 1)
			isActive = true;
		else
			isActive = false;
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		TileEntitySnowMelter tile = (TileEntitySnowMelter) world.getTileEntity(pos);

		tile.meltSnow();
		return true;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntitySnowMelter();
	}
}
