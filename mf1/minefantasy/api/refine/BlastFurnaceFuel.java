/*    */ package minefantasy.api.refine;
/*    */ 
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class BlastFurnaceFuel {
/*    */   public ItemStack fuel;
/*    */   public float smelts;
/*    */   
/*    */   public BlastFurnaceFuel(ItemStack item, float uses) {
/* 10 */     this.fuel = item;
/* 11 */     this.smelts = uses;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/refine/BlastFurnaceFuel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */