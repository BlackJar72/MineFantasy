/*     */ package minefantasy.api.forge;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import minefantasy.api.refine.BlastFurnaceFuel;
/*     */ import minefantasy.api.refine.FluxItem;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ public class ItemHandler
/*     */ {
/*  12 */   public static List<ItemStack> flux = new ArrayList();
/*  13 */   public static List<BlastFurnaceFuel> BlastFuel = new ArrayList();
/*  14 */   public static List<ForgeFuel> forgeFuel = new ArrayList();
/*  15 */   public static List<ItemStack> carbon = new ArrayList();
/*  16 */   public static int forgeMaxTemp = 0;
/*  17 */   public static List<FluxItem> fluxes = new ArrayList();
/*     */   
/*     */   public static void addFluxRecipe(ItemStack in, int amount) {
/*  20 */     fluxes.add(new FluxItem(in, amount));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isFlux(ItemStack item)
/*     */   {
/*  31 */     if (item == null) {
/*  32 */       return false;
/*     */     }
/*  34 */     for (ItemStack Flux : flux) {
/*  35 */       if (matches(item, Flux))
/*  36 */         return true;
/*     */     }
/*  38 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isFlux(int id)
/*     */   {
/*  49 */     for (ItemStack Flux : flux) {
/*  50 */       if (matches(new ItemStack(id, 1, 32767), Flux))
/*  51 */         return true;
/*     */     }
/*  53 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static float getBlastFuel(ItemStack item)
/*     */   {
/*  64 */     if (item == null) {
/*  65 */       return 0.0F;
/*     */     }
/*  67 */     for (BlastFurnaceFuel fuel : BlastFuel) {
/*  68 */       if ((fuel != null) && (fuel.fuel.func_77969_a(item))) {
/*  69 */         return fuel.smelts;
/*     */       }
/*     */     }
/*  72 */     return 0.0F;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static float getBlastFuel(int id)
/*     */   {
/*  83 */     for (BlastFurnaceFuel fuel : BlastFuel) {
/*  84 */       if ((fuel != null) && (fuel.fuel.field_77993_c == id)) {
/*  85 */         return fuel.smelts;
/*     */       }
/*     */     }
/*  88 */     return 0.0F;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static float getForgeFuel(ItemStack item)
/*     */   {
/*  99 */     if (item == null) {
/* 100 */       return 0.0F;
/*     */     }
/* 102 */     for (ForgeFuel fuel : forgeFuel) {
/* 103 */       if ((fuel != null) && 
/* 104 */         (fuel.fuel.field_77993_c == item.field_77993_c) && (
/* 105 */         (fuel.fuel.func_77960_j() == 32767) || (fuel.fuel.func_77960_j() == item.func_77960_j()))) {
/* 106 */         return fuel.duration;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 111 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public static boolean willLight(ItemStack item) {
/* 115 */     if (item == null) {
/* 116 */       return false;
/*     */     }
/*     */     
/* 119 */     for (ForgeFuel fuel : forgeFuel) {
/* 120 */       if ((fuel != null) && 
/* 121 */         (fuel.fuel.field_77993_c == item.field_77993_c) && (
/* 122 */         (fuel.fuel.func_77960_j() == 32767) || (fuel.fuel.func_77960_j() == item.func_77960_j()))) {
/* 123 */         return fuel.doesLight;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 128 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static float getForgeFuelWithoutSubid(int id)
/*     */   {
/* 139 */     for (ForgeFuel fuel : forgeFuel) {
/* 140 */       if ((fuel != null) && 
/* 141 */         (fuel.fuel.field_77993_c == id)) {
/* 142 */         return fuel.baseHeat;
/*     */       }
/*     */     }
/*     */     
/* 146 */     return 0.0F;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getForgeHeat(ItemStack item)
/*     */   {
/* 157 */     if (item == null) {
/* 158 */       return 0;
/*     */     }
/* 160 */     for (ForgeFuel fuel : forgeFuel) {
/* 161 */       if ((fuel != null) && 
/* 162 */         (fuel.fuel.field_77993_c == item.field_77993_c) && (
/* 163 */         (fuel.fuel.func_77960_j() == 32767) || (fuel.fuel.func_77960_j() == item.func_77960_j()))) {
/* 164 */         return fuel.baseHeat;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 169 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getForgeHeat(int id)
/*     */   {
/* 180 */     for (ForgeFuel fuel : forgeFuel) {
/* 181 */       if ((fuel != null) && (fuel.fuel.field_77993_c == id)) {
/* 182 */         return fuel.baseHeat;
/*     */       }
/*     */     }
/* 185 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isCarbon(ItemStack item)
/*     */   {
/* 196 */     if (item == null) {
/* 197 */       return false;
/*     */     }
/* 199 */     for (ItemStack Carbon : carbon) {
/* 200 */       if (matches(item, Carbon))
/* 201 */         return true;
/*     */     }
/* 203 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isCarbon(int id)
/*     */   {
/* 214 */     for (ItemStack Carbon : carbon) {
/* 215 */       if (matches(new ItemStack(id, 1, 32767), Carbon))
/* 216 */         return true;
/*     */     }
/* 218 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean matches(ItemStack item, ItemStack compare) {
/* 222 */     if ((item == null) || (compare == null)) {
/* 223 */       return false;
/*     */     }
/*     */     
/* 226 */     if (item.field_77993_c != compare.field_77993_c) {
/* 227 */       return false;
/*     */     }
/*     */     
/* 230 */     if ((item.func_77960_j() != compare.func_77960_j()) && (compare.func_77960_j() != 32767) && (item.func_77960_j() != 32767)) {
/* 231 */       return false;
/*     */     }
/* 233 */     return true;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/forge/ItemHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */