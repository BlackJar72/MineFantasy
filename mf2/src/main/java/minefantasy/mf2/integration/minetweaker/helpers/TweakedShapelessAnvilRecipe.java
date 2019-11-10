package minefantasy.mf2.integration.minetweaker.helpers;

import minefantasy.mf2.api.crafting.anvil.AnvilCraftMatrix;
import minefantasy.mf2.api.crafting.anvil.IAnvilRecipe;
import minefantasy.mf2.api.rpg.Skill;
import minetweaker.api.item.IIngredient;
import minetweaker.api.item.IItemStack;
import minetweaker.api.minecraft.MineTweakerMC;
import net.minecraft.item.ItemStack;

public class TweakedShapelessAnvilRecipe implements IAnvilRecipe {

    private int hammer, anvil, /* craft, */
            time, width, height;
    private IItemStack result;
    private IIngredient[] ingreds;
    private Skill s;
    private String research, tool;
    private boolean hot;

    public TweakedShapelessAnvilRecipe(IIngredient[] input, IItemStack output, String tool, int time, int hammer,
                                       int anvil, boolean hot, String research, Skill s) {
        this.height = 4;
        this.width = 4;
        this.ingreds = input;
        this.result = output;
        this.tool = tool;
        this.hammer = hammer;
        this.anvil = anvil;
        this.hot = hot;
        this.research = research;
        this.s = s;
        this.time = time;
    }

    @Override
    public int getAnvil() {
        return anvil;
    }

    @Override
    public int getCraftTime() {
        return time;
    }

    @Override
    public ItemStack getCraftingResult(AnvilCraftMatrix arg0) {
        return this.getRecipeOutput().copy();
    }

    @Override
    public int getRecipeHammer() {
        return hammer;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return MineTweakerMC.getItemStack(result).copy();
    }

    @Override
    public int getRecipeSize() {
        return this.width * this.height;
    }

    @Override
    public String getResearch() {
        return research;
    }

    @Override
    public Skill getSkill() {
        return s;
    }

    @Override
    public String getToolType() {
        return tool;
    }

    @Override
    public boolean matches(AnvilCraftMatrix inv) {
        boolean matches[] = new boolean[this.ingreds.length];
        boolean items[][] = new boolean[6][4];
        for (int a = 0; a < this.ingreds.length; a++) {
            IIngredient i = this.ingreds[a];
            for (IItemStack s : i.getItems()) {
                ItemStack ingred = MineTweakerMC.getItemStack(s);
                boolean found = false;
                for (int x = 0; x < 6; x++) {
                    for (int y = 0; y < 4; y++) {
                        ItemStack stack = inv.getStackInRowAndColumn(x, y);
                        if (stack == null)
                            continue;
                        if (stack.getItem() == ingred.getItem() && stack.getItemDamage() == ingred.getItemDamage()
                                && !items[x][y]) {
                            matches[a] = true;
                            items[x][y] = true;
                            found = true;
                            break;
                        }
                    }
                    if (found)
                        break;
                }
                if (found)
                    break;
            }
        }
        boolean isMatch = true;
        for (boolean b : matches)
            if (!b)
                isMatch = false;
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 4; y++) {
                if (!items[x][y] && inv.getStackInRowAndColumn(x, y) != null)
                    isMatch = false;
            }
        }
        return isMatch;
    }

    @Override
    public boolean outputHot() {
        return hot;
    }

    @Override
    public boolean useCustomTiers() {
        // TODO Auto-generated method stub
        return false;
    }

}
