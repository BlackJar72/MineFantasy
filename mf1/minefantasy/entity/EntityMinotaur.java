/*     */ package minefantasy.entity;
/*     */ 
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.api.armour.EnumArmourClass;
/*     */ import minefantasy.api.tactic.ISpecialSenses;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.system.MFResource;
/*     */ import minefantasy.system.TacticalManager;
/*     */ import minefantasy.system.cfg;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockChest;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.enchantment.EnchantmentThorns;
/*     */ import net.minecraft.entity.DataWatcher;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.EntityLivingData;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAttackOnCollide;
/*     */ import net.minecraft.entity.ai.EntityAIHurtByTarget;
/*     */ import net.minecraft.entity.ai.EntityAILeapAtTarget;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
/*     */ import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAITasks;
/*     */ import net.minecraft.entity.ai.EntityAIWander;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.ai.attributes.AttributeInstance;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.monster.IMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.tileentity.TileEntityChest;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.util.WeightedRandomChestContent;
/*     */ import net.minecraft.world.EnumSkyBlock;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraftforge.common.ChestGenHooks;
/*     */ import net.minecraftforge.common.ForgeHooks;
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
/*     */ 
/*     */ 
/*     */ public class EntityMinotaur
/*     */   extends EntityMob
/*     */   implements ISpecialSenses
/*     */ {
/*     */   public int swing;
/*     */   private int swingTar;
/*     */   private int hitSize;
/*     */   protected int swingY;
/*     */   private int swingTarY;
/*     */   private int hitSizeY;
/*     */   private float attackMod;
/*  82 */   public boolean isTitan = false;
/*     */   
/*     */ 
/*     */ 
/*  86 */   private float[] moveSpeeds = { 0.3F, 0.6F };
/*     */   private static final int idBase = 12;
/*     */   
/*  89 */   public EntityMinotaur(World world) { super(world);
/*     */     
/*  91 */     this.attackMod = 1.0F;
/*  92 */     this.chargeDuration = 0;
/*  93 */     this.chargeCool = 0;
/*  94 */     this.isCharging = false;
/*  95 */     func_70105_a(1.5F, 3.0F);
/*  96 */     this.field_70728_aV = 50;
/*     */     
/*  98 */     this.field_70714_bg.func_75776_a(3, new EntityAILeapAtTarget(this, 0.6F));
/*  99 */     this.field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
/* 100 */     this.field_70714_bg.func_75776_a(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
/* 101 */     this.field_70714_bg.func_75776_a(3, new EntityAIAttackOnCollide(this, EntityLiving.class, 1.0D, false));
/* 102 */     this.field_70714_bg.func_75776_a(6, new EntityAIWander(this, 1.0D));
/* 103 */     this.field_70714_bg.func_75776_a(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
/* 104 */     this.field_70714_bg.func_75776_a(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
/* 105 */     this.field_70714_bg.func_75776_a(7, new EntityAILookIdle(this));
/* 106 */     this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, true));
/* 107 */     this.field_70715_bh.func_75776_a(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
/*     */     
/* 109 */     for (int i = 0; i < this.field_82174_bp.length; i++) {
/* 110 */       this.field_82174_bp[i] = 2.0F;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer player)
/*     */   {
/* 116 */     ItemStack held = player.func_70694_bm();
/* 117 */     if ((MineFantasyBase.isDebug()) && (held != null)) {
/* 118 */       if ((held.field_77993_c == Item.field_77778_at.field_77779_bT) && (held.func_77960_j() == 1) && (canSetTitan())) {
/* 119 */         setTitan();
/* 120 */         addRandomItems();
/* 121 */         return true;
/*     */       }
/* 123 */       if (held.field_77993_c == Item.field_77705_m.field_77779_bT) {
/* 124 */         func_70606_j(0.1F);
/* 125 */         return true;
/*     */       }
/*     */     }
/* 128 */     return super.func_70085_c(player);
/*     */   }
/*     */   
/*     */   protected void func_110147_ax()
/*     */   {
/* 133 */     super.func_110147_ax();
/* 134 */     func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(40.0D);
/* 135 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.30000001192092896D);
/* 136 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(8.0D);
/* 137 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(60.0D);
/*     */   }
/*     */   
/*     */   protected boolean func_70650_aV()
/*     */   {
/* 142 */     return true;
/*     */   }
/*     */   
/*     */   public void func_70636_d() {
/* 146 */     super.func_70636_d();
/*     */     
/* 148 */     if (this.chargeDuration > 0) {
/* 149 */       this.chargeDuration -= 1;
/*     */     }
/* 151 */     if (this.swingY > this.swingTarY) {
/* 152 */       this.swingY -= 1;
/*     */     }
/* 154 */     if (this.swingY < this.swingTarY) {
/* 155 */       this.swingY += 1;
/*     */     }
/* 157 */     if (this.swingY >= this.hitSizeY) {
/* 158 */       this.swingTarY = 0;
/*     */     }
/* 160 */     if (this.swing > this.swingTar) {
/* 161 */       this.swing -= 1;
/*     */     }
/* 163 */     if (this.swing < this.swingTar) {
/* 164 */       this.swing += 1;
/*     */     }
/* 166 */     if (this.swing >= this.hitSize) {
/* 167 */       this.swingTar = 0;
/*     */     }
/* 169 */     if (this.chargeCool > 0) {
/* 170 */       this.chargeCool -= 1;
/*     */     }
/* 172 */     if (this.chargeDuration <= 0) {
/* 173 */       this.attackMod = 1.0F;
/* 174 */       func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(this.moveSpeeds[0]);
/* 175 */       this.isCharging = false;
/*     */     }
/* 177 */     if ((this.field_70146_Z.nextInt(50) == 0) && (func_70638_az() != null)) {
/* 178 */       float f = func_70032_d(func_70638_az());
/* 179 */       tryCharge(func_70638_az(), f);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean canSetTitan() {
/* 184 */     if ((!this.field_70170_p.func_72937_j((int)this.field_70165_t, (int)this.field_70163_u + 1, (int)this.field_70161_v)) && (this.field_71093_bK != -1)) {
/* 185 */       return false;
/*     */     }
/* 187 */     for (int x = -1; x <= 1; x++) {
/* 188 */       for (int z = -1; z <= 1; z++) {
/* 189 */         for (int y = 0; y <= 3; y++) {
/* 190 */           if (this.field_70170_p.func_72803_f((int)this.field_70165_t + x, (int)this.field_70163_u + y, (int)this.field_70161_v + z).func_76220_a()) {
/* 191 */             return false;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 196 */     return true;
/*     */   }
/*     */   
/*     */   private void setTitan() {
/* 200 */     if (this.field_70170_p.field_72995_K) {
/* 201 */       return;
/*     */     }
/* 203 */     this.field_70728_aV = 250;
/* 204 */     this.field_70138_W = 1.0F;
/* 205 */     this.field_70747_aH = 0.03F;
/* 206 */     func_70105_a(1.5F, 4.5F);
/* 207 */     this.isTitan = true;
/* 208 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.5D);
/* 209 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(7.0D);
/* 210 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(120.0D);
/* 211 */     func_70606_j(func_110138_aP());
/* 212 */     this.field_70715_bh.func_75776_a(2, new EntityAINearestAttackableTarget(this, IMob.class, 0, false));
/*     */   }
/*     */   
/*     */   public void func_70074_a(EntityLivingBase killed)
/*     */   {
/* 217 */     if (this.isTitan) {
/* 218 */       func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(func_110138_aP() + 1.0F);
/* 219 */       func_70691_i(killed.func_110138_aP() / 4.0F);
/*     */     }
/* 221 */     super.func_70074_a(killed);
/*     */   }
/*     */   
/*     */   public void func_70664_aZ()
/*     */   {
/* 226 */     float jumpHeight = this.isTitan ? 1.5F : 1.0F;
/* 227 */     this.field_70181_x = (0.41999998688697815D * jumpHeight);
/*     */     
/* 229 */     if (func_70644_a(Potion.field_76430_j)) {
/* 230 */       this.field_70181_x += (func_70660_b(Potion.field_76430_j).func_76458_c() + 1) * 0.1F;
/*     */     }
/*     */     
/* 233 */     if (func_70051_ag()) {
/* 234 */       float f = this.field_70177_z * 0.017453292F;
/* 235 */       this.field_70159_w -= MathHelper.func_76126_a(f) * 0.2F;
/* 236 */       this.field_70179_y += MathHelper.func_76134_b(f) * 0.2F;
/*     */     }
/*     */     
/* 239 */     this.field_70160_al = true;
/* 240 */     ForgeHooks.onLivingJump(this);
/*     */   }
/*     */   
/*     */   public int func_70658_aO()
/*     */   {
/* 245 */     return this.isTitan ? 20 : 4;
/*     */   }
/*     */   
/*     */   public boolean func_70652_k(Entity tar)
/*     */   {
/* 250 */     if (!func_70685_l(tar)) {
/* 251 */       return false;
/*     */     }
/* 253 */     float f = (float)func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e() * this.attackMod;
/* 254 */     int i = 0;
/*     */     
/* 256 */     if ((tar instanceof EntityLivingBase)) {
/* 257 */       f += EnchantmentHelper.func_77512_a(this, (EntityLivingBase)tar);
/* 258 */       i += EnchantmentHelper.func_77507_b(this, (EntityLivingBase)tar);
/*     */     }
/*     */     
/* 261 */     boolean flag = tar.func_70097_a(DamageSource.func_76358_a(this), f);
/*     */     
/* 263 */     if ((this.isTitan) && 
/* 264 */       (!this.field_70170_p.field_72995_K) && (this.field_70146_Z.nextInt(getStrongChance()) == 0)) {
/* 265 */       this.field_70170_p.func_72876_a(this, tar.field_70165_t, tar.field_70163_u, tar.field_70161_v, this.field_70146_Z.nextFloat() * 0.5F + 0.5F, true);
/*     */     }
/*     */     
/*     */ 
/* 269 */     if (flag) {
/* 270 */       if (i > 0) {
/* 271 */         tar.func_70024_g(-MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F) * i * 0.5F, 0.1D, MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F) * i * 0.5F);
/* 272 */         this.field_70159_w *= 0.6D;
/* 273 */         this.field_70179_y *= 0.6D;
/*     */       }
/*     */       
/* 276 */       int j = EnchantmentHelper.func_90036_a(this);
/*     */       
/* 278 */       if (j > 0) {
/* 279 */         tar.func_70015_d(j * 4);
/*     */       }
/*     */       
/* 282 */       if ((tar instanceof EntityLivingBase)) {
/* 283 */         EnchantmentThorns.func_92096_a(this, (EntityLivingBase)tar, this.field_70146_Z);
/*     */       }
/*     */     }
/*     */     
/* 287 */     return flag;
/*     */   }
/*     */   
/*     */   private int getStrongChance() {
/* 291 */     if (func_110143_aJ() < func_110138_aP() / 2.0F) {
/* 292 */       return 5;
/*     */     }
/* 294 */     if (func_110143_aJ() < func_110138_aP() / 4.0F) {
/* 295 */       return 2;
/*     */     }
/* 297 */     if (func_110143_aJ() < func_110138_aP() / 8.0F) {
/* 298 */       return 1;
/*     */     }
/* 300 */     return 10;
/*     */   }
/*     */   
/*     */   public boolean func_70097_a(DamageSource source, float dam)
/*     */   {
/* 305 */     if (this.isTitan) {
/* 306 */       if (source.func_76352_a()) {
/* 307 */         dam *= 0.25F;
/*     */       }
/* 309 */       if ((!this.field_70170_p.field_72995_K) && (source == DamageSource.field_76379_h)) {
/* 310 */         this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, dam / 3.0F, false);
/* 311 */         this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.5F + this.field_70146_Z.nextFloat(), true);
/* 312 */         dam = 0.0F;
/*     */       }
/*     */     }
/* 315 */     return super.func_70097_a(source, dam);
/*     */   }
/*     */   
/*     */   public void Charge() {
/* 319 */     if (this.isTitan) {
/* 320 */       return;
/*     */     }
/* 322 */     this.chargeDuration = 80;
/* 323 */     this.chargeCool = 320;
/* 324 */     this.attackMod = 1.2F;
/* 325 */     this.isCharging = true;
/*     */     
/* 327 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(this.moveSpeeds[1]);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70088_a()
/*     */   {
/* 334 */     super.func_70088_a();
/* 335 */     this.field_70180_af.func_75682_a(12, new Integer(this.swing));
/* 336 */     this.field_70180_af.func_75682_a(13, new Integer(this.swingY));
/* 337 */     this.field_70180_af.func_75682_a(14, new Integer(0));
/* 338 */     this.field_70180_af.func_75682_a(15, new Integer(0));
/*     */   }
/*     */   
/*     */   public EntityLivingData func_110161_a(EntityLivingData data)
/*     */   {
/* 343 */     func_98053_h(false);
/* 344 */     int chance = this.field_71093_bK == -1 ? 150 : 600;
/* 345 */     if ((this.field_70146_Z.nextInt(chance) < this.field_70170_p.field_73013_u) && (canSetTitan()) && (getDistanceAway() < cfg.titanDist)) {
/* 346 */       setTitan();
/*     */     }
/* 348 */     else if (((this.field_70163_u < 32.0D) && (!this.field_70170_p.func_72937_j((int)this.field_70165_t, (int)this.field_70163_u + 1, (int)this.field_70161_v + 1))) || (this.field_71093_bK == -1)) {
/* 349 */       setBreed(1);
/* 350 */     } else if (isInSnow()) {
/* 351 */       setBreed(2);
/*     */     }
/*     */     
/* 354 */     applyStats();
/* 355 */     addRandomItems();
/*     */     
/* 357 */     return super.func_110161_a(data);
/*     */   }
/*     */   
/*     */   private boolean isInSnow() {
/* 361 */     return this.field_70170_p.func_72807_a((int)this.field_70165_t, (int)this.field_70161_v).func_76746_c();
/*     */   }
/*     */   
/*     */   public float getSpeedMod() {
/* 365 */     float f = 1.0F;
/* 366 */     if (this.isCharging) {
/* 367 */       f *= 2.0F;
/*     */     }
/* 369 */     if (func_70644_a(Potion.field_76424_c)) {
/* 370 */       f *= (1.0F + 0.2F * (func_70660_b(Potion.field_76424_c).func_76458_c() + 1));
/*     */     }
/* 372 */     if (func_70644_a(Potion.field_76421_d)) {
/* 373 */       f *= (1.0F - 0.15F * (func_70660_b(Potion.field_76421_d).func_76458_c() + 1));
/*     */     }
/* 375 */     return f;
/*     */   }
/*     */   
/*     */   public boolean func_70601_bi()
/*     */   {
/* 380 */     int c = 8 - this.field_70170_p.field_73013_u;
/* 381 */     if ((this.field_70146_Z.nextInt(c) != 0) && (this.field_71093_bK == 0)) {
/* 382 */       return false;
/*     */     }
/* 384 */     return (super.func_70601_bi()) && (this.field_70170_p.field_73013_u >= cfg.minoDiff);
/*     */   }
/*     */   
/*     */   protected boolean func_70814_o()
/*     */   {
/* 389 */     if (!isInSnow()) {
/* 390 */       return super.func_70814_o();
/*     */     }
/*     */     
/* 393 */     int i = MathHelper.func_76128_c(this.field_70165_t);
/* 394 */     int j = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
/* 395 */     int k = MathHelper.func_76128_c(this.field_70161_v);
/*     */     
/* 397 */     if (this.field_70170_p.func_72972_b(EnumSkyBlock.Sky, i, j, k) > this.field_70146_Z.nextInt(32)) {
/* 398 */       return false;
/*     */     }
/* 400 */     int l = this.field_70170_p.func_72957_l(i, j, k);
/*     */     
/* 402 */     if (this.field_70170_p.func_72911_I()) {
/* 403 */       int i1 = this.field_70170_p.field_73008_k;
/* 404 */       this.field_70170_p.field_73008_k = 10;
/* 405 */       l = this.field_70170_p.func_72957_l(i, j, k);
/* 406 */       this.field_70170_p.field_73008_k = i1;
/*     */     }
/*     */     
/* 409 */     if (this.field_70146_Z.nextInt(10) == 0) {
/* 410 */       return l <= 10;
/*     */     }
/* 412 */     return l <= this.field_70146_Z.nextInt(10);
/*     */   }
/*     */   
/*     */   protected String func_70639_aQ()
/*     */   {
/* 417 */     return MFResource.sound("mob.minotaurLive");
/*     */   }
/*     */   
/*     */   protected String func_70621_aR() {
/* 421 */     return MFResource.sound("mob.minotaurHurt");
/*     */   }
/*     */   
/*     */   protected String func_70673_aS() {
/* 425 */     return MFResource.sound("mob.minotaurDie");
/*     */   }
/*     */   
/*     */   protected float func_70599_aP() {
/* 429 */     return 1.2F;
/*     */   }
/*     */   
/*     */   protected int func_70633_aT() {
/* 433 */     if (func_70027_ad()) {
/* 434 */       return Item.field_77734_bj.field_77779_bT;
/*     */     }
/* 436 */     return Item.field_77741_bi.field_77779_bT;
/*     */   }
/*     */   
/*     */   protected void func_70628_a(boolean player, int looting)
/*     */   {
/* 441 */     super.func_70628_a(player, looting);
/* 442 */     int hide = 1 + this.field_70146_Z.nextInt(1 + looting);
/* 443 */     if (this.isTitan) {
/* 444 */       hide *= 3;
/* 445 */       for (int a = 0; a < 2 + this.field_70146_Z.nextInt(5 * (looting + 1)); a++) {
/* 446 */         if (func_70027_ad()) {
/* 447 */           func_70099_a(new ItemStack(Item.field_77734_bj), 0.0F);
/*     */         } else {
/* 449 */           func_70099_a(new ItemStack(Item.field_77741_bi), 0.0F);
/*     */         }
/*     */       }
/*     */     }
/* 453 */     for (int a = 0; a < hide; a++) {
/* 454 */       func_70099_a(new ItemStack(ItemListMF.misc, 1, 98), 0.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void dropEquipment2(boolean dropAll, int chance) {
/* 459 */     if (this.field_70170_p.field_72995_K) {
/* 460 */       return;
/*     */     }
/* 462 */     ItemStack itemstack = func_70694_bm();
/* 463 */     if (itemstack != null) {
/* 464 */       if (itemstack.func_77984_f()) {
/* 465 */         int k = Math.max(itemstack.func_77958_k() - 25, 1);
/* 466 */         int l = itemstack.func_77958_k() - this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(k) + 1);
/*     */         
/* 468 */         if (l > k) {
/* 469 */           l = k;
/*     */         }
/*     */         
/* 472 */         if (l < 1) {
/* 473 */           l = 1;
/*     */         }
/*     */         
/* 476 */         itemstack.func_77964_b(l);
/*     */       }
/*     */       
/* 479 */       func_70099_a(itemstack, 0.0F);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public int chargeDuration;
/*     */   
/*     */   private void knockbackEntity(Entity entity)
/*     */   {
/* 488 */     float knockbackMod = 2.0F;
/* 489 */     float height = 1.0F;
/* 490 */     if ((entity != null) && ((entity instanceof EntityPlayer))) {
/* 491 */       EntityPlayer player = (EntityPlayer)entity;
/* 492 */       knockbackMod = 0.5F + getArmourKnockbackModifier(player) * 1.5F;
/* 493 */       height = 0.25F + getArmourKnockbackModifier(player) * 0.75F;
/*     */     }
/* 495 */     if (this.chargeDuration > 0) {
/* 496 */       knockbackMod *= 2.0F;
/*     */     }
/*     */     
/* 499 */     entity.func_70024_g(-MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F) * knockbackMod * 0.5F, height, MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F) * knockbackMod * 0.5F);
/*     */   }
/*     */   
/*     */   public double getHeadChargeAngle() {
/* 503 */     return this.chargeDuration > 0 ? 30.0D : 0.0D;
/*     */   }
/*     */   
/*     */   private void tryCharge(Entity entity, float f) {
/* 507 */     if ((this.chargeCool <= 0) && (f < 32.0F) && (entity.field_70121_D.field_72337_e > this.field_70121_D.field_72338_b) && (entity.field_70121_D.field_72338_b < this.field_70121_D.field_72337_e)) {
/* 508 */       Charge();
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70071_h_()
/*     */   {
/* 514 */     super.func_70071_h_();
/* 515 */     if (!this.field_70170_p.field_72995_K) {
/* 516 */       this.field_70180_af.func_75692_b(12, Integer.valueOf(this.swing));
/* 517 */       this.field_70180_af.func_75692_b(13, Integer.valueOf(this.swingY));
/* 518 */       this.field_70180_af.func_75692_b(14, Integer.valueOf(this.isTitan ? 1 : 0));
/*     */     } else {
/* 520 */       this.swing = this.field_70180_af.func_75679_c(12);
/* 521 */       this.swingY = this.field_70180_af.func_75679_c(13);
/* 522 */       this.isTitan = (this.field_70180_af.func_75679_c(14) == 1);
/*     */     }
/*     */   }
/*     */   
/*     */   public float getArmourKnockbackModifier(EntityPlayer player) {
/* 527 */     float r = 1.0F;
/*     */     
/* 529 */     EnumArmourClass AC0 = TacticalManager.getClassInSlot(player, 0);
/* 530 */     r -= (float)getArmourFractionOfTotal(AC0.getKnockback(), 4);
/*     */     
/* 532 */     EnumArmourClass AC1 = TacticalManager.getClassInSlot(player, 1);
/* 533 */     r -= (float)getArmourFractionOfTotal(AC1.getKnockback(), 7);
/*     */     
/* 535 */     EnumArmourClass AC2 = TacticalManager.getClassInSlot(player, 2);
/* 536 */     r -= (float)getArmourFractionOfTotal(AC2.getKnockback(), 8);
/*     */     
/* 538 */     EnumArmourClass AC3 = TacticalManager.getClassInSlot(player, 3);
/* 539 */     r -= (float)getArmourFractionOfTotal(AC3.getKnockback(), 5);
/*     */     
/* 541 */     return r > 0.0F ? r : 0.0F;
/*     */   }
/*     */   
/*     */   public void func_70014_b(NBTTagCompound nbt)
/*     */   {
/* 546 */     super.func_70014_b(nbt);
/* 547 */     nbt.func_74757_a("Titan", this.isTitan);
/* 548 */     nbt.func_74768_a("Breed", getBreed());
/*     */   }
/*     */   
/*     */   public void func_70037_a(NBTTagCompound nbt)
/*     */   {
/* 553 */     super.func_70037_a(nbt);
/*     */     
/* 555 */     if (nbt.func_74767_n("Titan")) {
/* 556 */       setTitan();
/*     */     }
/* 558 */     if (nbt.func_74764_b("Breed")) {
/* 559 */       setBreed(nbt.func_74762_e("Breed"));
/*     */     }
/*     */   }
/*     */   
/*     */   public String func_70023_ak()
/*     */   {
/* 565 */     if (func_94056_bM()) {
/* 566 */       return func_94057_bL();
/*     */     }
/* 568 */     if (this.isTitan) {
/* 569 */       return StatCollector.func_74838_a("entity.MineFantasy.MinotaurTitan.name");
/*     */     }
/* 571 */     return StatCollector.func_74838_a("entity.MineFantasy.Minotaur.name");
/*     */   }
/*     */   
/*     */   public double getArmourFractionOfTotal(double total, int armour) {
/* 575 */     return total / 24.0D * armour;
/*     */   }
/*     */   
/*     */   public int getViewingArc()
/*     */   {
/* 580 */     return 180;
/*     */   }
/*     */   
/*     */   public int getHearing()
/*     */   {
/* 585 */     return 0;
/*     */   }
/*     */   
/*     */   public int getSight()
/*     */   {
/* 590 */     return -10;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void addRandomItems()
/*     */   {
/* 597 */     ChunkCoordinates spawn = this.field_70170_p.func_72861_E();
/* 598 */     double dist = func_70011_f(spawn.field_71574_a, spawn.field_71572_b, spawn.field_71573_c);
/*     */     
/* 600 */     Item[] bronzeWeps = { ItemListMF.battleaxeBronze, ItemListMF.greatswordBronze, ItemListMF.morningstarBronze, ItemListMF.warhammerBronze };
/* 601 */     Item[] ironWeps = { ItemListMF.battleaxeIron, ItemListMF.greatswordIron, ItemListMF.morningstarIron, ItemListMF.warhammerIron };
/* 602 */     Item[] steelWeps = { ItemListMF.battleaxeSteel, ItemListMF.greatswordSteel, ItemListMF.morningstarSteel, ItemListMF.warhammerSteel };
/* 603 */     Item[] mithrilWeps = { ItemListMF.battleaxeMithril, ItemListMF.greatswordMithril, ItemListMF.morningstarMithril, ItemListMF.warhammerMithril };
/*     */     
/* 605 */     int spawnDist = cfg.minotaurWeaponDist;
/*     */     
/* 607 */     if ((dist > spawnDist * 4) || ((this.field_71093_bK == -1) && (this.field_70146_Z.nextInt(40) == 0))) {
/* 608 */       int a = mithrilWeps.length;
/* 609 */       func_70062_b(0, new ItemStack(mithrilWeps[this.field_70146_Z.nextInt(a)]));
/* 610 */       return; }
/* 611 */     if ((dist > spawnDist * 3) || ((this.field_71093_bK == -1) && (this.field_70146_Z.nextInt(30) == 0))) {
/* 612 */       int a = steelWeps.length;
/* 613 */       func_70062_b(0, new ItemStack(steelWeps[this.field_70146_Z.nextInt(a)]));
/* 614 */       return; }
/* 615 */     if ((dist > spawnDist * 2) || ((this.field_71093_bK == -1) && (this.field_70146_Z.nextInt(20) == 0))) {
/* 616 */       int a = ironWeps.length;
/* 617 */       func_70062_b(0, new ItemStack(ironWeps[this.field_70146_Z.nextInt(a)]));
/* 618 */       return; }
/* 619 */     if ((dist > spawnDist) || ((this.field_71093_bK == -1) && (this.field_70146_Z.nextInt(5) == 0))) {
/* 620 */       int a = bronzeWeps.length;
/* 621 */       func_70062_b(0, new ItemStack(bronzeWeps[this.field_70146_Z.nextInt(a)]));
/* 622 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTexture() {
/* 627 */     if (this.isTitan) {
/* 628 */       return "minotaurTitan";
/*     */     }
/* 630 */     switch (getBreed()) {
/*     */     case 0: 
/* 632 */       return "minotaur";
/*     */     case 1: 
/* 634 */       return "minotaurBlack";
/*     */     case 2: 
/* 636 */       return "minotaurAlbino";
/*     */     }
/* 638 */     return "minotaur";
/*     */   }
/*     */   
/*     */ 
/*     */   public int chargeCool;
/*     */   
/*     */   public boolean isCharging;
/*     */   public int getBreed()
/*     */   {
/* 647 */     return this.field_70180_af.func_75679_c(15);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void setBreed(int i)
/*     */   {
/* 656 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(i));
/* 657 */     this.field_70178_ae = (i == 1);
/*     */   }
/*     */   
/*     */   private void applyStats() {
/* 661 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(getBreedHealth());
/* 662 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(getBreedDamage());
/* 663 */     func_70606_j(func_110138_aP());
/*     */   }
/*     */   
/*     */   private double getBreedDamage() {
/* 667 */     switch (getBreed()) {
/*     */     case 0: 
/* 669 */       return 5.0D;
/*     */     case 1: 
/* 671 */       return 6.0D;
/*     */     case 2: 
/* 673 */       return 4.0D;
/*     */     }
/* 675 */     return 5.0D;
/*     */   }
/*     */   
/*     */   private double getBreedHealth() {
/* 679 */     switch (getBreed()) {
/*     */     case 0: 
/* 681 */       return 60.0D;
/*     */     case 1: 
/* 683 */       return 80.0D;
/*     */     case 2: 
/* 685 */       return 100.0D;
/*     */     }
/* 687 */     return 60.0D;
/*     */   }
/*     */   
/*     */   public void func_70645_a(DamageSource source)
/*     */   {
/* 692 */     super.func_70645_a(source);
/* 693 */     if (this.field_70170_p.field_72995_K) {
/* 694 */       return;
/*     */     }
/* 696 */     boolean placeChest = false;
/*     */     
/* 698 */     if (!this.isTitan) {
/* 699 */       return;
/*     */     }
/* 701 */     TileEntityChest chest = getLootChest();
/*     */     
/* 703 */     int x = (int)this.field_70165_t;
/* 704 */     int z = (int)this.field_70161_v;
/* 705 */     for (int y = (int)this.field_70163_u + 1; y > 0; y--) {
/* 706 */       if (this.field_70170_p.func_72803_f(x, y, z).func_76220_a()) {
/*     */         break;
/*     */       }
/*     */       
/* 710 */       if (tryPlaceChest(x, y, z, chest)) {
/* 711 */         placeChest = true;
/* 712 */         break;
/*     */       }
/*     */     }
/*     */     
/* 716 */     if (!placeChest) {
/* 717 */       for (int a = 0; a < chest.func_70302_i_(); a++) {
/* 718 */         ItemStack drop = chest.func_70301_a(a);
/* 719 */         if (drop != null)
/* 720 */           func_70099_a(drop, 0.0F);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean tryPlaceChest(int x, int y, int z, TileEntityChest tile) {
/* 726 */     boolean replace = false;
/* 727 */     int id = this.field_70170_p.func_72798_a(x, y, z);
/* 728 */     Block bl = Block.field_71973_m[id];
/*     */     
/* 730 */     if (this.field_70170_p.func_72803_f(x, y - 1, z).func_76220_a()) {
/* 731 */       if (bl != null) {
/* 732 */         replace = bl.isBlockReplaceable(this.field_70170_p, x, y, z);
/*     */       }
/* 734 */       if ((this.field_70170_p.func_72799_c(x, y, z)) || (replace)) {
/* 735 */         this.field_70170_p.func_94575_c(x, y, z, Block.field_72077_au.field_71990_ca);
/* 736 */         this.field_70170_p.func_72837_a(x, y, z, tile);
/* 737 */         return true;
/*     */       }
/*     */     }
/* 740 */     return false;
/*     */   }
/*     */   
/*     */   private TileEntityChest getLootChest() {
/* 744 */     TileEntityChest tile = new TileEntityChest();
/*     */     
/* 746 */     tile.func_94043_a("Minotaur Titan Loot");
/*     */     
/* 748 */     fillChest(tile, "dungeonChest");
/* 749 */     fillChest(tile, "pyramidDesertyChest");
/* 750 */     fillChest(tile, "pyramidJungleChest");
/* 751 */     fillChest(tile, "strongholdCrossing");
/* 752 */     fillChest(tile, "strongholdCorridor");
/*     */     
/* 754 */     return tile;
/*     */   }
/*     */   
/*     */   private void fillChest(TileEntityChest tile, String contents) {
/* 758 */     ChestGenHooks info = ChestGenHooks.getInfo(contents);
/* 759 */     WeightedRandomChestContent.func_76293_a(this.field_70146_Z, info.getItems(this.field_70146_Z), tile, info.getCount(this.field_70146_Z));
/*     */   }
/*     */   
/*     */   private double getDistanceAway() {
/* 763 */     ChunkCoordinates spawn = this.field_70170_p.func_72861_E();
/* 764 */     return func_70011_f(spawn.field_71574_a, spawn.field_71572_b, spawn.field_71573_c);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/EntityMinotaur.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */