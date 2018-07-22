/*    */ package minefantasy.block;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import minefantasy.MineFantasyBase;
/*    */ import minefantasy.item.ItemListMF;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.StatCollector;
/*    */ import net.minecraft.world.ColorizerFoliage;
/*    */ 
/*    */ public class ItemBlockLeavesMF extends ItemBlock
/*    */ {
/*    */   public ItemBlockLeavesMF(int id)
/*    */   {
/* 17 */     super(id);
/* 18 */     func_77656_e(0);
/* 19 */     func_77627_a(true);
/* 20 */     func_77637_a(ItemListMF.tabDeco);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int func_77647_b(int meta)
/*    */   {
/* 27 */     return meta | 0x4;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   @SideOnly(Side.CLIENT)
/*    */   public net.minecraft.util.Icon func_77617_a(int meta)
/*    */   {
/* 35 */     return MineFantasyBase.MFBlockLeaves.func_71858_a(0, meta);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_82790_a(ItemStack item, int id) {
/* 40 */     int j = item.func_77960_j();
/* 41 */     return (j & 0x2) == 2 ? ColorizerFoliage.func_77469_b() : (j & 0x1) == 1 ? ColorizerFoliage.func_77466_a() : ColorizerFoliage.func_77468_c();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String func_77667_c(ItemStack item)
/*    */   {
/* 50 */     int i = item.func_77960_j();
/*    */     
/* 52 */     if ((i < 0) || (i >= BlockLeavesMF.LEAF_TYPES.length)) {
/* 53 */       i = 0;
/*    */     }
/*    */     
/* 56 */     return StatCollector.func_74838_a("tile.leaves." + BlockLeavesMF.LEAF_TYPES[i]);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/ItemBlockLeavesMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */