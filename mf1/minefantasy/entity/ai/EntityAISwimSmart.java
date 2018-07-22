/*    */ package minefantasy.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.ai.EntityAIBase;
/*    */ import net.minecraft.entity.ai.EntityJumpHelper;
/*    */ import net.minecraft.pathfinding.PathNavigate;
/*    */ 
/*    */ 
/*    */ public class EntityAISwimSmart
/*    */   extends EntityAIBase
/*    */ {
/*    */   private EntityLiving theEntity;
/*    */   
/*    */   public EntityAISwimSmart(EntityLiving user)
/*    */   {
/* 17 */     this.theEntity = user;
/* 18 */     func_75248_a(4);
/* 19 */     user.func_70661_as().func_75495_e(true);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean func_75250_a()
/*    */   {
/* 26 */     return (this.theEntity.func_70090_H()) || (this.theEntity.func_70058_J());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void func_75246_d()
/*    */   {
/* 33 */     boolean swimDown = false;
/*    */     
/* 35 */     if ((this.theEntity.func_70643_av() != null) && 
/* 36 */       (this.theEntity.func_70643_av().field_70163_u < this.theEntity.field_70163_u - 1.0D)) {
/* 37 */       swimDown = true;
/*    */     }
/*    */     
/*    */ 
/* 41 */     if (this.theEntity.func_70086_ai() < 10) {
/* 42 */       swimDown = false;
/*    */     }
/*    */     
/* 45 */     if (!swimDown) {
/* 46 */       this.theEntity.func_70683_ar().func_75660_a();
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/ai/EntityAISwimSmart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */