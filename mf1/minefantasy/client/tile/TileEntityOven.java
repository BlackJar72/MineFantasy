/*     */ package minefantasy.client.tile;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.registry.GameRegistry;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Random;
/*     */ import minefantasy.api.aesthetic.IChimney;
/*     */ import minefantasy.api.cooking.OvenRecipes;
/*     */ import minefantasy.system.MFResource;
/*     */ import minefantasy.system.network.PacketManagerMF;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemBlock;
/*     */ import net.minecraft.item.ItemFood;
/*     */ import net.minecraft.item.ItemHoe;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.ItemSword;
/*     */ import net.minecraft.item.ItemTool;
/*     */ import net.minecraft.item.crafting.FurnaceRecipes;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.network.packet.Packet;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.server.management.ServerConfigurationManager;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class TileEntityOven extends TileEntity implements IInventory, minefantasy.system.network.PacketUserMF, net.minecraft.inventory.ISidedInventory
/*     */ {
/*     */   private int ticksExisted;
/*     */   private ItemStack[] items;
/*     */   public int direction;
/*     */   public int itemMeta;
/*     */   public int fuel;
/*  42 */   private Random rand = new Random();
/*     */   
/*     */ 
/*     */   public int maxFuel;
/*     */   
/*     */   public int progress;
/*     */   
/*     */   public int numUsers;
/*     */   
/*     */   public int doorAngle;
/*     */   
/*     */   public boolean isBurningClient;
/*     */   
/*     */ 
/*     */   public TileEntityOven()
/*     */   {
/*  58 */     this.items = new ItemStack[3];
/*     */   }
/*     */   
/*     */   public TileEntityOven(int meta) {
/*  62 */     this();
/*  63 */     this.itemMeta = meta;
/*     */   }
/*     */   
/*     */   public int func_70302_i_()
/*     */   {
/*  68 */     return this.items.length;
/*     */   }
/*     */   
/*     */   public ItemStack func_70301_a(int i)
/*     */   {
/*  73 */     return this.items[i];
/*     */   }
/*     */   
/*     */   public void func_70296_d() {
/*  77 */     super.func_70296_d();
/*     */     
/*  79 */     if ((this.field_70331_k != null) && (!this.field_70331_k.field_72995_K)) {
/*  80 */       syncItems();
/*     */     }
/*     */   }
/*     */   
/*     */   public ItemStack func_70298_a(int slot, int ammount)
/*     */   {
/*  86 */     func_70296_d();
/*  87 */     if (this.items[slot] != null)
/*     */     {
/*     */ 
/*  90 */       if (this.items[slot].field_77994_a <= ammount) {
/*  91 */         ItemStack var3 = this.items[slot];
/*  92 */         this.items[slot] = null;
/*  93 */         return var3;
/*     */       }
/*  95 */       ItemStack var3 = this.items[slot].func_77979_a(ammount);
/*     */       
/*  97 */       if (this.items[slot].field_77994_a == 0) {
/*  98 */         this.items[slot] = null;
/*     */       }
/*     */       
/* 101 */       return var3;
/*     */     }
/*     */     
/* 104 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public ItemStack func_70304_b(int slot)
/*     */   {
/* 110 */     if (this.items[slot] != null) {
/* 111 */       ItemStack var2 = this.items[slot];
/* 112 */       this.items[slot] = null;
/* 113 */       return var2;
/*     */     }
/* 115 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_70299_a(int i, ItemStack itemstack)
/*     */   {
/* 121 */     this.items[i] = itemstack;
/*     */   }
/*     */   
/*     */   public String func_70303_b()
/*     */   {
/* 126 */     int t = getType();
/* 127 */     String tier = "";
/*     */     
/* 129 */     if (t == 0) {
/* 130 */       tier = StatCollector.func_74838_a("tier.bronze");
/*     */     }
/* 132 */     if (t == 1) {
/* 133 */       tier = StatCollector.func_74838_a("tier.iron");
/*     */     }
/* 135 */     if (t == 2) {
/* 136 */       tier = StatCollector.func_74838_a("tier.steel");
/*     */     }
/* 138 */     if (t == 3) {
/* 139 */       tier = StatCollector.func_74838_a("tier.iron.deep");
/*     */     }
/*     */     
/* 142 */     return tier + " " + StatCollector.func_74838_a("container.oven");
/*     */   }
/*     */   
/*     */   public boolean func_94042_c()
/*     */   {
/* 147 */     return false;
/*     */   }
/*     */   
/*     */   public int func_70297_j_()
/*     */   {
/* 152 */     return 64;
/*     */   }
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer entityplayer)
/*     */   {
/* 157 */     return entityplayer.func_70011_f(this.field_70329_l + 0.5D, this.field_70330_m + 0.5D, this.field_70327_n + 0.5D) < 8.0D;
/*     */   }
/*     */   
/*     */   public void func_70295_k_() {
/* 161 */     if (this.numUsers == 0) {
/* 162 */       this.field_70331_k.func_72908_a(this.field_70329_l + 0.5D, this.field_70330_m + 0.5D, this.field_70327_n + 0.5D, MFResource.sound("furnaceOpen"), 0.5F, this.field_70331_k.field_73012_v.nextFloat() * 0.1F + 1.4F);
/*     */     }
/* 164 */     this.numUsers += 1;
/*     */   }
/*     */   
/*     */   public void func_70305_f() {
/* 168 */     this.numUsers -= 1;
/* 169 */     if ((this.numUsers == 0) && (this.doorAngle >= 10)) {
/* 170 */       this.field_70331_k.func_72908_a(this.field_70329_l + 0.5D, this.field_70330_m + 0.5D, this.field_70327_n + 0.5D, MFResource.sound("furnaceClose"), 0.5F, this.field_70331_k.field_73012_v.nextFloat() * 0.1F + 1.4F);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int getCookProgressScaled(int width)
/*     */   {
/* 180 */     return this.progress * width / 400;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int getBurnTimeRemainingScaled(int width)
/*     */   {
/* 189 */     if (this.maxFuel == 0) {
/* 190 */       this.maxFuel = 200;
/*     */     }
/*     */     
/* 193 */     return this.fuel * width / this.maxFuel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isBurning()
/*     */   {
/* 200 */     return this.fuel > 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_70316_g()
/*     */   {
/* 209 */     this.ticksExisted += 1;
/* 210 */     boolean flag = this.fuel > 0;
/* 211 */     boolean flag1 = false;
/*     */     
/* 213 */     if (this.fuel > 0) {
/* 214 */       this.fuel -= 1;
/*     */     }
/*     */     
/* 217 */     if (!this.field_70331_k.field_72995_K) {
/* 218 */       if ((this.fuel == 0) && (canSmelt())) {
/* 219 */         this.maxFuel = (this.fuel = getItemBurnTime(this.items[1]));
/*     */         
/* 221 */         if (this.fuel > 0) {
/* 222 */           flag1 = true;
/*     */           
/* 224 */           if (this.items[1] != null) {
/* 225 */             this.items[1].field_77994_a -= 1;
/*     */             
/* 227 */             if (this.items[1].field_77994_a == 0) {
/* 228 */               this.items[1] = this.items[1].func_77973_b().getContainerItemStack(this.items[1]);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 234 */       if ((isBurning()) && (canSmelt())) {
/* 235 */         this.progress += getCookSpeed();
/*     */         
/* 237 */         if (this.progress >= 400) {
/* 238 */           this.progress = 0;
/* 239 */           smeltItem();
/* 240 */           flag1 = true;
/*     */         }
/*     */       } else {
/* 243 */         this.progress = 0;
/*     */       }
/*     */       
/* 246 */       int off = getOffMetadata();
/* 247 */       int on = getOnMetadata();
/* 248 */       if ((isBurning()) && (this.field_70331_k.func_72805_g(this.field_70329_l, this.field_70330_m, this.field_70327_n) != on)) {
/* 249 */         this.field_70331_k.func_72921_c(this.field_70329_l, this.field_70330_m, this.field_70327_n, on, 3);
/* 250 */         this.field_70331_k.func_72969_x(this.field_70329_l, this.field_70330_m, this.field_70327_n);
/*     */       }
/* 252 */       if ((!isBurning()) && (this.field_70331_k.func_72805_g(this.field_70329_l, this.field_70330_m, this.field_70327_n) != off)) {
/* 253 */         this.field_70331_k.func_72921_c(this.field_70329_l, this.field_70330_m, this.field_70327_n, off, 3);
/* 254 */         this.field_70331_k.func_72969_x(this.field_70329_l, this.field_70330_m, this.field_70327_n);
/*     */       }
/*     */       
/* 257 */       if ((this.numUsers > 0) && (this.doorAngle < 15)) {
/* 258 */         this.doorAngle += 1;
/*     */       }
/*     */       
/* 261 */       if ((this.numUsers <= 0) && (this.doorAngle > 0)) {
/* 262 */         this.doorAngle -= 1;
/*     */       }
/* 264 */       if (this.doorAngle < 0)
/* 265 */         this.doorAngle = 0;
/* 266 */       if (this.doorAngle > 15) {
/* 267 */         this.doorAngle = 15;
/*     */       }
/* 269 */       if (this.ticksExisted % 20 == 0) {
/* 270 */         syncItems();
/*     */       }
/* 272 */       sendPacketToClients();
/*     */     }
/*     */     
/* 275 */     if (flag1) {
/* 276 */       func_70296_d();
/*     */     }
/*     */     
/* 279 */     if (this.field_70331_k.field_72995_K) {
/* 280 */       if (isBurning()) {
/* 281 */         puffSmoke(new Random(), this.field_70331_k, this.field_70329_l, this.field_70330_m, this.field_70327_n);
/*     */         
/* 283 */         if (this.rand.nextInt(10) == 0)
/* 284 */           this.field_70331_k.func_72869_a("flame", this.field_70329_l + this.rand.nextDouble() * 0.8D + 0.1D, this.field_70330_m + 0.4D, this.field_70327_n + this.rand.nextDouble() * 0.8D + 0.1D, 0.0D, 0.01D, 0.0D);
/*     */       }
/* 286 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */   private int getCookSpeed() {
/* 291 */     int tier = getType();
/* 292 */     return 1 + tier;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean canSmelt()
/*     */   {
/* 300 */     if (this.items[0] == null) {
/* 301 */       return false;
/*     */     }
/* 303 */     ItemStack itemstack = getResult();
/* 304 */     if (itemstack == null)
/* 305 */       return false;
/* 306 */     if (this.items[2] == null)
/* 307 */       return true;
/* 308 */     if (!this.items[2].func_77969_a(itemstack))
/* 309 */       return false;
/* 310 */     int result = this.items[2].field_77994_a + itemstack.field_77994_a;
/* 311 */     return (result <= func_70297_j_()) && (result <= itemstack.func_77976_d());
/*     */   }
/*     */   
/*     */   public ItemStack getResult()
/*     */   {
/* 316 */     return getResult(this.items[0]);
/*     */   }
/*     */   
/*     */   public ItemStack getResult(ItemStack item) {
/* 320 */     ItemStack result = OvenRecipes.getSmeltingResult(item);
/*     */     
/* 322 */     if (result != null) {
/* 323 */       return result;
/*     */     }
/* 325 */     result = FurnaceRecipes.func_77602_a().getSmeltingResult(item);
/*     */     
/* 327 */     if ((result != null) && ((result.func_77973_b() instanceof ItemFood))) {
/* 328 */       return result;
/*     */     }
/* 330 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void smeltItem()
/*     */   {
/* 338 */     if (canSmelt()) {
/* 339 */       ItemStack itemstack = getResult();
/*     */       
/* 341 */       if (this.items[2] == null) {
/* 342 */         this.items[2] = itemstack.func_77946_l();
/* 343 */       } else if (this.items[2].func_77969_a(itemstack)) {
/* 344 */         this.items[2].field_77994_a += itemstack.field_77994_a;
/*     */       }
/*     */       
/* 347 */       this.items[0].field_77994_a -= 1;
/*     */       
/* 349 */       if (this.items[0].field_77994_a <= 0) {
/* 350 */         this.items[0] = null;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70307_a(NBTTagCompound nbt) {
/* 356 */     super.func_70307_a(nbt);
/* 357 */     NBTTagList nbttaglist = nbt.func_74761_m("Items");
/* 358 */     this.items = new ItemStack[func_70302_i_()];
/* 359 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/* 360 */       NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.func_74743_b(i);
/* 361 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 362 */       if ((byte0 >= 0) && (byte0 < this.items.length)) {
/* 363 */         this.items[byte0] = ItemStack.func_77949_a(nbttagcompound1);
/*     */       }
/*     */     }
/* 366 */     this.fuel = nbt.func_74762_e("Fuel");
/* 367 */     this.maxFuel = nbt.func_74762_e("FuelMax");
/* 368 */     this.progress = nbt.func_74762_e("Progress");
/*     */     
/* 370 */     this.direction = nbt.func_74762_e("Dir");
/*     */   }
/*     */   
/*     */   public void func_70310_b(NBTTagCompound nbt) {
/* 374 */     super.func_70310_b(nbt);
/* 375 */     nbt.func_74768_a("Dir", this.direction);
/* 376 */     NBTTagList nbttaglist = new NBTTagList();
/* 377 */     for (int i = 0; i < this.items.length; i++) {
/* 378 */       if (this.items[i] != null) {
/* 379 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 380 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 381 */         this.items[i].func_77955_b(nbttagcompound1);
/* 382 */         nbttaglist.func_74742_a(nbttagcompound1);
/*     */       }
/*     */     }
/* 385 */     nbt.func_74768_a("Fuel", this.fuel);
/* 386 */     nbt.func_74768_a("FuelMax", this.maxFuel);
/* 387 */     nbt.func_74768_a("Progress", this.progress);
/*     */     
/* 389 */     nbt.func_74782_a("Items", nbttaglist);
/*     */   }
/*     */   
/*     */   public static int getItemBurnTime(ItemStack input) {
/* 393 */     if (input == null) {
/* 394 */       return 0;
/*     */     }
/* 396 */     int i = input.func_77973_b().field_77779_bT;
/* 397 */     Item item = input.func_77973_b();
/*     */     
/* 399 */     if (((input.func_77973_b() instanceof ItemBlock)) && (Block.field_71973_m[i] != null)) {
/* 400 */       Block block = Block.field_71973_m[i];
/*     */       
/* 402 */       if (block == Block.field_72092_bO) {
/* 403 */         return 150;
/*     */       }
/*     */       
/* 406 */       if (block.field_72018_cp == Material.field_76245_d) {
/* 407 */         return 300;
/*     */       }
/*     */       
/* 410 */       if (block == Block.field_111034_cE) {
/* 411 */         return 16000;
/*     */       }
/*     */     }
/*     */     
/* 415 */     if (((item instanceof ItemTool)) && (((ItemTool)item).func_77861_e().equals("WOOD")))
/* 416 */       return 200;
/* 417 */     if (((item instanceof ItemSword)) && (((ItemSword)item).func_77825_f().equals("WOOD")))
/* 418 */       return 200;
/* 419 */     if (((item instanceof ItemHoe)) && (((ItemHoe)item).func_77842_f().equals("WOOD")))
/* 420 */       return 200;
/* 421 */     if (i == Item.field_77669_D.field_77779_bT)
/* 422 */       return 100;
/* 423 */     if (i == Item.field_77705_m.field_77779_bT)
/* 424 */       return 1600;
/* 425 */     if (i == Item.field_77775_ay.field_77779_bT)
/* 426 */       return 20000;
/* 427 */     if (i == Block.field_71987_y.field_71990_ca)
/* 428 */       return 100;
/* 429 */     if (i == Item.field_77731_bo.field_77779_bT)
/* 430 */       return 2400;
/* 431 */     return GameRegistry.getFuelValue(input);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_94041_b(int slot, ItemStack item)
/*     */   {
/* 440 */     if (item == null) {
/* 441 */       return false;
/*     */     }
/* 443 */     if (slot == 0) {
/* 444 */       return getResult(item) != null;
/*     */     }
/* 446 */     if (slot == 1) {
/* 447 */       return isItemFuel(item);
/*     */     }
/* 449 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isItemFuel(ItemStack item) {
/* 453 */     return getItemBurnTime(item) > 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int[] func_94128_d(int side)
/*     */   {
/* 462 */     return side == 1 ? slots_top : side == 0 ? slots_bottom : slots_sides;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_102007_a(int slot, ItemStack item, int side)
/*     */   {
/* 471 */     return func_94041_b(slot, item);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_102008_b(int slot, ItemStack item, int side)
/*     */   {
/* 480 */     if (slot == 1) {
/* 481 */       return (item != null) && (item.field_77993_c == Item.field_77788_aw.field_77779_bT);
/*     */     }
/* 483 */     return slot == 2;
/*     */   }
/*     */   
/* 486 */   private static final int[] slots_top = { 0 };
/* 487 */   private static final int[] slots_bottom = { 2, 1 };
/* 488 */   private static final int[] slots_sides = { 1 };
/*     */   
/*     */   public int func_70322_n()
/*     */   {
/* 492 */     if (this.field_70331_k == null) {
/* 493 */       return this.itemMeta;
/*     */     }
/* 495 */     if (this.field_70325_p == -1) {
/* 496 */       this.field_70325_p = this.field_70331_k.func_72805_g(this.field_70329_l, this.field_70330_m, this.field_70327_n);
/*     */     }
/*     */     
/* 499 */     return this.field_70325_p;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/* 506 */     int meta = func_70322_n();
/* 507 */     return (int)Math.floor(meta / 2);
/*     */   }
/*     */   
/*     */   private int getOnMetadata() {
/* 511 */     return getType() * 2 + 1;
/*     */   }
/*     */   
/*     */   private int getOffMetadata() {
/* 515 */     return getType() * 2;
/*     */   }
/*     */   
/*     */   private void sendPacketToClients() {
/* 519 */     if (!this.field_70331_k.field_72995_K) {
/*     */       try {
/* 521 */         Packet packet = PacketManagerMF.getPacketIntegerArray(this, new int[] { this.fuel, this.progress, this.direction, isBurning() ? 1 : 0, this.doorAngle });
/*     */         
/* 523 */         FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*     */       } catch (Exception e) {
/* 525 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void recievePacket(ByteArrayDataInput data)
/*     */   {
/* 532 */     this.fuel = data.readInt();
/* 533 */     this.progress = data.readInt();
/* 534 */     this.direction = data.readInt();
/* 535 */     int burn = data.readInt();
/* 536 */     this.isBurningClient = (burn == 1);
/* 537 */     this.doorAngle = data.readInt();
/*     */   }
/*     */   
/*     */   public String getTexture() {
/* 541 */     switch (getType()) {
/*     */     case 0: 
/* 543 */       return "oven_bronze";
/*     */     case 1: 
/* 545 */       return "oven_iron";
/*     */     case 2: 
/* 547 */       return "oven_steel";
/*     */     case 3: 
/* 549 */       return "oven_deep";
/*     */     }
/*     */     
/* 552 */     return "oven";
/*     */   }
/*     */   
/*     */   public void syncItems() {
/* 556 */     if (!this.field_70331_k.field_72995_K) {
/* 557 */       for (int a = 0; a < this.items.length; a++) {
/* 558 */         Packet packet = PacketManagerMF.getPacketItemStackArray(this, a, this.items[a]);
/*     */         try {
/* 560 */           FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*     */         } catch (NullPointerException e) {
/* 562 */           System.out.println("MineFantasy: Client connection lost");
/* 563 */           return;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void puffSmoke(Random rand, World world, int x, int y, int z) {
/* 570 */     if (rand.nextInt(10) != 0) {
/* 571 */       return;
/*     */     }
/*     */     
/* 574 */     Block block = Block.field_71973_m[world.func_72798_a(x, y + 1, z)];
/* 575 */     IChimney chimney = null;
/*     */     
/* 577 */     if ((block instanceof IChimney)) {
/* 578 */       chimney = (IChimney)block;
/*     */     }
/* 580 */     if ((chimney != null) && (chimney.puffSmoke(world, x, y + 1, z, 0.083333336F, 1.0F, 1.0F))) {
/* 581 */       return;
/*     */     }
/*     */     
/* 584 */     world.func_72869_a("largesmoke", x + 0.5F, y + 1, z + 0.5F, (rand.nextFloat() - 0.5F) / 6.0F, 0.06499999761581421D, (rand.nextFloat() - 0.5F) / 6.0F);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/TileEntityOven.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */