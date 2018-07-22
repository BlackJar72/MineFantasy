/*     */ package minefantasy.block;
/*     */ 
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.client.tile.TileEntityRoad;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.BlockGrass;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.item.ItemBlock;
/*     */ import net.minecraft.item.ItemSpade;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AABBPool;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockRoad
/*     */   extends BlockContainer
/*     */ {
/*     */   public BlockRoad(int i, float f)
/*     */   {
/*  37 */     super(i, Material.field_76248_c);
/*  38 */     func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
/*  39 */     func_71868_h(0);
/*  40 */     func_71849_a(ItemListMF.tabDeco);
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_71872_e(World world, int x, int y, int z) {
/*  44 */     if (this == MineFantasyBase.MFBlockLowRoad) {
/*  45 */       return AxisAlignedBB.func_72332_a().func_72299_a(x + 0, y + 0, z + 0, x + 1, y + 0.5D, z + 1);
/*     */     }
/*  47 */     return AxisAlignedBB.func_72332_a().func_72299_a(x + 0, y + 0, z + 0, x + 1, y + 1, z + 1);
/*     */   }
/*     */   
/*     */   public Icon func_71895_b(IBlockAccess world, int x, int y, int z, int side)
/*     */   {
/*  52 */     TileEntityRoad tile = (TileEntityRoad)world.func_72796_p(x, y, z);
/*  53 */     int def = Block.field_71979_v.field_71990_ca;
/*     */     
/*  55 */     if (world.func_72805_g(x, y, z) == 1) {
/*  56 */       def = Block.field_71939_E.field_71990_ca;
/*     */     }
/*  58 */     int[] tex = tile.getSurface();
/*  59 */     if ((tex != null) && 
/*  60 */       (tex.length >= 2)) {
/*  61 */       int i = tex[0];
/*  62 */       if (i <= 0) {
/*  63 */         i = def;
/*     */       }
/*  65 */       Block block = Block.field_71973_m[i];
/*  66 */       if (block != null) {
/*  67 */         return block.func_71858_a(side, tex[1]);
/*     */       }
/*     */     }
/*     */     
/*  71 */     return null;
/*     */   }
/*     */   
/*     */   public Icon func_71858_a(int side, int meta)
/*     */   {
/*  76 */     if (meta == 1) {
/*  77 */       return Block.field_71979_v.func_71858_a(side, 0);
/*     */     }
/*  79 */     return Block.field_71979_v.func_71858_a(side, 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_71926_d()
/*     */   {
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int func_71922_a(World world, int x, int y, int z) {
/*  92 */     int meta = world.func_72805_g(x, y, z);
/*     */     
/*  94 */     return meta == 0 ? Block.field_71979_v.field_71990_ca : Block.field_71939_E.field_71990_ca;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_71886_c()
/*     */   {
/* 102 */     return false;
/*     */   }
/*     */   
/*     */   public void func_71861_g(World world, int x, int y, int z)
/*     */   {
/* 107 */     func_71847_b(world, x, y, z, new Random());
/* 108 */     super.func_71861_g(world, x, y, z);
/*     */   }
/*     */   
/*     */   public void func_71847_b(World world, int x, int y, int z, Random random)
/*     */   {
/* 113 */     if (world.func_72798_a(x, y - 1, z) == Block.field_71980_u.field_71990_ca) {
/* 114 */       world.func_72832_d(x, y - 1, z, Block.field_71979_v.field_71990_ca, 0, 2);
/*     */     }
/* 116 */     super.func_71847_b(world, x, y, z, random);
/*     */   }
/*     */   
/*     */   public void func_71863_a(World world, int x, int y, int z, int meta)
/*     */   {
/* 121 */     if (world.func_72798_a(x, y - 1, z) == Block.field_71980_u.field_71990_ca) {
/* 122 */       world.func_72832_d(x, y - 1, z, Block.field_71979_v.field_71990_ca, 0, 2);
/*     */     }
/* 124 */     TileEntityRoad road = (TileEntityRoad)world.func_72796_p(x, y, z);
/* 125 */     if (road != null) {
/* 126 */       road.sendPacketToClients();
/*     */     }
/*     */     
/* 129 */     super.func_71863_a(world, x, y, z, meta);
/*     */   }
/*     */   
/*     */   public boolean func_71903_a(World world, int x, int y, int z, EntityPlayer player, int i, float f, float f1, float f2) {
/* 133 */     TileEntityRoad road = (TileEntityRoad)world.func_72796_p(x, y, z);
/* 134 */     if (road == null) {
/* 135 */       return false;
/*     */     }
/* 137 */     int blockID = road.getSurface()[0];
/*     */     
/* 139 */     ItemStack itemstack = player.func_70694_bm();
/* 140 */     if ((itemstack != null) && (itemstack.field_77993_c <= 4096)) {
/* 141 */       if (!player.func_82247_a(x, y, z, i, itemstack)) {
/* 142 */         return false;
/*     */       }
/* 144 */       Block block = Block.field_71973_m[itemstack.field_77993_c];
/* 145 */       if (((itemstack.func_77973_b() instanceof ItemBlock)) && (block != null)) {
/* 146 */         if (!road.canBuild()) {
/* 147 */           return true;
/*     */         }
/*     */         
/* 150 */         if (upgradeRoad(world, x, y, z, 4, itemstack, block)) {
/* 151 */           if ((!player.field_71075_bZ.field_75098_d) && (!world.field_72995_K)) {
/* 152 */             itemstack.field_77994_a -= 1;
/* 153 */             if (itemstack.field_77994_a <= 0) {
/* 154 */               player.func_70062_b(0, null);
/*     */             }
/*     */           }
/* 157 */           return true;
/*     */         }
/*     */       }
/* 160 */       if (((itemstack.func_77973_b() instanceof ItemSpade)) && 
/* 161 */         (this == MineFantasyBase.MFBlockRoad)) {
/* 162 */         if (!world.field_72995_K) {
/* 163 */           int m = world.func_72805_g(x, y, z);
/* 164 */           world.func_72926_e(2001, x, y, z, blockID);
/* 165 */           world.func_72832_d(x, y, z, MineFantasyBase.MFBlockLowRoad.field_71990_ca, m, 2);
/*     */         }
/* 167 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 171 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean upgradeRoad(World world, int x, int y, int z, int r, ItemStack held, Block block)
/*     */   {
/* 182 */     if (held == null) {
/* 183 */       return false;
/*     */     }
/* 185 */     if (!block.func_71926_d()) {
/* 186 */       return false;
/*     */     }
/* 188 */     boolean flag = false;
/*     */     
/* 190 */     for (int x2 = -r; x2 <= r; x2++) {
/* 191 */       for (int y2 = -r; y2 <= r; y2++) {
/* 192 */         for (int z2 = -r; z2 <= r; z2++) {
/* 193 */           int id = world.func_72798_a(x + x2, y + y2, z + z2);
/* 194 */           int m = world.func_72805_g(x + x2, y + y2, z + z2);
/* 195 */           if (((id == MineFantasyBase.MFBlockRoad.field_71990_ca) || (id == MineFantasyBase.MFBlockLowRoad.field_71990_ca)) && 
/* 196 */             (getDistance(x + x2, y + y2, z + z2, x, y, z) < r * 1)) {
/* 197 */             flag = true;
/*     */             
/* 199 */             TileEntityRoad road = (TileEntityRoad)world.func_72796_p(x + x2, y + y2, z + z2);
/* 200 */             world.func_72926_e(2001, x + x2, y + y2, z + z2, held.field_77993_c);
/* 201 */             if (road != null) {
/* 202 */               road.setSurface(held.field_77993_c, held.func_77960_j());
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 210 */     return flag;
/*     */   }
/*     */   
/*     */   public int func_71885_a(int meta, Random rand, int i)
/*     */   {
/* 215 */     if (meta == 1) {
/* 216 */       return Block.field_71939_E.field_71990_ca;
/*     */     }
/* 218 */     return Block.field_71979_v.field_71990_ca;
/*     */   }
/*     */   
/*     */   public double getDistance(double x, double y, double z, int posX, int posY, int posZ) {
/* 222 */     double var7 = posX - x;
/* 223 */     double var9 = posY - y;
/* 224 */     double var11 = posZ - z;
/* 225 */     return MathHelper.func_76133_a(var7 * var7 + var9 * var9 + var11 * var11);
/*     */   }
/*     */   
/*     */   public TileEntity func_72274_a(World world)
/*     */   {
/* 230 */     return new TileEntityRoad();
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/BlockRoad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */