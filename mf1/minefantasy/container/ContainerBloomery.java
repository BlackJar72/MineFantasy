/*     */ package minefantasy.container;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import minefantasy.client.tile.TileEntitySmelter;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.ICrafting;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.inventory.SlotFurnace;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ContainerBloomery
/*     */   extends Container
/*     */ {
/*     */   private TileEntitySmelter bloomery;
/*     */   private int lastCookTime;
/*     */   private int lastBurnTime;
/*     */   private int lastItemBurnTime;
/*     */   
/*     */   public ContainerBloomery(InventoryPlayer inventoryplayer, TileEntitySmelter tileentityfurnace)
/*     */   {
/*  29 */     this.lastCookTime = 0;
/*  30 */     this.lastBurnTime = 0;
/*  31 */     this.lastItemBurnTime = 0;
/*  32 */     this.bloomery = tileentityfurnace;
/*  33 */     func_75146_a(new Slot(tileentityfurnace, 0, 56, 46));
/*  34 */     func_75146_a(new Slot(tileentityfurnace, 1, 79, 17));
/*  35 */     func_75146_a(new Slot(tileentityfurnace, 2, 102, 46));
/*  36 */     func_75146_a(new SlotFurnace(inventoryplayer.field_70458_d, tileentityfurnace, this.bloomery.getOutSlot(), 79, 53));
/*     */     
/*  38 */     for (int i = 0; i < 3; i++) {
/*  39 */       for (int k = 0; k < 9; k++) {
/*  40 */         func_75146_a(new Slot(inventoryplayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
/*     */       }
/*     */     }
/*     */     
/*  44 */     for (int j = 0; j < 9; j++) {
/*  45 */       func_75146_a(new Slot(inventoryplayer, j, 8 + j * 18, 142));
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_75132_a(ICrafting icrafting)
/*     */   {
/*  51 */     super.func_75132_a(icrafting);
/*  52 */     icrafting.func_71112_a(this, 0, this.bloomery.progress);
/*  53 */     icrafting.func_71112_a(this, 1, this.bloomery.fuel);
/*  54 */     icrafting.func_71112_a(this, 2, this.bloomery.maxFuel);
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_75142_b()
/*     */   {
/*  60 */     super.func_75142_b();
/*     */     
/*  62 */     for (int i = 0; i < this.field_75149_d.size(); i++) {
/*  63 */       ICrafting icrafting = (ICrafting)this.field_75149_d.get(i);
/*     */       
/*  65 */       if (this.lastCookTime != this.bloomery.progress) {
/*  66 */         icrafting.func_71112_a(this, 0, this.bloomery.progress);
/*     */       }
/*     */       
/*  69 */       if (this.lastBurnTime != this.bloomery.fuel) {
/*  70 */         icrafting.func_71112_a(this, 1, this.bloomery.fuel);
/*     */       }
/*     */       
/*  73 */       if (this.lastItemBurnTime != this.bloomery.maxFuel) {
/*  74 */         icrafting.func_71112_a(this, 2, this.bloomery.maxFuel);
/*     */       }
/*     */     }
/*     */     
/*  78 */     this.lastCookTime = this.bloomery.progress;
/*  79 */     this.lastBurnTime = this.bloomery.fuel;
/*  80 */     this.lastItemBurnTime = this.bloomery.maxFuel;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_75137_b(int id, int value) {
/*  85 */     if (id == 0) {
/*  86 */       this.bloomery.progress = value;
/*     */     }
/*     */     
/*  89 */     if (id == 1) {
/*  90 */       this.bloomery.fuel = value;
/*     */     }
/*     */     
/*  93 */     if (id == 2) {
/*  94 */       this.bloomery.maxFuel = value;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer entityplayer) {
/*  99 */     return this.bloomery.func_70300_a(entityplayer);
/*     */   }
/*     */   
/*     */   public ItemStack func_82846_b(EntityPlayer player, int num)
/*     */   {
/* 104 */     int invSize = 4;
/* 105 */     ItemStack placedItem = null;
/* 106 */     Slot slot = (Slot)this.field_75151_b.get(num);
/*     */     
/* 108 */     if ((slot != null) && (slot.func_75216_d())) {
/* 109 */       ItemStack itemSlot = slot.func_75211_c();
/* 110 */       placedItem = itemSlot.func_77946_l();
/*     */       
/*     */ 
/* 113 */       if (num < invSize) {
/* 114 */         if (!func_75135_a(itemSlot, invSize, 36 + invSize, true)) {
/* 115 */           return null;
/*     */         }
/*     */         
/* 118 */         slot.func_75220_a(itemSlot, placedItem);
/*     */       }
/*     */       else
/*     */       {
/* 122 */         if (this.bloomery.goesInCarbon(itemSlot)) {
/* 123 */           if (!func_75135_a(itemSlot, 2, 3, false)) {
/* 124 */             return null;
/*     */           }
/* 126 */         } else if (this.bloomery.goesInFuel(itemSlot)) {
/* 127 */           if (!func_75135_a(itemSlot, 0, 1, false)) {
/* 128 */             return null;
/*     */           }
/*     */         }
/* 131 */         else if (!func_75135_a(itemSlot, 1, 2, true)) {
/* 132 */           return null;
/*     */         }
/*     */         
/*     */ 
/* 136 */         slot.func_75220_a(itemSlot, placedItem);
/*     */       }
/*     */       
/* 139 */       if (itemSlot.field_77994_a == 0) {
/* 140 */         slot.func_75215_d((ItemStack)null);
/*     */       } else {
/* 142 */         slot.func_75218_e();
/*     */       }
/*     */       
/* 145 */       if (itemSlot.field_77994_a == placedItem.field_77994_a) {
/* 146 */         return null;
/*     */       }
/*     */       
/* 149 */       slot.func_82870_a(player, itemSlot);
/*     */     }
/*     */     
/* 152 */     return placedItem;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/container/ContainerBloomery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */