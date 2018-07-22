/*    */ package minefantasy.api.tailor;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ public class StringRecipes
/*    */ {
/* 10 */   private static List<StringRecipes> recipes = new ArrayList();
/*    */   public final ItemStack input;
/*    */   public final ItemStack output;
/*    */   public final int timeRequired;
/*    */   
/*    */   public StringRecipes(ItemStack in, ItemStack out, int time)
/*    */   {
/* 17 */     this.input = in;
/* 18 */     this.output = out;
/* 19 */     this.timeRequired = time;
/*    */   }
/*    */   
/*    */   public static void addRecipe(ItemStack in, ItemStack out, int time) {
/* 23 */     recipes.add(new StringRecipes(in, out, time));
/*    */   }
/*    */   
/*    */   public static StringRecipes getRecipe(ItemStack input) {
/* 27 */     if (recipes.isEmpty()) {
/* 28 */       return null;
/*    */     }
/*    */     
/* 31 */     for (int a = 0; a < recipes.size(); a++) {
/* 32 */       StringRecipes recipe = (StringRecipes)recipes.get(a);
/* 33 */       if ((recipe != null) && (matchItem(recipe.input, input))) {
/* 34 */         return recipe;
/*    */       }
/*    */     }
/* 37 */     return null;
/*    */   }
/*    */   
/*    */   private static boolean matchItem(ItemStack recipe, ItemStack item) {
/* 41 */     if ((recipe == null) || (item == null)) {
/* 42 */       return false;
/*    */     }
/* 44 */     if (recipe.field_77993_c == item.field_77993_c) {
/* 45 */       if (recipe.func_77960_j() == 32767) {
/* 46 */         return true;
/*    */       }
/* 48 */       return recipe.func_77960_j() == item.func_77960_j();
/*    */     }
/* 50 */     return false;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/tailor/StringRecipes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */