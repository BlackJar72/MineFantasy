/*     */ package minefantasy.client.tile;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.registry.GameRegistry;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.api.IMFCrafter;
/*     */ import minefantasy.api.anvil.AnvilProps;
/*     */ import minefantasy.api.anvil.CraftingManagerAnvil;
/*     */ import minefantasy.api.anvil.IAnvil;
/*     */ import minefantasy.api.anvil.ICustomRepair;
/*     */ import minefantasy.api.anvil.ItemRepairHammer;
/*     */ import minefantasy.api.forge.HeatableItem;
/*     */ import minefantasy.api.hound.IHoundArmour;
/*     */ import minefantasy.api.hound.ItemHoundFeedbag;
/*     */ import minefantasy.api.refine.CrushRecipes;
/*     */ import minefantasy.block.special.BlockAnvilMF;
/*     */ import minefantasy.block.special.BlockClickHelper;
/*     */ import minefantasy.block.special.ItemBlockFurnaceMF;
/*     */ import minefantasy.container.ContainerAnvil;
/*     */ import minefantasy.item.ItemBloom;
/*     */ import minefantasy.item.ItemHotItem;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.item.tool.ItemHammer;
/*     */ import minefantasy.system.AchivementMF;
/*     */ import minefantasy.system.cfg;
/*     */ import minefantasy.system.network.PacketManagerMF;
/*     */ import minefantasy.system.network.PacketUserMF;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryCrafting;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemBlock;
/*     */ import net.minecraft.item.ItemHoe;
/*     */ import net.minecraft.item.ItemPickaxe;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.ItemSword;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.network.packet.Packet;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.server.management.ServerConfigurationManager;
/*     */ import net.minecraft.stats.AchievementList;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ForgeDirection;
/*     */ import net.minecraftforge.oredict.OreDictionary;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TileEntityAnvil
/*     */   extends TileEntity
/*     */   implements IInventory, IAnvil, PacketUserMF, IMFCrafter
/*     */ {
/*  75 */   public static int maxWidth = AnvilProps.globalWidth = 8;
/*  76 */   public static int maxHeight = AnvilProps.globalHeight = 5;
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private ItemStack tempResult;
/*     */   private EntityPlayer smith;
/*  81 */   private int anvilLevel = 0;
/*     */   private boolean hotOut;
/*  83 */   private boolean slagOut = false;
/*  84 */   private int forgeMultiMax = 150;
/*  85 */   public int quality = 100;
/*  86 */   private int peak = 80;
/*     */   private int ticks;
/*     */   private ItemStack[] items;
/*     */   public int forgeTime;
/*     */   private int cool;
/*     */   public int direction;
/*  92 */   private Random rand = new Random();
/*  93 */   private int maxForgeTime = 200;
/*  94 */   private int maxForgeMultiplier = 2;
/*     */   
/*     */   private int forgeMulti;
/*     */   private int craftLevel;
/*     */   public int itemMetadata;
/*     */   public boolean fromItemRenderer;
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int gridTime;
/*     */   private Object recipe;
/*     */   private int canCraft;
/*     */   private int canFit;
/*     */   
/*     */   public TileEntityAnvil()
/*     */   {
/* 108 */     this.items = new ItemStack[maxWidth * maxHeight + 1];
/*     */   }
/*     */   
/*     */   public TileEntityAnvil(int metadata) {
/* 112 */     this.itemMetadata = metadata;
/*     */   }
/*     */   
/*     */   public TileEntityAnvil(int metadata, boolean fromItemRenderer) {
/* 116 */     this.itemMetadata = metadata;
/* 117 */     this.fromItemRenderer = fromItemRenderer;
/*     */   }
/*     */   
/*     */   public int[] gridSize() {
/* 121 */     if (isBig()) {
/* 122 */       return new int[] { 8, 5 };
/*     */     }
/* 124 */     return new int[] { 5, 4 };
/*     */   }
/*     */   
/*     */   public int func_70302_i_()
/*     */   {
/* 129 */     return this.items.length;
/*     */   }
/*     */   
/*     */   public ItemStack func_70301_a(int slot)
/*     */   {
/* 134 */     return this.items[slot];
/*     */   }
/*     */   
/*     */   public void func_70307_a(NBTTagCompound tag)
/*     */   {
/* 139 */     super.func_70307_a(tag);
/* 140 */     this.slagOut = tag.func_74767_n("Slag");
/*     */     
/* 142 */     NBTTagList var2 = tag.func_74761_m("Items");
/* 143 */     this.items = new ItemStack[func_70302_i_()];
/*     */     
/* 145 */     for (int var3 = 0; var3 < var2.func_74745_c(); var3++) {
/* 146 */       NBTTagCompound var4 = (NBTTagCompound)var2.func_74743_b(var3);
/* 147 */       byte var5 = var4.func_74771_c("Slot");
/*     */       
/* 149 */       if ((var5 >= 0) && (var5 < this.items.length)) {
/* 150 */         this.items[var5] = ItemStack.func_77949_a(var4);
/*     */       }
/*     */     }
/*     */     
/* 154 */     this.direction = tag.func_74762_e("Dir");
/* 155 */     if (tag.func_74764_b("quality")) {
/* 156 */       this.quality = tag.func_74762_e("quality");
/*     */     }
/*     */     
/* 159 */     this.forgeTime = tag.func_74762_e("Forge");
/* 160 */     this.maxForgeTime = tag.func_74762_e("ForgeMax");
/* 161 */     if (tag.func_74764_b("CustomName")) {
/* 162 */       this.customName = tag.func_74779_i("CustomName");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_70310_b(NBTTagCompound tag)
/*     */   {
/* 171 */     super.func_70310_b(tag);
/* 172 */     tag.func_74757_a("Slag", this.slagOut);
/* 173 */     NBTTagList var2 = new NBTTagList();
/*     */     
/* 175 */     tag.func_74768_a("Dir", this.direction);
/* 176 */     tag.func_74768_a("quality", this.quality);
/*     */     
/* 178 */     for (int var3 = 0; var3 < this.items.length; var3++) {
/* 179 */       if (this.items[var3] != null) {
/* 180 */         NBTTagCompound var4 = new NBTTagCompound();
/* 181 */         var4.func_74774_a("Slot", (byte)var3);
/* 182 */         this.items[var3].func_77955_b(var4);
/* 183 */         var2.func_74742_a(var4);
/*     */       }
/*     */     }
/*     */     
/* 187 */     tag.func_74782_a("Items", var2);
/* 188 */     tag.func_74768_a("Forge", this.forgeTime);
/* 189 */     tag.func_74768_a("ForgeMax", this.maxForgeTime);
/* 190 */     if (this.customName != null) {
/* 191 */       tag.func_74778_a("CustomName", this.customName);
/*     */     }
/*     */   }
/*     */   
/*     */   public int getForgeProgressScaled(int width) {
/* 196 */     return this.forgeTime * width / (this.maxForgeTime * this.maxForgeMultiplier);
/*     */   }
/*     */   
/*     */   public int getQualityPosScaled(int x, int width) {
/* 200 */     return x * width / 100;
/*     */   }
/*     */   
/*     */   public boolean repair(float effectivness, boolean enchant, float max, boolean reset) {
/* 204 */     if (this.field_70331_k.field_72995_K) {
/* 205 */       return false;
/*     */     }
/* 207 */     float timing = this.forgeMulti / 150;
/* 208 */     effectivness *= timing;
/* 209 */     Random rand = new Random();
/* 210 */     for (ItemStack repair : this.items) {
/* 211 */       if (repair != null) {
/* 212 */         int min = (int)(repair.func_77958_k() * (1.0F - max));
/* 213 */         if ((repair.field_77993_c == Block.field_82510_ck.field_71990_ca) && 
/* 214 */           (repair.func_77960_j() > 0) && (repair.field_77994_a == 1)) {
/* 215 */           int lvl = (int)((rand.nextInt(40) + 20) * effectivness);
/* 216 */           if (rand.nextInt(200) < lvl) {
/* 217 */             int d = repair.func_77960_j();
/* 218 */             repair.func_77964_b(d - 1);
/*     */           }
/* 220 */           if (reset)
/* 221 */             this.forgeMulti = 1;
/* 222 */           if ((MineFantasyBase.isDebug()) && 
/* 223 */             (!this.field_70331_k.field_72995_K)) {
/* 224 */             System.out.println("Repair: " + lvl);
/*     */           }
/*     */           
/* 227 */           return true;
/*     */         }
/*     */         
/* 230 */         if ((repair.field_77994_a == 1) && (!(repair.func_77973_b() instanceof ItemHammer)) && (!(repair.func_77973_b() instanceof ItemRepairHammer))) {
/* 231 */           boolean canRepair = (enchant) || (!needsOrnate(repair));
/* 232 */           int lvl = (int)((rand.nextInt(40) + 20) * effectivness);
/* 233 */           if (((repair.func_77973_b() instanceof ItemArmor)) || ((repair.func_77973_b() instanceof IHoundArmour))) {
/* 234 */             lvl = lvl / 5 + 1;
/*     */           }
/* 236 */           if ((repair.func_77973_b() instanceof ICustomRepair)) {
/* 237 */             lvl = (int)(lvl * ((ICustomRepair)repair.func_77973_b()).getRepairValue());
/*     */           }
/* 239 */           if ((repair.func_77960_j() > min) && (repair.func_77951_h()) && (repair.func_77984_f()) && (canRepair) && (canRepair(repair))) {
/* 240 */             repair.func_77964_b(repair.func_77960_j() - lvl);
/* 241 */             if (repair.func_77960_j() < 0)
/* 242 */               repair.func_77964_b(0);
/* 243 */             if (reset)
/* 244 */               this.forgeMulti = 1;
/* 245 */             if ((MineFantasyBase.isDebug()) && 
/* 246 */               (!this.field_70331_k.field_72995_K)) {
/* 247 */               System.out.println("Repair: " + lvl);
/* 248 */               System.out.println("Durability: " + (repair.func_77958_k() - repair.func_77960_j()) + " / " + repair.func_77958_k() + " (M: " + (repair.func_77958_k() - min) + ")");
/*     */             }
/*     */             
/* 251 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 256 */     if (reset)
/* 257 */       this.forgeMulti = 1;
/* 258 */     return false;
/*     */   }
/*     */   
/*     */   private boolean canRepair(ItemStack repair) {
/* 262 */     if ((repair.func_77973_b() instanceof ItemHoundFeedbag)) {
/* 263 */       return false;
/*     */     }
/* 265 */     return true;
/*     */   }
/*     */   
/*     */   private boolean needsOrnate(ItemStack repair) {
/* 269 */     if (repair == null) {
/* 270 */       return false;
/*     */     }
/* 272 */     if (repair.func_77948_v()) {
/* 273 */       return true;
/*     */     }
/* 275 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int getRepairHammerMetre(int width) {
/* 280 */     return (int)(width * getRepairHammer());
/*     */   }
/*     */   
/*     */   public boolean hitWithHammer(EntityPlayer player, int l, float power, int hitStr) {
/* 284 */     func_70296_d();
/* 285 */     if (!cfg.advancedAnvil) {
/* 286 */       hitStr = 1;
/*     */     }
/*     */     
/* 289 */     if (!canCraft())
/* 290 */       return false;
/* 291 */     if (this.field_70331_k.field_72995_K) {
/* 292 */       return false;
/*     */     }
/* 294 */     if ((canPlayerCraft(player)) && (this.craftLevel <= l) && (canFitResult()) && (this.anvilLevel <= getAnvilTier()))
/*     */     {
/* 296 */       if (player.field_71075_bZ.field_75098_d) {
/* 297 */         this.quality = 100;
/* 298 */         this.smith = player;
/* 299 */         craft();
/* 300 */         return true;
/*     */       }
/* 302 */       if (cfg.advancedAnvil) {
/* 303 */         if (hitStr == 0) {
/* 304 */           this.quality += this.forgeMulti / 16;
/* 305 */           if (this.quality > 100) {
/* 306 */             this.quality = 100;
/*     */           }
/*     */         }
/* 309 */         if (hitStr == 1) {
/* 310 */           int m = Math.max(30, this.forgeMulti);
/* 311 */           this.quality -= m / 16;
/* 312 */           if (this.quality <= 0) {
/* 313 */             this.quality = 100;
/*     */             
/* 315 */             if (canCraft()) {
/* 316 */               ItemStack res = getResult();
/* 317 */               this.field_70331_k.func_72980_b(this.field_70329_l + 0.5D, this.field_70330_m, this.field_70327_n + 0.5D, "random.break", 1.0F, 1.0F, true);
/* 318 */               this.field_70331_k.func_72980_b(this.field_70329_l + 0.5D, this.field_70330_m, this.field_70327_n + 0.5D, "random.break", 1.0F, 1.0F, false);
/*     */               
/* 320 */               if (this.smith != null) {
/* 321 */                 this.smith.func_70669_a(res);
/*     */               }
/*     */               
/* 324 */               decreseAll();
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 330 */       if (cfg.advancedAnvil) {
/* 331 */         power += 1.0F;
/*     */       }
/* 333 */       if (hitStr == 0) {
/* 334 */         power /= 4.0F;
/*     */       }
/*     */       
/* 337 */       this.forgeTime = ((int)(this.forgeTime + this.forgeMulti * power));
/* 338 */       this.smith = player;
/* 339 */       this.forgeMulti = 1;
/* 340 */       this.cool = 5;
/*     */       
/*     */ 
/* 343 */       return true;
/*     */     }
/* 345 */     return false;
/*     */   }
/*     */   
/*     */   public int getQualityPeak() {
/* 349 */     return this.peak;
/*     */   }
/*     */   
/*     */   private boolean canPlayerCraft(EntityPlayer player) {
/* 353 */     return true;
/*     */   }
/*     */   
/*     */   public ItemStack func_70298_a(int slot, int ammount)
/*     */   {
/* 358 */     func_70296_d();
/* 359 */     if (this.items[slot] != null)
/*     */     {
/*     */ 
/* 362 */       if (this.items[slot].field_77994_a <= ammount) {
/* 363 */         ItemStack var3 = this.items[slot];
/* 364 */         this.items[slot] = null;
/* 365 */         return var3;
/*     */       }
/* 367 */       ItemStack var3 = this.items[slot].func_77979_a(ammount);
/*     */       
/* 369 */       if (this.items[slot].field_77994_a == 0) {
/* 370 */         this.items[slot] = null;
/*     */       }
/*     */       
/* 373 */       return var3;
/*     */     }
/*     */     
/* 376 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public ItemStack func_70304_b(int slot)
/*     */   {
/* 382 */     if (this.items[slot] != null) {
/* 383 */       ItemStack var2 = this.items[slot];
/* 384 */       this.items[slot] = null;
/* 385 */       return var2;
/*     */     }
/* 387 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_70316_g()
/*     */   {
/* 393 */     super.func_70316_g();
/*     */     
/* 395 */     if ((this.field_70331_k.field_72995_K) && 
/* 396 */       (this.gridTime > 0)) {
/* 397 */       this.gridTime -= 1;
/*     */     }
/* 399 */     if (!this.field_70331_k.field_72995_K) {
/* 400 */       this.canCraft = (canCraft() ? 1 : 0);
/* 401 */       this.canFit = (canFitResult() ? 1 : 0);
/* 402 */       if (this.ticks % 20 == 0) {
/* 403 */         updateInv();
/*     */       }
/*     */       
/* 406 */       this.ticks += 1;
/* 407 */       this.cool -= 1;
/* 408 */       if (this.forgeTime >= this.maxForgeTime * this.maxForgeMultiplier) {
/* 409 */         this.forgeTime = 0;
/* 410 */         craft();
/* 411 */         this.quality = 100;
/*     */       }
/*     */       
/* 414 */       if ((this.forgeMulti < this.forgeMultiMax) && (this.cool <= 0)) {
/* 415 */         this.forgeMulti += 10;
/*     */       }
/*     */       
/* 418 */       this.peak = (80 + this.field_70331_k.field_73013_u * 5);
/* 419 */       if (!canCraft()) {
/* 420 */         this.quality = 100;
/*     */       }
/* 422 */       sendPacketToClients();
/*     */     }
/*     */   }
/*     */   
/*     */   private void updateInv() {
/* 427 */     if (!this.field_70331_k.field_72995_K) {
/* 428 */       this.recipe = getResult();
/* 429 */       syncItems();
/*     */       
/* 431 */       if ((!canCraft()) && (this.forgeTime > 0)) {
/* 432 */         this.forgeTime = 0;
/* 433 */         this.quality = 100;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70299_a(int slot, ItemStack itemstack)
/*     */   {
/* 440 */     func_70296_d();
/* 441 */     this.items[slot] = itemstack;
/*     */     
/* 443 */     if ((itemstack != null) && (itemstack.field_77994_a > func_70297_j_())) {
/* 444 */       itemstack.field_77994_a = func_70297_j_();
/*     */     }
/*     */   }
/*     */   
/*     */   public int func_70297_j_()
/*     */   {
/* 450 */     return 64;
/*     */   }
/*     */   
/*     */   private void sendPacketToClients() {
/* 454 */     if (!this.field_70331_k.field_72995_K) {
/* 455 */       Packet packet = PacketManagerMF.getPacketIntegerArray(this, new int[] { 0, this.forgeTime, this.maxForgeTime, this.forgeMulti, this.direction, this.quality, this.peak, this.canCraft, this.canFit });
/*     */       try {
/* 457 */         FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*     */       } catch (NullPointerException e) {
/* 459 */         System.out.println("MineFantasy: Client connection lost");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void syncItems() {
/* 465 */     if (!this.field_70331_k.field_72995_K) {
/* 466 */       for (int a = 0; a < this.items.length; a++) {
/* 467 */         Packet packet = PacketManagerMF.getPacketItemStackArray(this, a, this.items[a]);
/*     */         try {
/* 469 */           FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*     */         } catch (NullPointerException e) {
/* 471 */           System.out.println("MineFantasy: Client connection lost");
/* 472 */           return;
/*     */         }
/*     */       }
/* 475 */       Packet packet2 = PacketManagerMF.getPacketMFResult(this, getResult());
/*     */       try {
/* 477 */         FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet2);
/*     */       } catch (NullPointerException e) {
/* 479 */         System.out.println("MineFantasy: Client connection lost");
/* 480 */         return;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer player)
/*     */   {
/* 487 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70295_k_() {}
/*     */   
/*     */ 
/*     */   public void func_70305_f() {}
/*     */   
/*     */ 
/*     */   private void craft()
/*     */   {
/* 500 */     if (getResult() == null) {
/* 501 */       return;
/*     */     }
/*     */     
/* 504 */     ItemStack result = getResult().func_77946_l();
/* 505 */     if (result != null) {
/* 506 */       if (this.smith != null) {
/* 507 */         this.smith.func_71064_a(AchivementMF.AchievementForged, 1);
/* 508 */         GameRegistry.onItemCrafted(this.smith, result, this);
/*     */         
/* 510 */         result = modifyResult(result);
/*     */         
/* 512 */         if ((result.func_77973_b() instanceof ItemPickaxe)) {
/* 513 */           this.smith.func_71064_a(AchievementList.field_76012_o, 1);
/*     */         }
/* 515 */         if ((result.func_77973_b() instanceof ItemHoe)) {
/* 516 */           this.smith.func_71064_a(AchievementList.field_76013_l, 1);
/*     */         }
/* 518 */         if ((result.func_77973_b() instanceof ItemSword)) {
/* 519 */           this.smith.func_71064_a(AchievementList.field_76024_r, 1);
/*     */         }
/* 521 */         if ((result.func_77973_b() instanceof ItemBlockFurnaceMF)) {
/* 522 */           this.smith.func_71064_a(AchievementList.field_76015_j, 1);
/*     */         }
/*     */         
/* 525 */         for (ItemStack copper : OreDictionary.getOres("ingotCopper")) {
/* 526 */           if ((result.field_77993_c == copper.field_77993_c) && (
/* 527 */             (copper.func_77960_j() == 32767) || (copper.func_77960_j() == result.func_77960_j())))
/* 528 */             this.smith.func_71064_a(AchivementMF.AchievementCopper, 1);
/*     */         }
/* 530 */         for (ItemStack tin : OreDictionary.getOres("ingotTin")) {
/* 531 */           if ((result.field_77993_c == tin.field_77993_c) && (
/* 532 */             (tin.func_77960_j() == 32767) || (tin.func_77960_j() == result.func_77960_j())))
/* 533 */             this.smith.func_71064_a(AchivementMF.AchievementTin, 1);
/*     */         }
/*     */       }
/* 536 */       if ((this.slagOut) && 
/* 537 */         (this.field_70331_k != null) && (!this.field_70331_k.field_72995_K)) {
/* 538 */         for (int a = 0; a < this.rand.nextInt(3) + 1; a++) {
/* 539 */           EntityItem item = new EntityItem(this.field_70331_k, this.field_70329_l + 0.5D, this.field_70330_m + 1.0D, this.field_70327_n + 0.5D, new ItemStack(ItemListMF.misc, 1, 12));
/* 540 */           this.field_70331_k.func_72838_d(item);
/*     */         }
/*     */       }
/*     */       
/* 544 */       result = damageResult(result);
/* 545 */       if (heatOutput(result)) {
/* 546 */         ItemStack out = result.func_77946_l();
/* 547 */         result = ItemHotItem.createHotItem(out, false);
/* 548 */         result.field_77994_a = out.field_77994_a;
/*     */       }
/*     */       
/* 551 */       if (this.items[getGridSize()] == null) {
/* 552 */         decreseAll();
/* 553 */         func_70299_a(getGridSize(), result);
/* 554 */       } else if ((this.items[getGridSize()] != null) && (this.items[getGridSize()].func_77969_a(result))) {
/* 555 */         int c = this.items[getGridSize()].field_77994_a + result.field_77994_a;
/* 556 */         if (c <= this.items[getGridSize()].func_77976_d()) {
/* 557 */           decreseAll();
/* 558 */           this.items[getGridSize()].field_77994_a += result.field_77994_a;
/*     */         }
/*     */       }
/*     */     }
/* 562 */     func_70296_d();
/* 563 */     this.quality = 100;
/*     */   }
/*     */   
/*     */   private ItemStack damageResult(ItemStack result) {
/* 567 */     if (this.field_70331_k.field_72995_K) {
/* 568 */       return result;
/*     */     }
/* 570 */     int peak = getQualityPeak();
/*     */     
/* 572 */     if ((cfg.advancedAnvil) && (result.func_77984_f())) {
/* 573 */       int max = result.func_77958_k();
/* 574 */       float lvl = peak - this.quality;
/* 575 */       if (lvl < 0.0F) {
/* 576 */         lvl = 0.0F;
/*     */       }
/* 578 */       int damage = (int)(max * (lvl / peak));
/* 579 */       result.func_77964_b(damage);
/*     */     }
/* 581 */     return result;
/*     */   }
/*     */   
/*     */   private boolean heatOutput(ItemStack result) {
/* 585 */     if (MineFantasyBase.isDebug()) {
/* 586 */       return false;
/*     */     }
/* 588 */     if (result == null)
/* 589 */       return false;
/* 590 */     if ((result.func_77973_b() instanceof ItemBlock)) {
/* 591 */       return false;
/*     */     }
/* 593 */     return this.hotOut;
/*     */   }
/*     */   
/*     */   private ItemStack modifyResult(ItemStack result) {
/* 597 */     Random rand = new Random();
/*     */     
/* 599 */     if (EnchantmentHelper.func_77517_e(this.smith) <= 0) {
/* 600 */       return result;
/*     */     }
/* 602 */     int fortune = rand.nextInt(EnchantmentHelper.func_77517_e(this.smith) + 1);
/*     */     
/* 604 */     int stack = fortune * (64 / result.field_77994_a) / 8;
/*     */     
/* 606 */     int ss = result.field_77994_a + stack > 64 ? 64 : result.field_77994_a + stack;
/*     */     
/* 608 */     int add = result.func_77958_k() / 20 * fortune;
/*     */     
/* 610 */     if (result.func_77985_e()) {
/* 611 */       result.field_77994_a = ss;
/*     */     }
/* 613 */     if (result.func_77984_f())
/* 614 */       result.func_77964_b(-add);
/* 615 */     return result;
/*     */   }
/*     */   
/*     */   public int getGridSize() {
/* 619 */     return gridSize()[0] * gridSize()[1];
/*     */   }
/*     */   
/*     */   public boolean canCraft() {
/* 623 */     if (this.field_70331_k.field_72995_K) {
/* 624 */       return this.canCraft == 1;
/*     */     }
/* 626 */     return this.recipe != null;
/*     */   }
/*     */   
/*     */   public ItemStack getResult() {
/* 630 */     if (this.field_70331_k.field_72995_K) {
/* 631 */       return null;
/*     */     }
/*     */     
/* 634 */     if (this.ticks <= 1) {
/* 635 */       return null;
/*     */     }
/* 637 */     ContainerAnvil container = new ContainerAnvil(this);
/* 638 */     InventoryCrafting craft = new InventoryCrafting(container, gridSize()[0], gridSize()[1]);
/* 639 */     for (int a = 0; a < getGridSize(); a++) {
/* 640 */       craft.func_70299_a(a, this.items[a]);
/*     */     }
/* 642 */     if (getCrushRecipe() != null) {
/* 643 */       this.craftLevel = 0;
/* 644 */       this.hotOut = false;
/* 645 */       this.anvilLevel = 0;
/* 646 */       this.maxForgeTime = 200;
/* 647 */       return getCrushRecipe();
/*     */     }
/*     */     
/* 650 */     return CraftingManagerAnvil.getInstance().findMatchingRecipe(this, craft);
/*     */   }
/*     */   
/*     */   private ItemStack getCrushRecipe() {
/* 654 */     ItemStack in = null;
/* 655 */     for (int a = 0; a < getGridSize(); a++) {
/* 656 */       if (this.items[a] != null) {
/* 657 */         if (in != null) {
/* 658 */           return null;
/*     */         }
/* 660 */         in = this.items[a];
/*     */       }
/*     */     }
/* 663 */     if (HeatableItem.canHeatItem(in)) {
/* 664 */       return null;
/*     */     }
/* 666 */     if ((in != null) && (in.field_77993_c == ItemListMF.hotItem.field_77779_bT)) {
/* 667 */       if (!TileEntityForge.isProperlyHeated(in)) {
/* 668 */         return null;
/*     */       }
/* 670 */       in = ItemHotItem.getItem(in);
/*     */     }
/* 672 */     if ((in != null) && ((in.func_77973_b() instanceof ItemBloom))) {
/* 673 */       this.hotOut = true;
/* 674 */       this.slagOut = true;
/*     */     } else {
/* 676 */       this.slagOut = false;
/*     */     }
/* 678 */     return CrushRecipes.getResult(in);
/*     */   }
/*     */   
/*     */   private void decreseAll() {
/* 682 */     if ((this.smith != null) && 
/* 683 */       (this.smith.field_71075_bZ.field_75098_d) && (MineFantasyBase.isDebug())) {
/* 684 */       return;
/*     */     }
/*     */     
/*     */ 
/* 688 */     int fortune = 0;
/* 689 */     Random rand = new Random();
/* 690 */     if (this.smith != null) {
/* 691 */       fortune = EnchantmentHelper.func_77517_e(this.smith);
/*     */     }
/* 693 */     for (int s = 0; s < getGridSize(); s++)
/*     */     {
/* 695 */       if (rand.nextInt(25) >= fortune)
/* 696 */         func_70298_a(s, 1);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean isSilver(ItemStack itemStack) {
/* 701 */     ArrayList<ItemStack> list = OreDictionary.getOres("ingotSilver");
/* 702 */     for (int i = 0; i < list.size(); i++) {
/* 703 */       ItemStack ore = (ItemStack)list.get(i);
/* 704 */       if (ore.func_77969_a(itemStack))
/* 705 */         return true;
/*     */     }
/* 707 */     return false;
/*     */   }
/*     */   
/*     */   public void setForgeTime(int i)
/*     */   {
/* 712 */     this.maxForgeTime = i;
/*     */   }
/*     */   
/*     */   public void setHammerUsed(int i)
/*     */   {
/* 717 */     this.craftLevel = i;
/*     */   }
/*     */   
/*     */   public void setHotOutput(boolean i)
/*     */   {
/* 722 */     this.hotOut = i;
/*     */   }
/*     */   
/*     */   public int getCraftLevel() {
/* 726 */     return this.craftLevel;
/*     */   }
/*     */   
/*     */   public void recievePacket(ByteArrayDataInput data)
/*     */   {
/* 731 */     int id = data.readInt();
/*     */     
/* 733 */     if (id == 0) {
/* 734 */       this.forgeTime = data.readInt();
/* 735 */       this.maxForgeTime = data.readInt();
/* 736 */       this.forgeMulti = data.readInt();
/* 737 */       this.direction = data.readInt();
/* 738 */       this.quality = data.readInt();
/* 739 */       this.peak = data.readInt();
/* 740 */       this.canCraft = data.readInt();
/* 741 */       this.canFit = data.readInt();
/* 742 */       return;
/*     */     }
/* 744 */     if (id == 1) {
/* 745 */       int p = data.readInt();
/* 746 */       int i = data.readInt();
/* 747 */       int slot = data.readInt();
/*     */       
/* 749 */       Entity e = this.field_70331_k.func_73045_a(p);
/*     */       
/* 751 */       if ((e != null) && ((e instanceof EntityPlayer))) {
/* 752 */         BlockAnvilMF.useInventory(this.field_70331_k, this.field_70329_l, this.field_70330_m, this.field_70327_n, this, (EntityPlayer)e, i, slot);
/*     */       }
/* 754 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean canFitResult()
/*     */   {
/* 760 */     if (this.field_70331_k.field_72995_K) {
/* 761 */       return this.canFit == 1;
/*     */     }
/*     */     
/* 764 */     ItemStack slot = this.items[getGridSize()];
/* 765 */     ItemStack result = getResult();
/* 766 */     if (slot == null)
/* 767 */       return true;
/* 768 */     if (result == null)
/* 769 */       return false;
/* 770 */     if (!result.func_77969_a(slot))
/* 771 */       return false;
/* 772 */     int ss = slot.field_77994_a;
/* 773 */     int rs = result.field_77994_a;
/* 774 */     int sm = slot.func_77976_d() - ss;
/* 775 */     return rs <= sm;
/*     */   }
/*     */   
/*     */   public int func_70322_n() {
/* 779 */     if (this.field_70331_k == null) {
/* 780 */       return this.itemMetadata;
/*     */     }
/* 782 */     return super.func_70322_n();
/*     */   }
/*     */   
/*     */   public void setRequiredAnvil(int i)
/*     */   {
/* 787 */     this.anvilLevel = i;
/*     */   }
/*     */   
/*     */   public boolean func_94041_b(int i, ItemStack itemstack)
/*     */   {
/* 792 */     return false;
/*     */   }
/*     */   
/*     */   public String getGui() {
/* 796 */     return isBig() ? "anvilArtisan" : "anvil";
/*     */   }
/*     */   
/*     */   public int[][] getPositions() {
/* 800 */     if (isBig()) {
/* 801 */       return new int[][] { { 17, 8 }, { 80, 102 }, { 8, 123 } };
/*     */     }
/* 803 */     return new int[][] { { 8, 8 }, { 144, 35 }, { 8, 84 } };
/*     */   }
/*     */   
/*     */   public ItemStack getResultSlot() {
/* 807 */     return func_70301_a(getGridSize());
/*     */   }
/*     */   
/*     */   public EntityPlayer getSmith() {
/* 811 */     return this.smith;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getAnvilTier()
/*     */   {
/* 819 */     int meta = func_70322_n();
/*     */     
/* 821 */     return anvils[meta][1];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isBig()
/*     */   {
/* 828 */     int meta = func_70322_n();
/* 829 */     return anvils[meta][0] == 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 835 */   public static int[][] anvils = { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 0, 2 }, { 1, 2 }, { 0, 3 }, { 1, 3 }, { 0, 4 }, { 1, 4 } };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String customName;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getSlotFor(float x, float y)
/*     */   {
/* 847 */     ForgeDirection FD = BlockClickHelper.FD[this.direction];
/*     */     
/* 849 */     if ((FD == ForgeDirection.EAST) || (FD == ForgeDirection.WEST)) {
/* 850 */       return getSlotForEW(x, y);
/*     */     }
/* 852 */     return getSlotForNS(x, y);
/*     */   }
/*     */   
/*     */   public int getSlotForNS(float x, float y) {
/* 856 */     int sizeX = gridSize()[0];
/* 857 */     int sizeY = gridSize()[1];
/*     */     
/* 859 */     float x1 = 0.1875F;
/* 860 */     float x2 = 0.8125F;
/* 861 */     float y1 = 0.25F;
/* 862 */     float y2 = 0.75F;
/*     */     
/* 864 */     if (!isBig()) {
/* 865 */       x1 = 0.265625F;
/* 866 */       x2 = 0.734375F;
/* 867 */       y1 = 0.3125F;
/* 868 */       y2 = 0.6875F;
/*     */     }
/*     */     
/* 871 */     int[] coord = BlockClickHelper.getCoordsFor(x, y, x1, x2, y1, y2, sizeX, sizeY, this.direction);
/*     */     
/* 873 */     if (coord == null) {
/* 874 */       return -1;
/*     */     }
/* 876 */     if (coord[0] >= sizeX)
/* 877 */       coord[0] = (sizeX - 1);
/* 878 */     if (coord[1] >= sizeY) {
/* 879 */       coord[1] = (sizeY - 1);
/*     */     }
/* 881 */     return coord[0] + coord[1] * sizeX;
/*     */   }
/*     */   
/*     */   public int getSlotForEW(float x, float y) {
/* 885 */     int sizeX = gridSize()[0];
/* 886 */     int sizeY = gridSize()[1];
/*     */     
/* 888 */     float x1 = 0.25F;
/* 889 */     float x2 = 0.75F;
/* 890 */     float y1 = 0.1875F;
/* 891 */     float y2 = 0.8125F;
/*     */     
/* 893 */     if (!isBig()) {
/* 894 */       x1 = 0.3125F;
/* 895 */       x2 = 0.6875F;
/* 896 */       y1 = 0.265625F;
/* 897 */       y2 = 0.734375F;
/*     */     }
/*     */     
/* 900 */     int[] coord = BlockClickHelper.getCoordsFor(x, y, x1, x2, y1, y2, sizeY, sizeX, this.direction);
/*     */     
/* 902 */     if (coord == null) {
/* 903 */       return -1;
/*     */     }
/* 905 */     if (coord[0] >= sizeX)
/* 906 */       coord[0] = (sizeX - 1);
/* 907 */     if (coord[1] >= sizeY) {
/* 908 */       coord[1] = (sizeY - 1);
/*     */     }
/* 910 */     return coord[0] + coord[1] * sizeX;
/*     */   }
/*     */   
/*     */   public void func_70296_d()
/*     */   {
/* 915 */     updateInv();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean shouldRenderCraftMetre()
/*     */   {
/* 921 */     return canCraft();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int getProgressBar(int i)
/*     */   {
/* 927 */     return getForgeProgressScaled(i);
/*     */   }
/*     */   
/*     */   public boolean isItem3D(ItemStack itemstack) {
/* 931 */     if ((itemstack == null) || (itemstack.func_77973_b() == null) || ((itemstack.func_77973_b() instanceof ItemBlock))) {
/* 932 */       return false;
/*     */     }
/* 934 */     if (itemstack.field_77993_c == ItemListMF.hotItem.field_77779_bT) {
/* 935 */       ItemStack item = ItemHotItem.getItem(itemstack);
/* 936 */       return isItem3D(item);
/*     */     }
/* 938 */     return itemstack.func_77973_b().func_77662_d();
/*     */   }
/*     */   
/*     */   public float getItemRotate(ItemStack itemstack) {
/* 942 */     if ((itemstack == null) || (itemstack.func_77973_b() == null) || ((itemstack.func_77973_b() instanceof ItemBlock))) {
/* 943 */       return 45.0F;
/*     */     }
/* 945 */     if (itemstack.field_77993_c == ItemListMF.hotItem.field_77779_bT) {
/* 946 */       ItemStack item = ItemHotItem.getItem(itemstack);
/* 947 */       return getItemRotate(item);
/*     */     }
/* 949 */     return 45.0F;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setCustomName(String name)
/*     */   {
/* 955 */     this.customName = name;
/*     */   }
/*     */   
/*     */   public String func_70303_b()
/*     */   {
/* 960 */     return func_94042_c() ? this.customName : "container.mfAnvil";
/*     */   }
/*     */   
/*     */   public boolean func_94042_c()
/*     */   {
/* 965 */     return (this.customName != null) && (this.customName.length() > 0);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private float getRepairHammer() {
/* 970 */     if (!this.field_70331_k.field_72995_K) {
/* 971 */       return 0.0F;
/*     */     }
/* 973 */     EntityPlayer player = Minecraft.func_71410_x().field_71439_g;
/* 974 */     if ((player != null) && (player.func_70694_bm() != null) && 
/* 975 */       ((player.func_70694_bm().func_77973_b() instanceof ItemRepairHammer))) {
/* 976 */       return ((ItemRepairHammer)player.func_70694_bm().func_77973_b()).maxRepair;
/*     */     }
/*     */     
/* 979 */     return 0.0F;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getResultName()
/*     */   {
/* 985 */     if (this.field_70331_k.field_72995_K) {
/* 986 */       return this.tempResult != null ? this.tempResult.func_82833_r() : "";
/*     */     }
/* 988 */     return "";
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void setTempResult(ItemStack item)
/*     */   {
/* 994 */     this.tempResult = item;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/TileEntityAnvil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */