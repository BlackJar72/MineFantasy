/*     */ package minefantasy.block;
/*     */ 
/*     */ import cpw.mods.fml.common.registry.GameRegistry;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.block.special.BlockAnvilMF;
/*     */ import minefantasy.block.special.BlockBellows;
/*     */ import minefantasy.block.special.BlockBlastFurnace;
/*     */ import minefantasy.block.special.BlockDogBowl;
/*     */ import minefantasy.block.special.BlockFirepit;
/*     */ import minefantasy.block.special.BlockFoodPrep;
/*     */ import minefantasy.block.special.BlockForge;
/*     */ import minefantasy.block.special.BlockFurnaceMF;
/*     */ import minefantasy.block.special.BlockLantern;
/*     */ import minefantasy.block.special.BlockOven;
/*     */ import minefantasy.block.special.BlockRoast;
/*     */ import minefantasy.block.special.BlockSmelter;
/*     */ import minefantasy.block.special.BlockSpinningWheel;
/*     */ import minefantasy.block.special.BlockTailor;
/*     */ import minefantasy.block.special.BlockTanningRack;
/*     */ import minefantasy.block.special.BlockTripHammer;
/*     */ import minefantasy.block.special.BlockWeaponRack;
/*     */ import minefantasy.block.special.ItemBlockAnvil;
/*     */ import minefantasy.block.special.ItemBlockBlastFurnace;
/*     */ import minefantasy.block.special.ItemBlockSmelter;
/*     */ import minefantasy.block.special.ItemBlockTripHammer;
/*     */ import minefantasy.system.cfg;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockHalfSlab;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ 
/*     */ public class MFBlockList
/*     */ {
/*     */   public static Item MFItemWoodSingleSlab;
/*     */   public static Item MFItemWoodDoubleSlab;
/*     */   public static Item MFItemStoneSingleSlab;
/*     */   public static Item MFItemStoneDoubleSlab;
/*     */   public static Item MFItemSlateSingleSlab;
/*     */   public static Item MFItemSlateDoubleSlab;
/*     */   
/*     */   public static void assignBlocks()
/*     */   {
/*  44 */     MineFantasyBase.MFBlockLantern = new BlockLantern(cfg.lanternId, Material.field_76245_d).func_71864_b("lantern").func_71848_c(2.0F).func_71894_b(7.0F).func_71900_a(1.0F);
/*  45 */     MineFantasyBase.MFBlockForge = new BlockForge(cfg.forgeId).func_71864_b("forge").func_71848_c(10.0F).func_71894_b(15.0F);
/*  46 */     MineFantasyBase.MFBlockAnvil = new BlockAnvilMF(cfg.anvilId, 1, Material.field_76243_f).func_71864_b("anvil").func_71848_c(5.0F).func_71894_b(10.0F);
/*     */     
/*  48 */     MineFantasyBase.MFBlockMudBrick = new BlockMudbrick(cfg.mudBrickId).func_71848_c(0.7F).func_71894_b(1.0F).func_71884_a(Block.field_71964_f).func_71864_b("mudBrick");
/*  49 */     MineFantasyBase.MFBlockCobbBrick = new BlockCobbleBrick(cfg.cobbBrickId).func_71848_c(3.0F).func_71894_b(12.0F).func_71884_a(Block.field_71976_h).func_71864_b("cobbBrick");
/*  50 */     MineFantasyBase.MFBlockRePlanks = new BlockMedieval(cfg.rePlanksId, Material.field_76245_d, cfg.rePlanksId).func_71848_c(3.0F).func_71894_b(12.0F).func_71884_a(Block.field_71967_e).func_71864_b("rePlanks");
/*  51 */     MineFantasyBase.MFBlockOreUtil = new BlockUtilOre(cfg.oreUtilId).func_71848_c(2.0F).func_71894_b(5.0F).func_71884_a(Block.field_71976_h).func_71864_b("oreSilver");
/*  52 */     MineFantasyBase.MFBlockSlate = new BlockSlate(cfg.slateId).func_71848_c(2.2F).func_71894_b(6.0F).func_71884_a(Block.field_71976_h).func_71864_b("slate");
/*  53 */     MineFantasyBase.MFBlockClayWall = new BlockClayWall(cfg.clayWallId).func_71848_c(1.0F).func_71894_b(1.2F).func_71884_a(Block.field_71976_h).func_71864_b("clayWall");
/*  54 */     MineFantasyBase.MFBlockGranite = new BlockMedieval(cfg.graniteId, Material.field_76246_e, cfg.graniteId).func_71848_c(5.0F).func_71894_b(18.0F).func_71884_a(Block.field_71976_h).func_71864_b("granite");
/*  55 */     MineFantasyBase.MFBlockGraniteBrick = new BlockGraniteBrick(cfg.graniteBrickId).func_71848_c(8.0F).func_71894_b(25.0F).func_71884_a(Block.field_71976_h).func_71864_b("graniteBrick");
/*  56 */     MineFantasyBase.MFBlockPlanks = new BlockPlanksMF(cfg.planksId).func_71848_c(3.0F).func_71894_b(5.0F).func_71884_a(Block.field_71967_e).func_71864_b("planksMF");
/*  57 */     MineFantasyBase.MFBlockLog = new BlockLogMedieval(cfg.ironbarkId).func_71848_c(5.0F).func_71894_b(8.0F).func_71864_b("logMF").func_71884_a(Block.field_71967_e);
/*  58 */     MineFantasyBase.MFBlockLeaves = new BlockLeavesMF(cfg.leavesId).func_71848_c(0.2F).func_71868_h(1).func_71864_b("leavesIronbark").func_71884_a(Block.field_71965_g);
/*  59 */     MineFantasyBase.MFBlockSapling = new BlockSaplingMF(cfg.saplingId).func_71848_c(0.2F).func_71868_h(1).func_71864_b("saplingIronbark");
/*  60 */     MineFantasyBase.MFBlockTanner = new BlockTanningRack(cfg.tannerId, 1, Material.field_76245_d).func_71864_b("tanner").func_71848_c(5.0F).func_71894_b(10.0F);
/*  61 */     MineFantasyBase.MFBlockRoad = new BlockRoad(cfg.roadId, 0.9375F).func_71864_b("road").func_71848_c(0.5F).func_71884_a(Block.field_71964_f);
/*  62 */     MineFantasyBase.MFBlockOreUmite = new BlockUmite(cfg.oreIgnotumiteId, 169, Material.field_76246_e).func_71900_a(0.7F).func_71864_b("oreIgnotumite").func_71848_c(100.0F).func_71894_b(2000.0F);
/*  63 */     MineFantasyBase.MFBlockStairSmoothstone = new BlockStairsMod(cfg.stairStoneId, Block.field_71981_t, 0).func_71868_h(1).func_71864_b("stairSmoothstone").func_71848_c(1.0F).func_71894_b(1.5F);
/*  64 */     MineFantasyBase.MFBlockStairCobbBrick = new BlockMedievalStairs(cfg.stairCStoneId, MineFantasyBase.MFBlockCobbBrick).func_71868_h(1).func_71864_b("stairCobbBrick").func_71848_c(1.0F).func_71894_b(1.5F);
/*  65 */     MineFantasyBase.MFBlockDogbowl = new BlockDogBowl(cfg.dogbowlId).func_71864_b("dogbowl").func_71848_c(0.2F).func_71894_b(0.0F);
/*  66 */     MineFantasyBase.MFBlockWeaponRack = new BlockWeaponRack(cfg.weaponRackId).func_71864_b("weaponRack").func_71848_c(0.4F).func_71894_b(1.0F);
/*  67 */     MineFantasyBase.MFBlockHayRoof = new BlockMedievalStairs(cfg.hayRoofId, MineFantasyBase.MFBlockLeaves, Material.field_76257_i, 113).func_71868_h(1).func_71864_b("hayRoof").func_71848_c(1.0F).func_71894_b(0.2F);
/*  68 */     MineFantasyBase.MFBlockOreCopper = new BlockMedieval(cfg.oreCopperId, Material.field_76246_e, cfg.oreCopperId).func_71848_c(2.0F).func_71894_b(3.0F).func_71884_a(Block.field_71976_h).func_71864_b("oreCopper");
/*  69 */     MineFantasyBase.MFBlockOreTin = new BlockMedieval(cfg.oreTinId, Material.field_76246_e, cfg.oreTinId).func_71848_c(2.0F).func_71894_b(3.0F).func_71884_a(Block.field_71976_h).func_71864_b("oreTin");
/*  70 */     MineFantasyBase.MFBlockOreMythic = new BlockMythicOre(cfg.oreMithicId).func_71848_c(5.0F).func_71894_b(15.0F).func_71884_a(Block.field_71976_h).func_71864_b("oreMithril");
/*  71 */     MineFantasyBase.MFBlockSmelter = new BlockSmelter(cfg.bloomId).func_71864_b("bloom").func_71848_c(5.0F).func_71894_b(10.0F);
/*  72 */     MineFantasyBase.MFBlockBellow = new BlockBellows(cfg.bellowsId).func_71864_b("bellows").func_71848_c(1.0F).func_71894_b(1.0F);
/*  73 */     MineFantasyBase.MFBlockLimestone = new BlockMedieval(cfg.limestoneId, Material.field_76246_e, cfg.limestoneId).func_71864_b("limestone").func_71848_c(3.0F).func_71894_b(5.0F);
/*     */     
/*     */ 
/*     */ 
/*  77 */     MineFantasyBase.MFBlockBlast = new BlockBlastFurnace(cfg.BlastId, 0, Material.field_76243_f).func_71864_b("Blast").func_71848_c(8.0F).func_71894_b(10.0F);
/*  78 */     MineFantasyBase.MFBlockLowRoad = new BlockRoad(cfg.dirtSlabSId, 0.5F).func_71864_b("road").func_71848_c(0.5F).func_71884_a(Block.field_71964_f);
/*     */     
/*  80 */     MineFantasyBase.MFBlockDoorIronbark = new BlockDoorMF(cfg.ironbarkDoorId, MFDoorEnum.IRONBARK).func_71848_c(4.5F).func_71884_a(Block.field_71967_e).func_71864_b("doorIronbark");
/*  81 */     MineFantasyBase.MFBlockDoorHard = new BlockDoorMF(cfg.hardDoorId, MFDoorEnum.REINFORCED).func_71848_c(6.0F).func_71884_a(Block.field_71967_e).func_71864_b("doorHard");
/*  82 */     MineFantasyBase.MFBlockDoorSteel = new BlockDoorMF(cfg.steelDoorId, MFDoorEnum.STEEL).func_71848_c(10.0F).func_71884_a(Block.field_71977_i).func_71864_b("doorSteel");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  90 */     MineFantasyBase.MFBlockStorage = new BlockStorageMF(cfg.storeId).func_71848_c(5.0F).func_71894_b(8.0F).func_71884_a(Block.field_71977_i).func_71864_b("storage").func_71849_a(net.minecraft.creativetab.CreativeTabs.field_78030_b);
/*  91 */     MineFantasyBase.MFBlockIce = new BlockIceMF(cfg.iceId, 67).func_71848_c(0.5F).func_71868_h(3).func_71884_a(Block.field_71974_j).func_71864_b("ice");
/*  92 */     MineFantasyBase.MFBlockChimney = new BlockChimney(cfg.chimId).func_71848_c(1.5F).func_71894_b(0.5F).func_71884_a(Block.field_71976_h).func_71864_b("chimney");
/*  93 */     MineFantasyBase.MFBlockFirepit = new BlockFirepit(cfg.firepitId).func_71848_c(0.5F).func_71884_a(Block.field_71967_e).func_71864_b("firepit");
/*     */     
/*  95 */     MineFantasyBase.MFBlockTripHammer = new BlockTripHammer(cfg.tripHammerId).func_71864_b("tripHammer").func_71848_c(10.0F).func_71894_b(10.0F);
/*  96 */     MineFantasyBase.MFBlockSlag = new BlockSlag(cfg.slagId).func_71864_b("slag").func_71848_c(1.0F).func_71894_b(0.5F).func_71884_a(MineFantasyBase.stepSoundSlag);
/*  97 */     MineFantasyBase.MFBlockRoast = new BlockRoast(cfg.roastId).func_71864_b("roast").func_71848_c(0.4F).func_71894_b(1.0F);
/*     */     
/*  99 */     MineFantasyBase.MFBlockSlateStairs = new BlockMedievalStairs(cfg.stairSlateId, MineFantasyBase.MFBlockSlate, 0).func_71868_h(1).func_71864_b("stairSlate").func_71848_c(2.0F).func_71894_b(3.0F);
/* 100 */     MineFantasyBase.MFBlockSlateStairsTile = new BlockMedievalStairs(cfg.stairSlateTileId, MineFantasyBase.MFBlockSlate, 1).func_71868_h(1).func_71864_b("stairSlateTile").func_71848_c(2.0F).func_71894_b(3.0F);
/* 101 */     MineFantasyBase.MFBlockSlateDStairsTile = new BlockMedievalStairs(cfg.stairDSlateTileId, MineFantasyBase.MFBlockSlate, 2).func_71868_h(1).func_71864_b("stairDSlateTile").func_71848_c(2.0F).func_71894_b(3.0F);
/* 102 */     MineFantasyBase.MFBlockSlateStairsBrick = new BlockMedievalStairs(cfg.stairSlateBrickId, MineFantasyBase.MFBlockSlate, 3).func_71868_h(1).func_71864_b("stairSlateBrick").func_71848_c(2.0F).func_71894_b(3.0F);
/*     */     
/* 104 */     MineFantasyBase.MFBlockFurnace = new BlockFurnaceMF(cfg.furnaceOnId).func_71864_b("furnace").func_71848_c(5.0F).func_71894_b(10.0F);
/* 105 */     MineFantasyBase.MFBlockFoodPrep = new BlockFoodPrep(cfg.foodPrepId, Material.field_76245_d).func_71864_b("foodPrep").func_71848_c(1.0F).func_71894_b(0.0F);
/* 106 */     MineFantasyBase.MFBlockTailor = new BlockTailor(cfg.tailorId, Material.field_76245_d).func_71864_b("tailor").func_71848_c(4.0F).func_71894_b(2.0F);
/* 107 */     MineFantasyBase.MFBlockSpinningWheel = new BlockSpinningWheel(cfg.spinnerId).func_71864_b("spinningWheel").func_71848_c(2.0F).func_71894_b(0.5F);
/*     */     
/* 109 */     MineFantasyBase.MFBlockOreInferno = new BlockHellCoal(cfg.infernoId).func_71864_b("oreInferno").func_71848_c(2.0F).func_71894_b(2.0F).func_71900_a(0.25F);
/* 110 */     MineFantasyBase.MFBlockOven = new BlockOven(cfg.ovenId).func_71864_b("oven").func_71848_c(3.5F).func_71894_b(8.0F);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 115 */     MineFantasyBase.MFBlockStairCobbBrickRough = new BlockMedievalStairs(cfg.stairCStoneRoughId, MineFantasyBase.MFBlockCobbBrick, 3).func_71868_h(1).func_71864_b("stairCobbBrick").func_71848_c(1.0F).func_71894_b(1.5F);
/*     */     
/* 117 */     MineFantasyBase.MFBlockSlateDoubleSlab = (BlockHalfSlab)new BlockSlateSlab(cfg.SlslabId, true).func_71848_c(2.4F).func_71894_b(12.0F).func_71884_a(Block.field_71976_h).func_71864_b("slateSlab");
/* 118 */     MineFantasyBase.MFBlockSlateSingleSlab = (BlockHalfSlab)new BlockSlateSlab(cfg.SldSlabId, false).func_71848_c(1.2F).func_71894_b(12.0F).func_71884_a(Block.field_71976_h).func_71864_b("slateSlab");
/* 119 */     MineFantasyBase.MFBlockWoodDoubleSlab = (BlockHalfSlab)new BlockWoodSlabMF(cfg.WslabId, true).func_71848_c(3.0F).func_71894_b(5.0F).func_71884_a(Block.field_71976_h).func_71864_b("woodSlab");
/* 120 */     MineFantasyBase.MFBlockWoodSingleSlab = (BlockHalfSlab)new BlockWoodSlabMF(cfg.WdSlabId, false).func_71848_c(3.0F).func_71894_b(5.0F).func_71884_a(Block.field_71976_h).func_71864_b("woodSlab");
/* 121 */     MineFantasyBase.MFBlockStoneDoubleSlab = (BlockHalfSlab)new BlockStoneSlabMF(cfg.SslabId, true).func_71848_c(5.0F).func_71894_b(10.0F).func_71884_a(Block.field_71976_h).func_71864_b("stoneSlab");
/* 122 */     MineFantasyBase.MFBlockStoneSingleSlab = (BlockHalfSlab)new BlockStoneSlabMF(cfg.SdSlabId, false).func_71848_c(5.0F).func_71894_b(10.0F).func_71884_a(Block.field_71976_h).func_71864_b("stoneSlab");
/*     */     
/* 124 */     Item.field_77698_e[MineFantasyBase.MFBlockWoodSingleSlab.field_71990_ca] = new ItemWoodSlabMF(MineFantasyBase.MFBlockWoodSingleSlab.field_71990_ca - 256, MineFantasyBase.MFBlockWoodSingleSlab, MineFantasyBase.MFBlockWoodDoubleSlab, false).func_77655_b("woodSlab");
/* 125 */     Item.field_77698_e[MineFantasyBase.MFBlockWoodDoubleSlab.field_71990_ca] = new ItemWoodSlabMF(MineFantasyBase.MFBlockWoodDoubleSlab.field_71990_ca - 256, MineFantasyBase.MFBlockWoodSingleSlab, MineFantasyBase.MFBlockWoodDoubleSlab, true).func_77655_b("woodSlab");
/* 126 */     Item.field_77698_e[MineFantasyBase.MFBlockStoneSingleSlab.field_71990_ca] = new ItemStoneSlabMF(MineFantasyBase.MFBlockStoneSingleSlab.field_71990_ca - 256, MineFantasyBase.MFBlockStoneSingleSlab, MineFantasyBase.MFBlockStoneDoubleSlab, false).func_77655_b("stoneSlab");
/* 127 */     Item.field_77698_e[MineFantasyBase.MFBlockStoneDoubleSlab.field_71990_ca] = new ItemStoneSlabMF(MineFantasyBase.MFBlockStoneDoubleSlab.field_71990_ca - 256, MineFantasyBase.MFBlockStoneSingleSlab, MineFantasyBase.MFBlockStoneDoubleSlab, true).func_77655_b("stoneSlab");
/* 128 */     Item.field_77698_e[MineFantasyBase.MFBlockSlateSingleSlab.field_71990_ca] = new ItemBlockSlateSlab(MineFantasyBase.MFBlockSlateSingleSlab.field_71990_ca - 256, MineFantasyBase.MFBlockSlateSingleSlab, MineFantasyBase.MFBlockSlateDoubleSlab, false).func_77655_b("slateSlab");
/* 129 */     Item.field_77698_e[MineFantasyBase.MFBlockSlateDoubleSlab.field_71990_ca] = new ItemBlockSlateSlab(MineFantasyBase.MFBlockSlateDoubleSlab.field_71990_ca - 256, MineFantasyBase.MFBlockSlateSingleSlab, MineFantasyBase.MFBlockSlateDoubleSlab, true).func_77655_b("slateSlab");
/*     */     
/* 131 */     MFItemWoodSingleSlab = new ItemWoodSlabMF(MineFantasyBase.MFBlockWoodSingleSlab.field_71990_ca - 256, MineFantasyBase.MFBlockWoodSingleSlab, MineFantasyBase.MFBlockWoodDoubleSlab, false).func_77655_b("woodSlab");
/* 132 */     MFItemWoodDoubleSlab = new ItemWoodSlabMF(MineFantasyBase.MFBlockWoodDoubleSlab.field_71990_ca - 256, MineFantasyBase.MFBlockWoodSingleSlab, MineFantasyBase.MFBlockWoodDoubleSlab, true).func_77655_b("woodSlab");
/* 133 */     MFItemStoneSingleSlab = new ItemStoneSlabMF(MineFantasyBase.MFBlockStoneSingleSlab.field_71990_ca - 256, MineFantasyBase.MFBlockStoneSingleSlab, MineFantasyBase.MFBlockStoneDoubleSlab, false).func_77655_b("stoneSlab");
/* 134 */     MFItemStoneDoubleSlab = new ItemStoneSlabMF(MineFantasyBase.MFBlockStoneDoubleSlab.field_71990_ca - 256, MineFantasyBase.MFBlockStoneSingleSlab, MineFantasyBase.MFBlockStoneDoubleSlab, true).func_77655_b("stoneSlab");
/* 135 */     MFItemSlateSingleSlab = new ItemBlockSlateSlab(MineFantasyBase.MFBlockSlateSingleSlab.field_71990_ca - 256, MineFantasyBase.MFBlockSlateSingleSlab, MineFantasyBase.MFBlockSlateDoubleSlab, false).func_77655_b("slateSlab");
/* 136 */     MFItemSlateDoubleSlab = new ItemBlockSlateSlab(MineFantasyBase.MFBlockSlateDoubleSlab.field_71990_ca - 256, MineFantasyBase.MFBlockSlateSingleSlab, MineFantasyBase.MFBlockSlateDoubleSlab, true).func_77655_b("slateSlab");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void registerBlocks()
/*     */   {
/* 144 */     MinecraftForge.setBlockHarvestLevel(MineFantasyBase.MFBlockSlate, "pickaxe", 1);
/* 145 */     MinecraftForge.setBlockHarvestLevel(MineFantasyBase.MFBlockSlateStairs, "pickaxe", 1);
/* 146 */     MinecraftForge.setBlockHarvestLevel(MineFantasyBase.MFBlockSlateStairsTile, "pickaxe", 1);
/* 147 */     MinecraftForge.setBlockHarvestLevel(MineFantasyBase.MFBlockSlateDStairsTile, "pickaxe", 1);
/* 148 */     MinecraftForge.setBlockHarvestLevel(MineFantasyBase.MFBlockSlateStairsBrick, "pickaxe", 1);
/* 149 */     MinecraftForge.setBlockHarvestLevel(MineFantasyBase.MFBlockSlateDoubleSlab, "pickaxe", 1);
/* 150 */     MinecraftForge.setBlockHarvestLevel(MineFantasyBase.MFBlockSlateSingleSlab, "pickaxe", 1);
/* 151 */     MinecraftForge.setBlockHarvestLevel(MineFantasyBase.MFBlockStorage, "pickaxe", 1);
/* 152 */     MinecraftForge.setBlockHarvestLevel(MineFantasyBase.MFBlockBlast, "pickaxe", 2);
/* 153 */     MinecraftForge.setBlockHarvestLevel(MineFantasyBase.MFBlockOreCopper, "pickaxe", 1);
/* 154 */     MinecraftForge.setBlockHarvestLevel(MineFantasyBase.MFBlockOreInferno, 0, "pickaxe", 2);
/* 155 */     MinecraftForge.setBlockHarvestLevel(MineFantasyBase.MFBlockOreInferno, 1, "pickaxe", 4);
/* 156 */     MinecraftForge.setBlockHarvestLevel(MineFantasyBase.MFBlockOreUtil, "pickaxe", 2);
/*     */     
/* 158 */     MinecraftForge.setBlockHarvestLevel(MineFantasyBase.MFBlockOreMythic, 0, "pickaxe", 4);
/* 159 */     MinecraftForge.setBlockHarvestLevel(MineFantasyBase.MFBlockOreMythic, 1, "pickaxe", 3);
/* 160 */     MinecraftForge.setBlockHarvestLevel(MineFantasyBase.MFBlockOreMythic, 2, "pickaxe", 3);
/* 161 */     MinecraftForge.setBlockHarvestLevel(MineFantasyBase.MFBlockForge, 1, "pickaxe", 3);
/*     */     
/* 163 */     if (!cfg.weakIron) {
/* 164 */       MinecraftForge.setBlockHarvestLevel(Block.field_71949_H, "pickaxe", 2);
/*     */     }
/* 166 */     MinecraftForge.setBlockHarvestLevel(MineFantasyBase.MFBlockOreUmite, "pickaxe", 4);
/* 167 */     MinecraftForge.setBlockHarvestLevel(MineFantasyBase.MFBlockGranite, "pickaxe", 2);
/* 168 */     MinecraftForge.setBlockHarvestLevel(MineFantasyBase.MFBlockLimestone, "pickaxe", 1);
/* 169 */     MinecraftForge.setBlockHarvestLevel(MineFantasyBase.MFBlockGraniteBrick, "pickaxe", 2);
/* 170 */     MinecraftForge.setBlockHarvestLevel(MineFantasyBase.MFBlockLog, "axe", 1);
/* 171 */     MinecraftForge.setBlockHarvestLevel(MineFantasyBase.MFBlockPlanks, "axe", 1);
/* 172 */     MinecraftForge.setBlockHarvestLevel(MineFantasyBase.MFBlockRoad, "shovel", 0);
/*     */     
/* 174 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockSpinningWheel, "SpinningWheel");
/* 175 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockOreInferno, ItemBlockHellCoal.class, "oreInferno");
/* 176 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockTailor, "Tailor");
/* 177 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockSlateStairs, "slateStair");
/* 178 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockSlateStairsTile, "slateStairTile");
/* 179 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockSlateDStairsTile, "slateDTileStair");
/* 180 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockSlateStairsBrick, "slateStairBrick");
/*     */     
/* 182 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockOven, minefantasy.block.special.ItemBlockOven.class, "ovenMF");
/* 183 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockFoodPrep, "benchMF");
/* 184 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockFurnace, minefantasy.block.special.ItemBlockFurnaceMF.class, "furnaceMF");
/* 185 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockTripHammer, ItemBlockTripHammer.class, "tripHammer");
/* 186 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockSlate, ItemBlockSlate.class, "slateMF");
/* 187 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockFirepit, "fireMF");
/* 188 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockSlag, "slag");
/* 189 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockChimney, ItemBlockChimney.class, "chimneyMF");
/* 190 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockStorage, ItemBlockStorageMF.class, "metalMF");
/* 191 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockPlanks, ItemBlockTreeMF.class, "planksMF");
/* 192 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockLantern, "lanternMF");
/* 193 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockDoorIronbark, "doorIBark");
/* 194 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockDoorHard, "doorRe");
/* 195 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockDoorSteel, "doorSteel");
/* 196 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockBlast, ItemBlockBlastFurnace.class, "blastFurn");
/* 197 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockBellow, "bellowsMF");
/* 198 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockLimestone, "limestoneMF");
/* 199 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockSmelter, ItemBlockSmelter.class, "smelterMF");
/* 200 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockOreTin, "oreTin");
/* 201 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockOreCopper, "oreCopper");
/* 202 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockOreMythic, ItemBlockMythicOre.class, "oreMythic");
/* 203 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockForge, minefantasy.block.special.ItemBlockForge.class, "forgeMF");
/* 204 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockAnvil, ItemBlockAnvil.class, "anvilMF");
/* 205 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockMudBrick, ItemBlockMudbrick.class, "mudBrick");
/* 206 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockStairSmoothstone, "smoothStair");
/* 207 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockStairCobbBrick, "cobbBrickStair");
/* 208 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockStairCobbBrickRough, "cobbBrickStairRough");
/* 209 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockCobbBrick, ItemBlockCobbbrick.class, "cobbBrick");
/* 210 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockRePlanks, "rePlanks");
/* 211 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockOreUtil, ItemBlockUtilOre.class, "oreUtil");
/* 212 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockOreUmite, "oreIgnotumite");
/* 213 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockClayWall, ItemBlockWallclayMF.class, "clayWall");
/* 214 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockRoad, "roadMF");
/* 215 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockLowRoad, "lowRoadMF");
/* 216 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockGranite, "graniteMF");
/* 217 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockGraniteBrick, ItemBlockGranbrick.class, "granBrickMF");
/* 218 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockLog, ItemBlockTreeMF.class, "logMF");
/* 219 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockLeaves, ItemBlockTreeMF.class, "leavesMF");
/* 220 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockTanner, "tannerMF");
/* 221 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockSapling, ItemBlockSaplingMF.class, "saplingMF");
/* 222 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockDogbowl, minefantasy.block.special.ItemBlockDogbowl.class, "dogBowl");
/* 223 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockWeaponRack, "weaponRack");
/* 224 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockRoast, "spitRoast");
/* 225 */     GameRegistry.registerBlock(MineFantasyBase.MFBlockHayRoof, "hayRoof");
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/MFBlockList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */