package de.alles_minecraft.lovocraft;

import io.github.mc_umod.registerys.RenderRegistery;

public class ClientProxy extends CommonProxy{
	
	private RenderRegistery ENTRY;
	
	@Override
	public void registerModels() {
		this.ENTRY = new RenderRegistery(Lovocraft.MODID);
		this.ENTRY.register(Lovocraft.INSTANCE.lblocks.blockore);
		this.ENTRY.register(Lovocraft.INSTANCE.lblocks.blockbrick);
		this.ENTRY.register(Lovocraft.INSTANCE.lblocks.blocklovostone);
		this.ENTRY.register(Lovocraft.INSTANCE.lblocks.blocklovocobblestone);
		this.ENTRY.register(Lovocraft.INSTANCE.lblocks.blocklovotnt);
		this.ENTRY.register(Lovocraft.INSTANCE.lblocks.blocklovopillar);
		this.ENTRY.register(Lovocraft.INSTANCE.lblocks.blocklovofurnance);
		
	}	
	
}
