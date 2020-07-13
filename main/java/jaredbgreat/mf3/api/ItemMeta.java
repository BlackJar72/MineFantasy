package jaredbgreat.mf3.api;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemMeta {
	public final Item item;
	public final int  meta;	
	
	public ItemMeta(Item item, int meta) {
		this.item = item;
		this.meta = meta;
	}	
	
	public ItemMeta(ItemStack item) {
		this.item = item.getItem();
		this.meta = item.getItemDamage();
	}
	
	public ItemStack getStack(int number) {
		return new ItemStack(item, Math.min(number, item.getItemStackLimit()), meta);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ItemMeta) {
			ItemMeta other = (ItemMeta)o;
			return ((item == other.item) && (meta == other.meta));
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return item.hashCode() ^ (meta + (meta << 16));
	}
	
	
	
}
