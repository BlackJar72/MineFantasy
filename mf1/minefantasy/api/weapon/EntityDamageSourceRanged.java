/*    */ package minefantasy.api.weapon;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.EntityDamageSourceIndirect;
/*    */ 
/*    */ public class EntityDamageSourceRanged extends EntityDamageSourceIndirect
/*    */ {
/*    */   private Entity shooter;
/*    */   
/*    */   public EntityDamageSourceRanged(Entity arrow, Entity user, boolean AP)
/*    */   {
/* 12 */     super("arrow", arrow, user);
/* 13 */     this.shooter = user;
/* 14 */     if (AP) {
/* 15 */       func_76348_h();
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/weapon/EntityDamageSourceRanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */