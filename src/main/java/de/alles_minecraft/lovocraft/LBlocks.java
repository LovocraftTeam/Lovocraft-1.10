package de.alles_minecraft.lovocraft;

import de.alles_minecraft.lovocraft.blocks.BlockBrick;
import de.alles_minecraft.lovocraft.blocks.BlockLovoCobblestone;
import de.alles_minecraft.lovocraft.blocks.BlockLovoFurnace;
import de.alles_minecraft.lovocraft.blocks.BlockLovoPillar;
import de.alles_minecraft.lovocraft.blocks.BlockLovoStone;
import de.alles_minecraft.lovocraft.blocks.BlockLovoTnt;
import de.alles_minecraft.lovocraft.blocks.BlockOres;
import de.alles_minecraft.lovocraft.blocks.items.ItemBlockBrick;
import de.alles_minecraft.lovocraft.blocks.items.ItemBlockOres;
import io.github.mc_umod.registerys.BlockRegistery;
import net.minecraft.block.Block;

public class LBlocks {
	
	public final BlockRegistery register;

	public final Block blockore;
	public final Block blockbrick;
	public final Block blocklovostone;
	public final Block blocklovocobblestone;
	public final Block blocklovotnt;
	public final Block blocklovopillar;
	public final Block blocklovofurnance;
	
	public LBlocks() {
		this.register = new BlockRegistery();

		this.blockore = new BlockOres();
		this.blockbrick = new BlockBrick();
		this.blocklovostone = new BlockLovoStone();
		this.blocklovocobblestone = new BlockLovoCobblestone();
		this.blocklovotnt = new BlockLovoTnt();
		this.blocklovopillar = new BlockLovoPillar();
		this.blocklovofurnance = new BlockLovoFurnace();
		this.register();
	}

	private void register() {
		this.register.register(this.blockore,ItemBlockOres.class);
		this.register.register(this.blockbrick,ItemBlockBrick.class);
		this.register.register(blocklovostone);
		this.register.register(blocklovocobblestone);
		this.register.register(blocklovotnt);
		this.register.register(blocklovopillar);
		this.register.register(blocklovofurnance);
	}
	
}
