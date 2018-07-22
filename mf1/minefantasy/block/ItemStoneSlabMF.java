/*    */ package minefantasy.block;
/*    */ 
/*    */ import minefantasy.item.ItemListMF;
/*    */ import net.minecraft.block.BlockHalfSlab;
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
/*    */ public class ItemStoneSlabMF
/*    */   extends ItemSlab
/*    */ {
/*    */   public ItemStoneSlabMF(int id, BlockHalfSlab half, BlockHalfSlab full, boolean isFull)
/*    */   {
/* 24 */     super(id, half, full, isFull);
/* 25 */     func_77637_a(ItemListMF.tabDeco);
/*    */   }
/*    */   
/*    */   public String func_77628_j(ItemStack itemstack)
/*    */   {
/* 30 */     int i = itemstack.func_77960_j();
/* 31 */     switch (i) {
/*    */     case 0: 
/* 33 */       return StatCollector.func_74838_a("tile.cobbBrick.half");
/*    */     case 1: 
/* 35 */       return StatCollector.func_74838_a("tile.granite.half");
/*    */     case 2: 
/* 37 */       return StatCollector.func_74838_a("tile.granite.brick.half");
/*    */     case 3: 
/* 39 */       return StatCollector.func_74838_a("tile.smoothstone.half");
/*    */     case 4: 
/* 41 */       return StatCollector.func_74838_a("tile.mudBrick.half");
/*    */     case 5: 
/* 43 */       return StatCollector.func_74838_a("tile.cobbBrick.half");
/*    */     case 6: 
/* 45 */       return StatCollector.func_74838_a("tile.mudBrick.half");
/*    */     }
/* 47 */     return "Stone Slab";
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/ItemStoneSlabMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */