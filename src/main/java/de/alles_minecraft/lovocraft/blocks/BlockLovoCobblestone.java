package de.alles_minecraft.lovocraft.blocks;

import java.util.Random;

import de.alles_minecraft.lovocraft.LBlocks;
import de.alles_minecraft.lovocraft.Lovocraft;
import de.alles_minecraft.lovocraft.tileentity.TileEntityLovoFurnace;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.BlockStone;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLovoCobblestone extends BaseBlock {
	public BlockLovoCobblestone() {
		super(Material.ROCK);
		this.setSoundType(SoundType.STONE);
		this.setUnlocalizedName("lovo_cobblestone");
     	this.setHardness(3F);
		this.setResistance(10.0F);
		}
	
	@Override
	public String getHarvestTool(IBlockState state) {
		return "pickaxe";
	}
	
	@Override
	public int getHarvestLevel(IBlockState state) {
		return 1;
	}
}
