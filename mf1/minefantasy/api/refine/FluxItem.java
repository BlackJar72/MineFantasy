/*    */ package minefantasy.api.refine;
/*    */ 
/*    */ import net.minecraft.item.ItemStack;
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
/*    */ public class FluxItem
/*    */ {
/*    */   public int fluxOut;
/*    */   public ItemStack fluxItem;
/*    */   
/*    */   public FluxItem(ItemStack item, int out)
/*    */   {
/* 21 */     this.fluxItem = item;
/* 22 */     this.fluxOut = Math.min(out, 64);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/refine/FluxItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */