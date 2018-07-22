/*    */ package minefantasy.entity.ai.drake;
/*    */ 
/*    */ import java.util.Random;
/*    */ import minefantasy.entity.EntityDrake;
/*    */ import net.minecraft.pathfinding.PathNavigate;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityAIFindCave extends net.minecraft.entity.ai.EntityAIBase
/*    */ {
/*    */   private EntityDrake theCreature;
/*    */   private double shelterX;
/*    */   private double shelterY;
/*    */   private double shelterZ;
/*    */   private float movementSpeed;
/*    */   private World theWorld;
/*    */   
/*    */   public EntityAIFindCave(EntityDrake drake, float speed)
/*    */   {
/* 22 */     this.theCreature = drake;
/* 23 */     this.movementSpeed = speed;
/* 24 */     this.theWorld = drake.field_70170_p;
/* 25 */     func_75248_a(1);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean func_75250_a()
/*    */   {
/* 32 */     if (this.theCreature.state != 1)
/* 33 */       return false;
/* 34 */     if (!this.theWorld.func_72937_j(MathHelper.func_76128_c(this.theCreature.field_70165_t), (int)this.theCreature.field_70121_D.field_72338_b, MathHelper.func_76128_c(this.theCreature.field_70161_v))) {
/* 35 */       return false;
/*    */     }
/* 37 */     Vec3 var1 = findPossibleShelter();
/*    */     
/* 39 */     if (var1 == null) {
/* 40 */       return false;
/*    */     }
/* 42 */     this.shelterX = var1.field_72450_a;
/* 43 */     this.shelterY = var1.field_72448_b;
/* 44 */     this.shelterZ = var1.field_72449_c;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean func_75253_b()
/*    */   {
/* 54 */     return !this.theCreature.func_70661_as().func_75500_f();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void func_75249_e()
/*    */   {
/* 61 */     this.theCreature.func_70661_as().func_75492_a(this.shelterX, this.shelterY, this.shelterZ, this.movementSpeed);
/*    */   }
/*    */   
/*    */   private Vec3 findPossibleShelter() {
/* 65 */     Random var1 = this.theCreature.func_70681_au();
/*    */     
/* 67 */     for (int var2 = 0; var2 < 10; var2++) {
/* 68 */       int var3 = MathHelper.func_76128_c(this.theCreature.field_70165_t + var1.nextInt(20) - 10.0D);
/* 69 */       int var4 = MathHelper.func_76128_c(this.theCreature.field_70121_D.field_72338_b + var1.nextInt(6) - 3.0D);
/* 70 */       int var5 = MathHelper.func_76128_c(this.theCreature.field_70161_v + var1.nextInt(20) - 10.0D);
/*    */       
/* 72 */       if ((!this.theWorld.func_72937_j(var3, var4, var5)) && (this.theCreature.func_70783_a(var3, var4, var5) < 0.0F)) {
/* 73 */         return this.theWorld.func_82732_R().func_72345_a(var3, var4, var5);
/*    */       }
/*    */     }
/*    */     
/* 77 */     return null;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/ai/drake/EntityAIFindCave.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */