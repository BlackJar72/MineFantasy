package mods.battlegear2.api.shield;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public abstract interface IShield
{
  public abstract float getDecayRate(ItemStack paramItemStack);
  
  public abstract float getRecoveryRate(ItemStack paramItemStack);
  
  public abstract boolean canBlock(ItemStack paramItemStack, DamageSource paramDamageSource);
  
  public abstract float getDamageDecayRate(ItemStack paramItemStack, float paramFloat);
  
  public abstract float getBlockAngle(ItemStack paramItemStack);
  
  public abstract int getBashTimer(ItemStack paramItemStack);
  
  public abstract void blockAnimation(EntityPlayer paramEntityPlayer, float paramFloat);
  
  public abstract float getDamageReduction(ItemStack paramItemStack, DamageSource paramDamageSource);
}


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/shield/IShield.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */