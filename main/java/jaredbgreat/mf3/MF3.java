package jaredbgreat.mf3;

import jaredbgreat.mf3.proxy.IProxy;
import jaredbgreat.mf3.util.MobRegistrar;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=ModInfo.ID, name=ModInfo.NAME, 
version=ModInfo.VERSION, acceptableRemoteVersions=ModInfo.VERSION) 
public class MF3 {
	
    @Instance(ModInfo.ID)
    public static MF3 instance;
    
	@SidedProxy(clientSide = "jaredbgreat.mf3.proxy.ClientProxy",
				serverSide = "jaredbgreat.mf3.proxy.ServerProxy")
	public static IProxy proxy;
	
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    	MobRegistrar.registerMobs();
    	
		proxy.registerRenders();
    }
	
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	
    }
	
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    }

}
