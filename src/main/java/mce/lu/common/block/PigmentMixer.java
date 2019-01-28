package mce.lu.common.block;

import mce.lu.client.core.handler.GuiHandler;
import mce.lu.common.LittleUtilities;
import mce.lu.common.util.ModStatsList;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PigmentMixer extends BlockBase {
	public PigmentMixer(String name, Material mat) {
		super(name, mat);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!player.isSneaking()) {
			player.openGui(LittleUtilities.instance, GuiHandler.PIGMENT_MIXER, world, pos.getX(), pos.getY(),
					pos.getZ());
			player.addStat(ModStatsList.PIGMENT_MIXER_INTERACTION);
			return true;
		} else {
			return false;
		}
	}

	/*@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntity tile = world.getTileEntity(pos);

		if (tile instanceof TileEntityPigmentMixer) {
			InventoryHelper.dropInventoryItems(world, pos, (TileEntityPigmentMixer) tile);
			// world.updateComparatorOutputLevel(pos, this);
		}
	}*/
}
