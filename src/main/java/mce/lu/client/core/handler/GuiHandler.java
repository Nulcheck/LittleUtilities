package mce.lu.client.core.handler;

import mce.lu.client.gui.GuiCondenser;
import mce.lu.client.gui.GuiPigmentMixer;
import mce.lu.common.container.ContainerCondenser;
import mce.lu.common.container.ContainerPigmentMixer;
import mce.lu.common.entity.tile.TileEntityCondenser;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	public static final int CONDENSER = 0;
	public static final int PIGMENT_MIXER = 1;

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);

		switch (id) {
		case CONDENSER:
			return new ContainerCondenser(player.inventory, (TileEntityCondenser) world.getTileEntity(pos));
		case PIGMENT_MIXER:
			return new ContainerPigmentMixer(player.inventory, world, pos);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);

		switch (id) {
		case CONDENSER:
			return new GuiCondenser(player.inventory, (TileEntityCondenser) world.getTileEntity(pos));
		case PIGMENT_MIXER:
			return new GuiPigmentMixer(player.inventory, world);
		}
		return null;
	}
}