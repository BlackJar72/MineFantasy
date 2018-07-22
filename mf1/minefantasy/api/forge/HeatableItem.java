/*     */ package minefantasy.api.forge;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HeatableItem
/*     */ {
/*  19 */   public static boolean requiresHeating = true;
/*  20 */   public static List<HeatableItem> items = new ArrayList();
/*     */   
/*     */ 
/*     */ 
/*     */   protected final int minTemperature;
/*     */   
/*     */ 
/*     */ 
/*     */   protected final int unstableTemperature;
/*     */   
/*     */ 
/*     */ 
/*     */   protected final int maxTemperature;
/*     */   
/*     */ 
/*     */ 
/*     */   protected ItemStack object;
/*     */   
/*     */ 
/*     */ 
/*     */   public HeatableItem(ItemStack item, int min, int unstable, int max)
/*     */   {
/*  42 */     this.object = item;
/*  43 */     this.minTemperature = min;
/*  44 */     this.unstableTemperature = unstable;
/*  45 */     this.maxTemperature = max;
/*     */   }
/*     */   
/*     */   public static void addItem(ItemStack item, int min, int unstable, int max) {
/*  49 */     items.add(new HeatableItem(item, min, unstable, max));
/*     */   }
/*     */   
/*     */   public static boolean canHeatItem(ItemStack item) {
/*  53 */     return getStats(item) != null;
/*     */   }
/*     */   
/*     */   public static boolean canWorkItem(ItemStack item, int temp) {
/*  57 */     if (!requiresHeating) {
/*  58 */       return true;
/*     */     }
/*  60 */     if (!canHeatItem(item)) {
/*  61 */       return true;
/*     */     }
/*  63 */     int min = getStats(item).minTemperature;
/*     */     
/*  65 */     return (MineFantasyBase.isDebug()) || (temp >= min);
/*     */   }
/*     */   
/*     */   public static boolean doesRuinItem(ItemStack item, int temp) {
/*  69 */     if (!canHeatItem(item)) {
/*  70 */       return false;
/*     */     }
/*  72 */     int max = getStats(item).maxTemperature;
/*  73 */     return temp > max;
/*     */   }
/*     */   
/*     */   public static HeatableItem getStats(ItemStack item) {
/*  77 */     if (item == null) {
/*  78 */       return null;
/*     */     }
/*  80 */     if (items.isEmpty()) {
/*  81 */       return null;
/*     */     }
/*  83 */     for (HeatableItem compare : items) {
/*  84 */       if (compare.object != null) {
/*  85 */         if (compare.object.func_77960_j() == 32767) {
/*  86 */           if (compare.object.field_77993_c == item.field_77993_c) {
/*  87 */             return compare;
/*     */           }
/*  89 */         } else if (compare.object.func_77969_a(item)) {
/*  90 */           return compare;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  95 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static byte getHeatableStage(ItemStack item, int temp)
/*     */   {
/* 102 */     HeatableItem stats = getStats(item);
/* 103 */     if (stats != null) {
/* 104 */       int work = stats.minTemperature;
/* 105 */       int unstable = stats.unstableTemperature;
/*     */       
/* 107 */       if (temp > unstable)
/* 108 */         return 2;
/* 109 */       if (temp > work)
/* 110 */         return 1;
/*     */     }
/* 112 */     return 0;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/forge/HeatableItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */