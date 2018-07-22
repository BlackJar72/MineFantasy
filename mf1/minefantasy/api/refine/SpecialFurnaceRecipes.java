/*     */ package minefantasy.api.refine;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ public class SpecialFurnaceRecipes
/*     */ {
/*  12 */   private static List<Alloy> alloys = new ArrayList();
/*  13 */   private static HashMap<Integer, SpecialSmelt> specials = new HashMap();
/*  14 */   private static HashMap<List<Integer>, SpecialSmelt> specialsMeta = new HashMap();
/*     */   
/*     */   public static void addAlloy(ItemStack out, int level, List in) {
/*  17 */     alloys.add(new Alloy(out, level, in));
/*     */   }
/*     */   
/*     */   public static void addAlloy(ItemStack out, List in) {
/*  21 */     addAlloy(out, 0, in);
/*     */   }
/*     */   
/*     */   public static void addAlloy(Alloy alloy) {
/*  25 */     alloys.add(alloy);
/*     */   }
/*     */   
/*     */   public static Alloy getResult(ItemStack[] inv) {
/*  29 */     for (Alloy alloy : alloys) {
/*  30 */       if (alloy.matches(inv)) {
/*  31 */         return alloy;
/*     */       }
/*     */     }
/*  34 */     return null;
/*     */   }
/*     */   
/*     */   public static void addSmelting(int itemID, int metadata, ItemStack itemstack, int level) {
/*  38 */     specialsMeta.put(Arrays.asList(new Integer[] { Integer.valueOf(itemID), Integer.valueOf(metadata) }), new SpecialSmelt(level, itemstack, null));
/*     */   }
/*     */   
/*     */   public static void addSmelting(int itemID, ItemStack itemstack, int level) {
/*  42 */     specials.put(Integer.valueOf(itemID), new SpecialSmelt(level, itemstack, null));
/*     */   }
/*     */   
/*     */   public static ItemStack getSmeltingResult(ItemStack item, int lvl) {
/*  46 */     if (item == null) {
/*  47 */       return null;
/*     */     }
/*  49 */     SpecialSmelt ret = (SpecialSmelt)specialsMeta.get(Arrays.asList(new Integer[] { Integer.valueOf(item.field_77993_c), Integer.valueOf(item.func_77960_j()) }));
/*  50 */     if ((ret != null) && (ret.lvl <= lvl)) {
/*  51 */       return ret.result;
/*     */     }
/*  53 */     ret = (SpecialSmelt)specials.get(Integer.valueOf(item.field_77993_c));
/*  54 */     if ((ret != null) && (ret.lvl <= lvl)) {
/*  55 */       return ret.result;
/*     */     }
/*  57 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addRatioRecipe(ItemStack out, int level, List in, int levels)
/*     */   {
/*  68 */     for (int a = 1; a <= levels; a++) {
/*  69 */       List list2 = createDupeList(in, a);
/*  70 */       ItemStack out2 = out.func_77946_l();
/*  71 */       int ss = Math.min(out2.func_77976_d(), out2.field_77994_a * a);
/*  72 */       out2.field_77994_a = ss;
/*  73 */       addAlloy(out2, level, list2);
/*     */     }
/*     */   }
/*     */   
/*     */   public static List createDupeList(List list) {
/*  78 */     return createDupeList(list, 2);
/*     */   }
/*     */   
/*     */   public static List createDupeList(List list, int dupe) {
/*  82 */     if (dupe == 0) {
/*  83 */       dupe = 1;
/*     */     }
/*  85 */     List list2 = new ArrayList();
/*  86 */     for (int a = 0; a < dupe; a++) {
/*  87 */       for (int b = 0; b < list.size(); b++) {
/*  88 */         list2.add(list.get(b));
/*     */       }
/*     */     }
/*  91 */     return list2;
/*     */   }
/*     */   
/*     */   private static class SpecialSmelt {
/*     */     public int lvl;
/*     */     public ItemStack result;
/*     */     
/*     */     private SpecialSmelt(int level, ItemStack out) {
/*  99 */       this.lvl = level;
/* 100 */       this.result = out;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/refine/SpecialFurnaceRecipes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */