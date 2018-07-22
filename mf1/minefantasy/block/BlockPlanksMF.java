/*    */ package minefantasy.block;
/*    */ 
/*    */ import minefantasy.item.ItemListMF;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IconRegister;
/*    */ import net.minecraft.util.Icon;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockPlanksMF
/*    */   extends BlockMedieval
/*    */ {
/* 15 */   private Icon[] type = new Icon[2];
/*    */   
/*    */   public BlockPlanksMF(int i) {
/* 18 */     super(i, Material.field_76245_d);
/* 19 */     func_71849_a(ItemListMF.tabDeco);
/*    */   }
/*    */   
/*    */   public Icon func_71858_a(int side, int meta)
/*    */   {
/* 24 */     return this.type[meta];
/*    */   }
/*    */   
/*    */   public int func_71899_b(int meta)
/*    */   {
/* 29 */     return meta;
/*    */   }
/*    */   
/*    */   public float func_71934_m(World world, int x, int y, int z)
/*    */   {
/* 34 */     float f = super.func_71934_m(world, x, y, z);
/* 35 */     int meta = world.func_72805_g(x, y, z);
/*    */     
/* 37 */     if (meta == 1) {
/* 38 */       f *= 2.0F;
/*    */     }
/* 40 */     return f;
/*    */   }
/*    */   
/*    */   public void func_94332_a(IconRegister reg)
/*    */   {
/* 45 */     this.type[0] = reg.func_94245_a("MineFantasy:Tree/planksIronbark");
/* 46 */     this.type[1] = reg.func_94245_a("MineFantasy:Tree/planksEbony");
/*    */   }
/*    */   
/*    */   public Block func_71864_b(String name)
/*    */   {
/* 51 */     func_111022_d("minefantasy:Tree/" + name);
/* 52 */     return super.func_71864_b(name);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/BlockPlanksMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */