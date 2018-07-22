/*     */ package minefantasy.api.anvil;
/*     */ 
/*     */ import minefantasy.api.Components;
/*     */ import minefantasy.api.forge.HeatableItem;
/*     */ import net.minecraft.inventory.InventoryCrafting;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
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
/*     */ 
/*     */ 
/*     */ public class ShapedAnvilRecipes
/*     */   implements IAnvilRecipe
/*     */ {
/*     */   private int recipeWidth;
/*     */   private final int recipeHammer;
/*     */   private final boolean outputHot;
/*     */   private int recipeHeight;
/*     */   private final int anvil;
/*     */   private ItemStack[] recipeItems;
/*     */   private ItemStack recipeOutput;
/*     */   private final int recipeTime;
/*     */   private final float recipeExperiance;
/*     */   public final int recipeOutputItemID;
/*     */   
/*     */   public ShapedAnvilRecipes(int wdth, int heit, ItemStack[] inputs, ItemStack output, int time, int hammer, int anvi, float exp, boolean hot)
/*     */   {
/*  41 */     this.outputHot = hot;
/*  42 */     this.recipeOutputItemID = output.field_77993_c;
/*  43 */     this.recipeWidth = wdth;
/*  44 */     this.anvil = anvi;
/*  45 */     this.recipeHeight = heit;
/*  46 */     this.recipeItems = inputs;
/*  47 */     this.recipeOutput = output;
/*  48 */     this.recipeTime = time;
/*  49 */     this.recipeHammer = hammer;
/*  50 */     this.recipeExperiance = exp;
/*     */   }
/*     */   
/*     */   public ItemStack getRecipeOutput() {
/*  54 */     return this.recipeOutput;
/*     */   }
/*     */   
/*     */   public int getCraftTime() {
/*  58 */     return this.recipeTime;
/*     */   }
/*     */   
/*     */   public float getExperiance() {
/*  62 */     return this.recipeExperiance;
/*     */   }
/*     */   
/*     */   public int getRecipeHammer() {
/*  66 */     return this.recipeHammer;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean matches(InventoryCrafting matrix)
/*     */   {
/*  73 */     for (int var2 = 0; var2 <= AnvilProps.globalWidth - this.recipeWidth; var2++) {
/*  74 */       for (int var3 = 0; var3 <= AnvilProps.globalHeight - this.recipeHeight; var3++) {
/*  75 */         if (checkMatch(matrix, var2, var3, true)) {
/*  76 */           return true;
/*     */         }
/*     */         
/*  79 */         if (checkMatch(matrix, var2, var3, false)) {
/*  80 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  85 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean checkMatch(InventoryCrafting matrix, int x, int y, boolean b)
/*     */   {
/*  92 */     for (int var5 = 0; var5 < AnvilProps.globalWidth; var5++) {
/*  93 */       for (int var6 = 0; var6 < AnvilProps.globalHeight; var6++) {
/*  94 */         int var7 = var5 - x;
/*  95 */         int var8 = var6 - y;
/*  96 */         ItemStack recipeItem = null;
/*     */         
/*  98 */         if ((var7 >= 0) && (var8 >= 0) && (var7 < this.recipeWidth) && (var8 < this.recipeHeight)) {
/*  99 */           if (b) {
/* 100 */             recipeItem = this.recipeItems[(this.recipeWidth - var7 - 1 + var8 * this.recipeWidth)];
/*     */           } else {
/* 102 */             recipeItem = this.recipeItems[(var7 + var8 * this.recipeWidth)];
/*     */           }
/*     */         }
/*     */         
/* 106 */         ItemStack inputItem = matrix.func_70463_b(var5, var6);
/*     */         
/* 108 */         if ((inputItem != null) || (recipeItem != null)) {
/* 109 */           if (((inputItem == null) && (recipeItem != null)) || ((inputItem != null) && (recipeItem == null))) {
/* 110 */             return false;
/*     */           }
/* 112 */           if ((HeatableItem.requiresHeating) && (HeatableItem.canHeatItem(inputItem))) {
/* 113 */             return false;
/*     */           }
/* 115 */           inputItem = getHotItem(inputItem);
/*     */           
/* 117 */           if (inputItem == null) {
/* 118 */             return false;
/*     */           }
/*     */           
/* 121 */           if (recipeItem.field_77993_c != inputItem.field_77993_c) {
/* 122 */             return false;
/*     */           }
/*     */           
/* 125 */           if ((recipeItem.func_77960_j() != 32767) && (recipeItem.func_77960_j() != inputItem.func_77960_j())) {
/* 126 */             return false;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 132 */     return true;
/*     */   }
/*     */   
/*     */   private ItemStack getHotItem(ItemStack inputItem) {
/* 136 */     ItemStack hotItem = Components.getItem("hotItem", 0);
/*     */     
/*     */ 
/* 139 */     if (hotItem == null) {
/* 140 */       return inputItem;
/*     */     }
/*     */     
/* 143 */     if (inputItem.field_77993_c == hotItem.field_77993_c) {
/* 144 */       int temp = getTemp(inputItem);
/*     */       
/* 146 */       ItemStack ingot = getItem(inputItem);
/* 147 */       if (ingot != null) {
/* 148 */         inputItem = ingot;
/*     */       }
/* 150 */       if (!HeatableItem.canWorkItem(inputItem, temp)) {
/* 151 */         return null;
/*     */       }
/*     */     }
/* 154 */     return inputItem;
/*     */   }
/*     */   
/*     */   public static int getTemp(ItemStack item) {
/* 158 */     NBTTagCompound tag = getNBT(item);
/*     */     
/* 160 */     if (tag.func_74764_b("MFtemp")) {
/* 161 */       return tag.func_74762_e("MFtemp");
/*     */     }
/* 163 */     return 0;
/*     */   }
/*     */   
/*     */   public static ItemStack getItem(ItemStack item) {
/* 167 */     NBTTagCompound tag = getNBT(item);
/*     */     
/* 169 */     if ((tag.func_74764_b("ingotID")) && (tag.func_74764_b("ingotMeta"))) {
/* 170 */       return new ItemStack(tag.func_74762_e("ingotID"), 1, tag.func_74762_e("ingotMeta"));
/*     */     }
/*     */     
/* 173 */     return null;
/*     */   }
/*     */   
/*     */   private static NBTTagCompound getNBT(ItemStack item) {
/* 177 */     if (!item.func_77942_o())
/* 178 */       item.func_77982_d(new NBTTagCompound());
/* 179 */     return item.func_77978_p();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ItemStack getCraftingResult(InventoryCrafting matrix)
/*     */   {
/* 186 */     return new ItemStack(this.recipeOutput.field_77993_c, this.recipeOutput.field_77994_a, this.recipeOutput.func_77960_j());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getRecipeSize()
/*     */   {
/* 193 */     return this.recipeWidth * this.recipeHeight;
/*     */   }
/*     */   
/*     */   public int getAnvil()
/*     */   {
/* 198 */     return this.anvil;
/*     */   }
/*     */   
/*     */   public boolean outputHot()
/*     */   {
/* 203 */     return this.outputHot;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/anvil/ShapedAnvilRecipes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */