/*    */ package minefantasy.item.weapon;
/*    */ 
/*    */ import minefantasy.api.weapon.IWeaponCustomSpeed;
/*    */ import minefantasy.api.weapon.IWeaponWeakArmour;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.item.EnumToolMaterial;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.common.ForgeHooks;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ 
/*    */ public class ItemWaraxe extends ItemWeaponMF implements IWeaponCustomSpeed, IWeaponWeakArmour
/*    */ {
/*    */   public ItemWaraxe(int id, EnumToolMaterial material)
/*    */   {
/* 16 */     super(id, material);
/* 17 */     MinecraftForge.setToolClass(this, "axe", material.func_77996_d());
/*    */   }
/*    */   
/*    */   public ItemWaraxe(int id, EnumToolMaterial material, float dam, int uses) {
/* 21 */     this(id, material);
/*    */   }
/*    */   
/*    */   public float getDamageModifier()
/*    */   {
/* 26 */     return 1.2F;
/*    */   }
/*    */   
/*    */   public int getHitTime(ItemStack weapon, EntityLivingBase target)
/*    */   {
/* 31 */     return 1;
/*    */   }
/*    */   
/*    */   public float func_77638_a(ItemStack stack, Block block)
/*    */   {
/* 36 */     return ForgeHooks.isToolEffective(stack, block, this.material.func_77996_d()) ? this.material.func_77998_b() * 0.4F : 2.0F;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean canHarvestBlock(Block block, ItemStack stack)
/*    */   {
/* 44 */     return ForgeHooks.isToolEffective(stack, block, this.material.func_77996_d());
/*    */   }
/*    */   
/*    */   public float getDurability()
/*    */   {
/* 49 */     return 1.25F;
/*    */   }
/*    */   
/*    */   public float getArmourPower(ItemStack weapon)
/*    */   {
/* 54 */     return 0.5F;
/*    */   }
/*    */   
/*    */   public int getHandsUsed()
/*    */   {
/* 59 */     return 1;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/weapon/ItemWaraxe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */