/*    */ package minefantasy.entity.ai;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.BlockDoor;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityAIBreakDoorAnimate
/*    */   extends EntityAIUseDoorMF
/*    */ {
/*    */   private EntityLiving hoster;
/*    */   private int breakTime;
/*    */   
/*    */   public EntityAIBreakDoorAnimate(EntityLiving host)
/*    */   {
/* 18 */     super(host);
/* 19 */     this.hoster = host;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean func_75250_a()
/*    */   {
/* 26 */     return super.func_75250_a();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void func_75249_e()
/*    */   {
/* 33 */     super.func_75249_e();
/* 34 */     this.breakTime = 240;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean func_75253_b()
/*    */   {
/* 41 */     double var1 = this.theEntity.func_70092_e(this.entityPosX, this.entityPosY, this.entityPosZ);
/* 42 */     return (this.breakTime >= 0) && (!this.targetDoor.func_72233_a_(this.theEntity.field_70170_p, this.entityPosX, this.entityPosY, this.entityPosZ)) && (var1 < 4.0D);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void func_75246_d()
/*    */   {
/* 49 */     super.func_75246_d();
/* 50 */     if (this.theEntity.func_70681_au().nextInt(20) == 0) {
/* 51 */       this.hoster.func_71038_i();
/* 52 */       this.theEntity.field_70170_p.func_72926_e(1010, this.entityPosX, this.entityPosY, this.entityPosZ, 0);
/*    */     }
/* 54 */     if ((--this.breakTime == 0) && (this.theEntity.field_70170_p.field_73013_u == 3)) {
/* 55 */       this.theEntity.field_70170_p.func_94571_i(this.entityPosX, this.entityPosY, this.entityPosZ);
/* 56 */       this.theEntity.field_70170_p.func_72926_e(1012, this.entityPosX, this.entityPosY, this.entityPosZ, 0);
/* 57 */       this.theEntity.field_70170_p.func_72926_e(2001, this.entityPosX, this.entityPosY, this.entityPosZ, this.targetDoor.field_71990_ca);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/ai/EntityAIBreakDoorAnimate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */