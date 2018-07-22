/*    */ package minefantasy.entity.ai.hound;
/*    */ 
/*    */ import minefantasy.entity.EntityHound;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.ai.EntityAIFollowOwner;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityAIFollowHound
/*    */   extends EntityAIFollowOwner
/*    */ {
/*    */   private EntityHound thePet;
/*    */   
/*    */   public EntityAIFollowHound(EntityHound dog, float speed, float min, float max)
/*    */   {
/* 16 */     super(dog, speed, min, max);
/* 17 */     this.thePet = dog;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean func_75250_a()
/*    */   {
/* 24 */     Entity owner = this.thePet.func_70902_q();
/*    */     
/* 26 */     if (owner == null)
/* 27 */       return false;
/* 28 */     if (!this.thePet.isFollowing()) {
/* 29 */       return false;
/*    */     }
/* 31 */     return super.func_75250_a();
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/ai/hound/EntityAIFollowHound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */