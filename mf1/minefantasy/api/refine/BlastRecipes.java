/*    */ package minefantasy.api.refine;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class BlastRecipes
/*    */ {
/*    */   public final ItemStack input;
/*    */   public final ItemStack result;
/* 11 */   public static List<BlastRecipes> recipeList = new ArrayList();
/*    */   
/*    */   public BlastRecipes(ItemStack in, ItemStack out) {
/* 14 */     this.input = in;
/* 15 */     this.result = out;
/*    */   }
/*    */   
/*    */   public static ItemStack getResult(ItemStack in) {
/* 19 */     if (in == null) {
/* 20 */       return null;
/*    */     }
/* 22 */     for (int a = 0; a < recipeList.size(); a++) {
/* 23 */       BlastRecipes recipe = (BlastRecipes)recipeList.get(a);
/* 24 */       if (recipe.input.func_77969_a(in)) {
/* 25 */         return recipe.result;
/*    */       }
/*    */     }
/* 28 */     return null;
/*    */   }
/*    */   
/*    */   public static void add(BlastRecipes forgeRecipe) {
/* 32 */     if (recipeList == null) {
/* 33 */       recipeList = new ArrayList();
/*    */     } else {
/* 35 */       recipeList.add(forgeRecipe);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/refine/BlastRecipes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */