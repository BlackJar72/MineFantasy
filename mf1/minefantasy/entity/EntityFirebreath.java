/*     */ package minefantasy.entity;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.system.cfg;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockFire;
/*     */ import net.minecraft.block.BlockFluid;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.DataWatcher;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EntityDamageSourceIndirect;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.util.Vec3Pool;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityFirebreath
/*     */   extends Entity
/*     */ {
/*  34 */   private int xTile = -1;
/*  35 */   private int yTile = -1;
/*  36 */   private int zTile = -1;
/*  37 */   private int inTile = 0;
/*  38 */   private boolean inGround = false;
/*     */   public EntityLiving shootingEntity;
/*     */   private int ticksAlive;
/*  41 */   private int ticksInAir = 0;
/*     */   public double accelerationX;
/*     */   public double accelerationY;
/*  44 */   private int lifespan = 40;
/*     */   public double accelerationZ;
/*     */   
/*     */   public EntityFirebreath(World world) {
/*  48 */     super(world);
/*  49 */     func_70105_a(2.0F, 2.0F);
/*     */   }
/*     */   
/*     */   protected void func_70088_a() {
/*  53 */     this.field_70180_af.func_75682_a(4, Integer.valueOf(0));
/*     */   }
/*     */   
/*     */   public EntityFirebreath ice() {
/*  57 */     this.field_70180_af.func_75692_b(4, Integer.valueOf(1));
/*  58 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_70112_a(double dist)
/*     */   {
/*  67 */     double var3 = this.field_70121_D.func_72320_b() * 4.0D;
/*  68 */     var3 *= 64.0D;
/*  69 */     return dist < var3 * var3;
/*     */   }
/*     */   
/*     */   public EntityFirebreath(World world, double x, double y, double z, double xtar, double ytar, double ztar) {
/*  73 */     super(world);
/*  74 */     func_70105_a(1.0F, 1.0F);
/*  75 */     func_70012_b(x, y, z, this.field_70177_z, this.field_70125_A);
/*  76 */     func_70107_b(x, y, z);
/*  77 */     double var14 = MathHelper.func_76133_a(xtar * xtar + ytar * ytar + ztar * ztar);
/*  78 */     this.accelerationX = (xtar / var14 * 0.1D);
/*  79 */     this.accelerationY = (ytar / var14 * 0.1D);
/*  80 */     this.accelerationZ = (ztar / var14 * 0.1D);
/*     */   }
/*     */   
/*     */   public EntityFirebreath(World world, EntityLiving attacker, double xtar, double ytar, double ztar) {
/*  84 */     super(world);
/*  85 */     this.shootingEntity = attacker;
/*  86 */     func_70105_a(1.0F, 1.0F);
/*  87 */     func_70012_b(attacker.field_70165_t, attacker.field_70163_u, attacker.field_70161_v, attacker.field_70177_z, attacker.field_70125_A);
/*  88 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*  89 */     this.field_70129_M = 0.0F;
/*  90 */     this.field_70159_w = (this.field_70181_x = this.field_70179_y = 0.0D);
/*  91 */     xtar += this.field_70146_Z.nextGaussian() * 0.4D;
/*  92 */     ytar += this.field_70146_Z.nextGaussian() * 0.4D;
/*  93 */     ztar += this.field_70146_Z.nextGaussian() * 0.4D;
/*  94 */     double var9 = MathHelper.func_76133_a(xtar * xtar + ytar * ytar + ztar * ztar);
/*  95 */     this.accelerationX = (xtar / var9 * 0.1D);
/*  96 */     this.accelerationY = (ytar / var9 * 0.1D);
/*  97 */     this.accelerationZ = (ztar / var9 * 0.1D);
/*     */   }
/*     */   
/*     */   public int getType() {
/* 101 */     return this.field_70180_af.func_75679_c(4);
/*     */   }
/*     */   
/*     */   public EntityFirebreath(World world, EntityLiving attacker, double xtar, double ytar, double ztar, int life) {
/* 105 */     this(world, attacker, xtar, ytar, ztar);
/* 106 */     this.lifespan = life;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70071_h_()
/*     */   {
/* 113 */     if ((func_70026_G()) && (this.field_70146_Z.nextInt(40) == 0))
/* 114 */       func_70106_y();
/* 115 */     int var15_1 = this.field_70170_p.func_72798_a(this.xTile, this.yTile, this.zTile);
/*     */     
/* 117 */     if (var15_1 > 0) {
/* 118 */       Block.field_71973_m[var15_1].func_71902_a(this.field_70170_p, this.xTile, this.yTile, this.zTile);
/* 119 */       AxisAlignedBB var2 = Block.field_71973_m[var15_1].func_71872_e(this.field_70170_p, this.xTile, this.yTile, this.zTile);
/*     */       
/* 121 */       if ((var2 != null) && (var2.func_72318_a(this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t, this.field_70163_u, this.field_70161_v)))) {
/* 122 */         func_70106_y();
/*     */       }
/*     */     }
/* 125 */     if ((!this.field_70170_p.field_72995_K) && (!this.field_70170_p.func_72899_e((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v))) {
/* 126 */       func_70106_y();
/*     */     } else {
/* 128 */       super.func_70071_h_();
/* 129 */       if (getType() == 0)
/* 130 */         func_70015_d(1);
/* 131 */       this.ticksAlive += 1;
/*     */       
/* 133 */       if (this.ticksAlive >= this.lifespan) {
/* 134 */         func_70106_y();
/*     */       }
/*     */       
/* 137 */       if (this.inGround) {
/* 138 */         int var1 = this.field_70170_p.func_72798_a(this.xTile, this.yTile, this.zTile);
/*     */         
/* 140 */         if (var1 == this.inTile)
/*     */         {
/* 142 */           func_70106_y();
/*     */           
/* 144 */           return;
/*     */         }
/*     */         
/* 147 */         this.inGround = false;
/* 148 */         this.field_70159_w *= this.field_70146_Z.nextFloat() * 0.2F;
/* 149 */         this.field_70181_x *= this.field_70146_Z.nextFloat() * 0.2F;
/* 150 */         this.field_70179_y *= this.field_70146_Z.nextFloat() * 0.2F;
/* 151 */         this.ticksAlive = 0;
/* 152 */         this.ticksInAir = 0;
/*     */       } else {
/* 154 */         this.ticksInAir += 1;
/*     */       }
/*     */       
/* 157 */       Vec3 var15 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 158 */       Vec3 var2 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 159 */       MovingObjectPosition var3 = this.field_70170_p.func_72933_a(var15, var2);
/* 160 */       var15 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 161 */       var2 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/*     */       
/* 163 */       if (var3 != null) {
/* 164 */         var2 = this.field_70170_p.func_82732_R().func_72345_a(var3.field_72307_f.field_72450_a, var3.field_72307_f.field_72448_b, var3.field_72307_f.field_72449_c);
/*     */       }
/*     */       
/* 167 */       Entity var4 = null;
/* 168 */       List var5 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0D, 1.0D, 1.0D));
/* 169 */       double var6 = 0.0D;
/*     */       
/* 171 */       for (int var8 = 0; var8 < var5.size(); var8++) {
/* 172 */         Entity var9 = (Entity)var5.get(var8);
/*     */         
/* 174 */         if ((var9.func_70067_L()) && ((!var9.func_70028_i(this.shootingEntity)) || (this.ticksInAir >= 25))) {
/* 175 */           float var10 = 0.3F;
/* 176 */           AxisAlignedBB var11 = var9.field_70121_D.func_72314_b(var10, var10, var10);
/* 177 */           MovingObjectPosition var12 = var11.func_72327_a(var15, var2);
/*     */           
/* 179 */           if (var12 != null) {
/* 180 */             double var13 = var15.func_72438_d(var12.field_72307_f);
/*     */             
/* 182 */             if ((var13 < var6) || (var6 == 0.0D)) {
/* 183 */               var4 = var9;
/* 184 */               var6 = var13;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 191 */       if (canShoot(var4)) {
/* 192 */         var3 = new MovingObjectPosition(var4);
/* 193 */         var4.func_70015_d(1);
/*     */         
/* 195 */         if ((this.field_70146_Z.nextInt(3) == 0) && ((!var4.func_70045_F()) || (getType() != 0))) {
/* 196 */           DamageSource source = getDamageSource();
/* 197 */           var4.func_70097_a(source, getDamage());
/* 198 */           applyEffects(var4);
/*     */         }
/*     */       }
/*     */       
/* 202 */       if (var3 != null) {
/* 203 */         hitEntity(var3);
/*     */       }
/*     */       
/* 206 */       this.field_70165_t += this.field_70159_w;
/* 207 */       this.field_70163_u += this.field_70181_x;
/* 208 */       this.field_70161_v += this.field_70179_y;
/* 209 */       float var16 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 210 */       this.field_70177_z = ((float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / 3.141592653589793D));
/*     */       
/* 212 */       for (this.field_70125_A = ((float)(Math.atan2(this.field_70181_x, var16) * 180.0D / 3.141592653589793D)); this.field_70125_A - this.field_70127_C < -180.0F; this.field_70127_C -= 360.0F) {}
/*     */       
/*     */ 
/*     */ 
/* 216 */       while (this.field_70125_A - this.field_70127_C >= 180.0F) {
/* 217 */         this.field_70127_C += 360.0F;
/*     */       }
/*     */       
/* 220 */       while (this.field_70177_z - this.field_70126_B < -180.0F) {
/* 221 */         this.field_70126_B -= 360.0F;
/*     */       }
/*     */       
/* 224 */       while (this.field_70177_z - this.field_70126_B >= 180.0F) {
/* 225 */         this.field_70126_B += 360.0F;
/*     */       }
/*     */       
/* 228 */       this.field_70125_A = (this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2F);
/* 229 */       this.field_70177_z = (this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2F);
/* 230 */       float var17 = 0.95F;
/*     */       
/* 232 */       if (func_70090_H()) {
/* 233 */         for (int var19 = 0; var19 < 4; var19++) {
/* 234 */           float var18 = 0.25F;
/* 235 */           this.field_70170_p.func_72869_a("smoke", this.field_70165_t - this.field_70159_w * var18, this.field_70163_u - this.field_70181_x * var18, this.field_70161_v - this.field_70179_y * var18, this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */         }
/*     */         
/* 238 */         var17 = 0.8F;
/*     */       }
/*     */       
/* 241 */       this.field_70159_w += this.accelerationX;
/* 242 */       this.field_70181_x += this.accelerationY;
/* 243 */       this.field_70179_y += this.accelerationZ;
/* 244 */       this.field_70159_w *= var17;
/* 245 */       this.field_70181_x *= var17;
/* 246 */       this.field_70179_y *= var17;
/* 247 */       this.field_70170_p.func_72869_a("snoke", this.field_70165_t, this.field_70163_u + 0.5D, this.field_70161_v, 0.0D, 0.0D, 0.0D);
/* 248 */       func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*     */     }
/* 250 */     AxisAlignedBB bb = this.field_70121_D.func_72314_b(1.0D, 1.0D, 1.0D);
/* 251 */     if (!this.field_70170_p.field_72995_K)
/* 252 */       destroyBlocksInAABB(bb);
/*     */   }
/*     */   
/*     */   private DamageSource getDamageSource() {
/* 256 */     if (this.shootingEntity != null) {
/* 257 */       return new DamageSourceFirebreath(this, this.shootingEntity);
/*     */     }
/* 259 */     return new DamageSourceFirebreath(this, this);
/*     */   }
/*     */   
/*     */   private boolean canShoot(Entity en) {
/* 263 */     if (en == null) {
/* 264 */       return false;
/*     */     }
/* 266 */     if ((this.shootingEntity != null) && 
/* 267 */       (this.shootingEntity.field_70153_n != null) && 
/* 268 */       (this.shootingEntity.field_70153_n == en)) {
/* 269 */       return false;
/*     */     }
/* 271 */     return true;
/*     */   }
/*     */   
/*     */   private void applyEffects(Entity tar) {
/* 275 */     if ((tar instanceof EntityLiving)) {
/* 276 */       EntityLiving live = (EntityLiving)tar;
/* 277 */       if (getType() == 1)
/*     */       {
/* 279 */         int id = Potion.field_76421_d.field_76415_H;
/* 280 */         int d = 20;
/* 281 */         int l = 0;
/* 282 */         if (live.func_70660_b(Potion.field_76421_d) != null)
/*     */         {
/* 284 */           id = live.func_70660_b(Potion.field_76421_d).func_76456_a();
/* 285 */           d = live.func_70660_b(Potion.field_76421_d).func_76459_b();
/* 286 */           l = live.func_70660_b(Potion.field_76421_d).func_76458_c();
/*     */           
/* 288 */           if (d < 1200)
/* 289 */             d += 30;
/* 290 */           if ((this.field_70146_Z.nextInt(10) == 0) && (l < 5)) {
/* 291 */             l++;
/*     */           }
/*     */         }
/* 294 */         live.func_70690_d(new PotionEffect(id, d, l));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   protected void hitEntity(MovingObjectPosition pos) {
/* 300 */     if (!this.field_70170_p.field_72995_K) {
/* 301 */       AxisAlignedBB var3 = this.field_70121_D.func_72314_b(4.0D, 2.0D, 4.0D);
/* 302 */       List var4 = this.field_70170_p.func_72872_a(EntityLiving.class, var3);
/*     */       
/* 304 */       if (((var4 == null) || (var4.isEmpty())) || (
/*     */       
/*     */ 
/* 307 */         (this.field_70146_Z.nextInt(60) == 0) && (cfg.dragonGrief))) {
/* 308 */         int id = 0;
/* 309 */         if (getType() == 0)
/* 310 */           id = Block.field_72067_ar.field_71990_ca;
/* 311 */         if (getType() == 1) {
/* 312 */           id = Block.field_72037_aS.field_71990_ca;
/*     */         }
/* 314 */         placeFire((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, id);
/* 315 */         placeFire((int)this.field_70165_t, (int)this.field_70163_u - 1, (int)this.field_70161_v, id);
/*     */         
/* 317 */         if (getType() == 3) {
/* 318 */           freezeBlock((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
/*     */         }
/*     */       }
/* 321 */       if ((pos.field_72308_g != null) && (pos.field_72308_g.func_70097_a(getDamageSource(), getDamage()))) {
/* 322 */         applyEffects(pos.field_72308_g);
/*     */       }
/* 324 */       if ((pos.field_72308_g == null) || ((!(pos.field_72308_g instanceof EntityDragonSmall)) && (!(pos.field_72308_g instanceof EntityFirebreath))))
/*     */       {
/*     */ 
/* 327 */         func_70106_y();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void placeFire(int x, int y, int z, int id) {
/* 333 */     if ((this.field_70170_p.func_72799_c(x, y, z)) || (this.field_70170_p.func_72803_f(x, y, z) == Material.field_76259_v)) {
/* 334 */       placeBlock(x, y, z, id);
/*     */     }
/*     */   }
/*     */   
/*     */   private int getDamage() {
/* 339 */     switch (getType()) {
/*     */     case 0: 
/* 341 */       return 4;
/*     */     case 1: 
/* 343 */       return 3;
/*     */     }
/* 345 */     return 4;
/*     */   }
/*     */   
/*     */   private void freezeBlock(int x, int y, int z)
/*     */   {
/* 350 */     int repl = this.field_70170_p.func_72798_a(x, y, z);
/*     */     int i;
/* 352 */     if (repl == Block.field_71943_B.field_71990_ca)
/* 353 */       i = Block.field_72036_aT.field_71990_ca;
/* 354 */     if (repl == Block.field_71938_D.field_71990_ca)
/* 355 */       i = Block.field_72089_ap.field_71990_ca;
/* 356 */     if (repl == Block.field_71944_C.field_71990_ca)
/* 357 */       i = Block.field_72089_ap.field_71990_ca;
/* 358 */     if (this.field_70170_p.func_72803_f(x, y, z) == Material.field_76257_i)
/* 359 */       i = MineFantasyBase.MFBlockIce.field_71990_ca;
/* 360 */     if (this.field_70170_p.func_72803_f(x, y, z) == Material.field_76254_j)
/* 361 */       i = MineFantasyBase.MFBlockIce.field_71990_ca;
/*     */   }
/*     */   
/*     */   private void placeBlock(int x, int y, int z, int id) {
/* 365 */     if ((!this.field_70170_p.func_72799_c(x, y - 1, z)) && (
/* 366 */       (this.field_70170_p.func_72809_s(x, y - 1, z)) || (Block.field_71973_m[id].func_71926_d()))) {
/* 367 */       this.field_70170_p.func_72832_d(x, y, z, id, 0, 3);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_70014_b(NBTTagCompound tag)
/*     */   {
/* 374 */     tag.func_74777_a("xTile", (short)this.xTile);
/* 375 */     tag.func_74777_a("yTile", (short)this.yTile);
/* 376 */     tag.func_74777_a("zTile", (short)this.zTile);
/* 377 */     tag.func_74774_a("inTile", (byte)this.inTile);
/* 378 */     tag.func_74774_a("inGround", (byte)(this.inGround ? 1 : 0));
/* 379 */     tag.func_74768_a("Type", getType());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70037_a(NBTTagCompound tag)
/*     */   {
/* 386 */     this.xTile = tag.func_74765_d("xTile");
/* 387 */     this.yTile = tag.func_74765_d("yTile");
/* 388 */     this.zTile = tag.func_74765_d("zTile");
/* 389 */     this.inTile = (tag.func_74771_c("inTile") & 0xFF);
/* 390 */     this.inGround = (tag.func_74771_c("inGround") == 1);
/* 391 */     this.field_70180_af.func_75692_b(4, Integer.valueOf(tag.func_74762_e("Type")));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_70067_L()
/*     */   {
/* 399 */     return true;
/*     */   }
/*     */   
/*     */   public float func_70111_Y() {
/* 403 */     return 1.0F;
/*     */   }
/*     */   
/*     */   public float func_70053_R() {
/* 407 */     return 0.0F;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public float func_70013_c(float amount)
/*     */   {
/* 414 */     return 1.0F;
/*     */   }
/*     */   
/*     */   public int func_70070_b(float amount) {
/* 418 */     return 15728880;
/*     */   }
/*     */   
/*     */   private boolean destroyBlocksInAABB(AxisAlignedBB box) {
/* 422 */     int var2 = MathHelper.func_76128_c(box.field_72340_a);
/* 423 */     int var3 = MathHelper.func_76128_c(box.field_72338_b);
/* 424 */     int var4 = MathHelper.func_76128_c(box.field_72339_c);
/* 425 */     int var5 = MathHelper.func_76128_c(box.field_72336_d);
/* 426 */     int var6 = MathHelper.func_76128_c(box.field_72337_e);
/* 427 */     int var7 = MathHelper.func_76128_c(box.field_72334_f);
/* 428 */     boolean var8 = false;
/* 429 */     boolean var9 = false;
/*     */     
/* 431 */     for (int var10 = var2; var10 <= var5; var10++) {
/* 432 */       for (int var11 = var3; var11 <= var6; var11++) {
/* 433 */         for (int var12 = var4; var12 <= var7; var12++) {
/* 434 */           Material var13 = this.field_70170_p.func_72803_f(var10, var11, var12);
/*     */           
/* 436 */           if (var13 != null) {
/* 437 */             if (var13 == Material.field_76264_q) {
/* 438 */               var9 = true;
/* 439 */               this.field_70170_p.func_94571_i(var10, var11, var12);
/* 440 */             } else if (var13 == Material.field_76262_s) {
/* 441 */               var9 = true;
/* 442 */               this.field_70170_p.func_94571_i(var10, var11, var12);
/* 443 */               this.field_70170_p.func_72876_a(this, var10, var11, var12, 4.0F, true);
/*     */             } else {
/* 445 */               var8 = true;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 452 */     if (var9) {
/* 453 */       double var16 = box.field_72340_a + (box.field_72336_d - box.field_72340_a) * this.field_70146_Z.nextFloat();
/* 454 */       double var17 = box.field_72338_b + (box.field_72337_e - box.field_72338_b) * this.field_70146_Z.nextFloat();
/* 455 */       double var14 = box.field_72339_c + (box.field_72334_f - box.field_72339_c) * this.field_70146_Z.nextFloat();
/* 456 */       this.field_70170_p.func_72869_a("largeexplode", var16, var17, var14, 0.0D, 0.0D, 0.0D);
/* 457 */       for (int a = 0; a < 1 + this.field_70146_Z.nextInt(4); a++) {
/* 458 */         this.field_70170_p.func_72956_a(this, "random.glass", 1.0F, 1.0F);
/*     */       }
/*     */     }
/* 461 */     return var8;
/*     */   }
/*     */   
/*     */   public class DamageSourceFirebreath extends EntityDamageSourceIndirect
/*     */   {
/*     */     public DamageSourceFirebreath(EntityFirebreath breath, Entity shooter) {
/* 467 */       super(breath, shooter);
/* 468 */       func_76361_j();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/EntityFirebreath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */