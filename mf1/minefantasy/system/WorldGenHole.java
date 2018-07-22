/*    */ package minefantasy.system;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorldGenHole extends net.minecraft.world.gen.feature.WorldGenerator
/*    */ {
/*    */   private int numberOfBlocks;
/*    */   
/*    */   public WorldGenHole(int size)
/*    */   {
/* 15 */     this.numberOfBlocks = size;
/*    */   }
/*    */   
/*    */   public boolean func_76484_a(World world, Random rand, int x, int y, int z) {
/* 19 */     float f = rand.nextFloat() * 3.1415927F;
/* 20 */     double d0 = x + 8 + MathHelper.func_76126_a(f) * this.numberOfBlocks / 8.0F;
/* 21 */     double d1 = x + 8 - MathHelper.func_76126_a(f) * this.numberOfBlocks / 8.0F;
/* 22 */     double d2 = z + 8 + MathHelper.func_76134_b(f) * this.numberOfBlocks / 8.0F;
/* 23 */     double d3 = z + 8 - MathHelper.func_76134_b(f) * this.numberOfBlocks / 8.0F;
/* 24 */     double d4 = y + rand.nextInt(3) - 2;
/* 25 */     double d5 = y + rand.nextInt(3) - 2;
/*    */     
/* 27 */     for (int l = 0; l <= this.numberOfBlocks; l++) {
/* 28 */       double d6 = d0 + (d1 - d0) * l / this.numberOfBlocks;
/* 29 */       double d7 = d4 + (d5 - d4) * l / this.numberOfBlocks;
/* 30 */       double d8 = d2 + (d3 - d2) * l / this.numberOfBlocks;
/* 31 */       double d9 = rand.nextDouble() * this.numberOfBlocks / 16.0D;
/* 32 */       double d10 = (MathHelper.func_76126_a(l * 3.1415927F / this.numberOfBlocks) + 1.0F) * d9 + 1.0D;
/* 33 */       double d11 = (MathHelper.func_76126_a(l * 3.1415927F / this.numberOfBlocks) + 1.0F) * d9 + 1.0D;
/* 34 */       int i1 = MathHelper.func_76128_c(d6 - d10 / 2.0D);
/* 35 */       int j1 = MathHelper.func_76128_c(d7 - d11 / 2.0D);
/* 36 */       int k1 = MathHelper.func_76128_c(d8 - d10 / 2.0D);
/* 37 */       int l1 = MathHelper.func_76128_c(d6 + d10 / 2.0D);
/* 38 */       int i2 = MathHelper.func_76128_c(d7 + d11 / 2.0D);
/* 39 */       int j2 = MathHelper.func_76128_c(d8 + d10 / 2.0D);
/*    */       
/* 41 */       for (int k2 = i1; k2 <= l1; k2++) {
/* 42 */         double d12 = (k2 + 0.5D - d6) / (d10 / 2.0D);
/*    */         
/* 44 */         if (d12 * d12 < 1.0D) {
/* 45 */           for (int l2 = j1; l2 <= i2; l2++) {
/* 46 */             double d13 = (l2 + 0.5D - d7) / (d11 / 2.0D);
/*    */             
/* 48 */             if (d12 * d12 + d13 * d13 < 1.0D) {
/* 49 */               for (int i3 = k1; i3 <= j2; i3++) {
/* 50 */                 double d14 = (i3 + 0.5D - d8) / (d10 / 2.0D);
/*    */                 
/* 52 */                 Block block = Block.field_71973_m[world.func_72798_a(k2, l2, i3)];
/* 53 */                 if ((d12 * d12 + d13 * d13 + d14 * d14 < 1.0D) && (block != null) && (canReplace(world, x, y, z))) {
/* 54 */                   world.func_94571_i(k2, l2, i3);
/*    */                 }
/*    */               }
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 63 */     return true;
/*    */   }
/*    */   
/*    */   private boolean canReplace(World world, int x, int y, int z) {
/* 67 */     int id = world.func_72798_a(x, y, z);
/* 68 */     Block block = Block.field_71973_m[id];
/* 69 */     Material mat = world.func_72803_f(x, y, z);
/*    */     
/* 71 */     if ((mat == Material.field_76267_y) || (mat == Material.field_76261_t) || (mat == Material.field_76247_b) || (mat == Material.field_76248_c) || (mat == Material.field_76246_e) || (mat == Material.field_76251_o)) {
/* 72 */       return block.func_71934_m(world, x, y, z) >= 0.0F;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/WorldGenHole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */