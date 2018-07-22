/*     */ package minefantasy.entity;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import java.io.PrintStream;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.item.BoltType;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.item.ToolMaterialMedieval;
/*     */ import minefantasy.system.cfg;
/*     */ import minefantasy.system.network.PacketManagerMF;
/*     */ import minefantasy.system.network.PacketUserMF;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.enchantment.EnchantmentThorns;
/*     */ import net.minecraft.entity.DataWatcher;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.EnumCreatureAttribute;
/*     */ import net.minecraft.entity.IProjectile;
/*     */ import net.minecraft.entity.monster.EntityEnderman;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.entity.projectile.EntityArrow;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.NetServerHandler;
/*     */ import net.minecraft.network.packet.Packet;
/*     */ import net.minecraft.network.packet.Packet70GameEvent;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.server.management.ServerConfigurationManager;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.util.Vec3Pool;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityBoltMF
/*     */   extends EntityArrow implements IProjectile, PacketUserMF
/*     */ {
/*     */   private BoltType type;
/*  47 */   private int xTile = -1;
/*  48 */   private int yTile = -1;
/*  49 */   private int zTile = -1;
/*  50 */   private int inTile = 0;
/*  51 */   private int inData = 0;
/*  52 */   private boolean inGround = false;
/*     */   
/*     */ 
/*  55 */   public int field_70251_a = 0;
/*     */   
/*     */ 
/*  58 */   public int BoltShake = 0;
/*     */   
/*     */   public Entity field_70250_c;
/*     */   
/*     */   private int ticksInGround;
/*  63 */   private int ticksInAir = 0;
/*     */   
/*     */   private int knockbackStrength;
/*     */   
/*     */   private boolean hasHit;
/*     */   
/*     */   public EntityBoltMF(World world)
/*     */   {
/*  71 */     super(world);
/*  72 */     if (this.field_70146_Z.nextInt(10) == 0) {
/*  73 */       setCritical(true);
/*     */     }
/*  75 */     func_70239_b(1.0D);
/*  76 */     this.field_70155_l = 10.0D;
/*  77 */     func_70105_a(0.5F, 0.5F);
/*     */   }
/*     */   
/*     */   public EntityBoltMF(World world, double x, double y, double z, int id) {
/*  81 */     this(world);
/*  82 */     setType(id);
/*  83 */     func_70107_b(x, y, z);
/*  84 */     this.field_70129_M = 0.0F;
/*     */   }
/*     */   
/*     */   public EntityBoltMF(World world, EntityLivingBase shooter, float accur, float power, int id) {
/*  88 */     this(world);
/*  89 */     setType(id);
/*  90 */     this.field_70250_c = shooter;
/*     */     
/*  92 */     if ((shooter instanceof EntityPlayer)) {
/*  93 */       this.field_70251_a = (((EntityPlayer)shooter).field_71075_bZ.field_75098_d ? 2 : 1);
/*     */     }
/*  95 */     func_70012_b(shooter.field_70165_t, shooter.field_70163_u + shooter.func_70047_e(), shooter.field_70161_v, shooter.field_70177_z, shooter.field_70125_A);
/*  96 */     this.field_70165_t -= MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F;
/*  97 */     this.field_70163_u -= 0.10000000149011612D;
/*  98 */     this.field_70161_v -= MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F;
/*  99 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 100 */     this.field_70129_M = 0.0F;
/* 101 */     this.field_70159_w = (-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F));
/* 102 */     this.field_70179_y = (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F));
/* 103 */     this.field_70181_x = (-MathHelper.func_76126_a(this.field_70125_A / 180.0F * 3.1415927F));
/* 104 */     func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, power * 1.5F, accur);
/*     */   }
/*     */   
/*     */   public EntityBoltMF(World world, EntityLivingBase shooter, EntityLivingBase target, float power, float precision, int id) {
/* 108 */     this(world);
/*     */     
/* 110 */     this.field_70250_c = shooter;
/* 111 */     this.field_70251_a = ((shooter instanceof EntityPlayer) ? 1 : 0);
/* 112 */     setType(id);
/*     */     
/* 114 */     this.field_70163_u = (shooter.field_70163_u + shooter.func_70047_e() - 0.10000000149011612D);
/* 115 */     double var6 = target.field_70165_t - shooter.field_70165_t;
/* 116 */     double var8 = target.field_70163_u + target.func_70047_e() - 3.499999888241293D * getArc() - this.field_70163_u;
/* 117 */     double var10 = target.field_70161_v - shooter.field_70161_v;
/*     */     
/* 119 */     double range = shooter.func_70032_d(target);
/*     */     
/* 121 */     var8 = calculateRange(var8, range, power);
/* 122 */     if (target.field_70163_u > shooter.field_70163_u) {
/* 123 */       double dist = target.field_70163_u - shooter.field_70163_u;
/* 124 */       var8 += dist / 10.0D;
/*     */     }
/*     */     
/* 127 */     double var12 = MathHelper.func_76133_a(var6 * var6 + var10 * var10);
/*     */     
/* 129 */     if (var12 >= 1.0E-7D) {
/* 130 */       float var14 = (float)(Math.atan2(var10, var6) * 180.0D / 3.141592653589793D) - 90.0F;
/* 131 */       float var15 = (float)-(Math.atan2(var8, var12) * 180.0D / 3.141592653589793D);
/* 132 */       double var16 = var6 / var12;
/* 133 */       double var18 = var10 / var12;
/* 134 */       func_70012_b(shooter.field_70165_t + var16, this.field_70163_u, shooter.field_70161_v + var18, var14, var15);
/* 135 */       this.field_70129_M = 0.0F;
/* 136 */       float var20 = (float)var12 * getArc();
/* 137 */       func_70186_c(var6, var8 + var20, var10, power, precision);
/*     */     }
/*     */   }
/*     */   
/*     */   private double calculateRange(double yPos, double range, double power) {
/* 142 */     double yOffset = 0.041666666666666664D * range;
/* 143 */     if (range > 28.0D) {
/* 144 */       yOffset *= range / 16.0D;
/*     */     }
/* 146 */     if (range > 48.0D) {
/* 147 */       yOffset += 0.02D * range;
/*     */     }
/*     */     
/* 150 */     if (yOffset > 0.0D) {
/* 151 */       yPos += yOffset / 24.0D * range;
/*     */     }
/*     */     
/* 154 */     return yPos;
/*     */   }
/*     */   
/*     */   public EntityBoltMF(World world, EntityLivingBase shooter, float power, int type) {
/* 158 */     this(world);
/* 159 */     setType(type);
/* 160 */     this.field_70250_c = shooter;
/*     */     
/* 162 */     if ((shooter instanceof EntityPlayer)) {
/* 163 */       this.field_70251_a = 1;
/*     */     }
/*     */     
/* 166 */     func_70012_b(shooter.field_70165_t, shooter.field_70163_u + shooter.func_70047_e(), shooter.field_70161_v, shooter.field_70177_z, shooter.field_70125_A);
/* 167 */     this.field_70165_t -= MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F;
/* 168 */     this.field_70163_u -= 0.10000000149011612D;
/* 169 */     this.field_70161_v -= MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F;
/* 170 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 171 */     this.field_70129_M = 0.0F;
/* 172 */     this.field_70159_w = (-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F));
/* 173 */     this.field_70179_y = (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F));
/* 174 */     this.field_70181_x = (-MathHelper.func_76126_a(this.field_70125_A / 180.0F * 3.1415927F));
/* 175 */     func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, power * 1.5F, 1.0F);
/*     */   }
/*     */   
/*     */   protected void func_70088_a() {
/* 179 */     this.field_70180_af.func_75682_a(16, Byte.valueOf((byte)0));
/* 180 */     this.field_70180_af.func_75682_a(17, Integer.valueOf(0));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70016_h(double xv, double yv, double zv)
/*     */   {
/* 187 */     this.field_70159_w = xv;
/* 188 */     this.field_70181_x = yv;
/* 189 */     this.field_70179_y = zv;
/*     */     
/* 191 */     if ((this.field_70127_C == 0.0F) && (this.field_70126_B == 0.0F)) {
/* 192 */       float f = MathHelper.func_76133_a(xv * xv + zv * zv);
/* 193 */       this.field_70126_B = (this.field_70177_z = (float)(Math.atan2(xv, zv) * 180.0D / 3.141592653589793D));
/* 194 */       this.field_70127_C = (this.field_70125_A = (float)(Math.atan2(yv, f) * 180.0D / 3.141592653589793D));
/* 195 */       this.field_70127_C = this.field_70125_A;
/* 196 */       this.field_70126_B = this.field_70177_z;
/* 197 */       func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
/* 198 */       this.ticksInGround = 0;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70071_h_()
/*     */   {
/* 206 */     if ((this.field_70170_p.field_72995_K) && 
/* 207 */       (this.type == null)) {
/* 208 */       this.type = BoltType.getBolt(getType());
/*     */     }
/*     */     
/*     */ 
/* 212 */     super.func_70030_z();
/*     */     
/* 214 */     if ((this.field_70127_C == 0.0F) && (this.field_70126_B == 0.0F)) {
/* 215 */       float f = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 216 */       this.field_70126_B = (this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / 3.141592653589793D));
/* 217 */       this.field_70127_C = (this.field_70125_A = (float)(Math.atan2(this.field_70181_x, f) * 180.0D / 3.141592653589793D));
/*     */     }
/*     */     
/* 220 */     int i = this.field_70170_p.func_72798_a(this.xTile, this.yTile, this.zTile);
/*     */     
/* 222 */     if (i > 0) {
/* 223 */       Block.field_71973_m[i].func_71902_a(this.field_70170_p, this.xTile, this.yTile, this.zTile);
/* 224 */       AxisAlignedBB axisalignedbb = Block.field_71973_m[i].func_71872_e(this.field_70170_p, this.xTile, this.yTile, this.zTile);
/*     */       
/* 226 */       if ((axisalignedbb != null) && (axisalignedbb.func_72318_a(this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t, this.field_70163_u, this.field_70161_v)))) {
/* 227 */         this.inGround = true;
/*     */       }
/*     */     }
/*     */     
/* 231 */     if (this.BoltShake > 0) {
/* 232 */       this.BoltShake -= 1;
/*     */     }
/*     */     
/* 235 */     if (this.inGround) {
/* 236 */       int j = this.field_70170_p.func_72798_a(this.xTile, this.yTile, this.zTile);
/* 237 */       int k = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
/*     */       
/* 239 */       if ((j == this.inTile) && (k == this.inData)) {
/* 240 */         this.ticksInGround += 1;
/*     */         
/* 242 */         if (this.ticksInGround == 1200) {
/* 243 */           func_70106_y();
/*     */         }
/*     */       } else {
/* 246 */         this.inGround = false;
/* 247 */         this.field_70159_w *= this.field_70146_Z.nextFloat() * 0.2F;
/* 248 */         this.field_70181_x *= this.field_70146_Z.nextFloat() * 0.2F;
/* 249 */         this.field_70179_y *= this.field_70146_Z.nextFloat() * 0.2F;
/* 250 */         this.ticksInGround = 0;
/* 251 */         this.ticksInAir = 0;
/*     */       }
/*     */     } else {
/* 254 */       this.ticksInAir += 1;
/* 255 */       Vec3 vec3 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 256 */       Vec3 vec31 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 257 */       MovingObjectPosition movingobjectposition = this.field_70170_p.func_72831_a(vec3, vec31, false, true);
/* 258 */       vec3 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 259 */       vec31 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/*     */       
/* 261 */       if (movingobjectposition != null) {
/* 262 */         vec31 = this.field_70170_p.func_82732_R().func_72345_a(movingobjectposition.field_72307_f.field_72450_a, movingobjectposition.field_72307_f.field_72448_b, movingobjectposition.field_72307_f.field_72449_c);
/*     */       }
/*     */       
/* 265 */       Entity entity = null;
/* 266 */       List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0D, 1.0D, 1.0D));
/* 267 */       double d0 = 0.0D;
/*     */       
/*     */ 
/*     */ 
/* 271 */       for (int l = 0; l < list.size(); l++) {
/* 272 */         Entity entity1 = (Entity)list.get(l);
/*     */         
/* 274 */         if ((entity1.func_70067_L()) && ((entity1 != this.field_70250_c) || (this.ticksInAir >= 5))) {
/* 275 */           float f1 = 0.3F;
/* 276 */           AxisAlignedBB axisalignedbb1 = entity1.field_70121_D.func_72314_b(f1, f1, f1);
/* 277 */           MovingObjectPosition movingobjectposition1 = axisalignedbb1.func_72327_a(vec3, vec31);
/*     */           
/* 279 */           if (movingobjectposition1 != null) {
/* 280 */             double d1 = vec3.func_72438_d(movingobjectposition1.field_72307_f);
/*     */             
/* 282 */             if ((d1 < d0) || (d0 == 0.0D)) {
/* 283 */               entity = entity1;
/* 284 */               d0 = d1;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 290 */       if (entity != null) {
/* 291 */         movingobjectposition = new MovingObjectPosition(entity);
/*     */       }
/*     */       
/* 294 */       if ((movingobjectposition != null) && (movingobjectposition.field_72308_g != null) && ((movingobjectposition.field_72308_g instanceof EntityPlayer))) {
/* 295 */         EntityPlayer entityplayer = (EntityPlayer)movingobjectposition.field_72308_g;
/*     */         
/* 297 */         if ((entityplayer.field_71075_bZ.field_75102_a) || (((this.field_70250_c instanceof EntityPlayer)) && (!((EntityPlayer)this.field_70250_c).func_96122_a(entityplayer)))) {
/* 298 */           movingobjectposition = null;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 305 */       if (movingobjectposition != null) {
/* 306 */         if ((movingobjectposition.field_72308_g != null) && (!this.hasHit)) {
/* 307 */           float dam = (float)func_70242_d();
/*     */           
/* 309 */           if (func_70241_g()) {
/* 310 */             dam += this.field_70146_Z.nextFloat() * (dam / 2.0F);
/*     */           }
/*     */           
/* 313 */           DamageSource damagesource = null;
/*     */           
/* 315 */           if (this.field_70250_c == null) {
/* 316 */             damagesource = DamageSource.func_76353_a(this, this);
/*     */           } else {
/* 318 */             damagesource = DamageSource.func_76353_a(this, this.field_70250_c);
/*     */           }
/*     */           
/* 321 */           if ((func_70027_ad()) && (!(movingobjectposition.field_72308_g instanceof EntityEnderman))) {
/* 322 */             movingobjectposition.field_72308_g.func_70015_d(5);
/*     */           }
/* 324 */           if ((!this.field_70170_p.field_72995_K) && (MineFantasyBase.isDebug())) {
/* 325 */             System.out.println("Base Damage: " + dam);
/*     */           }
/*     */           
/* 328 */           dam = applyBonus(movingobjectposition.field_72308_g, dam);
/*     */           
/* 330 */           if ((!this.field_70170_p.field_72995_K) && (MineFantasyBase.isDebug())) {
/* 331 */             System.out.println("Full Damage: " + dam);
/*     */           }
/*     */           
/* 334 */           if (movingobjectposition.field_72308_g.func_70097_a(damagesource, dam)) {
/* 335 */             movingobjectposition.field_72308_g.field_70172_ad = 0;
/* 336 */             if ((movingobjectposition.field_72308_g instanceof EntityLivingBase)) {
/* 337 */               EntityLivingBase entityliving = (EntityLivingBase)movingobjectposition.field_72308_g;
/*     */               
/* 339 */               if (this.knockbackStrength > 0) {
/* 340 */                 float f3 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/*     */                 
/* 342 */                 if (f3 > 0.0F) {
/* 343 */                   movingobjectposition.field_72308_g.func_70024_g(this.field_70159_w * this.knockbackStrength * 0.6000000238418579D / f3, 0.1D, this.field_70179_y * this.knockbackStrength * 0.6000000238418579D / f3);
/*     */                 }
/*     */               }
/*     */               
/* 347 */               if (this.field_70250_c != null) {
/* 348 */                 EnchantmentThorns.func_92096_a(this.field_70250_c, entityliving, this.field_70146_Z);
/*     */               }
/*     */               
/* 351 */               if ((this.field_70250_c != null) && (movingobjectposition.field_72308_g != this.field_70250_c) && ((movingobjectposition.field_72308_g instanceof EntityPlayer)) && ((this.field_70250_c instanceof EntityPlayerMP))) {
/* 352 */                 ((EntityPlayerMP)this.field_70250_c).field_71135_a.func_72567_b(new Packet70GameEvent(6, 0));
/*     */               }
/*     */             }
/*     */             
/* 356 */             func_85030_a("random.bowhit", 1.0F, 1.2F / (this.field_70146_Z.nextFloat() * 0.2F + 0.9F));
/*     */             
/* 358 */             boolean leathalHit = false;
/* 359 */             if (((movingobjectposition.field_72308_g instanceof EntityLivingBase)) && 
/* 360 */               (((EntityLivingBase)movingobjectposition.field_72308_g).func_110143_aJ() <= 0.0F)) {
/* 361 */               leathalHit = true;
/*     */             }
/* 363 */             if (getType() != 3)
/* 364 */               leathalHit = false;
/* 365 */             if (!(movingobjectposition.field_72308_g instanceof EntityEnderman)) {
/* 366 */               tryBreak(movingobjectposition.field_72308_g);
/*     */             }
/* 368 */           } else if (getType() != 3) {
/* 369 */             this.field_70159_w *= -0.10000000149011612D;
/* 370 */             this.field_70181_x *= -0.10000000149011612D;
/* 371 */             this.field_70179_y *= -0.10000000149011612D;
/* 372 */             this.field_70177_z += 180.0F;
/* 373 */             this.field_70126_B += 180.0F;
/* 374 */             this.ticksInAir = 0;
/*     */           }
/*     */         } else {
/* 377 */           this.xTile = movingobjectposition.field_72311_b;
/* 378 */           this.yTile = movingobjectposition.field_72312_c;
/* 379 */           this.zTile = movingobjectposition.field_72309_d;
/* 380 */           this.inTile = this.field_70170_p.func_72798_a(this.xTile, this.yTile, this.zTile);
/* 381 */           this.inData = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
/* 382 */           this.field_70159_w = ((float)(movingobjectposition.field_72307_f.field_72450_a - this.field_70165_t));
/* 383 */           this.field_70181_x = ((float)(movingobjectposition.field_72307_f.field_72448_b - this.field_70163_u));
/* 384 */           this.field_70179_y = ((float)(movingobjectposition.field_72307_f.field_72449_c - this.field_70161_v));
/* 385 */           float f2 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
/* 386 */           this.field_70165_t -= this.field_70159_w / f2 * 0.05000000074505806D;
/* 387 */           this.field_70163_u -= this.field_70181_x / f2 * 0.05000000074505806D;
/* 388 */           this.field_70161_v -= this.field_70179_y / f2 * 0.05000000074505806D;
/* 389 */           func_85030_a("random.bowhit", 1.0F, 1.2F / (this.field_70146_Z.nextFloat() * 0.2F + 0.9F));
/* 390 */           this.inGround = true;
/* 391 */           this.BoltShake = 7;
/* 392 */           setCritical(false);
/*     */           
/* 394 */           if (this.inTile != 0) {
/* 395 */             Block.field_71973_m[this.inTile].func_71869_a(this.field_70170_p, this.xTile, this.yTile, this.zTile, this);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 400 */       if (func_70241_g()) {
/* 401 */         for (l = 0; l < 4; l++) {
/* 402 */           this.field_70170_p.func_72869_a("crit", this.field_70165_t + this.field_70159_w * l / 4.0D, this.field_70163_u + this.field_70181_x * l / 4.0D, this.field_70161_v + this.field_70179_y * l / 4.0D, -this.field_70159_w, -this.field_70181_x + 0.2D, -this.field_70179_y);
/*     */         }
/*     */       }
/*     */       
/* 406 */       this.field_70165_t += this.field_70159_w;
/* 407 */       this.field_70163_u += this.field_70181_x;
/* 408 */       this.field_70161_v += this.field_70179_y;
/* 409 */       float f2 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 410 */       this.field_70177_z = ((float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / 3.141592653589793D));
/*     */       
/* 412 */       for (this.field_70125_A = ((float)(Math.atan2(this.field_70181_x, f2) * 180.0D / 3.141592653589793D)); this.field_70125_A - this.field_70127_C < -180.0F; this.field_70127_C -= 360.0F) {}
/*     */       
/*     */ 
/*     */ 
/* 416 */       while (this.field_70125_A - this.field_70127_C >= 180.0F) {
/* 417 */         this.field_70127_C += 360.0F;
/*     */       }
/*     */       
/* 420 */       while (this.field_70177_z - this.field_70126_B < -180.0F) {
/* 421 */         this.field_70126_B -= 360.0F;
/*     */       }
/*     */       
/* 424 */       while (this.field_70177_z - this.field_70126_B >= 180.0F) {
/* 425 */         this.field_70126_B += 360.0F;
/*     */       }
/*     */       
/* 428 */       this.field_70125_A = (this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2F);
/* 429 */       this.field_70177_z = (this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2F);
/* 430 */       float f4 = 0.99F;
/* 431 */       float f1 = getGravity();
/*     */       
/* 433 */       if (func_70090_H()) {
/* 434 */         for (int j1 = 0; j1 < 4; j1++) {
/* 435 */           float f3 = 0.25F;
/* 436 */           this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * f3, this.field_70163_u - this.field_70181_x * f3, this.field_70161_v - this.field_70179_y * f3, this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */         }
/*     */         
/* 439 */         f4 = 0.8F;
/*     */       }
/*     */       
/* 442 */       this.field_70159_w *= f4;
/* 443 */       this.field_70181_x *= f4;
/* 444 */       this.field_70179_y *= f4;
/* 445 */       this.field_70181_x -= f1;
/* 446 */       func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 447 */       func_70017_D();
/*     */     }
/* 449 */     if ((this.field_70173_aa <= 10) && (!this.field_70170_p.field_72995_K)) {
/* 450 */       sendTrackerPacket();
/*     */     }
/*     */   }
/*     */   
/*     */   private void tryBreak(Entity hit) {
/* 455 */     this.hasHit = true;
/* 456 */     if (getBolt() != null) {
/* 457 */       int c = getBolt().getBreakChance();
/* 458 */       int chance = -1;
/* 459 */       if (c != -1) {
/* 460 */         if (c <= 0)
/* 461 */           c = 1;
/* 462 */         chance = this.field_70146_Z.nextInt(c);
/*     */       }
/*     */       
/* 465 */       if ((MineFantasyBase.isDebug()) && (!this.field_70170_p.field_72995_K)) {
/* 466 */         System.out.println("Arrow Break Chance: 1 in " + getBolt().getBreakChance() + ". hit has rolled a " + chance);
/*     */       }
/* 468 */       if ((!cfg.durableArrows) || (chance == 0)) {
/* 469 */         if (!this.field_70170_p.field_72995_K) {
/* 470 */           func_85030_a("random.break", 1.0F, 1.0F);
/* 471 */           func_70106_y();
/*     */         }
/*     */       } else {
/* 474 */         if ((hit != null) && (this.field_70251_a == 1)) {
/* 475 */           hit.func_70099_a(getDroppedItem(), 0.0F);
/*     */         }
/* 477 */         func_70106_y();
/*     */       }
/*     */     }
/* 480 */     else if (!this.field_70170_p.field_72995_K) {
/* 481 */       func_70106_y();
/*     */     }
/*     */   }
/*     */   
/*     */   private float applyBonus(Entity entityHit, float dam)
/*     */   {
/* 487 */     EntityLivingBase living = null;
/* 488 */     if ((entityHit instanceof EntityLivingBase)) {
/* 489 */       living = (EntityLivingBase)entityHit;
/*     */     }
/*     */     
/* 492 */     if (this.type != null) {
/* 493 */       if (this.type.material == ToolMaterialMedieval.DRAGONFORGE) {
/* 494 */         entityHit.func_70015_d(10);
/*     */       }
/* 496 */       if ((this.type.material == ToolMaterialMedieval.IGNOTUMITE) && 
/* 497 */         (this.field_70250_c != null) && ((this.field_70250_c instanceof EntityLivingBase))) {
/* 498 */         ((EntityLivingBase)this.field_70250_c).func_70691_i(dam / 4.0F);
/*     */       }
/*     */       
/* 501 */       if ((this.type.material == ToolMaterialMedieval.ORNATE) && (
/* 502 */         ((living != null) && (living.func_70668_bt() == EnumCreatureAttribute.UNDEAD)) || (entityHit.getClass().getName().endsWith("MoCEntityWerewolf")))) {
/* 503 */         living.func_70015_d(10);
/* 504 */         if (living.getClass().getName().endsWith("MoCEntityWarewolf")) {
/* 505 */           dam *= 10.0F;
/*     */         } else {
/* 507 */           dam *= 3.0F;
/*     */         }
/* 509 */         living.field_70170_p.func_72956_a(living, "random.fizz", 1.0F, 1.0F);
/*     */       }
/*     */     }
/*     */     
/* 513 */     return dam;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70014_b(NBTTagCompound nbt)
/*     */   {
/* 520 */     super.func_70014_b(nbt);
/* 521 */     nbt.func_74768_a("type", getType());
/* 522 */     nbt.func_74757_a("HasHit", this.hasHit);
/* 523 */     nbt.func_74777_a("xTile", (short)this.xTile);
/* 524 */     nbt.func_74777_a("yTile", (short)this.yTile);
/* 525 */     nbt.func_74777_a("zTile", (short)this.zTile);
/* 526 */     nbt.func_74774_a("inTile", (byte)this.inTile);
/* 527 */     nbt.func_74774_a("inData", (byte)this.inData);
/* 528 */     nbt.func_74774_a("shake", (byte)this.BoltShake);
/* 529 */     nbt.func_74774_a("inGround", (byte)(this.inGround ? 1 : 0));
/* 530 */     nbt.func_74774_a("pickup", (byte)this.field_70251_a);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70037_a(NBTTagCompound nbt)
/*     */   {
/* 537 */     super.func_70037_a(nbt);
/* 538 */     if (nbt.func_74764_b("type"))
/* 539 */       setType(nbt.func_74762_e("type"));
/* 540 */     this.xTile = nbt.func_74765_d("xTile");
/* 541 */     this.yTile = nbt.func_74765_d("yTile");
/* 542 */     this.zTile = nbt.func_74765_d("zTile");
/* 543 */     this.inTile = (nbt.func_74771_c("inTile") & 0xFF);
/* 544 */     this.inData = (nbt.func_74771_c("inData") & 0xFF);
/* 545 */     this.BoltShake = (nbt.func_74771_c("shake") & 0xFF);
/* 546 */     this.inGround = (nbt.func_74771_c("inGround") == 1);
/*     */     
/* 548 */     this.hasHit = nbt.func_74767_n("HasHit");
/* 549 */     if (nbt.func_74764_b("pickup")) {
/* 550 */       this.field_70251_a = nbt.func_74771_c("pickup");
/* 551 */     } else if (nbt.func_74764_b("player")) {
/* 552 */       this.field_70251_a = (nbt.func_74767_n("player") ? 1 : 0);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70100_b_(EntityPlayer player)
/*     */   {
/* 560 */     ItemStack drop = getDroppedItem();
/* 561 */     if ((drop != null) && (!this.field_70170_p.field_72995_K) && (this.inGround) && (this.BoltShake <= 0)) {
/* 562 */       boolean flag = (this.field_70251_a == 1) || ((this.field_70251_a == 2) && (player.field_71075_bZ.field_75098_d));
/*     */       
/* 564 */       if ((this.field_70251_a == 1) && (!player.field_71071_by.func_70441_a(drop))) {
/* 565 */         flag = false;
/*     */       }
/*     */       
/* 568 */       if (flag) {
/* 569 */         func_85030_a("random.pop", 0.2F, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7F + 1.0F) * 2.0F);
/* 570 */         player.func_71001_a(this, 1);
/* 571 */         func_70106_y();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private float getGravity()
/*     */   {
/* 580 */     float gravity = 0.075F;
/* 581 */     if ((this.type != null) && 
/* 582 */       (this.type.material == ToolMaterialMedieval.MITHRIL)) {
/* 583 */       gravity *= 0.5F;
/*     */     }
/*     */     
/*     */ 
/* 587 */     return gravity;
/*     */   }
/*     */   
/*     */   public String getTexture() {
/* 591 */     if ((this.type == null) || (this.type.getTextureName() == null)) {
/* 592 */       return "BoltIron";
/*     */     }
/* 594 */     return this.type.getTextureName();
/*     */   }
/*     */   
/*     */   private float getArc() {
/* 598 */     return 0.3F;
/*     */   }
/*     */   
/*     */   public double func_70242_d() {
/* 602 */     return BoltType.getDamage(this.type) * super.func_70242_d();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70240_a(int str)
/*     */   {
/* 609 */     super.func_70240_a(str);
/* 610 */     this.knockbackStrength = str;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCritical(boolean flag)
/*     */   {
/* 617 */     super.func_70243_d(flag);
/* 618 */     byte b0 = this.field_70180_af.func_75683_a(16);
/*     */     
/* 620 */     if (flag) {
/* 621 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(b0 | 0x1)));
/*     */     } else {
/* 623 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(b0 & 0xFFFFFFFE)));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70243_d(boolean flag) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean func_70241_g()
/*     */   {
/* 635 */     byte b0 = this.field_70180_af.func_75683_a(16);
/* 636 */     return (b0 & 0x1) != 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/* 645 */     return this.field_70180_af.func_75679_c(17);
/*     */   }
/*     */   
/*     */   public void setType(int type) {
/* 649 */     this.type = BoltType.getBolt(type);
/* 650 */     this.field_70180_af.func_75692_b(17, Integer.valueOf(type));
/*     */   }
/*     */   
/*     */   public void setOwner(EntityLivingBase thrower) {
/* 654 */     this.field_70250_c = thrower;
/*     */   }
/*     */   
/*     */   public ItemStack getDroppedItem() {
/* 658 */     return new ItemStack(ItemListMF.boltMF, 1, getType());
/*     */   }
/*     */   
/*     */   public void sendTrackerPacket() {
/*     */     try {
/* 663 */       Packet packet = PacketManagerMF.getEntityPacketDoubleArray(this, new double[] { this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70159_w, this.field_70181_x, this.field_70179_y, this.field_70125_A, this.field_70177_z, this.field_70127_C, this.field_70126_B });
/* 664 */       FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*     */     }
/*     */     catch (NullPointerException localNullPointerException) {}
/*     */   }
/*     */   
/*     */ 
/*     */   public void recievePacket(ByteArrayDataInput data)
/*     */   {
/* 672 */     this.field_70165_t = data.readDouble();
/* 673 */     this.field_70163_u = data.readDouble();
/* 674 */     this.field_70161_v = data.readDouble();
/*     */     
/* 676 */     this.field_70159_w = data.readDouble();
/* 677 */     this.field_70181_x = data.readDouble();
/* 678 */     this.field_70179_y = data.readDouble();
/*     */     
/* 680 */     this.field_70125_A = ((float)data.readDouble());
/* 681 */     this.field_70177_z = ((float)data.readDouble());
/* 682 */     this.field_70127_C = ((float)data.readDouble());
/* 683 */     this.field_70126_B = ((float)data.readDouble());
/*     */   }
/*     */   
/*     */   public BoltType getBolt() {
/* 687 */     return BoltType.getBolt(getType());
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/EntityBoltMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */