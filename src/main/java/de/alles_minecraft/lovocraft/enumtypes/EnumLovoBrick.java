package de.alles_minecraft.lovocraft.enumtypes;

import net.minecraft.util.IStringSerializable;

public enum EnumLovoBrick implements IStringSerializable {
	
	BRICK("lovo_brick",4,4,0,2),
	CHISELLED("lovo_brick_chiselled",4,4,0,3),
	CRACKED("lovo_brick_cracked",4,4,0,3);
	
	private String st;
	public final float hardness,resistance,light,harvestlevel;
	
	private EnumLovoBrick(String st,float hardness,float resistance,float light,float harvestlevel) {
		this.st = st;
		this.hardness = hardness;
		this.light = light;
		this.resistance = resistance;
		this.harvestlevel = harvestlevel;
	}
	
	@Override
	public String getName() {
		return st;
	}
	
	public int getMeta(){
		int i = 0;
		for(EnumLovoBrick brick : EnumLovoBrick.values()){
			if(brick.getName().equals(this.getName())){
				return i;
			}
			i++;
		}
		return 2;
	}
	
}