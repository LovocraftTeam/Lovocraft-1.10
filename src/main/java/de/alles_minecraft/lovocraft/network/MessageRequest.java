package de.alles_minecraft.lovocraft.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageRequest implements IMessage,IMessageHandler<MessageRequest, MessageCallback>{

	public MessageRequest() {}
	
	private int id;
 	private BlockPos pos;
	
	public MessageRequest(int id,BlockPos pos) {
		this.id = id;
		this.pos = pos;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.id = buf.readInt();
		this.pos = new BlockPos(buf.readInt(), buf.readInt(), buf.readInt());
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.id);
		buf.writeInt(this.pos.getX());
		buf.writeInt(this.pos.getY());
		buf.writeInt(this.pos.getZ());
	}


	@Override
	public MessageCallback onMessage(MessageRequest message, MessageContext ctx) {
		TileEntity tile = ctx.getServerHandler().playerEntity.worldObj.getTileEntity(message.pos);
		if(tile != null && tile instanceof INetworkChooseButtonProvider){
			INetworkChooseButtonProvider inv = (INetworkChooseButtonProvider) tile;
			return new MessageCallback(message.id, inv.getValue(message.id));
		}
		return null;
	}

}
