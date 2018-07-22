/*    */ package minefantasy.container;
/*    */ 
/*    */ import java.util.List;
/*    */ import minefantasy.client.tile.TileEntityTripHammer;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ContainerHammer
/*    */   extends Container
/*    */ {
/*    */   private TileEntityTripHammer hammer;
/*    */   
/*    */   public ContainerHammer(InventoryPlayer inventoryplayer, TileEntityTripHammer tile)
/*    */   {
/* 21 */     this.hammer = tile;
/* 22 */     func_75146_a(new Slot(tile, 0, 54, 35));
/* 23 */     func_75146_a(new Slot(tile, 1, 116, 35));
/* 24 */     for (int i = 0; i < 3; i++) {
/* 25 */       for (int k = 0; k < 9; k++) {
/* 26 */         func_75146_a(new Slot(inventoryplayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
/*    */       }
/*    */     }
/*    */     
/* 30 */     for (int j = 0; j < 9; j++) {
/* 31 */       func_75146_a(new Slot(inventoryplayer, j, 8 + j * 18, 142));
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean func_75145_c(EntityPlayer entityplayer) {
/* 36 */     return this.hammer.func_70300_a(entityplayer);
/*    */   }
/*    */   
/*    */   public ItemStack func_82846_b(EntityPlayer player, int num)
/*    */   {
/* 41 */     int invSize = 2;
/* 42 */     ItemStack placedItem = null;
/* 43 */     Slot slot = (Slot)this.field_75151_b.get(num);
/*    */     
/* 45 */     if ((slot != null) && (slot.func_75216_d())) {
/* 46 */       ItemStack itemSlot = slot.func_75211_c();
/* 47 */       placedItem = itemSlot.func_77946_l();
/*    */       
/*    */ 
/* 50 */       if (num < invSize) {
/* 51 */         if (!func_75135_a(itemSlot, invSize, 36 + invSize, true)) {
/* 52 */           return null;
/*    */         }
/*    */         
/* 55 */         slot.func_75220_a(itemSlot, placedItem);
/*    */       }
/*    */       else
/*    */       {
/* 59 */         if (!func_75135_a(itemSlot, 0, 1, false)) {
/* 60 */           return null;
/*    */         }
/*    */         
/* 63 */         slot.func_75220_a(itemSlot, placedItem);
/*    */       }
/*    */       
/* 66 */       if (itemSlot.field_77994_a == 0) {
/* 67 */         slot.func_75215_d((ItemStack)null);
/*    */       } else {
/* 69 */         slot.func_75218_e();
/*    */       }
/*    */       
/* 72 */       if (itemSlot.field_77994_a == placedItem.field_77994_a) {
/* 73 */         return null;
/*    */       }
/*    */       
/* 76 */       slot.func_82870_a(player, itemSlot);
/*    */     }
/*    */     
/* 79 */     return placedItem;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/container/ContainerHammer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */