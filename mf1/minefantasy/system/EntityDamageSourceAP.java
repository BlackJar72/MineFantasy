/*    */ package minefantasy.system;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ public class EntityDamageSourceAP extends net.minecraft.util.EntityDamageSource
/*    */ {
/*    */   public EntityDamageSourceAP(String type, Entity attacker)
/*    */   {
/*  9 */     super(type, attacker);
/* 10 */     func_76348_h();
/*    */   }
/*    */   
/*    */   public static EntityDamageSourceAP causeDamage(Entity attacker) {
/* 14 */     String type = (attacker instanceof net.minecraft.entity.player.EntityPlayer) ? "player" : "mob";
/* 15 */     return new EntityDamageSourceAP(type, attacker);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/EntityDamageSourceAP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */