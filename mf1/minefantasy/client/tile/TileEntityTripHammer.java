/*     */ package minefantasy.client.tile;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Random;
/*     */ import minefantasy.api.forge.HeatableItem;
/*     */ import minefantasy.api.refine.CrushRecipes;
/*     */ import minefantasy.item.ItemHotItem;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.system.MFResource;
/*     */ import minefantasy.system.cfg;
/*     */ import minefantasy.system.network.PacketManagerMF;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
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
/*     */ public class TileEntityTripHammer extends TileEntity implements minefantasy.system.network.PacketUserMF, IInventory, net.minecraft.inventory.ISidedInventory
/*     */ {
/*     */   public int direction;
/*  30 */   public int angle = 0;
/*     */   public int force;
/*  32 */   Random rand = new Random();
/*     */   private ItemStack[] inv;
/*     */   public int itemMetadata;
/*     */   
/*     */   public TileEntityTripHammer() {
/*  37 */     this.inv = new ItemStack[2];
/*     */   }
/*     */   
/*     */   public TileEntityTripHammer(int metadata) {
/*  41 */     this();
/*  42 */     this.itemMetadata = metadata;
/*     */   }
/*     */   
/*     */   public void interact(int power) {
/*  46 */     if (this.field_70331_k.field_72995_K) {
/*  47 */       return;
/*     */     }
/*  49 */     this.force = 2;
/*  50 */     this.angle += power;
/*  51 */     if (this.angle >= getMaxArm()) {
/*  52 */       this.angle = 0;
/*  53 */       hitHammer();
/*     */     }
/*     */   }
/*     */   
/*     */   private void spawnParticle(ItemStack item) {
/*  58 */     int x = this.field_70329_l;
/*  59 */     int y = this.field_70330_m;
/*  60 */     int z = this.field_70327_n;
/*     */     
/*  62 */     ForgeDirection dir = getFacing();
/*  63 */     double x1 = 0.0D + dir.offsetX * 0.4D;
/*  64 */     double z1 = 0.0D + dir.offsetZ * 0.4D;
/*     */     
/*  66 */     this.field_70331_k.func_72869_a("crit", x - 0.5D + x1, y - 0.5D, z - 0.5D + z1, 0.0D, 0.0D, 0.0D);
/*  67 */     this.field_70331_k.func_72869_a("smoke", x - 0.5D + x1, y - 0.5D, z - 0.5D + z1, 0.0D, 0.0D, 0.0D);
/*  68 */     if (item != null) {
/*  69 */       this.field_70331_k.func_72869_a("tilecrack_" + item.func_77973_b().field_77779_bT, this.field_70329_l + dir.offsetX * 0.4D, this.field_70330_m, this.field_70327_n + dir.offsetZ * 0.4D, (-0.5D + this.rand.nextDouble()) * 0.1D, 0.2D * this.rand.nextDouble(), (-0.5D + this.rand.nextDouble()) * 0.1D);
/*     */     }
/*  71 */     this.field_70331_k.func_72908_a(this.field_70329_l, this.field_70330_m, this.field_70327_n, MFResource.sound("AnvilSucceed"), 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   private ForgeDirection getFacing() {
/*  75 */     switch (this.direction)
/*     */     {
/*     */     case 0: 
/*  78 */       return ForgeDirection.SOUTH;
/*     */     case 1: 
/*  80 */       return ForgeDirection.WEST;
/*     */     case 2: 
/*  82 */       return ForgeDirection.NORTH;
/*     */     case 3: 
/*  84 */       return ForgeDirection.EAST;
/*     */     }
/*  86 */     return ForgeDirection.SOUTH;
/*     */   }
/*     */   
/*     */   private void hitHammer() {
/*  90 */     ItemStack res = getResult(this.inv[0]);
/*  91 */     spawnParticle(this.inv[0]);
/*     */     
/*  93 */     boolean craft = false;
/*     */     
/*  95 */     if (res != null) {
/*  96 */       if (this.inv[1] == null) {
/*  97 */         this.inv[1] = res.func_77946_l();
/*  98 */         craft = true;
/*  99 */       } else if (this.inv[1].func_77969_a(res)) {
/* 100 */         int total = res.field_77994_a + this.inv[1].field_77994_a;
/* 101 */         if (total <= res.func_77976_d()) {
/* 102 */           craft = true;
/* 103 */           this.inv[1].field_77994_a += res.field_77994_a;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 108 */     if (craft) {
/* 109 */       func_70298_a(0, 1);
/*     */     }
/*     */   }
/*     */   
/*     */   private ItemStack getResult() {
/* 114 */     return getResult(this.inv[0]);
/*     */   }
/*     */   
/*     */   private ItemStack getResult(ItemStack item) {
/* 118 */     if (item == null) {
/* 119 */       return null;
/*     */     }
/* 121 */     ItemStack input = item.func_77946_l();
/* 122 */     if (HeatableItem.canHeatItem(input)) {
/* 123 */       return null;
/*     */     }
/* 125 */     if ((input != null) && 
/* 126 */       (input.field_77993_c == ItemListMF.hotItem.field_77779_bT)) {
/* 127 */       input = ItemHotItem.getItem(input);
/*     */       
/* 129 */       int temp = ItemHotItem.getTemp(item);
/* 130 */       if (!HeatableItem.canWorkItem(input, temp)) {
/* 131 */         return null;
/*     */       }
/*     */     }
/* 134 */     return CrushRecipes.getResult(input);
/*     */   }
/*     */   
/*     */   public float getArmValue() {
/* 138 */     return this.angle / getMaxArm();
/*     */   }
/*     */   
/*     */   public int getMaxArm() {
/* 142 */     if (getType() == 1) {
/* 143 */       return 10;
/*     */     }
/* 145 */     return 45;
/*     */   }
/*     */   
/*     */   public void func_70316_g()
/*     */   {
/* 150 */     super.func_70316_g();
/* 151 */     if (getType() == 0) {
/* 152 */       updateEntity1();
/*     */     } else {
/* 154 */       updateEntity2();
/*     */     }
/* 156 */     sendPacketToClients();
/*     */   }
/*     */   
/*     */   private void updateEntity2() {
/* 160 */     if ((this.force > 0) || (automate())) {
/* 161 */       this.force -= 1;
/* 162 */       ForgeDirection fd = getFacing();
/* 163 */       TileEntity tile = this.field_70331_k.func_72796_p(this.field_70329_l + fd.offsetX, this.field_70330_m + fd.offsetY, this.field_70327_n + fd.offsetZ);
/* 164 */       if ((tile != null) && ((tile instanceof TileEntityTripHammer))) {
/* 165 */         TileEntityTripHammer hammer = (TileEntityTripHammer)tile;
/* 166 */         if (hammer.getFacing() == getFacing()) {
/* 167 */           hammer.interact(4);
/*     */         }
/*     */       }
/* 170 */       this.angle += 1;
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean automate() {
/* 175 */     if (!cfg.redstoneHammer) {
/* 176 */       return false;
/*     */     }
/* 178 */     if (this.field_70331_k.func_72864_z(this.field_70329_l, this.field_70330_m, this.field_70327_n)) {
/* 179 */       ForgeDirection fd = getFacing();
/* 180 */       TileEntity tile = this.field_70331_k.func_72796_p(this.field_70329_l + fd.offsetX, this.field_70330_m + fd.offsetY, this.field_70327_n + fd.offsetZ);
/* 181 */       if ((tile != null) && ((tile instanceof TileEntityTripHammer))) {
/* 182 */         TileEntityTripHammer hammer = (TileEntityTripHammer)tile;
/* 183 */         if ((hammer.getFacing() == getFacing()) && 
/* 184 */           (hammer.getResult() != null)) {
/* 185 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 190 */     return false;
/*     */   }
/*     */   
/*     */   public void updateEntity1() {
/* 194 */     if (this.force <= 0) {
/* 195 */       if (this.angle > 0)
/* 196 */         this.angle -= 1;
/* 197 */       if (this.angle < 0)
/* 198 */         this.angle = 0;
/*     */     } else {
/* 200 */       this.force -= 1;
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70307_a(NBTTagCompound nbt) {
/* 205 */     super.func_70307_a(nbt);
/* 206 */     this.direction = nbt.func_74762_e("direction");
/* 207 */     this.angle = nbt.func_74762_e("angle");
/* 208 */     this.force = nbt.func_74762_e("Force");
/*     */     
/* 210 */     NBTTagList nbttaglist = nbt.func_74761_m("Items");
/* 211 */     this.inv = new ItemStack[func_70302_i_()];
/* 212 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/* 213 */       NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.func_74743_b(i);
/* 214 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 215 */       if ((byte0 >= 0) && (byte0 < this.inv.length)) {
/* 216 */         this.inv[byte0] = ItemStack.func_77949_a(nbttagcompound1);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void sendPacketToClients() {
/* 222 */     if (!this.field_70331_k.field_72995_K) {
/* 223 */       Packet packet = PacketManagerMF.getPacketIntegerArray(this, new int[] { this.angle, this.direction, this.force });
/*     */       try {
/* 225 */         FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*     */       } catch (NullPointerException e) {
/* 227 */         System.out.println("MineFantasy: Client connection lost");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70310_b(NBTTagCompound nbt) {
/* 233 */     super.func_70310_b(nbt);
/* 234 */     nbt.func_74768_a("direction", this.direction);
/* 235 */     nbt.func_74768_a("angle", this.angle);
/* 236 */     nbt.func_74768_a("Force", this.force);
/*     */     
/* 238 */     NBTTagList nbttaglist = new NBTTagList();
/* 239 */     for (int i = 0; i < this.inv.length; i++) {
/* 240 */       if (this.inv[i] != null) {
/* 241 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 242 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 243 */         this.inv[i].func_77955_b(nbttagcompound1);
/* 244 */         nbttaglist.func_74742_a(nbttagcompound1);
/*     */       }
/*     */     }
/*     */     
/* 248 */     nbt.func_74782_a("Items", nbttaglist);
/*     */   }
/*     */   
/*     */   public void recievePacket(ByteArrayDataInput data)
/*     */   {
/* 253 */     this.angle = data.readInt();
/* 254 */     this.direction = data.readInt();
/* 255 */     this.force = data.readInt();
/*     */   }
/*     */   
/*     */   public int func_70302_i_() {
/* 259 */     return this.inv.length;
/*     */   }
/*     */   
/*     */   public ItemStack func_70301_a(int i) {
/* 263 */     return this.inv[i];
/*     */   }
/*     */   
/*     */   public ItemStack func_70298_a(int i, int j) {
/* 267 */     if (this.inv[i] != null) {
/* 268 */       if (this.inv[i].field_77994_a <= j) {
/* 269 */         ItemStack itemstack = this.inv[i];
/* 270 */         this.inv[i] = null;
/* 271 */         return itemstack;
/*     */       }
/* 273 */       ItemStack itemstack1 = this.inv[i].func_77979_a(j);
/* 274 */       if (this.inv[i].field_77994_a == 0) {
/* 275 */         this.inv[i] = null;
/*     */       }
/* 277 */       return itemstack1;
/*     */     }
/* 279 */     return null;
/*     */   }
/*     */   
/*     */   public void func_70299_a(int i, ItemStack itemstack)
/*     */   {
/* 284 */     this.inv[i] = itemstack;
/* 285 */     if ((itemstack != null) && (itemstack.field_77994_a > func_70297_j_())) {
/* 286 */       itemstack.field_77994_a = func_70297_j_();
/*     */     }
/*     */   }
/*     */   
/*     */   public String func_70303_b()
/*     */   {
/* 292 */     return "Trip Hammer";
/*     */   }
/*     */   
/*     */   public boolean func_94042_c()
/*     */   {
/* 297 */     return true;
/*     */   }
/*     */   
/*     */   public int func_70297_j_()
/*     */   {
/* 302 */     return 64;
/*     */   }
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer entityplayer)
/*     */   {
/* 307 */     if (this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m, this.field_70327_n) != this) {
/* 308 */       return false;
/*     */     }
/* 310 */     return entityplayer.func_70092_e(this.field_70329_l + 0.5D, this.field_70330_m + 0.5D, this.field_70327_n + 0.5D) <= 64.0D;
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
/*     */   public boolean func_94041_b(int i, ItemStack itemstack)
/*     */   {
/* 323 */     return getResult(itemstack) != null;
/*     */   }
/*     */   
/*     */   public ItemStack func_70304_b(int i)
/*     */   {
/* 328 */     return null;
/*     */   }
/*     */   
/*     */   public int[] func_94128_d(int side)
/*     */   {
/* 333 */     return new int[] { 0, 1 };
/*     */   }
/*     */   
/*     */   public boolean func_102007_a(int slot, ItemStack item, int side)
/*     */   {
/* 338 */     return slot == 0;
/*     */   }
/*     */   
/*     */   public boolean func_102008_b(int slot, ItemStack item, int side)
/*     */   {
/* 343 */     return slot == 1;
/*     */   }
/*     */   
/*     */   public int getType() {
/* 347 */     return func_70322_n();
/*     */   }
/*     */   
/*     */   public int func_70322_n()
/*     */   {
/* 352 */     if (this.field_70331_k == null) {
/* 353 */       return this.itemMetadata;
/*     */     }
/* 355 */     if (this.field_70325_p == -1) {
/* 356 */       this.field_70325_p = this.field_70331_k.func_72805_g(this.field_70329_l, this.field_70330_m, this.field_70327_n);
/*     */     }
/*     */     
/* 359 */     return this.field_70325_p;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/TileEntityTripHammer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */