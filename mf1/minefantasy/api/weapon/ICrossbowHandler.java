package minefantasy.api.weapon;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract interface ICrossbowHandler
{
  public abstract boolean shoot(ItemStack paramItemStack1, World paramWorld, EntityPlayer paramEntityPlayer, float paramFloat1, float paramFloat2, ItemStack paramItemStack2);
}


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/weapon/ICrossbowHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */