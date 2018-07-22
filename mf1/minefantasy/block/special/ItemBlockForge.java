/*    */ package minefantasy.block.special;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
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
/*    */ public class ItemBlockForge
/*    */   extends ItemBlock
/*    */ {
/*    */   public ItemBlockForge(int id)
/*    */   {
/* 24 */     super(id);
/* 25 */     func_77656_e(0);
/* 26 */     func_77627_a(true);
/* 27 */     func_77637_a(ItemListMF.tabSmellting);
/*    */   }
/*    */   
/*    */   public void func_77633_a(int id, CreativeTabs tabs, List list)
/*    */   {
/* 32 */     for (int n = 0; n < 3; n++) {
/* 33 */       list.add(new ItemStack(id, 1, n));
/*    */     }
/*    */   }
/*    */   
/*    */   public int func_77647_b(int damage)
/*    */   {
/* 39 */     return damage * 2;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public EnumRarity func_77613_e(ItemStack item)
/*    */   {
/* 45 */     if (item.func_77960_j() == 2) {
/* 46 */       return EnumRarity.rare;
/*    */     }
/* 48 */     return super.func_77613_e(item);
/*    */   }
/*    */   
/*    */   public String func_77628_j(ItemStack itemstack)
/*    */   {
/* 53 */     if (itemstack.func_77960_j() == 2) {
/* 54 */       return StatCollector.func_74838_a("tile.obsidian.name") + " " + StatCollector.func_74838_a("block.forge");
/*    */     }
/* 56 */     return StatCollector.func_74838_a("block.forge");
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/ItemBlockForge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */