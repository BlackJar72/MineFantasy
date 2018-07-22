/*    */ package minefantasy.item;
/*    */ 
/*    */ import java.util.List;
/*    */ import minefantasy.api.hound.ItemHoundWeapon;
/*    */ import minefantasy.system.MFResource;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EnumCreatureAttribute;
/*    */ import net.minecraft.item.EnumRarity;
/*    */ import net.minecraft.item.EnumToolMaterial;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemHoundWeaponMF
/*    */   extends ItemHoundWeapon
/*    */ {
/*    */   public String texture;
/*    */   private int strength;
/*    */   
/*    */   public ItemHoundWeaponMF(int id, EnumToolMaterial material, String tex, int str, int dam)
/*    */   {
/* 24 */     super(id, material);
/* 25 */     this.texture = tex;
/* 26 */     this.strength = str;
/* 27 */     func_77637_a(ItemListMF.tabPets);
/* 28 */     this.weaponDamage = dam;
/*    */   }
/*    */   
/*    */   public EnumRarity func_77613_e(ItemStack itemStack)
/*    */   {
/* 33 */     if (this.toolMaterial == ToolMaterialMedieval.IGNOTUMITE) {
/* 34 */       if (itemStack.func_77948_v()) {
/* 35 */         return EnumRarity.epic;
/*    */       }
/* 37 */       return EnumRarity.rare;
/*    */     }
/* 39 */     if (this.toolMaterial == ToolMaterialMedieval.DRAGONFORGE) {
/* 40 */       if (itemStack.func_77948_v()) {
/* 41 */         return EnumRarity.rare;
/*    */       }
/* 43 */       return EnumRarity.uncommon;
/*    */     }
/* 45 */     return super.func_77613_e(itemStack);
/*    */   }
/*    */   
/*    */   public String getTexture()
/*    */   {
/* 50 */     return MFResource.image("/mob/hound_armour/" + this.texture + "_teeth.png");
/*    */   }
/*    */   
/*    */   public int getRequiredStr()
/*    */   {
/* 55 */     return 0;
/*    */   }
/*    */   
/*    */   public boolean hitEntity(ItemStack weapon, EntityLiving target, EntityLiving user)
/*    */   {
/* 60 */     if (this.toolMaterial == ToolMaterialMedieval.DRAGONFORGE) {
/* 61 */       target.func_70015_d(20);
/*    */     }
/* 63 */     if (this.toolMaterial == ToolMaterialMedieval.IGNOTUMITE) {
/* 64 */       user.func_70691_i(2.0F);
/*    */     }
/* 66 */     if ((this.toolMaterial == ToolMaterialMedieval.ORNATE) && (
/* 67 */       (target.func_70668_bt() == EnumCreatureAttribute.UNDEAD) || (target.getClass().getName().endsWith("MoCEntityWarewolf")))) {
/* 68 */       target.func_70015_d(20);
/* 69 */       target.field_70170_p.func_72956_a(target, "random.fizz", 1.0F, 1.0F);
/*    */     }
/*    */     
/*    */ 
/* 73 */     return super.hitEntity(weapon, target, user);
/*    */   }
/*    */   
/*    */   public Item func_77655_b(String name)
/*    */   {
/* 78 */     func_111206_d("minefantasy:Pets/" + name);
/* 79 */     return super.func_77655_b(name);
/*    */   }
/*    */   
/*    */   public float getDamage(Entity tar)
/*    */   {
/* 84 */     float dam = this.weaponDamage;
/*    */     
/* 86 */     if ((tar != null) && ((tar instanceof EntityLiving)) && (this.toolMaterial == ToolMaterialMedieval.ORNATE) && (
/* 87 */       (((EntityLiving)tar).func_70668_bt() == EnumCreatureAttribute.UNDEAD) || (tar.getClass().getName().endsWith("MoCEntityWarewolf")))) {
/* 88 */       if (tar.getClass().getName().endsWith("MoCEntityWarewolf")) {
/* 89 */         dam *= 10.0F;
/*    */       } else {
/* 91 */         dam *= 2.0F;
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 96 */     return dam;
/*    */   }
/*    */   
/*    */   public void func_77633_a(int id, CreativeTabs tabs, List list) {}
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/ItemHoundWeaponMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */