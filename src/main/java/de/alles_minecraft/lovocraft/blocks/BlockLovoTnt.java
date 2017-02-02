package de.alles_minecraft.lovocraft.blocks;

import java.util.Random;

import de.alles_minecraft.lovocraft.LBlocks;
import de.alles_minecraft.lovocraft.Lovocraft;
import de.alles_minecraft.lovocraft.tileentity.TileEntityLovoFurnace;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
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

public class BlockLovoTnt extends BaseBlock {
	public BlockLovoTnt() {
		super(Material.TNT);
		this.setSoundType(SoundType.PLANT);
		this.setUnlocalizedName("lovo_tnt");
     	this.setHardness(0.2F);
		}
	
	   public boolean isOpaqueCube(IBlockState state)
	    {
	        return false;
	    }
}
