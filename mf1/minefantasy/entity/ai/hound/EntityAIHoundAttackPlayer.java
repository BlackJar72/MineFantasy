/*    */ package minefantasy.entity.ai.hound;
/*    */ 
/*    */ import minefantasy.entity.EntityHound;
/*    */ 
/*    */ public class EntityAIHoundAttackPlayer extends net.minecraft.entity.ai.EntityAINearestAttackableTarget
/*    */ {
/*    */   private EntityHound theTameable;
/*    */   
/*    */   public EntityAIHoundAttackPlayer(EntityHound dog, Class enemy, int chance, boolean chase) {
/* 10 */     super(dog, enemy, chance, chase);
/* 11 */     this.theTameable = dog;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean func_75250_a()
/*    */   {
/* 18 */     return this.theTameable.attackPlayer ? super.func_75250_a() : false;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/ai/hound/EntityAIHoundAttackPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */