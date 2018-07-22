/*     */ package minefantasy.system;
/*     */ 
/*     */ import minefantasy.api.armour.EnumArmourClass;
/*     */ import minefantasy.api.armour.IArmourClass;
/*     */ import minefantasy.api.tactic.ISpecialSenses;
/*     */ import minefantasy.api.tactic.IStealthArmour;
/*     */ import minefantasy.api.weapon.IHiddenItem;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumArmorMaterial;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class TacticalManager
/*     */ {
/*     */   public static boolean isFlankedBy(Entity attacker, EntityLivingBase defender, float angle)
/*     */   {
/*  22 */     float att = getAttackAngle(attacker, defender);
/*  23 */     return (att > 270.0F - angle / 2.0F) && (att < 270.0F + angle / 2.0F);
/*     */   }
/*     */   
/*     */   public static float getAttackAngle(Entity attacker, EntityLivingBase defender) {
/*  27 */     float attackedAtYaw = 90.0F;
/*     */     
/*  29 */     if (attacker != null)
/*     */     {
/*  31 */       double d = attacker.field_70165_t - defender.field_70165_t;
/*     */       
/*     */ 
/*  34 */       for (double d1 = attacker.field_70161_v - defender.field_70161_v; d * d + d1 * d1 < 1.0E-4D; d1 = (Math.random() - Math.random()) * 0.01D) {
/*  35 */         d = (Math.random() - Math.random()) * 0.01D;
/*     */       }
/*     */       
/*  38 */       attackedAtYaw = (float)(Math.atan2(d1, d) * 180.0D / 3.141592653589793D) - defender.field_70177_z;
/*  39 */       while (attackedAtYaw > 360.0F) {
/*  40 */         attackedAtYaw -= 360.0F;
/*     */       }
/*  42 */       while (attackedAtYaw < 0.0F)
/*  43 */         attackedAtYaw += 360.0F;
/*     */     }
/*  45 */     return attackedAtYaw;
/*     */   }
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
/*     */   public static boolean isDetected(Entity target, Entity observer)
/*     */   {
/*  63 */     if (((observer instanceof EntityLiving)) && 
/*  64 */       (((EntityLiving)observer).field_70172_ad > 0)) {
/*  65 */       return true;
/*     */     }
/*     */     
/*  68 */     boolean sound = getAudioSound(target, observer) > getHearing(observer);
/*  69 */     boolean seen = getVisibility(target, observer) > getSight(observer);
/*  70 */     return (sound) || (seen);
/*     */   }
/*     */   
/*     */   public static int getVisibility(Entity target, Entity targeter) {
/*  74 */     int r = 100;
/*     */     
/*  76 */     if (isFlankedBy(target, (EntityLivingBase)targeter, 360 - getArc(targeter) * 2)) {
/*  77 */       return 0;
/*     */     }
/*     */     
/*  80 */     if (!isFlankedBy(target, (EntityLivingBase)targeter, 360 - getArc(targeter))) {
/*  81 */       r += 10;
/*     */     }
/*     */     
/*  84 */     int range = (int)target.func_70032_d(targeter);
/*     */     
/*  86 */     if (range > 10)
/*  87 */       r -= range - 10;
/*  88 */     if (range < 0.25F) {
/*  89 */       return 100;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  94 */     float light = target.field_70170_p.func_72957_l((int)target.field_70165_t, (int)target.field_70163_u, (int)target.field_70161_v);
/*  95 */     if (light > 24.0F) {
/*  96 */       light = 24.0F;
/*     */     }
/*  98 */     float multi = 4.0F;
/*  99 */     if ((target instanceof EntityLiving)) {
/* 100 */       multi *= modLight((EntityLiving)target);
/*     */     }
/* 102 */     r = (int)(r - (24.0F - light) * multi);
/*     */     
/* 104 */     if (isInvisible(target))
/* 105 */       r = 0;
/* 106 */     return r;
/*     */   }
/*     */   
/*     */   private static boolean isInvisible(Entity target) {
/* 110 */     if ((target instanceof EntityLiving)) {
/* 111 */       EntityLiving live = (EntityLiving)target;
/* 112 */       if (live.func_70660_b(net.minecraft.potion.Potion.field_76441_p) != null) {
/* 113 */         for (int a = 0; a < 5; a++) {
/* 114 */           if (live.func_71124_b(a) != null) {
/* 115 */             if ((live.func_71124_b(a).func_77973_b() instanceof IHiddenItem)) {
/* 116 */               if (!((IHiddenItem)live.func_71124_b(a).func_77973_b()).doesHide()) {
/* 117 */                 return false;
/*     */               }
/* 119 */             } else if ((live.func_71124_b(a).func_77973_b() instanceof IStealthArmour)) {
/* 120 */               if (!((IStealthArmour)live.func_71124_b(a).func_77973_b()).canTurnInvisible()) {
/* 121 */                 return false;
/*     */               }
/*     */             } else
/* 124 */               return false;
/*     */           }
/*     */         }
/* 127 */         return true;
/*     */       }
/*     */     }
/* 130 */     return false;
/*     */   }
/*     */   
/*     */   public static int getAudioSound(Entity target, Entity targeter) {
/* 134 */     int r = 0;
/*     */     
/* 136 */     if ((!isQuietSteps(target)) && (getSpeed(target) > 0.0D)) {
/* 137 */       r += 50;
/*     */     }
/*     */     
/*     */ 
/* 141 */     if (target.func_70051_ag()) {
/* 142 */       r += 50;
/*     */     }
/*     */     
/*     */ 
/* 146 */     int spd = r;
/* 147 */     if ((target instanceof EntityPlayer)) {
/* 148 */       spd = (int)getAudioMod((EntityPlayer)target, r);
/*     */     }
/* 150 */     if (spd < r)
/* 151 */       r = spd;
/* 152 */     if (getSpeed(target) > 0.0D) {
/* 153 */       if (spd > r) {
/* 154 */         r = spd;
/*     */       }
/* 156 */       if (target.func_70090_H()) {
/* 157 */         r += 10;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 162 */     int range = (int)target.func_70032_d(targeter);
/* 163 */     if (range > 2) {
/* 164 */       r /= range / 2;
/*     */     }
/* 166 */     if ((target instanceof EntityLiving)) {
/* 167 */       r = modSound(r, (EntityLiving)target);
/*     */     }
/* 169 */     return r;
/*     */   }
/*     */   
/*     */   private static boolean isQuietSteps(Entity target)
/*     */   {
/* 174 */     if ((target instanceof EntityLivingBase)) {
/* 175 */       EntityLivingBase live = (EntityLivingBase)target;
/* 176 */       if ((live.func_71124_b(4) != null) && 
/* 177 */         ((live.func_71124_b(4).func_77973_b() instanceof IStealthArmour)) && 
/* 178 */         (((IStealthArmour)live.func_71124_b(4).func_77973_b()).quietRun())) {
/* 179 */         return !target.func_70051_ag();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 184 */     return target.func_70093_af();
/*     */   }
/*     */   
/*     */   private static double getSpeed(Entity target) {
/* 188 */     double x = target.field_70165_t - target.field_70142_S;
/* 189 */     double y = target.field_70161_v - target.field_70136_U;
/*     */     
/* 191 */     if (y < 0.0D)
/* 192 */       y = -y;
/* 193 */     if (x < 0.0D) {
/* 194 */       x = -x;
/*     */     }
/* 196 */     return Math.hypot(x, y);
/*     */   }
/*     */   
/*     */   public static double getAudioMod(EntityPlayer player, int r) {
/* 200 */     int r1 = r;
/* 201 */     EnumArmourClass AC0 = getClassInSlot(player, 0);
/* 202 */     r = (int)(r + AC0.getSoundMod(0));
/* 203 */     EnumArmourClass AC1 = getClassInSlot(player, 1);
/* 204 */     r = (int)(r + AC1.getSoundMod(1));
/* 205 */     EnumArmourClass AC2 = getClassInSlot(player, 2);
/* 206 */     r = (int)(r + AC2.getSoundMod(2));
/* 207 */     EnumArmourClass AC3 = getClassInSlot(player, 3);
/* 208 */     r = (int)(r + AC3.getSoundMod(3));
/* 209 */     return r;
/*     */   }
/*     */   
/*     */   public static EnumArmourClass getClassInSlot(EntityPlayer player, int i) {
/* 213 */     return getClassFor(armourInSlot(player, i));
/*     */   }
/*     */   
/*     */   public static EnumArmourClass getClassFor(ItemStack armour) {
/* 217 */     if (armour == null) {
/* 218 */       return EnumArmourClass.UNARMOURED;
/*     */     }
/* 220 */     EnumArmourClass AC = EnumArmourClass.HEAVY;
/*     */     
/* 222 */     if ((armour.field_77993_c == Item.field_77687_V.field_77779_bT) || (armour.field_77993_c == Item.field_77686_W.field_77779_bT) || (armour.field_77993_c == Item.field_77693_X.field_77779_bT) || (armour.field_77993_c == Item.field_77692_Y.field_77779_bT)) {
/* 223 */       AC = EnumArmourClass.LIGHT;
/* 224 */     } else if (armour.func_77973_b().getClass().getName().endsWith("MoCItemArmor")) {
/* 225 */       AC = EnumArmourClass.LIGHT;
/* 226 */     } else if ((armour.field_77993_c == Item.field_77694_Z.field_77779_bT) || (armour.field_77993_c == Item.field_77814_aa.field_77779_bT) || (armour.field_77993_c == Item.field_77816_ab.field_77779_bT) || (armour.field_77993_c == Item.field_77810_ac.field_77779_bT)) {
/* 227 */       AC = EnumArmourClass.MEDIUM;
/* 228 */     } else if ((armour.func_77973_b() instanceof IArmourClass)) {
/* 229 */       AC = ((IArmourClass)armour.func_77973_b()).getArmourClass();
/*     */     }
/* 231 */     else if ((armour.func_77973_b() != null) && ((armour.func_77973_b() instanceof ItemArmor))) {
/* 232 */       EnumArmorMaterial material = ((ItemArmor)armour.func_77973_b()).func_82812_d();
/* 233 */       AC = getClassOf(material, AC);
/*     */     }
/*     */     
/* 236 */     AC = minefantasy.api.armour.ArmourWeightClass.getClassFor(armour, AC);
/*     */     
/* 238 */     return AC;
/*     */   }
/*     */   
/*     */   private static EnumArmourClass getClassOf(EnumArmorMaterial material, EnumArmourClass AC) {
/* 242 */     return AC;
/*     */   }
/*     */   
/*     */   public static int getHearing(Entity entity) {
/* 246 */     if ((entity instanceof ISpecialSenses)) {
/* 247 */       return ((ISpecialSenses)entity).getSight();
/*     */     }
/* 249 */     if (((entity instanceof EntityMob)) && 
/* 250 */       (((EntityMob)entity).func_70668_bt() == net.minecraft.entity.EnumCreatureAttribute.UNDEAD)) {
/* 251 */       return 10;
/*     */     }
/*     */     
/*     */ 
/* 255 */     return 5;
/*     */   }
/*     */   
/*     */   private static ItemStack armourInSlot(EntityPlayer player, int i) {
/* 259 */     return player.field_71071_by.func_70440_f(i);
/*     */   }
/*     */   
/*     */   public static int getSight(Entity entity) {
/* 263 */     if ((entity instanceof ISpecialSenses)) {
/* 264 */       return ((ISpecialSenses)entity).getSight();
/*     */     }
/* 266 */     return 20;
/*     */   }
/*     */   
/*     */   private static int getArc(Entity entity) {
/* 270 */     if ((entity instanceof ISpecialSenses)) {
/* 271 */       return ((ISpecialSenses)entity).getViewingArc();
/*     */     }
/* 273 */     return 90;
/*     */   }
/*     */   
/*     */   public static float getSoundModForItem(Item item) {
/* 277 */     if (item == null) {
/* 278 */       return 1.0F;
/*     */     }
/* 280 */     if ((item instanceof IStealthArmour)) {
/* 281 */       return ((IStealthArmour)item).noiseReduction();
/*     */     }
/* 283 */     return 1.0F;
/*     */   }
/*     */   
/*     */   public static float getSightModForItem(Item item) {
/* 287 */     if (item == null) {
/* 288 */       return 1.0F;
/*     */     }
/* 290 */     if ((item instanceof IStealthArmour)) {
/* 291 */       return ((IStealthArmour)item).darknessAmplifier();
/*     */     }
/* 293 */     return 1.0F;
/*     */   }
/*     */   
/*     */   public static float modLight(EntityLiving live) {
/* 297 */     float tot = 0.0F;
/* 298 */     for (int a = 0; a < 4; a++) {
/* 299 */       ItemStack armour = live.func_71124_b(a);
/* 300 */       if (armour == null) {
/* 301 */         tot += 1.0F;
/*     */       } else {
/* 303 */         tot += getSightModForItem(armour.func_77973_b());
/*     */       }
/*     */     }
/* 306 */     return tot / 4.0F;
/*     */   }
/*     */   
/*     */   public static int modSound(int sound, EntityLiving live) {
/* 310 */     float tot = 0.0F;
/* 311 */     for (int a = 0; a < 4; a++) {
/* 312 */       ItemStack armour = live.func_71124_b(a);
/* 313 */       if (armour == null) {
/* 314 */         tot += 1.0F;
/*     */       } else {
/* 316 */         tot += getSoundModForItem(armour.func_77973_b());
/*     */       }
/*     */     }
/* 319 */     return (int)(tot / 4.0F);
/*     */   }
/*     */   
/*     */   public static boolean canBackstab(EntityLivingBase attacker, EntityLivingBase target) {
/* 323 */     return isFlankedBy(target, attacker, 90.0F);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/TacticalManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */