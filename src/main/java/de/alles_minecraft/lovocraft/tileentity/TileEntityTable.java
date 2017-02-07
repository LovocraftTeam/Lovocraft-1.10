package de.alles_minecraft.lovocraft.tileentity;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class TileEntityTable extends TileEntity{

    private ItemStack stack1;
    private ItemStack stack2;
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setTag("0", stack1.writeToNBT(new NBTTagCompound()));
		compound.setTag("1", stack2.writeToNBT(new NBTTagCompound()));
		return super.writeToNBT(compound);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		stack1 = ItemStack.loadItemStackFromNBT(compound.getCompoundTag("0"));
		stack2 = ItemStack.loadItemStackFromNBT(compound.getCompoundTag("1"));
	}
	
	public void addItem(ItemStack s){
		ItemStack st = stack1;
		ItemStack impl_st = stack2;
		if(s == null){
			stack1 = null;
			stack2 = null;
			Block.spawnAsEntity(worldObj, pos, st);
			Block.spawnAsEntity(worldObj, pos, impl_st);
		}
		if(st == null){
			stack1 = s;
		}
		if(impl_st == null){
			stack2 = s;
		}else{
			stack1 = impl_st;
			stack2 = s;
			Block.spawnAsEntity(worldObj, pos, st);
		}
	}
	
	@Override
	public ITextComponent getDisplayName() {
		return new TextComponentString("InDev") ;
	}
}
