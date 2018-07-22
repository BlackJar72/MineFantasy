package mods.battlegear2.api;

import cpw.mods.fml.relauncher.Side;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public abstract interface IOffhandDual
{
  public abstract boolean isOffhandHandDual(ItemStack paramItemStack);
  
  public abstract boolean offhandAttackEntity(PlayerEventChild.OffhandAttackEvent paramOffhandAttackEvent, ItemStack paramItemStack1, ItemStack paramItemStack2);
  
  public abstract boolean offhandClickAir(PlayerInteractEvent paramPlayerInteractEvent, ItemStack paramItemStack1, ItemStack paramItemStack2);
  
  public abstract boolean offhandClickBlock(PlayerInteractEvent paramPlayerInteractEvent, ItemStack paramItemStack1, ItemStack paramItemStack2);
  
  public abstract void performPassiveEffects(Side paramSide, ItemStack paramItemStack1, ItemStack paramItemStack2);
}


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/IOffhandDual.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */