package minefantasy.api.weapon;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

public abstract interface IWeaponSpecialBlock
{
  public abstract float blockDamage(EntityLivingBase paramEntityLivingBase, float paramFloat, DamageSource paramDamageSource);
}


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/weapon/IWeaponSpecialBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */