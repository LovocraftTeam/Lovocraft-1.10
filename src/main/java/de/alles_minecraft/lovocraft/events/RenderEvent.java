package de.alles_minecraft.lovocraft.events;

import de.alles_minecraft.lovocraft.Lovocraft;
import de.alles_minecraft.lovocraft.render.Render;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.Event;

public class RenderEvent extends Event {

	private World world;
	private BlockPos pos;
	private Render render;
	
	public RenderEvent(World world,BlockPos pos,Class<? extends Render> clazz) {
		this.world = world;
		this.pos = pos;
		try {
			this.render = clazz.newInstance();
		} catch (InstantiationException e) {
			Lovocraft.INSTANCE.log.catching(e);
		} catch (IllegalAccessException e) {
			Lovocraft.INSTANCE.log.catching(e);
		}
	}
	
	public BlockPos getPos(){
		return pos;
	}
	
	public void render(){
		EntityPlayer mp = Minecraft.getMinecraft().thePlayer;
		if(this.render != null){
			this.render.draw(this.world, this.pos);
		}
	}
}
