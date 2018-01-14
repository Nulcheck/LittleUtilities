package lu.com.mce.events;

import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.BlockPos;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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
		BlockPos pos = new BlockPos(e.pos);
		// TODO: Wool
		if (e.world.getBlockState(pos).getBlock() == Blocks.wool) {
			if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 0 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.BLACK)) {
				e.world.setBlockState(pos, Blocks.wool.getDefaultState(), 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			/*else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 1 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.RED)) {
				e.world.setBlockMetadataWithNotify(pos, 14, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 2 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.GREEN)) {
				e.world.setBlockMetadataWithNotify(pos, 13, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 3 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.BROWN)) {
				e.world.setBlockMetadataWithNotify(pos, 12, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 4 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.BLUE)) {
				e.world.setBlockMetadataWithNotify(pos, 11, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 5 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.PURPLE)) {
				e.world.setBlockMetadataWithNotify(pos, 10, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 6 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.CYAN)) {
				e.world.setBlockMetadataWithNotify(pos, 9, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 7 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.SILVER)) {
				e.world.setBlockMetadataWithNotify(pos, 8, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 8 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.GRAY)) {
				e.world.setBlockMetadataWithNotify(pos, 7, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 9 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.PINK)) {
				e.world.setBlockMetadataWithNotify(pos, 6, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 10 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.LIME)) {
				e.world.setBlockMetadataWithNotify(pos, 5, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 11 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.YELLOW)) {
				e.world.setBlockMetadataWithNotify(pos, 4, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 12 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.LIGHT_BLUE)) {
				e.world.setBlockMetadataWithNotify(pos, 3, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 13 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.MAGENTA)) {
				e.world.setBlockMetadataWithNotify(pos, 2, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 14 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.ORANGE)) {
				e.world.setBlockMetadataWithNotify(pos, 1, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 15 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.WHITE)) {
				e.world.setBlockMetadataWithNotify(pos, 0, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}
		}

		// TODO: Glass
		else if (e.world.getBlockState(pos) == Blocks.glass || e.world.getBlockState(pos) == Blocks.stained_glass) {
			if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 0 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(pos, 15, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 1 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(pos, 14, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 2 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(pos, 13, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 3 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(pos, 12, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 4 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(pos, 11, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 5 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(pos, 10, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 6 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(pos, 9, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 7 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(pos, 8, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 8 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(pos, 7, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 9 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(pos, 6, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 10 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(pos, 5, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 11 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(pos, 4, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 12 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(pos, 3, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 13 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(pos, 2, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 14 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(pos, 1, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 15 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(pos, 0, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 15
					&& e.world.getBlockState(pos) == Blocks.glass) {
				e.world.setBlock(pos, Blocks.stained_glass);
				e.world.setBlockMetadataWithNotify(pos, 0, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.water_bucket
					&& e.world.getBlockState(pos) == Blocks.stained_glass) {
				e.world.setBlock(pos, Blocks.glass);
				e.world.setBlockMetadataWithNotify(pos, 0, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
				e.entityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.bucket, 1));
			}
		}

		// TODO: Glass Panes
		else if (e.world.getBlockState(pos) == Blocks.glass_pane
				|| e.world.getBlockState(pos) == Blocks.stained_glass_pane) {
			if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 0 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(pos, 15, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 1 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(pos, 14, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 2 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(pos, 13, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 3 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(pos, 12, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 4 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(pos, 11, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 5 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(pos, 10, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 6 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(pos, 9, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 7 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(pos, 8, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 8 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(pos, 7, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 9 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(pos, 6, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 10 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(pos, 5, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 11 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(pos, 4, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 12 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(pos, 3, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 13 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(pos, 2, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 14 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(pos, 1, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 15 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(pos, 0, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 15
					&& e.world.getBlockState(pos) == Blocks.glass_pane) {
				e.world.setBlock(pos, Blocks.stained_glass_pane);
				e.world.setBlockMetadataWithNotify(pos, 0, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.water_bucket
					&& e.world.getBlockState(pos) == Blocks.stained_glass_pane) {
				e.world.setBlock(pos, Blocks.glass_pane);
				e.world.setBlockMetadataWithNotify(pos, 0, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
				e.entityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.bucket, 1));
			}
		}

		// TODO: Hardened Clay
		else if (e.world.getBlockState(pos) == Blocks.hardened_clay
				|| e.world.getBlockState(pos) == Blocks.stained_hardened_clay) {
			if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 0 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(pos, 15, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 1 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(pos, 14, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 2 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(pos, 13, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 3 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(pos, 12, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 4 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(pos, 11, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 5 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(pos, 10, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 6 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(pos, 9, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 7 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(pos, 8, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 8 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(pos, 7, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 9 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(pos, 6, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 10 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(pos, 5, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 11 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(pos, 4, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 12 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(pos, 3, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 13 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(pos, 2, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 14 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(pos, 1, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 15 && e.world.getBlockState(pos).getProperties().containsValue(EnumDyeColor.)) {
				e.world.setBlock(pos, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(pos, 0, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.dye
					&& e.entityPlayer.getHeldItem().getItemDamage() == 15
					&& e.world.getBlockState(pos) == Blocks.hardened_clay) {
				e.world.setBlock(pos, Blocks.stained_hardened_clay);
				e.world.setBlockMetadataWithNotify(pos, 0, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
			}

			else if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == Items.water_bucket
					&& e.world.getBlockState(pos) == Blocks.stained_hardened_clay) {
				e.world.setBlock(pos, Blocks.hardened_clay);
				e.world.setBlockMetadataWithNotify(pos, 0, 1);
				e.world.markBlockForUpdate(pos);
				e.entityPlayer.getHeldItem().stackSize--;
				e.entityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.bucket, 1));
			}*/
		}
	}
}