/*    */ package minefantasy.api.cooking;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ public class OvenRecipes
/*    */ {
/* 13 */   private static Map smeltingList = new HashMap();
/* 14 */   private static Map experienceList = new HashMap();
/* 15 */   private static HashMap<List<Integer>, ItemStack> metaSmeltingList = new HashMap();
/* 16 */   private static HashMap<List<Integer>, Float> metaExperience = new HashMap();
/*    */   
/*    */ 
/*    */ 
/*    */   public static void addSmelting(int id, ItemStack stack, float xp)
/*    */   {
/* 22 */     smeltingList.put(Integer.valueOf(id), stack);
/* 23 */     experienceList.put(Integer.valueOf(stack.field_77993_c), Float.valueOf(xp));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static void addSmelting(int itemID, int metadata, ItemStack itemstack, float experience)
/*    */   {
/* 30 */     metaSmeltingList.put(Arrays.asList(new Integer[] { Integer.valueOf(itemID), Integer.valueOf(metadata) }), itemstack);
/* 31 */     metaExperience.put(Arrays.asList(new Integer[] { Integer.valueOf(itemstack.field_77993_c), Integer.valueOf(itemstack.func_77960_j()) }), Float.valueOf(experience));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static ItemStack getSmeltingResult(ItemStack item)
/*    */   {
/* 42 */     if (item == null) {
/* 43 */       return null;
/*    */     }
/* 45 */     ItemStack ret = (ItemStack)metaSmeltingList.get(Arrays.asList(new Integer[] { Integer.valueOf(item.field_77993_c), Integer.valueOf(item.func_77960_j()) }));
/* 46 */     if (ret != null) {
/* 47 */       return ret;
/*    */     }
/* 49 */     return (ItemStack)smeltingList.get(Integer.valueOf(item.field_77993_c));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static float getExperience(ItemStack item)
/*    */   {
/* 57 */     if ((item == null) || (item.func_77973_b() == null)) {
/* 58 */       return 0.0F;
/*    */     }
/* 60 */     float ret = item.func_77973_b().getSmeltingExperience(item);
/* 61 */     if (ret < 0.0F) if (metaExperience.containsKey(Arrays.asList(new Integer[] { Integer.valueOf(item.field_77993_c), Integer.valueOf(item.func_77960_j()) }))) {
/* 62 */         ret = ((Float)metaExperience.get(Arrays.asList(new Integer[] { Integer.valueOf(item.field_77993_c), Integer.valueOf(item.func_77960_j()) }))).floatValue();
/*    */       }
/* 64 */     if ((ret < 0.0F) && (experienceList.containsKey(Integer.valueOf(item.field_77993_c)))) {
/* 65 */       ret = ((Float)experienceList.get(Integer.valueOf(item.field_77993_c))).floatValue();
/*    */     }
/* 67 */     return ret < 0.0F ? 0.0F : ret;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/cooking/OvenRecipes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */