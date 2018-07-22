/*     */ package minefantasy.client.tile;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Random;
/*     */ import minefantasy.api.IMFCrafter;
/*     */ import minefantasy.api.leatherwork.EnumToolType;
/*     */ import minefantasy.api.tanner.LeathercuttingRecipes;
/*     */ import minefantasy.api.tanner.TanningRecipes;
/*     */ import minefantasy.system.network.PacketManagerMF;
/*     */ import minefantasy.system.network.PacketUserMF;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
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
/*     */ public class TileEntityTanningRack
/*     */   extends TileEntity
/*     */   implements PacketUserMF, IMFCrafter, IInventory
/*     */ {
/*     */   private int ticksExisted;
/*     */   public int direction;
/*     */   public float progress;
/*     */   private ItemStack hungItem;
/*  41 */   Random rand = new Random();
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean canTan()
/*     */   {
/*  47 */     return TanningRecipes.instance().getTanningResult(getHung()) != null;
/*     */   }
/*     */   
/*     */   public boolean canCut() {
/*  51 */     return LeathercuttingRecipes.instance().getCuttingResult(getHung()) != null;
/*     */   }
/*     */   
/*     */   public void setHung(ItemStack item) {
/*  55 */     this.hungItem = item;
/*     */   }
/*     */   
/*     */   public boolean use(EntityPlayer player, EnumToolType toolType, float quality) {
/*  59 */     if ((canTan()) && (toolType == EnumToolType.KNIFE)) {
/*  60 */       this.field_70331_k.func_72908_a(this.field_70329_l + 0.5D, this.field_70330_m + 0.5D, this.field_70327_n + 0.5D, "step.cloth", 1.0F, 1.0F);
/*  61 */       this.progress += quality;
/*     */       
/*  63 */       if (this.progress >= getMaxProgress()) {
/*  64 */         this.progress = 0.0F;
/*  65 */         if (!this.field_70331_k.field_72995_K) {
/*  66 */           setHung(TanningRecipes.instance().getTanningResult(getHung()));
/*  67 */           syncItem();
/*     */         }
/*  69 */         if (player.func_70694_bm() != null) {
/*  70 */           player.func_70694_bm().func_77972_a(1, player);
/*     */         }
/*  72 */         return true;
/*     */       }
/*     */     }
/*  75 */     if ((canCut()) && (toolType == EnumToolType.CUTTER)) {
/*  76 */       this.field_70331_k.func_72908_a(this.field_70329_l + 0.5D, this.field_70330_m + 0.5D, this.field_70327_n + 0.5D, "mob.sheep.shear", 0.5F, 0.65F);
/*  77 */       this.progress += quality;
/*     */       
/*  79 */       if (this.progress >= getMaxProgress()) {
/*  80 */         this.progress = 0.0F;
/*  81 */         if (!this.field_70331_k.field_72995_K)
/*     */         {
/*  83 */           ItemStack result = LeathercuttingRecipes.instance().getCuttingResult(getHung()).func_77946_l();
/*  84 */           int rs = result.field_77994_a * this.hungItem.field_77994_a;
/*  85 */           setHung(result);
/*  86 */           this.hungItem.field_77994_a = rs;
/*  87 */           retrieveItem(player);
/*  88 */           syncItem();
/*     */         }
/*  90 */         if (player.func_70694_bm() != null) {
/*  91 */           player.func_70694_bm().func_77972_a(1, player);
/*     */         }
/*  93 */         return true;
/*     */       }
/*     */     }
/*  96 */     return false;
/*     */   }
/*     */   
/*     */   private float getMaxProgress() {
/* 100 */     return 50.0F;
/*     */   }
/*     */   
/*     */   public void func_70316_g()
/*     */   {
/* 105 */     super.func_70316_g();
/* 106 */     this.ticksExisted += 1;
/* 107 */     sendPacketToClients();
/*     */     
/* 109 */     if (this.ticksExisted % 20 == 0) {
/* 110 */       syncItem();
/*     */     }
/* 112 */     if (!canCraft()) {
/* 113 */       this.progress = 0.0F;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean canHang() {
/* 118 */     return getHung() == null;
/*     */   }
/*     */   
/*     */   public void hang(ItemStack item) {
/* 122 */     setHung(item);
/* 123 */     Random rand = new Random();
/* 124 */     this.field_70331_k.func_72908_a(this.field_70329_l, this.field_70330_m, this.field_70327_n, "mob.horse.leather", rand.nextFloat() + 1.5F, rand.nextFloat() * 0.4F + 0.8F);
/* 125 */     syncItem();
/*     */   }
/*     */   
/*     */   public ItemStack getHung() {
/* 129 */     return this.hungItem;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70310_b(NBTTagCompound tag)
/*     */   {
/* 136 */     super.func_70310_b(tag);
/*     */     
/* 138 */     if (getHung() != null) {
/* 139 */       NBTTagCompound slot = new NBTTagCompound();
/* 140 */       this.hungItem.func_77955_b(slot);
/*     */       
/* 142 */       tag.func_74782_a("Hung", slot);
/*     */     }
/* 144 */     tag.func_74768_a("Dir", this.direction);
/* 145 */     tag.func_74776_a("Progress", this.progress);
/*     */   }
/*     */   
/*     */   public void func_70307_a(NBTTagCompound tag) {
/* 149 */     super.func_70307_a(tag);
/*     */     
/* 151 */     if (tag.func_74764_b("Hung")) {
/* 152 */       this.hungItem = ItemStack.func_77949_a((NBTTagCompound)tag.func_74781_a("Hung"));
/*     */     }
/*     */     
/* 155 */     this.direction = tag.func_74762_e("Dir");
/* 156 */     this.progress = tag.func_74760_g("Progress");
/*     */   }
/*     */   
/*     */   private void sendPacketToClients() {
/* 160 */     if (!this.field_70331_k.field_72995_K) {
/*     */       try {
/* 162 */         Packet packet = PacketManagerMF.getPacketIntegerArray(this, new int[] { this.direction, (int)this.progress * 100 });
/* 163 */         FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*     */       } catch (NullPointerException e) {
/* 165 */         System.out.println("MineFantasy: Lost Client connection");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void recievePacket(ByteArrayDataInput data)
/*     */   {
/* 172 */     this.direction = data.readInt();
/* 173 */     int p = data.readInt();
/* 174 */     this.progress = (p / 100.0F);
/*     */   }
/*     */   
/*     */   public boolean canHang(ItemStack itemstack) {
/* 178 */     return (TanningRecipes.instance().getTanningResult(itemstack) != null) || (LeathercuttingRecipes.instance().getCuttingResult(itemstack) != null);
/*     */   }
/*     */   
/*     */   public void syncItem() {
/* 182 */     if (!this.field_70331_k.field_72995_K) {
/* 183 */       Packet packet = PacketManagerMF.getPacketItemStackArray(this, 0, getHung());
/*     */       try {
/* 185 */         FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*     */       } catch (NullPointerException e) {
/* 187 */         System.out.println("MineFantasy: Client connection lost");
/* 188 */         return;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public int func_70302_i_()
/*     */   {
/* 195 */     return 1;
/*     */   }
/*     */   
/*     */   public ItemStack func_70301_a(int i)
/*     */   {
/* 200 */     return getHung();
/*     */   }
/*     */   
/*     */   public ItemStack func_70298_a(int i, int j)
/*     */   {
/* 205 */     getHung().field_77994_a -= 1;
/* 206 */     if (getHung().field_77994_a <= 0) {
/* 207 */       setHung(null);
/*     */     }
/* 209 */     return getHung();
/*     */   }
/*     */   
/*     */   public ItemStack func_70304_b(int i)
/*     */   {
/* 214 */     return null;
/*     */   }
/*     */   
/*     */   public void func_70299_a(int i, ItemStack itemstack)
/*     */   {
/* 219 */     setHung(itemstack);
/*     */   }
/*     */   
/*     */   public String func_70303_b()
/*     */   {
/* 224 */     return null;
/*     */   }
/*     */   
/*     */   public boolean func_94042_c()
/*     */   {
/* 229 */     return false;
/*     */   }
/*     */   
/*     */   public int func_70297_j_()
/*     */   {
/* 234 */     return 1;
/*     */   }
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer entityplayer)
/*     */   {
/* 239 */     return false;
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
/* 252 */     return false;
/*     */   }
/*     */   
/*     */   public void retrieveItem(EntityPlayer player) {
/* 256 */     if (player.field_70170_p.field_72995_K) {
/* 257 */       return;
/*     */     }
/* 259 */     double x = player.field_70165_t;
/* 260 */     double y = player.field_70163_u;
/* 261 */     double z = player.field_70161_v;
/*     */     
/* 263 */     EntityItem drop = new EntityItem(this.field_70331_k, x + 0.5D, y + 0.5D, z + 0.5D, getHung().func_77946_l());
/* 264 */     this.field_70331_k.func_72838_d(drop);
/* 265 */     hang(null);
/*     */   }
/*     */   
/*     */   private boolean canCraft() {
/* 269 */     return (canTan()) || (canCut());
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean shouldRenderCraftMetre()
/*     */   {
/* 275 */     return canCraft();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int getProgressBar(int i)
/*     */   {
/* 281 */     return (int)(i / 50.0F * this.progress);
/*     */   }
/*     */   
/*     */   public String getResultName()
/*     */   {
/* 286 */     return "";
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void setTempResult(ItemStack item) {}
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/TileEntityTanningRack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */