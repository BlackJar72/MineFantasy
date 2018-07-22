package mods.battlegear2.api.heraldry;

import java.util.List;
import net.minecraft.item.ItemStack;

public abstract interface IFlagHolder
{
  public abstract void clearFlags();
  
  public abstract boolean addFlag(ItemStack paramItemStack);
  
  public abstract List<ItemStack> getFlags();
}


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/heraldry/IFlagHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */