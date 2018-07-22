/*    */ package minefantasy.client.tile;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import cpw.mods.fml.common.FMLCommonHandler;
/*    */ import minefantasy.system.network.PacketManagerMF;
/*    */ import minefantasy.system.network.PacketUserMF;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.network.packet.Packet;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.server.management.ServerConfigurationManager;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TileEntityDogBowl
/*    */   extends TileEntity
/*    */   implements PacketUserMF
/*    */ {
/*    */   public int food;
/*    */   public int itemMeta;
/*    */   
/*    */   public TileEntityDogBowl(int m)
/*    */   {
/* 27 */     this.itemMeta = m;
/*    */   }
/*    */   
/*    */ 
/*    */   public TileEntityDogBowl() {}
/*    */   
/*    */   public boolean canPutFood()
/*    */   {
/* 35 */     return this.food < getFoodMax();
/*    */   }
/*    */   
/*    */   public int getFoodMax() {
/* 39 */     if (func_70322_n() == 1) {
/* 40 */       return 64;
/*    */     }
/* 42 */     if (func_70322_n() == 2) {
/* 43 */       return 100;
/*    */     }
/* 45 */     return 32;
/*    */   }
/*    */   
/*    */   public void addFood(int healAmount) {
/* 49 */     this.food += healAmount;
/* 50 */     sendPacketToClients();
/*    */   }
/*    */   
/*    */   public int func_70322_n()
/*    */   {
/* 55 */     if (this.field_70331_k == null) {
/* 56 */       return this.itemMeta;
/*    */     }
/* 58 */     return super.func_70322_n();
/*    */   }
/*    */   
/*    */   public void func_70316_g() {
/* 62 */     super.func_70316_g();
/* 63 */     sendPacketToClients();
/*    */   }
/*    */   
/*    */   public void func_70307_a(NBTTagCompound nbt)
/*    */   {
/* 68 */     super.func_70307_a(nbt);
/* 69 */     this.food = nbt.func_74762_e("food");
/*    */   }
/*    */   
/*    */   public void func_70310_b(NBTTagCompound nbt)
/*    */   {
/* 74 */     super.func_70310_b(nbt);
/* 75 */     nbt.func_74768_a("food", this.food);
/*    */   }
/*    */   
/*    */   public void recievePacket(ByteArrayDataInput data)
/*    */   {
/* 80 */     int f2 = data.readInt();
/* 81 */     this.food = f2;
/*    */   }
/*    */   
/*    */   public void sendPacketToClients() {
/* 85 */     if (!this.field_70331_k.field_72995_K) {
/* 86 */       Packet packet = PacketManagerMF.getPacketInteger(this, this.food);
/* 87 */       FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*    */     }
/*    */   }
/*    */   
/*    */   public String getTex(int meta) {
/* 92 */     if (meta == 1) {
/* 93 */       return "Iron";
/*    */     }
/* 95 */     if (meta == 2) {
/* 96 */       return "Steel";
/*    */     }
/* 98 */     return "Wood";
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/TileEntityDogBowl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */