package lu.com.mce.objects.blocks;

import java.util.Random;

import lu.com.mce.main.mod_lu;
import lu.com.mce.util.BlockBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class ModBlocks {
	public static class BoundsBlock extends BlockBase {
		double maxY;

		public BoundsBlock(String name, Material mat, double maxY) {
			super(name, mat);
			this.maxY = maxY;
		}

		public boolean isFullCube(IBlockState state) {
			return false;
		}

		public boolean isOpaqueCube(IBlockState state) {
			return false;
		}

		public BlockRenderLayer getBlockLayer() {
			return BlockRenderLayer.CUTOUT;
		}

		public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
			return new AxisAlignedBB(0d, 0d, 0d, 1d, 1d - maxY, 1d);
		}
	}

	public static class GhastTearBlock extends BlockBase {
		public GhastTearBlock(String name, Material mat) {
			super(name, mat);
			setSoundType(SoundType.GLASS);
		}

		public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
			double d0 = 0.0625d;

			for (int l = 0; l < 6; ++l) {
				double d1 = (double) ((float) pos.getX() + rand.nextFloat());
				double d2 = (double) ((float) pos.getY() + rand.nextFloat());
				double d3 = (double) ((float) pos.getZ() + rand.nextFloat());

				if (l == 0
						&& !world.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).isOpaqueCube()) {
					d2 = (double) (pos.getY() + 1) + d0;
				}

				if (l == 1
						&& !world.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())).isOpaqueCube()) {
					d2 = (double) (pos.getY() + 0) - d0;
				}

				if (l == 2
						&& !world.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1)).isOpaqueCube()) {
					d3 = (double) (pos.getZ() + 1) + d0;
				}

				if (l == 3
						&& !world.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1)).isOpaqueCube()) {
					d3 = (double) (pos.getZ() + 0) - d0;
				}

				if (l == 4
						&& !world.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())).isOpaqueCube()) {
					d1 = (double) (pos.getX() + 1) + d0;
				}

				if (l == 5
						&& !world.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())).isOpaqueCube()) {
					d1 = (double) (pos.getX() + 0) - d0;
				}

				if (d1 < (double) pos.getX() || d1 > (double) (pos.getX() + 1) || d2 < 0.0D
						|| d2 > (double) (pos.getY() + 1) || d3 < (double) pos.getZ()
						|| d3 > (double) (pos.getZ() + 1)) {
					mod_lu.proxy.spawnParticle(world, pos.getX(), pos.getY(), pos.getZ(), "ghastTearFX");
				}
			}
		}

	}

	public static class BlazeRodBlock extends BlockBase {
		public BlazeRodBlock(String name, Material mat) {
			super(name, mat);
		}

		public void onEntityWalk(World world, BlockPos pos, Entity e) {
			e.setFire(8);
			super.onEntityWalk(world, pos, e);
		}

		public boolean isFireSource(World world, BlockPos pos, EnumFacing side) {
			if (side == EnumFacing.UP)
				return true;
			else
				return false;
		}

		public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
			double d0 = 0.0625d;

			for (int l = 0; l < 6; ++l) {
				double d1 = (double) ((float) pos.getX() + rand.nextFloat());
				double d2 = (double) ((float) pos.getY() + rand.nextFloat());
				double d3 = (double) ((float) pos.getZ() + rand.nextFloat());

				if (l == 0
						&& !world.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).isOpaqueCube()) {
					d2 = (double) (pos.getY() + 1) + d0;
				}

				if (l == 1
						&& !world.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())).isOpaqueCube()) {
					d2 = (double) (pos.getY() + 0) - d0;
				}

				if (l == 2
						&& !world.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1)).isOpaqueCube()) {
					d3 = (double) (pos.getZ() + 1) + d0;
				}

				if (l == 3
						&& !world.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1)).isOpaqueCube()) {
					d3 = (double) (pos.getZ() + 0) - d0;
				}

				if (l == 4
						&& !world.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())).isOpaqueCube()) {
					d1 = (double) (pos.getX() + 1) + d0;
				}

				if (l == 5
						&& !world.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())).isOpaqueCube()) {
					d1 = (double) (pos.getX() + 0) - d0;
				}

				if (d1 < (double) pos.getX() || d1 > (double) (pos.getX() + 1) || d2 < 0.0D
						|| d2 > (double) (pos.getY() + 1) || d3 < (double) pos.getZ()
						|| d3 > (double) (pos.getZ() + 1)) {
					mod_lu.proxy.spawnParticle(world, pos.getX(), pos.getY(), pos.getZ(), "blazeRodFX");
				}
			}
		}
	}

	public static class NetherStarBlock extends BlockBase {
		public NetherStarBlock(String name, Material mat) {
			super(name, mat);
		}

		public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
			double d0 = 0.0625d;

			for (int l = 0; l < 6; ++l) {
				double d1 = (double) ((float) pos.getX() + rand.nextFloat());
				double d2 = (double) ((float) pos.getY() + rand.nextFloat());
				double d3 = (double) ((float) pos.getZ() + rand.nextFloat());

				if (l == 0
						&& !world.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).isOpaqueCube()) {
					d2 = (double) (pos.getY() + 1) + d0;
				}

				if (l == 1
						&& !world.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())).isOpaqueCube()) {
					d2 = (double) (pos.getY() + 0) - d0;
				}

				if (l == 2
						&& !world.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1)).isOpaqueCube()) {
					d3 = (double) (pos.getZ() + 1) + d0;
				}

				if (l == 3
						&& !world.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1)).isOpaqueCube()) {
					d3 = (double) (pos.getZ() + 0) - d0;
				}

				if (l == 4
						&& !world.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())).isOpaqueCube()) {
					d1 = (double) (pos.getX() + 1) + d0;
				}

				if (l == 5
						&& !world.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())).isOpaqueCube()) {
					d1 = (double) (pos.getX() + 0) - d0;
				}

				if (d1 < (double) pos.getX() || d1 > (double) (pos.getX() + 1) || d2 < 0.0D
						|| d2 > (double) (pos.getY() + 1) || d3 < (double) pos.getZ()
						|| d3 > (double) (pos.getZ() + 1)) {
					mod_lu.proxy.spawnParticle(world, pos.getX(), pos.getY(), pos.getZ(), "netherStarFX");
				}
			}
		}
	}

	public static class EnderPearlBlock extends UsableBlock {
		public EnderPearlBlock(String name, Material mat) {
			super(name, mat);
		}

		public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
			double d0 = 0.0625d;

			for (int l = 0; l < 6; ++l) {
				double d1 = (double) ((float) pos.getX() + rand.nextFloat());
				double d2 = (double) ((float) pos.getY() + rand.nextFloat());
				double d3 = (double) ((float) pos.getZ() + rand.nextFloat());

				if (l == 0
						&& !world.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).isOpaqueCube()) {
					d2 = (double) (pos.getY() + 1) + d0;
				}

				if (l == 1
						&& !world.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())).isOpaqueCube()) {
					d2 = (double) (pos.getY() + 0) - d0;
				}

				if (l == 2
						&& !world.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1)).isOpaqueCube()) {
					d3 = (double) (pos.getZ() + 1) + d0;
				}

				if (l == 3
						&& !world.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1)).isOpaqueCube()) {
					d3 = (double) (pos.getZ() + 0) - d0;
				}

				if (l == 4
						&& !world.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())).isOpaqueCube()) {
					d1 = (double) (pos.getX() + 1) + d0;
				}

				if (l == 5
						&& !world.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())).isOpaqueCube()) {
					d1 = (double) (pos.getX() + 0) - d0;
				}

				if (d1 < (double) pos.getX() || d1 > (double) (pos.getX() + 1) || d2 < 0.0D
						|| d2 > (double) (pos.getY() + 1) || d3 < (double) pos.getZ()
						|| d3 > (double) (pos.getZ() + 1)) {
					mod_lu.proxy.spawnParticle(world, pos.getX(), pos.getY(), pos.getZ(), "enderPearlFX");
				}
			}
		}

		public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player,
				EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
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
			boolean attemptTeleport = player.attemptTeleport(event.getTargetX(), event.getTargetY(),
					event.getTargetZ());

			if (attemptTeleport) {
				player.world.playSound((EntityPlayer) null, player.prevPosX, player.prevPosY, player.prevPosZ,
						SoundEvents.ENTITY_ENDERMEN_TELEPORT, player.getSoundCategory(), 1.0F, 1.0F);
				player.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
			}

			return attemptTeleport;
		}
	}

	public static class EnderEyeBlock extends BlockBase {
		Random rand = new Random();

		public EnderEyeBlock(String name, Material mat) {
			super(name, mat);
		}

		public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
			double d0 = 0.0625d;

			for (int l = 0; l < 6; ++l) {
				double d1 = (double) ((float) pos.getX() + rand.nextFloat());
				double d2 = (double) ((float) pos.getY() + rand.nextFloat());
				double d3 = (double) ((float) pos.getZ() + rand.nextFloat());

				if (l == 0
						&& !world.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).isOpaqueCube()) {
					d2 = (double) (pos.getY() + 1) + d0;
				}

				if (l == 1
						&& !world.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())).isOpaqueCube()) {
					d2 = (double) (pos.getY() + 0) - d0;
				}

				if (l == 2
						&& !world.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1)).isOpaqueCube()) {
					d3 = (double) (pos.getZ() + 1) + d0;
				}

				if (l == 3
						&& !world.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1)).isOpaqueCube()) {
					d3 = (double) (pos.getZ() + 0) - d0;
				}

				if (l == 4
						&& !world.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())).isOpaqueCube()) {
					d1 = (double) (pos.getX() + 1) + d0;
				}

				if (l == 5
						&& !world.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())).isOpaqueCube()) {
					d1 = (double) (pos.getX() + 0) - d0;
				}

				if (d1 < (double) pos.getX() || d1 > (double) (pos.getX() + 1) || d2 < 0.0D
						|| d2 > (double) (pos.getY() + 1) || d3 < (double) pos.getZ()
						|| d3 > (double) (pos.getZ() + 1)) {
					mod_lu.proxy.spawnParticle(world, pos.getX(), pos.getY(), pos.getZ(), "enderEyeFX");
				}
			}
		}
	}

	public static class CompactDirt extends BlockBase {
		public CompactDirt(String name, Material mat) {
			super(name, mat);
		}
	}

	public static class CompactNetherrack extends BlockBase {
		public CompactNetherrack(String name, Material mat) {
			super(name, mat);
		}

		public boolean isFireSource(World world, int x, int y, int z, EnumFacing side) {
			if (side == EnumFacing.UP)
				return true;
			else
				return false;
		}
	}

	public static class PufferfishBlock extends EdibleBlock {
		public PufferfishBlock(String name, Material mat, int lvl, float sat) {
			super(name, mat, lvl, sat);
		}

		public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player,
				EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
			if (!player.isSneaking()) {
				super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ);
				this.applyEffects(world, pos, (Entity) player);
				return true;
			} else {
				return false;
			}
		}

		public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
			this.applyEffects(world, pos, entity);
		}

		public void onEntityWalk(World world, BlockPos pos, Entity entity) {
			this.applyEffects(world, pos, entity);
		}

		public void applyEffects(World world, BlockPos pos, Entity entity) {
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

	public static class FeatherBlock extends BlockBase {
		public FeatherBlock(String name, Material mat) {
			super(name, mat);
		}

		public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
			entityIn.fall(fallDistance, 0.0F);
		}

		public void onLanded(World worldIn, Entity entityIn) {
			if (entityIn.motionY < 0d) {
				entityIn.motionY = 0d;
			}
		}
	}
}
