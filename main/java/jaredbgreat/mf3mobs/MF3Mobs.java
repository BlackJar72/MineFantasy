package jaredbgreat.mf3mobs;

import jaredbgreat.mf3mobs.proxy.IProxy;
import jaredbgreat.mf3mobs.util.MobRegistrar;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=ModInfo.ID, name=ModInfo.NAME, 
version=ModInfo.VERSION, acceptableRemoteVersions=ModInfo.VERSION) 
public class MF3Mobs {
	
    @Instance(ModInfo.ID)
    public static MF3Mobs instance;
    
	@SidedProxy(clientSide = "jaredbgreat.mf3mobs.proxy.ClientProxy",
				serverSide = "jaredbgreat.mf3mobs.proxy.ServerProxy")
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
