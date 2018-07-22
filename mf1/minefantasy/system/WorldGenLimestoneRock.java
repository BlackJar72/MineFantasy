/*    */ package minefantasy.system;
/*    */ 
/*    */ import java.util.Random;
/*    */ import minefantasy.MineFantasyBase;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ 
/*    */ 
/*    */ public class WorldGenLimestoneRock
/*    */   extends WorldGenerator
/*    */ {
/* 14 */   private int minableBlockMeta = 0;
/*    */   
/*    */   private int numberOfBlocks;
/*    */   
/*    */   public WorldGenLimestoneRock(int size)
/*    */   {
/* 20 */     this.numberOfBlocks = size;
/*    */   }
/*    */   
/*    */   public boolean func_76484_a(World world, Random rand, int x, int y, int z) {
/* 24 */     float var6 = rand.nextFloat() * 3.1415927F;
/* 25 */     double var7 = x + 8 + MathHelper.func_76126_a(var6) * this.numberOfBlocks / 8.0F;
/* 26 */     double var9 = x + 8 - MathHelper.func_76126_a(var6) * this.numberOfBlocks / 8.0F;
/* 27 */     double var11 = z + 8 + MathHelper.func_76134_b(var6) * this.numberOfBlocks / 8.0F;
/* 28 */     double var13 = z + 8 - MathHelper.func_76134_b(var6) * this.numberOfBlocks / 8.0F;
/* 29 */     double var15 = y + rand.nextInt(3) - 2;
/* 30 */     double var17 = y + rand.nextInt(3) - 2;
/*    */     
/* 32 */     for (int var19 = 0; var19 <= this.numberOfBlocks; var19++) {
/* 33 */       double var20 = var7 + (var9 - var7) * var19 / this.numberOfBlocks;
/* 34 */       double var22 = var15 + (var17 - var15) * var19 / this.numberOfBlocks;
/* 35 */       double var24 = var11 + (var13 - var11) * var19 / this.numberOfBlocks;
/* 36 */       double var26 = rand.nextDouble() * this.numberOfBlocks / 16.0D;
/* 37 */       double var28 = (MathHelper.func_76126_a(var19 * 3.1415927F / this.numberOfBlocks) + 1.0F) * var26 + 1.0D;
/* 38 */       double var30 = (MathHelper.func_76126_a(var19 * 3.1415927F / this.numberOfBlocks) + 1.0F) * var26 + 1.0D;
/* 39 */       int var32 = MathHelper.func_76128_c(var20 - var28 / 2.0D);
/* 40 */       int var33 = MathHelper.func_76128_c(var22 - var30 / 2.0D);
/* 41 */       int var34 = MathHelper.func_76128_c(var24 - var28 / 2.0D);
/* 42 */       int var35 = MathHelper.func_76128_c(var20 + var28 / 2.0D);
/* 43 */       int var36 = MathHelper.func_76128_c(var22 + var30 / 2.0D);
/* 44 */       int var37 = MathHelper.func_76128_c(var24 + var28 / 2.0D);
/*    */       
/* 46 */       for (int var38 = var32; var38 <= var35; var38++) {
/* 47 */         double var39 = (var38 + 0.5D - var20) / (var28 / 2.0D);
/*    */         
/* 49 */         if (var39 * var39 < 1.0D) {
/* 50 */           for (int var41 = var33; var41 <= var36; var41++) {
/* 51 */             double var42 = (var41 + 0.5D - var22) / (var30 / 2.0D);
/*    */             
/* 53 */             if (var39 * var39 + var42 * var42 < 1.0D) {
/* 54 */               for (int var44 = var34; var44 <= var37; var44++) {
/* 55 */                 double var45 = (var44 + 0.5D - var24) / (var28 / 2.0D);
/*    */                 
/* 57 */                 Block block = Block.field_71973_m[world.func_72798_a(var38, var41, var44)];
/* 58 */                 if (var39 * var39 + var42 * var42 + var45 * var45 < 1.0D) {
/* 59 */                   world.func_72832_d(var38, var41, var44, MineFantasyBase.MFBlockLimestone.field_71990_ca, this.minableBlockMeta, 2);
/*    */                 }
/*    */               }
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 68 */     return true;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/WorldGenLimestoneRock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */