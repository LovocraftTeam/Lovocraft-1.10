package io.github.mc_umod.registrys;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/**
 * Class for Item and Block Render registering
 * 
 * @author MrTroble
 *
 */
public class RenderRegistery extends BaseRegistery{
	
	private ItemModelMesher mesher;
	private String modID;
	
	/**
	 * Needs ModID where the assets are located
	 * 
	 * @param modid
	 */
	public RenderRegistery(String modid) {
		this.mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		this.modID = modid;
	}
	
	/**
	 * Registers a Block Model and all its subtypes<br>
	 * <strong>Unlocalized Name has to be set</strong>
	 * 
	 * @param block
	 */
	public void register(Block block){
		this.register(Item.getItemFromBlock(block));
	}
	
	/**
	 * Registers a Item and all its subtypes<br>
	 * <strong>Unlocalized Name has to be set!</strong>
	 * 
	 * @param item
	 */
	public void register(Item item){
	    if(item instanceof ItemBlock){
	    	Block b = Block.getBlockFromItem(item);
	    	ImmutableList<IBlockState> list = b.getBlockState().getValidStates();
	    	if(list.size() > 1){
	    		ResourceLocation[] locs = new ResourceLocation[list.size()];
	    	    int i = 0;
	    	    for(IBlockState state : list){
	    	    	int met = b.getMetaFromState(state);
	    	    	String stg = this.formate(item.getUnlocalizedName(new ItemStack(b,1,met)));
		    	    this.mesher.register(item, met, new ModelResourceLocation(this.modID + ":" + stg,"inventory"));
	    		    locs[i] = new ResourceLocation(this.modID , stg);
	    		    i++;
	    	
	    	    }
    		    ModelBakery.registerItemVariants(item, locs);
	    	}else{
		    	this.mesher.register(item, 0, new ModelResourceLocation(this.modID + ":" + this.formate(item.getUnlocalizedName()),"inventory"));
	    	}
	    }else if(!item.getHasSubtypes()){
	    	this.mesher.register(item, 0, new ModelResourceLocation(this.modID + ":" + this.formate(item.getUnlocalizedName()),"inventory"));
	    }else{
	    	List<ItemStack> list = Lists.newArrayList();
	    	item.getSubItems(item, CreativeTabs.INVENTORY, list);
	    	ResourceLocation[] locs = new ResourceLocation[list.size()];
	    	int i = 0;
	    	for(ItemStack st : list){
		    	this.mesher.register(item, st.getMetadata(), new ModelResourceLocation(this.modID + ":" + this.formate(item.getUnlocalizedName()),"inventory"));
		    	locs[i] = new ResourceLocation(this.modID , this.formate(st.getUnlocalizedName()));
	    		i++;
	    	}
    		ModelBakery.registerItemVariants(item, locs);
	    }
	}
}
