package de.alles_minecraft.lovocraft.events;

import de.alles_minecraft.lovocraft.render.Render;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.Event;

public class RegisterRenderEvent extends RenderEvent {

	public RegisterRenderEvent(World world, BlockPos pos, Class<? extends Render> clazz) {
		super(world, pos, clazz);
	}
	
}
