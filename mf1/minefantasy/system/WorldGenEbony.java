/*     */ package minefantasy.system;
/*     */ 
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockSapling;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.feature.WorldGenerator;
/*     */ import net.minecraftforge.common.ForgeDirection;
/*     */ 
/*     */ public class WorldGenEbony
/*     */   extends WorldGenerator
/*     */ {
/*  15 */   private final int logID = MineFantasyBase.MFBlockLog.field_71990_ca;
/*  16 */   private final int leavesID = MineFantasyBase.MFBlockLeaves.field_71990_ca;
/*  17 */   private final int metadata = 1;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  22 */   static final byte[] otherCoordPairs = { 2, 0, 0, 1, 2, 1 };
/*     */   
/*     */ 
/*  25 */   Random rand = new Random();
/*     */   
/*     */   World worldObj;
/*     */   
/*  29 */   int[] basePos = { 0, 0, 0 };
/*  30 */   int heightLimit = 0;
/*     */   int height;
/*  32 */   double heightAttenuation = 0.718D;
/*  33 */   double branchDensity = 1.1D;
/*  34 */   double branchSlope = 0.581D;
/*  35 */   double scaleWidth = 1.1D;
/*  36 */   double leafDensity = 1.1D;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  42 */   int trunkSize = 1;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  47 */   int heightLimitLimit = 20;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  53 */   int leafDistanceLimit = 4;
/*     */   
/*     */   int[][] leafNodes;
/*     */   
/*     */   public WorldGenEbony(boolean par1)
/*     */   {
/*  59 */     super(par1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void generateLeafNodeList()
/*     */   {
/*  67 */     this.height = ((int)(this.heightLimit * this.heightAttenuation));
/*     */     
/*  69 */     if (this.height >= this.heightLimit) {
/*  70 */       this.height = (this.heightLimit - 1);
/*     */     }
/*     */     
/*  73 */     int i = (int)(1.382D + Math.pow(this.leafDensity * this.heightLimit / 13.0D, 2.0D));
/*     */     
/*  75 */     if (i < 1) {
/*  76 */       i = 1;
/*     */     }
/*     */     
/*  79 */     int[][] aint = new int[i * this.heightLimit][4];
/*  80 */     int j = this.basePos[1] + this.heightLimit - this.leafDistanceLimit;
/*  81 */     int k = 1;
/*  82 */     int l = this.basePos[1] + this.height;
/*  83 */     int i1 = j - this.basePos[1];
/*  84 */     aint[0][0] = this.basePos[0];
/*  85 */     aint[0][1] = j;
/*  86 */     aint[0][2] = this.basePos[2];
/*  87 */     aint[0][3] = l;
/*  88 */     j--;
/*     */     
/*  90 */     while (i1 >= 0) {
/*  91 */       int j1 = 0;
/*  92 */       float f = layerSize(i1);
/*     */       
/*  94 */       if (f < 0.0F) {
/*  95 */         j--;
/*  96 */         i1--;
/*     */       } else {
/*  98 */         for (double d0 = 0.5D; j1 < i; j1++) {
/*  99 */           double d1 = this.scaleWidth * f * (this.rand.nextFloat() + 0.328D);
/* 100 */           double d2 = this.rand.nextFloat() * 2.0D * 3.141592653589793D;
/* 101 */           int k1 = MathHelper.func_76128_c(d1 * Math.sin(d2) + this.basePos[0] + d0);
/* 102 */           int l1 = MathHelper.func_76128_c(d1 * Math.cos(d2) + this.basePos[2] + d0);
/* 103 */           int[] aint1 = { k1, j, l1 };
/* 104 */           int[] aint2 = { k1, j + this.leafDistanceLimit, l1 };
/*     */           
/* 106 */           if (checkBlockLine(aint1, aint2) == -1) {
/* 107 */             int[] aint3 = { this.basePos[0], this.basePos[1], this.basePos[2] };
/* 108 */             double d3 = Math.sqrt(Math.pow(Math.abs(this.basePos[0] - aint1[0]), 2.0D) + Math.pow(Math.abs(this.basePos[2] - aint1[2]), 2.0D));
/* 109 */             double d4 = d3 * this.branchSlope;
/*     */             
/* 111 */             if (aint1[1] - d4 > l) {
/* 112 */               aint3[1] = l;
/*     */             } else {
/* 114 */               aint3[1] = ((int)(aint1[1] - d4));
/*     */             }
/*     */             
/* 117 */             if (checkBlockLine(aint3, aint1) == -1) {
/* 118 */               aint[k][0] = k1;
/* 119 */               aint[k][1] = j;
/* 120 */               aint[k][2] = l1;
/* 121 */               aint[k][3] = aint3[1];
/* 122 */               k++;
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 127 */         j--;
/* 128 */         i1--;
/*     */       }
/*     */     }
/*     */     
/* 132 */     this.leafNodes = new int[k][4];
/* 133 */     System.arraycopy(aint, 0, this.leafNodes, 0, k);
/*     */   }
/*     */   
/*     */   void genTreeLayer(int par1, int par2, int par3, float par4, byte par5, int par6) {
/* 137 */     int i1 = (int)(par4 + 0.618D);
/* 138 */     byte b1 = otherCoordPairs[par5];
/* 139 */     byte b2 = otherCoordPairs[(par5 + 3)];
/* 140 */     int[] aint = { par1, par2, par3 };
/* 141 */     int[] aint1 = { 0, 0, 0 };
/* 142 */     int j1 = -i1;
/* 143 */     int k1 = -i1;
/*     */     
/* 145 */     for (aint1[par5] = aint[par5]; j1 <= i1; j1++) {
/* 146 */       aint[b1] += j1;
/* 147 */       k1 = -i1;
/*     */       
/* 149 */       while (k1 <= i1) {
/* 150 */         double d0 = Math.pow(Math.abs(j1) + 0.5D, 2.0D) + Math.pow(Math.abs(k1) + 0.5D, 2.0D);
/*     */         
/* 152 */         if (d0 > par4 * par4) {
/* 153 */           k1++;
/*     */         } else {
/* 155 */           aint[b2] += k1;
/* 156 */           int l1 = this.worldObj.func_72798_a(aint1[0], aint1[1], aint1[2]);
/*     */           
/* 158 */           if ((l1 != 0) && (l1 != this.leavesID)) {
/* 159 */             k1++;
/*     */           } else {
/* 161 */             func_76485_a(this.worldObj, aint1[0], aint1[1], aint1[2], par6, 1);
/* 162 */             k1++;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   float layerSize(int par1)
/*     */   {
/* 173 */     if (par1 < this.heightLimit * 0.3D) {
/* 174 */       return -1.618F;
/*     */     }
/* 176 */     float f = this.heightLimit / 2.0F;
/* 177 */     float f1 = this.heightLimit / 2.0F - par1;
/*     */     float f2;
/*     */     float f2;
/* 180 */     if (f1 == 0.0F) {
/* 181 */       f2 = f; } else { float f2;
/* 182 */       if (Math.abs(f1) >= f) {
/* 183 */         f2 = 0.0F;
/*     */       } else {
/* 185 */         f2 = (float)Math.sqrt(Math.pow(Math.abs(f), 2.0D) - Math.pow(Math.abs(f1), 2.0D));
/*     */       }
/*     */     }
/* 188 */     f2 *= 0.5F;
/* 189 */     return f2;
/*     */   }
/*     */   
/*     */   float leafSize(int par1)
/*     */   {
/* 194 */     return (par1 >= 0) && (par1 < this.leafDistanceLimit) ? 2.0F : (par1 != 0) && (par1 != this.leafDistanceLimit - 1) ? 3.0F : -1.0F;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void generateLeafNode(int par1, int par2, int par3)
/*     */   {
/* 202 */     int l = par2;
/*     */     
/* 204 */     for (int i1 = par2 + this.leafDistanceLimit; l < i1; l++) {
/* 205 */       float f = leafSize(l - par2);
/* 206 */       genTreeLayer(par1, l, par3, f, (byte)1, this.leavesID);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void placeBlockLine(int[] par1ArrayOfInteger, int[] par2ArrayOfInteger, int par3)
/*     */   {
/* 215 */     int[] aint2 = { 0, 0, 0 };
/* 216 */     byte b0 = 0;
/*     */     
/*     */ 
/* 219 */     for (byte b1 = 0; b0 < 3; b0 = (byte)(b0 + 1)) {
/* 220 */       par2ArrayOfInteger[b0] -= par1ArrayOfInteger[b0];
/*     */       
/* 222 */       if (Math.abs(aint2[b0]) > Math.abs(aint2[b1])) {
/* 223 */         b1 = b0;
/*     */       }
/*     */     }
/*     */     
/* 227 */     if (aint2[b1] != 0) {
/* 228 */       byte b2 = otherCoordPairs[b1];
/* 229 */       byte b3 = otherCoordPairs[(b1 + 3)];
/*     */       byte b4;
/*     */       byte b4;
/* 232 */       if (aint2[b1] > 0) {
/* 233 */         b4 = 1;
/*     */       } else {
/* 235 */         b4 = -1;
/*     */       }
/*     */       
/* 238 */       double d0 = aint2[b2] / aint2[b1];
/* 239 */       double d1 = aint2[b3] / aint2[b1];
/* 240 */       int[] aint3 = { 0, 0, 0 };
/* 241 */       int j = 0;
/*     */       
/* 243 */       for (int k = aint2[b1] + b4; j != k; j += b4) {
/* 244 */         aint3[b1] = MathHelper.func_76128_c(par1ArrayOfInteger[b1] + j + 0.5D);
/* 245 */         aint3[b2] = MathHelper.func_76128_c(par1ArrayOfInteger[b2] + j * d0 + 0.5D);
/* 246 */         aint3[b3] = MathHelper.func_76128_c(par1ArrayOfInteger[b3] + j * d1 + 0.5D);
/* 247 */         byte b5 = 1;
/* 248 */         int l = Math.abs(aint3[0] - par1ArrayOfInteger[0]);
/* 249 */         int i1 = Math.abs(aint3[2] - par1ArrayOfInteger[2]);
/* 250 */         int j1 = Math.max(l, i1);
/*     */         
/* 252 */         if (j1 > 0) {
/* 253 */           if (l == j1) {
/* 254 */             b5 = 5;
/* 255 */           } else if (i1 == j1) {
/* 256 */             b5 = 9;
/*     */           }
/*     */         }
/*     */         
/* 260 */         func_76485_a(this.worldObj, aint3[0], aint3[1], aint3[2], par3, b5);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void generateLeaves()
/*     */   {
/* 270 */     int i = 0;
/*     */     
/* 272 */     for (int j = this.leafNodes.length; i < j; i++) {
/* 273 */       int k = this.leafNodes[i][0];
/* 274 */       int l = this.leafNodes[i][1];
/* 275 */       int i1 = this.leafNodes[i][2];
/* 276 */       generateLeafNode(k, l, i1);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean leafNodeNeedsBase(int par1)
/*     */   {
/* 285 */     return par1 >= this.heightLimit * 0.2D;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void generateTrunk()
/*     */   {
/* 293 */     int i = this.basePos[0];
/* 294 */     int j = this.basePos[1];
/* 295 */     int k = this.basePos[1] + this.height;
/* 296 */     int l = this.basePos[2];
/* 297 */     int[] aint = { i, j, l };
/* 298 */     int[] aint1 = { i, k, l };
/* 299 */     placeBlockLine(aint, aint1, this.logID);
/*     */     
/* 301 */     if (this.trunkSize == 2) {
/* 302 */       aint[0] += 1;
/* 303 */       aint1[0] += 1;
/* 304 */       placeBlockLine(aint, aint1, this.logID);
/* 305 */       aint[2] += 1;
/* 306 */       aint1[2] += 1;
/* 307 */       placeBlockLine(aint, aint1, this.logID);
/* 308 */       aint[0] += -1;
/* 309 */       aint1[0] += -1;
/* 310 */       placeBlockLine(aint, aint1, this.logID);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void generateLeafNodeBases()
/*     */   {
/* 319 */     int i = 0;
/* 320 */     int j = this.leafNodes.length;
/*     */     
/* 322 */     for (int[] aint = { this.basePos[0], this.basePos[1], this.basePos[2] }; i < j; i++) {
/* 323 */       int[] aint1 = this.leafNodes[i];
/* 324 */       int[] aint2 = { aint1[0], aint1[1], aint1[2] };
/* 325 */       aint[1] = aint1[3];
/* 326 */       int k = aint[1] - this.basePos[1];
/*     */       
/* 328 */       if (leafNodeNeedsBase(k)) {
/* 329 */         placeBlockLine(aint, aint2, MineFantasyBase.MFBlockLog.field_71990_ca);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int checkBlockLine(int[] par1ArrayOfInteger, int[] par2ArrayOfInteger)
/*     */   {
/* 340 */     int[] aint2 = { 0, 0, 0 };
/* 341 */     byte b0 = 0;
/*     */     
/*     */ 
/* 344 */     for (byte b1 = 0; b0 < 3; b0 = (byte)(b0 + 1)) {
/* 345 */       par2ArrayOfInteger[b0] -= par1ArrayOfInteger[b0];
/*     */       
/* 347 */       if (Math.abs(aint2[b0]) > Math.abs(aint2[b1])) {
/* 348 */         b1 = b0;
/*     */       }
/*     */     }
/*     */     
/* 352 */     if (aint2[b1] == 0) {
/* 353 */       return -1;
/*     */     }
/* 355 */     byte b2 = otherCoordPairs[b1];
/* 356 */     byte b3 = otherCoordPairs[(b1 + 3)];
/*     */     byte b4;
/*     */     byte b4;
/* 359 */     if (aint2[b1] > 0) {
/* 360 */       b4 = 1;
/*     */     } else {
/* 362 */       b4 = -1;
/*     */     }
/*     */     
/* 365 */     double d0 = aint2[b2] / aint2[b1];
/* 366 */     double d1 = aint2[b3] / aint2[b1];
/* 367 */     int[] aint3 = { 0, 0, 0 };
/* 368 */     int i = 0;
/*     */     
/*     */ 
/* 371 */     for (int j = aint2[b1] + b4; i != j; i += b4) {
/* 372 */       par1ArrayOfInteger[b1] += i;
/* 373 */       aint3[b2] = MathHelper.func_76128_c(par1ArrayOfInteger[b2] + i * d0);
/* 374 */       aint3[b3] = MathHelper.func_76128_c(par1ArrayOfInteger[b3] + i * d1);
/* 375 */       int k = this.worldObj.func_72798_a(aint3[0], aint3[1], aint3[2]);
/*     */       
/* 377 */       if ((k != 0) && (k != this.leavesID)) {
/*     */         break;
/*     */       }
/*     */     }
/*     */     
/* 382 */     return i == j ? -1 : Math.abs(i);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean validTreeLocation()
/*     */   {
/* 391 */     int[] aint = { this.basePos[0], this.basePos[1], this.basePos[2] };
/* 392 */     int[] aint1 = { this.basePos[0], this.basePos[1] + this.heightLimit - 1, this.basePos[2] };
/* 393 */     int i = this.worldObj.func_72798_a(this.basePos[0], this.basePos[1] - 1, this.basePos[2]);
/*     */     
/* 395 */     Block soil = Block.field_71973_m[i];
/* 396 */     boolean isValidSoil = (soil != null) && (soil.canSustainPlant(this.worldObj, this.basePos[0], this.basePos[1] - 1, this.basePos[2], ForgeDirection.UP, (BlockSapling)Block.field_71987_y));
/* 397 */     if (!isValidSoil) {
/* 398 */       return false;
/*     */     }
/* 400 */     int j = checkBlockLine(aint, aint1);
/*     */     
/* 402 */     if (j == -1)
/* 403 */       return true;
/* 404 */     if (j < 6) {
/* 405 */       return false;
/*     */     }
/* 407 */     this.heightLimit = j;
/* 408 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_76487_a(double par1, double par3, double par5)
/*     */   {
/* 417 */     this.heightLimitLimit = ((int)(par1 * 12.0D));
/*     */     
/* 419 */     if (par1 > 0.5D) {
/* 420 */       this.leafDistanceLimit = 5;
/*     */     }
/*     */     
/* 423 */     this.scaleWidth = par3;
/* 424 */     this.leafDensity = par5;
/*     */   }
/*     */   
/*     */   public boolean func_76484_a(World par1World, Random par2Random, int par3, int par4, int par5) {
/* 428 */     this.worldObj = par1World;
/* 429 */     long l = par2Random.nextLong();
/* 430 */     this.rand.setSeed(l);
/* 431 */     this.basePos[0] = par3;
/* 432 */     this.basePos[1] = par4;
/* 433 */     this.basePos[2] = par5;
/*     */     
/* 435 */     if (this.heightLimit == 0) {
/* 436 */       this.heightLimit = (5 + this.rand.nextInt(this.heightLimitLimit));
/*     */     }
/*     */     
/* 439 */     if (!validTreeLocation()) {
/* 440 */       return false;
/*     */     }
/* 442 */     generateLeafNodeList();
/* 443 */     generateLeaves();
/* 444 */     generateTrunk();
/* 445 */     generateLeafNodeBases();
/* 446 */     return true;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/WorldGenEbony.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */