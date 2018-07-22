/*     */ package minefantasy.entity;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.PrintStream;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import minefantasy.system.MFResource;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.IProjectile;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EnumMovingObjectType;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.util.Vec3Pool;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public abstract class EntityThrowableBounce extends Entity implements IProjectile
/*     */ {
/*  26 */   private int xTile = -1;
/*  27 */   private int yTile = -1;
/*  28 */   public int ticksRemaining = getFuseTime();
/*  29 */   private int zTile = -1;
/*  30 */   private int inTile = 0;
/*  31 */   protected boolean inGround = false;
/*  32 */   public int throwableShake = 0;
/*     */   
/*     */ 
/*     */ 
/*     */   private EntityLivingBase thrower;
/*     */   
/*     */ 
/*  39 */   private String throwerName = null;
/*     */   private int ticksInGround;
/*  41 */   private int ticksInAir = 0;
/*     */   
/*     */   public EntityThrowableBounce(World par1World) {
/*  44 */     super(par1World);
/*  45 */     func_70105_a(0.25F, 0.25F);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void func_70088_a() {}
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_70112_a(double par1)
/*     */   {
/*  57 */     double var3 = this.field_70121_D.func_72320_b() * 4.0D;
/*  58 */     var3 *= 64.0D;
/*  59 */     return par1 < var3 * var3;
/*     */   }
/*     */   
/*     */   public EntityThrowableBounce(World par1World, EntityLivingBase par2EntityLivingBase) {
/*  63 */     super(par1World);
/*  64 */     this.thrower = par2EntityLivingBase;
/*  65 */     func_70105_a(0.25F, 0.25F);
/*  66 */     func_70012_b(par2EntityLivingBase.field_70165_t, par2EntityLivingBase.field_70163_u + par2EntityLivingBase.func_70047_e(), par2EntityLivingBase.field_70161_v, par2EntityLivingBase.field_70177_z, par2EntityLivingBase.field_70125_A);
/*  67 */     this.field_70165_t -= MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F;
/*  68 */     this.field_70163_u -= 0.10000000149011612D;
/*  69 */     this.field_70161_v -= MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F;
/*  70 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*  71 */     this.field_70129_M = 0.0F;
/*  72 */     float var3 = 0.4F;
/*  73 */     this.field_70159_w = (-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F) * var3);
/*  74 */     this.field_70179_y = (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F) * var3);
/*  75 */     this.field_70181_x = (-MathHelper.func_76126_a((this.field_70125_A + func_70183_g()) / 180.0F * 3.1415927F) * var3);
/*     */     
/*  77 */     func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, getThrownPower(), 1.0F);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private float getThrownPower()
/*     */   {
/*  86 */     return 1.5F;
/*     */   }
/*     */   
/*     */   public EntityThrowableBounce(World par1World, double par2, double par4, double par6) {
/*  90 */     super(par1World);
/*  91 */     this.ticksInGround = 0;
/*  92 */     func_70105_a(0.25F, 0.25F);
/*  93 */     func_70107_b(par2, par4, par6);
/*  94 */     this.field_70129_M = 0.0F;
/*     */   }
/*     */   
/*     */   protected float func_70183_g() {
/*  98 */     return 0.0F;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_70186_c(double par1, double par3, double par5, float par7, float par8)
/*     */   {
/* 106 */     float var9 = MathHelper.func_76133_a(par1 * par1 + par3 * par3 + par5 * par5);
/* 107 */     par1 /= var9;
/* 108 */     par3 /= var9;
/* 109 */     par5 /= var9;
/* 110 */     par1 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8;
/* 111 */     par3 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8;
/* 112 */     par5 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8;
/* 113 */     par1 *= par7;
/* 114 */     par3 *= par7;
/* 115 */     par5 *= par7;
/* 116 */     this.field_70159_w = par1;
/* 117 */     this.field_70181_x = par3;
/* 118 */     this.field_70179_y = par5;
/* 119 */     float var10 = MathHelper.func_76133_a(par1 * par1 + par5 * par5);
/* 120 */     this.field_70126_B = (this.field_70177_z = (float)(Math.atan2(par1, par5) * 180.0D / 3.141592653589793D));
/* 121 */     this.field_70127_C = (this.field_70125_A = (float)(Math.atan2(par3, var10) * 180.0D / 3.141592653589793D));
/* 122 */     this.ticksInGround = 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70016_h(double par1, double par3, double par5)
/*     */   {
/* 130 */     this.field_70159_w = par1;
/* 131 */     this.field_70181_x = par3;
/* 132 */     this.field_70179_y = par5;
/*     */     
/* 134 */     if ((this.field_70127_C == 0.0F) && (this.field_70126_B == 0.0F)) {
/* 135 */       float var7 = MathHelper.func_76133_a(par1 * par1 + par5 * par5);
/* 136 */       this.field_70126_B = (this.field_70177_z = (float)(Math.atan2(par1, par5) * 180.0D / 3.141592653589793D));
/* 137 */       this.field_70127_C = (this.field_70125_A = (float)(Math.atan2(par3, var7) * 180.0D / 3.141592653589793D));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70071_h_()
/*     */   {
/* 145 */     float drag = 0.95F;
/* 146 */     this.field_70159_w *= drag;
/* 147 */     this.field_70181_x *= drag;
/* 148 */     this.field_70179_y *= drag;
/* 149 */     this.field_70142_S = this.field_70165_t;
/* 150 */     this.field_70137_T = this.field_70163_u;
/* 151 */     this.field_70136_U = this.field_70161_v;
/* 152 */     super.func_70071_h_();
/*     */     
/* 154 */     if (this.throwableShake > 0) {
/* 155 */       this.throwableShake -= 1;
/*     */     }
/*     */     
/* 158 */     if ((this.field_70181_x < 0.01D) && (this.field_70181_x > -0.01D) && (this.field_70122_E)) {
/* 159 */       float drag2 = 0.8F;
/* 160 */       this.field_70159_w *= drag2;
/* 161 */       this.field_70181_x *= drag2;
/* 162 */       this.field_70179_y *= drag2;
/*     */     }
/*     */     
/* 165 */     if (this.inGround) {
/* 166 */       int var1 = this.field_70170_p.func_72798_a(this.xTile, this.yTile, this.zTile);
/*     */       
/* 168 */       if (var1 == this.inTile) {
/* 169 */         this.ticksInGround += 1;
/*     */         
/* 171 */         if (this.ticksInGround == 1200) {
/* 172 */           func_70106_y();
/*     */         }
/*     */         
/* 175 */         return;
/*     */       }
/*     */       
/* 178 */       this.inGround = false;
/* 179 */       this.field_70159_w *= this.field_70146_Z.nextFloat() * 0.2F;
/* 180 */       this.field_70181_x *= this.field_70146_Z.nextFloat() * 0.2F;
/* 181 */       this.field_70179_y *= this.field_70146_Z.nextFloat() * 0.2F;
/* 182 */       this.ticksInGround = 0;
/* 183 */       this.ticksInAir = 0;
/*     */     } else {
/* 185 */       this.ticksInAir += 1;
/*     */     }
/*     */     
/* 188 */     Vec3 var16 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 189 */     Vec3 var2 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 190 */     MovingObjectPosition var3 = this.field_70170_p.func_72933_a(var16, var2);
/* 191 */     var16 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 192 */     var2 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/*     */     
/* 194 */     if (var3 != null) {
/* 195 */       var2 = this.field_70170_p.func_82732_R().func_72345_a(var3.field_72307_f.field_72450_a, var3.field_72307_f.field_72448_b, var3.field_72307_f.field_72449_c);
/*     */     }
/*     */     
/* 198 */     if (!this.field_70170_p.field_72995_K) {
/* 199 */       Entity var4 = null;
/* 200 */       List var5 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0D, 1.0D, 1.0D));
/* 201 */       double var6 = 0.0D;
/* 202 */       EntityLivingBase var8 = getThrower();
/*     */       
/* 204 */       for (int var9 = 0; var9 < var5.size(); var9++) {
/* 205 */         Entity var10 = (Entity)var5.get(var9);
/*     */         
/* 207 */         if ((var10.func_70067_L()) && ((var10 != var8) || (this.ticksInAir >= 5))) {
/* 208 */           float var11 = 0.3F;
/* 209 */           AxisAlignedBB var12 = var10.field_70121_D.func_72314_b(var11, var11, var11);
/* 210 */           MovingObjectPosition var13 = var12.func_72327_a(var16, var2);
/*     */           
/* 212 */           if (var13 != null) {
/* 213 */             double var14 = var16.func_72438_d(var13.field_72307_f);
/*     */             
/* 215 */             if ((var14 < var6) || (var6 == 0.0D)) {
/* 216 */               var4 = var10;
/* 217 */               var6 = var14;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 223 */       if (var4 != null) {
/* 224 */         var3 = new MovingObjectPosition(var4);
/*     */       }
/*     */     }
/*     */     
/* 228 */     if (var3 != null) {
/* 229 */       boolean bounce = true;
/* 230 */       if (var3.field_72313_a == EnumMovingObjectType.TILE) {
/* 231 */         int id = this.field_70170_p.func_72798_a(var3.field_72311_b, var3.field_72312_c, var3.field_72309_d);
/* 232 */         if (id != 0) {
/* 233 */           Block block = Block.field_71973_m[id];
/* 234 */           if (block != null) {
/* 235 */             if (!block.field_72018_cp.func_76220_a()) {
/* 236 */               if (minefantasy.MineFantasyBase.isDebug()) {
/* 237 */                 System.out.println("NonSolid: " + block.field_72018_cp.toString());
/*     */               }
/* 239 */               bounce = false;
/*     */             }
/*     */             
/* 242 */             if (shouldBreakBlock(block)) {
/* 243 */               this.field_70170_p.func_94571_i(var3.field_72311_b, var3.field_72312_c, var3.field_72309_d);
/* 244 */               String snd = "dig." + block.field_72020_cn;
/* 245 */               if (block.field_72018_cp == Material.field_76264_q) {
/* 246 */                 snd = "random.glass";
/*     */               }
/* 248 */               func_85030_a(snd, 1.0F, 1.0F);
/* 249 */               bounce = false;
/* 250 */               this.field_70170_p.func_72869_a("tilecrack_" + id + "_" + this.field_70170_p.func_72805_g(var3.field_72311_b, var3.field_72312_c, var3.field_72309_d), var3.field_72311_b + 0.5D, var3.field_72312_c + 0.5D, var3.field_72309_d + 0.5D, 0.0D, 0.0D, 0.0D);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 256 */       if ((var3.field_72313_a == EnumMovingObjectType.TILE) && (this.field_70170_p.func_72798_a(var3.field_72311_b, var3.field_72312_c, var3.field_72309_d) == Block.field_72015_be.field_71990_ca)) {
/* 257 */         func_70063_aa();
/* 258 */       } else if (bounce) {
/* 259 */         bounce(var3);
/*     */       }
/*     */     }
/*     */     
/* 263 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 264 */     float var17 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 265 */     this.field_70177_z = ((float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / 3.141592653589793D));
/*     */     
/* 267 */     for (this.field_70125_A = ((float)(Math.atan2(this.field_70181_x, var17) * 180.0D / 3.141592653589793D)); this.field_70125_A - this.field_70127_C < -180.0F; this.field_70127_C -= 360.0F) {}
/*     */     
/*     */ 
/*     */ 
/* 271 */     while (this.field_70125_A - this.field_70127_C >= 180.0F) {
/* 272 */       this.field_70127_C += 360.0F;
/*     */     }
/*     */     
/* 275 */     while (this.field_70177_z - this.field_70126_B < -180.0F) {
/* 276 */       this.field_70126_B -= 360.0F;
/*     */     }
/*     */     
/* 279 */     while (this.field_70177_z - this.field_70126_B >= 180.0F) {
/* 280 */       this.field_70126_B += 360.0F;
/*     */     }
/*     */     
/* 283 */     this.field_70125_A = (this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2F);
/* 284 */     this.field_70177_z = (this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2F);
/* 285 */     float var18 = 0.99F;
/* 286 */     float var19 = getGravityVelocity();
/*     */     
/* 288 */     if (func_70090_H()) {
/* 289 */       for (int var7 = 0; var7 < 4; var7++) {
/* 290 */         float var20 = 0.25F;
/* 291 */         this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * var20, this.field_70163_u - this.field_70181_x * var20, this.field_70161_v - this.field_70179_y * var20, this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */       }
/*     */       
/* 294 */       var18 = 0.8F;
/*     */     }
/*     */     
/* 297 */     this.field_70159_w *= var18;
/* 298 */     this.field_70181_x *= var18;
/* 299 */     this.field_70179_y *= var18;
/* 300 */     this.field_70181_x -= var19;
/* 301 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected float getGravityVelocity()
/*     */   {
/* 308 */     return 0.5F;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void bounce(MovingObjectPosition var1)
/*     */   {
/* 315 */     float resistance = getResistance();
/* 316 */     if (resistance > 0.2F)
/* 317 */       this.field_70170_p.func_72956_a(this, MFResource.sound("Weapon.bombBounce"), resistance + 0.2F, 0.75F);
/* 318 */     if ((var1.field_72310_e == 0) && (this.field_70181_x > 0.0D))
/*     */     {
/* 320 */       this.field_70181_x *= -resistance;
/* 321 */       if ((this.field_70181_x < 0.01D) && (this.field_70181_x > -0.01D) && (this.field_70122_E)) {
/* 322 */         this.field_70159_w = (this.field_70181_x = this.field_70179_y = 0.0D);
/*     */       }
/*     */     }
/* 325 */     if ((var1.field_72310_e == 1) && (this.field_70181_x < 0.0D))
/*     */     {
/* 327 */       this.field_70181_x *= -resistance;
/* 328 */       if ((this.field_70181_x < 0.01D) && (this.field_70181_x > -0.01D) && (this.field_70122_E)) {
/* 329 */         this.field_70159_w = (this.field_70181_x = this.field_70179_y = 0.0D);
/*     */       }
/*     */     }
/*     */     
/* 333 */     if ((var1.field_72310_e == 2) && (this.field_70179_y > 0.0D))
/*     */     {
/* 335 */       this.field_70179_y *= -resistance;
/*     */     }
/* 337 */     if ((var1.field_72310_e == 3) && (this.field_70179_y < 0.0D))
/*     */     {
/* 339 */       this.field_70179_y *= -resistance;
/*     */     }
/*     */     
/* 342 */     if ((var1.field_72310_e == 4) && (this.field_70159_w > 0.0D))
/*     */     {
/* 344 */       this.field_70159_w *= -resistance;
/*     */     }
/* 346 */     if ((var1.field_72310_e == 5) && (this.field_70159_w < 0.0D))
/*     */     {
/* 348 */       this.field_70159_w *= -resistance;
/*     */     }
/* 350 */     if (var1.field_72308_g != null) {
/* 351 */       this.field_70159_w *= -0.10000000149011612D;
/* 352 */       this.field_70181_x *= -0.10000000149011612D;
/* 353 */       this.field_70179_y *= -0.10000000149011612D;
/*     */       
/* 355 */       if (this.thrower != null) {
/* 356 */         var1.field_72308_g.func_70097_a(DamageSource.func_76356_a(this, this.thrower), 1.0F);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public abstract float getResistance();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_70014_b(NBTTagCompound par1NBTTagCompound)
/*     */   {
/* 372 */     par1NBTTagCompound.func_74777_a("xTile", (short)this.xTile);
/* 373 */     par1NBTTagCompound.func_74768_a("fuse", this.ticksRemaining);
/* 374 */     par1NBTTagCompound.func_74777_a("yTile", (short)this.yTile);
/* 375 */     par1NBTTagCompound.func_74777_a("zTile", (short)this.zTile);
/* 376 */     par1NBTTagCompound.func_74774_a("inTile", (byte)this.inTile);
/* 377 */     par1NBTTagCompound.func_74774_a("shake", (byte)this.throwableShake);
/* 378 */     par1NBTTagCompound.func_74774_a("inGround", (byte)(this.inGround ? 1 : 0));
/*     */     
/* 380 */     if (((this.throwerName == null) || (this.throwerName.length() == 0)) && (this.thrower != null) && ((this.thrower instanceof net.minecraft.entity.player.EntityPlayer))) {
/* 381 */       this.throwerName = this.thrower.func_70023_ak();
/*     */     }
/*     */     
/* 384 */     par1NBTTagCompound.func_74778_a("ownerName", this.throwerName == null ? "" : this.throwerName);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound)
/*     */   {
/* 391 */     this.xTile = par1NBTTagCompound.func_74765_d("xTile");
/* 392 */     this.ticksRemaining = par1NBTTagCompound.func_74762_e("fuse");
/* 393 */     this.yTile = par1NBTTagCompound.func_74765_d("yTile");
/* 394 */     this.zTile = par1NBTTagCompound.func_74765_d("zTile");
/* 395 */     this.inTile = (par1NBTTagCompound.func_74771_c("inTile") & 0xFF);
/* 396 */     this.throwableShake = (par1NBTTagCompound.func_74771_c("shake") & 0xFF);
/* 397 */     this.inGround = (par1NBTTagCompound.func_74771_c("inGround") == 1);
/* 398 */     this.throwerName = par1NBTTagCompound.func_74779_i("ownerName");
/*     */     
/* 400 */     if ((this.throwerName != null) && (this.throwerName.length() == 0)) {
/* 401 */       this.throwerName = null;
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 407 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public EntityLivingBase getThrower() {
/* 411 */     if ((this.thrower == null) && (this.throwerName != null) && (this.throwerName.length() > 0)) {
/* 412 */       this.thrower = this.field_70170_p.func_72924_a(this.throwerName);
/*     */     }
/*     */     
/* 415 */     return this.thrower;
/*     */   }
/*     */   
/*     */   public abstract int getFuseTime();
/*     */   
/*     */   public abstract void explode(MovingObjectPosition paramMovingObjectPosition);
/*     */   
/*     */   public boolean shouldBreakBlock(Block block) {
/* 423 */     return false;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/EntityThrowableBounce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */