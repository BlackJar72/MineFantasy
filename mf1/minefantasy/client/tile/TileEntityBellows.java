/*     */ package minefantasy.client.tile;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import java.io.PrintStream;
/*     */ import minefantasy.api.forge.IBellowsUseable;
/*     */ import minefantasy.system.MFResource;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.packet.Packet;
/*     */ import net.minecraft.server.management.ServerConfigurationManager;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ForgeDirection;
/*     */ 
/*     */ public class TileEntityBellows extends TileEntity implements minefantasy.system.network.PacketUserMF
/*     */ {
/*     */   public int direction;
/*  19 */   public int press = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void interact(EntityPlayer player, float powerLevel)
/*     */   {
/*  26 */     int x = this.field_70329_l;
/*  27 */     int y = this.field_70330_m;
/*  28 */     int z = this.field_70327_n;
/*  29 */     IBellowsUseable forge = getFacingForge();
/*  30 */     if (this.press < 10) {
/*  31 */       if (player != null) {
/*  32 */         player.func_85030_a(MFResource.sound("bellows"), 1.0F, 1.0F);
/*     */       } else {
/*  34 */         this.field_70331_k.func_72980_b(this.field_70329_l, this.field_70330_m, this.field_70327_n, MFResource.sound("bellows"), 1.0F, 1.0F, false);
/*     */       }
/*  36 */       this.press = 50;
/*  37 */       if (forge != null) {
/*  38 */         forge.onUsedWithBellows(powerLevel);
/*     */       }
/*  40 */       sendPacketToClients();
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70316_g()
/*     */   {
/*  46 */     super.func_70316_g();
/*  47 */     if (this.press > 0)
/*  48 */       this.press -= 2;
/*  49 */     if (this.press < 0)
/*  50 */       this.press = 0;
/*  51 */     sendPacketToClients();
/*     */   }
/*     */   
/*     */   public void func_70307_a(NBTTagCompound nbt) {
/*  55 */     super.func_70307_a(nbt);
/*  56 */     this.direction = nbt.func_74762_e("direction");
/*  57 */     this.press = nbt.func_74762_e("press");
/*     */   }
/*     */   
/*     */   private void sendPacketToClients() {
/*  61 */     if (!this.field_70331_k.field_72995_K) {
/*  62 */       Packet packet = minefantasy.system.network.PacketManagerMF.getPacketIntegerArray(this, new int[] { this.press, this.direction });
/*     */       try {
/*  64 */         FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*     */       } catch (NullPointerException e) {
/*  66 */         System.out.println("MineFantasy: Client connection lost");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70310_b(NBTTagCompound nbt) {
/*  72 */     super.func_70310_b(nbt);
/*  73 */     nbt.func_74768_a("direction", this.direction);
/*  74 */     nbt.func_74768_a("press", this.press);
/*     */   }
/*     */   
/*     */   public void recievePacket(ByteArrayDataInput data)
/*     */   {
/*  79 */     this.press = data.readInt();
/*  80 */     this.direction = data.readInt();
/*     */   }
/*     */   
/*     */   public ForgeDirection getFacing() {
/*  84 */     TileEntityBellows bellows = (TileEntityBellows)this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m, this.field_70327_n);
/*  85 */     if (bellows == null)
/*  86 */       return null;
/*  87 */     int dir = bellows.direction;
/*  88 */     switch (dir)
/*     */     {
/*     */     case 0: 
/*  91 */       return ForgeDirection.SOUTH;
/*     */     case 1: 
/*  93 */       return ForgeDirection.WEST;
/*     */     case 2: 
/*  95 */       return ForgeDirection.NORTH;
/*     */     case 3: 
/*  97 */       return ForgeDirection.EAST;
/*     */     }
/*  99 */     return ForgeDirection.SOUTH;
/*     */   }
/*     */   
/*     */   public IBellowsUseable getFacingForge() {
/* 103 */     ForgeDirection dir = getFacing();
/* 104 */     int x2 = this.field_70329_l + dir.offsetX;
/* 105 */     int y2 = this.field_70330_m + dir.offsetY;
/* 106 */     int z2 = this.field_70327_n + dir.offsetZ;
/*     */     
/* 108 */     TileEntity tile = this.field_70331_k.func_72796_p(x2, y2, z2);
/* 109 */     if ((tile != null) && ((tile instanceof IBellowsUseable))) {
/* 110 */       return (IBellowsUseable)tile;
/*     */     }
/* 112 */     if ((this.field_70331_k.func_72803_f(x2, y2, z2) != null) && (this.field_70331_k.func_72803_f(x2, y2, z2).func_76220_a())) {
/* 113 */       return getFacingForgeThroughWall();
/*     */     }
/* 115 */     return null;
/*     */   }
/*     */   
/*     */   public IBellowsUseable getFacingForgeThroughWall() {
/* 119 */     ForgeDirection dir = getFacing();
/* 120 */     int x2 = this.field_70329_l + dir.offsetX * 2;
/* 121 */     int y2 = this.field_70330_m + dir.offsetY * 2;
/* 122 */     int z2 = this.field_70327_n + dir.offsetZ * 2;
/*     */     
/* 124 */     TileEntity tile = this.field_70331_k.func_72796_p(x2, y2, z2);
/* 125 */     if (tile == null)
/* 126 */       return null;
/* 127 */     if ((tile instanceof IBellowsUseable)) {
/* 128 */       return (IBellowsUseable)tile;
/*     */     }
/* 130 */     return null;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/TileEntityBellows.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */