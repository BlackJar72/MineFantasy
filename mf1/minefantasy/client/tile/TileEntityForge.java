/*      */ package minefantasy.client.tile;
/*      */ 
/*      */ import com.google.common.io.ByteArrayDataInput;
/*      */ import cpw.mods.fml.common.FMLCommonHandler;
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import java.io.PrintStream;
/*      */ import java.util.Random;
/*      */ import minefantasy.MineFantasyBase;
/*      */ import minefantasy.api.IMFCrafter;
/*      */ import minefantasy.api.aesthetic.IChimney;
/*      */ import minefantasy.api.cooking.IHeatSource;
/*      */ import minefantasy.api.forge.HeatableItem;
/*      */ import minefantasy.api.forge.IBellowsUseable;
/*      */ import minefantasy.api.forge.ItemHandler;
/*      */ import minefantasy.block.special.BlockClickHelper;
/*      */ import minefantasy.block.special.BlockForge;
/*      */ import minefantasy.item.ItemHotItem;
/*      */ import minefantasy.item.ItemListMF;
/*      */ import minefantasy.system.cfg;
/*      */ import minefantasy.system.network.PacketManagerMF;
/*      */ import minefantasy.system.network.PacketUserMF;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.block.material.Material;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.inventory.IInventory;
/*      */ import net.minecraft.inventory.ISidedInventory;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.nbt.NBTTagList;
/*      */ import net.minecraft.network.packet.Packet;
/*      */ import net.minecraft.server.MinecraftServer;
/*      */ import net.minecraft.server.management.ServerConfigurationManager;
/*      */ import net.minecraft.tileentity.TileEntity;
/*      */ import net.minecraft.util.StatCollector;
/*      */ import net.minecraft.world.World;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class TileEntityForge
/*      */   extends TileEntity
/*      */   implements IMFCrafter, IBellowsUseable, IInventory, PacketUserMF, ISidedInventory, IHeatSource
/*      */ {
/*   48 */   private ItemStack[] items = new ItemStack[10];
/*      */   
/*      */ 
/*   51 */   public int fuel = 0;
/*   52 */   private Random rand = new Random();
/*      */   
/*      */   public float heat;
/*      */   
/*      */   public int constructed;
/*      */   
/*      */   private int itemDam;
/*      */   
/*      */   public float bonus;
/*      */   public int extinguishBonus;
/*      */   public boolean isLit;
/*      */   public float itemHeat;
/*      */   private int adjacentLava;
/*      */   private int ticksExisted;
/*      */   public int justShared;
/*   67 */   public int forgeMaxTemp = -1;
/*      */   
/*      */   public int direction;
/*      */   
/*      */   public TileEntityForge() {}
/*      */   
/*      */   public TileEntityForge(int d)
/*      */   {
/*   75 */     this.itemDam = d;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int func_70302_i_()
/*      */   {
/*   82 */     return this.items.length;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public ItemStack func_70301_a(int slot)
/*      */   {
/*   89 */     return this.items[slot];
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public ItemStack func_70298_a(int slot, int num)
/*      */   {
/*   97 */     if (this.items[slot] != null)
/*      */     {
/*      */ 
/*  100 */       if (this.items[slot].field_77994_a <= num) {
/*  101 */         ItemStack var3 = this.items[slot];
/*  102 */         this.items[slot] = null;
/*  103 */         return var3;
/*      */       }
/*  105 */       ItemStack var3 = this.items[slot].func_77979_a(num);
/*      */       
/*  107 */       if (this.items[slot].field_77994_a == 0) {
/*  108 */         this.items[slot] = null;
/*      */       }
/*      */       
/*  111 */       return var3;
/*      */     }
/*      */     
/*  114 */     return null;
/*      */   }
/*      */   
/*      */   public float getTotalHeat()
/*      */   {
/*  119 */     float r = this.heat + this.bonus;
/*  120 */     if (r > this.forgeMaxTemp) {
/*  121 */       r = this.forgeMaxTemp;
/*      */     }
/*  123 */     return r;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public ItemStack func_70304_b(int slot)
/*      */   {
/*  132 */     if (this.items[slot] != null) {
/*  133 */       ItemStack var2 = this.items[slot];
/*  134 */       this.items[slot] = null;
/*  135 */       return var2;
/*      */     }
/*  137 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void func_70299_a(int slot, ItemStack stack)
/*      */   {
/*  146 */     this.items[slot] = stack;
/*      */     
/*  148 */     if ((stack != null) && (stack.field_77994_a > func_70297_j_())) {
/*  149 */       stack.field_77994_a = func_70297_j_();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String func_70303_b()
/*      */   {
/*  157 */     return "Forge";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void func_70307_a(NBTTagCompound nbt)
/*      */   {
/*  164 */     super.func_70307_a(nbt);
/*  165 */     NBTTagList var2 = nbt.func_74761_m("Items");
/*  166 */     this.items = new ItemStack[func_70302_i_()];
/*      */     
/*  168 */     for (int var3 = 0; var3 < var2.func_74745_c(); var3++) {
/*  169 */       NBTTagCompound var4 = (NBTTagCompound)var2.func_74743_b(var3);
/*  170 */       byte var5 = var4.func_74771_c("Slot");
/*      */       
/*  172 */       if ((var5 >= 0) && (var5 < this.items.length)) {
/*  173 */         this.items[var5] = ItemStack.func_77949_a(var4);
/*      */       }
/*      */     }
/*      */     
/*  177 */     this.constructed = nbt.func_74762_e("constructed");
/*  178 */     this.ticksExisted = nbt.func_74762_e("ticksExisted");
/*  179 */     this.direction = nbt.func_74762_e("Dir");
/*  180 */     this.fuel = nbt.func_74762_e("BurnTime");
/*  181 */     this.heat = nbt.func_74760_g("temperature");
/*  182 */     this.itemHeat = nbt.func_74760_g("itemTemperature");
/*  183 */     this.bonus = nbt.func_74760_g("bellows");
/*  184 */     this.justShared = nbt.func_74762_e("Shared");
/*  185 */     this.isLit = nbt.func_74767_n("fired");
/*  186 */     this.extinguishBonus = nbt.func_74762_e("extinguishBonus");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void func_70310_b(NBTTagCompound nbt)
/*      */   {
/*  193 */     super.func_70310_b(nbt);
/*      */     
/*  195 */     nbt.func_74768_a("constructed", this.constructed);
/*  196 */     nbt.func_74768_a("extinguishBonus", this.extinguishBonus);
/*  197 */     nbt.func_74768_a("ticksExisted", this.ticksExisted);
/*  198 */     nbt.func_74768_a("Dir", this.direction);
/*  199 */     nbt.func_74776_a("temperature", this.heat);
/*  200 */     nbt.func_74776_a("itemTemperature", this.itemHeat);
/*  201 */     nbt.func_74776_a("bellows", this.bonus);
/*  202 */     nbt.func_74768_a("BurnTime", this.fuel);
/*  203 */     nbt.func_74768_a("Shared", this.justShared);
/*  204 */     NBTTagList var2 = new NBTTagList();
/*  205 */     nbt.func_74757_a("fired", this.isLit);
/*      */     
/*  207 */     for (int var3 = 0; var3 < this.items.length; var3++) {
/*  208 */       if (this.items[var3] != null) {
/*  209 */         NBTTagCompound var4 = new NBTTagCompound();
/*  210 */         var4.func_74774_a("Slot", (byte)var3);
/*  211 */         this.items[var3].func_77955_b(var4);
/*  212 */         var2.func_74742_a(var4);
/*      */       }
/*      */     }
/*      */     
/*  216 */     nbt.func_74782_a("Items", var2);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public int func_70297_j_()
/*      */   {
/*  224 */     return 1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   @SideOnly(Side.CLIENT)
/*      */   public int getBurnTimeRemainingScaled(int height)
/*      */   {
/*  233 */     return this.fuel * height / getMaxFuel();
/*      */   }
/*      */   
/*      */   public int getHeatScaled(int height) {
/*  237 */     if (getTotalHeat() <= 0.0F)
/*  238 */       return 0;
/*  239 */     return (int)getTotalHeat() * height / this.forgeMaxTemp;
/*      */   }
/*      */   
/*      */   public int getItemHeatScaled(int height) {
/*  243 */     if (this.itemHeat <= 0.0F)
/*  244 */       return 0;
/*  245 */     return (int)this.itemHeat * height / this.forgeMaxTemp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean isBurning()
/*      */   {
/*  252 */     return (this.heat > 0.0F) && (this.isLit);
/*      */   }
/*      */   
/*      */   public void func_70316_g() {
/*  256 */     if (this.forgeMaxTemp < 0) {
/*  257 */       this.forgeMaxTemp = getMaxTemp();
/*      */     }
/*      */     
/*  260 */     this.justShared -= 1;
/*  261 */     this.ticksExisted += 1;
/*  262 */     boolean wasBurning = isBurning();
/*  263 */     boolean sendUpdate = false;
/*      */     
/*  265 */     if (!this.field_70331_k.field_72995_K) {
/*  266 */       if ((this.fuel <= 0) && (this.heat <= 0.0F)) {
/*  267 */         setLit(false);
/*      */       }
/*  269 */       if ((this.isLit) && (this.fuel <= 0)) {
/*  270 */         setLit(false);
/*  271 */       } else if (!cfg.lightForge) {
/*  272 */         setLit(true);
/*      */       }
/*  274 */       if (this.ticksExisted % 100 == 0) {
/*  275 */         this.adjacentLava = getAdjacentLava();
/*      */       }
/*  277 */       if (this.ticksExisted % 1 == 0) {
/*  278 */         shareTemp();
/*      */       }
/*      */       
/*  281 */       if (this.bonus >= 0.0F) {
/*  282 */         this.bonus -= 1.0F;
/*      */       }
/*      */       
/*  285 */       if ((this.fuel > 0) && (this.isLit)) {
/*  286 */         this.fuel -= 1;
/*  287 */         if ((this.heat < getMaxTemp()) && (this.heat < this.itemHeat)) {
/*  288 */           this.heat += 1.0F;
/*      */         }
/*      */       }
/*      */       
/*  292 */       if (this.heat > getMaxTemp()) {
/*  293 */         this.heat = getMaxTemp();
/*      */       }
/*      */       
/*  296 */       if (((!this.isLit) || (this.fuel <= 0)) && (this.heat > 0.0F)) {
/*  297 */         this.heat -= 1.0F;
/*      */       }
/*      */       
/*  300 */       if ((this.constructed == 1) && (this.fuel < getMaxFuel()) && (isItemFuel(this.items[0]))) {
/*  301 */         int burn = getItemBurnTime(this.items[0]);
/*  302 */         if ((burn > 0) && (this.fuel <= getMaxFuel() - burn)) {
/*  303 */           shareTemp();
/*  304 */           consumeFuel(this.items[0]);
/*      */           
/*  306 */           if (this.items[0].func_77973_b().func_77634_r()) {
/*  307 */             ItemStack cont = this.items[0].func_77973_b().getContainerItemStack(this.items[0]);
/*  308 */             func_70299_a(0, cont);
/*      */           } else {
/*  310 */             func_70298_a(0, 1);
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*  315 */       if (this.items.length > 0) {
/*  316 */         if (this.heat > 0.0F) {
/*  317 */           for (int a = 1; a < this.items.length; a++) {
/*  318 */             heatItem(a);
/*      */           }
/*      */         }
/*      */         
/*  322 */         if (this.heat <= 0.0F) {
/*  323 */           for (int a = 1; a < this.items.length; a++) {
/*  324 */             coolItem(a);
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*  330 */       if ((isBurning()) && 
/*  331 */         (this.field_70331_k.func_72803_f(this.field_70329_l, this.field_70330_m + 1, this.field_70327_n) != null) && (this.field_70331_k.func_72803_f(this.field_70329_l, this.field_70330_m + 1, this.field_70327_n) == Material.field_76244_g)) {
/*  332 */         douse();
/*      */       }
/*      */       
/*      */ 
/*  336 */       if ((isBurning()) && (this.field_70331_k.func_72951_B(this.field_70329_l, this.field_70330_m + 1, this.field_70327_n))) {
/*  337 */         if (this.rand.nextInt(5) == 0) {
/*  338 */           for (int a = 0; a < 3; a++) {
/*  339 */             this.field_70331_k.func_72869_a("splash", this.field_70329_l + this.rand.nextDouble() * 0.8D + 0.1D, this.field_70330_m + 0.4D, this.field_70327_n + this.rand.nextDouble() * 0.8D + 0.1D, 0.0D, 0.01D, 0.0D);
/*      */           }
/*      */           
/*  342 */           this.field_70331_k.func_72908_a(this.field_70329_l + 0.5F, this.field_70330_m + 0.5F, this.field_70327_n + 0.5F, "random.fizz", 0.4F, 2.0F + this.rand.nextFloat() * 0.4F);
/*      */           
/*  344 */           if (this.heat > 1.0F) {
/*  345 */             this.heat -= this.rand.nextInt(20);
/*  346 */             if (this.heat < 1.0F)
/*  347 */               this.heat = 1.0F;
/*      */           }
/*  349 */           if ((this.heat < 5.0F) && (this.fuel > 0)) {
/*  350 */             this.fuel -= this.rand.nextInt(20);
/*  351 */             if (this.fuel < 0)
/*  352 */               this.fuel = 0;
/*      */           }
/*      */         }
/*  355 */         if (this.rand.nextInt(20) == 0) {
/*  356 */           extinguish(Block.field_71943_B.field_71990_ca, 0);
/*      */         }
/*      */       }
/*  359 */       if (this.extinguishBonus > 0) {
/*  360 */         this.extinguishBonus -= 1;
/*      */       }
/*      */       
/*  363 */       if ((this.constructed == 0) || (this.ticksExisted % 100 == 0)) {
/*  364 */         findConstruction();
/*      */       }
/*  366 */       if ((this.isLit) && (this.constructed == -1)) {
/*  367 */         setLit(false);
/*      */       }
/*      */     }
/*      */     
/*  371 */     if (wasBurning != isBurning()) {
/*  372 */       sendUpdate = true;
/*      */     }
/*      */     
/*  375 */     int off = getOffMetadata();
/*  376 */     int on = getOnMetadata();
/*  377 */     if ((isBurning()) && (this.field_70331_k.func_72805_g(this.field_70329_l, this.field_70330_m, this.field_70327_n) != on)) {
/*  378 */       this.field_70331_k.func_72921_c(this.field_70329_l, this.field_70330_m, this.field_70327_n, on, 3);
/*  379 */       this.field_70331_k.func_72969_x(this.field_70329_l, this.field_70330_m, this.field_70327_n);
/*      */     }
/*  381 */     if ((!isBurning()) && (this.field_70331_k.func_72805_g(this.field_70329_l, this.field_70330_m, this.field_70327_n) != off)) {
/*  382 */       this.field_70331_k.func_72921_c(this.field_70329_l, this.field_70330_m, this.field_70327_n, off, 3);
/*  383 */       this.field_70331_k.func_72969_x(this.field_70329_l, this.field_70330_m, this.field_70327_n);
/*      */     }
/*      */     
/*  386 */     if (sendUpdate) {
/*  387 */       func_70296_d();
/*      */     }
/*  389 */     if (isBurning()) {
/*  390 */       puffSmoke(new Random(), this.field_70331_k, this.field_70329_l, this.field_70330_m, this.field_70327_n);
/*      */     }
/*  392 */     if (!this.field_70331_k.field_72995_K) {
/*  393 */       if (this.ticksExisted % 20 == 0) {
/*  394 */         syncItems();
/*      */       }
/*  396 */       sendPacketToClients();
/*      */     }
/*      */   }
/*      */   
/*      */   public void findConstruction() {
/*  401 */     this.constructed = (isConstructed() ? 1 : -1);
/*      */     
/*  403 */     if ((this.constructed == -1) && (this.isLit)) {
/*  404 */       setLit(false);
/*      */     }
/*      */   }
/*      */   
/*      */   private int getOnMetadata() {
/*  409 */     return getType() * 2 + 1;
/*      */   }
/*      */   
/*      */   private int getOffMetadata() {
/*  413 */     return getType() * 2;
/*      */   }
/*      */   
/*      */   public int func_70322_n() {
/*  417 */     if (this.field_70331_k == null) {
/*  418 */       return this.itemDam * 2;
/*      */     }
/*  420 */     if (this.field_70325_p == -1) {
/*  421 */       this.field_70325_p = this.field_70331_k.func_72805_g(this.field_70329_l, this.field_70330_m, this.field_70327_n);
/*      */     }
/*      */     
/*  424 */     return this.field_70325_p;
/*      */   }
/*      */   
/*      */   public void puffSmoke(Random rand, World world, int x, int y, int z) {
/*  428 */     if (rand.nextInt(15) != 0) {
/*  429 */       return;
/*      */     }
/*      */     
/*  432 */     Block block = Block.field_71973_m[world.func_72798_a(x, y + 2, z)];
/*  433 */     IChimney chimney = null;
/*      */     
/*  435 */     if ((block instanceof IChimney)) {
/*  436 */       chimney = (IChimney)block;
/*      */     }
/*  438 */     if ((chimney != null) && (chimney.puffSmoke(world, x, y + 2, z, 0.083333336F, 1.0F, 1.0F))) {
/*  439 */       return;
/*      */     }
/*      */     
/*  442 */     for (int x1 = -1; x1 <= 1; x1++) {
/*  443 */       for (int z1 = -1; z1 <= 1; z1++) {
/*  444 */         Block block1 = Block.field_71973_m[world.func_72798_a(x + x1, y + 2, z + z1)];
/*  445 */         IChimney chimney1 = null;
/*      */         
/*  447 */         if ((block1 instanceof IChimney)) {
/*  448 */           chimney1 = (IChimney)block1;
/*      */         }
/*  450 */         if ((chimney1 != null) && (chimney1.puffSmoke(world, x + x1, y + 2, z + z1, 0.083333336F, 1.0F, 1.0F))) {
/*      */           break;
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void heatItem(int slot) {
/*  458 */     ItemStack itemStack = this.items[slot];
/*  459 */     if (itemStack == null) {
/*  460 */       return;
/*      */     }
/*      */     
/*  463 */     if (HeatableItem.canHeatItem(itemStack)) {
/*  464 */       func_70299_a(slot, ItemHotItem.createHotItem(itemStack));
/*  465 */       return;
/*      */     }
/*      */     
/*  468 */     if (itemStack.field_77993_c == ItemListMF.hotItem.field_77779_bT) {
/*  469 */       int multiplier = this.rand.nextInt(5) + 1;
/*  470 */       double buff = getTotalHeat() / ItemHandler.forgeMaxTemp * multiplier;
/*  471 */       int itemHeat = ItemHotItem.getTemp(itemStack);
/*  472 */       buff *= (1.0D + this.adjacentLava / 4.0D);
/*      */       
/*  474 */       ItemStack ingot = ItemHotItem.getItem(itemStack);
/*  475 */       if ((ingot != null) && 
/*  476 */         (HeatableItem.doesRuinItem(ingot, itemHeat))) {
/*  477 */         func_70298_a(slot, 1);
/*      */       }
/*  479 */       if ((itemHeat > getTotalHeat()) || ((int)(itemHeat + buff) > getTotalHeat())) {
/*  480 */         return;
/*      */       }
/*  482 */       ItemHotItem.setTemp(itemStack, (int)(itemHeat + buff));
/*      */     }
/*      */   }
/*      */   
/*      */   private void coolItem(int slot)
/*      */   {
/*  488 */     ItemStack itemStack = this.items[slot];
/*  489 */     if (itemStack == null) {
/*  490 */       return;
/*      */     }
/*      */     
/*  493 */     if ((this.rand.nextInt(10) == 0) && (itemStack.field_77993_c == ItemListMF.hotItem.field_77779_bT)) {
/*  494 */       int multiplier = this.rand.nextInt(5) + 1;
/*  495 */       double buff = 1.0D;
/*  496 */       int itemHeat = ItemHotItem.getTemp(itemStack);
/*      */       
/*  498 */       ItemStack ingot = ItemHotItem.getItem(itemStack);
/*  499 */       if ((ingot != null) && 
/*  500 */         (HeatableItem.doesRuinItem(ingot, itemHeat))) {
/*  501 */         func_70298_a(slot, 1);
/*      */       }
/*      */       
/*  504 */       ItemHotItem.setTemp(itemStack, (int)(itemHeat - buff));
/*      */       
/*  506 */       if ((itemHeat == 0) && (ItemHotItem.getItem(itemStack) != null)) {
/*  507 */         func_70299_a(slot, ItemHotItem.getItem(itemStack));
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void dampenItem(int slot) {
/*  513 */     ItemStack itemStack = this.items[slot];
/*  514 */     if (itemStack == null) {
/*  515 */       return;
/*      */     }
/*      */     
/*  518 */     if (itemStack.field_77993_c == ItemListMF.hotItem.field_77779_bT) {
/*  519 */       if (ItemHotItem.getItem(itemStack) != null) {
/*  520 */         func_70299_a(slot, ItemHotItem.getItem(itemStack));
/*      */       } else {
/*  522 */         ItemHotItem.setTemp(itemStack, 0);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void splashWater() {
/*  528 */     if (!isBurning())
/*  529 */       return;
/*  530 */     this.heat -= 100.0F;
/*  531 */     if (this.heat < 0.0F) {
/*  532 */       this.heat = 0.0F;
/*      */     }
/*  534 */     this.field_70331_k.func_72980_b(this.field_70329_l + 0.5F, this.field_70330_m + 0.4F, this.field_70327_n + 0.5F, "random.fizz", 1.0F, 1.0F, true);
/*  535 */     this.field_70331_k.func_72869_a("smoke", this.field_70329_l + 0.5F, this.field_70330_m + 0.4F, this.field_70327_n + 0.5F, 0.0D, 0.05000000074505806D, 0.0D);
/*      */     
/*  537 */     if (!this.field_70331_k.field_72995_K) {
/*      */       try {
/*  539 */         Packet packet = PacketManagerMF.getPacketIntegerArray(this, new int[] { 1, 0 });
/*  540 */         FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*      */       } catch (NullPointerException e) {
/*  542 */         e.printStackTrace();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void douse() {
/*  548 */     if (!isBurning())
/*  549 */       return;
/*  550 */     this.heat = (this.itemHeat = this.bonus = 0.0F);
/*  551 */     this.field_70331_k.func_72980_b(this.field_70329_l + 0.5F, this.field_70330_m + 0.4F, this.field_70327_n + 0.5F, "random.fizz", 2.0F, 0.5F, true);
/*  552 */     for (int a = 0; a < 10; a++) {
/*  553 */       this.field_70331_k.func_72869_a("largesmoke", this.field_70329_l + this.rand.nextDouble() * 0.800000011920929D + 0.10000000149011612D, this.field_70330_m + 0.4F, this.field_70327_n + this.rand.nextDouble() * 0.800000011920929D + 0.10000000149011612D, 0.0D, 0.05000000074505806D, 0.0D);
/*      */     }
/*  555 */     for (int a = 1; a < this.items.length; a++) {
/*  556 */       dampenItem(a);
/*      */     }
/*  558 */     setLit(false);
/*  559 */     this.fuel = 0;
/*      */     
/*  561 */     if (!this.field_70331_k.field_72995_K) {
/*      */       try {
/*  563 */         Packet packet = PacketManagerMF.getPacketIntegerArray(this, new int[] { 1, 1 });
/*  564 */         FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*      */       } catch (NullPointerException e) {
/*  566 */         e.printStackTrace();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private float getItemHeat(ItemStack itemStack) {
/*  572 */     return ItemHandler.getForgeHeat(itemStack);
/*      */   }
/*      */   
/*      */   private void sendPacketToClients() {
/*      */     try {
/*  577 */       Packet packet = PacketManagerMF.getPacketIntegerArray(this, new int[] { 0, this.fuel, (int)this.heat * 10, (int)this.bonus * 10, (int)this.itemHeat * 10, this.direction, this.isLit ? 1 : 0, this.constructed });
/*  578 */       FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*      */     } catch (NullPointerException e) {
/*  580 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */   
/*      */   public void syncItems() {
/*  585 */     if (!this.field_70331_k.field_72995_K) {
/*  586 */       for (int a = 0; a < this.items.length; a++) {
/*  587 */         Packet packet = PacketManagerMF.getPacketItemStackArray(this, a, this.items[a]);
/*      */         try {
/*  589 */           FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*      */         } catch (NullPointerException e) {
/*  591 */           System.out.println("MineFantasy: Client connection lost");
/*  592 */           return;
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void recievePacket(ByteArrayDataInput data)
/*      */   {
/*  600 */     int type = data.readInt();
/*      */     
/*  602 */     if (type == 0) {
/*  603 */       this.fuel = data.readInt();
/*  604 */       this.heat = (data.readInt() / 10.0F);
/*  605 */       this.bonus = (data.readInt() / 10.0F);
/*  606 */       this.itemHeat = (data.readInt() / 10.0F);
/*  607 */       this.direction = data.readInt();
/*      */       
/*  609 */       int i = data.readInt();
/*  610 */       setLit(i == 1);
/*  611 */       this.constructed = data.readInt();
/*      */     }
/*  613 */     if (type == 1) {
/*  614 */       int action = data.readInt();
/*  615 */       if (action == 0) {
/*  616 */         splashWater();
/*      */       }
/*  618 */       if (action == 1) {
/*  619 */         douse();
/*      */       }
/*      */     }
/*  622 */     if (type == 2) {
/*  623 */       int p = data.readInt();
/*  624 */       int i = data.readInt();
/*  625 */       int slot = data.readInt();
/*      */       
/*  627 */       Entity e = this.field_70331_k.func_73045_a(p);
/*      */       
/*  629 */       if ((e != null) && ((e instanceof EntityPlayer))) {
/*  630 */         BlockForge.useInventory(this.field_70331_k, this.field_70329_l, this.field_70330_m, this.field_70327_n, this, (EntityPlayer)e, i, slot);
/*      */       }
/*  632 */       return;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getItemBurnTime(ItemStack fuel)
/*      */   {
/*  641 */     if (fuel == null) {
/*  642 */       return 0;
/*      */     }
/*  644 */     return (int)ItemHandler.getForgeFuel(fuel) * 2;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean doesItemLight(ItemStack fuel)
/*      */   {
/*  652 */     return ItemHandler.willLight(fuel);
/*      */   }
/*      */   
/*      */   public static int getItemTemperature(ItemStack fuel) {
/*  656 */     if (fuel == null) {
/*  657 */       return 0;
/*      */     }
/*  659 */     return ItemHandler.getForgeHeat(fuel);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean isItemFuel(ItemStack fuel)
/*      */   {
/*  667 */     if (fuel == null) {
/*  668 */       return false;
/*      */     }
/*  670 */     return (getItemBurnTime(fuel) > 0) && (getItemTemperature(fuel) <= this.forgeMaxTemp);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean func_70300_a(EntityPlayer user)
/*      */   {
/*  678 */     return this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m, this.field_70327_n) == this;
/*      */   }
/*      */   
/*      */ 
/*      */   public void func_70295_k_() {}
/*      */   
/*      */   public void func_70305_f() {}
/*      */   
/*      */   public int getMaxBellowsBonus()
/*      */   {
/*  688 */     return (int)(this.heat / 4.0F);
/*      */   }
/*      */   
/*      */   public void onUsedWithBellows(float powerLevel) {
/*  692 */     if (!isBurning())
/*  693 */       return;
/*  694 */     if (this.justShared > 0) {
/*  695 */       return;
/*      */     }
/*  697 */     if (this.fuel <= 0) {
/*  698 */       return;
/*      */     }
/*  700 */     this.justShared = 5;
/*  701 */     if (this.heat < this.itemHeat) {
/*  702 */       this.heat += 50.0F * powerLevel;
/*      */     }
/*  704 */     if (this.bonus < getMaxBellowsBonus()) {
/*  705 */       this.bonus += 100.0F * powerLevel;
/*      */     }
/*  707 */     if (this.bonus > getMaxBellowsBonus()) {
/*  708 */       this.bonus = getMaxBellowsBonus();
/*      */     }
/*      */     
/*  711 */     for (int a = 0; a < 10; a++) {
/*  712 */       this.field_70331_k.func_72869_a("flame", this.field_70329_l + this.rand.nextDouble() * 0.8D + 0.1D, this.field_70330_m + 0.4D, this.field_70327_n + this.rand.nextDouble() * 0.8D + 0.1D, 0.0D, 0.01D, 0.0D);
/*      */     }
/*      */     
/*  715 */     pumpBellows(-1, 0, powerLevel * 0.9F);
/*  716 */     pumpBellows(0, -1, powerLevel * 0.9F);
/*  717 */     pumpBellows(0, 1, powerLevel * 0.9F);
/*  718 */     pumpBellows(1, 0, powerLevel * 0.9F);
/*      */   }
/*      */   
/*      */ 
/*      */   public boolean func_94042_c()
/*      */   {
/*  724 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_94041_b(int i, ItemStack itemstack)
/*      */   {
/*  729 */     if (i == 0)
/*      */     {
/*  731 */       if (func_70301_a(0) == null) {
/*  732 */         return getItemBurnTime(itemstack) > 0;
/*      */       }
/*      */     }
/*      */     
/*  736 */     return HeatableItem.canHeatItem(itemstack);
/*      */   }
/*      */   
/*      */   public int[] func_94128_d(int side)
/*      */   {
/*  741 */     return new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
/*      */   }
/*      */   
/*      */   public boolean func_102007_a(int slot, ItemStack item, int side)
/*      */   {
/*  746 */     if ((slot > 0) && 
/*  747 */       (this.items[slot] == null)) {
/*  748 */       return true;
/*      */     }
/*      */     
/*  751 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_102008_b(int slot, ItemStack item, int side)
/*      */   {
/*  756 */     if ((side == 0) && 
/*  757 */       (item != null)) {
/*  758 */       if (isProperlyHeated(item)) {
/*  759 */         return slot > 0;
/*      */       }
/*  761 */       if (item.func_77973_b() == Item.field_77788_aw) {
/*  762 */         return slot == 0;
/*      */       }
/*      */     }
/*      */     
/*  766 */     return false;
/*      */   }
/*      */   
/*      */   public static boolean isProperlyHeated(ItemStack item) {
/*  770 */     if (item.func_77973_b() == null) {
/*  771 */       return false;
/*      */     }
/*  773 */     if ((item.func_77973_b() instanceof ItemHotItem)) {
/*  774 */       if (!ItemHotItem.showTemp(item)) {
/*  775 */         return true;
/*      */       }
/*  777 */       ItemStack item2 = ItemHotItem.getItem(item);
/*  778 */       int temp = ItemHotItem.getTemp(item) - 1;
/*  779 */       if (HeatableItem.canWorkItem(item2, temp)) {
/*  780 */         return true;
/*      */       }
/*      */     }
/*      */     
/*  784 */     return false;
/*      */   }
/*      */   
/*      */   private int getAdjacentLava() {
/*  788 */     int amount = 0;
/*  789 */     for (int x = -1; x <= 1; x++) {
/*  790 */       for (int z = -1; z <= 1; z++) {
/*  791 */         for (int y = -1; y <= 1; y++) {
/*  792 */           if (((x != 0) || (y != 0) || (z != 0)) && 
/*  793 */             (this.field_70331_k.func_72803_f(this.field_70329_l + x, this.field_70330_m + y, this.field_70327_n + z) == Material.field_76256_h)) {
/*  794 */             amount++;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*  799 */     return amount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean[] showSides()
/*      */   {
/*  806 */     if (this.field_70331_k == null) {
/*  807 */       return new boolean[] { true, true, true, true };
/*      */     }
/*  809 */     boolean front = !isForge(0, 0, 1);
/*  810 */     boolean left = !isForge(-1, 0, 0);
/*  811 */     boolean right = !isForge(1, 0, 0);
/*  812 */     boolean back = !isForge(0, 0, -1);
/*      */     
/*  814 */     return new boolean[] { front, left, right, back };
/*      */   }
/*      */   
/*      */   private void shareTemp() {
/*  818 */     shareTo(-1, 0);
/*  819 */     shareTo(1, 0);
/*  820 */     shareTo(0, -1);
/*  821 */     shareTo(0, 1);
/*      */   }
/*      */   
/*      */   private void shareTo(int x, int z) {
/*  825 */     if (this.fuel <= 0) {
/*  826 */       return;
/*      */     }
/*  828 */     int share = 2;
/*  829 */     TileEntity tile = this.field_70331_k.func_72796_p(this.field_70329_l + x, this.field_70330_m, this.field_70327_n + z);
/*  830 */     if (tile == null) {
/*  831 */       return;
/*      */     }
/*  833 */     if ((tile instanceof TileEntityForge)) {
/*  834 */       TileEntityForge forge = (TileEntityForge)tile;
/*      */       
/*  836 */       if ((this.isLit) && (!forge.isLit) && (forge.fuel > 0) && (forge.extinguishBonus <= 0)) {
/*  837 */         forge.setLit(true);
/*      */       }
/*  839 */       if ((!forge.isBurning()) && (this.heat > 1.0F)) {
/*  840 */         forge.heat = 1.0F;
/*      */       }
/*  842 */       if (forge.heat < this.heat - share) {
/*  843 */         forge.heat += share;
/*  844 */         this.heat -= share;
/*      */       }
/*  846 */       share = 20;
/*  847 */       if (forge.fuel < this.fuel - share) {
/*  848 */         forge.fuel += share;
/*  849 */         this.fuel -= share;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void pumpBellows(int x, int z, float pump) {
/*  855 */     if (this.fuel <= 0) {
/*  856 */       return;
/*      */     }
/*  858 */     int share = 2;
/*  859 */     TileEntity tile = this.field_70331_k.func_72796_p(this.field_70329_l + x, this.field_70330_m, this.field_70327_n + z);
/*  860 */     if (tile == null) {
/*  861 */       return;
/*      */     }
/*  863 */     if ((tile instanceof TileEntityForge)) {
/*  864 */       TileEntityForge forge = (TileEntityForge)tile;
/*  865 */       forge.onUsedWithBellows(pump);
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean isForge(int x, int y, int z) {
/*  870 */     return this.field_70331_k.func_72798_a(this.field_70329_l + x, this.field_70330_m + y, this.field_70327_n + z) == MineFantasyBase.MFBlockForge.field_71990_ca;
/*      */   }
/*      */   
/*      */   public boolean tryAddItem(int slotNum, ItemStack item) {
/*  874 */     if ((slotNum < 0) || (slotNum >= this.items.length) || (item == null)) {
/*  875 */       return false;
/*      */     }
/*      */     
/*  878 */     ItemStack slot = this.items[slotNum];
/*  879 */     if ((slot == null) && (HeatableItem.canHeatItem(item))) {
/*  880 */       ItemStack copy = item.func_77946_l();
/*  881 */       copy.field_77994_a = 1;
/*  882 */       func_70299_a(slotNum, copy);
/*  883 */       if (!this.field_70331_k.field_72995_K) {
/*  884 */         syncItems();
/*      */       }
/*      */       
/*  887 */       return true;
/*      */     }
/*  889 */     return false;
/*      */   }
/*      */   
/*      */   public int getType() {
/*  893 */     int meta = func_70322_n();
/*  894 */     return (int)Math.floor(meta / 2);
/*      */   }
/*      */   
/*      */   public String getTexture() {
/*  898 */     if (getType() == 1) {
/*  899 */       return "forge_cobble";
/*      */     }
/*  901 */     if (getType() == 2) {
/*  902 */       return "forge_obsidian";
/*      */     }
/*  904 */     return "forge";
/*      */   }
/*      */   
/*      */   public int getSlotFor(float x, float y) {
/*  908 */     int[] coord = BlockClickHelper.getCoordsFor(x, y, 0.0F, 1.0F, 0.0F, 1.0F, 3, 3, this.direction);
/*      */     
/*  910 */     if (coord == null) {
/*  911 */       return -1;
/*      */     }
/*  913 */     return coord[0] + coord[1] * 3 + 1;
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public boolean shouldRenderCraftMetre()
/*      */   {
/*  919 */     return (this.fuel > 0) || (this.heat > 0.0F);
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public int getProgressBar(int width)
/*      */   {
/*  925 */     return this.fuel * width / getMaxFuel();
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public String getResultName()
/*      */   {
/*  931 */     int seconds = (int)Math.floor(this.fuel / 20);
/*  932 */     int mins = (int)Math.floor(seconds / 60);
/*  933 */     seconds -= mins * 60;
/*      */     
/*  935 */     String sec = "";
/*  936 */     if (seconds < 10) {
/*  937 */       sec = sec + "0";
/*      */     }
/*      */     
/*  940 */     String ss = StatCollector.func_74838_a("info.fuel") + "= " + mins + ":" + sec + seconds;
/*      */     
/*  942 */     if (getHeat() > 0) {
/*  943 */       ss = ss + " " + StatCollector.func_74838_a("info.heat") + ": " + getTotalHeat() + "C";
/*      */     }
/*  945 */     return ss;
/*      */   }
/*      */   
/*      */ 
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void setTempResult(ItemStack res) {}
/*      */   
/*      */ 
/*      */   public boolean canPlaceAbove()
/*      */   {
/*  955 */     return true;
/*      */   }
/*      */   
/*      */   public int getHeat()
/*      */   {
/*  960 */     return (int)this.heat;
/*      */   }
/*      */   
/*      */   public void setLit(boolean b) {
/*  964 */     if ((b) && (!isConstructed())) {
/*  965 */       b = false;
/*      */     }
/*  967 */     this.isLit = b;
/*      */   }
/*      */   
/*      */   public void extinguishByHand() {
/*  971 */     extinguishByHand(16);
/*      */   }
/*      */   
/*      */   public void extinguishByHand(int a) {
/*  975 */     extinguishSide(-1, 0, a);
/*  976 */     extinguishSide(1, 0, a);
/*  977 */     extinguishSide(0, -1, a);
/*  978 */     extinguishSide(0, 1, a);
/*      */     
/*  980 */     extinguish();
/*      */   }
/*      */   
/*      */   private void extinguishSide(int x, int z, int c) {
/*  984 */     if (c <= 0) {
/*  985 */       return;
/*      */     }
/*  987 */     TileEntity tile = this.field_70331_k.func_72796_p(this.field_70329_l + x, this.field_70330_m, this.field_70327_n + z);
/*  988 */     if (tile == null) {
/*  989 */       return;
/*      */     }
/*  991 */     if ((tile instanceof TileEntityForge)) {
/*  992 */       TileEntityForge forge = (TileEntityForge)tile;
/*      */       
/*  994 */       if (forge.isLit) {
/*  995 */         forge.extinguishByHand(c - 1);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void extinguish() {
/* 1001 */     extinguish(Block.field_71939_E.field_71990_ca, 0);
/*      */   }
/*      */   
/*      */   public void extinguish(int block, int meta) {
/* 1005 */     this.field_70331_k.func_72908_a(this.field_70329_l + 0.5F, this.field_70330_m + 0.25F, this.field_70327_n + 0.5F, "random.fizz", 0.4F, 2.0F + this.rand.nextFloat() * 0.4F);
/* 1006 */     this.field_70331_k.func_72869_a("largesmoke", this.field_70329_l + 0.5D, this.field_70330_m + 0.5D, this.field_70327_n + 0.5D, 0.0D, 0.0D, 0.0D);
/* 1007 */     this.field_70331_k.func_72869_a("tilecrack_" + block + "_" + meta, this.field_70329_l + 0.5D, this.field_70330_m + 0.5D, this.field_70327_n + 0.5D, 0.0D, 0.0D, 0.0D);
/*      */     
/* 1009 */     this.extinguishBonus = 20;
/* 1010 */     setLit(false);
/*      */   }
/*      */   
/*      */   public int getMaxFuel() {
/* 1014 */     return 6000;
/*      */   }
/*      */   
/*      */   public void consumeFuel(ItemStack item) {
/* 1018 */     if (item == null) {
/* 1019 */       return;
/*      */     }
/* 1021 */     this.fuel = Math.min(getMaxFuel(), this.fuel + getItemBurnTime(item));
/* 1022 */     this.itemHeat = getItemHeat(item);
/*      */     
/* 1024 */     if ((!this.isLit) && (doesItemLight(item))) {
/* 1025 */       this.field_70331_k.func_72908_a(this.field_70329_l + 0.5D, this.field_70330_m + 0.5D, this.field_70327_n + 0.5D, "random.fizz", 1.0F, 0.5F + this.rand.nextFloat());
/* 1026 */       setLit(true);
/*      */     }
/*      */   }
/*      */   
/*      */   public int getMaxTemp() {
/* 1031 */     if (getType() == 2) {
/* 1032 */       return 5000;
/*      */     }
/* 1034 */     return 1000;
/*      */   }
/*      */   
/*      */   private boolean isConstructed() {
/* 1038 */     if (getType() == 2) {
/* 1039 */       return isObsidianBuilt();
/*      */     }
/* 1041 */     return true;
/*      */   }
/*      */   
/*      */   private boolean isObsidianBuilt()
/*      */   {
/* 1046 */     for (int x = -1; x <= 1; x++) {
/* 1047 */       for (int z = -1; z <= 1; z++) {
/* 1048 */         int id = this.field_70331_k.func_72798_a(this.field_70329_l + x, this.field_70330_m - 1, this.field_70327_n + z);
/* 1049 */         if (id != Block.field_72089_ap.field_71990_ca) {
/* 1050 */           return false;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1056 */     int sides = 0;
/*      */     
/* 1058 */     for (int x = -1; x <= 1; x++) {
/* 1059 */       for (int z = -1; z <= 1; z++) {
/* 1060 */         if ((x != 0) || (z != 0)) {
/* 1061 */           int id = this.field_70331_k.func_72798_a(this.field_70329_l + x, this.field_70330_m, this.field_70327_n + z);
/* 1062 */           if (id == Block.field_72089_ap.field_71990_ca) {
/* 1063 */             sides++;
/*      */           }
/* 1065 */           TileEntity tile = this.field_70331_k.func_72796_p(this.field_70329_l + x, this.field_70330_m, this.field_70327_n + z);
/* 1066 */           if ((tile != null) && ((tile instanceof TileEntityForge)) && 
/* 1067 */             (((TileEntityForge)tile).getType() == 2)) {
/* 1068 */             sides++;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1075 */     return sides >= 5;
/*      */   }
/*      */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/TileEntityForge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */