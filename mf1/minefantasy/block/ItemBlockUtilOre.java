/*    */ package minefantasy.block;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import minefantasy.MineFantasyBase;
/*    */ import minefantasy.item.ItemListMF;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.Icon;
/*    */ import net.minecraft.util.StatCollector;
/*    */ 
/*    */ public class ItemBlockUtilOre
/*    */   extends ItemBlock
/*    */ {
/*    */   public ItemBlockUtilOre(int id)
/*    */   {
/* 20 */     super(id);
/* 21 */     func_77656_e(0);
/* 22 */     func_77627_a(true);
/* 23 */     func_77637_a(ItemListMF.tabDeco);
/*    */   }
/*    */   
/*    */   public void func_77633_a(int id, CreativeTabs tabs, List list)
/*    */   {
/* 28 */     for (int n = 0; n < 3; n++) {
/* 29 */       list.add(new ItemStack(id, 1, n));
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int func_77647_b(int meta)
/*    */   {
/* 37 */     return meta;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   @SideOnly(Side.CLIENT)
/*    */   public Icon func_77617_a(int meta)
/*    */   {
/* 45 */     return MineFantasyBase.MFBlockOreUtil.func_71858_a(0, meta);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String func_77667_c(ItemStack item)
/*    */   {
/* 55 */     int type = item.func_77960_j();
/*    */     
/* 57 */     if (type == 1) {
/* 58 */       return StatCollector.func_74838_a("tile.oreUtil.nitre");
/*    */     }
/* 60 */     if (type == 2) {
/* 61 */       return StatCollector.func_74838_a("tile.oreUtil.sulfur");
/*    */     }
/*    */     
/* 64 */     return StatCollector.func_74838_a("tile.oreSilver");
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/ItemBlockUtilOre.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */