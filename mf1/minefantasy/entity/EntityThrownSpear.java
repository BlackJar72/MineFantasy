/*     */ package minefantasy.entity;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.network.PacketDispatcher;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.PrintStream;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.item.ToolMaterialMedieval;
/*     */ import minefantasy.item.weapon.ItemSpearMF;
/*     */ import minefantasy.system.network.PacketManagerMF;
/*     */ import minefantasy.system.network.PacketUserMF;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.DataWatcher;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.EnumCreatureAttribute;
/*     */ import net.minecraft.entity.monster.EntityEnderman;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.entity.projectile.EntityArrow;
/*     */ import net.minecraft.item.EnumToolMaterial;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.packet.Packet;
/*     */ import net.minecraft.network.packet.Packet70GameEvent;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.util.Vec3Pool;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityThrownSpear extends EntityArrow implements net.minecraft.entity.IProjectile, PacketUserMF, IThrownItem, ISyncedInventory
/*     */ {
/*  47 */   private int xTile = -1;
/*  48 */   private int yTile = -1;
/*  49 */   private int zTile = -1;
/*     */   
/*     */   private int inTile;
/*     */   
/*     */   private int inData;
/*     */   
/*     */   private boolean inGround;
/*     */   
/*     */   public int field_70251_a;
/*     */   
/*     */   public int field_70249_b;
/*     */   
/*     */   public Entity field_70250_c;
/*     */   
/*     */   private int ticksInGround;
/*     */   
/*     */   private int ticksInAir;
/*     */   
/*  67 */   private double damage = 2.0D;
/*     */   
/*     */   private int knockbackStrength;
/*     */   private ItemStack spearItem;
/*     */   
/*     */   public EntityThrownSpear(World world)
/*     */   {
/*  74 */     super(world);
/*  75 */     this.field_70155_l = 10.0D;
/*  76 */     func_70105_a(0.5F, 0.5F);
/*     */   }
/*     */   
/*     */   public EntityThrownSpear(World world, double x, double y, double z) {
/*  80 */     this(world);
/*  81 */     func_70107_b(x, y, z);
/*  82 */     this.field_70129_M = 0.0F;
/*     */   }
/*     */   
/*     */   public EntityThrownSpear(World world, EntityLivingBase thrower, float power) {
/*  86 */     this(world);
/*  87 */     this.field_70250_c = thrower;
/*     */     
/*  89 */     if ((thrower instanceof EntityPlayer)) {
/*  90 */       this.field_70251_a = 1;
/*     */     }
/*     */     
/*  93 */     func_70012_b(thrower.field_70165_t, thrower.field_70163_u + thrower.func_70047_e(), thrower.field_70161_v, thrower.field_70177_z, thrower.field_70125_A);
/*  94 */     this.field_70165_t -= MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F;
/*  95 */     this.field_70163_u -= 0.10000000149011612D;
/*  96 */     this.field_70161_v -= MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F;
/*  97 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*  98 */     this.field_70129_M = 0.0F;
/*  99 */     this.field_70159_w = (-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F));
/* 100 */     this.field_70179_y = (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F));
/* 101 */     this.field_70181_x = (-MathHelper.func_76126_a(this.field_70125_A / 180.0F * 3.1415927F));
/* 102 */     func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, power * 1.5F, 1.0F);
/*     */   }
/*     */   
/*     */   protected void func_70088_a() {
/* 106 */     this.field_70180_af.func_75682_a(16, Byte.valueOf((byte)0));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_70186_c(double par1, double par3, double par5, float par7, float par8)
/*     */   {
/* 114 */     float f2 = MathHelper.func_76133_a(par1 * par1 + par3 * par3 + par5 * par5);
/* 115 */     par1 /= f2;
/* 116 */     par3 /= f2;
/* 117 */     par5 /= f2;
/* 118 */     par1 += this.field_70146_Z.nextGaussian() * (this.field_70146_Z.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
/* 119 */     par3 += this.field_70146_Z.nextGaussian() * (this.field_70146_Z.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
/* 120 */     par5 += this.field_70146_Z.nextGaussian() * (this.field_70146_Z.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
/* 121 */     par1 *= par7;
/* 122 */     par3 *= par7;
/* 123 */     par5 *= par7;
/* 124 */     this.field_70159_w = par1;
/* 125 */     this.field_70181_x = par3;
/* 126 */     this.field_70179_y = par5;
/* 127 */     float f3 = MathHelper.func_76133_a(par1 * par1 + par5 * par5);
/* 128 */     this.field_70126_B = (this.field_70177_z = (float)(Math.atan2(par1, par5) * 180.0D / 3.141592653589793D));
/* 129 */     this.field_70127_C = (this.field_70125_A = (float)(Math.atan2(par3, f3) * 180.0D / 3.141592653589793D));
/* 130 */     this.ticksInGround = 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70056_a(double par1, double par3, double par5, float par7, float par8, int par9)
/*     */   {
/* 139 */     func_70107_b(par1, par3, par5);
/* 140 */     func_70101_b(par7, par8);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70016_h(double par1, double par3, double par5)
/*     */   {
/* 148 */     this.field_70159_w = par1;
/* 149 */     this.field_70181_x = par3;
/* 150 */     this.field_70179_y = par5;
/*     */     
/* 152 */     if ((this.field_70127_C == 0.0F) && (this.field_70126_B == 0.0F)) {
/* 153 */       float f = MathHelper.func_76133_a(par1 * par1 + par5 * par5);
/* 154 */       this.field_70126_B = (this.field_70177_z = (float)(Math.atan2(par1, par5) * 180.0D / 3.141592653589793D));
/* 155 */       this.field_70127_C = (this.field_70125_A = (float)(Math.atan2(par3, f) * 180.0D / 3.141592653589793D));
/* 156 */       this.field_70127_C = this.field_70125_A;
/* 157 */       this.field_70126_B = this.field_70177_z;
/* 158 */       func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
/* 159 */       this.ticksInGround = 0;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_70071_h_()
/*     */   {
/* 168 */     func_70030_z();
/*     */     
/* 170 */     if ((this.field_70127_C == 0.0F) && (this.field_70126_B == 0.0F)) {
/* 171 */       float f = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 172 */       this.field_70126_B = (this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / 3.141592653589793D));
/* 173 */       this.field_70127_C = (this.field_70125_A = (float)(Math.atan2(this.field_70181_x, f) * 180.0D / 3.141592653589793D));
/*     */     }
/*     */     
/* 176 */     int i = this.field_70170_p.func_72798_a(this.xTile, this.yTile, this.zTile);
/*     */     
/* 178 */     if (i > 0) {
/* 179 */       Block.field_71973_m[i].func_71902_a(this.field_70170_p, this.xTile, this.yTile, this.zTile);
/* 180 */       AxisAlignedBB axisalignedbb = Block.field_71973_m[i].func_71872_e(this.field_70170_p, this.xTile, this.yTile, this.zTile);
/*     */       
/* 182 */       if ((axisalignedbb != null) && (axisalignedbb.func_72318_a(this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t, this.field_70163_u, this.field_70161_v)))) {
/* 183 */         this.inGround = true;
/*     */       }
/*     */     }
/*     */     
/* 187 */     if (this.field_70249_b > 0) {
/* 188 */       this.field_70249_b -= 1;
/*     */     }
/*     */     
/* 191 */     if (this.inGround) {
/* 192 */       int j = this.field_70170_p.func_72798_a(this.xTile, this.yTile, this.zTile);
/* 193 */       int k = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
/*     */       
/* 195 */       if ((j == this.inTile) && (k == this.inData)) {
/* 196 */         this.ticksInGround += 1;
/*     */         
/* 198 */         if (this.ticksInGround == 1200) {
/* 199 */           func_70106_y();
/*     */         }
/*     */       } else {
/* 202 */         this.inGround = false;
/* 203 */         this.field_70159_w *= this.field_70146_Z.nextFloat() * 0.2F;
/* 204 */         this.field_70181_x *= this.field_70146_Z.nextFloat() * 0.2F;
/* 205 */         this.field_70179_y *= this.field_70146_Z.nextFloat() * 0.2F;
/* 206 */         this.ticksInGround = 0;
/* 207 */         this.ticksInAir = 0;
/*     */       }
/*     */     } else {
/* 210 */       this.ticksInAir += 1;
/* 211 */       Vec3 vec3 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 212 */       Vec3 vec31 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 213 */       MovingObjectPosition movingobjectposition = this.field_70170_p.func_72831_a(vec3, vec31, false, true);
/* 214 */       vec3 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 215 */       vec31 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/*     */       
/* 217 */       if (movingobjectposition != null) {
/* 218 */         vec31 = this.field_70170_p.func_82732_R().func_72345_a(movingobjectposition.field_72307_f.field_72450_a, movingobjectposition.field_72307_f.field_72448_b, movingobjectposition.field_72307_f.field_72449_c);
/*     */       }
/*     */       
/* 221 */       Entity entity = null;
/* 222 */       List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0D, 1.0D, 1.0D));
/* 223 */       double d0 = 0.0D;
/*     */       
/*     */ 
/*     */ 
/* 227 */       for (int l = 0; l < list.size(); l++) {
/* 228 */         Entity entity1 = (Entity)list.get(l);
/*     */         
/* 230 */         if ((entity1.func_70067_L()) && ((entity1 != this.field_70250_c) || (this.ticksInAir >= 5))) {
/* 231 */           float f1 = 0.3F;
/* 232 */           AxisAlignedBB axisalignedbb1 = entity1.field_70121_D.func_72314_b(f1, f1, f1);
/* 233 */           MovingObjectPosition movingobjectposition1 = axisalignedbb1.func_72327_a(vec3, vec31);
/*     */           
/* 235 */           if (movingobjectposition1 != null) {
/* 236 */             double d1 = vec3.func_72438_d(movingobjectposition1.field_72307_f);
/*     */             
/* 238 */             if ((d1 < d0) || (d0 == 0.0D)) {
/* 239 */               entity = entity1;
/* 240 */               d0 = d1;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 246 */       if (entity != null) {
/* 247 */         movingobjectposition = new MovingObjectPosition(entity);
/*     */       }
/*     */       
/* 250 */       if ((movingobjectposition != null) && (movingobjectposition.field_72308_g != null) && ((movingobjectposition.field_72308_g instanceof EntityPlayer))) {
/* 251 */         EntityPlayer entityplayer = (EntityPlayer)movingobjectposition.field_72308_g;
/*     */         
/* 253 */         if ((entityplayer.field_71075_bZ.field_75102_a) || (((this.field_70250_c instanceof EntityPlayer)) && (!((EntityPlayer)this.field_70250_c).func_96122_a(entityplayer)))) {
/* 254 */           movingobjectposition = null;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 261 */       if (movingobjectposition != null) {
/* 262 */         if (movingobjectposition.field_72308_g != null) {
/* 263 */           float f2 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
/* 264 */           float dam = (float)func_70242_d();
/* 265 */           if (isJavelin()) {
/* 266 */             dam = (float)Math.ceil(f2 * this.damage);
/*     */           }
/*     */           
/* 269 */           DamageSource damagesource = null;
/*     */           
/* 271 */           if (this.field_70250_c == null) {
/* 272 */             damagesource = DamageSource.func_76356_a(this, this);
/*     */           } else {
/* 274 */             damagesource = DamageSource.func_76356_a(this, this.field_70250_c);
/*     */           }
/*     */           
/* 277 */           if ((func_70027_ad()) && (!(movingobjectposition.field_72308_g instanceof EntityEnderman))) {
/* 278 */             movingobjectposition.field_72308_g.func_70015_d(5);
/*     */           }
/* 280 */           dam = modifyDamage(movingobjectposition.field_72308_g, dam);
/*     */           
/* 282 */           if (movingobjectposition.field_72308_g.func_70097_a(damagesource, dam)) {
/* 283 */             applySpecials(movingobjectposition.field_72308_g);
/* 284 */             if ((movingobjectposition.field_72308_g instanceof EntityLivingBase)) {
/* 285 */               EntityLivingBase entitylivingbase = (EntityLivingBase)movingobjectposition.field_72308_g;
/*     */               
/* 287 */               if (!this.field_70170_p.field_72995_K) {
/* 288 */                 entitylivingbase.func_85034_r(entitylivingbase.func_85035_bI() + 1);
/*     */               }
/*     */               
/* 291 */               float kb = this.knockbackStrength;
/* 292 */               if ((movingobjectposition.field_72308_g instanceof EntityLivingBase)) {
/* 293 */                 kb = modifyKnockback((EntityLivingBase)movingobjectposition.field_72308_g, kb);
/*     */               }
/* 295 */               if (kb > 0.0F) {
/* 296 */                 float f3 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/*     */                 
/* 298 */                 if (f3 > 0.0F) {
/* 299 */                   movingobjectposition.field_72308_g.func_70024_g(this.field_70159_w * kb * 0.6000000238418579D / f3, 0.1D, this.field_70179_y * kb * 0.6000000238418579D / f3);
/*     */                 }
/*     */               }
/*     */               
/* 303 */               if (this.field_70250_c != null) {
/* 304 */                 net.minecraft.enchantment.EnchantmentThorns.func_92096_a(this.field_70250_c, entitylivingbase, this.field_70146_Z);
/*     */               }
/*     */               
/* 307 */               if ((this.field_70250_c != null) && (movingobjectposition.field_72308_g != this.field_70250_c) && ((movingobjectposition.field_72308_g instanceof EntityPlayer)) && ((this.field_70250_c instanceof EntityPlayerMP))) {
/* 308 */                 ((EntityPlayerMP)this.field_70250_c).field_71135_a.func_72567_b(new Packet70GameEvent(6, 0));
/*     */               }
/*     */             }
/*     */             
/* 312 */             func_85030_a("random.bowhit", 1.0F, 1.2F / (this.field_70146_Z.nextFloat() * 0.2F + 0.9F));
/*     */             
/* 314 */             if (!(movingobjectposition.field_72308_g instanceof EntityEnderman)) {
/* 315 */               damageSpear();
/*     */             }
/*     */           } else {
/* 318 */             this.field_70159_w = 0.0D;
/* 319 */             this.field_70181_x = 0.0D;
/* 320 */             this.field_70179_y = 0.0D;
/* 321 */             this.field_70177_z += 180.0F;
/* 322 */             this.field_70126_B += 180.0F;
/* 323 */             this.ticksInAir = 0;
/*     */           }
/*     */         } else {
/* 326 */           this.xTile = movingobjectposition.field_72311_b;
/* 327 */           this.yTile = movingobjectposition.field_72312_c;
/* 328 */           this.zTile = movingobjectposition.field_72309_d;
/* 329 */           this.inTile = this.field_70170_p.func_72798_a(this.xTile, this.yTile, this.zTile);
/* 330 */           this.inData = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
/* 331 */           this.field_70159_w = ((float)(movingobjectposition.field_72307_f.field_72450_a - this.field_70165_t));
/* 332 */           this.field_70181_x = ((float)(movingobjectposition.field_72307_f.field_72448_b - this.field_70163_u));
/* 333 */           this.field_70179_y = ((float)(movingobjectposition.field_72307_f.field_72449_c - this.field_70161_v));
/* 334 */           float f2 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
/* 335 */           this.field_70165_t -= this.field_70159_w / f2 * 0.05000000074505806D;
/* 336 */           this.field_70163_u -= this.field_70181_x / f2 * 0.05000000074505806D;
/* 337 */           this.field_70161_v -= this.field_70179_y / f2 * 0.05000000074505806D;
/* 338 */           func_85030_a("random.bowhit", 1.0F, 1.2F / (this.field_70146_Z.nextFloat() * 0.2F + 0.9F));
/* 339 */           this.inGround = true;
/* 340 */           this.field_70249_b = 7;
/* 341 */           func_70243_d(false);
/*     */           
/* 343 */           if (this.inTile != 0) {
/* 344 */             Block.field_71973_m[this.inTile].func_71869_a(this.field_70170_p, this.xTile, this.yTile, this.zTile, this);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 349 */       if (func_70241_g()) {
/* 350 */         for (l = 0; l < 4; l++) {
/* 351 */           this.field_70170_p.func_72869_a("crit", this.field_70165_t + this.field_70159_w * l / 4.0D, this.field_70163_u + this.field_70181_x * l / 4.0D, this.field_70161_v + this.field_70179_y * l / 4.0D, -this.field_70159_w, -this.field_70181_x + 0.2D, -this.field_70179_y);
/*     */         }
/*     */       }
/*     */       
/* 355 */       this.field_70165_t += this.field_70159_w;
/* 356 */       this.field_70163_u += this.field_70181_x;
/* 357 */       this.field_70161_v += this.field_70179_y;
/* 358 */       float f2 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 359 */       this.field_70177_z = ((float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / 3.141592653589793D));
/*     */       
/* 361 */       for (this.field_70125_A = ((float)(Math.atan2(this.field_70181_x, f2) * 180.0D / 3.141592653589793D)); this.field_70125_A - this.field_70127_C < -180.0F; this.field_70127_C -= 360.0F) {}
/*     */       
/*     */ 
/*     */ 
/* 365 */       while (this.field_70125_A - this.field_70127_C >= 180.0F) {
/* 366 */         this.field_70127_C += 360.0F;
/*     */       }
/*     */       
/* 369 */       while (this.field_70177_z - this.field_70126_B < -180.0F) {
/* 370 */         this.field_70126_B -= 360.0F;
/*     */       }
/*     */       
/* 373 */       while (this.field_70177_z - this.field_70126_B >= 180.0F) {
/* 374 */         this.field_70126_B += 360.0F;
/*     */       }
/*     */       
/* 377 */       this.field_70125_A = (this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2F);
/* 378 */       this.field_70177_z = (this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2F);
/* 379 */       float f4 = 0.99F;
/* 380 */       float f1 = 0.05F;
/*     */       
/* 382 */       if (func_70090_H()) {
/* 383 */         for (int j1 = 0; j1 < 4; j1++) {
/* 384 */           float f3 = 0.25F;
/* 385 */           this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * f3, this.field_70163_u - this.field_70181_x * f3, this.field_70161_v - this.field_70179_y * f3, this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */         }
/*     */         
/* 388 */         f4 = 0.8F;
/*     */       }
/*     */       
/* 391 */       this.field_70159_w *= f4;
/* 392 */       this.field_70181_x *= f4;
/* 393 */       this.field_70179_y *= f4;
/* 394 */       this.field_70181_x -= f1;
/* 395 */       func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 396 */       func_70017_D();
/*     */     }
/* 398 */     if (this.field_70173_aa % 20 == 0) {
/* 399 */       syncSpear();
/*     */     }
/* 401 */     if ((this.field_70173_aa <= 10) && (!this.field_70170_p.field_72995_K)) {
/* 402 */       sendTrackerPacket();
/*     */     }
/*     */   }
/*     */   
/*     */   private float modifyKnockback(EntityLivingBase entityHit, float kb) {
/* 407 */     if (getSpear() != null) {
/* 408 */       int mod = 1 + EnchantmentHelper.func_77506_a(Enchantment.field_77338_j.field_77352_x, getSpear());
/* 409 */       return kb * mod;
/*     */     }
/* 411 */     return kb;
/*     */   }
/*     */   
/*     */   private float modifyDamage(Entity entityHit, float dam) {
/* 415 */     EntityLivingBase hit = null;
/* 416 */     if ((entityHit instanceof EntityLivingBase)) {
/* 417 */       hit = (EntityLivingBase)entityHit;
/*     */     }
/*     */     
/* 420 */     if (getSpear() == null) {
/* 421 */       return dam;
/*     */     }
/* 423 */     ItemStack weapon = getSpear();
/*     */     
/* 425 */     return modifyDamLiving(weapon, hit, dam);
/*     */   }
/*     */   
/*     */   private void applySpecials(Entity entityHit) {
/* 429 */     EntityLivingBase hit = null;
/* 430 */     if ((entityHit instanceof EntityLivingBase)) {
/* 431 */       hit = (EntityLivingBase)entityHit;
/*     */     }
/*     */     
/* 434 */     if (getSpear() == null) {
/* 435 */       return;
/*     */     }
/* 437 */     ItemStack weapon = getSpear();
/*     */     
/* 439 */     hitLiving(weapon, hit);
/*     */   }
/*     */   
/*     */   private void hitLiving(ItemStack weapon, EntityLivingBase target) {
/* 443 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/* 444 */       target.func_70015_d(20);
/*     */     }
/*     */     
/* 447 */     if ((getMaterial() == ToolMaterialMedieval.IGNOTUMITE) && 
/* 448 */       ((target instanceof EntityLiving))) {
/* 449 */       PotionEffect poison = new PotionEffect(Potion.field_76436_u.field_76415_H, 100, 1);
/* 450 */       ((EntityLiving)target).func_70690_d(poison);
/*     */     }
/*     */     
/*     */ 
/* 454 */     if ((getMaterial() == ToolMaterialMedieval.ORNATE) && 
/* 455 */       ((target instanceof EntityLiving))) {
/* 456 */       if (((EntityLiving)target).func_70668_bt() == EnumCreatureAttribute.UNDEAD) {
/* 457 */         target.func_70015_d(20);
/* 458 */         int hurt = target.field_70172_ad;
/* 459 */         target.field_70172_ad = 0;
/* 460 */         target.func_70097_a(DamageSource.field_76377_j, (float)this.damage);
/* 461 */         target.field_70172_ad = hurt;
/* 462 */         target.field_70170_p.func_72956_a(target, "random.fizz", 1.0F, 1.0F);
/*     */       }
/* 464 */       if (((EntityLiving)target).getClass().getName().endsWith("MoCEntityWarewolf")) {
/* 465 */         target.func_70015_d(20);
/* 466 */         int hurt = target.field_70172_ad;
/* 467 */         target.field_70172_ad = 0;
/* 468 */         target.func_70097_a(DamageSource.field_76377_j, (float)this.damage * 10.0F);
/* 469 */         target.field_70172_ad = hurt;
/* 470 */         target.field_70170_p.func_72956_a(target, "random.fizz", 1.0F, 1.0F);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 475 */     int fire = EnchantmentHelper.func_77506_a(Enchantment.field_77334_n.field_77352_x, weapon);
/* 476 */     if (fire > 0) {
/* 477 */       target.func_70015_d(20 * fire);
/*     */     }
/*     */   }
/*     */   
/*     */   private float modifyDamLiving(ItemStack weapon, EntityLivingBase target, float dam) {
/* 482 */     float sharp = EnchantmentHelper.func_77506_a(Enchantment.field_77338_j.field_77352_x, weapon);
/* 483 */     float spider = EnchantmentHelper.func_77506_a(Enchantment.field_77336_l.field_77352_x, weapon);
/* 484 */     float smite = EnchantmentHelper.func_77506_a(Enchantment.field_77339_k.field_77352_x, weapon);
/*     */     
/* 486 */     if ((!this.field_70170_p.field_72995_K) && (MineFantasyBase.isDebug())) {
/* 487 */       System.out.println("Start " + dam);
/*     */     }
/*     */     
/* 490 */     if (sharp > 0.0F) {
/* 491 */       dam += sharp * 1.25F;
/*     */       
/* 493 */       if ((!this.field_70170_p.field_72995_K) && (MineFantasyBase.isDebug())) {
/* 494 */         System.out.println("Sharpness " + sharp * 1.25F);
/*     */       }
/*     */     }
/* 497 */     if ((spider > 0.0F) && (target.func_70668_bt() == EnumCreatureAttribute.ARTHROPOD)) {
/* 498 */       dam += spider * 2.5F;
/*     */       
/* 500 */       if ((!this.field_70170_p.field_72995_K) && (MineFantasyBase.isDebug())) {
/* 501 */         System.out.println("Bane " + spider * 2.5F);
/*     */       }
/*     */     }
/* 504 */     if ((smite > 0.0F) && (target.func_70668_bt() == EnumCreatureAttribute.UNDEAD)) {
/* 505 */       dam += smite * 2.5F;
/*     */       
/* 507 */       if ((!this.field_70170_p.field_72995_K) && (MineFantasyBase.isDebug())) {
/* 508 */         System.out.println("Smite " + smite * 2.5F);
/*     */       }
/*     */     }
/*     */     
/* 512 */     if ((!this.field_70170_p.field_72995_K) && (MineFantasyBase.isDebug())) {
/* 513 */       System.out.println("End " + dam);
/*     */     }
/*     */     
/* 516 */     return dam;
/*     */   }
/*     */   
/*     */   private EnumToolMaterial getMaterial() {
/* 520 */     if ((getSpear().func_77973_b() instanceof ItemSpearMF)) {
/* 521 */       return ((ItemSpearMF)getSpear().func_77973_b()).getMaterial();
/*     */     }
/* 523 */     return EnumToolMaterial.STONE;
/*     */   }
/*     */   
/*     */   private void damageSpear() {
/* 527 */     ItemStack wep = getSpear();
/* 528 */     if (wep != null) {
/* 529 */       if (isJavelin()) {
/* 530 */         if (this.field_70146_Z.nextInt(10) == 0) {
/* 531 */           func_70106_y();
/*     */         }
/*     */       } else {
/* 534 */         if ((this.field_70250_c instanceof EntityLivingBase)) {
/* 535 */           wep.func_77972_a(1, (EntityLivingBase)this.field_70250_c);
/*     */         } else {
/* 537 */           wep.func_96631_a(1, this.field_70146_Z);
/*     */         }
/* 539 */         if (wep.func_77960_j() > wep.func_77958_k()) {
/* 540 */           func_70106_y();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void syncSpear()
/*     */   {
/* 548 */     if (!this.field_70170_p.field_72995_K) {
/*     */       try {
/* 550 */         Packet packet = PacketManagerMF.getPacketItemStackArray(this, 0, getSpear());
/* 551 */         PacketDispatcher.sendPacketToAllPlayers(packet);
/*     */       }
/*     */       catch (Exception localException) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public void sendTrackerPacket() {
/*     */     try {
/* 559 */       Packet packet = PacketManagerMF.getEntityPacketDoubleArray(this, new double[] { this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70159_w, this.field_70181_x, this.field_70179_y, this.field_70125_A, this.field_70177_z, this.field_70127_C, this.field_70126_B });
/* 560 */       FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*     */     }
/*     */     catch (NullPointerException localNullPointerException) {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_70014_b(NBTTagCompound nbt)
/*     */   {
/* 570 */     nbt.func_74777_a("xTile", (short)this.xTile);
/* 571 */     nbt.func_74777_a("yTile", (short)this.yTile);
/* 572 */     nbt.func_74777_a("zTile", (short)this.zTile);
/* 573 */     nbt.func_74774_a("inTile", (byte)this.inTile);
/* 574 */     nbt.func_74774_a("inData", (byte)this.inData);
/* 575 */     nbt.func_74774_a("shake", (byte)this.field_70249_b);
/* 576 */     nbt.func_74774_a("inGround", (byte)(this.inGround ? 1 : 0));
/* 577 */     nbt.func_74774_a("pickup", (byte)this.field_70251_a);
/* 578 */     nbt.func_74780_a("damage", this.damage);
/*     */     
/* 580 */     if (getSpear() != null) {
/* 581 */       NBTTagCompound itemNBT = new NBTTagCompound();
/*     */       
/* 583 */       getSpear().func_77955_b(itemNBT);
/* 584 */       nbt.func_74766_a("Spear", itemNBT);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70037_a(NBTTagCompound nbt)
/*     */   {
/* 592 */     this.xTile = nbt.func_74765_d("xTile");
/* 593 */     this.yTile = nbt.func_74765_d("yTile");
/* 594 */     this.zTile = nbt.func_74765_d("zTile");
/* 595 */     this.inTile = (nbt.func_74771_c("inTile") & 0xFF);
/* 596 */     this.inData = (nbt.func_74771_c("inData") & 0xFF);
/* 597 */     this.field_70249_b = (nbt.func_74771_c("shake") & 0xFF);
/* 598 */     this.inGround = (nbt.func_74771_c("inGround") == 1);
/*     */     
/* 600 */     if (nbt.func_74764_b("damage")) {
/* 601 */       this.damage = nbt.func_74769_h("damage");
/*     */     }
/*     */     
/* 604 */     if (nbt.func_74764_b("pickup")) {
/* 605 */       this.field_70251_a = nbt.func_74771_c("pickup");
/* 606 */     } else if (nbt.func_74764_b("player")) {
/* 607 */       this.field_70251_a = (nbt.func_74767_n("player") ? 1 : 0);
/*     */     }
/* 609 */     if (nbt.func_74764_b("Spear")) {
/* 610 */       NBTTagCompound itemNBT = nbt.func_74775_l("Spear");
/*     */       
/* 612 */       setSpear(ItemStack.func_77949_a(itemNBT));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70100_b_(EntityPlayer par1EntityPlayer)
/*     */   {
/* 620 */     if ((!this.field_70170_p.field_72995_K) && (this.inGround) && (this.field_70249_b <= 0)) {
/* 621 */       boolean flag = (this.field_70251_a == 1) || ((this.field_70251_a == 2) && (par1EntityPlayer.field_71075_bZ.field_75098_d));
/*     */       
/* 623 */       if ((getSpear() != null) && (this.field_70251_a == 1) && (!par1EntityPlayer.field_71071_by.func_70441_a(getSpear()))) {
/* 624 */         flag = false;
/*     */       }
/*     */       
/* 627 */       if (flag) {
/* 628 */         func_85030_a("random.pop", 0.2F, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7F + 1.0F) * 2.0F);
/* 629 */         par1EntityPlayer.func_71001_a(this, 1);
/* 630 */         func_70106_y();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean func_70041_e_()
/*     */   {
/* 640 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 645 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public void func_70239_b(double par1) {
/* 649 */     this.damage = par1;
/*     */   }
/*     */   
/*     */   public double func_70242_d() {
/* 653 */     return this.damage;
/*     */   }
/*     */   
/*     */   public boolean isJavelin() {
/* 657 */     if ((getSpear() != null) && (!getSpear().func_77984_f())) {
/* 658 */       return true;
/*     */     }
/* 660 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70240_a(int par1)
/*     */   {
/* 667 */     this.knockbackStrength = par1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean func_70075_an()
/*     */   {
/* 674 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_70243_d(boolean par1)
/*     */   {
/* 682 */     byte b0 = this.field_70180_af.func_75683_a(16);
/*     */     
/* 684 */     if (par1) {
/* 685 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(b0 | 0x1)));
/*     */     } else {
/* 687 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(b0 & 0xFFFFFFFE)));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_70241_g()
/*     */   {
/* 696 */     byte b0 = this.field_70180_af.func_75683_a(16);
/* 697 */     return (b0 & 0x1) != 0;
/*     */   }
/*     */   
/*     */   public EntityThrownSpear setSpear(ItemStack item) {
/* 701 */     this.spearItem = item;
/* 702 */     syncSpear();
/* 703 */     return this;
/*     */   }
/*     */   
/*     */   public ItemStack getSpear() {
/* 707 */     return this.spearItem;
/*     */   }
/*     */   
/*     */   public void setItem(ItemStack item, int slot)
/*     */   {
/* 712 */     if (this.field_70170_p.field_72995_K) {
/* 713 */       setSpear(item);
/*     */     }
/*     */   }
/*     */   
/*     */   public ItemStack getRenderItem()
/*     */   {
/* 719 */     return getSpear();
/*     */   }
/*     */   
/*     */   public int getSpin()
/*     */   {
/* 724 */     return 0;
/*     */   }
/*     */   
/*     */   public int getRotate()
/*     */   {
/* 729 */     return 0;
/*     */   }
/*     */   
/*     */   public float getScale()
/*     */   {
/* 734 */     return 2.0F;
/*     */   }
/*     */   
/*     */   public boolean isEnchanted()
/*     */   {
/* 739 */     return getSpear() != null ? getSpear().func_77948_v() : false;
/*     */   }
/*     */   
/*     */   public void recievePacket(ByteArrayDataInput data)
/*     */   {
/* 744 */     this.field_70165_t = data.readDouble();
/* 745 */     this.field_70163_u = data.readDouble();
/* 746 */     this.field_70161_v = data.readDouble();
/*     */     
/* 748 */     this.field_70159_w = data.readDouble();
/* 749 */     this.field_70181_x = data.readDouble();
/* 750 */     this.field_70179_y = data.readDouble();
/*     */     
/* 752 */     this.field_70125_A = ((float)data.readDouble());
/* 753 */     this.field_70177_z = ((float)data.readDouble());
/* 754 */     this.field_70127_C = ((float)data.readDouble());
/* 755 */     this.field_70126_B = ((float)data.readDouble());
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/EntityThrownSpear.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */