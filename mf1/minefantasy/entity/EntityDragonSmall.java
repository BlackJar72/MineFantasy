/*      */ package minefantasy.entity;
/*      */ 
/*      */ import java.io.PrintStream;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import minefantasy.MineFantasyBase;
/*      */ import minefantasy.item.ItemListMF;
/*      */ import minefantasy.system.AchivementMF;
/*      */ import minefantasy.system.EntityDamageSourceAP;
/*      */ import minefantasy.system.MFResource;
/*      */ import minefantasy.system.TacticalManager;
/*      */ import minefantasy.system.cfg;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.block.material.Material;
/*      */ import net.minecraft.entity.DataWatcher;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.SharedMonsterAttributes;
/*      */ import net.minecraft.entity.ai.EntityJumpHelper;
/*      */ import net.minecraft.entity.ai.attributes.AttributeInstance;
/*      */ import net.minecraft.entity.item.EntityItem;
/*      */ import net.minecraft.entity.monster.EntitySkeleton;
/*      */ import net.minecraft.entity.monster.IMob;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.entity.player.PlayerCapabilities;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.pathfinding.PathNavigate;
/*      */ import net.minecraft.potion.Potion;
/*      */ import net.minecraft.util.AABBPool;
/*      */ import net.minecraft.util.AxisAlignedBB;
/*      */ import net.minecraft.util.ChunkCoordinates;
/*      */ import net.minecraft.util.DamageSource;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.Vec3;
/*      */ import net.minecraft.world.World;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class EntityDragonSmall
/*      */   extends EntityFlyingMob
/*      */   implements IMob
/*      */ {
/*   54 */   private final int baseData = 13;
/*   55 */   public int courseChangeCooldown = 0;
/*      */   public double waypointX;
/*      */   public double waypointY;
/*      */   protected int breed;
/*      */   private Entity prevAttackTarget;
/*      */   public double waypointZ;
/*   61 */   private Entity targetedEntity = null;
/*   62 */   public int wingAngle = 45;
/*      */   
/*      */   public int wingFlap;
/*      */   public int jawMove;
/*      */   public int neckAngle;
/*      */   public boolean isFlying;
/*      */   private int retreatCooldown;
/*      */   public int tailX;
/*      */   public int fireBreathTick;
/*      */   public int groundTick;
/*      */   public int wingTick;
/*      */   public int tailZ;
/*      */   public int armSwing;
/*      */   public int armSwing2;
/*      */   private float moveSpeedOrigin;
/*      */   public int fireBreathCooldown;
/*      */   public int throwCooldown;
/*   79 */   private int aggroCooldown = 0;
/*   80 */   public int prevAttackCounter = 0;
/*   81 */   public int attackCounter = 0;
/*      */   private boolean fast;
/*      */   
/*      */   public EntityDragonSmall(World world) {
/*   85 */     super(world);
/*      */     
/*   87 */     func_70105_a(2.0F, 1.0F);
/*   88 */     this.field_70728_aV = 250;
/*   89 */     this.fireBreathCooldown = 1000;
/*   90 */     this.moveSpeedOrigin = 8.0F;
/*   91 */     func_70661_as().func_75495_e(true);
/*      */   }
/*      */   
/*      */   protected void func_110147_ax()
/*      */   {
/*   96 */     super.func_110147_ax();
/*   97 */     func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(48.0D);
/*   98 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(this.moveSpeedOrigin);
/*   99 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(30.0D);
/*      */   }
/*      */   
/*      */   public boolean isFlying() {
/*  103 */     return true;
/*      */   }
/*      */   
/*      */   public float getSpeedModifier() {
/*  107 */     float mod = 1.0F;
/*  108 */     if (this.fast) {
/*  109 */       mod = 2.0F;
/*      */     }
/*  111 */     if (this.breed == 3) {
/*  112 */       mod *= 2.0F;
/*      */     }
/*  114 */     if (isTerrestrial()) {
/*  115 */       return 2.0F + 1.0F * mod;
/*      */     }
/*  117 */     return mod;
/*      */   }
/*      */   
/*      */   public int func_70658_aO()
/*      */   {
/*  122 */     switch (this.breed) {
/*      */     case 1: 
/*  124 */       return 8;
/*      */     case 2: 
/*  126 */       return 10;
/*      */     case 3: 
/*  128 */       return 15;
/*      */     case 4: 
/*  130 */       return 20;
/*      */     }
/*  132 */     return 10;
/*      */   }
/*      */   
/*      */   protected void func_70088_a()
/*      */   {
/*  137 */     super.func_70088_a();
/*  138 */     this.field_70180_af.func_75682_a(13, new Integer(this.jawMove));
/*  139 */     this.field_70180_af.func_75682_a(14, new Integer(this.groundTick));
/*  140 */     this.field_70180_af.func_75682_a(15, new Integer(this.neckAngle));
/*  141 */     this.field_70180_af.func_75682_a(16, new Integer(this.breed));
/*      */   }
/*      */   
/*      */   public float getMaxHealthOnBreed() {
/*  145 */     switch (this.breed) {
/*      */     case 1: 
/*  147 */       return 80.0F;
/*      */     case 2: 
/*  149 */       return 120.0F;
/*      */     case 3: 
/*  151 */       return 150.0F;
/*      */     case 4: 
/*  153 */       return 200.0F;
/*      */     }
/*  155 */     return 80.0F;
/*      */   }
/*      */   
/*      */   public boolean attackEntityFrom(DamageSource source, int damage)
/*      */   {
/*  160 */     if (source.func_76347_k()) {
/*  161 */       return false;
/*      */     }
/*  163 */     if (source == DamageSource.field_76368_d)
/*  164 */       return false;
/*  165 */     if ((source.func_76346_g() != null) && ((source.func_76346_g() instanceof EntityPlayer)) && 
/*  166 */       ((func_70638_az() == null) || (damage > 16) || ((this.targetedEntity != null) && (!(this.targetedEntity instanceof EntityPlayer)))) && 
/*  167 */       (this.retreatCooldown <= 0)) {
/*  168 */       func_70784_b(source.func_76346_g());
/*      */     }
/*      */     
/*  171 */     if ((source.func_76346_g() != null) && 
/*  172 */       (func_70638_az() == null) && 
/*  173 */       (this.retreatCooldown <= 0)) {
/*  174 */       func_70784_b(source.func_76346_g());
/*      */     }
/*      */     
/*  177 */     if (this.field_70146_Z.nextInt(getDisengageChance()) < damage) {
/*  178 */       if (this.targetedEntity != null) {
/*  179 */         this.prevAttackTarget = this.targetedEntity;
/*      */       }
/*  181 */       this.retreatCooldown = 20;
/*  182 */       this.waypointY = (this.field_70163_u + 16.0D);
/*  183 */       func_70784_b(null);
/*      */     }
/*  185 */     return super.attackEntityFrom(source, damage);
/*      */   }
/*      */   
/*      */   private int getDisengageChance() {
/*  189 */     int d = 100;
/*      */     
/*  191 */     switch (this.breed) {
/*      */     case 1: 
/*  193 */       d = 100;
/*  194 */       break;
/*      */     case 2: 
/*  196 */       d = 300;
/*  197 */       break;
/*      */     case 3: 
/*  199 */       d = 100;
/*  200 */       break;
/*      */     case 4: 
/*  202 */       d = 800;
/*      */     }
/*      */     
/*      */     
/*  206 */     if (this.field_70170_p.field_73013_u == 1)
/*  207 */       return d *= 2;
/*  208 */     if (this.field_70170_p.field_73013_u == 3)
/*  209 */       return d /= 2;
/*  210 */     return d;
/*      */   }
/*      */   
/*      */   public void func_70636_d()
/*      */   {
/*  215 */     super.func_70636_d();
/*  216 */     setStats();
/*  217 */     if (this.retreatCooldown > 0) {
/*  218 */       this.retreatCooldown -= 1;
/*  219 */     } else if (this.prevAttackTarget != null) {
/*  220 */       if ((!calmDown()) || (this.field_70146_Z.nextInt(10) == 0)) {
/*  221 */         func_70784_b(this.prevAttackTarget);
/*      */         
/*  223 */         if (this.field_70146_Z.nextInt(3) == 0) {
/*  224 */           this.fireBreathCooldown = 0;
/*      */         }
/*  226 */         moveToTarget();
/*      */       }
/*  228 */       this.prevAttackTarget = null;
/*      */     }
/*  230 */     if (this.neckAngle > 0) {
/*  231 */       this.neckAngle -= 1;
/*      */     }
/*  233 */     if (isTerrestrial()) {
/*  234 */       setMoveSpeed(this.moveSpeedOrigin * getFlySpeed());
/*      */     } else {
/*  236 */       setMoveSpeed(this.moveSpeedOrigin);
/*      */     }
/*  238 */     this.field_70180_af.func_75692_b(13, Integer.valueOf(this.jawMove));
/*  239 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(this.neckAngle));
/*      */     
/*  241 */     if (this.groundTick > 0) {
/*  242 */       this.groundTick -= 1;
/*      */     }
/*  244 */     this.wingTick += 1;
/*  245 */     if (this.wingTick == 20) {
/*  246 */       this.wingTick = 0;
/*  247 */       if (!isTerrestrial())
/*  248 */         this.field_70170_p.func_72956_a(this, MFResource.sound("mob.flap"), 1.0F, 1.0F);
/*      */     }
/*  250 */     int i = 6 * this.wingTick;
/*  251 */     this.wingFlap = (-40 + i);
/*  252 */     if (this.field_70122_E) {
/*  253 */       this.groundTick = 20;
/*      */     }
/*      */     
/*  256 */     if (isTerrestrial()) {
/*  257 */       this.wingFlap = -40;
/*  258 */       this.wingAngle = 0;
/*      */     } else {
/*  260 */       this.wingAngle = 45;
/*      */     }
/*  262 */     if (this.jawMove > 0) {
/*  263 */       this.jawMove -= 4;
/*      */     }
/*  265 */     if (this.fireBreathTick > 0) {
/*  266 */       this.jawMove = 20;
/*      */     }
/*  268 */     if (this.fireBreathTick > 0) {
/*  269 */       this.fireBreathTick -= 1;
/*      */     }
/*  271 */     if (this.fireBreathCooldown > 0) {
/*  272 */       this.fireBreathCooldown -= 1;
/*      */     }
/*  274 */     if (this.throwCooldown > 0) {
/*  275 */       this.throwCooldown -= 1;
/*      */     }
/*      */     
/*  278 */     if ((this.targetedEntity != null) && (this.fireBreathTick > 0)) {
/*  279 */       breatheFire(this.targetedEntity);
/*      */     }
/*  281 */     if ((this.targetedEntity != null) && (
/*  282 */       (func_70032_d(this.targetedEntity) > 300.0F) || (this.targetedEntity.field_70128_L))) {
/*  283 */       this.targetedEntity = null;
/*      */     }
/*      */     
/*  286 */     if ((this.targetedEntity == null) && (this.field_70146_Z.nextInt(100) == 0) && (this.retreatCooldown <= 0)) {
/*  287 */       this.waypointX = (this.field_70165_t + (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * 16.0F);
/*  288 */       this.waypointY = (this.field_70163_u + (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * 16.0F);
/*  289 */       this.waypointZ = (this.field_70161_v + (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * 16.0F);
/*      */     }
/*  291 */     if ((this.targetedEntity == null) && (this.field_70146_Z.nextInt(100) == 0) && (this.retreatCooldown > 0)) {
/*  292 */       this.waypointX = (this.field_70165_t + (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * 16.0F);
/*  293 */       this.waypointY = this.field_70163_u;
/*  294 */       this.waypointZ = (this.field_70161_v + (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * 16.0F);
/*      */     }
/*  296 */     if (this.targetedEntity != null) {
/*  297 */       if ((!(this.targetedEntity instanceof EntityPlayer)) && 
/*  298 */         (this.targetedEntity != null) && (!func_70685_l(this.targetedEntity)) && 
/*  299 */         (this.field_70146_Z.nextInt(10) == 0)) {
/*  300 */         func_70784_b(null);
/*      */       }
/*      */       
/*  303 */       if ((this.targetedEntity != null) && ((func_70032_d(this.targetedEntity) > 200.0F) || (this.targetedEntity.field_70128_L))) {
/*  304 */         this.targetedEntity = null;
/*      */       }
/*  306 */       if ((!(this.targetedEntity instanceof EntityPlayer)) && 
/*  307 */         (this.targetedEntity != null) && (!func_70685_l(this.targetedEntity)) && 
/*  308 */         (this.field_70146_Z.nextInt(10) == 0)) {
/*  309 */         func_70784_b(null);
/*      */       }
/*      */     }
/*      */     
/*  313 */     if (!this.field_70170_p.field_72995_K)
/*  314 */       this.field_70180_af.func_75692_b(14, Integer.valueOf(this.groundTick));
/*  315 */     if (this.field_70170_p.field_72995_K) {
/*  316 */       this.groundTick = this.field_70180_af.func_75679_c(14);
/*      */     }
/*  318 */     if ((willRetreat(this.targetedEntity)) && (this.field_70146_Z.nextInt(getRetreatChance()) == 0)) {
/*  319 */       this.prevAttackTarget = this.targetedEntity;
/*  320 */       this.retreatCooldown = 100;
/*  321 */       this.waypointX = (this.field_70165_t + (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * 16.0F);
/*  322 */       this.waypointY = (this.field_70163_u + this.field_70146_Z.nextFloat() * 16.0F);
/*  323 */       this.waypointZ = (this.field_70161_v + (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * 16.0F);
/*  324 */       func_70784_b(null);
/*      */     }
/*  326 */     if (!this.field_70170_p.field_72995_K) {
/*  327 */       this.fast = (destroyBlocksInAABB(this.field_70121_D) | destroyBlocksInAABB(this.field_70121_D));
/*      */       
/*  329 */       if ((func_70090_H()) && 
/*  330 */         (this.field_70146_Z.nextFloat() < 0.8F)) {
/*  331 */         func_70683_ar().func_75660_a();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void setMoveSpeed(float speed)
/*      */   {
/*  338 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(speed);
/*      */   }
/*      */   
/*      */   private float getFlySpeed() {
/*  342 */     return 20.0F;
/*      */   }
/*      */   
/*      */   private double getDistanceToHome() {
/*  346 */     ChunkCoordinates home = func_110172_bL();
/*  347 */     return func_70011_f(home.field_71574_a, home.field_71572_b, home.field_71573_c);
/*      */   }
/*      */   
/*      */   private int getRetreatChance() {
/*  351 */     switch (this.breed) {
/*      */     case 1: 
/*  353 */       return 200;
/*      */     case 2: 
/*  355 */       return 400;
/*      */     case 3: 
/*  357 */       return 100;
/*      */     case 4: 
/*  359 */       return 1000;
/*      */     }
/*  361 */     return 200;
/*      */   }
/*      */   
/*      */   private void moveToTarget() {
/*  365 */     if (this.targetedEntity != null) {
/*  366 */       this.waypointX = this.targetedEntity.field_70165_t;
/*  367 */       this.waypointY = this.targetedEntity.field_70163_u;
/*  368 */       this.waypointZ = this.targetedEntity.field_70161_v;
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean isTerrestrial() {
/*  373 */     return this.groundTick > 0;
/*      */   }
/*      */   
/*      */   public void func_70642_aH()
/*      */   {
/*  378 */     this.jawMove = 30;
/*  379 */     this.neckAngle = 10;
/*      */     
/*  381 */     String s = func_70639_aQ();
/*      */     
/*  383 */     float pitch = func_70647_i();
/*      */     
/*  385 */     if (s != null) {
/*  386 */       func_85030_a(s, func_70599_aP(), pitch);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected void func_70626_be()
/*      */   {
/*  394 */     if ((!this.field_70170_p.field_72995_K) && (this.field_70170_p.field_73013_u == 0)) {
/*  395 */       func_70106_y();
/*      */     }
/*  397 */     if (this.field_70170_p.field_72995_K)
/*  398 */       func_70106_y();
/*  399 */     if ((isTerrestrial()) && (this.field_70181_x < 0.0D)) {
/*  400 */       this.field_70181_x = 0.0D;
/*      */     }
/*  402 */     if ((this.targetedEntity != null) && (func_70032_d(this.targetedEntity) < 6.0F) && 
/*  403 */       (this.field_70163_u >= this.targetedEntity.field_70163_u - 3.0D) && (!this.field_70122_E)) {
/*  404 */       this.field_70181_x = -0.25D;
/*      */     }
/*      */     
/*  407 */     this.prevAttackCounter = this.attackCounter;
/*  408 */     double var1 = this.waypointX - this.field_70165_t;
/*  409 */     double var3 = this.waypointY - this.field_70163_u;
/*  410 */     double var5 = this.waypointZ - this.field_70161_v;
/*  411 */     double var7 = MathHelper.func_76133_a(var1 * var1 + var3 * var3 + var5 * var5);
/*      */     
/*  413 */     if (((this.targetedEntity == null) && (var7 < 1.0D)) || (var7 > 60.0D)) {
/*  414 */       this.waypointX = (this.field_70165_t + (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * 16.0F);
/*  415 */       this.waypointY = (this.field_70163_u + (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * 16.0F);
/*  416 */       this.waypointZ = (this.field_70161_v + (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * 16.0F);
/*      */     }
/*      */     
/*  419 */     if (this.courseChangeCooldown-- <= 0) {
/*  420 */       this.courseChangeCooldown += this.field_70146_Z.nextInt(5) + 2;
/*      */       
/*  422 */       if (isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, var7)) {
/*  423 */         this.field_70159_w += var1 / var7 * 0.2D;
/*  424 */         this.field_70181_x += var3 / var7 * 0.2D;
/*  425 */         this.field_70179_y += var5 / var7 * 0.2D;
/*      */       }
/*  427 */       else if (!isTerrestrial()) {
/*  428 */         if ((this.targetedEntity != null) && (this.field_70163_u < this.targetedEntity.field_70163_u - 1.0D)) {
/*  429 */           this.field_70181_x = 0.25D;
/*      */         }
/*  431 */         if ((this.targetedEntity != null) && (this.field_70163_u > this.targetedEntity.field_70163_u)) {
/*  432 */           this.field_70181_x = -0.25D;
/*      */         }
/*      */       }
/*  435 */       else if ((this.targetedEntity != null) && (this.field_70163_u < this.targetedEntity.field_70163_u + 6.0D)) {
/*  436 */         this.field_70181_x = 0.25D;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  442 */     if ((this.targetedEntity != null) && (this.targetedEntity.field_70128_L)) {
/*  443 */       this.targetedEntity = null;
/*      */     }
/*      */     
/*  446 */     if (this.targetedEntity == null) {
/*  447 */       setEntityToAttack(EntityPlayer.class);
/*      */     }
/*      */     
/*  450 */     double var9 = 200.0D;
/*      */     
/*  452 */     if ((this.targetedEntity != null) && (this.targetedEntity.func_70068_e(this) < var9 * var9)) {
/*  453 */       double var11 = this.targetedEntity.field_70165_t - this.field_70165_t;
/*  454 */       double var13 = this.targetedEntity.field_70121_D.field_72338_b + this.targetedEntity.field_70131_O / 2.0F - (this.field_70163_u + this.field_70131_O / 2.0F);
/*  455 */       double var15 = this.targetedEntity.field_70161_v - this.field_70161_v;
/*  456 */       this.field_70761_aq = (this.field_70177_z = -(float)Math.atan2(var11, var15) * 180.0F / 3.1415927F);
/*  457 */       boolean inRangeOfAttack = (this.targetedEntity.func_70032_d(this) < 4.0F) && (func_70685_l(this.targetedEntity));
/*  458 */       boolean inRangeOfFire = (this.targetedEntity.func_70032_d(this) > 4.0F) && (this.targetedEntity.func_70032_d(this) < 24.0F) && (this.fireBreathCooldown <= 0);
/*  459 */       if ((func_70685_l(this.targetedEntity)) && (inRangeOfFire) && (!isConfused())) {
/*  460 */         this.fireBreathTick = (20 + this.field_70146_Z.nextInt(40));
/*  461 */         this.fireBreathCooldown = (900 + getBreathCooldown() + this.field_70146_Z.nextInt(getBreathCooldown()));
/*  462 */         this.field_70170_p.func_72956_a(this, MFResource.sound("mob.breatheFire"), 1.0F, 1.0F);
/*  463 */         this.jawMove = 20;
/*      */       }
/*  465 */       if ((func_70685_l(this.targetedEntity)) && (inRangeOfAttack) && 
/*  466 */         (this.attackCounter <= 0)) {
/*  467 */         func_70785_a(this.targetedEntity, getAttackStrength(this.targetedEntity));
/*  468 */         this.attackCounter = getAttackTime();
/*  469 */         this.jawMove = 40;
/*  470 */         this.field_70170_p.func_72956_a(this, MFResource.sound("mob.bite"), 1.0F, 1.0F);
/*      */       }
/*      */       
/*  473 */       if (this.attackCounter > 0) {
/*  474 */         this.attackCounter -= 1;
/*      */       }
/*  476 */       if ((func_70685_l(this.targetedEntity)) && (!inRangeOfAttack)) {
/*  477 */         this.waypointX = this.targetedEntity.field_70165_t;
/*  478 */         this.waypointY = this.targetedEntity.field_70163_u;
/*  479 */         this.waypointZ = this.targetedEntity.field_70161_v;
/*      */       }
/*  481 */       int i = this.targetedEntity.func_70068_e(this) < 12.0D ? 1 : 0;
/*      */     } else {
/*  483 */       this.field_70761_aq = (this.field_70177_z = -(float)Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0F / 3.1415927F);
/*      */       
/*  485 */       if (this.attackCounter > 0) {
/*  486 */         this.attackCounter -= 1;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean isConfused() {
/*  492 */     return func_70660_b(Potion.field_76431_k) != null;
/*      */   }
/*      */   
/*      */   private int getAttackTime() {
/*  496 */     switch (this.breed) {
/*      */     case 1: 
/*  498 */       return 15;
/*      */     case 2: 
/*  500 */       return 12;
/*      */     case 3: 
/*  502 */       return 8;
/*      */     case 4: 
/*  504 */       return 10;
/*      */     }
/*  506 */     return 20;
/*      */   }
/*      */   
/*      */   private int getBreathCooldown() {
/*  510 */     switch (this.breed) {
/*      */     case 1: 
/*  512 */       return 600;
/*      */     case 2: 
/*  514 */       return 1200;
/*      */     case 3: 
/*  516 */       return 800;
/*      */     case 4: 
/*  518 */       return 400;
/*      */     }
/*  520 */     return 600;
/*      */   }
/*      */   
/*      */   protected void func_70785_a(Entity entity, float f) {
/*  524 */     float damage = getAttackStrength(entity);
/*      */     
/*  526 */     if (this.field_70146_Z.nextInt(3) == 0) {
/*  527 */       this.targetedEntity.field_70181_x = 2.0D;
/*  528 */       func_70664_aZ();
/*  529 */       this.neckAngle = 10;
/*  530 */       damage = 2.0F;
/*      */     }
/*  532 */     this.field_70170_p.func_72956_a(this, MFResource.sound("mob.bite"), 1.0F, 1.0F);
/*  533 */     float AP = damage * getAPDamage();
/*  534 */     entity.func_70097_a(DamageSource.func_76358_a(this), damage - AP);
/*  535 */     entity.func_70097_a(EntityDamageSourceAP.causeDamage(this), damage);
/*      */   }
/*      */   
/*      */   private float getAPDamage() {
/*  539 */     return 0.2F;
/*      */   }
/*      */   
/*      */   public void setEntityToAttack(Class enClass) {
/*  543 */     List list = this.field_70170_p.func_72872_a(enClass, AxisAlignedBB.func_72332_a().func_72299_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70165_t + 1.0D, this.field_70163_u + 1.0D, this.field_70161_v + 1.0D).func_72314_b(getAggro(), getAggro(), getAggro()));
/*  544 */     if (!list.isEmpty()) {
/*  545 */       Entity target = (Entity)list.get(this.field_70170_p.field_73012_v.nextInt(list.size()));
/*  546 */       if (canAttackEntity(target)) {
/*  547 */         double r = getAggro();
/*  548 */         if (TacticalManager.isDetected(this, target)) {
/*  549 */           r /= 3.0D;
/*      */         }
/*      */         
/*  552 */         boolean inRange = func_70032_d(target) <= r;
/*  553 */         if ((this.retreatCooldown <= 0) && (inRange)) {
/*  554 */           func_70784_b(target);
/*      */         }
/*      */       } else {
/*  557 */         list.remove(target);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private double getAggro() {
/*  563 */     if (calmDown()) {
/*  564 */       return 30.0D;
/*      */     }
/*  566 */     return 120.0D;
/*      */   }
/*      */   
/*      */   public void func_70645_a(DamageSource source) {
/*  570 */     super.func_70645_a(source);
/*      */     
/*  572 */     if ((source.func_76346_g() != null) && ((source.func_76346_g() instanceof EntityPlayer))) {
/*  573 */       EntityPlayer var2 = (EntityPlayer)source.func_76346_g();
/*  574 */       var2.func_71064_a(AchivementMF.AchievementDragonslayer, 1);
/*      */     }
/*  576 */     if ((source.func_76364_f() != null) && ((source.func_76364_f() instanceof EntityPlayer))) {
/*  577 */       EntityPlayer var2 = (EntityPlayer)source.func_76364_f();
/*  578 */       var2.func_71064_a(AchivementMF.AchievementDragonslayer, 1);
/*      */     }
/*      */   }
/*      */   
/*      */   public void func_70014_b(NBTTagCompound nbt)
/*      */   {
/*  584 */     super.func_70014_b(nbt);
/*  585 */     nbt.func_74768_a("fire", this.fireBreathCooldown);
/*  586 */     nbt.func_74768_a("toss", this.throwCooldown);
/*  587 */     nbt.func_74768_a("breed", this.breed);
/*      */   }
/*      */   
/*      */   public void func_70037_a(NBTTagCompound nbt)
/*      */   {
/*  592 */     super.func_70037_a(nbt);
/*  593 */     if (nbt.func_74764_b("fire")) {
/*  594 */       this.fireBreathCooldown = nbt.func_74762_e("fire");
/*      */     }
/*  596 */     if (nbt.func_74764_b("toss")) {
/*  597 */       this.throwCooldown = nbt.func_74762_e("toss");
/*      */     }
/*  599 */     this.breed = nbt.func_74762_e("breed");
/*  600 */     if (this.breed == 0) {
/*  601 */       this.breed = (this.field_70146_Z.nextBoolean() ? 1 : 2);
/*      */     }
/*      */   }
/*      */   
/*      */   public String getTexture() {
/*  606 */     switch (this.breed) {
/*      */     case 1: 
/*  608 */       return MFResource.image("/mob/dragonRed.png");
/*      */     case 2: 
/*  610 */       return MFResource.image("/mob/dragonGreen.png");
/*      */     case 3: 
/*  612 */       return MFResource.image("/mob/dragonBlack.png");
/*      */     case 4: 
/*  614 */       return MFResource.image("/mob/dragonGold.png");
/*      */     }
/*  616 */     return MFResource.image("/mob/dragonRed.png");
/*      */   }
/*      */   
/*      */   public void func_70106_y()
/*      */   {
/*  621 */     super.func_70106_y();
/*      */   }
/*      */   
/*      */   public void func_70071_h_()
/*      */   {
/*  626 */     super.func_70071_h_();
/*  627 */     if (this.field_70170_p.func_82737_E() < 2L)
/*  628 */       func_70106_y();
/*  629 */     if (this.field_70173_aa == 1)
/*  630 */       createMount();
/*  631 */     if (!this.field_70170_p.field_72995_K) {
/*  632 */       if ((this.breed == 3) && (this.field_70173_aa % 20 == 0)) {
/*  633 */         func_70691_i(1.0F);
/*      */       }
/*  635 */       this.field_70180_af.func_75692_b(16, Integer.valueOf(this.breed));
/*      */     } else {
/*  637 */       this.breed = this.field_70180_af.func_75679_c(16);
/*      */     }
/*      */   }
/*      */   
/*      */   protected boolean func_70692_ba()
/*      */   {
/*  643 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private boolean isCourseTraversable(double x, double y, double z, double distance)
/*      */   {
/*  650 */     if ((this.targetedEntity != null) && (func_70032_d(this.targetedEntity) < 1.2D))
/*  651 */       return false;
/*  652 */     double var9 = (this.waypointX - this.field_70165_t) / distance;
/*  653 */     double var11 = (this.waypointY - this.field_70163_u) / distance;
/*  654 */     double var13 = (this.waypointZ - this.field_70161_v) / distance;
/*  655 */     AxisAlignedBB bb = this.field_70121_D.func_72329_c();
/*      */     
/*  657 */     for (int var16 = 1; var16 < distance; var16++) {
/*  658 */       bb.func_72317_d(var9, var11, var13);
/*      */       
/*  660 */       if ((this.field_70170_p.func_72945_a(this, bb).size() > 0) && 
/*  661 */         (!isBlockGlass(bb))) {
/*  662 */         return false;
/*      */       }
/*      */     }
/*      */     
/*  666 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected String func_70639_aQ()
/*      */   {
/*  673 */     return MFResource.sound("mob.dragon");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected String func_70621_aR()
/*      */   {
/*  680 */     return MFResource.sound("mob.dragonhurt");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected String func_70673_aS()
/*      */   {
/*  687 */     return MFResource.sound("mob.dragonHurt");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected int func_70633_aT()
/*      */   {
/*  694 */     return 0;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected void func_70628_a(boolean multiply, int amount)
/*      */   {
/*  701 */     dropSpecificItem(ItemListMF.misc.field_77779_bT, 19, 1);
/*  702 */     int amountDropped = this.field_70146_Z.nextInt(3 + amount);
/*      */     
/*  704 */     for (int timesDropped = 0; timesDropped < amountDropped; timesDropped++) {
/*  705 */       func_70025_b(Item.field_77677_M.field_77779_bT, 1);
/*      */     }
/*      */   }
/*      */   
/*      */   public EntityItem dropSpecificItem(int id, int damage, int amount) {
/*  710 */     return dropSpecificItemWithOffset(id, damage, amount, 0.0F);
/*      */   }
/*      */   
/*      */   public EntityItem dropSpecificItemWithOffset(int id, int damage, int amount, float offset) {
/*  714 */     return func_70099_a(new ItemStack(id, amount, damage), offset);
/*      */   }
/*      */   
/*      */   public boolean func_70601_bi()
/*      */   {
/*  719 */     int chance = this.field_71093_bK == 0 ? cfg.dragonChance : cfg.dragonChance / 4;
/*  720 */     if (this.field_70146_Z.nextInt(cfg.dragonChance) != 0) {
/*  721 */       return false;
/*      */     }
/*      */     
/*  724 */     if (this.field_70170_p.field_73013_u < cfg.dragonDiff) {
/*  725 */       return false;
/*      */     }
/*      */     
/*  728 */     if (!super.func_70601_bi()) {
/*  729 */       return false;
/*      */     }
/*  731 */     if (!canSpawnAtPos()) {
/*  732 */       return false;
/*      */     }
/*  734 */     if (MineFantasyBase.isDebug()) {
/*  735 */       System.out.println("Try Dragon Spawn: " + getDistanceAway());
/*      */     }
/*  737 */     return true;
/*      */   }
/*      */   
/*      */   public boolean isProperBlock(int x, int y, int z) {
/*  741 */     return true;
/*      */   }
/*      */   
/*      */   public boolean canSpawnAtPos() {
/*  745 */     if (this.field_71093_bK != 0) {
/*  746 */       return true;
/*      */     }
/*  748 */     ChunkCoordinates spawn = this.field_70170_p.func_72861_E();
/*      */     
/*  750 */     if (!this.field_70170_p.func_72937_j((int)this.field_70165_t, (int)this.field_70163_u + 1, (int)this.field_70161_v)) {
/*  751 */       return false;
/*      */     }
/*  753 */     return func_70011_f(spawn.field_71574_a, spawn.field_71572_b, spawn.field_71573_c) > getDistanceToSpawn();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   protected float func_70599_aP()
/*      */   {
/*  761 */     return 3.0F;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int func_70641_bl()
/*      */   {
/*  768 */     return 1;
/*      */   }
/*      */   
/*      */   private void breatheFire(Entity target) {
/*  772 */     int spread = 1;
/*      */     
/*  774 */     for (int a = 0; a < spread; a++) {
/*  775 */       double var11 = this.targetedEntity.field_70165_t - this.field_70165_t;
/*  776 */       double var13 = this.targetedEntity.field_70121_D.field_72338_b + this.targetedEntity.field_70131_O / 2.0F - (this.field_70163_u + this.field_70131_O / 2.0F);
/*  777 */       double var15 = this.targetedEntity.field_70161_v - this.field_70161_v;
/*  778 */       EntityFirebreath var17 = new EntityFirebreath(this.field_70170_p, this, var11, var13, var15, 20);
/*  779 */       double var18 = 1.0D;
/*  780 */       Vec3 var20 = func_70676_i(1.0F);
/*  781 */       var17.field_70165_t = (this.field_70165_t + var20.field_72450_a * var18);
/*  782 */       var17.field_70163_u = (this.field_70163_u + this.field_70131_O / 2.0F + 0.5D);
/*  783 */       var17.field_70161_v = (this.field_70161_v + var20.field_72449_c * var18);
/*  784 */       this.field_70170_p.func_72838_d(var17);
/*      */     }
/*      */   }
/*      */   
/*      */   public void func_70784_b(Entity target) {
/*  789 */     this.targetedEntity = target;
/*      */   }
/*      */   
/*      */   private boolean canAttackEntity(Entity target) {
/*  793 */     if (!func_70685_l(target))
/*  794 */       return false;
/*  795 */     if (((target instanceof EntityDragonSmall)) || (target == this.field_70153_n)) {
/*  796 */       return false;
/*      */     }
/*  798 */     if ((target instanceof EntityPlayer)) {
/*  799 */       EntityPlayer player = (EntityPlayer)target;
/*  800 */       return !player.field_71075_bZ.field_75098_d;
/*      */     }
/*  802 */     return func_70685_l(target);
/*      */   }
/*      */   
/*      */   public int getNeckAngle() {
/*  806 */     return this.field_70180_af.func_75679_c(15);
/*      */   }
/*      */   
/*      */   public int getJawMove() {
/*  810 */     return this.field_70180_af.func_75679_c(13);
/*      */   }
/*      */   
/*      */   public int wingFlap() {
/*  814 */     return this.wingFlap;
/*      */   }
/*      */   
/*      */   public int wingAngle() {
/*  818 */     return this.wingAngle;
/*      */   }
/*      */   
/*      */   private boolean willRetreat(Entity entity) {
/*  822 */     if (this.retreatCooldown > 0)
/*  823 */       return false;
/*  824 */     if (entity == null)
/*  825 */       return false;
/*  826 */     if (!isCourseTraversable(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, func_70032_d(entity)))
/*  827 */       return true;
/*  828 */     return func_70032_d(entity) < 8.0F;
/*      */   }
/*      */   
/*      */   protected void func_70623_bb()
/*      */   {
/*  833 */     super.func_70623_bb();
/*      */   }
/*      */   
/*      */   private void setStats() {
/*  837 */     if (this.breed == 0)
/*      */     {
/*  839 */       func_110171_b((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 32);
/*  840 */       this.breed = (this.field_70146_Z.nextInt(2) + 1);
/*      */       
/*  842 */       int rareBreed = this.field_70146_Z.nextInt(20);
/*  843 */       if (getDistanceAway() > cfg.dragonDistance * 5) {
/*  844 */         rareBreed = this.field_70146_Z.nextInt(2);
/*      */       }
/*      */       
/*  847 */       if (rareBreed == 0)
/*  848 */         this.breed = 3;
/*  849 */       if (rareBreed == 1) {
/*  850 */         this.breed = 4;
/*      */       }
/*  852 */       if (this.breed >= 3) {
/*  853 */         this.field_70728_aV = 500;
/*      */       }
/*  855 */       setMaxHealth(getMaxHealthOnBreed());
/*  856 */       func_70606_j(func_110138_aP());
/*      */     }
/*  858 */     this.field_70178_ae = true;
/*      */   }
/*      */   
/*      */   private void setMaxHealth(float maxHealth)
/*      */   {
/*  863 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(maxHealth);
/*      */   }
/*      */   
/*      */   private boolean destroyBlocksInAABB(AxisAlignedBB box) {
/*  867 */     if (!cfg.dragonGrief) {
/*  868 */       return false;
/*      */     }
/*  870 */     int var2 = MathHelper.func_76128_c(box.field_72340_a);
/*  871 */     int var3 = MathHelper.func_76128_c(box.field_72338_b);
/*  872 */     int var4 = MathHelper.func_76128_c(box.field_72339_c);
/*  873 */     int var5 = MathHelper.func_76128_c(box.field_72336_d);
/*  874 */     int var6 = MathHelper.func_76128_c(box.field_72337_e);
/*  875 */     int var7 = MathHelper.func_76128_c(box.field_72334_f);
/*  876 */     boolean var8 = false;
/*  877 */     boolean var9 = false;
/*      */     
/*  879 */     for (int x = var2; x <= var5; x++) {
/*  880 */       for (int y = var3; y <= var6; y++) {
/*  881 */         for (int z = var4; z <= var7; z++) {
/*  882 */           Material var13 = this.field_70170_p.func_72803_f(x, y, z);
/*  883 */           int id = this.field_70170_p.func_72798_a(x, y, z);
/*  884 */           int meta = this.field_70170_p.func_72805_g(x, y, z);
/*      */           
/*  886 */           if (var13 != null) {
/*  887 */             if (var13 == Material.field_76264_q) {
/*  888 */               var9 = true;
/*  889 */               this.field_70170_p.func_94571_i(x, y, z);
/*  890 */               for (int a = 0; a < 1 + this.field_70146_Z.nextInt(4); a++)
/*  891 */                 this.field_70170_p.func_72956_a(this, "random.glass", 1.0F, 1.0F);
/*  892 */             } else if (isMaterialBreakable(var13)) {
/*  893 */               var9 = true;
/*  894 */               this.field_70170_p.func_94571_i(x, y, z);
/*  895 */               for (int a = 0; a < 1 + this.field_70146_Z.nextInt(4); a++)
/*  896 */                 this.field_70170_p.func_72956_a(this, "step.grass", 1.0F, 1.0F);
/*  897 */             } else if ((var13 == Material.field_76248_c) && (this.field_70170_p.func_72796_p(x, y, z) == null)) {
/*  898 */               var9 = true;
/*  899 */               this.field_70170_p.func_94571_i(x, y, z);
/*  900 */               Block.field_71973_m[id].func_71897_c(this.field_70170_p, x, y, z, meta, 0);
/*  901 */               for (int a = 0; a < 1 + this.field_70146_Z.nextInt(4); a++)
/*  902 */                 this.field_70170_p.func_72956_a(this, "step.gravel", 1.0F, 1.0F);
/*  903 */               attackEntityFrom(DamageSource.field_76367_g, 1);
/*  904 */             } else if ((var13 == Material.field_76247_b) && (this.field_70170_p.func_72796_p(x, y, z) == null)) {
/*  905 */               var9 = true;
/*  906 */               this.field_70170_p.func_94571_i(x, y, z);
/*  907 */               Block.field_71973_m[id].func_71897_c(this.field_70170_p, x, y, z, meta, 0);
/*  908 */               for (int a = 0; a < 1 + this.field_70146_Z.nextInt(4); a++)
/*  909 */                 this.field_70170_p.func_72956_a(this, "step.grass", 1.0F, 1.0F);
/*  910 */               attackEntityFrom(DamageSource.field_76367_g, 1);
/*  911 */             } else if ((var13 == Material.field_76245_d) && (this.field_70170_p.func_72796_p(x, y, z) == null)) {
/*  912 */               var9 = true;
/*  913 */               this.field_70170_p.func_94571_i(x, y, z);
/*  914 */               Block.field_71973_m[id].func_71897_c(this.field_70170_p, x, y, z, meta, 0);
/*  915 */               for (int a = 0; a < 1 + this.field_70146_Z.nextInt(4); a++)
/*  916 */                 this.field_70170_p.func_72956_a(this, "mob.zombie.woodBreak", 1.0F, 1.0F);
/*  917 */               attackEntityFrom(DamageSource.field_76367_g, 1);
/*  918 */             } else if ((var13 == Material.field_76246_e) && (this.field_70170_p.func_72796_p(x, y, z) == null)) {
/*  919 */               if ((Block.field_71973_m[id].func_71934_m(this.field_70170_p, x, y, z) < 50.0F) && (Block.field_71973_m[id].func_71934_m(this.field_70170_p, x, y, z) > 0.0F)) {
/*  920 */                 var9 = true;
/*  921 */                 this.field_70170_p.func_94571_i(x, y, z);
/*  922 */                 Block.field_71973_m[id].func_71897_c(this.field_70170_p, x, y, z, meta, 0);
/*  923 */                 for (int a = 0; a < 1 + this.field_70146_Z.nextInt(4); a++)
/*  924 */                   this.field_70170_p.func_72956_a(this, "mob.zombie.iron", 1.0F, 1.0F);
/*  925 */                 attackEntityFrom(DamageSource.field_76367_g, 5);
/*      */               }
/*  927 */             } else if ((var13 == Material.field_76243_f) && (this.field_70170_p.func_72796_p(x, y, z) == null)) {
/*  928 */               var9 = true;
/*  929 */               this.field_70170_p.func_94571_i(x, y, z);
/*  930 */               Block.field_71973_m[id].func_71897_c(this.field_70170_p, x, y, z, meta, 0);
/*  931 */               attackEntityFrom(DamageSource.field_76367_g, 10);
/*      */             } else {
/*  933 */               var8 = true;
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  940 */     if (var9) {
/*  941 */       double var16 = box.field_72340_a + (box.field_72336_d - box.field_72340_a) * this.field_70146_Z.nextFloat();
/*  942 */       double var17 = box.field_72338_b + (box.field_72337_e - box.field_72338_b) * this.field_70146_Z.nextFloat();
/*  943 */       double var14 = box.field_72339_c + (box.field_72334_f - box.field_72339_c) * this.field_70146_Z.nextFloat();
/*  944 */       this.field_70170_p.func_72869_a("largeexplode", var16, var17, var14, 0.0D, 0.0D, 0.0D);
/*      */     }
/*      */     
/*      */ 
/*  948 */     return var8;
/*      */   }
/*      */   
/*      */   private boolean isBlockGlass(AxisAlignedBB box) {
/*  952 */     int var2 = MathHelper.func_76128_c(box.field_72340_a);
/*  953 */     int var3 = MathHelper.func_76128_c(box.field_72338_b);
/*  954 */     int var4 = MathHelper.func_76128_c(box.field_72339_c);
/*  955 */     int var5 = MathHelper.func_76128_c(box.field_72336_d);
/*  956 */     int var6 = MathHelper.func_76128_c(box.field_72337_e);
/*  957 */     int var7 = MathHelper.func_76128_c(box.field_72334_f);
/*  958 */     boolean var8 = false;
/*  959 */     boolean var9 = false;
/*      */     
/*  961 */     for (int var10 = var2; var10 <= var5; var10++) {
/*  962 */       for (int var11 = var3; var11 <= var6; var11++) {
/*  963 */         for (int var12 = var4; var12 <= var7; var12++) {
/*  964 */           Material var13 = this.field_70170_p.func_72803_f(var10, var11, var12);
/*      */           
/*  966 */           if (var13 != null) {
/*  967 */             if ((var13 == Material.field_76264_q) || (isMaterialBreakable(var13))) {
/*  968 */               var9 = true;
/*      */               
/*      */ 
/*  971 */               return true;
/*      */             }
/*  973 */             var8 = true;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  980 */     if (var9) {
/*  981 */       double var16 = box.field_72340_a + (box.field_72336_d - box.field_72340_a) * this.field_70146_Z.nextFloat();
/*  982 */       double var17 = box.field_72338_b + (box.field_72337_e - box.field_72338_b) * this.field_70146_Z.nextFloat();
/*  983 */       double var14 = box.field_72339_c + (box.field_72334_f - box.field_72339_c) * this.field_70146_Z.nextFloat();
/*  984 */       this.field_70170_p.func_72869_a("largeexplode", var16, var17, var14, 0.0D, 0.0D, 0.0D);
/*      */     }
/*      */     
/*      */ 
/*  988 */     return false;
/*      */   }
/*      */   
/*      */   private boolean isMaterialBreakable(Material material) {
/*  992 */     return (material == Material.field_76268_x) || (material == Material.field_76238_C) || (material == Material.field_76265_p) || (material == Material.field_76253_m) || (material == Material.field_76257_i) || (material == Material.field_76266_z) || (material == Material.field_76263_r) || (material == Material.field_76254_j);
/*      */   }
/*      */   
/*      */   private void createMount() {}
/*      */   
/*      */   private boolean calmDown()
/*      */   {
/*  999 */     return (!this.field_70170_p.func_72935_r()) || (this.field_70170_p.func_72951_B(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v))) || (this.field_70170_p.func_72951_B(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u + this.field_70131_O), MathHelper.func_76128_c(this.field_70161_v)));
/*      */   }
/*      */   
/*      */   public double getDistanceToSpawn()
/*      */   {
/* 1004 */     return cfg.dragonDistance;
/*      */   }
/*      */   
/*      */   public float getAttackStrength(Entity entity) {
/* 1008 */     int dam = 6;
/* 1009 */     switch (this.breed) {
/*      */     case 1: 
/* 1011 */       dam = 3;
/*      */     case 2: 
/* 1013 */       dam = 4;
/*      */     case 3: 
/* 1015 */       dam = 5;
/*      */     case 4: 
/* 1017 */       dam = 5;
/*      */     }
/* 1019 */     return dam + this.field_70146_Z.nextInt(dam);
/*      */   }
/*      */   
/*      */   public void func_70108_f(Entity entity)
/*      */   {
/* 1024 */     if (((entity instanceof EntitySkeleton)) && (this.field_70154_o == null) && (!entity.func_70115_ae())) {
/* 1025 */       entity.func_70078_a(this);
/*      */       
/* 1027 */       func_70071_h_();
/* 1028 */       entity.func_70071_h_();
/*      */     }
/* 1030 */     super.func_70108_f(entity);
/*      */   }
/*      */   
/*      */   public double func_70042_X()
/*      */   {
/* 1035 */     return super.func_70042_X();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private double getDistanceAway()
/*      */   {
/* 1042 */     ChunkCoordinates spawn = this.field_70170_p.func_72861_E();
/* 1043 */     return func_70011_f(spawn.field_71574_a, spawn.field_71572_b, spawn.field_71573_c);
/*      */   }
/*      */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/EntityDragonSmall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */