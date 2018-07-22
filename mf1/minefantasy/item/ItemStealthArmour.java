/*    */ package minefantasy.item;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import minefantasy.api.tactic.IStealthArmour;
/*    */ import net.minecraft.client.model.ModelBiped;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.item.EnumArmorMaterial;
/*    */ import net.minecraft.item.EnumRarity;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.potion.Potion;
/*    */ 
/*    */ public class ItemStealthArmour
/*    */   extends ItemArmourMFOld
/*    */   implements IStealthArmour
/*    */ {
/*    */   public ItemStealthArmour(int i, EnumArmorMaterial mat, int render, int type, String s)
/*    */   {
/* 19 */     super(i, ArmourDesign.SOLID, mat, render, type, s);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot)
/*    */   {
/* 25 */     if (canTurnInvisible()) {
/* 26 */       ModelBiped model = new ModelBiped();
/*    */       
/* 28 */       if (entityLiving.func_70660_b(Potion.field_76441_p) != null) {
/* 29 */         model.field_78115_e.field_78807_k = true;
/* 30 */         model.field_78116_c.field_78807_k = true;
/* 31 */         model.field_78114_d.field_78807_k = true;
/* 32 */         model.field_78112_f.field_78807_k = true;
/* 33 */         model.field_78113_g.field_78807_k = true;
/* 34 */         model.field_78123_h.field_78807_k = true;
/* 35 */         model.field_78124_i.field_78807_k = true;
/* 36 */         model.field_78122_k.field_78807_k = true;
/*    */         
/* 38 */         return model;
/*    */       }
/*    */     }
/* 41 */     return null;
/*    */   }
/*    */   
/*    */   public EnumRarity func_77613_e(ItemStack item)
/*    */   {
/* 46 */     return EnumRarity.uncommon;
/*    */   }
/*    */   
/*    */   public float darknessAmplifier()
/*    */   {
/* 51 */     return 1.15F;
/*    */   }
/*    */   
/*    */   public float noiseReduction()
/*    */   {
/* 56 */     return 1.0F;
/*    */   }
/*    */   
/*    */   public boolean quietRun()
/*    */   {
/* 61 */     return true;
/*    */   }
/*    */   
/*    */   public boolean canTurnInvisible()
/*    */   {
/* 66 */     return true;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/ItemStealthArmour.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */