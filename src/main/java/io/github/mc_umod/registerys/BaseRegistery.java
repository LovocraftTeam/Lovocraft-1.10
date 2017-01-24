package io.github.mc_umod.registerys;

/**
 * Base Class for all Register Classes
 * 
 * @author MrTroble
 *
 */
public class BaseRegistery {

	/**
	 * Clears an Unlocalized Name
	 * 
	 * @param inputString
	 * @return String without item. tile. .name
	 */
	protected String formate(String inputString){
		return inputString.replace("item.", "").replace(".name", "").replace("tile.", "");
	}

}
