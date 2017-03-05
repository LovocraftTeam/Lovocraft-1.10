package io.github.mc_umod.registrys;

import java.lang.reflect.Constructor;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Class to register Blocks
 * 
 * @author MrTroble
 *
 */
public class ItemRegistery extends BaseRegistery{
	
	/**
	 * Registers a Block<br>
	 * <strong>Unlocalized Name has to be set!</strong>
	 * 
	 * @param block
	 */
	public void register(Item itemblock){
		String name = this.formate(itemblock.getUnlocalizedName());
		itemblock.setRegistryName(name);
		GameRegistry.register(itemblock);
	}
}