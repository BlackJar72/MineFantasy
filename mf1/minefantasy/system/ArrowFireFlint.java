/*    */ package minefantasy.system;
/*    */ 
/*    */ import minefantasy.api.arrow.IArrowHandler;
/*    */ import minefantasy.api.arrow.ISpecialBow;
/*    */ import net.minecraft.enchantment.Enchantment;
/*    */ import net.minecraft.enchantment.EnchantmentHelper;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.projectile.EntityArrow;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ArrowFireFlint
/*    */   implements IArrowHandler
/*    */ {
/*    */   public boolean onFireArrow(World world, ItemStack arrow, ItemStack bow, EntityPlayer user, float charge, boolean infinite)
/*    */   {
/* 20 */     if (arrow.field_77993_c != Item.field_77704_l.field_77779_bT) {
/* 21 */       return false;
/*    */     }
/* 23 */     EntityArrow entArrow = new EntityArrow(world, user, charge * 2.0F);
/*    */     
/* 25 */     int var9 = EnchantmentHelper.func_77506_a(Enchantment.field_77345_t.field_77352_x, bow);
/*    */     
/* 27 */     if (var9 > 0) {
/* 28 */       entArrow.func_70239_b(entArrow.func_70242_d() + var9 * 0.5D + 0.5D);
/*    */     }
/*    */     
/* 31 */     int var10 = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, bow);
/*    */     
/* 33 */     if (var10 > 0) {
/* 34 */       entArrow.func_70240_a(var10);
/*    */     }
/*    */     
/* 37 */     if (EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, bow) > 0) {
/* 38 */       entArrow.func_70015_d(100);
/*    */     }
/*    */     
/* 41 */     if (infinite) {
/* 42 */       entArrow.field_70251_a = 2;
/*    */     }
/*    */     
/* 45 */     if ((bow != null) && (bow.func_77973_b() != null) && ((bow.func_77973_b() instanceof ISpecialBow))) {
/* 46 */       entArrow = (EntityArrow)((ISpecialBow)bow.func_77973_b()).modifyArrow(entArrow);
/*    */     }
/* 48 */     if (!world.field_72995_K) {
/* 49 */       world.func_72838_d(entArrow);
/*    */     }
/*    */     
/* 52 */     return true;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/ArrowFireFlint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */