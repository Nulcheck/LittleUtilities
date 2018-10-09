package lu.com.mce.events;

import lu.com.mce.objects.InitBlocks;
import lu.com.mce.objects.InitItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GameEvent {
	TileEntity te;

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
		IBlockState state = e.getWorld().getBlockState(pos);
		te = e.getWorld().getTileEntity(pos);

		// Dye a block in world.
		for (int i = 0; i <= 15; i++) {
			if (e.getEntityPlayer().getHeldItemMainhand() != null
					&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.DYE
					&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 15 - i
					&& e.getWorld().getBlockState(pos).getBlock() == Blocks.WOOL
					&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i) {
				e.getWorld().setBlockState(pos, Blocks.WOOL.getBlockState().getBlock().getStateFromMeta(i));
				e.getEntityPlayer().getHeldItemMainhand().shrink(1);
			}

			else if (e.getEntityPlayer().getHeldItemMainhand() != null
					&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.DYE
					&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 15 - i
					&& (e.getWorld().getBlockState(pos).getBlock() == Blocks.GLASS
							|| e.getWorld().getBlockState(pos).getBlock() == Blocks.STAINED_GLASS)
					&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i) {
				e.getWorld().setBlockState(pos, Blocks.STAINED_GLASS.getBlockState().getBlock().getStateFromMeta(i));
				e.getEntityPlayer().getHeldItemMainhand().shrink(1);
			}

			else if (e.getEntityPlayer().getHeldItemMainhand() != null
					&& e.getEntityPlayer().getHeldItemMainhand().getItem() == InitItems.SPONGE
					&& e.getWorld().getBlockState(pos).getBlock() == Blocks.STAINED_GLASS) {
				e.getWorld().setBlockState(pos, Blocks.GLASS.getDefaultState());
			}

			else if (e.getEntityPlayer().getHeldItemMainhand() != null
					&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.DYE
					&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 15 - i
					&& (e.getWorld().getBlockState(pos).getBlock() == Blocks.GLASS_PANE
							|| e.getWorld().getBlockState(pos).getBlock() == Blocks.STAINED_GLASS_PANE)
					&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i) {
				e.getWorld().setBlockState(pos,
						Blocks.STAINED_GLASS_PANE.getBlockState().getBlock().getStateFromMeta(i));
				e.getEntityPlayer().getHeldItemMainhand().shrink(1);
			}

			else if (e.getEntityPlayer().getHeldItemMainhand() != null
					&& e.getEntityPlayer().getHeldItemMainhand().getItem() == InitItems.SPONGE
					&& e.getWorld().getBlockState(pos).getBlock() == Blocks.STAINED_GLASS_PANE) {
				e.getWorld().setBlockState(pos, Blocks.GLASS_PANE.getDefaultState());
			}

			else if (e.getEntityPlayer().getHeldItemMainhand() != null
					&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.DYE
					&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 15 - i
					&& (e.getWorld().getBlockState(pos).getBlock() == Blocks.HARDENED_CLAY
							|| e.getWorld().getBlockState(pos).getBlock() == Blocks.STAINED_HARDENED_CLAY)
					&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i) {
				e.getWorld().setBlockState(pos,
						Blocks.STAINED_HARDENED_CLAY.getBlockState().getBlock().getStateFromMeta(i));
				e.getEntityPlayer().getHeldItemMainhand().shrink(1);
			}

			else if (e.getEntityPlayer().getHeldItemMainhand() != null
					&& e.getEntityPlayer().getHeldItemMainhand().getItem() == InitItems.SPONGE
					&& e.getWorld().getBlockState(pos).getBlock() == Blocks.STAINED_HARDENED_CLAY) {
				e.getWorld().setBlockState(pos, Blocks.HARDENED_CLAY.getDefaultState());
			}

			else if (e.getEntityPlayer().getHeldItemMainhand() != null
					&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.DYE
					&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 15 - i
					&& e.getWorld().getBlockState(pos).getBlock() == Blocks.CARPET
					&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i) {
				e.getWorld().setBlockState(pos, Blocks.CARPET.getBlockState().getBlock().getStateFromMeta(i));
				e.getEntityPlayer().getHeldItemMainhand().shrink(1);
			}

			else if (e.getEntityPlayer().getHeldItemMainhand() != null
					&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.DYE
					&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 15 - i
					&& e.getWorld().getBlockState(pos).getBlock() == Blocks.CONCRETE
					&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i) {
				e.getWorld().setBlockState(pos, Blocks.CONCRETE.getBlockState().getBlock().getStateFromMeta(i));
				e.getEntityPlayer().getHeldItemMainhand().shrink(1);
			}

			else if (e.getEntityPlayer().getHeldItemMainhand() != null
					&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.DYE
					&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 15 - i
					&& e.getWorld().getBlockState(pos).getBlock() == Blocks.CONCRETE_POWDER
					&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) != i) {
				e.getWorld().setBlockState(pos, Blocks.CONCRETE_POWDER.getBlockState().getBlock().getStateFromMeta(i));
				e.getEntityPlayer().getHeldItemMainhand().shrink(1);
			}

			// Color Bed, but only does 1 part, not both..
			/*
			 * else if (e.getEntityPlayer().isSneaking() &&
			 * e.getEntityPlayer().getHeldItemMainhand() != null &&
			 * e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.DYE
			 * && e.getEntityPlayer().getHeldItemMainhand().getItemDamage() ==
			 * 15 - i && e.getWorld().getTileEntity(pos) instanceof
			 * TileEntityBed && ((TileEntityBed) te).getColor().getMetadata() !=
			 * i) { if(((TileEntityBed)te).isHeadPiece()){ ((TileEntityBed)
			 * te).setColor(EnumDyeColor.byMetadata(i)); } else {
			 * ((TileEntityBed) te).setColor(EnumDyeColor.byMetadata(i)); }
			 * e.getEntityPlayer().getHeldItemMainhand().shrink(1); }
			 */
		}

		// Condensed Usable Blocks
		if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.PORKCHOP
				&& e.getWorld().getBlockState(pos).getBlock() == InitBlocks.PORK_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.COOKED_PORKCHOP
				&& e.getWorld().getBlockState(pos).getBlock() == InitBlocks.COOKED_PORK_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.BEEF
				&& e.getWorld().getBlockState(pos).getBlock() == InitBlocks.BEEF_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.COOKED_BEEF
				&& e.getWorld().getBlockState(pos).getBlock() == InitBlocks.COOKED_BEEF_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.CHICKEN
				&& e.getWorld().getBlockState(pos).getBlock() == InitBlocks.CHICKEN_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.COOKED_CHICKEN
				&& e.getWorld().getBlockState(pos).getBlock() == InitBlocks.COOKED_CHICKEN_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.FISH
				&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 0
				&& e.getWorld().getBlockState(pos).getBlock() == InitBlocks.COD_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.FISH
				&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 1
				&& e.getWorld().getBlockState(pos).getBlock() == InitBlocks.SALMON_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.FISH
				&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 2
				&& e.getWorld().getBlockState(pos).getBlock() == InitBlocks.TROPICAL_FISH_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.FISH
				&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 3
				&& e.getWorld().getBlockState(pos).getBlock() == InitBlocks.PUFFERFISH_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.COOKED_FISH
				&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 0
				&& e.getWorld().getBlockState(pos).getBlock() == InitBlocks.COOKED_COD_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.COOKED_FISH
				&& e.getEntityPlayer().getHeldItemMainhand().getItemDamage() == 1
				&& e.getWorld().getBlockState(pos).getBlock() == InitBlocks.COOKED_SALMON_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.ROTTEN_FLESH
				&& e.getWorld().getBlockState(pos).getBlock() == InitBlocks.ROTTEN_FLESH_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.APPLE
				&& e.getWorld().getBlockState(pos).getBlock() == InitBlocks.APPLE_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.BREAD
				&& e.getWorld().getBlockState(pos).getBlock() == InitBlocks.BREAD_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.COOKIE
				&& e.getWorld().getBlockState(pos).getBlock() == InitBlocks.COOKIE_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.SPIDER_EYE
				&& e.getWorld().getBlockState(pos).getBlock() == InitBlocks.SPIDER_EYE_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.CARROT
				&& e.getWorld().getBlockState(pos).getBlock() == InitBlocks.CARROT_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.POTATO
				&& e.getWorld().getBlockState(pos).getBlock() == InitBlocks.POTATO_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.BAKED_POTATO
				&& e.getWorld().getBlockState(pos).getBlock() == InitBlocks.BAKED_POTATO_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}

		else if (e.getEntityPlayer().isSneaking() && e.getEntityPlayer().getHeldItemMainhand() != null
				&& e.getEntityPlayer().getHeldItemMainhand().getItem() == Items.ENDER_PEARL
				&& e.getWorld().getBlockState(pos).getBlock() == InitBlocks.ENDER_PEARL_BLOCK
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) < 9
				&& e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) > 0) {
			e.getWorld().setBlockState(pos, e.getWorld().getBlockState(pos).getBlock()
					.getStateFromMeta(e.getWorld().getBlockState(pos).getBlock().getMetaFromState(state) - 1));
			e.getEntityPlayer().getHeldItemMainhand().shrink(1);
		}
	}
}