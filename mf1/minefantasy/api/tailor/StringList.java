/*    */ package minefantasy.api.tailor;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StringList
/*    */ {
/* 14 */   private static HashMap<List<Integer>, Integer> stringList = new HashMap();
/* 15 */   private static HashMap<Integer, Integer> stringID = new HashMap();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void addString(int string, int tier)
/*    */   {
/* 26 */     stringID.put(Integer.valueOf(string), Integer.valueOf(tier));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void addString(Item string, int tier)
/*    */   {
/* 38 */     stringID.put(Integer.valueOf(string.field_77779_bT), Integer.valueOf(tier));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void addString(ItemStack string, int tier)
/*    */   {
/* 50 */     stringList.put(Arrays.asList(new Integer[] { Integer.valueOf(string.field_77993_c), Integer.valueOf(string.func_77960_j()) }), Integer.valueOf(tier));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean doesMatchTier(ItemStack string, int tier)
/*    */   {
/* 62 */     if (string == null) {
/* 63 */       return false;
/*    */     }
/* 65 */     int stringTier = 0;
/*    */     
/* 67 */     if (!stringList.isEmpty()) if (stringList.containsKey(Arrays.asList(new Integer[] { Integer.valueOf(string.field_77993_c), Integer.valueOf(string.func_77960_j()) }))) {
/* 68 */         stringTier = ((Integer)stringList.get(Arrays.asList(new Integer[] { Integer.valueOf(string.field_77993_c), Integer.valueOf(string.func_77960_j()) }))).intValue();
/* 69 */         break label141; } if ((!stringID.isEmpty()) && (stringID.containsKey(Integer.valueOf(string.field_77993_c)))) {
/* 70 */       stringTier = ((Integer)stringID.get(Integer.valueOf(string.field_77993_c))).intValue();
/*    */     }
/*    */     label141:
/* 73 */     return stringTier >= tier;
/*    */   }
/*    */   
/*    */   public static boolean isString(ItemStack string) {
/* 77 */     if (string == null) {
/* 78 */       return false;
/*    */     }
/*    */     
/* 81 */     if (!stringList.isEmpty()) if (stringList.containsKey(Arrays.asList(new Integer[] { Integer.valueOf(string.field_77993_c), Integer.valueOf(string.func_77960_j()) })))
/* 82 */         return true;
/* 83 */     if ((!stringID.isEmpty()) && (stringID.containsKey(Integer.valueOf(string.field_77993_c)))) {
/* 84 */       return true;
/*    */     }
/*    */     
/* 87 */     return false;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/tailor/StringList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */