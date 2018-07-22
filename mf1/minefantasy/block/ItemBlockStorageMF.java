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
/*    */ public class ItemBlockStorageMF
/*    */   extends ItemBlock
/*    */ {
/*    */   public ItemBlockStorageMF(int id)
/*    */   {
/* 21 */     super(id);
/* 22 */     func_77656_e(0);
/* 23 */     func_77627_a(true);
/* 24 */     func_77637_a(ItemListMF.tabDeco);
/*    */   }
/*    */   
/*    */   public void func_77633_a(int id, CreativeTabs tabs, List list)
/*    */   {
/* 29 */     for (int n = 0; n < 9; n++) {
/* 30 */       if (n != 6) {
/* 31 */         list.add(new ItemStack(id, 1, n));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public int func_77647_b(int damage) {
/* 37 */     return damage;
/*    */   }
/*    */   
/*    */   public String func_77628_j(ItemStack itemstack)
/*    */   {
/* 42 */     int t = itemstack.func_77960_j();
/* 43 */     String tier = "";
/*    */     
/* 45 */     if (t == 0) {
/* 46 */       tier = StatCollector.func_74838_a("tier.steel");
/*    */     }
/* 48 */     if (t == 1) {
/* 49 */       tier = StatCollector.func_74838_a("tier.copper");
/*    */     }
/* 51 */     if (t == 2) {
/* 52 */       tier = StatCollector.func_74838_a("tier.tin");
/*    */     }
/* 54 */     if (t == 3) {
/* 55 */       tier = StatCollector.func_74838_a("tier.bronze");
/*    */     }
/* 57 */     if (t == 4) {
/* 58 */       tier = StatCollector.func_74838_a("tier.mithril");
/*    */     }
/* 60 */     if (t == 5) {
/* 61 */       tier = StatCollector.func_74838_a("tier.silver");
/*    */     }
/* 63 */     if (t == 7) {
/* 64 */       tier = StatCollector.func_74838_a("tier.iron.wrought");
/*    */     }
/* 66 */     if (t == 8) {
/* 67 */       tier = StatCollector.func_74838_a("tier.iron.deep");
/*    */     }
/*    */     
/* 70 */     return StatCollector.func_74838_a("block.blockstore") + " " + tier;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/ItemBlockStorageMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */