package de.alles_minecraft.lovocraft.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageCallback implements IMessage, IMessageHandler<MessageCallback, IMessage>{

	private int id;
	private boolean state;
	
	public MessageCallback() {}
	
	public MessageCallback(int id,boolean b) {
		this.state = b;
		this.id = id;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.id = buf.readInt();
		this.state = buf.readBoolean();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.id);
		buf.writeBoolean(this.state);	}

	
	@Override
	public IMessage onMessage(MessageCallback message, MessageContext ctx) {
		GuiScreen sc = Minecraft.getMinecraft().currentScreen;
		if(sc != null && sc instanceof INetworkChooseButton)((INetworkChooseButton)sc).onNetworkCall(message.id, message.state);
		return null;
	}

}
