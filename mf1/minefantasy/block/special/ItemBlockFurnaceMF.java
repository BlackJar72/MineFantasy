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
/*    */ public class ItemBlockFurnaceMF
/*    */   extends ItemBlock
/*    */ {
/*    */   public ItemBlockFurnaceMF(int id)
/*    */   {
/* 22 */     super(id);
/* 23 */     func_77656_e(0);
/* 24 */     func_77627_a(true);
/* 25 */     func_77637_a(ItemListMF.tabSmellting);
/*    */   }
/*    */   
/*    */   public void func_77633_a(int id, CreativeTabs tabs, List list)
/*    */   {
/* 30 */     for (int n = 0; n < 5; n++) {
/* 31 */       list.add(new ItemStack(id, 1, n));
/*    */     }
/*    */   }
/*    */   
/*    */   public int func_77647_b(int damage)
/*    */   {
/* 37 */     return damage * 2;
/*    */   }
/*    */   
/*    */   public String func_77628_j(ItemStack itemstack)
/*    */   {
/* 42 */     int t = itemstack.func_77960_j();
/* 43 */     String tier = "";
/*    */     
/* 45 */     if (t == 0) {
/* 46 */       return StatCollector.func_74838_a("tile.furnace.name") + " " + StatCollector.func_74838_a("block.furnace.heater");
/*    */     }
/*    */     
/* 49 */     if (t == 1) {
/* 50 */       tier = StatCollector.func_74838_a("tier.bronze");
/*    */     }
/* 52 */     if (t == 2) {
/* 53 */       tier = StatCollector.func_74838_a("tier.iron");
/*    */     }
/* 55 */     if (t == 3) {
/* 56 */       tier = StatCollector.func_74838_a("tier.steel");
/*    */     }
/* 58 */     if (t == 4) {
/* 59 */       tier = StatCollector.func_74838_a("tier.iron.deep");
/*    */     }
/*    */     
/* 62 */     return tier + " " + StatCollector.func_74838_a("tile.furnace.name");
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/ItemBlockFurnaceMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */