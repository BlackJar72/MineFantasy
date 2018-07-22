package minefantasy.api.weapon;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public abstract interface IWeaponCustomSpeed
{
  public abstract int getHitTime(ItemStack paramItemStack, EntityLivingBase paramEntityLivingBase);
}


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/weapon/IWeaponCustomSpeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */