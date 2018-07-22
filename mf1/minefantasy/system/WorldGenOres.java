/*    */ package minefantasy.system;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenMinable;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ 
/*    */ 
/*    */ public class WorldGenOres
/*    */   extends WorldGenerator
/*    */ {
/*    */   private int minableBlockId;
/* 15 */   private int minableBlockMeta = 0;
/*    */   
/*    */   private int numberOfBlocks;
/*    */   
/*    */   private int insideBlock;
/*    */   
/*    */   private int veinSize;
/*    */   
/*    */   private int veinChance;
/*    */   
/*    */ 
/*    */   public WorldGenOres(int size, int chance, int oreID, int veinSize)
/*    */   {
/* 28 */     this(size, chance, oreID, 0, veinSize, Block.field_71981_t.field_71990_ca);
/*    */   }
/*    */   
/*    */   public WorldGenOres(int size, int chance, int oreID, int veinSize, int target) {
/* 32 */     this(size, chance, oreID, 0, veinSize, target);
/*    */   }
/*    */   
/*    */   public WorldGenOres(int size, int chance, int oreID, int oreMeta, int veinSize, int target) {
/* 36 */     this.numberOfBlocks = size;
/* 37 */     this.veinChance = chance;
/* 38 */     this.minableBlockId = oreID;
/* 39 */     this.veinSize = veinSize;
/* 40 */     this.insideBlock = target;
/* 41 */     this.minableBlockMeta = oreMeta;
/*    */   }
/*    */   
/*    */   public boolean func_76484_a(World world, Random rand, int x, int y, int z) {
/* 45 */     float f = rand.nextFloat() * 3.1415927F;
/* 46 */     double d0 = x + 8 + MathHelper.func_76126_a(f) * this.numberOfBlocks / 8.0F;
/* 47 */     double d1 = x + 8 - MathHelper.func_76126_a(f) * this.numberOfBlocks / 8.0F;
/* 48 */     double d2 = z + 8 + MathHelper.func_76134_b(f) * this.numberOfBlocks / 8.0F;
/* 49 */     double d3 = z + 8 - MathHelper.func_76134_b(f) * this.numberOfBlocks / 8.0F;
/* 50 */     double d4 = y + rand.nextInt(3) - 2;
/* 51 */     double d5 = y + rand.nextInt(3) - 2;
/*    */     
/* 53 */     for (int l = 0; l <= this.numberOfBlocks; l++) {
/* 54 */       double d6 = d0 + (d1 - d0) * l / this.numberOfBlocks;
/* 55 */       double d7 = d4 + (d5 - d4) * l / this.numberOfBlocks;
/* 56 */       double d8 = d2 + (d3 - d2) * l / this.numberOfBlocks;
/* 57 */       double d9 = rand.nextDouble() * this.numberOfBlocks / 16.0D;
/* 58 */       double d10 = (MathHelper.func_76126_a(l * 3.1415927F / this.numberOfBlocks) + 1.0F) * d9 + 1.0D;
/* 59 */       double d11 = (MathHelper.func_76126_a(l * 3.1415927F / this.numberOfBlocks) + 1.0F) * d9 + 1.0D;
/* 60 */       int i1 = MathHelper.func_76128_c(d6 - d10 / 2.0D);
/* 61 */       int j1 = MathHelper.func_76128_c(d7 - d11 / 2.0D);
/* 62 */       int k1 = MathHelper.func_76128_c(d8 - d10 / 2.0D);
/* 63 */       int l1 = MathHelper.func_76128_c(d6 + d10 / 2.0D);
/* 64 */       int i2 = MathHelper.func_76128_c(d7 + d11 / 2.0D);
/* 65 */       int j2 = MathHelper.func_76128_c(d8 + d10 / 2.0D);
/*    */       
/* 67 */       for (int k2 = i1; k2 <= l1; k2++) {
/* 68 */         double d12 = (k2 + 0.5D - d6) / (d10 / 2.0D);
/*    */         
/* 70 */         if (d12 * d12 < 1.0D) {
/* 71 */           for (int l2 = j1; l2 <= i2; l2++) {
/* 72 */             double d13 = (l2 + 0.5D - d7) / (d11 / 2.0D);
/*    */             
/* 74 */             if (d12 * d12 + d13 * d13 < 1.0D) {
/* 75 */               for (int i3 = k1; i3 <= j2; i3++) {
/* 76 */                 double d14 = (i3 + 0.5D - d8) / (d10 / 2.0D);
/*    */                 
/* 78 */                 Block block = Block.field_71973_m[world.func_72798_a(k2, l2, i3)];
/* 79 */                 if ((d12 * d12 + d13 * d13 + d14 * d14 < 1.0D) && (block != null) && (block.isGenMineableReplaceable(world, k2, l2, i3, this.insideBlock)) && 
/* 80 */                   (rand.nextInt(1000) < this.veinChance)) {
/* 81 */                   new WorldGenMinable(this.minableBlockId, this.minableBlockMeta, this.veinSize, this.insideBlock).func_76484_a(world, rand, k2, l2, i3);
/*    */                 }
/*    */               }
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 91 */     return true;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/WorldGenOres.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */