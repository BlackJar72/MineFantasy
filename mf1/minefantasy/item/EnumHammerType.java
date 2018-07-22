/*    */ package minefantasy.item;
/*    */ 
/*    */ public enum EnumHammerType
/*    */ {
/*  5 */   STONE(0, 0.3F, 50, 0),  TIN(0, 0.35F, 200, 4),  COPPER(0, 0.4F, 125, 5),  BRONZE(0, 0.5F, 250, 5),  IRON(0, 1.0F, 500, 10),  STEEL(0, 2.0F, 750, 12),  MITHRIL(0, 3.0F, 1000, 15),  DRAGONFORGE(0, 5.0F, 2500, 18),  ORNATE(1, 2.0F, 1000, 20);
/*    */   
/*    */   private final int enchant;
/*    */   private final int level;
/*    */   private final float strength;
/*    */   private final int uses;
/*    */   
/*    */   private EnumHammerType(int lvl, float str, int use, int en) {
/* 13 */     this.enchant = en;
/* 14 */     this.level = lvl;
/* 15 */     this.strength = str;
/* 16 */     this.uses = use;
/*    */   }
/*    */   
/*    */   public int getMaxUses() {
/* 20 */     return this.uses;
/*    */   }
/*    */   
/*    */   public float getStrength() {
/* 24 */     return this.strength;
/*    */   }
/*    */   
/*    */   public int getLevel() {
/* 28 */     return this.level;
/*    */   }
/*    */   
/*    */   public int getEnchantability() {
/* 32 */     return this.enchant;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/EnumHammerType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */