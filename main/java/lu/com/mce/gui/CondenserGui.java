package lu.com.mce.gui;

import org.lwjgl.opengl.GL11;

import lu.com.mce.container.CondenserContainer;
import lu.com.mce.entity.tile.TileEntityCondenser;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class CondenserGui extends GuiContainer {
	public TileEntityCondenser con;
	public final ResourceLocation texture = new ResourceLocation("mod_lu", "/textures/gui/condenser.png".substring(1));

	public CondenserGui(InventoryPlayer player, TileEntityCondenser entity) {
		super(new CondenserContainer(player, entity));

		this.con = entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerForegroundLayer(int x, int y) {
		String name = this.con.isInvNameLocalized() ? this.con.getInvName() : I18n.format(this.con.getInvName());

		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6,
				4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}

	public void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1f, 1f, 1f, 1f);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
}
