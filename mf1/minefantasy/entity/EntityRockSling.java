/*    */ package minefantasy.entity;
/*    */ 
/*    */ import minefantasy.item.ItemListMF;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.projectile.EntityThrowable;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityRockSling extends EntityThrowable
/*    */ {
/*    */   public EntityRockSling(World world)
/*    */   {
/* 17 */     super(world);
/*    */   }
/*    */   
/*    */   public EntityRockSling(World world, EntityLivingBase thrower, float f) {
/* 21 */     super(world, thrower);
/*    */     
/* 23 */     this.field_70159_w = (-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F) * f);
/* 24 */     this.field_70179_y = (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F) * f);
/* 25 */     this.field_70181_x = (-MathHelper.func_76126_a((this.field_70125_A + func_70183_g()) / 180.0F * 3.1415927F) * f);
/* 26 */     func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, func_70182_d(), 1.0F);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void func_70184_a(MovingObjectPosition pos)
/*    */   {
/* 34 */     if (pos.field_72308_g != null) {
/* 35 */       pos.field_72308_g.func_70097_a(DamageSource.func_76356_a(this, func_85052_h()), 4.0F);
/*    */     }
/*    */     
/* 38 */     for (int i = 0; i < 8; i++) {
/* 39 */       this.field_70170_p.func_72869_a("snowballpoof", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0D, 0.0D, 0.0D);
/*    */     }
/*    */     
/* 42 */     if (!this.field_70170_p.field_72995_K) {
/* 43 */       func_70099_a(new ItemStack(ItemListMF.misc, 1, 108), 0.0F);
/* 44 */       func_70106_y();
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/EntityRockSling.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */