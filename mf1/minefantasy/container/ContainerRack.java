/*    */ package minefantasy.container;
/*    */ 
/*    */ import java.util.List;
/*    */ import minefantasy.client.tile.TileEntityWeaponRack;
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
/*    */ public class ContainerRack
/*    */   extends Container
/*    */ {
/*    */   private TileEntityWeaponRack rack;
/*    */   private int lastCookTime;
/*    */   private int lastBurnTime;
/*    */   private int lastItemBurnTime;
/*    */   
/*    */   public ContainerRack(InventoryPlayer inventoryplayer, TileEntityWeaponRack tile)
/*    */   {
/* 25 */     this.lastCookTime = 0;
/* 26 */     this.lastBurnTime = 0;
/* 27 */     this.lastItemBurnTime = 0;
/* 28 */     this.rack = tile;
/* 29 */     func_75146_a(new SlotRack(tile, 0, 19, 36));
/* 30 */     func_75146_a(new SlotRack(tile, 1, 56, 36));
/* 31 */     func_75146_a(new SlotRack(tile, 2, 93, 36));
/* 32 */     func_75146_a(new SlotRack(tile, 3, 130, 36));
/* 33 */     for (int i = 0; i < 3; i++) {
/* 34 */       for (int k = 0; k < 9; k++) {
/* 35 */         func_75146_a(new Slot(inventoryplayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
/*    */       }
/*    */     }
/*    */     
/* 39 */     for (int j = 0; j < 9; j++) {
/* 40 */       func_75146_a(new Slot(inventoryplayer, j, 8 + j * 18, 142));
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean isItemValid(ItemStack item) {
/* 45 */     return TileEntityWeaponRack.canHang(item);
/*    */   }
/*    */   
/*    */   public boolean func_75145_c(EntityPlayer entityplayer) {
/* 49 */     return this.rack.func_70300_a(entityplayer);
/*    */   }
/*    */   
/*    */   public ItemStack func_82846_b(EntityPlayer player, int num)
/*    */   {
/* 54 */     int invSize = 4;
/* 55 */     ItemStack placedItem = null;
/* 56 */     Slot slot = (Slot)this.field_75151_b.get(num);
/*    */     
/* 58 */     if ((slot != null) && (slot.func_75216_d())) {
/* 59 */       ItemStack itemSlot = slot.func_75211_c();
/* 60 */       placedItem = itemSlot.func_77946_l();
/*    */       
/*    */ 
/* 63 */       if (num < invSize) {
/* 64 */         if (!func_75135_a(itemSlot, invSize, 36 + invSize, true)) {
/* 65 */           return null;
/*    */         }
/*    */         
/* 68 */         slot.func_75220_a(itemSlot, placedItem);
/*    */       }
/*    */       else
/*    */       {
/* 72 */         if ((isItemValid(itemSlot)) && 
/* 73 */           (!func_75135_a(itemSlot, 0, invSize, false))) {
/* 74 */           return null;
/*    */         }
/*    */         
/* 77 */         slot.func_75220_a(itemSlot, placedItem);
/*    */       }
/*    */       
/* 80 */       if (itemSlot.field_77994_a == 0) {
/* 81 */         slot.func_75215_d((ItemStack)null);
/*    */       } else {
/* 83 */         slot.func_75218_e();
/*    */       }
/*    */       
/* 86 */       if (itemSlot.field_77994_a == placedItem.field_77994_a) {
/* 87 */         return null;
/*    */       }
/*    */       
/* 90 */       slot.func_82870_a(player, itemSlot);
/*    */     }
/*    */     
/* 93 */     return placedItem;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/container/ContainerRack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */