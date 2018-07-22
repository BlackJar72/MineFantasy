package mods.battlegear2.api.core;

import net.minecraft.item.ItemStack;

public abstract interface IOffhandRender
{
  public abstract ItemStack getItemToRender();
  
  public abstract void setItemToRender(ItemStack paramItemStack);
  
  public abstract int getEquippedItemSlot();
  
  public abstract void setEquippedItemSlot(int paramInt);
  
  public abstract float getEquippedProgress();
  
  public abstract void setEquippedProgress(float paramFloat);
  
  public abstract float getPrevEquippedProgress();
  
  public abstract void setPrevEquippedProgress(float paramFloat);
}


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/core/IOffhandRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */