/*     */ package minefantasy.container;
/*     */ 
/*     */ import java.util.List;
/*     */ import minefantasy.api.forge.ItemHandler;
/*     */ import minefantasy.client.tile.TileEntityBlastFurnace;
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
/*     */ 
/*     */ public class ContainerBFurnace
/*     */   extends Container
/*     */ {
/*     */   private TileEntityBlastFurnace furnace;
/*     */   private int lastCookTime;
/*     */   private int lastBurnTime;
/*     */   private int lastItemBurnTime;
/*     */   private int type;
/*     */   
/*     */   public ContainerBFurnace(int meta, EntityPlayer entityplayer, TileEntityBlastFurnace tileentityfurnace)
/*     */   {
/*  30 */     InventoryPlayer inventoryplayer = entityplayer.field_71071_by;
/*  31 */     this.type = meta;
/*  32 */     this.lastCookTime = 0;
/*  33 */     this.lastBurnTime = 0;
/*  34 */     this.lastItemBurnTime = 0;
/*  35 */     this.furnace = tileentityfurnace;
/*  36 */     if (this.type == 1)
/*     */     {
/*  38 */       func_75146_a(new Slot(tileentityfurnace, 0, 68, 17));
/*  39 */       func_75146_a(new Slot(tileentityfurnace, 1, 93, 17));
/*  40 */       func_75146_a(new Slot(tileentityfurnace, 2, 80, 53));
/*     */     }
/*  42 */     if (this.type == 2)
/*     */     {
/*  44 */       func_75146_a(new Slot(tileentityfurnace, 0, 80, 53));
/*     */     }
/*  46 */     if (this.type == 3)
/*     */     {
/*  48 */       func_75146_a(new SlotFurnace(entityplayer, tileentityfurnace, 0, 80, 35));
/*  49 */       func_75146_a(new SlotFurnace(entityplayer, tileentityfurnace, 1, 80, 55));
/*     */     }
/*  51 */     for (int i = 0; i < 3; i++) {
/*  52 */       for (int k = 0; k < 9; k++) {
/*  53 */         func_75146_a(new Slot(inventoryplayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
/*     */       }
/*     */     }
/*     */     
/*  57 */     for (int j = 0; j < 9; j++) {
/*  58 */       func_75146_a(new Slot(inventoryplayer, j, 8 + j * 18, 142));
/*     */     }
/*     */   }
/*     */   
/*     */   public void updateCraftingResults() {
/*  63 */     super.func_75142_b();
/*  64 */     for (int i = 0; i < this.field_75149_d.size(); i++) {
/*  65 */       ICrafting icrafting = (ICrafting)this.field_75149_d.get(i);
/*  66 */       if (this.lastCookTime != this.furnace.cookTime) {
/*  67 */         icrafting.func_71112_a(this, 0, this.furnace.cookTime);
/*     */       }
/*  69 */       if (this.lastBurnTime != this.furnace.fuel) {
/*  70 */         icrafting.func_71112_a(this, 1, this.furnace.fuel);
/*     */       }
/*  72 */       if (this.lastItemBurnTime != this.furnace.maxFuel) {
/*  73 */         icrafting.func_71112_a(this, 2, this.furnace.maxFuel);
/*     */       }
/*     */     }
/*     */     
/*  77 */     this.lastCookTime = this.furnace.cookTime;
/*  78 */     this.lastBurnTime = this.furnace.fuel;
/*  79 */     this.lastItemBurnTime = this.furnace.maxFuel;
/*     */   }
/*     */   
/*     */   public void func_75137_b(int i, int j) {
/*  83 */     if (i == 0) {
/*  84 */       this.furnace.cookTime = j;
/*     */     }
/*  86 */     if (i == 1) {
/*  87 */       this.furnace.fuel = j;
/*     */     }
/*  89 */     if (i == 2) {
/*  90 */       this.furnace.maxFuel = j;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer entityplayer) {
/*  95 */     return this.furnace.func_70300_a(entityplayer);
/*     */   }
/*     */   
/*     */   public ItemStack func_82846_b(EntityPlayer player, int num)
/*     */   {
/* 100 */     int invSize = 3;
/* 101 */     if (this.type == 2)
/* 102 */       invSize = 1;
/* 103 */     if (this.type == 3) {
/* 104 */       invSize = 2;
/*     */     }
/* 106 */     ItemStack placedItem = null;
/* 107 */     Slot slot = (Slot)this.field_75151_b.get(num);
/*     */     
/* 109 */     if ((slot != null) && (slot.func_75216_d())) {
/* 110 */       ItemStack itemSlot = slot.func_75211_c();
/* 111 */       placedItem = itemSlot.func_77946_l();
/*     */       
/*     */ 
/* 114 */       if (num < invSize) {
/* 115 */         if (!func_75135_a(itemSlot, invSize, 36 + invSize, true)) {
/* 116 */           return null;
/*     */         }
/*     */         
/* 119 */         slot.func_75220_a(itemSlot, placedItem);
/*     */ 
/*     */       }
/* 122 */       else if ((this.type != 3) && (TileEntityBlastFurnace.getItemBurnTime(itemSlot) > 0)) {
/* 123 */         if (!func_75135_a(itemSlot, 0, invSize, false)) {
/* 124 */           return null;
/*     */         }
/*     */         
/* 127 */         slot.func_75220_a(itemSlot, placedItem);
/*     */ 
/*     */       }
/* 130 */       else if ((this.type == 1) && (ItemHandler.isFlux(itemSlot))) {
/* 131 */         if (!func_75135_a(itemSlot, 1, invSize, false)) {
/* 132 */           return null;
/*     */         }
/*     */         
/* 135 */         slot.func_75220_a(itemSlot, placedItem);
/*     */ 
/*     */       }
/* 138 */       else if (this.type == 1) {
/* 139 */         if (!func_75135_a(itemSlot, 2, invSize, false)) {
/* 140 */           return null;
/*     */         }
/*     */         
/* 143 */         slot.func_75220_a(itemSlot, placedItem);
/*     */       }
/*     */       
/* 146 */       if (itemSlot.field_77994_a == 0) {
/* 147 */         slot.func_75215_d((ItemStack)null);
/*     */       } else {
/* 149 */         slot.func_75218_e();
/*     */       }
/*     */       
/* 152 */       if (itemSlot.field_77994_a == placedItem.field_77994_a) {
/* 153 */         return null;
/*     */       }
/*     */       
/* 156 */       slot.func_82870_a(player, itemSlot);
/*     */     }
/*     */     
/* 159 */     return placedItem;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/container/ContainerBFurnace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */