package de.alles_minecraft.lovocraft.network;

import de.alles_minecraft.lovocraft.Lovocraft;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class Packet{
	
	public final SimpleNetworkWrapper wrapper = NetworkRegistry.INSTANCE.newSimpleChannel(Lovocraft.MODID);
	
	public Packet() {
		wrapper.registerMessage(MessageRequest.class, MessageRequest.class, 0, Side.SERVER);
		wrapper.registerMessage(MessageCallback.class, MessageCallback.class, 1, Side.CLIENT);
		wrapper.registerMessage(MessageChooserSetter.class, MessageChooserSetter.class, 2, Side.SERVER);
	}

}
