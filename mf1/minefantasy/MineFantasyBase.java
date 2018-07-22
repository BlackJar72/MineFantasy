/*     */ package minefantasy;
/*     */ 
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.Mod;
/*     */ import cpw.mods.fml.common.Mod.EventHandler;
/*     */ import cpw.mods.fml.common.Mod.Instance;
/*     */ import cpw.mods.fml.common.SidedProxy;
/*     */ import cpw.mods.fml.common.event.FMLInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLPostInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*     */ import cpw.mods.fml.common.network.NetworkMod;
/*     */ import cpw.mods.fml.common.network.NetworkRegistry;
/*     */ import cpw.mods.fml.common.registry.GameRegistry;
/*     */ import cpw.mods.fml.common.registry.TickRegistry;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import java.io.PrintStream;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import minefantasy.api.MineFantasyAPI;
/*     */ import minefantasy.api.arrow.Arrows;
/*     */ import minefantasy.api.weapon.CrossbowAmmo;
/*     */ import minefantasy.block.MFBlockList;
/*     */ import minefantasy.client.tile.TileEntityAnvil;
/*     */ import minefantasy.client.tile.TileEntityBellows;
/*     */ import minefantasy.client.tile.TileEntityBlastFurnace;
/*     */ import minefantasy.client.tile.TileEntityDogBowl;
/*     */ import minefantasy.client.tile.TileEntityFirepit;
/*     */ import minefantasy.client.tile.TileEntityFoodPrep;
/*     */ import minefantasy.client.tile.TileEntityForge;
/*     */ import minefantasy.client.tile.TileEntityFurnaceMF;
/*     */ import minefantasy.client.tile.TileEntityLantern;
/*     */ import minefantasy.client.tile.TileEntityOven;
/*     */ import minefantasy.client.tile.TileEntityRoad;
/*     */ import minefantasy.client.tile.TileEntityRoast;
/*     */ import minefantasy.client.tile.TileEntitySmelter;
/*     */ import minefantasy.client.tile.TileEntitySpinningWheel;
/*     */ import minefantasy.client.tile.TileEntityTailor;
/*     */ import minefantasy.client.tile.TileEntityTanningRack;
/*     */ import minefantasy.client.tile.TileEntityTripHammer;
/*     */ import minefantasy.client.tile.TileEntityWeaponRack;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.system.AchivementMF;
/*     */ import minefantasy.system.AnvilRecipesMF;
/*     */ import minefantasy.system.ArmourTickHandlerMF;
/*     */ import minefantasy.system.ArrowFireFlint;
/*     */ import minefantasy.system.ArrowFirerMF;
/*     */ import minefantasy.system.ArrowHandlerMF;
/*     */ import minefantasy.system.CraftingHandlerMF;
/*     */ import minefantasy.system.CrossbowAmmoMF;
/*     */ import minefantasy.system.EntitylistMF;
/*     */ import minefantasy.system.EventManagerMF;
/*     */ import minefantasy.system.HotItemTickHandler;
/*     */ import minefantasy.system.MFProxyCommon;
/*     */ import minefantasy.system.MineFantasyFuels;
/*     */ import minefantasy.system.QuiverArrowsMF;
/*     */ import minefantasy.system.RecipesMF;
/*     */ import minefantasy.system.WorldGenMF;
/*     */ import minefantasy.system.cfg;
/*     */ import minefantasy.system.network.PacketManagerMF;
/*     */ import mods.battlegear2.api.quiver.QuiverArrowRegistry;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockHalfSlab;
/*     */ import net.minecraft.block.StepSound;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemBow;
/*     */ import net.minecraft.item.ItemShears;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.CraftingManager;
/*     */ import net.minecraft.item.crafting.FurnaceRecipes;
/*     */ import net.minecraft.item.crafting.IRecipe;
/*     */ import net.minecraft.item.crafting.ShapedRecipes;
/*     */ import net.minecraftforge.common.Configuration;
/*     */ import net.minecraftforge.common.DungeonHooks;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.EventBus;
/*     */ import net.minecraftforge.oredict.OreDictionary;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @Mod(modid="MineFantasy", name="Mine Fantasy", version="1.4.0")
/*     */ @NetworkMod(clientSideRequired=true, serverSideRequired=true, channels={"MineFantasy"}, packetHandler=PacketManagerMF.class)
/*     */ public class MineFantasyBase
/*     */ {
/* 133 */   public static StepSound stepSoundSlag = new StepSound("gravel", 1.0F, 0.5F);
/*     */   
/*     */   public static Block MFBlockMudBrick;
/*     */   
/*     */   public static Block MFBlockCobbBrick;
/*     */   
/*     */   public static Block MFBlockGraniteBrick;
/*     */   
/*     */   public static Block MFBlockGranite;
/*     */   
/*     */   public static Block MFBlockIce;
/*     */   
/*     */   public static Block MFBlockLog;
/*     */   
/*     */   public static Block MFBlockLeaves;
/*     */   
/*     */   public static Block MFBlockSapling;
/*     */   
/*     */   public static Block MFBlockRePlanks;
/*     */   
/*     */   public static Block MFBlockPlanks;
/*     */   
/*     */   public static Block MFBlockHayRoof;
/*     */   
/*     */   public static Block MFBlockRoad;
/*     */   
/*     */   public static Block MFBlockLowRoad;
/*     */   public static Block MFBlockOreUtil;
/*     */   public static Block MFBlockOreUmite;
/*     */   public static Block MFBlockOreCopper;
/*     */   public static Block MFBlockOreTin;
/*     */   public static Block MFBlockOreMythic;
/*     */   public static Block MFBlockOreInferno;
/*     */   public static Block MFBlockClayWall;
/*     */   public static Block MFBlockLimestone;
/*     */   public static Block MFBlockTanner;
/*     */   public static Block MFBlockLantern;
/*     */   public static Block MFBlockForge;
/*     */   public static Block MFBlockAnvil;
/*     */   public static Block MFBlockDogbowl;
/*     */   public static Block MFBlockWeaponRack;
/*     */   public static Block MFBlockChimney;
/*     */   public static Block MFBlockFirepit;
/*     */   public static Block MFBlockTripHammer;
/*     */   public static Block MFBlockSlag;
/*     */   public static Block MFBlockRoast;
/*     */   public static Block MFBlockFurnace;
/*     */   public static Block MFBlockFoodPrep;
/*     */   public static Block MFBlockTailor;
/*     */   public static Block MFBlockSpinningWheel;
/*     */   public static Block MFBlockOven;
/*     */   public static Block MFBlockSmelter;
/*     */   public static Block MFBlockBellow;
/*     */   public static Block MFBlockBlast;
/*     */   public static Block MFBlockDoorIronbark;
/*     */   public static Block MFBlockDoorHard;
/*     */   public static Block MFBlockDoorSteel;
/*     */   public static Block MFBlockStorage;
/*     */   public static Block MFBlockStairCobbBrickRough;
/*     */   public static Block MFBlockStairSmoothstone;
/*     */   public static Block MFBlockStairCobbBrick;
/*     */   public static Block MFBlockSlate;
/*     */   public static Block MFBlockSlateStairs;
/*     */   public static Block MFBlockSlateStairsTile;
/*     */   public static Block MFBlockSlateDStairsTile;
/*     */   public static Block MFBlockSlateStairsBrick;
/*     */   public static BlockHalfSlab MFBlockSlateDoubleSlab;
/*     */   public static BlockHalfSlab MFBlockSlateSingleSlab;
/*     */   public static BlockHalfSlab MFBlockWoodDoubleSlab;
/*     */   public static BlockHalfSlab MFBlockWoodSingleSlab;
/*     */   public static BlockHalfSlab MFBlockStoneDoubleSlab;
/*     */   public static BlockHalfSlab MFBlockStoneSingleSlab;
/*     */   public static boolean isBGLoaded;
/*     */   public static boolean isHOLoaded;
/*     */   public static String version;
/* 208 */   public boolean client = FMLCommonHandler.instance().getSide().isClient();
/*     */   
/*     */   @SidedProxy(clientSide="minefantasy.client.MFProxyClient", serverSide="minefantasy.system.MFProxyCommon")
/*     */   public static MFProxyCommon proxy;
/*     */   @Mod.Instance
/*     */   public static MineFantasyBase instance;
/*     */   
/*     */   @Mod.EventHandler
/*     */   public void preInit(FMLPreInitializationEvent event)
/*     */   {
/* 218 */     isBGLoaded = setIsBGLoaded();
/* 219 */     isHOLoaded = setIsHOLoaded();
/*     */     
/* 221 */     Configuration config = new Configuration(event.getSuggestedConfigurationFile());
/* 222 */     new cfg().setConfig(config);
/*     */     
/* 224 */     if (isDebug()) {
/* 225 */       System.out.println("MineFantasy: Debug mode ACTIVE");
/* 226 */       minefantasy.api.forge.HeatableItem.requiresHeating = false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 232 */     gameRegister();
/*     */   }
/*     */   
/*     */   @Mod.EventHandler
/*     */   public void load(FMLInitializationEvent event) {
/* 237 */     MinecraftForge.EVENT_BUS.register(new EventManagerMF());
/* 238 */     MinecraftForge.EVENT_BUS.register(new ArrowHandlerMF());
/*     */     
/*     */ 
/*     */ 
/* 242 */     AchivementMF.register();
/* 243 */     NetworkRegistry.instance().registerGuiHandler(instance, proxy);
/*     */     
/*     */ 
/* 246 */     proxy.registerTickHandlers();
/* 247 */     proxy.registerRenderInformation();
/*     */   }
/*     */   
/*     */   @Mod.EventHandler
/*     */   public void modsLoaded(FMLPostInitializationEvent event) {
/* 252 */     MineFantasyAPI.initAllPlugins();
/* 253 */     RecipesMF.addFinalRecipes();
/* 254 */     removeIron();
/* 255 */     RecipesMF.initiate();
/* 256 */     AnvilRecipesMF.initiate();
/*     */   }
/*     */   
/*     */   public void gameRegister() {
/* 260 */     removeRecipes();
/*     */     
/* 262 */     TickRegistry.registerTickHandler(new ArmourTickHandlerMF(), FMLCommonHandler.instance().getSide());
/* 263 */     TickRegistry.registerTickHandler(new ArmourTickHandlerMF(), Side.SERVER);
/* 264 */     TickRegistry.registerTickHandler(new HotItemTickHandler(), FMLCommonHandler.instance().getSide());
/* 265 */     TickRegistry.registerTickHandler(new HotItemTickHandler(), Side.SERVER);
/*     */     
/* 267 */     MFBlockList.assignBlocks();
/* 268 */     MFBlockList.registerBlocks();
/*     */     
/* 270 */     ItemListMF.init();
/* 271 */     ItemListMF.registerItems();
/*     */     
/* 273 */     EntitylistMF.registerEntity();
/* 274 */     registerTileEntities();
/*     */     
/* 276 */     Arrows.addHandler(new ArrowFireFlint());
/* 277 */     Arrows.addHandler(new ArrowFirerMF());
/*     */     
/* 279 */     DungeonHooks.addDungeonMob("MineFantasy.Minotaur", 50);
/* 280 */     DungeonHooks.addDungeonMob("MineFantasy.Basilisk", 10);
/*     */     
/* 282 */     if (FMLCommonHandler.instance().getSide().isClient()) {
/* 283 */       AchivementMF.init();
/*     */     }
/* 285 */     GameRegistry.registerWorldGenerator(new WorldGenMF());
/* 286 */     GameRegistry.registerCraftingHandler(new CraftingHandlerMF());
/* 287 */     GameRegistry.registerFuelHandler(new MineFantasyFuels());
/* 288 */     CrossbowAmmo.addCrossbowHandler(new CrossbowAmmoMF());
/* 289 */     QuiverArrowRegistry.addArrowFireHandler(new QuiverArrowsMF());
/*     */     
/* 291 */     registerOres();
/* 292 */     rebuildRecipes();
/*     */   }
/*     */   
/*     */   private void registerOres() {
/* 296 */     OreDictionary.registerOre("logWood", new ItemStack(MFBlockLog, 1, 32767));
/* 297 */     OreDictionary.registerOre("treeLeaves", new ItemStack(MFBlockLeaves, 1, 32767));
/*     */     
/* 299 */     OreDictionary.registerOre("treeSapling", new ItemStack(MFBlockSapling, 1, 32767));
/* 300 */     OreDictionary.registerOre("ingotSteel", new ItemStack(ItemListMF.ingotSteel));
/*     */     
/* 302 */     OreDictionary.registerOre("blockLimestone", new ItemStack(MFBlockLimestone));
/* 303 */     OreDictionary.registerOre("blockSteel", new ItemStack(MFBlockStorage, 1, 0));
/* 304 */     OreDictionary.registerOre("blockCopper", new ItemStack(MFBlockStorage, 1, 1));
/* 305 */     OreDictionary.registerOre("blockTin", new ItemStack(MFBlockStorage, 1, 2));
/* 306 */     OreDictionary.registerOre("blockBronze", new ItemStack(MFBlockStorage, 1, 3));
/* 307 */     OreDictionary.registerOre("blockMithril", new ItemStack(MFBlockStorage, 1, 4));
/* 308 */     OreDictionary.registerOre("blockDeepIron", new ItemStack(MFBlockStorage, 1, 8));
/* 309 */     OreDictionary.registerOre("blockSilver", new ItemStack(MFBlockStorage, 1, 5));
/* 310 */     OreDictionary.registerOre("blockIron", new ItemStack(MFBlockStorage, 1, 7));
/*     */     
/* 312 */     OreDictionary.registerOre("ingotTin", new ItemStack(ItemListMF.misc, 1, 57));
/* 313 */     OreDictionary.registerOre("ingotCopper", new ItemStack(ItemListMF.misc, 1, 56));
/* 314 */     OreDictionary.registerOre("ingotBronze", new ItemStack(ItemListMF.misc, 1, 58));
/* 315 */     OreDictionary.registerOre("ingotSilver", new ItemStack(ItemListMF.ingotSilver));
/* 316 */     OreDictionary.registerOre("chain", new ItemStack(ItemListMF.misc, 1, 116));
/*     */     
/* 318 */     OreDictionary.registerOre("oreCopper", new ItemStack(MFBlockOreCopper));
/* 319 */     OreDictionary.registerOre("oreTin", new ItemStack(MFBlockOreTin));
/* 320 */     OreDictionary.registerOre("oreSilver", new ItemStack(MFBlockOreUtil, 1, 0));
/*     */     
/* 322 */     OreDictionary.registerOre("oreNitre", new ItemStack(MFBlockOreUtil, 1, 1));
/* 323 */     OreDictionary.registerOre("oreNiter", new ItemStack(MFBlockOreUtil, 1, 2));
/* 324 */     OreDictionary.registerOre("oreSulfur", new ItemStack(MFBlockOreUtil, 1, 2));
/*     */     
/* 326 */     OreDictionary.registerOre("ingotIron", new ItemStack(ItemListMF.misc, 1, 60));
/* 327 */     OreDictionary.registerOre("ingotIron", new ItemStack(Item.field_77703_o));
/* 328 */     OreDictionary.registerOre("salt", ItemListMF.component(10));
/*     */     
/* 330 */     OreDictionary.registerOre("ingotMithril", new ItemStack(ItemListMF.misc, 1, 55));
/* 331 */     OreDictionary.registerOre("ingotDeepIron", new ItemStack(ItemListMF.misc, 1, 185));
/*     */   }
/*     */   
/*     */   private void registerTileEntities() {
/* 335 */     GameRegistry.registerTileEntity(TileEntityLantern.class, "MFLantern");
/* 336 */     GameRegistry.registerTileEntity(TileEntityBellows.class, "Bellows");
/* 337 */     GameRegistry.registerTileEntity(TileEntityDogBowl.class, "Dogbowl");
/* 338 */     GameRegistry.registerTileEntity(TileEntityAnvil.class, "Anvil");
/* 339 */     GameRegistry.registerTileEntity(TileEntitySmelter.class, "Bloom");
/* 340 */     GameRegistry.registerTileEntity(TileEntityForge.class, "Forge");
/* 341 */     GameRegistry.registerTileEntity(TileEntityTanningRack.class, "Tanner");
/* 342 */     GameRegistry.registerTileEntity(TileEntityWeaponRack.class, "Rack");
/* 343 */     GameRegistry.registerTileEntity(TileEntityRoast.class, "MFSpitRoast");
/* 344 */     GameRegistry.registerTileEntity(TileEntityBlastFurnace.class, "Blastfurnace");
/* 345 */     GameRegistry.registerTileEntity(TileEntityTripHammer.class, "MFTripHammer");
/* 346 */     GameRegistry.registerTileEntity(TileEntityFurnaceMF.class, "MFFurnace");
/* 347 */     GameRegistry.registerTileEntity(TileEntityFoodPrep.class, "MFFoodPrep");
/* 348 */     GameRegistry.registerTileEntity(TileEntityTailor.class, "MFTailor");
/* 349 */     GameRegistry.registerTileEntity(TileEntitySpinningWheel.class, "MFSpinningWheel");
/* 350 */     GameRegistry.registerTileEntity(TileEntityFirepit.class, "firepitMF");
/* 351 */     GameRegistry.registerTileEntity(TileEntityOven.class, "ovenMF");
/* 352 */     GameRegistry.registerTileEntity(TileEntityRoad.class, "roadMF");
/*     */   }
/*     */   
/*     */   private void rebuildRecipes() {
/* 356 */     System.out.println("[MineFantasy] Hardcore crafting ENABLED: Tool / Weapon recipes removed. Rebuilding...");
/* 357 */     List recipes = new ArrayList();
/*     */     
/* 359 */     int prevSize = CraftingManager.func_77594_a().func_77592_b().size();
/*     */     
/* 361 */     for (int a = 0; a < CraftingManager.func_77594_a().func_77592_b().size(); a++) {
/* 362 */       if ((CraftingManager.func_77594_a().func_77592_b().get(a) instanceof IRecipe)) {
/* 363 */         IRecipe recipe = (IRecipe)CraftingManager.func_77594_a().func_77592_b().get(a);
/* 364 */         if ((recipe != null) && (!willRemove(recipe.func_77571_b()))) {
/* 365 */           recipes.add(recipe);
/*     */         }
/*     */       }
/*     */     }
/* 369 */     int less = prevSize - recipes.size();
/*     */     
/* 371 */     System.out.println("[MineFantasy] Recipes Rebuilt " + less + " recipes removed. Applying new List....");
/* 372 */     CraftingManager.func_77594_a().func_77592_b().clear();
/*     */     
/* 374 */     for (int a = 0; a < recipes.size(); a++) {
/* 375 */       CraftingManager.func_77594_a().func_77592_b().add(recipes.get(a));
/*     */     }
/*     */     
/* 378 */     System.out.println("[MineFantasy] New Recipe List Applied.");
/*     */   }
/*     */   
/*     */   private void removeRecipes() {
/* 382 */     System.out.println("MineFantasy: Removing replaced recipes...");
/* 383 */     for (int a = 0; a < CraftingManager.func_77594_a().func_77592_b().size(); a++) {
/* 384 */       IRecipe rec = (IRecipe)CraftingManager.func_77594_a().func_77592_b().get(a);
/* 385 */       if ((rec.func_77571_b() != null) && (rec.func_77571_b().func_77969_a(new ItemStack(Item.field_77669_D)))) {
/* 386 */         CraftingManager.func_77594_a().func_77592_b().remove(a);
/*     */         
/* 388 */         if ((rec instanceof ShapedRecipes)) {
/* 389 */           ShapedRecipes shape = (ShapedRecipes)rec;
/*     */           
/* 391 */           if ((shape.field_77577_c == 2) && (shape.field_77576_b == 1)) {
/* 392 */             GameRegistry.addRecipe(new ItemStack(ItemListMF.plank, 8), new Object[] { "A", "B", Character.valueOf('A'), shape.field_77574_d[0], Character.valueOf('A'), shape.field_77574_d[1] });
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 397 */       if ((rec.func_77571_b() != null) && (rec.func_77571_b().func_77969_a(new ItemStack(Block.field_82510_ck)))) {
/* 398 */         CraftingManager.func_77594_a().func_77592_b().remove(a);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void tryRemove(String string, int id, ItemStack recipe) {
/* 404 */     if ((OreDictionary.getOres(string) == null) || (OreDictionary.getOres(string).isEmpty())) {
/* 405 */       return;
/*     */     }
/*     */     
/* 408 */     for (ItemStack ore : OreDictionary.getOres(string)) {
/* 409 */       if ((ore != null) && 
/* 410 */         (ore.func_77969_a(recipe))) {
/* 411 */         FurnaceRecipes.func_77602_a().func_77599_b().remove(Integer.valueOf(id));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void removeIron()
/*     */   {
/* 418 */     System.out.println("MineFantasy: Removing Ingot Smelting");
/*     */     
/* 420 */     for (int a2 = 0; a2 < FurnaceRecipes.func_77602_a().func_77599_b().size(); a2++) {
/* 421 */       Object recipe = FurnaceRecipes.func_77602_a().func_77599_b().get(Integer.valueOf(a2));
/* 422 */       if ((recipe != null) && ((recipe instanceof ItemStack)) && 
/* 423 */         (((ItemStack)recipe).field_77993_c == Item.field_77703_o.field_77779_bT)) {
/* 424 */         FurnaceRecipes.func_77602_a().func_77599_b().remove(Integer.valueOf(a2));
/* 425 */         if (cfg.easyIron) {
/* 426 */           MineFantasyAPI.addSpecialSmelt(ItemListMF.component(60), -1, Integer.valueOf(a2));
/*     */         } else {
/* 428 */           MineFantasyAPI.addBlastRecipe(a2, new ItemStack(Item.field_77703_o));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean willRemove(ItemStack item)
/*     */   {
/* 436 */     if (item == null) {
/* 437 */       return false;
/*     */     }
/* 439 */     int id = item.field_77993_c;
/*     */     
/* 441 */     if ((id == Item.field_77709_i.field_77779_bT) || (id == Item.field_77687_V.field_77779_bT) || (id == Item.field_77686_W.field_77779_bT) || (id == Item.field_77693_X.field_77779_bT) || (id == Item.field_77692_Y.field_77779_bT) || (isBGItem(id, "quiver")))
/*     */     {
/*     */ 
/* 444 */       return true;
/*     */     }
/* 446 */     if ((cfg.hardcoreFurnace) && 
/* 447 */       (id == Block.field_72051_aB.field_71990_ca)) {
/* 448 */       return true;
/*     */     }
/*     */     
/* 451 */     if (cfg.hardcoreCraft) {
/* 452 */       return (id == Item.field_77674_B.field_77779_bT) || (id == Item.field_77681_I.field_77779_bT) || (id == Item.field_77713_t.field_77779_bT) || (id == Item.field_77720_x.field_77779_bT) || (id == Item.field_77696_g.field_77779_bT) || (id == Item.field_77675_C.field_77779_bT) || (id == Item.field_77682_J.field_77779_bT) || (id == Item.field_77712_u.field_77779_bT) || (id == Item.field_77719_y.field_77779_bT) || (id == Item.field_77708_h.field_77779_bT) || (id == Item.field_77673_A.field_77779_bT) || (id == Item.field_77680_H.field_77779_bT) || (id == Item.field_77714_s.field_77779_bT) || (id == Item.field_77710_w.field_77779_bT) || (id == Item.field_77695_f.field_77779_bT) || (id == Item.field_77688_Q.field_77779_bT) || (id == Item.field_77691_R.field_77779_bT) || (id == Item.field_77678_N.field_77779_bT) || (id == Item.field_77679_O.field_77779_bT) || (id == Item.field_77689_P.field_77779_bT) || (id == Item.field_77718_z.field_77779_bT) || (id == Item.field_77672_G.field_77779_bT) || (id == Item.field_77715_r.field_77779_bT) || (id == Item.field_77711_v.field_77779_bT) || (id == Item.field_77716_q.field_77779_bT) || (id == Item.field_77812_ad.field_77779_bT) || (id == Item.field_77822_ae.field_77779_bT) || (id == Item.field_77824_af.field_77779_bT) || (id == Item.field_77818_ag.field_77779_bT) || (id == Item.field_77796_al.field_77779_bT) || (id == Item.field_77806_am.field_77779_bT) || (id == Item.field_77808_an.field_77779_bT) || (id == Item.field_77802_ao.field_77779_bT) || (id == Item.field_77820_ah.field_77779_bT) || (id == Item.field_77798_ai.field_77779_bT) || (id == Item.field_77800_aj.field_77779_bT) || (id == Item.field_77794_ak.field_77779_bT) || (id == Item.field_77707_k.field_77779_bT) || (id == Block.field_71959_S.field_71990_ca) || (id == Item.field_77745_be.field_77779_bT);
/*     */     }
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
/* 470 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isBGItem(int id, String string) {
/* 474 */     return isBGItem(id, string, 32767);
/*     */   }
/*     */   
/*     */   private boolean isBGItem(int id, String string, int meta) {
/* 478 */     ItemStack BGItem = getBGItem(string, meta);
/*     */     
/* 480 */     if ((BGItem != null) && 
/* 481 */       (id == BGItem.field_77993_c)) {
/* 482 */       return (BGItem.func_77960_j() == meta) || (meta == 32767);
/*     */     }
/*     */     
/* 485 */     return false;
/*     */   }
/*     */   
/*     */   public static ItemStack getBGItem(String itemString, int meta) {
/* 489 */     if (meta == 32767)
/* 490 */       meta = 0;
/* 491 */     ItemStack item = null;
/*     */     try
/*     */     {
/* 494 */       String itemClass = "mods.battlegear2.utils.BattlegearConfig";
/* 495 */       Object obj = Class.forName(itemClass).getField(itemString).get(null);
/* 496 */       if ((obj instanceof Item)) {
/* 497 */         item = new ItemStack((Item)obj, 1, meta);
/* 498 */       } else if ((obj instanceof Block)) {
/* 499 */         item = new ItemStack((Block)obj, 1, meta);
/* 500 */       } else if ((obj instanceof ItemStack)) {
/* 501 */         item = (ItemStack)obj;
/*     */       }
/*     */     }
/*     */     catch (Exception localException) {}
/*     */     
/* 506 */     return item;
/*     */   }
/*     */   
/*     */   public static int getColourForRGB(int red, int green, int blue) {
/* 510 */     return (red << 16) + (green << 8) + blue;
/*     */   }
/*     */   
/*     */   public static String getVersion() {
/* 514 */     return getVersion();
/*     */   }
/*     */   
/*     */   public static boolean isDebug() {
/* 518 */     return cfg.debug.equalsIgnoreCase("XA42-DDY3-22Y4-32HG-997V");
/*     */   }
/*     */   
/*     */   static {
/* 522 */     MineFantasyAPI.modLoaded = true;
/*     */   }
/*     */   
/*     */   public static boolean isBGLoaded() {
/* 526 */     return isBGLoaded;
/*     */   }
/*     */   
/*     */   public static boolean setIsBGLoaded() {
/*     */     try {
/* 531 */       Class.forName("mods.battlegear2.Battlegear");
/*     */     } catch (ClassNotFoundException e) {
/* 533 */       return false;
/*     */     }
/* 535 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isHOLoaded() {
/* 539 */     return isHOLoaded;
/*     */   }
/*     */   
/*     */   public static boolean setIsHOLoaded() {
/*     */     try {
/* 544 */       Class.forName("iguanaman.hungeroverhaul.HungerOverhaul");
/*     */     } catch (ClassNotFoundException e) {
/* 546 */       return false;
/*     */     }
/* 548 */     return true;
/*     */   }
/*     */   
/*     */   public static float scaleExhaustion(float exhaust) {
/* 552 */     if (isHOLoaded()) {
/* 553 */       exhaust *= 0.25F;
/*     */     }
/* 555 */     return exhaust;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/MineFantasyBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */