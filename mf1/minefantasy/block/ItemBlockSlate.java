/*    */ package minefantasy.block;
/*    */ 
/*    */ import java.util.List;
/*    */ import minefantasy.item.ItemListMF;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.StatCollector;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemBlockSlate
/*    */   extends ItemBlock
/*    */ {
/*    */   public ItemBlockSlate(int id)
/*    */   {
/* 22 */     super(id);
/* 23 */     func_77656_e(0);
/* 24 */     func_77627_a(true);
/* 25 */     func_77637_a(ItemListMF.tabDeco);
/*    */   }
/*    */   
/*    */   public void func_77633_a(int id, CreativeTabs tabs, List list)
/*    */   {
/* 30 */     for (int n = 0; n < 4; n++) {
/* 31 */       list.add(new ItemStack(id, 1, n));
/*    */     }
/*    */   }
/*    */   
/*    */   public int func_77647_b(int damage)
/*    */   {
/* 37 */     return damage;
/*    */   }
/*    */   
/*    */   public String func_77628_j(ItemStack itemstack)
/*    */   {
/* 42 */     int i = itemstack.func_77960_j();
/* 43 */     switch (i) {
/*    */     case 0: 
/* 45 */       return StatCollector.func_74838_a("tile.slate");
/*    */     case 1: 
/* 47 */       return StatCollector.func_74838_a("tile.slate.tile");
/*    */     case 2: 
/* 49 */       return StatCollector.func_74838_a("tile.slate.tile.d");
/*    */     case 3: 
/* 51 */       return StatCollector.func_74838_a("tile.slate.brick");
/*    */     }
/* 53 */     return StatCollector.func_74838_a("tile.slate");
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/ItemBlockSlate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */