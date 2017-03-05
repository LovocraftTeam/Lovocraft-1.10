package de.alles_minecraft.lovocraft.tileentity;

import de.alles_minecraft.lovocraft.events.RegisterRenderEvent;
import de.alles_minecraft.lovocraft.events.UnregisterRenderEvent;
import de.alles_minecraft.lovocraft.render.RenderTabelSpc;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;

public class TileEntityTable extends TileEntity{

    private ItemStack stack1;
    private ItemStack stack2;
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		if(this.stack1 != null)compound.setTag("0", this.stack1.writeToNBT(new NBTTagCompound()));
		if(this.stack2 != null)compound.setTag("1", this.stack2.writeToNBT(new NBTTagCompound()));
		return super.writeToNBT(compound);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		if(compound.hasKey("0"))this.stack1 = ItemStack.loadItemStackFromNBT(compound.getCompoundTag("0"));
		if(compound.hasKey("1"))this.stack2 = ItemStack.loadItemStackFromNBT(compound.getCompoundTag("1"));
	}
	
	public void addItem(ItemStack s){
		if(s == null){
			if(this.stack1 != null){
				Block.spawnAsEntity(this.worldObj, this.pos, this.stack1);
				this.stack1 = null;
			}
			if(this.stack2 != null){
				Block.spawnAsEntity(this.worldObj, this.pos, this.stack2);
				this.stack2 = null;
			}
			return;
		}
		if(this.stack1 != null && this.stack1.isItemEqual(s)){
			if(this.stack1.stackSize >= 64){
				Block.spawnAsEntity(this.worldObj, this.pos, new ItemStack(s.getItem(),1,s.getMetadata()));
			}else{
				this.stack1.stackSize++;
			}
			return;
		}
		if(this.stack2 != null && this.stack2.isItemEqual(s)){
			if(this.stack2.stackSize >= 64){
				Block.spawnAsEntity(this.worldObj, this.pos, new ItemStack(s.getItem(),1,s.getMetadata()));
			}else{
				this.stack2.stackSize++;
			}
			return;
		}
		if(this.stack1 == null){
			this.stack1 = new ItemStack(s.getItem(),1,s.getMetadata());
			return;
		}
		if(this.stack2 == null){
			this.stack2 = new ItemStack(s.getItem(),1,s.getMetadata());
			return;
		}
		Block.spawnAsEntity(this.worldObj, this.pos, new ItemStack(s.getItem(),1,s.getMetadata()));
	}
	
	@Override
	public void onChunkUnload() {
		MinecraftForge.EVENT_BUS.post(new UnregisterRenderEvent(worldObj, pos, RenderTabelSpc.class));
	}
	
	@Override
	public void onLoad() {
		MinecraftForge.EVENT_BUS.post(new RegisterRenderEvent(worldObj, pos, RenderTabelSpc.class));
	}
	
	@Override
	public ITextComponent getDisplayName() {
		return new TextComponentString("InDev") ;
	}
}
