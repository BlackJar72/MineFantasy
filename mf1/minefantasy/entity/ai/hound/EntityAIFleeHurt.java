/*    */ package minefantasy.entity.ai.hound;
/*    */ 
/*    */ import minefantasy.entity.EntityHound;
/*    */ import net.minecraft.entity.ai.EntityAIAvoidEntity;
/*    */ 
/*    */ public class EntityAIFleeHurt extends EntityAIAvoidEntity
/*    */ {
/*    */   private EntityHound hound;
/*    */   
/*    */   public EntityAIFleeHurt(EntityHound dog, Class flee, float distance, float speedF, float speedN)
/*    */   {
/* 12 */     super(dog, flee, distance, speedF, speedN);
/* 13 */     this.hound = dog;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean func_75250_a()
/*    */   {
/* 20 */     return false;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/ai/hound/EntityAIFleeHurt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */