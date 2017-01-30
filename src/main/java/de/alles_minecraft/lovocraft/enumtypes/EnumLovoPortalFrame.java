package de.alles_minecraft.lovocraft.enumtypes;

import net.minecraft.util.IStringSerializable;

public enum EnumLovoPortalFrame implements IStringSerializable {
	
	FRAME("lovo_portal_frame",6,8,3),
	FRAMEEMPTY("lovo_portal_frame_empty",6,8,3),
	FRAMECRYSTAL("lovo_portal_frame_crystal",6,8,3);
	
	private String st;
	public final float hardness,resistance,harvestlevel;
	
	private EnumLovoPortalFrame(String st,float hardness,float resistance,float harvestlevel) {
		this.st = st;
		this.hardness = hardness;
		this.resistance = resistance;
		this.harvestlevel = harvestlevel;
	}
	
	@Override
	public String getName() {
		return st;
	}
	
	public int getMeta(){
		int i = 0;
		for(EnumLovoPortalFrame portalframe : EnumLovoPortalFrame.values()){
			if(portalframe.getName().equals(this.getName())){
				return i;
			}
			i++;
		}
		return 2;
	}
	
}
