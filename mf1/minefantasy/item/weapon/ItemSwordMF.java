/*    */ package minefantasy.item.weapon;
/*    */ 
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.item.EnumToolMaterial;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ public class ItemSwordMF
/*    */   extends ItemWeaponMF
/*    */ {
/*    */   public ItemSwordMF(int id, EnumToolMaterial material)
/*    */   {
/* 13 */     super(id, material);
/*    */   }
/*    */   
/*    */   public ItemSwordMF(int id, EnumToolMaterial material, float dam, int uses) {
/* 17 */     this(id, material);
/*    */   }
/*    */   
/*    */   public float getDamageModifier()
/*    */   {
/* 22 */     return 1.0F;
/*    */   }
/*    */   
/*    */   public boolean canBlock() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public float getDurability()
/*    */   {
/* 31 */     return 1.0F;
/*    */   }
/*    */   
/*    */   public int getHitTime(ItemStack weapon, EntityLivingBase target) {
/* 35 */     return 0;
/*    */   }
/*    */   
/*    */   public int getHandsUsed()
/*    */   {
/* 40 */     return 1;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/weapon/ItemSwordMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */