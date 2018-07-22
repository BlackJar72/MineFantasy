/*     */ package minefantasy.api.anvil;
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
/*     */ public class CraftingManagerAnvil
/*     */ {
/*  21 */   private static final CraftingManagerAnvil instance = new CraftingManagerAnvil();
/*     */   
/*     */ 
/*  24 */   public List recipes = new ArrayList();
/*     */   
/*     */ 
/*     */ 
/*     */   public static CraftingManagerAnvil getInstance()
/*     */   {
/*  30 */     return instance;
/*     */   }
/*     */   
/*     */   private CraftingManagerAnvil() {
/*  34 */     Collections.sort(this.recipes, new RecipeSorterAnvil(this));
/*  35 */     System.out.println("MineFantasy: Anvil recipes initiating");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void addRecipe(ItemStack result, boolean hot, float exp, int hammer, int anvil, int time, Object... input)
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
/*  97 */     this.recipes.add(new ShapedAnvilRecipes(var5, var6, var15, result, time, hammer, anvil, exp, hot));
/*     */   }
/*     */   
/*     */   public void addShapelessRecipe(ItemStack output, boolean hot, float experiance, int hammer, int anvil, int time, Object... input) {
/* 101 */     ArrayList var3 = new ArrayList();
/* 102 */     Object[] var4 = input;
/* 103 */     int var5 = input.length;
/*     */     
/* 105 */     for (int var6 = 0; var6 < var5; var6++) {
/* 106 */       Object var7 = var4[var6];
/*     */       
/* 108 */       if ((var7 instanceof ItemStack)) {
/* 109 */         var3.add(((ItemStack)var7).func_77946_l());
/* 110 */       } else if ((var7 instanceof Item)) {
/* 111 */         var3.add(new ItemStack((Item)var7));
/*     */       } else {
/* 113 */         if (!(var7 instanceof Block)) {
/* 114 */           throw new RuntimeException("MineFantasy: Invalid shapeless anvil recipe!");
/*     */         }
/*     */         
/* 117 */         var3.add(new ItemStack((Block)var7));
/*     */       }
/*     */     }
/*     */     
/* 121 */     this.recipes.add(new ShapelessAnvilRecipes(output, experiance, hammer, anvil, time, var3, hot));
/*     */   }
/*     */   
/*     */   public ItemStack findMatchingRecipe(InventoryCrafting matrix) {
/* 125 */     int var2 = 0;
/* 126 */     ItemStack var3 = null;
/* 127 */     ItemStack var4 = null;
/*     */     
/* 129 */     for (int var5 = 0; var5 < matrix.func_70302_i_(); var5++) {
/* 130 */       ItemStack var6 = matrix.func_70301_a(var5);
/*     */       
/* 132 */       if (var6 != null) {
/* 133 */         if (var2 == 0) {
/* 134 */           var3 = var6;
/*     */         }
/*     */         
/* 137 */         if (var2 == 1) {
/* 138 */           var4 = var6;
/*     */         }
/*     */         
/* 141 */         var2++;
/*     */       }
/*     */     }
/*     */     
/* 145 */     if ((var2 == 2) && (var3.field_77993_c == var4.field_77993_c) && (var3.field_77994_a == 1) && (var4.field_77994_a == 1) && (Item.field_77698_e[var3.field_77993_c].isRepairable())) {
/* 146 */       Item var10 = Item.field_77698_e[var3.field_77993_c];
/* 147 */       int var12 = var10.func_77612_l() - var3.func_77952_i();
/* 148 */       int var7 = var10.func_77612_l() - var4.func_77952_i();
/* 149 */       int var8 = var12 + var7 + var10.func_77612_l() * 10 / 100;
/* 150 */       int var9 = var10.func_77612_l() - var8 * 2;
/*     */       
/* 152 */       if (var9 < 0) {
/* 153 */         var9 = 0;
/*     */       }
/*     */       
/* 156 */       return new ItemStack(var3.field_77993_c, 1, var9);
/*     */     }
/* 158 */     Iterator var11 = this.recipes.iterator();
/*     */     IAnvilRecipe var13;
/*     */     do
/*     */     {
/* 162 */       if (!var11.hasNext()) {
/* 163 */         return null;
/*     */       }
/*     */       
/* 166 */       var13 = (IAnvilRecipe)var11.next();
/* 167 */     } while (!var13.matches(matrix));
/*     */     
/* 169 */     return var13.getCraftingResult(matrix);
/*     */   }
/*     */   
/*     */   public ItemStack findMatchingRecipe(IAnvil anvil, InventoryCrafting matrix)
/*     */   {
/* 174 */     int time = 200;
/* 175 */     int anvi = 1;
/* 176 */     boolean hot = false;
/* 177 */     int hammer = 0;
/* 178 */     int var2 = 0;
/* 179 */     ItemStack var3 = null;
/* 180 */     ItemStack var4 = null;
/*     */     
/* 182 */     for (int var5 = 0; var5 < matrix.func_70302_i_(); var5++) {
/* 183 */       ItemStack var6 = matrix.func_70301_a(var5);
/*     */       
/* 185 */       if (var6 != null) {
/* 186 */         if (var2 == 0) {
/* 187 */           var3 = var6;
/*     */         }
/*     */         
/* 190 */         if (var2 == 1) {
/* 191 */           var4 = var6;
/*     */         }
/*     */         
/* 194 */         var2++;
/*     */       }
/*     */     }
/*     */     
/* 198 */     if ((var2 == 2) && (var3.field_77993_c == var4.field_77993_c) && (var3.field_77994_a == 1) && (var4.field_77994_a == 1) && (Item.field_77698_e[var3.field_77993_c].isRepairable())) {
/* 199 */       Item var10 = Item.field_77698_e[var3.field_77993_c];
/* 200 */       int var12 = var10.func_77612_l() - var3.func_77952_i();
/* 201 */       int var7 = var10.func_77612_l() - var4.func_77952_i();
/* 202 */       int var8 = var12 + var7 + var10.func_77612_l() * 10 / 100;
/* 203 */       int var9 = var10.func_77612_l() - var8;
/*     */       
/* 205 */       if (var9 < 0) {
/* 206 */         var9 = 0;
/*     */       }
/*     */       
/* 209 */       return new ItemStack(var3.field_77993_c, 1, var9);
/*     */     }
/* 211 */     Iterator var11 = this.recipes.iterator();
/* 212 */     IAnvilRecipe var13 = null;
/*     */     
/* 214 */     while (var11.hasNext()) {
/* 215 */       IAnvilRecipe rec = (IAnvilRecipe)var11.next();
/*     */       
/* 217 */       if (rec.matches(matrix)) {
/* 218 */         var13 = rec;
/*     */       }
/*     */     }
/*     */     
/* 222 */     if (var13 != null) {
/* 223 */       time = var13.getCraftTime();
/* 224 */       hammer = var13.getRecipeHammer();
/* 225 */       anvi = var13.getAnvil();
/* 226 */       hot = var13.outputHot();
/*     */       
/* 228 */       anvil.setForgeTime(time);
/* 229 */       anvil.setHammerUsed(hammer);
/* 230 */       anvil.setRequiredAnvil(anvi);
/* 231 */       anvil.setHotOutput(hot);
/*     */       
/* 233 */       return var13.getCraftingResult(matrix);
/*     */     }
/* 235 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public List getRecipeList()
/*     */   {
/* 243 */     return this.recipes;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/anvil/CraftingManagerAnvil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */