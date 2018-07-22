/*     */ package minefantasy.entity.ai;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockDoor;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.pathfinding.PathEntity;
/*     */ import net.minecraft.pathfinding.PathNavigate;
/*     */ import net.minecraft.pathfinding.PathPoint;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public abstract class EntityAIUseDoorMF
/*     */   extends EntityAIBase
/*     */ {
/*     */   protected EntityLiving theEntity;
/*     */   protected int entityPosX;
/*     */   protected int entityPosY;
/*     */   protected int entityPosZ;
/*     */   protected BlockDoor targetDoor;
/*     */   boolean hasStoppedDoorInteraction;
/*     */   float entityPositionX;
/*     */   float entityPositionZ;
/*     */   
/*     */   public EntityAIUseDoorMF(EntityLiving user)
/*     */   {
/*  28 */     this.theEntity = user;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean func_75250_a()
/*     */   {
/*  35 */     if (!this.theEntity.field_70123_F) {
/*  36 */       return false;
/*     */     }
/*  38 */     PathNavigate pathnavigate = this.theEntity.func_70661_as();
/*  39 */     PathEntity pathentity = pathnavigate.func_75505_d();
/*     */     
/*  41 */     if ((pathentity != null) && (!pathentity.func_75879_b()) && (pathnavigate.func_75507_c())) {
/*  42 */       for (int i = 0; i < Math.min(pathentity.func_75873_e() + 2, pathentity.func_75874_d()); i++) {
/*  43 */         PathPoint pathpoint = pathentity.func_75877_a(i);
/*  44 */         this.entityPosX = pathpoint.field_75839_a;
/*  45 */         this.entityPosY = (pathpoint.field_75837_b + 1);
/*  46 */         this.entityPosZ = pathpoint.field_75838_c;
/*     */         
/*  48 */         if (this.theEntity.func_70092_e(this.entityPosX, this.theEntity.field_70163_u, this.entityPosZ) <= 2.25D) {
/*  49 */           this.targetDoor = findUsableDoor(this.entityPosX, this.entityPosY, this.entityPosZ);
/*     */           
/*  51 */           if (this.targetDoor != null) {
/*  52 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*  57 */       this.entityPosX = MathHelper.func_76128_c(this.theEntity.field_70165_t);
/*  58 */       this.entityPosY = MathHelper.func_76128_c(this.theEntity.field_70163_u + 1.0D);
/*  59 */       this.entityPosZ = MathHelper.func_76128_c(this.theEntity.field_70161_v);
/*  60 */       this.targetDoor = findUsableDoor(this.entityPosX, this.entityPosY, this.entityPosZ);
/*  61 */       return this.targetDoor != null;
/*     */     }
/*  63 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_75253_b()
/*     */   {
/*  72 */     return !this.hasStoppedDoorInteraction;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_75249_e()
/*     */   {
/*  79 */     this.hasStoppedDoorInteraction = false;
/*  80 */     this.entityPositionX = ((float)(this.entityPosX + 0.5F - this.theEntity.field_70165_t));
/*  81 */     this.entityPositionZ = ((float)(this.entityPosZ + 0.5F - this.theEntity.field_70161_v));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_75246_d()
/*     */   {
/*  88 */     float f = (float)(this.entityPosX + 0.5F - this.theEntity.field_70165_t);
/*  89 */     float f1 = (float)(this.entityPosZ + 0.5F - this.theEntity.field_70161_v);
/*  90 */     float f2 = this.entityPositionX * f + this.entityPositionZ * f1;
/*     */     
/*  92 */     if (f2 < 0.0F) {
/*  93 */       this.hasStoppedDoorInteraction = true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private BlockDoor findUsableDoor(int x, int y, int z)
/*     */   {
/* 101 */     int l = this.theEntity.field_70170_p.func_72798_a(x, y, z);
/* 102 */     Block block = Block.field_71973_m[l];
/* 103 */     return (block instanceof BlockDoor) ? (BlockDoor)Block.field_71973_m[l] : null;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/ai/EntityAIUseDoorMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */