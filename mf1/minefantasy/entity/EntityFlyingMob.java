/*    */ package minefantasy.entity;
/*    */ 
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public abstract class EntityFlyingMob extends EntityDaymob
/*    */ {
/*    */   public EntityFlyingMob(World world)
/*    */   {
/* 10 */     super(world);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void func_70069_a(float height) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void func_70064_a(double height, boolean b) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private boolean shouldFall()
/*    */   {
/* 28 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void func_70612_e(float x, float y)
/*    */   {
/* 35 */     if (func_70090_H()) {
/* 36 */       func_70060_a(x, y, 0.02F);
/* 37 */       func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 38 */       this.field_70159_w *= 0.800000011920929D;
/* 39 */       this.field_70181_x *= 0.800000011920929D;
/* 40 */       this.field_70179_y *= 0.800000011920929D;
/* 41 */     } else if (func_70058_J()) {
/* 42 */       func_70060_a(x, y, 0.02F);
/* 43 */       func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 44 */       this.field_70159_w *= 0.5D;
/* 45 */       this.field_70181_x *= 0.5D;
/* 46 */       this.field_70179_y *= 0.5D;
/*    */     } else {
/* 48 */       float f2 = 0.91F;
/*    */       
/* 50 */       if (this.field_70122_E) {
/* 51 */         f2 = 0.54600006F;
/* 52 */         int i = this.field_70170_p.func_72798_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70121_D.field_72338_b) - 1, MathHelper.func_76128_c(this.field_70161_v));
/*    */         
/* 54 */         if (i > 0) {
/* 55 */           f2 = net.minecraft.block.Block.field_71973_m[i].field_72016_cq * 0.91F;
/*    */         }
/*    */       }
/*    */       
/* 59 */       float f3 = 0.16277136F / (f2 * f2 * f2);
/* 60 */       func_70060_a(x, y, this.field_70122_E ? 0.1F * f3 : 0.02F);
/* 61 */       f2 = 0.91F;
/*    */       
/* 63 */       if (this.field_70122_E) {
/* 64 */         f2 = 0.54600006F;
/* 65 */         int j = this.field_70170_p.func_72798_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70121_D.field_72338_b) - 1, MathHelper.func_76128_c(this.field_70161_v));
/*    */         
/* 67 */         if (j > 0) {
/* 68 */           f2 = net.minecraft.block.Block.field_71973_m[j].field_72016_cq * 0.91F;
/*    */         }
/*    */       }
/*    */       
/* 72 */       func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 73 */       this.field_70159_w *= f2;
/* 74 */       this.field_70181_x *= f2;
/* 75 */       this.field_70179_y *= f2;
/*    */     }
/*    */     
/* 78 */     this.field_70722_aY = this.field_70721_aZ;
/* 79 */     double d0 = this.field_70165_t - this.field_70169_q;
/* 80 */     double d1 = this.field_70161_v - this.field_70166_s;
/* 81 */     float f4 = MathHelper.func_76133_a(d0 * d0 + d1 * d1) * 4.0F;
/*    */     
/* 83 */     if (f4 > 1.0F) {
/* 84 */       f4 = 1.0F;
/*    */     }
/*    */     
/* 87 */     this.field_70721_aZ += (f4 - this.field_70721_aZ) * 0.4F;
/* 88 */     this.field_70754_ba += this.field_70721_aZ;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean func_70617_f_()
/*    */   {
/* 95 */     return false;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/EntityFlyingMob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */