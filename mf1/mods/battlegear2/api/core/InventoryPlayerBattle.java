/*     */ package mods.battlegear2.api.core;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InventoryPlayerBattle
/*     */   extends InventoryPlayer
/*     */ {
/*  20 */   public boolean hasChanged = true;
/*     */   
/*  22 */   public static int OFFSET = 150;
/*  23 */   public static int WEAPON_SETS = 3;
/*     */   
/*  25 */   public static int EXTRA_ITEMS = WEAPON_SETS * 2;
/*  26 */   public static int EXTRA_INV_SIZE = WEAPON_SETS * 2 + 6 + 6;
/*     */   
/*     */   public ItemStack[] extraItems;
/*     */   
/*     */   public InventoryPlayerBattle(EntityPlayer entityPlayer)
/*     */   {
/*  32 */     super(entityPlayer);
/*  33 */     this.extraItems = new ItemStack[EXTRA_INV_SIZE];
/*     */   }
/*     */   
/*     */   public boolean isBattlemode() {
/*  37 */     return (this.field_70461_c < OFFSET + 2 * WEAPON_SETS) && (this.field_70461_c >= OFFSET);
/*     */   }
/*     */   
/*     */   public static boolean isValidSwitch(int id) {
/*  41 */     return ((id >= 0) && (id < func_70451_h())) || ((id >= OFFSET) && (id < OFFSET + 2 * WEAPON_SETS));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private int getInventorySlotContainItem(int par1)
/*     */   {
/*  48 */     for (int j = 0; j < this.extraItems.length; j++) {
/*  49 */       if ((this.extraItems[j] != null) && (this.extraItems[j].field_77993_c == par1)) {
/*  50 */         return j;
/*     */       }
/*     */     }
/*  53 */     return -1;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private int getInventorySlotContainItemAndDamage(int par1, int par2) {
/*  58 */     for (int k = 0; k < this.extraItems.length; k++) {
/*  59 */       if ((this.extraItems[k] != null) && (this.extraItems[k].field_77993_c == par1) && (this.extraItems[k].func_77960_j() == par2)) {
/*  60 */         return k;
/*     */       }
/*     */     }
/*  63 */     return -1;
/*     */   }
/*     */   
/*     */   public ItemStack func_70448_g()
/*     */   {
/*  68 */     return isBattlemode() ? this.extraItems[(this.field_70461_c - OFFSET)] : super.func_70448_g();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70433_a(int par1, int par2, boolean par3, boolean par4)
/*     */   {
/*  74 */     if (!isBattlemode()) {
/*  75 */       super.func_70433_a(par1, par2, par3, par4);
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70453_c(int direction) {
/*  81 */     this.hasChanged = true;
/*     */     
/*  83 */     if (isBattlemode())
/*     */     {
/*  85 */       if (direction > 0) {
/*  86 */         direction = 1;
/*  87 */       } else if (direction != 0) {
/*  88 */         direction = -1;
/*     */       }
/*     */       
/*     */ 
/*  92 */       for (this.field_70461_c -= direction; this.field_70461_c < OFFSET; this.field_70461_c += WEAPON_SETS) {}
/*     */       
/*     */ 
/*  95 */       while (this.field_70461_c >= OFFSET + WEAPON_SETS) {
/*  96 */         this.field_70461_c -= WEAPON_SETS;
/*     */       }
/*     */     }
/*     */     
/* 100 */     super.func_70453_c(direction);
/*     */   }
/*     */   
/*     */ 
/*     */   public int func_82347_b(int targetId, int targetDamage)
/*     */   {
/* 106 */     this.hasChanged = true;
/*     */     
/* 108 */     int stacks = super.func_82347_b(targetId, targetDamage);
/*     */     
/* 110 */     for (int i = 0; i < this.extraItems.length; i++) {
/* 111 */       if ((this.extraItems[i] != null) && ((targetId <= -1) || (this.extraItems[i].field_77993_c == targetId)) && ((targetDamage <= -1) || (this.extraItems[i].func_77960_j() == targetDamage)))
/*     */       {
/*     */ 
/*     */ 
/* 115 */         stacks += this.extraItems[i].field_77994_a;
/* 116 */         this.extraItems[i] = null;
/*     */       }
/*     */     }
/*     */     
/* 120 */     return stacks;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_70429_k()
/*     */   {
/* 129 */     super.func_70429_k();
/* 130 */     for (int i = 0; i < this.extraItems.length; i++) {
/* 131 */       if (this.extraItems[i] != null) {
/* 132 */         this.extraItems[i].func_77945_a(this.field_70458_d.field_70170_p, this.field_70458_d, i, this.field_70461_c + OFFSET == i);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_70435_d(int par1)
/*     */   {
/* 143 */     int j = getInventorySlotContainItem(par1);
/*     */     
/* 145 */     if (j < 0) {
/* 146 */       return super.func_70435_d(par1);
/*     */     }
/* 148 */     this.hasChanged = true;
/* 149 */     if (--this.extraItems[j].field_77994_a <= 0) {
/* 150 */       this.extraItems[j] = null;
/*     */     }
/*     */     
/* 153 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_70450_e(int par1)
/*     */   {
/* 163 */     if (super.func_70450_e(par1)) {
/* 164 */       return true;
/*     */     }
/* 166 */     int j = getInventorySlotContainItem(par1);
/* 167 */     return j >= 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_70441_a(ItemStack par1ItemStack)
/*     */   {
/* 176 */     return super.func_70441_a(par1ItemStack);
/*     */   }
/*     */   
/*     */   public ItemStack func_70298_a(int slot, int amount)
/*     */   {
/* 181 */     this.hasChanged = true;
/* 182 */     if (slot >= OFFSET) {
/* 183 */       ItemStack targetStack = this.extraItems[(slot - OFFSET)];
/*     */       
/* 185 */       if (targetStack != null)
/*     */       {
/* 187 */         if (targetStack.field_77994_a <= amount)
/*     */         {
/* 189 */           this.extraItems[(slot - OFFSET)] = null;
/* 190 */           return targetStack;
/*     */         }
/*     */         
/*     */ 
/* 194 */         targetStack = this.extraItems[(slot - OFFSET)].func_77979_a(amount);
/*     */         
/* 196 */         if (this.extraItems[(slot - OFFSET)].field_77994_a == 0) {
/* 197 */           this.extraItems[(slot - OFFSET)] = null;
/*     */         }
/*     */         
/* 200 */         return targetStack;
/*     */       }
/*     */       
/*     */ 
/* 204 */       return null;
/*     */     }
/*     */     
/* 207 */     return super.func_70298_a(slot, amount);
/*     */   }
/*     */   
/*     */ 
/*     */   public ItemStack func_70304_b(int slot)
/*     */   {
/* 213 */     if (slot >= OFFSET) {
/* 214 */       return this.extraItems[(slot - OFFSET)];
/*     */     }
/* 216 */     return super.func_70304_b(slot);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70299_a(int slot, ItemStack itemStack)
/*     */   {
/* 223 */     setInventorySlotContents(slot, itemStack, true);
/*     */   }
/*     */   
/*     */   public void setInventorySlotContents(int slot, ItemStack itemStack, boolean changed) {
/* 227 */     this.hasChanged = changed;
/* 228 */     if ((itemStack != null) && (itemStack.field_77993_c == 0)) {
/* 229 */       itemStack = null;
/*     */     }
/* 231 */     if (slot >= OFFSET) {
/* 232 */       this.extraItems[(slot - OFFSET)] = itemStack;
/*     */     } else {
/* 234 */       super.func_70299_a(slot, itemStack);
/*     */     }
/*     */   }
/*     */   
/*     */   public float func_70438_a(Block block)
/*     */   {
/* 240 */     if (isBattlemode()) {
/* 241 */       ItemStack currentItemStack = func_70448_g();
/* 242 */       return currentItemStack != null ? currentItemStack.func_77967_a(block) : 1.0F;
/*     */     }
/*     */     
/* 245 */     return super.func_70438_a(block);
/*     */   }
/*     */   
/*     */ 
/*     */   public NBTTagList func_70442_a(NBTTagList par1nbtTagList)
/*     */   {
/* 251 */     NBTTagList nbtList = super.func_70442_a(par1nbtTagList);
/*     */     
/*     */ 
/* 254 */     for (int i = 0; i < this.extraItems.length; i++) {
/* 255 */       if (this.extraItems[i] != null) {
/* 256 */         NBTTagCompound nbttagcompound = new NBTTagCompound();
/*     */         
/* 258 */         nbttagcompound.func_74774_a("Slot", (byte)(i + OFFSET));
/* 259 */         this.extraItems[i].func_77955_b(nbttagcompound);
/* 260 */         nbtList.func_74742_a(nbttagcompound);
/*     */       }
/*     */     }
/* 263 */     return nbtList;
/*     */   }
/*     */   
/*     */   public void func_70443_b(NBTTagList nbtTagList)
/*     */   {
/* 268 */     super.func_70443_b(nbtTagList);
/*     */     
/* 270 */     this.extraItems = new ItemStack[EXTRA_INV_SIZE];
/*     */     
/* 272 */     for (int i = 0; i < nbtTagList.func_74745_c(); i++) {
/* 273 */       NBTTagCompound nbttagcompound = (NBTTagCompound)nbtTagList.func_74743_b(i);
/* 274 */       int j = nbttagcompound.func_74771_c("Slot") & 0xFF;
/*     */       
/* 276 */       if (j >= OFFSET) {
/* 277 */         ItemStack itemstack = ItemStack.func_77949_a(nbttagcompound);
/* 278 */         if (itemstack != null) {
/* 279 */           this.extraItems[(j - OFFSET)] = itemstack;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public ItemStack func_70301_a(int slot)
/*     */   {
/* 287 */     if (slot >= OFFSET) {
/* 288 */       return this.extraItems[(slot - OFFSET)];
/*     */     }
/* 290 */     return super.func_70301_a(slot);
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_70436_m()
/*     */   {
/* 296 */     super.func_70436_m();
/* 297 */     for (int i = 0; i < this.extraItems.length; i++) {
/* 298 */       if (this.extraItems[i] != null) {
/* 299 */         this.field_70458_d.func_71019_a(this.extraItems[i], true);
/* 300 */         this.extraItems[i] = null;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70296_d()
/*     */   {
/* 307 */     super.func_70296_d();
/* 308 */     this.hasChanged = true;
/*     */   }
/*     */   
/*     */   public void func_70455_b(InventoryPlayer par1InventoryPlayer)
/*     */   {
/* 313 */     this.hasChanged = true;
/* 314 */     this.extraItems = new ItemStack[EXTRA_INV_SIZE];
/*     */     
/* 316 */     super.func_70455_b(par1InventoryPlayer);
/*     */     
/* 318 */     if ((par1InventoryPlayer instanceof InventoryPlayerBattle)) {
/* 319 */       for (int i = 0; i < this.extraItems.length; i++) {
/* 320 */         this.extraItems[i] = par1InventoryPlayer.func_70301_a(i + OFFSET);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public ItemStack getCurrentOffhandWeapon() {
/* 326 */     if (isBattlemode()) {
/* 327 */       return func_70301_a(this.field_70461_c + WEAPON_SETS);
/*     */     }
/* 329 */     return null;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/core/InventoryPlayerBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */