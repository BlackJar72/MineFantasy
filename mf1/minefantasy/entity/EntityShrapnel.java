/*     */ package minefantasy.entity;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import minefantasy.system.network.PacketManagerMF;
/*     */ import minefantasy.system.network.PacketUserMF;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.enchantment.EnchantmentThorns;
/*     */ import net.minecraft.entity.DataWatcher;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.IProjectile;
/*     */ import net.minecraft.entity.monster.EntityEnderman;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.entity.projectile.EntityArrow;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityShrapnel
/*     */   extends EntityArrow
/*     */   implements IProjectile, PacketUserMF
/*     */ {
/*  46 */   private int xTile = -1;
/*  47 */   private int yTile = -1;
/*  48 */   private int zTile = -1;
/*  49 */   private int inTile = 0;
/*  50 */   private int inData = 0;
/*  51 */   private boolean inGround = false;
/*     */   
/*     */ 
/*  54 */   public int field_70251_a = 0;
/*     */   
/*     */ 
/*  57 */   public int field_70249_b = 0;
/*     */   
/*     */   public Entity field_70250_c;
/*     */   
/*     */   private int ticksInGround;
/*  62 */   private int ticksInAir = 0;
/*     */   
/*     */   private int knockbackStrength;
/*     */   
/*     */   public EntityShrapnel(World world)
/*     */   {
/*  68 */     super(world);
/*  69 */     this.field_70155_l = 10.0D;
/*  70 */     func_70105_a(0.5F, 0.5F);
/*     */   }
/*     */   
/*     */   public EntityShrapnel(Entity owner, World world, double x, double y, double z) {
/*  74 */     this(world, x, y, z);
/*     */     
/*  76 */     if (owner != null) {
/*  77 */       this.field_70250_c = owner;
/*     */     }
/*     */   }
/*     */   
/*     */   public EntityShrapnel(World world, double x, double y, double z) {
/*  82 */     super(world);
/*  83 */     this.field_70155_l = 10.0D;
/*  84 */     func_70105_a(0.5F, 0.5F);
/*  85 */     func_70107_b(x, y, z);
/*  86 */     this.field_70129_M = 0.0F;
/*     */   }
/*     */   
/*     */   protected void func_70088_a() {
/*  90 */     this.field_70180_af.func_75682_a(16, Byte.valueOf((byte)0));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70016_h(double xv, double yv, double zv)
/*     */   {
/*  97 */     this.field_70159_w = xv;
/*  98 */     this.field_70181_x = yv;
/*  99 */     this.field_70179_y = zv;
/*     */     
/* 101 */     if ((this.field_70127_C == 0.0F) && (this.field_70126_B == 0.0F)) {
/* 102 */       float f = MathHelper.func_76133_a(xv * xv + zv * zv);
/* 103 */       this.field_70126_B = (this.field_70177_z = (float)(Math.atan2(xv, zv) * 180.0D / 3.141592653589793D));
/* 104 */       this.field_70127_C = (this.field_70125_A = (float)(Math.atan2(yv, f) * 180.0D / 3.141592653589793D));
/* 105 */       this.field_70127_C = this.field_70125_A;
/* 106 */       this.field_70126_B = this.field_70177_z;
/* 107 */       func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
/* 108 */       this.ticksInGround = 0;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70071_h_()
/*     */   {
/* 116 */     if (this.field_70170_p.field_72995_K) {
/* 117 */       return;
/*     */     }
/*     */     
/* 120 */     super.func_70030_z();
/*     */     
/* 122 */     if ((this.field_70127_C == 0.0F) && (this.field_70126_B == 0.0F)) {
/* 123 */       float f = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 124 */       this.field_70126_B = (this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / 3.141592653589793D));
/* 125 */       this.field_70127_C = (this.field_70125_A = (float)(Math.atan2(this.field_70181_x, f) * 180.0D / 3.141592653589793D));
/*     */     }
/*     */     
/* 128 */     int i = this.field_70170_p.func_72798_a(this.xTile, this.yTile, this.zTile);
/*     */     
/* 130 */     if (i > 0) {
/* 131 */       boolean stick = true;
/* 132 */       Block block = Block.field_71973_m[i];
/*     */       
/* 134 */       if (shouldBreakBlock(block)) {
/* 135 */         this.field_70170_p.func_94571_i(this.xTile, this.yTile, this.zTile);
/* 136 */         String snd = "dig." + block.field_72020_cn;
/* 137 */         if (block.field_72018_cp == Material.field_76264_q) {
/* 138 */           snd = "random.glass";
/*     */         }
/* 140 */         func_85030_a(snd, 1.0F, 1.0F);
/* 141 */         stick = false;
/* 142 */         this.field_70170_p.func_72869_a("tilecrack_" + i + "_" + this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile), this.xTile + 0.5D, this.yTile + 0.5D, this.zTile + 0.5D, 0.0D, 0.0D, 0.0D);
/*     */       }
/* 144 */       if (stick) {
/* 145 */         Block.field_71973_m[i].func_71902_a(this.field_70170_p, this.xTile, this.yTile, this.zTile);
/* 146 */         AxisAlignedBB axisalignedbb = Block.field_71973_m[i].func_71872_e(this.field_70170_p, this.xTile, this.yTile, this.zTile);
/*     */         
/* 148 */         if ((axisalignedbb != null) && (axisalignedbb.func_72318_a(this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t, this.field_70163_u, this.field_70161_v)))) {
/* 149 */           this.inGround = true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 154 */     if (this.field_70249_b > 0) {
/* 155 */       this.field_70249_b -= 1;
/*     */     }
/*     */     
/* 158 */     if (this.inGround) {
/* 159 */       int j = this.field_70170_p.func_72798_a(this.xTile, this.yTile, this.zTile);
/* 160 */       int k = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
/*     */       
/* 162 */       if ((j == this.inTile) && (k == this.inData)) {
/* 163 */         this.ticksInGround += 1;
/*     */         
/* 165 */         if (this.ticksInGround >= 100) {
/* 166 */           func_70106_y();
/*     */         }
/*     */       } else {
/* 169 */         this.inGround = false;
/* 170 */         this.field_70159_w *= this.field_70146_Z.nextFloat() * 0.2F;
/* 171 */         this.field_70181_x *= this.field_70146_Z.nextFloat() * 0.2F;
/* 172 */         this.field_70179_y *= this.field_70146_Z.nextFloat() * 0.2F;
/* 173 */         this.ticksInGround = 0;
/* 174 */         this.ticksInAir = 0;
/*     */       }
/*     */     } else {
/* 177 */       this.ticksInAir += 1;
/* 178 */       Vec3 vec3 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 179 */       Vec3 vec31 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 180 */       MovingObjectPosition movingobjectposition = this.field_70170_p.func_72831_a(vec3, vec31, false, true);
/* 181 */       vec3 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 182 */       vec31 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/*     */       
/* 184 */       if (movingobjectposition != null) {
/* 185 */         vec31 = this.field_70170_p.func_82732_R().func_72345_a(movingobjectposition.field_72307_f.field_72450_a, movingobjectposition.field_72307_f.field_72448_b, movingobjectposition.field_72307_f.field_72449_c);
/*     */       }
/*     */       
/* 188 */       Entity entity = null;
/* 189 */       List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0D, 1.0D, 1.0D));
/* 190 */       double d0 = 0.0D;
/*     */       
/*     */ 
/*     */ 
/* 194 */       for (int l = 0; l < list.size(); l++) {
/* 195 */         Entity entity1 = (Entity)list.get(l);
/*     */         
/* 197 */         if ((entity1.func_70067_L()) && ((entity1 != this.field_70250_c) || (this.ticksInAir >= 5))) {
/* 198 */           float f1 = 0.3F;
/* 199 */           AxisAlignedBB axisalignedbb1 = entity1.field_70121_D.func_72314_b(f1, f1, f1);
/* 200 */           MovingObjectPosition movingobjectposition1 = axisalignedbb1.func_72327_a(vec3, vec31);
/*     */           
/* 202 */           if (movingobjectposition1 != null) {
/* 203 */             double d1 = vec3.func_72438_d(movingobjectposition1.field_72307_f);
/*     */             
/* 205 */             if ((d1 < d0) || (d0 == 0.0D)) {
/* 206 */               entity = entity1;
/* 207 */               d0 = d1;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 213 */       if (entity != null) {
/* 214 */         movingobjectposition = new MovingObjectPosition(entity);
/*     */       }
/*     */       
/* 217 */       if ((movingobjectposition != null) && (movingobjectposition.field_72308_g != null) && ((movingobjectposition.field_72308_g instanceof EntityPlayer))) {
/* 218 */         EntityPlayer entityplayer = (EntityPlayer)movingobjectposition.field_72308_g;
/*     */         
/* 220 */         if ((entityplayer.field_71075_bZ.field_75102_a) || (((this.field_70250_c instanceof EntityPlayer)) && (!((EntityPlayer)this.field_70250_c).func_96122_a(entityplayer)))) {
/* 221 */           movingobjectposition = null;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 228 */       if (movingobjectposition != null) {
/* 229 */         if (movingobjectposition.field_72308_g != null) {
/* 230 */           float f2 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
/* 231 */           int dam = MathHelper.func_76143_f(f2 * func_70242_d());
/*     */           
/* 233 */           if (func_70241_g()) {
/* 234 */             dam += this.field_70146_Z.nextInt(dam / 2 + 2);
/*     */           }
/*     */           
/* 237 */           DamageSource damagesource = null;
/*     */           
/* 239 */           if (this.field_70250_c == null) {
/* 240 */             damagesource = EntityBombThrown.causeBombDamage(this, this);
/*     */           } else {
/* 242 */             damagesource = EntityBombThrown.causeBombDamage(this, this.field_70250_c);
/*     */           }
/* 244 */           damagesource.func_76349_b();
/*     */           
/* 246 */           if ((func_70027_ad()) && (!(movingobjectposition.field_72308_g instanceof EntityEnderman))) {
/* 247 */             movingobjectposition.field_72308_g.func_70015_d(5);
/*     */           }
/*     */           
/* 250 */           if (movingobjectposition.field_72308_g.func_70097_a(damagesource, dam)) {
/* 251 */             entity.field_70172_ad = 0;
/* 252 */             movingobjectposition.field_72308_g.field_70172_ad = 0;
/* 253 */             if ((movingobjectposition.field_72308_g instanceof EntityLiving)) {
/* 254 */               EntityLiving entityliving = (EntityLiving)movingobjectposition.field_72308_g;
/*     */               
/* 256 */               if (!this.field_70170_p.field_72995_K) {
/* 257 */                 entityliving.func_85034_r(entityliving.func_85035_bI() + 1);
/*     */               }
/*     */               
/* 260 */               if (this.field_70250_c != null) {
/* 261 */                 EnchantmentThorns.func_92096_a(this.field_70250_c, entityliving, this.field_70146_Z);
/*     */               }
/*     */               
/* 264 */               if ((this.field_70250_c != null) && (movingobjectposition.field_72308_g != this.field_70250_c) && ((movingobjectposition.field_72308_g instanceof EntityPlayer)) && ((this.field_70250_c instanceof EntityPlayerMP))) {
/* 265 */                 ((EntityPlayerMP)this.field_70250_c).field_71135_a.func_72567_b(new Packet70GameEvent(6, 0));
/*     */               }
/*     */             }
/*     */             
/* 269 */             if (!(movingobjectposition.field_72308_g instanceof EntityEnderman)) {
/* 270 */               func_70106_y();
/*     */             }
/*     */           } else {
/* 273 */             this.field_70159_w *= -0.10000000149011612D;
/* 274 */             this.field_70181_x *= -0.10000000149011612D;
/* 275 */             this.field_70179_y *= -0.10000000149011612D;
/* 276 */             this.field_70177_z += 180.0F;
/* 277 */             this.field_70126_B += 180.0F;
/* 278 */             this.ticksInAir = 0;
/*     */           }
/*     */         } else {
/* 281 */           this.xTile = movingobjectposition.field_72311_b;
/* 282 */           this.yTile = movingobjectposition.field_72312_c;
/* 283 */           this.zTile = movingobjectposition.field_72309_d;
/* 284 */           this.inTile = this.field_70170_p.func_72798_a(this.xTile, this.yTile, this.zTile);
/* 285 */           this.inData = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
/* 286 */           this.field_70159_w = ((float)(movingobjectposition.field_72307_f.field_72450_a - this.field_70165_t));
/* 287 */           this.field_70181_x = ((float)(movingobjectposition.field_72307_f.field_72448_b - this.field_70163_u));
/* 288 */           this.field_70179_y = ((float)(movingobjectposition.field_72307_f.field_72449_c - this.field_70161_v));
/* 289 */           float f2 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
/* 290 */           this.field_70165_t -= this.field_70159_w / f2 * 0.05000000074505806D;
/* 291 */           this.field_70163_u -= this.field_70181_x / f2 * 0.05000000074505806D;
/* 292 */           this.field_70161_v -= this.field_70179_y / f2 * 0.05000000074505806D;
/* 293 */           func_85030_a("random.bowhit", 1.0F, 1.2F / (this.field_70146_Z.nextFloat() * 0.2F + 0.9F));
/* 294 */           this.inGround = true;
/* 295 */           this.field_70249_b = 7;
/* 296 */           func_70243_d(false);
/*     */           
/* 298 */           if (this.inTile != 0) {
/* 299 */             Block.field_71973_m[this.inTile].func_71869_a(this.field_70170_p, this.xTile, this.yTile, this.zTile, this);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 304 */       if (func_70241_g()) {
/* 305 */         for (l = 0; l < 4; l++) {
/* 306 */           this.field_70170_p.func_72869_a("crit", this.field_70165_t + this.field_70159_w * l / 4.0D, this.field_70163_u + this.field_70181_x * l / 4.0D, this.field_70161_v + this.field_70179_y * l / 4.0D, -this.field_70159_w, -this.field_70181_x + 0.2D, -this.field_70179_y);
/*     */         }
/*     */       }
/*     */       
/* 310 */       this.field_70165_t += this.field_70159_w;
/* 311 */       this.field_70163_u += this.field_70181_x;
/* 312 */       this.field_70161_v += this.field_70179_y;
/* 313 */       float f2 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 314 */       this.field_70177_z = ((float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / 3.141592653589793D));
/*     */       
/* 316 */       for (this.field_70125_A = ((float)(Math.atan2(this.field_70181_x, f2) * 180.0D / 3.141592653589793D)); this.field_70125_A - this.field_70127_C < -180.0F; this.field_70127_C -= 360.0F) {}
/*     */       
/*     */ 
/*     */ 
/* 320 */       while (this.field_70125_A - this.field_70127_C >= 180.0F) {
/* 321 */         this.field_70127_C += 360.0F;
/*     */       }
/*     */       
/* 324 */       while (this.field_70177_z - this.field_70126_B < -180.0F) {
/* 325 */         this.field_70126_B -= 360.0F;
/*     */       }
/*     */       
/* 328 */       while (this.field_70177_z - this.field_70126_B >= 180.0F) {
/* 329 */         this.field_70126_B += 360.0F;
/*     */       }
/*     */       
/* 332 */       this.field_70125_A = (this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2F);
/* 333 */       this.field_70177_z = (this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2F);
/* 334 */       float f4 = 0.99F;
/* 335 */       float f1 = getGravity();
/*     */       
/* 337 */       if (func_70090_H()) {
/* 338 */         for (int j1 = 0; j1 < 4; j1++) {
/* 339 */           float f3 = 0.25F;
/* 340 */           this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * f3, this.field_70163_u - this.field_70181_x * f3, this.field_70161_v - this.field_70179_y * f3, this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */         }
/*     */         
/* 343 */         f4 = 0.8F;
/*     */       }
/*     */       
/* 346 */       this.field_70159_w *= f4;
/* 347 */       this.field_70181_x *= f4;
/* 348 */       this.field_70179_y *= f4;
/* 349 */       this.field_70181_x -= f1;
/* 350 */       func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 351 */       func_70017_D();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean shouldBreakBlock(Block block) {
/* 356 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70014_b(NBTTagCompound nbt)
/*     */   {
/* 363 */     super.func_70014_b(nbt);
/* 364 */     nbt.func_74777_a("xTile", (short)this.xTile);
/* 365 */     nbt.func_74777_a("yTile", (short)this.yTile);
/* 366 */     nbt.func_74777_a("zTile", (short)this.zTile);
/* 367 */     nbt.func_74774_a("inTile", (byte)this.inTile);
/* 368 */     nbt.func_74774_a("inData", (byte)this.inData);
/* 369 */     nbt.func_74774_a("shake", (byte)this.field_70249_b);
/* 370 */     nbt.func_74774_a("inGround", (byte)(this.inGround ? 1 : 0));
/* 371 */     nbt.func_74774_a("pickup", (byte)this.field_70251_a);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70037_a(NBTTagCompound nbt)
/*     */   {
/* 378 */     super.func_70037_a(nbt);
/* 379 */     this.xTile = nbt.func_74765_d("xTile");
/* 380 */     this.yTile = nbt.func_74765_d("yTile");
/* 381 */     this.zTile = nbt.func_74765_d("zTile");
/* 382 */     this.inTile = (nbt.func_74771_c("inTile") & 0xFF);
/* 383 */     this.inData = (nbt.func_74771_c("inData") & 0xFF);
/* 384 */     this.field_70249_b = (nbt.func_74771_c("shake") & 0xFF);
/* 385 */     this.inGround = (nbt.func_74771_c("inGround") == 1);
/*     */     
/* 387 */     if (nbt.func_74764_b("pickup")) {
/* 388 */       this.field_70251_a = nbt.func_74771_c("pickup");
/* 389 */     } else if (nbt.func_74764_b("player")) {
/* 390 */       this.field_70251_a = (nbt.func_74767_n("player") ? 1 : 0);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_70100_b_(EntityPlayer player) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private float getGravity()
/*     */   {
/* 404 */     return 0.1F;
/*     */   }
/*     */   
/*     */   public String getTexture() {
/* 408 */     return "shrapnel";
/*     */   }
/*     */   
/*     */   public double func_70242_d() {
/* 412 */     return super.func_70242_d();
/*     */   }
/*     */   
/*     */   public void sendTrackerPacket() {
/*     */     try {
/* 417 */       Packet packet = PacketManagerMF.getEntityPacketDoubleArray(this, new double[] { this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70159_w, this.field_70181_x, this.field_70179_y, this.field_70125_A, this.field_70177_z, this.field_70127_C, this.field_70126_B });
/* 418 */       FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*     */     }
/*     */     catch (NullPointerException localNullPointerException) {}
/*     */   }
/*     */   
/*     */ 
/*     */   public void recievePacket(ByteArrayDataInput data)
/*     */   {
/* 426 */     this.field_70165_t = data.readDouble();
/* 427 */     this.field_70163_u = data.readDouble();
/* 428 */     this.field_70161_v = data.readDouble();
/*     */     
/* 430 */     this.field_70159_w = data.readDouble();
/* 431 */     this.field_70181_x = data.readDouble();
/* 432 */     this.field_70179_y = data.readDouble();
/*     */     
/* 434 */     this.field_70125_A = ((float)data.readDouble());
/* 435 */     this.field_70177_z = ((float)data.readDouble());
/* 436 */     this.field_70127_C = ((float)data.readDouble());
/* 437 */     this.field_70126_B = ((float)data.readDouble());
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/EntityShrapnel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */