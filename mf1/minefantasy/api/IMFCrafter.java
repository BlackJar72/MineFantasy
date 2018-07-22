package minefantasy.api;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;

public abstract interface IMFCrafter
{
  @SideOnly(Side.CLIENT)
  public abstract boolean shouldRenderCraftMetre();
  
  @SideOnly(Side.CLIENT)
  public abstract int getProgressBar(int paramInt);
  
  @SideOnly(Side.CLIENT)
  public abstract String getResultName();
  
  @SideOnly(Side.CLIENT)
  public abstract void setTempResult(ItemStack paramItemStack);
}


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/IMFCrafter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */