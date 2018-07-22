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
/*    */ public class ItemBlockTripHammer
/*    */   extends ItemBlock
/*    */ {
/*    */   public ItemBlockTripHammer(int id)
/*    */   {
/* 21 */     super(id);
/* 22 */     func_77656_e(0);
/* 23 */     func_77627_a(true);
/* 24 */     func_77637_a(ItemListMF.tabSmith);
/*    */   }
/*    */   
/*    */   public void func_77633_a(int id, CreativeTabs tabs, List list)
/*    */   {
/* 29 */     for (int n = 0; n < 2; n++) {
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
/* 41 */     int i = itemstack.func_77960_j();
/* 42 */     String type = "";
/*    */     
/* 44 */     if (i == 1) {
/* 45 */       type = " " + StatCollector.func_74838_a("block.crank");
/*    */     }
/* 47 */     return StatCollector.func_74838_a("block.triphammer");
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/ItemBlockTripHammer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */