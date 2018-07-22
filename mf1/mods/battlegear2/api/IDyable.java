package mods.battlegear2.api;

import net.minecraft.item.ItemStack;

public abstract interface IDyable
{
  public abstract boolean hasColor(ItemStack paramItemStack);
  
  public abstract int getColor(ItemStack paramItemStack);
  
  public abstract void setColor(ItemStack paramItemStack, int paramInt);
  
  public abstract void removeColor(ItemStack paramItemStack);
  
  public abstract int getDefaultColor(ItemStack paramItemStack);
}


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/IDyable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */