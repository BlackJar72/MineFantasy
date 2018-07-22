/*     */ package minefantasy.client.tile;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.api.IMFCrafter;
/*     */ import minefantasy.api.cooking.IHeatSource;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.system.network.PacketManagerMF;
/*     */ import minefantasy.system.network.PacketUserMF;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemHoe;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.ItemSword;
/*     */ import net.minecraft.item.ItemTool;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.packet.Packet;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.server.management.ServerConfigurationManager;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class TileEntityFirepit
/*     */   extends TileEntity implements IHeatSource, IMFCrafter, PacketUserMF
/*     */ {
/*  33 */   public int fuel = 0;
/*  34 */   private int maxFuel = 12000;
/*  35 */   private float charcoal = 0.0F;
/*     */   private int ticksExisted;
/*  37 */   private Random rand = new Random();
/*     */   
/*     */   public void func_70316_g()
/*     */   {
/*  41 */     super.func_70316_g();
/*  42 */     this.ticksExisted += 1;
/*     */     
/*  44 */     if (!this.field_70331_k.field_72995_K) {
/*  45 */       if ((!isLit()) && (this.fuel > 0) && (this.ticksExisted % 10 == 0)) {
/*  46 */         tryLight();
/*     */       }
/*     */       
/*  49 */       if (isLit()) {
/*  50 */         if (this.fuel > 0) {
/*  51 */           this.fuel -= 1;
/*  52 */           this.charcoal += 2.0833334E-4F;
/*     */         }
/*     */         
/*  55 */         if (this.fuel <= 0) {
/*  56 */           setLit(false);
/*     */         }
/*     */         
/*  59 */         if ((isLit()) && (isWet())) {
/*  60 */           extinguish(Block.field_71943_B.field_71990_ca, 0);
/*     */         }
/*     */       }
/*  63 */       sendPacketToClients();
/*     */     }
/*  65 */     if (this.field_70331_k.field_72995_K) {
/*  66 */       if ((this.ticksExisted % 5 == 0) && (isLit())) {
/*  67 */         this.field_70331_k.func_72869_a("smoke", this.field_70329_l + 0.5D, this.field_70330_m + 0.5D, this.field_70327_n + 0.5D, 0.0D, 0.0D, 0.0D);
/*  68 */         this.field_70331_k.func_72869_a("flame", this.field_70329_l + 0.5D, this.field_70330_m + 0.5D, this.field_70327_n + 0.5D, 0.0D, 0.0D, 0.0D);
/*     */         
/*  70 */         if (this.rand.nextInt(100) == 0) {
/*  71 */           this.field_70331_k.func_72980_b(this.field_70329_l + 0.5F, this.field_70330_m + 0.5F, this.field_70327_n + 0.5F, "fire.fire", 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F, false);
/*     */         }
/*     */       }
/*     */       
/*  75 */       if ((this.ticksExisted % 20 == 0) && 
/*  76 */         (this.field_70331_k.func_72798_a(this.field_70329_l, this.field_70330_m, this.field_70327_n) != MineFantasyBase.MFBlockFirepit.field_71990_ca)) {
/*  77 */         System.out.println("No Block");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean isWet()
/*     */   {
/*  84 */     if ((isWater(-1, 0, 0)) || (isWater(1, 0, 0)) || (isWater(0, 0, -1)) || (isWater(0, 0, 1)) || (isWater(0, 1, 0))) {
/*  85 */       return true;
/*     */     }
/*  87 */     if ((this.field_70331_k.func_72798_a(this.field_70329_l, this.field_70330_m + 1, this.field_70327_n) == MineFantasyBase.MFBlockRoast.field_71990_ca) && 
/*  88 */       (this.field_70331_k.func_72951_B(this.field_70329_l, this.field_70330_m + 2, this.field_70327_n))) {
/*  89 */       return true;
/*     */     }
/*     */     
/*     */ 
/*  93 */     return this.field_70331_k.func_72951_B(this.field_70329_l, this.field_70330_m + 1, this.field_70327_n);
/*     */   }
/*     */   
/*     */   public int getCharcoalDrop() {
/*  97 */     return (int)Math.floor(this.charcoal);
/*     */   }
/*     */   
/*     */   public boolean isBurning() {
/* 101 */     return (isLit()) && (this.fuel > 0);
/*     */   }
/*     */   
/*     */   public boolean isLit() {
/* 105 */     return this.field_70331_k.func_72805_g(this.field_70329_l, this.field_70330_m, this.field_70327_n) == 1;
/*     */   }
/*     */   
/*     */   private void tryLight() {
/* 109 */     if ((isFire(-1, 0, 0)) || (isFire(1, 0, 0)) || (isFire(0, 0, -1)) || (isFire(0, 0, 1)) || (isFire(0, -1, 0)) || (isFire(0, 1, 0))) {
/* 110 */       setLit(true);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean isFire(int x, int y, int z) {
/* 115 */     return this.field_70331_k.func_72803_f(this.field_70329_l + x, this.field_70330_m + y, this.field_70327_n + z) == Material.field_76250_n;
/*     */   }
/*     */   
/*     */   private boolean isWater(int x, int y, int z) {
/* 119 */     return this.field_70331_k.func_72803_f(this.field_70329_l + x, this.field_70330_m + y, this.field_70327_n + z) == Material.field_76244_g;
/*     */   }
/*     */   
/*     */   public boolean addFuel(ItemStack input) {
/* 123 */     int amount = getItemBurnTime(input);
/* 124 */     if ((amount > 0) && (this.fuel < this.maxFuel)) {
/* 125 */       this.fuel += amount;
/* 126 */       if (this.fuel > this.maxFuel) {
/* 127 */         this.fuel = this.maxFuel;
/*     */       }
/* 129 */       return true;
/*     */     }
/* 131 */     return false;
/*     */   }
/*     */   
/*     */   public void setLit(boolean lit) {
/* 135 */     if (this.field_70331_k != null) {
/* 136 */       this.field_70331_k.func_72921_c(this.field_70329_l, this.field_70330_m, this.field_70327_n, lit ? 1 : 0, 2);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70310_b(NBTTagCompound nbt)
/*     */   {
/* 142 */     super.func_70310_b(nbt);
/*     */     
/* 144 */     nbt.func_74768_a("fuel", this.fuel);
/* 145 */     nbt.func_74768_a("maxFuel", this.maxFuel);
/* 146 */     nbt.func_74768_a("ticksExisted", this.ticksExisted);
/*     */     
/* 148 */     nbt.func_74776_a("charcoal", this.charcoal);
/*     */   }
/*     */   
/*     */   public void func_70307_a(NBTTagCompound nbt)
/*     */   {
/* 153 */     super.func_70307_a(nbt);
/*     */     
/* 155 */     setLit(nbt.func_74767_n("isLit"));
/*     */     
/* 157 */     this.fuel = nbt.func_74762_e("fuel");
/* 158 */     this.maxFuel = nbt.func_74762_e("maxFuel");
/* 159 */     this.ticksExisted = nbt.func_74762_e("ticksExisted");
/*     */     
/* 161 */     this.charcoal = nbt.func_74760_g("charcoal");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getItemBurnTime(ItemStack input)
/*     */   {
/* 170 */     if (input == null) {
/* 171 */       return 0;
/*     */     }
/* 173 */     int i = input.func_77973_b().field_77779_bT;
/* 174 */     int d = input.func_77960_j();
/* 175 */     Item item = input.func_77973_b();
/*     */     
/* 177 */     if (((item instanceof ItemTool)) && (((ItemTool)item).func_77861_e().equals("WOOD")))
/* 178 */       return 3600;
/* 179 */     if (((item instanceof ItemSword)) && (((ItemSword)item).func_77825_f().equals("WOOD")))
/* 180 */       return 1800;
/* 181 */     if (((item instanceof ItemHoe)) && (((ItemHoe)item).func_77842_f().equals("WOOD")))
/* 182 */       return 2400;
/* 183 */     if (i == Item.field_77669_D.field_77779_bT)
/* 184 */       return 600;
/* 185 */     if (i == ItemListMF.plank.field_77779_bT) {
/* 186 */       return 1200;
/*     */     }
/* 188 */     if (i == ItemListMF.misc.field_77779_bT) {
/* 189 */       if (d == 25)
/* 190 */         return 1800;
/* 191 */       if (d == 114) {
/* 192 */         return 3600;
/*     */       }
/*     */     }
/* 195 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean canPlaceAbove()
/*     */   {
/* 201 */     return true;
/*     */   }
/*     */   
/*     */   public int getHeat()
/*     */   {
/* 206 */     if (!isBurning()) {
/* 207 */       return 0;
/*     */     }
/* 209 */     return 300;
/*     */   }
/*     */   
/*     */   private void sendPacketToClients() {
/*     */     try {
/* 214 */       Packet packet = PacketManagerMF.getPacketInteger(this, this.fuel);
/* 215 */       FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*     */     } catch (Exception e) {
/* 217 */       System.out.println("MineFantasy: Client connections lost");
/*     */     }
/*     */   }
/*     */   
/*     */   public void recievePacket(ByteArrayDataInput data)
/*     */   {
/* 223 */     this.fuel = data.readInt();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean shouldRenderCraftMetre()
/*     */   {
/* 229 */     return this.fuel > 0;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int getProgressBar(int width)
/*     */   {
/* 235 */     return this.fuel * width / this.maxFuel;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getResultName()
/*     */   {
/* 241 */     int seconds = (int)Math.floor(this.fuel / 20);
/* 242 */     int mins = (int)Math.floor(seconds / 60);
/* 243 */     seconds -= mins * 60;
/*     */     
/* 245 */     String s = "";
/* 246 */     if (seconds < 10) {
/* 247 */       s = s + "0";
/*     */     }
/*     */     
/* 250 */     return StatCollector.func_74838_a("info.fuel") + "= " + mins + ":" + s + seconds;
/*     */   }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void setTempResult(ItemStack res) {}
/*     */   
/*     */   public void extinguish()
/*     */   {
/* 259 */     extinguish(Block.field_71939_E.field_71990_ca, 0);
/*     */   }
/*     */   
/*     */   public void extinguish(int block, int meta) {
/* 263 */     this.field_70331_k.func_72908_a(this.field_70329_l + 0.5F, this.field_70330_m + 0.25F, this.field_70327_n + 0.5F, "random.fizz", 0.4F, 2.0F + this.rand.nextFloat() * 0.4F);
/* 264 */     this.field_70331_k.func_72869_a("largesmoke", this.field_70329_l + 0.5D, this.field_70330_m + 0.5D, this.field_70327_n + 0.5D, 0.0D, 0.0D, 0.0D);
/* 265 */     this.field_70331_k.func_72869_a("tilecrack_" + block + "_" + meta, this.field_70329_l + 0.5D, this.field_70330_m + 0.5D, this.field_70327_n + 0.5D, 0.0D, 0.0D, 0.0D);
/*     */     
/* 267 */     setLit(false);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/TileEntityFirepit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */