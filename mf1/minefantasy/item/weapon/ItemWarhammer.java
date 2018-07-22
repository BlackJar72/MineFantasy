/*    */ package minefantasy.item.weapon;
/*    */ 
/*    */ import minefantasy.api.weapon.IWeaponCustomSpeed;
/*    */ import minefantasy.api.weapon.IWeaponMobility;
/*    */ import minefantasy.api.weapon.IWeaponPenetrateArmour;
/*    */ import minefantasy.item.ToolMaterialMedieval;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.item.EnumToolMaterial;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ItemWarhammer
/*    */   extends ItemWarpick
/*    */   implements IWeaponPenetrateArmour, IWeaponMobility, IWeaponCustomSpeed
/*    */ {
/*    */   public ItemWarhammer(int id, EnumToolMaterial material)
/*    */   {
/* 18 */     super(id, material);
/*    */   }
/*    */   
/*    */   public ItemWarhammer(int id, EnumToolMaterial material, float dam, int uses) {
/* 22 */     this(id, material);
/*    */   }
/*    */   
/*    */   public boolean func_77641_a(Block block)
/*    */   {
/* 27 */     return block.field_71990_ca == Block.field_71955_W.field_71990_ca ? false : super.func_77641_a(block);
/*    */   }
/*    */   
/*    */   public float getExaustion()
/*    */   {
/* 32 */     return 0.15F;
/*    */   }
/*    */   
/*    */   public float getSpeedWhenEquipped()
/*    */   {
/* 37 */     float degrade = 0.2F;
/* 38 */     if (getMaterial() == ToolMaterialMedieval.MITHRIL) {
/* 39 */       degrade /= 2.0F;
/*    */     }
/* 41 */     return 1.0F - degrade;
/*    */   }
/*    */   
/*    */   public float getArmourDamageBonus()
/*    */   {
/* 46 */     return 2.0F;
/*    */   }
/*    */   
/*    */   public boolean buffDamage()
/*    */   {
/* 51 */     return true;
/*    */   }
/*    */   
/*    */   public float getKnockback()
/*    */   {
/* 56 */     return 5.0F;
/*    */   }
/*    */   
/*    */   public float getDamageModifier()
/*    */   {
/* 61 */     return super.getDamageModifier() * 1.5F;
/*    */   }
/*    */   
/*    */   public int getHitTime(ItemStack weapon, EntityLivingBase target)
/*    */   {
/* 66 */     return super.getHitTime(null, target) * 2 + 5;
/*    */   }
/*    */   
/*    */   public float getDurability()
/*    */   {
/* 71 */     return super.getDurability() * 1.5F;
/*    */   }
/*    */   
/*    */   public int getHandsUsed()
/*    */   {
/* 76 */     return 2;
/*    */   }
/*    */   
/*    */   public boolean sheatheOnBack(ItemStack item)
/*    */   {
/* 81 */     return true;
/*    */   }
/*    */   
/*    */   public float getBalance()
/*    */   {
/* 86 */     return 1.0F;
/*    */   }
/*    */   
/*    */   public float getBlockFailureChance()
/*    */   {
/* 91 */     return 0.45F;
/*    */   }
/*    */   
/*    */   public float getDebilitation()
/*    */   {
/* 96 */     return 0.5F;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/weapon/ItemWarhammer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */