package de.alles_minecraft.lovocraft.gui;

import java.io.IOException;

import de.alles_minecraft.lovocraft.Lovocraft;
import de.alles_minecraft.lovocraft.container.ContainerLovoFurnace;
import de.alles_minecraft.lovocraft.network.INetworkChooseButton;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

public class GuiLovoFurnace extends GuiContainer implements INetworkChooseButton{
	
	private BlockPos pos;
	private GuiChooseButton button;
	
	public GuiLovoFurnace(IInventory inv,InventoryPlayer player) {
		super(new ContainerLovoFurnace(inv,player));
		this.pos = ((TileEntity)inv).getPos();
	}
	
	@Override
	public void initGui() {
		super.initGui();
		this.button = new GuiChooseButton(this.pos, 0,115, 12);
		this.button.init();
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Lovocraft.MODID,"textures\\gui\\lovofurnace_gui.png"));
		Gui.drawModalRectWithCustomSizedTexture(this.guiLeft, this.guiTop, 0, 0, 257, 257, 257, 257);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.button.draw();
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		if(mouseButton == 0){
			this.button.onPressed(mouseX, mouseY,this.guiLeft,this.guiTop);
		}
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}

	@Override
	public void onNetworkCall(int id, boolean state) {
		this.button.setState(state);
	}
}
