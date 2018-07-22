package mods.battlegear2.api.weapons;

import java.util.Map;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;

public abstract interface IPotionEffect
{
  public abstract Map<PotionEffect, Float> getEffectsOnHit(EntityLivingBase paramEntityLivingBase1, EntityLivingBase paramEntityLivingBase2);
}


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/weapons/IPotionEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */