/*    */ package minefantasy.api.anvil;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class RecipeSorterAnvil
/*    */   implements Comparator
/*    */ {
/*    */   final CraftingManagerAnvil craftingManager;
/*    */   
/*    */   RecipeSorterAnvil(CraftingManagerAnvil manager)
/*    */   {
/* 16 */     this.craftingManager = manager;
/*    */   }
/*    */   
/*    */   public int compareRecipes(IAnvilRecipe recipe1, IAnvilRecipe recipe2) {
/* 20 */     return recipe2.getRecipeSize() > recipe1.getRecipeSize() ? 1 : recipe2.getRecipeSize() < recipe1.getRecipeSize() ? -1 : ((recipe2 instanceof ShapelessAnvilRecipes)) && ((recipe1 instanceof ShapedAnvilRecipes)) ? -1 : ((recipe1 instanceof ShapelessAnvilRecipes)) && ((recipe2 instanceof ShapedAnvilRecipes)) ? 1 : 0;
/*    */   }
/*    */   
/*    */   public int compare(Object input1, Object input2)
/*    */   {
/* 25 */     return compareRecipes((IAnvilRecipe)input1, (IAnvilRecipe)input2);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/anvil/RecipeSorterAnvil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */