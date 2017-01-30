package de.alles_minecraft.lovocraft.blocks;

import java.util.List;

import de.alles_minecraft.lovocraft.enumtypes.EnumLovoBrick;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;



public class BlockLovoBrick extends BaseBlock{

	public static final PropertyEnum<EnumLovoBrick> PROPERTY = PropertyEnum.create("lovo_brick_enum", EnumLovoBrick.class);
	
	public BlockLovoBrick() {
		super(Material.ROCK);	
		this.setUnlocalizedName("lovo_brick");
		this.setSoundType(SoundType.STONE);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(BlockLovoBrick.PROPERTY).getMeta();
	}
	
	@Override
	public float getBlockHardness(IBlockState state, World worldIn, BlockPos pos) {
		return (int) state.getValue(BlockLovoBrick.PROPERTY).hardness;
	}
	
	@Override
	public float getExplosionResistance(World world, BlockPos pos, Entity exploder, Explosion explosion) {
		return (int) world.getBlockState(pos).getValue(BlockLovoBrick.PROPERTY).resistance;
	}
	
	@Override
	public int getHarvestLevel(IBlockState state) {
	
		return (int) state.getValue(BlockLovoBrick.PROPERTY).harvestlevel;
	}
	
	@Override
	public String getHarvestTool(IBlockState state) {
		return "pickaxe";
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(BlockLovoBrick.PROPERTY, EnumLovoBrick.values()[meta]);
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return this.getMetaFromState(state);
	}
				
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
		for(EnumLovoBrick brick : EnumLovoBrick.values()){
			list.add(new ItemStack(this,1,brick.getMeta()));
		}
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {BlockLovoBrick.PROPERTY});
	}
	
}
