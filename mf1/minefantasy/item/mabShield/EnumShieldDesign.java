/*    */ package minefantasy.item.mabShield;
/*    */ 
/*    */ public enum EnumShieldDesign {
/*  4 */   BUCKLER("buckler", 10.0F, 0.35F, 1.0F, 15.0F, 2),  ROUND("round", 7.5F, 0.8F, 1.0F, 60.0F, 7),  KITE("kite", 6.5F, 0.7F, 1.0F, 90.0F, 10),  TOWER("tower", 5.0F, 1.1F, 1.25F, 120.0F, 15);
/*    */   
/*    */   private final String name;
/*    */   private final float carryTime;
/*    */   private final float threshold;
/*    */   private final float scale;
/*    */   private final float blockArc;
/*    */   private final int bashTime;
/*    */   
/*    */   private EnumShieldDesign(String label, float carry, float dt, float sc, float arc, int bash) {
/* 14 */     this.name = label;
/* 15 */     this.carryTime = carry;
/* 16 */     this.threshold = dt;
/* 17 */     this.scale = sc;
/* 18 */     this.blockArc = arc;
/* 19 */     this.bashTime = bash;
/*    */   }
/*    */   
/*    */   public String getTitle() {
/* 23 */     return this.name;
/*    */   }
/*    */   
/*    */   public float getCarryTime() {
/* 27 */     return this.carryTime;
/*    */   }
/*    */   
/*    */   public float getThreshold() {
/* 31 */     return this.threshold;
/*    */   }
/*    */   
/*    */   public float getScale() {
/* 35 */     return this.scale;
/*    */   }
/*    */   
/*    */   public float getArc() {
/* 39 */     return this.blockArc;
/*    */   }
/*    */   
/*    */   public int getBashTime() {
/* 43 */     return this.bashTime;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/mabShield/EnumShieldDesign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */