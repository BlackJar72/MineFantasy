/*    */ package minefantasy.block;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import minefantasy.MineFantasyBase;
/*    */ import minefantasy.item.ItemListMF;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockStairs;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IconRegister;
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
/*    */ public class BlockMedievalStairs
/*    */   extends BlockStairs
/*    */ {
/*    */   public Icon field_111038_cB;
/*    */   
/*    */   public BlockMedievalStairs(int i, Block b)
/*    */   {
/* 28 */     super(i, b, 0);
/* 29 */     func_71849_a(ItemListMF.tabDeco);
/*    */   }
/*    */   
/*    */   public BlockMedievalStairs(int i, Block b, int m) {
/* 33 */     super(i, b, m);
/* 34 */     func_71849_a(ItemListMF.tabDeco);
/*    */   }
/*    */   
/*    */   public BlockMedievalStairs(int i, Block b, Material m, int tex) {
/* 38 */     super(i, b, 0);
/* 39 */     if (m == Material.field_76257_i) {
/* 40 */       setBurnProperties(i, 30, 60);
/*    */     }
/* 42 */     if (m == Material.field_76257_i) {
/* 43 */       setBurnProperties(i, 5, 20);
/*    */     }
/* 45 */     func_71849_a(ItemListMF.tabDeco);
/*    */   }
/*    */   
/*    */   public Icon func_71858_a(int s, int m)
/*    */   {
/* 50 */     if (this == MineFantasyBase.MFBlockHayRoof)
/* 51 */       return this.field_111038_cB;
/* 52 */     return super.func_71858_a(s, m);
/*    */   }
/*    */   
/*    */   public void addCreativeItems(ArrayList itemList)
/*    */   {
/* 57 */     itemList.add(new ItemStack(this));
/*    */   }
/*    */   
/*    */   public void func_94332_a(IconRegister reg) {
/* 61 */     this.field_111038_cB = reg.func_94245_a("MineFantasy:Basic/Hay_Roof");
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/BlockMedievalStairs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */