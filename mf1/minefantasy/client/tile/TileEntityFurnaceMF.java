/*      */ package minefantasy.client.tile;
/*      */ 
/*      */ import com.google.common.io.ByteArrayDataInput;
/*      */ import cpw.mods.fml.common.FMLCommonHandler;
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import java.util.Random;
/*      */ import minefantasy.api.aesthetic.IChimney;
/*      */ import minefantasy.api.forge.IBellowsUseable;
/*      */ import minefantasy.api.forge.ItemHandler;
/*      */ import minefantasy.api.refine.Alloy;
/*      */ import minefantasy.api.refine.SpecialFurnaceRecipes;
/*      */ import minefantasy.system.MFResource;
/*      */ import minefantasy.system.network.PacketManagerMF;
/*      */ import minefantasy.system.network.PacketUserMF;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.block.material.Material;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.inventory.IInventory;
/*      */ import net.minecraft.inventory.ISidedInventory;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemFood;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.item.crafting.FurnaceRecipes;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.nbt.NBTTagList;
/*      */ import net.minecraft.network.packet.Packet;
/*      */ import net.minecraft.server.MinecraftServer;
/*      */ import net.minecraft.server.management.ServerConfigurationManager;
/*      */ import net.minecraft.tileentity.TileEntity;
/*      */ import net.minecraft.tileentity.TileEntityFurnace;
/*      */ import net.minecraft.util.StatCollector;
/*      */ import net.minecraft.world.World;
/*      */ import net.minecraftforge.common.ForgeDirection;
/*      */ import net.minecraftforge.oredict.OreDictionary;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class TileEntityFurnaceMF
/*      */   extends TileEntity
/*      */   implements IBellowsUseable, IInventory, ISidedInventory, PacketUserMF
/*      */ {
/*      */   public int fuel;
/*      */   public int maxFuel;
/*      */   public ItemStack[] inv;
/*      */   public int direction;
/*      */   public int itemMeta;
/*   63 */   public boolean built = false;
/*   64 */   private Random rand = new Random();
/*      */   
/*      */   public int numUsers;
/*      */   
/*      */   public int doorAngle;
/*      */   
/*      */   public float heat;
/*      */   
/*      */   public float maxHeat;
/*      */   
/*      */   private int aboveType;
/*      */   
/*      */   private int justShared;
/*      */   
/*      */   public int progress;
/*      */   
/*      */   private int ticksExisted;
/*      */   
/*      */   private int ticksSinceSync;
/*      */   
/*      */   private boolean isBurningClient;
/*      */   
/*      */   public TileEntityFurnaceMF()
/*      */   {
/*   88 */     this.inv = new ItemStack[8];
/*   89 */     this.fuel = (this.maxFuel = this.progress = 0);
/*      */   }
/*      */   
/*      */   public TileEntityFurnaceMF(int meta) {
/*   93 */     this.itemMeta = meta;
/*      */   }
/*      */   
/*      */   public void onUsedWithBellows(float powerLevel)
/*      */   {
/*   98 */     if (isHeater()) {
/*   99 */       if (this.justShared > 0) {
/*  100 */         return;
/*      */       }
/*  102 */       this.justShared = 5;
/*      */       
/*  104 */       if (this.fuel > 0) {
/*  105 */         int max = (int)(this.maxHeat * 1.5F);
/*  106 */         if (this.heat < max) {
/*  107 */           this.heat += 50.0F * powerLevel;
/*      */         }
/*      */         
/*  110 */         for (int a = 0; a < 10; a++) {
/*  111 */           this.field_70331_k.func_72869_a("flame", this.field_70329_l + this.rand.nextDouble() * 0.8D + 0.1D, this.field_70330_m + 0.4D, this.field_70327_n + this.rand.nextDouble() * 0.8D + 0.1D, 0.0D, 0.01D, 0.0D);
/*      */         }
/*      */       }
/*  114 */       pumpBellows(-1, 0, powerLevel * 0.9F);
/*  115 */       pumpBellows(0, -1, powerLevel * 0.9F);
/*  116 */       pumpBellows(0, 1, powerLevel * 0.9F);
/*  117 */       pumpBellows(1, 0, powerLevel * 0.9F);
/*      */     }
/*      */   }
/*      */   
/*      */   private void pumpBellows(int x, int z, float pump) {
/*  122 */     int share = 2;
/*  123 */     TileEntity tile = this.field_70331_k.func_72796_p(this.field_70329_l + x, this.field_70330_m, this.field_70327_n + z);
/*  124 */     if (tile == null) {
/*  125 */       return;
/*      */     }
/*  127 */     if ((tile instanceof TileEntityFurnaceMF)) {
/*  128 */       TileEntityFurnaceMF furn = (TileEntityFurnaceMF)tile;
/*  129 */       if (furn.isHeater()) {
/*  130 */         furn.onUsedWithBellows(pump);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void func_70316_g() {
/*  136 */     super.func_70316_g();
/*      */     
/*  138 */     if (!this.field_70331_k.field_72995_K) {
/*  139 */       if ((this.numUsers > 0) && (this.doorAngle < 20)) {
/*  140 */         this.doorAngle += 1;
/*      */       }
/*      */       
/*  143 */       if ((this.numUsers <= 0) && (this.doorAngle > 0)) {
/*  144 */         this.doorAngle -= 1;
/*      */       }
/*  146 */       if (this.doorAngle < 0)
/*  147 */         this.doorAngle = 0;
/*  148 */       if (this.doorAngle > 20) {
/*  149 */         this.doorAngle = 20;
/*      */       }
/*      */     }
/*  152 */     this.ticksExisted += 1;
/*  153 */     if (this.justShared > 0)
/*  154 */       this.justShared -= 1;
/*  155 */     if (this.ticksExisted % 10 == 0) {
/*  156 */       this.built = structureExists();
/*      */     }
/*  158 */     if (isHeater()) {
/*  159 */       updateHeater();
/*      */     } else {
/*  161 */       updateFurnace();
/*      */     }
/*      */     
/*  164 */     if (!this.field_70331_k.field_72995_K) {
/*  165 */       int off = getOffMetadata();
/*  166 */       int on = getOnMetadata();
/*  167 */       if ((isBurning()) && (this.field_70331_k.func_72805_g(this.field_70329_l, this.field_70330_m, this.field_70327_n) != on)) {
/*  168 */         this.field_70331_k.func_72921_c(this.field_70329_l, this.field_70330_m, this.field_70327_n, on, 3);
/*  169 */         this.field_70331_k.func_72969_x(this.field_70329_l, this.field_70330_m, this.field_70327_n);
/*      */       }
/*  171 */       if ((!isBurning()) && (this.field_70331_k.func_72805_g(this.field_70329_l, this.field_70330_m, this.field_70327_n) != off)) {
/*  172 */         this.field_70331_k.func_72921_c(this.field_70329_l, this.field_70330_m, this.field_70327_n, off, 3);
/*  173 */         this.field_70331_k.func_72969_x(this.field_70329_l, this.field_70330_m, this.field_70327_n);
/*      */       }
/*      */       
/*  176 */       sendPacketToClients();
/*      */     }
/*      */   }
/*      */   
/*      */   private void updateFurnace() {
/*  181 */     if (this.field_70331_k.field_72995_K) {
/*  182 */       if (isBurning()) {
/*  183 */         puffSmoke(new Random(), this.field_70331_k, this.field_70329_l, this.field_70330_m, this.field_70327_n);
/*      */         
/*  185 */         if (this.rand.nextInt(10) == 0)
/*  186 */           this.field_70331_k.func_72869_a("flame", this.field_70329_l + this.rand.nextDouble() * 0.8D + 0.1D, this.field_70330_m + 0.4D, this.field_70327_n + this.rand.nextDouble() * 0.8D + 0.1D, 0.0D, 0.01D, 0.0D);
/*      */       }
/*  188 */       return;
/*      */     }
/*      */     
/*  191 */     TileEntityFurnaceMF heater = getHeater();
/*      */     
/*  193 */     if (heater != null) {
/*  194 */       this.heat = heater.heat;
/*      */     } else {
/*  196 */       this.heat -= 4.0F;
/*      */     }
/*  198 */     boolean canSmelt = false;
/*  199 */     boolean smelted = false;
/*      */     
/*  201 */     if (getSpecialResult() != null) {
/*  202 */       if (!canFitSpecialResult()) {
/*  203 */         canSmelt = false;
/*      */       } else {
/*  205 */         canSmelt = true;
/*      */         
/*  207 */         if (this.progress >= getMaxTime()) {
/*  208 */           smeltSpecial();
/*  209 */           smelted = true;
/*      */         }
/*      */       }
/*      */     } else {
/*  213 */       for (int a = 0; a < 4; a++) {
/*  214 */         if (canSmelt(this.inv[a], this.inv[(a + 4)])) {
/*  215 */           canSmelt = true;
/*      */           
/*  217 */           if (this.progress >= getMaxTime()) {
/*  218 */             smeltItem(a, a + 4);
/*  219 */             smelted = true;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*  224 */     if (canSmelt) {
/*  225 */       this.progress = ((int)(this.progress + this.heat));
/*      */     }
/*  227 */     if ((!canSmelt) || (smelted)) {
/*  228 */       this.progress = 0;
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean canFitSpecialResult() {
/*  233 */     ItemStack spec = getSpecialResult();
/*      */     
/*  235 */     if (spec != null) {
/*  236 */       int spaceNeeded = spec.field_77994_a;
/*  237 */       int spaceLeft = 0;
/*      */       
/*  239 */       for (int a = 4; a < 8; a++) {
/*  240 */         ItemStack item = this.inv[a];
/*  241 */         if (this.inv[a] == null) {
/*  242 */           spaceLeft += 64;
/*      */         }
/*  244 */         else if ((this.inv[a].func_77969_a(spec)) && 
/*  245 */           (this.inv[a].field_77994_a < this.inv[a].func_77976_d())) {
/*  246 */           spaceLeft += this.inv[a].func_77976_d() - this.inv[a].field_77994_a;
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*  251 */       return spec.field_77994_a <= spaceLeft;
/*      */     }
/*  253 */     return false;
/*      */   }
/*      */   
/*      */   private void smeltSpecial() {
/*  257 */     ItemStack res = getSpecialResult().func_77946_l();
/*      */     
/*  259 */     for (int output = 4; output < 8; output++) {
/*  260 */       if (res.field_77994_a <= 0) {
/*      */         break;
/*      */       }
/*  263 */       if (this.inv[output] == null) {
/*  264 */         func_70299_a(output, res);
/*  265 */         break;
/*      */       }
/*  267 */       if (this.inv[output].func_77969_a(res)) {
/*  268 */         int spaceLeft = this.inv[output].func_77976_d() - this.inv[output].field_77994_a;
/*      */         
/*  270 */         if (res.field_77994_a <= spaceLeft) {
/*  271 */           this.inv[output].field_77994_a += res.field_77994_a;
/*  272 */           break;
/*      */         }
/*  274 */         this.inv[output].field_77994_a += spaceLeft;
/*  275 */         res.field_77994_a -= spaceLeft;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  280 */     for (int input = 0; input < 4; input++)
/*  281 */       func_70298_a(input, 1);
/*      */   }
/*      */   
/*      */   public void puffSmoke(Random rand, World world, int x, int y, int z) {
/*  285 */     if (rand.nextInt(5) != 0) {
/*  286 */       return;
/*      */     }
/*  288 */     boolean chim = false;
/*      */     
/*  290 */     Block block = Block.field_71973_m[world.func_72798_a(x, y + 2, z)];
/*  291 */     IChimney chimney = null;
/*      */     
/*  293 */     if ((block instanceof IChimney)) {
/*  294 */       chimney = (IChimney)block;
/*      */     }
/*  296 */     if ((chimney != null) && (chimney.puffSmoke(world, x, y + 2, z, 0.083333336F, 1.0F, 1.0F))) {
/*  297 */       chim = true;
/*  298 */       return;
/*      */     }
/*      */     
/*  301 */     for (int x1 = -1; x1 <= 1; x1++) {
/*  302 */       for (int z1 = -1; z1 <= 1; z1++) {
/*  303 */         Block block1 = Block.field_71973_m[world.func_72798_a(x + x1, y + 2, z + z1)];
/*  304 */         IChimney chimney1 = null;
/*      */         
/*  306 */         if ((block1 instanceof IChimney)) {
/*  307 */           chimney1 = (IChimney)block1;
/*      */         }
/*  309 */         if ((chimney1 != null) && (chimney1.puffSmoke(world, x + x1, y + 2, z + z1, 0.083333336F, 1.0F, 1.0F))) {
/*  310 */           chim = true;
/*  311 */           break;
/*      */         }
/*      */       }
/*      */     }
/*  315 */     if (!chim) {
/*  316 */       for (int a = 0; a < 5; a++) {
/*  317 */         world.func_72869_a("largesmoke", x + 0.5F, y + 2, z + 0.5F, (rand.nextFloat() - 0.5F) / 6.0F, 0.06499999761581421D, (rand.nextFloat() - 0.5F) / 6.0F);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private int getMaxTime() {
/*  323 */     if (getType() == 1)
/*  324 */       return 300000;
/*  325 */     if (getType() == 2)
/*  326 */       return 250000;
/*  327 */     if (getType() == 2)
/*  328 */       return 200000;
/*  329 */     if (getType() == 4) {
/*  330 */       return 150000;
/*      */     }
/*  332 */     return 100000;
/*      */   }
/*      */   
/*      */   private void smeltItem(int input, int output) {
/*  336 */     ItemStack res = getResult(this.inv[input]).func_77946_l();
/*      */     
/*  338 */     if (this.inv[output] == null) {
/*  339 */       func_70299_a(output, res);
/*      */     }
/*  341 */     else if (this.inv[output].func_77969_a(res)) {
/*  342 */       this.inv[output].field_77994_a += res.field_77994_a;
/*      */     }
/*      */     
/*      */ 
/*  346 */     func_70298_a(input, 1);
/*      */   }
/*      */   
/*      */   private boolean canSmelt(ItemStack in, ItemStack out) {
/*  350 */     if (isHeater()) {
/*  351 */       return false;
/*      */     }
/*  353 */     if (!this.built) {
/*  354 */       return false;
/*      */     }
/*  356 */     ItemStack res = getResult(in);
/*  357 */     if (res == null) {
/*  358 */       return false;
/*      */     }
/*  360 */     if (out == null) {
/*  361 */       return true;
/*      */     }
/*  363 */     if (out.func_77969_a(res)) {
/*  364 */       int max = res.func_77976_d();
/*  365 */       if (out.field_77994_a + res.field_77994_a > max) {
/*  366 */         return false;
/*      */       }
/*      */     } else {
/*  369 */       return false;
/*      */     }
/*      */     
/*  372 */     return true;
/*      */   }
/*      */   
/*      */   private TileEntityFurnaceMF getHeater() {
/*  376 */     TileEntity tile = this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m - 1, this.field_70327_n);
/*  377 */     if ((tile != null) && ((tile instanceof TileEntityFurnaceMF)) && 
/*  378 */       (((TileEntityFurnaceMF)tile).isHeater())) {
/*  379 */       return (TileEntityFurnaceMF)tile;
/*      */     }
/*  381 */     return null;
/*      */   }
/*      */   
/*      */   private TileEntityFurnaceMF getFurnace() {
/*  385 */     TileEntity tile = this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m + 1, this.field_70327_n);
/*  386 */     if ((tile != null) && ((tile instanceof TileEntityFurnaceMF)) && 
/*  387 */       (!((TileEntityFurnaceMF)tile).isHeater())) {
/*  388 */       return (TileEntityFurnaceMF)tile;
/*      */     }
/*  390 */     return null;
/*      */   }
/*      */   
/*      */   private void updateHeater() {
/*  394 */     if (this.field_70331_k.field_72995_K) {
/*  395 */       return;
/*      */     }
/*  397 */     TileEntityFurnaceMF furn = getFurnace();
/*  398 */     if (furn != null) {
/*  399 */       this.aboveType = furn.getType();
/*      */     }
/*  401 */     if (!this.built) {
/*  402 */       this.heat = (this.maxHeat = this.fuel = this.maxFuel = 0);
/*  403 */       return;
/*      */     }
/*  405 */     if (this.heat < this.maxHeat) {
/*  406 */       this.heat += 1.0F;
/*      */     }
/*  408 */     if (this.heat > this.maxHeat) {
/*  409 */       this.heat -= 1.0F;
/*      */     }
/*  411 */     if (this.fuel > 0) {
/*  412 */       this.fuel -= 1;
/*      */     } else {
/*  414 */       if ((this.inv[0] != null) && (isItemFuel(this.inv[0]))) {
/*  415 */         this.fuel = (this.maxFuel = getItemBurnTime(this.inv[0]));
/*  416 */         this.maxHeat = getItemHeat(this.inv[0]);
/*      */         
/*  418 */         if (this.inv[0].func_77973_b().func_77634_r()) {
/*  419 */           this.inv[0] = this.inv[0].func_77973_b().getContainerItemStack(this.inv[0]);
/*      */         } else {
/*  421 */           func_70298_a(0, 1);
/*      */         }
/*      */       }
/*  424 */       if (this.fuel <= 0) {
/*  425 */         if (this.heat > 0.0F)
/*  426 */           this.heat -= 1.0F;
/*  427 */         this.maxHeat = 0.0F;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private float getItemHeat(ItemStack itemStack)
/*      */   {
/*  434 */     return ItemHandler.getForgeHeat(itemStack);
/*      */   }
/*      */   
/*      */   public ItemStack getResult(ItemStack item) {
/*  438 */     if ((item == null) || (item.func_77973_b() == null)) {
/*  439 */       return null;
/*      */     }
/*  441 */     if (getSpecialResult() != null) {
/*  442 */       return null;
/*      */     }
/*  444 */     ItemStack res = SpecialFurnaceRecipes.getSmeltingResult(item, getSmeltLevel());
/*      */     
/*  446 */     if (res == null)
/*      */     {
/*  448 */       res = FurnaceRecipes.func_77602_a().getSmeltingResult(item);
/*  449 */       if ((res == null) || (res.func_77973_b() == null)) {
/*  450 */         if ((item.func_77973_b() instanceof ItemFood)) {
/*  451 */           return new ItemStack(Item.field_77705_m.field_77779_bT, 1, 1);
/*      */         }
/*  453 */         return null; }
/*  454 */       if ((res.func_77973_b() instanceof ItemFood)) {
/*  455 */         return new ItemStack(Item.field_77705_m.field_77779_bT, 1, 1);
/*      */       }
/*      */     }
/*      */     
/*  459 */     return res;
/*      */   }
/*      */   
/*      */   public ItemStack getSpecialResult() {
/*  463 */     ItemStack[] input = new ItemStack[4];
/*  464 */     for (int a = 0; a < 4; a++) {
/*  465 */       input[a] = this.inv[a];
/*      */     }
/*  467 */     Alloy alloy = SpecialFurnaceRecipes.getResult(input);
/*  468 */     if ((alloy != null) && 
/*  469 */       (alloy.getLevel() <= getSmeltLevel())) {
/*  470 */       return SpecialFurnaceRecipes.getResult(input).getRecipeOutput();
/*      */     }
/*      */     
/*  473 */     return null;
/*      */   }
/*      */   
/*      */   public int func_70302_i_() {
/*  477 */     return this.inv.length;
/*      */   }
/*      */   
/*      */   public ItemStack func_70301_a(int i) {
/*  481 */     return this.inv[i];
/*      */   }
/*      */   
/*      */   public ItemStack func_70298_a(int i, int j) {
/*  485 */     if (this.inv[i] != null) {
/*  486 */       if (this.inv[i].field_77994_a <= j) {
/*  487 */         ItemStack itemstack = this.inv[i];
/*  488 */         this.inv[i] = null;
/*  489 */         return itemstack;
/*      */       }
/*  491 */       ItemStack itemstack1 = this.inv[i].func_77979_a(j);
/*  492 */       if (this.inv[i].field_77994_a == 0) {
/*  493 */         this.inv[i] = null;
/*      */       }
/*  495 */       return itemstack1;
/*      */     }
/*  497 */     return null;
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public int getBurnTimeRemainingScaled(int height)
/*      */   {
/*  503 */     if (this.maxFuel == 0) {
/*  504 */       this.maxFuel = 200;
/*      */     }
/*      */     
/*  507 */     return this.fuel * height / this.maxFuel;
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public int getHeatScaled(int height) {
/*  512 */     if (this.heat <= 0.0F)
/*  513 */       return 0;
/*  514 */     int size = (int)this.heat * height / ItemHandler.forgeMaxTemp;
/*      */     
/*  516 */     return Math.min(size, height);
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public int getItemHeatScaled(int height) {
/*  521 */     if (this.maxHeat <= 0.0F)
/*  522 */       return 0;
/*  523 */     int size = (int)this.maxHeat * height / ItemHandler.forgeMaxTemp;
/*      */     
/*  525 */     return Math.min(size, height);
/*      */   }
/*      */   
/*      */   public void func_70299_a(int i, ItemStack itemstack) {
/*  529 */     this.inv[i] = itemstack;
/*  530 */     if ((itemstack != null) && (itemstack.field_77994_a > func_70297_j_())) {
/*  531 */       itemstack.field_77994_a = func_70297_j_();
/*      */     }
/*      */   }
/*      */   
/*      */   public String func_70303_b() {
/*  536 */     int t = getType();
/*  537 */     String tier = "";
/*      */     
/*  539 */     if (isHeater()) {
/*  540 */       return StatCollector.func_74838_a("tile.furnace.name") + " " + StatCollector.func_74838_a("block.furnace.heater");
/*      */     }
/*      */     
/*  543 */     if (t == 1) {
/*  544 */       tier = StatCollector.func_74838_a("tier.bronze");
/*      */     }
/*  546 */     if (t == 2) {
/*  547 */       tier = StatCollector.func_74838_a("tier.iron");
/*      */     }
/*  549 */     if (t == 3) {
/*  550 */       tier = StatCollector.func_74838_a("tier.steel");
/*      */     }
/*  552 */     if (t == 4) {
/*  553 */       tier = StatCollector.func_74838_a("tier.iron.deep");
/*      */     }
/*      */     
/*  556 */     return tier + " " + StatCollector.func_74838_a("tile.furnace.name");
/*      */   }
/*      */   
/*      */   public int getSmeltLevel() {
/*  560 */     if (isHeater()) {
/*  561 */       return -1;
/*      */     }
/*  563 */     return getType() - 1;
/*      */   }
/*      */   
/*      */   public void func_70307_a(NBTTagCompound nbt) {
/*  567 */     super.func_70307_a(nbt);
/*  568 */     NBTTagList nbttaglist = nbt.func_74761_m("Items");
/*  569 */     this.inv = new ItemStack[func_70302_i_()];
/*  570 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*  571 */       NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.func_74743_b(i);
/*  572 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/*  573 */       if ((byte0 >= 0) && (byte0 < this.inv.length)) {
/*  574 */         this.inv[byte0] = ItemStack.func_77949_a(nbttagcompound1);
/*      */       }
/*      */     }
/*      */     
/*  578 */     this.justShared = nbt.func_74762_e("Shared");
/*  579 */     this.built = nbt.func_74767_n("Built");
/*      */     
/*  581 */     this.fuel = nbt.func_74762_e("fuel");
/*  582 */     this.maxFuel = nbt.func_74762_e("MaxFuel");
/*      */     
/*  584 */     this.heat = nbt.func_74760_g("heat");
/*  585 */     this.maxHeat = nbt.func_74760_g("maxHeat");
/*      */     
/*  587 */     this.direction = nbt.func_74762_e("Dir");
/*  588 */     this.progress = nbt.func_74762_e("progress");
/*  589 */     this.aboveType = nbt.func_74762_e("Level");
/*      */   }
/*      */   
/*      */   public void func_70310_b(NBTTagCompound nbt) {
/*  593 */     super.func_70310_b(nbt);
/*      */     
/*  595 */     nbt.func_74768_a("Shared", this.justShared);
/*  596 */     nbt.func_74768_a("Level", this.aboveType);
/*  597 */     nbt.func_74757_a("Built", this.built);
/*      */     
/*  599 */     nbt.func_74768_a("fuel", this.fuel);
/*  600 */     nbt.func_74768_a("maxFuel", this.maxFuel);
/*      */     
/*  602 */     nbt.func_74776_a("heat", this.heat);
/*  603 */     nbt.func_74776_a("maxHeat", this.maxHeat);
/*      */     
/*  605 */     nbt.func_74768_a("Dir", this.direction);
/*  606 */     nbt.func_74768_a("progress", this.progress);
/*      */     
/*  608 */     NBTTagList nbttaglist = new NBTTagList();
/*  609 */     for (int i = 0; i < this.inv.length; i++) {
/*  610 */       if (this.inv[i] != null) {
/*  611 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/*  612 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/*  613 */         this.inv[i].func_77955_b(nbttagcompound1);
/*  614 */         nbttaglist.func_74742_a(nbttagcompound1);
/*      */       }
/*      */     }
/*      */     
/*  618 */     nbt.func_74782_a("Items", nbttaglist);
/*      */   }
/*      */   
/*      */   public int func_70297_j_() {
/*  622 */     return 64;
/*      */   }
/*      */   
/*      */   public boolean isBurning() {
/*  626 */     if (isHeater()) {
/*  627 */       return this.heat > 0.0F;
/*      */     }
/*  629 */     return (this.progress > 0) && (this.heat > 0.0F);
/*      */   }
/*      */   
/*      */   public boolean isHeater() {
/*  633 */     return getType() == 0;
/*      */   }
/*      */   
/*      */   public int getItemBurnTime(ItemStack itemstack) {
/*  637 */     if (itemstack == null) {
/*  638 */       return 0;
/*      */     }
/*  640 */     return TileEntityFurnace.func_70398_a(itemstack);
/*      */   }
/*      */   
/*      */   public boolean func_70300_a(EntityPlayer entityplayer) {
/*  644 */     if (this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m, this.field_70327_n) != this) {
/*  645 */       return false;
/*      */     }
/*  647 */     return entityplayer.func_70092_e(this.field_70329_l + 0.5D, this.field_70330_m + 0.5D, this.field_70327_n + 0.5D) <= 64.0D;
/*      */   }
/*      */   
/*      */   public void func_70295_k_() {
/*  651 */     if (this.numUsers == 0) {
/*  652 */       this.field_70331_k.func_72908_a(this.field_70329_l + 0.5D, this.field_70330_m + 0.5D, this.field_70327_n + 0.5D, MFResource.sound("furnaceOpen"), 0.5F, this.field_70331_k.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*      */     }
/*  654 */     this.numUsers += 1;
/*      */   }
/*      */   
/*      */   public void func_70305_f() {
/*  658 */     this.numUsers -= 1;
/*  659 */     if ((this.numUsers == 0) && (this.doorAngle >= 15)) {
/*  660 */       this.field_70331_k.func_72908_a(this.field_70329_l + 0.5D, this.field_70330_m + 0.5D, this.field_70327_n + 0.5D, MFResource.sound("furnaceClose"), 0.5F, this.field_70331_k.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*      */     }
/*      */   }
/*      */   
/*      */   public ItemStack func_70304_b(int var1)
/*      */   {
/*  666 */     return null;
/*      */   }
/*      */   
/*      */   private void sendPacketToClients() {
/*  670 */     if (!this.field_70331_k.field_72995_K) {
/*      */       try {
/*  672 */         Packet packet = PacketManagerMF.getPacketIntegerArray(this, new int[] { this.fuel, this.progress, this.direction, (int)this.heat, isBurning() ? 1 : 0, this.justShared, this.doorAngle });
/*      */         
/*  674 */         FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*      */       } catch (Exception e) {
/*  676 */         e.printStackTrace();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void recievePacket(ByteArrayDataInput data)
/*      */   {
/*  683 */     this.fuel = data.readInt();
/*  684 */     this.progress = data.readInt();
/*  685 */     this.direction = data.readInt();
/*  686 */     this.heat = data.readInt();
/*  687 */     int burn = data.readInt();
/*  688 */     this.isBurningClient = (burn == 1);
/*  689 */     this.justShared = data.readInt();
/*  690 */     this.doorAngle = data.readInt();
/*      */   }
/*      */   
/*      */   public int func_70322_n() {
/*  694 */     if (this.field_70331_k == null) {
/*  695 */       return this.itemMeta * 2;
/*      */     }
/*  697 */     if (this.field_70325_p == -1) {
/*  698 */       this.field_70325_p = this.field_70331_k.func_72805_g(this.field_70329_l, this.field_70330_m, this.field_70327_n);
/*      */     }
/*      */     
/*  701 */     return this.field_70325_p;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getType()
/*      */   {
/*  708 */     int meta = func_70322_n();
/*  709 */     return (int)Math.floor(meta / 2);
/*      */   }
/*      */   
/*      */   private int getOnMetadata() {
/*  713 */     return getType() * 2 + 1;
/*      */   }
/*      */   
/*      */   private int getOffMetadata() {
/*  717 */     return getType() * 2;
/*      */   }
/*      */   
/*      */   public boolean func_94042_c()
/*      */   {
/*  722 */     return true;
/*      */   }
/*      */   
/*      */   public int[] func_94128_d(int side)
/*      */   {
/*  727 */     if (isHeater()) {
/*  728 */       return new int[] { 0 };
/*      */     }
/*  730 */     return new int[] { 0, 1, 2, 3, 4, 5, 6, 7 };
/*      */   }
/*      */   
/*      */   public boolean func_102007_a(int slot, ItemStack item, int side)
/*      */   {
/*  735 */     if (isHeater()) {
/*  736 */       return (slot == 0) && (isItemFuel(item));
/*      */     }
/*  738 */     return (slot < 4) && (getResult(item) != null);
/*      */   }
/*      */   
/*      */   public boolean func_94041_b(int slot, ItemStack item)
/*      */   {
/*  743 */     return func_102007_a(slot, item, 0);
/*      */   }
/*      */   
/*      */   public boolean isItemFuel(ItemStack item) {
/*  747 */     return getItemBurnTime(item) > 0;
/*      */   }
/*      */   
/*      */   public boolean func_102008_b(int slot, ItemStack item, int side)
/*      */   {
/*  752 */     if (!isHeater()) {
/*  753 */       return slot >= 4;
/*      */     }
/*  755 */     return item.field_77993_c == Item.field_77788_aw.field_77779_bT;
/*      */   }
/*      */   
/*      */   public int getCookProgressScaled(int i) {
/*  759 */     return this.progress * i / getMaxTime();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean isBlockValidForSide(int x, int y, int z)
/*      */   {
/*  771 */     if (this.field_70331_k == null) {
/*  772 */       return false;
/*      */     }
/*      */     
/*  775 */     Block block = Block.field_71973_m[this.field_70331_k.func_72798_a(x, y, z)];
/*      */     
/*  777 */     if (block == null) {
/*  778 */       return false;
/*      */     }
/*      */     
/*  781 */     if (block.field_71990_ca == this.field_70331_k.func_72798_a(this.field_70329_l, this.field_70330_m, this.field_70327_n)) {
/*  782 */       return true;
/*      */     }
/*  784 */     return isBlockValidForTop(x, y, z);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean isBlockValidForTop(int x, int y, int z)
/*      */   {
/*  797 */     if (this.field_70331_k == null) {
/*  798 */       return false;
/*      */     }
/*      */     
/*  801 */     Block block = Block.field_71973_m[this.field_70331_k.func_72798_a(x, y, z)];
/*      */     
/*  803 */     if (block == null) {
/*  804 */       return false;
/*      */     }
/*      */     
/*  807 */     if (isHeater()) {
/*  808 */       float hardness = getBaseFor();
/*      */       
/*  810 */       return isBlockCorrectBase(block, x, y, z, hardness);
/*      */     }
/*      */     
/*  813 */     int id = block.field_71990_ca;
/*  814 */     int meta = this.field_70331_k.func_72805_g(x, y, z);
/*      */     
/*  816 */     String metal = getWalls();
/*  817 */     return isMetal(getWalls(), id, meta);
/*      */   }
/*      */   
/*      */   private boolean isBlockCorrectBase(Block block, int x, int y, int z, float hardness) {
/*  821 */     return (block.func_71926_d()) && (this.field_70331_k.func_72803_f(x, y, z) == Material.field_76246_e) && (block.func_71934_m(this.field_70331_k, x, y, z) >= hardness);
/*      */   }
/*      */   
/*      */   private String getWalls() {
/*  825 */     switch (getType()) {
/*      */     case 1: 
/*  827 */       return "Bronze";
/*      */     case 2: 
/*  829 */       return "Iron";
/*      */     case 3: 
/*  831 */       return "Steel";
/*      */     case 4: 
/*  833 */       return "DeepIron";
/*      */     }
/*  835 */     return "Bronze";
/*      */   }
/*      */   
/*      */   private float getBaseFor() {
/*  839 */     switch (this.aboveType) {
/*      */     case 2: 
/*  841 */       return 2.0F;
/*      */     case 3: 
/*  843 */       return 5.0F;
/*      */     case 4: 
/*  845 */       return 10.0F;
/*      */     }
/*  847 */     return 0.0F;
/*      */   }
/*      */   
/*      */   public boolean isBlockValidForSide(ForgeDirection side) {
/*  851 */     if (this.field_70331_k == null) {
/*  852 */       return false;
/*      */     }
/*      */     
/*  855 */     int x = this.field_70329_l + side.offsetX;
/*  856 */     int y = this.field_70330_m + side.offsetY;
/*  857 */     int z = this.field_70327_n + side.offsetZ;
/*      */     
/*  859 */     return isBlockValidForSide(x, y, z);
/*      */   }
/*      */   
/*      */   public boolean isSolid(ForgeDirection side) {
/*  863 */     if (this.field_70331_k == null) {
/*  864 */       return false;
/*      */     }
/*      */     
/*  867 */     int x = this.field_70329_l + side.offsetX;
/*  868 */     int y = this.field_70330_m + side.offsetY;
/*  869 */     int z = this.field_70327_n + side.offsetZ;
/*      */     
/*  871 */     Material mat = this.field_70331_k.func_72803_f(x, y, z);
/*      */     
/*  873 */     if (mat == null) {
/*  874 */       return false;
/*      */     }
/*  876 */     return mat.func_76220_a();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean structureExists()
/*      */   {
/*  884 */     if (this.field_70331_k == null) {
/*  885 */       return false;
/*      */     }
/*      */     
/*  888 */     if (isSolid(getFront())) {
/*  889 */       return false;
/*      */     }
/*      */     
/*  892 */     if ((!isHeater()) && (!isBlockValidForTop(this.field_70329_l, this.field_70330_m + 1, this.field_70327_n))) {
/*  893 */       return false;
/*      */     }
/*      */     
/*  896 */     if (!isBlockValidForSide(getLeft())) {
/*  897 */       return false;
/*      */     }
/*  899 */     if (!isBlockValidForSide(getRight())) {
/*  900 */       return false;
/*      */     }
/*  902 */     if (!isBlockValidForSide(getBack())) {
/*  903 */       return false;
/*      */     }
/*      */     
/*  906 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public ForgeDirection getFront()
/*      */   {
/*  913 */     if (this.direction == 0)
/*      */     {
/*  915 */       return ForgeDirection.NORTH;
/*      */     }
/*  917 */     if (this.direction == 1)
/*      */     {
/*  919 */       return ForgeDirection.EAST;
/*      */     }
/*  921 */     if (this.direction == 2)
/*      */     {
/*  923 */       return ForgeDirection.SOUTH;
/*      */     }
/*  925 */     if (this.direction == 3)
/*      */     {
/*  927 */       return ForgeDirection.WEST;
/*      */     }
/*  929 */     return ForgeDirection.UNKNOWN;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public ForgeDirection getBack()
/*      */   {
/*  936 */     if (this.direction == 0)
/*      */     {
/*  938 */       return ForgeDirection.SOUTH;
/*      */     }
/*  940 */     if (this.direction == 1)
/*      */     {
/*  942 */       return ForgeDirection.WEST;
/*      */     }
/*  944 */     if (this.direction == 2)
/*      */     {
/*  946 */       return ForgeDirection.NORTH;
/*      */     }
/*  948 */     if (this.direction == 3)
/*      */     {
/*  950 */       return ForgeDirection.EAST;
/*      */     }
/*  952 */     return ForgeDirection.UNKNOWN;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public ForgeDirection getLeft()
/*      */   {
/*  959 */     if (this.direction == 0)
/*      */     {
/*  961 */       return ForgeDirection.WEST;
/*      */     }
/*  963 */     if (this.direction == 1)
/*      */     {
/*  965 */       return ForgeDirection.NORTH;
/*      */     }
/*  967 */     if (this.direction == 2)
/*      */     {
/*  969 */       return ForgeDirection.EAST;
/*      */     }
/*  971 */     if (this.direction == 3)
/*      */     {
/*  973 */       return ForgeDirection.SOUTH;
/*      */     }
/*  975 */     return ForgeDirection.UNKNOWN;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public ForgeDirection getRight()
/*      */   {
/*  982 */     if (this.direction == 0)
/*      */     {
/*  984 */       return ForgeDirection.EAST;
/*      */     }
/*  986 */     if (this.direction == 1)
/*      */     {
/*  988 */       return ForgeDirection.SOUTH;
/*      */     }
/*  990 */     if (this.direction == 2)
/*      */     {
/*  992 */       return ForgeDirection.WEST;
/*      */     }
/*  994 */     if (this.direction == 3)
/*      */     {
/*  996 */       return ForgeDirection.NORTH;
/*      */     }
/*  998 */     return ForgeDirection.UNKNOWN;
/*      */   }
/*      */   
/*      */   public boolean isMetal(String ore, int id, int meta) {
/* 1002 */     for (ItemStack block : OreDictionary.getOres("block" + ore)) {
/* 1003 */       if ((block.field_77993_c == id) && ((block.func_77960_j() == 32767) || (block.func_77960_j() == meta))) {
/* 1004 */         return true;
/*      */       }
/*      */     }
/* 1007 */     return false;
/*      */   }
/*      */   
/*      */   public String getTexture() {
/* 1011 */     switch (getType()) {
/*      */     case 1: 
/* 1013 */       return "FurnaceMF_bronze";
/*      */     case 2: 
/* 1015 */       return "FurnaceMF_iron";
/*      */     case 3: 
/* 1017 */       return "FurnaceMF_steel";
/*      */     case 4: 
/* 1019 */       return "FurnaceMF_deep";
/*      */     }
/*      */     
/* 1022 */     return "FurnaceMF_rock";
/*      */   }
/*      */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/TileEntityFurnaceMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */