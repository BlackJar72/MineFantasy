package minefantasy.entity;

import net.minecraft.item.ItemStack;

public abstract interface IThrownItem
{
  public abstract ItemStack getRenderItem();
  
  public abstract int getSpin();
  
  public abstract int getRotate();
  
  public abstract float getScale();
  
  public abstract boolean isEnchanted();
}


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/IThrownItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */