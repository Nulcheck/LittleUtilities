package mce.lu.common.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.xendric.xenlib.common.core.block.BlockBase;

public class BlockMagmaSlime extends BlockBase {

	public BlockMagmaSlime(String name, Material mat, List<Block> blockList, List<Item> itemList, SoundType type) {
		super(name, mat, blockList, itemList, type);
		this.setDefaultSlipperiness(0.98f);
	}

	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity e) {
		if (e instanceof EntityLivingBase)
			e.setFire(8);
	}
}