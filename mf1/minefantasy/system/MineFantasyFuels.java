/*    */ package minefantasy.system;
/*    */ 
/*    */ import cpw.mods.fml.common.IFuelHandler;
/*    */ import minefantasy.item.ItemListMF;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class MineFantasyFuels implements IFuelHandler
/*    */ {
/*    */   public int getBurnTime(ItemStack fuel)
/*    */   {
/* 12 */     if (fuel.field_77993_c == ItemListMF.misc.field_77779_bT) {
/* 13 */       int m = fuel.func_77960_j();
/*    */       
/* 15 */       if (m == 14) {
/* 16 */         return 960;
/*    */       }
/* 18 */       if (m == 92) {
/* 19 */         return 3200;
/*    */       }
/* 21 */       if (m == 90) {
/* 22 */         return 6400;
/*    */       }
/* 24 */       if (m == 91) {
/* 25 */         return 12800;
/*    */       }
/* 27 */       if (m == 25) {
/* 28 */         return 200;
/*    */       }
/*    */     }
/* 31 */     if (fuel.field_77993_c == ItemListMF.plank.field_77779_bT) {
/* 32 */       return 150;
/*    */     }
/* 34 */     return 0;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/MineFantasyFuels.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */