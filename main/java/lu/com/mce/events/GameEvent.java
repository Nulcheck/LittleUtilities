package lu.com.mce.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class GameEvent {
	@SubscribeEvent
	public void setEntityOnFire(AttackEntityEvent e) {
		if (e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.blaze_rod
				&& e.target instanceof EntityLiving) {
			e.target.setFire(8);
		}
	}

	@SubscribeEvent
	public void onInteractEvent(PlayerInteractEvent e) {
		// TODO: Wool
		if (e.world.getBlock(e.x, e.y, e.z) == Blocks.wool) {
			if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 0
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 15) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 15, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 1
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 14) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 14, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 2
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 13) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 13, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 3
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 12) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 12, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 4
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 11) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 11, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 5
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 10) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 10, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 6
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 9) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 9, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 7
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 8) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 8
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 7) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 7, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 9
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 6) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 6, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 10
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 5) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 5, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 11
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 4) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 12
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 3) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 13
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 2) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 14
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 1) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 15
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 0) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}
		}

		// TODO: Glass
		else if (e.world.getBlock(e.x, e.y, e.z) == Blocks.glass
				|| e.world.getBlock(e.x, e.y, e.z) == Blocks.stained_glass) {
			if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 0
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 15) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 15, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 1
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 14) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 14, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 2
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 13) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 13, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 3
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 12) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 12, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 4
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 11) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 11, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 5
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 10) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 10, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 6
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 9) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 9, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 7
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 8) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 8
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 7) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 7, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 9
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 6) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 6, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 10
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 5) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 5, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 11
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 4) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 12
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 3) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 13
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 2) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 14
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 1) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 15
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 0) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 15
					&& e.world.getBlock(e.x, e.y, e.z) == Blocks.glass) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.water_bucket
					&& e.world.getBlock(e.x, e.y, e.z) == Blocks.stained_glass) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.glass);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
				e.entityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.bucket, 1));
			}
		}

		// TODO: Glass Panes
		else if (e.world.getBlock(e.x, e.y, e.z) == Blocks.glass_pane
				|| e.world.getBlock(e.x, e.y, e.z) == Blocks.stained_glass_pane) {
			if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 0
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 15) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 15, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 1
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 14) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 14, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 2
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 13) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 13, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 3
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 12) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 12, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 4
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 11) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 11, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 5
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 10) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 10, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 6
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 9) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 9, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 7
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 8) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 8
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 7) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 7, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 9
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 6) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 6, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 10
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 5) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 5, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 11
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 4) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 12
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 3) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 13
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 2) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 14
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 1) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 15
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 0) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 15
					&& e.world.getBlock(e.x, e.y, e.z) == Blocks.glass_pane) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.water_bucket
					&& e.world.getBlock(e.x, e.y, e.z) == Blocks.stained_glass_pane) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.glass_pane);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
				e.entityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.bucket, 1));
			}
		}

		// TODO: Hardened Clay
		else if (e.world.getBlock(e.x, e.y, e.z) == Blocks.hardened_clay
				|| e.world.getBlock(e.x, e.y, e.z) == Blocks.stained_hardened_clay) {
			if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 0
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 15) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 15, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 1
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 14) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 14, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 2
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 13) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 13, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 3
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 12) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 12, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 4
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 11) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 11, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 5
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 10) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 10, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 6
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 9) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 9, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 7
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 8) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 8
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 7) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 7, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 9
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 6) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 6, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 10
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 5) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 5, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 11
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 4) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 12
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 3) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 13
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 2) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 14
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 1) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 15
					&& e.world.getBlockMetadata(e.x, e.y, e.z) != 0) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 15
					&& e.world.getBlock(e.x, e.y, e.z) == Blocks.hardened_clay) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.water_bucket
					&& e.world.getBlock(e.x, e.y, e.z) == Blocks.stained_hardened_clay) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.hardened_clay);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.getHeldItem().stackSize--;
				e.entityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.bucket, 1));
			}
		}
	}
}