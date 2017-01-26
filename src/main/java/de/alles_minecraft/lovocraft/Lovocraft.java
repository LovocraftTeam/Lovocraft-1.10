package de.alles_minecraft.lovocraft;

import org.apache.logging.log4j.Logger;

import de.alles_minecraft.lovocraft.network.Packet;
import de.alles_minecraft.lovocraft.tileentity.TileEntityLovoFurnance;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid=Lovocraft.MODID, acceptedMinecraftVersions="1.10",name="Lovocraft 2",version="0.0.1a",dependencies="required-after:FML",canBeDeactivated=true)
public class Lovocraft {
	
	@Instance("lovocraft")
	public static Lovocraft INSTANCE;
	
	@SidedProxy(serverSide="de.alles_minecraft.lovocraft.CommonProxy",clientSide="de.alles_minecraft.lovocraft.ClientProxy")
	public static CommonProxy PROXY_INSTANCE;
	
	public static final String MODID = "lovocraft";
	
	public Logger log;
	
	public CreativeTabs lovo_tab = new CreativeTabs("lovo_tab") {
		@Override
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Lovocraft.INSTANCE.lblocks.blockore);
		}
	};
	
	public LBlocks lblocks;
	public LItems litems;
	
	public Packet pack;
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent evnt){
		this.log = evnt.getModLog();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent evnt){
		this.pack = new Packet();
		this.litems = new LItems();
		this.lblocks = new LBlocks();
		
		NetworkRegistry.INSTANCE.registerGuiHandler(MODID, new GuiHandler());
		
		PROXY_INSTANCE.registerModels();
		
		TileEntity.addMapping(TileEntityLovoFurnance.class, "LovoFurnace");
	}
	
	@EventHandler
	public void postinit(FMLPostInitializationEvent evnt){
	}
}
