package de.alles_minecraft.lovocraft.render;

import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;

import com.google.common.collect.Lists;

import de.alles_minecraft.lovocraft.Lovocraft;
import de.alles_minecraft.lovocraft.events.RegisterRenderEvent;
import de.alles_minecraft.lovocraft.events.RenderEvent;
import de.alles_minecraft.lovocraft.events.UnregisterRenderEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiScreenEvent.DrawScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;

/**
 * <strong>NEUES RENDERSYSTEM<strong>
 * @author MrTroble
 * 
 */
public class RenderSys {
	
	private HashMap<BlockPos,RenderEvent> ACTIVE_RENDER = new HashMap<BlockPos, RenderEvent>();
	
	@SubscribeEvent
	public void tick(RenderTickEvent evt){
		try{
			ACTIVE_RENDER.forEach(new BiConsumer<BlockPos, RenderEvent>() {

				@Override
				public void accept(BlockPos t, RenderEvent u) {
					u.render();
				}
			});
		}catch(Throwable e){
			Lovocraft.INSTANCE.log.catching(e);
		}
	}
	
	@SubscribeEvent
	public void register(RegisterRenderEvent reg){
		ACTIVE_RENDER.put(reg.getPos(),reg);
	}
	
	@SubscribeEvent
	public void unregister(UnregisterRenderEvent unreg){
		ACTIVE_RENDER.remove(unreg.getPos());
	}
	
	
}
