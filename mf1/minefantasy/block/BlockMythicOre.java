/*    */ package minefantasy.block;
/*    */ 
/*    */ import minefantasy.item.ItemListMF;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IconRegister;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.Icon;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockMythicOre
/*    */   extends BlockMedieval
/*    */ {
/* 15 */   public Icon[] types = new Icon[3];
/*    */   
/*    */   public BlockMythicOre(int i) {
/* 18 */     super(i, Material.field_76246_e);
/* 19 */     func_71849_a(ItemListMF.tabDeco);
/*    */   }
/*    */   
/*    */   public Icon func_71858_a(int side, int meta)
/*    */   {
/* 24 */     return this.types[meta];
/*    */   }
/*    */   
/*    */   public int func_71899_b(int meta)
/*    */   {
/* 29 */     return meta;
/*    */   }
/*    */   
/*    */   public void func_94332_a(IconRegister reg) {
/* 33 */     this.types[0] = reg.func_94245_a("MineFantasy:Basic/oreMithril");
/* 34 */     this.types[1] = reg.func_94245_a("MineFantasy:Basic/oreDeepIron");
/* 35 */     this.types[2] = reg.func_94245_a("MineFantasy:Basic/oreDeepIronNether");
/*    */   }
/*    */   
/*    */   public float func_71934_m(World world, int x, int y, int z)
/*    */   {
/* 40 */     int meta = world.func_72805_g(x, y, z);
/*    */     
/* 42 */     if (meta == 0) {
/* 43 */       return 8.0F;
/*    */     }
/* 45 */     return 3.5F;
/*    */   }
/*    */   
/*    */   public float getExplosionResistance(Entity explosion, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ)
/*    */   {
/* 50 */     int meta = world.func_72805_g(x, y, z);
/*    */     
/* 52 */     if (meta == 0) {
/* 53 */       return 15.0F;
/*    */     }
/* 55 */     return 8.0F;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/BlockMythicOre.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */