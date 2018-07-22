/*     */ package minefantasy.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockLeaves;
/*     */ import net.minecraft.block.BlockLeavesBase;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraft.world.ColorizerFoliage;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraftforge.common.IShearable;
/*     */ 
/*     */ 
/*     */ public class BlockLeavesMF
/*     */   extends BlockLeavesBase
/*     */   implements IShearable
/*     */ {
/*  30 */   public static final String[] LEAF_TYPES = { "ironbark", "ebony" };
/*  31 */   public static final String[] names = { "IronBarkLeaves", "IronBarkLeaves_opaque", "leaves", "leaves_opaque" };
/*  32 */   private Icon[] iconArray = new Icon[4];
/*     */   int[] adjacentTreeBlocks;
/*     */   
/*     */   public BlockLeavesMF(int id) {
/*  36 */     super(id, Material.field_76257_i, true);
/*  37 */     func_71907_b(true);
/*  38 */     func_71849_a(ItemListMF.tabDeco);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_71933_m() {
/*  43 */     double d0 = 0.5D;
/*  44 */     double d1 = 1.0D;
/*  45 */     return ColorizerFoliage.func_77470_a(d0, d1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_71889_f_(int meta)
/*     */   {
/*  53 */     return (meta & 0x3) == 2 ? ColorizerFoliage.func_77469_b() : (meta & 0x3) == 1 ? ColorizerFoliage.func_77468_c() : ColorizerFoliage.func_77468_c();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_71920_b(IBlockAccess world, int x, int y, int z)
/*     */   {
/*  62 */     int l = world.func_72805_g(x, y, z);
/*     */     
/*  64 */     if ((l & 0x3) == 1)
/*  65 */       return ColorizerFoliage.func_77466_a();
/*  66 */     if ((l & 0x3) == 2) {
/*  67 */       return ColorizerFoliage.func_77469_b();
/*     */     }
/*  69 */     int i1 = 0;
/*  70 */     int j1 = 0;
/*  71 */     int k1 = 0;
/*     */     
/*  73 */     for (int l1 = -1; l1 <= 1; l1++) {
/*  74 */       for (int i2 = -1; i2 <= 1; i2++) {
/*  75 */         int j2 = world.func_72807_a(x + i2, z + l1).func_76726_l();
/*  76 */         i1 += ((j2 & 0xFF0000) >> 16);
/*  77 */         j1 += ((j2 & 0xFF00) >> 8);
/*  78 */         k1 += (j2 & 0xFF);
/*     */       }
/*     */     }
/*     */     
/*  82 */     return (i1 / 9 & 0xFF) << 16 | (j1 / 9 & 0xFF) << 8 | k1 / 9 & 0xFF;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_71852_a(World world, int x, int y, int z, int meta, int update)
/*     */   {
/*  91 */     byte b0 = 1;
/*  92 */     int j1 = b0 + 1;
/*     */     
/*  94 */     if (world.func_72904_c(x - j1, y - j1, z - j1, x + j1, y + j1, z + j1)) {
/*  95 */       for (int k1 = -b0; k1 <= b0; k1++) {
/*  96 */         for (int l1 = -b0; l1 <= b0; l1++) {
/*  97 */           for (int i2 = -b0; i2 <= b0; i2++) {
/*  98 */             int j2 = world.func_72798_a(x + k1, y + l1, z + i2);
/*     */             
/* 100 */             if (Block.field_71973_m[j2] != null) {
/* 101 */               Block.field_71973_m[j2].beginLeavesDecay(world, x + k1, y + l1, z + i2);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_71847_b(World world, int x, int y, int z, Random rand)
/*     */   {
/* 113 */     if (!world.field_72995_K) {
/* 114 */       int l = world.func_72805_g(x, y, z);
/*     */       
/* 116 */       if (((l & 0x8) != 0) && ((l & 0x4) == 0)) {
/* 117 */         byte b0 = 4;
/* 118 */         int i1 = b0 + 1;
/* 119 */         byte b1 = 32;
/* 120 */         int j1 = b1 * b1;
/* 121 */         int k1 = b1 / 2;
/*     */         
/* 123 */         if (this.adjacentTreeBlocks == null) {
/* 124 */           this.adjacentTreeBlocks = new int[b1 * b1 * b1];
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 129 */         if (world.func_72904_c(x - i1, y - i1, z - i1, x + i1, y + i1, z + i1))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 134 */           for (int l1 = -b0; l1 <= b0; l1++) {
/* 135 */             for (int i2 = -b0; i2 <= b0; i2++) {
/* 136 */               for (int j2 = -b0; j2 <= b0; j2++) {
/* 137 */                 int k2 = world.func_72798_a(x + l1, y + i2, z + j2);
/*     */                 
/* 139 */                 Block block = Block.field_71973_m[k2];
/*     */                 
/* 141 */                 if ((block != null) && (block.canSustainLeaves(world, x + l1, y + i2, z + j2))) {
/* 142 */                   this.adjacentTreeBlocks[((l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1)] = 0;
/* 143 */                 } else if ((block != null) && (block.isLeaves(world, x + l1, y + i2, z + j2))) {
/* 144 */                   this.adjacentTreeBlocks[((l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1)] = -2;
/*     */                 } else {
/* 146 */                   this.adjacentTreeBlocks[((l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1)] = -1;
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */           
/* 152 */           for (l1 = 1; l1 <= 4; l1++) {
/* 153 */             for (int i2 = -b0; i2 <= b0; i2++) {
/* 154 */               for (int j2 = -b0; j2 <= b0; j2++) {
/* 155 */                 for (int k2 = -b0; k2 <= b0; k2++) {
/* 156 */                   if (this.adjacentTreeBlocks[((i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1)] == l1 - 1) {
/* 157 */                     if (this.adjacentTreeBlocks[((i2 + k1 - 1) * j1 + (j2 + k1) * b1 + k2 + k1)] == -2) {
/* 158 */                       this.adjacentTreeBlocks[((i2 + k1 - 1) * j1 + (j2 + k1) * b1 + k2 + k1)] = l1;
/*     */                     }
/*     */                     
/* 161 */                     if (this.adjacentTreeBlocks[((i2 + k1 + 1) * j1 + (j2 + k1) * b1 + k2 + k1)] == -2) {
/* 162 */                       this.adjacentTreeBlocks[((i2 + k1 + 1) * j1 + (j2 + k1) * b1 + k2 + k1)] = l1;
/*     */                     }
/*     */                     
/* 165 */                     if (this.adjacentTreeBlocks[((i2 + k1) * j1 + (j2 + k1 - 1) * b1 + k2 + k1)] == -2) {
/* 166 */                       this.adjacentTreeBlocks[((i2 + k1) * j1 + (j2 + k1 - 1) * b1 + k2 + k1)] = l1;
/*     */                     }
/*     */                     
/* 169 */                     if (this.adjacentTreeBlocks[((i2 + k1) * j1 + (j2 + k1 + 1) * b1 + k2 + k1)] == -2) {
/* 170 */                       this.adjacentTreeBlocks[((i2 + k1) * j1 + (j2 + k1 + 1) * b1 + k2 + k1)] = l1;
/*     */                     }
/*     */                     
/* 173 */                     if (this.adjacentTreeBlocks[((i2 + k1) * j1 + (j2 + k1) * b1 + (k2 + k1 - 1))] == -2) {
/* 174 */                       this.adjacentTreeBlocks[((i2 + k1) * j1 + (j2 + k1) * b1 + (k2 + k1 - 1))] = l1;
/*     */                     }
/*     */                     
/* 177 */                     if (this.adjacentTreeBlocks[((i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1 + 1)] == -2) {
/* 178 */                       this.adjacentTreeBlocks[((i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1 + 1)] = l1;
/*     */                     }
/*     */                   }
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 187 */         int l1 = this.adjacentTreeBlocks[(k1 * j1 + k1 * b1 + k1)];
/*     */         
/* 189 */         if (l1 >= 0) {
/* 190 */           world.func_72921_c(x, y, z, l & 0xFFFFFFF7, 4);
/*     */         } else {
/* 192 */           removeLeaves(world, x, y, z);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_71862_a(World world, int x, int y, int z, Random rand)
/*     */   {
/* 203 */     if ((world.func_72951_B(x, y + 1, z)) && (!world.func_72797_t(x, y - 1, z)) && (rand.nextInt(15) == 1)) {
/* 204 */       double d0 = x + rand.nextFloat();
/* 205 */       double d1 = y - 0.05D;
/* 206 */       double d2 = z + rand.nextFloat();
/* 207 */       world.func_72869_a("dripWater", d0, d1, d2, 0.0D, 0.0D, 0.0D);
/*     */     }
/*     */   }
/*     */   
/*     */   private void removeLeaves(World world, int x, int y, int z) {
/* 212 */     func_71897_c(world, x, y, z, world.func_72805_g(x, y, z), 0);
/* 213 */     world.func_94571_i(x, y, z);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int func_71885_a(int id, Random rand, int meta)
/*     */   {
/* 220 */     return MineFantasyBase.MFBlockSapling.field_71990_ca;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_71914_a(World world, int x, int y, int z, int meta, float chance, int fortune)
/*     */   {
/* 228 */     if (!world.field_72995_K) {
/* 229 */       int j1 = 20;
/*     */       
/* 231 */       if ((meta & 0x3) == 1) {
/* 232 */         j1 = 600;
/*     */       }
/*     */       
/* 235 */       if (fortune > 0) {
/* 236 */         j1 -= (2 << fortune);
/*     */         
/* 238 */         if (j1 < 10) {
/* 239 */           j1 = 10;
/*     */         }
/*     */       }
/*     */       
/* 243 */       if (world.field_73012_v.nextInt(j1) == 0) {
/* 244 */         int k1 = func_71885_a(meta, world.field_73012_v, fortune);
/* 245 */         func_71929_a(world, x, y, z, new ItemStack(k1, 1, func_71899_b(meta)));
/*     */       }
/*     */       
/* 248 */       j1 = 200;
/*     */       
/* 250 */       if (fortune > 0) {
/* 251 */         j1 -= (10 << fortune);
/*     */         
/* 253 */         if (j1 < 40) {
/* 254 */           j1 = 40;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_71893_a(World world, EntityPlayer player, int x, int y, int z, int meta)
/*     */   {
/* 266 */     super.func_71893_a(world, player, x, y, z, meta);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int func_71899_b(int meta)
/*     */   {
/* 274 */     return meta & 0x3;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_71926_d()
/*     */   {
/* 283 */     return !Block.field_71952_K.field_72131_c;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Icon func_71858_a(int side, int m)
/*     */   {
/* 292 */     int meta = m & 0x3;
/* 293 */     int graphics = Block.field_71952_K.field_72131_c ? 0 : 1;
/* 294 */     if (meta == 1) {
/* 295 */       return Block.field_71952_K.func_71858_a(side, 0);
/*     */     }
/* 297 */     return this.iconArray[(meta * 2 + graphics)];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_71879_a(int id, CreativeTabs tab, List list)
/*     */   {
/* 305 */     for (int a = 0; a < 2; a++) {
/* 306 */       list.add(new ItemStack(id, 1, a));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected ItemStack func_71880_c_(int meta)
/*     */   {
/* 317 */     return new ItemStack(this.field_71990_ca, 1, meta & 0x3);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94332_a(IconRegister reg)
/*     */   {
/* 326 */     this.iconArray[0] = reg.func_94245_a("minefantasy:Tree/" + names[0]);
/* 327 */     this.iconArray[1] = reg.func_94245_a("minefantasy:Tree/" + names[1]);
/* 328 */     this.iconArray[2] = reg.func_94245_a("minecraft:" + names[2]);
/* 329 */     this.iconArray[3] = reg.func_94245_a("minecraft:" + names[3]);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isShearable(ItemStack item, World world, int x, int y, int z)
/*     */   {
/* 335 */     return true;
/*     */   }
/*     */   
/*     */   public int quantityDropped(int meta, int fort, Random random)
/*     */   {
/* 340 */     fort = Math.max(1, fort);
/* 341 */     int c = meta == 0 ? 20 : 120;
/* 342 */     return random.nextInt(getChance(meta)) == 0 ? 1 + random.nextInt(fort) : 0;
/*     */   }
/*     */   
/*     */   private int getChance(int meta) {
/* 346 */     int type = meta & 0x3;
/* 347 */     return meta == 0 ? 20 : 100;
/*     */   }
/*     */   
/*     */   public ArrayList<ItemStack> onSheared(ItemStack item, World world, int x, int y, int z, int fortune)
/*     */   {
/* 352 */     ArrayList<ItemStack> ret = new ArrayList();
/* 353 */     ret.add(new ItemStack(this, 1, world.func_72805_g(x, y, z) & 0x3));
/* 354 */     return ret;
/*     */   }
/*     */   
/*     */   public void beginLeavesDecay(World world, int x, int y, int z)
/*     */   {
/* 359 */     world.func_72921_c(x, y, z, world.func_72805_g(x, y, z) | 0x8, 4);
/*     */   }
/*     */   
/*     */   public boolean isLeaves(World world, int x, int y, int z)
/*     */   {
/* 364 */     return true;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/BlockLeavesMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */