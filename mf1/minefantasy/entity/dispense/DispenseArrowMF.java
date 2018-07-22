/*    */ package minefantasy.entity.dispense;
/*    */ 
/*    */ import minefantasy.entity.EntityArrowMF;
/*    */ import net.minecraft.block.BlockDispenser;
/*    */ import net.minecraft.dispenser.BehaviorProjectileDispense;
/*    */ import net.minecraft.dispenser.IBlockSource;
/*    */ import net.minecraft.dispenser.IPosition;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.IProjectile;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class DispenseArrowMF extends BehaviorProjectileDispense
/*    */ {
/*    */   public ItemStack func_82487_b(IBlockSource source, ItemStack stack)
/*    */   {
/* 18 */     float y = 1.1F;
/* 19 */     World var3 = source.func_82618_k();
/* 20 */     IPosition var4 = BlockDispenser.func_82525_a(source);
/* 21 */     EnumFacing enumfacing = BlockDispenser.func_100009_j_(source.func_82620_h());
/*    */     
/* 23 */     IProjectile iprojectile = getProjectileEntity(var3, var4, stack.func_77960_j());
/* 24 */     if (iprojectile != null) {
/* 25 */       iprojectile.func_70186_c(enumfacing.func_82601_c(), enumfacing.func_96559_d() + 0.1F, enumfacing.func_82599_e(), func_82500_b(), func_82498_a());
/* 26 */       var3.func_72838_d((Entity)iprojectile);
/* 27 */       stack.func_77979_a(1);
/*    */     }
/* 29 */     return stack;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected IProjectile getProjectileEntity(World world, IPosition pos, int meta)
/*    */   {
/* 36 */     EntityArrowMF arrow = new EntityArrowMF(world, pos.func_82615_a(), pos.func_82617_b(), pos.func_82616_c(), meta);
/*    */     
/* 38 */     arrow.field_70251_a = 1;
/* 39 */     return arrow;
/*    */   }
/*    */   
/*    */   protected IProjectile func_82499_a(World var1, IPosition var2)
/*    */   {
/* 44 */     return getProjectileEntity(var1, var2, 0);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/dispense/DispenseArrowMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */