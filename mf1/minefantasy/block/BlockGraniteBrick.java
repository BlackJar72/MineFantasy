/*    */ package minefantasy.block;
/*    */ 
/*    */ import minefantasy.item.ItemListMF;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IconRegister;
/*    */ import net.minecraft.util.Icon;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockGraniteBrick
/*    */   extends BlockMedieval
/*    */ {
/* 16 */   public Icon[] types = new Icon[3];
/*    */   
/*    */   public BlockGraniteBrick(int i) {
/* 19 */     super(i, Material.field_76246_e);
/* 20 */     func_71849_a(ItemListMF.tabDeco);
/*    */   }
/*    */   
/*    */   public Icon func_71858_a(int side, int meta)
/*    */   {
/* 25 */     return this.types[meta];
/*    */   }
/*    */   
/*    */   public int func_71899_b(int meta)
/*    */   {
/* 30 */     return meta;
/*    */   }
/*    */   
/*    */   public void func_94332_a(IconRegister reg) {
/* 34 */     this.types[0] = reg.func_94245_a("MineFantasy:Basic/Granite_brick");
/* 35 */     this.types[1] = reg.func_94245_a("MineFantasy:Basic/Granite_brick_mossy");
/* 36 */     this.types[2] = reg.func_94245_a("MineFantasy:Basic/Granite_brick_cracked");
/*    */   }
/*    */   
/*    */   public Block func_71864_b(String name)
/*    */   {
/* 41 */     func_111022_d("minefantasy:Basic/" + name);
/* 42 */     return super.func_71864_b(name);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/BlockGraniteBrick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */