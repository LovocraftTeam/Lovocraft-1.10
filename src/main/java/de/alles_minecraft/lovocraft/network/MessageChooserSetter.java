package de.alles_minecraft.lovocraft.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageChooserSetter implements IMessage, IMessageHandler<MessageChooserSetter, IMessage>{

	private int id;
	private boolean state;
	private BlockPos pos;
	
	public MessageChooserSetter() {}
	
	public MessageChooserSetter(int id,boolean b,BlockPos pos) {
		this.state = b;
		this.id = id;
		this.pos = pos;
	}
	
	@Override
	public IMessage onMessage(MessageChooserSetter message, MessageContext ctx) {
		TileEntity tile = ctx.getServerHandler().playerEntity.worldObj.getTileEntity(message.pos);
		if(tile != null && tile instanceof INetworkChooseButttonProvider){
			INetworkChooseButttonProvider inv = (INetworkChooseButttonProvider) tile;
			inv.setValue(message.id,message.state);
		}
		return null;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.id = buf.readInt();
		this.pos = new BlockPos(buf.readInt(), buf.readInt(), buf.readInt());
		this.state = buf.readBoolean();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.id);
		buf.writeInt(this.pos.getX());
		buf.writeInt(this.pos.getY());
		buf.writeInt(this.pos.getZ());
		buf.writeBoolean(this.state);
	}

}
