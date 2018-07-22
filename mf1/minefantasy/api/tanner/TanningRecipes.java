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
/*    */ public class TanningRecipes
/*    */ {
/* 15 */   private static final TanningRecipes tanningBase = new TanningRecipes();
/*    */   
/*    */ 
/* 18 */   private Map tanningList = new HashMap();
/* 19 */   private Map experienceList = new HashMap();
/* 20 */   private Map metaTanningList = new HashMap();
/*    */   
/*    */ 
/*    */ 
/*    */   public static final TanningRecipes instance()
/*    */   {
/* 26 */     return tanningBase;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void addTanning(int id, ItemStack result, float exp)
/*    */   {
/* 36 */     this.tanningList.put(Integer.valueOf(id), result);
/* 37 */     this.experienceList.put(Integer.valueOf(result.field_77993_c), Float.valueOf(exp));
/*    */   }
/*    */   
/*    */   public Map getTanningList() {
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
/*    */   public void addTanning(int itemID, int metadata, ItemStack itemstack)
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
/*    */   public ItemStack getTanningResult(ItemStack item)
/*    */   {
/* 66 */     if (item == null) {
/* 67 */       return null;
/*    */     }
/* 69 */     ItemStack ret = (ItemStack)this.metaTanningList.get(Arrays.asList(new Integer[] { Integer.valueOf(item.field_77993_c), Integer.valueOf(item.func_77960_j()) }));
/* 70 */     if (ret != null) {
/* 71 */       return ret;
/*    */     }
/* 73 */     return (ItemStack)this.tanningList.get(Integer.valueOf(item.field_77993_c));
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/tanner/TanningRecipes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */