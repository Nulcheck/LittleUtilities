package lu.com.mce.objects.blocks;

import java.util.Random;

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
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class ModBlocks {
	public static class BoundsBlock extends BlockBase {
		static double maxY;
		static double maxY1 = 1d - maxY;
		
		protected static final AxisAlignedBB BLOCK_COLLISION_AABB = new AxisAlignedBB(0d, 0d, 0d, 1d, maxY1, 1d);
		protected static final AxisAlignedBB BLOCK_AABB = new AxisAlignedBB(0d, 0d, 0d, 1d, maxY1, 1d);

		public BoundsBlock(String name, Material mat, double maxY) {
			super(name, mat);
			this.maxY = maxY;
		}

		public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
			return BLOCK_COLLISION_AABB;
		}

		public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos) {
			return BLOCK_AABB.offset(pos);
		}

		public boolean isFullCube(IBlockState state) {
			return false;
		}

		public boolean isOpaqueCube(IBlockState state) {
			return false;
		}
	}

	public static class GhastTearBlock extends BlockBase {
		public GhastTearBlock(String name, Material mat) {
			super(name, mat);
			setSoundType(SoundType.GLASS);
		}

		/*
		 * public void randomDisplayTick(World world, BlockPos pos, Random rand)
		 * { double d0 = 0.0625d;
		 * 
		 * for (int l = 0; l < 6; ++l) { double d1 = (double) ((float)
		 * pos.getX() + rand.nextFloat()); double d2 = (double) ((float)
		 * pos.getY() + rand.nextFloat()); double d3 = (double) ((float)
		 * pos.getZ() + rand.nextFloat());
		 * 
		 * if (l == 0 && !world.getBlockState(pos.getX(), pos.getY() + 1,
		 * pos.getZ()).isOpaqueCube()) { d2 = (double) (pos.getY() + 1) + d0; }
		 * 
		 * if (l == 1 && !world.getBlockState(pos.getX(), pos.getY() - 1,
		 * pos.getZ()).isOpaqueCube()) { d2 = (double) (pos.getY() + 0) - d0; }
		 * 
		 * if (l == 2 && !world.getBlockState(pos.getX(), pos.getY(), pos.getZ()
		 * + 1).isOpaqueCube()) { d3 = (double) (pos.getZ() + 1) + d0; }
		 * 
		 * if (l == 3 && !world.getBlockState(pos.getX(), pos.getY(), pos.getZ()
		 * - 1).isOpaqueCube()) { d3 = (double) (pos.getZ() + 0) - d0; }
		 * 
		 * if (l == 4 && !world.getBlockState(pos.getX() + 1, pos.getY(),
		 * pos.getZ()).isOpaqueCube()) { d1 = (double) (pos.getX() + 1) + d0; }
		 * 
		 * if (l == 5 && !world.getBlockState(pos.getX() - 1, pos.getY(),
		 * pos.getZ()).isOpaqueCube()) { d1 = (double) (pos.getX() + 0) - d0; }
		 * 
		 * if (d1 < (double) pos.getX() || d1 > (double) (pos.getX() + 1) || d2
		 * < 0.0D || d2 > (double) (pos.getY() + 1) || d3 < (double) pos.getZ()
		 * || d3 > (double) (pos.getZ() + 1)) {
		 * mod_lu.proxy.spawnParticle(world, pos.getX(), pos.getY(), pos.getZ(),
		 * "ghastTearFx"); } } }
		 */
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

		/*
		 * public void randomDisplayTick(World world, int x, int y, int z,
		 * Random rand) { double d0 = 0.0625d;
		 * 
		 * for (int l = 0; l < 6; ++l) { double d1 = (double) ((float) x +
		 * rand.nextFloat()); double d2 = (double) ((float) y +
		 * rand.nextFloat()); double d3 = (double) ((float) z +
		 * rand.nextFloat());
		 * 
		 * if (l == 0 && !world.getBlock(x, y + 1, z).isOpaqueCube()) { d2 =
		 * (double) (y + 1) + d0; }
		 * 
		 * if (l == 1 && !world.getBlock(x, y - 1, z).isOpaqueCube()) { d2 =
		 * (double) (y + 0) - d0; }
		 * 
		 * if (l == 2 && !world.getBlock(x, y, z + 1).isOpaqueCube()) { d3 =
		 * (double) (z + 1) + d0; }
		 * 
		 * if (l == 3 && !world.getBlock(x, y, z - 1).isOpaqueCube()) { d3 =
		 * (double) (z + 0) - d0; }
		 * 
		 * if (l == 4 && !world.getBlock(x + 1, y, z).isOpaqueCube()) { d1 =
		 * (double) (x + 1) + d0; }
		 * 
		 * if (l == 5 && !world.getBlock(x - 1, y, z).isOpaqueCube()) { d1 =
		 * (double) (x + 0) - d0; }
		 * 
		 * if (d1 < (double) x || d1 > (double) (x + 1) || d2 < 0.0D || d2 >
		 * (double) (y + 1) || d3 < (double) z || d3 > (double) (z + 1)) {
		 * mod_lu.proxy.spawnParticle(world, x, y, z, "blazeRodFx"); } } }
		 */
	}

	public static class NetherStarBlock extends BlockBase {
		public NetherStarBlock(String name, Material mat) {
			super(name, mat);
		}

		/*
		 * public void randomDisplayTick(World world, int x, int y, int z,
		 * Random rand) { double d0 = 0.0625d;
		 * 
		 * for (int l = 0; l < 6; ++l) { double d1 = (double) ((float) x +
		 * rand.nextFloat()); double d2 = (double) ((float) y +
		 * rand.nextFloat()); double d3 = (double) ((float) z +
		 * rand.nextFloat());
		 * 
		 * if (l == 0 && !world.getBlock(x, y + 1, z).isOpaqueCube()) { d2 =
		 * (double) (y + 1) + d0; }
		 * 
		 * if (l == 1 && !world.getBlock(x, y - 1, z).isOpaqueCube()) { d2 =
		 * (double) (y + 0) - d0; }
		 * 
		 * if (l == 2 && !world.getBlock(x, y, z + 1).isOpaqueCube()) { d3 =
		 * (double) (z + 1) + d0; }
		 * 
		 * if (l == 3 && !world.getBlock(x, y, z - 1).isOpaqueCube()) { d3 =
		 * (double) (z + 0) - d0; }
		 * 
		 * if (l == 4 && !world.getBlock(x + 1, y, z).isOpaqueCube()) { d1 =
		 * (double) (x + 1) + d0; }
		 * 
		 * if (l == 5 && !world.getBlock(x - 1, y, z).isOpaqueCube()) { d1 =
		 * (double) (x + 0) - d0; }
		 * 
		 * if (d1 < (double) x || d1 > (double) (x + 1) || d2 < 0.0D || d2 >
		 * (double) (y + 1) || d3 < (double) z || d3 > (double) (z + 1)) {
		 * mod_lu.proxy.spawnParticle(world, x, y, z, "netherStarFx"); } } }
		 */
	}

	public static class EnderPearlBlock extends UsableBlock {
		public EnderPearlBlock(String name, Material mat) {
			super(name, mat);
		}

		/*
		 * public void randomDisplayTick(World world, int x, int y, int z,
		 * Random rand) { double d0 = 0.0625d;
		 * 
		 * for (int l = 0; l < 6; ++l) { double d1 = (double) ((float) x +
		 * rand.nextFloat()); double d2 = (double) ((float) y +
		 * rand.nextFloat()); double d3 = (double) ((float) z +
		 * rand.nextFloat());
		 * 
		 * if (l == 0 && !world.getBlock(x, y + 1, z).isOpaqueCube()) { d2 =
		 * (double) (y + 1) + d0; }
		 * 
		 * if (l == 1 && !world.getBlock(x, y - 1, z).isOpaqueCube()) { d2 =
		 * (double) (y + 0) - d0; }
		 * 
		 * if (l == 2 && !world.getBlock(x, y, z + 1).isOpaqueCube()) { d3 =
		 * (double) (z + 1) + d0; }
		 * 
		 * if (l == 3 && !world.getBlock(x, y, z - 1).isOpaqueCube()) { d3 =
		 * (double) (z + 0) - d0; }
		 * 
		 * if (l == 4 && !world.getBlock(x + 1, y, z).isOpaqueCube()) { d1 =
		 * (double) (x + 1) + d0; }
		 * 
		 * if (l == 5 && !world.getBlock(x - 1, y, z).isOpaqueCube()) { d1 =
		 * (double) (x + 0) - d0; }
		 * 
		 * if (d1 < (double) x || d1 > (double) (x + 1) || d2 < 0.0D || d2 >
		 * (double) (y + 1) || d3 < (double) z || d3 > (double) (z + 1)) {
		 * mod_lu.proxy.spawnParticle(world, x, y, z, "enderPerlFx"); } } }
		 */

		public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX,
				float hitY, float hitZ) {
			Random rand = new Random();
			double d0 = player.posX + (rand.nextDouble() - 0.5D) * 64.0D;
			double d1 = player.posY + (double) (rand.nextInt(64) - 32);
			double d2 = player.posZ + (rand.nextDouble() - 0.5D) * 64.0D;

			return this.teleportPlayer(d0, d1, d2, player);
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

		/*
		 * public void randomDisplayTick(World world, int x, int y, int z,
		 * Random rand) { double d0 = 0.0625d;
		 * 
		 * for (int l = 0; l < 6; ++l) { double d1 = (double) ((float) x +
		 * rand.nextFloat()); double d2 = (double) ((float) y +
		 * rand.nextFloat()); double d3 = (double) ((float) z +
		 * rand.nextFloat()); double d4 = 0.0D; double d5 = 0.0D; double d6 =
		 * 0.0D; d4 = ((double) rand.nextFloat() - 0.5D) * 0.5D; d5 = ((double)
		 * rand.nextFloat() - 0.5D) * 0.5D; d6 = ((double) rand.nextFloat() -
		 * 0.5D) * 0.5D;
		 * 
		 * if (l == 0 && !world.getBlock(x, y + 1, z).isOpaqueCube()) { d2 =
		 * (double) (y + 1) + d0; }
		 * 
		 * if (l == 1 && !world.getBlock(x, y - 1, z).isOpaqueCube()) { d2 =
		 * (double) (y + 0) - d0; }
		 * 
		 * if (l == 2 && !world.getBlock(x, y, z + 1).isOpaqueCube()) { d3 =
		 * (double) (z + 1) + d0; }
		 * 
		 * if (l == 3 && !world.getBlock(x, y, z - 1).isOpaqueCube()) { d3 =
		 * (double) (z + 0) - d0; }
		 * 
		 * if (l == 4 && !world.getBlock(x + 1, y, z).isOpaqueCube()) { d1 =
		 * (double) (x + 1) + d0; }
		 * 
		 * if (l == 5 && !world.getBlock(x - 1, y, z).isOpaqueCube()) { d1 =
		 * (double) (x + 0) - d0; }
		 * 
		 * if (d1 < (double) x || d1 > (double) (x + 1) || d2 < 0.0D || d2 >
		 * (double) (y + 1) || d3 < (double) z || d3 > (double) (z + 1)) {
		 * mod_lu.proxy.spawnParticle(world, x, y, z, "enderEyeFx"); //
		 * world.spawnParticle("portal", d1, d2, d3, d4, d5, d6); } } }
		 */
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
			this.setPotionEffect(MobEffects.POISON, 1200, 3, 1f);
			this.setPotionEffect(MobEffects.HUNGER, 300, 2, 1f);
			this.setPotionEffect(MobEffects.NAUSEA, 300, 1, 1f);
		}

		public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
			try {
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.POISON, 1200, 3, false, true));
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.HUNGER, 300, 2, false, true));
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 300, 1, false, true));
				super.onEntityCollidedWithBlock(world, pos, state, entity);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public int getRenderType() {
			return 13;
		}
	}
}
