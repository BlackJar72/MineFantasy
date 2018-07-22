/*     */ package minefantasy.container;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import java.util.List;
/*     */ import minefantasy.client.tile.TileEntityOven;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.ICrafting;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class ContainerOven extends Container
/*     */ {
/*     */   private TileEntityOven oven;
/*     */   private int lastCookTime;
/*     */   private int lastBurnTime;
/*     */   private int lastItemBurnTime;
/*     */   
/*     */   public ContainerOven(InventoryPlayer user, TileEntityOven tile)
/*     */   {
/*  22 */     tile.func_70295_k_();
/*     */     
/*  24 */     this.oven = tile;
/*  25 */     func_75146_a(new Slot(tile, 0, 56, 17));
/*  26 */     func_75146_a(new Slot(tile, 1, 56, 53));
/*  27 */     func_75146_a(new net.minecraft.inventory.SlotFurnace(user.field_70458_d, tile, 2, 116, 35));
/*     */     
/*     */ 
/*  30 */     for (int i = 0; i < 3; i++) {
/*  31 */       for (int j = 0; j < 9; j++) {
/*  32 */         func_75146_a(new Slot(user, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
/*     */       }
/*     */     }
/*     */     
/*  36 */     for (i = 0; i < 9; i++) {
/*  37 */       func_75146_a(new Slot(user, i, 8 + i * 18, 142));
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_75134_a(EntityPlayer player)
/*     */   {
/*  43 */     super.func_75134_a(player);
/*  44 */     this.oven.func_70305_f();
/*     */   }
/*     */   
/*     */   public void func_75132_a(ICrafting manager)
/*     */   {
/*  49 */     super.func_75132_a(manager);
/*  50 */     manager.func_71112_a(this, 0, this.oven.progress);
/*  51 */     manager.func_71112_a(this, 1, this.oven.fuel);
/*  52 */     manager.func_71112_a(this, 2, this.oven.maxFuel);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_75142_b()
/*     */   {
/*  60 */     super.func_75142_b();
/*     */     
/*  62 */     for (int i = 0; i < this.field_75149_d.size(); i++) {
/*  63 */       ICrafting icrafting = (ICrafting)this.field_75149_d.get(i);
/*     */       
/*  65 */       if (this.lastCookTime != this.oven.progress) {
/*  66 */         icrafting.func_71112_a(this, 0, this.oven.progress);
/*     */       }
/*     */       
/*  69 */       if (this.lastBurnTime != this.oven.fuel) {
/*  70 */         icrafting.func_71112_a(this, 1, this.oven.fuel);
/*     */       }
/*     */       
/*  73 */       if (this.lastItemBurnTime != this.oven.maxFuel) {
/*  74 */         icrafting.func_71112_a(this, 2, this.oven.maxFuel);
/*     */       }
/*     */     }
/*     */     
/*  78 */     this.lastCookTime = this.oven.progress;
/*  79 */     this.lastBurnTime = this.oven.fuel;
/*  80 */     this.lastItemBurnTime = this.oven.maxFuel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @cpw.mods.fml.relauncher.SideOnly(Side.CLIENT)
/*     */   public void func_75137_b(int id, int value)
/*     */   {
/*  88 */     if (id == 0) {
/*  89 */       this.oven.progress = value;
/*     */     }
/*     */     
/*  92 */     if (id == 1) {
/*  93 */       this.oven.fuel = value;
/*     */     }
/*     */     
/*  96 */     if (id == 2) {
/*  97 */       this.oven.maxFuel = value;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean func_75145_c(EntityPlayer user)
/*     */   {
/* 104 */     return this.oven.func_70300_a(user);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ItemStack func_82846_b(EntityPlayer user, int num)
/*     */   {
/* 113 */     ItemStack itemstack = null;
/* 114 */     Slot slot = (Slot)this.field_75151_b.get(num);
/*     */     
/* 116 */     if ((slot != null) && (slot.func_75216_d())) {
/* 117 */       ItemStack itemstack1 = slot.func_75211_c();
/* 118 */       itemstack = itemstack1.func_77946_l();
/*     */       
/* 120 */       if (num == 2) {
/* 121 */         if (!func_75135_a(itemstack1, 3, 39, true)) {
/* 122 */           return null;
/*     */         }
/*     */         
/* 125 */         slot.func_75220_a(itemstack1, itemstack);
/* 126 */       } else if ((num != 1) && (num != 0)) {
/* 127 */         if (this.oven.getResult(itemstack1) != null) {
/* 128 */           if (!func_75135_a(itemstack1, 0, 1, false)) {
/* 129 */             return null;
/*     */           }
/* 131 */         } else if (this.oven.isItemFuel(itemstack1)) {
/* 132 */           if (!func_75135_a(itemstack1, 1, 2, false)) {
/* 133 */             return null;
/*     */           }
/* 135 */         } else if ((num >= 3) && (num < 30)) {
/* 136 */           if (!func_75135_a(itemstack1, 30, 39, false)) {
/* 137 */             return null;
/*     */           }
/* 139 */         } else if ((num >= 30) && (num < 39) && (!func_75135_a(itemstack1, 3, 30, false))) {
/* 140 */           return null;
/*     */         }
/* 142 */       } else if (!func_75135_a(itemstack1, 3, 39, false)) {
/* 143 */         return null;
/*     */       }
/*     */       
/* 146 */       if (itemstack1.field_77994_a == 0) {
/* 147 */         slot.func_75215_d((ItemStack)null);
/*     */       } else {
/* 149 */         slot.func_75218_e();
/*     */       }
/*     */       
/* 152 */       if (itemstack1.field_77994_a == itemstack.field_77994_a) {
/* 153 */         return null;
/*     */       }
/*     */       
/* 156 */       slot.func_82870_a(user, itemstack1);
/*     */     }
/*     */     
/* 159 */     return itemstack;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/container/ContainerOven.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */