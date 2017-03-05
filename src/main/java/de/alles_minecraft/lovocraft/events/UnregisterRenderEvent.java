package de.alles_minecraft.lovocraft.events;

import de.alles_minecraft.lovocraft.render.Render;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class UnregisterRenderEvent extends RenderEvent{

	public UnregisterRenderEvent(World world, BlockPos pos, Class<? extends Render> clazz) {
		super(world, pos, clazz);
	}

}
