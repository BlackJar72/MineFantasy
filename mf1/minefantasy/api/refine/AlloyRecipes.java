/*    */ package minefantasy.api.refine;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class AlloyRecipes
/*    */ {
/*  9 */   private static List<Alloy> alloys = new ArrayList();
/*    */   
/*    */   public static void addAlloy(ItemStack out, int level, List in) {
/* 12 */     alloys.add(new Alloy(out, level, in));
/*    */   }
/*    */   
/*    */   public static void addAlloy(ItemStack out, List in) {
/* 16 */     addAlloy(out, 0, in);
/*    */   }
/*    */   
/*    */   public static void addAlloy(Alloy alloy) {
/* 20 */     alloys.add(alloy);
/*    */   }
/*    */   
/*    */   public static Alloy getResult(ItemStack[] inv) {
/* 24 */     for (Alloy alloy : alloys) {
/* 25 */       if (alloy.matches(inv)) {
/* 26 */         return alloy;
/*    */       }
/*    */     }
/* 29 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void addRatioRecipe(ItemStack out, int level, List in, int levels)
/*    */   {
/* 40 */     for (int a = 1; a <= levels; a++) {
/* 41 */       List list2 = createDupeList(in, a);
/* 42 */       ItemStack out2 = out.func_77946_l();
/* 43 */       int ss = Math.min(out2.func_77976_d(), out2.field_77994_a * a);
/* 44 */       out2.field_77994_a = ss;
/* 45 */       addAlloy(out2, level, list2);
/*    */     }
/*    */   }
/*    */   
/*    */   public static List createDupeList(List list) {
/* 50 */     return createDupeList(list, 2);
/*    */   }
/*    */   
/*    */   public static List createDupeList(List list, int dupe) {
/* 54 */     if (dupe == 0) {
/* 55 */       dupe = 1;
/*    */     }
/* 57 */     List list2 = new ArrayList();
/* 58 */     for (int a = 0; a < dupe; a++) {
/* 59 */       for (int b = 0; b < list.size(); b++) {
/* 60 */         list2.add(list.get(b));
/*    */       }
/*    */     }
/* 63 */     return list2;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/refine/AlloyRecipes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */