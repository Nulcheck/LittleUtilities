package mce.lu.client.gui;

import mce.lu.common.block.ModBlocks;
import mce.lu.common.container.ContainerPigmentMixer;
import mce.lu.common.util.References;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GuiPigmentMixer extends GuiContainer {
	private static final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID,
			"textures/gui/pigment_mixer.png");

	public GuiPigmentMixer(InventoryPlayer player, World world) {
		this(player, world, BlockPos.ORIGIN);
	}

	public GuiPigmentMixer(InventoryPlayer player, World world, BlockPos pos) {
		super(new ContainerPigmentMixer(player, world, pos));
	}

	/**
	 * Draws screen and all components in it. (Also makes the background, behind
	 * GUI image, darker)
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
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRenderer.drawString(I18n.format("container.pigment_mixer"),
				this.xSize / 2 - this.fontRenderer.getStringWidth("pigment_mixer") / 2, 6, 4210752);
		this.fontRenderer.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}

	/**
	 * Draw main texture image.
	 */
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1f, 1f, 1f);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		int i = this.guiLeft;
		int j = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
	}
}
