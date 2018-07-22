/*    */ package minefantasy.api.refine;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import net.minecraft.inventory.InventoryCrafting;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ public class Alloy
/*    */ {
/*    */   private final List recipeItems;
/*    */   private final ItemStack recipeOutput;
/*    */   private final int level;
/* 17 */   private Map props = new HashMap();
/*    */   
/*    */   public Alloy(ItemStack output, int requiredLevel, List items) {
/* 20 */     this.recipeItems = items;
/* 21 */     this.recipeOutput = output;
/* 22 */     this.level = requiredLevel;
/*    */   }
/*    */   
/*    */   public ItemStack getRecipeOutput() {
/* 26 */     return this.recipeOutput;
/*    */   }
/*    */   
/*    */   public Alloy addProperty(String id, Object prop) {
/* 30 */     this.props.put(id, prop);
/* 31 */     return this;
/*    */   }
/*    */   
/*    */   public Object getProperty(String id) {
/* 35 */     return this.props.get(id);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean matches(ItemStack[] inventory)
/*    */   {
/* 42 */     ArrayList checkRecipe = new ArrayList(this.recipeItems);
/*    */     
/* 44 */     for (ItemStack itemstack : inventory) {
/* 45 */       if (itemstack != null) {
/* 46 */         boolean matches = false;
/* 47 */         Iterator iterator = checkRecipe.iterator();
/*    */         
/* 49 */         while (iterator.hasNext()) {
/* 50 */           ItemStack checkItem = (ItemStack)iterator.next();
/*    */           
/* 52 */           if ((itemstack.field_77993_c == checkItem.field_77993_c) && ((checkItem.func_77960_j() == 32767) || (itemstack.func_77960_j() == checkItem.func_77960_j()))) {
/* 53 */             matches = true;
/* 54 */             checkRecipe.remove(checkItem);
/* 55 */             break;
/*    */           }
/*    */         }
/*    */         
/* 59 */         if (!matches) {
/* 60 */           return false;
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 65 */     return checkRecipe.isEmpty();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public ItemStack getCraftingResult(InventoryCrafting inv)
/*    */   {
/* 72 */     return this.recipeOutput.func_77946_l();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int getRecipeSize()
/*    */   {
/* 79 */     return this.recipeItems.size();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getLevel()
/*    */   {
/* 89 */     return this.level;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/refine/Alloy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */