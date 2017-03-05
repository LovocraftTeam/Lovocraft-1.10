package de.alles_minecraft.lovocraft.render;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface Render {

	public void draw(World world,BlockPos pos);
	
}
