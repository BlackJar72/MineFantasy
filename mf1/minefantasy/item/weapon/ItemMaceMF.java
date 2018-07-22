/*    */ package minefantasy.item.weapon;
/*    */ 
/*    */ import minefantasy.api.weapon.IWeaponCustomSpeed;
/*    */ import minefantasy.api.weapon.IWeaponPenetrateArmour;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.item.EnumToolMaterial;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ItemMaceMF
/*    */   extends ItemWeaponMF
/*    */   implements IWeaponPenetrateArmour, IWeaponCustomSpeed
/*    */ {
/*    */   private float APdamage;
/*    */   
/*    */   public ItemMaceMF(int id, EnumToolMaterial material)
/*    */   {
/* 18 */     super(id, material);
/* 19 */     this.APdamage = (this.baseDamage * getAPPercent());
/*    */   }
/*    */   
/*    */   public ItemMaceMF(int id, EnumToolMaterial material, float dam, int uses) {
/* 23 */     this(id, material);
/*    */   }
/*    */   
/*    */   public float getDamageModifier()
/*    */   {
/* 28 */     return 1.0F;
/*    */   }
/*    */   
/*    */   public int getHitTime(ItemStack weapon, EntityLivingBase target)
/*    */   {
/* 33 */     return 2;
/*    */   }
/*    */   
/*    */   public float getAPDamage()
/*    */   {
/* 38 */     return this.APdamage;
/*    */   }
/*    */   
/*    */   public boolean func_77641_a(Block block)
/*    */   {
/* 43 */     return block.field_71990_ca == Block.field_71955_W.field_71990_ca ? false : super.func_77641_a(block);
/*    */   }
/*    */   
/*    */   public float func_77638_a(ItemStack stack, Block block)
/*    */   {
/* 48 */     return 2.5F;
/*    */   }
/*    */   
/*    */   public float getDurability()
/*    */   {
/* 53 */     return 1.5F;
/*    */   }
/*    */   
/*    */   public float getArmourDamageBonus()
/*    */   {
/* 58 */     return 0.0F;
/*    */   }
/*    */   
/*    */   public boolean buffDamage()
/*    */   {
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int getHandsUsed()
/*    */   {
/* 68 */     return 1;
/*    */   }
/*    */   
/*    */   protected float getAPPercent()
/*    */   {
/* 73 */     return 0.25F;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/weapon/ItemMaceMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */