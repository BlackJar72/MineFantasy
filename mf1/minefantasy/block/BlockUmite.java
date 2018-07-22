/*    */ package minefantasy.block;
/*    */ 
/*    */ import java.util.Random;
/*    */ import minefantasy.item.ItemListMF;
/*    */ import minefantasy.system.MFResource;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockUmite
/*    */   extends BlockMedieval
/*    */ {
/*    */   public BlockUmite(int i, int n, Material m)
/*    */   {
/* 18 */     super(i, m);
/*    */     
/* 20 */     func_71907_b(true);
/* 21 */     func_71896_v();
/* 22 */     func_71849_a(ItemListMF.tabDeco);
/*    */   }
/*    */   
/*    */   public void func_71862_a(World world, int x, int y, int z, Random rand)
/*    */   {
/* 27 */     if (rand.nextInt(20) == 0) {
/* 28 */       world.func_72980_b(x + 0.5D, y + 0.5D, z + 0.5D, MFResource.sound("Ignotumite"), 2.5F, rand.nextFloat() * 0.4F + 0.5F, true);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/BlockUmite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */