/*    */ package minefantasy.item.weapon;
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum EnumBowType
/*    */ {
/*  7 */   SHORTBOW(0.75F, 1.0F, 1.0F), 
/*    */   
/*    */ 
/*    */ 
/* 11 */   RECURVE(0.7F, 1.5F, 1.0F), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 16 */   COMPOSITE(0.75F, 0.9F, 3.5F), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 21 */   LONGBOW(1.0F, 0.75F, 1.0F);
/*    */   
/*    */ 
/*    */ 
/*    */   public final float power;
/*    */   
/*    */ 
/*    */   public final float speed;
/*    */   
/*    */ 
/*    */   public final float durability;
/*    */   
/*    */ 
/*    */   private EnumBowType(float pwr, float spd, float dur)
/*    */   {
/* 36 */     this.power = pwr;
/* 37 */     this.speed = spd;
/* 38 */     this.durability = dur;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/weapon/EnumBowType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */