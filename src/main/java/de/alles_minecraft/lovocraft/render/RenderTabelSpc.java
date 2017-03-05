package de.alles_minecraft.lovocraft.render;

import java.awt.Color;

import static org.lwjgl.opengl.GL11.*;

import io.github.mc_umod.corelib.api.util.RGBA;
import io.github.mc_umod.corelib.renderapi.RenderBuffer;
import io.github.mc_umod.corelib.renderapi.Vertex;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
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
