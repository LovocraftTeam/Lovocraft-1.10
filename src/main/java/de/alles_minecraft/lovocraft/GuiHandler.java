package de.alles_minecraft.lovocraft;

import de.alles_minecraft.lovocraft.container.ContainerLovoFurnace;
import de.alles_minecraft.lovocraft.gui.GuiLovoFurnace;
import de.alles_minecraft.lovocraft.tileentity.TileEntityLovoFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity ent = world.getTileEntity(new BlockPos(x, y, z));
		if(ent instanceof TileEntityLovoFurnace){
			return new ContainerLovoFurnace((IInventory) ent,player.inventory);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity ent = world.getTileEntity(new BlockPos(x, y, z));
		if(ent instanceof TileEntityLovoFurnace){
			return new GuiLovoFurnace((IInventory) ent,player.inventory);
		}
		return null;
	}

}
