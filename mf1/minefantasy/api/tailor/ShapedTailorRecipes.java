/*     */ package minefantasy.api.tailor;
/*     */ 
/*     */ import net.minecraft.inventory.InventoryCrafting;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ShapedTailorRecipes
/*     */   implements ITailorRecipe
/*     */ {
/*     */   private int recipeWidth;
/*     */   private int recipeHeight;
/*     */   private ItemStack[] recipeItems;
/*     */   private ItemStack recipeOutput;
/*     */   private final int stitchCount;
/*     */   private final int needleTier;
/*     */   private final float stitchTime;
/*     */   private final int stringNeeded;
/*     */   public final int recipeOutputItemID;
/*     */   
/*     */   public ShapedTailorRecipes(int wdth, int heit, ItemStack[] inputs, ItemStack output, int tier, int stitches, float time, int string)
/*     */   {
/*  35 */     this.recipeOutputItemID = output.field_77993_c;
/*  36 */     this.recipeWidth = wdth;
/*  37 */     this.recipeHeight = heit;
/*  38 */     this.recipeItems = inputs;
/*  39 */     this.recipeOutput = output;
/*  40 */     this.stitchCount = stitches;
/*  41 */     this.stitchTime = time;
/*  42 */     this.needleTier = tier;
/*  43 */     this.stringNeeded = string;
/*     */   }
/*     */   
/*     */   public ItemStack getRecipeOutput() {
/*  47 */     return this.recipeOutput;
/*     */   }
/*     */   
/*     */   public int getStitchCount() {
/*  51 */     return this.stitchCount;
/*     */   }
/*     */   
/*     */   public float getStitchTime() {
/*  55 */     return this.stitchTime;
/*     */   }
/*     */   
/*     */   public int getTier() {
/*  59 */     return this.needleTier;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean matches(InventoryCrafting matrix)
/*     */   {
/*  66 */     for (int var2 = 0; var2 <= 4 - this.recipeWidth; var2++) {
/*  67 */       for (int var3 = 0; var3 <= 4 - this.recipeHeight; var3++) {
/*  68 */         if (checkMatch(matrix, var2, var3, true)) {
/*  69 */           return true;
/*     */         }
/*     */         
/*  72 */         if (checkMatch(matrix, var2, var3, false)) {
/*  73 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  78 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean checkMatch(InventoryCrafting matrix, int x, int y, boolean b)
/*     */   {
/*  85 */     for (int var5 = 0; var5 < 4; var5++) {
/*  86 */       for (int var6 = 0; var6 < 4; var6++) {
/*  87 */         int var7 = var5 - x;
/*  88 */         int var8 = var6 - y;
/*  89 */         ItemStack recipeItem = null;
/*     */         
/*  91 */         if ((var7 >= 0) && (var8 >= 0) && (var7 < this.recipeWidth) && (var8 < this.recipeHeight)) {
/*  92 */           if (b) {
/*  93 */             recipeItem = this.recipeItems[(this.recipeWidth - var7 - 1 + var8 * this.recipeWidth)];
/*     */           } else {
/*  95 */             recipeItem = this.recipeItems[(var7 + var8 * this.recipeWidth)];
/*     */           }
/*     */         }
/*     */         
/*  99 */         ItemStack inputItem = matrix.func_70463_b(var5, var6);
/*     */         
/* 101 */         if ((inputItem != null) || (recipeItem != null)) {
/* 102 */           if (((inputItem == null) && (recipeItem != null)) || ((inputItem != null) && (recipeItem == null))) {
/* 103 */             return false;
/*     */           }
/*     */           
/* 106 */           if (inputItem == null) {
/* 107 */             return false;
/*     */           }
/*     */           
/* 110 */           if (recipeItem.field_77993_c != inputItem.field_77993_c) {
/* 111 */             return false;
/*     */           }
/*     */           
/* 114 */           if ((recipeItem.func_77960_j() != 32767) && (recipeItem.func_77960_j() != inputItem.func_77960_j())) {
/* 115 */             return false;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 121 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ItemStack getCraftingResult(InventoryCrafting matrix)
/*     */   {
/* 128 */     return new ItemStack(this.recipeOutput.field_77993_c, this.recipeOutput.field_77994_a, this.recipeOutput.func_77960_j());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getRecipeSize()
/*     */   {
/* 135 */     return this.recipeWidth * this.recipeHeight;
/*     */   }
/*     */   
/*     */   public int getString()
/*     */   {
/* 140 */     return this.stringNeeded;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/tailor/ShapedTailorRecipes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */