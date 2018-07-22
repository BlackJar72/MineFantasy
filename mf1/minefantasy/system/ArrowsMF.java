/*    */ package minefantasy.system;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ArrowsMF
/*    */ {
/*  9 */   public static List<ItemStack> useableArrows = new ArrayList();
/*    */   
/*    */   public static void addArrow(ItemStack arrow) {
/* 12 */     useableArrows.add(arrow);
/*    */   }
/*    */   
/*    */   public static boolean canShootArrow(ItemStack arrow) {
/* 16 */     for (ItemStack Comparearrow : useableArrows) {
/* 17 */       if (Comparearrow.func_77969_a(arrow))
/* 18 */         return true;
/*    */     }
/* 20 */     return false;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/ArrowsMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */