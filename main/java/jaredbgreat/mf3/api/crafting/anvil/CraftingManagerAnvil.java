package jaredbgreat.mf3.api.crafting.anvil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CraftingManagerAnvil {
	
    /** The static instance of this class */
    private static final CraftingManagerAnvil instance = new CraftingManagerAnvil();
    /** A list of all the recipes added */
    public List recipes = new ArrayList();

    
    /**
     * Returns the static instance of this class
     */
    public static CraftingManagerAnvil getInstance() {
        return instance;
    }
    

    private CraftingManagerAnvil() {
    	// TODO: All the required recipe stuff
        //Collections.sort(this.recipes, new RecipeSorterAnvil(this));
        System.out.println("MineFantasy: Anvil recipes initiating");
    }
    
    

}
