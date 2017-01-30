package de.alles_minecraft.lovocraft.blocks;

import java.util.List;

import de.alles_minecraft.lovocraft.enumtypes.EnumLovoOre;
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

public class BlockLovoOre extends BaseBlock{

	public static final PropertyEnum<EnumLovoOre> PROPERTY = PropertyEnum.create("lovo_ore_enum", EnumLovoOre.class);
	
	public BlockLovoOre() {
		super(Material.ROCK);	
		this.setUnlocalizedName("lovo_ore");
		this.setSoundType(SoundType.STONE);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(BlockLovoOre.PROPERTY).getMeta();
	}
	
	@Override
	public float getBlockHardness(IBlockState state, World worldIn, BlockPos pos) {
		return (int) state.getValue(BlockLovoOre.PROPERTY).hardness;
	}
	
	@Override
	public float getExplosionResistance(World world, BlockPos pos, Entity exploder, Explosion explosion) {
		return (int) world.getBlockState(pos).getValue(BlockLovoOre.PROPERTY).resistance;
	}
	
	@Override
	public int getLightValue(IBlockState state) {
		return (int) state.getValue(BlockLovoOre.PROPERTY).light;
	}
	@Override
	public int getHarvestLevel(IBlockState state) {
	
		return (int) state.getValue(BlockLovoOre.PROPERTY).harvestlevel;
	}
	
	@Override
	public String getHarvestTool(IBlockState state) {
		return "pickaxe";
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(BlockLovoOre.PROPERTY, EnumLovoOre.values()[meta]);
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return this.getMetaFromState(state);
	}
				
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
		for(EnumLovoOre ore : EnumLovoOre.values()){
			list.add(new ItemStack(this,1,ore.getMeta()));
		}
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {BlockLovoOre.PROPERTY});
	}
	
}
