package jaredbgreat.mf3.api.crafting.anvil;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;

public interface IAnvilRecipe {
    /**
     * Used to check if a recipe matches current crafting inventory
     */
    boolean matches(InventoryCrafting var1);

    /**
     * Returns an Item that is the result of this recipe
     */
    ItemStack getCraftingResult(InventoryCrafting var1);
    int getCraftTime();
    /**
     * Returns the size of the recipe area
     */
    int getRecipeSize();
    
    int getRecipeHammer();
    
    float getExperiance();
    
    int getAnvil();
    
    boolean outputHot();
    
    String getToolType();
    
    String getResearch();
    
    ItemStack getRecipeOutput();
    
    // TODO: Add skills ... or not...?
    //Skill getSkill();
}
