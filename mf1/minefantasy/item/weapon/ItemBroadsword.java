/*    */ package minefantasy.item.weapon;
/*    */ 
/*    */ import minefantasy.api.weapon.IWeaponSpecialBlock;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.EnumToolMaterial;
/*    */ import net.minecraft.util.DamageSource;
/*    */ 
/*    */ 
/*    */ public class ItemBroadsword
/*    */   extends ItemWeaponMF
/*    */   implements IWeaponSpecialBlock
/*    */ {
/*    */   public ItemBroadsword(int id, EnumToolMaterial material)
/*    */   {
/* 16 */     super(id, material);
/*    */   }
/*    */   
/*    */   public ItemBroadsword(int id, EnumToolMaterial material, float dam, int uses) {
/* 20 */     this(id, material);
/*    */   }
/*    */   
/*    */   public float getDamageModifier()
/*    */   {
/* 25 */     return 0.9F;
/*    */   }
/*    */   
/*    */   public boolean canBlock() {
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public float getDurability()
/*    */   {
/* 34 */     return 1.1F;
/*    */   }
/*    */   
/*    */   public float blockDamage(EntityLivingBase entity, float damage, DamageSource source)
/*    */   {
/* 39 */     if (!source.func_76363_c()) {
/* 40 */       if ((entity instanceof EntityPlayer)) {
/* 41 */         if (((EntityPlayer)entity).func_70632_aY()) {
/* 42 */           damage *= 0.5F;
/*    */         } else {
/* 44 */           damage *= 0.75F;
/*    */         }
/*    */       } else {
/* 47 */         damage *= 0.75F;
/*    */       }
/*    */     }
/* 50 */     return damage;
/*    */   }
/*    */   
/*    */   public int getHandsUsed()
/*    */   {
/* 55 */     return 1;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/weapon/ItemBroadsword.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */