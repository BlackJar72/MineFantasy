/*    */ package minefantasy.container;
/*    */ 
/*    */ import java.util.List;
/*    */ import minefantasy.client.tile.TileEntityRoast;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ContainerRoast
/*    */   extends Container
/*    */ {
/*    */   private TileEntityRoast roast;
/*    */   private int lastCookTime;
/*    */   private int lastBurnTime;
/*    */   private int lastItemBurnTime;
/*    */   
/*    */   public ContainerRoast(InventoryPlayer inventoryplayer, TileEntityRoast tile)
/*    */   {
/* 25 */     this.lastCookTime = 0;
/* 26 */     this.lastBurnTime = 0;
/* 27 */     this.lastItemBurnTime = 0;
/* 28 */     this.roast = tile;
/* 29 */     func_75146_a(new SlotRoast(tile, 0, 44, 33));
/* 30 */     func_75146_a(new SlotRoast(tile, 1, 62, 33));
/* 31 */     func_75146_a(new SlotRoast(tile, 2, 80, 33));
/* 32 */     func_75146_a(new SlotRoast(tile, 3, 98, 33));
/* 33 */     func_75146_a(new SlotRoast(tile, 4, 116, 33));
/* 34 */     for (int i = 0; i < 3; i++) {
/* 35 */       for (int k = 0; k < 9; k++) {
/* 36 */         func_75146_a(new Slot(inventoryplayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
/*    */       }
/*    */     }
/*    */     
/* 40 */     for (int j = 0; j < 9; j++) {
/* 41 */       func_75146_a(new Slot(inventoryplayer, j, 8 + j * 18, 142));
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean isItemValid(ItemStack item) {
/* 46 */     return this.roast.isValid(item);
/*    */   }
/*    */   
/*    */   public boolean func_75145_c(EntityPlayer entityplayer) {
/* 50 */     return this.roast.func_70300_a(entityplayer);
/*    */   }
/*    */   
/*    */   public ItemStack func_82846_b(EntityPlayer player, int num)
/*    */   {
/* 55 */     int invSize = 5;
/* 56 */     ItemStack placedItem = null;
/* 57 */     Slot slot = (Slot)this.field_75151_b.get(num);
/*    */     
/* 59 */     if ((slot != null) && (slot.func_75216_d())) {
/* 60 */       ItemStack itemSlot = slot.func_75211_c();
/* 61 */       placedItem = itemSlot.func_77946_l();
/*    */       
/*    */ 
/* 64 */       if (num < invSize) {
/* 65 */         if (!func_75135_a(itemSlot, invSize, 36 + invSize, true)) {
/* 66 */           return null;
/*    */         }
/*    */         
/* 69 */         slot.func_75220_a(itemSlot, placedItem);
/*    */       }
/*    */       
/* 72 */       if (itemSlot.field_77994_a == 0) {
/* 73 */         slot.func_75215_d((ItemStack)null);
/*    */       } else {
/* 75 */         slot.func_75218_e();
/*    */       }
/*    */       
/* 78 */       if (itemSlot.field_77994_a == placedItem.field_77994_a) {
/* 79 */         return null;
/*    */       }
/*    */       
/* 82 */       slot.func_82870_a(player, itemSlot);
/*    */     }
/*    */     
/* 85 */     return placedItem;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/container/ContainerRoast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */