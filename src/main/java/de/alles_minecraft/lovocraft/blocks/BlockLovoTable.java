package de.alles_minecraft.lovocraft.blocks;

import java.util.List;
import java.util.Random;

import de.alles_minecraft.lovocraft.LBlocks;
import de.alles_minecraft.lovocraft.Lovocraft;
import de.alles_minecraft.lovocraft.events.UnregisterRenderEvent;
import de.alles_minecraft.lovocraft.render.RenderTabelSpc;
import de.alles_minecraft.lovocraft.tileentity.TileEntityLovoFurnace;
import de.alles_minecraft.lovocraft.tileentity.TileEntityTable;
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
import net.minecraft.entity.Entity;
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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class BlockLovoTable extends BaseBlock implements ITileEntityProvider{
	
	protected static final AxisAlignedBB LOVO_TABLE_AABB = new AxisAlignedBB(0.19D, 0.0D, 0.19D, 0.81D, 0.94D, 0.81D);
	
	
	public BlockLovoTable() {
		super(Material.ROCK);
		this.setSoundType(SoundType.STONE);
		this.setUnlocalizedName("lovo_table");
     	this.setHardness(4F);
		this.setResistance(12.0F);
		}
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
	    return LOVO_TABLE_AABB;
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn) {
		if(!worldIn.isSideSolid(pos.down(), EnumFacing.UP, false)){
			this.breakBlock(worldIn, pos, state);
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		if(side.equals(EnumFacing.UP)){
			((TileEntityTable)worldIn.getTileEntity(pos)).addItem(heldItem);
			if(playerIn.inventory.getCurrentItem() != null){
				playerIn.inventory.getCurrentItem().stackSize--;
				if(playerIn.inventory.getCurrentItem().stackSize <= 0){
					playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, null);
				}
			}
			return true;
		}
		return false;
	}
	
	@Override
	public String getHarvestTool(IBlockState state) {
		return "pickaxe";
	}

	@Override
	public int getHarvestLevel(IBlockState state) {
		return 1;
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		MinecraftForge.EVENT_BUS.post(new UnregisterRenderEvent(worldIn, pos, RenderTabelSpc.class));
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return true;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullBlock(IBlockState s) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState s) {
		return false;
	}
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityTable();
	}
}
