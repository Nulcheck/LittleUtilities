package lu.com.mce.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class MeatBlocks {
	public static class PorkBlock extends Block {
		public PorkBlock(Material mat) {
			super(mat);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0)); // It's fuckin' raw!
			list.add(new ItemStack(item, 1, 1)); // Cooked
		}

		public int damageDropped(int meta) {
			return meta;
		}
	}

	public static class BeefBlock extends Block {
		public BeefBlock(Material mat) {
			super(mat);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0)); // Raw
			list.add(new ItemStack(item, 1, 1)); // Cooked
		}

		public int damageDropped(int meta) {
			return meta;
		}
	}

	public static class ChickenBlock extends Block {
		public ChickenBlock(Material mat) {
			super(mat);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0)); // Raw
			list.add(new ItemStack(item, 1, 1)); // Cooked
		}

		public int damageDropped(int meta) {
			return meta;
		}
	}

	public static class FishBlock extends Block {
		public FishBlock(Material mat) {
			super(mat);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0)); // Fish
			list.add(new ItemStack(item, 1, 1)); // Salmon
			list.add(new ItemStack(item, 1, 2)); // Clown
			list.add(new ItemStack(item, 1, 3)); // Mrs. Puff
			list.add(new ItemStack(item, 1, 4)); // Cooked Fish
			list.add(new ItemStack(item, 1, 5)); // Cooked Salmon
		}

		public int damageDropped(int meta) {
			return meta;
		}
	}

	public static class RottenFleshBlock extends EdibleBlock {
		public RottenFleshBlock(Material mat, int lvl, float sat) {
			super(mat, lvl, sat);
		}

		public void onEntityWalking(World world, int x, int y, int z, Entity player) {
			((EntityLivingBase) player).addPotionEffect(new PotionEffect(17, 220, 1, false));
			((EntityLivingBase) player).addPotionEffect(new PotionEffect(9, 220, 1, false));
			super.onEntityWalking(world, x, y, z, player);
		}

		public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
			((EntityLivingBase) player).addPotionEffect(new PotionEffect(17, 220, 1, false));
			((EntityLivingBase) player).addPotionEffect(new PotionEffect(9, 220, 1, false));
			super.onEntityWalking(world, x, y, z, player);
		}
	}
}
