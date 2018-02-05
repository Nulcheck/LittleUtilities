package lu.com.mce.blocks;

import java.util.List;
import java.util.Random;

import lu.com.mce.common.mod_lu;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockNetherrack;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class ModBlocks extends Block {
	public ModBlocks(Material mat) {
		super(mat);
	}

	public static class GhastTearBlock extends Block {
		public GhastTearBlock(Material mat) {
			super(mat);
		}

		public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
			double d0 = 0.0625d;

			for (int l = 0; l < 6; ++l) {
				double d1 = (double) ((float) x + rand.nextFloat());
				double d2 = (double) ((float) y + rand.nextFloat());
				double d3 = (double) ((float) z + rand.nextFloat());

				if (l == 0 && !world.getBlock(x, y + 1, z).isOpaqueCube()) {
					d2 = (double) (y + 1) + d0;
				}

				if (l == 1 && !world.getBlock(x, y - 1, z).isOpaqueCube()) {
					d2 = (double) (y + 0) - d0;
				}

				if (l == 2 && !world.getBlock(x, y, z + 1).isOpaqueCube()) {
					d3 = (double) (z + 1) + d0;
				}

				if (l == 3 && !world.getBlock(x, y, z - 1).isOpaqueCube()) {
					d3 = (double) (z + 0) - d0;
				}

				if (l == 4 && !world.getBlock(x + 1, y, z).isOpaqueCube()) {
					d1 = (double) (x + 1) + d0;
				}

				if (l == 5 && !world.getBlock(x - 1, y, z).isOpaqueCube()) {
					d1 = (double) (x + 0) - d0;
				}

				if (d1 < (double) x || d1 > (double) (x + 1) || d2 < 0.0D || d2 > (double) (y + 1) || d3 < (double) z || d3 > (double) (z + 1)) {
					mod_lu.proxy.spawnParticle(world, x, y, z, "ghastTearFx");
				}
			}
		}
	}

	public static class BlazeRodBlock extends Block {
		public BlazeRodBlock(Material mat) {
			super(mat);
		}

		public void onEntityWalking(World world, int x, int y, int z, Entity e) {
			e.setFire(8);
			super.onEntityWalking(world, x, y, z, e);
		}

		public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side) {
			if (side == ForgeDirection.UP)
				return true;
			else
				return false;
		}

		public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
			double d0 = 0.0625d;

			for (int l = 0; l < 6; ++l) {
				double d1 = (double) ((float) x + rand.nextFloat());
				double d2 = (double) ((float) y + rand.nextFloat());
				double d3 = (double) ((float) z + rand.nextFloat());

				if (l == 0 && !world.getBlock(x, y + 1, z).isOpaqueCube()) {
					d2 = (double) (y + 1) + d0;
				}

				if (l == 1 && !world.getBlock(x, y - 1, z).isOpaqueCube()) {
					d2 = (double) (y + 0) - d0;
				}

				if (l == 2 && !world.getBlock(x, y, z + 1).isOpaqueCube()) {
					d3 = (double) (z + 1) + d0;
				}

				if (l == 3 && !world.getBlock(x, y, z - 1).isOpaqueCube()) {
					d3 = (double) (z + 0) - d0;
				}

				if (l == 4 && !world.getBlock(x + 1, y, z).isOpaqueCube()) {
					d1 = (double) (x + 1) + d0;
				}

				if (l == 5 && !world.getBlock(x - 1, y, z).isOpaqueCube()) {
					d1 = (double) (x + 0) - d0;
				}

				if (d1 < (double) x || d1 > (double) (x + 1) || d2 < 0.0D || d2 > (double) (y + 1) || d3 < (double) z || d3 > (double) (z + 1)) {
					mod_lu.proxy.spawnParticle(world, x, y, z, "blazeRodFx");
				}
			}
		}
	}

	public static class NetherStarBlock extends Block {
		public NetherStarBlock(Material mat) {
			super(mat);
		}

		public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
			double d0 = 0.0625d;

			for (int l = 0; l < 6; ++l) {
				double d1 = (double) ((float) x + rand.nextFloat());
				double d2 = (double) ((float) y + rand.nextFloat());
				double d3 = (double) ((float) z + rand.nextFloat());

				if (l == 0 && !world.getBlock(x, y + 1, z).isOpaqueCube()) {
					d2 = (double) (y + 1) + d0;
				}

				if (l == 1 && !world.getBlock(x, y - 1, z).isOpaqueCube()) {
					d2 = (double) (y + 0) - d0;
				}

				if (l == 2 && !world.getBlock(x, y, z + 1).isOpaqueCube()) {
					d3 = (double) (z + 1) + d0;
				}

				if (l == 3 && !world.getBlock(x, y, z - 1).isOpaqueCube()) {
					d3 = (double) (z + 0) - d0;
				}

				if (l == 4 && !world.getBlock(x + 1, y, z).isOpaqueCube()) {
					d1 = (double) (x + 1) + d0;
				}

				if (l == 5 && !world.getBlock(x - 1, y, z).isOpaqueCube()) {
					d1 = (double) (x + 0) - d0;
				}

				if (d1 < (double) x || d1 > (double) (x + 1) || d2 < 0.0D || d2 > (double) (y + 1) || d3 < (double) z || d3 > (double) (z + 1)) {
					mod_lu.proxy.spawnParticle(world, x, y, z, "netherStarFx");
				}
			}
		}
	}

	public static class BoundsBlock extends Block {
		float f;

		public BoundsBlock(Material mat, float maxY) {
			super(mat);
			this.f = maxY;
			float f1 = 1f - maxY;

			this.setBlockBounds(0f, 0f, 0f, 1f, f1, 1f);
		}

		public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
			return AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) z, (double) (x + 1), (double) ((float) (y + 1) - f), (double) (z + 1));
		}

		public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
			return AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) z, (double) (x + 1), (double) ((float) (y + 1) - f), (double) (z + 1));
		}

		public boolean renderAsNormalBlock() {
			return false;
		}

		public boolean isOpaqueCube() {
			return false;
		}
	}

	public static class SlimeBlock extends Block {
		private double height;
		private boolean mY;

		public SlimeBlock(Material mat) {
			super(mat);
			this.slipperiness = 0.8f;
		}

		public boolean isOpaqueCube() {
			return false;
		}

		public boolean shouldSideBeRendered(IBlockAccess blockAcc, int x, int y, int z, int side) {
			return true;
		}

		public void onFallenUpon(World world, int x, int y, int z, Entity e, float fallDistance) {
			if (e.isSneaking()) {
				super.onFallenUpon(world, x, y, z, e, fallDistance);
			} else {
				e.fallDistance = 0f;
				mY = true;
				this.height = (-e.motionY);
			}
		}

		public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity e) {
			/// e.motionY *= -1.2d;
			if (mY) {
				e.motionY = this.height;
				mY = false;
			} else if (Math.abs(e.motionY) < 0.1D) {
				double d0 = 0.4D + Math.abs(e.motionY) * 1D;
				e.motionX *= d0;
				e.motionZ *= d0;
			}
			super.onEntityCollidedWithBlock(world, x, y, z, e);
		}

		public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
			return AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 1 - 0.0625f, z + 1);
		}
	}

	public static class EnderPerlBlock extends UsableBlock {
		public EnderPerlBlock(Material mat) {
			super(mat);
		}

		public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
			double d0 = 0.0625d;

			for (int l = 0; l < 6; ++l) {
				double d1 = (double) ((float) x + rand.nextFloat());
				double d2 = (double) ((float) y + rand.nextFloat());
				double d3 = (double) ((float) z + rand.nextFloat());

				if (l == 0 && !world.getBlock(x, y + 1, z).isOpaqueCube()) {
					d2 = (double) (y + 1) + d0;
				}

				if (l == 1 && !world.getBlock(x, y - 1, z).isOpaqueCube()) {
					d2 = (double) (y + 0) - d0;
				}

				if (l == 2 && !world.getBlock(x, y, z + 1).isOpaqueCube()) {
					d3 = (double) (z + 1) + d0;
				}

				if (l == 3 && !world.getBlock(x, y, z - 1).isOpaqueCube()) {
					d3 = (double) (z + 0) - d0;
				}

				if (l == 4 && !world.getBlock(x + 1, y, z).isOpaqueCube()) {
					d1 = (double) (x + 1) + d0;
				}

				if (l == 5 && !world.getBlock(x - 1, y, z).isOpaqueCube()) {
					d1 = (double) (x + 0) - d0;
				}

				if (d1 < (double) x || d1 > (double) (x + 1) || d2 < 0.0D || d2 > (double) (y + 1) || d3 < (double) z || d3 > (double) (z + 1)) {
					mod_lu.proxy.spawnParticle(world, x, y, z, "enderPerlFx");
				}
			}
		}

		public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
			Random rand = new Random();
			double d0 = player.posX + (rand.nextDouble() - 0.5D) * 64.0D;
			double d1 = player.posY + (double) (rand.nextInt(64) - 32);
			double d2 = player.posZ + (rand.nextDouble() - 0.5D) * 64.0D;

			if (this.teleportPlayer(d0, d1, d2, player)) {
				super.onBlockActivated(world, x, y, z, player, meta, hitX, hitY, hitZ);
			}

			return this.teleportPlayer(d0, d1, d2, player);
		}

		protected boolean teleportPlayer(double x, double y, double z, EntityPlayer player) {
			Random rand = new Random();
			EnderTeleportEvent event = new EnderTeleportEvent(player, x, y, z, 0);

			if (MinecraftForge.EVENT_BUS.post(event)) {
				return false;
			}

			double d3 = player.posX;
			double d4 = player.posY;
			double d5 = player.posZ;
			player.posX = event.targetX;
			player.posY = event.targetY;
			player.posZ = event.targetZ;
			boolean boundingBoxEmpty = false;
			int i = MathHelper.floor_double(player.posX);
			int j = MathHelper.floor_double(player.posY);
			int k = MathHelper.floor_double(player.posZ);

			if (player.worldObj.blockExists(i, j, k)) {
				boolean isSolidBlock = false;

				while (!isSolidBlock && j > 0) {
					Block block = player.worldObj.getBlock(i, j - 1, k);

					if (block.getMaterial().blocksMovement()) {
						isSolidBlock = true;
					} else {
						--player.posY;
						--j;
					}
				}

				if (isSolidBlock) {
					player.setPosition(player.posX, player.posY, player.posZ);

					if (player.worldObj.getCollidingBoundingBoxes(player, player.boundingBox).isEmpty() && !player.worldObj.isAnyLiquid(player.boundingBox)) {
						boundingBoxEmpty = true;
					}
				}
			}

			if (!boundingBoxEmpty) {
				player.setPosition(d3, d4, d5);
				return false;
			} else {
				short short1 = 128;

				for (int l = 0; l < short1; ++l) {
					double d6 = (double) l / ((double) short1 - 1.0D);
					float f = (rand.nextFloat() - 0.5F) * 0.2F;
					float f1 = (rand.nextFloat() - 0.5F) * 0.2F;
					float f2 = (rand.nextFloat() - 0.5F) * 0.2F;
					double d7 = d3 + (player.posX - d3) * d6 + (rand.nextDouble() - 0.5D) * (double) player.width * 2.0D;
					double d8 = d4 + (player.posY - d4) * d6 + rand.nextDouble() * (double) player.height;
					double d9 = d5 + (player.posZ - d5) * d6 + (rand.nextDouble() - 0.5D) * (double) player.width * 2.0D;
					player.worldObj.spawnParticle("portal", d7, d8, d9, (double) f, (double) f1, (double) f2);
				}

				player.worldObj.playSoundEffect(d3, d4, d5, "mob.endermen.portal", 1.0F, 1.0F);
				player.playSound("mob.endermen.portal", 1.0F, 1.0F);
				return true;
			}
		}
	}

	public static class EnderEyeBlock extends Block {
		Random rand = new Random();

		public EnderEyeBlock(Material mat) {
			super(mat);
		}

		public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
			double d0 = 0.0625d;

			for (int l = 0; l < 6; ++l) {
				double d1 = (double) ((float) x + rand.nextFloat());
				double d2 = (double) ((float) y + rand.nextFloat());
				double d3 = (double) ((float) z + rand.nextFloat());
				double d4 = 0.0D;
				double d5 = 0.0D;
				double d6 = 0.0D;
				d4 = ((double) rand.nextFloat() - 0.5D) * 0.5D;
				d5 = ((double) rand.nextFloat() - 0.5D) * 0.5D;
				d6 = ((double) rand.nextFloat() - 0.5D) * 0.5D;

				if (l == 0 && !world.getBlock(x, y + 1, z).isOpaqueCube()) {
					d2 = (double) (y + 1) + d0;
				}

				if (l == 1 && !world.getBlock(x, y - 1, z).isOpaqueCube()) {
					d2 = (double) (y + 0) - d0;
				}

				if (l == 2 && !world.getBlock(x, y, z + 1).isOpaqueCube()) {
					d3 = (double) (z + 1) + d0;
				}

				if (l == 3 && !world.getBlock(x, y, z - 1).isOpaqueCube()) {
					d3 = (double) (z + 0) - d0;
				}

				if (l == 4 && !world.getBlock(x + 1, y, z).isOpaqueCube()) {
					d1 = (double) (x + 1) + d0;
				}

				if (l == 5 && !world.getBlock(x - 1, y, z).isOpaqueCube()) {
					d1 = (double) (x + 0) - d0;
				}

				if (d1 < (double) x || d1 > (double) (x + 1) || d2 < 0.0D || d2 > (double) (y + 1) || d3 < (double) z || d3 > (double) (z + 1)) {
					mod_lu.proxy.spawnParticle(world, x, y, z, "enderEyeFx");
					// world.spawnParticle("portal", d1, d2, d3, d4, d5, d6);
				}
			}
		}
	}

	public static class CompactDirt extends BlockDirt {
		public CompactDirt() {
			super();
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(this, 1, 0));
		}
	}

	public static class CompactNetherrack extends BlockNetherrack {
		public CompactNetherrack() {
			super();
		}

		public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side) {
			if (side == ForgeDirection.UP)
				return true;
			else
				return false;
		}
	}

	public static class PufferfishBlock extends EdibleBlock {
		private IIcon top;

		public PufferfishBlock(Material mat, int lvl, float sat) {
			super(mat, lvl, sat);
			this.setPotionEffect(Potion.poison.id, 1200, 3, 1f);
			this.setPotionEffect(Potion.hunger.id, 300, 2, 1f);
			this.setPotionEffect(Potion.confusion.id, 300, 1, 1f);
		}

		public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
			try {
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.poison.id, 1200, 3, false));
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.hunger.id, 300, 2, false));
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.confusion.id, 300, 1, false));
				super.onEntityCollidedWithBlock(world, x, y, z, entity);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public IIcon getIcon(int side, int meta) {
			return side == 1 ? this.top : (side == 0 ? this.top : this.blockIcon);
		}

		public void registerBlockIcons(IIconRegister icon) {
			this.blockIcon = icon.registerIcon("mod_lu:pufferfish_side");
			this.top = icon.registerIcon("mod_lu:pufferfish_top");
		}

		public int getRenderType() {
			return 13;
		}
	}

	public static class BoneBlock extends Block {
		public BoneBlock(Material mat) {
			super(mat);
		}

		public boolean isOpaqueCube() {
			return false;
		}

		public boolean shouldSideBeRendered(IBlockAccess blockAcc, int x, int y, int z, int side) {
			return true;
		}
	}
}
