/*     */ package minefantasy.api.structure;
/*     */ 
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public abstract class StructureModuleMF
/*     */ {
/*     */   public final int xCoord;
/*     */   public final int yCoord;
/*     */   public final int zCoord;
/*     */   public final int direction;
/*     */   protected final World worldObj;
/*     */   
/*     */   public StructureModuleMF(World world, int x, int y, int z, int d) {
/*  14 */     this.worldObj = world;
/*  15 */     this.xCoord = x;
/*  16 */     this.yCoord = y;
/*  17 */     this.zCoord = z;
/*  18 */     this.direction = d;
/*     */   }
/*     */   
/*     */   public StructureModuleMF(World world, int x, int y, int z) {
/*  22 */     this(world, x, y, z, 0);
/*     */   }
/*     */   
/*     */   public abstract void generate();
/*     */   
/*     */   public int rotateLeft() {
/*  28 */     switch (this.direction) {
/*     */     case 0: 
/*  30 */       return 3;
/*     */     case 1: 
/*  32 */       return 0;
/*     */     case 2: 
/*  34 */       return 1;
/*     */     case 3: 
/*  36 */       return 2;
/*     */     }
/*  38 */     return 0;
/*     */   }
/*     */   
/*     */   public int rotateRight() {
/*  42 */     switch (this.direction) {
/*     */     case 0: 
/*  44 */       return 1;
/*     */     case 1: 
/*  46 */       return 2;
/*     */     case 2: 
/*  48 */       return 3;
/*     */     case 3: 
/*  50 */       return 0;
/*     */     }
/*  52 */     return 0;
/*     */   }
/*     */   
/*     */   public int reverse() {
/*  56 */     switch (this.direction) {
/*     */     case 0: 
/*  58 */       return 2;
/*     */     case 1: 
/*  60 */       return 3;
/*     */     case 2: 
/*  62 */       return 0;
/*     */     case 3: 
/*  64 */       return 1;
/*     */     }
/*  66 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void placeBlock(int id, int meta, int x, int y, int z)
/*     */   {
/*  84 */     placeBlock(id, meta, x, y, z, this.direction);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void placeBlock(int id, int meta, int xo, int yo, int zo, int dir)
/*     */   {
/* 104 */     int u = 2;
/* 105 */     int x = this.xCoord;
/* 106 */     int y = this.yCoord + yo;
/* 107 */     int z = this.zCoord;
/*     */     
/* 109 */     switch (dir) {
/*     */     case 0: 
/* 111 */       x += xo;
/* 112 */       z += zo;
/* 113 */       break;
/*     */     
/*     */     case 1: 
/* 116 */       x -= zo;
/* 117 */       z += xo;
/* 118 */       break;
/*     */     
/*     */     case 2: 
/* 121 */       x -= xo;
/* 122 */       z -= zo;
/* 123 */       break;
/*     */     
/*     */     case 3: 
/* 126 */       x += zo;
/* 127 */       z -= xo;
/*     */     }
/*     */     
/*     */     
/* 131 */     this.worldObj.func_72832_d(x, y, z, id, meta, u);
/*     */   }
/*     */   
/*     */   public int[] offsetPos(int xo, int yo, int zo, int dir) {
/* 135 */     int u = 2;
/* 136 */     int x = this.xCoord;
/* 137 */     int y = this.yCoord + yo;
/* 138 */     int z = this.zCoord;
/*     */     
/* 140 */     switch (dir) {
/*     */     case 0: 
/* 142 */       x += xo;
/* 143 */       z += zo;
/* 144 */       break;
/*     */     
/*     */     case 1: 
/* 147 */       x -= zo;
/* 148 */       z += xo;
/* 149 */       break;
/*     */     
/*     */     case 2: 
/* 152 */       x -= xo;
/* 153 */       z -= zo;
/* 154 */       break;
/*     */     
/*     */     case 3: 
/* 157 */       x += zo;
/* 158 */       z -= xo;
/*     */     }
/*     */     
/*     */     
/* 162 */     return new int[] { x, y, z };
/*     */   }
/*     */   
/*     */   public net.minecraft.tileentity.TileEntity getTileEntity(int xo, int yo, int zo, int dir) {
/* 166 */     int u = 2;
/* 167 */     int x = this.xCoord;
/* 168 */     int y = this.yCoord + yo;
/* 169 */     int z = this.zCoord;
/*     */     
/* 171 */     switch (dir) {
/*     */     case 0: 
/* 173 */       x += xo;
/* 174 */       z += zo;
/* 175 */       break;
/*     */     
/*     */     case 1: 
/* 178 */       x -= zo;
/* 179 */       z += xo;
/* 180 */       break;
/*     */     
/*     */     case 2: 
/* 183 */       x -= xo;
/* 184 */       z -= zo;
/* 185 */       break;
/*     */     
/*     */     case 3: 
/* 188 */       x += zo;
/* 189 */       z -= xo;
/*     */     }
/*     */     
/*     */     
/* 193 */     return this.worldObj.func_72796_p(x, y, z);
/*     */   }
/*     */   
/*     */   public void notifyBlock(int id, int xo, int yo, int zo, int dir) {
/* 197 */     int u = 2;
/* 198 */     int x = this.xCoord;
/* 199 */     int y = this.yCoord + yo;
/* 200 */     int z = this.zCoord;
/*     */     
/* 202 */     switch (dir) {
/*     */     case 0: 
/* 204 */       x += xo;
/* 205 */       z += zo;
/* 206 */       break;
/*     */     
/*     */     case 1: 
/* 209 */       x -= zo;
/* 210 */       z += xo;
/* 211 */       break;
/*     */     
/*     */     case 2: 
/* 214 */       x -= xo;
/* 215 */       z -= zo;
/* 216 */       break;
/*     */     
/*     */     case 3: 
/* 219 */       x += zo;
/* 220 */       z -= xo;
/*     */     }
/*     */     
/*     */     
/* 224 */     this.worldObj.func_72851_f(x, y, z, id);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/structure/StructureModuleMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */