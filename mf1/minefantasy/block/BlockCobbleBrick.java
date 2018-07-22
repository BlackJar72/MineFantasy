/*    */ package minefantasy.block;
/*    */ 
/*    */ import minefantasy.item.ItemListMF;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IconRegister;
/*    */ import net.minecraft.util.Icon;
/*    */ 
/*    */ 
/*    */ public class BlockCobbleBrick
/*    */   extends BlockMedieval
/*    */ {
/* 12 */   public Icon[] types = new Icon[6];
/*    */   
/*    */   public BlockCobbleBrick(int i) {
/* 15 */     super(i, Material.field_76246_e);
/* 16 */     func_71849_a(ItemListMF.tabDeco);
/*    */   }
/*    */   
/*    */   public Icon func_71858_a(int side, int meta)
/*    */   {
/* 21 */     return this.types[meta];
/*    */   }
/*    */   
/*    */   public int func_71899_b(int meta)
/*    */   {
/* 26 */     return meta;
/*    */   }
/*    */   
/*    */   public void func_94332_a(IconRegister reg) {
/* 30 */     this.types[0] = reg.func_94245_a("MineFantasy:Basic/Cobblestone_brick");
/* 31 */     this.types[1] = reg.func_94245_a("MineFantasy:Basic/Cobblestone_brick_mossy");
/* 32 */     this.types[2] = reg.func_94245_a("MineFantasy:Basic/Cobblestone_brick_cracked");
/*    */     
/* 34 */     this.types[3] = reg.func_94245_a("MineFantasy:Basic/Cobblestone_brick_rough");
/* 35 */     this.types[4] = reg.func_94245_a("MineFantasy:Basic/Cobblestone_brick_rough_mossy");
/* 36 */     this.types[5] = reg.func_94245_a("MineFantasy:Basic/Cobblestone_brick_rough_cracked");
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/BlockCobbleBrick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */