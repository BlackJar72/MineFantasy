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
/*    */ public class ItemBlockDogbowl
/*    */   extends ItemBlock
/*    */ {
/*    */   public ItemBlockDogbowl(int id)
/*    */   {
/* 22 */     super(id);
/* 23 */     func_77656_e(0);
/* 24 */     func_77627_a(true);
/* 25 */     func_77637_a(ItemListMF.tabPets);
/*    */   }
/*    */   
/*    */   public void func_77633_a(int id, CreativeTabs tabs, List list)
/*    */   {
/* 30 */     for (int n = 0; n < 3; n++) {
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
/* 43 */     String tier = null;
/* 44 */     switch (i) {
/*    */     case 0: 
/* 46 */       tier = StatCollector.func_74838_a("tier.wood") + " ";
/* 47 */       break;
/*    */     
/*    */     case 1: 
/* 50 */       tier = StatCollector.func_74838_a("tier.iron") + " ";
/* 51 */       break;
/*    */     
/*    */     case 2: 
/* 54 */       tier = StatCollector.func_74838_a("tier.steel") + " ";
/*    */     }
/*    */     
/*    */     
/* 58 */     return tier + StatCollector.func_74838_a("block.dogbowl");
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/ItemBlockDogbowl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */