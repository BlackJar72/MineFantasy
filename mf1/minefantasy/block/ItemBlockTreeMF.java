/*    */ package minefantasy.block;
/*    */ 
/*    */ import java.util.List;
/*    */ import minefantasy.MineFantasyBase;
/*    */ import minefantasy.item.ItemListMF;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.EnumRarity;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.StatCollector;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemBlockTreeMF
/*    */   extends ItemBlock
/*    */ {
/*    */   public ItemBlockTreeMF(int id)
/*    */   {
/* 23 */     super(id);
/* 24 */     func_77656_e(0);
/* 25 */     func_77627_a(true);
/* 26 */     func_77637_a(ItemListMF.tabDeco);
/*    */   }
/*    */   
/*    */   public void func_77633_a(int id, CreativeTabs tabs, List list)
/*    */   {
/* 31 */     for (int n = 0; n < 2; n++) {
/* 32 */       list.add(new ItemStack(id, 1, n));
/*    */     }
/*    */   }
/*    */   
/*    */   public int func_77647_b(int damage)
/*    */   {
/* 38 */     return damage;
/*    */   }
/*    */   
/*    */   public String func_77628_j(ItemStack itemstack)
/*    */   {
/* 43 */     int i = itemstack.func_77960_j();
/* 44 */     int id = itemstack.field_77993_c;
/* 45 */     if (id == MineFantasyBase.MFBlockLog.field_71990_ca) {
/* 46 */       switch (i) {
/*    */       case 0: 
/* 48 */         return StatCollector.func_74838_a("tile.log.ironbark");
/*    */       case 1: 
/* 50 */         return StatCollector.func_74838_a("tile.log.ebony");
/*    */       }
/*    */       
/*    */     }
/* 54 */     if (id == MineFantasyBase.MFBlockPlanks.field_71990_ca) {
/* 55 */       switch (i) {
/*    */       case 0: 
/* 57 */         return StatCollector.func_74838_a("tile.planks.ironbark");
/*    */       case 1: 
/* 59 */         return StatCollector.func_74838_a("tile.planks.ebony");
/*    */       }
/*    */       
/*    */     }
/* 63 */     if (id == MineFantasyBase.MFBlockLeaves.field_71990_ca) {
/* 64 */       switch (i) {
/*    */       case 0: 
/* 66 */         return StatCollector.func_74838_a("tile.leaves.ironbark");
/*    */       case 1: 
/* 68 */         return StatCollector.func_74838_a("tile.leaves.ebony");
/*    */       }
/*    */       
/*    */     }
/* 72 */     if (id == MineFantasyBase.MFBlockSapling.field_71990_ca) {
/* 73 */       switch (i) {
/*    */       case 0: 
/* 75 */         return StatCollector.func_74838_a("tile.sapling.ironbark");
/*    */       case 1: 
/* 77 */         return StatCollector.func_74838_a("tile.sapling.ebony");
/*    */       }
/*    */     }
/* 80 */     return "Unnamed";
/*    */   }
/*    */   
/*    */   public EnumRarity func_77613_e(ItemStack item)
/*    */   {
/* 85 */     int d = item.func_77960_j();
/* 86 */     if (d == 1) {
/* 87 */       return EnumRarity.uncommon;
/*    */     }
/* 89 */     return EnumRarity.common;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/ItemBlockTreeMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */