/*    */ package minefantasy.api.forge;
/*    */ 
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ForgeFuel {
/*    */   protected ItemStack fuel;
/*    */   protected float duration;
/*    */   protected int baseHeat;
/*    */   protected boolean doesLight;
/*    */   
/*    */   public ForgeFuel(ItemStack item, float dura, int heat, boolean light) {
/* 12 */     this.fuel = item;
/* 13 */     this.duration = dura;
/* 14 */     this.baseHeat = heat;
/* 15 */     this.doesLight = light;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/forge/ForgeFuel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */