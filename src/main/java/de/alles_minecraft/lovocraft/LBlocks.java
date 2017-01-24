package de.alles_minecraft.lovocraft;

import de.alles_minecraft.lovocraft.blocks.BlockLovoFurnace;
import de.alles_minecraft.lovocraft.blocks.BlockOres;
import de.alles_minecraft.lovocraft.blocks.items.ItemBlockOres;
import io.github.mc_umod.registerys.BlockRegistery;
import net.minecraft.block.Block;

public class LBlocks {
	
	public final BlockRegistery register;

	public final Block blockore;
	public final Block blocklovofurnance;
	
	public LBlocks() {
		this.register = new BlockRegistery();

		this.blocklovofurnance = new BlockLovoFurnace();
		this.blockore = new BlockOres();
		
		this.register();
	}

	private void register() {
		this.register.register(blocklovofurnance);
		this.register.register(this.blockore,ItemBlockOres.class);
	}
	
}
