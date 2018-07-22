/*    */ package minefantasy.item.weapon;
/*    */ 
/*    */ import java.util.Random;
/*    */ import minefantasy.api.weapon.IWeaponCustomSpeed;
/*    */ import minefantasy.api.weapon.IWeaponMobility;
/*    */ import minefantasy.item.ToolMaterialMedieval;
/*    */ import minefantasy.system.CombatManager;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.item.EnumToolMaterial;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.potion.Potion;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ 
/*    */ public class ItemGreatmace extends ItemMaceMF implements minefantasy.api.weapon.IWeaponPenetrateArmour, IWeaponMobility, IWeaponCustomSpeed
/*    */ {
/*    */   public ItemGreatmace(int id, EnumToolMaterial material)
/*    */   {
/* 18 */     super(id, material);
/*    */   }
/*    */   
/*    */   public ItemGreatmace(int id, EnumToolMaterial material, float dam, int uses) {
/* 22 */     this(id, material);
/*    */   }
/*    */   
/*    */   public float getExaustion()
/*    */   {
/* 27 */     return 0.1F;
/*    */   }
/*    */   
/*    */   public float getSpeedWhenEquipped()
/*    */   {
/* 32 */     float degrade = 0.12F;
/* 33 */     if (getMaterial() == ToolMaterialMedieval.MITHRIL) {
/* 34 */       degrade /= 2.0F;
/*    */     }
/* 36 */     return 1.0F - degrade;
/*    */   }
/*    */   
/*    */   public float getDamageModifier()
/*    */   {
/* 41 */     return super.getDamageModifier() * 1.5F;
/*    */   }
/*    */   
/*    */   public int getHitTime(ItemStack weapon, EntityLivingBase target)
/*    */   {
/* 46 */     return super.getHitTime(null, target) * 2 + 5;
/*    */   }
/*    */   
/*    */   public float getDurability()
/*    */   {
/* 51 */     return super.getDurability() * 1.5F;
/*    */   }
/*    */   
/*    */   public int getHandsUsed()
/*    */   {
/* 56 */     return 2;
/*    */   }
/*    */   
/*    */   public float getBalance()
/*    */   {
/* 61 */     return 0.85F;
/*    */   }
/*    */   
/*    */   public float getBlockFailureChance()
/*    */   {
/* 66 */     return 0.25F;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void applyHeavyAttackBonus(EntityLivingBase attacker, EntityLivingBase target)
/*    */   {
/* 73 */     if (CombatManager.getAntisprintArmours(attacker) < 4) {
/* 74 */       return;
/*    */     }
/*    */     
/* 77 */     if (this.rand.nextInt(5) == 0) {
/* 78 */       attacker.func_70690_d(new PotionEffect(Potion.field_76420_g.field_76415_H, 100, 0));
/* 79 */       attacker.func_70690_d(new PotionEffect(Potion.field_76424_c.field_76415_H, 50, 0));
/* 80 */       attacker.func_70691_i(1.0F);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/weapon/ItemGreatmace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */