package de.alles_minecraft.lovocraft.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerLovoFurnace extends Container{
	
	public ContainerLovoFurnace(IInventory tile,InventoryPlayer player) {
		
		super.addSlotToContainer(new Slot(tile, 0, 149, 36));
		super.addSlotToContainer(new Slot(tile, 1, 8, 10));
		super.addSlotToContainer(new Slot(tile, 2, 8, 35));
		super.addSlotToContainer(new Slot(tile, 3, 8, 53));
		
		for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j)
            {
                this.addSlotToContainer(new Slot(tile, j + i * 3 + 4, 53 + j * 18, 17 + i * 18));
            }
        }
		
		for (int i = 0; i < 4; ++i)
        {
            for (int j = 0; j < 4; ++j)
            {
                this.addSlotToContainer(new Slot(tile, j + i * 4 + 13, 178 + j * 18, 9 + i * 18));
            }
        }
		
		for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int k = 0; k < 9; ++k)
        {
            this.addSlotToContainer(new Slot(player, k, 8 + k * 18, 142));
        }
	}
	
	@Override
	protected void retrySlotClick(int slotId, int clickedButton, boolean mode, EntityPlayer playerIn) {}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}

}
