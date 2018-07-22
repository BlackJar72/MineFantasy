/*    */ package minefantasy.block.special;
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
/*    */ public class ItemBlockOven
/*    */   extends ItemBlock
/*    */ {
/*    */   public ItemBlockOven(int id)
/*    */   {
/* 22 */     super(id);
/* 23 */     func_77656_e(0);
/* 24 */     func_77627_a(true);
/* 25 */     func_77637_a(ItemListMF.tabSmellting);
/*    */   }
/*    */   
/*    */   public void func_77633_a(int id, CreativeTabs tabs, List list)
/*    */   {
/* 30 */     for (int n = 0; n < 4; n++) {
/* 31 */       list.add(new ItemStack(id, 1, n * 2));
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
/* 42 */     int t = getType(itemstack.func_77960_j());
/* 43 */     String tier = "";
/*    */     
/* 45 */     if (t == 0) {
/* 46 */       tier = StatCollector.func_74838_a("tier.bronze");
/*    */     }
/* 48 */     if (t == 1) {
/* 49 */       tier = StatCollector.func_74838_a("tier.iron");
/*    */     }
/* 51 */     if (t == 2) {
/* 52 */       tier = StatCollector.func_74838_a("tier.steel");
/*    */     }
/* 54 */     if (t == 3) {
/* 55 */       tier = StatCollector.func_74838_a("tier.iron.deep");
/*    */     }
/*    */     
/* 58 */     return tier + " " + StatCollector.func_74838_a("tile.oven.name");
/*    */   }
/*    */   
/*    */   public int getType(int meta) {
/* 62 */     return (int)Math.floor(meta / 2);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/ItemBlockOven.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */