/*     */ package minefantasy.system;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.api.armour.EnumArmourClass;
/*     */ import minefantasy.api.armour.IArmourCustomSpeed;
/*     */ import minefantasy.api.armour.IElementalResistance;
/*     */ import minefantasy.api.weapon.DamageSourceAP;
/*     */ import minefantasy.api.weapon.ICustomDamager;
/*     */ import minefantasy.api.weapon.IHitReaction;
/*     */ import minefantasy.api.weapon.IStealthWeapon;
/*     */ import minefantasy.api.weapon.IWeaponCustomSpeed;
/*     */ import minefantasy.api.weapon.IWeaponMobility;
/*     */ import minefantasy.api.weapon.IWeaponPenetrateArmour;
/*     */ import minefantasy.api.weapon.IWeaponSpecial;
/*     */ import minefantasy.api.weapon.IWeaponSpecialBlock;
/*     */ import minefantasy.api.weapon.IWeaponWeakArmour;
/*     */ import minefantasy.api.weapon.IWeightedWeapon;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EntityDamageSource;
/*     */ import net.minecraft.util.EntityDamageSourceIndirect;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.event.entity.living.LivingHurtEvent;
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
/*     */ public class CombatManager
/*     */ {
/*  50 */   private static Random rand = new Random();
/*     */   
/*     */   public static void onAttack(LivingHurtEvent event) {
/*  53 */     EntityLivingBase target = event.entityLiving;
/*  54 */     event.ammount = resistWithArmour(event.source, event.ammount, target);
/*     */     
/*  56 */     ItemStack defense = target.func_70694_bm();
/*  57 */     if (defense != null) {
/*  58 */       if ((defense.func_77973_b() instanceof IWeaponSpecialBlock)) {
/*  59 */         event.ammount = ((IWeaponSpecialBlock)defense.func_77973_b()).blockDamage(target, event.ammount, event.source);
/*     */       }
/*  61 */       if ((defense.func_77973_b() instanceof IHitReaction)) {
/*  62 */         ((IHitReaction)defense.func_77973_b()).onUserHit(event.source, target);
/*     */       }
/*     */     }
/*     */     
/*  66 */     float damage = event.ammount;
/*  67 */     int hurtTimeTemp = target.field_70737_aN;
/*  68 */     int hurtResistanceTimeTemp = target.field_70172_ad;
/*     */     
/*  70 */     if (((event.source instanceof EntityDamageSource)) && (!(event.source instanceof EntityDamageSourceIndirect)) && (!event.source.field_76373_n.equals("battlegearExtra"))) {
/*  71 */       Entity entityHitter = ((EntityDamageSource)event.source).func_76346_g();
/*     */       
/*  73 */       if ((entityHitter instanceof EntityLivingBase)) {
/*  74 */         EntityLivingBase attacker = (EntityLivingBase)entityHitter;
/*  75 */         ItemStack weapon = attacker.func_70694_bm();
/*     */         
/*  77 */         if (weapon != null) {
/*  78 */           if ((weapon.func_77973_b() instanceof IWeightedWeapon)) {
/*  79 */             float power = ((IWeightedWeapon)weapon.func_77973_b()).getBlockFailureChance();
/*  80 */             if (((target instanceof EntityPlayer)) && (power > 0.0F) && 
/*  81 */               (!target.field_70170_p.field_72995_K) && (defense != null) && (((EntityPlayer)target).func_70632_aY())) {
/*  82 */               int itemdam = (int)Math.floor(damage * power * 2.0F);
/*  83 */               defense.func_77972_a(itemdam, target);
/*     */               
/*  85 */               if (target.func_70681_au().nextFloat() < power) {
/*  86 */                 entityDropItem(target, defense, 0.2F);
/*  87 */                 target.func_70062_b(0, null);
/*     */               }
/*     */             }
/*     */           }
/*     */           
/*  92 */           if ((weapon.func_77973_b() instanceof ICustomDamager)) {
/*  93 */             event.ammount = (damage = ((ICustomDamager)weapon.func_77973_b()).getHitDamage(weapon));
/*     */           }
/*     */           
/*  96 */           if ((weapon.func_77973_b() instanceof IWeaponWeakArmour)) {
/*  97 */             float multiplier = ((IWeaponWeakArmour)weapon.func_77973_b()).getArmourPower(weapon);
/*  98 */             event.ammount = (damage = applyArmorCalculations(multiplier, target, event.source, damage));
/*     */           }
/* 100 */           if ((weapon.func_77973_b() instanceof IWeaponPenetrateArmour))
/*     */           {
/* 102 */             float dam = ((IWeaponPenetrateArmour)weapon.func_77973_b()).getAPDamage();
/* 103 */             event.ammount -= dam;
/*     */             
/* 105 */             damageWithBonus(target, DamageSourceAP.blunt, damage, dam);
/*     */             
/* 107 */             if (((IWeaponPenetrateArmour)weapon.func_77973_b()).buffDamage()) {
/* 108 */               float bonus = ((IWeaponPenetrateArmour)weapon.func_77973_b()).getArmourDamageBonus() - 1.0F;
/* 109 */               if (bonus > 0.0F) {
/* 110 */                 int AD = (int)((damage + dam) * bonus);
/* 111 */                 if ((target instanceof EntityPlayer)) {
/* 112 */                   ((EntityPlayer)target).field_71071_by.func_70449_g(AD);
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */           
/* 118 */           if ((attacker.func_70093_af()) && (TacticalManager.isDetected(target, attacker)) && (TacticalManager.isFlankedBy(attacker, target, 90.0F))) {
/* 119 */             float bonus = 1.0F;
/* 120 */             if ((weapon.func_77973_b() instanceof IStealthWeapon)) {
/* 121 */               bonus = ((IStealthWeapon)weapon.func_77973_b()).getBackstabModifier();
/*     */             }
/* 123 */             event.ammount = (damage = applySneakAttack(attacker, target, damage * bonus));
/*     */           }
/* 125 */           if ((attacker.field_70143_R > 3.0F) && (attacker.field_70143_R < 23.0F) && ((weapon.func_77973_b() instanceof IStealthWeapon)) && 
/* 126 */             (((IStealthWeapon)weapon.func_77973_b()).canDropAttack())) {
/* 127 */             float bonus = ((IStealthWeapon)weapon.func_77973_b()).getDropModifier();
/* 128 */             float dam = (attacker.field_70143_R - 3.0F) * bonus;
/*     */             
/* 130 */             event.ammount = (damage = applyDropAttack(attacker, target, damage, bonus));
/*     */           }
/*     */           
/*     */ 
/* 134 */           if ((weapon.func_77973_b() instanceof IWeaponSpecial)) {
/* 135 */             ((IWeaponSpecial)weapon.func_77973_b()).onHit(damage, weapon, target, attacker);
/*     */           }
/*     */           
/* 138 */           if ((weapon.func_77973_b() instanceof IWeaponCustomSpeed)) {
/* 139 */             hurtTimeTemp += ((IWeaponCustomSpeed)weapon.func_77973_b()).getHitTime(weapon, target);
/* 140 */             hurtResistanceTimeTemp += ((IWeaponCustomSpeed)weapon.func_77973_b()).getHitTime(weapon, target);
/*     */           }
/*     */         }
/* 143 */         EventManagerMF.makeHitSound(weapon, target);
/*     */       }
/*     */     }
/* 146 */     target.field_70172_ad = hurtResistanceTimeTemp;
/* 147 */     target.field_70737_aN = hurtTimeTemp;
/*     */   }
/*     */   
/*     */   public static float applySneakAttack(Entity attacker, Entity target, float dam)
/*     */   {
/* 152 */     target.func_85030_a("minefantasy:Weapon.crit", dam / 2.0F, 1.0F);
/* 153 */     if ((attacker instanceof EntityPlayer)) {
/* 154 */       ((EntityPlayer)attacker).func_71009_b(target);
/*     */     }
/* 156 */     return dam;
/*     */   }
/*     */   
/*     */   public static void attackSpecial(Entity attacker, Entity target, float dam) {
/* 160 */     target.func_70097_a(new EntityDamageSource("battlegearSpecial", attacker), dam);
/*     */   }
/*     */   
/*     */   public static float applyDropAttack(EntityLivingBase attacker, Entity target, float dam, float bonus) {
/* 164 */     target.func_85030_a("minefantasy:Weapon.crit", dam * 2.0F, 1.0F);
/* 165 */     if ((attacker instanceof EntityPlayer)) {
/* 166 */       ((EntityPlayer)attacker).func_71009_b(target);
/*     */     }
/*     */     
/* 169 */     attacker.func_70694_bm().func_77972_a((int)(bonus / 2.0F), attacker);
/* 170 */     attacker.func_70634_a(target.field_70165_t, target.field_70163_u, target.field_70161_v);
/* 171 */     attacker.field_70181_x = 0.0D;
/* 172 */     attacker.field_70143_R = 0.0F;
/*     */     
/* 174 */     return dam * bonus;
/*     */   }
/*     */   
/*     */   protected static float applyArmorCalculations(float power, EntityLivingBase target, DamageSource source, float damage) {
/* 178 */     if (!source.func_76363_c()) {
/* 179 */       int i = 25 - (int)(target.func_70658_aO() * power);
/* 180 */       float f1 = damage * i;
/* 181 */       damage = f1 / 25.0F;
/*     */     }
/*     */     
/* 184 */     return damage;
/*     */   }
/*     */   
/*     */   public static float getMovementSpeedModifier(EntityLivingBase entity) {
/* 188 */     return getMovementSpeedModifier(entity, true);
/*     */   }
/*     */   
/*     */   public static float getMovementSpeedModifier(EntityLivingBase entity, boolean includeWep) {
/* 192 */     float r = 1.0F;
/*     */     
/* 194 */     float AC0 = getMoveSpeedFor(entity, 0);
/* 195 */     r -= (float)getArmourFractionOfTotal(AC0, 4);
/*     */     
/* 197 */     float AC1 = getMoveSpeedFor(entity, 1);
/* 198 */     r -= (float)getArmourFractionOfTotal(AC1, 7);
/*     */     
/* 200 */     float AC2 = getMoveSpeedFor(entity, 2);
/* 201 */     r -= (float)getArmourFractionOfTotal(AC2, 8);
/*     */     
/* 203 */     float AC3 = getMoveSpeedFor(entity, 3);
/* 204 */     r -= (float)getArmourFractionOfTotal(AC3, 5);
/*     */     
/* 206 */     if (includeWep) {
/* 207 */       r *= slowdownHeavyWeapon(entity);
/*     */     }
/* 209 */     return r;
/*     */   }
/*     */   
/*     */   public static int getAntisprintArmours(EntityLivingBase entity) {
/* 213 */     int r = 0;
/* 214 */     EnumArmourClass AC0 = getClassInSlot(entity, 0);
/* 215 */     r += (AC0.canSprintIn() ? 0 : 1);
/*     */     
/* 217 */     EnumArmourClass AC1 = getClassInSlot(entity, 1);
/* 218 */     r += (AC1.canSprintIn() ? 0 : 1);
/*     */     
/* 220 */     EnumArmourClass AC2 = getClassInSlot(entity, 2);
/* 221 */     r += (AC2.canSprintIn() ? 0 : 1);
/*     */     
/* 223 */     EnumArmourClass AC3 = getClassInSlot(entity, 3);
/* 224 */     r += (AC3.canSprintIn() ? 0 : 1);
/* 225 */     return r;
/*     */   }
/*     */   
/*     */   public static float getArmourExaustModifier(EntityLivingBase player) {
/* 229 */     float r = 0.0F;
/*     */     
/* 231 */     EnumArmourClass AC0 = getClassInSlot(player, 0);
/* 232 */     r += (float)getArmourFractionOfTotal(AC0.getExaustion(), 4);
/*     */     
/* 234 */     EnumArmourClass AC1 = getClassInSlot(player, 1);
/* 235 */     r += (float)getArmourFractionOfTotal(AC1.getExaustion(), 7);
/*     */     
/* 237 */     EnumArmourClass AC2 = getClassInSlot(player, 2);
/* 238 */     r += (float)getArmourFractionOfTotal(AC2.getExaustion(), 8);
/*     */     
/* 240 */     EnumArmourClass AC3 = getClassInSlot(player, 3);
/* 241 */     r += (float)getArmourFractionOfTotal(AC3.getExaustion(), 5);
/* 242 */     return r;
/*     */   }
/*     */   
/*     */   private static float getMoveSpeedFor(EntityLivingBase entity, int i) {
/* 246 */     EnumArmourClass AC = getClassInSlot(entity, i);
/* 247 */     float r = AC.getSpeedReduction();
/*     */     
/* 249 */     ItemStack armour = armourInSlot(entity, i);
/*     */     
/* 251 */     if ((armour != null) && (armour.func_77973_b() != null) && 
/* 252 */       ((armour.func_77973_b() instanceof IArmourCustomSpeed))) {
/* 253 */       r = 1.0F - ((IArmourCustomSpeed)armour.func_77973_b()).getMoveSpeed(armour);
/*     */     }
/*     */     
/* 256 */     return r;
/*     */   }
/*     */   
/*     */   public static double getArmourFractionOfTotal(double total, int armour) {
/* 260 */     return total / 24.0D * armour;
/*     */   }
/*     */   
/*     */   public static ItemStack armourInSlot(EntityLivingBase ent, int i) {
/* 264 */     return ent.func_71124_b(i + 1);
/*     */   }
/*     */   
/*     */   public static EnumArmourClass getClassInSlot(EntityLivingBase entity, int i) {
/* 268 */     return TacticalManager.getClassFor(armourInSlot(entity, i));
/*     */   }
/*     */   
/*     */   private static float slowdownHeavyWeapon(EntityLivingBase entity) {
/* 272 */     float wp = 1.0F;
/*     */     
/* 274 */     ItemStack held = entity.func_70694_bm();
/* 275 */     if ((held != null) && ((held.func_77973_b() instanceof IWeaponMobility))) {
/* 276 */       float minus = ((IWeaponMobility)held.func_77973_b()).getSpeedWhenEquipped();
/* 277 */       if (wp > minus) {
/* 278 */         wp = minus;
/*     */       }
/*     */     }
/* 281 */     if ((entity instanceof EntityPlayer)) {
/* 282 */       EntityPlayer player = (EntityPlayer)entity;
/*     */       
/* 284 */       for (int a = 0; a < 9; a++) {
/* 285 */         ItemStack slot = player.field_71071_by.field_70462_a[a];
/* 286 */         if ((slot != null) && ((slot.func_77973_b() instanceof IWeaponMobility))) {
/* 287 */           float minus = ((IWeaponMobility)slot.func_77973_b()).getSpeedWhenEquipped();
/* 288 */           if (wp > minus)
/* 289 */             wp = minus;
/*     */         }
/*     */       }
/*     */     } else {
/* 293 */       ItemStack s = entity.func_70694_bm();
/* 294 */       if ((s != null) && ((s.func_77973_b() instanceof IWeaponMobility))) {
/* 295 */         float minus = ((IWeaponMobility)s.func_77973_b()).getSpeedWhenEquipped();
/* 296 */         if (wp > minus)
/* 297 */           wp = minus;
/*     */       }
/*     */     }
/* 300 */     if (wp < 0.1D) {
/* 301 */       return 0.1F;
/*     */     }
/* 303 */     if ((cfg.disableWeight) && (wp < 1.0F)) {
/* 304 */       return 1.0F;
/*     */     }
/* 306 */     return wp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void damageWithBonus(EntityLivingBase target, DamageSource source, float damage, float bonus)
/*     */   {
/* 314 */     if (bonus < target.func_110143_aJ()) {
/* 315 */       target.func_70097_a(DamageSourceAP.blunt, bonus + damage);
/* 316 */       if ((!target.field_70170_p.field_72995_K) && (MineFantasyBase.isDebug())) {
/* 317 */         System.out.println("Damage");
/*     */       }
/*     */     }
/* 320 */     else if (!target.field_70170_p.field_72995_K) {
/* 321 */       target.func_70606_j(-1.0F);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void entityDropItem(Entity entity, ItemStack drop, float range)
/*     */   {
/* 329 */     if (drop.field_77994_a == 0) {
/* 330 */       return;
/*     */     }
/* 332 */     EntityItem entityitem = new EntityItem(entity.field_70170_p, entity.field_70165_t, entity.field_70163_u + range, entity.field_70161_v, drop);
/* 333 */     entityitem.field_70293_c = 50;
/* 334 */     if (entity.captureDrops) {
/* 335 */       entity.capturedDrops.add(entityitem);
/*     */     } else {
/* 337 */       entity.field_70170_p.func_72838_d(entityitem);
/*     */     }
/*     */   }
/*     */   
/*     */   private static float resistWithArmour(DamageSource source, float dam, EntityLivingBase target)
/*     */   {
/* 343 */     for (int a = 1; a < 5; a++) {
/* 344 */       ItemStack piece = target.func_71124_b(a);
/* 345 */       if ((piece != null) && ((piece.func_77973_b() instanceof IElementalResistance))) {
/* 346 */         IElementalResistance resist = (IElementalResistance)piece.func_77973_b();
/*     */         
/* 348 */         if (source.func_76347_k()) {
/* 349 */           dam *= resist.fireResistance();
/*     */         }
/*     */       }
/*     */     }
/* 353 */     return dam;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/CombatManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */