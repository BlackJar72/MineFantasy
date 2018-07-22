/*     */ package minefantasy.item.weapon;
/*     */ 
/*     */ import minefantasy.api.weapon.IWeaponCustomSpeed;
/*     */ import minefantasy.api.weapon.IWeaponMobility;
/*     */ import minefantasy.system.CombatManager;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.monster.EntityCreeper;
/*     */ import net.minecraft.item.EnumToolMaterial;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.DamageSource;
/*     */ 
/*     */ public class ItemBattleaxe extends ItemWaraxe implements IWeaponMobility, IWeaponCustomSpeed
/*     */ {
/*     */   public ItemBattleaxe(int id, EnumToolMaterial material)
/*     */   {
/*  19 */     super(id, material);
/*     */   }
/*     */   
/*     */   public ItemBattleaxe(int id, EnumToolMaterial material, float dam, int uses) {
/*  23 */     this(id, material);
/*     */   }
/*     */   
/*     */   public float getExaustion()
/*     */   {
/*  28 */     return 0.3F;
/*     */   }
/*     */   
/*     */   public float getSpeedWhenEquipped()
/*     */   {
/*  33 */     float degrade = 0.16F;
/*  34 */     if (getMaterial() == minefantasy.item.ToolMaterialMedieval.MITHRIL) {
/*  35 */       degrade /= 2.0F;
/*     */     }
/*  37 */     return 1.0F - degrade;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean canHarvestBlock(Block block, ItemStack stack)
/*     */   {
/*  45 */     return net.minecraftforge.common.ForgeHooks.isToolEffective(stack, block, this.material.func_77996_d());
/*     */   }
/*     */   
/*     */   public float getKnockback()
/*     */   {
/*  50 */     return 4.0F;
/*     */   }
/*     */   
/*     */   public float getDamageModifier()
/*     */   {
/*  55 */     return super.getDamageModifier() * 1.5F;
/*     */   }
/*     */   
/*     */   public int getHitTime(ItemStack weapon, EntityLivingBase target)
/*     */   {
/*  60 */     return super.getHitTime(null, target) * 2 + 5;
/*     */   }
/*     */   
/*     */   public float getDurability()
/*     */   {
/*  65 */     return super.getDurability() * 1.5F;
/*     */   }
/*     */   
/*     */   public int getHandsUsed()
/*     */   {
/*  70 */     return 2;
/*     */   }
/*     */   
/*     */   public float getBalance()
/*     */   {
/*  75 */     return 0.95F;
/*     */   }
/*     */   
/*     */   public float getBlockFailureChance()
/*     */   {
/*  80 */     return 0.15F;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void applyHeavyDefenseBonus(DamageSource source, EntityLivingBase user)
/*     */   {
/*  88 */     if (CombatManager.getMovementSpeedModifier(user, false) < 1.0F) {
/*  89 */       return;
/*     */     }
/*  91 */     boolean creeper = (source.func_94541_c()) && (source.func_76346_g() != null) && ((source.func_76346_g() instanceof EntityCreeper));
/*     */     
/*     */ 
/*  94 */     if ((user.func_110143_aJ() < user.func_110138_aP() * 0.35F) || (creeper)) {
/*  95 */       user.func_70690_d(new PotionEffect(Potion.field_76420_g.field_76415_H, 200, 0));
/*  96 */       user.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 200, 1));
/*  97 */       if (source.func_76352_a()) {
/*  98 */         user.func_70690_d(new PotionEffect(Potion.field_76424_c.field_76415_H, 100, 1));
/*     */       }
/*     */       
/*     */ 
/* 102 */       if (user.func_110143_aJ() < user.func_110138_aP() * 0.2F) {
/* 103 */         user.func_70690_d(new PotionEffect(Potion.field_76428_l.field_76415_H, 60, 0));
/* 104 */         if (source.func_76352_a()) {
/* 105 */           user.func_70690_d(new PotionEffect(Potion.field_76424_c.field_76415_H, 100, 2));
/*     */         } else {
/* 107 */           user.func_70690_d(new PotionEffect(Potion.field_76424_c.field_76415_H, 100, 1));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/weapon/ItemBattleaxe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */