/*     */ package minefantasy.client.tile;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.PrintStream;
/*     */ import minefantasy.api.tailor.StringRecipes;
/*     */ import minefantasy.block.special.BlockClickHelper;
/*     */ import minefantasy.system.network.PacketManagerMF;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.entity.Entity;
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
/*     */ 
/*     */ public class TileEntitySpinningWheel extends TileEntity implements IInventory, net.minecraft.inventory.ISidedInventory, minefantasy.api.IMFCrafter, minefantasy.system.network.PacketUserMF
/*     */ {
/*  27 */   private ItemStack[] inv = new ItemStack[3];
/*     */   
/*     */   public int direction;
/*     */   private int progress;
/*     */   private int maxProgress;
/*     */   private StringRecipes recipe;
/*     */   private int ticksExisted;
/*     */   private int spinAngle;
/*     */   private int lastUsedTime;
/*     */   
/*     */   public boolean use(EntityPlayer player)
/*     */   {
/*  39 */     if (player == null) {
/*  40 */       return false;
/*     */     }
/*  42 */     if (canCraft()) {
/*  43 */       this.progress += 1;
/*  44 */       this.lastUsedTime = 10;
/*  45 */       player.func_71038_i();
/*  46 */       return true;
/*     */     }
/*  48 */     return false;
/*     */   }
/*     */   
/*     */   public void func_70316_g()
/*     */   {
/*  53 */     super.func_70316_g();
/*  54 */     this.ticksExisted += 1;
/*     */     
/*  56 */     if (!this.field_70331_k.field_72995_K) {
/*  57 */       if (!canCraft()) {
/*  58 */         this.progress = 0;
/*     */       }
/*  60 */       if ((this.progress >= this.maxProgress) && (this.maxProgress > 0)) {
/*  61 */         craftItem();
/*     */       }
/*  63 */       sendPacketToClients();
/*     */     }
/*     */     
/*  66 */     if (this.spinAngle == 20) {
/*  67 */       this.spinAngle = 0;
/*  68 */       this.spinAngle += 1;
/*  69 */       this.field_70331_k.func_72908_a(this.field_70329_l + 0.5D, this.field_70330_m + 0.5D, this.field_70327_n + 0.5D, "random.click", 0.2F, 0.2F);
/*  70 */     } else if ((this.spinAngle == 5) || (this.spinAngle == 9) || (this.spinAngle == 11)) {
/*  71 */       this.spinAngle += 1;
/*  72 */       this.field_70331_k.func_72908_a(this.field_70329_l + 0.5D, this.field_70330_m + 0.5D, this.field_70327_n + 0.5D, "random.click", 0.1F, 0.8F);
/*     */     }
/*  74 */     else if (this.lastUsedTime > 0) {
/*  75 */       this.spinAngle += 1;
/*  76 */       this.lastUsedTime -= 1;
/*     */     }
/*     */     
/*     */ 
/*  80 */     if (this.ticksExisted % 10 == 0) {
/*  81 */       syncItems();
/*     */     }
/*     */   }
/*     */   
/*     */   private void craftItem() {
/*  86 */     if (!canCraft()) {
/*  87 */       return;
/*     */     }
/*  89 */     ItemStack res = getResult().func_77946_l();
/*  90 */     ItemStack out = func_70301_a(2);
/*     */     
/*  92 */     func_70298_a(1, 1);
/*     */     
/*  94 */     if (out == null) {
/*  95 */       func_70299_a(2, res);
/*     */     } else {
/*  97 */       out.field_77994_a += res.field_77994_a;
/*     */     }
/*  99 */     this.progress = 0;
/* 100 */     func_70298_a(0, 1);
/*     */   }
/*     */   
/*     */   public void func_70310_b(NBTTagCompound nbt)
/*     */   {
/* 105 */     super.func_70310_b(nbt);
/* 106 */     NBTTagList itemTag = new NBTTagList();
/*     */     
/* 108 */     nbt.func_74768_a("Dir", this.direction);
/* 109 */     nbt.func_74768_a("Ticks", this.ticksExisted);
/*     */     
/* 111 */     for (int num = 0; num < this.inv.length; num++) {
/* 112 */       if (this.inv[num] != null) {
/* 113 */         NBTTagCompound nbtInv = new NBTTagCompound();
/* 114 */         nbtInv.func_74774_a("Slot", (byte)num);
/* 115 */         this.inv[num].func_77955_b(nbtInv);
/* 116 */         itemTag.func_74742_a(nbtInv);
/*     */       }
/*     */     }
/* 119 */     nbt.func_74782_a("Items", itemTag);
/*     */     
/* 121 */     nbt.func_74768_a("Progress", this.progress);
/*     */   }
/*     */   
/*     */   public void func_70307_a(NBTTagCompound nbt)
/*     */   {
/* 126 */     super.func_70307_a(nbt);
/*     */     
/* 128 */     NBTTagList itemTag = nbt.func_74761_m("Items");
/* 129 */     this.inv = new ItemStack[func_70302_i_()];
/*     */     
/* 131 */     for (int var3 = 0; var3 < itemTag.func_74745_c(); var3++) {
/* 132 */       NBTTagCompound slot = (NBTTagCompound)itemTag.func_74743_b(var3);
/* 133 */       byte id = slot.func_74771_c("Slot");
/*     */       
/* 135 */       if ((id >= 0) && (id < this.inv.length)) {
/* 136 */         this.inv[id] = ItemStack.func_77949_a(slot);
/*     */       }
/*     */     }
/*     */     
/* 140 */     this.direction = nbt.func_74762_e("Dir");
/* 141 */     this.ticksExisted = nbt.func_74762_e("Ticks");
/* 142 */     this.progress = nbt.func_74762_e("Progress");
/*     */   }
/*     */   
/*     */   private void syncItems() {
/* 146 */     this.recipe = getNewRecipe();
/* 147 */     this.maxProgress = getMaxTime();
/*     */     
/* 149 */     if (!this.field_70331_k.field_72995_K) {
/* 150 */       for (int a = 0; a < this.inv.length; a++) {
/* 151 */         Packet packet = PacketManagerMF.getPacketItemStackArray(this, a, this.inv[a]);
/*     */         try {
/* 153 */           FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*     */         } catch (NullPointerException e) {
/* 155 */           System.out.println("MineFantasy: Client connection lost");
/* 156 */           return;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean canCraft() {
/* 163 */     if (getRecipe() != null) {
/* 164 */       ItemStack stick = func_70301_a(1);
/*     */       
/* 166 */       if ((stick == null) || (stick.field_77993_c != Item.field_77669_D.field_77779_bT) || (stick.field_77994_a <= 0)) {
/* 167 */         return false;
/*     */       }
/*     */       
/* 170 */       ItemStack res = getResult();
/* 171 */       ItemStack out = func_70301_a(2);
/* 172 */       if (res == null) {
/* 173 */         return false;
/*     */       }
/* 175 */       if (out == null) {
/* 176 */         return true;
/*     */       }
/*     */       
/* 179 */       if (!out.func_77969_a(res)) {
/* 180 */         return false;
/*     */       }
/*     */       
/* 183 */       int max = Math.min(out.func_77976_d(), func_70297_j_());
/*     */       
/* 185 */       return out.field_77994_a + res.field_77994_a <= max;
/*     */     }
/* 187 */     return false;
/*     */   }
/*     */   
/*     */   private StringRecipes getRecipe() {
/* 191 */     return this.recipe;
/*     */   }
/*     */   
/*     */   private StringRecipes getNewRecipe() {
/* 195 */     return StringRecipes.getRecipe(func_70301_a(0));
/*     */   }
/*     */   
/*     */   private int getMaxTime() {
/* 199 */     return getRecipe() != null ? getRecipe().timeRequired : -1;
/*     */   }
/*     */   
/*     */   private ItemStack getResult() {
/* 203 */     return getRecipe() != null ? getRecipe().output : null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int func_70302_i_()
/*     */   {
/* 210 */     return this.inv.length;
/*     */   }
/*     */   
/*     */   public ItemStack func_70301_a(int slot)
/*     */   {
/* 215 */     return this.inv[slot];
/*     */   }
/*     */   
/*     */   public ItemStack func_70298_a(int slot, int num)
/*     */   {
/* 220 */     if (this.inv[slot] == null) {
/* 221 */       return null;
/*     */     }
/* 223 */     this.inv[slot].field_77994_a -= num;
/* 224 */     if (this.inv[slot].field_77994_a <= 0) {
/* 225 */       this.inv[slot] = null;
/*     */     }
/* 227 */     return this.inv[slot];
/*     */   }
/*     */   
/*     */   public ItemStack func_70304_b(int i)
/*     */   {
/* 232 */     return null;
/*     */   }
/*     */   
/*     */   public void func_70299_a(int slot, ItemStack itemstack)
/*     */   {
/* 237 */     this.inv[slot] = itemstack;
/*     */   }
/*     */   
/*     */   public String func_70303_b()
/*     */   {
/* 242 */     return "Spinning Wheel";
/*     */   }
/*     */   
/*     */   public boolean func_94042_c()
/*     */   {
/* 247 */     return true;
/*     */   }
/*     */   
/*     */   public int func_70297_j_()
/*     */   {
/* 252 */     return 64;
/*     */   }
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer player)
/*     */   {
/* 257 */     return player.func_70011_f(this.field_70329_l, this.field_70330_m, this.field_70327_n) < 8.0D;
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
/*     */   public boolean func_94041_b(int slot, ItemStack itemstack)
/*     */   {
/* 270 */     if (slot == 0) {
/* 271 */       return StringRecipes.getRecipe(itemstack) != null;
/*     */     }
/* 273 */     if (slot == 1) {
/* 274 */       return itemstack.field_77993_c == Item.field_77669_D.field_77779_bT;
/*     */     }
/* 276 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerIcons(IconRegister reg) {}
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean shouldRenderCraftMetre()
/*     */   {
/* 286 */     return canCraft();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int getProgressBar(int i)
/*     */   {
/* 292 */     return getProgressScale(i);
/*     */   }
/*     */   
/*     */   public int getProgressScale(int width) {
/* 296 */     return this.progress * width / this.maxProgress;
/*     */   }
/*     */   
/*     */   private void sendPacketToClients() {
/* 300 */     if (!this.field_70331_k.field_72995_K) {
/* 301 */       Packet packet = PacketManagerMF.getPacketIntegerArray(this, new int[] { 0, this.progress, this.maxProgress, this.direction });
/*     */       try {
/* 303 */         FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*     */       } catch (NullPointerException e) {
/* 305 */         System.out.println("MineFantasy: Client connection lost");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void recievePacket(ByteArrayDataInput data)
/*     */   {
/*     */     try {
/* 313 */       int id = data.readInt();
/* 314 */       if (id == 0) {
/* 315 */         this.progress = data.readInt();
/* 316 */         this.maxProgress = data.readInt();
/* 317 */         this.direction = data.readInt();
/*     */       }
/* 319 */       if (id == 1) {
/* 320 */         int p = data.readInt();
/* 321 */         int i = data.readInt();
/* 322 */         int slot = data.readInt();
/*     */         
/* 324 */         Entity e = this.field_70331_k.func_73045_a(p);
/*     */         
/* 326 */         if ((e != null) && ((e instanceof EntityPlayer))) {
/* 327 */           minefantasy.block.special.BlockSpinningWheel.useInventory(this.field_70331_k, this.field_70329_l, this.field_70330_m, this.field_70327_n, this, (EntityPlayer)e, i, slot);
/*     */         }
/* 329 */         return;
/*     */       }
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public int getSlotFor(float x, float y) {
/* 336 */     int[] coord = BlockClickHelper.getCoordsFor(x, y, 0.0F, 1.0F, 0.0F, 1.0F, 3, 3, this.direction);
/*     */     
/* 338 */     if (coord == null) {
/* 339 */       return -1;
/*     */     }
/*     */     
/* 342 */     if ((coord[0] == 1) && 
/* 343 */       (coord[1] == 2)) {
/* 344 */       return 0;
/*     */     }
/*     */     
/* 347 */     if (coord[1] == 0) {
/* 348 */       if (coord[0] == 0) {
/* 349 */         return 1;
/*     */       }
/* 351 */       if (coord[0] == 2) {
/* 352 */         return 2;
/*     */       }
/*     */     }
/* 355 */     return -1;
/*     */   }
/*     */   
/*     */   public ItemStack getResultSlot() {
/* 359 */     return func_70301_a(2);
/*     */   }
/*     */   
/*     */   public float getArmValue() {
/* 363 */     return this.spinAngle / 20.0F;
/*     */   }
/*     */   
/*     */   public void func_70296_d() {
/* 367 */     super.func_70296_d();
/* 368 */     if (!this.field_70331_k.field_72995_K) {
/* 369 */       syncItems();
/*     */     }
/*     */   }
/*     */   
/*     */   public int[] func_94128_d(int side)
/*     */   {
/* 375 */     return new int[] { 0, 1, 2 };
/*     */   }
/*     */   
/*     */   public boolean func_102007_a(int slot, ItemStack item, int side)
/*     */   {
/* 380 */     return func_94041_b(slot, item);
/*     */   }
/*     */   
/*     */   public boolean func_102008_b(int slot, ItemStack item, int side)
/*     */   {
/* 385 */     return slot == 2;
/*     */   }
/*     */   
/*     */   public String getResultName()
/*     */   {
/* 390 */     if (getResult() != null) {
/* 391 */       return getResult().func_82833_r();
/*     */     }
/* 393 */     return "";
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void setTempResult(ItemStack item) {}
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/TileEntitySpinningWheel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */