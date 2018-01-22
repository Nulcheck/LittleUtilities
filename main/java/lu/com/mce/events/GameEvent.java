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
		for(int i = 0; i <= 9; ++i){
			if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.porkchop && e.world.getBlock(e.x, e.y, e.z) == mod_lu.porkBlock
					&& e.world.getBlockMetadata(e.x, e.y, e.z) < 9) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, i - 1, 2);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize -= 1;
			}
		}
	}
}