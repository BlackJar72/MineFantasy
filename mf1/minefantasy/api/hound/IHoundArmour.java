package minefantasy.api.hound;

import net.minecraft.util.DamageSource;

public abstract interface IHoundArmour
{
  public abstract boolean shouldDamage(DamageSource paramDamageSource);
  
  public abstract float getResistance(DamageSource paramDamageSource);
  
  public abstract float getMobilityModifier();
  
  public abstract float getACDisplayPercent();
}


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/hound/IHoundArmour.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */