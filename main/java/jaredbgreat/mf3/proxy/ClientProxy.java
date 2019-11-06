package jaredbgreat.mf3.proxy;

import jaredbgreat.mf3.entity.EntityDrake;
import jaredbgreat.mf3.model.ModelDrake;
import jaredbgreat.mf3.render.RenderDrake;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy implements IProxy {


	@Override
	public void registerItemRender(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(item.getRegistryName(), id));
	}


	@Override
	public void registerRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntityDrake.class,
				new IRenderFactory<EntityDrake>() {
					@Override
					public Render<EntityDrake> createRenderFor(
							RenderManager manager) {
						return new RenderDrake(manager, new ModelDrake(), 0.5f);
					}
				});
	}


	@Override
	public void registerItemRenders(ModelRegistryEvent event) {
		
	}
}
