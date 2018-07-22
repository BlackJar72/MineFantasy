/*    */ package minefantasy.system;
/*    */ 
/*    */ import minefantasy.entity.EntityArrowMF;
/*    */ import minefantasy.item.ItemListMF;
/*    */ import mods.battlegear2.api.quiver.IArrowFireHandler;
/*    */ import net.minecraft.enchantment.Enchantment;
/*    */ import net.minecraft.enchantment.EnchantmentHelper;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.PlayerCapabilities;
/*    */ import net.minecraft.entity.projectile.EntityArrow;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class QuiverArrowsMF implements IArrowFireHandler
/*    */ {
/*    */   public boolean canFireArrow(ItemStack arrow, World world, EntityPlayer player, float charge)
/*    */   {
/* 19 */     if (arrow == null) {
/* 20 */       return false;
/*    */     }
/* 22 */     return arrow.field_77993_c == ItemListMF.arrowMF.field_77779_bT;
/*    */   }
/*    */   
/*    */   public EntityArrow getFiredArrow(ItemStack arrow, World world, EntityPlayer player, float charge)
/*    */   {
/* 27 */     EntityArrow entArrow = new EntityArrowMF(world, player, charge, arrow.func_77960_j());
/*    */     
/* 29 */     boolean infinite = false;
/* 30 */     ItemStack held = player.func_70694_bm();
/* 31 */     if (held != null) {
/* 32 */       infinite = EnchantmentHelper.func_77506_a(Enchantment.field_77342_w.field_77352_x, held) > 0;
/*    */     }
/* 34 */     if (player.field_71075_bZ.field_75098_d) {
/* 35 */       entArrow.field_70251_a = 0;
/*    */     }
/* 37 */     if (infinite) {
/* 38 */       entArrow.field_70251_a = 2;
/*    */     }
/*    */     
/* 41 */     return entArrow;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/QuiverArrowsMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */