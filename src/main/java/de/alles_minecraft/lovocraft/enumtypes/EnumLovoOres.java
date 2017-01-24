package de.alles_minecraft.lovocraft.enumtypes;

import net.minecraft.util.IStringSerializable;

public enum EnumLovoOres implements IStringSerializable {
	
	COAL("lovo_coal",0,0,0),
	DIAMOND("lovo_diamond",0,0,0),
	EMERALD("lovo_emerald",0,0,0),
	GOLD("lovo_gold",0,0,0),
	IRON("lovo_iron",0,0,0),
	LAPIS("lovo_lapis",0,0,0),
	REDSTONE("lovo_redstone",0,0,0),
	LOVO_ORE("lovo_ore",0,0,0),
	LOVO_ORE_NETHER("lovo_ore_nether",0,0,0);
	
	private String st;
	public final float hardness,resistance,light;
	
	private EnumLovoOres(String st,float hardness,float resistance,float light) {
		this.st = st;
		this.hardness = hardness;
		this.light = light;
		this.resistance = resistance;
	}
	
	@Override
	public String getName() {
		return st;
	}
	
	public int getMeta(){
		int i = 0;
		for(EnumLovoOres ore : EnumLovoOres.values()){
			if(ore.getName().equals(this.getName())){
				return i;
			}
			i++;
		}
		return 2;
	}
	
}
