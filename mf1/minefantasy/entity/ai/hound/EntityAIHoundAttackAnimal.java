/*    */ package minefantasy.entity.ai.hound;
/*    */ 
/*    */ import minefantasy.entity.EntityHound;
/*    */ import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
/*    */ 
/*    */ public class EntityAIHoundAttackAnimal extends EntityAINearestAttackableTarget
/*    */ {
/*    */   private EntityHound theTameable;
/*    */   
/*    */   public EntityAIHoundAttackAnimal(EntityHound dog, Class enemy, int chance, boolean chase)
/*    */   {
/* 12 */     super(dog, enemy, chance, chase);
/* 13 */     this.theTameable = dog;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean func_75250_a()
/*    */   {
/* 20 */     return this.theTameable.attackAnimal ? super.func_75250_a() : false;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/ai/hound/EntityAIHoundAttackAnimal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */