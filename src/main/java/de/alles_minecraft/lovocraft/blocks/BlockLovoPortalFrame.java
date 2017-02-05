package de.alles_minecraft.lovocraft.blocks;

import java.util.List;

import de.alles_minecraft.lovocraft.enumtypes.EnumLovoPortalFrame;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;



public class BlockLovoPortalFrame extends BaseBlock{

	public static final PropertyEnum<EnumLovoPortalFrame> PROPERTY = PropertyEnum.create("lovo_portal_frame_enum", EnumLovoPortalFrame.class);
	
	public BlockLovoPortalFrame() {
		super(Material.ROCK);	
		this.setUnlocalizedName("lovo_portal_frame");
		this.setSoundType(SoundType.STONE);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(BlockLovoPortalFrame.PROPERTY).getMeta();
	}
	
	@Override
	public float getBlockHardness(IBlockState state, World worldIn, BlockPos pos) {
		return (int) state.getValue(BlockLovoPortalFrame.PROPERTY).hardness;
	}
	
	@Override
	public float getExplosionResistance(World world, BlockPos pos, Entity exploder, Explosion explosion) {
		return (int) world.getBlockState(pos).getValue(BlockLovoPortalFrame.PROPERTY).resistance;
	}
	
	@Override
	public int getHarvestLevel(IBlockState state) {
	
		return (int) state.getValue(BlockLovoPortalFrame.PROPERTY).harvestlevel;
	}
	
	@Override
	public String getHarvestTool(IBlockState state) {
		return "pickaxe";
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(BlockLovoPortalFrame.PROPERTY, EnumLovoPortalFrame.values()[meta]);
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return this.getMetaFromState(state);
	}
				
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
		for(EnumLovoPortalFrame portalframe : EnumLovoPortalFrame.values()){
			list.add(new ItemStack(this,1,portalframe.getMeta()));
		}
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {BlockLovoPortalFrame.PROPERTY});
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		if(state.getValue(PROPERTY).equals(EnumLovoPortalFrame.FRAMEEMPTY))return false;
		return true;
	}
	
	@Override
	public boolean isFullBlock(IBlockState s) {
		if(s.getValue(PROPERTY).equals(EnumLovoPortalFrame.FRAMEEMPTY))return false;
		return true;
	}
	
	@Override
	public boolean isFullCube(IBlockState s) {
		if(s.getValue(PROPERTY).equals(EnumLovoPortalFrame.FRAMEEMPTY))return false;
		return true;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT_MIPPED;
	}
	
}
