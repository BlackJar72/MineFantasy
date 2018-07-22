/*    */ package minefantasy.item;
/*    */ 
/*    */ public enum EnumCrossbowType
/*    */ {
/*  5 */   HAND_CROSSBOW("crossbowHand", 1, 10, 3.5F, 300, 0.5F, 12),  LIGHT_CROSSBOW("crossbowLight", 1, 30, 1.5F, 800, 1.0F, 10),  REPEATER_CROSSBOW("crossbowRepeat", 6, 20, 3.0F, 1000, 0.9F, 8),  HEAVY_CROSSBOW("crossbowHeavy", 1, 45, 2.0F, 800, 1.0F, 10);
/*    */   
/*    */   private int ammo;
/*    */   private int durability;
/*    */   private int time;
/*    */   private float accuracy;
/*    */   private float damage;
/*    */   private int enchant;
/*    */   private String name;
/*    */   
/*    */   private EnumCrossbowType(String n, int a, int t, float a1, int u, float d, int e) {
/* 16 */     this.name = n;
/* 17 */     this.enchant = e;
/* 18 */     this.durability = u;
/* 19 */     this.damage = d;
/* 20 */     this.ammo = a;
/* 21 */     this.time = t;
/* 22 */     this.accuracy = a1;
/*    */   }
/*    */   
/*    */   public int getMaxAmmo() {
/* 26 */     return this.ammo;
/*    */   }
/*    */   
/*    */   public int getReload() {
/* 30 */     return this.time;
/*    */   }
/*    */   
/*    */   public float getAccuracy() {
/* 34 */     return this.accuracy;
/*    */   }
/*    */   
/*    */   public int getDurability() {
/* 38 */     return this.durability;
/*    */   }
/*    */   
/*    */   public float getDamage() {
/* 42 */     return this.damage;
/*    */   }
/*    */   
/*    */   public int getEnchantment() {
/* 46 */     return this.enchant;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 50 */     return this.name;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/EnumCrossbowType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */