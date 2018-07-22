/*    */ package minefantasy.block;
/*    */ 
/*    */ import minefantasy.item.ItemListMF;
/*    */ import net.minecraft.block.BlockHalfSlab;
/*    */ import net.minecraft.item.EnumRarity;
/*    */ import net.minecraft.item.ItemSlab;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemWoodSlabMF
/*    */   extends ItemSlab
/*    */ {
/*    */   public ItemWoodSlabMF(int id, BlockHalfSlab half, BlockHalfSlab full, boolean isFull)
/*    */   {
/* 25 */     super(id, half, full, isFull);
/* 26 */     func_77637_a(ItemListMF.tabDeco);
/*    */   }
/*    */   
/*    */   public String func_77628_j(ItemStack itemstack)
/*    */   {
/* 31 */     int i = itemstack.func_77960_j();
/* 32 */     switch (i) {
/*    */     case 0: 
/* 34 */       return StatCollector.func_74838_a("tile.ironbark.half");
/*    */     case 1: 
/* 36 */       return StatCollector.func_74838_a("tile.ebony.half");
/*    */     case 2: 
/* 38 */       return StatCollector.func_74838_a("tile.rePlanks.half");
/*    */     case 3: 
/* 40 */       return StatCollector.func_74838_a("tile.hayRoof.half");
/*    */     }
/* 42 */     return "Wood Slab";
/*    */   }
/*    */   
/*    */   public EnumRarity func_77613_e(ItemStack item)
/*    */   {
/* 47 */     if (item.func_77960_j() == 1) {
/* 48 */       return EnumRarity.uncommon;
/*    */     }
/* 50 */     return EnumRarity.common;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/ItemWoodSlabMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */