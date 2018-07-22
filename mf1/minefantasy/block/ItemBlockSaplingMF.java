/*    */ package minefantasy.block;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import minefantasy.item.ItemListMF;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.Icon;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemBlockSaplingMF
/*    */   extends ItemBlockTreeMF
/*    */ {
/*    */   public ItemBlockSaplingMF(int id)
/*    */   {
/* 24 */     super(id);
/* 25 */     func_77656_e(0);
/* 26 */     func_77627_a(true);
/* 27 */     func_77637_a(ItemListMF.tabDeco);
/*    */   }
/*    */   
/*    */   public void func_77633_a(int id, CreativeTabs tabs, List list)
/*    */   {
/* 32 */     for (int n = 0; n < 2; n++) {
/* 33 */       list.add(new ItemStack(id, 1, n));
/*    */     }
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public Icon func_77617_a(int id)
/*    */   {
/* 40 */     return ((BlockSaplingMF)(BlockSaplingMF)minefantasy.MineFantasyBase.MFBlockSapling).saplingIcon[id];
/*    */   }
/*    */   
/*    */   public int func_77647_b(int damage)
/*    */   {
/* 45 */     return damage;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/ItemBlockSaplingMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */