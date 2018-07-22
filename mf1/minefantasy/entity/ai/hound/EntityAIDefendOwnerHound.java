/*    */ package minefantasy.entity.ai.hound;
/*    */ 
/*    */ import minefantasy.entity.EntityHound;
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.ai.EntityAITarget;
/*    */ 
/*    */ public class EntityAIDefendOwnerHound
/*    */   extends EntityAITarget
/*    */ {
/*    */   EntityHound hound;
/*    */   EntityLivingBase enemy;
/*    */   private int lastRevengeTime;
/*    */   
/*    */   public EntityAIDefendOwnerHound(EntityHound dog)
/*    */   {
/* 17 */     super(dog, false);
/* 18 */     this.hound = dog;
/* 19 */     func_75248_a(1);
/*    */   }
/*    */   
/*    */   public boolean func_75250_a() {
/* 23 */     if ((!this.hound.func_70909_n()) || (!this.hound.shouldDefendOwner(this.enemy))) {
/* 24 */       return false;
/*    */     }
/* 26 */     EntityLivingBase entitylivingbase = this.hound.func_130012_q();
/*    */     
/* 28 */     if (entitylivingbase == null) {
/* 29 */       return false;
/*    */     }
/* 31 */     this.enemy = entitylivingbase.func_70643_av();
/* 32 */     int i = entitylivingbase.func_142015_aE();
/* 33 */     return (i != this.lastRevengeTime) && (func_75296_a(this.enemy, false)) && (this.hound.func_142018_a(this.enemy, entitylivingbase));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void func_75249_e()
/*    */   {
/* 42 */     this.field_75299_d.func_70624_b(this.enemy);
/* 43 */     EntityLivingBase entitylivingbase = this.hound.func_130012_q();
/*    */     
/* 45 */     if (entitylivingbase != null) {
/* 46 */       this.lastRevengeTime = entitylivingbase.func_142015_aE();
/*    */     }
/*    */     
/* 49 */     super.func_75249_e();
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/ai/hound/EntityAIDefendOwnerHound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */