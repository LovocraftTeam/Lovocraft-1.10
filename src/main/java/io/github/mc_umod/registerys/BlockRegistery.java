package io.github.mc_umod.registerys;

import java.lang.reflect.Constructor;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Class to register Blocks
 * 
 * @author MrTroble
 *
 */
public class BlockRegistery extends BaseRegistery{
	
	/**
	 * Registers a Block<br>
	 * <strong>Unlocalized Name has to be set</strong>
	 * 
	 * @param block
	 */
	public void register(Block block){
		this.register(block, null);
	}

	/**
	 * Registers a Block with an ItemBlock<br>
	 * <strong>Unlocalized Name has to be set</strong>
	 * 
	 * @param block
	 * @param itemBlock
	 */
	public void register(Block block,Class<? extends ItemBlock> itemBlock){
		String name = this.formate(block.getUnlocalizedName());
		block.setRegistryName(name);
		GameRegistry.register(block);

		ItemBlock itemblock = null;
		try {
			Constructor<?> cons = itemBlock.getConstructor(Block.class);
			itemblock = (ItemBlock) cons.newInstance(block);
		} catch (Throwable th) {
			itemblock = new ItemBlock(block);
		}
		GameRegistry.register(itemblock.setUnlocalizedName(block.getUnlocalizedName()).setRegistryName(name));
	}
}