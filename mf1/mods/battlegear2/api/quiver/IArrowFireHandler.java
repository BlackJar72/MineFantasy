package mods.battlegear2.api.quiver;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract interface IArrowFireHandler
{
  public abstract boolean canFireArrow(ItemStack paramItemStack, World paramWorld, EntityPlayer paramEntityPlayer, float paramFloat);
  
  public abstract EntityArrow getFiredArrow(ItemStack paramItemStack, World paramWorld, EntityPlayer paramEntityPlayer, float paramFloat);
}


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/quiver/IArrowFireHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */