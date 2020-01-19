package mce.lu.client.gui;

import mce.lu.common.container.ContainerDehydrator;
import mce.lu.common.entity.tile.TileEntityDehydrator;
import mce.lu.common.util.References;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiDehydrator extends GuiContainer {
	public final ResourceLocation GUI_TEXTURE = new ResourceLocation(References.MOD_ID, "textures/gui/dehydrator.png");
	private IInventory tile;
	private InventoryPlayer playerInv;

	public GuiDehydrator(InventoryPlayer playerInv, IInventory tileInv) {
		super(new ContainerDehydrator(playerInv, tileInv));

		this.xSize = 176;
		this.ySize = 166;

		this.tile = (TileEntityDehydrator) tileInv;
		this.playerInv = playerInv;
	}

	/**
	 * Draws screen and all components in it. (Also makes the background, behind GUI
	 * image, darker)
	 */
	@Override
	public void drawScreen(int mouseX, int mouseY, float ticks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, ticks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	/**
	 * Drawing stuff like the GUI name and the word "Inventory". This is on the
	 * foreground and is not on the actual GUI png file. (background texture)
	 */
	@Override
	public void drawGuiContainerForegroundLayer(int x, int y) {
		String name = this.tile.getDisplayName().getUnformattedText();
		String invName = this.playerInv.getDisplayName().getUnformattedText();

		this.fontRenderer.drawString(name, this.xSize / 2 - this.fontRenderer.getStringWidth(name) / 2, 6, 4210752);
		this.fontRenderer.drawString(invName, 8, this.ySize - 96 + 2, 4210752);
	}

	/**
	 * Draw main texture image.
	 */
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1f, 1f, 1f);
		this.mc.getTextureManager().bindTexture(GUI_TEXTURE);
		this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
}
