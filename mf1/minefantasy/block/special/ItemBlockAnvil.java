/*    */ package minefantasy.block.special;
/*    */ 
/*    */ import java.util.List;
/*    */ import minefantasy.item.ItemListMF;
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
/*    */ 
/*    */ 
/*    */ public class ItemBlockAnvil
/*    */   extends ItemBlock
/*    */ {
/*    */   public ItemBlockAnvil(int id)
/*    */   {
/* 23 */     super(id);
/* 24 */     func_77656_e(0);
/* 25 */     func_77627_a(true);
/* 26 */     func_77637_a(ItemListMF.tabSmith);
/*    */   }
/*    */   
/*    */   public void func_77633_a(int id, CreativeTabs tabs, List list)
/*    */   {
/* 31 */     for (int n = 0; n < 9; n++) {
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
/* 44 */     String tier = "";
/* 45 */     String size = "";
/*    */     
/* 47 */     int t = minefantasy.client.tile.TileEntityAnvil.anvils[i][1];
/* 48 */     int s = minefantasy.client.tile.TileEntityAnvil.anvils[i][0];
/*    */     
/* 50 */     switch (t) {
/*    */     case 0: 
/* 52 */       tier = StatCollector.func_74838_a("tier.stone");
/* 53 */       break;
/*    */     
/*    */     case 1: 
/* 56 */       tier = StatCollector.func_74838_a("tier.bronze");
/* 57 */       break;
/*    */     
/*    */     case 2: 
/* 60 */       tier = StatCollector.func_74838_a("tier.iron");
/* 61 */       break;
/*    */     
/*    */     case 3: 
/* 64 */       tier = StatCollector.func_74838_a("tier.steel");
/* 65 */       break;
/*    */     
/*    */     case 4: 
/* 68 */       tier = StatCollector.func_74838_a("tier.iron.deep");
/*    */     }
/*    */     
/*    */     
/*    */ 
/* 73 */     if ((s == 0) && (t >= 0)) {
/* 74 */       size = StatCollector.func_74838_a("size.small") + " ";
/*    */     }
/*    */     
/* 77 */     return size + tier + " " + StatCollector.func_74838_a("tile.anvil.name");
/*    */   }
/*    */   
/*    */   public EnumRarity func_77613_e(ItemStack item)
/*    */   {
/* 82 */     if (item.func_77960_j() >= 5) {
/* 83 */       return EnumRarity.uncommon;
/*    */     }
/* 85 */     return EnumRarity.common;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/ItemBlockAnvil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */