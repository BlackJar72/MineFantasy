/*    */ package minefantasy.container;
/*    */ 
/*    */ import minefantasy.client.tile.TileEntityWeaponRack;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class SlotRack
/*    */   extends Slot
/*    */ {
/*    */   public SlotRack(TileEntityWeaponRack inventory, int slotNum, int x, int y)
/*    */   {
/* 12 */     super(inventory, slotNum, x, y);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean func_75214_a(ItemStack item)
/*    */   {
/* 21 */     return TileEntityWeaponRack.canHang(item);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/container/SlotRack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */