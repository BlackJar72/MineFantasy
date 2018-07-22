package minefantasy.api.tactic;

import net.minecraft.entity.Entity;

public abstract interface IGuard
{
  public abstract void onDetectPickpocket(Entity paramEntity1, Entity paramEntity2);
  
  public abstract void onDetectAssault(Entity paramEntity1, Entity paramEntity2);
  
  public abstract void onDetectMurder(Entity paramEntity1, Entity paramEntity2);
}


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/tactic/IGuard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */