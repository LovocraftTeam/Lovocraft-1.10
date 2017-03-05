package de.alles_minecraft.lovocraft;

import io.github.mc_umod.registrys.RenderRegistery;

public class ClientProxy extends CommonProxy{
	
	private RenderRegistery ENTRY;
	
	@Override
	public void registerModels() {
		this.ENTRY = new RenderRegistery(Lovocraft.MODID);
		this.ENTRY.register(Lovocraft.INSTANCE.lblocks.blocklovoore);
		this.ENTRY.register(Lovocraft.INSTANCE.lblocks.blocklovobrick);
		this.ENTRY.register(Lovocraft.INSTANCE.lblocks.blocklovoportalframe);
		this.ENTRY.register(Lovocraft.INSTANCE.lblocks.blocklovostone);
		this.ENTRY.register(Lovocraft.INSTANCE.lblocks.blocklovocobblestone);
		this.ENTRY.register(Lovocraft.INSTANCE.lblocks.blocklovotnt);
		this.ENTRY.register(Lovocraft.INSTANCE.lblocks.blocklovotable);
		this.ENTRY.register(Lovocraft.INSTANCE.lblocks.blocklovofurnace);
		
		this.ENTRY.register(Lovocraft.INSTANCE.litems.lovocrystal);
		this.ENTRY.register(Lovocraft.INSTANCE.litems.lovocrystalcrumbled);
		this.ENTRY.register(Lovocraft.INSTANCE.litems.lovoiron);
		this.ENTRY.register(Lovocraft.INSTANCE.litems.lovostring);
		this.ENTRY.register(Lovocraft.INSTANCE.litems.lovostick);
		this.ENTRY.register(Lovocraft.INSTANCE.litems.lovofurnaceupgrade);
		this.ENTRY.register(Lovocraft.INSTANCE.litems.lovobow);
		this.ENTRY.register(Lovocraft.INSTANCE.litems.lovostaff);
	}	
	
}
