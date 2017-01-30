package de.alles_minecraft.lovocraft;

import de.alles_minecraft.lovocraft.blocks.BlockLovoBrick;
import de.alles_minecraft.lovocraft.blocks.BlockLovoCobblestone;
import de.alles_minecraft.lovocraft.blocks.BlockLovoFurnace;
import de.alles_minecraft.lovocraft.blocks.BlockLovoPillar;
import de.alles_minecraft.lovocraft.blocks.BlockLovoPortalFrame;
import de.alles_minecraft.lovocraft.blocks.BlockLovoStone;
import de.alles_minecraft.lovocraft.blocks.BlockLovoTnt;
import de.alles_minecraft.lovocraft.blocks.BlockLovoOre;
import de.alles_minecraft.lovocraft.blocks.items.ItemBlockBrick;
import de.alles_minecraft.lovocraft.blocks.items.ItemBlockLovoPortalFrame;
import de.alles_minecraft.lovocraft.blocks.items.ItemBlockOre;
import io.github.mc_umod.registerys.BlockRegistery;
import net.minecraft.block.Block;

public class LBlocks {
	
	public final BlockRegistery register;

	public final Block blocklovoore;
	public final Block blocklovobrick;
	public final Block blocklovoportalframe;
	public final Block blocklovostone;
	public final Block blocklovocobblestone;
	public final Block blocklovotnt;
	public final Block blocklovopillar;
	public final Block blocklovofurnace;
	
	public LBlocks() {
		this.register = new BlockRegistery();

		this.blocklovoore = new BlockLovoOre();
		this.blocklovobrick = new BlockLovoBrick();
		this.blocklovoportalframe = new BlockLovoPortalFrame();
		this.blocklovostone = new BlockLovoStone();
		this.blocklovocobblestone = new BlockLovoCobblestone();
		this.blocklovotnt = new BlockLovoTnt();
		this.blocklovopillar = new BlockLovoPillar();
		this.blocklovofurnace = new BlockLovoFurnace();
		this.register();
	}

	private void register() {
		this.register.register(this.blocklovoore,ItemBlockOre.class);
		this.register.register(this.blocklovobrick,ItemBlockBrick.class);
		this.register.register(this.blocklovoportalframe,ItemBlockLovoPortalFrame.class);
		this.register.register(blocklovostone);
		this.register.register(blocklovocobblestone);
		this.register.register(blocklovotnt);
		this.register.register(blocklovopillar);
		this.register.register(blocklovofurnace);
	}
	
}
