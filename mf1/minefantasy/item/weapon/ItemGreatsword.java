/*    */ package minefantasy.item.weapon;
/*    */ 
/*    */ import minefantasy.api.weapon.IWeaponMobility;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.item.EnumToolMaterial;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.potion.Potion;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ 
/*    */ public class ItemGreatsword extends ItemSwordMF implements IWeaponMobility, minefantasy.api.weapon.IWeaponCustomSpeed
/*    */ {
/*    */   public ItemGreatsword(int id, EnumToolMaterial material)
/*    */   {
/* 14 */     super(id, material);
/*    */   }
/*    */   
/*    */   public ItemGreatsword(int id, EnumToolMaterial material, float dam, int uses) {
/* 18 */     this(id, material);
/*    */   }
/*    */   
/*    */   public float getExaustion()
/*    */   {
/* 23 */     return 0.15F;
/*    */   }
/*    */   
/*    */   public float getSpeedWhenEquipped()
/*    */   {
/* 28 */     float degrade = 0.1F;
/* 29 */     if (getMaterial() == minefantasy.item.ToolMaterialMedieval.MITHRIL) {
/* 30 */       degrade /= 2.0F;
/*    */     }
/* 32 */     return 1.0F - degrade;
/*    */   }
/*    */   
/*    */   public boolean canBlock() {
/* 36 */     return true;
/*    */   }
/*    */   
/*    */   public float getKnockback()
/*    */   {
/* 41 */     return 3.0F;
/*    */   }
/*    */   
/*    */   public float getDamageModifier()
/*    */   {
/* 46 */     return super.getDamageModifier() * 1.5F;
/*    */   }
/*    */   
/*    */   public int getHitTime(ItemStack weapon, EntityLivingBase target)
/*    */   {
/* 51 */     return super.getHitTime(null, target) * 2 + 5;
/*    */   }
/*    */   
/*    */   public float getDurability()
/*    */   {
/* 56 */     return super.getDurability() * 1.5F;
/*    */   }
/*    */   
/*    */   public int getHandsUsed()
/*    */   {
/* 61 */     return 2;
/*    */   }
/*    */   
/*    */   public float getBalance()
/*    */   {
/* 66 */     return 0.8F;
/*    */   }
/*    */   
/*    */   public float getBlockFailureChance()
/*    */   {
/* 71 */     return 0.2F;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void applyHeavyAttackBonus(EntityLivingBase attacker, EntityLivingBase target)
/*    */   {
/* 78 */     if (minefantasy.system.CombatManager.getAntisprintArmours(attacker) < 4) {
/* 79 */       return;
/*    */     }
/*    */     
/* 82 */     if (this.rand.nextInt(5) == 0) {
/* 83 */       attacker.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 100, 0));
/* 84 */       attacker.func_70690_d(new PotionEffect(Potion.field_76424_c.field_76415_H, 100, 0));
/* 85 */       attacker.func_70691_i(1.0F);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/weapon/ItemGreatsword.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */