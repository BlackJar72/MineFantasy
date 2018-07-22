/*    */ package minefantasy.api.weapon;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.ChatMessageComponent;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.util.StatCollector;
/*    */ 
/*    */ public class DamageSourceWeaponBonus extends DamageSource
/*    */ {
/*    */   protected Entity damageSourceEntity;
/*    */   
/*    */   public DamageSourceWeaponBonus(String entityType, Entity attacker, boolean AP)
/*    */   {
/* 16 */     super(entityType);
/* 17 */     if (AP) {
/* 18 */       func_76348_h();
/*    */     }
/* 20 */     this.field_76373_n = "battlegearExtra";
/* 21 */     this.damageSourceEntity = attacker;
/*    */   }
/*    */   
/*    */   public Entity func_76346_g() {
/* 25 */     return this.damageSourceEntity;
/*    */   }
/*    */   
/*    */   public ChatMessageComponent func_76360_b(EntityLivingBase entity)
/*    */   {
/* 30 */     ItemStack itemstack = (this.damageSourceEntity instanceof EntityLivingBase) ? ((EntityLivingBase)this.damageSourceEntity).func_70694_bm() : null;
/* 31 */     String s = "death.attack." + this.field_76373_n;
/* 32 */     String s1 = s + ".item";
/* 33 */     return (itemstack != null) && (itemstack.func_82837_s()) && (StatCollector.func_94522_b(s1)) ? ChatMessageComponent.func_111082_b(s1, new Object[] { entity.func_96090_ax(), this.damageSourceEntity.func_96090_ax(), itemstack.func_82833_r() }) : ChatMessageComponent.func_111082_b(s, new Object[] { entity.func_96090_ax(), this.damageSourceEntity.func_96090_ax() });
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/weapon/DamageSourceWeaponBonus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */