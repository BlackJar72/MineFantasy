/*    */ package minefantasy.entity;
/*    */ 
/*    */ public class HoundBreedMix {
/*    */   private EnumHoundBreed breed1;
/*    */   private EnumHoundBreed breed2;
/*    */   private EnumHoundBreed result;
/*    */   
/*    */   public HoundBreedMix(EnumHoundBreed b1, EnumHoundBreed b2, EnumHoundBreed r) {
/*  9 */     this.breed1 = b1;
/* 10 */     this.breed2 = b2;
/* 11 */     this.result = r;
/*    */   }
/*    */   
/*    */   public boolean matches(EnumHoundBreed b1, EnumHoundBreed b2) {
/* 15 */     return ((this.breed1 == b1) && (this.breed2 == b2)) || ((this.breed1 == b2) && (this.breed2 == b1));
/*    */   }
/*    */   
/*    */   public EnumHoundBreed getResult() {
/* 19 */     return this.result;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/HoundBreedMix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */