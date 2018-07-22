/*    */ package minefantasy.item.weapon;
/*    */ 
/*    */ import minefantasy.item.ToolMaterialMedieval;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.EnumToolMaterial;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemHalbeard
/*    */   extends ItemSpearMF
/*    */ {
/*    */   public ItemHalbeard(int id, EnumToolMaterial material)
/*    */   {
/* 17 */     super(id, material);
/*    */   }
/*    */   
/*    */   public ItemHalbeard(int id, EnumToolMaterial material, float dam, int uses) {
/* 21 */     this(id, material);
/*    */   }
/*    */   
/*    */   public float getDamageModifier()
/*    */   {
/* 26 */     return 1.8F;
/*    */   }
/*    */   
/*    */   public int getHitTime(ItemStack weapon, EntityLivingBase target)
/*    */   {
/* 31 */     return 10;
/*    */   }
/*    */   
/*    */   public float getExaustion()
/*    */   {
/* 36 */     return 0.15F;
/*    */   }
/*    */   
/*    */   public float getSpeedWhenEquipped()
/*    */   {
/* 41 */     float degrade = 0.2F;
/* 42 */     if (getMaterial() == ToolMaterialMedieval.MITHRIL) {
/* 43 */       degrade /= 2.0F;
/*    */     }
/* 45 */     return 1.0F - degrade;
/*    */   }
/*    */   
/*    */   public float getKnockback()
/*    */   {
/* 50 */     return 6.0F;
/*    */   }
/*    */   
/*    */   public ItemStack func_77659_a(ItemStack item, World world, EntityPlayer player)
/*    */   {
/* 55 */     return item;
/*    */   }
/*    */   
/*    */   public float getBalance()
/*    */   {
/* 60 */     return 0.75F;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/weapon/ItemHalbeard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */