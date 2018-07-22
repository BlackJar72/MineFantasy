/*     */ package minefantasy.client.tile;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.network.PacketDispatcher;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Random;
/*     */ import minefantasy.api.cooking.IHeatSource;
/*     */ import minefantasy.system.network.PacketManagerMF;
/*     */ import minefantasy.system.network.PacketUserMF;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemFood;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.FurnaceRecipes;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.network.packet.Packet;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.server.management.ServerConfigurationManager;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ForgeDirection;
/*     */ 
/*     */ public class TileEntityRoast
/*     */   extends TileEntity implements IInventory, PacketUserMF
/*     */ {
/*     */   private ItemStack[] inv;
/*     */   public int direction;
/*  33 */   public int[] enchantment = new int[5];
/*  34 */   public int[] cooking = new int[5];
/*  35 */   private static int maxCookTime = 60000;
/*     */   
/*     */   public TileEntityRoast() {
/*  38 */     this.inv = new ItemStack[5];
/*     */   }
/*     */   
/*     */   public int func_70302_i_() {
/*  42 */     return this.inv.length;
/*     */   }
/*     */   
/*     */   public ItemStack func_70301_a(int i) {
/*  46 */     ItemStack item = this.inv[i];
/*  47 */     if ((item == null) || (item.func_77973_b() == null)) {
/*  48 */       return null;
/*     */     }
/*  50 */     return item;
/*     */   }
/*     */   
/*     */   public ItemStack func_70298_a(int i, int j) {
/*  54 */     if (this.inv[i] != null) {
/*  55 */       if (this.inv[i].field_77994_a <= j) {
/*  56 */         ItemStack itemstack = this.inv[i];
/*  57 */         this.inv[i] = null;
/*  58 */         return itemstack;
/*     */       }
/*  60 */       ItemStack itemstack1 = this.inv[i].func_77979_a(j);
/*  61 */       if (this.inv[i].field_77994_a == 0) {
/*  62 */         this.inv[i] = null;
/*     */       }
/*  64 */       return itemstack1;
/*     */     }
/*  66 */     return null;
/*     */   }
/*     */   
/*     */   public void func_70299_a(int i, ItemStack itemstack)
/*     */   {
/*  71 */     this.inv[i] = itemstack;
/*  72 */     if ((itemstack != null) && (itemstack.field_77994_a > func_70297_j_())) {
/*  73 */       itemstack.field_77994_a = func_70297_j_();
/*     */     }
/*     */   }
/*     */   
/*     */   public String func_70303_b() {
/*  78 */     return "Roast";
/*     */   }
/*     */   
/*     */   public void func_70307_a(NBTTagCompound nbt) {
/*  82 */     super.func_70307_a(nbt);
/*  83 */     NBTTagList nbttaglist = nbt.func_74761_m("Items");
/*  84 */     this.inv = new ItemStack[func_70302_i_()];
/*  85 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*  86 */       NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.func_74743_b(i);
/*  87 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/*  88 */       if ((byte0 >= 0) && (byte0 < this.inv.length)) {
/*  89 */         this.inv[byte0] = ItemStack.func_77949_a(nbttagcompound1);
/*     */       }
/*     */     }
/*     */     
/*  93 */     this.direction = nbt.func_74762_e("Dir");
/*     */     
/*  95 */     int[] cook = nbt.func_74759_k("Cooking");
/*  96 */     if ((cook != null) && (cook.length == this.cooking.length)) {
/*  97 */       this.cooking = nbt.func_74759_k("Cooking");
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70310_b(NBTTagCompound nbt) {
/* 102 */     super.func_70310_b(nbt);
/* 103 */     nbt.func_74768_a("Dir", this.direction);
/* 104 */     NBTTagList nbttaglist = new NBTTagList();
/* 105 */     for (int i = 0; i < this.inv.length; i++) {
/* 106 */       if (this.inv[i] != null) {
/* 107 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 108 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 109 */         this.inv[i].func_77955_b(nbttagcompound1);
/* 110 */         nbttaglist.func_74742_a(nbttagcompound1);
/*     */       }
/*     */     }
/* 113 */     nbt.func_74782_a("Items", nbttaglist);
/* 114 */     nbt.func_74783_a("Cooking", this.cooking);
/*     */   }
/*     */   
/*     */   public int func_70297_j_() {
/* 118 */     return 1;
/*     */   }
/*     */   
/*     */   public void func_70316_g() {
/* 122 */     if (!this.field_70331_k.field_72995_K) {
/* 123 */       for (int a = 0; a < 5; a++) {
/* 124 */         if (getResultFor(a) != null) {
/* 125 */           this.cooking[a] += getCookSpeed();
/* 126 */           if (this.cooking[a] > maxCookTime) {
/* 127 */             cook(a);
/*     */           }
/*     */         } else {
/* 130 */           this.cooking[a] = 0;
/*     */         }
/*     */       }
/* 133 */       sendPacketToClients();
/*     */     }
/*     */   }
/*     */   
/*     */   private void cook(int a) {
/* 138 */     if (this.inv[a] != null) {
/* 139 */       ItemStack result = getResultFor(a);
/* 140 */       if (result != null) {
/* 141 */         func_70299_a(a, result.func_77946_l());
/* 142 */         this.cooking[a] = 0;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private int getCookSpeed() {
/* 148 */     if (getHeat() <= 0) {
/* 149 */       return 0;
/*     */     }
/* 151 */     Random rand = new Random();
/* 152 */     if (rand.nextInt(2) == 0) {
/* 153 */       return 0;
/*     */     }
/* 155 */     return rand.nextInt(getHeat() + 1);
/*     */   }
/*     */   
/*     */   private int getHeat() {
/* 159 */     if (this.field_70331_k == null) {
/* 160 */       return 0;
/*     */     }
/* 162 */     if ((this.field_70331_k.func_72803_f(this.field_70329_l, this.field_70330_m - 1, this.field_70327_n) != null) && (this.field_70331_k.func_72803_f(this.field_70329_l, this.field_70330_m - 1, this.field_70327_n) == Material.field_76250_n)) {
/* 163 */       return 200;
/*     */     }
/* 165 */     TileEntity tile = this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m - 1, this.field_70327_n);
/*     */     
/* 167 */     if (tile == null) {
/* 168 */       return 0;
/*     */     }
/* 170 */     if ((tile instanceof IHeatSource)) {
/* 171 */       return ((IHeatSource)tile).getHeat();
/*     */     }
/* 173 */     if ((tile instanceof TileEntityForge)) {
/* 174 */       return (int)((TileEntityForge)tile).heat * 2;
/*     */     }
/* 176 */     return 0;
/*     */   }
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer entityplayer) {
/* 180 */     if (this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m, this.field_70327_n) != this) {
/* 181 */       return false;
/*     */     }
/* 183 */     return entityplayer.func_70092_e(this.field_70329_l + 0.5D, this.field_70330_m + 0.5D, this.field_70327_n + 0.5D) <= 64.0D;
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_70295_k_() {}
/*     */   
/*     */ 
/*     */   public void func_70305_f() {}
/*     */   
/*     */   public ItemStack func_70304_b(int var1)
/*     */   {
/* 194 */     return null;
/*     */   }
/*     */   
/*     */   private void sendPacketToClients() {
/* 198 */     int e0 = getEnchantment(0);
/* 199 */     int e1 = getEnchantment(1);
/* 200 */     int e2 = getEnchantment(2);
/* 201 */     int e3 = getEnchantment(3);
/* 202 */     int e4 = getEnchantment(4);
/*     */     
/* 204 */     int c0 = getCook(0);
/* 205 */     int c1 = getCook(1);
/* 206 */     int c2 = getCook(2);
/* 207 */     int c3 = getCook(3);
/* 208 */     int c4 = getCook(4);
/*     */     
/* 210 */     if ((!this.field_70331_k.field_72995_K) || (FMLCommonHandler.instance().getSide().isServer())) {
/*     */       try {
/* 212 */         Packet packet = PacketManagerMF.getPacketIntegerArray(this, new int[] { this.direction, getItemID(0), getItemID(1), getItemID(2), getItemID(3), getItemID(4), getItemMeta(0), getItemMeta(1), getItemMeta(2), getItemMeta(3), getItemMeta(4), e0, e1, e2, e3, e4, c0, c1, c2, c3, c4 });
/*     */         
/* 214 */         FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*     */       } catch (NullPointerException e) {
/* 216 */         System.out.println("MineFantasy: Client connections lost");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private int getEnchantment(int i) {
/* 222 */     ItemStack is = func_70301_a(i);
/* 223 */     if (is == null) {
/* 224 */       return 0;
/*     */     }
/* 226 */     if (is.func_77948_v()) {
/* 227 */       return 1;
/*     */     }
/* 229 */     return 0;
/*     */   }
/*     */   
/*     */   private int getCook(int i) {
/* 233 */     return this.cooking[i];
/*     */   }
/*     */   
/*     */   public void sendPacketToServer()
/*     */   {
/* 238 */     if (this.field_70331_k.field_72995_K) {
/*     */       try {
/* 240 */         Packet packet = PacketManagerMF.getPacketIntegerArray(this, new int[] { this.direction, getItemID(0), getItemID(1), getItemID(2), getItemID(3), getItemID(4) });
/* 241 */         PacketDispatcher.sendPacketToServer(packet);
/*     */       } catch (NullPointerException e) {
/* 243 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private int getItemID(int i) {
/* 249 */     ItemStack item = this.inv[i];
/* 250 */     if (item == null)
/* 251 */       return 0;
/* 252 */     return item.field_77993_c;
/*     */   }
/*     */   
/*     */   private int getItemMeta(int i) {
/* 256 */     ItemStack item = this.inv[i];
/* 257 */     if (item == null)
/* 258 */       return 0;
/* 259 */     return item.func_77960_j();
/*     */   }
/*     */   
/*     */   public void recievePacket(ByteArrayDataInput data)
/*     */   {
/*     */     try {
/* 265 */       this.direction = data.readInt();
/* 266 */       int i1 = data.readInt();
/* 267 */       int i2 = data.readInt();
/* 268 */       int i3 = data.readInt();
/* 269 */       int i4 = data.readInt();
/* 270 */       int i5 = data.readInt();
/*     */       
/* 272 */       int m1 = data.readInt();
/* 273 */       int m2 = data.readInt();
/* 274 */       int m3 = data.readInt();
/* 275 */       int m4 = data.readInt();
/* 276 */       int m5 = data.readInt();
/* 277 */       if (this.field_70331_k.field_72995_K) {
/* 278 */         this.inv[0] = new ItemStack(i1, 1, m1);
/* 279 */         this.inv[1] = new ItemStack(i2, 1, m2);
/* 280 */         this.inv[2] = new ItemStack(i3, 1, m3);
/* 281 */         this.inv[3] = new ItemStack(i4, 1, m4);
/* 282 */         this.inv[4] = new ItemStack(i5, 1, m5);
/*     */         
/* 284 */         for (int a = 0; a < 5; a++) {
/* 285 */           this.enchantment[a] = data.readInt();
/*     */         }
/* 287 */         for (int a = 0; a < 5; a++)
/* 288 */           this.cooking[a] = data.readInt();
/*     */       }
/*     */     } catch (Exception e) {
/* 291 */       System.err.println("MineFantasy: Spit Roast packet failed");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean func_94042_c()
/*     */   {
/* 298 */     return true;
/*     */   }
/*     */   
/*     */   public boolean func_94041_b(int i, ItemStack itemstack)
/*     */   {
/* 303 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isEnchanted(int slot) {
/* 307 */     return this.enchantment[slot] == 1;
/*     */   }
/*     */   
/*     */   public boolean willShowBase() {
/* 311 */     if (this.field_70331_k == null) {
/* 312 */       return false;
/*     */     }
/*     */     
/* 315 */     if ((this.field_70331_k.func_72803_f(this.field_70329_l, this.field_70330_m - 1, this.field_70327_n) != null) && (this.field_70331_k.func_72803_f(this.field_70329_l, this.field_70330_m - 1, this.field_70327_n) == Material.field_76250_n)) {
/* 316 */       return true;
/*     */     }
/*     */     
/* 319 */     TileEntity tile = this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m - 1, this.field_70327_n);
/*     */     
/* 321 */     if (tile == null) {
/* 322 */       return false;
/*     */     }
/* 324 */     if ((tile instanceof IHeatSource)) {
/* 325 */       return ((IHeatSource)tile).canPlaceAbove();
/*     */     }
/* 327 */     if ((tile instanceof TileEntityForge)) {
/* 328 */       return true;
/*     */     }
/* 330 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isValid(ItemStack item) {
/* 334 */     return getResultFor(item) != null;
/*     */   }
/*     */   
/*     */   public ItemStack getResultFor(int slot) {
/* 338 */     return getResultFor(this.inv[slot]);
/*     */   }
/*     */   
/*     */   public ItemStack getResultFor(ItemStack item) {
/* 342 */     ItemStack result = FurnaceRecipes.func_77602_a().getSmeltingResult(item);
/* 343 */     if ((result != null) && (result.func_77973_b() != null) && 
/* 344 */       ((result.func_77973_b() instanceof ItemFood))) {
/* 345 */       return result;
/*     */     }
/*     */     
/* 348 */     return null;
/*     */   }
/*     */   
/*     */   public int getCookProgressScaled(int height, int slot) {
/* 352 */     return this.cooking[slot] * height / maxCookTime;
/*     */   }
/*     */   
/*     */   public boolean tryAddItem(ItemStack item) {
/* 356 */     if (item == null) {
/* 357 */       return false;
/*     */     }
/* 359 */     for (int a = 0; a < func_70302_i_(); a++) {
/* 360 */       ItemStack slot = this.inv[a];
/* 361 */       if ((slot == null) && (getResultFor(item) != null)) {
/* 362 */         ItemStack copy = item.func_77946_l();
/* 363 */         copy.field_77994_a = 1;
/* 364 */         func_70299_a(a, copy);
/* 365 */         return true;
/*     */       }
/*     */     }
/* 368 */     return false;
/*     */   }
/*     */   
/*     */   public boolean tryTakeItem(EntityPlayer player) {
/* 372 */     if (player == null) {
/* 373 */       return false;
/*     */     }
/* 375 */     for (int a = 0; a < func_70302_i_(); a++) {
/* 376 */       ItemStack slot = this.inv[a];
/* 377 */       if ((slot != null) && (getResultFor(slot) == null)) {
/* 378 */         this.field_70331_k.func_72838_d(new EntityItem(this.field_70331_k, player.field_70165_t, player.field_70163_u, player.field_70161_v, this.inv[a]));
/* 379 */         func_70298_a(a, 1);
/* 380 */         return true;
/*     */       }
/*     */     }
/* 383 */     return false;
/*     */   }
/*     */   
/*     */   private ForgeDirection getLeftSide() {
/* 387 */     switch (this.direction) {
/*     */     case 0: 
/* 389 */       return ForgeDirection.EAST;
/*     */     case 1: 
/* 391 */       return ForgeDirection.SOUTH;
/*     */     case 2: 
/* 393 */       return ForgeDirection.WEST;
/*     */     case 3: 
/* 395 */       return ForgeDirection.NORTH;
/*     */     }
/* 397 */     return ForgeDirection.UNKNOWN;
/*     */   }
/*     */   
/*     */   private ForgeDirection getRightSide() {
/* 401 */     switch (this.direction) {
/*     */     case 0: 
/* 403 */       return ForgeDirection.WEST;
/*     */     case 1: 
/* 405 */       return ForgeDirection.NORTH;
/*     */     case 2: 
/* 407 */       return ForgeDirection.EAST;
/*     */     case 3: 
/* 409 */       return ForgeDirection.SOUTH;
/*     */     }
/* 411 */     return ForgeDirection.UNKNOWN;
/*     */   }
/*     */   
/*     */   public boolean renderLeft() {
/* 415 */     if (this.field_70331_k == null) {
/* 416 */       return true;
/*     */     }
/* 418 */     ForgeDirection left = getLeftSide();
/*     */     
/* 420 */     TileEntity en = this.field_70331_k.func_72796_p(this.field_70329_l + left.offsetX, this.field_70330_m + left.offsetY, this.field_70327_n + left.offsetZ);
/*     */     
/* 422 */     if ((en != null) && ((en instanceof TileEntityRoast)) && 
/* 423 */       (((TileEntityRoast)en).direction == this.direction)) {
/* 424 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 428 */     return true;
/*     */   }
/*     */   
/*     */   public boolean renderRight() {
/* 432 */     if (this.field_70331_k == null) {
/* 433 */       return true;
/*     */     }
/* 435 */     ForgeDirection right = getRightSide();
/*     */     
/* 437 */     TileEntity en = this.field_70331_k.func_72796_p(this.field_70329_l + right.offsetX, this.field_70330_m + right.offsetY, this.field_70327_n + right.offsetZ);
/*     */     
/* 439 */     if ((en != null) && ((en instanceof TileEntityRoast)) && 
/* 440 */       (((TileEntityRoast)en).direction == this.direction)) {
/* 441 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 445 */     return true;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/TileEntityRoast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */