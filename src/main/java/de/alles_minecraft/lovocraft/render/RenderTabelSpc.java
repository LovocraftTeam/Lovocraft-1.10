package de.alles_minecraft.lovocraft.render;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RenderTabelSpc implements Render {
	
	@Override
	public void draw(World world, BlockPos pos) {
		GlStateManager.pushMatrix();
	    {
	    }
		GlStateManager.popMatrix();
	}

}
