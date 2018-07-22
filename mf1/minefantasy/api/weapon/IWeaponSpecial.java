package minefantasy.api.weapon;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public abstract interface IWeaponSpecial
{
  public abstract void onHit(float paramFloat, ItemStack paramItemStack, EntityLivingBase paramEntityLivingBase1, EntityLivingBase paramEntityLivingBase2);
}


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/weapon/IWeaponSpecial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */