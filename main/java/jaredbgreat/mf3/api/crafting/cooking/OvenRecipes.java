package jaredbgreat.mf3.api.crafting.cooking;

import jaredbgreat.mf3.api.ItemMeta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class OvenRecipes
{
    /** The list of smelting results. */
    private static Map smeltingList = new HashMap();
    private static Map experienceList = new HashMap();
    private static HashMap<List<ItemMeta>, ItemStack> metaSmeltingList 
    		 = new HashMap<List<ItemMeta>, ItemStack>();
    private static HashMap<List<ItemMeta>, Float> metaExperience 
    		 = new HashMap<List<ItemMeta>, Float>();

    /**
     * Adds a smelting recipe.
     */
    public static void addSmelting(int id, ItemStack stack, float xp)
    {
        smeltingList.put(Integer.valueOf(id), stack);
        experienceList.put(stack.getItem(), Float.valueOf(xp));
    }

    /**
     * A metadata sensitive version of adding a furnace recipe.
     */
    public static void addSmelting(Item item, int meta, ItemStack itemstack, float experience)
    {
        metaSmeltingList.put(Arrays.asList(new ItemMeta(item, meta)), itemstack);
        metaExperience.put(Arrays.asList(new ItemMeta(item, itemstack.getItemDamage())), experience);
    }

    /**
     * Used to get the resulting ItemStack form a source ItemStack
     * @param item The Source ItemStack
     * @return The result ItemStack
     */
    public static ItemStack getSmeltingResult(ItemStack item) 
    {
        if (item == null)
        {
            return null;
        }
        ItemStack ret = (ItemStack)metaSmeltingList.get(Arrays.asList(item.getItem(), item.getItemDamage()));
        if (ret != null) 
        {
            return ret;
        }
        return (ItemStack)smeltingList.get(item.getItem());
    }

    /**
     * Grabs the amount of base experience for this item to give when pulled from the furnace slot.
     */
    public static float getExperience(ItemStack item)
    {
        if (item == null || item.getItem() == null)
        {
            return 0;
        }
        float ret = item.getItem().getSmeltingExperience(item);
        if (ret < 0 && metaExperience.containsKey(Arrays.asList(item.getItem(), item.getItemDamage())))
        {
            ret = metaExperience.get(Arrays.asList(new ItemMeta(item.getItem(), item.getItemDamage())));
        }
        if (ret < 0 && experienceList.containsKey(item.getItem()))
        {
            ret = ((Float)experienceList.get(item.getItem())).floatValue();
        }
        return (ret < 0 ? 0 : ret);
    }
}
