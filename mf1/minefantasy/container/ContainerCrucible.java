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
/*     */ public class ContainerCrucible
/*     */   extends Container
/*     */ {
/*     */   private TileEntitySmelter smelter;
/*     */   private int lastCookTime;
/*     */   private int shownIngot;
/*     */   
/*     */   public ContainerCrucible(InventoryPlayer inventoryplayer, TileEntitySmelter tileentityfurnace)
/*     */   {
/*  28 */     this.lastCookTime = 0;
/*  29 */     this.shownIngot = 0;
/*  30 */     int outOffset = 0;
/*  31 */     this.smelter = tileentityfurnace;
/*  32 */     int s = 3;
/*  33 */     int xp = 37;
/*  34 */     int yp = 17;
/*  35 */     if (this.smelter.getTier() == 2) {
/*  36 */       s = 4;
/*  37 */       xp = 30;
/*  38 */       yp = 7;
/*  39 */       outOffset = 9;
/*     */     }
/*  41 */     for (int x = 0; x < s; x++) {
/*  42 */       for (int y = 0; y < s; y++) {
/*  43 */         func_75146_a(new Slot(tileentityfurnace, 1 + y * s + x, xp + x * 18, yp + y * 18));
/*     */       }
/*     */     }
/*  46 */     func_75146_a(new SlotFurnace(inventoryplayer.field_70458_d, tileentityfurnace, this.smelter.getOutSlot(), 135 + outOffset, 35));
/*  47 */     for (int i = 0; i < 3; i++) {
/*  48 */       for (int k = 0; k < 9; k++) {
/*  49 */         func_75146_a(new Slot(inventoryplayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
/*     */       }
/*     */     }
/*     */     
/*  53 */     for (int j = 0; j < 9; j++) {
/*  54 */       func_75146_a(new Slot(inventoryplayer, j, 8 + j * 18, 142));
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_75132_a(ICrafting icrafting)
/*     */   {
/*  60 */     super.func_75132_a(icrafting);
/*  61 */     icrafting.func_71112_a(this, 0, this.smelter.progress);
/*  62 */     icrafting.func_71112_a(this, 1, this.smelter.showIngot ? 1 : 0);
/*     */   }
/*     */   
/*     */   public void func_75142_b()
/*     */   {
/*  67 */     super.func_75142_b();
/*     */     
/*  69 */     for (int i = 0; i < this.field_75149_d.size(); i++) {
/*  70 */       ICrafting icrafting = (ICrafting)this.field_75149_d.get(i);
/*     */       
/*  72 */       if (this.lastCookTime != this.smelter.progress) {
/*  73 */         icrafting.func_71112_a(this, 0, this.smelter.progress);
/*     */       }
/*     */       
/*  76 */       if (this.shownIngot != (this.smelter.showIngot ? 1 : 0)) {
/*  77 */         icrafting.func_71112_a(this, 1, this.smelter.showIngot ? 1 : 0);
/*     */       }
/*     */     }
/*     */     
/*  81 */     this.lastCookTime = this.smelter.progress;
/*  82 */     this.shownIngot = (this.smelter.showIngot ? 1 : 0);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_75137_b(int id, int value) {
/*  87 */     if (id == 0) {
/*  88 */       this.smelter.progress = value;
/*     */     }
/*  90 */     if (id == 1) {
/*  91 */       this.smelter.showIngot = (value == 1);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer entityplayer) {
/*  96 */     return this.smelter.func_70300_a(entityplayer);
/*     */   }
/*     */   
/*     */   public ItemStack func_82846_b(EntityPlayer player, int num)
/*     */   {
/* 101 */     int invSize = 10;
/* 102 */     if (this.smelter.getTier() == 2) {
/* 103 */       invSize = 17;
/*     */     }
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
/* 122 */         if (!func_75135_a(itemSlot, 0, 9, false)) {
/* 123 */           return null;
/*     */         }
/*     */         
/* 126 */         slot.func_75220_a(itemSlot, placedItem);
/*     */       }
/*     */       
/* 129 */       if (itemSlot.field_77994_a == 0) {
/* 130 */         slot.func_75215_d((ItemStack)null);
/*     */       } else {
/* 132 */         slot.func_75218_e();
/*     */       }
/*     */       
/* 135 */       if (itemSlot.field_77994_a == placedItem.field_77994_a) {
/* 136 */         return null;
/*     */       }
/*     */       
/* 139 */       slot.func_82870_a(player, itemSlot);
/*     */     }
/*     */     
/* 142 */     return placedItem;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/container/ContainerCrucible.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */