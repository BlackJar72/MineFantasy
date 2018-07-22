/*     */ package minefantasy.entity;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import java.io.PrintStream;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.api.tactic.ISpecialSenses;
/*     */ import minefantasy.entity.ai.EntityAIBreakDoorAnimate;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.system.TacticalManager;
/*     */ import minefantasy.system.cfg;
/*     */ import minefantasy.system.network.PacketManagerMF;
/*     */ import minefantasy.system.network.PacketUserMF;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.DataWatcher;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.EntityLivingData;
/*     */ import net.minecraft.entity.EnumCreatureAttribute;
/*     */ import net.minecraft.entity.IRangedAttackMob;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIArrowAttack;
/*     */ import net.minecraft.entity.ai.EntityAIAttackOnCollide;
/*     */ import net.minecraft.entity.ai.EntityAIHurtByTarget;
/*     */ import net.minecraft.entity.ai.EntityAILeapAtTarget;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
/*     */ import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAITasks;
/*     */ import net.minecraft.entity.ai.EntityAIWander;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.ai.attributes.AttributeInstance;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.monster.IMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntityArrow;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.packet.Packet;
/*     */ import net.minecraft.pathfinding.PathNavigate;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.server.management.ServerConfigurationManager;
/*     */ import net.minecraft.util.AABBPool;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EntityDamageSourceIndirect;
/*     */ import net.minecraft.util.MathHelper;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntitySkeletalKnight
/*     */   extends EntityMob
/*     */   implements IMob, ISpecialSenses, IRangedAttackMob, PacketUserMF
/*     */ {
/*  79 */   private static final float[] enchantmentProbability = { 0.0F, 0.0F, 0.1F, 0.2F };
/*     */   private int rallyCooldown;
/*     */   private int sprintCooldown;
/*     */   private static final int dataId = 12;
/*  83 */   private float attackRange = 2.5F;
/*     */   
/*     */   public EntitySkeletalKnight(World world) {
/*  86 */     super(world);
/*  87 */     setWeapon((byte)0);
/*     */     
/*  89 */     this.field_70714_bg.func_75776_a(3, new EntityAIArrowAttack(this, 0.25D, 20, 60, 15.0F));
/*  90 */     this.field_70714_bg.func_75776_a(3, new EntityAILeapAtTarget(this, 0.4F));
/*     */     
/*  92 */     this.field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
/*  93 */     this.field_70714_bg.func_75776_a(1, new EntityAIBreakDoorAnimate(this));
/*  94 */     this.field_70714_bg.func_75776_a(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
/*  95 */     this.field_70714_bg.func_75776_a(3, new EntityAIAttackOnCollide(this, EntityLiving.class, 1.0D, true));
/*  96 */     this.field_70714_bg.func_75776_a(5, new EntityAIMoveThroughVillage(this, 1.0D, false));
/*  97 */     this.field_70714_bg.func_75776_a(6, new EntityAIWander(this, 1.0D));
/*  98 */     this.field_70714_bg.func_75776_a(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
/*  99 */     this.field_70714_bg.func_75776_a(7, new EntityAILookIdle(this));
/* 100 */     this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, true));
/* 101 */     this.field_70715_bh.func_75776_a(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
/*     */     
/* 103 */     this.field_82174_bp[0] = 2.0F;
/*     */   }
/*     */   
/*     */   protected void func_110147_ax()
/*     */   {
/* 108 */     super.func_110147_ax();
/* 109 */     func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(64.0D);
/* 110 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23000000417232513D);
/* 111 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(2.0D);
/* 112 */     func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0D);
/*     */   }
/*     */   
/*     */   public void func_70088_a()
/*     */   {
/* 117 */     super.func_70088_a();
/* 118 */     this.field_70180_af.func_75682_a(12, Integer.valueOf(0));
/* 119 */     this.field_70180_af.func_75682_a(13, Byte.valueOf((byte)0));
/* 120 */     this.field_70180_af.func_75682_a(14, Byte.valueOf((byte)0));
/*     */   }
/*     */   
/*     */   public EntityLivingData func_110161_a(EntityLivingData data)
/*     */   {
/* 125 */     func_98053_h(false);
/* 126 */     enchant(defaultHeldItem);
/* 127 */     enchant(bluntItem);
/* 128 */     enchant(rangedItem);
/* 129 */     enchant(stealthItem);
/*     */     
/* 131 */     return super.func_110161_a(data);
/*     */   }
/*     */   
/*     */   public int func_70658_aO()
/*     */   {
/* 136 */     return 20;
/*     */   }
/*     */   
/*     */   private boolean isProperDistance() {
/* 140 */     if (this.field_71093_bK != 0) {
/* 141 */       return true;
/*     */     }
/* 143 */     ChunkCoordinates spawn = this.field_70170_p.func_72861_E();
/* 144 */     return func_70011_f(spawn.field_71574_a, spawn.field_71572_b, spawn.field_71573_c) > getDistanceToSpawn();
/*     */   }
/*     */   
/*     */   public double getDistanceToSpawn() {
/* 148 */     return 0.0D;
/*     */   }
/*     */   
/*     */   public boolean func_70601_bi()
/*     */   {
/* 153 */     if (this.field_70146_Z.nextInt(10) != 0) {
/* 154 */       return false;
/*     */     }
/* 156 */     EntityPlayer xpPlayer = getHighestXPLevel();
/* 157 */     int lvl = 0;
/* 158 */     if (xpPlayer != null) {
/* 159 */       lvl = xpPlayer.field_71068_ca;
/*     */     }
/* 161 */     if (lvl < cfg.knightLvl) {
/* 162 */       return false;
/*     */     }
/* 164 */     if (this.field_70170_p.field_73013_u < cfg.knightDiff) {
/* 165 */       return false;
/*     */     }
/*     */     
/* 168 */     if (!super.func_70601_bi()) {
/* 169 */       return false;
/*     */     }
/* 171 */     if (MineFantasyBase.isDebug()) {
/* 172 */       System.out.println("Try Knight Spawn: " + lvl + " for " + xpPlayer.func_70023_ak());
/*     */     }
/* 174 */     return true;
/*     */   }
/*     */   
/*     */   private EntityPlayer getHighestXPLevel() {
/* 178 */     EntityPlayer play = this.field_70170_p.func_72890_a(this, -1.0D);
/* 179 */     if (play != null) {
/* 180 */       return play;
/*     */     }
/* 182 */     return null;
/*     */   }
/*     */   
/*     */   public void func_70636_d()
/*     */   {
/* 187 */     super.func_70636_d();
/* 188 */     if ((!this.field_70170_p.field_72995_K) && 
/* 189 */       (this.rallyCooldown > 0)) {
/* 190 */       this.rallyCooldown -= 1;
/*     */     }
/* 192 */     if (this.rallyCooldown <= 0) {
/* 193 */       rally(func_70638_az());
/*     */     }
/*     */     
/* 196 */     if ((func_70638_az() != null) && 
/* 197 */       (func_70638_az().field_70128_L)) {
/* 198 */       func_70624_b(null);
/*     */     }
/*     */     
/*     */ 
/* 202 */     if (!this.field_70170_p.field_72995_K) {
/* 203 */       int block = getBlockTime();
/* 204 */       if (block > 0) {
/* 205 */         block--;
/*     */       }
/* 207 */       this.field_70180_af.func_75692_b(12, Integer.valueOf(block));
/*     */       
/* 209 */       if (this.field_70173_aa % 100 == 0) {
/* 210 */         func_70691_i(1.0F);
/*     */       }
/* 212 */       if (this.field_70173_aa % 10 == 0) {
/* 213 */         updateWeapons();
/*     */       }
/*     */       
/* 216 */       if (func_70638_az() != null) {
/* 217 */         if ((func_70638_az().field_82175_bq) && 
/* 218 */           (func_70694_bm() == defaultHeldItem) && 
/* 219 */           (isInfront(func_70638_az()))) {
/* 220 */           this.field_70180_af.func_75692_b(12, Integer.valueOf(15));
/*     */         }
/*     */         
/*     */ 
/* 224 */         if ((func_70032_d(func_70638_az()) < 2.0F) && (this.field_70146_Z.nextInt(5) == 0) && (!func_70093_af())) {
/* 225 */           double pounceFactor = func_70032_d(func_70638_az()) / 8.0F;
/* 226 */           func_70024_g(-MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F) * (float)pounceFactor * 0.5F, 0.1D, MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F) * (float)pounceFactor * 0.5F);
/* 227 */           func_70664_aZ();
/*     */         }
/* 229 */         if ((func_70032_d(func_70638_az()) < 2.0F) && (this.field_70143_R > 0.0D) && (!func_70617_f_())) {
/* 230 */           func_70652_k(func_70638_az());
/*     */         }
/*     */       } else {
/* 233 */         setWeapon((byte)0);
/*     */       }
/* 235 */       this.sprintCooldown -= 1;
/* 236 */       func_70095_a(getSneakStage());
/* 237 */       if (startSprinting()) {
/* 238 */         func_70031_b(true);
/*     */       }
/* 240 */       if (stopSprinting()) {
/* 241 */         func_70031_b(false);
/*     */       }
/*     */     }
/* 244 */     if (!this.field_70170_p.field_72995_K) {
/* 245 */       sendPacketToClients();
/*     */       
/* 247 */       if ((func_70638_az() != null) && (!func_70638_az().field_70128_L) && (this.field_70146_Z.nextInt(400) == 0) && 
/* 248 */         (func_70032_d(func_70638_az()) > 4.0F) && (func_70032_d(func_70638_az()) < 12.0F)) {
/* 249 */         throwBombAt(func_70638_az());
/* 250 */         return;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void updateWeapons()
/*     */   {
/* 257 */     if (func_70638_az() != null) {
/* 258 */       int AC = func_70638_az().func_70658_aO();
/* 259 */       int bluntAC = 15;
/*     */       
/* 261 */       if (func_70093_af()) {
/* 262 */         setWeaponUsed((byte)1);
/* 263 */       } else if (AC >= bluntAC) {
/* 264 */         setWeaponUsed((byte)2);
/*     */       } else {
/* 266 */         setWeaponUsed((byte)0);
/*     */       }
/*     */     } else {
/* 269 */       setWeaponUsed((byte)0);
/*     */     }
/*     */   }
/*     */   
/*     */   private void sendPacketToClients() {
/*     */     try {
/* 275 */       Packet packet = PacketManagerMF.getEntityPacketInteger(this, this.rallyCooldown);
/* 276 */       FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72393_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, 16.0D, this.field_71093_bK, packet);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   protected void func_70664_aZ()
/*     */   {
/* 283 */     if (this.field_70122_E)
/* 284 */       super.func_70664_aZ();
/*     */   }
/*     */   
/*     */   public boolean useRanged() {
/* 288 */     return this.field_70180_af.func_75683_a(13) == 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void setWeapon(byte type)
/*     */   {
/* 296 */     this.field_70180_af.func_75692_b(13, Byte.valueOf(type));
/*     */     
/* 298 */     func_70062_b(0, getNextWeapon());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private int getType()
/*     */   {
/* 305 */     return 1;
/*     */   }
/*     */   
/*     */   private boolean startSprinting() {
/* 309 */     if (func_70661_as().func_75500_f())
/* 310 */       return false;
/* 311 */     if (func_70093_af()) {
/* 312 */       return false;
/*     */     }
/* 314 */     if (getType() == 0) {
/* 315 */       return false;
/*     */     }
/* 317 */     if (this.sprintCooldown > 0) {
/* 318 */       return true;
/*     */     }
/* 320 */     if ((func_70638_az() != null) && 
/* 321 */       (func_70032_d(func_70638_az()) > 4.0F)) {
/* 322 */       this.sprintCooldown = 20;
/* 323 */       return true;
/*     */     }
/*     */     
/* 326 */     return false;
/*     */   }
/*     */   
/*     */   private boolean stopSprinting() {
/* 330 */     if (func_70661_as().func_75500_f())
/* 331 */       return true;
/* 332 */     if (getType() == 0) {
/* 333 */       return true;
/*     */     }
/* 335 */     if (this.sprintCooldown > 0) {
/* 336 */       return false;
/*     */     }
/* 338 */     if ((func_70638_az() != null) && 
/* 339 */       (func_70032_d(func_70638_az()) < 1.5D)) {
/* 340 */       this.sprintCooldown = 0;
/* 341 */       return true;
/*     */     }
/*     */     
/* 344 */     return true;
/*     */   }
/*     */   
/*     */   private boolean getSneakStage() {
/* 348 */     if (func_70661_as().func_75500_f())
/* 349 */       return false;
/* 350 */     if (func_70051_ag()) {
/* 351 */       return false;
/*     */     }
/* 353 */     if (getType() == 0) {
/* 354 */       return false;
/*     */     }
/* 356 */     if (func_70638_az() != null) {
/* 357 */       if (!TacticalManager.isDetected(this, func_70638_az())) {
/* 358 */         return true;
/*     */       }
/* 360 */       if (this.field_70143_R > 3.0D) {
/* 361 */         return true;
/*     */       }
/*     */     }
/* 364 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isBlocking() {
/* 368 */     return getBlockTime() > 0;
/*     */   }
/*     */   
/*     */   protected boolean func_70650_aV()
/*     */   {
/* 373 */     return true;
/*     */   }
/*     */   
/*     */   public EnumCreatureAttribute func_70668_bt()
/*     */   {
/* 378 */     return EnumCreatureAttribute.UNDEAD;
/*     */   }
/*     */   
/*     */   public void func_70036_a(int x, int y, int z, int block)
/*     */   {
/* 383 */     super.func_70036_a(x, y, z, block);
/* 384 */     float volume = 0.8F;
/* 385 */     func_85030_a("mob.irongolem.walk", volume, 1.0F);
/* 386 */     if (this.field_70146_Z.nextInt(5) == 0)
/* 387 */       func_85030_a("mob.irongolem.throw", volume, 1.0F);
/* 388 */     func_85030_a("mob.skeleton.step", 0.15F, 1.0F);
/*     */   }
/*     */   
/*     */   public void func_70624_b(EntityLivingBase entity)
/*     */   {
/* 393 */     if ((entity instanceof EntityMob)) {
/* 394 */       ((EntityMob)entity).func_70624_b(null);
/* 395 */       return;
/*     */     }
/* 397 */     super.func_70624_b(entity);
/*     */   }
/*     */   
/*     */   public void rally(EntityLivingBase entity) {
/* 401 */     boolean target = (entity != null) && (!entity.field_70128_L);
/* 402 */     boolean success = false;
/*     */     
/* 404 */     this.rallyCooldown = getRallyTime();
/*     */     
/* 406 */     List<EntityLiving> mobs = this.field_70170_p.func_72872_a(EntityLiving.class, AxisAlignedBB.func_72332_a().func_72299_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70165_t + 1.0D, this.field_70163_u + 1.0D, this.field_70161_v + 1.0D).func_72314_b(64.0D, 4.0D, 64.0D));
/* 407 */     for (EntityLiving minion : mobs) {
/* 408 */       if ((minion != null) && ((minion instanceof IMob))) {
/* 409 */         success = true;
/* 410 */         spawnAngryParticle(minion);
/* 411 */         minion.func_70691_i(2.0F);
/* 412 */         if (target) {
/* 413 */           minion.func_70624_b(entity);
/* 414 */           minion.func_70661_as().func_75497_a(entity, 1.0D);
/*     */         }
/*     */       }
/*     */     }
/* 418 */     if (success) {
/* 419 */       spawnAngryParticle(this);
/*     */     }
/*     */   }
/*     */   
/*     */   private void spawnAngryParticle(Entity entity) {
/* 424 */     for (int var2 = 0; var2 < 5; var2++) {
/* 425 */       double var3 = this.field_70146_Z.nextGaussian() * 0.02D;
/* 426 */       double var5 = this.field_70146_Z.nextGaussian() * 0.02D;
/* 427 */       double var7 = this.field_70146_Z.nextGaussian() * 0.02D;
/* 428 */       this.field_70170_p.func_72869_a("angryVillager", entity.field_70165_t + this.field_70146_Z.nextFloat() * entity.field_70130_N * 2.0F - entity.field_70130_N, entity.field_70163_u + 1.0D + this.field_70146_Z.nextFloat() * entity.field_70131_O, entity.field_70161_v + this.field_70146_Z.nextFloat() * entity.field_70130_N * 2.0F - entity.field_70130_N, var3, var5, var7);
/*     */     }
/*     */   }
/*     */   
/*     */   private int getRallyTime()
/*     */   {
/* 434 */     return 400;
/*     */   }
/*     */   
/*     */   protected void func_70665_d(DamageSource source, float dam)
/*     */   {
/* 439 */     if (this.field_70170_p.field_72995_K) {
/* 440 */       return;
/*     */     }
/* 442 */     Entity en = source.func_76346_g();
/*     */     
/* 444 */     if ((isInfront(en)) && (!source.func_76363_c()) && (isBlocking())) {
/* 445 */       dam /= 2.0F;
/*     */     }
/* 447 */     if ((!this.field_70170_p.field_72995_K) && (MineFantasyBase.isDebug())) {
/* 448 */       System.out.println("Full Dam: " + dam);
/*     */     }
/* 450 */     super.func_70665_d(source, dam);
/*     */   }
/*     */   
/*     */   private boolean isInfront(Entity en) {
/* 454 */     if (en == null) {
/* 455 */       return false;
/*     */     }
/* 457 */     if (TacticalManager.isFlankedBy(en, this, 180.0F)) {
/* 458 */       return false;
/*     */     }
/* 460 */     return true;
/*     */   }
/*     */   
/*     */   public boolean func_70097_a(DamageSource source, float damage)
/*     */   {
/* 465 */     if ((source instanceof EntityDamageSourceIndirect)) {
/* 466 */       EntityDamageSourceIndirect src = (EntityDamageSourceIndirect)source;
/*     */       
/* 468 */       if ((src.func_76346_g() != null) && (src.func_76346_g() == this)) {
/* 469 */         return false;
/*     */       }
/*     */     }
/* 472 */     if (this.field_70737_aN == 0) {
/* 473 */       func_85030_a("mob.skeleton.hurt", 1.0F, 1.0F);
/*     */     }
/* 475 */     if ((!this.field_70170_p.field_72995_K) && (MineFantasyBase.isDebug())) {
/* 476 */       System.out.println("Dam: " + damage);
/*     */     }
/* 478 */     return super.func_70097_a(source, damage);
/*     */   }
/*     */   
/*     */   public boolean func_70652_k(Entity entity)
/*     */   {
/* 483 */     if (!func_70685_l(entity))
/* 484 */       return false;
/* 485 */     setWeapon((byte)0);
/* 486 */     func_71038_i();
/*     */     
/* 488 */     int knockback = 0;
/*     */     
/* 490 */     if ((entity instanceof EntityLivingBase)) {
/* 491 */       knockback += EnchantmentHelper.func_77507_b(this, (EntityLivingBase)entity);
/*     */     }
/*     */     
/* 494 */     if (func_70051_ag()) {
/* 495 */       knockback += 2;
/*     */     }
/* 497 */     if (knockback > 0) {
/* 498 */       entity.func_70024_g(-MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F) * knockback * 0.5F, 0.1D, MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F) * knockback * 0.5F);
/* 499 */       this.field_70159_w *= 0.6D;
/* 500 */       this.field_70179_y *= 0.6D;
/*     */     }
/* 502 */     return super.func_70652_k(entity);
/*     */   }
/*     */   
/*     */   public void func_82196_d(EntityLivingBase target, float damage) {
/* 506 */     if (this.field_70170_p.field_72995_K) {
/* 507 */       return;
/*     */     }
/* 509 */     if (target == null) {
/* 510 */       return;
/*     */     }
/* 512 */     if ((func_70032_d(target) < 2.0F) || (func_70093_af()) || (func_70051_ag()) || ((func_70638_az() == null) && (func_70638_az().field_70128_L))) {
/* 513 */       setWeapon((byte)0);
/* 514 */       return;
/*     */     }
/* 516 */     setWeapon((byte)1);
/* 517 */     EntityArrow entityarrow = new EntityArrowMF(this.field_70170_p, this, target, 1.6F, (float)(1.0D - this.field_70170_p.field_73013_u * 0.3D), 5);
/* 518 */     entityarrow.func_70239_b(2.0D + 2.0D * this.field_70170_p.field_73013_u);
/* 519 */     if (this.field_70146_Z.nextInt(4) == 0) {
/* 520 */       entityarrow.func_70243_d(true);
/*     */     }
/* 522 */     int i = EnchantmentHelper.func_77506_a(Enchantment.field_77345_t.field_77352_x, func_70694_bm());
/* 523 */     int j = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, func_70694_bm());
/* 524 */     entityarrow.func_70239_b(damage * 2.0F + this.field_70146_Z.nextGaussian() * 0.25D + this.field_70170_p.field_73013_u * 0.11F);
/*     */     
/* 526 */     if (i > 0) {
/* 527 */       entityarrow.func_70239_b(entityarrow.func_70242_d() + i * 0.5D + 0.5D);
/*     */     }
/*     */     
/* 530 */     if (j > 0) {
/* 531 */       entityarrow.func_70240_a(j);
/*     */     }
/*     */     
/* 534 */     if (EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, func_70694_bm()) > 0) {
/* 535 */       entityarrow.func_70015_d(100);
/*     */     }
/*     */     
/* 538 */     func_85030_a("random.bow", 1.0F, 1.0F / (func_70681_au().nextFloat() * 0.4F + 0.8F));
/* 539 */     this.field_70170_p.func_72838_d(entityarrow);
/*     */   }
/*     */   
/*     */   private void throwBombAt(EntityLivingBase target) {
/* 543 */     if ((target == null) || (!func_70685_l(target))) {
/* 544 */       return;
/*     */     }
/* 546 */     func_71038_i();
/* 547 */     EntityBombThrown bomb = new EntityBombThrown(this.field_70170_p, this, target, 1.0F, (float)(1.0D - this.field_70170_p.field_73013_u * 0.3D)).setID(0);
/* 548 */     this.field_70170_p.func_72838_d(bomb);
/*     */   }
/*     */   
/*     */   public boolean attackEntity(Entity entity) {
/* 552 */     return super.func_70652_k(entity);
/*     */   }
/*     */   
/*     */   protected String func_70639_aQ()
/*     */   {
/* 557 */     return "mob.skeleton";
/*     */   }
/*     */   
/*     */   public float getAttackStrength(Entity entity) {
/* 561 */     float dam = 2.0F;
/* 562 */     if (func_70694_bm() != null) {
/* 563 */       dam = (float)func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
/*     */     }
/*     */     
/* 566 */     if (func_70644_a(Potion.field_76420_g)) {
/* 567 */       dam += (3 << func_70660_b(Potion.field_76420_g).func_76458_c());
/*     */     }
/*     */     
/* 570 */     if (func_70644_a(Potion.field_76437_t)) {
/* 571 */       dam -= (2 << func_70660_b(Potion.field_76437_t).func_76458_c());
/*     */     }
/*     */     
/* 574 */     boolean flag = (this.field_70143_R > 0.0F) && (!this.field_70122_E) && (!func_70617_f_()) && (!func_70090_H()) && (!func_70644_a(Potion.field_76440_q)) && (this.field_70154_o == null) && ((entity instanceof EntityLivingBase));
/*     */     
/* 576 */     if ((flag) && (dam > 0.0F)) {
/* 577 */       dam += this.field_70146_Z.nextFloat() * (dam / 2.0F + 2.0F);
/*     */     }
/*     */     
/* 580 */     return dam;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected String func_70621_aR()
/*     */   {
/* 588 */     return "mob.skeletonhurt";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected String func_70673_aS()
/*     */   {
/* 596 */     return "mob.skeletonhurt";
/*     */   }
/*     */   
/*     */   public ItemStack getNextWeapon() {
/* 600 */     if (useRanged()) {
/* 601 */       return rangedItem;
/*     */     }
/* 603 */     byte wp = getLastWeaponUsed();
/*     */     
/* 605 */     if (wp == 1) {
/* 606 */       return stealthItem;
/*     */     }
/* 608 */     if (wp == 2) {
/* 609 */       return bluntItem;
/*     */     }
/* 611 */     return defaultHeldItem;
/*     */   }
/*     */   
/* 614 */   private static final ItemStack defaultHeldItem = new ItemStack(ItemListMF.broadSteel, 1);
/* 615 */   private static final ItemStack bluntItem = new ItemStack(ItemListMF.warhammerSteel, 1);
/* 616 */   private static final ItemStack stealthItem = new ItemStack(ItemListMF.daggerSteel, 1);
/* 617 */   private static final ItemStack rangedItem = new ItemStack(ItemListMF.bowComposite, 1);
/*     */   
/*     */   private int getSwingSpeedModifier() {
/* 620 */     return 6;
/*     */   }
/*     */   
/*     */   protected void func_70628_a(boolean pKill, int loot)
/*     */   {
/* 625 */     if (this.field_70170_p.field_72995_K)
/* 626 */       return;
/* 627 */     int dropSize = this.field_70146_Z.nextInt(5 + loot) + 4;
/*     */     
/*     */ 
/* 630 */     dropSize = this.field_70146_Z.nextInt(3 + loot);
/*     */     
/* 632 */     for (int count = 0; count < dropSize; count++) {
/* 633 */       func_70025_b(Item.field_77755_aX.field_77779_bT, 1);
/*     */     }
/* 635 */     ItemStack[] other = getDropItems(loot);
/* 636 */     if (other.length > 0) {
/* 637 */       for (ItemStack localItemStack : other) {}
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 642 */     for (int a = 0; a < this.field_70146_Z.nextInt(4 + loot); a++) {
/* 643 */       func_70099_a(new ItemStack(ItemListMF.bombMF, 1, 0), 0.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70014_b(NBTTagCompound tag)
/*     */   {
/* 649 */     super.func_70014_b(tag);
/* 650 */     tag.func_74774_a("Weapon", this.field_70180_af.func_75683_a(13));
/* 651 */     tag.func_74774_a("Melee", this.field_70180_af.func_75683_a(14));
/*     */   }
/*     */   
/*     */   public void func_70037_a(NBTTagCompound tag)
/*     */   {
/* 656 */     super.func_70037_a(tag);
/*     */     
/* 658 */     if (tag.func_74764_b("Weapon")) {
/* 659 */       setWeapon(tag.func_74771_c("Weapon"));
/*     */     }
/* 661 */     if (tag.func_74764_b("Melee"))
/* 662 */       setWeaponUsed(tag.func_74771_c("Melee"));
/*     */   }
/*     */   
/*     */   private ItemStack[] getDropItems(int looting) {
/* 666 */     return new ItemStack[] { getDamagedItem(defaultHeldItem), getDamagedItem(bluntItem), getDamagedItem(stealthItem), getDamagedItem(rangedItem) };
/*     */   }
/*     */   
/*     */   private ItemStack getDamagedItem(ItemStack itemstack) {
/* 670 */     if (itemstack.func_77984_f()) {
/* 671 */       int maxDamage = Math.max(itemstack.func_77958_k() - 25, 1);
/* 672 */       int damageDone = itemstack.func_77958_k() - this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(maxDamage) + 1);
/*     */       
/* 674 */       if (damageDone > maxDamage) {
/* 675 */         damageDone = maxDamage;
/*     */       }
/*     */       
/* 678 */       if (damageDone < 1) {
/* 679 */         damageDone = 1;
/*     */       }
/*     */       
/* 682 */       itemstack.func_77964_b(damageDone);
/*     */     }
/*     */     
/* 685 */     return itemstack;
/*     */   }
/*     */   
/*     */   private int getBlockTime() {
/* 689 */     return this.field_70180_af.func_75679_c(12);
/*     */   }
/*     */   
/*     */   public int getViewingArc()
/*     */   {
/* 694 */     return 70;
/*     */   }
/*     */   
/*     */   public int getHearing()
/*     */   {
/* 699 */     return 12;
/*     */   }
/*     */   
/*     */   public int getSight()
/*     */   {
/* 704 */     return -10;
/*     */   }
/*     */   
/*     */   public EntityItem dropItem(int id, int stack, int damage) {
/* 708 */     int d = damage / 2 + this.field_70146_Z.nextInt(damage / 2);
/* 709 */     return dropItemWithOffset(id, stack, d, 0.0F);
/*     */   }
/*     */   
/*     */   public EntityItem dropItemWithOffset(int id, int stack, int dam, float offset) {
/* 713 */     return func_70099_a(new ItemStack(id, stack, dam), offset);
/*     */   }
/*     */   
/*     */   protected void enchant(ItemStack item) {
/* 717 */     if ((item != null) && (item.func_77948_v())) {
/* 718 */       return;
/*     */     }
/* 720 */     if ((item != null) && (this.field_70146_Z.nextFloat() < enchantmentProbability[this.field_70170_p.field_73013_u])) {
/* 721 */       EnchantmentHelper.func_77504_a(this.field_70146_Z, item, 5 + this.field_70170_p.field_73013_u * this.field_70146_Z.nextInt(6));
/*     */     }
/*     */   }
/*     */   
/*     */   public void recievePacket(ByteArrayDataInput data)
/*     */   {
/*     */     try {
/* 728 */       this.rallyCooldown = data.readInt();
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private byte getLastWeaponUsed()
/*     */   {
/* 738 */     return this.field_70180_af.func_75683_a(14);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void setWeaponUsed(byte id)
/*     */   {
/* 745 */     this.field_70180_af.func_75692_b(14, Byte.valueOf(id));
/*     */   }
/*     */   
/*     */   public void func_70653_a(Entity entity, float x, double y, double z) {}
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/EntitySkeletalKnight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */