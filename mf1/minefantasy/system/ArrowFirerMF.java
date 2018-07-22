/*    */ package minefantasy.system;
/*    */ 
/*    */ import minefantasy.api.arrow.IArrowHandler;
/*    */ import minefantasy.api.arrow.ISpecialBow;
/*    */ import minefantasy.entity.EntityArrowMF;
/*    */ import net.minecraft.enchantment.Enchantment;
/*    */ import net.minecraft.enchantment.EnchantmentHelper;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ArrowFirerMF
/*    */   implements IArrowHandler
/*    */ {
/*    */   public boolean onFireArrow(World world, ItemStack arrow, ItemStack bow, EntityPlayer user, float charge, boolean infinite)
/*    */   {
/* 19 */     EntityArrowMF entArrow = new EntityArrowMF(world, user, charge * 2.0F, arrow.func_77960_j());
/*    */     
/* 21 */     int var9 = EnchantmentHelper.func_77506_a(Enchantment.field_77345_t.field_77352_x, bow);
/*    */     
/* 23 */     if (var9 > 0) {
/* 24 */       entArrow.func_70239_b(entArrow.func_70242_d() + var9 * 0.5D + 0.5D);
/*    */     }
/*    */     
/* 27 */     int var10 = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, bow);
/*    */     
/* 29 */     if (var10 > 0) {
/* 30 */       entArrow.func_70240_a(var10);
/*    */     }
/*    */     
/* 33 */     if (EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, bow) > 0) {
/* 34 */       entArrow.func_70015_d(100);
/*    */     }
/*    */     
/* 37 */     if (infinite) {
/* 38 */       entArrow.field_70251_a = 2;
/*    */     }
/*    */     
/* 41 */     if ((bow != null) && (bow.func_77973_b() != null) && ((bow.func_77973_b() instanceof ISpecialBow))) {
/* 42 */       entArrow = (EntityArrowMF)((ISpecialBow)bow.func_77973_b()).modifyArrow(entArrow);
/*    */     }
/* 44 */     if (!world.field_72995_K) {
/* 45 */       world.func_72838_d(entArrow);
/*    */     }
/*    */     
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/ArrowFirerMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */