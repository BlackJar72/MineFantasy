/*     */ package minefantasy.container;
/*     */ 
/*     */ import java.util.List;
/*     */ import minefantasy.client.tile.TileEntityTailor;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.ICrafting;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class ContainerTailor extends net.minecraft.inventory.Container
/*     */ {
/*     */   private TileEntityTailor bench;
/*  13 */   private int lastProgress = 0;
/*     */   private int xSize;
/*     */   private int ySize;
/*     */   
/*     */   public ContainerTailor(TileEntityTailor tile) {
/*  18 */     this.bench = tile;
/*     */     
/*     */ 
/*  21 */     int startX = 34;
/*  22 */     int startY = 22;
/*     */     
/*  24 */     this.xSize = 4;
/*  25 */     this.ySize = 4;
/*     */     
/*  27 */     for (int yMult = 0; yMult < this.ySize; yMult++) {
/*  28 */       func_75146_a(new Slot(tile, yMult, 8, startY + yMult * 18));
/*     */     }
/*  30 */     for (yMult = 0; yMult < this.ySize; yMult++) {
/*  31 */       for (int xMult = 0; xMult < this.xSize; xMult++) {
/*  32 */         func_75146_a(new Slot(tile, xMult + yMult * this.xSize + 4, startX + xMult * 18, startY + yMult * 18));
/*     */       }
/*     */     }
/*  35 */     func_75146_a(new Slot(tile, tile.func_70302_i_() - 1, 148, 49));
/*     */   }
/*     */   
/*     */   public ContainerTailor(net.minecraft.entity.player.InventoryPlayer invPlayer, TileEntityTailor tile) {
/*  39 */     this.bench = tile;
/*     */     
/*     */ 
/*  42 */     int startX = 34;
/*  43 */     int startY = 22;
/*     */     
/*  45 */     this.xSize = 4;
/*  46 */     this.ySize = 4;
/*     */     
/*  48 */     for (int yMult = 0; yMult < this.ySize; yMult++) {
/*  49 */       func_75146_a(new Slot(tile, yMult, 8, startY + yMult * 18));
/*     */     }
/*  51 */     for (yMult = 0; yMult < this.ySize; yMult++) {
/*  52 */       for (int xMult = 0; xMult < this.xSize; xMult++) {
/*  53 */         func_75146_a(new Slot(tile, xMult + yMult * this.xSize + 4, startX + xMult * 18, startY + yMult * 18));
/*     */       }
/*     */     }
/*  56 */     func_75146_a(new Slot(tile, tile.func_70302_i_() - 1, 148, 49));
/*     */     
/*     */ 
/*     */ 
/*  60 */     for (int var3 = 0; var3 < 3; var3++) {
/*  61 */       for (int var4 = 0; var4 < 9; var4++) {
/*  62 */         func_75146_a(new Slot(invPlayer, var4 + var3 * 9 + 9, 8 + var4 * 18, 98 + var3 * 18));
/*     */       }
/*     */     }
/*     */     
/*  66 */     for (var3 = 0; var3 < 9; var3++) {
/*  67 */       func_75146_a(new Slot(invPlayer, var3, 8 + var3 * 18, 156));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void updateCraftingResults()
/*     */   {
/*  75 */     super.func_75142_b();
/*     */     
/*  77 */     for (int var1 = 0; var1 < this.field_75149_d.size(); var1++) {
/*  78 */       ICrafting var2 = (ICrafting)this.field_75149_d.get(var1);
/*     */       
/*  80 */       if (this.lastProgress != this.bench.progress) {
/*  81 */         var2.func_71112_a(this, 0, this.bench.progress);
/*     */       }
/*     */     }
/*     */     
/*  85 */     this.lastProgress = this.bench.progress;
/*     */   }
/*     */   
/*     */   public void func_75137_b(int slot, int set) {
/*  89 */     if (slot == 0) {
/*  90 */       this.bench.progress = set;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer par1EntityPlayer) {
/*  95 */     return this.bench.func_70300_a(par1EntityPlayer);
/*     */   }
/*     */   
/*     */   public ItemStack func_82846_b(EntityPlayer player, int num)
/*     */   {
/* 100 */     int invSize = this.xSize * this.ySize + 5;
/* 101 */     ItemStack placedItem = null;
/* 102 */     Slot slot = (Slot)this.field_75151_b.get(num);
/*     */     
/* 104 */     if ((slot != null) && (slot.func_75216_d())) {
/* 105 */       ItemStack itemSlot = slot.func_75211_c();
/* 106 */       placedItem = itemSlot.func_77946_l();
/*     */       
/*     */ 
/* 109 */       if (num < invSize) {
/* 110 */         if (!func_75135_a(itemSlot, invSize, 36 + invSize, true)) {
/* 111 */           return null;
/*     */         }
/*     */         
/* 114 */         slot.func_75220_a(itemSlot, placedItem);
/*     */       }
/*     */       else
/*     */       {
/* 118 */         if (!func_75135_a(itemSlot, 0, invSize - 1, false)) {
/* 119 */           return null;
/*     */         }
/*     */         
/* 122 */         slot.func_75220_a(itemSlot, placedItem);
/*     */       }
/*     */       
/* 125 */       if (itemSlot.field_77994_a == 0) {
/* 126 */         slot.func_75215_d((ItemStack)null);
/*     */       } else {
/* 128 */         slot.func_75218_e();
/*     */       }
/*     */       
/* 131 */       if (itemSlot.field_77994_a == placedItem.field_77994_a) {
/* 132 */         return null;
/*     */       }
/*     */       
/* 135 */       slot.func_82870_a(player, itemSlot);
/*     */     }
/* 137 */     return placedItem;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/container/ContainerTailor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */