package de.alles_minecraft.lovocraft.blocks.items;

import de.alles_minecraft.lovocraft.blocks.BlockBrick;
import de.alles_minecraft.lovocraft.blocks.BlockOres;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ItemBlockBrick extends ItemBlockSub{

	public ItemBlockBrick(Block block) {
		super(block);
	}	
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		Block block = Block.getBlockFromItem(stack.getItem());
		if(block != null){
			return "tile." + block.getStateFromMeta(stack.getMetadata()).getValue(BlockBrick.PROPERTY).getName();
		}
		return "";
	}
}
