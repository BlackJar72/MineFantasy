/*     */ package minefantasy.entity;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.PrintStream;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.api.tactic.ISpecialSenses;
/*     */ import minefantasy.entity.ai.drake.EntityAIFindCave;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.system.MFCalculate;
/*     */ import minefantasy.system.MFResource;
/*     */ import minefantasy.system.cfg;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockGrass;
/*     */ import net.minecraft.entity.DataWatcher;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.EntityLivingData;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAttackOnCollide;
/*     */ import net.minecraft.entity.ai.EntityAIHurtByTarget;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
/*     */ import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAITasks;
/*     */ import net.minecraft.entity.ai.EntityAIWander;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.ai.attributes.AttributeInstance;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntitySkeleton;
/*     */ import net.minecraft.entity.passive.EntityVillager;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.pathfinding.PathNavigate;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.DamageSource;
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
/*     */ public class EntityDrake
/*     */   extends EntityDaymob
/*     */   implements ISpecialSenses, IGrowable
/*     */ {
/*  60 */   private int mouthAngle = 0;
/*     */   public int tailIdleY;
/*     */   public int armScratch;
/*     */   public int scratchTime;
/*     */   public int tailDirY;
/*  65 */   private int age = 100;
/*  66 */   private int maxAge = 100;
/*  67 */   private final int dataWMin = 13;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public byte state;
/*     */   
/*     */ 
/*     */ 
/*  76 */   private int[] home = { 0, 0, 0 };
/*     */   private boolean hasHome;
/*     */   
/*     */   public EntityDrake(World world) {
/*  80 */     super(world);
/*     */     
/*  82 */     this.field_70138_W = 1.0F;
/*  83 */     syncStats();
/*  84 */     this.field_70728_aV = 20;
/*  85 */     func_70606_j(func_110138_aP());
/*  86 */     this.field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
/*  87 */     this.field_70714_bg.func_75776_a(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, true));
/*  88 */     this.field_70714_bg.func_75776_a(3, new EntityAIAttackOnCollide(this, EntityLiving.class, 1.0D, false));
/*  89 */     this.field_70714_bg.func_75776_a(3, new EntityAIFindCave(this, 1.0F));
/*  90 */     this.field_70714_bg.func_75776_a(5, new EntityAIMoveThroughVillage(this, 1.0D, false));
/*  91 */     this.field_70714_bg.func_75776_a(6, new EntityAIWander(this, 0.800000011920929D));
/*  92 */     this.field_70714_bg.func_75776_a(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
/*  93 */     this.field_70714_bg.func_75776_a(7, new EntityAILookIdle(this));
/*  94 */     this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, false));
/*  95 */     this.field_70715_bh.func_75776_a(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
/*  96 */     this.field_70715_bh.func_75776_a(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
/*     */   }
/*     */   
/*     */   protected void func_110147_ax()
/*     */   {
/* 101 */     super.func_110147_ax();
/* 102 */     func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(32.0D);
/* 103 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(getMoveSpeed());
/* 104 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(30.0D);
/*     */   }
/*     */   
/*     */   public EntityDrake(World world, double x, double y, double z, int a) {
/* 108 */     this(world);
/* 109 */     func_70107_b(x, y, z);
/* 110 */     setAge(a);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int func_70641_bl()
/*     */   {
/* 117 */     return 2;
/*     */   }
/*     */   
/*     */   private void setAge(int i) {
/* 121 */     this.age = i;
/* 122 */     float scw = getScaleOnAge() * 1.5F * getScaleOnBreed();
/* 123 */     float sch = getScaleOnAge() * 2.5F * getScaleOnBreed();
/* 124 */     func_70105_a(scw, sch);
/* 125 */     this.field_70163_u += 0.02D;
/* 126 */     setSpeed(getMoveSpeed());
/* 127 */     setMaxHealthStat(getMaxHealthStat());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public float func_70783_a(int x, int y, int z)
/*     */   {
/* 136 */     if (this.state == 1) {
/* 137 */       return 0.5F - this.field_70170_p.func_72801_o(x, y, z);
/*     */     }
/*     */     
/* 140 */     return this.field_70170_p.func_72798_a(x, y - 1, z) == Block.field_71980_u.field_71990_ca ? 10.0F : this.field_70170_p.func_72801_o(x, y, z) - 0.5F;
/*     */   }
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource source, int dam)
/*     */   {
/* 145 */     if ((source.func_76346_g() != null) && ((source.func_76346_g() instanceof EntityLiving)) && (getLifeStage() <= 1)) {
/* 146 */       AxisAlignedBB search = this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D);
/* 147 */       List<EntityDrake> friends = this.field_70170_p.func_72872_a(EntityDrake.class, search);
/* 148 */       for (EntityDrake drake : friends) {
/* 149 */         drake.func_70624_b((EntityLiving)source.func_76346_g());
/*     */       }
/*     */     }
/* 152 */     return super.attackEntityFrom(source, dam);
/*     */   }
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer player)
/*     */   {
/* 157 */     if ((player.func_71045_bC() == null) && (getLifeStage() == 0))
/* 158 */       player.func_71038_i();
/* 159 */     if ((player.func_71045_bC() == null) && (getLifeStage() == 0) && (this.field_70146_Z.nextInt(5) == 0)) {
/* 160 */       player.func_70097_a(DamageSource.func_76358_a(this), 1.0F);
/* 161 */       this.mouthAngle = 10;
/* 162 */       func_70642_aH();
/*     */     }
/* 164 */     return super.func_70085_c(player);
/*     */   }
/*     */   
/*     */   public float getMaxHealthStat() {
/* 168 */     return (int)(30.0F * getScaleOnAge() * getTerritoryBuff()) * getBreedHpMod();
/*     */   }
/*     */   
/*     */   private float getBreedHpMod() {
/* 172 */     return 1.0F + 2.0F * getBreed();
/*     */   }
/*     */   
/*     */   private float getBreedAcMod() {
/* 176 */     return 1.0F + 1.0F * getBreed();
/*     */   }
/*     */   
/*     */   private float getBreedDamMod() {
/* 180 */     return 1.0F + 0.6F * getBreed();
/*     */   }
/*     */   
/*     */   public void setMaxHealthStat(float f) {
/* 184 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(f);
/*     */   }
/*     */   
/*     */   public void setSpeed(float speed) {
/* 188 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(speed);
/*     */   }
/*     */   
/*     */   public int func_70627_aG()
/*     */   {
/* 193 */     return 240;
/*     */   }
/*     */   
/*     */   public void func_70088_a()
/*     */   {
/* 198 */     super.func_70088_a();
/* 199 */     this.field_70180_af.func_75682_a(13, Integer.valueOf(this.mouthAngle));
/* 200 */     this.field_70180_af.func_75682_a(14, Integer.valueOf(0));
/* 201 */     this.field_70180_af.func_75682_a(15, Integer.valueOf(this.age));
/* 202 */     this.field_70180_af.func_75682_a(16, Integer.valueOf(0));
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float getMouthAngle() {
/* 207 */     int angle = this.mouthAngle;
/* 208 */     if (angle < -10)
/* 209 */       angle = -10;
/* 210 */     if (angle > 10)
/* 211 */       angle = 10;
/* 212 */     return angle * 2;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float getTailYAngle() {
/* 217 */     int angle = this.tailIdleY;
/* 218 */     if (angle > 20)
/* 219 */       angle = 20;
/* 220 */     return angle;
/*     */   }
/*     */   
/*     */   public void func_70636_d()
/*     */   {
/* 225 */     super.func_70636_d();
/* 226 */     if (this.field_70170_p.func_82737_E() <= 2L)
/* 227 */       func_70106_y();
/* 228 */     if (this.mouthAngle > 0)
/* 229 */       this.mouthAngle -= 1;
/* 230 */     if (this.field_70170_p.field_72995_K) {
/* 231 */       this.mouthAngle = this.field_70180_af.func_75679_c(13);
/* 232 */       this.age = this.field_70180_af.func_75679_c(15);
/*     */     } else {
/* 234 */       if (this.field_70173_aa % 20 == 0) {}
/*     */       
/* 236 */       this.field_70180_af.func_75692_b(13, Integer.valueOf(this.mouthAngle));
/* 237 */       this.field_70180_af.func_75692_b(14, Integer.valueOf(isIdle() ? 1 : 0));
/* 238 */       this.field_70180_af.func_75692_b(15, Integer.valueOf(this.age));
/*     */       
/* 240 */       if (this.field_70173_aa % getAgeMultiplier() == 0) {
/* 241 */         grow();
/*     */       }
/*     */       
/* 244 */       if (this.field_70173_aa % 100 == 0) {
/* 245 */         func_70691_i(1.0F);
/*     */       }
/*     */       
/* 248 */       if ((!this.hasHome) && (this.state == 0) && (getLifeStage() == 3) && (this.field_70146_Z.nextInt(8000) == 0)) {
/* 249 */         AxisAlignedBB bb = this.field_70121_D.func_72314_b(64.0D, 32.0D, 64.0D);
/* 250 */         if (this.field_70170_p.func_72872_a(EntityDrake.class, bb).size() < 5) {
/* 251 */           this.state = 1;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 256 */     if (this.field_70170_p.field_72995_K) {
/* 257 */       if (this.tailDirY == 0)
/*     */       {
/* 259 */         this.tailIdleY -= 3;
/* 260 */         if (this.tailIdleY <= -15)
/* 261 */           this.tailDirY = 1;
/*     */       }
/* 263 */       if (this.tailDirY == 1)
/*     */       {
/* 265 */         this.tailIdleY += 3;
/* 266 */         if (this.tailIdleY >= 15)
/* 267 */           this.tailDirY = 0;
/*     */       }
/* 269 */       if ((this.tailIdleY == 0) && 
/* 270 */         (this.field_70146_Z.nextInt(3) == 0)) {
/* 271 */         this.tailDirY = 2;
/*     */       }
/*     */       
/* 274 */       if (this.field_70146_Z.nextInt(100) == 0) {
/* 275 */         this.tailDirY = this.field_70146_Z.nextInt(1);
/*     */       }
/* 277 */       if (this.scratchTime > 0) {
/* 278 */         if (!isIdle()) {
/* 279 */           this.scratchTime = (this.armScratch = 0);
/*     */         }
/* 281 */         this.scratchTime -= 1;
/* 282 */         this.armScratch -= 1;
/* 283 */         if (this.armScratch <= 0) {
/* 284 */           this.armScratch = 5;
/*     */         }
/* 286 */       } else if ((this.field_70146_Z.nextInt(500) == 0) && (isIdle())) {
/* 287 */         this.scratchTime = (30 + this.field_70146_Z.nextInt(50));
/* 288 */         this.armScratch = 5;
/*     */       } else {
/* 290 */         this.armScratch = 0;
/*     */       }
/*     */     }
/*     */     
/* 294 */     if ((this.state == 1) && (!this.hasHome) && 
/* 295 */       (!this.field_70170_p.func_72937_j((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v))) {
/* 296 */       int chance = this.field_70170_p.func_72957_l((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
/* 297 */       if (this.field_70170_p.func_72798_a((int)this.field_70165_t, (int)this.field_70163_u - 1, (int)this.field_70161_v) == Block.field_71981_t.field_71990_ca)
/* 298 */         chance += 9000;
/* 299 */       if ((chance < 5) || (this.field_70146_Z.nextInt(1000000) < chance)) {
/* 300 */         AxisAlignedBB search = this.field_70121_D.func_72314_b(64.0D, 32.0D, 64.0D);
/* 301 */         List drakes = this.field_70170_p.func_72872_a(EntityDrake.class, search);
/* 302 */         if (drakes.size() < 8) {
/* 303 */           settle((int)this.field_70165_t, (int)this.field_70163_u - 1, (int)this.field_70161_v);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 308 */     if (this.hasHome) {
/* 309 */       double distance = func_70011_f(this.home[0], this.home[1], this.home[2]);
/* 310 */       if (distance > 8.0D) {
/* 311 */         func_70624_b(null);
/* 312 */         func_70661_as().func_75492_a(this.home[0], this.home[1], this.home[2], getMoveSpeed());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public float getMoveSpeed() {
/* 318 */     return 0.5F * getScaleOnAge();
/*     */   }
/*     */   
/*     */   private void syncStats() {
/* 322 */     setSpeed(getMoveSpeed());
/* 323 */     setMaxHealthStat(getMaxHealthStat());
/*     */   }
/*     */   
/*     */ 
/*     */   private int getAgeMultiplier()
/*     */   {
/* 329 */     return (int)MFCalculate.getTicksForMinutes(2);
/*     */   }
/*     */   
/*     */   private boolean isIdle() {
/* 333 */     if (this.field_70170_p.field_72995_K) {
/* 334 */       return this.field_70180_af.func_75679_c(14) == 1;
/*     */     }
/* 336 */     return (func_70638_az() == null) && (func_70661_as().func_75500_f());
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_70642_aH()
/*     */   {
/* 342 */     super.func_70642_aH();
/* 343 */     this.mouthAngle = 20;
/*     */   }
/*     */   
/*     */   public int func_70658_aO()
/*     */   {
/* 348 */     return (int)(5.0F * getScaleOnAge() * getBreedAcMod());
/*     */   }
/*     */   
/*     */   protected boolean func_70650_aV()
/*     */   {
/* 353 */     return true;
/*     */   }
/*     */   
/*     */   public boolean func_70601_bi()
/*     */   {
/* 358 */     if (this.field_70146_Z.nextInt(10) != 0) {
/* 359 */       return false;
/*     */     }
/*     */     
/* 362 */     AxisAlignedBB bb = this.field_70121_D.func_72314_b(200.0D, 100.0D, 200.0D);
/* 363 */     List<EntityDrake> list2 = this.field_70170_p.func_72872_a(EntityDrake.class, bb);
/* 364 */     if (list2.size() > 5) {
/* 365 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 370 */     return super.func_70601_bi();
/*     */   }
/*     */   
/*     */   public boolean func_70652_k(Entity entity) {
/* 374 */     if (!func_70685_l(entity)) {
/* 375 */       return false;
/*     */     }
/* 377 */     this.mouthAngle = 11;
/* 378 */     return super.func_70652_k(entity);
/*     */   }
/*     */   
/*     */   public float getAttackStrength(Entity entity)
/*     */   {
/* 383 */     return (int)(5.0F * getScaleOnAge() * getTerritoryBuff() * getBreedDamMod());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected String func_70639_aQ()
/*     */   {
/* 390 */     return MFResource.sound("mob.drakeidle");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected String func_70621_aR()
/*     */   {
/* 397 */     return MFResource.sound("mob.drakehurt");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected String func_70673_aS()
/*     */   {
/* 404 */     return MFResource.sound("mob.drakeidle");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void func_70036_a(int par1, int par2, int par3, int par4)
/*     */   {
/* 411 */     func_85030_a(MFResource.sound("mob.drakestep"), 0.15F, 1.0F);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected int func_70633_aT()
/*     */   {
/* 418 */     return 0;
/*     */   }
/*     */   
/*     */   protected void func_70600_l(int par1) {}
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float getScratchForDisplay()
/*     */   {
/* 426 */     int time = 5 - this.armScratch;
/* 427 */     return 20 * time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70014_b(NBTTagCompound nbt)
/*     */   {
/* 434 */     super.func_70014_b(nbt);
/* 435 */     nbt.func_74768_a("Age", this.age);
/* 436 */     nbt.func_74768_a("Breed", getBreed());
/* 437 */     nbt.func_74774_a("DarkeState", this.state);
/* 438 */     nbt.func_74783_a("Territory", this.home);
/* 439 */     nbt.func_74757_a("hasHome", this.hasHome);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70037_a(NBTTagCompound nbt)
/*     */   {
/* 446 */     super.func_70037_a(nbt);
/* 447 */     setAge(nbt.func_74762_e("Age"));
/* 448 */     this.state = nbt.func_74771_c("DarkeState");
/* 449 */     this.home = nbt.func_74759_k("Territory");
/* 450 */     this.hasHome = nbt.func_74767_n("hasHome");
/* 451 */     if (nbt.func_74764_b("Breed")) {
/* 452 */       setBreed(nbt.func_74762_e("Breed"));
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70624_b(EntityLivingBase entity)
/*     */   {
/* 458 */     if (getLifeStage() >= 2) {
/* 459 */       super.func_70624_b(entity);
/*     */     }
/*     */   }
/*     */   
/*     */   public int getViewingArc() {
/* 464 */     return 270;
/*     */   }
/*     */   
/*     */   public int getHearing()
/*     */   {
/* 469 */     return 0;
/*     */   }
/*     */   
/*     */   public int getSight()
/*     */   {
/* 474 */     return 15;
/*     */   }
/*     */   
/*     */   public float getTotalScale()
/*     */   {
/* 479 */     return getScaleOnAge() * getScaleOnBreed() * 0.8F;
/*     */   }
/*     */   
/*     */   private float getScaleOnAge() {
/* 483 */     return this.age > 10 ? 0.01F * this.age : 0.1F;
/*     */   }
/*     */   
/*     */   public float func_70647_i()
/*     */   {
/* 488 */     float pitchDown = 1.0F * getScaleOnAge();
/* 489 */     return 2.0F - pitchDown;
/*     */   }
/*     */   
/*     */   public float func_70599_aP()
/*     */   {
/* 494 */     float volumeUp = 0.75F * getScaleOnAge();
/* 495 */     return 0.25F + volumeUp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public byte getLifeStage()
/*     */   {
/* 504 */     if (this.age > 60)
/* 505 */       return 3;
/* 506 */     if (this.age > 30)
/* 507 */       return 2;
/* 508 */     if (this.age > 10)
/* 509 */       return 1;
/* 510 */     if (this.age > 0)
/* 511 */       return 0;
/* 512 */     return 3;
/*     */   }
/*     */   
/*     */   private void spawnHatchlings() {
/* 516 */     if (this.field_70170_p.field_72995_K)
/* 517 */       return;
/* 518 */     int amount = this.field_70146_Z.nextInt(3) + 1;
/* 519 */     for (int a = 0; a < amount; a++) {
/* 520 */       EntityDrake hatchling = new EntityDrake(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, 1);
/* 521 */       this.field_70170_p.func_72838_d(hatchling);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_70631_g_() {
/* 526 */     return getLifeStage() <= 1;
/*     */   }
/*     */   
/*     */   public void grow() {
/* 530 */     if ((hasRoomToGrow()) && (this.age < this.maxAge)) {
/* 531 */       int age2 = this.age + 1;
/* 532 */       setAge(age2);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean hasRoomToGrow() {
/* 537 */     for (int var1 = 0; var1 < 8; var1++) {
/* 538 */       float var2 = ((var1 >> 0) % 2 - 0.5F) * this.field_70130_N * 1.1F;
/* 539 */       float var3 = ((var1 >> 1) % 2 - 0.5F) * 0.1F;
/* 540 */       float var4 = ((var1 >> 2) % 2 - 0.5F) * this.field_70130_N * 1.1F;
/* 541 */       int var5 = MathHelper.func_76128_c(this.field_70165_t + var2);
/* 542 */       int var6 = MathHelper.func_76128_c(this.field_70163_u + func_70047_e() + var3);
/* 543 */       int var7 = MathHelper.func_76128_c(this.field_70161_v + var4);
/*     */       
/* 545 */       if (this.field_70170_p.func_72809_s(var5, var6, var7)) {
/* 546 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 550 */     return true;
/*     */   }
/*     */   
/*     */   private void settle(int x, int y, int z) {
/* 554 */     if (this.hasHome)
/* 555 */       return;
/* 556 */     if (this.state == 2) {
/* 557 */       return;
/*     */     }
/* 559 */     if (MineFantasyBase.isDebug()) {
/* 560 */       System.out.println("Drake Settle");
/*     */     }
/*     */     
/* 563 */     this.home[0] = x;
/* 564 */     this.home[1] = y;
/* 565 */     this.home[2] = z;
/* 566 */     this.hasHome = true;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 572 */     float buff = getTerritoryBuff();
/* 573 */     this.state = 2;
/* 574 */     int heal = (int)(func_110138_aP() * (getTerritoryBuff() - 1.0F));
/* 575 */     func_70691_i(heal);
/* 576 */     spawnHatchlings();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private float getTerritoryBuff()
/*     */   {
/* 584 */     if (this.state != 2) {
/* 585 */       return 1.0F;
/*     */     }
/* 587 */     int diff = this.field_70170_p.field_73013_u;
/* 588 */     float buff = 1.0F;
/* 589 */     if (diff == 2)
/* 590 */       buff = 1.5F;
/* 591 */     if (diff == 3) {
/* 592 */       buff = 2.0F;
/*     */     }
/* 594 */     return buff;
/*     */   }
/*     */   
/*     */   public double getDistanceToSpawn()
/*     */   {
/* 599 */     return cfg.drakeDistance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void func_70628_a(boolean playerKill, int looting)
/*     */   {
/* 606 */     int amount = this.field_70146_Z.nextInt(2) + this.field_70146_Z.nextInt(1 + looting) + (int)getScaleOnAge();
/*     */     
/* 608 */     for (int counter = 0; counter < amount; counter++) {
/* 609 */       if (func_70027_ad()) {
/* 610 */         func_70025_b(ItemListMF.drakeCooked.field_77779_bT, 1);
/*     */       } else {
/* 612 */         func_70025_b(ItemListMF.drakeRaw.field_77779_bT, 1);
/*     */       }
/*     */     }
/*     */     
/* 616 */     amount = (getScaleOnAge() > 0.5F ? 1 : 0) + this.field_70146_Z.nextInt(1 + looting);
/*     */     
/* 618 */     for (counter = 0; counter < amount; counter++) {
/* 619 */       dropItem(ItemListMF.misc.field_77779_bT, 1, 101);
/*     */     }
/*     */   }
/*     */   
/*     */   public EntityItem dropItem(int id, int num, int dam) {
/* 624 */     return dropItemWithOffset(id, num, dam, 0.0F);
/*     */   }
/*     */   
/*     */   public EntityItem dropItemWithOffset(int id, int stack, int damage, float offset) {
/* 628 */     return func_70099_a(new ItemStack(id, stack, damage), offset);
/*     */   }
/*     */   
/*     */   public void func_70108_f(Entity entity)
/*     */   {
/* 633 */     if (((entity instanceof EntitySkeleton)) && (this.field_70154_o == null) && (!entity.func_70115_ae())) {
/* 634 */       entity.func_70078_a(this);
/*     */       
/* 636 */       func_70071_h_();
/* 637 */       entity.func_70071_h_();
/*     */     }
/* 639 */     super.func_70108_f(entity);
/*     */   }
/*     */   
/*     */   public double func_70042_X()
/*     */   {
/* 644 */     return (super.func_70042_X() + 0.5D) * getTotalScale();
/*     */   }
/*     */   
/*     */   private void setBreed(int i) {
/* 648 */     this.field_70180_af.func_75692_b(16, Integer.valueOf(i));
/*     */   }
/*     */   
/*     */   public int getBreed() {
/* 652 */     return this.field_70180_af.func_75679_c(16);
/*     */   }
/*     */   
/*     */   public EntityLivingData func_110161_a(EntityLivingData data)
/*     */   {
/* 657 */     double distance = getDistanceAway();
/*     */     
/* 659 */     if (distance > getDistanceToSpawn() * 3.0D) {
/* 660 */       setBreed(2);
/* 661 */     } else if (distance > getDistanceToSpawn() * 2.0D) {
/* 662 */       setBreed(1);
/*     */     } else {
/* 664 */       setBreed(0);
/*     */     }
/*     */     
/* 667 */     setAge(100);
/* 668 */     if (this.field_70146_Z.nextInt(3) == 0) {
/* 669 */       setAge(50);
/*     */     }
/* 671 */     return super.func_110161_a(data);
/*     */   }
/*     */   
/*     */   private double getDistanceAway() {
/* 675 */     ChunkCoordinates spawn = this.field_70170_p.func_72861_E();
/* 676 */     return func_70011_f(spawn.field_71574_a, spawn.field_71572_b, spawn.field_71573_c);
/*     */   }
/*     */   
/*     */   private float getScaleOnBreed() {
/* 680 */     if (getBreed() == 2) {
/* 681 */       return 1.1F;
/*     */     }
/* 683 */     return 1.0F;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/* 688 */     int b = getBreed();
/* 689 */     if (b == 1) {
/* 690 */       return "DrakeBlue";
/*     */     }
/* 692 */     if (b == 2) {
/* 693 */       return "DrakeGold";
/*     */     }
/* 695 */     return "Drake";
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/EntityDrake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */