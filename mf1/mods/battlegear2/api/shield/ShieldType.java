/*    */ package mods.battlegear2.api.shield;
/*    */ 
/*    */ public class ShieldType
/*    */ {
/*  5 */   public static final ShieldType WOOD = new ShieldType("wood", 0.05F, 0.05F, 40, 15, -4417438);
/*  6 */   public static final ShieldType HIDE = new ShieldType("hide", 0.033333335F, 0.05F, 40, 12, -6600661);
/*  7 */   public static final ShieldType IRON = new ShieldType("iron", 0.016666668F, 0.05F, 120, 9, -5460820);
/*  8 */   public static final ShieldType DIAMOND = new ShieldType("diamond", 0.01F, 0.05F, 263, 10, -14434369);
/*  9 */   public static final ShieldType GOLD = new ShieldType("gold", 0.025F, 0.05F, 56, 25, -5725184);
/*    */   private final float decayRate;
/*    */   private final float damageDecay;
/*    */   private final String name;
/*    */   private final int enchantability;
/*    */   private final int maxDamage;
/*    */   private final int defaultRGB;
/*    */   
/*    */   public ShieldType(String name, float decayRate, float damageDecay, int maxDamage, int enchantability, int defaultColour)
/*    */   {
/* 19 */     this.name = name;
/* 20 */     this.decayRate = decayRate;
/* 21 */     this.damageDecay = damageDecay;
/* 22 */     this.enchantability = enchantability;
/* 23 */     this.maxDamage = maxDamage;
/* 24 */     this.defaultRGB = defaultColour;
/*    */   }
/*    */   
/*    */   public float getDecayRate() {
/* 28 */     return this.decayRate;
/*    */   }
/*    */   
/*    */   public float getDamageDecay() {
/* 32 */     return this.damageDecay;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 36 */     return this.name;
/*    */   }
/*    */   
/*    */   public int getEnchantability() {
/* 40 */     return this.enchantability;
/*    */   }
/*    */   
/*    */   public int getMaxDamage() {
/* 44 */     return this.maxDamage;
/*    */   }
/*    */   
/*    */   public int getDefaultRGB() {
/* 48 */     return this.defaultRGB;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/shield/ShieldType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */