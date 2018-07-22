/*    */ package minefantasy.container;
/*    */ 
/*    */ import minefantasy.client.tile.TileEntityRoast;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class SlotRoast extends Slot
/*    */ {
/*    */   private TileEntityRoast roast;
/*    */   
/*    */   public SlotRoast(TileEntityRoast tile, int slotNum, int x, int y)
/*    */   {
/* 13 */     super(tile, slotNum, x, y);
/* 14 */     this.roast = tile;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean func_75214_a(ItemStack item)
/*    */   {
/* 22 */     return this.roast.isValid(item);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/container/SlotRoast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */