/*     */ package minefantasy.container;
/*     */ 
/*     */ import java.util.List;
/*     */ import minefantasy.api.hound.IHoundEquipment;
/*     */ import minefantasy.entity.EntityHound;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ContainerHoundArmour
/*     */   extends Container
/*     */ {
/*     */   public EntityHound hound;
/*     */   
/*     */   public ContainerHoundArmour(EntityPlayer player, EntityHound dog)
/*     */   {
/*  21 */     InventoryPlayer inventoryplayer = player.field_71071_by;
/*  22 */     this.hound = dog;
/*     */     
/*  24 */     if ((dog.func_70909_n()) && (player != null) && (dog.func_70905_p().equals(player.field_71092_bJ))) {
/*  25 */       func_75146_a(new SlotHoundArmour(this, dog, 0, 120, 39, 0));
/*  26 */       func_75146_a(new SlotHoundArmour(this, dog, 1, 144, 39, 1));
/*     */     }
/*  28 */     for (int i = 0; i < 3; i++) {
/*  29 */       for (int k = 0; k < 9; k++) {
/*  30 */         func_75146_a(new Slot(inventoryplayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
/*     */       }
/*     */     }
/*     */     
/*  34 */     for (int j = 0; j < 9; j++) {
/*  35 */       func_75146_a(new Slot(inventoryplayer, j, 8 + j * 18, 142));
/*     */     }
/*     */   }
/*     */   
/*     */   public ContainerHoundArmour addPlayer(InventoryPlayer inventoryplayer)
/*     */   {
/*  41 */     if (inventoryplayer != null)
/*     */     {
/*  43 */       for (int i = 0; i < 3; i++) {
/*  44 */         for (int k = 0; k < 9; k++) {
/*  45 */           func_75146_a(new Slot(inventoryplayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
/*     */         }
/*     */       }
/*     */     }
/*  49 */     for (int j = 0; j < 9; j++) {
/*  50 */       func_75146_a(new Slot(inventoryplayer, j, 8 + j * 18, 142));
/*     */     }
/*     */     
/*  53 */     return this;
/*     */   }
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer var1)
/*     */   {
/*  58 */     return this.hound.func_70300_a(var1);
/*     */   }
/*     */   
/*     */   public ItemStack func_82846_b(EntityPlayer player, int num)
/*     */   {
/*  63 */     if ((!this.hound.func_70909_n()) || (player == null) || (!this.hound.func_70905_p().equals(player.field_71092_bJ))) {
/*  64 */       return null;
/*     */     }
/*     */     try
/*     */     {
/*  68 */       int invSize = this.hound.func_70302_i_();
/*  69 */       ItemStack placedItem = null;
/*  70 */       Slot slot = (Slot)this.field_75151_b.get(num);
/*     */       
/*  72 */       if ((slot != null) && (slot.func_75216_d())) {
/*  73 */         ItemStack itemSlot = slot.func_75211_c();
/*  74 */         placedItem = itemSlot.func_77946_l();
/*     */         
/*     */ 
/*  77 */         if (num < invSize)
/*     */         {
/*  79 */           if (!func_75135_a(itemSlot, invSize, 36 + invSize, true)) {
/*  80 */             return null;
/*     */           }
/*     */           
/*  83 */           slot.func_75220_a(itemSlot, placedItem);
/*     */ 
/*     */         }
/*  86 */         else if (((placedItem.func_77973_b() instanceof IHoundEquipment)) && (!((Slot)this.field_75151_b.get(((IHoundEquipment)placedItem.func_77973_b()).getPiece())).func_75216_d()) && (((SlotHoundArmour)this.field_75151_b.get(((IHoundEquipment)placedItem.func_77973_b()).getPiece())).func_75214_a(placedItem)))
/*     */         {
/*  88 */           int var6 = ((IHoundEquipment)placedItem.func_77973_b()).getPiece();
/*     */           
/*  90 */           if (!func_75135_a(itemSlot, var6, var6 + 1, false)) {
/*  91 */             return null;
/*     */           }
/*     */         }
/*     */         
/*  95 */         if (itemSlot.field_77994_a == 0) {
/*  96 */           slot.func_75215_d((ItemStack)null);
/*     */         } else {
/*  98 */           slot.func_75218_e();
/*     */         }
/*     */         
/* 101 */         if (itemSlot.field_77994_a == placedItem.field_77994_a) {
/* 102 */           return null;
/*     */         }
/*     */         
/* 105 */         slot.func_82870_a(player, itemSlot);
/*     */       }
/*     */       
/* 108 */       return placedItem;
/*     */     } catch (Exception e) {}
/* 110 */     return null;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/container/ContainerHoundArmour.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */