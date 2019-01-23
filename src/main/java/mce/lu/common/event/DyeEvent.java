package mce.lu.common.event;

import mce.lu.common.item.ModItems;
import mce.lu.common.util.config.LUConfigManager;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class DyeEvent {
	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public static void onInteractEvent(PlayerInteractEvent e) {
		BlockPos pos = e.getPos();
		IBlockState state = e.getWorld().getBlockState(pos);
		// TileEntity te = e.getWorld().getTileEntity(pos);

		// Dye a block in world.
		if (LUConfigManager.modConfig.modEvents.dyeEvent) {
			for (int i = 0; i <= 15; i++) {
				if (!e.getEntityPlayer().getHeldItemMainhand().isEmpty()
						&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.DYE
						&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 15 - i
						&& e.getWorld().getBlockState(pos).getBlock() == Blocks.WOOL
						&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i) {
					e.getWorld().setBlockState(pos, Blocks.WOOL.getBlockState().getBlock().getStateFromMeta(i));
					e.getEntityPlayer().getHeldItemMainhand().shrink(1);
				}

				else if (!e.getEntityPlayer().getHeldItemMainhand().isEmpty()
						&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.DYE
						&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 15 - i
						&& (e.getWorld().getBlockState(pos).getBlock() == Blocks.GLASS
								|| e.getWorld().getBlockState(pos).getBlock() == Blocks.STAINED_GLASS)
						&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i) {
					e.getWorld().setBlockState(pos,
							Blocks.STAINED_GLASS.getBlockState().getBlock().getStateFromMeta(i));
					e.getEntityPlayer().getHeldItemMainhand().shrink(1);
				}

				else if (!e.getEntityPlayer().getHeldItemMainhand().isEmpty()
						&& e.getEntityPlayer().getHeldItemMainhand().getItem() == ModItems.SPONGE
						&& e.getWorld().getBlockState(pos).getBlock() == Blocks.STAINED_GLASS) {
					e.getWorld().setBlockState(pos, Blocks.GLASS.getDefaultState());
				}

				else if (!e.getEntityPlayer().getHeldItemMainhand().isEmpty()
						&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.DYE
						&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 15 - i
						&& (e.getWorld().getBlockState(pos).getBlock() == Blocks.GLASS_PANE
								|| e.getWorld().getBlockState(pos).getBlock() == Blocks.STAINED_GLASS_PANE)
						&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i) {
					e.getWorld().setBlockState(pos,
							Blocks.STAINED_GLASS_PANE.getBlockState().getBlock().getStateFromMeta(i));
					e.getEntityPlayer().getHeldItemMainhand().shrink(1);
				}

				else if (!e.getEntityPlayer().getHeldItemMainhand().isEmpty()
						&& e.getEntityPlayer().getHeldItemMainhand().getItem() == ModItems.SPONGE
						&& e.getWorld().getBlockState(pos).getBlock() == Blocks.STAINED_GLASS_PANE) {
					e.getWorld().setBlockState(pos, Blocks.GLASS_PANE.getDefaultState());
				}

				else if (!e.getEntityPlayer().getHeldItemMainhand().isEmpty()
						&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.DYE
						&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 15 - i
						&& (e.getWorld().getBlockState(pos).getBlock() == Blocks.HARDENED_CLAY
								|| e.getWorld().getBlockState(pos).getBlock() == Blocks.STAINED_HARDENED_CLAY)
						&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i) {
					e.getWorld().setBlockState(pos,
							Blocks.STAINED_HARDENED_CLAY.getBlockState().getBlock().getStateFromMeta(i));
					e.getEntityPlayer().getHeldItemMainhand().shrink(1);
				}

				else if (!e.getEntityPlayer().getHeldItemMainhand().isEmpty()
						&& e.getEntityPlayer().getHeldItemMainhand().getItem() == ModItems.SPONGE
						&& e.getWorld().getBlockState(pos).getBlock() == Blocks.STAINED_HARDENED_CLAY) {
					e.getWorld().setBlockState(pos, Blocks.HARDENED_CLAY.getDefaultState());
				}

				else if (!e.getEntityPlayer().getHeldItemMainhand().isEmpty()
						&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.DYE
						&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 15 - i
						&& e.getWorld().getBlockState(pos).getBlock() == Blocks.CARPET
						&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i) {
					e.getWorld().setBlockState(pos, Blocks.CARPET.getBlockState().getBlock().getStateFromMeta(i));
					e.getEntityPlayer().getHeldItemMainhand().shrink(1);
				}

				else if (!e.getEntityPlayer().getHeldItemMainhand().isEmpty()
						&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.DYE
						&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 15 - i
						&& e.getWorld().getBlockState(pos).getBlock() == Blocks.CONCRETE
						&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i) {
					e.getWorld().setBlockState(pos, Blocks.CONCRETE.getBlockState().getBlock().getStateFromMeta(i));
					e.getEntityPlayer().getHeldItemMainhand().shrink(1);
				}

				else if (!e.getEntityPlayer().getHeldItemMainhand().isEmpty()
						&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.DYE
						&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 15 - i
						&& e.getWorld().getBlockState(pos).getBlock() == Blocks.CONCRETE_POWDER
						&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i) {
					e.getWorld().setBlockState(pos,
							Blocks.CONCRETE_POWDER.getBlockState().getBlock().getStateFromMeta(i));
					e.getEntityPlayer().getHeldItemMainhand().shrink(1);
				}

				// Color Bed, but only does 1 part, not both..
				/*
				 * else if (e.getEntityPlayer().isSneaking() &&
				 * !e.getEntityPlayer().getHeldItemMainhand().isEmpty() &&
				 * e.getEntityPlayer().getHeldItemMainhand().getItem() ==
				 * Items.DYE &&
				 * e.getEntityPlayer().getHeldItemMainhand().getItemDamage() ==
				 * 15 - i && e.getWorld().getTileEntity(pos) instanceof
				 * TileEntityBed && ((TileEntityBed)
				 * te).getColor().getMetadata() != i) {
				 * if(((TileEntityBed)te).isHeadPiece()){ ((TileEntityBed)
				 * te).setColor(EnumDyeColor.byMetadata(i)); } else {
				 * ((TileEntityBed) te).setColor(EnumDyeColor.byMetadata(i)); }
				 * e.getEntityPlayer().getHeldItemMainhand().shrink(1); }
				 */
			}
		}
	}
}
