/*     */ package minefantasy.system;
/*     */ 
/*     */ import cpw.mods.fml.common.registry.EntityRegistry;
/*     */ import java.awt.Color;
/*     */ import java.io.PrintStream;
/*     */ import java.util.HashMap;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.entity.EntityBasilisk;
/*     */ import minefantasy.entity.EntityDragonSmall;
/*     */ import minefantasy.entity.EntityDrake;
/*     */ import minefantasy.entity.EntityHound;
/*     */ import minefantasy.entity.EntityMinotaur;
/*     */ import minefantasy.entity.EntityRockSling;
/*     */ import minefantasy.entity.EntityShrapnel;
/*     */ import minefantasy.entity.EntitySkeletalKnight;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EnumCreatureType;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraftforge.common.BiomeDictionary;
/*     */ import net.minecraftforge.common.BiomeDictionary.Type;
/*     */ 
/*     */ public class EntitylistMF
/*     */ {
/*     */   public static int IDBase;
/*     */   
/*     */   public static void registerEntity()
/*     */   {
/*  30 */     IDBase = cfg.entityIDBase;
/*  31 */     addEntity(EntityHound.class, "HoundMF", Color.WHITE.hashCode(), MineFantasyBase.getColourForRGB(128, 64, 0));
/*  32 */     addEntity(EntityMinotaur.class, "Minotaur", MineFantasyBase.getColourForRGB(70, 50, 28), Color.BLACK.hashCode());
/*  33 */     addEntity(EntitySkeletalKnight.class, "SkeletalKnight", Color.GRAY.hashCode(), MineFantasyBase.getColourForRGB(100, 70, 70));
/*  34 */     addEntity(EntityDragonSmall.class, "SmallDragon", Color.RED.hashCode(), MineFantasyBase.getColourForRGB(221, 218, 164));
/*  35 */     addEntity(EntityDrake.class, "Drake", Color.GREEN.hashCode(), MineFantasyBase.getColourForRGB(221, 218, 164));
/*  36 */     addEntity(EntityBasilisk.class, "Basilisk", Color.BLUE.hashCode(), MineFantasyBase.getColourForRGB(221, 218, 164));
/*     */     
/*  38 */     EntityRegistry.registerModEntity(minefantasy.entity.EntityBombThrown.class, "MFBomb", IDBase, MineFantasyBase.instance, 64, 1, true);
/*  39 */     IDBase += 1;
/*  40 */     EntityRegistry.registerModEntity(minefantasy.entity.EntityFirebreath.class, "fireBreath", IDBase, MineFantasyBase.instance, 64, 20, true);
/*  41 */     IDBase += 1;
/*  42 */     EntityRegistry.registerModEntity(minefantasy.entity.EntityArrowMF.class, "arrowMF", IDBase, MineFantasyBase.instance, 64, 20, false);
/*  43 */     IDBase += 1;
/*  44 */     EntityRegistry.registerModEntity(minefantasy.entity.EntityBoltMF.class, "boltMF", IDBase, MineFantasyBase.instance, 64, 20, false);
/*  45 */     IDBase += 1;
/*  46 */     EntityRegistry.registerModEntity(minefantasy.entity.EntityThrownSpear.class, "MFSpear", IDBase, MineFantasyBase.instance, 64, 20, false);
/*  47 */     IDBase += 1;
/*  48 */     EntityRegistry.registerModEntity(EntityRockSling.class, "MFRock", IDBase, MineFantasyBase.instance, 64, 1, false);
/*  49 */     IDBase += 1;
/*  50 */     EntityRegistry.registerModEntity(EntityShrapnel.class, "shrapnelMF", IDBase, MineFantasyBase.instance, 64, 1, false);
/*  51 */     IDBase += 1;
/*     */     
/*  53 */     EntityRegistry.addSpawn(EntityHound.class, cfg.houndSpawnrate / 2, 3, 3, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.field_76767_f });
/*  54 */     EntityRegistry.addSpawn(EntityHound.class, cfg.houndSpawnrate / 2, 3, 3, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.field_76785_t });
/*  55 */     EntityRegistry.addSpawn(EntityHound.class, cfg.houndSpawnrate / 3, 3, 3, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.field_76782_w });
/*  56 */     EntityRegistry.addSpawn(EntityHound.class, cfg.houndSpawnrate / 3, 3, 3, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.field_76792_x });
/*  57 */     EntityRegistry.addSpawn(EntityDrake.class, cfg.drakeSpawnrate, 1, 3, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.field_76772_c });
/*  58 */     EntityRegistry.addSpawn(EntityDrake.class, cfg.drakeSpawnrate, 2, 2, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.field_76783_v });
/*  59 */     EntityRegistry.addSpawn(EntityDrake.class, cfg.drakeSpawnrate, 2, 4, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.field_76770_e });
/*     */     
/*  61 */     addSpawn(EntityHound.class, cfg.houndSpawnrate, 3, 5, EnumCreatureType.creature, BiomeDictionary.Type.FOREST);
/*  62 */     addSpawn(EntityDrake.class, cfg.drakeSpawnrate, 1, 3, EnumCreatureType.creature, BiomeDictionary.Type.PLAINS);
/*     */     
/*  64 */     addSpawn(EntitySkeletalKnight.class, cfg.knightSpawnrate, 1, 1, EnumCreatureType.monster);
/*  65 */     addSpawn(EntityMinotaur.class, cfg.minotaurSpawnrate, 1, 2, EnumCreatureType.monster);
/*  66 */     addSpawn(EntityDragonSmall.class, 1, 1, 1, EnumCreatureType.creature, BiomeDictionary.Type.MOUNTAIN);
/*     */     
/*  68 */     addSpawn(EntityBasilisk.class, cfg.basilSpawnrate, 1, 1, EnumCreatureType.monster);
/*  69 */     addSpawn(EntityBasilisk.class, cfg.basilSpawnrateNether, 1, 1, EnumCreatureType.monster, BiomeDictionary.Type.NETHER);
/*     */     
/*  71 */     addSpawn(EntityMinotaur.class, cfg.minotaurSpawnrate * 5, 2, 8, EnumCreatureType.monster, BiomeDictionary.Type.NETHER);
/*  72 */     addSpawn(EntityDragonSmall.class, cfg.dragonSpawnrateNether, 1, 2, EnumCreatureType.monster, BiomeDictionary.Type.NETHER);
/*  73 */     addSpawn(EntityDragonSmall.class, 2, 1, 1, EnumCreatureType.monster, BiomeDictionary.Type.MOUNTAIN);
/*     */   }
/*     */   
/*     */   private static void addEntity(Class<? extends Entity> entityClass, String entityName, int eggColor, int eggDotsColor)
/*     */   {
/*  78 */     if (MineFantasyBase.isDebug()) {
/*  79 */       System.out.println("MineFantasy: registerEntity " + entityClass + " with Mod ID " + IDBase);
/*     */     }
/*  81 */     EntityRegistry.registerModEntity(entityClass, entityName, IDBase, MineFantasyBase.instance, 128, 1, true);
/*  82 */     EntityList.field_75627_a.put(Integer.valueOf(IDBase), new net.minecraft.entity.EntityEggInfo(IDBase, eggColor, eggDotsColor));
/*     */     
/*  84 */     EntityList.func_75618_a(entityClass, entityName, IDBase);
/*  85 */     IDBase += 1;
/*     */   }
/*     */   
/*     */   public static void addSpawn(Class<? extends EntityLiving> entityClass, int weightedProb, int min, int max, EnumCreatureType typeOfCreature) {
/*  89 */     for (BiomeGenBase biome : BiomeGenBase.field_76773_a) {
/*  90 */       if (biome != null) {
/*  91 */         if (BiomeDictionary.isBiomeRegistered(biome)) {
/*  92 */           if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.END)) {
/*  93 */             return;
/*     */           }
/*  95 */           if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.NETHER)) {
/*  96 */             return;
/*     */           }
/*  98 */           if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.MUSHROOM)) {
/*  99 */             return;
/*     */           }
/*     */         }
/*     */         
/* 103 */         EntityRegistry.addSpawn(entityClass, weightedProb, min, max, typeOfCreature, new BiomeGenBase[] { biome });
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static void addSpawn(Class<? extends EntityLiving> entityClass, int weightedProb, int min, int max, EnumCreatureType typeOfCreature, BiomeDictionary.Type type) {
/* 109 */     for (BiomeGenBase biome : BiomeGenBase.field_76773_a) {
/* 110 */       if ((biome != null) && 
/* 111 */         (BiomeDictionary.isBiomeRegistered(biome)) && 
/* 112 */         (BiomeDictionary.isBiomeOfType(biome, type))) {
/* 113 */         EntityRegistry.addSpawn(entityClass, weightedProb, min, max, typeOfCreature, new BiomeGenBase[] { biome });
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/EntitylistMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */