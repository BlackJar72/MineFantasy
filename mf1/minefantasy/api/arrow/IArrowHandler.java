package minefantasy.api.arrow;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract interface IArrowHandler
{
  public abstract boolean onFireArrow(World paramWorld, ItemStack paramItemStack1, ItemStack paramItemStack2, EntityPlayer paramEntityPlayer, float paramFloat, boolean paramBoolean);
}


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/arrow/IArrowHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */