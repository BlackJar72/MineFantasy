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
/*    */ public class ItemBlockSlateSlab
/*    */   extends ItemSlab
/*    */ {
/*    */   public ItemBlockSlateSlab(int id, BlockHalfSlab half, BlockHalfSlab full, boolean isFull)
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
/* 33 */       return StatCollector.func_74838_a("tile.slate.half");
/*    */     case 1: 
/* 35 */       return StatCollector.func_74838_a("tile.slate.tile.half");
/*    */     case 2: 
/* 37 */       return StatCollector.func_74838_a("tile.slate.tile.d.half");
/*    */     case 3: 
/* 39 */       return StatCollector.func_74838_a("tile.slate.brick.half");
/*    */     }
/* 41 */     return StatCollector.func_74838_a("tile.slate.half");
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/ItemBlockSlateSlab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */