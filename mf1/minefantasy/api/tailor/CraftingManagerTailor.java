/*     */ package minefantasy.api.tailor;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.inventory.InventoryCrafting;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CraftingManagerTailor
/*     */ {
/*  21 */   private static final CraftingManagerTailor instance = new CraftingManagerTailor();
/*     */   
/*     */ 
/*  24 */   public List recipes = new ArrayList();
/*     */   
/*     */ 
/*     */ 
/*     */   public static CraftingManagerTailor getInstance()
/*     */   {
/*  30 */     return instance;
/*     */   }
/*     */   
/*     */   private CraftingManagerTailor() {
/*  34 */     Collections.sort(this.recipes, new RecipeSorterTailor(this));
/*  35 */     System.out.println("MineFantasy: Tailor recipes initiating");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void addRecipe(ItemStack result, int tier, int string, int stitchCount, float time, Object... input)
/*     */   {
/*  42 */     String var3 = "";
/*  43 */     int var4 = 0;
/*  44 */     int var5 = 0;
/*  45 */     int var6 = 0;
/*     */     
/*     */ 
/*  48 */     if ((input[var4] instanceof String[])) {
/*  49 */       String[] var7 = (String[])(String[])input[(var4++)];
/*  50 */       String[] var8 = var7;
/*  51 */       int var9 = var7.length;
/*     */       
/*  53 */       for (int var10 = 0; var10 < var9; var10++) {
/*  54 */         String var11 = var8[var10];
/*  55 */         var6++;
/*  56 */         var5 = var11.length();
/*  57 */         var3 = var3 + var11;
/*     */       }
/*     */     } else {
/*  60 */       while ((input[var4] instanceof String)) {
/*  61 */         String var13 = (String)input[(var4++)];
/*  62 */         var6++;
/*  63 */         var5 = var13.length();
/*  64 */         var3 = var3 + var13;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  70 */     for (HashMap var14 = new HashMap(); var4 < input.length; var4 += 2) {
/*  71 */       Character var16 = (Character)input[var4];
/*  72 */       ItemStack var17 = null;
/*     */       
/*  74 */       if ((input[(var4 + 1)] instanceof Item)) {
/*  75 */         var17 = new ItemStack((Item)input[(var4 + 1)], 1, 32767);
/*  76 */       } else if ((input[(var4 + 1)] instanceof Block)) {
/*  77 */         var17 = new ItemStack((Block)input[(var4 + 1)], 1, 32767);
/*  78 */       } else if ((input[(var4 + 1)] instanceof ItemStack)) {
/*  79 */         var17 = (ItemStack)input[(var4 + 1)];
/*     */       }
/*     */       
/*  82 */       var14.put(var16, var17);
/*     */     }
/*     */     
/*  85 */     ItemStack[] var15 = new ItemStack[var5 * var6];
/*     */     
/*  87 */     for (int var9 = 0; var9 < var5 * var6; var9++) {
/*  88 */       char var18 = var3.charAt(var9);
/*     */       
/*  90 */       if (var14.containsKey(Character.valueOf(var18))) {
/*  91 */         var15[var9] = ((ItemStack)var14.get(Character.valueOf(var18))).func_77946_l();
/*     */       } else {
/*  93 */         var15[var9] = null;
/*     */       }
/*     */     }
/*     */     
/*  97 */     this.recipes.add(new ShapedTailorRecipes(var5, var6, var15, result, tier, stitchCount, time, string));
/*     */   }
/*     */   
/*     */   public ItemStack findMatchingRecipe(InventoryCrafting matrix) {
/* 101 */     int var2 = 0;
/* 102 */     ItemStack var3 = null;
/* 103 */     ItemStack var4 = null;
/*     */     
/* 105 */     for (int var5 = 0; var5 < matrix.func_70302_i_(); var5++) {
/* 106 */       ItemStack var6 = matrix.func_70301_a(var5);
/*     */       
/* 108 */       if (var6 != null) {
/* 109 */         if (var2 == 0) {
/* 110 */           var3 = var6;
/*     */         }
/*     */         
/* 113 */         if (var2 == 1) {
/* 114 */           var4 = var6;
/*     */         }
/*     */         
/* 117 */         var2++;
/*     */       }
/*     */     }
/*     */     
/* 121 */     if ((var2 == 2) && (var3.field_77993_c == var4.field_77993_c) && (var3.field_77994_a == 1) && (var4.field_77994_a == 1) && (Item.field_77698_e[var3.field_77993_c].isRepairable())) {
/* 122 */       Item var10 = Item.field_77698_e[var3.field_77993_c];
/* 123 */       int var12 = var10.func_77612_l() - var3.func_77952_i();
/* 124 */       int var7 = var10.func_77612_l() - var4.func_77952_i();
/* 125 */       int var8 = var12 + var7 + var10.func_77612_l() * 10 / 100;
/* 126 */       int var9 = var10.func_77612_l() - var8 * 2;
/*     */       
/* 128 */       if (var9 < 0) {
/* 129 */         var9 = 0;
/*     */       }
/*     */       
/* 132 */       return new ItemStack(var3.field_77993_c, 1, var9);
/*     */     }
/* 134 */     Iterator var11 = this.recipes.iterator();
/*     */     ITailorRecipe var13;
/*     */     do
/*     */     {
/* 138 */       if (!var11.hasNext()) {
/* 139 */         return null;
/*     */       }
/*     */       
/* 142 */       var13 = (ITailorRecipe)var11.next();
/* 143 */     } while (!var13.matches(matrix));
/*     */     
/* 145 */     return var13.getCraftingResult(matrix);
/*     */   }
/*     */   
/*     */   public ItemStack findMatchingRecipe(ITailor bench, InventoryCrafting matrix)
/*     */   {
/* 150 */     int stitches = 8;
/* 151 */     int tier = 0;
/* 152 */     float time = 1.0F;
/* 153 */     int string = 0;
/* 154 */     int var2 = 0;
/* 155 */     ItemStack var3 = null;
/* 156 */     ItemStack var4 = null;
/*     */     
/* 158 */     for (int var5 = 0; var5 < matrix.func_70302_i_(); var5++) {
/* 159 */       ItemStack var6 = matrix.func_70301_a(var5);
/*     */       
/* 161 */       if (var6 != null) {
/* 162 */         if (var2 == 0) {
/* 163 */           var3 = var6;
/*     */         }
/*     */         
/* 166 */         if (var2 == 1) {
/* 167 */           var4 = var6;
/*     */         }
/*     */         
/* 170 */         var2++;
/*     */       }
/*     */     }
/*     */     
/* 174 */     if ((var2 == 2) && (var3.field_77993_c == var4.field_77993_c) && (var3.field_77994_a == 1) && (var4.field_77994_a == 1) && (Item.field_77698_e[var3.field_77993_c].isRepairable())) {
/* 175 */       Item var10 = Item.field_77698_e[var3.field_77993_c];
/* 176 */       int var12 = var10.func_77612_l() - var3.func_77952_i();
/* 177 */       int var7 = var10.func_77612_l() - var4.func_77952_i();
/* 178 */       int var8 = var12 + var7 + var10.func_77612_l() * 10 / 100;
/* 179 */       int var9 = var10.func_77612_l() - var8;
/*     */       
/* 181 */       if (var9 < 0) {
/* 182 */         var9 = 0;
/*     */       }
/*     */       
/* 185 */       return new ItemStack(var3.field_77993_c, 1, var9);
/*     */     }
/* 187 */     Iterator var11 = this.recipes.iterator();
/*     */     ITailorRecipe var13;
/*     */     do
/*     */     {
/* 191 */       if (!var11.hasNext()) {
/* 192 */         return null;
/*     */       }
/*     */       
/* 195 */       var13 = (ITailorRecipe)var11.next();
/* 196 */     } while (!var13.matches(matrix));
/*     */     
/* 198 */     stitches = var13.getStitchCount();
/* 199 */     time = var13.getStitchTime();
/* 200 */     string = var13.getString();
/* 201 */     tier = var13.getTier();
/*     */     
/* 203 */     bench.setTier(tier);
/* 204 */     bench.setSewTime(time);
/* 205 */     bench.setStitchCount(stitches);
/* 206 */     bench.setString(string);
/* 207 */     return var13.getCraftingResult(matrix);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public List getRecipeList()
/*     */   {
/* 215 */     return this.recipes;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/tailor/CraftingManagerTailor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */