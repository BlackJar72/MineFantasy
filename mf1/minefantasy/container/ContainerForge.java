/*     */ package minefantasy.container;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import minefantasy.client.tile.TileEntityForge;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.ICrafting;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class ContainerForge
/*     */   extends Container
/*     */ {
/*     */   private TileEntityForge furnace;
/*  19 */   private int lastCookTime = 0;
/*  20 */   private int lastBurnTime = 0;
/*     */   
/*     */   public ContainerForge(InventoryPlayer invPlayer, TileEntityForge forge) {
/*  23 */     this.furnace = forge;
/*  24 */     func_75146_a(new Slot(forge, 0, 26, 44));
/*  25 */     for (int x = 0; x < 3; x++) {
/*  26 */       for (int y = 0; y < 3; y++) {
/*  27 */         func_75146_a(new Slot(forge, y * 3 + x + 1, 58 + x * 22, 13 + y * 22));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  32 */     for (int var3 = 0; var3 < 3; var3++) {
/*  33 */       for (int var4 = 0; var4 < 9; var4++) {
/*  34 */         func_75146_a(new Slot(invPlayer, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
/*     */       }
/*     */     }
/*     */     
/*  38 */     for (var3 = 0; var3 < 9; var3++) {
/*  39 */       func_75146_a(new Slot(invPlayer, var3, 8 + var3 * 18, 142));
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_75132_a(ICrafting craft) {
/*  44 */     super.func_75132_a(craft);
/*  45 */     craft.func_71112_a(this, 1, this.furnace.fuel);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void updateCraftingResults()
/*     */   {
/*  52 */     super.func_75142_b();
/*  53 */     Iterator var1 = this.field_75149_d.iterator();
/*     */     
/*  55 */     while (var1.hasNext()) {
/*  56 */       ICrafting var2 = (ICrafting)var1.next();
/*     */       
/*  58 */       if (this.lastBurnTime != this.furnace.fuel) {
/*  59 */         var2.func_71112_a(this, 1, this.furnace.fuel);
/*     */       }
/*     */     }
/*     */     
/*  63 */     this.lastBurnTime = this.furnace.fuel;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_75137_b(int id, int amount) {
/*  68 */     if (id == 1) {
/*  69 */       this.furnace.fuel = amount;
/*     */     }
/*     */   }
/*     */   
/*     */   public ItemStack func_82846_b(EntityPlayer player, int num)
/*     */   {
/*  75 */     int invSize = 10;
/*  76 */     ItemStack placedItem = null;
/*  77 */     Slot slot = (Slot)this.field_75151_b.get(num);
/*     */     
/*  79 */     if ((slot != null) && (slot.func_75216_d())) {
/*  80 */       ItemStack itemSlot = slot.func_75211_c();
/*  81 */       placedItem = itemSlot.func_77946_l();
/*     */       
/*     */ 
/*  84 */       if (num < invSize) {
/*  85 */         if (!func_75135_a(itemSlot, invSize, 36 + invSize, true)) {
/*  86 */           return null;
/*     */         }
/*     */         
/*  89 */         slot.func_75220_a(itemSlot, placedItem);
/*     */       }
/*     */       else
/*     */       {
/*  93 */         if (this.furnace.isItemFuel(itemSlot)) {
/*  94 */           if (((Slot)this.field_75151_b.get(0)).func_75216_d()) {
/*  95 */             return null;
/*     */           }
/*     */           
/*  98 */           if ((itemSlot.func_77942_o()) && (itemSlot.field_77994_a == 1)) {
/*  99 */             ((Slot)this.field_75151_b.get(0)).func_75215_d(itemSlot.func_77946_l());
/* 100 */             itemSlot.field_77994_a = 0;
/* 101 */           } else if (itemSlot.field_77994_a >= 1) {
/* 102 */             ((Slot)this.field_75151_b.get(0)).func_75215_d(new ItemStack(itemSlot.field_77993_c, 1, itemSlot.func_77960_j()));
/* 103 */             itemSlot.field_77994_a -= 1;
/*     */           }
/*     */         }
/*     */         
/* 107 */         slot.func_75220_a(itemSlot, placedItem);
/*     */       }
/*     */       
/* 110 */       if (itemSlot.field_77994_a == 0) {
/* 111 */         slot.func_75215_d((ItemStack)null);
/*     */       } else {
/* 113 */         slot.func_75218_e();
/*     */       }
/*     */       
/* 116 */       if (itemSlot.field_77994_a == placedItem.field_77994_a) {
/* 117 */         return null;
/*     */       }
/*     */       
/* 120 */       slot.func_82870_a(player, itemSlot);
/*     */     }
/* 122 */     return placedItem;
/*     */   }
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer user) {
/* 126 */     return this.furnace.func_70300_a(user);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/container/ContainerForge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */