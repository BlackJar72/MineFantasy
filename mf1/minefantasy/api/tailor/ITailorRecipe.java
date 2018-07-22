package minefantasy.api.tailor;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;

public abstract interface ITailorRecipe
{
  public abstract boolean matches(InventoryCrafting paramInventoryCrafting);
  
  public abstract ItemStack getCraftingResult(InventoryCrafting paramInventoryCrafting);
  
  public abstract int getStitchCount();
  
  public abstract float getStitchTime();
  
  public abstract int getRecipeSize();
  
  public abstract int getTier();
  
  public abstract int getString();
  
  public abstract ItemStack getRecipeOutput();
}


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/tailor/ITailorRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */