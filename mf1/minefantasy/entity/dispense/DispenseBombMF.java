/*    */ package minefantasy.entity.dispense;
/*    */ 
/*    */ import minefantasy.entity.EntityBombThrown;
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
/*    */ 
/*    */ public class DispenseBombMF
/*    */   extends BehaviorProjectileDispense
/*    */ {
/*    */   public ItemStack func_82487_b(IBlockSource source, ItemStack stack)
/*    */   {
/* 20 */     float y = 1.1F;
/* 21 */     World var3 = source.func_82618_k();
/* 22 */     IPosition var4 = BlockDispenser.func_82525_a(source);
/* 23 */     EnumFacing var5 = BlockDispenser.func_100009_j_(source.func_82620_h());
/*    */     
/* 25 */     IProjectile var6 = getProjectileEntity(var3, var4, stack.func_77960_j());
/* 26 */     if (var6 != null) {
/* 27 */       var6.func_70186_c(var5.func_82601_c(), 0.10000000149011612D * y, var5.func_96559_d(), func_82500_b(), func_82498_a());
/* 28 */       var3.func_72838_d((Entity)var6);
/* 29 */       stack.func_77979_a(1);
/*    */     }
/* 31 */     return stack;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected IProjectile getProjectileEntity(World world, IPosition pos, int type)
/*    */   {
/* 38 */     EntityBombThrown bomb = new EntityBombThrown(world, pos.func_82615_a(), pos.func_82617_b(), pos.func_82616_c(), 20).setID(type);
/* 39 */     return bomb;
/*    */   }
/*    */   
/*    */   protected IProjectile func_82499_a(World var1, IPosition var2)
/*    */   {
/* 44 */     return getProjectileEntity(var1, var2, 0);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/dispense/DispenseBombMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */