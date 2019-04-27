package mce.lu.common.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.xendric.xenlib.common.core.block.BlockEdible;

public class PufferfishBlock extends BlockEdible {
	public PufferfishBlock(String name, Material mat, List<Block> blockList, List<Item> itemList, int lvl, float sat) {
		super(name, mat, blockList, itemList, lvl, sat);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!player.isSneaking()) {
			super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ);

			/**
			 * If you ate the block, then apply effects. Otherwise, it would apply effects
			 * just by right clicking, and I wanted to apply effects upon eating it.
			 */
			if (super.eatBlock(world, pos, state, player)) {
				this.applyEffects(world, pos, (Entity) player);
				return true;
			}
			return false;
		} else
			return false;
	}

	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
		this.applyEffects(world, pos, entity);
	}

	@Override
	public void onEntityWalk(World world, BlockPos pos, Entity entity) {
		this.applyEffects(world, pos, entity);
	}

	private void applyEffects(World world, BlockPos pos, Entity entity) {
		try {
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.POISON, 1200, 3));
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.HUNGER, 300, 2));
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 300, 1));
			super.onEntityWalk(world, pos, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
