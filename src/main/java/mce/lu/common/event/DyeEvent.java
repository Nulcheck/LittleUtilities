package mce.lu.common.event;

import mce.lu.common.entity.passive.EntityChromaCow;
import mce.lu.common.item.ModItems;
import mce.lu.common.util.config.LUConfigManager;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteractSpecific;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.xendric.xenlib.common.util.EnumDyeColorHelper;
import net.xendric.xenlib.common.util.Util;

@EventBusSubscriber
public class DyeEvent {
	@SubscribeEvent
	public static void onEntityInteractEvent(EntityInteractSpecific e) {
		ItemStack heldItem = e.getEntityPlayer().getHeldItemMainhand();

		if (!e.getWorld().isRemote) {
			if (e.getHand().equals(EnumHand.MAIN_HAND) && !heldItem.isEmpty()) {
				// Loop through dye colors
				for (int i = 0; i < 16; ++i) {
					for (ItemStack stack : OreDictionary.getOres("dye" + Util.dyes[15 - i])) {
						if (heldItem.getItem() == stack.getItem()) {
							if (heldItem.getItem().getHasSubtypes()) {
								if (heldItem.getItemDamage() == 15 - i)
									dyeEntities(e);
							} else
								dyeEntities(e);
						}
					}
				}
			}
		}
	}

