/*    */ package minefantasy.entity.ai.hound;
/*    */ 
/*    */ import minefantasy.entity.EntityHound;
/*    */ import net.minecraft.util.Vec3;
/*    */ 
/*    */ public class EntityAIWanderHound extends net.minecraft.entity.ai.EntityAIBase
/*    */ {
/*    */   private EntityHound entity;
/*    */   private double xPosition;
/*    */   private double yPosition;
/*    */   private double zPosition;
/*    */   private float speed;
/*    */   
/*    */   public EntityAIWanderHound(EntityHound dog, float speed)
/*    */   {
/* 16 */     this.entity = dog;
/* 17 */     this.speed = speed;
/* 18 */     func_75248_a(1);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean func_75250_a()
/*    */   {
/* 25 */     if (!this.entity.shouldWander()) {
/* 26 */       return false;
/*    */     }
/* 28 */     if (this.entity.func_70654_ax() >= 100)
/* 29 */       return false;
/* 30 */     if (this.entity.func_70681_au().nextInt(120) != 0) {
/* 31 */       return false;
/*    */     }
/* 33 */     Vec3 vec3 = net.minecraft.entity.ai.RandomPositionGenerator.func_75463_a(this.entity, 10, 7);
/*    */     
/* 35 */     if (vec3 == null) {
/* 36 */       return false;
/*    */     }
/* 38 */     this.xPosition = vec3.field_72450_a;
/* 39 */     this.yPosition = vec3.field_72448_b;
/* 40 */     this.zPosition = vec3.field_72449_c;
/* 41 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean func_75253_b()
/*    */   {
/* 50 */     return !this.entity.func_70661_as().func_75500_f();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void func_75249_e()
/*    */   {
/* 57 */     this.entity.func_70661_as().func_75492_a(this.xPosition, this.yPosition, this.zPosition, this.speed);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/ai/hound/EntityAIWanderHound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */