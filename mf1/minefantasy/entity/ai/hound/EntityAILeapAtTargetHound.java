/*    */ package minefantasy.entity.ai.hound;
/*    */ 
/*    */ import minefantasy.entity.EntityHound;
/*    */ 
/*    */ public class EntityAILeapAtTargetHound extends net.minecraft.entity.ai.EntityAILeapAtTarget
/*    */ {
/*    */   private EntityHound hound;
/*    */   
/*    */   public EntityAILeapAtTargetHound(EntityHound dog, float chance)
/*    */   {
/* 11 */     super(dog, chance);
/* 12 */     this.hound = dog;
/*    */   }
/*    */   
/*    */   public boolean func_75250_a()
/*    */   {
/* 17 */     return this.hound.shouldLeapAttack() ? super.func_75250_a() : false;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/ai/hound/EntityAILeapAtTargetHound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */