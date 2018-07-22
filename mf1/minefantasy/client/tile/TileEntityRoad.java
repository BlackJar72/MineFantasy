/*     */ package minefantasy.client.tile;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Random;
/*     */ import minefantasy.system.network.PacketManagerMF;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.packet.Packet;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.server.management.ServerConfigurationManager;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class TileEntityRoad extends TileEntity implements minefantasy.system.network.PacketUserMF, minefantasy.api.IMFCrafter
/*     */ {
/*     */   private float buildTime;
/*  22 */   private int lastUsed = 0;
/*  23 */   private int[] surface = new int[2];
/*     */   private int ticksExisted;
/*  25 */   private Random rand = new Random();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean shouldRenderCraftMetre()
/*     */   {
/*  33 */     return this.buildTime > 0.0F;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int getProgressBar(int i)
/*     */   {
/*  39 */     return (int)(i * this.buildTime);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getResultName()
/*     */   {
/*  45 */     return "";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void setTempResult(ItemStack res) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70316_g()
/*     */   {
/*  57 */     super.func_70316_g();
/*     */     
/*  59 */     if (!this.field_70331_k.field_72995_K) {
/*  60 */       if (this.lastUsed < 0) {
/*  61 */         this.lastUsed += 1;
/*     */       }
/*     */       
/*  64 */       if (this.lastUsed > 0) {
/*  65 */         this.lastUsed -= 1;
/*  66 */       } else if (this.buildTime > 0.0F) {
/*  67 */         this.buildTime = 0.0F;
/*     */       }
/*  69 */       this.ticksExisted += 1;
/*  70 */       if (this.ticksExisted % 20 == 0) {
/*  71 */         sendPacketToClients();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void setSurface(int id, int meta) {
/*  77 */     if ((this.field_70331_k == null) || (this.field_70331_k.field_72995_K)) {
/*  78 */       return;
/*     */     }
/*  80 */     if (id == Block.field_71980_u.field_71990_ca) {
/*  81 */       id = Block.field_71979_v.field_71990_ca;
/*     */     }
/*  83 */     this.surface[0] = id;
/*  84 */     this.surface[1] = meta;
/*     */     
/*  86 */     sendPacketToClients();
/*     */   }
/*     */   
/*     */   public void sendPacketToClients() {
/*  90 */     if (!this.field_70331_k.field_72995_K) {
/*     */       try {
/*  92 */         Packet packet = PacketManagerMF.getPacketIntegerArray(this, new int[] { (int)(this.buildTime * 50.0F), this.surface[0], this.surface[1] });
/*  93 */         FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*     */       } catch (NullPointerException e) {
/*  95 */         System.out.println("MineFantasy: Client connections lost");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void recievePacket(ByteArrayDataInput data)
/*     */   {
/* 102 */     this.buildTime = (data.readInt() / 50.0F);
/* 103 */     int id2 = data.readInt();
/* 104 */     int meta2 = data.readInt();
/*     */     
/* 106 */     if (blockChange(id2, meta2)) {
/* 107 */       if (minefantasy.MineFantasyBase.isDebug()) {
/* 108 */         System.out.println("Detected Road tex change");
/*     */       }
/* 110 */       this.surface[0] = id2;
/* 111 */       this.surface[1] = meta2;
/*     */       
/* 113 */       this.field_70331_k.func_72902_n(this.field_70329_l, this.field_70330_m, this.field_70327_n);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean blockChange(int id, int meta) {
/* 118 */     if (id != this.surface[0])
/* 119 */       return true;
/* 120 */     if (meta != this.surface[1]) {
/* 121 */       return true;
/*     */     }
/* 123 */     return false;
/*     */   }
/*     */   
/*     */   public void func_70310_b(NBTTagCompound nbt) {
/* 127 */     super.func_70310_b(nbt);
/*     */     
/* 129 */     nbt.func_74783_a("surface", this.surface);
/*     */   }
/*     */   
/*     */   public void func_70307_a(NBTTagCompound nbt) {
/* 133 */     super.func_70307_a(nbt);
/*     */     
/* 135 */     this.surface = nbt.func_74759_k("surface");
/*     */   }
/*     */   
/*     */   public int[] getSurface() {
/* 139 */     return this.surface;
/*     */   }
/*     */   
/*     */   public boolean canBuild() {
/* 143 */     if ((this.field_70331_k == null) || (this.field_70331_k.field_72995_K)) {
/* 144 */       return false;
/*     */     }
/* 146 */     if (this.lastUsed < 0) {
/* 147 */       return false;
/*     */     }
/* 149 */     this.lastUsed = 10;
/* 150 */     this.buildTime += this.rand.nextFloat() / 2.0F;
/* 151 */     sendPacketToClients();
/* 152 */     if (this.buildTime >= 1.0F) {
/* 153 */       this.buildTime = 0.0F;
/* 154 */       this.lastUsed = -10;
/* 155 */       return true;
/*     */     }
/* 157 */     this.field_70331_k.func_72908_a(this.field_70329_l, this.field_70330_m, this.field_70327_n, "dig.grass", 0.5F, 1.0F);
/* 158 */     return false;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/TileEntityRoad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */