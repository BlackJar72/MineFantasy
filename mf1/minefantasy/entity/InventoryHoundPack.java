/*     */ package minefantasy.entity;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InventoryHoundPack
/*     */   implements IInventory
/*     */ {
/*  20 */   public boolean inventoryChanged = false;
/*     */   private String inventoryTitle;
/*     */   private int slotsCount;
/*     */   private ItemStack[] inventoryContents;
/*     */   private List field_70480_d;
/*     */   private boolean field_94051_e;
/*     */   
/*     */   public InventoryHoundPack(String title, boolean local, int slots)
/*     */   {
/*  29 */     this.inventoryTitle = title;
/*  30 */     this.field_94051_e = local;
/*  31 */     this.slotsCount = slots;
/*  32 */     this.inventoryContents = new ItemStack[slots];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ItemStack func_70301_a(int slot)
/*     */   {
/*  39 */     return this.inventoryContents[slot];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public ItemStack func_70298_a(int slot, int num)
/*     */   {
/*  47 */     if (this.inventoryContents[slot] != null)
/*     */     {
/*     */ 
/*  50 */       if (this.inventoryContents[slot].field_77994_a <= num) {
/*  51 */         ItemStack itemstack = this.inventoryContents[slot];
/*  52 */         this.inventoryContents[slot] = null;
/*  53 */         func_70296_d();
/*  54 */         return itemstack;
/*     */       }
/*  56 */       ItemStack itemstack = this.inventoryContents[slot].func_77979_a(num);
/*     */       
/*  58 */       if (this.inventoryContents[slot].field_77994_a == 0) {
/*  59 */         this.inventoryContents[slot] = null;
/*     */       }
/*     */       
/*  62 */       func_70296_d();
/*  63 */       return itemstack;
/*     */     }
/*     */     
/*  66 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ItemStack func_70304_b(int slot)
/*     */   {
/*  76 */     if (this.inventoryContents[slot] != null) {
/*  77 */       ItemStack itemstack = this.inventoryContents[slot];
/*  78 */       this.inventoryContents[slot] = null;
/*  79 */       return itemstack;
/*     */     }
/*  81 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_70299_a(int slot, ItemStack stack)
/*     */   {
/*  90 */     this.inventoryContents[slot] = stack;
/*     */     
/*  92 */     if ((stack != null) && (stack.field_77994_a > func_70297_j_())) {
/*  93 */       stack.field_77994_a = func_70297_j_();
/*     */     }
/*     */     
/*  96 */     func_70296_d();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int func_70302_i_()
/*     */   {
/* 103 */     return this.slotsCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String func_70303_b()
/*     */   {
/* 110 */     return this.inventoryTitle;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_94042_c()
/*     */   {
/* 119 */     return this.field_94051_e;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int func_70297_j_()
/*     */   {
/* 127 */     return 64;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70296_d()
/*     */   {
/* 134 */     this.inventoryChanged = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_70300_a(EntityPlayer player)
/*     */   {
/* 142 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70295_k_() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70305_f() {}
/*     */   
/*     */ 
/*     */   public boolean func_94041_b(int slot, ItemStack stack)
/*     */   {
/* 156 */     return true;
/*     */   }
/*     */   
/*     */   public boolean addItemStackToInventory(ItemStack item) {
/* 160 */     if (item == null) {
/* 161 */       return false;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 166 */       if (item.func_77951_h()) {
/* 167 */         int i = getFirstEmptyStack();
/*     */         
/* 169 */         if (i >= 0) {
/* 170 */           this.inventoryContents[i] = ItemStack.func_77944_b(item);
/* 171 */           this.inventoryContents[i].field_77992_b = 5;
/* 172 */           item.field_77994_a = 0;
/* 173 */           return true;
/*     */         }
/* 175 */         return false;
/*     */       }
/*     */       int i;
/*     */       do {
/* 179 */         i = item.field_77994_a;
/* 180 */         item.field_77994_a = storePartialItemStack(item);
/* 181 */       } while ((item.field_77994_a > 0) && (item.field_77994_a < i));
/*     */       
/* 183 */       return item.field_77994_a < i;
/*     */     }
/*     */     catch (Throwable throwable) {}
/* 186 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getFirstEmptyStack()
/*     */   {
/* 195 */     for (int i = 0; i < this.inventoryContents.length; i++) {
/* 196 */       if (this.inventoryContents[i] == null) {
/* 197 */         return i;
/*     */       }
/*     */     }
/*     */     
/* 201 */     return -1;
/*     */   }
/*     */   
/*     */   private int storePartialItemStack(ItemStack par1ItemStack) {
/* 205 */     int i = par1ItemStack.field_77993_c;
/* 206 */     int j = par1ItemStack.field_77994_a;
/*     */     
/*     */ 
/* 209 */     if (par1ItemStack.func_77976_d() == 1) {
/* 210 */       int k = getFirstEmptyStack();
/*     */       
/* 212 */       if (k < 0) {
/* 213 */         return j;
/*     */       }
/* 215 */       if (this.inventoryContents[k] == null) {
/* 216 */         this.inventoryContents[k] = ItemStack.func_77944_b(par1ItemStack);
/*     */       }
/*     */       
/* 219 */       return 0;
/*     */     }
/*     */     
/* 222 */     int k = storeItemStack(par1ItemStack);
/*     */     
/* 224 */     if (k < 0) {
/* 225 */       k = getFirstEmptyStack();
/*     */     }
/*     */     
/* 228 */     if (k < 0) {
/* 229 */       return j;
/*     */     }
/* 231 */     if (this.inventoryContents[k] == null) {
/* 232 */       this.inventoryContents[k] = new ItemStack(i, 0, par1ItemStack.func_77960_j());
/*     */       
/* 234 */       if (par1ItemStack.func_77942_o()) {
/* 235 */         this.inventoryContents[k].func_77982_d((NBTTagCompound)par1ItemStack.func_77978_p().func_74737_b());
/*     */       }
/*     */     }
/*     */     
/* 239 */     int l = j;
/*     */     
/* 241 */     if (j > this.inventoryContents[k].func_77976_d() - this.inventoryContents[k].field_77994_a) {
/* 242 */       l = this.inventoryContents[k].func_77976_d() - this.inventoryContents[k].field_77994_a;
/*     */     }
/*     */     
/* 245 */     if (l > func_70297_j_() - this.inventoryContents[k].field_77994_a) {
/* 246 */       l = func_70297_j_() - this.inventoryContents[k].field_77994_a;
/*     */     }
/*     */     
/* 249 */     if (l == 0) {
/* 250 */       return j;
/*     */     }
/* 252 */     j -= l;
/* 253 */     this.inventoryContents[k].field_77994_a += l;
/* 254 */     this.inventoryContents[k].field_77992_b = 5;
/* 255 */     return j;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int storeItemStack(ItemStack par1ItemStack)
/*     */   {
/* 265 */     for (int i = 0; i < this.inventoryContents.length; i++) {
/* 266 */       if ((this.inventoryContents[i] != null) && (this.inventoryContents[i].field_77993_c == par1ItemStack.field_77993_c) && (this.inventoryContents[i].func_77985_e()) && (this.inventoryContents[i].field_77994_a < this.inventoryContents[i].func_77976_d()) && (this.inventoryContents[i].field_77994_a < func_70297_j_()) && ((!this.inventoryContents[i].func_77981_g()) || (this.inventoryContents[i].func_77960_j() == par1ItemStack.func_77960_j())) && (ItemStack.func_77970_a(this.inventoryContents[i], par1ItemStack)))
/*     */       {
/*     */ 
/* 269 */         return i;
/*     */       }
/*     */     }
/*     */     
/* 273 */     return -1;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/InventoryHoundPack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */