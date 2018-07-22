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
/*    */ public class ItemBlockChimney
/*    */   extends ItemBlock
/*    */ {
/*    */   public ItemBlockChimney(int id)
/*    */   {
/* 21 */     super(id);
/* 22 */     func_77656_e(0);
/* 23 */     func_77627_a(true);
/* 24 */     func_77637_a(ItemListMF.tabDeco);
/*    */   }
/*    */   
/*    */   public void func_77633_a(int id, CreativeTabs tabs, List list)
/*    */   {
/* 29 */     for (int n = 0; n < 6; n++) {
/* 30 */       list.add(new ItemStack(id, 1, n));
/*    */     }
/*    */   }
/*    */   
/*    */   public int func_77647_b(int damage)
/*    */   {
/* 36 */     return damage;
/*    */   }
/*    */   
/*    */   public String func_77628_j(ItemStack itemstack)
/*    */   {
/* 41 */     int t = itemstack.func_77960_j();
/*    */     
/* 43 */     String tier = "";
/* 44 */     if (t == 0) {
/* 45 */       tier = StatCollector.func_74838_a("tier.iron");
/*    */     }
/* 47 */     if (t == 1) {
/* 48 */       tier = StatCollector.func_74838_a("tier.steel");
/*    */     }
/* 50 */     if (t == 2) {
/* 51 */       tier = StatCollector.func_74838_a("tier.stone");
/*    */     }
/* 53 */     if (t == 3) {
/* 54 */       tier = StatCollector.func_74838_a("tier.brick");
/*    */     }
/* 56 */     if (t == 4) {
/* 57 */       tier = StatCollector.func_74838_a("tier.bronze");
/*    */     }
/* 59 */     if (t == 5) {
/* 60 */       tier = StatCollector.func_74838_a("tier.iron.deep");
/*    */     }
/* 62 */     return tier + " " + StatCollector.func_74838_a("tile.chimney");
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/ItemBlockChimney.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */