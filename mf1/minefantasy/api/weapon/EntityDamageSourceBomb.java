/*    */ package minefantasy.api.weapon;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.ChatMessageComponent;
/*    */ import net.minecraft.util.EntityDamageSourceIndirect;
/*    */ 
/*    */ public class EntityDamageSourceBomb extends EntityDamageSourceIndirect
/*    */ {
/*    */   private Entity thrower;
/*    */   
/*    */   public EntityDamageSourceBomb(Entity bomb, Entity user)
/*    */   {
/* 15 */     super("bomb", bomb, user);
/* 16 */     this.thrower = user;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public ChatMessageComponent func_76360_b(EntityLivingBase hurtEnemy)
/*    */   {
/* 24 */     String throwername = this.thrower == null ? this.field_76386_o.func_96090_ax() : this.thrower.func_96090_ax();
/* 25 */     ItemStack itemstack = (this.thrower instanceof EntityLivingBase) ? ((EntityLivingBase)this.thrower).func_70694_bm() : null;
/* 26 */     String damageType = "death.attack.bomb";
/*    */     
/* 28 */     String src = "";
/* 29 */     if ((this.thrower != null) && (this.thrower != func_76364_f())) {
/* 30 */       if (this.thrower == hurtEnemy) {
/* 31 */         src = ".suicide";
/*    */       } else {
/* 33 */         src = ".thrown";
/*    */       }
/*    */     }
/* 36 */     String s2 = damageType + src;
/* 37 */     return ChatMessageComponent.func_111082_b(s2, new Object[] { hurtEnemy.func_96090_ax(), throwername });
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/weapon/EntityDamageSourceBomb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */