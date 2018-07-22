/*    */ package minefantasy.item.weapon;
/*    */ 
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.item.EnumToolMaterial;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ItemDagger extends ItemWeaponMF implements minefantasy.api.weapon.IWeaponCustomSpeed, minefantasy.api.weapon.IStealthWeapon
/*    */ {
/*    */   public ItemDagger(int id, EnumToolMaterial material)
/*    */   {
/* 11 */     super(id, material);
/*    */   }
/*    */   
/*    */   public ItemDagger(int id, EnumToolMaterial material, float dam, int uses) {
/* 15 */     this(id, material);
/*    */   }
/*    */   
/*    */   public float getDamageModifier()
/*    */   {
/* 20 */     return 0.5F;
/*    */   }
/*    */   
/*    */   public int getHitTime(ItemStack weapon, EntityLivingBase target)
/*    */   {
/* 25 */     return -2;
/*    */   }
/*    */   
/*    */   public float getBackstabModifier()
/*    */   {
/* 30 */     return 4.0F;
/*    */   }
/*    */   
/*    */   public float getDropModifier()
/*    */   {
/* 35 */     return 3.0F;
/*    */   }
/*    */   
/*    */   public boolean canDropAttack()
/*    */   {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public float getDurability()
/*    */   {
/* 45 */     return 0.5F;
/*    */   }
/*    */   
/*    */   public int getHandsUsed()
/*    */   {
/* 50 */     return 1;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/weapon/ItemDagger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */