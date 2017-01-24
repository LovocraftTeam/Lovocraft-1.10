package de.alles_minecraft.lovocraft.enumtypes;

import net.minecraft.util.IStringSerializable;

public enum EnumLovoOres implements IStringSerializable {
	
	COAL("lovo_coal"),
	DIAMOND("lovo_diamond"),
	EMERALD("lovo_emerald"),
	GOLD("lovo_gold"),
	IRON("lovo_iron"),
	LAPIS("lovo_lapis"),
	REDSTONE("lovo_redstone"),
	LOVO_ORE("lovo_ore"),
	LOVO_ORE_NETHER("lovo_ore_nether");
	
	private String st;
	
	private EnumLovoOres(String st) {
		this.st = st;
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
