package minefantasy.api.forge;

import net.minecraft.item.ItemStack;

public abstract interface IHotItem
{
  public abstract boolean isHot(ItemStack paramItemStack);
  
  public abstract boolean isCoolable(ItemStack paramItemStack);
}


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/forge/IHotItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */