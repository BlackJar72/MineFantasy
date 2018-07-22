/*     */ package minefantasy.entity;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import java.io.PrintStream;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.api.weapon.EntityDamageSourceRanged;
/*     */ import minefantasy.item.ArrowType;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.item.ToolMaterialMedieval;
/*     */ import minefantasy.system.AchivementMF;
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
/*     */ import net.minecraft.item.EnumToolMaterial;
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
/*     */ public class EntityArrowMF extends EntityArrow implements IProjectile, PacketUserMF
/*     */ {
/*     */   private ArrowType type;
/*  49 */   private int xTile = -1;
/*  50 */   private int yTile = -1;
/*  51 */   private int zTile = -1;
/*  52 */   private int inTile = 0;
/*  53 */   private int inData = 0;
/*  54 */   private boolean hasHit = false;
/*  55 */   private boolean inGround = false;
/*     */   
/*     */   private float powerEnchant;
/*     */   
/*  59 */   public int field_70251_a = 0;
/*     */   
/*     */ 
/*  62 */   public int field_70249_b = 0;
/*     */   
/*     */   public Entity field_70250_c;
/*     */   
/*     */   private int ticksInGround;
/*  67 */   private int ticksInAir = 0;
/*     */   
/*     */   private int knockbackStrength;
/*     */   
/*  71 */   private int kills = 0;
/*     */   
/*     */   public EntityArrowMF(World world) {
/*  74 */     super(world);
/*  75 */     if (this.field_70146_Z.nextInt(10) == 0) {
/*  76 */       setCritical(true);
/*     */     }
/*  78 */     this.field_70155_l = 10.0D;
/*  79 */     func_70105_a(0.5F, 0.5F);
/*     */   }
/*     */   
/*     */   public EntityArrowMF(World world, double x, double y, double z, int id) {
/*  83 */     this(world);
/*  84 */     setType(id);
/*  85 */     func_70107_b(x, y, z);
/*  86 */     this.field_70129_M = 0.0F;
/*     */   }
/*     */   
/*     */   public EntityArrowMF(World world, EntityLivingBase shooter, float power) {
/*  90 */     this(world, shooter, 1.0F, power, 0);
/*     */   }
/*     */   
/*     */   public EntityArrowMF(World world, EntityLivingBase shooter, float accur, float power, int id) {
/*  94 */     this(world);
/*  95 */     setType(id);
/*  96 */     this.field_70250_c = shooter;
/*     */     
/*  98 */     if ((shooter instanceof EntityPlayer)) {
/*  99 */       this.field_70251_a = (((EntityPlayer)shooter).field_71075_bZ.field_75098_d ? 2 : 1);
/*     */     }
/* 101 */     func_70012_b(shooter.field_70165_t, shooter.field_70163_u + shooter.func_70047_e(), shooter.field_70161_v, shooter.field_70177_z, shooter.field_70125_A);
/* 102 */     this.field_70165_t -= MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F;
/* 103 */     this.field_70163_u -= 0.10000000149011612D;
/* 104 */     this.field_70161_v -= MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F;
/* 105 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 106 */     this.field_70129_M = 0.0F;
/* 107 */     this.field_70159_w = (-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F));
/* 108 */     this.field_70179_y = (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F));
/* 109 */     this.field_70181_x = (-MathHelper.func_76126_a(this.field_70125_A / 180.0F * 3.1415927F));
/* 110 */     func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, power * 1.5F, accur);
/*     */   }
/*     */   
/*     */   public EntityArrowMF(World world, EntityLivingBase shooter, EntityLivingBase target, float power, float precision, int id) {
/* 114 */     this(world);
/*     */     
/* 116 */     this.field_70250_c = shooter;
/* 117 */     this.field_70251_a = ((shooter instanceof EntityPlayer) ? 1 : 0);
/* 118 */     setType(id);
/*     */     
/* 120 */     this.field_70163_u = (shooter.field_70163_u + shooter.func_70047_e() - 0.10000000149011612D);
/* 121 */     double var6 = target.field_70165_t - shooter.field_70165_t;
/* 122 */     double var8 = target.field_70163_u + target.func_70047_e() - 3.499999888241293D * getArc() - this.field_70163_u;
/* 123 */     double var10 = target.field_70161_v - shooter.field_70161_v;
/*     */     
/* 125 */     double range = shooter.func_70032_d(target);
/*     */     
/* 127 */     var8 = calculateRange(var8, range, power);
/* 128 */     if (target.field_70163_u > shooter.field_70163_u) {
/* 129 */       double dist = target.field_70163_u - shooter.field_70163_u;
/* 130 */       var8 += dist / 10.0D;
/*     */     }
/*     */     
/* 133 */     double var12 = MathHelper.func_76133_a(var6 * var6 + var10 * var10);
/*     */     
/* 135 */     if (var12 >= 1.0E-7D) {
/* 136 */       float var14 = (float)(Math.atan2(var10, var6) * 180.0D / 3.141592653589793D) - 90.0F;
/* 137 */       float var15 = (float)-(Math.atan2(var8, var12) * 180.0D / 3.141592653589793D);
/* 138 */       double var16 = var6 / var12;
/* 139 */       double var18 = var10 / var12;
/* 140 */       func_70012_b(shooter.field_70165_t + var16, this.field_70163_u, shooter.field_70161_v + var18, var14, var15);
/* 141 */       this.field_70129_M = 0.0F;
/* 142 */       float var20 = (float)var12 * getArc();
/* 143 */       func_70186_c(var6, var8 + var20, var10, power, precision);
/*     */     }
/*     */   }
/*     */   
/*     */   private double calculateRange(double yPos, double range, double power) {
/* 148 */     double yOffset = 0.041666666666666664D * range;
/* 149 */     if (range > 28.0D) {
/* 150 */       yOffset *= range / 16.0D;
/*     */     }
/* 152 */     if (range > 48.0D) {
/* 153 */       yOffset += 0.02D * range;
/*     */     }
/*     */     
/* 156 */     if (yOffset > 0.0D) {
/* 157 */       yPos += yOffset / 24.0D * range;
/*     */     }
/*     */     
/* 160 */     return yPos;
/*     */   }
/*     */   
/*     */   public EntityArrowMF(World world, EntityLivingBase shooter, float power, int type) {
/* 164 */     this(world);
/* 165 */     setType(type);
/* 166 */     this.field_70250_c = shooter;
/*     */     
/* 168 */     if ((shooter instanceof EntityPlayer)) {
/* 169 */       this.field_70251_a = 1;
/*     */     }
/*     */     
/* 172 */     func_70012_b(shooter.field_70165_t, shooter.field_70163_u + shooter.func_70047_e(), shooter.field_70161_v, shooter.field_70177_z, shooter.field_70125_A);
/* 173 */     this.field_70165_t -= MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F;
/* 174 */     this.field_70163_u -= 0.10000000149011612D;
/* 175 */     this.field_70161_v -= MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F;
/* 176 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 177 */     this.field_70129_M = 0.0F;
/* 178 */     this.field_70159_w = (-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F));
/* 179 */     this.field_70179_y = (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F));
/* 180 */     this.field_70181_x = (-MathHelper.func_76126_a(this.field_70125_A / 180.0F * 3.1415927F));
/* 181 */     func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, power * 1.5F, 1.0F);
/*     */   }
/*     */   
/*     */   protected void func_70088_a() {
/* 185 */     this.field_70180_af.func_75682_a(16, Byte.valueOf((byte)0));
/* 186 */     this.field_70180_af.func_75682_a(17, Integer.valueOf(0));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70016_h(double xv, double yv, double zv)
/*     */   {
/* 193 */     this.field_70159_w = xv;
/* 194 */     this.field_70181_x = yv;
/* 195 */     this.field_70179_y = zv;
/*     */     
/* 197 */     if ((this.field_70127_C == 0.0F) && (this.field_70126_B == 0.0F)) {
/* 198 */       float f = MathHelper.func_76133_a(xv * xv + zv * zv);
/* 199 */       this.field_70126_B = (this.field_70177_z = (float)(Math.atan2(xv, zv) * 180.0D / 3.141592653589793D));
/* 200 */       this.field_70127_C = (this.field_70125_A = (float)(Math.atan2(yv, f) * 180.0D / 3.141592653589793D));
/* 201 */       this.field_70127_C = this.field_70125_A;
/* 202 */       this.field_70126_B = this.field_70177_z;
/* 203 */       func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
/* 204 */       this.ticksInGround = 0;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70071_h_()
/*     */   {
/* 212 */     if ((this.field_70170_p.field_72995_K) && 
/* 213 */       (this.type == null)) {
/* 214 */       this.type = ArrowType.getArrow(getType());
/*     */     }
/*     */     
/* 217 */     super.func_70030_z();
/*     */     
/* 219 */     if ((this.inGround) && (isReed())) {
/* 220 */       this.field_70170_p.func_72956_a(this, "dig.grass", 1.0F, 1.0F);
/* 221 */       func_70106_y();
/*     */     }
/*     */     
/* 224 */     if ((this.field_70127_C == 0.0F) && (this.field_70126_B == 0.0F)) {
/* 225 */       float f = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 226 */       this.field_70126_B = (this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / 3.141592653589793D));
/* 227 */       this.field_70127_C = (this.field_70125_A = (float)(Math.atan2(this.field_70181_x, f) * 180.0D / 3.141592653589793D));
/*     */     }
/*     */     
/* 230 */     int i = this.field_70170_p.func_72798_a(this.xTile, this.yTile, this.zTile);
/*     */     
/* 232 */     if (i > 0) {
/* 233 */       Block.field_71973_m[i].func_71902_a(this.field_70170_p, this.xTile, this.yTile, this.zTile);
/* 234 */       AxisAlignedBB axisalignedbb = Block.field_71973_m[i].func_71872_e(this.field_70170_p, this.xTile, this.yTile, this.zTile);
/*     */       
/* 236 */       if ((axisalignedbb != null) && (axisalignedbb.func_72318_a(this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t, this.field_70163_u, this.field_70161_v)))) {
/* 237 */         this.inGround = true;
/*     */       }
/*     */     }
/*     */     
/* 241 */     if (this.field_70249_b > 0) {
/* 242 */       this.field_70249_b -= 1;
/*     */     }
/*     */     
/* 245 */     if (this.inGround) {
/* 246 */       int j = this.field_70170_p.func_72798_a(this.xTile, this.yTile, this.zTile);
/* 247 */       int k = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
/*     */       
/* 249 */       if ((j == this.inTile) && (k == this.inData)) {
/* 250 */         this.ticksInGround += 1;
/*     */         
/* 252 */         if (this.ticksInGround == 1200) {
/* 253 */           func_70106_y();
/*     */         }
/*     */       } else {
/* 256 */         this.inGround = false;
/* 257 */         this.field_70159_w *= this.field_70146_Z.nextFloat() * 0.2F;
/* 258 */         this.field_70181_x *= this.field_70146_Z.nextFloat() * 0.2F;
/* 259 */         this.field_70179_y *= this.field_70146_Z.nextFloat() * 0.2F;
/* 260 */         this.ticksInGround = 0;
/* 261 */         this.ticksInAir = 0;
/*     */       }
/*     */     } else {
/* 264 */       this.ticksInAir += 1;
/* 265 */       Vec3 vec3 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 266 */       Vec3 vec31 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 267 */       MovingObjectPosition movingobjectposition = this.field_70170_p.func_72831_a(vec3, vec31, false, true);
/* 268 */       vec3 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 269 */       vec31 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/*     */       
/* 271 */       if (movingobjectposition != null) {
/* 272 */         vec31 = this.field_70170_p.func_82732_R().func_72345_a(movingobjectposition.field_72307_f.field_72450_a, movingobjectposition.field_72307_f.field_72448_b, movingobjectposition.field_72307_f.field_72449_c);
/*     */       }
/*     */       
/* 275 */       Entity entity = null;
/* 276 */       List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0D, 1.0D, 1.0D));
/* 277 */       double d0 = 0.0D;
/*     */       
/*     */ 
/*     */ 
/* 281 */       for (int l = 0; l < list.size(); l++) {
/* 282 */         Entity entity1 = (Entity)list.get(l);
/*     */         
/* 284 */         if ((entity1.func_70067_L()) && ((entity1 != this.field_70250_c) || (this.ticksInAir >= 5))) {
/* 285 */           float f1 = 0.3F;
/* 286 */           AxisAlignedBB axisalignedbb1 = entity1.field_70121_D.func_72314_b(f1, f1, f1);
/* 287 */           MovingObjectPosition movingobjectposition1 = axisalignedbb1.func_72327_a(vec3, vec31);
/*     */           
/* 289 */           if (movingobjectposition1 != null) {
/* 290 */             double d1 = vec3.func_72438_d(movingobjectposition1.field_72307_f);
/*     */             
/* 292 */             if ((d1 < d0) || (d0 == 0.0D)) {
/* 293 */               entity = entity1;
/* 294 */               d0 = d1;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 300 */       if (entity != null) {
/* 301 */         movingobjectposition = new MovingObjectPosition(entity);
/*     */       }
/*     */       
/* 304 */       if ((movingobjectposition != null) && (movingobjectposition.field_72308_g != null) && ((movingobjectposition.field_72308_g instanceof EntityPlayer))) {
/* 305 */         EntityPlayer entityplayer = (EntityPlayer)movingobjectposition.field_72308_g;
/*     */         
/* 307 */         if ((entityplayer.field_71075_bZ.field_75102_a) || (((this.field_70250_c instanceof EntityPlayer)) && (!((EntityPlayer)this.field_70250_c).func_96122_a(entityplayer)))) {
/* 308 */           movingobjectposition = null;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 315 */       if (movingobjectposition != null) {
/* 316 */         if ((movingobjectposition.field_72308_g != null) && (!this.hasHit)) {
/* 317 */           float f2 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
/* 318 */           float dam = (float)(f2 * func_70242_d());
/*     */           
/* 320 */           if (func_70241_g()) {
/* 321 */             dam += this.field_70146_Z.nextFloat() * (dam / 2.0F);
/*     */           }
/*     */           
/* 324 */           DamageSource damagesource = null;
/* 325 */           DamageSource damagesource2 = null;
/*     */           
/* 327 */           if (this.field_70250_c == null) {
/* 328 */             damagesource = DamageSource.func_76353_a(this, this);
/* 329 */             damagesource2 = new EntityDamageSourceRanged(this, this, true);
/*     */           } else {
/* 331 */             damagesource = DamageSource.func_76353_a(this, this.field_70250_c);
/* 332 */             damagesource2 = new EntityDamageSourceRanged(this, this.field_70250_c, true);
/*     */           }
/*     */           
/* 335 */           if ((func_70027_ad()) && (!(movingobjectposition.field_72308_g instanceof EntityEnderman))) {
/* 336 */             movingobjectposition.field_72308_g.func_70015_d(5);
/*     */           }
/*     */           
/* 339 */           dam = applyBonus(movingobjectposition.field_72308_g, dam);
/*     */           
/* 341 */           float penetrate = getArmourPenetration();
/* 342 */           int APdamage = (int)(dam * penetrate);
/* 343 */           dam -= APdamage;
/*     */           
/* 345 */           if (movingobjectposition.field_72308_g.func_70097_a(damagesource, dam)) {
/* 346 */             movingobjectposition.field_72308_g.field_70172_ad = 0;
/* 347 */             if ((!movingobjectposition.field_72308_g.func_70097_a(damagesource2, APdamage)) || 
/*     */             
/* 349 */               ((movingobjectposition.field_72308_g instanceof EntityLivingBase))) {
/* 350 */               EntityLivingBase entityliving = (EntityLivingBase)movingobjectposition.field_72308_g;
/*     */               
/* 352 */               if (!this.field_70170_p.field_72995_K) {
/* 353 */                 entityliving.func_85034_r(entityliving.func_85035_bI() + 1);
/*     */               }
/*     */               
/* 356 */               if (this.knockbackStrength > 0) {
/* 357 */                 float f3 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/*     */                 
/* 359 */                 if (f3 > 0.0F) {
/* 360 */                   movingobjectposition.field_72308_g.func_70024_g(this.field_70159_w * this.knockbackStrength * 0.6000000238418579D / f3, 0.1D, this.field_70179_y * this.knockbackStrength * 0.6000000238418579D / f3);
/*     */                 }
/*     */               }
/*     */               
/* 364 */               if (this.field_70250_c != null) {
/* 365 */                 EnchantmentThorns.func_92096_a(this.field_70250_c, entityliving, this.field_70146_Z);
/*     */               }
/*     */               
/* 368 */               if ((this.field_70250_c != null) && (movingobjectposition.field_72308_g != this.field_70250_c) && ((movingobjectposition.field_72308_g instanceof EntityPlayer)) && ((this.field_70250_c instanceof EntityPlayerMP))) {
/* 369 */                 ((EntityPlayerMP)this.field_70250_c).field_71135_a.func_72567_b(new Packet70GameEvent(6, 0));
/*     */               }
/*     */             }
/*     */             
/* 373 */             func_85030_a("random.bowhit", 1.0F, 1.2F / (this.field_70146_Z.nextFloat() * 0.2F + 0.9F));
/*     */             
/* 375 */             boolean leathalHit = false;
/* 376 */             if (((movingobjectposition.field_72308_g instanceof EntityLivingBase)) && 
/* 377 */               (((EntityLivingBase)movingobjectposition.field_72308_g).func_110143_aJ() <= 0.0F)) {
/* 378 */               leathalHit = true;
/*     */             }
/* 380 */             if ((!(movingobjectposition.field_72308_g instanceof EntityEnderman)) && ((!isBroad()) || (!leathalHit))) {
/* 381 */               tryBreak(movingobjectposition.field_72308_g);
/*     */             }
/* 383 */             else if (isBroad()) {
/* 384 */               if (!this.field_70128_L) {}
/*     */               
/* 386 */               this.kills += 1;
/* 387 */               if ((this.kills >= 3) && 
/* 388 */                 (this.field_70250_c != null) && ((this.field_70250_c instanceof EntityPlayer))) {
/* 389 */                 ((EntityPlayer)this.field_70250_c).func_71064_a(AchivementMF.AchievementTripleKill, 1);
/*     */               }
/*     */               
/*     */             }
/*     */           }
/* 394 */           else if (!isBroad()) {
/* 395 */             this.field_70159_w *= -0.10000000149011612D;
/* 396 */             this.field_70181_x *= -0.10000000149011612D;
/* 397 */             this.field_70179_y *= -0.10000000149011612D;
/* 398 */             this.field_70177_z += 180.0F;
/* 399 */             this.field_70126_B += 180.0F;
/* 400 */             this.ticksInAir = 0;
/*     */           }
/*     */         } else {
/* 403 */           this.xTile = movingobjectposition.field_72311_b;
/* 404 */           this.yTile = movingobjectposition.field_72312_c;
/* 405 */           this.zTile = movingobjectposition.field_72309_d;
/* 406 */           this.inTile = this.field_70170_p.func_72798_a(this.xTile, this.yTile, this.zTile);
/* 407 */           this.inData = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
/* 408 */           this.field_70159_w = ((float)(movingobjectposition.field_72307_f.field_72450_a - this.field_70165_t));
/* 409 */           this.field_70181_x = ((float)(movingobjectposition.field_72307_f.field_72448_b - this.field_70163_u));
/* 410 */           this.field_70179_y = ((float)(movingobjectposition.field_72307_f.field_72449_c - this.field_70161_v));
/* 411 */           float f2 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
/* 412 */           this.field_70165_t -= this.field_70159_w / f2 * 0.05000000074505806D;
/* 413 */           this.field_70163_u -= this.field_70181_x / f2 * 0.05000000074505806D;
/* 414 */           this.field_70161_v -= this.field_70179_y / f2 * 0.05000000074505806D;
/* 415 */           func_85030_a("random.bowhit", 1.0F, 1.2F / (this.field_70146_Z.nextFloat() * 0.2F + 0.9F));
/* 416 */           this.inGround = true;
/* 417 */           this.field_70249_b = 7;
/* 418 */           setCritical(false);
/*     */           
/* 420 */           if (this.inTile != 0) {
/* 421 */             Block.field_71973_m[this.inTile].func_71869_a(this.field_70170_p, this.xTile, this.yTile, this.zTile, this);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 426 */       if (func_70241_g()) {
/* 427 */         for (l = 0; l < 4; l++) {
/* 428 */           this.field_70170_p.func_72869_a("crit", this.field_70165_t + this.field_70159_w * l / 4.0D, this.field_70163_u + this.field_70181_x * l / 4.0D, this.field_70161_v + this.field_70179_y * l / 4.0D, -this.field_70159_w, -this.field_70181_x + 0.2D, -this.field_70179_y);
/*     */         }
/*     */       }
/*     */       
/* 432 */       this.field_70165_t += this.field_70159_w;
/* 433 */       this.field_70163_u += this.field_70181_x;
/* 434 */       this.field_70161_v += this.field_70179_y;
/* 435 */       float f2 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 436 */       this.field_70177_z = ((float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / 3.141592653589793D));
/*     */       
/* 438 */       for (this.field_70125_A = ((float)(Math.atan2(this.field_70181_x, f2) * 180.0D / 3.141592653589793D)); this.field_70125_A - this.field_70127_C < -180.0F; this.field_70127_C -= 360.0F) {}
/*     */       
/*     */ 
/*     */ 
/* 442 */       while (this.field_70125_A - this.field_70127_C >= 180.0F) {
/* 443 */         this.field_70127_C += 360.0F;
/*     */       }
/*     */       
/* 446 */       while (this.field_70177_z - this.field_70126_B < -180.0F) {
/* 447 */         this.field_70126_B -= 360.0F;
/*     */       }
/*     */       
/* 450 */       while (this.field_70177_z - this.field_70126_B >= 180.0F) {
/* 451 */         this.field_70126_B += 360.0F;
/*     */       }
/*     */       
/* 454 */       this.field_70125_A = (this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2F);
/* 455 */       this.field_70177_z = (this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2F);
/* 456 */       float f4 = 0.99F;
/* 457 */       float f1 = getGravity();
/*     */       
/* 459 */       if (func_70090_H()) {
/* 460 */         for (int j1 = 0; j1 < 4; j1++) {
/* 461 */           float f3 = 0.25F;
/* 462 */           this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * f3, this.field_70163_u - this.field_70181_x * f3, this.field_70161_v - this.field_70179_y * f3, this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */         }
/*     */         
/* 465 */         f4 = 0.8F;
/*     */       }
/*     */       
/* 468 */       this.field_70159_w *= f4;
/* 469 */       this.field_70181_x *= f4;
/* 470 */       this.field_70179_y *= f4;
/* 471 */       this.field_70181_x -= f1;
/* 472 */       func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 473 */       func_70017_D();
/*     */     }
/* 475 */     if ((this.field_70173_aa <= 10) && (!this.field_70170_p.field_72995_K)) {
/* 476 */       sendTrackerPacket();
/*     */     }
/*     */   }
/*     */   
/*     */   private void tryBreak(Entity hit) {
/* 481 */     this.hasHit = true;
/* 482 */     if (getArrow() != null) {
/* 483 */       int c = getArrow().getBreakChance();
/* 484 */       int chance = -1;
/* 485 */       if (c != -1) {
/* 486 */         if (c <= 0)
/* 487 */           c = 1;
/* 488 */         chance = this.field_70146_Z.nextInt(c);
/*     */       }
/*     */       
/* 491 */       if ((MineFantasyBase.isDebug()) && (!this.field_70170_p.field_72995_K)) {
/* 492 */         System.out.println("Arrow Break Chance: 1 in " + getArrow().getBreakChance() + ". hit has rolled a " + chance);
/*     */       }
/* 494 */       if ((!cfg.durableArrows) || (chance == 0)) {
/* 495 */         if (!this.field_70170_p.field_72995_K) {
/* 496 */           if (isReed()) {
/* 497 */             func_85030_a("dig.grass", 1.0F, 1.0F);
/*     */           } else
/* 499 */             func_85030_a("random.break", 1.0F, 1.0F);
/* 500 */           func_70106_y();
/*     */         }
/*     */       } else {
/* 503 */         if ((hit != null) && (this.field_70251_a == 1)) {
/* 504 */           hit.func_70099_a(getDroppedItem(), 0.0F);
/*     */         }
/* 506 */         func_70106_y();
/*     */       }
/*     */     }
/* 509 */     else if (!this.field_70170_p.field_72995_K) {
/* 510 */       func_70106_y();
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean isBroad()
/*     */   {
/* 516 */     if (this.type != null) {
/* 517 */       return this.type.arrowType == 2;
/*     */     }
/* 519 */     return false;
/*     */   }
/*     */   
/*     */   private float applyBonus(Entity entityHit, float dam) {
/* 523 */     EntityLivingBase living = null;
/* 524 */     if ((entityHit instanceof EntityLivingBase)) {
/* 525 */       living = (EntityLivingBase)entityHit;
/*     */     }
/*     */     
/* 528 */     if (this.type != null) {
/* 529 */       if (this.type.material == ToolMaterialMedieval.DRAGONFORGE) {
/* 530 */         entityHit.func_70015_d(10);
/*     */       }
/* 532 */       if ((this.type.material == ToolMaterialMedieval.IGNOTUMITE) && 
/* 533 */         (this.field_70250_c != null) && ((this.field_70250_c instanceof EntityLivingBase))) {
/* 534 */         ((EntityLivingBase)this.field_70250_c).func_70691_i(dam / 4.0F);
/*     */       }
/*     */       
/* 537 */       if ((this.type.material == ToolMaterialMedieval.ORNATE) && (
/* 538 */         ((living != null) && (living.func_70668_bt() == EnumCreatureAttribute.UNDEAD)) || (entityHit.getClass().getName().endsWith("MoCEntityWerewolf")))) {
/* 539 */         living.func_70015_d(10);
/* 540 */         if (living.getClass().getName().endsWith("MoCEntityWarewolf")) {
/* 541 */           dam *= 10.0F;
/*     */         } else {
/* 543 */           dam *= 3.0F;
/*     */         }
/* 545 */         living.field_70170_p.func_72956_a(living, "random.fizz", 1.0F, 1.0F);
/*     */       }
/*     */     }
/*     */     
/* 549 */     dam += this.powerEnchant;
/* 550 */     return dam;
/*     */   }
/*     */   
/*     */   public void func_70239_b(double dam)
/*     */   {
/* 555 */     float bonus = (float)(dam - func_70242_d());
/*     */     
/* 557 */     this.powerEnchant = bonus;
/*     */   }
/*     */   
/*     */   private float getArmourPenetration() {
/* 561 */     if (this.type != null) {
/* 562 */       if (this.type.arrowType == 1)
/* 563 */         return 0.3F;
/* 564 */       if (this.type.arrowType == 2)
/* 565 */         return 0.5F;
/*     */     }
/* 567 */     return 0.0F;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70014_b(NBTTagCompound nbt)
/*     */   {
/* 574 */     super.func_70014_b(nbt);
/* 575 */     nbt.func_74757_a("HasHit", this.hasHit);
/* 576 */     nbt.func_74768_a("Kills", this.kills);
/* 577 */     nbt.func_74768_a("type", getType());
/* 578 */     nbt.func_74777_a("xTile", (short)this.xTile);
/* 579 */     nbt.func_74777_a("yTile", (short)this.yTile);
/* 580 */     nbt.func_74777_a("zTile", (short)this.zTile);
/* 581 */     nbt.func_74774_a("inTile", (byte)this.inTile);
/* 582 */     nbt.func_74774_a("inData", (byte)this.inData);
/* 583 */     nbt.func_74774_a("shake", (byte)this.field_70249_b);
/* 584 */     nbt.func_74774_a("inGround", (byte)(this.inGround ? 1 : 0));
/* 585 */     nbt.func_74774_a("pickup", (byte)this.field_70251_a);
/* 586 */     nbt.func_74776_a("Power", this.powerEnchant);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70037_a(NBTTagCompound nbt)
/*     */   {
/* 593 */     super.func_70037_a(nbt);
/* 594 */     if (nbt.func_74764_b("Kills")) {
/* 595 */       this.kills = nbt.func_74762_e("Kills");
/*     */     }
/* 597 */     if (nbt.func_74764_b("type")) {
/* 598 */       setType(nbt.func_74762_e("type"));
/*     */     }
/* 600 */     this.xTile = nbt.func_74765_d("xTile");
/* 601 */     this.yTile = nbt.func_74765_d("yTile");
/* 602 */     this.zTile = nbt.func_74765_d("zTile");
/* 603 */     this.inTile = (nbt.func_74771_c("inTile") & 0xFF);
/* 604 */     this.inData = (nbt.func_74771_c("inData") & 0xFF);
/* 605 */     this.field_70249_b = (nbt.func_74771_c("shake") & 0xFF);
/* 606 */     this.inGround = (nbt.func_74771_c("inGround") == 1);
/* 607 */     this.hasHit = nbt.func_74767_n("HasHit");
/*     */     
/* 609 */     if (nbt.func_74764_b("pickup")) {
/* 610 */       this.field_70251_a = nbt.func_74771_c("pickup");
/* 611 */     } else if (nbt.func_74764_b("player")) {
/* 612 */       this.field_70251_a = (nbt.func_74767_n("player") ? 1 : 0);
/*     */     }
/*     */     
/* 615 */     this.powerEnchant = nbt.func_74760_g("Power");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70100_b_(EntityPlayer player)
/*     */   {
/* 622 */     ItemStack drop = getDroppedItem();
/* 623 */     if ((drop != null) && (!this.field_70170_p.field_72995_K) && (this.inGround) && (this.field_70249_b <= 0)) {
/* 624 */       boolean flag = (this.field_70251_a == 1) || ((this.field_70251_a == 2) && (player.field_71075_bZ.field_75098_d));
/*     */       
/* 626 */       if ((this.field_70251_a == 1) && (!player.field_71071_by.func_70441_a(drop))) {
/* 627 */         flag = false;
/*     */       }
/*     */       
/* 630 */       if (flag) {
/* 631 */         func_85030_a("random.pop", 0.2F, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7F + 1.0F) * 2.0F);
/* 632 */         player.func_71001_a(this, 1);
/* 633 */         func_70106_y();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private float getGravity()
/*     */   {
/* 642 */     float gravity = 0.05F;
/* 643 */     if (this.type != null) {
/* 644 */       if (this.type.material == ToolMaterialMedieval.MITHRIL) {
/* 645 */         gravity *= 0.5F;
/* 646 */       } else if (this.type.material == EnumToolMaterial.WOOD) {
/* 647 */         gravity *= 0.75F;
/*     */       }
/*     */       
/* 650 */       if (this.type.arrowType == 1) {
/* 651 */         gravity *= 0.5F;
/* 652 */       } else if (this.type.arrowType == 2) {
/* 653 */         gravity *= 1.5F;
/*     */       }
/*     */     }
/*     */     
/* 657 */     return gravity;
/*     */   }
/*     */   
/*     */   public String getTexture() {
/* 661 */     if ((this.type == null) || (this.type.getTextureName() == null)) {
/* 662 */       return "arrowIron";
/*     */     }
/* 664 */     return this.type.getTextureName();
/*     */   }
/*     */   
/*     */   private float getArc() {
/* 668 */     switch (getType()) {
/*     */     case 1: 
/* 670 */       return 0.8F;
/*     */     case 2: 
/* 672 */       return 0.1F;
/*     */     case 3: 
/* 674 */       return 0.18F;
/*     */     case 4: 
/* 676 */       return 0.3F;
/*     */     case 5: 
/* 678 */       return 0.12F;
/*     */     case 6: 
/* 680 */       return 0.12F;
/*     */     }
/* 682 */     return 0.2F;
/*     */   }
/*     */   
/*     */   public double func_70242_d()
/*     */   {
/* 687 */     return ArrowType.getDamage(this.type);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70240_a(int str)
/*     */   {
/* 694 */     super.func_70240_a(str);
/* 695 */     this.knockbackStrength = str;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCritical(boolean flag)
/*     */   {
/* 703 */     super.func_70243_d(flag);
/* 704 */     byte b0 = this.field_70180_af.func_75683_a(16);
/*     */     
/* 706 */     if (flag) {
/* 707 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(b0 | 0x1)));
/*     */     } else {
/* 709 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(b0 & 0xFFFFFFFE)));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_70243_d(boolean flag) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean func_70241_g()
/*     */   {
/* 722 */     byte b0 = this.field_70180_af.func_75683_a(16);
/* 723 */     return (b0 & 0x1) != 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/* 732 */     return this.field_70180_af.func_75679_c(17);
/*     */   }
/*     */   
/*     */   public void setType(int type) {
/* 736 */     this.type = ArrowType.getArrow(type);
/* 737 */     this.field_70180_af.func_75692_b(17, Integer.valueOf(type));
/*     */   }
/*     */   
/*     */   public void setOwner(EntityLivingBase thrower) {
/* 741 */     this.field_70250_c = thrower;
/*     */   }
/*     */   
/*     */   public ItemStack getDroppedItem() {
/* 745 */     return new ItemStack(ItemListMF.arrowMF, 1, getType());
/*     */   }
/*     */   
/*     */   public void sendTrackerPacket() {
/*     */     try {
/* 750 */       Packet packet = PacketManagerMF.getEntityPacketDoubleArray(this, new double[] { this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70159_w, this.field_70181_x, this.field_70179_y, this.field_70125_A, this.field_70177_z, this.field_70127_C, this.field_70126_B });
/* 751 */       FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*     */     }
/*     */     catch (NullPointerException localNullPointerException) {}
/*     */   }
/*     */   
/*     */ 
/*     */   public void recievePacket(ByteArrayDataInput data)
/*     */   {
/* 759 */     this.field_70165_t = data.readDouble();
/* 760 */     this.field_70163_u = data.readDouble();
/* 761 */     this.field_70161_v = data.readDouble();
/*     */     
/* 763 */     this.field_70159_w = data.readDouble();
/* 764 */     this.field_70181_x = data.readDouble();
/* 765 */     this.field_70179_y = data.readDouble();
/*     */     
/* 767 */     this.field_70125_A = ((float)data.readDouble());
/* 768 */     this.field_70177_z = ((float)data.readDouble());
/* 769 */     this.field_70127_C = ((float)data.readDouble());
/* 770 */     this.field_70126_B = ((float)data.readDouble());
/*     */   }
/*     */   
/*     */   private int getArrowModel() {
/* 774 */     if (this.type != null) {
/* 775 */       return this.type.arrowType;
/*     */     }
/* 777 */     return 0;
/*     */   }
/*     */   
/*     */   private boolean isReed() {
/* 781 */     return (this.type != null) && (this.type.material == EnumToolMaterial.WOOD);
/*     */   }
/*     */   
/*     */   public ArrowType getArrow() {
/* 785 */     return ArrowType.getArrow(getType());
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/EntityArrowMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */