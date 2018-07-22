/*    */ package minefantasy.api.tanner;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LeathercuttingRecipes
/*    */ {
/* 15 */   private static final LeathercuttingRecipes tanningBase = new LeathercuttingRecipes();
/*    */   
/*    */ 
/* 18 */   private Map tanningList = new HashMap();
/* 19 */   private Map experienceList = new HashMap();
/* 20 */   private Map metaTanningList = new HashMap();
/*    */   
/*    */ 
/*    */ 
/*    */   public static final LeathercuttingRecipes instance()
/*    */   {
/* 26 */     return tanningBase;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void addCutting(int id, ItemStack result, float exp)
/*    */   {
/* 36 */     this.tanningList.put(Integer.valueOf(id), result);
/* 37 */     this.experienceList.put(Integer.valueOf(result.field_77993_c), Float.valueOf(exp));
/*    */   }
/*    */   
/*    */   public Map getCuttingList() {
/* 41 */     return this.tanningList;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void addCutting(int itemID, int metadata, ItemStack itemstack)
/*    */   {
/* 55 */     this.metaTanningList.put(Arrays.asList(new Integer[] { Integer.valueOf(itemID), Integer.valueOf(metadata) }), itemstack);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void addCutting(int itemID, ItemStack itemstack)
/*    */   {
/* 67 */     this.metaTanningList.put(Arrays.asList(new Integer[] { Integer.valueOf(itemID), Integer.valueOf(0) }), itemstack);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void addCutting(ItemStack item, ItemStack itemstack)
/*    */   {
/* 79 */     this.metaTanningList.put(Arrays.asList(new Integer[] { Integer.valueOf(item.field_77993_c), Integer.valueOf(item.func_77960_j()) }), itemstack);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public ItemStack getCuttingResult(ItemStack item)
/*    */   {
/* 90 */     if (item == null) {
/* 91 */       return null;
/*    */     }
/* 93 */     ItemStack ret = (ItemStack)this.metaTanningList.get(Arrays.asList(new Integer[] { Integer.valueOf(item.field_77993_c), Integer.valueOf(item.func_77960_j()) }));
/* 94 */     if (ret != null) {
/* 95 */       return ret;
/*    */     }
/* 97 */     return (ItemStack)this.tanningList.get(Integer.valueOf(item.field_77993_c));
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/tanner/LeathercuttingRecipes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */