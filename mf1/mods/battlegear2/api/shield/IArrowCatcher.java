package mods.battlegear2.api.shield;

import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public abstract interface IArrowCatcher
{
  public abstract boolean catchArrow(ItemStack paramItemStack, EntityPlayer paramEntityPlayer, IProjectile paramIProjectile);
}


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/shield/IArrowCatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */