/*    */ package minefantasy.api.tailor;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class RecipeSorterTailor
/*    */   implements Comparator
/*    */ {
/*    */   final CraftingManagerTailor craftingManager;
/*    */   
/*    */   RecipeSorterTailor(CraftingManagerTailor manager)
/*    */   {
/* 16 */     this.craftingManager = manager;
/*    */   }
/*    */   
/*    */   public int compareRecipes(ITailorRecipe recipe1, ITailorRecipe recipe2) {
/* 20 */     return recipe2.getRecipeSize() > recipe1.getRecipeSize() ? 1 : recipe2.getRecipeSize() < recipe1.getRecipeSize() ? -1 : (recipe1 instanceof ShapedTailorRecipes) ? -1 : (recipe2 instanceof ShapedTailorRecipes) ? 1 : 0;
/*    */   }
/*    */   
/*    */   public int compare(Object input1, Object input2) {
/* 24 */     return compareRecipes((ITailorRecipe)input1, (ITailorRecipe)input2);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/tailor/RecipeSorterTailor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */