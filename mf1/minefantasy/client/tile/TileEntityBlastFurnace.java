/*     */ package minefantasy.client.tile;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.api.aesthetic.IChimney;
/*     */ import minefantasy.api.forge.IBellowsUseable;
/*     */ import minefantasy.api.forge.ItemHandler;
/*     */ import minefantasy.api.refine.BlastRecipes;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.system.network.PacketManagerMF;
/*     */ import minefantasy.system.network.PacketUserMF;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.ISidedInventory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.network.packet.Packet;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.server.management.ServerConfigurationManager;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ForgeDirection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TileEntityBlastFurnace
/*     */   extends TileEntity
/*     */   implements IInventory, PacketUserMF, ISidedInventory, IBellowsUseable
/*     */ {
/*     */   public byte direction;
/*     */   private ItemStack[] inventory;
/*     */   public int fuel;
/*     */   public int maxFuel;
/*     */   public int cookTime;
/*  46 */   public static int requiredTime = 800;
/*     */   public int ticksExisted;
/*     */   public int heat;
/*  49 */   public static int requiredHeat = 2400;
/*     */   public boolean canCook;
/*     */   private boolean isBuilt;
/*     */   private int bellowsBonus;
/*  53 */   private final ItemStack slag = ItemListMF.component(11, 1);
/*     */   private String customName;
/*     */   
/*  56 */   public TileEntityBlastFurnace() { this.inventory = new ItemStack[3]; }
/*     */   
/*     */   public void updateFurnace()
/*     */   {
/*  60 */     if (!furnaceExists()) {
/*  61 */       this.fuel = (this.maxFuel = this.cookTime = 0);
/*  62 */       return;
/*     */     }
/*  64 */     if (getFuelBlock() != null) {
/*  65 */       getFuelBlock().canCook = canCook();
/*     */     }
/*     */     
/*  68 */     boolean var1 = this.fuel > 0;
/*  69 */     boolean var2 = false;
/*     */     
/*  71 */     if (this.fuel > 0) {
/*  72 */       this.fuel -= 1;
/*     */     }
/*     */     
/*  75 */     if (!this.field_70331_k.field_72995_K) {
/*  76 */       if ((getFuelBlock() != null) && 
/*  77 */         (this.fuel == 0) && (getFuelBlock().canRefuel())) {
/*  78 */         this.maxFuel = (this.fuel = getItemBurnTime(getFuelSlot()));
/*     */         
/*  80 */         if (this.fuel > 0) {
/*  81 */           var2 = true;
/*     */           
/*  83 */           getFuelBlock().func_70298_a(0, 1);
/*     */         }
/*     */       }
/*     */       
/*  87 */       if ((isBurning()) && (canSmelt())) {
/*  88 */         this.cookTime += 1;
/*  89 */         if ((getFuelBlock() != null) && (getFuelBlock().bellowsBonus > 0)) {
/*  90 */           this.cookTime += 2;
/*     */         }
/*     */         
/*  93 */         if (this.cookTime >= requiredTime) {
/*  94 */           this.cookTime = 0;
/*  95 */           smeltItem();
/*  96 */           var2 = true;
/*     */         }
/*     */       } else {
/*  99 */         this.cookTime = 0;
/*     */       }
/*     */       
/* 102 */       if (var1 != this.fuel > 0) {
/* 103 */         var2 = true;
/*     */       }
/*     */     }
/*     */     
/* 107 */     if (var2) {
/* 108 */       func_70296_d();
/*     */     }
/* 110 */     if (getFuelBlock() != null) {
/* 111 */       getFuelBlock().fuel = this.fuel;
/* 112 */       getFuelBlock().maxFuel = this.maxFuel;
/*     */     }
/* 114 */     if ((isBurning()) && (this.ticksExisted % 5 == 0)) {
/* 115 */       puffSmoke(3);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean canSmelt() {
/* 120 */     int h = 0;
/* 121 */     if (getFuelBlock() != null) {
/* 122 */       h = getFuelBlock().heat;
/*     */     }
/*     */     
/* 125 */     return (canCook()) && (h >= requiredHeat);
/*     */   }
/*     */   
/*     */   private boolean canRefuel() {
/* 129 */     if ((this.field_70325_p == 2) && 
/* 130 */       (this.field_70331_k.func_72864_z(this.field_70329_l, this.field_70330_m, this.field_70327_n))) {
/* 131 */       return false;
/*     */     }
/* 133 */     return true;
/*     */   }
/*     */   
/*     */   private boolean canCook() {
/* 137 */     if ((this.inventory[0] == null) || (this.inventory[1] == null) || (this.inventory[2] == null))
/* 138 */       return false;
/* 139 */     if ((!isCoal(0)) || (!isLimestone(1))) {
/* 140 */       return false;
/*     */     }
/* 142 */     ItemStack var1 = BlastRecipes.getResult(this.inventory[2]);
/* 143 */     if (var1 == null)
/* 144 */       return false;
/* 145 */     if (getResultSlot() == null)
/* 146 */       return true;
/* 147 */     if (!getResultSlot().func_77969_a(var1))
/* 148 */       return false;
/* 149 */     int result = getResultSlot().field_77994_a + var1.field_77994_a;
/*     */     
/* 151 */     return (canFitSlag()) && (result <= func_70297_j_()) && (result <= var1.func_77976_d());
/*     */   }
/*     */   
/*     */   private boolean canFitSlag()
/*     */   {
/* 156 */     if (getSlagSlot() == null)
/* 157 */       return true;
/* 158 */     if (!getSlagSlot().func_77969_a(this.slag))
/* 159 */       return false;
/* 160 */     int result = getSlagSlot().field_77994_a + this.slag.field_77994_a;
/*     */     
/* 162 */     return result <= 64;
/*     */   }
/*     */   
/*     */   private boolean isLimestone(int i) {
/* 166 */     return ItemHandler.isFlux(this.inventory[i]);
/*     */   }
/*     */   
/*     */   private boolean isCoal(int i) {
/* 170 */     return ItemHandler.isCarbon(this.inventory[i]);
/*     */   }
/*     */   
/*     */   public void smeltItem() {
/* 174 */     if (canSmelt()) {
/* 175 */       ItemStack var1 = BlastRecipes.getResult(this.inventory[2]);
/*     */       
/* 177 */       if (getResultSlot() == null) {
/* 178 */         setResult(var1.func_77946_l());
/* 179 */       } else if (getResultSlot().func_77969_a(var1)) {
/* 180 */         getResultBlock().incrStackSize(0, var1.field_77994_a);
/*     */       }
/*     */       
/* 183 */       if (getSlagSlot() == null) {
/* 184 */         setSlag(this.slag.func_77946_l());
/* 185 */       } else if (getSlagSlot().func_77969_a(this.slag)) {
/* 186 */         getResultBlock().incrStackSize(1, this.slag.field_77994_a);
/*     */       }
/*     */       
/* 189 */       for (int a = 0; a < 3; a++) {
/* 190 */         this.inventory[a].field_77994_a -= 1;
/*     */         
/* 192 */         if (this.inventory[a].field_77994_a <= 0) {
/* 193 */           this.inventory[a] = null;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static int getItemBurnTime(ItemStack stack) {
/* 200 */     if (stack == null) {
/* 201 */       return 0;
/*     */     }
/* 203 */     if (ItemHandler.getBlastFuel(stack) > 0.0F) {
/* 204 */       return (int)ItemHandler.getBlastFuel(stack) * requiredTime;
/*     */     }
/* 206 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void updateFuel()
/*     */   {
/* 214 */     if (this.field_70331_k.field_72995_K) {
/* 215 */       return;
/*     */     }
/*     */     
/* 218 */     if (getInput() != null) {
/* 219 */       if ((this.fuel > 0) && (this.heat < requiredHeat)) {
/* 220 */         this.heat += 4;
/* 221 */         if (this.bellowsBonus > 0)
/* 222 */           this.heat += 2;
/* 223 */         this.fuel -= 5;
/*     */       }
/* 225 */       if (this.fuel <= 0) {
/* 226 */         if (this.heat > 0)
/* 227 */           this.heat -= 2;
/* 228 */         if (this.heat < 0)
/* 229 */           this.heat = 0;
/*     */       }
/*     */     } else {
/* 232 */       if (this.heat > 0)
/* 233 */         this.heat -= 10;
/* 234 */       if (this.heat < 0) {
/* 235 */         this.heat = 0;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void setFuelStack(ItemStack item) {
/* 241 */     if (hasFuelBlock()) {
/* 242 */       getFuelBlock().func_70299_a(0, item);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int getCookProgressScaled(int width)
/*     */   {
/* 252 */     return this.cookTime * width / requiredTime;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int getHeatProgressScaled(int width) {
/* 257 */     return this.heat * width / requiredHeat;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int getBurnTimeRemainingScaled(int height)
/*     */   {
/* 267 */     if (this.fuel <= 0)
/* 268 */       return 0;
/* 269 */     if (this.maxFuel == 0) {
/* 270 */       this.maxFuel = 200;
/*     */     }
/*     */     
/* 273 */     return this.fuel * height / this.maxFuel;
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_70307_a(NBTTagCompound nbt)
/*     */   {
/* 279 */     super.func_70307_a(nbt);
/* 280 */     this.bellowsBonus = nbt.func_74762_e("Bellows");
/* 281 */     this.ticksExisted = nbt.func_74762_e("Time");
/* 282 */     this.heat = nbt.func_74762_e("heat");
/* 283 */     this.direction = nbt.func_74771_c("Facing");
/* 284 */     this.fuel = nbt.func_74762_e("Fuel");
/* 285 */     this.maxFuel = nbt.func_74762_e("MFuel");
/* 286 */     this.cookTime = nbt.func_74762_e("Cook");
/* 287 */     this.isBuilt = nbt.func_74767_n("Build");
/*     */     
/* 289 */     NBTTagList var2 = nbt.func_74761_m("Items");
/* 290 */     this.inventory = new ItemStack[3];
/*     */     
/* 292 */     for (int var3 = 0; var3 < var2.func_74745_c(); var3++) {
/* 293 */       NBTTagCompound var4 = (NBTTagCompound)var2.func_74743_b(var3);
/* 294 */       byte var5 = var4.func_74771_c("Slot");
/*     */       
/* 296 */       if ((var5 >= 0) && (var5 < this.inventory.length)) {
/* 297 */         this.inventory[var5] = ItemStack.func_77949_a(var4);
/*     */       }
/*     */     }
/*     */     
/* 301 */     if (nbt.func_74764_b("CustomName")) {
/* 302 */       this.customName = nbt.func_74779_i("CustomName");
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70316_g()
/*     */   {
/* 308 */     this.ticksExisted += 1;
/*     */     
/* 310 */     if (this.bellowsBonus > 0) {
/* 311 */       this.bellowsBonus -= 1;
/*     */     }
/* 313 */     if (this.ticksExisted % 10 == 0) {
/* 314 */       this.isBuilt = structureExists();
/*     */     }
/*     */     
/* 317 */     boolean wasBurning = isBurning();
/* 318 */     super.func_70316_g();
/* 319 */     if ((this.field_70325_p == 2) && (furnaceExists())) {
/* 320 */       updateFuel();
/*     */     }
/*     */     
/* 323 */     if ((this.field_70325_p == 1) && (furnaceExists()))
/* 324 */       updateFurnace();
/* 325 */     if (!furnaceExists()) {
/* 326 */       this.fuel = (this.maxFuel = this.cookTime = 0);
/*     */     }
/* 328 */     sendPacketToClients();
/* 329 */     if ((this.ticksExisted % 20 == 0) && (!isBurning()) && (wasBurning)) {
/* 330 */       onSecondUpdate();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/* 338 */     return this.field_70331_k.func_72805_g(this.field_70329_l, this.field_70330_m, this.field_70327_n);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onSecondUpdate()
/*     */   {
/* 346 */     this.field_70331_k.func_72969_x(this.field_70329_l, this.field_70330_m, this.field_70327_n);
/* 347 */     int radius = 10;
/* 348 */     int height = 10;
/* 349 */     for (int a = -radius; a <= radius; a++) {
/* 350 */       for (int b = -height; b <= height; b++) {
/* 351 */         for (int c = -radius; c <= radius; c++) {
/* 352 */           Random rand = new Random();
/* 353 */           if ((rand.nextInt(30) == 0) && (canCutSnow(a, b, c, radius))) {
/* 354 */             Material mat = this.field_70331_k.func_72803_f(this.field_70329_l + a, this.field_70330_m + b, this.field_70327_n + c);
/* 355 */             if ((mat != null) && (mat == Material.field_76259_v)) {
/* 356 */               this.field_70331_k.func_94575_c(this.field_70329_l + a, this.field_70330_m + b, this.field_70327_n + c, 0);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean canCutSnow(int a, int b, int c, int r)
/*     */   {
/* 366 */     if (!isBurning())
/* 367 */       return false;
/* 368 */     if (getDistanceFromPos(a, this.field_70330_m, c) > r) {
/* 369 */       return false;
/*     */     }
/* 371 */     return true;
/*     */   }
/*     */   
/*     */   public void func_70310_b(NBTTagCompound nbt)
/*     */   {
/* 376 */     super.func_70310_b(nbt);
/* 377 */     nbt.func_74768_a("Bellows", this.bellowsBonus);
/* 378 */     nbt.func_74768_a("heat", this.heat);
/* 379 */     nbt.func_74768_a("Time", this.ticksExisted);
/* 380 */     nbt.func_74774_a("Facing", this.direction);
/* 381 */     nbt.func_74768_a("Fuel", this.fuel);
/* 382 */     nbt.func_74768_a("MFuel", this.maxFuel);
/* 383 */     nbt.func_74768_a("Cook", this.cookTime);
/* 384 */     nbt.func_74757_a("Build", this.isBuilt);
/*     */     
/* 386 */     NBTTagList var2 = new NBTTagList();
/*     */     
/* 388 */     for (int var3 = 0; var3 < this.inventory.length; var3++) {
/* 389 */       if (this.inventory[var3] != null) {
/* 390 */         NBTTagCompound var4 = new NBTTagCompound();
/* 391 */         var4.func_74774_a("Slot", (byte)var3);
/* 392 */         this.inventory[var3].func_77955_b(var4);
/* 393 */         var2.func_74742_a(var4);
/*     */       }
/*     */     }
/*     */     
/* 397 */     nbt.func_74782_a("Items", var2);
/*     */     
/* 399 */     if (func_94042_c()) {
/* 400 */       nbt.func_74778_a("CustomName", this.customName);
/*     */     }
/*     */   }
/*     */   
/*     */   public TileEntityBlastFurnace getFuelBlock() {
/* 405 */     int stepDown = 5;
/* 406 */     if (this.field_70331_k.func_72805_g(this.field_70329_l, this.field_70330_m - stepDown, this.field_70327_n) != 2)
/* 407 */       return null;
/* 408 */     return getBFurnAt(this.field_70329_l, this.field_70330_m - stepDown, this.field_70327_n);
/*     */   }
/*     */   
/*     */   public TileEntityBlastFurnace getInput() {
/* 412 */     int stepUp = 5;
/* 413 */     if (this.field_70331_k.func_72805_g(this.field_70329_l, this.field_70330_m + stepUp, this.field_70327_n) != 1)
/* 414 */       return null;
/* 415 */     return getBFurnAt(this.field_70329_l, this.field_70330_m + stepUp, this.field_70327_n);
/*     */   }
/*     */   
/*     */   public TileEntityBlastFurnace getResultBlock() {
/* 419 */     TileEntityBlastFurnace r = null;
/* 420 */     int stepDown = 6;
/*     */     
/* 422 */     r = getBFurnAt(this.field_70329_l - 2, this.field_70330_m - stepDown, this.field_70327_n);
/* 423 */     if ((r != null) && (this.field_70331_k.func_72805_g(this.field_70329_l - 2, this.field_70330_m - stepDown, this.field_70327_n) == 3)) {
/* 424 */       return r;
/*     */     }
/* 426 */     r = getBFurnAt(this.field_70329_l + 2, this.field_70330_m - stepDown, this.field_70327_n);
/* 427 */     if ((r != null) && (this.field_70331_k.func_72805_g(this.field_70329_l + 2, this.field_70330_m - stepDown, this.field_70327_n) == 3)) {
/* 428 */       return r;
/*     */     }
/* 430 */     r = getBFurnAt(this.field_70329_l, this.field_70330_m - stepDown, this.field_70327_n - 2);
/* 431 */     if ((r != null) && (this.field_70331_k.func_72805_g(this.field_70329_l, this.field_70330_m - stepDown, this.field_70327_n - 2) == 3)) {
/* 432 */       return r;
/*     */     }
/* 434 */     r = getBFurnAt(this.field_70329_l, this.field_70330_m - stepDown, this.field_70327_n + 2);
/* 435 */     if ((r != null) && (this.field_70331_k.func_72805_g(this.field_70329_l, this.field_70330_m - stepDown, this.field_70327_n + 2) == 3)) {
/* 436 */       return r;
/*     */     }
/* 438 */     return null;
/*     */   }
/*     */   
/*     */   public boolean hasFuelBlock() {
/* 442 */     return getFuelBlock() != null;
/*     */   }
/*     */   
/*     */   public boolean hasResultBlock() {
/* 446 */     return getResultBlock() != null;
/*     */   }
/*     */   
/*     */   public boolean furnaceExists() {
/* 450 */     return this.isBuilt;
/*     */   }
/*     */   
/*     */   public boolean structureExists() {
/* 454 */     if (this.field_70325_p != 1)
/* 455 */       return true;
/* 456 */     if (!hasFuelBlock())
/* 457 */       return false;
/* 458 */     if (!hasResultBlock())
/* 459 */       return false;
/* 460 */     if (!isChamberBlock(this.field_70329_l, this.field_70330_m + 1, this.field_70327_n))
/* 461 */       return false;
/* 462 */     if (!isChamberBlock(this.field_70329_l, this.field_70330_m + 2, this.field_70327_n))
/* 463 */       return false;
/* 464 */     if (!isChamberBlock(this.field_70329_l, this.field_70330_m - 1, this.field_70327_n))
/* 465 */       return false;
/* 466 */     if (!isChamberBlock(this.field_70329_l, this.field_70330_m - 2, this.field_70327_n))
/* 467 */       return false;
/* 468 */     if (!isChamberBlock(this.field_70329_l, this.field_70330_m - 3, this.field_70327_n))
/* 469 */       return false;
/* 470 */     if (!isChamberBlock(this.field_70329_l, this.field_70330_m - 4, this.field_70327_n)) {
/* 471 */       return false;
/*     */     }
/* 473 */     for (int x = -1; x < 2; x++) {
/* 474 */       for (int z = -1; z < 2; z++) {
/* 475 */         int id = Block.field_72007_bm.field_71990_ca;
/* 476 */         if ((x == 0) && (z == 0))
/* 477 */           id = Block.field_71938_D.field_71990_ca;
/* 478 */         if (this.field_70331_k.func_72798_a(this.field_70329_l + x, this.field_70330_m - 6, this.field_70327_n + z) != id) {
/* 479 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 484 */     for (int x = -1; x < 2; x++) {
/* 485 */       for (int z = -1; z < 2; z++) {
/* 486 */         if (this.field_70331_k.func_72798_a(this.field_70329_l + x, this.field_70330_m - 7, this.field_70327_n + z) != Block.field_72007_bm.field_71990_ca) {
/* 487 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 492 */     return this.field_70331_k.func_72937_j(this.field_70329_l, this.field_70330_m + 3, this.field_70327_n);
/*     */   }
/*     */   
/*     */   public int getFuel() {
/* 496 */     if (!hasFuelBlock()) {
/* 497 */       return 0;
/*     */     }
/* 499 */     return getFuelBlock().fuel;
/*     */   }
/*     */   
/*     */   public ItemStack getFuelSlot() {
/* 503 */     if (!hasFuelBlock()) {
/* 504 */       return null;
/*     */     }
/* 506 */     return getFuelBlock().func_70301_a(0);
/*     */   }
/*     */   
/*     */   public ItemStack getResultSlot() {
/* 510 */     if (!hasResultBlock()) {
/* 511 */       return null;
/*     */     }
/* 513 */     return getResultBlock().func_70301_a(0);
/*     */   }
/*     */   
/*     */   public ItemStack getSlagSlot() {
/* 517 */     if (!hasResultBlock()) {
/* 518 */       return null;
/*     */     }
/* 520 */     return getResultBlock().func_70301_a(1);
/*     */   }
/*     */   
/*     */   public boolean interact(EntityPlayer player) {
/* 524 */     if (this.field_70325_p != 0)
/* 525 */       player.openGui(MineFantasyBase.instance, 7, this.field_70331_k, this.field_70329_l, this.field_70330_m, this.field_70327_n);
/* 526 */     return true;
/*     */   }
/*     */   
/*     */   public String getTexture() {
/* 530 */     switch (func_70322_n()) {
/*     */     case 1: 
/* 532 */       return "in";
/*     */     case 2: 
/* 534 */       return "fuel";
/*     */     case 3: 
/* 536 */       return "out";
/*     */     }
/* 538 */     return "";
/*     */   }
/*     */   
/*     */   private boolean isChamberBlock(int x, int y, int z) {
/* 542 */     if (this.field_70331_k.func_72803_f(x + 1, y, z) != Material.field_76246_e)
/* 543 */       return false;
/* 544 */     if (this.field_70331_k.func_72803_f(x - 1, y, z) != Material.field_76246_e)
/* 545 */       return false;
/* 546 */     if (this.field_70331_k.func_72803_f(x, y, z + 1) != Material.field_76246_e)
/* 547 */       return false;
/* 548 */     if (this.field_70331_k.func_72803_f(x, y, z - 1) != Material.field_76246_e) {
/* 549 */       return false;
/*     */     }
/* 551 */     return (this.field_70331_k.func_72798_a(x, y, z) == MineFantasyBase.MFBlockBlast.field_71990_ca) && (this.field_70331_k.func_72805_g(x, y, z) == 0);
/*     */   }
/*     */   
/*     */   public String getDefaultName() {
/* 555 */     switch (func_70322_n()) {
/*     */     case 1: 
/* 557 */       return "container.blastfurn";
/*     */     case 2: 
/* 559 */       return "container.blastfurn.fuel";
/*     */     case 3: 
/* 561 */       return "container.blastfurn.out";
/*     */     }
/* 563 */     return "";
/*     */   }
/*     */   
/*     */   public int func_70297_j_()
/*     */   {
/* 568 */     return 64;
/*     */   }
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer entityplayer) {
/* 572 */     if (getBFurnAt(this.field_70329_l, this.field_70330_m, this.field_70327_n) != this) {
/* 573 */       return false;
/*     */     }
/* 575 */     return entityplayer.func_70092_e(this.field_70329_l + 0.5D, this.field_70330_m + 0.5D, this.field_70327_n + 0.5D) <= 64.0D;
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_70295_k_() {}
/*     */   
/*     */   public void func_70305_f() {}
/*     */   
/*     */   private void sendPacketToClients()
/*     */   {
/* 585 */     if (!this.field_70331_k.field_72995_K) {
/*     */       try {
/* 587 */         Packet packet = PacketManagerMF.getPacketIntegerArray(this, new int[] { this.fuel, this.maxFuel, this.cookTime, this.direction, this.heat });
/* 588 */         FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*     */       } catch (NullPointerException e) {
/* 590 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void setResult(ItemStack item) {
/* 596 */     if (hasResultBlock()) {
/* 597 */       getResultBlock().func_70299_a(0, item);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setSlag(ItemStack item) {
/* 602 */     if (hasResultBlock()) {
/* 603 */       getResultBlock().func_70299_a(1, item);
/*     */     }
/*     */   }
/*     */   
/*     */   public void recievePacket(ByteArrayDataInput data)
/*     */   {
/* 609 */     this.fuel = data.readInt();
/* 610 */     this.maxFuel = data.readInt();
/* 611 */     this.cookTime = data.readInt();
/* 612 */     this.direction = ((byte)data.readInt());
/* 613 */     this.heat = data.readInt();
/*     */   }
/*     */   
/*     */   public boolean isBurning() {
/* 617 */     if (func_70322_n() == 2) {
/* 618 */       return this.heat > 0;
/*     */     }
/* 620 */     if ((func_70322_n() == 1) && 
/* 621 */       (getFuelBlock() != null)) {
/* 622 */       return getFuelBlock().heat > 0;
/*     */     }
/*     */     
/* 625 */     if (this.field_70325_p == 1)
/* 626 */       return this.fuel > 0;
/* 627 */     TileEntityBlastFurnace furn = getBFurnAt(this.field_70329_l, this.field_70330_m + 4, this.field_70327_n);
/* 628 */     if (furn != null) {
/* 629 */       return furn.isBurning();
/*     */     }
/* 631 */     return false;
/*     */   }
/*     */   
/*     */   public int func_70302_i_() {
/* 635 */     return this.inventory.length;
/*     */   }
/*     */   
/*     */   public ItemStack func_70301_a(int i) {
/* 639 */     return this.inventory[i];
/*     */   }
/*     */   
/*     */   public ItemStack func_70298_a(int i, int j) {
/* 643 */     if ((this.inventory[i] != null) && (this.inventory[i].func_77973_b() != null) && 
/* 644 */       (this.inventory[i].func_77973_b().func_77634_r())) {
/* 645 */       this.inventory[i] = this.inventory[i].func_77973_b().getContainerItemStack(this.inventory[i]);
/* 646 */       return this.inventory[i];
/*     */     }
/*     */     
/*     */ 
/* 650 */     if (this.inventory[i] != null) {
/* 651 */       if (this.inventory[i].field_77994_a <= j) {
/* 652 */         ItemStack itemstack = this.inventory[i];
/* 653 */         this.inventory[i] = null;
/* 654 */         return itemstack;
/*     */       }
/* 656 */       ItemStack itemstack1 = this.inventory[i].func_77979_a(j);
/* 657 */       if (this.inventory[i].field_77994_a == 0) {
/* 658 */         this.inventory[i] = null;
/*     */       }
/* 660 */       return itemstack1;
/*     */     }
/* 662 */     return null;
/*     */   }
/*     */   
/*     */   public void func_70299_a(int i, ItemStack itemstack)
/*     */   {
/* 667 */     this.inventory[i] = itemstack;
/* 668 */     if ((itemstack != null) && (itemstack.field_77994_a > func_70297_j_())) {
/* 669 */       itemstack.field_77994_a = func_70297_j_();
/*     */     }
/*     */   }
/*     */   
/*     */   public void incrStackSize(int slot, int num) {
/* 674 */     this.inventory[slot].field_77994_a += num;
/*     */   }
/*     */   
/*     */   public ItemStack func_70304_b(int var1)
/*     */   {
/* 679 */     return null;
/*     */   }
/*     */   
/*     */   public void puffSmoke(int height) {
/* 683 */     Random rand = new Random();
/* 684 */     float dense = getSmokeDensity();
/*     */     
/* 686 */     IChimney chimney = (IChimney)Block.field_71973_m[this.field_70331_k.func_72798_a(this.field_70329_l, this.field_70330_m + 1, this.field_70327_n)];
/* 687 */     if ((chimney == null) || ((chimney != null) && (!chimney.puffSmoke(this.field_70331_k, this.field_70329_l, this.field_70330_m + 1, this.field_70327_n, 0.5F * dense, 1.0F, 1 * height)))) {
/* 688 */       this.field_70331_k.func_72869_a("largesmoke", this.field_70329_l + 0.5F, this.field_70330_m + 1, this.field_70327_n + 0.5F, (rand.nextFloat() - 0.5F) / 2.0F * dense, 0.06499999761581421D, (rand.nextFloat() - 0.5F) / 2.0F * height);
/*     */     }
/*     */   }
/*     */   
/*     */   private float getSmokeDensity() {
/* 693 */     float sc = 1.0F;
/* 694 */     if (getFuelBlock() != null) {
/* 695 */       sc = getFuelBlock().getTempEmitions();
/*     */     }
/*     */     
/* 698 */     return 1.0F * sc;
/*     */   }
/*     */   
/*     */   private TileEntityBlastFurnace getBFurnAt(int x, int y, int z) {
/* 702 */     TileEntity tile = this.field_70331_k.func_72796_p(x, y, z);
/* 703 */     if (tile == null) {
/* 704 */       return null;
/*     */     }
/* 706 */     if ((tile instanceof TileEntityBlastFurnace)) {
/* 707 */       return (TileEntityBlastFurnace)tile;
/*     */     }
/* 709 */     return null;
/*     */   }
/*     */   
/*     */   public float getTempEmitions() {
/* 713 */     if (requiredHeat <= 0) {
/* 714 */       requiredHeat = 1;
/*     */     }
/* 716 */     return this.heat / requiredHeat;
/*     */   }
/*     */   
/*     */   public ForgeDirection getFacing() {
/* 720 */     switch (this.direction) {
/*     */     case 2: 
/* 722 */       return ForgeDirection.NORTH;
/*     */     case 3: 
/* 724 */       return ForgeDirection.SOUTH;
/*     */     case 5: 
/* 726 */       return ForgeDirection.EAST;
/*     */     case 4: 
/* 728 */       return ForgeDirection.WEST;
/*     */     }
/* 730 */     return ForgeDirection.NORTH;
/*     */   }
/*     */   
/*     */   public ForgeDirection getBack() {
/* 734 */     switch (this.direction) {
/*     */     case 2: 
/* 736 */       return ForgeDirection.SOUTH;
/*     */     case 3: 
/* 738 */       return ForgeDirection.NORTH;
/*     */     case 5: 
/* 740 */       return ForgeDirection.WEST;
/*     */     case 4: 
/* 742 */       return ForgeDirection.EAST;
/*     */     }
/* 744 */     return ForgeDirection.NORTH;
/*     */   }
/*     */   
/*     */   public ForgeDirection getLeft() {
/* 748 */     switch (this.direction) {
/*     */     case 2: 
/* 750 */       return ForgeDirection.WEST;
/*     */     case 3: 
/* 752 */       return ForgeDirection.EAST;
/*     */     case 5: 
/* 754 */       return ForgeDirection.NORTH;
/*     */     case 4: 
/* 756 */       return ForgeDirection.SOUTH;
/*     */     }
/* 758 */     return ForgeDirection.NORTH;
/*     */   }
/*     */   
/*     */   public ForgeDirection getRight() {
/* 762 */     switch (this.direction) {
/*     */     case 2: 
/* 764 */       return ForgeDirection.EAST;
/*     */     case 3: 
/* 766 */       return ForgeDirection.WEST;
/*     */     case 5: 
/* 768 */       return ForgeDirection.SOUTH;
/*     */     case 4: 
/* 770 */       return ForgeDirection.NORTH;
/*     */     }
/* 772 */     return ForgeDirection.NORTH;
/*     */   }
/*     */   
/*     */   public boolean func_94041_b(int i, ItemStack itemstack)
/*     */   {
/* 777 */     if (getType() == 1) {
/* 778 */       if (i == 0) {
/* 779 */         return ItemHandler.isCarbon(itemstack);
/*     */       }
/* 781 */       if (i == 1) {
/* 782 */         return ItemHandler.isFlux(itemstack);
/*     */       }
/* 784 */       if (i == 2)
/* 785 */         return BlastRecipes.getResult(itemstack) != null;
/*     */     }
/* 787 */     if (getType() == 2) {
/* 788 */       return getItemBurnTime(itemstack) > 0;
/*     */     }
/* 790 */     return false;
/*     */   }
/*     */   
/*     */   public double getDistanceFromPos(double x, double y, double z) {
/* 794 */     double d3 = this.field_70329_l + 0.5D - x;
/* 795 */     double d4 = this.field_70330_m + 0.5D - y;
/* 796 */     double d5 = this.field_70327_n + 0.5D - z;
/* 797 */     return d3 * d3 + d4 * d4 + d5 * d5;
/*     */   }
/*     */   
/*     */   public int[] func_94128_d(int slot)
/*     */   {
/* 802 */     switch (getType()) {
/*     */     case 0: 
/* 804 */       return null;
/*     */     case 1: 
/* 806 */       return new int[] { 0, 1, 2 };
/*     */     case 3: 
/* 808 */       return new int[] { 0, 1 };
/*     */     }
/* 810 */     return new int[] { 0 };
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_102007_a(int slot, ItemStack item, int side)
/*     */   {
/* 818 */     return func_94041_b(slot, item);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_102008_b(int slot, ItemStack item, int side)
/*     */   {
/* 826 */     if (getType() == 1)
/*     */     {
/* 828 */       if (slot == 2)
/* 829 */         return true;
/*     */     }
/* 831 */     if ((getType() == 2) || (getType() == 3))
/*     */     {
/* 833 */       return side == 0;
/*     */     }
/* 835 */     return true;
/*     */   }
/*     */   
/*     */   public void onUsedWithBellows(float powerLevel)
/*     */   {
/* 840 */     this.bellowsBonus = ((int)(20.0F * powerLevel));
/*     */   }
/*     */   
/*     */ 
/*     */   public void setCustomName(String name)
/*     */   {
/* 846 */     this.customName = name;
/*     */   }
/*     */   
/*     */   public String func_70303_b()
/*     */   {
/* 851 */     return func_94042_c() ? this.customName : getDefaultName();
/*     */   }
/*     */   
/*     */   public boolean func_94042_c()
/*     */   {
/* 856 */     return (this.customName != null) && (this.customName.length() > 0);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/TileEntityBlastFurnace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */