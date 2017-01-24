package de.alles_minecraft.lovocraft.blocks.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockBase extends ItemBlock{

	public ItemBlockBase(Block block) {
		super(block);
		this.bFull3D = true;
	}
	
	@Override
	public int getMetadata(int damage) {
		return damage;
	}

}
