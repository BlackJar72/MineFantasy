package jaredbgreat.mf3.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;

public interface IProxy {
	public void registerRenders();
	public void registerItemRenders(ModelRegistryEvent event);
	public void registerItemRender(Item itemFromBlock, int i, String string);
}
