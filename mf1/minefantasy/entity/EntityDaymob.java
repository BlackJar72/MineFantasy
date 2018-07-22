/*     */ package minefantasy.entity;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockGrass;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.enchantment.EnchantmentThorns;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.monster.IMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.EnumSkyBlock;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class EntityDaymob
/*     */   extends EntityCreature
/*     */   implements IMob
/*     */ {
/*     */   public EntityDaymob(World world)
/*     */   {
/*  30 */     super(world);
/*  31 */     this.field_70728_aV = 5;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_70636_d()
/*     */   {
/*  40 */     func_82168_bl();
/*  41 */     super.func_70636_d();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70071_h_()
/*     */   {
/*  48 */     super.func_70071_h_();
/*     */     
/*  50 */     if ((!this.field_70170_p.field_72995_K) && (this.field_70170_p.field_73013_u == 0)) {
/*  51 */       func_70106_y();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected Entity func_70782_k()
/*     */   {
/*  61 */     EntityPlayer var1 = this.field_70170_p.func_72856_b(this, 16.0D);
/*  62 */     return (var1 != null) && (func_70685_l(var1)) ? var1 : null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean attackEntityFrom(DamageSource source, int damage)
/*     */   {
/*  69 */     if (func_85032_ar())
/*  70 */       return false;
/*  71 */     if (super.func_70097_a(source, damage)) {
/*  72 */       Entity var3 = source.func_76346_g();
/*     */       
/*  74 */       if ((this.field_70153_n != var3) && (this.field_70154_o != var3)) {
/*  75 */         if (var3 != this) {
/*  76 */           this.field_70789_a = var3;
/*     */         }
/*     */         
/*  79 */         return true;
/*     */       }
/*  81 */       return true;
/*     */     }
/*     */     
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_70652_k(Entity target)
/*     */   {
/*  89 */     float var2 = getAttackStrength(target);
/*     */     
/*  91 */     if (func_70644_a(Potion.field_76420_g)) {
/*  92 */       var2 += (3 << func_70660_b(Potion.field_76420_g).func_76458_c());
/*     */     }
/*     */     
/*  95 */     if (func_70644_a(Potion.field_76437_t)) {
/*  96 */       var2 -= (2 << func_70660_b(Potion.field_76437_t).func_76458_c());
/*     */     }
/*     */     
/*  99 */     int var3 = 0;
/*     */     
/* 101 */     if ((target instanceof EntityLiving)) {
/* 102 */       var2 += EnchantmentHelper.func_77512_a(this, (EntityLiving)target);
/* 103 */       var3 += EnchantmentHelper.func_77507_b(this, (EntityLiving)target);
/*     */     }
/*     */     
/* 106 */     boolean var4 = target.func_70097_a(DamageSource.func_76358_a(this), var2);
/*     */     
/* 108 */     if (var4) {
/* 109 */       if (var3 > 0) {
/* 110 */         target.func_70024_g(-MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F) * var3 * 0.5F, 0.1D, MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F) * var3 * 0.5F);
/* 111 */         this.field_70159_w *= 0.6D;
/* 112 */         this.field_70179_y *= 0.6D;
/*     */       }
/*     */       
/* 115 */       int var5 = EnchantmentHelper.func_90036_a(this);
/*     */       
/* 117 */       if (var5 > 0) {
/* 118 */         target.func_70015_d(var5 * 4);
/*     */       }
/*     */       
/* 121 */       if ((target instanceof EntityLiving)) {
/* 122 */         EnchantmentThorns.func_92096_a(this, (EntityLiving)target, this.field_70146_Z);
/*     */       }
/*     */     }
/*     */     
/* 126 */     return var4;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void func_70785_a(Entity target, float damage)
/*     */   {
/* 134 */     if ((this.field_70724_aR <= 0) && (damage < 2.0F) && (target.field_70121_D.field_72337_e > this.field_70121_D.field_72338_b) && (target.field_70121_D.field_72338_b < this.field_70121_D.field_72337_e)) {
/* 135 */       this.field_70724_aR = 20;
/* 136 */       func_70652_k(target);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean isValidLightLevel()
/*     */   {
/* 144 */     int var1 = MathHelper.func_76128_c(this.field_70165_t);
/* 145 */     int var2 = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
/* 146 */     int var3 = MathHelper.func_76128_c(this.field_70161_v);
/*     */     
/* 148 */     if (this.field_70170_p.func_72972_b(EnumSkyBlock.Sky, var1, var2, var3) > this.field_70146_Z.nextInt(32)) {
/* 149 */       return false;
/*     */     }
/* 151 */     int light = this.field_70170_p.func_72957_l(var1, var2, var3);
/*     */     
/* 153 */     if (this.field_70170_p.func_72911_I()) {
/* 154 */       int sky = this.field_70170_p.field_73008_k;
/* 155 */       this.field_70170_p.field_73008_k = 10;
/* 156 */       light = this.field_70170_p.func_72957_l(var1, var2, var3);
/* 157 */       this.field_70170_p.field_73008_k = sky;
/*     */     }
/*     */     
/* 160 */     return light >= 15 - this.field_70146_Z.nextInt(5);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_70601_bi()
/*     */   {
/* 170 */     int var1 = MathHelper.func_76128_c(this.field_70165_t);
/* 171 */     int var2 = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
/* 172 */     int var3 = MathHelper.func_76128_c(this.field_70161_v);
/*     */     
/* 174 */     return (isProperDistance()) && (isProperBlock(var1, var2, var3)) && (this.field_70170_p.func_72883_k(var1, var2, var3) >= getMinimalLight()) && (super.func_70601_bi());
/*     */   }
/*     */   
/*     */   public int getMinimalLight() {
/* 178 */     return 10;
/*     */   }
/*     */   
/*     */   public boolean isProperBlock(int x, int y, int z) {
/* 182 */     return this.field_70170_p.func_72798_a(x, y - 1, z) == Block.field_71980_u.field_71990_ca;
/*     */   }
/*     */   
/*     */   public boolean isProperDistance() {
/* 186 */     if (this.field_71093_bK != 0) {
/* 187 */       return true;
/*     */     }
/* 189 */     ChunkCoordinates spawn = this.field_70170_p.func_72861_E();
/* 190 */     return func_70011_f(spawn.field_71574_a, spawn.field_71572_b, spawn.field_71573_c) > getDistanceToSpawn();
/*     */   }
/*     */   
/*     */   public abstract double getDistanceToSpawn();
/*     */   
/*     */   public abstract float getAttackStrength(Entity paramEntity);
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/EntityDaymob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */