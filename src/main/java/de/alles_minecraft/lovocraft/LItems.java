package de.alles_minecraft.lovocraft;

import de.alles_minecraft.lovocraft.blocks.BlockLovoOre;
import de.alles_minecraft.lovocraft.items.ItemLovoBow;
import de.alles_minecraft.lovocraft.items.ItemLovoCrystal;
import de.alles_minecraft.lovocraft.items.ItemLovoCrystalCrumbled;
import de.alles_minecraft.lovocraft.items.ItemLovoFurnaceUpgrade;
import de.alles_minecraft.lovocraft.items.ItemLovoIron;
import de.alles_minecraft.lovocraft.items.ItemLovoStaff;
import de.alles_minecraft.lovocraft.items.ItemLovoStick;
import de.alles_minecraft.lovocraft.items.ItemLovoString;
import io.github.mc_umod.registrys.BlockRegistery;
import io.github.mc_umod.registrys.ItemRegistery;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class LItems {

	public final ItemRegistery register;
	
	public final Item lovocrystal;
	public final Item lovocrystalcrumbled;
	public final Item lovoiron;
	public final Item lovostring;
	public final Item lovostick;
	public final Item lovofurnaceupgrade;
	public final Item lovobow;
	public final Item lovostaff;
	
	public LItems() {
		this.register = new ItemRegistery();
		this.lovocrystal = new ItemLovoCrystal();
		this.lovocrystalcrumbled = new ItemLovoCrystalCrumbled();
		this.lovoiron = new ItemLovoIron();
		this.lovostring = new ItemLovoString();
		this.lovostick = new ItemLovoStick();
		this.lovofurnaceupgrade = new ItemLovoFurnaceUpgrade();
		this.lovobow = new ItemLovoBow();
		this.lovostaff = new ItemLovoStaff();
		register();
	}

	private void register() {
		this.register.register(this.lovocrystal);
		this.register.register(this.lovocrystalcrumbled);
		this.register.register(this.lovoiron);
		this.register.register(this.lovostring);
		this.register.register(this.lovostick);
		this.register.register(this.lovofurnaceupgrade);
		this.register.register(this.lovobow);
		this.register.register(this.lovostaff);
	}
	
}
