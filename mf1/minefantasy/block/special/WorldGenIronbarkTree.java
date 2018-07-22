/*    */ package minefantasy.block.special;
/*    */ 
/*    */ import java.util.Random;
/*    */ import minefantasy.MineFantasyBase;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ 
/*    */ public class WorldGenIronbarkTree extends WorldGenerator
/*    */ {
/*    */   public WorldGenIronbarkTree(boolean notify)
/*    */   {
/* 13 */     super(notify);
/*    */   }
/*    */   
/*    */   public WorldGenIronbarkTree() {
/* 17 */     super(false);
/*    */   }
/*    */   
/*    */   public boolean func_76484_a(World world, Random random, int i, int j, int k) {
/* 21 */     int height = random.nextInt(5) + 8;
/* 22 */     boolean flag = true;
/* 23 */     if ((j < 1) || (j + height + 1 > 256)) {
/* 24 */       return false;
/*    */     }
/* 26 */     for (int i1 = j; i1 <= j + 1 + height; i1++) {
/* 27 */       byte byte0 = 1;
/* 28 */       if (i1 == j) {
/* 29 */         byte0 = 0;
/*    */       }
/* 31 */       if (i1 >= j + 1 + height - 2) {
/* 32 */         byte0 = 2;
/*    */       }
/* 34 */       for (int i2 = i - byte0; (i2 <= i + byte0) && (flag); i2++) {
/* 35 */         for (int l2 = k - byte0; (l2 <= k + byte0) && (flag); l2++) {
/* 36 */           if ((i1 >= 0) && (i1 < 256)) {
/* 37 */             int j3 = world.func_72798_a(i2, i1, l2);
/* 38 */             if ((j3 != 0) && (j3 != MineFantasyBase.MFBlockLeaves.field_71990_ca))
/*    */             {
/* 40 */               flag = false;
/*    */             }
/*    */           } else {
/* 43 */             flag = false;
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 51 */     if (!flag) {
/* 52 */       return false;
/*    */     }
/* 54 */     int j1 = world.func_72798_a(i, j - 1, k);
/* 55 */     if (((j1 != Block.field_71980_u.field_71990_ca) && (j1 != Block.field_71979_v.field_71990_ca)) || (j >= 256 - height - 1))
/*    */     {
/*    */ 
/* 58 */       return false;
/*    */     }
/* 60 */     world.func_94575_c(i, j - 1, k, Block.field_71979_v.field_71990_ca);
/*    */     
/*    */ 
/* 63 */     for (int k1 = j - 3 + height; k1 <= j + height; k1++) {
/* 64 */       int j2 = k1 - (j + height);
/* 65 */       int i3 = 1 - j2 / 2;
/* 66 */       for (int k3 = i - i3; k3 <= i + i3; k3++) {
/* 67 */         int l3 = k3 - i;
/* 68 */         for (int i4 = k - i3; i4 <= k + i3; i4++) {
/* 69 */           int j4 = i4 - k;
/* 70 */           if (((Math.abs(l3) != i3) || (Math.abs(j4) != i3) || ((random.nextInt(2) != 0) && (j2 != 0))) && (Block.field_71970_n[world.func_72798_a(k3, k1, i4)] == 0)) {
/* 71 */             func_76485_a(world, k3, k1, i4, MineFantasyBase.MFBlockLeaves.field_71990_ca, 0);
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 79 */     for (int l1 = 0; l1 < height; l1++) {
/* 80 */       int k2 = world.func_72798_a(i, j + l1, k);
/* 81 */       if ((k2 == 0) || (k2 == MineFantasyBase.MFBlockLeaves.field_71990_ca))
/*    */       {
/* 83 */         func_76485_a(world, i, j + l1, k, MineFantasyBase.MFBlockLog.field_71990_ca, 0);
/*    */       }
/*    */     }
/*    */     
/* 87 */     return true;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/WorldGenIronbarkTree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */