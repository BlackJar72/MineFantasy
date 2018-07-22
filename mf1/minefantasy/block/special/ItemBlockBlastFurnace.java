/*    */ package minefantasy.block.special;
/*    */ 
/*    */ import java.util.List;
/*    */ import minefantasy.item.ItemListMF;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.StatCollector;
/*    */ 
/*    */ public class ItemBlockBlastFurnace extends ItemBlock
/*    */ {
/*    */   public ItemBlockBlastFurnace(int id)
/*    */   {
/* 14 */     super(id);
/* 15 */     func_77656_e(0);
/* 16 */     func_77627_a(true);
/* 17 */     func_77637_a(ItemListMF.tabSmellting);
/*    */   }
/*    */   
/*    */   public void func_77633_a(int id, CreativeTabs tabs, List list)
/*    */   {
/* 22 */     for (int n = 0; n < 4; n++) {
/* 23 */       list.add(new ItemStack(id, 1, n));
/*    */     }
/*    */   }
/*    */   
/*    */   public int func_77647_b(int damage)
/*    */   {
/* 29 */     return damage;
/*    */   }
/*    */   
/*    */   public String func_77628_j(ItemStack itemstack)
/*    */   {
/* 34 */     int i = itemstack.func_77960_j();
/* 35 */     switch (i) {
/*    */     case 1: 
/* 37 */       return StatCollector.func_74838_a("block.blastfurnace.input");
/*    */     case 2: 
/* 39 */       return StatCollector.func_74838_a("block.blastfurnace.heater");
/*    */     case 3: 
/* 41 */       return StatCollector.func_74838_a("block.blastfurnace.output");
/*    */     }
/* 43 */     return StatCollector.func_74838_a("block.blastfurnace.shaft");
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/ItemBlockBlastFurnace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */