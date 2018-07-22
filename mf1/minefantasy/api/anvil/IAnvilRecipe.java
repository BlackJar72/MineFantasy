package minefantasy.api.anvil;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;

public abstract interface IAnvilRecipe
{
  public abstract boolean matches(InventoryCrafting paramInventoryCrafting);
  
  public abstract ItemStack getCraftingResult(InventoryCrafting paramInventoryCrafting);
  
  public abstract int getCraftTime();
  
  public abstract int getRecipeSize();
  
  public abstract int getRecipeHammer();
  
  public abstract float getExperiance();
  
  public abstract int getAnvil();
  
  public abstract boolean outputHot();
  
  public abstract ItemStack getRecipeOutput();
}


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/anvil/IAnvilRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */