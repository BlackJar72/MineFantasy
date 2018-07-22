/*    */ package minefantasy.block;
/*    */ 
/*    */ import minefantasy.item.ItemListMF;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.texture.IconRegister;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.Icon;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockStorageMF extends BlockMedieval
/*    */ {
/* 12 */   private Icon[] type = new Icon[9];
/*    */   
/*    */   public BlockStorageMF(int i) {
/* 15 */     super(i, net.minecraft.block.material.Material.field_76243_f);
/* 16 */     func_71849_a(ItemListMF.tabSmellting);
/*    */   }
/*    */   
/*    */   public Icon func_71858_a(int side, int meta)
/*    */   {
/* 21 */     return this.type[meta];
/*    */   }
/*    */   
/*    */   public float func_71934_m(World world, int x, int y, int z)
/*    */   {
/* 26 */     float f = Block.field_72083_ai.field_71989_cb;
/* 27 */     int meta = world.func_72805_g(x, y, z);
/*    */     
/* 29 */     if (meta == 0)
/* 30 */       f *= 1.5F;
/* 31 */     if (meta == 1)
/* 32 */       f *= 0.5F;
/* 33 */     if (meta == 2)
/* 34 */       f *= 0.6F;
/* 35 */     if (meta == 3)
/* 36 */       f *= 0.8F;
/* 37 */     if (meta == 4)
/* 38 */       f *= 2.0F;
/* 39 */     if (meta == 5)
/* 40 */       f *= 0.5F;
/* 41 */     if (meta == 6)
/* 42 */       f *= 0.5F;
/* 43 */     if (meta == 7) {
/* 44 */       f *= 1.0F;
/*    */     }
/* 46 */     return f;
/*    */   }
/*    */   
/*    */ 
/*    */   public float getExplosionResistance(Entity explosion, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ)
/*    */   {
/* 52 */     float f = Block.field_72083_ai.field_72029_cc;
/* 53 */     int meta = world.func_72805_g(x, y, z);
/*    */     
/* 55 */     if (meta == 0)
/* 56 */       f *= 1.5F;
/* 57 */     if (meta == 1)
/* 58 */       f *= 0.5F;
/* 59 */     if (meta == 2)
/* 60 */       f *= 0.6F;
/* 61 */     if (meta == 3)
/* 62 */       f *= 0.8F;
/* 63 */     if (meta == 4)
/* 64 */       f *= 2.0F;
/* 65 */     if (meta == 5)
/* 66 */       f *= 0.5F;
/* 67 */     if (meta == 6)
/* 68 */       f *= 0.5F;
/* 69 */     if (meta == 7) {
/* 70 */       f *= 1.0F;
/*    */     }
/* 72 */     return f;
/*    */   }
/*    */   
/*    */ 
/*    */   public int func_71899_b(int meta)
/*    */   {
/* 78 */     return meta;
/*    */   }
/*    */   
/*    */   public void func_94332_a(IconRegister reg) {
/* 82 */     this.type[0] = reg.func_94245_a("MineFantasy:Basic/MF_Storage_Steel");
/* 83 */     this.type[1] = reg.func_94245_a("MineFantasy:Basic/MF_Storage_Copper");
/* 84 */     this.type[2] = reg.func_94245_a("MineFantasy:Basic/MF_Storage_Tin");
/* 85 */     this.type[3] = reg.func_94245_a("MineFantasy:Basic/MF_Storage_Bronze");
/* 86 */     this.type[4] = reg.func_94245_a("MineFantasy:Basic/MF_Storage_Mithril");
/* 87 */     this.type[5] = reg.func_94245_a("MineFantasy:Basic/MF_Storage_Silver");
/* 88 */     this.type[6] = reg.func_94245_a("MineFantasy:Basic/MF_Storage_Silver");
/* 89 */     this.type[7] = reg.func_94245_a("MineFantasy:Basic/MF_Storage_Wrought");
/* 90 */     this.type[8] = reg.func_94245_a("MineFantasy:Basic/MF_Storage_DeepIron");
/*    */   }
/*    */   
/*    */   public boolean isBeaconBase(World worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ)
/*    */   {
/* 95 */     return true;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/BlockStorageMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */