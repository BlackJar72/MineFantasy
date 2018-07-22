/*     */ package minefantasy.entity;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.system.MFResource;
/*     */ import minefantasy.system.TacticalManager;
/*     */ import minefantasy.system.cfg;
/*     */ import net.minecraft.entity.DataWatcher;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAttackOnCollide;
/*     */ import net.minecraft.entity.ai.EntityAIHurtByTarget;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAITasks;
/*     */ import net.minecraft.entity.ai.EntityAIWander;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.ai.attributes.AttributeInstance;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.passive.EntityVillager;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.pathfinding.PathNavigate;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.util.Vec3Pool;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class EntityBasilisk
/*     */   extends EntityMob
/*     */ {
/*     */   public EntityBasilisk(World world)
/*     */   {
/*  48 */     super(world);
/*     */     
/*  50 */     func_70105_a(2.0F, 1.0F);
/*  51 */     applyRandomBreed();
/*     */     
/*  53 */     this.field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
/*  54 */     this.field_70714_bg.func_75776_a(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
/*  55 */     this.field_70714_bg.func_75776_a(3, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true));
/*  56 */     this.field_70714_bg.func_75776_a(6, new EntityAIWander(this, 1.0D));
/*  57 */     this.field_70714_bg.func_75776_a(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
/*  58 */     this.field_70714_bg.func_75776_a(7, new EntityAILookIdle(this));
/*  59 */     this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, true));
/*  60 */     this.field_70715_bh.func_75776_a(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
/*  61 */     this.field_70715_bh.func_75776_a(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
/*     */   }
/*     */   
/*     */   protected void func_110147_ax()
/*     */   {
/*  66 */     super.func_110147_ax();
/*  67 */     func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(16.0D);
/*  68 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23000000417232513D);
/*  69 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(4.0D);
/*  70 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(30.0D);
/*     */   }
/*     */   
/*     */   public boolean func_70601_bi()
/*     */   {
/*  75 */     if ((this.field_71093_bK != -1) && (this.field_70146_Z.nextInt(10) != 0)) {
/*  76 */       return false;
/*     */     }
/*  78 */     if (!canSpawnAtPos()) {
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     return super.func_70601_bi();
/*     */   }
/*     */   
/*     */   public boolean canSpawnAtPos()
/*     */   {
/*  87 */     if (this.field_71093_bK != 0) {
/*  88 */       return true;
/*     */     }
/*  90 */     ChunkCoordinates spawn = this.field_70170_p.func_72861_E();
/*     */     
/*  92 */     if (!this.field_70170_p.func_72937_j((int)this.field_70165_t, (int)this.field_70163_u + 1, (int)this.field_70161_v)) {
/*  93 */       return false;
/*     */     }
/*  95 */     return func_70011_f(spawn.field_71574_a, spawn.field_71572_b, spawn.field_71573_c) > cfg.basiliskDistance;
/*     */   }
/*     */   
/*     */   public int func_70658_aO()
/*     */   {
/* 100 */     switch (getBreed()) {
/*     */     case 0: 
/* 102 */       return 10;
/*     */     case 1: 
/* 104 */       return 15;
/*     */     case 2: 
/* 106 */       return 20;
/*     */     }
/* 108 */     return super.func_70658_aO();
/*     */   }
/*     */   
/*     */   public boolean func_70097_a(DamageSource source, float dam)
/*     */   {
/* 113 */     setMouthTicks(10);
/* 114 */     return super.func_70097_a(source, dam);
/*     */   }
/*     */   
/*     */   protected void func_70088_a() {
/* 118 */     super.func_70088_a();
/* 119 */     func_70096_w().func_75682_a(12, Byte.valueOf((byte)-1));
/* 120 */     func_70096_w().func_75682_a(13, Integer.valueOf(0));
/* 121 */     func_70096_w().func_75682_a(14, Integer.valueOf(0));
/*     */   }
/*     */   
/*     */   public void setBreed(byte breed) {
/* 125 */     if (breed == 2) {
/* 126 */       this.field_70178_ae = true;
/*     */     } else {
/* 128 */       this.field_70178_ae = false;
/*     */     }
/* 130 */     func_70096_w().func_75692_b(12, Byte.valueOf(breed));
/*     */     
/* 132 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(getBreedHealth());
/* 133 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(getAttackStrength());
/*     */   }
/*     */   
/*     */   public void setMouthTicks(int tick) {
/* 137 */     func_70096_w().func_75692_b(13, Integer.valueOf(tick));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public byte getBreed()
/*     */   {
/* 146 */     return func_70096_w().func_75683_a(12);
/*     */   }
/*     */   
/*     */   public int getMouthTicks() {
/* 150 */     return func_70096_w().func_75679_c(13);
/*     */   }
/*     */   
/*     */   public void setGazeTime(int tick) {
/* 154 */     func_70096_w().func_75692_b(14, Integer.valueOf(tick));
/*     */   }
/*     */   
/*     */   public int getGazeTime() {
/* 158 */     return func_70096_w().func_75679_c(14);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void applyRandomBreed()
/*     */   {
/* 165 */     if (this.field_71093_bK == -1) {
/* 166 */       setBreed((byte)2);
/* 167 */       func_70105_a(3.0F, 2.0F);
/*     */     }
/* 169 */     else if ((this.field_70146_Z.nextInt(3) == 0) && (getDistanceAway() > cfg.basiliskDistance * 2)) {
/* 170 */       setBreed((byte)1);
/*     */     } else {
/* 172 */       setBreed((byte)0);
/*     */     }
/* 174 */     func_70606_j(func_110138_aP());
/*     */   }
/*     */   
/*     */   public float getBreedHealth() {
/* 178 */     if (getBreed() == 2) {
/* 179 */       return 60.0F;
/*     */     }
/* 181 */     return 30.0F;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/* 186 */     return MFResource.image("/mob/Basilisk" + getBreedStr() + ".png");
/*     */   }
/*     */   
/*     */   public float getAttackStrength() {
/* 190 */     switch (getBreed()) {
/*     */     case 1: 
/* 192 */       return 10.0F;
/*     */     case 2: 
/* 194 */       return 12.0F;
/*     */     }
/* 196 */     return 8.0F;
/*     */   }
/*     */   
/*     */   public void func_70636_d()
/*     */   {
/* 201 */     super.func_70636_d();
/*     */     
/* 203 */     if (!this.field_70170_p.field_72995_K) {
/* 204 */       int sndTimer = getGazeTime();
/* 205 */       if (sndTimer > 0)
/* 206 */         sndTimer--;
/* 207 */       setGazeTime(sndTimer);
/*     */       
/* 209 */       int mouth = getMouthTicks();
/* 210 */       if (mouth > 0)
/* 211 */         mouth--;
/* 212 */       setMouthTicks(mouth);
/*     */       
/* 214 */       for (int a = 0; a < this.field_70170_p.field_73010_i.size(); a++) {
/* 215 */         EntityPlayer pl = (EntityPlayer)this.field_70170_p.field_73010_i.get(a);
/*     */         
/* 217 */         if ((isCrosshairOver(pl)) && 
/* 218 */           (!pl.field_71075_bZ.field_75098_d)) {
/* 219 */           applyGaze(pl);
/*     */         }
/*     */       }
/* 222 */       if (func_70638_az() != null) {
/* 223 */         EntityLivingBase tar = func_70643_av();
/* 224 */         if ((tar != null) && (tar != this.field_70153_n) && (!(tar instanceof EntityBasilisk)) && (tar != this) && 
/* 225 */           (!(tar instanceof EntityPlayer)) && 
/* 226 */           (func_70685_l(tar)) && (!TacticalManager.isFlankedBy(this, tar, 270.0F)) && (!TacticalManager.isFlankedBy(tar, this, 270.0F))) {
/* 227 */           applyGaze(tar);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public String getBreedStr()
/*     */   {
/* 236 */     if (getBreed() == 1)
/* 237 */       return "Stone";
/* 238 */     if (getBreed() == 2)
/* 239 */       return "Fire";
/* 240 */     return "";
/*     */   }
/*     */   
/*     */   protected boolean func_70650_aV()
/*     */   {
/* 245 */     return true;
/*     */   }
/*     */   
/*     */   public void func_70014_b(NBTTagCompound nbt) {
/* 249 */     super.func_70014_b(nbt);
/*     */     
/* 251 */     nbt.func_74774_a("Breed", getBreed());
/* 252 */     nbt.func_74768_a("Gaze", getGazeTime());
/*     */   }
/*     */   
/*     */   public void func_70037_a(NBTTagCompound nbt) {
/* 256 */     super.func_70037_a(nbt);
/*     */     
/* 258 */     setBreed(nbt.func_74771_c("Breed"));
/* 259 */     setGazeTime(nbt.func_74762_e("Gaze"));
/*     */   }
/*     */   
/*     */   public boolean isCrosshairOver(EntityPlayer player) {
/* 263 */     if (!TacticalManager.isFlankedBy(player, this, 270.0F)) {
/* 264 */       Vec3 var3 = player.func_70676_i(1.0F).func_72432_b();
/* 265 */       Vec3 var4 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t - player.field_70165_t, this.field_70121_D.field_72338_b + this.field_70131_O / 2.0F - (player.field_70163_u + player.func_70047_e()), this.field_70161_v - player.field_70161_v);
/* 266 */       double var5 = var4.func_72433_c();
/* 267 */       var4 = var4.func_72432_b();
/* 268 */       double var7 = var3.func_72430_b(var4);
/* 269 */       return var7 > 1.0D - 0.025D / var5 ? player.func_70685_l(this) : false;
/*     */     }
/* 271 */     return false;
/*     */   }
/*     */   
/*     */   public void applyGaze(EntityLivingBase target) {
/* 275 */     if (this.field_70170_p.field_72995_K) {
/* 276 */       return;
/*     */     }
/* 278 */     if (getGazeTime() > 0) {
/* 279 */       return;
/*     */     }
/* 281 */     boolean hit = false;
/* 282 */     byte breed = getBreed();
/* 283 */     int diff = this.field_70170_p.field_73013_u;
/*     */     
/* 285 */     if (getBreed() == 0)
/*     */     {
/* 287 */       target.func_70690_d(new PotionEffect(Potion.field_76436_u.field_76415_H, 200 * diff, 1));
/*     */     }
/* 289 */     if (getBreed() == 1)
/*     */     {
/* 291 */       target.func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 300 * diff, 100));
/* 292 */       target.func_70690_d(new PotionEffect(Potion.field_76419_f.field_76415_H, 300 * diff, 100));
/*     */     }
/* 294 */     if (getBreed() == 2)
/*     */     {
/* 296 */       target.func_70015_d(5 * diff);
/*     */     }
/*     */     
/* 299 */     if (func_70638_az() == null) {
/* 300 */       func_70624_b(target);
/* 301 */       func_70661_as().func_75497_a(target, 0.2199999988079071D);
/*     */     }
/*     */     
/* 304 */     this.field_70170_p.func_72956_a(target, "mob.zombie.unfect", 1.0F, 1.0F);
/* 305 */     setGazeTime(getCooldown());
/*     */   }
/*     */   
/*     */   private int getCooldown() {
/* 309 */     if (getBreed() == 2) {
/* 310 */       return 40;
/*     */     }
/* 312 */     return 60;
/*     */   }
/*     */   
/*     */   public boolean func_70652_k(Entity en)
/*     */   {
/* 317 */     if (!func_70685_l(en)) {
/* 318 */       return false;
/*     */     }
/* 320 */     setMouthTicks(10);
/* 321 */     this.field_70170_p.func_72956_a(this, MFResource.sound("mob.bite"), 1.0F, 1.0F);
/* 322 */     return super.func_70652_k(en);
/*     */   }
/*     */   
/*     */   public void func_70645_a(DamageSource source)
/*     */   {
/* 327 */     super.func_70645_a(source);
/* 328 */     setMouthTicks(10);
/*     */   }
/*     */   
/*     */   protected String func_70639_aQ()
/*     */   {
/* 333 */     return MFResource.sound("mob.hiss");
/*     */   }
/*     */   
/*     */   protected String func_70621_aR()
/*     */   {
/* 338 */     return "damage.hit";
/*     */   }
/*     */   
/*     */   protected String func_70673_aS()
/*     */   {
/* 343 */     return "damage.hit";
/*     */   }
/*     */   
/*     */   public float func_70647_i()
/*     */   {
/* 348 */     return 1.0F;
/*     */   }
/*     */   
/*     */   public void func_70642_aH()
/*     */   {
/* 353 */     super.func_70642_aH();
/* 354 */     setMouthTicks(3);
/*     */   }
/*     */   
/*     */   protected void func_70036_a(int x, int y, int z, int m)
/*     */   {
/* 359 */     func_85030_a(MFResource.sound("mob.basiliskWalk"), 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public String func_70023_ak()
/*     */   {
/* 364 */     if (getBreed() == 2) {
/* 365 */       return "Nether Basilisk";
/*     */     }
/* 367 */     return "Basilisk";
/*     */   }
/*     */   
/*     */   public float getScale() {
/* 371 */     if (getBreed() == 2) {
/* 372 */       return 1.5F;
/*     */     }
/* 374 */     return 1.0F;
/*     */   }
/*     */   
/*     */   protected int func_70633_aT()
/*     */   {
/* 379 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void func_70628_a(boolean playerKill, int looting)
/*     */   {
/* 386 */     int amount = this.field_70146_Z.nextInt(2) + this.field_70146_Z.nextInt(1 + looting);
/*     */     
/* 388 */     for (int counter = 0; counter < amount; counter++) {
/* 389 */       if (func_70027_ad()) {
/* 390 */         func_70025_b(ItemListMF.basiliskCooked.field_77779_bT, 1);
/*     */       } else {
/* 392 */         func_70025_b(ItemListMF.basiliskRaw.field_77779_bT, 1);
/*     */       }
/*     */     }
/*     */     
/* 396 */     amount = 1 + this.field_70146_Z.nextInt(1 + looting);
/*     */     
/* 398 */     for (counter = 0; counter < amount; counter++) {
/* 399 */       dropItem(ItemListMF.misc.field_77779_bT, 1, getHide());
/*     */     }
/*     */     
/* 402 */     if ((getBreed() == 2) && 
/* 403 */       (playerKill) && ((this.field_70146_Z.nextInt(3) == 0) || (this.field_70146_Z.nextInt(1 + looting) > 0))) {
/* 404 */       func_70025_b(Item.field_77727_br.field_77779_bT, 1);
/*     */     }
/*     */   }
/*     */   
/*     */   private int getHide()
/*     */   {
/* 410 */     switch (getBreed()) {
/*     */     case 0: 
/* 412 */       return 157;
/*     */     case 1: 
/* 414 */       return 160;
/*     */     case 2: 
/* 416 */       return 163;
/*     */     }
/* 418 */     return 157;
/*     */   }
/*     */   
/*     */   public EntityItem dropItem(int id, int num, int dam) {
/* 422 */     return dropItemWithOffset(id, num, dam, 0.0F);
/*     */   }
/*     */   
/*     */   public EntityItem dropItemWithOffset(int id, int stack, int damage, float offset) {
/* 426 */     return func_70099_a(new ItemStack(id, stack, damage), offset);
/*     */   }
/*     */   
/*     */   public float getMouthAngle() {
/* 430 */     float ang = getMouthTicks();
/* 431 */     if (ang > 10.0F) {
/* 432 */       ang = 10.0F;
/*     */     }
/* 434 */     return ang / 10.0F;
/*     */   }
/*     */   
/*     */   private double getDistanceAway() {
/* 438 */     ChunkCoordinates spawn = this.field_70170_p.func_72861_E();
/* 439 */     return func_70011_f(spawn.field_71574_a, spawn.field_71572_b, spawn.field_71573_c);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/EntityBasilisk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */