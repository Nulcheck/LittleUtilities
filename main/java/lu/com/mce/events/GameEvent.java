package lu.com.mce.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import lu.com.mce.common.mod_lu;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class GameEvent {
	@SubscribeEvent
	public void setEntityOnFire(AttackEntityEvent e) {
		if (e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.blaze_rod && e.target instanceof EntityLiving) {
			e.target.setFire(8);
		}
	}

	@SubscribeEvent
	public void onInteractEvent(PlayerInteractEvent e) {
		// Dye a block in world.
		for (int i = 0; i <= 15; ++i) {
			if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.dye && e.entityPlayer.getHeldItem().getItemDamage() == 15 - i
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != i && e.world.getBlock(e.x, e.y, e.z) == Blocks.wool) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, i, 2);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 15 - i && e.world.getBlockMetadata(e.x, e.y, e.z) != i
					&& (e.world.getBlock(e.x, e.y, e.z) == Blocks.glass || e.world.getBlock(e.x, e.y, e.z) == Blocks.stained_glass)) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, i, 2);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == mod_lu.sponge && e.world.getBlockMetadata(e.x, e.y, e.z) != i
					&& e.world.getBlock(e.x, e.y, e.z) == Blocks.stained_glass) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.glass, 0, 2);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 15 - i && e.world.getBlockMetadata(e.x, e.y, e.z) != i
					&& (e.world.getBlock(e.x, e.y, e.z) == Blocks.glass_pane || e.world.getBlock(e.x, e.y, e.z) == Blocks.stained_glass_pane)) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, i, 2);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == mod_lu.sponge && e.world.getBlockMetadata(e.x, e.y, e.z) != i
					&& e.world.getBlock(e.x, e.y, e.z) == Blocks.stained_glass_pane) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.glass_pane, 0, 2);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 15 - i && e.world.getBlockMetadata(e.x, e.y, e.z) != i
					&& (e.world.getBlock(e.x, e.y, e.z) == Blocks.hardened_clay || e.world.getBlock(e.x, e.y, e.z) == Blocks.stained_hardened_clay)) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, i, 2);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == mod_lu.sponge && e.world.getBlockMetadata(e.x, e.y, e.z) != i
					&& e.world.getBlock(e.x, e.y, e.z) == Blocks.stained_hardened_clay) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.hardened_clay, 0, 2);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}
		}

		// TODO: Condensed Usable Blocks
		if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.porkchop && e.world.getBlock(e.x, e.y, e.z) == mod_lu.porkBlock
				&& e.world.getBlockMetadata(e.x, e.y, e.z) < 9 && e.world.getBlockMetadata(e.x, e.y, e.z) > 0) {
			int meta = e.world.getBlockMetadata(e.x, e.y, e.z);
			e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta - 1, 2);
			e.world.markBlockForUpdate(e.x, e.y, e.z);
			e.entityPlayer.getHeldItem().stackSize -= 1;
		}

		else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.cooked_porkchop
				&& e.world.getBlock(e.x, e.y, e.z) == mod_lu.cookedPorkBlock && e.world.getBlockMetadata(e.x, e.y, e.z) < 9 && e.world.getBlockMetadata(e.x, e.y, e.z) > 0) {
			int meta = e.world.getBlockMetadata(e.x, e.y, e.z);
			e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta - 1, 2);
			e.world.markBlockForUpdate(e.x, e.y, e.z);
			e.entityPlayer.getHeldItem().stackSize -= 1;
		}

		else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.beef && e.world.getBlock(e.x, e.y, e.z) == mod_lu.beefBlock
				&& e.world.getBlockMetadata(e.x, e.y, e.z) < 9 && e.world.getBlockMetadata(e.x, e.y, e.z) > 0) {
			int meta = e.world.getBlockMetadata(e.x, e.y, e.z);
			e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta - 1, 2);
			e.world.markBlockForUpdate(e.x, e.y, e.z);
			e.entityPlayer.getHeldItem().stackSize -= 1;
		}

		else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.cooked_beef
				&& e.world.getBlock(e.x, e.y, e.z) == mod_lu.cookedBeefBlock && e.world.getBlockMetadata(e.x, e.y, e.z) < 9 && e.world.getBlockMetadata(e.x, e.y, e.z) > 0) {
			int meta = e.world.getBlockMetadata(e.x, e.y, e.z);
			e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta - 1, 2);
			e.world.markBlockForUpdate(e.x, e.y, e.z);
			e.entityPlayer.getHeldItem().stackSize -= 1;
		}

		else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.chicken
				&& e.world.getBlock(e.x, e.y, e.z) == mod_lu.chickenBlock && e.world.getBlockMetadata(e.x, e.y, e.z) < 9 && e.world.getBlockMetadata(e.x, e.y, e.z) > 0) {
			int meta = e.world.getBlockMetadata(e.x, e.y, e.z);
			e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta - 1, 2);
			e.world.markBlockForUpdate(e.x, e.y, e.z);
			e.entityPlayer.getHeldItem().stackSize -= 1;
		}

		else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.cooked_chicken
				&& e.world.getBlock(e.x, e.y, e.z) == mod_lu.cookedChickenBlock && e.world.getBlockMetadata(e.x, e.y, e.z) < 9 && e.world.getBlockMetadata(e.x, e.y, e.z) > 0) {
			int meta = e.world.getBlockMetadata(e.x, e.y, e.z);
			e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta - 1, 2);
			e.world.markBlockForUpdate(e.x, e.y, e.z);
			e.entityPlayer.getHeldItem().stackSize -= 1;
		}

		else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.fish && e.entityPlayer.getHeldItem().getItemDamage() == 0
				&& e.world.getBlock(e.x, e.y, e.z) == mod_lu.fishBlock && e.world.getBlockMetadata(e.x, e.y, e.z) < 9 && e.world.getBlockMetadata(e.x, e.y, e.z) > 0) {
			int meta = e.world.getBlockMetadata(e.x, e.y, e.z);
			e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta - 1, 2);
			e.world.markBlockForUpdate(e.x, e.y, e.z);
			e.entityPlayer.getHeldItem().stackSize -= 1;
		}

		else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.fish && e.entityPlayer.getHeldItem().getItemDamage() == 1
				&& e.world.getBlock(e.x, e.y, e.z) == mod_lu.salmonBlock && e.world.getBlockMetadata(e.x, e.y, e.z) < 9 && e.world.getBlockMetadata(e.x, e.y, e.z) > 0) {
			int meta = e.world.getBlockMetadata(e.x, e.y, e.z);
			e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta - 1, 2);
			e.world.markBlockForUpdate(e.x, e.y, e.z);
			e.entityPlayer.getHeldItem().stackSize -= 1;
		}

		else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.fish && e.entityPlayer.getHeldItem().getItemDamage() == 2
				&& e.world.getBlock(e.x, e.y, e.z) == mod_lu.clownfishBlock && e.world.getBlockMetadata(e.x, e.y, e.z) < 9 && e.world.getBlockMetadata(e.x, e.y, e.z) > 0) {
			int meta = e.world.getBlockMetadata(e.x, e.y, e.z);
			e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta - 1, 2);
			e.world.markBlockForUpdate(e.x, e.y, e.z);
			e.entityPlayer.getHeldItem().stackSize -= 1;
		}

		else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.fish && e.entityPlayer.getHeldItem().getItemDamage() == 3
				&& e.world.getBlock(e.x, e.y, e.z) == mod_lu.pufferfishBlock && e.world.getBlockMetadata(e.x, e.y, e.z) < 9 && e.world.getBlockMetadata(e.x, e.y, e.z) > 0) {
			int meta = e.world.getBlockMetadata(e.x, e.y, e.z);
			e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta - 1, 2);
			e.world.markBlockForUpdate(e.x, e.y, e.z);
			e.entityPlayer.getHeldItem().stackSize -= 1;
		}

		else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.cooked_fished
				&& e.entityPlayer.getHeldItem().getItemDamage() == 0 && e.world.getBlock(e.x, e.y, e.z) == mod_lu.cookedFishBlock && e.world.getBlockMetadata(e.x, e.y, e.z) < 9
				&& e.world.getBlockMetadata(e.x, e.y, e.z) > 0) {
			int meta = e.world.getBlockMetadata(e.x, e.y, e.z);
			e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta - 1, 2);
			e.world.markBlockForUpdate(e.x, e.y, e.z);
			e.entityPlayer.getHeldItem().stackSize -= 1;
		}

		else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.cooked_fished
				&& e.entityPlayer.getHeldItem().getItemDamage() == 1 && e.world.getBlock(e.x, e.y, e.z) == mod_lu.cookedSalmonBlock && e.world.getBlockMetadata(e.x, e.y, e.z) < 9
				&& e.world.getBlockMetadata(e.x, e.y, e.z) > 0) {
			int meta = e.world.getBlockMetadata(e.x, e.y, e.z);
			e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta - 1, 2);
			e.world.markBlockForUpdate(e.x, e.y, e.z);
			e.entityPlayer.getHeldItem().stackSize -= 1;
		}

		else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.rotten_flesh
				&& e.world.getBlock(e.x, e.y, e.z) == mod_lu.rottenFleshBlock && e.world.getBlockMetadata(e.x, e.y, e.z) < 9 && e.world.getBlockMetadata(e.x, e.y, e.z) > 0) {
			int meta = e.world.getBlockMetadata(e.x, e.y, e.z);
			e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta - 1, 2);
			e.world.markBlockForUpdate(e.x, e.y, e.z);
			e.entityPlayer.getHeldItem().stackSize -= 1;
		}

		else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.apple && e.world.getBlock(e.x, e.y, e.z) == mod_lu.appleBlock
				&& e.world.getBlockMetadata(e.x, e.y, e.z) < 9 && e.world.getBlockMetadata(e.x, e.y, e.z) > 0) {
			int meta = e.world.getBlockMetadata(e.x, e.y, e.z);
			e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta - 1, 2);
			e.world.markBlockForUpdate(e.x, e.y, e.z);
			e.entityPlayer.getHeldItem().stackSize -= 1;
		}

		else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.bread && e.world.getBlock(e.x, e.y, e.z) == mod_lu.breadBlock
				&& e.world.getBlockMetadata(e.x, e.y, e.z) < 9 && e.world.getBlockMetadata(e.x, e.y, e.z) > 0) {
			int meta = e.world.getBlockMetadata(e.x, e.y, e.z);
			e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta - 1, 2);
			e.world.markBlockForUpdate(e.x, e.y, e.z);
			e.entityPlayer.getHeldItem().stackSize -= 1;
		}

		else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.cookie && e.world.getBlock(e.x, e.y, e.z) == mod_lu.cookieBlock
				&& e.world.getBlockMetadata(e.x, e.y, e.z) < 9 && e.world.getBlockMetadata(e.x, e.y, e.z) > 0) {
			int meta = e.world.getBlockMetadata(e.x, e.y, e.z);
			e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta - 1, 2);
			e.world.markBlockForUpdate(e.x, e.y, e.z);
			e.entityPlayer.getHeldItem().stackSize -= 1;
		}

		else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.spider_eye
				&& e.world.getBlock(e.x, e.y, e.z) == mod_lu.spiderEyeBlock && e.world.getBlockMetadata(e.x, e.y, e.z) < 9 && e.world.getBlockMetadata(e.x, e.y, e.z) > 0) {
			int meta = e.world.getBlockMetadata(e.x, e.y, e.z);
			e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta - 1, 2);
			e.world.markBlockForUpdate(e.x, e.y, e.z);
			e.entityPlayer.getHeldItem().stackSize -= 1;
		}

		else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.carrot && e.world.getBlock(e.x, e.y, e.z) == mod_lu.carrotBlock
				&& e.world.getBlockMetadata(e.x, e.y, e.z) < 9 && e.world.getBlockMetadata(e.x, e.y, e.z) > 0) {
			int meta = e.world.getBlockMetadata(e.x, e.y, e.z);
			e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta - 1, 2);
			e.world.markBlockForUpdate(e.x, e.y, e.z);
			e.entityPlayer.getHeldItem().stackSize -= 1;
		}

		else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.potato && e.world.getBlock(e.x, e.y, e.z) == mod_lu.potatoBlock
				&& e.world.getBlockMetadata(e.x, e.y, e.z) < 9 && e.world.getBlockMetadata(e.x, e.y, e.z) > 0) {
			int meta = e.world.getBlockMetadata(e.x, e.y, e.z);
			e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta - 1, 2);
			e.world.markBlockForUpdate(e.x, e.y, e.z);
			e.entityPlayer.getHeldItem().stackSize -= 1;
		}

		else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.ender_pearl
				&& e.world.getBlock(e.x, e.y, e.z) == mod_lu.enderPerlBlock && e.world.getBlockMetadata(e.x, e.y, e.z) < 9 && e.world.getBlockMetadata(e.x, e.y, e.z) > 0) {
			int meta = e.world.getBlockMetadata(e.x, e.y, e.z);
			e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta - 1, 2);
			e.world.markBlockForUpdate(e.x, e.y, e.z);
			e.entityPlayer.getHeldItem().stackSize -= 1;
		}
	}
}