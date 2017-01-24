package de.alles_minecraft.lovocraft.blocks;

import java.util.List;

import de.alles_minecraft.lovocraft.enumtypes.EnumLovoOres;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BlockOres extends BaseBlock{

	public static final PropertyEnum<EnumLovoOres> PROPERTY = PropertyEnum.create("lovo_ore_enum", EnumLovoOres.class);
	
	public BlockOres() {
		super(Material.GROUND);	
		this.setUnlocalizedName("lovo_ores");
		this.setSoundType(SoundType.STONE);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(BlockOres.PROPERTY).getMeta();
	}
	
	@Override
	public String getHarvestTool(IBlockState state) {
		return "pickaxe";
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(BlockOres.PROPERTY, EnumLovoOres.values()[meta]);
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return this.getMetaFromState(state);
	}
				
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
		for(EnumLovoOres ore : EnumLovoOres.values()){
			list.add(new ItemStack(this,1,ore.getMeta()));
		}
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {BlockOres.PROPERTY});
	}
	
}
