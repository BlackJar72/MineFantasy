package mods.battlegear2.api.core;

import net.minecraft.entity.Entity;

public abstract interface IBattlePlayer
{
  public abstract void swingOffItem();
  
  public abstract float getOffSwingProgress(float paramFloat);
  
  public abstract void attackTargetEntityWithCurrentOffItem(Entity paramEntity);
  
  public abstract boolean isBattlemode();
  
  public abstract boolean isBlockingWithShield();
  
  public abstract void setBlockingWithShield(boolean paramBoolean);
  
  public abstract int getSpecialActionTimer();
  
  public abstract void setSpecialActionTimer(int paramInt);
}


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/core/IBattlePlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */