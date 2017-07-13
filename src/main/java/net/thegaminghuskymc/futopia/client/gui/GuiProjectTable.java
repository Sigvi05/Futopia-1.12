package net.thegaminghuskymc.futopia.client.gui;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.client.container.ContainerProjectTable;
import net.thegaminghuskymc.huskylib.client.gui.GuiContainerBase;

public class GuiProjectTable extends GuiContainerBase {
	
	private static ResourceLocation texture = new ResourceLocation(Refs.MODID, "textures/gui/container/project_table.png");

	public GuiProjectTable(InventoryPlayer playerInv) {
		super(new ContainerProjectTable(playerInv));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int i = this.guiLeft;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRenderer.drawString(I18n.format("Project Table"), 28, 6, 0x75FF05);
        this.fontRenderer.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 0x75FF05);
	}

}
