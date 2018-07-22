/*     */ package minefantasy.client.tile;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.network.PacketDispatcher;
/*     */ import java.io.PrintStream;
/*     */ import minefantasy.block.special.BlockClickHelper;
/*     */ import minefantasy.block.special.BlockWeaponRack;
/*     */ import minefantasy.system.network.PacketManagerMF;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemBlock;
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
/*     */ public class TileEntityWeaponRack extends TileEntity implements IInventory, minefantasy.system.network.PacketUserMF
/*     */ {
/*     */   private ItemStack[] inv;
/*     */   public int direction;
/*     */   private int ticksExisted;
/*     */   
/*     */   public TileEntityWeaponRack()
/*     */   {
/*  32 */     this.inv = new ItemStack[4];
/*     */   }
/*     */   
/*     */   public int func_70302_i_() {
/*  36 */     return this.inv.length;
/*     */   }
/*     */   
/*     */   public ItemStack func_70301_a(int i) {
/*  40 */     return this.inv[i];
/*     */   }
/*     */   
/*     */   public ItemStack func_70298_a(int i, int j) {
/*  44 */     if (this.inv[i] != null) {
/*  45 */       if (this.inv[i].field_77994_a <= j) {
/*  46 */         ItemStack itemstack = this.inv[i];
/*  47 */         this.inv[i] = null;
/*  48 */         syncItems();
/*  49 */         return itemstack;
/*     */       }
/*  51 */       ItemStack itemstack1 = this.inv[i].func_77979_a(j);
/*  52 */       if (this.inv[i].field_77994_a == 0) {
/*  53 */         this.inv[i] = null;
/*     */       }
/*  55 */       syncItems();
/*  56 */       return itemstack1;
/*     */     }
/*  58 */     syncItems();
/*  59 */     return null;
/*     */   }
/*     */   
/*     */   public void func_70299_a(int i, ItemStack itemstack)
/*     */   {
/*  64 */     this.inv[i] = itemstack;
/*  65 */     syncItems();
/*     */   }
/*     */   
/*     */   public String func_70303_b() {
/*  69 */     return "Rack";
/*     */   }
/*     */   
/*     */   public void func_70307_a(NBTTagCompound nbttagcompound)
/*     */   {
/*  74 */     super.func_70307_a(nbttagcompound);
/*  75 */     NBTTagList nbttaglist = nbttagcompound.func_74761_m("Items");
/*     */     
/*  77 */     this.inv = new ItemStack[func_70302_i_()];
/*     */     
/*  79 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*  80 */       NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.func_74743_b(i);
/*  81 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/*  82 */       if ((byte0 >= 0) && (byte0 < this.inv.length)) {
/*  83 */         this.inv[byte0] = ItemStack.func_77949_a(nbttagcompound1);
/*     */       }
/*     */     }
/*     */     
/*  87 */     this.direction = nbttagcompound.func_74762_e("Dir");
/*     */   }
/*     */   
/*     */   public void func_70310_b(NBTTagCompound nbttagcompound)
/*     */   {
/*  92 */     super.func_70310_b(nbttagcompound);
/*  93 */     nbttagcompound.func_74768_a("Dir", this.direction);
/*  94 */     NBTTagList nbttaglist = new NBTTagList();
/*  95 */     for (int i = 0; i < this.inv.length; i++) {
/*  96 */       if (this.inv[i] != null) {
/*  97 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/*  98 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/*  99 */         this.inv[i].func_77955_b(nbttagcompound1);
/* 100 */         nbttaglist.func_74742_a(nbttagcompound1);
/*     */       }
/*     */     }
/*     */     
/* 104 */     nbttagcompound.func_74782_a("Items", nbttaglist);
/*     */   }
/*     */   
/*     */   public int func_70297_j_() {
/* 108 */     return 64;
/*     */   }
/*     */   
/*     */   public void func_70316_g() {
/* 112 */     this.ticksExisted += 1;
/* 113 */     if (this.ticksExisted % 20 == 0) {
/* 114 */       syncItems();
/*     */     }
/* 116 */     sendPacketToClients();
/*     */   }
/*     */   
/*     */   public void syncItems() {
/* 120 */     if (!this.field_70331_k.field_72995_K) {
/*     */       try {
/* 122 */         for (int a = 0; a < func_70302_i_(); a++) {
/* 123 */           Packet packet = PacketManagerMF.getPacketItemStackArray(this, a, func_70301_a(a));
/* 124 */           PacketDispatcher.sendPacketToAllPlayers(packet);
/*     */         }
/*     */       }
/*     */       catch (Exception localException) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer entityplayer)
/*     */   {
/* 133 */     if (this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m, this.field_70327_n) != this) {
/* 134 */       return false;
/*     */     }
/* 136 */     return entityplayer.func_70092_e(this.field_70329_l + 0.5D, this.field_70330_m + 0.5D, this.field_70327_n + 0.5D) <= 64.0D;
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
/* 147 */     return null;
/*     */   }
/*     */   
/*     */   private void sendPacketToClients() {
/* 151 */     if (!this.field_70331_k.field_72995_K) {
/*     */       try {
/* 153 */         Packet packet = PacketManagerMF.getPacketIntegerArray(this, new int[] { 0, this.direction });
/* 154 */         FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*     */       } catch (NullPointerException e) {
/* 156 */         System.out.println("MineFantasy: Client connections lost");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private int getEnchantment(int i) {
/* 162 */     ItemStack is = func_70301_a(i);
/* 163 */     if (is == null) {
/* 164 */       return 0;
/*     */     }
/* 166 */     if (is.func_77948_v()) {
/* 167 */       return 1;
/*     */     }
/* 169 */     return 0;
/*     */   }
/*     */   
/*     */   public void recievePacket(ByteArrayDataInput data)
/*     */   {
/*     */     try {
/* 175 */       int id = data.readInt();
/*     */       
/* 177 */       if (id == 0) {
/* 178 */         this.direction = data.readInt();
/*     */       }
/* 180 */       if (id == 1) {
/* 181 */         int p = data.readInt();
/* 182 */         int i = data.readInt();
/* 183 */         int slot = data.readInt();
/*     */         
/* 185 */         Entity e = this.field_70331_k.func_73045_a(p);
/*     */         
/* 187 */         if ((e != null) && ((e instanceof EntityPlayer))) {
/* 188 */           BlockWeaponRack.tryPlaceItem(slot, this.field_70331_k, this, (EntityPlayer)e);
/*     */         }
/* 190 */         return;
/*     */       }
/*     */     } catch (Exception e) {
/* 193 */       System.err.println("MineFantasy: Weapon rack packet failed");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean func_94042_c()
/*     */   {
/* 200 */     return true;
/*     */   }
/*     */   
/*     */   public boolean func_94041_b(int i, ItemStack itemstack)
/*     */   {
/* 205 */     return false;
/*     */   }
/*     */   
/*     */   public int getSlotFor(float x, float y) {
/* 209 */     ForgeDirection FD = BlockClickHelper.FD[this.direction];
/*     */     
/* 211 */     float offset = 0.0625F;
/*     */     
/* 213 */     float x1 = 0.0F + offset;
/* 214 */     float x2 = 1.0F - offset;
/* 215 */     float y1 = 0.0F;
/* 216 */     float y2 = 1.0F;
/* 217 */     if ((FD == ForgeDirection.EAST) || (FD == ForgeDirection.WEST)) {
/* 218 */       x1 = 0.0F;
/* 219 */       x2 = 1.0F;
/* 220 */       y1 = 0.0F + offset;
/* 221 */       y2 = 1.0F - offset;
/*     */     }
/* 223 */     int[] coord = BlockClickHelper.getCoordsFor(x, y, x1, x2, y1, y2, 4, 4, this.direction);
/*     */     
/* 225 */     if (coord == null) {
/* 226 */       return -1;
/*     */     }
/* 228 */     return coord[0];
/*     */   }
/*     */   
/*     */   public static boolean canHang(ItemStack item)
/*     */   {
/* 233 */     if ((item == null) || (item.func_77973_b() == null)) {
/* 234 */       return false;
/*     */     }
/* 236 */     if ((item.func_77973_b() instanceof ItemBlock)) {
/* 237 */       return false;
/*     */     }
/* 239 */     return true;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/TileEntityWeaponRack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */