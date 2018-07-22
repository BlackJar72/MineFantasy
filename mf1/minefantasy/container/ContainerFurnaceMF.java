/*     */ package minefantasy.container;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import minefantasy.client.tile.TileEntityFurnaceMF;
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
/*     */ public class ContainerFurnaceMF
/*     */   extends Container
/*     */ {
/*     */   public TileEntityFurnaceMF smelter;
/*     */   public int lastProgress;
/*     */   public int lastFuel;
/*     */   public int lastMaxFuel;
/*     */   public int lastHeat;
/*     */   public int lastMaxHeat;
/*     */   
/*     */   public ContainerFurnaceMF(EntityPlayer play, InventoryPlayer inventoryplayer, TileEntityFurnaceMF tileentityfurnace)
/*     */   {
/*  31 */     this.lastProgress = 0;
/*  32 */     this.lastFuel = 0;
/*  33 */     this.lastMaxFuel = 0;
/*  34 */     this.lastHeat = 0;
/*  35 */     this.lastMaxHeat = 0;
/*  36 */     this.smelter = tileentityfurnace;
/*  37 */     tileentityfurnace.func_70295_k_();
/*     */     
/*  39 */     if (this.smelter.isHeater()) {
/*  40 */       func_75146_a(new Slot(this.smelter, 0, 59, 44));
/*     */     }
/*     */     else {
/*  43 */       func_75146_a(new Slot(this.smelter, 0, 36, 26));
/*  44 */       func_75146_a(new Slot(this.smelter, 1, 54, 26));
/*  45 */       func_75146_a(new Slot(this.smelter, 2, 36, 44));
/*  46 */       func_75146_a(new Slot(this.smelter, 3, 54, 44));
/*     */       
/*     */ 
/*  49 */       func_75146_a(new SlotFurnace(play, this.smelter, 4, 106, 26));
/*  50 */       func_75146_a(new SlotFurnace(play, this.smelter, 5, 124, 26));
/*  51 */       func_75146_a(new SlotFurnace(play, this.smelter, 6, 106, 44));
/*  52 */       func_75146_a(new SlotFurnace(play, this.smelter, 7, 124, 44));
/*     */     }
/*     */     
/*     */ 
/*  56 */     for (int i = 0; i < 3; i++) {
/*  57 */       for (int k = 0; k < 9; k++) {
/*  58 */         func_75146_a(new Slot(inventoryplayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
/*     */       }
/*     */     }
/*     */     
/*  62 */     for (int j = 0; j < 9; j++) {
/*  63 */       func_75146_a(new Slot(inventoryplayer, j, 8 + j * 18, 142));
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_75134_a(EntityPlayer player)
/*     */   {
/*  69 */     super.func_75134_a(player);
/*  70 */     this.smelter.func_70305_f();
/*     */   }
/*     */   
/*     */   public void func_75132_a(ICrafting icrafting)
/*     */   {
/*  75 */     super.func_75132_a(icrafting);
/*  76 */     icrafting.func_71112_a(this, 0, this.smelter.progress);
/*  77 */     icrafting.func_71112_a(this, 1, this.smelter.fuel);
/*  78 */     icrafting.func_71112_a(this, 2, this.smelter.maxFuel);
/*  79 */     icrafting.func_71112_a(this, 3, (int)this.smelter.heat);
/*  80 */     icrafting.func_71112_a(this, 4, (int)this.smelter.maxHeat);
/*     */   }
/*     */   
/*     */   public void func_75142_b()
/*     */   {
/*  85 */     super.func_75142_b();
/*     */     
/*  87 */     for (int i = 0; i < this.field_75149_d.size(); i++) {
/*  88 */       ICrafting icrafting = (ICrafting)this.field_75149_d.get(i);
/*     */       
/*  90 */       if (this.lastProgress != this.smelter.progress) {
/*  91 */         icrafting.func_71112_a(this, 0, this.smelter.progress);
/*     */       }
/*     */       
/*  94 */       if (this.lastFuel != this.smelter.fuel) {
/*  95 */         icrafting.func_71112_a(this, 1, this.smelter.fuel);
/*     */       }
/*     */       
/*  98 */       if (this.lastMaxFuel != this.smelter.maxFuel) {
/*  99 */         icrafting.func_71112_a(this, 2, this.smelter.maxFuel);
/*     */       }
/*     */       
/* 102 */       if (this.lastHeat != this.smelter.heat) {
/* 103 */         icrafting.func_71112_a(this, 3, (int)this.smelter.heat);
/*     */       }
/*     */       
/* 106 */       if (this.lastMaxHeat != this.smelter.maxHeat) {
/* 107 */         icrafting.func_71112_a(this, 4, (int)this.smelter.maxHeat);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 112 */     this.lastProgress = this.smelter.progress;
/* 113 */     this.lastFuel = this.smelter.fuel;
/* 114 */     this.lastMaxFuel = this.smelter.maxFuel;
/* 115 */     this.lastHeat = ((int)this.smelter.heat);
/* 116 */     this.lastMaxHeat = ((int)this.smelter.maxHeat);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_75137_b(int id, int value) {
/* 121 */     if (id == 0) {
/* 122 */       this.smelter.progress = value;
/*     */     }
/*     */     
/* 125 */     if (id == 1) {
/* 126 */       this.smelter.fuel = value;
/*     */     }
/*     */     
/* 129 */     if (id == 2) {
/* 130 */       this.smelter.maxFuel = value;
/*     */     }
/*     */     
/* 133 */     if (id == 3) {
/* 134 */       this.smelter.heat = value;
/*     */     }
/*     */     
/* 137 */     if (id == 4) {
/* 138 */       this.smelter.maxHeat = value;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer entityplayer) {
/* 143 */     return this.smelter.func_70300_a(entityplayer);
/*     */   }
/*     */   
/*     */   public ItemStack func_82846_b(EntityPlayer player, int num)
/*     */   {
/* 148 */     int invSize = 8;
/* 149 */     if (this.smelter.isHeater()) {
/* 150 */       invSize = 1;
/*     */     }
/* 152 */     ItemStack placedItem = null;
/* 153 */     Slot slot = (Slot)this.field_75151_b.get(num);
/*     */     
/* 155 */     if ((slot != null) && (slot.func_75216_d())) {
/* 156 */       ItemStack itemSlot = slot.func_75211_c();
/* 157 */       placedItem = itemSlot.func_77946_l();
/*     */       
/*     */ 
/* 160 */       if (num < invSize) {
/* 161 */         if (!func_75135_a(itemSlot, invSize, 36 + invSize, true)) {
/* 162 */           return null;
/*     */         }
/*     */         
/* 165 */         slot.func_75220_a(itemSlot, placedItem);
/*     */       }
/*     */       else
/*     */       {
/* 169 */         if (this.smelter.isHeater()) {
/* 170 */           if ((this.smelter.isItemFuel(itemSlot)) && 
/* 171 */             (!func_75135_a(itemSlot, 0, 1, false))) {
/* 172 */             return null;
/*     */           }
/*     */           
/*     */         }
/* 176 */         else if ((this.smelter.getResult(itemSlot) != null) && 
/* 177 */           (!func_75135_a(itemSlot, 0, 4, false))) {
/* 178 */           return null;
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 183 */         slot.func_75220_a(itemSlot, placedItem);
/*     */       }
/*     */       
/* 186 */       if (itemSlot.field_77994_a == 0) {
/* 187 */         slot.func_75215_d((ItemStack)null);
/*     */       } else {
/* 189 */         slot.func_75218_e();
/*     */       }
/*     */       
/* 192 */       if (itemSlot.field_77994_a == placedItem.field_77994_a) {
/* 193 */         return null;
/*     */       }
/*     */       
/* 196 */       slot.func_82870_a(player, itemSlot);
/*     */     }
/*     */     
/* 199 */     return placedItem;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/container/ContainerFurnaceMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */