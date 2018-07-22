/*     */ package minefantasy.system;
/*     */ 
/*     */ import cpw.mods.fml.common.IWorldGenerator;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ConcurrentModificationException;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.block.special.WorldGenIronbarkTree;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ import net.minecraft.world.gen.feature.WorldGenMinable;
/*     */ import net.minecraftforge.common.BiomeDictionary;
/*     */ import net.minecraftforge.common.BiomeDictionary.Type;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldGenMF
/*     */   implements IWorldGenerator
/*     */ {
/*     */   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
/*     */   {
/*  31 */     generateMisc(random, chunkX, chunkZ, world);
/*  32 */     generateOres(random, chunkX, chunkZ, world, false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void generateOres(Random random, int chunkX, int chunkZ, World world, boolean HC)
/*     */   {
/*     */     try
/*     */     {
/*  43 */       if ((random.nextInt(250) == 0) && (cfg.spawnIgnot)) {
/*  44 */         addOre(random, chunkX, chunkZ, world, MineFantasyBase.MFBlockOreUmite.field_71990_ca, 0, 8, 1, 0, 16);
/*     */       }
/*     */       
/*  47 */       if (cfg.spawnSilver) {
/*  48 */         addOre(random, chunkX, chunkZ, world, MineFantasyBase.MFBlockOreUtil.field_71990_ca, 0, 8, 2, 0, 32);
/*     */       }
/*  50 */       if (cfg.spawnNitre) {
/*  51 */         addOreWithNeighbour(random, chunkX, chunkZ, world, MineFantasyBase.MFBlockOreUtil.field_71990_ca, 1, 8, 4, 0, 64, Block.field_71981_t.field_71990_ca, 0);
/*     */       }
/*  53 */       if (cfg.spawnSulfur) {
/*  54 */         addOre(random, chunkX, chunkZ, world, MineFantasyBase.MFBlockOreUtil.field_71990_ca, 2, 6, 3, 0, 16);
/*     */       }
/*     */       
/*  57 */       if (cfg.spawnCopper) {
/*  58 */         addOre(random, chunkX, chunkZ, world, MineFantasyBase.MFBlockOreCopper.field_71990_ca, 0, 8, 10, 0, 96);
/*     */       }
/*     */       
/*  61 */       if (cfg.spawnTin) {
/*  62 */         addOre(random, chunkX, chunkZ, world, MineFantasyBase.MFBlockOreTin.field_71990_ca, 0, 8, 7, 0, 96);
/*     */       }
/*     */       
/*  65 */       if (cfg.spawnMithril) {
/*  66 */         addRangedOre(random, chunkX, chunkZ, world, MineFantasyBase.MFBlockOreMythic.field_71990_ca, 0, 6, 2, 0, 16, Block.field_71981_t.field_71990_ca, cfg.mithrilDistance);
/*     */       }
/*  68 */       if (cfg.spawnDeepIron) {
/*  69 */         addOre(random, chunkX, chunkZ, world, MineFantasyBase.MFBlockOreMythic.field_71990_ca, 1, 8, 3, 0, 32);
/*     */         
/*  71 */         addOre(random, chunkX, chunkZ, world, MineFantasyBase.MFBlockOreMythic.field_71990_ca, 2, 8, 5, 0, 128, Block.field_72012_bb.field_71990_ca);
/*     */       }
/*  73 */       addOre(random, chunkX, chunkZ, world, MineFantasyBase.MFBlockOreInferno.field_71990_ca, 0, 12, 10, 0, 128, Block.field_72012_bb.field_71990_ca);
/*  74 */       addOre(random, chunkX, chunkZ, world, MineFantasyBase.MFBlockOreInferno.field_71990_ca, 1, 10, 6, 0, 64, Block.field_72012_bb.field_71990_ca);
/*     */     }
/*     */     catch (ConcurrentModificationException e) {
/*  77 */       System.err.println("MineFantasy: WorldGen Failed");
/*     */     }
/*     */   }
/*     */   
/*     */   private void addOre(Random rand, int chunkX, int chunkZ, World world, int id, int meta, int size, int abundance, int min, int max)
/*     */   {
/*  83 */     addOre(rand, chunkX, chunkZ, world, id, meta, size, abundance, min, max, Block.field_71981_t.field_71990_ca);
/*     */   }
/*     */   
/*     */   private void addOre(Random rand, int chunkX, int chunkZ, World world, int id, int meta, int size, int abundance, int min, int max, int inside) {
/*  87 */     for (int a = 0; a < abundance; a++) {
/*  88 */       int x = chunkX * 16 + rand.nextInt(16);
/*  89 */       int y = min + rand.nextInt(max - min + 1);
/*  90 */       int z = chunkZ * 16 + rand.nextInt(16);
/*  91 */       new WorldGenMinable(id, meta, size, inside).func_76484_a(world, rand, x, y, z);
/*     */     }
/*     */   }
/*     */   
/*     */   private void addRangedOre(Random rand, int chunkX, int chunkZ, World world, int id, int meta, int size, int abundance, int min, int max, int inside, double range) {
/*  96 */     for (int a = 0; a < abundance; a++) {
/*  97 */       int x = chunkX * 16 + rand.nextInt(16);
/*  98 */       int y = min + rand.nextInt(max - min + 1);
/*  99 */       int z = chunkZ * 16 + rand.nextInt(16);
/* 100 */       if (getDistance(world, x, z) > range) {
/* 101 */         new WorldGenMinable(id, meta, size, inside).func_76484_a(world, rand, x, y, z);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private double getDistance(World world, int x, int z) {
/* 107 */     ChunkCoordinates spawn = world.func_72861_E();
/*     */     
/* 109 */     int xd = x - spawn.field_71574_a;
/* 110 */     int zd = z - spawn.field_71573_c;
/*     */     
/* 112 */     if (xd < 0)
/* 113 */       xd = -xd;
/* 114 */     if (zd < 0) {
/* 115 */       zd = -zd;
/*     */     }
/* 117 */     double dist = Math.hypot(xd, zd);
/*     */     
/* 119 */     return dist;
/*     */   }
/*     */   
/*     */   private void addOreWithNeighbour(Random rand, int chunkX, int chunkZ, World world, int id, int meta, int size, int abundance, int min, int max, int inside, int neighbour) {
/* 123 */     for (int a = 0; a < abundance; a++) {
/* 124 */       int x = chunkX * 16 + rand.nextInt(16);
/* 125 */       int y = min + rand.nextInt(max - min + 1);
/* 126 */       int z = chunkZ * 16 + rand.nextInt(16);
/*     */       
/* 128 */       if (isNeibourNear(world, x, y, z, neighbour)) {
/* 129 */         if (neighbour == Block.field_71938_D.field_71990_ca) {
/* 130 */           System.out.println("Gen By Lava: " + x + " " + y + " " + z);
/*     */         }
/* 132 */         new WorldGenMinable(id, meta, size, inside).func_76484_a(world, rand, x, y, z);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean isNeibourNear(World world, int x, int y, int z, int neighbour) {
/* 138 */     return (world.func_72798_a(x - 1, y, z) == neighbour) || (world.func_72798_a(1, y, z) == neighbour) || (world.func_72798_a(x, y - 1, z) == neighbour) || (world.func_72798_a(x, y + 1, z) == neighbour) || (world.func_72798_a(x, y, z - 1) == neighbour) || (world.func_72798_a(x, y, z + 1) == neighbour);
/*     */   }
/*     */   
/*     */   public void generateMisc(Random random, int chunkX, int chunkZ, World world)
/*     */   {
/*     */     try {
/* 144 */       if (random.nextInt(100) == 0) {
/* 145 */         for (int k = 0; k < 1; k++) {
/* 146 */           int k1 = chunkX * 16 + random.nextInt(16);
/* 147 */           int k2 = random.nextInt(32);
/* 148 */           int k3 = chunkZ * 16 + random.nextInt(16);
/* 149 */           new WorldGenMinable(MineFantasyBase.MFBlockGranite.field_71990_ca, 128).func_76484_a(world, random, k1, k2, k3);
/*     */         }
/*     */       }
/*     */       
/* 153 */       if ((cfg.generateSlate) && (random.nextInt(cfg.slateSpawnRate) == 0)) {
/* 154 */         for (int k = 0; k < 1; k++) {
/* 155 */           int k1 = chunkX * 16 + random.nextInt(16);
/* 156 */           int k2 = random.nextInt(64);
/* 157 */           int k3 = chunkZ * 16 + random.nextInt(16);
/* 158 */           new WorldGenMinable(MineFantasyBase.MFBlockSlate.field_71990_ca, 0, 64, Block.field_71981_t.field_71990_ca).func_76484_a(world, random, k1, k2, k3);
/*     */         }
/*     */       }
/*     */       
/* 162 */       BiomeGenBase b = world.func_72807_a(chunkX * 16, chunkZ * 16);
/*     */       
/* 164 */       if (BiomeDictionary.isBiomeOfType(b, BiomeDictionary.Type.MOUNTAIN)) {
/* 165 */         for (int k = 0; k < 1; k++) {
/* 166 */           int k1 = chunkX * 16 + random.nextInt(16);
/* 167 */           int k2 = random.nextInt(128);
/* 168 */           int k3 = chunkZ * 16 + random.nextInt(16);
/* 169 */           new WorldGenMinable(MineFantasyBase.MFBlockGranite.field_71990_ca, 64).func_76484_a(world, random, k1, k2, k3);
/*     */         }
/*     */       }
/*     */       
/* 173 */       if (cfg.spawnIBark) {
/* 174 */         if ((BiomeDictionary.isBiomeOfType(b, BiomeDictionary.Type.JUNGLE)) && 
/* 175 */           (random.nextInt(100) < 15)) {
/* 176 */           for (int x = 0; x < 5; x++) {
/* 177 */             int Xcoord = chunkX * 16 + random.nextInt(16);
/* 178 */             int Zcoord = chunkZ * 16 + random.nextInt(16);
/* 179 */             int i2 = world.func_72976_f(Xcoord, Zcoord);
/* 180 */             new WorldGenIronbarkTree().func_76484_a(world, random, Xcoord, i2, Zcoord);
/*     */           }
/*     */         }
/*     */         
/* 184 */         if ((BiomeDictionary.isBiomeOfType(b, BiomeDictionary.Type.FOREST)) && 
/* 185 */           (random.nextInt(100) < 5)) {
/* 186 */           for (int x = 0; x < 3; x++) {
/* 187 */             int Xcoord = chunkX * 16 + random.nextInt(16);
/* 188 */             int Zcoord = chunkZ * 16 + random.nextInt(16);
/* 189 */             int i2 = world.func_72976_f(Xcoord, Zcoord);
/* 190 */             new WorldGenIronbarkTree().func_76484_a(world, random, Xcoord, i2, Zcoord);
/*     */           }
/*     */         }
/*     */       }
/* 194 */       if (cfg.spawnEbony) {
/* 195 */         if ((BiomeDictionary.isBiomeOfType(b, BiomeDictionary.Type.JUNGLE)) && 
/* 196 */           (random.nextInt(100) < 1)) {
/* 197 */           for (int x = 0; x < 1; x++) {
/* 198 */             int Xcoord = chunkX * 16 + random.nextInt(16);
/* 199 */             int Zcoord = chunkZ * 16 + random.nextInt(16);
/* 200 */             int i2 = world.func_72976_f(Xcoord, Zcoord);
/* 201 */             new WorldGenEbony(false).func_76484_a(world, random, Xcoord, i2, Zcoord);
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 206 */         if ((BiomeDictionary.isBiomeOfType(b, BiomeDictionary.Type.FOREST)) && 
/* 207 */           (random.nextInt(250) < 1)) {
/* 208 */           for (int x = 0; x < 1; x++) {
/* 209 */             int Xcoord = chunkX * 16 + random.nextInt(16);
/* 210 */             int Zcoord = chunkZ * 16 + random.nextInt(16);
/* 211 */             int i2 = world.func_72976_f(Xcoord, Zcoord);
/* 212 */             new WorldGenEbony(false).func_76484_a(world, random, Xcoord, i2, Zcoord);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 217 */       if ((BiomeDictionary.isBiomeOfType(b, BiomeDictionary.Type.WATER)) && 
/* 218 */         (random.nextInt(100) < 10)) {
/* 219 */         for (int x = 0; x < 1; x++) {
/* 220 */           int Xcoord = chunkX * 16 + random.nextInt(16);
/* 221 */           int Zcoord = chunkZ * 16 + random.nextInt(16);
/* 222 */           int i2 = world.func_72976_f(Xcoord, Zcoord);
/* 223 */           new WorldGenLimestone(4, 8, 12).func_76484_a(world, random, Xcoord, i2, Zcoord);
/*     */         }
/*     */       }
/*     */       
/* 227 */       if ((BiomeDictionary.isBiomeOfType(b, BiomeDictionary.Type.SWAMP)) && 
/* 228 */         (random.nextInt(100) < 8)) {
/* 229 */         for (int x = 0; x < 1; x++) {
/* 230 */           int Xcoord = chunkX * 16 + random.nextInt(16);
/* 231 */           int Zcoord = chunkZ * 16 + random.nextInt(16);
/* 232 */           int i2 = world.func_72976_f(Xcoord, Zcoord);
/* 233 */           new WorldGenLimestone(4, 5, 10).func_76484_a(world, random, Xcoord, i2, Zcoord);
/*     */         }
/*     */       }
/*     */       
/* 237 */       if ((BiomeDictionary.isBiomeOfType(b, BiomeDictionary.Type.BEACH)) && 
/* 238 */         (random.nextInt(100) < 5)) {
/* 239 */         for (int x = 0; x < 1; x++) {
/* 240 */           int Xcoord = chunkX * 16 + random.nextInt(16);
/* 241 */           int Zcoord = chunkZ * 16 + random.nextInt(16);
/* 242 */           int i2 = world.func_72976_f(Xcoord, Zcoord);
/* 243 */           new WorldGenLimestone(4, 4, 8).func_76484_a(world, random, Xcoord, i2, Zcoord);
/*     */         }
/*     */       }
/*     */       
/* 247 */       if ((cfg.limeCavern) && (random.nextInt(cfg.limestoneSpawnRate) == 0)) {
/* 248 */         for (int k = 0; k < 1; k++) {
/* 249 */           int k1 = chunkX * 16 + random.nextInt(16);
/* 250 */           int k2 = 32 + random.nextInt(64);
/* 251 */           int k3 = chunkZ * 16 + random.nextInt(16);
/* 252 */           new WorldGenHole(48).func_76484_a(world, random, k1, k2 + 8, k3);
/*     */           
/* 254 */           new WorldGenHole(64).func_76484_a(world, random, k1, k2, k3);
/*     */           
/* 256 */           new WorldGenMinable(MineFantasyBase.MFBlockLimestone.field_71990_ca, 128).func_76484_a(world, random, k1, k2, k3);
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (ConcurrentModificationException e) {
/* 261 */       System.err.println("MineFantasy: WorldGen Failed");
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/WorldGenMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */