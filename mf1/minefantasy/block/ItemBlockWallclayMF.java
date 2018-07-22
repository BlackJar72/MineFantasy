/*    */ package minefantasy.block;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.StatCollector;
/*    */ 
/*    */ public class ItemBlockWallclayMF extends ItemBlock
/*    */ {
/*    */   public ItemBlockWallclayMF(int id)
/*    */   {
/* 13 */     super(id);
/* 14 */     func_77656_e(0);
/* 15 */     func_77627_a(true);
/* 16 */     func_77637_a(minefantasy.item.ItemListMF.tabDeco);
/*    */   }
/*    */   
/*    */   public void func_77633_a(int id, CreativeTabs tabs, List list)
/*    */   {
/* 21 */     for (int n = 0; n < 4; n++) {
/* 22 */       list.add(new ItemStack(id, 1, n));
/*    */     }
/*    */   }
/*    */   
/*    */   public int func_77647_b(int damage)
/*    */   {
/* 28 */     return damage;
/*    */   }
/*    */   
/*    */   public String func_77628_j(ItemStack itemstack)
/*    */   {
/* 33 */     int i = itemstack.func_77960_j();
/* 34 */     switch (i) {
/*    */     case 1: 
/* 36 */       return StatCollector.func_74838_a("tile.clayWall.cross");
/*    */     case 2: 
/* 38 */       return StatCollector.func_74838_a("tile.clayWall.diagonal1");
/*    */     
/*    */     case 3: 
/* 41 */       return StatCollector.func_74838_a("tile.clayWall.diagonal2");
/*    */     }
/*    */     
/* 44 */     return StatCollector.func_74838_a("tile.clayWall");
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/ItemBlockWallclayMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */