package de.alles_minecraft.lovocraft.items;

import de.alles_minecraft.lovocraft.Lovocraft;
import net.minecraft.item.Item;

public class ItemBasic extends Item{

	public ItemBasic(String name) {
		this.setUnlocalizedName(name);
		this.setCreativeTab(Lovocraft.INSTANCE.lovo_tab);
	}
	
}
