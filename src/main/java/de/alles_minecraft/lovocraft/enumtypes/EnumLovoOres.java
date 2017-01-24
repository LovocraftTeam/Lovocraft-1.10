package de.alles_minecraft.lovocraft.enumtypes;

import net.minecraft.util.IStringSerializable;

public enum EnumLovoOres implements IStringSerializable {
	
	COAL("lovo_coal",4,4,0,2),
	DIAMOND("lovo_diamond",4,4,0,3),
	EMERALD("lovo_emerald",4,4,0,3),
	GOLD("lovo_gold",4,4,0,2),
	IRON("lovo_iron",4,4,0,2),
	LAPIS("lovo_lapis",4,4,0,2),
	REDSTONE("lovo_redstone",4,4,6,2),
	LOVO_ORE("lovo_ore",4,4,8,3),
	LOVO_ORE_NETHER("lovo_ore_nether",4,4,8,3);
	
	private String st;
	public final float hardness,resistance,light,harvestlevel;
	
	private EnumLovoOres(String st,float hardness,float resistance,float light,float harvestlevel) {
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
		for(EnumLovoOres ore : EnumLovoOres.values()){
			if(ore.getName().equals(this.getName())){
				return i;
			}
			i++;
		}
		return 2;
	}
	
}