	public static void dyeEntities(EntityInteractSpecific e) {
		if (!e.getWorld().isRemote) {
			ItemStack heldItem = e.getEntityPlayer().getHeldItemMainhand();
			EnumDyeColor color = EnumDyeColorHelper.byOreDictDyeName(heldItem);

			// Doggo
			if (e.getTarget() instanceof EntityWolf && color != ((EntityWolf) e.getTarget()).getCollarColor()) {
				((EntityWolf) e.getTarget()).setCollarColor(color);

				if (!e.getEntityPlayer().isCreative())
					heldItem.shrink(1);
			}

			// Sheep
			if (e.getTarget() instanceof EntitySheep && color != ((EntitySheep) e.getTarget()).getFleeceColor()
					&& !((EntitySheep) e.getTarget()).getSheared()) {
				((EntitySheep) e.getTarget()).setFleeceColor(color);

				if (!e.getEntityPlayer().isCreative())
					heldItem.shrink(1);
			}

			// Cow into Chroma Cow
			if (e.getTarget() instanceof EntityCow && !(e.getTarget() instanceof EntityChromaCow)) {
				EntityChromaCow cow = new EntityChromaCow(e.getWorld());
				e.getTarget().getEntityWorld().setEntityState(e.getTarget(), (byte) 16);

				cow.copyLocationAndAnglesFrom(e.getTarget());
				cow.onInitialSpawn(e.getWorld().getDifficultyForLocation(new BlockPos(cow)), (IEntityLivingData) null);
				cow.setHealth(((EntityCow) e.getTarget()).getHealth());
				cow.renderYawOffset = ((EntityCow) e.getTarget()).renderYawOffset;
				cow.setHideColor(color);

				// Remove vanilla cow
				e.getWorld().removeEntity(e.getTarget());
				cow.setNoAI(((EntityLiving) e.getTarget()).isAIDisabled());

				if (((EntityLivingBase) e.getTarget()).isChild())
					cow.setGrowingAge(-24000);

				// Set custom name if it had one
				if (e.getTarget().hasCustomName()) {
					cow.setCustomNameTag(e.getTarget().getCustomNameTag());
					cow.setAlwaysRenderNameTag(e.getTarget().getAlwaysRenderNameTag());
				}

				// Spawn chroma cow
				e.getWorld().spawnEntity(cow);

				if (!e.getEntityPlayer().isCreative())
					heldItem.shrink(1);
			}

			// Chroma Cow
			if (e.getTarget() instanceof EntityChromaCow && color != ((EntityChromaCow) e.getTarget()).getHideColor()) {
				((EntityChromaCow) e.getTarget()).setHideColor(color);

				if (!e.getEntityPlayer().isCreative())
					heldItem.shrink(1);
			}
		}
	}

	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public static void onBlockInteractEvent(RightClickBlock e) {
		BlockPos pos = e.getPos();
		IBlockState state = e.getWorld().getBlockState(pos);
		ItemStack heldItem = e.getEntityPlayer().getHeldItemMainhand();
		Block block = e.getWorld().getBlockState(pos).getBlock();

		// Dye a block in world.
		if (LUConfigManager.modConfig.modEvents.dyeEvent) {
			for (int i = 0; i < 16; ++i) {
				for (ItemStack stack : OreDictionary.getOres("dye" + Util.dyes[15 - i])) {
					if (!heldItem.isEmpty() && heldItem.getItem() == stack.getItem() && block == Blocks.WOOL
							&& block.getMetaFromState(state) != i) {
						if (heldItem.getItem().getHasSubtypes()) {
							if (heldItem.getItemDamage() == 15 - i) {
								e.getWorld().setBlockState(pos,
										Blocks.WOOL.getBlockState().getBlock().getStateFromMeta(i));
								if (!e.getEntityPlayer().isCreative())
									heldItem.shrink(1);
							}
						} else {
							e.getWorld().setBlockState(pos, Blocks.WOOL.getBlockState().getBlock().getStateFromMeta(i));
							if (!e.getEntityPlayer().isCreative())
								heldItem.shrink(1);
						}
					}

					else if (!heldItem.isEmpty() && heldItem.getItem() == stack.getItem()
							&& (block == Blocks.GLASS || block == Blocks.STAINED_GLASS)
							&& block.getMetaFromState(state) != i) {
						if (heldItem.getItem().getHasSubtypes()) {
							if (heldItem.getItemDamage() == 15 - i) {
								e.getWorld().setBlockState(pos,
										Blocks.STAINED_GLASS.getBlockState().getBlock().getStateFromMeta(i));
								if (!e.getEntityPlayer().isCreative())
									heldItem.shrink(1);
							}
						} else {
							e.getWorld().setBlockState(pos,
									Blocks.STAINED_GLASS.getBlockState().getBlock().getStateFromMeta(i));
							if (!e.getEntityPlayer().isCreative())
								heldItem.shrink(1);
						}
					}

					else if (!heldItem.isEmpty() && heldItem.getItem() == ModItems.SPONGE
							&& block == Blocks.STAINED_GLASS) {
						e.getWorld().setBlockState(pos, Blocks.GLASS.getDefaultState());
					}

					else if (!heldItem.isEmpty() && heldItem.getItem() == stack.getItem()
							&& (block == Blocks.GLASS_PANE || block == Blocks.STAINED_GLASS_PANE)
							&& block.getMetaFromState(state) != i) {
						if (heldItem.getItem().getHasSubtypes()) {
							if (heldItem.getItemDamage() == 15 - i) {
								e.getWorld().setBlockState(pos,
										Blocks.STAINED_GLASS_PANE.getBlockState().getBlock().getStateFromMeta(i));
								if (!e.getEntityPlayer().isCreative())
									heldItem.shrink(1);
							}
						} else {
							e.getWorld().setBlockState(pos,
									Blocks.STAINED_GLASS_PANE.getBlockState().getBlock().getStateFromMeta(i));
							if (!e.getEntityPlayer().isCreative())
								heldItem.shrink(1);
						}
					}

					else if (!heldItem.isEmpty() && heldItem.getItem() == ModItems.SPONGE
							&& block == Blocks.STAINED_GLASS_PANE) {
						e.getWorld().setBlockState(pos, Blocks.GLASS_PANE.getDefaultState());
					}

					else if (!heldItem.isEmpty() && heldItem.getItem() == stack.getItem()
							&& (block == Blocks.HARDENED_CLAY || block == Blocks.STAINED_HARDENED_CLAY)
							&& block.getMetaFromState(state) != i) {
						if (heldItem.getItem().getHasSubtypes()) {
							if (heldItem.getItemDamage() == 15 - i) {
								e.getWorld().setBlockState(pos,
										Blocks.STAINED_HARDENED_CLAY.getBlockState().getBlock().getStateFromMeta(i));
								if (!e.getEntityPlayer().isCreative())
									heldItem.shrink(1);
							}
						} else {
							e.getWorld().setBlockState(pos,
									Blocks.STAINED_HARDENED_CLAY.getBlockState().getBlock().getStateFromMeta(i));
							if (!e.getEntityPlayer().isCreative())
								heldItem.shrink(1);
						}
					}

					else if (!heldItem.isEmpty() && heldItem.getItem() == ModItems.SPONGE
							&& block == Blocks.STAINED_HARDENED_CLAY) {
						e.getWorld().setBlockState(pos, Blocks.HARDENED_CLAY.getDefaultState());
					}

					else if (!heldItem.isEmpty() && heldItem.getItem() == stack.getItem() && block == Blocks.CARPET
							&& block.getMetaFromState(state) != i) {
						if (heldItem.getItem().getHasSubtypes()) {
							if (heldItem.getItemDamage() == 15 - i) {
								e.getWorld().setBlockState(pos,
										Blocks.CARPET.getBlockState().getBlock().getStateFromMeta(i));
								if (!e.getEntityPlayer().isCreative())
									heldItem.shrink(1);
							}
						} else {
							e.getWorld().setBlockState(pos,
									Blocks.CARPET.getBlockState().getBlock().getStateFromMeta(i));
							if (!e.getEntityPlayer().isCreative())
								heldItem.shrink(1);
						}
					}

					else if (!heldItem.isEmpty() && heldItem.getItem() == stack.getItem() && block == Blocks.CONCRETE
							&& block.getMetaFromState(state) != i) {
						if (heldItem.getItem().getHasSubtypes()) {
							if (heldItem.getItemDamage() == 15 - i) {
								e.getWorld().setBlockState(pos,
										Blocks.CONCRETE.getBlockState().getBlock().getStateFromMeta(i));
								if (!e.getEntityPlayer().isCreative())
									heldItem.shrink(1);
							}
						} else {
							e.getWorld().setBlockState(pos,
									Blocks.CONCRETE.getBlockState().getBlock().getStateFromMeta(i));
							if (!e.getEntityPlayer().isCreative())
								heldItem.shrink(1);
						}
					}

					else if (!heldItem.isEmpty() && heldItem.getItem() == stack.getItem()
							&& block == Blocks.CONCRETE_POWDER && block.getMetaFromState(state) != i) {
						if (heldItem.getItem().getHasSubtypes()) {
							if (heldItem.getItemDamage() == 15 - i) {
								e.getWorld().setBlockState(pos,
										Blocks.CONCRETE_POWDER.getBlockState().getBlock().getStateFromMeta(i));
								if (!e.getEntityPlayer().isCreative())
									heldItem.shrink(1);
							}
						} else {
							e.getWorld().setBlockState(pos,
									Blocks.CONCRETE_POWDER.getBlockState().getBlock().getStateFromMeta(i));
							if (!e.getEntityPlayer().isCreative())
								heldItem.shrink(1);
						}
					}

					// Color Bed, but only does 1 part, not both..
					/*
					 * else if (e.getEntityPlayer().isSneaking() && !heldItem.isEmpty() &&
					 * heldItem.getItem() == Items.DYE && heldItem.getItemDamage() == 15 - i &&
					 * e.getWorld().getTileEntity(pos) instanceof TileEntityBed && ((TileEntityBed)
					 * te).getColor().getMetadata() != i) { if(((TileEntityBed)te).isHeadPiece()){
					 * ((TileEntityBed) te).setColor(EnumDyeColor.byMetadata(i)); } else {
					 * ((TileEntityBed) te).setColor(EnumDyeColor.byMetadata(i)); }
					 * heldItem.shrink(1); }
					 */
				}
			}
		}
	}
}
