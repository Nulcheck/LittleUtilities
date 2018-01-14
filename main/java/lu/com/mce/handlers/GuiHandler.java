package lu.com.mce.handlers;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import lu.com.mce.common.mod_lu;
import lu.com.mce.container.CondenserContainer;
import lu.com.mce.entity.tile.TileEntityCondenser;
import lu.com.mce.gui.CondenserGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

	public GuiHandler() {
		NetworkRegistry.INSTANCE.registerGuiHandler(mod_lu.instance, this);
	}

	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if (entity != null) {
			switch (id) {
			case mod_lu.condenserGUI:
				return (id == 0) && (world.getBlock(x, y, z) == mod_lu.condenser)
						? new CondenserContainer(player.inventory, (TileEntityCondenser) entity) : null;
			}
		}

		return null;
	}

	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if (entity != null) {
			switch (id) {
			case mod_lu.condenserGUI:
				return (id == 0) && (world.getBlock(x, y, z) == mod_lu.condenser)
						? new CondenserGui(player.inventory, (TileEntityCondenser) entity) : null;
			}
		}

		return null;
	}
}
