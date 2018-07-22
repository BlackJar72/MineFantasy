/*    */ package minefantasy.api.refine;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CrushRecipes
/*    */ {
/* 12 */   private static List<CrushRecipe> recipeList = new ArrayList();
/* 13 */   private static List<ICustomCrushRecipe> customs = new ArrayList();
/*    */   
/*    */   public static void addRecipe(ICustomCrushRecipe recipe) {
/* 16 */     customs.add(recipe);
/*    */   }
/*    */   
/*    */   public static void addRecipe(ItemStack input, ItemStack output) {
/* 20 */     recipeList.add(new CrushRecipe(input, output));
/*    */   }
/*    */   
/*    */   public static ItemStack getResult(ItemStack in) {
/* 24 */     if ((recipeList == null) || (recipeList.isEmpty())) {
/* 25 */       return null;
/*    */     }
/* 27 */     if (in != null)
/*    */     {
/* 29 */       for (int a = 0; a < customs.size(); a++) {
/* 30 */         ICustomCrushRecipe recipe = (ICustomCrushRecipe)customs.get(a);
/* 31 */         if ((recipe != null) && 
/* 32 */           (recipe.getOutput(in) != null)) {
/* 33 */           return recipe.getOutput(in);
/*    */         }
/*    */       }
/*    */       
/*    */ 
/* 38 */       for (int a = 0; a < recipeList.size(); a++) {
/* 39 */         CrushRecipe recipe = (CrushRecipe)recipeList.get(a);
/* 40 */         if (recipe.input != null) {
/* 41 */           if ((recipe.input.func_77960_j() == 32767) && 
/* 42 */             (recipe.input.field_77993_c == in.field_77993_c)) {
/* 43 */             return recipe.output;
/*    */           }
/* 45 */           if (recipe.input.func_77969_a(in)) {
/* 46 */             return recipe.output;
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/* 51 */     return null;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/refine/CrushRecipes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */