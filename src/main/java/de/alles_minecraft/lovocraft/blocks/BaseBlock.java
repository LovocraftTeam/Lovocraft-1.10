package de.alles_minecraft.lovocraft.blocks;

import de.alles_minecraft.lovocraft.Lovocraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BaseBlock extends Block{

	public BaseBlock(Material materialIn) {
		super(materialIn);
		this.setCreativeTab(Lovocraft.INSTANCE.lovo_tab);
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}
	
	public boolean isFireSource(World world, BlockPos pos, EnumFacing side) {
		if (side == EnumFacing.UP) {
			return true;
		} else {
			return false;
		}
	}
}
