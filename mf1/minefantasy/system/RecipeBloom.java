/*    */ package minefantasy.system;
/*    */ 
/*    */ import minefantasy.api.refine.ICustomCrushRecipe;
/*    */ import minefantasy.item.ItemListMF;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class RecipeBloom implements ICustomCrushRecipe
/*    */ {
/*    */   public ItemStack getOutput(ItemStack input)
/*    */   {
/* 12 */     if (input == null) {
/* 13 */       return null;
/*    */     }
/* 15 */     if (input.field_77993_c == ItemListMF.bloom.field_77779_bT) {
/* 16 */       return minefantasy.item.ItemBloom.getItem(input);
/*    */     }
/* 18 */     return null;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/RecipeBloom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */