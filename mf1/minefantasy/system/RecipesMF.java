/*     */ package minefantasy.system;
/*     */ 
/*     */ import cpw.mods.fml.common.registry.GameRegistry;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.api.MineFantasyAPI;
/*     */ import minefantasy.api.forge.ItemHandler;
/*     */ import minefantasy.api.tailor.StringList;
/*     */ import minefantasy.api.tanner.LeathercuttingRecipes;
/*     */ import minefantasy.api.tanner.TanningRecipes;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.FurnaceRecipes;
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
/*     */ public class RecipesMF
/*     */ {
/*     */   public static void initiate()
/*     */   {
/*  34 */     addBombs();
/*  35 */     addLeatherRecipes();
/*  36 */     addTailoring();
/*  37 */     addPrimitive();
/*  38 */     addHeatables();
/*  39 */     addHaftTiers();
/*  40 */     addIngotAlternatives();
/*  41 */     addFletching();
/*     */     
/*  43 */     addBlock(new ItemStack(MineFantasyBase.MFBlockStorage, 1, 0), new ItemStack(ItemListMF.ingotSteel));
/*  44 */     addBlock(com(111), com(108));
/*  45 */     addBlock(new ItemStack(Block.field_71998_bu), com(110));
/*  46 */     addBlock(new ItemStack(MineFantasyBase.MFBlockStorage, 1, 1), com(56));
/*  47 */     addBlock(new ItemStack(MineFantasyBase.MFBlockStorage, 1, 2), com(57));
/*  48 */     addBlock(new ItemStack(MineFantasyBase.MFBlockStorage, 1, 3), com(58));
/*  49 */     addBlock(new ItemStack(MineFantasyBase.MFBlockStorage, 1, 4), com(55));
/*  50 */     addBlock(new ItemStack(MineFantasyBase.MFBlockStorage, 1, 5), new ItemStack(ItemListMF.ingotSilver));
/*  51 */     addBlock(new ItemStack(MineFantasyBase.MFBlockStorage, 1, 7), com(60));
/*  52 */     addBlock(new ItemStack(MineFantasyBase.MFBlockStorage, 1, 8), com(185));
/*  53 */     ArrayList<ItemStack> steel = OreDictionary.getOres("ingotSteel");
/*  54 */     ArrayList<ItemStack> copper = OreDictionary.getOres("ingotCopper");
/*  55 */     ArrayList<ItemStack> tin = OreDictionary.getOres("ingotTin");
/*  56 */     ArrayList<ItemStack> copperB = OreDictionary.getOres("blockCopper");
/*  57 */     ArrayList<ItemStack> Silver = OreDictionary.getOres("ingotSilver");
/*     */     
/*  59 */     MineFantasyAPI.addOvenRecipe(com(16), com(10, 2));
/*  60 */     FurnaceRecipes.func_77602_a().addSmelting(ItemListMF.misc.field_77779_bT, 16, com(10, 2), 0.0F);
/*  61 */     for (int a = 0; a < steel.size(); a++) {
/*  62 */       addSteel((ItemStack)steel.get(a));
/*     */     }
/*  64 */     addSalt("salt");
/*  65 */     addSalt("oreSalt");
/*  66 */     addSalt("foodSalt");
/*  67 */     GameRegistry.addShapelessRecipe(com(10), new Object[] { com(16) });
/*  68 */     for (int a = 0; a < copper.size(); a++) {
/*  69 */       addCopper((ItemStack)copper.get(a));
/*  70 */       for (int b = 0; b < tin.size(); b++) {
/*  71 */         MineFantasyAPI.addRatioAlloy(5, com(58, 3), new Object[] { copper.get(a), copper.get(a), tin.get(b) });
/*     */       }
/*     */     }
/*     */     
/*  75 */     GameRegistry.addRecipe(new ItemStack(ItemListMF.malletWood), new Object[] { "W", "G", "S", Character.valueOf('G'), com(88), Character.valueOf('W'), ItemListMF.plank, Character.valueOf('S'), Item.field_77669_D });
/*  76 */     GameRegistry.addRecipe(new ItemStack(ItemListMF.malletIronbark), new Object[] { "W", "G", "S", Character.valueOf('G'), com(89), Character.valueOf('W'), com(25), Character.valueOf('S'), com(87) });
/*  77 */     GameRegistry.addRecipe(new ItemStack(ItemListMF.malletEbony), new Object[] { "W", "G", "S", Character.valueOf('G'), com(89), Character.valueOf('W'), com(114), Character.valueOf('S'), com(126) });
/*     */     
/*  79 */     for (int a = 0; a < ItemHandler.carbon.size(); a++) {
/*  80 */       MineFantasyAPI.addRatioAlloy(5, com(166), 1, new Object[] { ItemHandler.carbon.get(a), ItemHandler.carbon.get(a), com(60) });
/*     */       
/*  82 */       MineFantasyAPI.addSpecialSmelt(new ItemStack(ItemListMF.ingotSteel), 2, new Object[] { ItemHandler.carbon.get(a), ItemHandler.carbon.get(a), ItemHandler.carbon.get(a), com(60) });
/*     */     }
/*  84 */     MineFantasyAPI.addSpecialSmelt(com(14, 2), 1, com(15));
/*  85 */     MineFantasyAPI.addCrushRecipe(Item.field_77705_m.field_77779_bT, com(15));
/*     */     
/*  87 */     for (int a = 0; a < ItemHandler.flux.size(); a++) {
/*  88 */       MineFantasyAPI.addRatioAlloy(5, com(167), 0, new Object[] { Item.field_77717_p, Item.field_77717_p, Item.field_77717_p, Item.field_77717_p, ItemHandler.flux.get(a) });
/*     */       
/*  90 */       MineFantasyAPI.addRatioAlloy(5, com(153), 1, new Object[] { com(52), ItemHandler.flux.get(a), ItemHandler.flux.get(a), ItemHandler.flux.get(a), ItemHandler.flux.get(a) });
/*     */       
/*     */ 
/*  93 */       MineFantasyAPI.addRatioAlloy(5, com(55, 4), 1, new Object[] { com(53), ItemListMF.ingotSilver, ItemListMF.ingotSilver, ItemListMF.ingotSilver, ItemListMF.ingotSilver, ItemHandler.flux.get(a) });
/*     */       
/*  95 */       GameRegistry.addRecipe(new ItemStack(ItemListMF.boltMF, 8, 0), new Object[] { "H", "F", Character.valueOf('H'), Item.field_77804_ap, Character.valueOf('F'), Item.field_77676_L });
/*     */       
/*  97 */       GameRegistry.addRecipe(com(11), new Object[] { "SS", "SS", Character.valueOf('S'), com(12) });
/*     */       
/*  99 */       for (int b = 0; b < ItemHandler.carbon.size(); b++) {
/* 100 */         MineFantasyAPI.addRatioAlloy(5, com(22), 1, new Object[] { com(21), ItemHandler.flux.get(a), ItemHandler.flux.get(a), ItemHandler.flux.get(a), ItemHandler.carbon.get(b) });
/*     */       }
/*     */     }
/*     */     
/* 104 */     for (ItemStack ore : tin) {
/* 105 */       GameRegistry.addRecipe(new ItemStack(Item.field_77788_aw), new Object[] { "I I", " I ", Character.valueOf('I'), ore });
/*     */     }
/*     */     
/* 108 */     for (ItemStack bronze : OreDictionary.getOres("ingotBronze")) {
/* 109 */       GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockAnvil, 1, 1), new Object[] { " II", "III", " L ", Character.valueOf('L'), Block.field_71978_w, Character.valueOf('I'), bronze });
/*     */       
/* 111 */       GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockChimney, 8, 4), new Object[] { "I I", "I I", "I I", Character.valueOf('I'), bronze });
/*     */     }
/* 113 */     for (ItemStack deepIron : OreDictionary.getOres("ingotDeepIron")) {
/* 114 */       GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockChimney, 12, 5), new Object[] { "I I", "I I", "I I", Character.valueOf('I'), deepIron });
/* 115 */       GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockAnvil, 1, 7), new Object[] { " II", "III", " L ", Character.valueOf('L'), Block.field_71978_w, Character.valueOf('I'), deepIron });
/*     */     }
/* 117 */     for (ItemStack mithril : OreDictionary.getOres("ingotMithril"))
/*     */     {
/* 119 */       GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockChimney, 8, 4), new Object[] { "I I", "I I", "I I", Character.valueOf('I'), mithril });
/*     */     }
/*     */     
/*     */ 
/* 123 */     if ((cfg.easyIron) || (MineFantasyBase.isDebug())) {
/* 124 */       addEasyIron();
/*     */     } else {
/* 126 */       addIron();
/*     */     }
/*     */     
/*     */ 
/* 130 */     MineFantasyAPI.addBlastRecipe(new ItemStack(MineFantasyBase.MFBlockOreMythic.field_71990_ca, 1, 1), com(185));
/* 131 */     MineFantasyAPI.addBlastRecipe(new ItemStack(MineFantasyBase.MFBlockOreMythic.field_71990_ca, 1, 2), com(185));
/*     */     
/* 133 */     MineFantasyAPI.addBlastRecipe(new ItemStack(MineFantasyBase.MFBlockOreMythic.field_71990_ca, 1, 0), com(53));
/* 134 */     MineFantasyAPI.addBlastRecipe(new ItemStack(ItemListMF.misc, 1, 50), new ItemStack(ItemListMF.misc, 1, 52));
/*     */     
/* 136 */     FurnaceRecipes.func_77602_a().addSmelting(ItemListMF.misc.field_77779_bT, 113, new ItemStack(ItemListMF.misc, 1, 56), 0.5F);
/*     */     
/* 138 */     GameRegistry.addSmelting(ItemListMF.muttonRaw.field_77779_bT, new ItemStack(ItemListMF.muttonCooked), 0.1F);
/* 139 */     GameRegistry.addSmelting(ItemListMF.drakeRaw.field_77779_bT, new ItemStack(ItemListMF.drakeCooked), 0.3F);
/* 140 */     GameRegistry.addSmelting(ItemListMF.basiliskRaw.field_77779_bT, new ItemStack(ItemListMF.basiliskCooked), 0.2F);
/* 141 */     GameRegistry.addSmelting(MineFantasyBase.MFBlockOreUtil.field_71990_ca, new ItemStack(ItemListMF.ingotSilver), 1.0F);
/* 142 */     GameRegistry.addSmelting(MineFantasyBase.MFBlockOreTin.field_71990_ca, com(57), 0.6F);
/* 143 */     GameRegistry.addSmelting(MineFantasyBase.MFBlockOreCopper.field_71990_ca, com(56), 0.5F);
/* 144 */     GameRegistry.addSmelting(MineFantasyBase.MFBlockOreUmite.field_71990_ca, com(152), 20.0F);
/*     */     
/*     */ 
/* 147 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockWoodSingleSlab, 6, 0), new Object[] { "HHH", Character.valueOf('H'), new ItemStack(MineFantasyBase.MFBlockPlanks, 0, 0) });
/* 148 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockWoodSingleSlab, 6, 1), new Object[] { "HHH", Character.valueOf('H'), new ItemStack(MineFantasyBase.MFBlockPlanks, 0, 1) });
/* 149 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockWoodSingleSlab, 6, 2), new Object[] { "HHH", Character.valueOf('H'), MineFantasyBase.MFBlockRePlanks });
/* 150 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockWoodSingleSlab, 6, 3), new Object[] { "HHH", "HHH", Character.valueOf('H'), Item.field_77685_T });
/*     */     
/* 152 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockStoneSingleSlab, 6, 0), new Object[] { "HHH", Character.valueOf('H'), new ItemStack(MineFantasyBase.MFBlockCobbBrick, 1, 0) });
/* 153 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockStoneSingleSlab, 6, 1), new Object[] { "HHH", Character.valueOf('H'), MineFantasyBase.MFBlockGranite });
/* 154 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockStoneSingleSlab, 6, 2), new Object[] { "HHH", Character.valueOf('H'), new ItemStack(MineFantasyBase.MFBlockGraniteBrick, 0, 0) });
/* 155 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockStoneSingleSlab, 2, 3), new Object[] { "H", "H", Character.valueOf('H'), new ItemStack(Block.field_72079_ak, 0, 0) });
/* 156 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockStoneSingleSlab, 6, 4), new Object[] { "HHH", Character.valueOf('H'), new ItemStack(MineFantasyBase.MFBlockMudBrick, 1, 0) });
/* 157 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockStoneSingleSlab, 6, 5), new Object[] { "HHH", Character.valueOf('H'), new ItemStack(MineFantasyBase.MFBlockCobbBrick, 1, 3) });
/* 158 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockStoneSingleSlab, 6, 6), new Object[] { "HHH", Character.valueOf('H'), new ItemStack(MineFantasyBase.MFBlockMudBrick, 1, 1) });
/*     */     
/* 160 */     GameRegistry.addRecipe(new ItemStack(Item.field_77763_aO), new Object[] { "F", "M", Character.valueOf('M'), Item.field_77773_az, Character.valueOf('F'), new ItemStack(MineFantasyBase.MFBlockFurnace, 1, 0) });
/*     */     
/* 162 */     for (int a = 0; a < 4; a++) {
/* 163 */       GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockSlateSingleSlab, 6, a), new Object[] { "HHH", Character.valueOf('H'), new ItemStack(MineFantasyBase.MFBlockSlate, 1, a) });
/*     */     }
/* 165 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockSlateStairs, 4), new Object[] { "S  ", "SS ", "SSS", Character.valueOf('S'), new ItemStack(MineFantasyBase.MFBlockSlate, 1, 0) });
/* 166 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockSlateStairsTile, 4), new Object[] { "S  ", "SS ", "SSS", Character.valueOf('S'), new ItemStack(MineFantasyBase.MFBlockSlate, 1, 1) });
/* 167 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockSlateDStairsTile, 4), new Object[] { "S  ", "SS ", "SSS", Character.valueOf('S'), new ItemStack(MineFantasyBase.MFBlockSlate, 1, 2) });
/* 168 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockSlateStairsBrick, 4), new Object[] { "S  ", "SS ", "SSS", Character.valueOf('S'), new ItemStack(MineFantasyBase.MFBlockSlate, 1, 3) });
/*     */     
/* 170 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockDogbowl), new Object[] { "PBP", " P ", Character.valueOf('P'), ItemListMF.plank, Character.valueOf('B'), Item.field_77670_E });
/*     */     
/* 172 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockSmelter), new Object[] { " S ", "S S", "SSS", Character.valueOf('S'), Block.field_71978_w });
/*     */     
/* 174 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockSmelter, 1, 1), new Object[] { "S S", "S S", " S ", Character.valueOf('S'), Block.field_71978_w });
/*     */     
/* 176 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockSmelter, 1, 2), new Object[] { "S S", "S S", " S ", Character.valueOf('S'), MineFantasyBase.MFBlockGranite });
/*     */     
/* 178 */     GameRegistry.addRecipe(com(113), new Object[] { "W", Character.valueOf('W'), MineFantasyBase.MFBlockOreCopper });
/*     */     
/* 180 */     GameRegistry.addRecipe(new ItemStack(Block.field_71988_x), new Object[] { "WW", "WW", Character.valueOf('W'), ItemListMF.plank });
/* 181 */     GameRegistry.addRecipe(new ItemStack(Item.field_77669_D, 4), new Object[] { "W", "W", Character.valueOf('W'), ItemListMF.plank });
/*     */     
/* 183 */     GameRegistry.addShapelessRecipe(com(90), new Object[] { Item.field_77705_m, Item.field_77722_bw });
/*     */     
/* 185 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemListMF.transferHound), new Object[] { Item.field_77759_aK, Item.field_77676_L, new ItemStack(Item.field_77756_aW, 1, 0), Item.field_77755_aX });
/*     */     
/* 187 */     GameRegistry.addRecipe(com(91, 8), new Object[] { "CCC", "CGC", "CCC", Character.valueOf('C'), new ItemStack(Item.field_77705_m, 1, 0), Character.valueOf('G'), com(19) });
/*     */     
/* 189 */     GameRegistry.addRecipe(com(91, 6), new Object[] { "CCC", "CGC", "CCC", Character.valueOf('C'), new ItemStack(Item.field_77705_m, 1, 1), Character.valueOf('G'), com(19) });
/*     */     
/* 191 */     GameRegistry.addShapelessRecipe(com(92), new Object[] { Item.field_77705_m, Block.field_72012_bb });
/*     */     
/* 193 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockChimney, 8, 0), new Object[] { "I I", "I I", "I I", Character.valueOf('I'), com(60) });
/*     */     
/* 195 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockChimney, 8, 2), new Object[] { "I I", "I I", "I I", Character.valueOf('I'), MineFantasyBase.MFBlockCobbBrick });
/*     */     
/* 197 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockChimney, 8, 3), new Object[] { "I I", "I I", "I I", Character.valueOf('I'), Block.field_72081_al });
/*     */     
/* 199 */     GameRegistry.addRecipe(new RecipeBookClone());
/*     */     
/* 201 */     GameRegistry.addRecipe(new ItemStack(ItemListMF.doorIronbark), new Object[] { "HH", "HH", "HH", Character.valueOf('H'), new ItemStack(MineFantasyBase.MFBlockPlanks, 1, 0) });
/*     */     
/* 203 */     GameRegistry.addRecipe(new ItemStack(ItemListMF.doorHard), new Object[] { "HH", "HH", "HH", Character.valueOf('H'), MineFantasyBase.MFBlockRePlanks });
/* 204 */     GameRegistry.addRecipe(new ItemStack(ItemListMF.doorSteel), new Object[] { "HH", "HH", "HH", Character.valueOf('H'), ItemListMF.ingotSteel });
/*     */     
/* 206 */     for (ItemStack lime : OreDictionary.getOres("blockLimestone")) {
/* 207 */       GameRegistry.addRecipe(com(66, 4), new Object[] { "L", Character.valueOf('L'), lime });
/*     */     }
/* 209 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockLimestone), new Object[] { "LL", "LL", Character.valueOf('L'), com(66) });
/*     */     
/* 211 */     GameRegistry.addRecipe(new ItemStack(ItemListMF.misc, 8, 23), new Object[] { " S ", " P ", "P P", Character.valueOf('P'), Item.field_77759_aK, Character.valueOf('S'), Item.field_77669_D });
/*     */     
/* 213 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockBellow), new Object[] { "WWP", "LL ", "WW ", Character.valueOf('W'), Block.field_71988_x, Character.valueOf('P'), ItemListMF.plank, Character.valueOf('L'), Item.field_77770_aF });
/*     */     
/* 215 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockAnvil, 1, 0), new Object[] { " CC", "CCC", " C ", Character.valueOf('C'), Block.field_71978_w });
/*     */     
/* 217 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockAnvil, 1, 3), new Object[] { " II", "III", " L ", Character.valueOf('L'), Block.field_71978_w, Character.valueOf('I'), com(60) });
/*     */     
/* 219 */     GameRegistry.addRecipe(new ItemStack(Block.field_82510_ck, 1, 0), new Object[] { "III", " I ", "III", Character.valueOf('I'), com(60) });
/*     */     
/* 221 */     for (ItemStack steelI : steel) {
/* 222 */       GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockAnvil, 1, 5), new Object[] { " II", "III", " L ", Character.valueOf('L'), Block.field_71978_w, Character.valueOf('I'), steelI });
/*     */     }
/*     */     
/* 225 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockLantern, 1), new Object[] { "SPS", "GTG", "SPS", Character.valueOf('S'), Item.field_77669_D, Character.valueOf('G'), Block.field_72003_bq, Character.valueOf('T'), Block.field_72069_aq, Character.valueOf('P'), Block.field_71988_x });
/*     */     
/* 227 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockForge, 1), new Object[] { "S S", "SCS", "CCC", Character.valueOf('C'), Item.field_77705_m, Character.valueOf('S'), Block.field_72007_bm });
/* 228 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockForge, 1, 1), new Object[] { "S S", "SCS", "CCC", Character.valueOf('C'), Item.field_77705_m, Character.valueOf('S'), MineFantasyBase.MFBlockCobbBrick });
/*     */     
/* 230 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockForge, 1), new Object[] { "S S", "SCS", "CCC", Character.valueOf('C'), new ItemStack(Item.field_77705_m, 1, 2), Character.valueOf('S'), Block.field_72007_bm });
/* 231 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockForge, 1, 1), new Object[] { "S S", "SCS", "CCC", Character.valueOf('C'), new ItemStack(Item.field_77705_m, 1, 1), Character.valueOf('S'), MineFantasyBase.MFBlockCobbBrick });
/*     */     
/* 233 */     GameRegistry.addRecipe(new ItemStack(ItemListMF.plank), new Object[] { "P", "P", Character.valueOf('P'), Item.field_77669_D });
/*     */     
/* 235 */     GameRegistry.addRecipe(com(25), new Object[] { "P", "P", Character.valueOf('P'), com(87) });
/* 236 */     GameRegistry.addRecipe(com(114), new Object[] { "P", "P", Character.valueOf('P'), com(126) });
/*     */     
/* 238 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockGraniteBrick, 4), new Object[] { "PP", "PP", Character.valueOf('P'), MineFantasyBase.MFBlockGranite });
/*     */     
/* 240 */     addCobbleConversion(MineFantasyBase.MFBlockCobbBrick);
/* 241 */     addCobbleConversion(MineFantasyBase.MFBlockCobbBrick, Block.field_71978_w);
/*     */     
/* 243 */     addMudbrickConversion(MineFantasyBase.MFBlockMudBrick);
/* 244 */     addMudbrickConversion(MineFantasyBase.MFBlockMudBrick, Block.field_71979_v);
/*     */     
/* 246 */     addSlateConversion(MineFantasyBase.MFBlockSlate);
/* 247 */     addSlateConversion(MineFantasyBase.MFBlockSlateDoubleSlab);
/* 248 */     addSlateConversion(MineFantasyBase.MFBlockSlateSingleSlab);
/*     */     
/* 250 */     Block[] stairConvert = { MineFantasyBase.MFBlockSlateStairs, MineFantasyBase.MFBlockSlateStairsTile, MineFantasyBase.MFBlockSlateDStairsTile, MineFantasyBase.MFBlockSlateStairsBrick };
/* 251 */     for (Block block : stairConvert) {
/* 252 */       GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockSlateStairsBrick, 4), new Object[] { "PP", "PP", Character.valueOf('P'), block });
/* 253 */       GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockSlateDStairsTile, 4), new Object[] { " P ", "P P", " P ", Character.valueOf('P'), block });
/* 254 */       GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockSlateStairsTile, 4), new Object[] { "P P", "   ", "P P", Character.valueOf('P'), block });
/* 255 */       GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockSlateStairs), new Object[] { "P", Character.valueOf('P'), block });
/*     */     }
/*     */     
/* 258 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockRePlanks, 6), new Object[] { "SIS", "SIS", "SIS", Character.valueOf('I'), Item.field_77703_o, Character.valueOf('S'), Block.field_71988_x });
/*     */     
/* 260 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockClayWall, 4), new Object[] { " P ", "PCP", " P ", Character.valueOf('C'), Block.field_72041_aW, Character.valueOf('P'), ItemListMF.plank });
/*     */     
/* 262 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockClayWall, 1, 1), new Object[] { "P P", " C ", "P P", Character.valueOf('C'), MineFantasyBase.MFBlockClayWall, Character.valueOf('P'), ItemListMF.plank });
/*     */     
/* 264 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockClayWall, 1, 2), new Object[] { "  P", " C ", "PP ", Character.valueOf('C'), MineFantasyBase.MFBlockClayWall, Character.valueOf('P'), ItemListMF.plank });
/*     */     
/* 266 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockClayWall, 1, 3), new Object[] { "PP ", " C ", "  P", Character.valueOf('C'), MineFantasyBase.MFBlockClayWall, Character.valueOf('P'), ItemListMF.plank });
/*     */     
/* 268 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemListMF.misc, 8, 20), new Object[] { new ItemStack(ItemListMF.misc, 1, 19), Item.field_77677_M });
/* 269 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemListMF.misc, 1, 20), new Object[] { Item.field_77722_bw, Item.field_77677_M });
/*     */     
/* 271 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemListMF.explosive, 4), new Object[] { com(15), com(24), com(177) });
/*     */     
/* 273 */     GameRegistry.addRecipe(new ItemStack(Item.field_77677_M), new Object[] { "BB", "BB", Character.valueOf('B'), ItemListMF.explosive });
/*     */     
/* 275 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockPlanks, 4, 0), new Object[] { "I", Character.valueOf('I'), new ItemStack(MineFantasyBase.MFBlockLog, 1, 0) });
/*     */     
/* 277 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockPlanks, 4, 1), new Object[] { "I", Character.valueOf('I'), new ItemStack(MineFantasyBase.MFBlockLog, 1, 1) });
/*     */     
/* 279 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockPlanks, 1, 0), new Object[] { "PP", "PP", Character.valueOf('P'), com(25) });
/* 280 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockPlanks, 1, 1), new Object[] { "PP", "PP", Character.valueOf('P'), com(114) });
/*     */     
/* 282 */     GameRegistry.addRecipe(new ItemStack(Block.field_72060_ay), new Object[] { "II", "II", Character.valueOf('I'), MineFantasyBase.MFBlockPlanks });
/*     */     
/* 284 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockFoodPrep), new Object[] { "III", Character.valueOf('I'), ItemListMF.plank });
/*     */     
/* 286 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockHayRoof, 4), new Object[] { "  I", " II", "III", Character.valueOf('I'), Item.field_77685_T });
/* 287 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockHayRoof, 4), new Object[] { "I  ", "II ", "III", Character.valueOf('I'), Item.field_77685_T });
/*     */     
/* 289 */     GameRegistry.addRecipe(com(87, 4), new Object[] { "I", "I", Character.valueOf('I'), com(25) });
/* 290 */     GameRegistry.addRecipe(com(126, 4), new Object[] { "I", "I", Character.valueOf('I'), com(114) });
/*     */     
/* 292 */     GameRegistry.addRecipe(com(25, 8), new Object[] { "I", "I", Character.valueOf('I'), new ItemStack(MineFantasyBase.MFBlockPlanks, 1, 0) });
/*     */     
/* 294 */     GameRegistry.addRecipe(com(114, 8), new Object[] { "I", "I", Character.valueOf('I'), new ItemStack(MineFantasyBase.MFBlockPlanks, 1, 1) });
/*     */     
/* 296 */     GameRegistry.addRecipe(new ItemStack(Item.field_77670_E, 4), new Object[] { "I I", " I ", Character.valueOf('I'), MineFantasyBase.MFBlockPlanks });
/* 297 */     GameRegistry.addRecipe(new ItemStack(Block.field_72046_aM), new Object[] { "II", Character.valueOf('I'), MineFantasyBase.MFBlockPlanks });
/* 298 */     GameRegistry.addRecipe(new ItemStack(Item.field_77790_av), new Object[] { "II", "II", "II", Character.valueOf('I'), MineFantasyBase.MFBlockPlanks });
/* 299 */     GameRegistry.addRecipe(new ItemStack(Block.field_72005_bk, 2), new Object[] { "III", "III", Character.valueOf('I'), MineFantasyBase.MFBlockPlanks });
/* 300 */     GameRegistry.addRecipe(new ItemStack(Block.field_72077_au, 1), new Object[] { "III", "I I", "III", Character.valueOf('I'), MineFantasyBase.MFBlockPlanks });
/* 301 */     GameRegistry.addRecipe(new ItemStack(Item.field_77769_aE, 1), new Object[] { "I I", "III", Character.valueOf('I'), MineFantasyBase.MFBlockPlanks });
/* 302 */     GameRegistry.addRecipe(new ItemStack(Item.field_77792_au, 1), new Object[] { "III", "III", " V ", Character.valueOf('I'), MineFantasyBase.MFBlockPlanks, Character.valueOf('V'), Item.field_77669_D });
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
/* 322 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemListMF.misc, 1, 5), new Object[] { new ItemStack(ItemListMF.misc, 1, 4), new ItemStack(ItemListMF.misc, 1, 0) });
/*     */     
/* 324 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockTanner), new Object[] { "PPP", "P P", "WWW", Character.valueOf('W'), Block.field_71988_x, Character.valueOf('P'), ItemListMF.plank });
/* 325 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockRoast), new Object[] { "SSS", "P P", Character.valueOf('S'), Item.field_77669_D, Character.valueOf('P'), ItemListMF.plank });
/*     */     
/* 327 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockTanner), new Object[] { "PPP", "P P", "WWW", Character.valueOf('W'), MineFantasyBase.MFBlockPlanks, Character.valueOf('P'), ItemListMF.plank });
/*     */     
/* 329 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockWeaponRack), new Object[] { "P P", "PPP", "P P", Character.valueOf('P'), ItemListMF.plank });
/* 330 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockStairSmoothstone, 4), new Object[] { "S  ", "SS ", "SSS", Character.valueOf('S'), Block.field_71981_t });
/* 331 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockStairCobbBrick, 4), new Object[] { "S  ", "SS ", "SSS", Character.valueOf('S'), new ItemStack(MineFantasyBase.MFBlockCobbBrick, 1, 0) });
/* 332 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockStairCobbBrickRough, 4), new Object[] { "S  ", "SS ", "SSS", Character.valueOf('S'), new ItemStack(MineFantasyBase.MFBlockCobbBrick, 1, 3) });
/*     */   }
/*     */   
/*     */   private static void addSalt(String type)
/*     */   {
/* 337 */     ArrayList<ItemStack> salts = OreDictionary.getOres(type);
/* 338 */     if ((salts != null) && (!salts.isEmpty())) {
/* 339 */       for (ItemStack salt : salts) {
/* 340 */         GameRegistry.addShapelessRecipe(new ItemStack(ItemListMF.misc, 1, 5), new Object[] { new ItemStack(ItemListMF.misc, 1, 4), salt });
/*     */         
/* 342 */         GameRegistry.addShapelessRecipe(com(0), new Object[] { salt, salt });
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static void addIron() {
/* 348 */     MineFantasyAPI.addCrushRecipe(new ItemStack(Item.field_77703_o), com(60));
/* 349 */     MineFantasyAPI.addBlastRecipe(Block.field_71949_H.field_71990_ca, new ItemStack(Item.field_77703_o));
/* 350 */     MineFantasyAPI.addBloomRecipe(new ItemStack(Block.field_71949_H), com(60), 1600);
/*     */   }
/*     */   
/*     */   private static void addEasyIron() {
/* 354 */     MineFantasyAPI.addBloomRecipe(new ItemStack(Block.field_71949_H), com(60), 800);
/* 355 */     MineFantasyAPI.addSpecialSmelt(com(60), -1, new ItemStack(Block.field_71949_H));
/* 356 */     MineFantasyAPI.addRatioAlloy(8, new ItemStack(Item.field_77703_o), 0, new Object[] { com(60), com(0) });
/*     */   }
/*     */   
/*     */   private static void addSlateConversion(Block block) {
/* 360 */     GameRegistry.addRecipe(new ItemStack(block, 4, 3), new Object[] { "PP", "PP", Character.valueOf('P'), block });
/* 361 */     GameRegistry.addRecipe(new ItemStack(block, 4, 2), new Object[] { " P ", "P P", " P ", Character.valueOf('P'), block });
/* 362 */     GameRegistry.addRecipe(new ItemStack(block, 4, 1), new Object[] { "P P", "   ", "P P", Character.valueOf('P'), block });
/* 363 */     GameRegistry.addRecipe(new ItemStack(block, 1), new Object[] { "P", Character.valueOf('P'), block });
/*     */   }
/*     */   
/*     */   private static void addCobbleConversion(Block block) {
/* 367 */     addCobbleConversion(block, block);
/*     */   }
/*     */   
/*     */   private static void addCobbleConversion(Block block, Block block2) {
/* 371 */     GameRegistry.addRecipe(new ItemStack(block, 4, 3), new Object[] { "PP", "PP", Character.valueOf('P'), block2 });
/* 372 */     GameRegistry.addRecipe(new ItemStack(block, 4, 0), new Object[] { "P P", "   ", "P P", Character.valueOf('P'), block2 });
/*     */     
/* 374 */     if (block2 != Block.field_71978_w) {
/* 375 */       GameRegistry.addRecipe(new ItemStack(Block.field_71978_w), new Object[] { "P", Character.valueOf('P'), block2 });
/*     */     }
/*     */   }
/*     */   
/*     */   private static void addMudbrickConversion(Block block) {
/* 380 */     addMudbrickConversion(block, block);
/*     */   }
/*     */   
/*     */   private static void addMudbrickConversion(Block block, Block block2) {
/* 384 */     GameRegistry.addRecipe(new ItemStack(block, 4, 1), new Object[] { "PP", "PP", Character.valueOf('P'), block2 });
/* 385 */     GameRegistry.addRecipe(new ItemStack(block, 4, 0), new Object[] { "P P", "   ", "P P", Character.valueOf('P'), block2 });
/*     */     
/* 387 */     if (block2 != Block.field_71979_v) {
/* 388 */       GameRegistry.addRecipe(new ItemStack(Block.field_71979_v), new Object[] { "P", Character.valueOf('P'), block2 });
/*     */     }
/*     */   }
/*     */   
/*     */   private static void addIngotAlternatives() {
/* 393 */     GameRegistry.addShapelessRecipe(new ItemStack(Item.field_77760_aL), new Object[] { Item.field_77759_aK, Item.field_77759_aK, Item.field_77759_aK, com(7) });
/* 394 */     GameRegistry.addRecipe(new ItemStack(Block.field_71958_P), new Object[] { "CCC", "CBC", "CRC", Character.valueOf('C'), Block.field_71978_w, Character.valueOf('B'), ItemListMF.shortbow, Character.valueOf('R'), Item.field_77767_aC });
/*     */     
/* 396 */     GameRegistry.addRecipe(new ItemStack(Item.field_77721_bz), new Object[] { "I I", "I I", "III", Character.valueOf('I'), com(60) });
/* 397 */     GameRegistry.addRecipe(new ItemStack(Item.field_77773_az), new Object[] { "I I", "III", Character.valueOf('I'), com(60) });
/*     */     
/* 399 */     GameRegistry.addRecipe(new ItemStack(Block.field_72056_aG, 32), new Object[] { "I I", "ISI", "I I", Character.valueOf('S'), Item.field_77669_D, Character.valueOf('I'), ItemListMF.ingotSteel });
/*     */     
/* 401 */     GameRegistry.addShapelessRecipe(new ItemStack(Item.field_111212_ci), new Object[] { Item.field_77683_K, Item.field_77759_aK });
/*     */     
/* 403 */     GameRegistry.addRecipe(new ItemStack(Block.field_71954_T, 64), new Object[] { "I I", "ISI", "IRI", Character.valueOf('R'), Item.field_77767_aC, Character.valueOf('S'), Item.field_77669_D, Character.valueOf('I'), com(167) });
/* 404 */     GameRegistry.addRecipe(new ItemStack(Item.field_77778_at, 1, 1), new Object[] { "III", "IAI", "III", Character.valueOf('A'), Item.field_77706_j, Character.valueOf('I'), com(167) });
/*     */   }
/*     */   
/*     */   private static void addHaftTiers() {
/* 408 */     Object[] glueMats = { Item.field_77737_bm, Item.field_77754_aU, Item.field_77770_aF, com(7), com(109) };
/* 409 */     for (int a = 0; a < ItemHandler.flux.size(); a++) {
/* 410 */       for (Object mat : glueMats) {
/* 411 */         MineFantasyAPI.addRatioAlloy(8, com(88), 0, new Object[] { ItemHandler.flux.get(a), mat });
/*     */       }
/*     */     }
/* 414 */     MineFantasyAPI.addAlloy(com(89, 4), 1, new Object[] { com(88), com(88), com(88), com(88), Item.field_77761_aM });
/*     */     
/* 416 */     GameRegistry.addShapelessRecipe(com(89, 4), new Object[] { com(88), com(88), com(88), com(88), Item.field_77761_aM });
/*     */     
/* 418 */     MineFantasyAPI.addTailorRecipe(com(59, 1), 2, 2.0F, 1, new Object[] { "L", "P", Character.valueOf('L'), com(26), Character.valueOf('P'), ItemListMF.plank });
/*     */     
/* 420 */     MineFantasyAPI.addTailorRecipe(com(65, 1), 2, 4.0F, 1, new Object[] { "L", "G", "P", Character.valueOf('W'), Block.field_72101_ab, Character.valueOf('L'), com(26), Character.valueOf('G'), com(88), Character.valueOf('P'), ItemListMF.plank });
/*     */     
/* 422 */     MineFantasyAPI.addTailorRecipe(com(77, 1), 4, 5.0F, 1, new Object[] { " L ", "GWG", " P ", Character.valueOf('W'), Block.field_72101_ab, Character.valueOf('L'), com(26), Character.valueOf('G'), com(89), Character.valueOf('P'), com(25) });
/*     */     
/* 424 */     MineFantasyAPI.addTailorRecipe(com(83, 1), 4, 10.0F, 1, new Object[] { " L ", "GWG", " P ", Character.valueOf('W'), Block.field_72101_ab, Character.valueOf('L'), com(26), Character.valueOf('G'), com(89), Character.valueOf('P'), com(114) });
/*     */     
/* 426 */     MineFantasyAPI.addTailorRecipe(com(81, 1), 4, 10.0F, 1, new Object[] { " L ", "GWG", "IPI", Character.valueOf('W'), Block.field_72101_ab, Character.valueOf('L'), com(26), Character.valueOf('G'), com(88), Character.valueOf('I'), Item.field_77717_p, Character.valueOf('P'), com(114) });
/*     */   }
/*     */   
/*     */   private static void addCopper(ItemStack copper)
/*     */   {
/* 431 */     addBlock(new ItemStack(MineFantasyBase.MFBlockStorage, 1, 1), copper);
/*     */   }
/*     */   
/*     */   private static ItemStack block(int i) {
/* 435 */     return new ItemStack(MineFantasyBase.MFBlockStorage, 1, i);
/*     */   }
/*     */   
/*     */   private static void addBlock(ItemStack block, ItemStack item) {
/* 439 */     GameRegistry.addRecipe(block, new Object[] { "III", "III", "III", Character.valueOf('I'), item });
/*     */     
/* 441 */     GameRegistry.addRecipe(new ItemStack(item.field_77993_c, 9, item.func_77960_j()), new Object[] { "I", Character.valueOf('I'), block });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void addSteel(ItemStack ore)
/*     */   {
/* 448 */     MineFantasyAPI.addRatioAlloy(1, com(21, 1), 1, new Object[] { ore, com(19), Item.field_77717_p });
/*     */     
/* 450 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockChimney, 8, 1), new Object[] { "I I", "I I", "I I", Character.valueOf('I'), ore });
/*     */     
/* 452 */     GameRegistry.addRecipe(new ItemStack(Item.field_77709_i), new Object[] { "A ", " B", Character.valueOf('A'), ore, Character.valueOf('B'), Item.field_77804_ap });
/*     */   }
/*     */   
/*     */   public static void addFinalRecipes() {
/* 456 */     GameRegistry.addRecipe(new ItemStack(Item.field_77776_ba), new Object[] { "C  ", "CCC", "WWW", Character.valueOf('C'), com(9), Character.valueOf('W'), ItemListMF.plank });
/*     */     
/* 458 */     for (ItemStack plank : OreDictionary.getOres("plankWood")) {
/* 459 */       GameRegistry.addRecipe(new ItemStack(ItemListMF.plank, 8), new Object[] { "W", "W", Character.valueOf('W'), plank });
/*     */     }
/*     */   }
/*     */   
/*     */   private static void addLeatherRecipes() {
/* 464 */     TanningRecipes.instance().addTanning(ItemListMF.misc.field_77779_bT, 190, com(4, 4));
/*     */     
/* 466 */     TanningRecipes.instance().addTanning(ItemListMF.misc.field_77779_bT, 17, com(4, 4));
/* 467 */     TanningRecipes.instance().addTanning(ItemListMF.misc.field_77779_bT, 33, com(4, 2));
/* 468 */     TanningRecipes.instance().addTanning(ItemListMF.misc.field_77779_bT, 98, com(4, 8));
/* 469 */     TanningRecipes.instance().addTanning(ItemListMF.misc.field_77779_bT, 101, com(4, 8));
/*     */     
/* 471 */     TanningRecipes.instance().addTanning(ItemListMF.misc.field_77779_bT, 3, com(4, 1));
/* 472 */     TanningRecipes.instance().addTanning(ItemListMF.misc.field_77779_bT, 6, com(4, 3));
/* 473 */     TanningRecipes.instance().addTanning(ItemListMF.misc.field_77779_bT, 154, com(4, 5));
/*     */     
/* 475 */     TanningRecipes.instance().addTanning(ItemListMF.misc.field_77779_bT, 157, com(4, 12));
/* 476 */     TanningRecipes.instance().addTanning(ItemListMF.misc.field_77779_bT, 160, com(4, 16));
/* 477 */     TanningRecipes.instance().addTanning(ItemListMF.misc.field_77779_bT, 163, com(4, 24));
/*     */     
/* 479 */     GameRegistry.addShapelessRecipe(com(8), new Object[] { com(7), Item.field_77737_bm });
/* 480 */     MineFantasyAPI.addFoodPrep(com(8), new ItemStack(Item.field_77770_aF), 2.5F, "mallet", MFResource.sound("mallet_use"));
/*     */     
/* 482 */     LeathercuttingRecipes.instance().addCutting(Item.field_77770_aF.field_77779_bT, new ItemStack(ItemListMF.misc, 8, 26));
/* 483 */     LeathercuttingRecipes.instance().addCutting(com(7), new ItemStack(ItemListMF.misc, 4, 26));
/*     */   }
/*     */   
/*     */   private static void addPrimitive() {
/* 487 */     GameRegistry.addRecipe(com(108), new Object[] { "D", Character.valueOf('D'), Block.field_71979_v });
/*     */     
/* 489 */     GameRegistry.addRecipe(new ItemStack(ItemListMF.rocks), new Object[] { "AR", "RA", Character.valueOf('R'), com(108) });
/*     */     
/* 491 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockFirepit), new Object[] { "P", Character.valueOf('P'), ItemListMF.plank });
/*     */     
/* 493 */     ItemStack[] rocks = { new ItemStack(Item.field_77804_ap), com(108) };
/* 494 */     ItemStack[] binds = { new ItemStack(Item.field_77683_K), com(110), com(109) };
/* 495 */     ItemStack[] hides = { com(4), com(17), com(3), com(6), com(101), com(98), com(33) };
/*     */     
/* 497 */     for (ItemStack rock : rocks) {
/* 498 */       for (ItemStack bind : binds) {
/* 499 */         GameRegistry.addRecipe(new ItemStack(ItemListMF.spearStone), new Object[] { "ATR", "AST", "SAA", Character.valueOf('S'), Item.field_77669_D, Character.valueOf('T'), bind, Character.valueOf('R'), rock });
/*     */         
/* 501 */         if (cfg.hardcoreCraft) {
/* 502 */           GameRegistry.addRecipe(new ItemStack(ItemListMF.hammerStone), new Object[] { "TRT", " S ", Character.valueOf('S'), ItemListMF.plank, Character.valueOf('T'), bind, Character.valueOf('R'), Block.field_71978_w });
/*     */           
/* 504 */           GameRegistry.addRecipe(new ItemStack(ItemListMF.knifeStone), new Object[] { "TR", "ST", Character.valueOf('S'), Item.field_77669_D, Character.valueOf('T'), bind, Character.valueOf('R'), rock });
/*     */           
/* 506 */           GameRegistry.addRecipe(new ItemStack(ItemListMF.tongsStone), new Object[] { "RT", "SR", Character.valueOf('S'), Item.field_77669_D, Character.valueOf('T'), bind, Character.valueOf('R'), rock });
/*     */         } else {
/* 508 */           GameRegistry.addRecipe(new ItemStack(ItemListMF.hammerStone), new Object[] { "R", "S", Character.valueOf('S'), ItemListMF.plank, Character.valueOf('R'), Block.field_71978_w });
/*     */           
/* 510 */           GameRegistry.addRecipe(new ItemStack(ItemListMF.tongsStone), new Object[] { "R ", "SR", Character.valueOf('S'), Item.field_77669_D, Character.valueOf('R'), rock });
/*     */           
/* 512 */           GameRegistry.addRecipe(new ItemStack(ItemListMF.knifeStone), new Object[] { " R", "S ", Character.valueOf('S'), Item.field_77669_D, Character.valueOf('R'), rock });
/*     */         }
/*     */         
/* 515 */         GameRegistry.addRecipe(new ItemStack(ItemListMF.axePrim), new Object[] { "AAT", "ATR", "ASA", Character.valueOf('S'), Item.field_77669_D, Character.valueOf('T'), bind, Character.valueOf('R'), rock });
/*     */         
/* 517 */         GameRegistry.addRecipe(new ItemStack(ItemListMF.pickStonePrim), new Object[] { "RTT", "ASA", "ASA", Character.valueOf('S'), Item.field_77669_D, Character.valueOf('T'), bind, Character.valueOf('R'), rock });
/*     */         
/* 519 */         GameRegistry.addRecipe(new ItemStack(ItemListMF.javelin), new Object[] { "R", "T", "S", Character.valueOf('S'), Item.field_77669_D, Character.valueOf('T'), bind, Character.valueOf('R'), rock });
/*     */       }
/*     */     }
/*     */     
/* 523 */     for (ItemStack bind : binds) {
/* 524 */       for (ItemStack hide : hides) {
/* 525 */         GameRegistry.addRecipe(new ItemStack(ItemListMF.sling), new Object[] { "H  ", " B ", "  B", Character.valueOf('H'), hide, Character.valueOf('B'), bind });
/* 526 */         GameRegistry.addRecipe(new ItemStack(ItemListMF.bandage, 4), new Object[] { "B", "H", "B", Character.valueOf('H'), hide, Character.valueOf('B'), bind });
/* 527 */         GameRegistry.addRecipe(new ItemStack(ItemListMF.armourRawhide), new Object[] { "H H", "BHB", Character.valueOf('H'), hide, Character.valueOf('B'), bind });
/* 528 */         GameRegistry.addRecipe(new ItemStack(ItemListMF.legsRawhide), new Object[] { "BB", "HH", Character.valueOf('H'), hide, Character.valueOf('B'), bind });
/* 529 */         GameRegistry.addRecipe(new ItemStack(ItemListMF.spearCopper), new Object[] { "ATR", "AST", "SAA", Character.valueOf('S'), Item.field_77669_D, Character.valueOf('T'), bind, Character.valueOf('R'), com(113) });
/* 530 */         GameRegistry.addRecipe(new ItemStack(ItemListMF.pickCopperPrim), new Object[] { "RTT", "ASA", "ASA", Character.valueOf('S'), Item.field_77669_D, Character.valueOf('T'), bind, Character.valueOf('R'), com(113) });
/*     */         
/* 532 */         for (ItemStack planks : OreDictionary.getOres("plankWood")) {
/* 533 */           GameRegistry.addRecipe(new ItemStack(ItemListMF.clubWood), new Object[] { "TRT", "ATA", "ASA", Character.valueOf('S'), Item.field_77669_D, Character.valueOf('R'), planks, Character.valueOf('T'), bind });
/*     */         }
/* 535 */         GameRegistry.addRecipe(new ItemStack(ItemListMF.clubStone), new Object[] { "TRT", "ATA", "ASA", Character.valueOf('S'), Item.field_77669_D, Character.valueOf('R'), Block.field_71978_w, Character.valueOf('T'), bind });
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static ItemStack com(int id) {
/* 541 */     return ItemListMF.component(id);
/*     */   }
/*     */   
/*     */   private static ItemStack com(int id, int val) {
/* 545 */     return ItemListMF.component(id, val);
/*     */   }
/*     */   
/*     */   private static void addHeatables() {
/* 549 */     MineFantasyAPI.addHeatableItem(com(153), 950, 3000, 5000);
/* 550 */     MineFantasyAPI.addHeatableItem(com(22), 900, 3000, 5000);
/* 551 */     MineFantasyAPI.addHeatableItem(com(60), 400, 1200, 1500);
/* 552 */     MineFantasyAPI.addHeatableItem(com(2), 200, 1200, 1500);
/* 553 */     MineFantasyAPI.addHeatableItem(com(123), 250, 1500, 1800);
/* 554 */     MineFantasyAPI.addHeatableItem(com(122), 150, 600, 800);
/* 555 */     MineFantasyAPI.addHeatableItem(com(124), 1250, 3200, 3500);
/* 556 */     MineFantasyAPI.addHeatableItem(Item.field_77717_p.field_77779_bT, 250, 900, 1100);
/*     */     
/* 558 */     if (!cfg.easyIron) {
/* 559 */       MineFantasyAPI.addHeatableItem(Item.field_77703_o.field_77779_bT, 350, 1000, 1200);
/*     */     }
/*     */     
/* 562 */     addHeatable("ingotSteel", 400, 900, 1200);
/* 563 */     addHeatable("ingotDamascusSteel", 450, 1000, 1250);
/* 564 */     addHeatable("ingotCopper", 300, 600, 700);
/* 565 */     addHeatable("ingotRefinedIron", 350, 800, 1100);
/* 566 */     addHeatable("ingotNickel", 500, 1000, 1300);
/* 567 */     addHeatable("ingotPlatinum", 500, 1100, 1400);
/* 568 */     addHeatable("ingotSilver", 200, 750, 900);
/* 569 */     addHeatable("ingotTin", 100, 350, 450);
/* 570 */     addHeatable("ingotTitanium", 700, 1200, 1600);
/* 571 */     addHeatable("ingotZinc", 200, 300, 450);
/* 572 */     addHeatable("ingotBronze", 300, 600, 800);
/*     */     
/* 574 */     addHeatable("ingotDeepIron", 1200, 2400, 3000);
/* 575 */     addHeatable("ingotMithril", 1300, 2800, 3200);
/*     */   }
/*     */   
/*     */   private static void addHeatable(String oreStr, int min, int unstable, int max) {
/* 579 */     for (ItemStack ore : OreDictionary.getOres(oreStr))
/* 580 */       MineFantasyAPI.addHeatableItem(ore, min, unstable, max);
/*     */   }
/*     */   
/*     */   public static ItemStack getItem(String itemClass, String itemString, int meta) {
/* 584 */     ItemStack item = null;
/*     */     try
/*     */     {
/* 587 */       Object obj = Class.forName(itemClass).getField(itemString).get(null);
/* 588 */       if ((obj instanceof Item)) {
/* 589 */         item = new ItemStack((Item)obj, 1, meta);
/* 590 */       } else if ((obj instanceof Block)) {
/* 591 */         item = new ItemStack((Block)obj, 1, meta);
/* 592 */       } else if ((obj instanceof ItemStack)) {
/* 593 */         item = (ItemStack)obj;
/*     */       }
/*     */     }
/*     */     catch (Exception localException) {}
/*     */     
/* 598 */     return item;
/*     */   }
/*     */   
/*     */   private static void addTailoring() {
/* 602 */     GameRegistry.addRecipe(new ItemStack(ItemListMF.needleBone), new Object[] { "B", "B", Character.valueOf('B'), Item.field_77755_aX });
/*     */     
/* 604 */     StringList.addString(Item.field_77683_K, 2);
/* 605 */     StringList.addString(com(151), 1);
/* 606 */     StringList.addString(com(109), 0);
/* 607 */     MineFantasyAPI.addStringRecipe(Block.field_72101_ab, com(151, 4), 10);
/*     */     
/* 609 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockSpinningWheel), new Object[] { "W P", "WWW", "PPP", Character.valueOf('W'), Block.field_71988_x, Character.valueOf('P'), ItemListMF.plank });
/* 610 */     GameRegistry.addRecipe(new ItemStack(Item.field_77683_K), new Object[] { "SGS", " S ", "SGS", Character.valueOf('S'), com(151), Character.valueOf('G'), com(88) });
/* 611 */     GameRegistry.addRecipe(new ItemStack(Item.field_77683_K), new Object[] { "SGS", " S ", "S S", Character.valueOf('S'), com(151), Character.valueOf('G'), com(89) });
/* 612 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockTailor), new Object[] { "SSS", "WLW", "P P", Character.valueOf('S'), Item.field_77669_D, Character.valueOf('W'), Block.field_71988_x, Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('P'), ItemListMF.plank });
/* 613 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockTailor), new Object[] { "SSS", "WLW", "P P", Character.valueOf('S'), Item.field_77669_D, Character.valueOf('W'), Block.field_71988_x, Character.valueOf('L'), com(7), Character.valueOf('P'), ItemListMF.plank });
/*     */     
/* 615 */     MineFantasyAPI.addTailorRecipe(com(9, 4), 4, 4.0F, 1, new Object[] { "LFL", " C ", "LFL", Character.valueOf('C'), Block.field_72101_ab, Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('F'), Item.field_77676_L });
/* 616 */     MineFantasyAPI.addTailorRecipe(new ItemStack(ItemListMF.bandage, 4, 1), 4, 2.0F, 1, new Object[] { "W", "W", Character.valueOf('W'), Block.field_72101_ab });
/* 617 */     MineFantasyAPI.addTailorRecipe(new ItemStack(ItemListMF.bandage, 1, 2), 2, 2.0F, 2, new Object[] { "L", "B", "L", Character.valueOf('L'), com(26), Character.valueOf('B'), new ItemStack(ItemListMF.bandage, 4, 1) });
/* 618 */     MineFantasyAPI.addTailorRecipe(new ItemStack(ItemListMF.apronSmithy), 12, 10.0F, 1, new Object[] { "LAL", "LWL", "ALA", Character.valueOf('W'), Block.field_72101_ab, Character.valueOf('L'), Item.field_77770_aF });
/* 619 */     MineFantasyAPI.addTailorRecipe(new ItemStack(ItemListMF.apronSmithy), 12, 10.0F, 1, new Object[] { "LAL", "LWL", "ALA", Character.valueOf('W'), Block.field_72101_ab, Character.valueOf('L'), com(7) });
/* 620 */     MineFantasyAPI.addTailorRecipe(com(27), 2, 8.0F, 1, new Object[] { "B", "L", "L", Character.valueOf('L'), com(26), Character.valueOf('B'), com(125) });
/* 621 */     MineFantasyAPI.addTailorRecipe(new ItemStack(ItemListMF.hound_feed, 1, ItemListMF.hound_feed.func_77612_l() - 1), 8, 14.0F, 1, new Object[] { "B B", "L L", " L ", Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('B'), com(27) });
/* 622 */     MineFantasyAPI.addTailorRecipe(new ItemStack(ItemListMF.hound_sPack), 12, 16.0F, 1, new Object[] { "LCL", "LLL", "B B", Character.valueOf('C'), Block.field_72077_au, Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('B'), com(27) });
/* 623 */     MineFantasyAPI.addTailorRecipe(new ItemStack(ItemListMF.hound_bPack), 24, 24.0F, 2, new Object[] { "CLC", "LPL", "BLB", "B B", Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('C'), Block.field_72077_au, Character.valueOf('P'), ItemListMF.hound_sPack, Character.valueOf('B'), com(27) });
/*     */     
/*     */ 
/* 626 */     MineFantasyAPI.addTailorRecipe(new ItemStack(ItemListMF.helmetLeatherRough), 5, 10.0F, 1, new Object[] { "LLL", "L L", Character.valueOf('L'), com(7) });
/* 627 */     MineFantasyAPI.addTailorRecipe(new ItemStack(ItemListMF.plateLeatherRough), 8, 10.0F, 1, new Object[] { "L L", "LLL", "LLL", Character.valueOf('L'), com(7) });
/* 628 */     MineFantasyAPI.addTailorRecipe(new ItemStack(ItemListMF.legsLeatherRough), 7, 10.0F, 1, new Object[] { "LLL", "L L", "L L", Character.valueOf('L'), com(7) });
/* 629 */     MineFantasyAPI.addTailorRecipe(new ItemStack(ItemListMF.bootsLeatherRough), 4, 10.0F, 1, new Object[] { "L L", "L L", Character.valueOf('L'), com(7) });
/* 630 */     MineFantasyAPI.addTailorRecipe(new ItemStack(Item.field_77687_V), 6, 10.0F, 1, new Object[] { "LLL", "L L", Character.valueOf('L'), Item.field_77770_aF });
/* 631 */     MineFantasyAPI.addTailorRecipe(new ItemStack(Item.field_77686_W), 16, 10.0F, 1, new Object[] { "L L", "LLL", "LLL", Character.valueOf('L'), Item.field_77770_aF });
/* 632 */     MineFantasyAPI.addTailorRecipe(new ItemStack(Item.field_77693_X), 12, 10.0F, 1, new Object[] { "LLL", "L L", "L L", Character.valueOf('L'), Item.field_77770_aF });
/* 633 */     MineFantasyAPI.addTailorRecipe(new ItemStack(Item.field_77692_Y), 4, 10.0F, 1, new Object[] { "L L", "L L", Character.valueOf('L'), Item.field_77770_aF });
/* 634 */     MineFantasyAPI.addTailorRecipe(com(104), 2, 4, 8.0F, 2, new Object[] { " I ", "LBL", Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('B'), com(89), Character.valueOf('I'), new ItemStack(Item.field_77756_aW, 1, 0) });
/* 635 */     MineFantasyAPI.addTailorRecipe(new ItemStack(ItemListMF.helmetStealth), 2, 8, 28.0F, 2, new Object[] { "LLL", "L L", Character.valueOf('L'), com(104) });
/* 636 */     MineFantasyAPI.addTailorRecipe(new ItemStack(ItemListMF.plateStealth), 2, 16, 28.0F, 2, new Object[] { "L L", "LLL", "LLL", Character.valueOf('L'), com(104) });
/* 637 */     MineFantasyAPI.addTailorRecipe(new ItemStack(ItemListMF.legsStealth), 2, 12, 28.0F, 2, new Object[] { "LLL", "L L", "L L", Character.valueOf('L'), com(104) });
/* 638 */     MineFantasyAPI.addTailorRecipe(new ItemStack(ItemListMF.bootsStealth), 2, 4, 28.0F, 2, new Object[] { "L L", "L L", Character.valueOf('L'), com(104) });
/* 639 */     MineFantasyAPI.addTailorRecipe(new ItemStack(Item.field_77765_aA), 32, 10.0F, 1, new Object[] { "L  ", "LLL", "B B", Character.valueOf('B'), com(27), Character.valueOf('L'), Item.field_77770_aF });
/*     */     
/* 641 */     ItemStack quiver = MineFantasyBase.getBGItem("quiver", 0);
/* 642 */     if (quiver != null)
/* 643 */       MineFantasyAPI.addTailorRecipe(quiver, 12, 10.0F, 1, new Object[] { "L L", "L L", "LLL", Character.valueOf('L'), Item.field_77770_aF });
/*     */   }
/*     */   
/*     */   private static void addFletching() {
/* 647 */     GameRegistry.addRecipe(new ItemStack(ItemListMF.arrowMF, 4, 0), new Object[] { "R", "R", "F", Character.valueOf('R'), Item.field_77758_aJ, Character.valueOf('F'), Item.field_77676_L });
/*     */     
/*     */ 
/*     */ 
/* 651 */     addArrow(1, 127, Item.field_77669_D, Integer.valueOf(23));
/* 652 */     addArrow(4, 128, Item.field_77669_D, Integer.valueOf(23));
/* 653 */     addArrow(7, 129, Item.field_77669_D, Integer.valueOf(23));
/* 654 */     addArrow(10, 130, Integer.valueOf(87), Integer.valueOf(23));
/* 655 */     addArrow(13, 131, Item.field_77669_D, Integer.valueOf(23));
/* 656 */     addArrow(16, 132, Item.field_77669_D, Integer.valueOf(23));
/* 657 */     addArrow(19, 133, Item.field_77669_D, Integer.valueOf(23));
/* 658 */     addArrow(22, 134, Integer.valueOf(126), Integer.valueOf(23));
/* 659 */     addArrow(25, 189, Integer.valueOf(87), Integer.valueOf(23));
/*     */     
/* 661 */     addArrow(2, 143, Item.field_77669_D, Integer.valueOf(23));
/* 662 */     addArrow(5, 144, Item.field_77669_D, Integer.valueOf(23));
/* 663 */     addArrow(8, 145, Item.field_77669_D, Integer.valueOf(23));
/* 664 */     addArrow(11, 146, Integer.valueOf(87), Integer.valueOf(23));
/* 665 */     addArrow(14, 147, Item.field_77669_D, Integer.valueOf(23));
/* 666 */     addArrow(17, 148, Item.field_77669_D, Integer.valueOf(23));
/* 667 */     addArrow(20, 149, Item.field_77669_D, Integer.valueOf(23));
/* 668 */     addArrow(23, 150, Integer.valueOf(126), Integer.valueOf(23));
/* 669 */     addArrow(26, 187, Integer.valueOf(87), Integer.valueOf(23));
/*     */     
/* 671 */     addArrow(3, 135, ItemListMF.plank, Integer.valueOf(23));
/* 672 */     addArrow(6, 136, ItemListMF.plank, Integer.valueOf(23));
/* 673 */     addArrow(9, 137, ItemListMF.plank, Integer.valueOf(23));
/* 674 */     addArrow(12, 138, Integer.valueOf(25), Integer.valueOf(23));
/* 675 */     addArrow(15, 139, ItemListMF.plank, Integer.valueOf(23));
/* 676 */     addArrow(18, 140, ItemListMF.plank, Integer.valueOf(23));
/* 677 */     addArrow(21, 141, ItemListMF.plank, Integer.valueOf(23));
/* 678 */     addArrow(24, 142, Integer.valueOf(114), Integer.valueOf(23));
/* 679 */     addArrow(27, 188, Integer.valueOf(25), Integer.valueOf(23));
/*     */   }
/*     */   
/*     */   private static void addArrow(int type, int head, Object body, Object feather) {
/* 683 */     if ((body instanceof Integer)) {
/* 684 */       int b = ((Integer)body).intValue();
/* 685 */       body = com(b);
/*     */     }
/* 687 */     if ((feather instanceof Integer)) {
/* 688 */       int b = ((Integer)feather).intValue();
/* 689 */       feather = com(b);
/*     */     }
/*     */     
/* 692 */     GameRegistry.addRecipe(new ItemStack(ItemListMF.arrowMF, 1, type), new Object[] { "H", "S", "F", Character.valueOf('H'), com(head), Character.valueOf('S'), body, Character.valueOf('F'), feather });
/*     */   }
/*     */   
/*     */   private static void addBombs() {
/* 696 */     GameRegistry.addRecipe(new ItemStack(ItemListMF.bombMF, 1, 0), new Object[] { " S ", "CFC", " P ", Character.valueOf('S'), Item.field_77683_K, Character.valueOf('C'), Item.field_77757_aI, Character.valueOf('P'), ItemListMF.explosive, Character.valueOf('F'), com(176) });
/* 697 */     GameRegistry.addRecipe(new ItemStack(ItemListMF.bombMF, 1, 1), new Object[] { " S ", "CFC", " P ", Character.valueOf('S'), Item.field_77683_K, Character.valueOf('C'), Item.field_77757_aI, Character.valueOf('P'), ItemListMF.explosive, Character.valueOf('F'), com(20) });
/* 698 */     GameRegistry.addRecipe(new ItemStack(ItemListMF.bombMF, 1, 2), new Object[] { " S ", "CFC", " P ", Character.valueOf('S'), Item.field_77683_K, Character.valueOf('C'), Item.field_77757_aI, Character.valueOf('P'), ItemListMF.explosive, Character.valueOf('F'), Item.field_77723_bv });
/* 699 */     GameRegistry.addRecipe(new ItemStack(ItemListMF.bombMF, 1, 3), new Object[] { " S ", "CFC", " P ", Character.valueOf('S'), Item.field_77683_K, Character.valueOf('C'), Item.field_77757_aI, Character.valueOf('P'), ItemListMF.explosive, Character.valueOf('F'), Item.field_77767_aC });
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/RecipesMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */