package minefantasy.api.weapon;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

public abstract interface IHitReaction
{
  public abstract void onUserHit(DamageSource paramDamageSource, EntityLivingBase paramEntityLivingBase);
}


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/weapon/IHitReaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */