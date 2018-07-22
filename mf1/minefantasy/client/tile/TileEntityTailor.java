/*     */ package minefantasy.client.tile;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Random;
/*     */ import minefantasy.api.IMFCrafter;
/*     */ import minefantasy.api.tailor.CraftingManagerTailor;
/*     */ import minefantasy.api.tailor.INeedle;
/*     */ import minefantasy.api.tailor.ITailor;
/*     */ import minefantasy.api.tailor.StringList;
/*     */ import minefantasy.block.special.BlockClickHelper;
/*     */ import minefantasy.block.special.BlockTailor;
/*     */ import minefantasy.container.ContainerTailor;
/*     */ import minefantasy.system.network.PacketManagerMF;
/*     */ import minefantasy.system.network.PacketUserMF;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryCrafting;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.network.packet.Packet;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.server.management.ServerConfigurationManager;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.world.World;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TileEntityTailor
/*     */   extends TileEntity
/*     */   implements IInventory, PacketUserMF, ITailor, IMFCrafter
/*     */ {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private ItemStack tempResult;
/*     */   public int direction;
/*     */   private ItemStack[] inv;
/*     */   public int progress;
/*  55 */   private int maxProgress = 200;
/*     */   private int ticks;
/*     */   private int recipeTier;
/*     */   public int reqString;
/*     */   private float sewTime;
/*     */   private float sewProg;
/*     */   private ItemStack recipe;
/*     */   
/*     */   public TileEntityTailor() {
/*  64 */     this.inv = new ItemStack[21];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean onUse(EntityPlayer player)
/*     */   {
/*  76 */     if (player == null) {
/*  77 */       return false;
/*     */     }
/*  79 */     ItemStack item = player.func_70694_bm();
/*     */     
/*  81 */     if ((item != null) && (item.func_77973_b() != null) && ((item.func_77973_b() instanceof INeedle)) && (canCraft()) && (hasString(false))) {
/*  82 */       if ((this.recipeTier == 0) || (((INeedle)item.func_77973_b()).getTier() >= this.recipeTier)) {
/*  83 */         this.field_70331_k.func_72980_b(this.field_70329_l + 0.5D, this.field_70330_m + 0.5D, this.field_70327_n + 0.5D, "step.cloth", 1.0F, this.field_70331_k.field_73012_v.nextFloat() * 0.1F + 0.9F, true);
/*  84 */         this.sewProg += ((INeedle)item.func_77973_b()).getEfficiency();
/*  85 */         if (!player.field_71075_bZ.field_75098_d) {
/*  86 */           item.func_77972_a(1, player);
/*     */         }
/*     */       } else {
/*  89 */         this.field_70331_k.func_72980_b(this.field_70329_l + 0.5D, this.field_70330_m + 0.5D, this.field_70327_n + 0.5D, "step.cloth", 1.0F, this.field_70331_k.field_73012_v.nextFloat() * 0.1F + 0.4F, true);
/*     */       }
/*  91 */       func_70296_d();
/*  92 */       return true;
/*     */     }
/*  94 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean hasString(boolean consume)
/*     */   {
/* 105 */     if (this.reqString <= -1) {
/* 106 */       return true;
/*     */     }
/* 108 */     for (int a = 0; a < 4; a++) {
/* 109 */       ItemStack slot = func_70301_a(a);
/*     */       
/* 111 */       if ((slot != null) && 
/* 112 */         (StringList.doesMatchTier(slot, this.reqString))) {
/* 113 */         if (consume)
/* 114 */           func_70298_a(a, 1);
/* 115 */         return true;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 120 */     return false;
/*     */   }
/*     */   
/*     */   public void func_70316_g()
/*     */   {
/* 125 */     super.func_70316_g();
/* 126 */     this.ticks += 1;
/* 127 */     if (this.progress >= this.maxProgress) {
/* 128 */       this.progress = 0;
/* 129 */       this.sewProg = 0.0F;
/* 130 */       craft();
/*     */     }
/* 132 */     if ((this.sewProg >= this.sewTime) && (this.sewTime > 0.0F)) {
/* 133 */       this.sewProg -= this.sewTime;
/* 134 */       if (hasString(true)) {
/* 135 */         this.progress += 1;
/*     */       }
/*     */     }
/*     */     
/* 139 */     if ((!canCraft()) && (this.progress > 0)) {
/* 140 */       this.progress = 0;
/*     */     }
/*     */     
/* 143 */     if (!this.field_70331_k.field_72995_K) {
/* 144 */       if (this.ticks % 20 == 0) {
/* 145 */         syncItems();
/*     */       }
/* 147 */       sendPacketToClients();
/*     */     }
/*     */   }
/*     */   
/*     */   public ItemStack getResult() {
/* 152 */     return this.recipe;
/*     */   }
/*     */   
/*     */   public ItemStack getRecipe() {
/* 156 */     if (this.ticks <= 1) {
/* 157 */       return null;
/*     */     }
/* 159 */     ContainerTailor container = new ContainerTailor(this);
/*     */     
/* 161 */     InventoryCrafting craft = new InventoryCrafting(container, 4, 4);
/*     */     
/* 163 */     for (int a = 0; a < 16; a++) {
/* 164 */       craft.func_70299_a(a, this.inv[(a + 4)]);
/*     */     }
/*     */     
/* 167 */     return CraftingManagerTailor.getInstance().findMatchingRecipe(this, craft);
/*     */   }
/*     */   
/*     */   public boolean canCraft() {
/* 171 */     return (getResult() != null) && (canFitResult());
/*     */   }
/*     */   
/*     */   public boolean canFitResult() {
/* 175 */     ItemStack slot = this.inv[getOutputSlot()];
/* 176 */     ItemStack result = getResult();
/*     */     
/* 178 */     if (slot == null)
/* 179 */       return true;
/* 180 */     if (result == null) {
/* 181 */       return false;
/*     */     }
/* 183 */     if (!result.func_77969_a(slot)) {
/* 184 */       return false;
/*     */     }
/* 186 */     int ss = slot.field_77994_a;
/* 187 */     int rs = result.field_77994_a;
/* 188 */     int sm = slot.func_77976_d() - ss;
/*     */     
/* 190 */     return rs <= sm;
/*     */   }
/*     */   
/*     */   private void craft() {
/* 194 */     if (getResult() == null) {
/* 195 */       return;
/*     */     }
/* 197 */     ItemStack result = getResult().func_77946_l();
/*     */     
/* 199 */     if (result != null) {
/* 200 */       if (this.inv[getOutputSlot()] == null) {
/* 201 */         decreseAll();
/* 202 */         func_70299_a(getOutputSlot(), result);
/* 203 */       } else if ((this.inv[getOutputSlot()] != null) && (this.inv[getOutputSlot()].func_77969_a(result))) {
/* 204 */         int c = this.inv[getOutputSlot()].field_77994_a + result.field_77994_a;
/* 205 */         if (c <= this.inv[getOutputSlot()].func_77976_d()) {
/* 206 */           decreseAll();
/* 207 */           this.inv[getOutputSlot()].field_77994_a += result.field_77994_a;
/*     */         }
/*     */       }
/*     */     }
/* 211 */     func_70296_d();
/*     */   }
/*     */   
/*     */   private void decreseAll() {
/* 215 */     Random rand = new Random();
/*     */     
/* 217 */     for (int s = 4; s < getOutputSlot(); s++) {
/* 218 */       func_70298_a(s, 1);
/*     */     }
/*     */   }
/*     */   
/*     */   private void sendPacketToClients() {
/* 223 */     if (!this.field_70331_k.field_72995_K) {
/* 224 */       Packet packet = PacketManagerMF.getPacketIntegerArray(this, new int[] { 0, this.progress, this.maxProgress, this.direction });
/*     */       try {
/* 226 */         FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*     */       } catch (NullPointerException e) {
/* 228 */         System.out.println("MineFantasy: Client connection lost");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void syncItems() {
/* 234 */     if (!this.field_70331_k.field_72995_K) {
/* 235 */       for (int a = 0; a < this.inv.length; a++) {
/* 236 */         Packet packet = PacketManagerMF.getPacketItemStackArray(this, a, this.inv[a]);
/*     */         try {
/* 238 */           FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*     */         } catch (NullPointerException e) {
/* 240 */           System.out.println("MineFantasy: Client connection lost");
/* 241 */           return;
/*     */         }
/*     */       }
/*     */       
/* 245 */       Packet packet2 = PacketManagerMF.getPacketMFResult(this, getResult());
/*     */       try {
/* 247 */         FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet2);
/*     */       } catch (NullPointerException e) {
/* 249 */         System.out.println("MineFantasy: Client connection lost");
/* 250 */         return;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void recievePacket(ByteArrayDataInput data)
/*     */   {
/*     */     try {
/* 258 */       int id = data.readInt();
/*     */       
/* 260 */       if (id == 0) {
/* 261 */         this.progress = data.readInt();
/* 262 */         this.maxProgress = data.readInt();
/* 263 */         this.direction = data.readInt();
/*     */       }
/* 265 */       if (id == 1) {
/* 266 */         int p = data.readInt();
/* 267 */         int i = data.readInt();
/* 268 */         int slot = data.readInt();
/*     */         
/* 270 */         Entity e = this.field_70331_k.func_73045_a(p);
/*     */         
/* 272 */         if ((e != null) && ((e instanceof EntityPlayer))) {
/* 273 */           BlockTailor.useInventory(this.field_70331_k, this.field_70329_l, this.field_70330_m, this.field_70327_n, this, (EntityPlayer)e, i, slot);
/*     */         }
/* 275 */         return;
/*     */       }
/*     */     } catch (Exception e) {
/* 278 */       System.err.println("MineFantasy: Failed to process packet from Tailor Bench");
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70296_d()
/*     */   {
/* 284 */     super.func_70296_d();
/*     */     
/* 286 */     this.recipe = getRecipe();
/* 287 */     syncItems();
/*     */   }
/*     */   
/*     */   public void func_70310_b(NBTTagCompound nbt)
/*     */   {
/* 292 */     super.func_70310_b(nbt);
/* 293 */     NBTTagList itemTag = new NBTTagList();
/*     */     
/* 295 */     nbt.func_74768_a("Dir", this.direction);
/* 296 */     nbt.func_74776_a("Sew", this.sewProg);
/*     */     
/* 298 */     for (int var3 = 0; var3 < this.inv.length; var3++) {
/* 299 */       if (this.inv[var3] != null) {
/* 300 */         NBTTagCompound var4 = new NBTTagCompound();
/* 301 */         var4.func_74774_a("Slot", (byte)var3);
/* 302 */         this.inv[var3].func_77955_b(var4);
/* 303 */         itemTag.func_74742_a(var4);
/*     */       }
/*     */     }
/* 306 */     nbt.func_74782_a("Items", itemTag);
/*     */     
/* 308 */     nbt.func_74768_a("Progress", this.progress);
/*     */   }
/*     */   
/*     */   public void func_70307_a(NBTTagCompound nbt)
/*     */   {
/* 313 */     super.func_70307_a(nbt);
/*     */     
/* 315 */     NBTTagList itemTag = nbt.func_74761_m("Items");
/* 316 */     this.inv = new ItemStack[func_70302_i_()];
/* 317 */     this.sewProg = nbt.func_74760_g("Sew");
/*     */     
/* 319 */     for (int var3 = 0; var3 < itemTag.func_74745_c(); var3++) {
/* 320 */       NBTTagCompound slot = (NBTTagCompound)itemTag.func_74743_b(var3);
/* 321 */       byte id = slot.func_74771_c("Slot");
/*     */       
/* 323 */       if ((id >= 0) && (id < this.inv.length)) {
/* 324 */         this.inv[id] = ItemStack.func_77949_a(slot);
/*     */       }
/*     */     }
/*     */     
/* 328 */     this.direction = nbt.func_74762_e("Dir");
/* 329 */     this.progress = nbt.func_74762_e("Progress");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String func_70303_b()
/*     */   {
/* 336 */     return "Tailor Bench";
/*     */   }
/*     */   
/*     */   public boolean func_94042_c()
/*     */   {
/* 341 */     return true;
/*     */   }
/*     */   
/*     */   public boolean func_94041_b(int i, ItemStack itemstack)
/*     */   {
/* 346 */     return (i < 4) && (StringList.isString(itemstack));
/*     */   }
/*     */   
/*     */   public int getProgressScale(int width) {
/* 350 */     return this.progress * width / this.maxProgress;
/*     */   }
/*     */   
/*     */   public int func_70302_i_()
/*     */   {
/* 355 */     return this.inv.length;
/*     */   }
/*     */   
/*     */   public ItemStack func_70301_a(int i)
/*     */   {
/* 360 */     return this.inv[i];
/*     */   }
/*     */   
/*     */   public ItemStack func_70298_a(int slot, int amount)
/*     */   {
/* 365 */     func_70296_d();
/* 366 */     if (this.inv[slot] != null)
/*     */     {
/*     */ 
/* 369 */       if (this.inv[slot].field_77994_a <= amount) {
/* 370 */         ItemStack result = this.inv[slot];
/* 371 */         this.inv[slot] = null;
/* 372 */         func_70296_d();
/* 373 */         return result;
/*     */       }
/* 375 */       ItemStack result = this.inv[slot].func_77979_a(amount);
/*     */       
/* 377 */       if (this.inv[slot].field_77994_a == 0) {
/* 378 */         this.inv[slot] = null;
/*     */       }
/*     */       
/* 381 */       func_70296_d();
/* 382 */       return result;
/*     */     }
/*     */     
/* 385 */     func_70296_d();
/* 386 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public ItemStack func_70304_b(int slot)
/*     */   {
/* 392 */     if (this.inv[slot] != null) {
/* 393 */       ItemStack var2 = this.inv[slot];
/* 394 */       this.inv[slot] = null;
/* 395 */       return var2;
/*     */     }
/* 397 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_70299_a(int i, ItemStack itemstack)
/*     */   {
/* 403 */     func_70296_d();
/* 404 */     this.inv[i] = itemstack;
/*     */   }
/*     */   
/*     */   public int func_70297_j_()
/*     */   {
/* 409 */     return 64;
/*     */   }
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer entityplayer)
/*     */   {
/* 414 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_70295_k_() {}
/*     */   
/*     */ 
/*     */   public void func_70305_f() {}
/*     */   
/*     */ 
/*     */   public int getOutputSlot()
/*     */   {
/* 426 */     return func_70302_i_() - 1;
/*     */   }
/*     */   
/*     */   public void setStitchCount(int i)
/*     */   {
/* 431 */     this.maxProgress = i;
/*     */   }
/*     */   
/*     */   public void setString(int str)
/*     */   {
/* 436 */     this.reqString = str;
/*     */   }
/*     */   
/*     */   public void setSewTime(float f)
/*     */   {
/* 441 */     this.sewTime = f;
/*     */   }
/*     */   
/*     */   public void setTier(int i)
/*     */   {
/* 446 */     this.recipeTier = i;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public ItemStack getRenderItem(int i) {
/* 451 */     return this.inv[i];
/*     */   }
/*     */   
/*     */   public int getSlotFor(float x, float y) {
/* 455 */     int[] coord = BlockClickHelper.getCoordsFor(x, y, 0.0F, 1.0F, 0.0F, 1.0F, 6, 6, this.direction);
/*     */     
/* 457 */     if (coord == null) {
/* 458 */       return -1;
/*     */     }
/*     */     
/* 461 */     if ((coord[0] == 1) || (coord[1] < 2)) {
/* 462 */       return -1;
/*     */     }
/* 464 */     coord[1] -= 2;
/* 465 */     if (coord[0] == 0) {
/* 466 */       return coord[1];
/*     */     }
/* 468 */     coord[0] -= 2;
/*     */     
/* 470 */     return coord[1] * 4 + coord[0] + 4;
/*     */   }
/*     */   
/*     */   public ItemStack getResultSlot() {
/* 474 */     return func_70301_a(func_70302_i_() - 1);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean shouldRenderCraftMetre()
/*     */   {
/* 480 */     return canCraft();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int getProgressBar(int i)
/*     */   {
/* 486 */     return getProgressScale(i);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getResultName()
/*     */   {
/* 492 */     if (this.field_70331_k.field_72995_K) {
/* 493 */       return this.tempResult != null ? this.tempResult.func_82833_r() : "";
/*     */     }
/* 495 */     return "";
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void setTempResult(ItemStack item)
/*     */   {
/* 501 */     this.tempResult = item;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/TileEntityTailor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */