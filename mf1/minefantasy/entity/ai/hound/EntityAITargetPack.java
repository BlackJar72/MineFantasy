/*    */ package minefantasy.entity.ai.hound;
/*    */ 
/*    */ import minefantasy.entity.EntityHound;
/*    */ 
/*    */ public class EntityAITargetPack extends net.minecraft.entity.ai.EntityAINearestAttackableTarget
/*    */ {
/*    */   private EntityHound theTameable;
/*    */   
/*    */   public EntityAITargetPack(EntityHound dog, Class target, int chance, boolean shouldSee)
/*    */   {
/* 11 */     super(dog, target, chance, shouldSee);
/* 12 */     this.theTameable = dog;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean func_75250_a()
/*    */   {
/* 19 */     return !this.theTameable.func_70909_n();
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/ai/hound/EntityAITargetPack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */