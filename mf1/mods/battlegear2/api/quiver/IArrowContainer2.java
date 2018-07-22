package mods.battlegear2.api.quiver;

import mods.battlegear2.api.PlayerEventChild.QuiverArrowEvent.Firing;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract interface IArrowContainer2
{
  public abstract int getSlotCount(ItemStack paramItemStack);
  
  public abstract int getSelectedSlot(ItemStack paramItemStack);
  
  public abstract void setSelectedSlot(ItemStack paramItemStack, int paramInt);
  
  public abstract ItemStack getStackInSlot(ItemStack paramItemStack, int paramInt);
  
  public abstract void setStackInSlot(ItemStack paramItemStack1, int paramInt, ItemStack paramItemStack2);
  
  public abstract boolean hasArrowFor(ItemStack paramItemStack1, ItemStack paramItemStack2, EntityPlayer paramEntityPlayer, int paramInt);
  
  public abstract EntityArrow getArrowType(ItemStack paramItemStack, World paramWorld, EntityPlayer paramEntityPlayer, float paramFloat);
  
  public abstract void onArrowFired(World paramWorld, EntityPlayer paramEntityPlayer, ItemStack paramItemStack1, ItemStack paramItemStack2, EntityArrow paramEntityArrow);
  
  public abstract void onPreArrowFired(PlayerEventChild.QuiverArrowEvent.Firing paramFiring);
  
  public abstract boolean isCraftableWithArrows(ItemStack paramItemStack1, ItemStack paramItemStack2);
  
  public abstract ItemStack addArrows(ItemStack paramItemStack1, ItemStack paramItemStack2);
}


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/quiver/IArrowContainer2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */