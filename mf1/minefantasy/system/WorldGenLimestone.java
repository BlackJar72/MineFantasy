/*    */ package minefantasy.system;
/*    */ 
/*    */ import java.util.Random;
/*    */ import minefantasy.MineFantasyBase;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockGrass;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ 
/*    */ public class WorldGenLimestone
/*    */   extends WorldGenerator
/*    */ {
/* 13 */   private int minableBlockMeta = 0;
/*    */   
/*    */   private int limestoneSize;
/*    */   private int submergeDepth;
/*    */   private int height;
/*    */   private boolean sandOnly;
/*    */   
/*    */   public WorldGenLimestone(int under, int over, int size)
/*    */   {
/* 22 */     this.limestoneSize = size;
/* 23 */     this.submergeDepth = under;
/* 24 */     this.height = over;
/*    */   }
/*    */   
/*    */   public boolean func_76484_a(World world, Random random, int i, int j, int k) {
/* 28 */     boolean flag = true;
/* 29 */     if ((j < 1) || (j + this.height + 1 > 256)) {
/* 30 */       return false;
/*    */     }
/* 32 */     for (int i1 = j; i1 <= j + 1 + this.height; i1++) {
/* 33 */       byte byte0 = 1;
/* 34 */       if (i1 == j) {
/* 35 */         byte0 = 0;
/*    */       }
/* 37 */       if (i1 >= j + 1 + this.height - 2) {
/* 38 */         byte0 = 2;
/*    */       }
/* 40 */       for (int i2 = i - byte0; (i2 <= i + byte0) && (flag); i2++) {
/* 41 */         for (int l2 = k - byte0; (l2 <= k + byte0) && (flag); l2++) {
/* 42 */           if ((i1 >= 0) && (i1 < 256)) {
/* 43 */             int j3 = world.func_72798_a(i2, i1, l2);
/* 44 */             if ((j3 != 0) && (j3 != MineFantasyBase.MFBlockLimestone.field_71990_ca))
/*    */             {
/* 46 */               flag = false;
/*    */             }
/*    */           } else {
/* 49 */             flag = false;
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 57 */     if (!flag) {
/* 58 */       return false;
/*    */     }
/* 60 */     int j1 = world.func_72798_a(i, j - 1, k);
/* 61 */     if (((j1 != Block.field_71939_E.field_71990_ca) && (j1 != Block.field_71980_u.field_71990_ca) && (j1 != Block.field_71979_v.field_71990_ca)) || (j >= 256 - this.height - 1)) {
/* 62 */       return false;
/*    */     }
/* 64 */     if ((this.sandOnly) && (j1 == Block.field_71980_u.field_71990_ca) && (j1 == Block.field_71979_v.field_71990_ca)) {
/* 65 */       return false;
/*    */     }
/* 67 */     generateLimestone(world, random, i, j - 1, k);
/* 68 */     return true;
/*    */   }
/*    */   
/*    */   public WorldGenLimestone sandOnly() {
/* 72 */     this.sandOnly = true;
/* 73 */     return this;
/*    */   }
/*    */   
/*    */   private void generateLimestone(World world, Random random, int x, int y, int z) {
/* 77 */     for (int t = -this.submergeDepth; t < this.height; t++)
/* 78 */       new WorldGenLimestoneRock(this.limestoneSize).func_76484_a(world, random, x, y - t, z);
/*    */   }
/*    */   
/*    */   private void initGeneration(World world, Random rand, int x, int y, int z) {
/* 82 */     world.func_94575_c(x, y, z, MineFantasyBase.MFBlockLimestone.field_71990_ca);
/*    */   }
/*    */   
/*    */   public boolean canBuildOff(World world, int x, int y, int z)
/*    */   {
/* 87 */     return (world.func_72798_a(x, y, z) == Block.field_71939_E.field_71990_ca) || (world.func_72798_a(x, y, z) == Block.field_71980_u.field_71990_ca);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/WorldGenLimestone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */