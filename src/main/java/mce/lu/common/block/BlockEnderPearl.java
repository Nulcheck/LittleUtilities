package mce.lu.common.block;

import java.util.List;
import java.util.Random;

import mce.lu.client.fx.particles.ParticleEnderFX;
import mce.lu.common.LittleUtilities;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.xendric.xenlib.client.util.ParticleManager;
import net.xendric.xenlib.common.core.block.BlockUsable;

public class BlockEnderPearl extends BlockUsable {
	public BlockEnderPearl(String name, Material mat, List<Block> blockList, List<Item> itemList) {
		super(name, mat, blockList, itemList);
	}

	@Override
	public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
		double d0 = 0.0625d;

		for (int l = 0; l < 6; ++l) {
			double d1 = (double) ((float) pos.getX() + rand.nextFloat());
			double d2 = (double) ((float) pos.getY() + rand.nextFloat());
			double d3 = (double) ((float) pos.getZ() + rand.nextFloat());

			if (l == 0 && !world.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).isOpaqueCube()) {
				d2 = (double) (pos.getY() + 1) + d0;
			}

			if (l == 1 && !world.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())).isOpaqueCube()) {
				d2 = (double) (pos.getY() + 0) - d0;
			}

			if (l == 2 && !world.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1)).isOpaqueCube()) {
				d3 = (double) (pos.getZ() + 1) + d0;
			}

			if (l == 3 && !world.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1)).isOpaqueCube()) {
				d3 = (double) (pos.getZ() + 0) - d0;
			}

			if (l == 4 && !world.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())).isOpaqueCube()) {
				d1 = (double) (pos.getX() + 1) + d0;
			}

			if (l == 5 && !world.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())).isOpaqueCube()) {
				d1 = (double) (pos.getX() + 0) - d0;
			}

			if (d1 < (double) pos.getX() || d1 > (double) (pos.getX() + 1) || d2 < 0.0D
					|| d2 > (double) (pos.getY() + 1) || d3 < (double) pos.getZ() || d3 > (double) (pos.getZ() + 1)) {
				/*
				 * LittleUtilities.proxy .spawnParticle(world, pos.getX(), pos.getY(),
				 * pos.getZ(), new ParticleEnderFX(world, pos.getX() + rand.nextDouble(),
				 * pos.getY() + rand.nextDouble(), pos.getZ() + rand.nextDouble(), 0d, 0d, 0d),
				 * 1f, 0.3f, 0.9f, 0f, 10, false);
				 */
			}
		}
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		Random rand = new Random();
		double d0 = player.posX + (rand.nextDouble() - 0.5D) * 64.0D;
		double d1 = player.posY + (double) (rand.nextInt(64) - 32);
		double d2 = player.posZ + (rand.nextDouble() - 0.5D) * 64.0D;

		if (!player.isSneaking()) {
			if (this.teleportPlayer(d0, d1, d2, player)) {
				super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ);
			}

			return this.teleportPlayer(d0, d1, d2, player);
		} else
			return false;
	}

	private boolean teleportPlayer(double x, double y, double z, EntityPlayer player) {
		EnderTeleportEvent event = new EnderTeleportEvent(player, x, y, z, 0);
		if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event))
			return false;
		boolean attemptTeleport = player.attemptTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ());

		if (attemptTeleport) {
			player.world.playSound((EntityPlayer) null, player.prevPosX, player.prevPosY, player.prevPosZ,
					SoundEvents.ENTITY_ENDERMEN_TELEPORT, player.getSoundCategory(), 1.0F, 1.0F);
			player.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
		}

		return attemptTeleport;
	}
}
