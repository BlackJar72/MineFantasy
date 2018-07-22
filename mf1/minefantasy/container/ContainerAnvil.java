/*     */ package minefantasy.container;
/*     */ 
/*     */ import java.util.List;
/*     */ import minefantasy.client.tile.TileEntityAnvil;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class ContainerAnvil extends net.minecraft.inventory.Container
/*     */ {
/*     */   private TileEntityAnvil anvil;
/*     */   private boolean hasPlayer;
/*  14 */   private int lastCookTime = 0;
/*  15 */   private int lastBurnTime = 0;
/*  16 */   private int lastItemBurnTime = 0;
/*     */   private int xSize;
/*     */   private int ySize;
/*     */   
/*     */   public ContainerAnvil(TileEntityAnvil tile) {
/*  21 */     this.anvil = tile;
/*     */     
/*  23 */     if (tile.isBig()) {
/*  24 */       this.ySize = 204;
/*     */     }
/*     */     
/*  27 */     int startX = 8;
/*  28 */     int startY = 8;
/*     */     
/*  30 */     this.xSize = tile.gridSize()[0];
/*  31 */     this.ySize = tile.gridSize()[1];
/*     */     
/*  33 */     for (int yMult = 0; yMult < this.ySize; yMult++) {
/*  34 */       for (int xMult = 0; xMult < this.xSize; xMult++) {
/*  35 */         func_75146_a(new Slot(tile, xMult + yMult * this.xSize, startX + xMult * 18, startY + yMult * 18));
/*     */       }
/*     */     }
/*  38 */     func_75146_a(new SlotAnvil(tile.getSmith(), tile, tile.getGridSize(), 144, 35));
/*     */   }
/*     */   
/*     */   public ContainerAnvil(InventoryPlayer invPlayer, TileEntityAnvil tile) {
/*  42 */     this.hasPlayer = (invPlayer != null);
/*  43 */     this.anvil = tile;
/*     */     
/*     */ 
/*  46 */     int startX = tile.getPositions()[0][0];
/*  47 */     int startY = tile.getPositions()[0][1];
/*     */     
/*  49 */     this.xSize = tile.gridSize()[0];
/*  50 */     this.ySize = tile.gridSize()[1];
/*     */     
/*  52 */     for (int yMult = 0; yMult < this.ySize; yMult++) {
/*  53 */       for (int xMult = 0; xMult < this.xSize; xMult++) {
/*  54 */         func_75146_a(new Slot(tile, xMult + yMult * this.xSize, startX + xMult * 18, startY + yMult * 18));
/*     */       }
/*     */     }
/*  57 */     if (invPlayer != null) {
/*  58 */       func_75146_a(new SlotAnvil(invPlayer.field_70458_d, tile, tile.getGridSize(), tile.getPositions()[1][0], tile.getPositions()[1][1]));
/*     */       
/*     */ 
/*  61 */       for (int var3 = 0; var3 < 3; var3++) {
/*  62 */         for (int var4 = 0; var4 < 9; var4++) {
/*  63 */           func_75146_a(new Slot(invPlayer, var4 + var3 * 9 + 9, tile.getPositions()[2][0] + var4 * 18, tile.getPositions()[2][1] + var3 * 18));
/*     */         }
/*     */       }
/*     */       
/*  67 */       for (var3 = 0; var3 < 9; var3++) {
/*  68 */         func_75146_a(new Slot(invPlayer, var3, tile.getPositions()[2][0] + var3 * 18, tile.getPositions()[2][1] + 58));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void updateCraftingResults()
/*     */   {
/*  77 */     super.func_75142_b();
/*     */     
/*  79 */     for (int var1 = 0; var1 < this.field_75149_d.size(); var1++) {
/*  80 */       net.minecraft.inventory.ICrafting var2 = (net.minecraft.inventory.ICrafting)this.field_75149_d.get(var1);
/*     */       
/*  82 */       if (this.lastCookTime != this.anvil.forgeTime) {
/*  83 */         var2.func_71112_a(this, 0, this.anvil.forgeTime);
/*     */       }
/*     */     }
/*     */     
/*  87 */     this.lastCookTime = this.anvil.forgeTime;
/*     */   }
/*     */   
/*     */   public void func_75137_b(int slot, int set) {
/*  91 */     if (slot == 0) {
/*  92 */       this.anvil.forgeTime = set;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer par1EntityPlayer) {
/*  97 */     return this.anvil.func_70300_a(par1EntityPlayer);
/*     */   }
/*     */   
/*     */   public ItemStack func_82846_b(EntityPlayer player, int num)
/*     */   {
/* 102 */     int invSize = this.xSize * this.ySize + 1;
/* 103 */     ItemStack placedItem = null;
/* 104 */     Slot slot = (Slot)this.field_75151_b.get(num);
/*     */     
/* 106 */     if ((slot != null) && (slot.func_75216_d())) {
/* 107 */       ItemStack itemSlot = slot.func_75211_c();
/* 108 */       placedItem = itemSlot.func_77946_l();
/*     */       
/*     */ 
/* 111 */       if (num < invSize) {
/* 112 */         if (!func_75135_a(itemSlot, invSize, 36 + invSize, true)) {
/* 113 */           return null;
/*     */         }
/*     */         
/* 116 */         slot.func_75220_a(itemSlot, placedItem);
/*     */       }
/*     */       else
/*     */       {
/* 120 */         if (!func_75135_a(itemSlot, 0, invSize - 1, false)) {
/* 121 */           return null;
/*     */         }
/*     */         
/* 124 */         slot.func_75220_a(itemSlot, placedItem);
/*     */       }
/*     */       
/* 127 */       if (itemSlot.field_77994_a == 0) {
/* 128 */         slot.func_75215_d((ItemStack)null);
/*     */       } else {
/* 130 */         slot.func_75218_e();
/*     */       }
/*     */       
/* 133 */       if (itemSlot.field_77994_a == placedItem.field_77994_a) {
/* 134 */         return null;
/*     */       }
/*     */       
/* 137 */       slot.func_82870_a(player, itemSlot);
/*     */     }
/* 139 */     return placedItem;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/container/ContainerAnvil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */