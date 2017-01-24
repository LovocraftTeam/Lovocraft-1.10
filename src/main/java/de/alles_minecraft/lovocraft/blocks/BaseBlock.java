package de.alles_minecraft.lovocraft.blocks;

import de.alles_minecraft.lovocraft.Lovocraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumBlockRenderType;

public class BaseBlock extends Block{

	public BaseBlock(Material materialIn) {
		super(materialIn);
		this.setCreativeTab(Lovocraft.INSTANCE.lovo_tab);
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}
}
