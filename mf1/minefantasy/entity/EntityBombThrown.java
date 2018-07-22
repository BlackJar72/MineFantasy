/*     */ package minefantasy.entity;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import minefantasy.api.weapon.EntityDamageSourceBomb;
/*     */ import minefantasy.item.ItemBombMF;
/*     */ import minefantasy.system.cfg;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockFire;
/*     */ import net.minecraft.entity.DataWatcher;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityBombThrown
/*     */   extends EntityThrowableBounce
/*     */   implements IBomb
/*     */ {
/*  40 */   private int ticksRemaining = 60;
/*  41 */   private float bounce = 0.8F;
/*     */   private EntityLivingBase thrower;
/*     */   
/*     */   public EntityBombThrown(World world) {
/*  45 */     super(world);
/*     */   }
/*     */   
/*     */   public EntityBombThrown(World world, EntityLivingBase entity) {
/*  49 */     super(world, entity);
/*  50 */     this.thrower = entity;
/*     */   }
/*     */   
/*     */   public EntityBombThrown(World world, EntityLivingBase entity, int fuse, int id) {
/*  54 */     this(world, entity);
/*  55 */     setID(id);
/*     */   }
/*     */   
/*     */ 
/*     */   protected float getGravityVelocity()
/*     */   {
/*  61 */     return 0.15F;
/*     */   }
/*     */   
/*     */   public EntityBombThrown(World world, double x, double y, double z, int fuse) {
/*  65 */     super(world, x, y, z);
/*  66 */     this.ticksRemaining = fuse;
/*     */   }
/*     */   
/*     */   public EntityBombThrown(World world, EntityLivingBase shooter, EntityLivingBase target, float power, float precision) {
/*  70 */     super(world, shooter);
/*  71 */     this.field_70155_l = 10.0D;
/*  72 */     this.thrower = shooter;
/*     */     
/*  74 */     this.field_70163_u = (shooter.field_70163_u + shooter.func_70047_e() - 0.10000000149011612D);
/*  75 */     double var6 = target.field_70165_t - shooter.field_70165_t;
/*  76 */     double var8 = target.field_70163_u + target.func_70047_e() - 3.499999888241293D * getArc() - this.field_70163_u;
/*  77 */     double var10 = target.field_70161_v - shooter.field_70161_v;
/*  78 */     double var12 = MathHelper.func_76133_a(var6 * var6 + var10 * var10);
/*     */     
/*  80 */     if (var12 >= 1.0E-7D) {
/*  81 */       float var14 = (float)(Math.atan2(var10, var6) * 180.0D / 3.141592653589793D) - 90.0F;
/*  82 */       float var15 = (float)-(Math.atan2(var8, var12) * 180.0D / 3.141592653589793D);
/*  83 */       double var16 = var6 / var12;
/*  84 */       double var18 = var10 / var12;
/*  85 */       func_70012_b(shooter.field_70165_t + var16, this.field_70163_u, shooter.field_70161_v + var18, var14, var15);
/*  86 */       this.field_70129_M = 0.0F;
/*  87 */       float var20 = (float)var12 * getArc();
/*  88 */       func_70186_c(var6, var8 + var20, var10, power, precision);
/*     */     }
/*     */   }
/*     */   
/*     */   private float getArc() {
/*  93 */     return getGravityVelocity() * 4.0F;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public EntityBombThrown shrapnel()
/*     */   {
/* 100 */     setID(0);
/* 101 */     return this;
/*     */   }
/*     */   
/*     */   public void func_70088_a()
/*     */   {
/* 106 */     super.func_70088_a();
/* 107 */     this.field_70180_af.func_75682_a(2, Byte.valueOf((byte)0));
/* 108 */     this.field_70180_af.func_75682_a(3, Integer.valueOf(1));
/* 109 */     this.field_70180_af.func_75682_a(4, Integer.valueOf(0));
/*     */   }
/*     */   
/*     */   public boolean getIsShrapnel() {
/* 113 */     return this.field_70180_af.func_75683_a(2) != 0;
/*     */   }
/*     */   
/*     */   public void func_70071_h_()
/*     */   {
/* 118 */     this.field_70170_p.func_72869_a("smoke", this.field_70165_t, this.field_70163_u, this.field_70161_v, -this.field_70159_w, -this.field_70181_x, -this.field_70179_y);
/* 119 */     super.func_70071_h_();
/* 120 */     this.ticksRemaining -= 1;
/* 121 */     if (this.ticksRemaining <= 0) {
/* 122 */       explode(new MovingObjectPosition(this));
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70014_b(NBTTagCompound nbt) {
/* 127 */     nbt.func_74776_a("Bounce", this.bounce);
/* 128 */     nbt.func_74768_a("Ticks", this.ticksRemaining);
/* 129 */     nbt.func_74768_a("ID", getID());
/*     */   }
/*     */   
/*     */   public void func_70037_a(NBTTagCompound nbt) {
/* 133 */     setID(nbt.func_74762_e("ID"));
/* 134 */     this.bounce = nbt.func_74760_g("Bounce");
/* 135 */     this.ticksRemaining = nbt.func_74762_e("Ticks");
/*     */   }
/*     */   
/*     */   public void explode(MovingObjectPosition pos)
/*     */   {
/* 140 */     this.field_70170_p.func_72956_a(this, "random.explode", 0.3F, 5.0F);
/* 141 */     this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0F, false);
/* 142 */     if (!this.field_70170_p.field_72995_K) {
/* 143 */       double area = 4.0D;
/* 144 */       AxisAlignedBB var3 = this.field_70121_D.func_72314_b(area, area / 2.0D, area);
/* 145 */       List var4 = this.field_70170_p.func_72872_a(EntityLivingBase.class, var3);
/*     */       
/* 147 */       if ((var4 != null) && (!var4.isEmpty())) {
/* 148 */         Iterator var5 = var4.iterator();
/*     */         
/* 150 */         while (var5.hasNext()) {
/* 151 */           Entity var6 = (Entity)var5.next();
/* 152 */           double var7 = func_70068_e(var6);
/*     */           
/* 154 */           double radius = getRadius();
/* 155 */           if (var7 < radius) {
/* 156 */             applyEffects(var6);
/*     */             
/* 158 */             int dam = getDamage();
/*     */             
/* 160 */             if (var7 < radius / 2.0D) {
/* 161 */               double sc = radius / 2.0D - var7;
/* 162 */               if (sc < 0.0D)
/* 163 */                 sc = 0.0D;
/* 164 */               if (sc > radius / 2.0D)
/* 165 */                 sc = radius;
/* 166 */               dam = (int)(dam * (1.0D + 0.5D / (radius / 2.0D) * sc));
/*     */             }
/* 168 */             if (!(var6 instanceof EntityItem)) {
/* 169 */               DamageSource source = causeBombDamage(this, this);
/* 170 */               if (this.thrower != null) {
/* 171 */                 source = causeBombDamage(this, this.thrower);
/*     */               }
/* 173 */               source.func_94540_d();
/* 174 */               if (canEntityBeSeen(var6)) {
/* 175 */                 var6.func_70097_a(source, dam);
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/* 181 */       if (getID() == 0) {
/* 182 */         for (int shards = 0; shards < 32; shards++) {
/* 183 */           EntityShrapnel shrapnel = new EntityShrapnel(this.thrower, this.field_70170_p, this.field_70165_t, this.field_70163_u + 0.5D, this.field_70161_v);
/* 184 */           shrapnel.field_70251_a = 0;
/* 185 */           shrapnel.field_70173_aa = 20;
/*     */           
/* 187 */           float range = 0.6F;
/* 188 */           shrapnel.func_70016_h((this.field_70146_Z.nextDouble() - 0.5D) * range, this.field_70146_Z.nextDouble() * (range / 2.0F), (this.field_70146_Z.nextDouble() - 0.5D) * range);
/* 189 */           shrapnel.func_70239_b(5.0D);
/* 190 */           this.field_70170_p.func_72838_d(shrapnel);
/*     */         }
/*     */       }
/*     */       
/* 194 */       if (getID() == 1)
/*     */       {
/* 196 */         startFire(pos);
/*     */       }
/* 198 */       func_70106_y();
/*     */     }
/*     */   }
/*     */   
/*     */   private void applyEffects(Entity hit) {
/* 203 */     EntityLivingBase live = null;
/* 204 */     if ((hit instanceof EntityLivingBase)) {
/* 205 */       live = (EntityLivingBase)hit;
/*     */     }
/*     */     
/* 208 */     if (getID() == 1)
/*     */     {
/* 210 */       hit.func_70015_d(20);
/*     */     }
/* 212 */     if ((getID() == 2) && (live != null))
/*     */     {
/* 214 */       live.func_70690_d(new PotionEffect(Potion.field_76436_u.field_76415_H, 100, 0));
/*     */     }
/* 216 */     if ((getID() == 3) && (live != null))
/*     */     {
/* 218 */       live.func_70690_d(new PotionEffect(Potion.field_76431_k.field_76415_H, 400, 1));
/* 219 */       live.func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 400, 1));
/*     */     }
/*     */   }
/*     */   
/*     */   private double getRadius() {
/* 224 */     return 16.0D;
/*     */   }
/*     */   
/*     */   private int getDamage() {
/* 228 */     switch (getID()) {
/*     */     case 0: 
/* 230 */       return 18;
/*     */     case 1: 
/* 232 */       return 4;
/*     */     case 2: 
/* 234 */       return 4;
/*     */     case 3: 
/* 236 */       return 4;
/*     */     }
/* 238 */     return 4;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private int getID()
/*     */   {
/* 245 */     return this.field_70180_af.func_75679_c(4);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public EntityBombThrown setID(int id)
/*     */   {
/* 252 */     this.field_70180_af.func_75692_b(4, Integer.valueOf(id));
/* 253 */     return this;
/*     */   }
/*     */   
/*     */   public float getResistance()
/*     */   {
/* 258 */     return this.bounce;
/*     */   }
/*     */   
/*     */   public int getFuseTime()
/*     */   {
/* 263 */     return 30;
/*     */   }
/*     */   
/*     */   public void bounce(MovingObjectPosition pos)
/*     */   {
/* 268 */     super.bounce(pos);
/* 269 */     if (this.bounce > 0.0F) {
/* 270 */       this.bounce -= 0.1F;
/*     */     }
/*     */   }
/*     */   
/*     */   public Icon getIcon() {
/* 275 */     if (getID() >= ItemBombMF.icons.length) {
/* 276 */       return ItemBombMF.icons[(ItemBombMF.icons.length - 1)];
/*     */     }
/* 278 */     return ItemBombMF.icons[getID()];
/*     */   }
/*     */   
/*     */   public boolean func_70067_L() {
/* 282 */     return !this.field_70128_L;
/*     */   }
/*     */   
/*     */   public boolean shouldBreakBlock(Block block)
/*     */   {
/* 287 */     return false;
/*     */   }
/*     */   
/*     */   public static DamageSource causeBombDamage(Entity bomb, Entity user) {
/* 291 */     return new EntityDamageSourceBomb(bomb, user).func_76349_b();
/*     */   }
/*     */   
/*     */   public boolean canEntityBeSeen(Entity entity) {
/* 295 */     return this.field_70170_p.func_72933_a(this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t, this.field_70163_u + func_70047_e(), this.field_70161_v), this.field_70170_p.func_82732_R().func_72345_a(entity.field_70165_t, entity.field_70163_u + entity.func_70047_e(), entity.field_70161_v)) == null;
/*     */   }
/*     */   
/*     */   private void startFire(MovingObjectPosition pos) {
/* 299 */     if (cfg.disableFirebomb) {
/* 300 */       return;
/*     */     }
/* 302 */     if (!this.field_70170_p.field_72995_K) {
/* 303 */       if (this.field_70170_p.func_72799_c((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v)) {
/* 304 */         this.field_70170_p.func_72832_d((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, Block.field_72067_ar.field_71990_ca, 0, 3);
/*     */       }
/*     */       
/* 307 */       int r = 3;
/* 308 */       for (int x = -r; x < r; x++) {
/* 309 */         for (int y = -r; y < r; y++) {
/* 310 */           for (int z = -r; z < r; z++) {
/* 311 */             if ((this.field_70146_Z.nextInt(5) == 0) && (this.field_70170_p.func_72799_c((int)this.field_70165_t + x, (int)this.field_70163_u + y, (int)this.field_70161_v + z))) {
/* 312 */               this.field_70170_p.func_72832_d((int)this.field_70165_t + x, (int)this.field_70163_u + y, (int)this.field_70161_v + z, Block.field_72067_ar.field_71990_ca, 0, 3);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/EntityBombThrown.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */