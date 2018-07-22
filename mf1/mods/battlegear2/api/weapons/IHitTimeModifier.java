package mods.battlegear2.api.weapons;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public abstract interface IHitTimeModifier
{
  public abstract int getHitTime(ItemStack paramItemStack, EntityLivingBase paramEntityLivingBase);
}


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/weapons/IHitTimeModifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */