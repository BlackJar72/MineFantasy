/*    */ package minefantasy.system;
/*    */ 
/*    */ import net.minecraft.inventory.InventoryCrafting;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.item.crafting.IRecipe;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class RecipeBookClone
/*    */   implements IRecipe
/*    */ {
/*    */   public boolean func_77569_a(InventoryCrafting craftMatrix, World world)
/*    */   {
/* 15 */     int var3 = 0;
/* 16 */     ItemStack var4 = null;
/*    */     
/* 18 */     for (int var5 = 0; var5 < craftMatrix.func_70302_i_(); var5++) {
/* 19 */       ItemStack var6 = craftMatrix.func_70301_a(var5);
/*    */       
/* 21 */       if (var6 != null) {
/* 22 */         if (var6.field_77993_c == Item.field_77823_bG.field_77779_bT) {
/* 23 */           if (var4 != null) {
/* 24 */             return false;
/*    */           }
/*    */           
/* 27 */           var4 = var6;
/*    */         } else {
/* 29 */           if (var6.field_77993_c != Item.field_77760_aL.field_77779_bT) {
/* 30 */             return false;
/*    */           }
/*    */           
/* 33 */           var3++;
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 38 */     return (var4 != null) && (var3 > 0);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public ItemStack func_77572_b(InventoryCrafting craftMatrix)
/*    */   {
/* 45 */     int var2 = 0;
/* 46 */     ItemStack var3 = null;
/*    */     
/* 48 */     for (int var4 = 0; var4 < craftMatrix.func_70302_i_(); var4++) {
/* 49 */       ItemStack var5 = craftMatrix.func_70301_a(var4);
/*    */       
/* 51 */       if (var5 != null) {
/* 52 */         if (var5.field_77993_c == Item.field_77823_bG.field_77779_bT) {
/* 53 */           if (var3 != null) {
/* 54 */             return null;
/*    */           }
/*    */           
/* 57 */           var3 = var5;
/*    */         } else {
/* 59 */           if (var5.field_77993_c != Item.field_77760_aL.field_77779_bT) {
/* 60 */             return null;
/*    */           }
/*    */           
/* 63 */           var2++;
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 68 */     if ((var3 != null) && (var2 >= 1)) {
/* 69 */       ItemStack var6 = new ItemStack(Item.field_77823_bG, var2 + 1, var3.func_77960_j());
/*    */       
/* 71 */       if (var3.func_82837_s()) {
/* 72 */         var6.func_82834_c(var3.func_82833_r());
/*    */       }
/* 74 */       var6.func_77982_d(var3.func_77978_p());
/*    */       
/* 76 */       return var6;
/*    */     }
/* 78 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int func_77570_a()
/*    */   {
/* 86 */     return 9;
/*    */   }
/*    */   
/*    */   public ItemStack func_77571_b() {
/* 90 */     return null;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/RecipeBookClone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */