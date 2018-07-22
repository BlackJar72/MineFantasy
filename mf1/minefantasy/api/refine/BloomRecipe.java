/*    */ package minefantasy.api.refine;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import minefantasy.item.ItemBloom;
/*    */ import minefantasy.system.cfg;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BloomRecipe
/*    */ {
/*    */   public final ItemStack input1;
/*    */   public final ItemStack result;
/*    */   public final int time;
/* 17 */   public static List<BloomRecipe> recipeList = new ArrayList();
/*    */   
/*    */   public BloomRecipe(ItemStack in1, ItemStack out) {
/* 20 */     this(in1, out, 200);
/*    */   }
/*    */   
/*    */   public BloomRecipe(ItemStack in1, ItemStack out, int time) {
/* 24 */     this.input1 = in1;
/* 25 */     this.result = out;
/* 26 */     this.time = time;
/*    */   }
/*    */   
/*    */   public static ItemStack getResult(ItemStack input) {
/* 30 */     if (input != null) {
/* 31 */       for (int a = 0; a < recipeList.size(); a++) {
/* 32 */         BloomRecipe recipe = (BloomRecipe)recipeList.get(a);
/* 33 */         if (recipe.input1.func_77969_a(input)) {
/* 34 */           if (cfg.easyBlooms) {
/* 35 */             return recipe.result;
/*    */           }
/* 37 */           return ItemBloom.createBloom(recipe.result);
/*    */         }
/*    */       }
/*    */     }
/* 41 */     return null;
/*    */   }
/*    */   
/*    */   public static int getTime(ItemStack input) {
/* 45 */     if (input != null) {
/* 46 */       for (int a = 0; a < recipeList.size(); a++) {
/* 47 */         BloomRecipe recipe = (BloomRecipe)recipeList.get(a);
/* 48 */         if (recipe.input1.func_77969_a(input)) {
/* 49 */           return recipe.time;
/*    */         }
/*    */       }
/*    */     }
/* 53 */     return 200;
/*    */   }
/*    */   
/*    */   public static void add(BloomRecipe forgeRecipe) {
/* 57 */     if (recipeList == null) {
/* 58 */       recipeList = new ArrayList();
/*    */     } else {
/* 60 */       recipeList.add(forgeRecipe);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/refine/BloomRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */