/*    */ package minefantasy.api.cooking;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ public class FoodPrepRecipe
/*    */ {
/* 10 */   public static List<FoodPrepRecipe> recipes = new ArrayList();
/*    */   
/*    */ 
/*    */ 
/*    */   public float time;
/*    */   
/*    */ 
/*    */ 
/*    */   public ItemStack input;
/*    */   
/*    */ 
/*    */   public ItemStack output;
/*    */   
/*    */ 
/*    */   public String utensil;
/*    */   
/*    */ 
/*    */   public String prepSound;
/*    */   
/*    */ 
/*    */ 
/*    */   public static void addFoodPrepRecipe(int in, ItemStack out, float time, String utensil, String sound)
/*    */   {
/* 33 */     recipes.add(new FoodPrepRecipe(in, out, time, utensil, sound));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void addFoodPrepRecipe(ItemStack in, ItemStack out, float time, String utensil, String sound)
/*    */   {
/* 51 */     recipes.add(new FoodPrepRecipe(in, out, time, utensil, sound));
/*    */   }
/*    */   
/*    */   public FoodPrepRecipe(int in, ItemStack out, float time, String utensil, String sound) {
/* 55 */     this(new ItemStack(in, 1, 32767), out, time, utensil, sound);
/*    */   }
/*    */   
/*    */   public FoodPrepRecipe(ItemStack in, ItemStack out, float time, String utensil, String sound) {
/* 59 */     this.time = time;
/* 60 */     this.input = in;
/* 61 */     this.output = out;
/* 62 */     this.utensil = utensil;
/* 63 */     this.prepSound = sound;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static FoodPrepRecipe getRecipeFor(ItemStack in, ItemStack utensil)
/*    */   {
/* 76 */     if (in == null) {
/* 77 */       return null;
/*    */     }
/*    */     
/* 80 */     for (int a = 0; a < recipes.size(); a++) {
/* 81 */       FoodPrepRecipe recipe = (FoodPrepRecipe)recipes.get(a);
/*    */       
/* 83 */       if ((in.field_77993_c == recipe.input.field_77993_c) && 
/* 84 */         ((recipe.input.func_77960_j() == 32767) || (recipe.input.func_77960_j() == in.func_77960_j())) && 
/* 85 */         (UtensilManager.isToolValid(utensil, recipe.utensil))) {
/* 86 */         return recipe;
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 91 */     return null;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/cooking/FoodPrepRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */