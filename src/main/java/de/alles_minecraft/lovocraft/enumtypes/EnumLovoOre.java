package de.alles_minecraft.lovocraft.enumtypes;

import net.minecraft.util.IStringSerializable;

public enum EnumLovoOre implements IStringSerializable {
	
	COAL("lovo_coal",4,5,0,2),
	DIAMOND("lovo_diamond",4,5,0,3),
	EMERALD("lovo_emerald",4,5,0,3),
	GOLD("lovo_gold",4,5,0,2),
	IRON("lovo_iron",4,5,0,2),
	LAPIS("lovo_lapis",4,5,0,2),
	REDSTONE("lovo_redstone",4,5,6,2),
	LOVO_ORE("lovo_ore",4,5,8,3),
	LOVO_ORE_NETHER("lovo_ore_nether",4,5,8,3);
	
	private String st;
	public final float hardness,resistance,light,harvestlevel;
	
	private EnumLovoOre(String st,float hardness,float resistance,float light,float harvestlevel) {
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
		for(EnumLovoOre ore : EnumLovoOre.values()){
			if(ore.getName().equals(this.getName())){
				return i;
			}
			i++;
		}
		return 2;
	}
	
}
