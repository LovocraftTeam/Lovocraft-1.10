package de.alles_minecraft.lovocraft.gui;

import de.alles_minecraft.lovocraft.Lovocraft;
import de.alles_minecraft.lovocraft.network.MessageChooserSetter;
import de.alles_minecraft.lovocraft.network.MessageRequest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

public class GuiChooseButton extends Gui {

	private int x,y;
	private TextureManager tex;
	private boolean state;
	private float animation;
	private int id;
	private BlockPos pos;
	
	public GuiChooseButton(BlockPos pos,int id,int x,int y) {
		this.pos = pos;
		this.id = id;
		this.x = x;
		this.y = y;
		this.tex = Minecraft.getMinecraft().getTextureManager();
	}
	
	public void init(){
		Lovocraft.INSTANCE.pack.wrapper.sendToServer(new MessageRequest(id, pos));
	}
	
	public void draw(){
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.x, this.y, 0);
		{
			this.tex.bindTexture(new ResourceLocation(Lovocraft.MODID,"textures\\gui\\Rahmen.png"));
			GlStateManager.color(1 - animation, animation,0,0.5F);
			drawScaledCustomSizeModalRect(0, 0, 0, 0, 72, 36, 72/3, 36/3, 72, 36);
			GlStateManager.color(1, 1, 1);
			this.tex.bindTexture(new ResourceLocation(Lovocraft.MODID,"textures\\gui\\" + (animation < 0.5 ? "no.png":"yes.png")));
			drawScaledCustomSizeModalRect(Math.round(1 + (36/3*animation)), 1, 0, 0, 30, 30, 30/3, 30/3, 30, 30);
			if(this.state == false && this.animation > 0){
				this.animation -= 0.05;
			}else if(this.state == true && this.animation < 1){
				this.animation += 0.05;
			}
		}
		GlStateManager.popMatrix();
	}
	
	public void setState(boolean b){
		if(this.state != b){
			this.state = b;
			this.animation = b ? 0:1;
			Lovocraft.INSTANCE.pack.wrapper.sendToServer(new MessageChooserSetter(this.id, b, this.pos));
		}
	}
	
	public boolean getState(){
		return this.state;
	}
	
	public void onPressed(int mx,int my,int xoff,int yoff){
		if(mx < this.x + xoff + 72/3&& mx > this.x + xoff && my < this.y + yoff + 36/3 && my > this.y + yoff){
			this.setState(!state);
		}
	}
}
