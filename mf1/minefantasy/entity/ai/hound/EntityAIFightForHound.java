/*    */ package minefantasy.entity.ai.hound;
/*    */ 
/*    */ import minefantasy.entity.EntityHound;
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.ai.EntityAITarget;
/*    */ 
/*    */ public class EntityAIFightForHound extends EntityAITarget
/*    */ {
/*    */   EntityHound hound;
/*    */   EntityLivingBase enemy;
/*    */   private int lastRevenge;
/*    */   
/*    */   public EntityAIFightForHound(EntityHound dog)
/*    */   {
/* 16 */     super(dog, false);
/* 17 */     this.hound = dog;
/* 18 */     func_75248_a(1);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean func_75250_a()
/*    */   {
/* 26 */     if ((!this.hound.func_70909_n()) || (!this.hound.shouldDefendOwner(this.enemy))) {
/* 27 */       return false;
/*    */     }
/* 29 */     EntityLivingBase entitylivingbase = this.hound.func_130012_q();
/*    */     
/* 31 */     if (entitylivingbase == null) {
/* 32 */       return false;
/*    */     }
/* 34 */     this.enemy = entitylivingbase.func_110144_aD();
/* 35 */     int i = entitylivingbase.func_142013_aG();
/* 36 */     return (i != this.lastRevenge) && (func_75296_a(this.enemy, false)) && (this.hound.func_142018_a(this.enemy, entitylivingbase));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void func_75249_e()
/*    */   {
/* 45 */     this.field_75299_d.func_70624_b(this.enemy);
/* 46 */     EntityLivingBase entitylivingbase = this.hound.func_130012_q();
/*    */     
/* 48 */     if (entitylivingbase != null) {
/* 49 */       this.lastRevenge = entitylivingbase.func_142013_aG();
/*    */     }
/*    */     
/* 52 */     super.func_75249_e();
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/ai/hound/EntityAIFightForHound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */