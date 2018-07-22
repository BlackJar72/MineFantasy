package minefantasy.entity;

import net.minecraft.entity.Entity;

public abstract interface IArrow
{
  public abstract void setDamage(double paramDouble);
  
  public abstract void setKnockbackStrength(int paramInt);
  
  public abstract void setIsCritical(boolean paramBoolean);
  
  public abstract void setFire(int paramInt);
  
  public abstract Entity getInstance();
  
  public abstract double getDamage();
}


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/IArrow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */