package lu.com.mce.events;

import lu.com.mce.common.mod_lu;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GameEvent {
	@SubscribeEvent
	public void setEntityOnFire(AttackEntityEvent e) {
		if (e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.BLAZE_ROD
				&& e.getTarget() instanceof EntityLiving) {
			e.getTarget().setFire(8);
		}
	}

	@SubscribeEvent
	public void onInteractEvent(PlayerInteractEvent e) {
		BlockPos pos = e.getPos();
		IBlockState state = e.getWorld().getBlockState(pos).getBlock().getDefaultState();
		
		// Dye a block in getWorld().
		for (int i = 0; i <= 15; ++i) {
			if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
					&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.DYE
					&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 15 - i
					&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i
					&& e.getWorld().getBlockState(pos) == Blocks.WOOL) {
				e.getWorld().setBlockState(pos, state);
				e.getEntityPlayer().inventory.decrStackSize(e.getEntityPlayer().inventory.currentItem, 1);
			}

			else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
					&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.dye
					&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 15 - i
					&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i
					&& (e.getWorld().getBlockState(pos) == Blocks.GLASS
							|| e.getWorld().getBlockState(pos) == Blocks.STAINED_GLASS)) {
				e.getWorld().setBlockState(pos, Blocks.STAINED_GLASS.getDefaultState());
				e.getWorld().setBlockState(pos, state);
				e.getEntityPlayer().inventory.decrStackSize(e.getEntityPlayer().inventory.currentItem, 1);
			}

			else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
					&& e.getEntityPlayer().getHeldItemMainhand().getItem() == mod_lu.sponge
					&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i
					&& e.getWorld().getBlockState(pos) == Blocks.STAINED_GLASS) {
				e.getWorld().setBlockState(pos, Blocks.GLASS.getDefaultState());
				e.getEntityPlayer().inventory.getCurrentItem().damageItem(1, e.getEntityPlayer());
			}

			else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
					&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.dye
					&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 15 - i
					&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i
					&& (e.getWorld().getBlockState(pos) == Blocks.GLASS_PANE
							|| e.getWorld().getBlockState(pos) == Blocks.STAINED_GLASS_PANE)) {
				e.getWorld().setBlockState(pos, Blocks.STAINED_GLASS_PANE.getDefaultState());
				e.getWorld().setBlockState(pos, state);
				e.getEntityPlayer().inventory.decrStackSize(e.getEntityPlayer().inventory.currentItem, 1);
			}

			else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
					&& e.getEntityPlayer().getHeldItemMainhand().getItem() == mod_lu.sponge
					&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i
					&& e.getWorld().getBlockState(pos) == Blocks.STAINED_GLASS_PANE) {
				e.getWorld().setBlockState(pos, Blocks.GLASS_PANE.getDefaultState());
				e.getEntityPlayer().inventory.getCurrentItem().damageItem(1, e.getEntityPlayer());
			}

			else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
					&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.dye
					&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 15 - i
					&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i
					&& (e.getWorld().getBlockState(pos) == Blocks.HARDENED_CLAY
							|| e.getWorld().getBlockState(pos) == Blocks.STAINED_HARDENED_CLAY)) {
				e.getWorld().setBlockState(pos, Blocks.STAINED_HARDENED_CLAY.getDefaultState());
				e.getWorld().setBlockState(pos, state);
				e.getEntityPlayer().inventory.decrStackSize(e.getEntityPlayer().inventory.currentItem, 1);
			}

			else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
					&& e.getEntityPlayer().getHeldItemMainhand().getItem() == mod_lu.sponge
					&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i
					&& e.getWorld().getBlockState(pos) == Blocks.STAINED_HARDENED_CLAY) {
				e.getWorld().setBlockState(pos, Blocks.HARDENED_CLAY.getDefaultState());
				e.getEntityPlayer().inventory.getCurrentItem().damageItem(1, e.getEntityPlayer());
			}
		}

		// TODO: Condensed Usable Blocks
		if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.porkchop
				&& e.getWorld().getBlockState(pos) == mod_lu.porkBlock
				&& e.getWorld().getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlock().getMetaFromState(state) > 0) {
			int meta = e.getWorld().getBlock().getMetaFromState(state);
			e.getWorld().setBlockMetadataWithNotify(pos, meta - 1, 2);
			e.getEntityPlayer().getHeldItemMainhand().stackSize -= 1;
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.cooked_porkchop
				&& e.getWorld().getBlockState(pos) == mod_lu.cookedPorkBlock
				&& e.getWorld().getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlock().getMetaFromState(state) > 0) {
			int meta = e.getWorld().getBlock().getMetaFromState(state);
			e.getWorld().setBlockMetadataWithNotify(pos, meta - 1, 2);
			e.getEntityPlayer().getHeldItemMainhand().stackSize -= 1;
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.beef
				&& e.getWorld().getBlockState(pos) == mod_lu.beefBlock
				&& e.getWorld().getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlock().getMetaFromState(state) > 0) {
			int meta = e.getWorld().getBlock().getMetaFromState(state);
			e.getWorld().setBlockMetadataWithNotify(pos, meta - 1, 2);
			e.getEntityPlayer().getHeldItemMainhand().stackSize -= 1;
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.cooked_beef
				&& e.getWorld().getBlockState(pos) == mod_lu.cookedBeefBlock
				&& e.getWorld().getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlock().getMetaFromState(state) > 0) {
			int meta = e.getWorld().getBlock().getMetaFromState(state);
			e.getWorld().setBlockMetadataWithNotify(pos, meta - 1, 2);
			e.getEntityPlayer().getHeldItemMainhand().stackSize -= 1;
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.chicken
				&& e.getWorld().getBlockState(pos) == mod_lu.chickenBlock
				&& e.getWorld().getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlock().getMetaFromState(state) > 0) {
			int meta = e.getWorld().getBlock().getMetaFromState(state);
			e.getWorld().setBlockMetadataWithNotify(pos, meta - 1, 2);
			e.getEntityPlayer().getHeldItemMainhand().stackSize -= 1;
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.cooked_chicken
				&& e.getWorld().getBlock(pos) == mod_lu.cookedChickenBlock
				&& e.getWorld().getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlock().getMetaFromState(state) > 0) {
			int meta = e.getWorld().getBlock().getMetaFromState(state);
			e.getWorld().setBlockMetadataWithNotify(pos, meta - 1, 2);
			e.getEntityPlayer().getHeldItemMainhand().stackSize -= 1;
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.fish
				&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 0
				&& e.getWorld().getBlock(pos) == mod_lu.fishBlock
				&& e.getWorld().getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlock().getMetaFromState(state) > 0) {
			int meta = e.getWorld().getBlock().getMetaFromState(state);
			e.getWorld().setBlockMetadataWithNotify(pos, meta - 1, 2);
			e.getEntityPlayer().getHeldItemMainhand().stackSize -= 1;
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.fish
				&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 1
				&& e.getWorld().getBlock(pos) == mod_lu.salmonBlock
				&& e.getWorld().getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlock().getMetaFromState(state) > 0) {
			int meta = e.getWorld().getBlock().getMetaFromState(state);
			e.getWorld().setBlockMetadataWithNotify(pos, meta - 1, 2);
			e.getEntityPlayer().getHeldItemMainhand().stackSize -= 1;
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.fish
				&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 2
				&& e.getWorld().getBlock(pos) == mod_lu.clownfishBlock
				&& e.getWorld().getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlock().getMetaFromState(state) > 0) {
			int meta = e.getWorld().getBlock().getMetaFromState(state);
			e.getWorld().setBlockMetadataWithNotify(pos, meta - 1, 2);
			e.getEntityPlayer().getHeldItemMainhand().stackSize -= 1;
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.fish
				&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 3
				&& e.getWorld().getBlock(pos) == mod_lu.pufferfishBlock
				&& e.getWorld().getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlock().getMetaFromState(state) > 0) {
			int meta = e.getWorld().getBlock().getMetaFromState(state);
			e.getWorld().setBlockMetadataWithNotify(pos, meta - 1, 2);
			e.getEntityPlayer().getHeldItemMainhand().stackSize -= 1;
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.cooked_fished
				&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 0
				&& e.getWorld().getBlock(pos) == mod_lu.cookedFishBlock
				&& e.getWorld().getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlock().getMetaFromState(state) > 0) {
			int meta = e.getWorld().getBlock().getMetaFromState(state);
			e.getWorld().setBlockMetadataWithNotify(pos, meta - 1, 2);
			e.getEntityPlayer().getHeldItemMainhand().stackSize -= 1;
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.cooked_fished
				&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 1
				&& e.getWorld().getBlock(pos) == mod_lu.cookedSalmonBlock
				&& e.getWorld().getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlock().getMetaFromState(state) > 0) {
			int meta = e.getWorld().getBlock().getMetaFromState(state);
			e.getWorld().setBlockMetadataWithNotify(pos, meta - 1, 2);
			e.getEntityPlayer().getHeldItemMainhand().stackSize -= 1;
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.rotten_flesh
				&& e.getWorld().getBlock(pos) == mod_lu.rottenFleshBlock
				&& e.getWorld().getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlock().getMetaFromState(state) > 0) {
			int meta = e.getWorld().getBlock().getMetaFromState(state);
			e.getWorld().setBlockMetadataWithNotify(pos, meta - 1, 2);
			e.getEntityPlayer().getHeldItemMainhand().stackSize -= 1;
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.apple
				&& e.getWorld().getBlock(pos) == mod_lu.appleBlock
				&& e.getWorld().getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlock().getMetaFromState(state) > 0) {
			int meta = e.getWorld().getBlock().getMetaFromState(state);
			e.getWorld().setBlockMetadataWithNotify(pos, meta - 1, 2);
			e.getEntityPlayer().getHeldItemMainhand().stackSize -= 1;
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.bread
				&& e.getWorld().getBlock(pos) == mod_lu.breadBlock
				&& e.getWorld().getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlock().getMetaFromState(state) > 0) {
			int meta = e.getWorld().getBlock().getMetaFromState(state);
			e.getWorld().setBlockMetadataWithNotify(pos, meta - 1, 2);
			e.getEntityPlayer().getHeldItemMainhand().stackSize -= 1;
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.cookie
				&& e.getWorld().getBlock(pos) == mod_lu.cookieBlock
				&& e.getWorld().getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlock().getMetaFromState(state) > 0) {
			int meta = e.getWorld().getBlock().getMetaFromState(state);
			e.getWorld().setBlockMetadataWithNotify(pos, meta - 1, 2);
			e.getEntityPlayer().getHeldItemMainhand().stackSize -= 1;
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.spider_eye
				&& e.getWorld().getBlock(pos) == mod_lu.spiderEyeBlock
				&& e.getWorld().getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlock().getMetaFromState(state) > 0) {
			int meta = e.getWorld().getBlock().getMetaFromState(state);
			e.getWorld().setBlockMetadataWithNotify(pos, meta - 1, 2);
			e.getEntityPlayer().getHeldItemMainhand().stackSize -= 1;
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.carrot
				&& e.getWorld().getBlock(pos) == mod_lu.carrotBlock
				&& e.getWorld().getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlock().getMetaFromState(state) > 0) {
			int meta = e.getWorld().getBlock().getMetaFromState(state);
			e.getWorld().setBlockMetadataWithNotify(pos, meta - 1, 2);
			e.getEntityPlayer().getHeldItemMainhand().stackSize -= 1;
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.potato
				&& e.getWorld().getBlock(pos) == mod_lu.potatoBlock
				&& e.getWorld().getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlock().getMetaFromState(state) > 0) {
			int meta = e.getWorld().getBlock().getMetaFromState(state);
			e.getWorld().setBlockMetadataWithNotify(pos, meta - 1, 2);
			e.getEntityPlayer().getHeldItemMainhand().stackSize -= 1;
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.ender_pearl
				&& e.getWorld().getBlock(pos) == mod_lu.enderPerlBlock
				&& e.getWorld().getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlock().getMetaFromState(state) > 0) {
			int meta = e.getWorld().getBlock().getMetaFromState(state);
			e.getWorld().setBlockMetadataWithNotify(pos, meta - 1, 2);
			e.getEntityPlayer().getHeldItemMainhand().stackSize -= 1;
		}
	}
}