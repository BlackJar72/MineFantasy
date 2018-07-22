/*     */ package minefantasy.api.anvil;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
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
/*     */ public class ShapelessAnvilRecipes
/*     */   implements IAnvilRecipe
/*     */ {
/*     */   private final ItemStack recipeOutput;
/*     */   private final boolean outputHot;
/*     */   private final List recipeItems;
/*     */   private final int recipeHammer;
/*     */   private final int anvil;
/*     */   private final int recipeTime;
/*     */   private final float recipeExperiance;
/*     */   
/*     */   public ShapelessAnvilRecipes(ItemStack output, float exp, int hammer, int anvi, int time, List components, boolean hot)
/*     */   {
/*  36 */     this.outputHot = hot;
/*  37 */     this.recipeOutput = output;
/*  38 */     this.anvil = anvi;
/*  39 */     this.recipeItems = components;
/*  40 */     this.recipeHammer = hammer;
/*  41 */     this.recipeTime = time;
/*  42 */     this.recipeExperiance = exp;
/*     */   }
/*     */   
/*     */   public ItemStack getRecipeOutput() {
/*  46 */     return this.recipeOutput;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean matches(InventoryCrafting par1InventoryCrafting)
/*     */   {
/*  53 */     ArrayList var2 = new ArrayList(this.recipeItems);
/*     */     
/*  55 */     for (int var3 = 0; var3 <= AnvilProps.globalWidth; var3++) {
/*  56 */       for (int var4 = 0; var4 <= AnvilProps.globalHeight; var4++) {
/*  57 */         ItemStack inputItem = par1InventoryCrafting.func_70463_b(var4, var3);
/*     */         
/*  59 */         if (inputItem != null) {
/*  60 */           boolean var6 = false;
/*  61 */           Iterator var7 = var2.iterator();
/*     */           
/*  63 */           while (var7.hasNext()) {
/*  64 */             ItemStack recipeItem = (ItemStack)var7.next();
/*     */             
/*  66 */             if ((HeatableItem.requiresHeating) && (HeatableItem.canHeatItem(inputItem))) {
/*  67 */               return false;
/*     */             }
/*  69 */             inputItem = getHotItem(inputItem);
/*  70 */             if (inputItem == null) {
/*  71 */               return false;
/*     */             }
/*     */             
/*  74 */             if ((inputItem.field_77993_c == recipeItem.field_77993_c) && ((recipeItem.func_77960_j() == 32767) || (inputItem.func_77960_j() == recipeItem.func_77960_j()))) {
/*  75 */               var6 = true;
/*  76 */               var2.remove(recipeItem);
/*  77 */               break;
/*     */             }
/*     */           }
/*     */           
/*  81 */           if (!var6) {
/*  82 */             return false;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  88 */     return var2.isEmpty();
/*     */   }
/*     */   
/*     */   private ItemStack getHotItem(ItemStack inputItem) {
/*  92 */     ItemStack hotItem = Components.getItem("hotItem", 0);
/*     */     
/*     */ 
/*  95 */     if (hotItem == null) {
/*  96 */       return inputItem;
/*     */     }
/*     */     
/*  99 */     if (inputItem.field_77993_c == hotItem.field_77993_c) {
/* 100 */       int temp = getTemp(inputItem);
/*     */       
/* 102 */       ItemStack ingot = getItem(inputItem);
/* 103 */       if (ingot != null) {
/* 104 */         inputItem = ingot;
/*     */       }
/* 106 */       if (!HeatableItem.canWorkItem(inputItem, temp)) {
/* 107 */         return null;
/*     */       }
/*     */     }
/* 110 */     return inputItem;
/*     */   }
/*     */   
/*     */   public static int getTemp(ItemStack item) {
/* 114 */     NBTTagCompound tag = getNBT(item);
/*     */     
/* 116 */     if (tag.func_74764_b("MFtemp")) {
/* 117 */       return tag.func_74762_e("MFtemp");
/*     */     }
/* 119 */     return 0;
/*     */   }
/*     */   
/*     */   public static ItemStack getItem(ItemStack item) {
/* 123 */     NBTTagCompound tag = getNBT(item);
/*     */     
/* 125 */     if ((tag.func_74764_b("ingotID")) && (tag.func_74764_b("ingotMeta"))) {
/* 126 */       return new ItemStack(tag.func_74762_e("ingotID"), 1, tag.func_74762_e("ingotMeta"));
/*     */     }
/*     */     
/* 129 */     return null;
/*     */   }
/*     */   
/*     */   private static NBTTagCompound getNBT(ItemStack item) {
/* 133 */     if (!item.func_77942_o())
/* 134 */       item.func_77982_d(new NBTTagCompound());
/* 135 */     return item.func_77978_p();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ItemStack getCraftingResult(InventoryCrafting par1InventoryCrafting)
/*     */   {
/* 142 */     return this.recipeOutput.func_77946_l();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getRecipeSize()
/*     */   {
/* 149 */     return this.recipeItems.size();
/*     */   }
/*     */   
/*     */   public int getCraftTime()
/*     */   {
/* 154 */     return this.recipeTime;
/*     */   }
/*     */   
/*     */   public int getRecipeHammer()
/*     */   {
/* 159 */     return this.recipeHammer;
/*     */   }
/*     */   
/*     */   public float getExperiance()
/*     */   {
/* 164 */     return this.recipeExperiance;
/*     */   }
/*     */   
/*     */   public int getAnvil()
/*     */   {
/* 169 */     return this.anvil;
/*     */   }
/*     */   
/*     */   public boolean outputHot()
/*     */   {
/* 174 */     return this.outputHot;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/anvil/ShapelessAnvilRecipes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */