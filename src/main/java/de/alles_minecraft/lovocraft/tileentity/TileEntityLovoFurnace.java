package de.alles_minecraft.lovocraft.tileentity;

import de.alles_minecraft.lovocraft.network.INetworkChooseButtonProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class TileEntityLovoFurnace extends TileEntity implements ISidedInventory, INetworkChooseButtonProvider{
	
	private ItemStack[] stacks = new ItemStack[13];
	private boolean state;

	@Override
	public int getSizeInventory() {
		return this.stacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return this.stacks[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		ItemStack stack = this.stacks[index];
		if(stack.stackSize - count <= 0){
			this.removeStackFromSlot(index);
			return stack;
		}else{
			this.stacks[index].stackSize -= count;
			stack.stackSize = count;
			return stack;
		}
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		ItemStack stack = this.stacks[index];
		this.setInventorySlotContents(index, null);
		return stack;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		this.stacks[index] = stack;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public void openInventory(EntityPlayer player) {}

	@Override
	public void closeInventory(EntityPlayer player) {}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		//TODO SET UP SLOT LOGIC
		return true;
	}

	@Override
	public int getField(int id) {return 0;}

	@Override
	public void setField(int id, int value) {}

	@Override
	public int getFieldCount() {return 0;}

	@Override
	public void clear() {
		this.stacks = new ItemStack[stacks.length];
	}

	@Override
	public String getName() {
		return "TileEntityLovoFurnace";
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		// TODO SET UP SLOT LOGIC FOR HOPPER SUPPORT
		return null;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		// TODO SET UP SLOT LOGIC FOR HOPPER SUPPORT
		return false;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		// TODO SET UP SLOT LOGIC FOR HOPPER SUPPORT
		return false;
	}

	@Override
	public boolean getValue(int id) {
		return this.state;
	}

	@Override
	public void setValue(int id, boolean value) {
		this.state = value;
	}
	
}
