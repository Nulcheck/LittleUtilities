package mce.lu.common.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.xendric.xenlib.common.core.block.BlockBase;

public class BlockTranslucentBase extends BlockBase {
	/*
	 * Don't render sides next to each other like glass (if true), otherwise it
	 * renders like the slime block
	 */
	private final boolean ignoreSimilarity;

	public BlockTranslucentBase(String name, Material mat, List<Block> blockList, List<Item> itemList,
			boolean ignoreSimilar) {
		super(name, mat, blockList, itemList);
		this.ignoreSimilarity = ignoreSimilar;
	}

	public BlockTranslucentBase(String name, Material mat, List<Block> blockList, List<Item> itemList, SoundType sound,
			boolean ignoreSimilar) {
		this(name, mat, blockList, itemList, ignoreSimilar);
		this.setSoundType(sound);
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}

	/**
	 * Used to determine ambient occlusion and culling when rebuilding chunks for
	 * render
	 */
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos,
			EnumFacing side) {
		IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
		Block block = iblockstate.getBlock();

		if (blockState != iblockstate)
			return true;

		return !this.ignoreSimilarity && block == this ? false
				: super.shouldSideBeRendered(blockState, blockAccess, pos, side);
	}
}
