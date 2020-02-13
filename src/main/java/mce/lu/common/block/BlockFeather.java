package mce.lu.common.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.xendric.xenlib.common.core.block.BlockBase;

public class BlockFeather extends BlockBase {
	public BlockFeather(String name, Material mat, List<Block> blockList, List<Item> itemList) {
		super(name, mat, blockList, itemList);
	}

	@Override
	public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
		entityIn.fall(fallDistance, 0.0F);
	}

	@Override
	public void onLanded(World worldIn, Entity entityIn) {
		if (entityIn.motionY < 0d) {
			entityIn.motionY = 0d;
		}
	}
}
