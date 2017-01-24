package de.alles_minecraft.lovocraft.blocks.items;

import de.alles_minecraft.lovocraft.blocks.BlockOres;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ItemBlockOres extends ItemBlockSub{

	public ItemBlockOres(Block block) {
		super(block);
	}	
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		Block block = Block.getBlockFromItem(stack.getItem());
		if(block != null){
			return "tile." + block.getStateFromMeta(stack.getMetadata()).getValue(BlockOres.PROPERTY).getName();
		}
		return "";
	}
}
