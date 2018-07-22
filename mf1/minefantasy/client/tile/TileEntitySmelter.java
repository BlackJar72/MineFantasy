/*     */ package minefantasy.client.tile;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.network.PacketDispatcher;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.api.aesthetic.IChimney;
/*     */ import minefantasy.api.anvil.ITongs;
/*     */ import minefantasy.api.cooking.IHeatSource;
/*     */ import minefantasy.api.forge.IBellowsUseable;
/*     */ import minefantasy.api.forge.ItemHandler;
/*     */ import minefantasy.api.forge.TongsHelper;
/*     */ import minefantasy.api.refine.Alloy;
/*     */ import minefantasy.api.refine.AlloyRecipes;
/*     */ import minefantasy.api.refine.BloomRecipe;
/*     */ import minefantasy.item.ItemBloom;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.system.cfg;
/*     */ import minefantasy.system.network.PacketManagerMF;
/*     */ import minefantasy.system.network.PacketUserMF;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.ISidedInventory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.FurnaceRecipes;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.network.packet.Packet;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.server.management.ServerConfigurationManager;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityFurnace;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ForgeDirection;
/*     */ import net.minecraftforge.oredict.OreDictionary;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TileEntitySmelter
/*     */   extends TileEntity
/*     */   implements IBellowsUseable, IInventory, ISidedInventory, PacketUserMF
/*     */ {
/*     */   private ItemStack[] inv;
/*     */   public int fuel;
/*     */   public int maxFuel;
/*     */   public int progress;
/*     */   public int direction;
/*     */   public int itemMetadata;
/*  56 */   private int lastTemp = 0;
/*     */   private int ticksExisted;
/*  58 */   public int maxTime = 400;
/*     */   private int bellows;
/*  60 */   private static List<ItemStack> allowedSmelts = ;
/*     */   
/*     */   public boolean showIngot;
/*     */   
/*     */ 
/*     */   public TileEntitySmelter()
/*     */   {
/*  67 */     this.inv = new ItemStack[18];
/*  68 */     this.fuel = 0;
/*  69 */     this.maxFuel = 0;
/*  70 */     this.progress = 0;
/*     */   }
/*     */   
/*     */   public TileEntitySmelter(int metadata) {
/*  74 */     this();
/*  75 */     this.itemMetadata = metadata;
/*     */   }
/*     */   
/*     */   public int func_70302_i_() {
/*  79 */     return this.inv.length;
/*     */   }
/*     */   
/*     */   public ItemStack func_70301_a(int i) {
/*  83 */     return this.inv[i];
/*     */   }
/*     */   
/*     */   public ItemStack func_70298_a(int i, int j) {
/*  87 */     if (this.inv[i] != null) {
/*  88 */       if (this.inv[i].field_77994_a <= j) {
/*  89 */         ItemStack itemstack = this.inv[i];
/*  90 */         this.inv[i] = null;
/*  91 */         return itemstack;
/*     */       }
/*  93 */       ItemStack itemstack1 = this.inv[i].func_77979_a(j);
/*  94 */       if (this.inv[i].field_77994_a == 0) {
/*  95 */         this.inv[i] = null;
/*     */       }
/*  97 */       return itemstack1;
/*     */     }
/*  99 */     return null;
/*     */   }
/*     */   
/*     */   public void func_70299_a(int i, ItemStack itemstack)
/*     */   {
/* 104 */     this.inv[i] = itemstack;
/* 105 */     if ((itemstack != null) && (itemstack.field_77994_a > func_70297_j_())) {
/* 106 */       itemstack.field_77994_a = func_70297_j_();
/*     */     }
/*     */   }
/*     */   
/*     */   public String func_70303_b() {
/* 111 */     return "Bloomery";
/*     */   }
/*     */   
/*     */   public void func_70307_a(NBTTagCompound nbt) {
/* 115 */     super.func_70307_a(nbt);
/* 116 */     NBTTagList nbttaglist = nbt.func_74761_m("Items");
/* 117 */     this.inv = new ItemStack[func_70302_i_()];
/* 118 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/* 119 */       NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.func_74743_b(i);
/* 120 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 121 */       if ((byte0 >= 0) && (byte0 < this.inv.length)) {
/* 122 */         this.inv[byte0] = ItemStack.func_77949_a(nbttagcompound1);
/*     */       }
/*     */     }
/*     */     
/* 126 */     this.lastTemp = nbt.func_74762_e("LastTemp");
/* 127 */     this.bellows = nbt.func_74762_e("bellows");
/* 128 */     this.maxTime = nbt.func_74762_e("maxTime");
/* 129 */     this.fuel = nbt.func_74762_e("BurnTime");
/* 130 */     this.direction = nbt.func_74762_e("Dir");
/* 131 */     this.progress = nbt.func_74762_e("CookTime");
/* 132 */     this.maxFuel = getItemBurnTime(this.inv[0]);
/*     */   }
/*     */   
/*     */   public void func_70310_b(NBTTagCompound nbt) {
/* 136 */     super.func_70310_b(nbt);
/* 137 */     nbt.func_74768_a("LastTemp", this.lastTemp);
/* 138 */     nbt.func_74768_a("BurnTime", this.fuel);
/* 139 */     nbt.func_74768_a("Dir", this.direction);
/* 140 */     nbt.func_74768_a("bellows", this.bellows);
/* 141 */     nbt.func_74768_a("CookTime", this.progress);
/* 142 */     nbt.func_74768_a("maxTime", this.maxTime);
/* 143 */     NBTTagList nbttaglist = new NBTTagList();
/* 144 */     for (int i = 0; i < this.inv.length; i++) {
/* 145 */       if (this.inv[i] != null) {
/* 146 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 147 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 148 */         this.inv[i].func_77955_b(nbttagcompound1);
/* 149 */         nbttaglist.func_74742_a(nbttagcompound1);
/*     */       }
/*     */     }
/*     */     
/* 153 */     nbt.func_74782_a("Items", nbttaglist);
/*     */   }
/*     */   
/*     */   public int func_70297_j_() {
/* 157 */     return 64;
/*     */   }
/*     */   
/*     */   public int getCookProgressScaled(int i) {
/* 161 */     return this.progress * i / this.maxTime;
/*     */   }
/*     */   
/*     */   public int getBurnTimeRemainingScaled(int i) {
/* 165 */     if (this.maxFuel == 0) {
/* 166 */       this.maxFuel = this.maxTime;
/*     */     }
/* 168 */     return this.fuel * i / this.maxFuel;
/*     */   }
/*     */   
/*     */   public boolean isBurning() {
/* 172 */     if (getTier() == 0) {
/* 173 */       return this.fuel > 0;
/*     */     }
/* 175 */     if ((this.field_70331_k != null) && (this.field_70331_k.field_72995_K)) {
/* 176 */       return this.showIngot;
/*     */     }
/* 178 */     return (getHeatSource() > 0) && (getRecipe() != null);
/*     */   }
/*     */   
/*     */   public void func_70316_g() {
/* 182 */     if (!this.field_70331_k.field_72995_K) {
/* 183 */       this.showIngot = (getTier() == 0 ? hasSmelted() : isBurning());
/*     */     }
/* 185 */     if (this.bellows > 0)
/* 186 */       this.bellows -= 1;
/* 187 */     if (getTier() >= 1) {
/* 188 */       int time = 400;
/* 189 */       for (int a = 1; a < func_70302_i_() - 1; a++) {
/* 190 */         if (this.inv[a] != null) {
/* 191 */           time += 50;
/*     */         }
/*     */       }
/* 194 */       if (!this.field_70331_k.field_72995_K)
/* 195 */         this.maxTime = time;
/*     */     } else {
/* 197 */       this.maxTime = BloomRecipe.getTime(this.inv[1]);
/*     */     }
/* 199 */     boolean flag = this.fuel > 0;
/* 200 */     boolean flag1 = false;
/* 201 */     boolean flag2 = isBurning();
/* 202 */     if ((getTier() == 0) && (this.fuel > 0)) {
/* 203 */       this.fuel -= 2;
/*     */     }
/* 205 */     if (!this.field_70331_k.field_72995_K) {
/* 206 */       this.ticksExisted += 1;
/* 207 */       if ((getTier() > 0) && (this.ticksExisted % 20 == 0)) {
/* 208 */         this.lastTemp = getTemperature();
/*     */       }
/* 210 */       if ((getTier() == 0) && (this.fuel <= 0) && (canSmelt())) {
/* 211 */         this.maxFuel = (this.fuel = getItemBurnTime(this.inv[0]));
/* 212 */         if (this.fuel > 0) {
/* 213 */           flag1 = true;
/* 214 */           if (this.inv[0] != null) {
/* 215 */             if (this.inv[0].func_77973_b().func_77634_r()) {
/* 216 */               this.inv[0] = this.inv[0].func_77973_b().getContainerItemStack(this.inv[0]);
/*     */             } else {
/* 218 */               this.inv[0].field_77994_a -= 1;
/* 219 */               if (this.inv[0].field_77994_a == 0) {
/* 220 */                 this.inv[0] = null;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/* 226 */       if ((isBurning()) && (canSmelt()) && ((getTier() > 0) || (this.fuel > 0))) {
/* 227 */         this.progress += getHeatSource();
/* 228 */         if (this.progress >= this.maxTime) {
/* 229 */           this.progress = 0;
/* 230 */           smeltItem();
/* 231 */           flag1 = true;
/*     */         }
/*     */       } else {
/* 234 */         this.progress = 0;
/*     */       }
/*     */     }
/* 237 */     if (flag1) {
/* 238 */       func_70296_d();
/*     */     }
/* 240 */     if (isBurning()) {
/* 241 */       int x = this.field_70329_l;
/* 242 */       int y = this.field_70330_m;
/* 243 */       int z = this.field_70327_n;
/* 244 */       Random rand = new Random();
/* 245 */       if (!this.field_70331_k.isBlockSolidOnSide(x, y + 1, z, ForgeDirection.DOWN))
/* 246 */         this.field_70331_k.func_72869_a("largesmoke", x + 0.5F, y, z + 0.5F, 0.0D, 0.06499999761581421D, 0.0D);
/*     */     }
/* 248 */     if (!this.field_70331_k.field_72995_K) {
/* 249 */       int off = getOffMetadata();
/* 250 */       int on = getOnMetadata();
/* 251 */       boolean update = false;
/* 252 */       if ((isBurning()) && (this.field_70331_k.func_72805_g(this.field_70329_l, this.field_70330_m, this.field_70327_n) != on)) {
/* 253 */         this.field_70331_k.func_72921_c(this.field_70329_l, this.field_70330_m, this.field_70327_n, on, 3);
/* 254 */         this.field_70331_k.func_72969_x(this.field_70329_l, this.field_70330_m, this.field_70327_n);
/* 255 */         update = true;
/*     */       }
/* 257 */       if ((!isBurning()) && (this.field_70331_k.func_72805_g(this.field_70329_l, this.field_70330_m, this.field_70327_n) != off)) {
/* 258 */         this.field_70331_k.func_72921_c(this.field_70329_l, this.field_70330_m, this.field_70327_n, off, 3);
/* 259 */         this.field_70331_k.func_72969_x(this.field_70329_l, this.field_70330_m, this.field_70327_n);
/* 260 */         update = true;
/*     */       }
/* 262 */       if ((getTier() > 0) && (update)) {
/* 263 */         this.lastTemp = getTemperature();
/*     */       }
/*     */     }
/* 266 */     if (isBurning()) {
/* 267 */       puffSmoke(new Random(), this.field_70331_k, this.field_70329_l, this.field_70330_m, this.field_70327_n);
/*     */     }
/* 269 */     sendPacketToClients();
/*     */   }
/*     */   
/*     */   public void puffSmoke(Random rand, World world, int x, int y, int z) {
/* 273 */     if (getTier() >= 1) {
/* 274 */       if (rand.nextInt(10) == 0) {
/* 275 */         world.func_72869_a("smoke", x + 0.5F, y + 1, z + 0.5F, (rand.nextFloat() - 0.5F) / 6.0F, 0.06499999761581421D, (rand.nextFloat() - 0.5F) / 6.0F);
/*     */       }
/* 277 */       return;
/*     */     }
/* 279 */     Block block = Block.field_71973_m[world.func_72798_a(x, y + 1, z)];
/* 280 */     IChimney chimney = null;
/*     */     
/* 282 */     if ((block instanceof IChimney)) {
/* 283 */       chimney = (IChimney)block;
/*     */     }
/* 285 */     if ((chimney == null) || ((chimney != null) && (!chimney.puffSmoke(world, x, y + 1, z, 0.16666667F, 1.0F, 1.0F)))) {
/* 286 */       for (int a = 0; a < 5; a++) {
/* 287 */         world.func_72869_a("largesmoke", x + 0.5F, y + 1, z + 0.5F, (rand.nextFloat() - 0.5F) / 6.0F, 0.06499999761581421D, (rand.nextFloat() - 0.5F) / 6.0F);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean canSmelt() {
/* 293 */     if ((getTier() >= 1) && (this.field_70331_k != null) && 
/* 294 */       (getHeatSource() <= 0)) {
/* 295 */       return false;
/*     */     }
/* 297 */     ItemStack result = getRecipe();
/* 298 */     if (result == null)
/* 299 */       return false;
/* 300 */     if (this.inv[getOutSlot()] == null)
/* 301 */       return true;
/* 302 */     if ((this.inv[getOutSlot()] != null) && (this.inv[getOutSlot()].func_77969_a(result)) && (this.inv[getOutSlot()].field_77994_a < this.inv[getOutSlot()].func_77976_d() - (result.field_77994_a - 1)))
/* 303 */       return true;
/* 304 */     return false;
/*     */   }
/*     */   
/*     */   private int getHeatSource() {
/* 308 */     if (getTier() == 0) {
/* 309 */       if (this.bellows > 0) {
/* 310 */         return 3;
/*     */       }
/* 312 */       return 1;
/*     */     }
/*     */     
/* 315 */     return (int)Math.floor(this.lastTemp / 250.0F);
/*     */   }
/*     */   
/*     */   public int getTemperature() {
/* 319 */     if (this.field_70331_k == null) {
/* 320 */       return 0;
/*     */     }
/* 322 */     Material mat = this.field_70331_k.func_72803_f(this.field_70329_l, this.field_70330_m - 1, this.field_70327_n);
/* 323 */     if (mat != null) {
/* 324 */       if (mat == Material.field_76250_n) {
/* 325 */         return 200;
/*     */       }
/* 327 */       if (mat == Material.field_76256_h) {
/* 328 */         return 1000;
/*     */       }
/*     */     }
/* 331 */     TileEntity tile = this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m - 1, this.field_70327_n);
/*     */     
/* 333 */     if ((tile != null) && 
/* 334 */       ((tile instanceof IHeatSource))) {
/* 335 */       return ((IHeatSource)tile).getHeat();
/*     */     }
/*     */     
/* 338 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean hasSmelted()
/*     */   {
/* 346 */     if (this.field_70331_k == null) {
/* 347 */       return false;
/*     */     }
/* 349 */     if (this.field_70331_k.field_72995_K) {
/* 350 */       return this.showIngot;
/*     */     }
/* 352 */     return this.inv[getOutSlot()] != null;
/*     */   }
/*     */   
/*     */   public int getOutSlot() {
/* 356 */     return func_70302_i_() - 1;
/*     */   }
/*     */   
/*     */   public void smeltItem() {
/* 360 */     if (!canSmelt()) {
/* 361 */       return;
/*     */     }
/*     */     
/* 364 */     ItemStack itemstack = getRecipe();
/*     */     
/* 366 */     if (this.inv[getOutSlot()] == null) {
/* 367 */       this.inv[getOutSlot()] = itemstack.func_77946_l();
/*     */ 
/*     */     }
/* 370 */     else if (this.inv[getOutSlot()].field_77993_c == itemstack.field_77993_c) {
/* 371 */       this.inv[getOutSlot()].field_77994_a += itemstack.field_77994_a;
/*     */     }
/*     */     
/* 374 */     for (int a = 1; a < func_70302_i_() - 1; a++) {
/* 375 */       if (this.inv[a] != null) {
/* 376 */         this.inv[a].field_77994_a -= 1;
/* 377 */         if (this.inv[a].field_77994_a <= 0) {
/* 378 */           this.inv[a] = null;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean isWrought(ItemStack itemstack) {
/* 385 */     if (itemstack == null) {
/* 386 */       return false;
/*     */     }
/* 388 */     return itemstack.func_77969_a(ItemListMF.component(60));
/*     */   }
/*     */   
/*     */   public int getItemBurnTime(ItemStack itemstack) {
/* 392 */     if (itemstack == null) {
/* 393 */       return 0;
/*     */     }
/* 395 */     if (getTier() == 0) {
/* 396 */       return (int)TileEntityFurnace.func_70398_a(itemstack);
/*     */     }
/* 398 */     return TileEntityFurnace.func_70398_a(itemstack) / 4;
/*     */   }
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer entityplayer) {
/* 402 */     if (this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m, this.field_70327_n) != this) {
/* 403 */       return false;
/*     */     }
/* 405 */     return entityplayer.func_70092_e(this.field_70329_l + 0.5D, this.field_70330_m + 0.5D, this.field_70327_n + 0.5D) <= 64.0D;
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
/* 416 */     return null;
/*     */   }
/*     */   
/*     */   private ItemStack getRecipe() {
/* 420 */     if (getTier() == 0) {
/* 421 */       if (getResult(this.inv[1]) != null) {
/* 422 */         return ItemHandler.isCarbon(this.inv[2]) ? getResult(this.inv[1]) : null;
/*     */       }
/* 424 */       return null;
/*     */     }
/*     */     
/* 427 */     if (getTier() == 1) {
/* 428 */       ItemStack[] input = new ItemStack[func_70302_i_() - 2];
/* 429 */       for (int a = 1; a < 10; a++) {
/* 430 */         input[(a - 1)] = this.inv[a];
/*     */       }
/* 432 */       Alloy alloy = AlloyRecipes.getResult(input);
/* 433 */       if ((alloy != null) && 
/* 434 */         (alloy.getLevel() <= 0)) {
/* 435 */         return AlloyRecipes.getResult(input).getRecipeOutput();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 440 */     if (getTier() == 2) {
/* 441 */       ItemStack[] input = new ItemStack[func_70302_i_() - 2];
/* 442 */       for (int a = 1; a < 17; a++) {
/* 443 */         input[(a - 1)] = this.inv[a];
/*     */       }
/* 445 */       Alloy alloy = AlloyRecipes.getResult(input);
/* 446 */       if ((alloy != null) && 
/* 447 */         (alloy.getLevel() <= 1)) {
/* 448 */         return AlloyRecipes.getResult(input).getRecipeOutput();
/*     */       }
/*     */     }
/*     */     
/* 452 */     return null;
/*     */   }
/*     */   
/*     */   private ItemStack getResult(ItemStack itemStack) {
/* 456 */     if (BloomRecipe.getResult(itemStack) != null) {
/* 457 */       return BloomRecipe.getResult(itemStack);
/*     */     }
/* 459 */     ItemStack furnaceRec = FurnaceRecipes.func_77602_a().getSmeltingResult(itemStack);
/*     */     
/* 461 */     if ((furnaceRec != null) && (canAcceptOut(furnaceRec))) {
/* 462 */       if (cfg.easyBlooms) {
/* 463 */         return furnaceRec;
/*     */       }
/* 465 */       return ItemBloom.createBloom(furnaceRec);
/*     */     }
/*     */     
/* 468 */     return null;
/*     */   }
/*     */   
/*     */   private boolean canAcceptOut(ItemStack result) {
/* 472 */     if (result == null) {
/* 473 */       return false;
/*     */     }
/* 475 */     ItemStack result2 = result;
/*     */     
/* 477 */     if (result.field_77993_c == ItemListMF.bloom.field_77779_bT) {
/* 478 */       result2 = ItemBloom.getItem(result);
/*     */     }
/*     */     
/* 481 */     for (ItemStack compare : allowedSmelts) {
/* 482 */       if (compare.func_77969_a(result2)) {
/* 483 */         return true;
/*     */       }
/* 485 */       if ((compare.field_77993_c == result2.field_77993_c) && (compare.func_77960_j() == 32767)) {
/* 486 */         return true;
/*     */       }
/*     */     }
/* 489 */     return false;
/*     */   }
/*     */   
/*     */   private void sendPacketToClients() {
/* 493 */     if (!this.field_70331_k.field_72995_K) {
/*     */       try {
/* 495 */         boolean display = hasSmelted();
/* 496 */         if (getTier() > 0) {
/* 497 */           display = isBurning();
/*     */         }
/* 499 */         Packet packet = PacketManagerMF.getPacketIntegerArray(this, new int[] { this.fuel, this.maxFuel, this.progress, this.direction, this.showIngot ? 1 : 0, this.maxTime, this.lastTemp });
/* 500 */         FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*     */       } catch (NullPointerException e) {
/* 502 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   private void sendPacketToServer()
/*     */   {
/* 510 */     if (this.field_70331_k.field_72995_K) {
/*     */       try {
/* 512 */         Packet packet = PacketManagerMF.getPacketIntegerArray(this, new int[] { this.fuel, this.maxFuel, this.progress, this.direction });
/* 513 */         PacketDispatcher.sendPacketToServer(packet);
/*     */       } catch (NullPointerException e) {
/* 515 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void recievePacket(ByteArrayDataInput data)
/*     */   {
/* 522 */     this.fuel = data.readInt();
/* 523 */     this.maxFuel = data.readInt();
/* 524 */     this.progress = data.readInt();
/* 525 */     this.direction = data.readInt();
/* 526 */     int smelt = data.readInt();
/* 527 */     this.showIngot = (smelt == 1);
/* 528 */     this.maxTime = data.readInt();
/* 529 */     this.lastTemp = data.readInt();
/*     */   }
/*     */   
/*     */   public int func_70322_n() {
/* 533 */     if (this.field_70331_k == null) {
/* 534 */       return this.itemMetadata * 2;
/*     */     }
/* 536 */     if (this.field_70325_p == -1) {
/* 537 */       this.field_70325_p = this.field_70331_k.func_72805_g(this.field_70329_l, this.field_70330_m, this.field_70327_n);
/*     */     }
/*     */     
/* 540 */     return this.field_70325_p;
/*     */   }
/*     */   
/*     */   public int getTier() {
/* 544 */     int meta = func_70322_n();
/* 545 */     return (int)Math.floor(meta / 2);
/*     */   }
/*     */   
/*     */   private int getOnMetadata() {
/* 549 */     return getTier() * 2 + 1;
/*     */   }
/*     */   
/*     */   private int getOffMetadata() {
/* 553 */     return getTier() * 2;
/*     */   }
/*     */   
/*     */   public boolean func_94042_c()
/*     */   {
/* 558 */     return true;
/*     */   }
/*     */   
/*     */   public boolean canPutInFuel(ItemStack itemstack) {
/* 562 */     if (itemstack == null) {
/* 563 */       return false;
/*     */     }
/* 565 */     if (getItemBurnTime(itemstack) <= 0) {
/* 566 */       return false;
/*     */     }
/* 568 */     ItemStack fs = func_70301_a(1);
/* 569 */     if (fs != null) {
/* 570 */       if (!fs.func_77969_a(itemstack)) {
/* 571 */         return false;
/*     */       }
/* 573 */       if (fs.field_77994_a >= fs.func_77976_d()) {
/* 574 */         return false;
/*     */       }
/*     */     }
/* 577 */     return true;
/*     */   }
/*     */   
/*     */   public int[] func_94128_d(int side)
/*     */   {
/* 582 */     if (getTier() == 0) {
/* 583 */       if (side == 1)
/*     */       {
/* 585 */         return new int[] { 2, 1 };
/*     */       }
/* 587 */       if (side == 0)
/*     */       {
/* 589 */         return new int[] { getOutSlot(), 0 };
/*     */       }
/* 591 */       return new int[] { 0 };
/*     */     }
/* 593 */     return new int[] { 0, getOutSlot() };
/*     */   }
/*     */   
/*     */   private int getFrontSide() {
/* 597 */     switch (this.direction) {
/*     */     case 0: 
/* 599 */       return 2;
/*     */     case 1: 
/* 601 */       return 3;
/*     */     case 2: 
/* 603 */       return 4;
/*     */     case 3: 
/* 605 */       return 5;
/*     */     }
/* 607 */     return 2;
/*     */   }
/*     */   
/*     */   private int getLeftSide() {
/* 611 */     switch (this.direction) {
/*     */     case 0: 
/* 613 */       return 5;
/*     */     case 1: 
/* 615 */       return 2;
/*     */     case 2: 
/* 617 */       return 3;
/*     */     case 3: 
/* 619 */       return 4;
/*     */     }
/* 621 */     return 2;
/*     */   }
/*     */   
/*     */   private int getRightSide() {
/* 625 */     switch (this.direction) {
/*     */     case 0: 
/* 627 */       return 4;
/*     */     case 1: 
/* 629 */       return 5;
/*     */     case 2: 
/* 631 */       return 2;
/*     */     case 3: 
/* 633 */       return 3;
/*     */     }
/* 635 */     return 2;
/*     */   }
/*     */   
/*     */   public boolean func_102007_a(int i, ItemStack itemstack, int j)
/*     */   {
/* 640 */     if (j == 0) {
/* 641 */       return false;
/*     */     }
/* 643 */     if (getTier() == 0) {
/* 644 */       return func_94041_b(i, itemstack);
/*     */     }
/* 646 */     if (i == 0) {
/* 647 */       return canPutInFuel(itemstack);
/*     */     }
/* 649 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_94041_b(int slot, ItemStack item)
/*     */   {
/* 654 */     if (slot == 0) {
/* 655 */       return isItemFuel(item);
/*     */     }
/* 657 */     if (slot == 1) {
/* 658 */       return true;
/*     */     }
/* 660 */     if (slot == 2) {
/* 661 */       return ItemHandler.isCarbon(item);
/*     */     }
/*     */     
/* 664 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isItemFuel(ItemStack item) {
/* 668 */     return getItemBurnTime(item) > 0;
/*     */   }
/*     */   
/*     */   public boolean func_102008_b(int i, ItemStack itemstack, int j)
/*     */   {
/* 673 */     if (getTier() == 0) {
/* 674 */       if ((i == 0) && 
/* 675 */         (!isItemFuel(itemstack))) {
/* 676 */         return true;
/*     */       }
/*     */       
/* 679 */       if (i == 3) {
/* 680 */         return true;
/*     */       }
/*     */     }
/* 683 */     return (i == getOutSlot()) && (!isItemFuel(itemstack));
/*     */   }
/*     */   
/*     */   public boolean goesInCarbon(ItemStack itemSlot) {
/* 687 */     if (ItemHandler.isCarbon(itemSlot)) {
/* 688 */       if ((getItemBurnTime(itemSlot) > 0) && 
/* 689 */         (getResult(this.inv[1]) == null)) {
/* 690 */         return false;
/*     */       }
/*     */       
/* 693 */       return true;
/*     */     }
/* 695 */     return false;
/*     */   }
/*     */   
/*     */   public boolean goesInFuel(ItemStack itemSlot) {
/* 699 */     if ((ItemHandler.isCarbon(itemSlot)) && 
/* 700 */       (getResult(this.inv[1]) != null)) {
/* 701 */       return false;
/*     */     }
/*     */     
/* 704 */     return getItemBurnTime(itemSlot) > 0;
/*     */   }
/*     */   
/*     */   private static List<ItemStack> getAllowedSmelts() {
/* 708 */     List list = new ArrayList();
/*     */     
/* 710 */     list.add(new ItemStack(Item.field_77717_p));
/*     */     
/* 712 */     list = addOresIng("Copper", list);
/* 713 */     list = addOresIng("Tin", list);
/* 714 */     list = addOresIng("Bronze", list);
/* 715 */     list = addOresIng("Iron", list);
/* 716 */     list = addOresIng("Gold", list);
/* 717 */     list = addOresIng("Silver", list);
/* 718 */     list = addOresIng("RefinedIron", list);
/* 719 */     list = addOresIng("Zinc", list);
/* 720 */     list = addOresIng("Nickel", list);
/* 721 */     list = addOresIng("Tungsten", list);
/* 722 */     list = addOresIng("Bismuth", list);
/* 723 */     list = addOresIng("Lead", list);
/* 724 */     list = addOresIng("Steel", list);
/* 725 */     list = addOresIng("Mithril", list);
/*     */     
/* 727 */     return list;
/*     */   }
/*     */   
/*     */   private static List addOresIng(String ores, List list) {
/* 731 */     return addOres("ingot" + ores, list);
/*     */   }
/*     */   
/*     */   private static List addOres(String ores, List list) {
/* 735 */     for (ItemStack ore : OreDictionary.getOres(ores)) {
/* 736 */       list.add(ore);
/*     */     }
/* 738 */     return list;
/*     */   }
/*     */   
/*     */   public boolean tryTakeItem(EntityPlayer player) {
/* 742 */     if (getTier() != 0) {
/* 743 */       return false;
/*     */     }
/* 745 */     if (player == null) {
/* 746 */       return false;
/*     */     }
/*     */     
/* 749 */     if ((player.func_70694_bm() != null) && ((player.func_70694_bm().func_77973_b() instanceof ITongs))) {
/* 750 */       ItemStack tongs = player.func_70694_bm();
/* 751 */       if (TongsHelper.getHeldItem(tongs) == null) {
/* 752 */         int s = getOutSlot();
/* 753 */         ItemStack slot = this.inv[s];
/* 754 */         if ((slot != null) && 
/* 755 */           (TongsHelper.trySetHeldItem(tongs, slot))) {
/* 756 */           if ((MineFantasyBase.isDebug()) && 
/* 757 */             (!player.field_70170_p.field_72995_K)) {
/* 758 */             System.out.println("Pickup");
/*     */           }
/*     */           
/* 761 */           func_70298_a(s, 1);
/* 762 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 767 */     return false;
/*     */   }
/*     */   
/*     */   public ItemStack getResultSlot() {
/* 771 */     return this.inv[getOutSlot()];
/*     */   }
/*     */   
/*     */   public void onUsedWithBellows(float powerLevel)
/*     */   {
/* 776 */     this.bellows = ((int)(20.0F * powerLevel));
/*     */   }
/*     */   
/*     */   public int getHeatScaled(int height) {
/* 780 */     if (this.lastTemp <= 0)
/* 781 */       return 0;
/* 782 */     return this.lastTemp * height / ItemHandler.forgeMaxTemp;
/*     */   }
/*     */   
/*     */   public boolean willShowBase() {
/* 786 */     if (this.field_70331_k == null) {
/* 787 */       return false;
/*     */     }
/* 789 */     if (getTier() == 0) {
/* 790 */       return false;
/*     */     }
/*     */     
/* 793 */     if ((this.field_70331_k.func_72803_f(this.field_70329_l, this.field_70330_m - 1, this.field_70327_n) != null) && (this.field_70331_k.func_72803_f(this.field_70329_l, this.field_70330_m - 1, this.field_70327_n) == Material.field_76250_n)) {
/* 794 */       return true;
/*     */     }
/* 796 */     if ((this.field_70331_k.func_72803_f(this.field_70329_l, this.field_70330_m - 1, this.field_70327_n) != null) && (this.field_70331_k.func_72803_f(this.field_70329_l, this.field_70330_m - 1, this.field_70327_n) == Material.field_76256_h)) {
/* 797 */       return true;
/*     */     }
/*     */     
/* 800 */     TileEntity tile = this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m - 1, this.field_70327_n);
/*     */     
/* 802 */     if (tile == null) {
/* 803 */       return false;
/*     */     }
/* 805 */     if ((tile instanceof IHeatSource)) {
/* 806 */       return ((IHeatSource)tile).canPlaceAbove();
/*     */     }
/* 808 */     if ((tile instanceof TileEntityForge)) {
/* 809 */       return true;
/*     */     }
/* 811 */     return false;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/TileEntitySmelter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */