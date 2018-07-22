package mods.battlegear2.api.quiver;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public abstract interface IQuiverSelection
{
  public abstract ItemStack getQuiverFor(ItemStack paramItemStack, EntityPlayer paramEntityPlayer);
}


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/quiver/IQuiverSelection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */