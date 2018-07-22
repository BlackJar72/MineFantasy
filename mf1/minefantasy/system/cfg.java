/*     */ package minefantasy.system;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.TreeMap;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.api.armour.ArmourWeightClass;
/*     */ import net.minecraftforge.common.Configuration;
/*     */ import net.minecraftforge.common.Property;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class cfg
/*     */ {
/*  35 */   public static HashMap<Integer, Boolean> hangables = new HashMap();
/*     */   
/*     */   public static int itemId;
/*  38 */   public TreeMap<String, Property> spawnProperties = new TreeMap();
/*  39 */   public TreeMap<String, Property> achievementProperties = new TreeMap();
/*  40 */   public TreeMap<String, Property> oreGenProps = new TreeMap();
/*  41 */   public TreeMap<String, Property> statsProp = new TreeMap();
/*     */   
/*     */   public static final String CATEGORY_MOBS = "MineFantasy Mob Spawns";
/*     */   
/*     */   public static final String CATEGORY_ACHIEVEMENTS = "MineFantasy Achievements";
/*     */   
/*     */   public static final String CATEGORY_OREGENERATIONS = "MineFantasy Ore Generation";
/*     */   
/*     */   public static final String CATEGORY_STATS = "MineFantasy Statistics";
/*     */   
/*     */   public static final String CATEGORY_MISC = "MineFantasy Specifics";
/*     */   
/*     */   public static final String CATEGORY_HARDCORE = "MineFantasy Hardcore Options";
/*     */   
/*     */   public static final String CATEGORY_COMBAT = "MineFantasy Combat Options";
/*     */   
/*     */   public static final String CATEGORY_HUD = "MineFantasy HUD Positions";
/*     */   
/*     */   public static String debug;
/*     */   
/*     */   public static boolean renderWarnings;
/*     */   
/*     */   public static int lanternId;
/*     */   
/*     */   public static int forgeId;
/*     */   
/*     */   public static int anvilId;
/*     */   
/*     */   public static int mudBrickId;
/*     */   
/*     */   public static int cobbBrickId;
/*     */   
/*     */   public static int rePlanksId;
/*     */   
/*     */   public static int oreUtilId;
/*     */   
/*     */   public static int slateId;
/*     */   
/*     */   public static int clayWallId;
/*     */   
/*     */   public static int graniteId;
/*     */   
/*     */   public static int graniteBrickId;
/*     */   
/*     */   public static int leavesId;
/*     */   public static int ironbarkId;
/*     */   public static int planksId;
/*     */   public static int saplingId;
/*     */   public static int tannerId;
/*     */   public static int roadId;
/*     */   public static int totemId;
/*     */   public static int oreIgnotumiteId;
/*     */   public static int stairStoneId;
/*     */   public static int stairCStoneId;
/*     */   public static int stairCStoneRoughId;
/*     */   public static int dogbowlId;
/*     */   public static int weaponRackId;
/*     */   public static int hayRoofId;
/*     */   public static int oreCopperId;
/*     */   public static int oreTinId;
/*     */   public static int oreMithicId;
/*     */   public static int bloomId;
/*     */   public static int bellowsId;
/*     */   public static int limestoneId;
/*     */   public static int BlastId;
/*     */   public static int ProspectorOreId;
/*     */   public static int infernoId;
/*     */   public static int ovenId;
/*     */   public static int ironbarkDoorId;
/*     */   public static int hardDoorId;
/*     */   public static int steelDoorId;
/*     */   public static int storeId;
/*     */   public static int iceId;
/*     */   public static int chimId;
/*     */   public static int firepitId;
/*     */   public static int renderId;
/*     */   public static int dirtSlabDId;
/*     */   public static int dirtSlabSId;
/*     */   public static int dirtSlabDIdMF;
/*     */   public static int dirtSlabSIdMF;
/*     */   public static int WslabId;
/*     */   public static int WdSlabId;
/*     */   public static int SslabId;
/*     */   public static int SdSlabId;
/*     */   public static int tripHammerId;
/*     */   public static int slagId;
/*     */   public static int roastId;
/*     */   public static int SlslabId;
/*     */   public static int SldSlabId;
/*     */   public static int stairSlateId;
/*     */   public static int stairSlateTileId;
/*     */   public static int stairDSlateTileId;
/*     */   public static int stairSlateBrickId;
/*     */   public static int furnaceOffId;
/*     */   public static int furnaceOnId;
/*     */   public static int foodPrepId;
/*     */   public static int tailorId;
/*     */   public static int spinnerId;
/*     */   public static boolean advancedAnvil;
/*     */   public static boolean lightForge;
/*     */   public static boolean weakIron;
/*     */   public static int achCopper;
/*     */   public static int achAnvil;
/*     */   public static int achBomb;
/*     */   public static int achTin;
/*     */   public static int achAlloy;
/*     */   public static int achBronze;
/*     */   public static int achSuperore;
/*     */   public static int achDragon;
/*     */   public static int achDragoningot;
/*     */   public static int achTriplekill;
/*     */   public static int achTanner;
/*     */   public static int achPlate;
/*     */   public static int achArrow;
/*     */   public static int achIron;
/*     */   public static int achGranite;
/*     */   public static int achForge;
/*     */   public static int achSteel;
/*     */   public static int achMithril;
/*     */   public static int achEncrust;
/*     */   public static int entityIDBase;
/*     */   public static int minotaurSpawnrate;
/*     */   public static int knightSpawnrate;
/*     */   public static int houndSpawnrate;
/*     */   public static int drakeSpawnrate;
/*     */   public static int basilSpawnrate;
/*     */   public static int basilSpawnrateNether;
/*     */   public static int dragonDiff;
/*     */   public static int minoDiff;
/*     */   public static int knightDiff;
/*     */   public static int knightLvl;
/*     */   public static boolean mobTime;
/*     */   public static int minotaurWeaponDist;
/*     */   public static int titanDist;
/*     */   public static int dragonDistance;
/*     */   public static int drakeDistance;
/*     */   public static int basiliskDistance;
/*     */   public static int dragonSpawnrateNether;
/*     */   public static boolean dragonGrief;
/*     */   public static boolean houndKillMan;
/*     */   public static boolean houndNoFire;
/*     */   public static boolean hungryHound;
/*     */   public static boolean starveHound;
/*     */   public static boolean dropMutton;
/*     */   public static int dragonChance;
/*     */   public static boolean spawnSilver;
/*     */   public static boolean spawnNitre;
/*     */   public static boolean spawnSulfur;
/*     */   public static boolean spawnCopper;
/*     */   public static boolean spawnTin;
/*     */   public static boolean spawnMithril;
/*     */   public static boolean spawnDeepIron;
/*     */   public static boolean spawnIgnot;
/*     */   public static boolean spawnIBark;
/*     */   public static boolean spawnEbony;
/*     */   public static boolean spawnHerb;
/*     */   public static boolean limeCavern;
/*     */   public static boolean generateSlate;
/*     */   public static double mithrilDistance;
/*     */   public static int slateSpawnRate;
/*     */   public static int limestoneSpawnRate;
/*     */   public static int statDragons;
/* 203 */   public static boolean hitSound = true;
/* 204 */   public static boolean burnPlayer = true;
/*     */   
/*     */   public static boolean heavyBonus;
/*     */   
/*     */   public static boolean useBalance;
/*     */   
/*     */   public static boolean renderHot;
/*     */   
/*     */   public static boolean hardcoreCraft;
/*     */   
/*     */   public static boolean hardcoreHafts;
/*     */   public static boolean easyBlooms;
/*     */   public static boolean easyIron;
/*     */   public static boolean hardcoreLeather;
/*     */   public static boolean hardcoreFurnace;
/*     */   public static boolean hardcoreObsidianForge;
/*     */   public static boolean regen;
/*     */   public static boolean redstoneHammer;
/*     */   public static int regenLayer;
/*     */   public static int maxHeat;
/*     */   public static double dryRocksChance;
/*     */   public static boolean disableWeight;
/*     */   public static boolean easyTameHound;
/*     */   public static int HoundBreed;
/*     */   public static boolean durableArrows;
/*     */   public static boolean disableFirebomb;
/*     */   public static int craftMetreY;
/*     */   public static int craftMetreX;
/*     */   public static boolean disableHUD;
/*     */   public static int basiliskMax;
/*     */   private Configuration config;
/*     */   
/*     */   public void setConfig(Configuration configuration)
/*     */   {
/* 238 */     configuration.load();
/* 239 */     this.config = configuration;
/* 240 */     debug = configuration.get("MineFantasy Specifics", "Debug Mode: (Requires Serial): ", "").getString();
/* 241 */     renderWarnings = Boolean.parseBoolean(get("Display block renderer alerts (These will spam the chat until resolved)", "MineFantasy Specifics", false).getString());
/*     */     
/*     */ 
/* 244 */     itemId = Integer.parseInt(get("Item Base Id", "item", 1250).getString());
/* 245 */     lanternId = Integer.parseInt(get("Lantern", "block", 180).getString());
/* 246 */     forgeId = Integer.parseInt(get("Forge", "block", 181).getString());
/* 247 */     anvilId = Integer.parseInt(get("Anvil", "block", 182).getString());
/* 248 */     mudBrickId = Integer.parseInt(get("Mud Bricks", "block", 183).getString());
/* 249 */     cobbBrickId = Integer.parseInt(get("Cobblestone Bricks", "block", 184).getString());
/* 250 */     rePlanksId = Integer.parseInt(get("Reinforced Planks", "block", 185).getString());
/* 251 */     oreUtilId = Integer.parseInt(get("Silver Ore", "block", 186).getString());
/* 252 */     slateId = Integer.parseInt(get("Slate Block", "block", 187).getString());
/* 253 */     clayWallId = Integer.parseInt(get("Clay Wall", "block", 188).getString());
/* 254 */     graniteId = Integer.parseInt(get("Granite", "block", 189).getString());
/* 255 */     graniteBrickId = Integer.parseInt(get("Granite Bricks", "block", 190).getString());
/* 256 */     leavesId = Integer.parseInt(get("Leaves", "block", 191).getString());
/* 257 */     ironbarkId = Integer.parseInt(get("Ironbark", "block", 192).getString());
/* 258 */     planksId = Integer.parseInt(get("Planks", "block", 193).getString());
/* 259 */     saplingId = Integer.parseInt(get("Sapling", "block", 194).getString());
/* 260 */     tannerId = Integer.parseInt(get("Tanning Rack", "block", 195).getString());
/* 261 */     roadId = Integer.parseInt(get("Road", "block", 196).getString());
/* 262 */     dogbowlId = Integer.parseInt(get("Dog Bowl", "block", 197).getString());
/* 263 */     totemId = Integer.parseInt(get("Totem", "block", 198).getString());
/* 264 */     oreIgnotumiteId = Integer.parseInt(get("Ignotumite ore", "block", 199).getString());
/* 265 */     stairStoneId = Integer.parseInt(get("Stone Stairs", "block", 200).getString());
/* 266 */     stairCStoneId = Integer.parseInt(get("Cobblestone Brick Stairs", "block", 201).getString());
/* 267 */     weaponRackId = Integer.parseInt(get("Weapon Rack", "block", 202).getString());
/* 268 */     hayRoofId = Integer.parseInt(get("Hay Roof", "block", 203).getString());
/* 269 */     oreCopperId = Integer.parseInt(get("Copper Ore", "block", 205).getString());
/* 270 */     oreTinId = Integer.parseInt(get("Tin Ore", "block", 206).getString());
/* 271 */     oreMithicId = Integer.parseInt(get("Mithril Ore", "block", 207).getString());
/* 272 */     bloomId = Integer.parseInt(get("Bloom", "block", 208).getString());
/* 273 */     bellowsId = Integer.parseInt(get("Bellows", "block", 209).getString());
/* 274 */     limestoneId = Integer.parseInt(get("Limestone", "block", 210).getString());
/* 275 */     BlastId = Integer.parseInt(get("Blast Furnace Blocks", "block", 211).getString());
/* 276 */     ProspectorOreId = Integer.parseInt(get("Hidden Ore Block", "block", 212).getString());
/* 277 */     infernoId = Integer.parseInt(get("Inferno Coal Ore", "block", 213).getString());
/* 278 */     ovenId = Integer.parseInt(get("Oven", "block", 214).getString());
/* 279 */     ironbarkDoorId = Integer.parseInt(get("Ironbark Door", "block", 215).getString());
/* 280 */     hardDoorId = Integer.parseInt(get("Reinforced Door", "block", 216).getString());
/* 281 */     steelDoorId = Integer.parseInt(get("Steel Door", "block", 217).getString());
/* 282 */     storeId = Integer.parseInt(get("Storage Block", "block", 219).getString());
/* 283 */     iceId = Integer.parseInt(get("Ice Block", "block", 220).getString());
/* 284 */     chimId = Integer.parseInt(get("Chimney Block", "block", 221).getString());
/* 285 */     dirtSlabDId = Integer.parseInt(get("Dirt Slab", "block", 222).getString());
/* 286 */     dirtSlabSId = Integer.parseInt(get("Dirt Single Slab", "block", 223).getString());
/* 287 */     dirtSlabDIdMF = Integer.parseInt(get("MF Dirt Slab", "block", 224).getString());
/* 288 */     dirtSlabSIdMF = Integer.parseInt(get("MF Dirt Single Slab", "block", 225).getString());
/* 289 */     firepitId = Integer.parseInt(get("Firepit", "block", 226).getString());
/*     */     
/* 291 */     WslabId = Integer.parseInt(get("Single Wood Slab", "block", 227).getString());
/* 292 */     WdSlabId = Integer.parseInt(get("Double Wood Slab", "block", 228).getString());
/* 293 */     SslabId = Integer.parseInt(get("Single Stone Slab", "block", 229).getString());
/* 294 */     SdSlabId = Integer.parseInt(get("Double Stone Slab", "block", 230).getString());
/* 295 */     tripHammerId = Integer.parseInt(get("Trip Hammer", "block", 231).getString());
/* 296 */     slagId = Integer.parseInt(get("Slag", "block", 232).getString());
/* 297 */     roastId = Integer.parseInt(get("Spit Roast", "block", 233).getString());
/* 298 */     SlslabId = Integer.parseInt(get("Single Slate Slab", "block", 234).getString());
/* 299 */     SldSlabId = Integer.parseInt(get("Double Slate Slab", "block", 235).getString());
/*     */     
/* 301 */     stairSlateId = Integer.parseInt(get("Slate Stairs", "block", 236).getString());
/* 302 */     stairSlateTileId = Integer.parseInt(get("Slate Tile Stairs", "block", 237).getString());
/* 303 */     stairDSlateTileId = Integer.parseInt(get("Diagonal Slate Tile Stairs", "block", 238).getString());
/* 304 */     stairSlateBrickId = Integer.parseInt(get("Slate Brick Stairs", "block", 239).getString());
/*     */     
/* 306 */     furnaceOffId = Integer.parseInt(get("Furnace Block Inactive", "block", 240).getString());
/* 307 */     furnaceOnId = Integer.parseInt(get("Furnace Block Active", "block", 241).getString());
/* 308 */     foodPrepId = Integer.parseInt(get("Benchtop", "block", 242).getString());
/* 309 */     tailorId = Integer.parseInt(get("Tailor Bench", "block", 243).getString());
/* 310 */     spinnerId = Integer.parseInt(get("Spinning Wheel", "block", 244).getString());
/*     */     
/* 312 */     stairCStoneRoughId = Integer.parseInt(get("Rough Cobblestone Brick Stairs", "block", 245).getString());
/*     */     
/* 314 */     renderId = Integer.parseInt(get("Render ID", "block", 200).getString());
/* 315 */     advancedAnvil = Boolean.parseBoolean(get("Advanced Forging", "block", true).getString());
/* 316 */     lightForge = Boolean.parseBoolean(get("Forges need to be lit", "block", true).getString());
/*     */     
/* 318 */     achCopper = Integer.parseInt(get("CopperAgeAchievementId", "MineFantasy Achievements", 500).getString());
/* 319 */     achAnvil = Integer.parseInt(get("AnvilAchievementId", "MineFantasy Achievements", 501).getString());
/* 320 */     achBomb = Integer.parseInt(get("BombAchievementId", "MineFantasy Achievements", 502).getString());
/* 321 */     achTin = Integer.parseInt(get("TinAchievementId", "MineFantasy Achievements", 503).getString());
/* 322 */     achAlloy = Integer.parseInt(get("AlloyAchievementId", "MineFantasy Achievements", 504).getString());
/* 323 */     achBronze = Integer.parseInt(get("BronzeAgeAchievementId", "MineFantasy Achievements", 505).getString());
/* 324 */     achSuperore = Integer.parseInt(get("IgnotumiteAchievementId", "MineFantasy Achievements", 506).getString());
/* 325 */     achDragon = Integer.parseInt(get("DragonslayerAchievementId", "MineFantasy Achievements", 507).getString());
/* 326 */     achDragoningot = Integer.parseInt(get("DragonforgerAchievementId", "MineFantasy Achievements", 508).getString());
/* 327 */     achTriplekill = Integer.parseInt(get("TripleKillAchievementId", "MineFantasy Achievements", 509).getString());
/* 328 */     achTanner = Integer.parseInt(get("TannerAchievementId", "MineFantasy Achievements", 510).getString());
/* 329 */     achPlate = Integer.parseInt(get("PlateAchievementId", "MineFantasy Achievements", 511).getString());
/* 330 */     achArrow = Integer.parseInt(get("ArrowAchievementId", "MineFantasy Achievements", 512).getString());
/* 331 */     achIron = Integer.parseInt(get("IronAgeAchievementId", "MineFantasy Achievements", 513).getString());
/* 332 */     achGranite = Integer.parseInt(get("GraniteAchievementId", "MineFantasy Achievements", 514).getString());
/* 333 */     achForge = Integer.parseInt(get("BlacksmithAchievementId", "MineFantasy Achievements", 515).getString());
/* 334 */     achSteel = Integer.parseInt(get("SteelAgeAchievementId", "MineFantasy Achievements", 516).getString());
/* 335 */     achMithril = Integer.parseInt(get("MithrilAchievementId", "MineFantasy Achievements", 517).getString());
/* 336 */     achEncrust = Integer.parseInt(get("EncrustedAchievementId", "MineFantasy Achievements", 518).getString());
/*     */     
/*     */ 
/* 339 */     entityIDBase = Integer.parseInt(get("Base Entity ID", "MineFantasy Mob Spawns", 400).getString());
/*     */     
/* 341 */     houndSpawnrate = Integer.parseInt(get("Hound Spawn Rate", "MineFantasy Mob Spawns", 4).getString());
/* 342 */     minotaurSpawnrate = Integer.parseInt(get("Minotaur Spawn Rate", "MineFantasy Mob Spawns", 5).getString());
/* 343 */     knightSpawnrate = Integer.parseInt(get("Skeletal Knight Spawn Rate", "MineFantasy Mob Spawns", 3).getString());
/* 344 */     drakeSpawnrate = Integer.parseInt(get("Drake Spawn Rate", "MineFantasy Mob Spawns", 2).getString());
/* 345 */     dragonSpawnrateNether = Integer.parseInt(get("Small Dragon Nether Spawn Rate", "MineFantasy Mob Spawns", 1).getString());
/* 346 */     dragonGrief = Boolean.parseBoolean(get("Dragons Spread fire/Break blocks", "MineFantasy Mob Spawns", true).getString());
/* 347 */     houndKillMan = Boolean.parseBoolean(get("Hounds Attack Villagers", "MineFantasy Mob Spawns", true).getString());
/* 348 */     houndNoFire = Boolean.parseBoolean(get("Prevent Hound Fire Death", "MineFantasy Mob Spawns", true).getString());
/* 349 */     hungryHound = Boolean.parseBoolean(get("Hounds Get Hungry", "MineFantasy Mob Spawns", true).getString());
/* 350 */     starveHound = Boolean.parseBoolean(get("Hounds starve to death", "MineFantasy Mob Spawns", true).getString());
/* 351 */     dropMutton = Boolean.parseBoolean(get("Sheep drop Mutton", "MineFantasy Mob Spawns", true).getString());
/* 352 */     basilSpawnrate = Integer.parseInt(get("Basillisk Spawn Rate", "MineFantasy Mob Spawns", 2).getString());
/* 353 */     basilSpawnrateNether = Integer.parseInt(get("Nether Basillisk Spawn Rate", "MineFantasy Mob Spawns", 6).getString());
/*     */     
/* 355 */     minotaurWeaponDist = Integer.parseInt(get("Minotaur weapon spawn distance", "MineFantasy Mob Spawns", 1000).getString());
/* 356 */     titanDist = Integer.parseInt(get("Minotaur Titan Spawn distance", "MineFantasy Mob Spawns", 2000).getString());
/* 357 */     dragonDistance = Integer.parseInt(get("Dragon spawn min distance", "MineFantasy Mob Spawns", 2000).getString());
/* 358 */     drakeDistance = Integer.parseInt(get("Drake spawn min distance", "MineFantasy Mob Spawns", 1800).getString());
/* 359 */     basiliskDistance = Integer.parseInt(get("Basilisk spawn min distance", "MineFantasy Mob Spawns", 2500).getString());
/*     */     
/* 361 */     minoDiff = Integer.parseInt(get("Minotaur Spawn Difficulty", "MineFantasy Mob Spawns", 2).getString());
/* 362 */     knightDiff = Integer.parseInt(get("Skeletal Knight Spawn Difficulty", "MineFantasy Mob Spawns", 2).getString());
/* 363 */     knightLvl = Integer.parseInt(get("Minimal Xp level for skeletal knights", "MineFantasy Mob Spawns", 35).getString());
/* 364 */     dragonDiff = Integer.parseInt(get("Small Dragon Spawn Difficulty", "MineFantasy Mob Spawns", 2).getString());
/*     */     
/* 366 */     dragonChance = Integer.parseInt(get("(1 in X)Small Dragon Spawn Chance", "MineFantasy Mob Spawns", 4000).getString());
/*     */     
/* 368 */     easyTameHound = Boolean.parseBoolean(get("Easy Tame Hounds", "general", false).getString());
/* 369 */     HoundBreed = Integer.parseInt(get("Hound Breed Difficulty(must be +) Higher = harder", "general", 10).getString());
/* 370 */     durableArrows = Boolean.parseBoolean(get("Arrows don't always break", "general", true).getString());
/* 371 */     disableFirebomb = Boolean.parseBoolean(get("Disable Fire Bomb Grief", "general", false).getString());
/*     */     
/*     */ 
/* 374 */     spawnSilver = Boolean.parseBoolean(get("Generate Silver Ore", "MineFantasy Ore Generation", true).getString());
/* 375 */     spawnNitre = Boolean.parseBoolean(get("Generate Nitre Ore", "MineFantasy Ore Generation", true).getString());
/* 376 */     spawnSulfur = Boolean.parseBoolean(get("Generate Sulfur Ore", "MineFantasy Ore Generation", true).getString());
/*     */     
/* 378 */     spawnCopper = Boolean.parseBoolean(get("Generate Copper Ore", "MineFantasy Ore Generation", true).getString());
/* 379 */     spawnTin = Boolean.parseBoolean(get("Generate Tin Ore", "MineFantasy Ore Generation", true).getString());
/* 380 */     spawnMithril = Boolean.parseBoolean(get("Generate Mithril Ore", "MineFantasy Ore Generation", true).getString());
/* 381 */     spawnDeepIron = Boolean.parseBoolean(get("Generate Deep Iron Ore", "MineFantasy Ore Generation", true).getString());
/* 382 */     spawnIgnot = Boolean.parseBoolean(get("Generate Ignotumite Ore", "MineFantasy Ore Generation", true).getString());
/*     */     
/* 384 */     spawnIBark = Boolean.parseBoolean(get("Generate Ironbark", "MineFantasy Ore Generation", true).getString());
/* 385 */     spawnEbony = Boolean.parseBoolean(get("Generate Ebony", "MineFantasy Ore Generation", true).getString());
/*     */     
/* 387 */     limeCavern = Boolean.parseBoolean(get("Generate Limestone Cavern", "MineFantasy Ore Generation", true).getString());
/* 388 */     generateSlate = Boolean.parseBoolean(get("Generate Slate", "MineFantasy Ore Generation", true).getString());
/* 389 */     mithrilDistance = Double.parseDouble(get("Mithril Min Distance", "MineFantasy Ore Generation", 1000.0D).getString());
/* 390 */     slateSpawnRate = Integer.parseInt(get("Slate Spawn Rate, lower is more (Default: 75)", "MineFantasy Ore Generation", 75).getString());
/* 391 */     limestoneSpawnRate = Integer.parseInt(get("Limestone Spawn Rate, lower is more (Default: 480)", "MineFantasy Ore Generation", 480).getString());
/*     */     
/*     */ 
/* 394 */     statDragons = Integer.parseInt(get("Dragons Slain Stat Id", "general", 5000).getString());
/*     */     
/*     */ 
/* 397 */     useBalance = Boolean.parseBoolean(get("Heavy Weapon balance offset", "MineFantasy Combat Options", true).getString());
/* 398 */     heavyBonus = Boolean.parseBoolean(get("Heavy Weapon combat bonus", "MineFantasy Combat Options", false).getString());
/* 399 */     renderHot = Boolean.parseBoolean(get("Dynamic Hot Ingot Rendering", "general", true).getString());
/* 400 */     weakIron = Boolean.parseBoolean(get("Mine Iron with stone (Not recommended, ruins bronze tiering)", "general", false).getString());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 407 */     maxHeat = Integer.parseInt(get("Maximum Metal Heat(Celcius): The point where ingot rendering hits yellow", "general", 1400).getString());
/* 408 */     dryRocksChance = Double.parseDouble(get("Dry Rocks Success chance(As a decimal: 1 = 100% 0.5 = 50%)", "MineFantasy Specifics", 0.1D).getString());
/* 409 */     redstoneHammer = Boolean.parseBoolean(get("Automatic Trip hammer with Redstone", "general", true).getString());
/* 410 */     hitSound = Boolean.parseBoolean(get("Weapon Hit Sound", "MineFantasy Combat Options", true).getString());
/* 411 */     burnPlayer = Boolean.parseBoolean(get("Hot Items Burn Player", "general", true).getString());
/*     */     
/* 413 */     disableWeight = Boolean.parseBoolean(get("Disable Armour weight slowing (This will break the armour tiering, and make nearly all armours obsolete!)", "general", false).getString());
/*     */     
/* 415 */     loadArmoursFromList(0, configuration.get("MineFantasy Combat Options", "Light Armour list (put the ID and : after each eg. id1:id2:id3:id4: )", "").getString(), "Light Armour list");
/* 416 */     loadArmoursFromList(1, configuration.get("MineFantasy Combat Options", "Medium Armour list (put the ID and : after each eg. id1:id2:id3:id4: )", "").getString(), "Medium Armour list");
/* 417 */     loadArmoursFromList(2, configuration.get("MineFantasy Combat Options", "Heavy Armour list (put the ID and : after each eg. id1:id2:id3:id4: )", "").getString(), "Heavy Armour list");
/* 418 */     loadArmoursFromList(3, configuration.get("MineFantasy Combat Options", "Plate Armour list (put the ID and : after each eg. id1:id2:id3:id4: )", "").getString(), "Plate Armour list");
/*     */     
/* 420 */     loadHangablesFromList(configuration.get("MineFantasy Specifics", "Hangable Item list (put the ID and : after each eg. id1:id2:id3:id4: )", "").getString());
/*     */     
/* 422 */     craftMetreX = Integer.parseInt(get("Craft Metre X Pos (from crosshair)", "MineFantasy HUD Positions", 0).getString());
/* 423 */     craftMetreY = Integer.parseInt(get("Craft Metre Y Pos (from bottom)", "MineFantasy HUD Positions", 69).getString());
/* 424 */     disableHUD = Boolean.parseBoolean(get("Disable Craft HUD", "MineFantasy HUD Positions", false).getString());
/*     */     
/* 426 */     basiliskMax = Integer.parseInt(get("Max basilisk meat buff (each 1.0 = half heart): default 60(30hearts)", "MineFantasy Specifics", 60).getString());
/*     */     
/*     */ 
/* 429 */     hardcoreCraft = Boolean.parseBoolean(get("Hardcore Crafting", "MineFantasy Hardcore Options", true).getString());
/* 430 */     hardcoreLeather = Boolean.parseBoolean(get("Hardcore Leather Tanning", "MineFantasy Hardcore Options", false).getString());
/* 431 */     hardcoreFurnace = Boolean.parseBoolean(get("Remove Basic Furnace Recipe", "MineFantasy Hardcore Options", true).getString());
/* 432 */     easyBlooms = Boolean.parseBoolean(get("Easy Bloomery Smelts", "MineFantasy Hardcore Options", false).getString());
/* 433 */     easyIron = Boolean.parseBoolean(get("Simple Iron Smelting", "MineFantasy Hardcore Options", false).getString());
/* 434 */     hardcoreHafts = Boolean.parseBoolean(get("Hardcore Hafts", "MineFantasy Hardcore Options", true).getString());
/* 435 */     hardcoreObsidianForge = Boolean.parseBoolean(get("Hardcore Obsidian Forges", "MineFantasy Hardcore Options", true).getString());
/*     */     
/* 437 */     configuration.save();
/*     */   }
/*     */   
/*     */   public Property get(String string, String category, int i) {
/* 441 */     return this.config.get(category, string, i);
/*     */   }
/*     */   
/*     */   public Property get(String string, String category, double i) {
/* 445 */     return this.config.get(category, string, i);
/*     */   }
/*     */   
/*     */   public Property get(String string, String category, boolean i) {
/* 449 */     return this.config.get(category, string, i);
/*     */   }
/*     */   
/*     */   public Property get(String string, String category, String i) {
/* 453 */     return this.config.get(category, string, i);
/*     */   }
/*     */   
/*     */   private static void loadArmoursFromList(int tier, String str, String type) {
/* 457 */     if (MineFantasyBase.isDebug()) {
/* 458 */       System.out.println("MineFantasy: Loading Config List for " + type);
/*     */     }
/*     */     try {
/* 461 */       String temp = "";
/* 462 */       for (int a = 0; a < str.length(); a++) {
/* 463 */         if (a == str.length() - 1) {
/* 464 */           temp = temp + str.charAt(a);
/*     */         }
/* 466 */         if ((str.charAt(a) == ":".charAt(0)) || (a == str.length() - 1)) {
/* 467 */           int i = Integer.valueOf(temp).intValue();
/* 468 */           ArmourWeightClass.configArmours.put(Integer.valueOf(i), Integer.valueOf(tier));
/* 469 */           if (MineFantasyBase.isDebug()) {
/* 470 */             System.out.println("MineFantasy: Added Id " + i + " to " + type);
/*     */           }
/* 472 */           temp = "";
/*     */         }
/* 474 */         else if (str.charAt(a) != " ".charAt(0)) {
/* 475 */           temp = temp + str.charAt(a);
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 480 */       System.out.println("MineFantasy: Failed to load config list: Make sure each number is followed by a : ");
/*     */     }
/*     */   }
/*     */   
/*     */   private static void loadHangablesFromList(String str) {
/* 485 */     String type = "Hangable Item Renders";
/*     */     
/* 487 */     if (MineFantasyBase.isDebug()) {
/* 488 */       System.out.println("MineFantasy: Loading Config List for " + type);
/*     */     }
/*     */     try {
/* 491 */       String temp = "";
/* 492 */       for (int a = 0; a < str.length(); a++) {
/* 493 */         if (a == str.length() - 1) {
/* 494 */           temp = temp + str.charAt(a);
/*     */         }
/* 496 */         if ((str.charAt(a) == ":".charAt(0)) || (a == str.length() - 1)) {
/* 497 */           int i = Integer.valueOf(temp).intValue();
/* 498 */           hangables.put(Integer.valueOf(i), Boolean.valueOf(true));
/* 499 */           if (MineFantasyBase.isDebug()) {
/* 500 */             System.out.println("MineFantasy: Added Id " + i + " to " + type);
/*     */           }
/* 502 */           temp = "";
/*     */         }
/* 504 */         else if (str.charAt(a) != " ".charAt(0)) {
/* 505 */           temp = temp + str.charAt(a);
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 510 */       System.out.println("MineFantasy: Failed to load config list: Make sure each number is followed by a : ");
/*     */     }
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
/*     */ 
/*     */   public static boolean canRenderHung(int id)
/*     */   {
/* 532 */     if ((!hangables.isEmpty()) && (hangables.containsKey(Integer.valueOf(id)))) {
/* 533 */       return ((Boolean)hangables.get(Integer.valueOf(id))).booleanValue();
/*     */     }
/* 535 */     return false;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/cfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */