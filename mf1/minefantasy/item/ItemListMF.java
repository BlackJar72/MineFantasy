/*      */ package minefantasy.item;
/*      */ 
/*      */ import cpw.mods.fml.common.registry.GameRegistry;
/*      */ import minefantasy.api.MineFantasyAPI;
/*      */ import minefantasy.api.anvil.ItemRepairHammer;
/*      */ import minefantasy.api.weapon.EnumAmmo;
/*      */ import minefantasy.item.armour.EnumArmourMF;
/*      */ import minefantasy.item.armour.ItemArmourMF;
/*      */ import minefantasy.item.mabShield.EnumShieldDesign;
/*      */ import minefantasy.item.mabShield.ItemShield;
/*      */ import minefantasy.item.tool.ItemHammer;
/*      */ import minefantasy.item.tool.ItemHandpick;
/*      */ import minefantasy.item.tool.ItemKnifeMF;
/*      */ import minefantasy.item.tool.ItemMallet;
/*      */ import minefantasy.item.tool.ItemMattock;
/*      */ import minefantasy.item.tool.ItemMedievalAxe;
/*      */ import minefantasy.item.tool.ItemMedievalHoe;
/*      */ import minefantasy.item.tool.ItemMedievalPick;
/*      */ import minefantasy.item.tool.ItemMedievalSpade;
/*      */ import minefantasy.item.tool.ItemNeedle;
/*      */ import minefantasy.item.tool.ItemRakeMF;
/*      */ import minefantasy.item.tool.ItemSaw;
/*      */ import minefantasy.item.tool.ItemScytheMF;
/*      */ import minefantasy.item.tool.ItemShearsMF;
/*      */ import minefantasy.item.tool.ItemTongs;
/*      */ import minefantasy.item.weapon.EnumBowType;
/*      */ import minefantasy.item.weapon.ItemBattleaxe;
/*      */ import minefantasy.item.weapon.ItemBowMF;
/*      */ import minefantasy.item.weapon.ItemBroadsword;
/*      */ import minefantasy.item.weapon.ItemCrossbow;
/*      */ import minefantasy.item.weapon.ItemDagger;
/*      */ import minefantasy.item.weapon.ItemGreatmace;
/*      */ import minefantasy.item.weapon.ItemGreatsword;
/*      */ import minefantasy.item.weapon.ItemHalbeard;
/*      */ import minefantasy.item.weapon.ItemLance;
/*      */ import minefantasy.item.weapon.ItemMaceMF;
/*      */ import minefantasy.item.weapon.ItemSpearMF;
/*      */ import minefantasy.item.weapon.ItemSwordMF;
/*      */ import minefantasy.item.weapon.ItemWaraxe;
/*      */ import minefantasy.item.weapon.ItemWarhammer;
/*      */ import minefantasy.item.weapon.ItemWarpick;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.creativetab.CreativeTabs;
/*      */ import net.minecraft.item.EnumToolMaterial;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemArmor;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.potion.Potion;
/*      */ import net.minecraft.util.WeightedRandomChestContent;
/*      */ import net.minecraftforge.common.ChestGenHooks;
/*      */ 
/*      */ public class ItemListMF
/*      */ {
/*   54 */   public static CreativeTabs tabWeapon = new CreativeTabMF(CreativeTabs.getNextID(), "forgedweapon", 0);
/*   55 */   public static CreativeTabs tabArmour = new CreativeTabMF(CreativeTabs.getNextID(), "forgedarmour", 1);
/*   56 */   public static CreativeTabs tabTool = new CreativeTabMF(CreativeTabs.getNextID(), "forgedtool", 2);
/*   57 */   public static CreativeTabs tabTailor = new CreativeTabMF(CreativeTabs.getNextID(), "tailor", 3);
/*   58 */   public static CreativeTabs tabArcher = new CreativeTabMF(CreativeTabs.getNextID(), "archery", 4);
/*   59 */   public static CreativeTabs tabMF = new CreativeTabMF(CreativeTabs.getNextID(), "forge", 5);
/*   60 */   public static CreativeTabs tabSmellting = new CreativeTabMF(CreativeTabs.getNextID(), "smellting", 6);
/*   61 */   public static CreativeTabs tabSmith = new CreativeTabMF(CreativeTabs.getNextID(), "blacksmith", 7);
/*   62 */   public static CreativeTabs tabDeco = new CreativeTabMF(CreativeTabs.getNextID(), "decorations", 8);
/*   63 */   public static CreativeTabs tabCook = new CreativeTabMF(CreativeTabs.getNextID(), "cook", 9);
/*   64 */   public static CreativeTabs tabMedieval = new CreativeTabMF(CreativeTabs.getNextID(), "medievalcomp", 10);
/*   65 */   public static CreativeTabs tabPets = new CreativeTabMF(CreativeTabs.getNextID(), "pets", 11);
/*   66 */   public static int itemId = minefantasy.system.cfg.itemId;
/*      */   
/*   68 */   public static final Item hammerIron = new ItemHammer(itemId, 1.0F, ToolMaterialMedieval.IRON).func_77655_b("hammerIron");
/*   69 */   public static final Item ingotSteel = new ItemMedieval(itemId + 1, false, 64).func_77655_b("ingotSteel");
/*   70 */   public static final Item tongsBronze = new ItemTongs(itemId + 2, ToolMaterialMedieval.BRONZE).func_77655_b("tongsBronze");
/*   71 */   public static final Item apronSmithy = new ItemArmourMF(itemId + 3, ArmourDesign.LEATHER, EnumArmourMF.APRON, 1, 1, "smithApron").func_77655_b("apronSmithy").func_77637_a(tabArmour);
/*   72 */   public static final Item plank = new ItemMedieval(itemId + 4, false, 64).func_77655_b("plank");
/*   73 */   public static final Item pickIronForged = new ItemMedievalPick(itemId + 5, ToolMaterialMedieval.IRON).func_77655_b("pickIronForged");
/*   74 */   public static final Item pickSteelForged = new ItemMedievalPick(itemId + 6, ToolMaterialMedieval.STEEL).func_77655_b("pickSteelForged");
/*   75 */   public static final Item pickIgnotumiteForged = new ItemMedievalPick(itemId + 55, ToolMaterialMedieval.IGNOTUMITE).func_77655_b("pickIgnotumiteForged");
/*   76 */   public static final Item knifeStone = new ItemKnifeMF(itemId + 66, 3.0F, ToolMaterialMedieval.PRIMITIVE_STONE).func_77655_b("knifeStone");
/*   77 */   public static final Item mattockMithril = new ItemMattock(itemId + 7, ToolMaterialMedieval.MITHRIL).func_77655_b("mattockMithril");
/*   78 */   public static final Item swordIronForged = new ItemSwordMF(itemId + 8, ToolMaterialMedieval.IRON).func_77655_b("swordIron");
/*   79 */   public static final Item swordSteelForged = new ItemSwordMF(itemId + 9, ToolMaterialMedieval.STEEL).func_77655_b("swordSteel");
/*   80 */   public static final Item swordIgnotumite = new ItemSwordMF(itemId + 56, ToolMaterialMedieval.IGNOTUMITE).func_77655_b("swordIgnotumite");
/*   81 */   public static final Item swordDragon = new ItemSwordMF(itemId + 67, ToolMaterialMedieval.DRAGONFORGE).func_77655_b("swordDragonforge");
/*   82 */   public static final Item knifeMithril = new ItemKnifeMF(itemId + 10, 6.0F, ToolMaterialMedieval.MITHRIL).func_77655_b("knifeMithril");
/*   83 */   public static final Item swordOrnate = new ItemSwordMF(itemId + 11, ToolMaterialMedieval.ORNATE).func_77655_b("swordOrnate");
/*   84 */   public static final Item axeIronForged = new ItemMedievalAxe(itemId + 12, ToolMaterialMedieval.IRON).func_77655_b("axeIronForged");
/*   85 */   public static final Item axeSteelForged = new ItemMedievalAxe(itemId + 13, ToolMaterialMedieval.STEEL).func_77655_b("axeSteelForged");
/*   86 */   public static final Item axeIgnotumiteForged = new ItemMedievalAxe(itemId + 57, ToolMaterialMedieval.IGNOTUMITE).func_77655_b("axeIgnotumiteForged");
/*   87 */   public static final Item swordTin = new ItemSwordMF(itemId + 68, ToolMaterialMedieval.TIN).func_77655_b("swordTin");
/*   88 */   public static final Item sawMithril = new ItemSaw(itemId + 14, ToolMaterialMedieval.MITHRIL).func_77655_b("sawMithril");
/*   89 */   public static final Item spadeIronForged = new ItemMedievalSpade(itemId + 15, ToolMaterialMedieval.IRON).func_77655_b("spadeIronForged");
/*   90 */   public static final Item spadeSteelForged = new ItemMedievalSpade(itemId + 16, ToolMaterialMedieval.STEEL).func_77655_b("spadeSteel");
/*   91 */   public static final Item spadeIgnotumiteForged = new ItemMedievalSpade(itemId + 58, ToolMaterialMedieval.IGNOTUMITE).func_77655_b("spadeIgnotumite");
/*   92 */   public static final Item knifeSteel = new ItemKnifeMF(itemId + 69, 4.0F, ToolMaterialMedieval.STEEL).func_77655_b("knifeSteel");
/*   93 */   public static final Item shearsMithril = new ItemShearsMF(itemId + 17, ToolMaterialMedieval.MITHRIL).func_77655_b("shearsMithril");
/*   94 */   public static final Item hoeIronForged = new ItemMedievalHoe(itemId + 18, ToolMaterialMedieval.IRON).func_77655_b("hoeIronForged");
/*   95 */   public static final Item hoeSteelForged = new ItemMedievalHoe(itemId + 19, ToolMaterialMedieval.STEEL).func_77655_b("hoeSteelForged");
/*   96 */   public static final Item rakeBronze = new ItemRakeMF(itemId + 59, ToolMaterialMedieval.BRONZE).func_77655_b("rakeBronze");
/*   97 */   public static final Item rakeIron = new ItemRakeMF(itemId + 70, ToolMaterialMedieval.IRON).func_77655_b("rakeIron");
/*   98 */   public static final Item rakeMithril = new ItemRakeMF(itemId + 20, ToolMaterialMedieval.MITHRIL).func_77655_b("rakeMithril");
/*      */   
/*  100 */   public static final Item helmetBronzeScale = new ItemArmourMF(itemId + 21, ArmourDesign.SCALE, EnumArmourMF.BRONZE, 1, 0, "bronzeScale_1").func_77655_b("bronzeScaleHelmet");
/*  101 */   public static final Item plateBronzeScale = new ItemArmourMF(itemId + 22, ArmourDesign.SCALE, EnumArmourMF.BRONZE, 1, 1, "bronzeScale_1").func_77655_b("bronzeScaleChest");
/*  102 */   public static final Item legsBronzeScale = new ItemArmourMF(itemId + 23, ArmourDesign.SCALE, EnumArmourMF.BRONZE, 2, 2, "bronzeScale_2").func_77655_b("bronzeScaleLegs");
/*  103 */   public static final Item bootsBronzeScale = new ItemArmourMF(itemId + 24, ArmourDesign.SCALE, EnumArmourMF.BRONZE, 2, 3, "bronzeScale_1").func_77655_b("bronzeScaleBoots");
/*      */   
/*  105 */   public static final Item helmetSteelPlate = new ItemArmourMF(itemId + 25, ArmourDesign.PLATE, EnumArmourMF.STEEL, 0, 0, "steelPlate_1").func_77655_b("steelPlateHelmet");
/*  106 */   public static final Item plateSteelPlate = new ItemArmourMF(itemId + 26, ArmourDesign.PLATE, EnumArmourMF.STEEL, 0, 1, "steelPlate_1").func_77655_b("steelPlateChest");
/*  107 */   public static final Item legsSteelPlate = new ItemArmourMF(itemId + 27, ArmourDesign.PLATE, EnumArmourMF.STEEL, 0, 2, "steelPlate_2").func_77655_b("steelPlateLegs");
/*  108 */   public static final Item bootsSteelPlate = new ItemArmourMF(itemId + 28, ArmourDesign.PLATE, EnumArmourMF.STEEL, 0, 3, "steelPlate_1").func_77655_b("steelPlateBoots");
/*      */   
/*  110 */   public static final Item knifeCopper = new ItemKnifeMF(itemId + 33, 3.0F, ToolMaterialMedieval.COPPER).func_77655_b("knifeCopper");
/*  111 */   public static final Item hammerCopper = new ItemHammer(itemId + 34, 0.4F, ToolMaterialMedieval.COPPER).func_77655_b("hammerCopper");
/*  112 */   public static final Item ingotSilver = new ItemMedieval(itemId + 35, false, 64).func_77655_b("ingotSilver");
/*  113 */   public static final Item tinderbox = new minefantasy.item.tool.ItemLighter(itemId + 36, 64, 0.25D).func_77655_b("tinderbox");
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*  118 */   public static final Item bombMF = new ItemBombMF(itemId + 39).func_77655_b("bombIron");
/*  119 */   public static final Item malletWood = new ItemMallet(itemId + 40, EnumToolMaterial.WOOD).func_77655_b("malletWood");
/*  120 */   public static final Item malletIronbark = new ItemMallet(itemId + 64, ToolMaterialMedieval.IRONBARK).func_77655_b("malletIronbark");
/*  121 */   public static final Item explosive = new ItemMedieval(itemId + 41, false, 64).func_77655_b("explosive");
/*  122 */   public static final Item misc = new ItemMedievalComponent(itemId + 42).func_77655_b("dust");
/*  123 */   public static final Item hotItem = new ItemHotItem(itemId + 43).func_77655_b("hotItem");
/*  124 */   public static final Item broadIron = new ItemBroadsword(itemId + 44, ToolMaterialMedieval.IRON).func_77655_b("broadswordIron");
/*  125 */   public static final Item morningstarIron = new ItemGreatmace(itemId + 45, ToolMaterialMedieval.IRON).func_77655_b("greatmaceIron");
/*  126 */   public static final Item warpickIron = new ItemWarpick(itemId + 46, ToolMaterialMedieval.IRON).func_77655_b("warpickIron");
/*  127 */   public static final Item broadSteel = new ItemBroadsword(itemId + 47, ToolMaterialMedieval.STEEL).func_77655_b("broadswordSteel");
/*  128 */   public static final Item morningstarSteel = new ItemGreatmace(itemId + 48, ToolMaterialMedieval.STEEL).func_77655_b("greatmaceSteel");
/*  129 */   public static final Item warpickSteel = new ItemWarpick(itemId + 49, ToolMaterialMedieval.STEEL).func_77655_b("warpickSteel");
/*  130 */   public static final Item broadOrnate = new ItemBroadsword(itemId + 60, ToolMaterialMedieval.ORNATE).func_77655_b("broadswordOrnate");
/*  131 */   public static final Item broadDragon = new ItemBroadsword(itemId + 71, ToolMaterialMedieval.DRAGONFORGE).func_77655_b("broadswordDragonforge");
/*  132 */   public static final Item rakeSteel = new ItemRakeMF(itemId + 61, ToolMaterialMedieval.STEEL).func_77655_b("rakeSteel");
/*  133 */   public static final Item morningstarDragon = new ItemGreatmace(itemId + 72, ToolMaterialMedieval.DRAGONFORGE).func_77655_b("greatmaceDragon");
/*  134 */   public static final Item waraxeSteel = new ItemWaraxe(itemId + 62, ToolMaterialMedieval.STEEL).func_77655_b("waraxeSteel");
/*  135 */   public static final Item warpickDragon = new ItemWarpick(itemId + 73, ToolMaterialMedieval.DRAGONFORGE).func_77655_b("warpickDragon");
/*  136 */   public static final Item waraxeEncrusted = new ItemWaraxe(itemId + 50, ToolMaterialMedieval.ENCRUSTED).func_77655_b("waraxeEncrusted");
/*  137 */   public static final Item greatmaceOrnate = new ItemGreatmace(itemId + 51, ToolMaterialMedieval.ORNATE).func_77655_b("greatmaceOrnate");
/*  138 */   public static final Item waraxeDragon = new ItemWaraxe(itemId + 52, ToolMaterialMedieval.DRAGONFORGE).func_77655_b("waraxeDragon");
/*      */   
/*      */ 
/*  141 */   public static final Item maceEncrusted = new ItemMaceMF(itemId + 54, ToolMaterialMedieval.ENCRUSTED).func_77655_b("maceEncrusted");
/*  142 */   public static final Item knifeBronze = new ItemKnifeMF(itemId + 63, 4.0F, ToolMaterialMedieval.BRONZE).func_77655_b("knifeBronze").func_77637_a(tabTool);
/*  143 */   public static final Item knifeIron = new ItemKnifeMF(itemId + 77, 4.0F, ToolMaterialMedieval.IRON).func_77655_b("knifeIron");
/*  144 */   public static final Item hammerOrnate = new ItemHammer(itemId + 86, 2.0F, ToolMaterialMedieval.ORNATE).func_77655_b("hammerPower");
/*  145 */   public static final Item axePrim = new ItemMedievalAxe(itemId + 87, ToolMaterialMedieval.PRIMITIVE_STONE).func_77655_b("axePrim");
/*      */   
/*  147 */   public static final Item helmetDragonPlate = new ItemArmourMF(itemId + 78, ArmourDesign.PLATE, EnumArmourMF.DRAGONFORGE, 1, 0, "dragonforgePlate_1").func_77655_b("dragonforgePlateHelmet");
/*  148 */   public static final Item plateDragonPlate = new ItemArmourMF(itemId + 79, ArmourDesign.PLATE, EnumArmourMF.DRAGONFORGE, 1, 1, "dragonforgePlate_1").func_77655_b("dragonforgePlateChest");
/*  149 */   public static final Item legsDragonPlate = new ItemArmourMF(itemId + 80, ArmourDesign.PLATE, EnumArmourMF.DRAGONFORGE, 2, 2, "dragonforgePlate_2").func_77655_b("dragonforgePlateLegs");
/*  150 */   public static final Item bootsDragonPlate = new ItemArmourMF(itemId + 81, ArmourDesign.PLATE, EnumArmourMF.DRAGONFORGE, 2, 3, "dragonforgePlate_1").func_77655_b("dragonforgePlateBoots");
/*      */   
/*  152 */   public static final Item greatmaceEncrusted = new ItemGreatmace(itemId + 88, ToolMaterialMedieval.ENCRUSTED).func_77655_b("greatmaceEncrusted");
/*  153 */   public static final Item tongsIron = new ItemTongs(itemId + 138, ToolMaterialMedieval.IRON).func_77655_b("tongsIron");
/*  154 */   public static final Item arrowMF = new ItemArrowMF(itemId + 90).func_77655_b("arrowMF");
/*  155 */   public static final Item tongsSteel = new ItemTongs(itemId + 91, ToolMaterialMedieval.STEEL).func_77655_b("tongsSteel");
/*  156 */   public static final Item tongsMithril = new ItemTongs(itemId + 89, ToolMaterialMedieval.MITHRIL).func_77655_b("tongsMithril");
/*      */   
/*  158 */   public static final Item pickTin = new ItemMedievalPick(itemId + 92, ToolMaterialMedieval.TIN).func_77655_b("pickTin");
/*  159 */   public static final Item spadeTin = new ItemMedievalSpade(itemId + 93, ToolMaterialMedieval.TIN).func_77655_b("spadeTin");
/*  160 */   public static final Item hoeTin = new ItemMedievalHoe(itemId + 94, ToolMaterialMedieval.TIN).func_77655_b("hoeTin");
/*  161 */   public static final Item knifeTin = new ItemKnifeMF(itemId + 95, 3.0F, ToolMaterialMedieval.TIN).func_77655_b("knifeTin");
/*  162 */   public static final Item axeTin = new ItemMedievalAxe(itemId + 96, ToolMaterialMedieval.TIN).func_77655_b("axeTin");
/*      */   
/*  164 */   public static final Item hammerBronze = new ItemHammer(itemId + 97, 0.6F, ToolMaterialMedieval.BRONZE).func_77655_b("hammerBronze");
/*  165 */   public static final Item pickBronze = new ItemMedievalPick(itemId + 98, ToolMaterialMedieval.BRONZE).func_77655_b("pickBronze");
/*  166 */   public static final Item spadeBronze = new ItemMedievalSpade(itemId + 99, ToolMaterialMedieval.BRONZE).func_77655_b("spadeBronze");
/*  167 */   public static final Item hoeBronze = new ItemMedievalHoe(itemId + 100, ToolMaterialMedieval.BRONZE).func_77655_b("hoeBronze");
/*  168 */   public static final Item swordBronze = new ItemSwordMF(itemId + 101, ToolMaterialMedieval.BRONZE).func_77655_b("swordBronze");
/*  169 */   public static final Item axeBronze = new ItemMedievalAxe(itemId + 102, ToolMaterialMedieval.BRONZE).func_77655_b("axeBronze");
/*  170 */   public static final Item broadBronze = new ItemBroadsword(itemId + 103, ToolMaterialMedieval.BRONZE).func_77655_b("broadswordBronze");
/*  171 */   public static final Item morningstarBronze = new ItemGreatmace(itemId + 104, ToolMaterialMedieval.BRONZE).func_77655_b("greatmaceBronze");
/*  172 */   public static final Item warpickBronze = new ItemWarpick(itemId + 105, ToolMaterialMedieval.BRONZE).func_77655_b("warpickBronze");
/*      */   
/*  174 */   public static final Item hammerSteel = new ItemHammer(itemId + 106, 1.8F, ToolMaterialMedieval.STEEL).func_77655_b("hammerSteel");
/*      */   
/*  176 */   public static final Item pickMithril = new ItemMedievalPick(itemId + 107, ToolMaterialMedieval.MITHRIL).func_77655_b("pickMithril");
/*  177 */   public static final Item spadeMithril = new ItemMedievalSpade(itemId + 108, ToolMaterialMedieval.MITHRIL).func_77655_b("spadeMithril");
/*  178 */   public static final Item hoeMithril = new ItemMedievalHoe(itemId + 109, ToolMaterialMedieval.MITHRIL).func_77655_b("hoeMithril");
/*  179 */   public static final Item swordMithril = new ItemSwordMF(itemId + 110, ToolMaterialMedieval.MITHRIL).func_77655_b("swordMithril");
/*  180 */   public static final Item axeMithril = new ItemMedievalAxe(itemId + 111, ToolMaterialMedieval.MITHRIL).func_77655_b("axeMithril");
/*  181 */   public static final Item broadMithril = new ItemBroadsword(itemId + 112, ToolMaterialMedieval.MITHRIL).func_77655_b("broadswordMithril");
/*  182 */   public static final Item morningstarMithril = new ItemGreatmace(itemId + 113, ToolMaterialMedieval.MITHRIL).func_77655_b("greatmaceMithril");
/*  183 */   public static final Item warpickMithril = new ItemWarpick(itemId + 114, ToolMaterialMedieval.MITHRIL).func_77655_b("warpickMithril");
/*      */   
/*  185 */   public static final Item bowComposite = new ItemBowMF(itemId + 115, ToolMaterialMedieval.STRONGWOOD, EnumBowType.COMPOSITE).func_77655_b("bowComposite");
/*  186 */   public static final Item bowIronbark = new ItemBowMF(itemId + 116, ToolMaterialMedieval.IRONBARK, EnumBowType.COMPOSITE).func_77655_b("bowIronbark");
/*  187 */   public static final Item longbow = new ItemBowMF(itemId + 117, ToolMaterialMedieval.STRONGWOOD, EnumBowType.LONGBOW).func_77655_b("longbow");
/*  188 */   public static final Item warhammerEncrusted = new ItemWarhammer(itemId + 118, ToolMaterialMedieval.ENCRUSTED).func_77655_b("warhammerEncrusted");
/*      */   
/*  190 */   public static final Item pickEncrusted = new ItemMedievalPick(itemId + 119, ToolMaterialMedieval.ENCRUSTED).func_77655_b("pickEncrusted");
/*  191 */   public static final Item spadeEncrusted = new ItemMedievalSpade(itemId + 120, ToolMaterialMedieval.ENCRUSTED).func_77655_b("spadeEncrusted");
/*  192 */   public static final Item mattockBronze = new ItemMattock(itemId + 121, ToolMaterialMedieval.BRONZE).func_77655_b("mattockBronze");
/*  193 */   public static final Item swordEncrusted = new ItemSwordMF(itemId + 122, ToolMaterialMedieval.ENCRUSTED).func_77655_b("swordEncrusted");
/*  194 */   public static final Item axeEncrusted = new ItemMedievalAxe(itemId + 123, ToolMaterialMedieval.ENCRUSTED).func_77655_b("axeEncrusted");
/*  195 */   public static final Item broadEncrusted = new ItemBroadsword(itemId + 124, ToolMaterialMedieval.ENCRUSTED).func_77655_b("broadswordEncrusted");
/*  196 */   public static final Item mattockIron = new ItemMattock(itemId + 125, ToolMaterialMedieval.IRON).func_77655_b("mattockIron");
/*  197 */   public static final Item warpickEncrusted = new ItemWarpick(itemId + 126, ToolMaterialMedieval.ENCRUSTED).func_77655_b("warpickEncrusted");
/*      */   
/*  199 */   public static final Item helmetBronzeChain = new ItemArmourMF(itemId + 127, ArmourDesign.CHAIN, EnumArmourMF.BRONZE, 1, 0, "bronzeChain_1").func_77655_b("bronzeChainHelmet");
/*  200 */   public static final Item plateBronzeChain = new ItemArmourMF(itemId + 128, ArmourDesign.CHAIN, EnumArmourMF.BRONZE, 1, 1, "bronzeChain_1").func_77655_b("bronzeChainChest");
/*  201 */   public static final Item legsBronzeChain = new ItemArmourMF(itemId + 129, ArmourDesign.CHAIN, EnumArmourMF.BRONZE, 2, 2, "bronzeChain_2").func_77655_b("bronzeChainLegs");
/*  202 */   public static final Item bootsBronzeChain = new ItemArmourMF(itemId + 130, ArmourDesign.CHAIN, EnumArmourMF.BRONZE, 2, 3, "bronzeChain_1").func_77655_b("bronzeChainBoots");
/*      */   
/*  204 */   public static final Item helmetBronzePlate = new ItemArmourMF(itemId + 131, ArmourDesign.PLATE, EnumArmourMF.BRONZE, 1, 0, "bronzePlate_1").func_77655_b("bronzePlateHelmet");
/*  205 */   public static final Item plateBronzePlate = new ItemArmourMF(itemId + 132, ArmourDesign.PLATE, EnumArmourMF.BRONZE, 1, 1, "bronzePlate_1").func_77655_b("bronzePlateChest");
/*  206 */   public static final Item legsBronzePlate = new ItemArmourMF(itemId + 133, ArmourDesign.PLATE, EnumArmourMF.BRONZE, 2, 2, "bronzePlate_2").func_77655_b("bronzePlateLegs");
/*  207 */   public static final Item bootsBronzePlate = new ItemArmourMF(itemId + 134, ArmourDesign.PLATE, EnumArmourMF.BRONZE, 2, 3, "bronzePlate_1").func_77655_b("bronzePlateBoots");
/*      */   
/*  209 */   public static final Item doorIronbark = new ItemDoorMF(itemId + 135, minefantasy.block.MFDoorEnum.IRONBARK).func_77655_b("doorIronbarkItem");
/*  210 */   public static final Item doorHard = new ItemDoorMF(itemId + 136, minefantasy.block.MFDoorEnum.REINFORCED).func_77655_b("doorHardItem");
/*  211 */   public static final Item doorSteel = new ItemDoorMF(itemId + 137, minefantasy.block.MFDoorEnum.STEEL).func_77655_b("doorSteelItem");
/*  212 */   public static final Item axeDragon = new ItemMedievalAxe(itemId + 139, ToolMaterialMedieval.DRAGONFORGE).func_77655_b("axeDragon");
/*      */   
/*  214 */   public static final Item hammerDragon = new ItemHammer(itemId + 140, 2.5F, ToolMaterialMedieval.DRAGONFORGE).func_77655_b("hammerDragon");
/*  215 */   public static final Item hoeDragon = new ItemMedievalHoe(itemId + 141, ToolMaterialMedieval.DRAGONFORGE).func_77655_b("hoeDragon");
/*  216 */   public static final Item knifeDragon = new ItemKnifeMF(itemId + 142, 5.0F, ToolMaterialMedieval.DRAGONFORGE).func_77655_b("knifeDragon");
/*  217 */   public static final Item mattockDragon = new ItemMattock(itemId + 143, ToolMaterialMedieval.DRAGONFORGE).func_77655_b("mattockDragon");
/*  218 */   public static final Item rakeDragon = new ItemRakeMF(itemId + 144, ToolMaterialMedieval.DRAGONFORGE).func_77655_b("rakeDragon");
/*  219 */   public static final Item pickDragon = new ItemMedievalPick(itemId + 145, ToolMaterialMedieval.DRAGONFORGE).func_77655_b("pickDragon");
/*      */   
/*  221 */   public static final Item helmetEncrustedPlate = new ItemArmourMF(itemId + 146, ArmourDesign.PLATE, EnumArmourMF.ENCRUSTED, 1, 0, "encrustedPlate_1").func_77655_b("encrustedPlateHelmet");
/*  222 */   public static final Item plateEncrustedPlate = new ItemArmourMF(itemId + 147, ArmourDesign.PLATE, EnumArmourMF.ENCRUSTED, 1, 1, "encrustedPlate_1").func_77655_b("encrustedPlateChest");
/*  223 */   public static final Item legsEncrustedPlate = new ItemArmourMF(itemId + 148, ArmourDesign.PLATE, EnumArmourMF.ENCRUSTED, 2, 2, "encrustedPlate_2").func_77655_b("encrustedPlateLegs");
/*  224 */   public static final Item bootsEncrustedPlate = new ItemArmourMF(itemId + 149, ArmourDesign.PLATE, EnumArmourMF.ENCRUSTED, 2, 3, "encrustedPlate_1").func_77655_b("encrustedPlateBoots");
/*      */   
/*  226 */   public static final Item helmetSteelSplint = new ItemArmourMF(itemId + 150, ArmourDesign.SPLINT, EnumArmourMF.STEEL, 1, 0, "steelSplint_1").func_77655_b("steelSplintHelmet");
/*  227 */   public static final Item plateSteelSplint = new ItemArmourMF(itemId + 151, ArmourDesign.SPLINT, EnumArmourMF.STEEL, 1, 1, "steelSplint_1").func_77655_b("steelSplintChest");
/*  228 */   public static final Item legsSteelSplint = new ItemArmourMF(itemId + 152, ArmourDesign.SPLINT, EnumArmourMF.STEEL, 2, 2, "steelSplint_2").func_77655_b("steelSplintLegs");
/*  229 */   public static final Item bootsSteelSplint = new ItemArmourMF(itemId + 153, ArmourDesign.SPLINT, EnumArmourMF.STEEL, 2, 3, "steelSplint_1").func_77655_b("steelSplintBoots");
/*      */   
/*  231 */   public static final Item helmetSteelScale = new ItemArmourMF(itemId + 154, ArmourDesign.SCALE, EnumArmourMF.STEEL, 1, 0, "steelScale_1").func_77655_b("steelScaleHelmet");
/*  232 */   public static final Item plateSteelScale = new ItemArmourMF(itemId + 155, ArmourDesign.SCALE, EnumArmourMF.STEEL, 1, 1, "steelScale_1").func_77655_b("steelScaleChest");
/*  233 */   public static final Item legsSteelScale = new ItemArmourMF(itemId + 156, ArmourDesign.SCALE, EnumArmourMF.STEEL, 2, 2, "steelScale_2").func_77655_b("steelScaleLegs");
/*  234 */   public static final Item bootsSteelScale = new ItemArmourMF(itemId + 157, ArmourDesign.SCALE, EnumArmourMF.STEEL, 2, 3, "steelScale_1").func_77655_b("steelScaleBoots");
/*      */   
/*  236 */   public static final Item helmetMithrilSplint = new ItemArmourMF(itemId + 158, ArmourDesign.SPLINT, EnumArmourMF.MITHRIL, 1, 0, "mithrilSplint_1").func_77655_b("mithrilSplintHelmet");
/*  237 */   public static final Item plateMithrilSplint = new ItemArmourMF(itemId + 159, ArmourDesign.SPLINT, EnumArmourMF.MITHRIL, 1, 1, "mithrilSplint_1").func_77655_b("mithrilSplintChest");
/*  238 */   public static final Item legsMithrilSplint = new ItemArmourMF(itemId + 160, ArmourDesign.SPLINT, EnumArmourMF.MITHRIL, 2, 2, "mithrilSplint_2").func_77655_b("mithrilSplintLegs");
/*  239 */   public static final Item bootsMithrilSplint = new ItemArmourMF(itemId + 161, ArmourDesign.SPLINT, EnumArmourMF.MITHRIL, 2, 3, "mithrilSplint_1").func_77655_b("mithrilSplintBoots");
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  254 */   public static final Item helmetIronHvyChain = new ItemArmourMF(itemId + 166, ArmourDesign.HVYCHAIN, EnumArmourMF.IRON, 1, 0, "ironHvyChain_1").func_77655_b("ironHvyHelmet");
/*  255 */   public static final Item plateIronHvyChain = new ItemArmourMF(itemId + 167, ArmourDesign.HVYCHAIN, EnumArmourMF.IRON, 1, 1, "ironHvyChain_1").func_77655_b("ironHvyChest");
/*  256 */   public static final Item legsIronHvyChain = new ItemArmourMF(itemId + 168, ArmourDesign.HVYCHAIN, EnumArmourMF.IRON, 2, 2, "ironHvyChain_2").func_77655_b("ironHvyLegs");
/*  257 */   public static final Item bootsIronHvyChain = new ItemArmourMF(itemId + 169, ArmourDesign.HVYCHAIN, EnumArmourMF.IRON, 2, 3, "ironHvyChain_1").func_77655_b("ironHvyBoots");
/*      */   
/*  259 */   public static final Item drakeRaw = new ItemFoodMF(itemId + 170, 5, 0.5F, true).func_77655_b("drakeRaw");
/*  260 */   public static final Item drakeCooked = new ItemFoodMF(itemId + 171, 12, 1.2F, true, new net.minecraft.potion.PotionEffect(Potion.field_76443_y.field_76415_H, 6000, 0, true)).func_77655_b("drakeCooked");
/*      */   
/*  262 */   public static final Item maceCopper = new ItemMaceMF(itemId + 172, ToolMaterialMedieval.COPPER).func_77655_b("maceCopper");
/*  263 */   public static final Item maceBronze = new ItemMaceMF(itemId + 173, ToolMaterialMedieval.BRONZE).func_77655_b("maceBronze");
/*  264 */   public static final Item maceIron = new ItemMaceMF(itemId + 174, ToolMaterialMedieval.IRON).func_77655_b("maceIron");
/*  265 */   public static final Item maceSteel = new ItemMaceMF(itemId + 175, ToolMaterialMedieval.STEEL).func_77655_b("maceSteel");
/*  266 */   public static final Item maceMithril = new ItemMaceMF(itemId + 176, ToolMaterialMedieval.MITHRIL).func_77655_b("maceMithril");
/*  267 */   public static final Item maceDragon = new ItemMaceMF(itemId + 177, ToolMaterialMedieval.DRAGONFORGE).func_77655_b("maceDragon");
/*  268 */   public static final Item maceOrnate = new ItemMaceMF(itemId + 178, ToolMaterialMedieval.ORNATE).func_77655_b("maceOrnate");
/*  269 */   public static final Item waraxeBronze = new ItemWaraxe(itemId + 179, ToolMaterialMedieval.BRONZE).func_77655_b("waraxeBronze");
/*      */   
/*  271 */   public static final Item hammerMithril = new ItemHammer(itemId + 180, 4.0F, ToolMaterialMedieval.MITHRIL).func_77655_b("hammerMithril");
/*  272 */   public static final Item scytheMithril = new ItemScytheMF(itemId + 181, ToolMaterialMedieval.MITHRIL).func_77655_b("scytheMithril");
/*  273 */   public static final Item hound_Iplate = new ItemHoundArmourMF(itemId + 182, EnumArmourMF.IRON, true, "iron", 1, 40).func_77655_b("hound_Iplate");
/*  274 */   public static final Item hound_IplateH = new ItemHoundArmourMF(itemId + 183, EnumArmourMF.IRON, true, "iron", 0, 40).func_77655_b("hound_IplateH");
/*  275 */   public static final Item sawDragon = new ItemSaw(itemId + 184, ToolMaterialMedieval.DRAGONFORGE).func_77655_b("sawDragon");
/*      */   
/*  277 */   public static final Item hound_feed = new ItemHoundFeedbagMF(itemId + 185, 100, "bigPack", 0).func_77655_b("hound_feed");
/*  278 */   public static final Item hound_sPack = new ItemHoundPackMF(itemId + 186, 1, 3, "pack", 10, 0, 10).func_77655_b("hound_sPack");
/*  279 */   public static final Item hound_bPack = new ItemHoundPackMF(itemId + 187, 1, 6, "bigPack", 50, 0, 30).func_77655_b("hound_bPack");
/*      */   
/*  281 */   public static final Item hammerTin = new ItemHammer(itemId + 188, 0.35F, ToolMaterialMedieval.TIN).func_77655_b("hammerTin");
/*  282 */   public static final Item shearsTin = new ItemShearsMF(itemId + 189, ToolMaterialMedieval.TIN).func_77655_b("shearsTin");
/*      */   
/*  284 */   public static final Item hound_BMail = new ItemHoundArmourMF(itemId + 190, EnumArmourMF.BRONZE, false, "bronze", 1, 5).func_77655_b("hound_BMail");
/*  285 */   public static final Item hound_BMailH = new ItemHoundArmourMF(itemId + 191, EnumArmourMF.BRONZE, false, "bronze", 0, 5).func_77655_b("hound_BMailH");
/*  286 */   public static final Item hound_IMail = new ItemHoundArmourMF(itemId + 192, EnumArmourMF.IRON, false, "iron", 1, 10).func_77655_b("hound_IMail");
/*  287 */   public static final Item hound_IMailH = new ItemHoundArmourMF(itemId + 193, EnumArmourMF.IRON, false, "iron", 0, 10).func_77655_b("hound_IMailH");
/*  288 */   public static final Item hound_SMail = new ItemHoundArmourMF(itemId + 194, EnumArmourMF.STEEL, false, "steel", 1, 20).func_77655_b("hound_SMail");
/*  289 */   public static final Item hound_SMailH = new ItemHoundArmourMF(itemId + 195, EnumArmourMF.STEEL, false, "steel", 0, 20).func_77655_b("hound_SMailH");
/*  290 */   public static final Item hound_MMail = new ItemHoundArmourMF(itemId + 196, EnumArmourMF.MITHRIL, false, "mithril", 1, 35).func_77655_b("hound_MMail");
/*  291 */   public static final Item hound_MMailH = new ItemHoundArmourMF(itemId + 197, EnumArmourMF.MITHRIL, false, "mithril", 0, 35).func_77655_b("hound_MMailH");
/*      */   
/*  293 */   public static final Item hound_Bplate = new ItemHoundArmourMF(itemId + 198, EnumArmourMF.BRONZE, true, "bronze", 1, 30).func_77655_b("hound_Bplate");
/*  294 */   public static final Item hound_BplateH = new ItemHoundArmourMF(itemId + 199, EnumArmourMF.BRONZE, true, "bronze", 0, 30).func_77655_b("hound_BplateH");
/*  295 */   public static final Item hound_Splate = new ItemHoundArmourMF(itemId + 200, EnumArmourMF.STEEL, true, "steel", 1, 50).func_77655_b("hound_Splate");
/*  296 */   public static final Item hound_SplateH = new ItemHoundArmourMF(itemId + 201, EnumArmourMF.STEEL, true, "steel", 0, 50).func_77655_b("hound_SplateH");
/*  297 */   public static final Item hound_Dplate = new ItemHoundArmourMF(itemId + 202, EnumArmourMF.DRAGONFORGE, true, "dragon", 1, 55).func_77655_b("hound_Dplate");
/*  298 */   public static final Item hound_DplateH = new ItemHoundArmourMF(itemId + 203, EnumArmourMF.DRAGONFORGE, true, "dragon", 0, 55).func_77655_b("hound_DplateH");
/*  299 */   public static final Item hound_Eplate = new ItemHoundArmourMF(itemId + 204, EnumArmourMF.ENCRUSTED, true, "encrusted", 1, 60).func_77655_b("hound_Eplate");
/*  300 */   public static final Item hound_EplateH = new ItemHoundArmourMF(itemId + 205, EnumArmourMF.ENCRUSTED, true, "encrusted", 0, 60).func_77655_b("hound_EplateH");
/*      */   
/*  302 */   public static final Item hound_Bteeth = new ItemHoundWeaponMF(itemId + 206, ToolMaterialMedieval.BRONZE, "bronze", 10, 1).func_77655_b("hound_Bteeth");
/*  303 */   public static final Item hound_Iteeth = new ItemHoundWeaponMF(itemId + 207, ToolMaterialMedieval.IRON, "iron", 15, 2).func_77655_b("hound_Iteeth");
/*  304 */   public static final Item hound_Steeth = new ItemHoundWeaponMF(itemId + 208, ToolMaterialMedieval.STEEL, "steel", 25, 3).func_77655_b("hound_Steeth");
/*  305 */   public static final Item hound_Eteeth = new ItemHoundWeaponMF(itemId + 209, ToolMaterialMedieval.ENCRUSTED, "encrusted", 35, 4).func_77655_b("hound_Eteeth");
/*  306 */   public static final Item hound_Mteeth = new ItemHoundWeaponMF(itemId + 210, ToolMaterialMedieval.MITHRIL, "mithril", 45, 5).func_77655_b("hound_Mteeth");
/*  307 */   public static final Item hound_Dteeth = new ItemHoundWeaponMF(itemId + 211, ToolMaterialMedieval.DRAGONFORGE, "dragon", 30, 4).func_77655_b("hound_Dteeth");
/*      */   
/*  309 */   public static final Item spearBronze = new ItemSpearMF(itemId + 212, ToolMaterialMedieval.BRONZE).func_77655_b("spearBronze");
/*  310 */   public static final Item spearIron = new ItemSpearMF(itemId + 213, ToolMaterialMedieval.IRON).func_77655_b("spearIron");
/*  311 */   public static final Item spearSteel = new ItemSpearMF(itemId + 214, ToolMaterialMedieval.STEEL).func_77655_b("spearSteel");
/*  312 */   public static final Item spearEncrusted = new ItemSpearMF(itemId + 215, ToolMaterialMedieval.ENCRUSTED).func_77655_b("spearEncrusted");
/*  313 */   public static final Item spearMithril = new ItemSpearMF(itemId + 216, ToolMaterialMedieval.MITHRIL).func_77655_b("spearMithril");
/*  314 */   public static final Item waraxeMithril = new ItemWaraxe(itemId + 217, ToolMaterialMedieval.MITHRIL).func_77655_b("waraxeMithril");
/*  315 */   public static final Item spearDragon = new ItemSpearMF(itemId + 218, ToolMaterialMedieval.DRAGONFORGE).func_77655_b("spearDragon");
/*  316 */   public static final Item waraxeOrnate = new ItemWaraxe(itemId + 219, ToolMaterialMedieval.ORNATE).func_77655_b("waraxeOrnate");
/*  317 */   public static final Item spearOrnate = new ItemSpearMF(itemId + 220, ToolMaterialMedieval.ORNATE).func_77655_b("spearOrnate");
/*      */   
/*  319 */   public static final Item battleaxeBronze = new ItemBattleaxe(itemId + 221, ToolMaterialMedieval.BRONZE).func_77655_b("battleaxeBronze");
/*  320 */   public static final Item battleaxeIron = new ItemBattleaxe(itemId + 222, ToolMaterialMedieval.IRON).func_77655_b("battleaxeIron");
/*  321 */   public static final Item battleaxeSteel = new ItemBattleaxe(itemId + 223, ToolMaterialMedieval.STEEL).func_77655_b("battleaxeSteel");
/*  322 */   public static final Item battleaxeEncrusted = new ItemBattleaxe(itemId + 224, ToolMaterialMedieval.ENCRUSTED).func_77655_b("battleaxeEncrusted");
/*  323 */   public static final Item battleaxeMithril = new ItemBattleaxe(itemId + 225, ToolMaterialMedieval.MITHRIL).func_77655_b("battleaxeMithril");
/*  324 */   public static final Item battleaxeOrnate = new ItemBattleaxe(itemId + 226, ToolMaterialMedieval.ORNATE).func_77655_b("battleaxeOrnate");
/*  325 */   public static final Item mattockSteel = new ItemMattock(itemId + 227, ToolMaterialMedieval.STEEL).func_77655_b("mattockSteel");
/*  326 */   public static final Item battleaxeDragon = new ItemBattleaxe(itemId + 228, ToolMaterialMedieval.DRAGONFORGE).func_77655_b("battleaxeDragon");
/*  327 */   public static final Item sawBronze = new ItemSaw(itemId + 229, ToolMaterialMedieval.BRONZE).func_77655_b("sawBronze");
/*      */   
/*  329 */   public static final Item scytheBronze = new ItemScytheMF(itemId + 230, ToolMaterialMedieval.BRONZE).func_77655_b("scytheBronze");
/*  330 */   public static final Item scytheIron = new ItemScytheMF(itemId + 231, ToolMaterialMedieval.IRON).func_77655_b("scytheIron");
/*  331 */   public static final Item scytheSteel = new ItemScytheMF(itemId + 232, ToolMaterialMedieval.STEEL).func_77655_b("scytheSteel");
/*  332 */   public static final Item hammerStone = new ItemHammer(itemId + 233, 0.3F, EnumToolMaterial.STONE).func_77655_b("hammerStone");
/*      */   
/*  334 */   public static final Item greatswordBronze = new ItemGreatsword(itemId + 234, ToolMaterialMedieval.BRONZE).func_77655_b("greatswordBronze");
/*  335 */   public static final Item greatswordIron = new ItemGreatsword(itemId + 235, ToolMaterialMedieval.IRON).func_77655_b("greatswordIron");
/*  336 */   public static final Item greatswordSteel = new ItemGreatsword(itemId + 236, ToolMaterialMedieval.STEEL).func_77655_b("greatswordSteel");
/*  337 */   public static final Item greatswordEncrusted = new ItemGreatsword(itemId + 237, ToolMaterialMedieval.ENCRUSTED).func_77655_b("greatswordEncrusted");
/*  338 */   public static final Item greatswordMithril = new ItemGreatsword(itemId + 238, ToolMaterialMedieval.MITHRIL).func_77655_b("greatswordMithril");
/*  339 */   public static final Item greatswordDragon = new ItemGreatsword(itemId + 239, ToolMaterialMedieval.DRAGONFORGE).func_77655_b("greatswordDragon");
/*  340 */   public static final Item sawIron = new ItemSaw(itemId + 240, ToolMaterialMedieval.IRON).func_77655_b("sawIron");
/*  341 */   public static final Item greatswordOrnate = new ItemGreatsword(itemId + 241, ToolMaterialMedieval.ORNATE).func_77655_b("greatswordOrnate");
/*  342 */   public static final Item sawSteel = new ItemSaw(itemId + 242, ToolMaterialMedieval.STEEL).func_77655_b("sawSteel");
/*      */   
/*  344 */   public static final Item hammerRepair = new ItemRepairHammer(itemId + 243, 32, 0.5F, 0.5F, false, 0).func_77655_b("hammerRepair");
/*  345 */   public static final Item hammerRepairOrnate = new ItemRepairHammer(itemId + 244, 64, 0.5F, 0.5F, true, 1).func_77655_b("hammerRepairOrnate");
/*      */   
/*  347 */   public static final Item hammerRepair2 = new ItemRepairHammer(itemId + 245, 48, 0.5F, 0.8F, false, 1).func_77655_b("hammerRepair2");
/*  348 */   public static final Item hammerRepairOrnate2 = new ItemRepairHammer(itemId + 246, 96, 0.5F, 0.8F, true, 2).func_77655_b("hammerRepairOrnate2");
/*      */   
/*  350 */   public static final Item hammerRepairArtisan = new ItemRepairHammer(itemId + 247, 256, 0.8F, 1.0F, false, 2).func_77655_b("hammerRepairArtisan");
/*  351 */   public static final Item hammerRepairOrnateArtisan = new ItemRepairHammer(itemId + 248, 384, 0.8F, 1.0F, true, 3).func_77655_b("hammerRepairOrnateArtisan");
/*      */   
/*  353 */   public static final Item daggerBronze = new ItemDagger(itemId + 285, ToolMaterialMedieval.BRONZE).func_77655_b("daggerBronze");
/*  354 */   public static final Item daggerIron = new ItemDagger(itemId + 286, ToolMaterialMedieval.IRON).func_77655_b("daggerIron");
/*  355 */   public static final Item daggerSteel = new ItemDagger(itemId + 287, ToolMaterialMedieval.STEEL).func_77655_b("daggerSteel");
/*  356 */   public static final Item daggerEncrusted = new ItemDagger(itemId + 288, ToolMaterialMedieval.ENCRUSTED).func_77655_b("daggerEncrusted");
/*  357 */   public static final Item daggerMithril = new ItemDagger(itemId + 289, ToolMaterialMedieval.MITHRIL).func_77655_b("daggerMithril");
/*  358 */   public static final Item daggerDragon = new ItemDagger(itemId + 290, ToolMaterialMedieval.DRAGONFORGE).func_77655_b("daggerDragon");
/*  359 */   public static final Item pickCopperForged = new ItemMedievalPick(itemId + 291, ToolMaterialMedieval.COPPER).func_77655_b("pickCopperForged");
/*  360 */   public static final Item daggerOrnate = new ItemDagger(itemId + 292, ToolMaterialMedieval.ORNATE).func_77655_b("daggerOrnate");
/*  361 */   public static final Item axeCopperForged = new ItemMedievalAxe(itemId + 293, ToolMaterialMedieval.COPPER).func_77655_b("axeCopperForged");
/*      */   
/*  363 */   public static final Item scytheDragon = new ItemScytheMF(itemId + 294, ToolMaterialMedieval.DRAGONFORGE).func_77655_b("scytheDragon");
/*  364 */   public static final Item shearsDragon = new ItemShearsMF(itemId + 295, ToolMaterialMedieval.DRAGONFORGE).func_77655_b("shearsDragon");
/*  365 */   public static final Item spadeDragon = new ItemMedievalSpade(itemId + 296, ToolMaterialMedieval.DRAGONFORGE).func_77655_b("spadeDragon");
/*  366 */   public static final Item tongsDragon = new ItemTongs(itemId + 297, ToolMaterialMedieval.DRAGONFORGE).func_77655_b("tongsDragon");
/*  367 */   public static final Item bowDragon = new ItemBowMF(itemId + 298, ToolMaterialMedieval.DRAGONFORGE, EnumBowType.RECURVE).func_77655_b("bowDragonforge");
/*  368 */   public static final Item bowOrnate = new ItemBowMF(itemId + 299, ToolMaterialMedieval.ORNATE, EnumBowType.RECURVE).func_77655_b("bowOrnate");
/*  369 */   public static final Item spadeCopperForged = new ItemMedievalSpade(itemId + 300, ToolMaterialMedieval.COPPER).func_77655_b("spadeCopper");
/*  370 */   public static final Item malletEbony = new ItemMallet(itemId + 301, ToolMaterialMedieval.IRONBARK).func_77655_b("malletEbony");
/*  371 */   public static final Item hoeCopperForged = new ItemMedievalHoe(itemId + 302, ToolMaterialMedieval.COPPER).func_77655_b("hoeCopperForged");
/*      */   
/*  373 */   public static final Item helmetStealth = new ItemStealthArmour(itemId + 303, MedievalArmourMaterial.STEALTH, 1, 0, "stealth_1").func_77655_b("stealthHelmet");
/*  374 */   public static final Item plateStealth = new ItemStealthArmour(itemId + 304, MedievalArmourMaterial.STEALTH, 1, 1, "stealth_1").func_77655_b("stealthChest");
/*  375 */   public static final Item legsStealth = new ItemStealthArmour(itemId + 305, MedievalArmourMaterial.STEALTH, 2, 2, "stealth_2").func_77655_b("stealthLegs");
/*  376 */   public static final Item bootsStealth = new ItemStealthArmour(itemId + 306, MedievalArmourMaterial.STEALTH, 2, 3, "stealth_1").func_77655_b("stealthBoots");
/*      */   
/*  378 */   public static final Item crossbowHand = new ItemCrossbow(itemId + 307, EnumAmmo.BOLT, EnumCrossbowType.HAND_CROSSBOW).func_77655_b("crossbowHand");
/*  379 */   public static final Item crossbowLight = new ItemCrossbow(itemId + 308, EnumAmmo.BOLT, EnumCrossbowType.LIGHT_CROSSBOW).func_77655_b("crossbowLight");
/*  380 */   public static final Item crossbowRepeat = new ItemCrossbow(itemId + 309, EnumAmmo.BOLT, EnumCrossbowType.REPEATER_CROSSBOW).func_77655_b("crossbowRepeat");
/*  381 */   public static final Item crossbowHeavy = new ItemCrossbow(itemId + 310, EnumAmmo.ARROW, EnumCrossbowType.HEAVY_CROSSBOW).func_77655_b("crossbowHeavy");
/*      */   
/*  383 */   public static final Item tongsStone = new ItemTongs(itemId + 311, EnumToolMaterial.STONE).func_77655_b("tongsStone");
/*  384 */   public static final Item boltMF = new ItemBoltMF(itemId + 312).func_77655_b("boltMF");
/*      */   
/*  386 */   public static final Item spearStone = new ItemSpearMF(itemId + 313, ToolMaterialMedieval.PRIMITIVE_STONE).func_77655_b("spearStonePrim").func_77637_a(CreativeTabs.field_78037_j);
/*  387 */   public static final Item spearCopper = new ItemSpearMF(itemId + 314, ToolMaterialMedieval.PRIMITIVE_COPPER).func_77655_b("spearCopperPrim").func_77637_a(CreativeTabs.field_78037_j);
/*      */   
/*  389 */   public static final Item pickStonePrim = new minefantasy.item.tool.ItemPrimitivePick(itemId + 315, ToolMaterialMedieval.PRIMITIVE_STONE).func_77655_b("pickStonePrim");
/*  390 */   public static final Item pickCopperPrim = new minefantasy.item.tool.ItemPrimitivePick(itemId + 316, ToolMaterialMedieval.PRIMITIVE_COPPER).func_77655_b("pickCopperPrim");
/*  391 */   public static final Item rocks = new minefantasy.item.tool.ItemLighter(itemId + 317, 8, minefantasy.system.cfg.dryRocksChance).func_77655_b("flintAndRock");
/*  392 */   public static final Item javelin = new ItemJavelin(itemId + 318, 4).func_77655_b("javelin").func_77637_a(CreativeTabs.field_78037_j);
/*  393 */   public static final Item armourRawhide = new ItemArmourMFOld(itemId + 319, ArmourDesign.LEATHER, MedievalArmourMaterial.RAWHIDE, 1, 1, "rawhide_1").func_77655_b("rawhideChest");
/*  394 */   public static final Item legsRawhide = new ItemArmourMFOld(itemId + 320, ArmourDesign.LEATHER, MedievalArmourMaterial.RAWHIDE, 2, 2, "rawhide_2").func_77655_b("rawhideLegs");
/*  395 */   public static final Item clubWood = new ItemSwordMF(itemId + 321, EnumToolMaterial.WOOD, 3.0F, 64).func_77655_b("clubPrim").func_77637_a(CreativeTabs.field_78037_j);
/*  396 */   public static final Item clubStone = new ItemSwordMF(itemId + 322, ToolMaterialMedieval.PRIMITIVE_STONE, 4.0F, 128).func_77655_b("clubStonePrim").func_77637_a(CreativeTabs.field_78037_j);
/*      */   
/*  398 */   public static final Item bowEbony = new ItemBowMF(itemId + 323, ToolMaterialMedieval.EBONY, EnumBowType.COMPOSITE).func_77655_b("bowEbony");
/*      */   
/*  400 */   public static final Item waraxeIron = new ItemWaraxe(itemId + 324, ToolMaterialMedieval.IRON).func_77655_b("waraxeIron");
/*      */   
/*  402 */   public static final Item shearsCopper = new ItemShearsMF(itemId + 325, ToolMaterialMedieval.COPPER).func_77655_b("shearsCopper");
/*  403 */   public static final Item shearsBronze = new ItemShearsMF(itemId + 326, ToolMaterialMedieval.BRONZE).func_77655_b("shearsBronze");
/*  404 */   public static final Item shearsIron = new ItemShearsMF(itemId + 327, ToolMaterialMedieval.IRON).func_77655_b("shearsIron");
/*  405 */   public static final Item shearsSteel = new ItemShearsMF(itemId + 328, ToolMaterialMedieval.STEEL).func_77655_b("shearsSteel");
/*      */   
/*  407 */   public static final Item warhammerBronze = new ItemWarhammer(itemId + 329, ToolMaterialMedieval.BRONZE).func_77655_b("warhammerBronze");
/*  408 */   public static final Item warhammerIron = new ItemWarhammer(itemId + 330, ToolMaterialMedieval.IRON).func_77655_b("warhammerIron");
/*  409 */   public static final Item warhammerSteel = new ItemWarhammer(itemId + 331, ToolMaterialMedieval.STEEL).func_77655_b("warhammerSteel");
/*  410 */   public static final Item warhammerOrnate = new ItemWarhammer(itemId + 332, ToolMaterialMedieval.ORNATE).func_77655_b("warhammerOrnate");
/*  411 */   public static final Item warhammerMithril = new ItemWarhammer(itemId + 333, ToolMaterialMedieval.MITHRIL).func_77655_b("warhammerMithril");
/*  412 */   public static final Item warhammerDragon = new ItemWarhammer(itemId + 334, ToolMaterialMedieval.DRAGONFORGE).func_77655_b("warhammerDragon");
/*      */   
/*  414 */   public static final Item helmetIronScale = new ItemArmourMF(itemId + 335, ArmourDesign.SCALE, EnumArmourMF.IRON, 1, 0, "ironScale_1").func_77655_b("ironScaleHelmet");
/*  415 */   public static final Item plateIronScale = new ItemArmourMF(itemId + 336, ArmourDesign.SCALE, EnumArmourMF.IRON, 1, 1, "ironScale_1").func_77655_b("ironScaleChest");
/*  416 */   public static final Item legsIronScale = new ItemArmourMF(itemId + 337, ArmourDesign.SCALE, EnumArmourMF.IRON, 2, 2, "ironScale_2").func_77655_b("ironScaleLegs");
/*  417 */   public static final Item bootsIronScale = new ItemArmourMF(itemId + 338, ArmourDesign.SCALE, EnumArmourMF.IRON, 2, 3, "ironScale_1").func_77655_b("ironScaleBoots");
/*  418 */   public static final Item transferHound = new ItemPetChange(itemId + 339).func_77655_b("petChange");
/*  419 */   public static final Item hound_Igteeth = new ItemHoundWeaponMF(itemId + 340, ToolMaterialMedieval.IGNOTUMITE, "ignotumite", 80, 5).func_77655_b("hound_Igteeth");
/*  420 */   public static final Item hound_Oteeth = new ItemHoundWeaponMF(itemId + 341, ToolMaterialMedieval.ORNATE, "ornate", 20, 1).func_77655_b("hound_Oteeth");
/*      */   
/*  422 */   public static final Item halbeardBronze = new ItemHalbeard(itemId + 342, ToolMaterialMedieval.BRONZE).func_77655_b("halbeardBronze");
/*  423 */   public static final Item halbeardIron = new ItemHalbeard(itemId + 343, ToolMaterialMedieval.IRON).func_77655_b("halbeardIron");
/*  424 */   public static final Item halbeardSteel = new ItemHalbeard(itemId + 344, ToolMaterialMedieval.STEEL).func_77655_b("halbeardSteel");
/*  425 */   public static final Item halbeardOrnate = new ItemHalbeard(itemId + 345, ToolMaterialMedieval.ORNATE).func_77655_b("halbeardOrnate");
/*  426 */   public static final Item halbeardEncrusted = new ItemHalbeard(itemId + 346, ToolMaterialMedieval.ENCRUSTED).func_77655_b("halbeardEncrusted");
/*  427 */   public static final Item halbeardMithril = new ItemHalbeard(itemId + 347, ToolMaterialMedieval.MITHRIL).func_77655_b("halbeardMithril");
/*  428 */   public static final Item halbeardDragon = new ItemHalbeard(itemId + 348, ToolMaterialMedieval.DRAGONFORGE).func_77655_b("halbeardDragon");
/*      */   
/*  430 */   public static final Item bloom = new ItemBloom(itemId + 349).func_77655_b("bloom");
/*  431 */   public static final Item sling = new ItemSlingMF(itemId + 350, 256).func_77655_b("sling");
/*      */   
/*  433 */   public static final Item basiliskRaw = new ItemFoodMF(itemId + 351, 4, 0.4F, true, 4).func_77844_a(Potion.field_76444_x.field_76415_H, 300, 3, 1.0F).func_77655_b("basiliskRaw");
/*  434 */   public static final Item basiliskCooked = new ItemFoodMF(itemId + 352, 10, 3.0F, true, 8).func_77844_a(Potion.field_76444_x.field_76415_H, 600, 3, 1.0F).func_77655_b("basiliskCooked");
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*  439 */   public static final Item helmetMithrilScale = new ItemArmourMF(itemId + 354, ArmourDesign.SCALE, EnumArmourMF.MITHRIL, 1, 0, "mithrilScale_1").func_77655_b("mithrilScaleHelmet");
/*  440 */   public static final Item plateMithrilScale = new ItemArmourMF(itemId + 355, ArmourDesign.SCALE, EnumArmourMF.MITHRIL, 1, 1, "mithrilScale_1").func_77655_b("mithrilScaleChest");
/*  441 */   public static final Item legsMithrilScale = new ItemArmourMF(itemId + 356, ArmourDesign.SCALE, EnumArmourMF.MITHRIL, 2, 2, "mithrilScale_2").func_77655_b("mithrilScaleLegs");
/*  442 */   public static final Item bootsMithrilScale = new ItemArmourMF(itemId + 357, ArmourDesign.SCALE, EnumArmourMF.MITHRIL, 2, 3, "mithrilScale_1").func_77655_b("mithrilScaleBoots");
/*  443 */   public static final Item helmetDragonScale = new ItemArmourMF(itemId + 358, ArmourDesign.SCALE, EnumArmourMF.DRAGONFORGE, 1, 0, "dragonforgeScale_1").func_77655_b("dragonforgeScaleHelmet");
/*  444 */   public static final Item plateDragonScale = new ItemArmourMF(itemId + 359, ArmourDesign.SCALE, EnumArmourMF.DRAGONFORGE, 1, 1, "dragonforgeScale_1").func_77655_b("dragonforgeScaleChest");
/*  445 */   public static final Item legsDragonScale = new ItemArmourMF(itemId + 360, ArmourDesign.SCALE, EnumArmourMF.DRAGONFORGE, 2, 2, "dragonforgeScale_2").func_77655_b("dragonforgeScaleLegs");
/*  446 */   public static final Item bootsDragonScale = new ItemArmourMF(itemId + 361, ArmourDesign.SCALE, EnumArmourMF.DRAGONFORGE, 2, 3, "dragonforgeScale_1").func_77655_b("dragonforgeScaleBoots");
/*      */   
/*  448 */   public static final Item helmetSteelChain = new ItemArmourMF(itemId + 362, ArmourDesign.CHAIN, EnumArmourMF.STEEL, 1, 0, "steelChain_1").func_77655_b("steelChainHelmet");
/*  449 */   public static final Item plateSteelChain = new ItemArmourMF(itemId + 363, ArmourDesign.CHAIN, EnumArmourMF.STEEL, 1, 1, "steelChain_1").func_77655_b("steelChainChest");
/*  450 */   public static final Item legsSteelChain = new ItemArmourMF(itemId + 364, ArmourDesign.CHAIN, EnumArmourMF.STEEL, 2, 2, "steelChain_2").func_77655_b("steelChainLegs");
/*  451 */   public static final Item bootsSteelChain = new ItemArmourMF(itemId + 365, ArmourDesign.CHAIN, EnumArmourMF.STEEL, 2, 3, "steelChain_1").func_77655_b("steelChainBoots");
/*  452 */   public static final Item helmetMithrilChain = new ItemArmourMF(itemId + 366, ArmourDesign.CHAIN, EnumArmourMF.MITHRIL, 1, 0, "mithrilChain_1").func_77655_b("mithrilChainHelmet");
/*  453 */   public static final Item plateMithrilChain = new ItemArmourMF(itemId + 367, ArmourDesign.CHAIN, EnumArmourMF.MITHRIL, 1, 1, "mithrilChain_1").func_77655_b("mithrilChainChest");
/*  454 */   public static final Item legsMithrilChain = new ItemArmourMF(itemId + 368, ArmourDesign.CHAIN, EnumArmourMF.MITHRIL, 2, 2, "mithrilChain_2").func_77655_b("mithrilChainLegs");
/*  455 */   public static final Item bootsMithrilChain = new ItemArmourMF(itemId + 369, ArmourDesign.CHAIN, EnumArmourMF.MITHRIL, 2, 3, "mithrilChain_1").func_77655_b("mithrilChainBoots");
/*  456 */   public static final Item helmetDragonChain = new ItemArmourMF(itemId + 370, ArmourDesign.CHAIN, EnumArmourMF.DRAGONFORGE, 1, 0, "dragonforgeChain_1").func_77655_b("dragonforgeChainHelmet");
/*  457 */   public static final Item plateDragonChain = new ItemArmourMF(itemId + 371, ArmourDesign.CHAIN, EnumArmourMF.DRAGONFORGE, 1, 1, "dragonforgeChain_1").func_77655_b("dragonforgeChainChest");
/*  458 */   public static final Item legsDragonChain = new ItemArmourMF(itemId + 372, ArmourDesign.CHAIN, EnumArmourMF.DRAGONFORGE, 2, 2, "dragonforgeChain_2").func_77655_b("dragonforgeChainLegs");
/*  459 */   public static final Item bootsDragonChain = new ItemArmourMF(itemId + 373, ArmourDesign.CHAIN, EnumArmourMF.DRAGONFORGE, 2, 3, "dragonforgeChain_1").func_77655_b("dragonforgeChainBoots");
/*      */   
/*  461 */   public static final Item helmetBronzeSplint = new ItemArmourMF(itemId + 374, ArmourDesign.SPLINT, EnumArmourMF.BRONZE, 1, 0, "bronzeSplint_1").func_77655_b("bronzeSplintHelmet");
/*  462 */   public static final Item plateBronzeSplint = new ItemArmourMF(itemId + 375, ArmourDesign.SPLINT, EnumArmourMF.BRONZE, 1, 1, "bronzeSplint_1").func_77655_b("bronzeSplintChest");
/*  463 */   public static final Item legsBronzeSplint = new ItemArmourMF(itemId + 376, ArmourDesign.SPLINT, EnumArmourMF.BRONZE, 2, 2, "bronzeSplint_2").func_77655_b("bronzeSplintLegs");
/*  464 */   public static final Item bootsBronzeSplint = new ItemArmourMF(itemId + 377, ArmourDesign.SPLINT, EnumArmourMF.BRONZE, 2, 3, "bronzeSplint_1").func_77655_b("bronzeSplintBoots");
/*  465 */   public static final Item helmetIronSplint = new ItemArmourMF(itemId + 378, ArmourDesign.SPLINT, EnumArmourMF.IRON, 1, 0, "ironSplint_1").func_77655_b("ironSplintHelmet");
/*  466 */   public static final Item plateIronSplint = new ItemArmourMF(itemId + 379, ArmourDesign.SPLINT, EnumArmourMF.IRON, 1, 1, "ironSplint_1").func_77655_b("ironSplintChest");
/*  467 */   public static final Item legsIronSplint = new ItemArmourMF(itemId + 380, ArmourDesign.SPLINT, EnumArmourMF.IRON, 2, 2, "ironSplint_2").func_77655_b("ironSplintLegs");
/*  468 */   public static final Item bootsIronSplint = new ItemArmourMF(itemId + 381, ArmourDesign.SPLINT, EnumArmourMF.IRON, 2, 3, "ironSplint_1").func_77655_b("ironSplintBoots");
/*  469 */   public static final Item helmetDragonSplint = new ItemArmourMF(itemId + 382, ArmourDesign.SPLINT, EnumArmourMF.DRAGONFORGE, 1, 0, "dragonforgeSplint_1").func_77655_b("dragonforgeSplintHelmet");
/*  470 */   public static final Item plateDragonSplint = new ItemArmourMF(itemId + 383, ArmourDesign.SPLINT, EnumArmourMF.DRAGONFORGE, 1, 1, "dragonforgeSplint_1").func_77655_b("dragonforgeSplintChest");
/*  471 */   public static final Item legsDragonSplint = new ItemArmourMF(itemId + 384, ArmourDesign.SPLINT, EnumArmourMF.DRAGONFORGE, 2, 2, "dragonforgeSplint_2").func_77655_b("dragonforgeSplintLegs");
/*  472 */   public static final Item bootsDragonSplint = new ItemArmourMF(itemId + 385, ArmourDesign.SPLINT, EnumArmourMF.DRAGONFORGE, 2, 3, "dragonforgeSplint_1").func_77655_b("dragonforgeSplintBoots");
/*      */   
/*  474 */   public static final Item helmetBronzeHvyChain = new ItemArmourMF(itemId + 386, ArmourDesign.HVYCHAIN, EnumArmourMF.BRONZE, 1, 0, "bronzeHvyChain_1").func_77655_b("bronzeHvyHelmet");
/*  475 */   public static final Item plateBronzeHvyChain = new ItemArmourMF(itemId + 387, ArmourDesign.HVYCHAIN, EnumArmourMF.BRONZE, 1, 1, "bronzeHvyChain_1").func_77655_b("bronzeHvyChest");
/*  476 */   public static final Item legsBronzeHvyChain = new ItemArmourMF(itemId + 388, ArmourDesign.HVYCHAIN, EnumArmourMF.BRONZE, 2, 2, "bronzeHvyChain_2").func_77655_b("bronzeHvyLegs");
/*  477 */   public static final Item bootsBronzeHvyChain = new ItemArmourMF(itemId + 389, ArmourDesign.HVYCHAIN, EnumArmourMF.BRONZE, 2, 3, "bronzeHvyChain_1").func_77655_b("bronzeHvyBoots");
/*  478 */   public static final Item helmetSteelHvyChain = new ItemArmourMF(itemId + 390, ArmourDesign.HVYCHAIN, EnumArmourMF.STEEL, 1, 0, "steelHvyChain_1").func_77655_b("steelHvyHelmet");
/*  479 */   public static final Item plateSteelHvyChain = new ItemArmourMF(itemId + 391, ArmourDesign.HVYCHAIN, EnumArmourMF.STEEL, 1, 1, "steelHvyChain_1").func_77655_b("steelHvyChest");
/*  480 */   public static final Item legsSteelHvyChain = new ItemArmourMF(itemId + 392, ArmourDesign.HVYCHAIN, EnumArmourMF.STEEL, 2, 2, "steelHvyChain_2").func_77655_b("steelHvyLegs");
/*  481 */   public static final Item bootsSteelHvyChain = new ItemArmourMF(itemId + 393, ArmourDesign.HVYCHAIN, EnumArmourMF.STEEL, 2, 3, "steelHvyChain_1").func_77655_b("steelHvyBoots");
/*  482 */   public static final Item helmetMithrilHvyChain = new ItemArmourMF(itemId + 394, ArmourDesign.HVYCHAIN, EnumArmourMF.MITHRIL, 1, 0, "mithrilHvyChain_1").func_77655_b("mithrilHvyHelmet");
/*  483 */   public static final Item plateMithrilHvyChain = new ItemArmourMF(itemId + 395, ArmourDesign.HVYCHAIN, EnumArmourMF.MITHRIL, 1, 1, "mithrilHvyChain_1").func_77655_b("mithrilHvyChest");
/*  484 */   public static final Item legsMithrilHvyChain = new ItemArmourMF(itemId + 396, ArmourDesign.HVYCHAIN, EnumArmourMF.MITHRIL, 2, 2, "mithrilHvyChain_2").func_77655_b("mithrilHvyLegs");
/*  485 */   public static final Item bootsMithrilHvyChain = new ItemArmourMF(itemId + 397, ArmourDesign.HVYCHAIN, EnumArmourMF.MITHRIL, 2, 3, "mithrilHvyChain_1").func_77655_b("mithrilHvyBoots");
/*  486 */   public static final Item helmetDragonHvyChain = new ItemArmourMF(itemId + 398, ArmourDesign.HVYCHAIN, EnumArmourMF.DRAGONFORGE, 1, 0, "dragonforgeHvyChain_1").func_77655_b("dragonforgeHvyHelmet");
/*  487 */   public static final Item plateDragonHvyChain = new ItemArmourMF(itemId + 399, ArmourDesign.HVYCHAIN, EnumArmourMF.DRAGONFORGE, 1, 1, "dragonforgeHvyChain_1").func_77655_b("dragonforgeHvyChest");
/*  488 */   public static final Item legsDragonHvyChain = new ItemArmourMF(itemId + 400, ArmourDesign.HVYCHAIN, EnumArmourMF.DRAGONFORGE, 2, 2, "dragonforgeHvyChain_2").func_77655_b("dragonforgeHvyLegs");
/*  489 */   public static final Item bootsDragonHvyChain = new ItemArmourMF(itemId + 401, ArmourDesign.HVYCHAIN, EnumArmourMF.DRAGONFORGE, 2, 3, "dragonforgeHvyChain_1").func_77655_b("dragonforgeHvyBoots");
/*      */   
/*  491 */   public static final Item helmetIronPlate = new ItemArmourMF(itemId + 402, ArmourDesign.PLATE, EnumArmourMF.IRON, 0, 0, "ironPlate_1").func_77655_b("ironPlateHelmet");
/*  492 */   public static final Item plateIronPlate = new ItemArmourMF(itemId + 403, ArmourDesign.PLATE, EnumArmourMF.IRON, 0, 1, "ironPlate_1").func_77655_b("ironPlateChest");
/*  493 */   public static final Item legsIronPlate = new ItemArmourMF(itemId + 404, ArmourDesign.PLATE, EnumArmourMF.IRON, 0, 2, "ironPlate_2").func_77655_b("ironPlateLegs");
/*  494 */   public static final Item bootsIronPlate = new ItemArmourMF(itemId + 405, ArmourDesign.PLATE, EnumArmourMF.IRON, 0, 3, "ironPlate_1").func_77655_b("ironPlateBoots");
/*  495 */   public static final Item helmetMithrilPlate = new ItemArmourMF(itemId + 406, ArmourDesign.PLATE, EnumArmourMF.MITHRIL, 0, 0, "mithrilPlate_1").func_77655_b("mithrilPlateHelmet");
/*  496 */   public static final Item plateMithrilPlate = new ItemArmourMF(itemId + 407, ArmourDesign.PLATE, EnumArmourMF.MITHRIL, 0, 1, "mithrilPlate_1").func_77655_b("mithrilPlateChest");
/*  497 */   public static final Item legsMithrilPlate = new ItemArmourMF(itemId + 408, ArmourDesign.PLATE, EnumArmourMF.MITHRIL, 0, 2, "mithrilPlate_2").func_77655_b("mithrilPlateLegs");
/*  498 */   public static final Item bootsMithrilPlate = new ItemArmourMF(itemId + 409, ArmourDesign.PLATE, EnumArmourMF.MITHRIL, 0, 3, "mithrilPlate_1").func_77655_b("mithrilPlateBoots");
/*      */   
/*  500 */   public static final Item hound_Mplate = new ItemHoundArmourMF(itemId + 410, EnumArmourMF.MITHRIL, true, "mithril", 1, 70).func_77655_b("hound_Mplate");
/*  501 */   public static final Item hound_MplateH = new ItemHoundArmourMF(itemId + 411, EnumArmourMF.MITHRIL, true, "mithril", 0, 70).func_77655_b("hound_MplateH");
/*  502 */   public static final Item hound_DMail = new ItemHoundArmourMF(itemId + 412, EnumArmourMF.DRAGONFORGE, false, "dragonforge", 1, 30).func_77655_b("hound_DMail");
/*  503 */   public static final Item hound_DMailH = new ItemHoundArmourMF(itemId + 413, EnumArmourMF.DRAGONFORGE, false, "dragonforge", 0, 30).func_77655_b("hound_DMailH");
/*      */   
/*  505 */   public static final Item needleBone = new ItemNeedle(itemId + 414, EnumToolMaterial.STONE).func_77655_b("needleBone");
/*  506 */   public static final Item needleBronze = new ItemNeedle(itemId + 415, ToolMaterialMedieval.BRONZE).func_77655_b("needleBronze");
/*  507 */   public static final Item needleIron = new ItemNeedle(itemId + 416, ToolMaterialMedieval.IRON).func_77655_b("needleIron");
/*  508 */   public static final Item needleSteel = new ItemNeedle(itemId + 417, ToolMaterialMedieval.STEEL).func_77655_b("needleSteel");
/*  509 */   public static final Item needleMithril = new ItemNeedle(itemId + 418, ToolMaterialMedieval.MITHRIL).func_77655_b("needleMithril");
/*      */   
/*  511 */   public static final Item shortbow = new ItemBowMF(itemId + 419, ToolMaterialMedieval.STRONGWOOD, EnumBowType.COMPOSITE).func_77655_b("shortbow");
/*  512 */   public static final Item bowBronze = new ItemBowMF(itemId + 420, ToolMaterialMedieval.BRONZE, EnumBowType.RECURVE).func_77655_b("bowBronze");
/*  513 */   public static final Item bowIron = new ItemBowMF(itemId + 421, ToolMaterialMedieval.IRON, EnumBowType.RECURVE).func_77655_b("bowIron");
/*  514 */   public static final Item bowSteel = new ItemBowMF(itemId + 422, ToolMaterialMedieval.STEEL, EnumBowType.RECURVE).func_77655_b("bowSteel");
/*  515 */   public static final Item bowMithril = new ItemBowMF(itemId + 423, ToolMaterialMedieval.MITHRIL, EnumBowType.RECURVE).func_77655_b("bowMithril");
/*      */   
/*  517 */   public static final Item tongsTin = new ItemTongs(itemId + 424, ToolMaterialMedieval.TIN).func_77655_b("tongsTin");
/*  518 */   public static final Item tongsCopper = new ItemTongs(itemId + 425, ToolMaterialMedieval.COPPER).func_77655_b("tongsCopper");
/*      */   
/*  520 */   public static final Item lanceBronze = new ItemLance(itemId + 426, ToolMaterialMedieval.BRONZE).func_77655_b("lanceBronze");
/*  521 */   public static final Item lanceIron = new ItemLance(itemId + 427, ToolMaterialMedieval.IRON).func_77655_b("lanceIron");
/*  522 */   public static final Item lanceSteel = new ItemLance(itemId + 428, ToolMaterialMedieval.STEEL).func_77655_b("lanceSteel");
/*  523 */   public static final Item lanceEncrusted = new ItemLance(itemId + 429, ToolMaterialMedieval.ENCRUSTED).func_77655_b("lanceEncrusted");
/*  524 */   public static final Item lanceMithril = new ItemLance(itemId + 450, ToolMaterialMedieval.MITHRIL).func_77655_b("lanceMithril");
/*  525 */   public static final Item lanceDragon = new ItemLance(itemId + 451, ToolMaterialMedieval.DRAGONFORGE).func_77655_b("lanceDragonforge");
/*  526 */   public static final Item lanceOrnate = new ItemLance(itemId + 452, ToolMaterialMedieval.ORNATE).func_77655_b("lanceOrnate");
/*      */   
/*  528 */   public static final Item helmetGuildedPlate = new ItemArmourMF(itemId + 453, ArmourDesign.PLATE, EnumArmourMF.GUILDED, 1, 0, "guildedPlate_1").func_77655_b("guildedPlateHelmet");
/*  529 */   public static final Item plateGuildedPlate = new ItemArmourMF(itemId + 454, ArmourDesign.PLATE, EnumArmourMF.GUILDED, 1, 1, "guildedPlate_1").func_77655_b("guildedPlateChest");
/*  530 */   public static final Item legsGuildedPlate = new ItemArmourMF(itemId + 455, ArmourDesign.PLATE, EnumArmourMF.GUILDED, 2, 2, "guildedPlate_2").func_77655_b("guildedPlateLegs");
/*  531 */   public static final Item bootsGuildedPlate = new ItemArmourMF(itemId + 456, ArmourDesign.PLATE, EnumArmourMF.GUILDED, 2, 3, "guildedPlate_1").func_77655_b("guildedPlateBoots");
/*      */   
/*  533 */   public static final Item helmetGuildedChain = new ItemArmourMF(itemId + 457, ArmourDesign.CHAIN, EnumArmourMF.GUILDED, 1, 0, "guildedChain_1").func_77655_b("guildedChainHelmet");
/*  534 */   public static final Item plateGuildedChain = new ItemArmourMF(itemId + 458, ArmourDesign.CHAIN, EnumArmourMF.GUILDED, 1, 1, "guildedChain_1").func_77655_b("guildedChainChest");
/*  535 */   public static final Item legsGuildedChain = new ItemArmourMF(itemId + 459, ArmourDesign.CHAIN, EnumArmourMF.GUILDED, 2, 2, "guildedChain_2").func_77655_b("guildedChainLegs");
/*  536 */   public static final Item bootsGuildedChain = new ItemArmourMF(itemId + 460, ArmourDesign.CHAIN, EnumArmourMF.GUILDED, 2, 3, "guildedChain_1").func_77655_b("guildedChainBoots");
/*      */   
/*  538 */   public static final Item helmetGuildedSplint = new ItemArmourMF(itemId + 461, ArmourDesign.SPLINT, EnumArmourMF.GUILDED, 1, 0, "guildedSplint_1").func_77655_b("guildedSplintHelmet");
/*  539 */   public static final Item plateGuildedSplint = new ItemArmourMF(itemId + 462, ArmourDesign.SPLINT, EnumArmourMF.GUILDED, 1, 1, "guildedSplint_1").func_77655_b("guildedSplintChest");
/*  540 */   public static final Item legsGuildedSplint = new ItemArmourMF(itemId + 463, ArmourDesign.SPLINT, EnumArmourMF.GUILDED, 2, 2, "guildedSplint_2").func_77655_b("guildedSplintLegs");
/*  541 */   public static final Item bootsGuildedSplint = new ItemArmourMF(itemId + 464, ArmourDesign.SPLINT, EnumArmourMF.GUILDED, 2, 3, "guildedSplint_1").func_77655_b("guildedSplintBoots");
/*      */   
/*  543 */   public static final Item helmetGuildedHvyChain = new ItemArmourMF(itemId + 465, ArmourDesign.HVYCHAIN, EnumArmourMF.GUILDED, 1, 0, "guildedHvyChain_1").func_77655_b("guildedHvyHelmet");
/*  544 */   public static final Item plateGuildedHvyChain = new ItemArmourMF(itemId + 466, ArmourDesign.HVYCHAIN, EnumArmourMF.GUILDED, 1, 1, "guildedHvyChain_1").func_77655_b("guildedHvyChest");
/*  545 */   public static final Item legsGuildedHvyChain = new ItemArmourMF(itemId + 467, ArmourDesign.HVYCHAIN, EnumArmourMF.GUILDED, 2, 2, "guildedHvyChain_2").func_77655_b("guildedHvyLegs");
/*  546 */   public static final Item bootsGuildedHvyChain = new ItemArmourMF(itemId + 468, ArmourDesign.HVYCHAIN, EnumArmourMF.GUILDED, 2, 3, "guildedHvyChain_1").func_77655_b("guildedHvyBoots");
/*      */   
/*  548 */   public static final Item helmetGuildedScale = new ItemArmourMF(itemId + 469, ArmourDesign.SCALE, EnumArmourMF.GUILDED, 1, 0, "guildedScale_1").func_77655_b("guildedScaleHelmet");
/*  549 */   public static final Item plateGuildedScale = new ItemArmourMF(itemId + 470, ArmourDesign.SCALE, EnumArmourMF.GUILDED, 1, 1, "guildedScale_1").func_77655_b("guildedScaleChest");
/*  550 */   public static final Item legsGuildedScale = new ItemArmourMF(itemId + 471, ArmourDesign.SCALE, EnumArmourMF.GUILDED, 2, 2, "guildedScale_2").func_77655_b("guildedScaleLegs");
/*  551 */   public static final Item bootsGuildedScale = new ItemArmourMF(itemId + 472, ArmourDesign.SCALE, EnumArmourMF.GUILDED, 2, 3, "guildedScale_1").func_77655_b("guildedScaleBoots");
/*      */   
/*  553 */   public static final Item handpickBronze = new ItemHandpick(itemId + 473, ToolMaterialMedieval.BRONZE).func_77655_b("handpickBronze");
/*  554 */   public static final Item handpickIron = new ItemHandpick(itemId + 474, ToolMaterialMedieval.IRON).func_77655_b("handpickIron");
/*  555 */   public static final Item handpickSteel = new ItemHandpick(itemId + 475, ToolMaterialMedieval.STEEL).func_77655_b("handpickSteel");
/*  556 */   public static final Item handpickEncrusted = new ItemHandpick(itemId + 476, ToolMaterialMedieval.ENCRUSTED).func_77655_b("handpickEncrusted");
/*  557 */   public static final Item handpickMithril = new ItemHandpick(itemId + 477, ToolMaterialMedieval.MITHRIL).func_77655_b("handpickMithril");
/*  558 */   public static final Item handpickDragonforge = new ItemHandpick(itemId + 478, ToolMaterialMedieval.DRAGONFORGE).func_77655_b("handpickDragonforge");
/*  559 */   public static final Item handpickIgnotumite = new ItemHandpick(itemId + 479, ToolMaterialMedieval.IGNOTUMITE).func_77655_b("handpickIgnotumite");
/*      */   
/*  561 */   public static final Item helmetLeatherRough = new ItemArmourMF(itemId + 480, ArmourDesign.LEATHER, EnumArmourMF.LEATHER, 1, 0, "roughLeather_1").func_77655_b("roughLeatherHelmet");
/*  562 */   public static final Item plateLeatherRough = new ItemArmourMF(itemId + 481, ArmourDesign.LEATHER, EnumArmourMF.LEATHER, 1, 1, "roughLeather_1").func_77655_b("roughLeatherChest");
/*  563 */   public static final Item legsLeatherRough = new ItemArmourMF(itemId + 482, ArmourDesign.LEATHER, EnumArmourMF.LEATHER, 2, 2, "roughLeather_2").func_77655_b("roughLeatherLegs");
/*  564 */   public static final Item bootsLeatherRough = new ItemArmourMF(itemId + 483, ArmourDesign.LEATHER, EnumArmourMF.LEATHER, 2, 3, "roughLeather_1").func_77655_b("roughLeatherBoots");
/*      */   
/*  566 */   public static final Item waraxeCopper = new ItemWaraxe(itemId + 484, ToolMaterialMedieval.COPPER).func_77655_b("waraxeCopper");
/*  567 */   public static final Item waraxeTin = new ItemWaraxe(itemId + 485, ToolMaterialMedieval.TIN).func_77655_b("waraxeTin");
/*  568 */   public static final Item swordCopper = new ItemSwordMF(itemId + 486, ToolMaterialMedieval.COPPER).func_77655_b("swordCopper");
/*  569 */   public static final Item maceTin = new ItemMaceMF(itemId + 487, ToolMaterialMedieval.TIN).func_77655_b("maceTin");
/*      */   
/*  571 */   public static final Item daggerIgnotumite = new ItemDagger(itemId + 488, ToolMaterialMedieval.IGNOTUMITE).func_77655_b("daggerIgnotumite");
/*  572 */   public static final Item waraxeIgnotumite = new ItemWaraxe(itemId + 489, ToolMaterialMedieval.IGNOTUMITE).func_77655_b("waraxeIgnotumite");
/*  573 */   public static final Item maceIgnotumite = new ItemMaceMF(itemId + 490, ToolMaterialMedieval.IGNOTUMITE).func_77655_b("maceIgnotumite");
/*  574 */   public static final Item broadIgnotumite = new ItemBroadsword(itemId + 491, ToolMaterialMedieval.IGNOTUMITE).func_77655_b("broadswordIgnotumite");
/*  575 */   public static final Item warpickIgnotumite = new ItemWarpick(itemId + 492, ToolMaterialMedieval.IGNOTUMITE).func_77655_b("warpickIgnotumite");
/*  576 */   public static final Item greatswordIgnotumite = new ItemGreatsword(itemId + 493, ToolMaterialMedieval.IGNOTUMITE).func_77655_b("greatswordIgnotumite");
/*  577 */   public static final Item morningstarIgnotumite = new ItemGreatmace(itemId + 494, ToolMaterialMedieval.IGNOTUMITE).func_77655_b("greatmaceIgnotumite");
/*  578 */   public static final Item battleaxeIgnotumite = new ItemBattleaxe(itemId + 495, ToolMaterialMedieval.IGNOTUMITE).func_77655_b("battleaxeIgnotumite");
/*  579 */   public static final Item warhammerIgnotumite = new ItemWarhammer(itemId + 496, ToolMaterialMedieval.IGNOTUMITE).func_77655_b("warhammerIgnotumite");
/*  580 */   public static final Item spearIgnotumite = new ItemSpearMF(itemId + 497, ToolMaterialMedieval.IGNOTUMITE).func_77655_b("spearIgnotumite");
/*  581 */   public static final Item halbeardIgnotumite = new ItemHalbeard(itemId + 498, ToolMaterialMedieval.IGNOTUMITE).func_77655_b("halbeardIgnotumite");
/*  582 */   public static final Item lanceIgnotumite = new ItemWarpick(itemId + 499, ToolMaterialMedieval.IGNOTUMITE).func_77655_b("lanceIgnotumite");
/*  583 */   public static final Item warpickOrnate = new ItemWarpick(itemId + 500, ToolMaterialMedieval.ORNATE).func_77655_b("warpickOrnate");
/*      */   
/*  585 */   public static final Item hound_GMail = new ItemHoundArmourMF(itemId + 501, EnumArmourMF.GUILDED, false, "guilded", 1, 20).func_77655_b("hound_GMail");
/*  586 */   public static final Item hound_GMailH = new ItemHoundArmourMF(itemId + 502, EnumArmourMF.GUILDED, false, "guilded", 0, 20).func_77655_b("hound_GMailH");
/*      */   
/*  588 */   public static final Item hound_Gplate = new ItemHoundArmourMF(itemId + 503, EnumArmourMF.GUILDED, true, "guilded", 1, 50).func_77655_b("hound_Gplate");
/*  589 */   public static final Item hound_GplateH = new ItemHoundArmourMF(itemId + 504, EnumArmourMF.GUILDED, true, "guilded", 0, 50).func_77655_b("hound_GplateH");
/*      */   
/*  591 */   public static final Item muttonRaw = new ItemFoodMF(itemId + 505, 3, 0.3F, true).func_77655_b("muttonRaw");
/*  592 */   public static final Item muttonCooked = new ItemFoodMF(itemId + 506, 8, 0.8F, true).func_77655_b("muttonCooked");
/*      */   
/*  594 */   public static final Item kiteBronze = new ItemShield(itemId + 507, ToolMaterialMedieval.BRONZE, EnumShieldDesign.KITE);
/*  595 */   public static final Item kiteIron = new ItemShield(itemId + 508, ToolMaterialMedieval.IRON, EnumShieldDesign.KITE);
/*  596 */   public static final Item kiteSteel = new ItemShield(itemId + 509, ToolMaterialMedieval.STEEL, EnumShieldDesign.KITE);
/*  597 */   public static final Item kiteMithril = new ItemShield(itemId + 510, ToolMaterialMedieval.MITHRIL, EnumShieldDesign.KITE);
/*  598 */   public static final Item kiteGuilded = new ItemShield(itemId + 511, ToolMaterialMedieval.ORNATE, EnumShieldDesign.KITE, "guilded");
/*  599 */   public static final Item kiteEncrusted = new ItemShield(itemId + 512, ToolMaterialMedieval.ENCRUSTED, EnumShieldDesign.KITE);
/*  600 */   public static final Item kiteDragonforge = new ItemShield(itemId + 513, ToolMaterialMedieval.DRAGONFORGE, EnumShieldDesign.KITE);
/*      */   
/*  602 */   public static final Item towerBronze = new ItemShield(itemId + 514, ToolMaterialMedieval.BRONZE, EnumShieldDesign.TOWER);
/*  603 */   public static final Item towerIron = new ItemShield(itemId + 515, ToolMaterialMedieval.IRON, EnumShieldDesign.TOWER);
/*  604 */   public static final Item towerSteel = new ItemShield(itemId + 516, ToolMaterialMedieval.STEEL, EnumShieldDesign.TOWER);
/*  605 */   public static final Item towerMithril = new ItemShield(itemId + 517, ToolMaterialMedieval.MITHRIL, EnumShieldDesign.TOWER);
/*  606 */   public static final Item towerGuilded = new ItemShield(itemId + 518, ToolMaterialMedieval.ORNATE, EnumShieldDesign.TOWER, "guilded");
/*  607 */   public static final Item towerEncrusted = new ItemShield(itemId + 519, ToolMaterialMedieval.ENCRUSTED, EnumShieldDesign.TOWER);
/*  608 */   public static final Item towerDragonforge = new ItemShield(itemId + 520, ToolMaterialMedieval.DRAGONFORGE, EnumShieldDesign.TOWER);
/*      */   
/*  610 */   public static final Item bucklerBronze = new ItemShield(itemId + 521, ToolMaterialMedieval.BRONZE, EnumShieldDesign.BUCKLER);
/*  611 */   public static final Item bucklerIron = new ItemShield(itemId + 522, ToolMaterialMedieval.IRON, EnumShieldDesign.BUCKLER);
/*  612 */   public static final Item bucklerSteel = new ItemShield(itemId + 523, ToolMaterialMedieval.STEEL, EnumShieldDesign.BUCKLER);
/*  613 */   public static final Item bucklerMithril = new ItemShield(itemId + 524, ToolMaterialMedieval.MITHRIL, EnumShieldDesign.BUCKLER);
/*  614 */   public static final Item bucklerGuilded = new ItemShield(itemId + 525, ToolMaterialMedieval.ORNATE, EnumShieldDesign.BUCKLER, "guilded");
/*  615 */   public static final Item bucklerEncrusted = new ItemShield(itemId + 526, ToolMaterialMedieval.ENCRUSTED, EnumShieldDesign.BUCKLER);
/*  616 */   public static final Item bucklerDragonforge = new ItemShield(itemId + 527, ToolMaterialMedieval.DRAGONFORGE, EnumShieldDesign.BUCKLER);
/*      */   
/*  618 */   public static final Item shieldWood = new ItemShield(itemId + 528, ToolMaterialMedieval.STRONGWOOD, EnumShieldDesign.ROUND);
/*  619 */   public static final Item shieldIronbark = new ItemShield(itemId + 529, ToolMaterialMedieval.IRONBARK, EnumShieldDesign.ROUND);
/*  620 */   public static final Item shieldEbony = new ItemShield(itemId + 530, ToolMaterialMedieval.EBONY, EnumShieldDesign.ROUND);
/*      */   
/*  622 */   public static final Item bandage = new ItemBandage(itemId + 531);
/*      */   
/*  624 */   public static final Item bowDeepIron = new ItemBowMF(itemId + 532, ToolMaterialMedieval.DEEP_IRON, EnumBowType.RECURVE).func_77655_b("bowDeepIron");
/*      */   
/*  626 */   public static final Item hammerDeepIron = new ItemHammer(itemId + 533, 3.0F, ToolMaterialMedieval.DEEP_IRON).func_77655_b("hammerDeepIron");
/*  627 */   public static final Item tongsDeepIron = new ItemTongs(itemId + 534, ToolMaterialMedieval.DEEP_IRON).func_77655_b("tongsDeepIron");
/*  628 */   public static final Item knifeDeepIron = new ItemKnifeMF(itemId + 535, ToolMaterialMedieval.DEEP_IRON).func_77655_b("knifeDeepIron");
/*  629 */   public static final Item shearsDeepIron = new ItemShearsMF(itemId + 536, ToolMaterialMedieval.DEEP_IRON).func_77655_b("shearsDeepIron");
/*  630 */   public static final Item needleDeepIron = new ItemNeedle(itemId + 537, ToolMaterialMedieval.DEEP_IRON).func_77655_b("needleDeepIron");
/*  631 */   public static final Item pickDeepIron = new ItemMedievalPick(itemId + 53, ToolMaterialMedieval.DEEP_IRON).func_77655_b("pickDeepIron");
/*  632 */   public static final Item handpickDeepIron = new ItemHandpick(itemId + 539, ToolMaterialMedieval.DEEP_IRON).func_77655_b("handpickDeepIron");
/*  633 */   public static final Item axeDeepIron = new ItemMedievalAxe(itemId + 560, ToolMaterialMedieval.DEEP_IRON).func_77655_b("axeDeepIron");
/*  634 */   public static final Item sawDeepIron = new ItemSaw(itemId + 561, ToolMaterialMedieval.DEEP_IRON).func_77655_b("sawDeepIron");
/*  635 */   public static final Item spadeDeepIron = new ItemMedievalSpade(itemId + 562, ToolMaterialMedieval.DEEP_IRON).func_77655_b("spadeDeepIron");
/*  636 */   public static final Item mattockDeepIron = new ItemMattock(itemId + 563, ToolMaterialMedieval.DEEP_IRON).func_77655_b("mattockDeepIron");
/*  637 */   public static final Item hoeDeepIron = new ItemMedievalHoe(itemId + 564, ToolMaterialMedieval.DEEP_IRON).func_77655_b("hoeDeepIron");
/*  638 */   public static final Item scytheDeepIron = new ItemScytheMF(itemId + 565, ToolMaterialMedieval.DEEP_IRON).func_77655_b("scytheDeepIron");
/*  639 */   public static final Item rakeDeepIron = new ItemRakeMF(itemId + 566, ToolMaterialMedieval.DEEP_IRON).func_77655_b("rakeDeepIron");
/*      */   
/*  641 */   public static final Item daggerDeepIron = new ItemDagger(itemId + 567, ToolMaterialMedieval.DEEP_IRON).func_77655_b("daggerDeepIron");
/*  642 */   public static final Item swordDeepIron = new ItemSwordMF(itemId + 568, ToolMaterialMedieval.DEEP_IRON).func_77655_b("swordDeepIron");
/*  643 */   public static final Item broadswordDeepIron = new ItemBroadsword(itemId + 569, ToolMaterialMedieval.DEEP_IRON).func_77655_b("broadswordDeepIron");
/*  644 */   public static final Item greatswordDeepIron = new ItemGreatsword(itemId + 590, ToolMaterialMedieval.DEEP_IRON).func_77655_b("greatswordDeepIron");
/*  645 */   public static final Item maceDeepIron = new ItemMaceMF(itemId + 591, ToolMaterialMedieval.DEEP_IRON).func_77655_b("maceDeepIron");
/*  646 */   public static final Item warpickDeepIron = new ItemWarpick(itemId + 592, ToolMaterialMedieval.DEEP_IRON).func_77655_b("warpickDeepIron");
/*  647 */   public static final Item greatmaceDeepIron = new ItemGreatmace(itemId + 593, ToolMaterialMedieval.DEEP_IRON).func_77655_b("greatmaceDeepIron");
/*  648 */   public static final Item warhammerDeepIron = new ItemWarhammer(itemId + 594, ToolMaterialMedieval.DEEP_IRON).func_77655_b("warhammerDeepIron");
/*  649 */   public static final Item waraxeDeepIron = new ItemWaraxe(itemId + 595, ToolMaterialMedieval.DEEP_IRON).func_77655_b("waraxeDeepIron");
/*  650 */   public static final Item battleaxeDeepIron = new ItemBattleaxe(itemId + 596, ToolMaterialMedieval.DEEP_IRON).func_77655_b("battleaxeDeepIron");
/*  651 */   public static final Item spearDeepIron = new ItemSpearMF(itemId + 597, ToolMaterialMedieval.DEEP_IRON).func_77655_b("spearDeepIron");
/*  652 */   public static final Item halbeardDeepIron = new ItemHalbeard(itemId + 598, ToolMaterialMedieval.DEEP_IRON).func_77655_b("halbeardDeepIron");
/*  653 */   public static final Item lanceDeepIron = new ItemLance(itemId + 599, ToolMaterialMedieval.DEEP_IRON).func_77655_b("lanceDeepIron");
/*      */   
/*  655 */   public static final Item bucklerDeepIron = new ItemShield(itemId + 600, ToolMaterialMedieval.DEEP_IRON, EnumShieldDesign.BUCKLER);
/*  656 */   public static final Item kiteDeepIron = new ItemShield(itemId + 601, ToolMaterialMedieval.DEEP_IRON, EnumShieldDesign.KITE);
/*  657 */   public static final Item towerDeepIron = new ItemShield(itemId + 602, ToolMaterialMedieval.DEEP_IRON, EnumShieldDesign.TOWER);
/*      */   
/*  659 */   public static final Item hound_DImail = new ItemHoundArmourMF(itemId + 603, EnumArmourMF.DEEP_IRON, false, "deepIron", 1, 60).func_77655_b("hound_DImail");
/*  660 */   public static final Item hound_DImailH = new ItemHoundArmourMF(itemId + 604, EnumArmourMF.DEEP_IRON, false, "deepIron", 0, 60).func_77655_b("hound_DImailH");
/*  661 */   public static final Item hound_DIplate = new ItemHoundArmourMF(itemId + 605, EnumArmourMF.DEEP_IRON, true, "deepIron", 1, 60).func_77655_b("hound_DIplate");
/*  662 */   public static final Item hound_DIplateH = new ItemHoundArmourMF(itemId + 606, EnumArmourMF.DEEP_IRON, true, "deepIron", 0, 60).func_77655_b("hound_DIplateH");
/*  663 */   public static final Item hound_DIteeth = new ItemHoundWeaponMF(itemId + 607, ToolMaterialMedieval.DEEP_IRON, "deepIron", 10, 1).func_77655_b("hound_DIteeth");
/*      */   
/*  665 */   public static final Item helmetDeepIronPlate = new ItemArmourMF(itemId + 608, ArmourDesign.PLATE, EnumArmourMF.DEEP_IRON, 1, 0, "deepIronPlate_1").func_77655_b("deepIronPlateHelmet");
/*  666 */   public static final Item plateDeepIronPlate = new ItemArmourMF(itemId + 609, ArmourDesign.PLATE, EnumArmourMF.DEEP_IRON, 1, 1, "deepIronPlate_1").func_77655_b("deepIronPlateChest");
/*  667 */   public static final Item legsDeepIronPlate = new ItemArmourMF(itemId + 610, ArmourDesign.PLATE, EnumArmourMF.DEEP_IRON, 2, 2, "deepIronPlate_2").func_77655_b("deepIronPlateLegs");
/*  668 */   public static final Item bootsDeepIronPlate = new ItemArmourMF(itemId + 611, ArmourDesign.PLATE, EnumArmourMF.DEEP_IRON, 2, 3, "deepIronPlate_1").func_77655_b("deepIronPlateBoots");
/*      */   
/*  670 */   public static final Item helmetDeepIronChain = new ItemArmourMF(itemId + 612, ArmourDesign.CHAIN, EnumArmourMF.DEEP_IRON, 1, 0, "deepIronChain_1").func_77655_b("deepIronChainHelmet");
/*  671 */   public static final Item plateDeepIronChain = new ItemArmourMF(itemId + 613, ArmourDesign.CHAIN, EnumArmourMF.DEEP_IRON, 1, 1, "deepIronChain_1").func_77655_b("deepIronChainChest");
/*  672 */   public static final Item legsDeepIronChain = new ItemArmourMF(itemId + 614, ArmourDesign.CHAIN, EnumArmourMF.DEEP_IRON, 2, 2, "deepIronChain_2").func_77655_b("deepIronChainLegs");
/*  673 */   public static final Item bootsDeepIronChain = new ItemArmourMF(itemId + 615, ArmourDesign.CHAIN, EnumArmourMF.DEEP_IRON, 2, 3, "deepIronChain_1").func_77655_b("deepIronChainBoots");
/*      */   
/*  675 */   public static final Item helmetDeepIronSplint = new ItemArmourMF(itemId + 616, ArmourDesign.SPLINT, EnumArmourMF.DEEP_IRON, 1, 0, "deepIronSplint_1").func_77655_b("deepIronSplintHelmet");
/*  676 */   public static final Item plateDeepIronSplint = new ItemArmourMF(itemId + 617, ArmourDesign.SPLINT, EnumArmourMF.DEEP_IRON, 1, 1, "deepIronSplint_1").func_77655_b("deepIronSplintChest");
/*  677 */   public static final Item legsDeepIronSplint = new ItemArmourMF(itemId + 618, ArmourDesign.SPLINT, EnumArmourMF.DEEP_IRON, 2, 2, "deepIronSplint_2").func_77655_b("deepIronSplintLegs");
/*  678 */   public static final Item bootsDeepIronSplint = new ItemArmourMF(itemId + 619, ArmourDesign.SPLINT, EnumArmourMF.DEEP_IRON, 2, 3, "deepIronSplint_1").func_77655_b("deepIronSplintBoots");
/*      */   
/*  680 */   public static final Item helmetDeepIronHvyChain = new ItemArmourMF(itemId + 620, ArmourDesign.HVYCHAIN, EnumArmourMF.DEEP_IRON, 1, 0, "deepIronHvyChain_1").func_77655_b("deepIronHvyHelmet");
/*  681 */   public static final Item plateDeepIronHvyChain = new ItemArmourMF(itemId + 621, ArmourDesign.HVYCHAIN, EnumArmourMF.DEEP_IRON, 1, 1, "deepIronHvyChain_1").func_77655_b("deepIronHvyChest");
/*  682 */   public static final Item legsDeepIronHvyChain = new ItemArmourMF(itemId + 622, ArmourDesign.HVYCHAIN, EnumArmourMF.DEEP_IRON, 2, 2, "deepIronHvyChain_2").func_77655_b("deepIronHvyLegs");
/*  683 */   public static final Item bootsDeepIronHvyChain = new ItemArmourMF(itemId + 623, ArmourDesign.HVYCHAIN, EnumArmourMF.DEEP_IRON, 2, 3, "deepIronHvyChain_1").func_77655_b("deepIronHvyBoots");
/*      */   
/*  685 */   public static final Item helmetDeepIronScale = new ItemArmourMF(itemId + 624, ArmourDesign.SCALE, EnumArmourMF.DEEP_IRON, 1, 0, "deepIronScale_1").func_77655_b("deepIronScaleHelmet");
/*  686 */   public static final Item plateDeepIronScale = new ItemArmourMF(itemId + 625, ArmourDesign.SCALE, EnumArmourMF.DEEP_IRON, 1, 1, "deepIronScale_1").func_77655_b("deepIronScaleChest");
/*  687 */   public static final Item legsDeepIronScale = new ItemArmourMF(itemId + 626, ArmourDesign.SCALE, EnumArmourMF.DEEP_IRON, 2, 2, "deepIronScale_2").func_77655_b("deepIronScaleLegs");
/*  688 */   public static final Item bootsDeepIronScale = new ItemArmourMF(itemId + 627, ArmourDesign.SCALE, EnumArmourMF.DEEP_IRON, 2, 3, "deepIronScale_1").func_77655_b("deepIronScaleBoots");
/*      */   public static final int flux = 0;
/*      */   public static final int splintBronze = 1; public static final int lumpIron = 2; public static final int hidePig = 3; public static final int leatherRaw = 4; public static final int leatherSalt = 5; public static final int hideSheep = 6; public static final int leatherRough = 7; public static final int leatherGore = 8; public static final int padding = 9; public static final int salt = 10; public static final int slag = 11; public static final int slagSmall = 12; public static final int linkIron = 13; public static final int coke = 14; public static final int coalPowder = 15; public static final int saltPaper = 16; public static final int rawHide = 17; public static final int linkBronze = 18; public static final int fireGland = 19; public static final int fireExplosive = 20; public static final int ingotDragonImpure = 21; public static final int ingotDragon = 22; public static final int featherArrow = 23; public static final int sulfur = 24; public static final int plankIronbark = 25; public static final int leatherStrip = 26; public static final int leatherBelt = 27; public static final int smlPlateSteel = 28; public static final int curvedPlateSteel = 29; public static final int splintSteel = 30; public static final int scaleSteel = 31; public static final int hideHound = 33; public static final int scaleBronze = 36; public static final int scaleIron = 37;
/*  691 */   public static void registerItems() { GameRegistry.registerItem(hammerIron, "hammerIron");
/*  692 */     GameRegistry.registerItem(ingotSteel, "ingotSteel");
/*  693 */     GameRegistry.registerItem(tongsBronze, "tongsBronze");
/*  694 */     GameRegistry.registerItem(apronSmithy, "apronSmithy");
/*  695 */     GameRegistry.registerItem(plank, "plank");
/*  696 */     GameRegistry.registerItem(pickIronForged, "pickIronForged");
/*  697 */     GameRegistry.registerItem(pickSteelForged, "pickSteelForged");
/*  698 */     GameRegistry.registerItem(pickIgnotumiteForged, "pickIgnotumiteForged");
/*  699 */     GameRegistry.registerItem(knifeStone, "knifeStone");
/*  700 */     GameRegistry.registerItem(mattockMithril, "mattockMithril");
/*  701 */     GameRegistry.registerItem(swordIronForged, "swordIron");
/*  702 */     GameRegistry.registerItem(swordSteelForged, "swordSteel");
/*  703 */     GameRegistry.registerItem(swordIgnotumite, "swordIgnotumite");
/*  704 */     GameRegistry.registerItem(swordDragon, "swordDragonforge");
/*  705 */     GameRegistry.registerItem(knifeMithril, "knifeMithril");
/*  706 */     GameRegistry.registerItem(swordOrnate, "swordOrnate");
/*  707 */     GameRegistry.registerItem(axeIronForged, "axeIronForged");
/*  708 */     GameRegistry.registerItem(axeSteelForged, "axeSteelForged");
/*  709 */     GameRegistry.registerItem(axeIgnotumiteForged, "axeIgnotumiteForged");
/*  710 */     GameRegistry.registerItem(swordTin, "swordTin");
/*  711 */     GameRegistry.registerItem(sawMithril, "sawMithril");
/*  712 */     GameRegistry.registerItem(spadeIronForged, "spadeIronForged");
/*  713 */     GameRegistry.registerItem(spadeSteelForged, "spadeSteel");
/*  714 */     GameRegistry.registerItem(spadeIgnotumiteForged, "spadeIgnotumite");
/*  715 */     GameRegistry.registerItem(knifeSteel, "knifeSteel");
/*  716 */     GameRegistry.registerItem(shearsMithril, "shearsMithril");
/*  717 */     GameRegistry.registerItem(hoeIronForged, "hoeIronForged");
/*  718 */     GameRegistry.registerItem(hoeSteelForged, "hoeSteelForged");
/*  719 */     GameRegistry.registerItem(rakeBronze, "rakeBronze");
/*  720 */     GameRegistry.registerItem(rakeIron, "rakeIron");
/*  721 */     GameRegistry.registerItem(rakeMithril, "rakeMithril");
/*      */     
/*  723 */     GameRegistry.registerItem(helmetBronzeScale, "bronzeScaleHelmet");
/*  724 */     GameRegistry.registerItem(plateBronzeScale, "bronzeScaleChest");
/*  725 */     GameRegistry.registerItem(legsBronzeScale, "bronzeScaleLegs");
/*  726 */     GameRegistry.registerItem(bootsBronzeScale, "bronzeScaleBoots");
/*      */     
/*  728 */     GameRegistry.registerItem(helmetSteelPlate, "steelPlateHelmet");
/*  729 */     GameRegistry.registerItem(plateSteelPlate, "steelPlateChest");
/*  730 */     GameRegistry.registerItem(legsSteelPlate, "steelPlateLegs");
/*  731 */     GameRegistry.registerItem(bootsSteelPlate, "steelPlateBoots");
/*      */     
/*  733 */     GameRegistry.registerItem(knifeCopper, "knifeCopper");
/*  734 */     GameRegistry.registerItem(hammerCopper, "hammerCopper");
/*  735 */     GameRegistry.registerItem(ingotSilver, "ingotSilver");
/*  736 */     GameRegistry.registerItem(tinderbox, "tinderbox");
/*  737 */     GameRegistry.registerItem(bombMF, "bombIron");
/*  738 */     GameRegistry.registerItem(malletWood, "malletWood");
/*  739 */     GameRegistry.registerItem(malletIronbark, "malletIronbark");
/*  740 */     GameRegistry.registerItem(explosive, "explosive");
/*  741 */     GameRegistry.registerItem(misc, "dust");
/*  742 */     GameRegistry.registerItem(hotItem, "hotItem");
/*  743 */     GameRegistry.registerItem(broadIron, "broadswordIron");
/*  744 */     GameRegistry.registerItem(morningstarIron, "greatmaceIron");
/*  745 */     GameRegistry.registerItem(warpickIron, "warpickIron");
/*  746 */     GameRegistry.registerItem(broadSteel, "broadswordSteel");
/*  747 */     GameRegistry.registerItem(morningstarSteel, "greatmaceSteel");
/*  748 */     GameRegistry.registerItem(warpickSteel, "warpickSteel");
/*  749 */     GameRegistry.registerItem(broadOrnate, "broadswordOrnate");
/*  750 */     GameRegistry.registerItem(broadDragon, "broadswordDragonforge");
/*  751 */     GameRegistry.registerItem(rakeSteel, "rakeSteel");
/*  752 */     GameRegistry.registerItem(morningstarDragon, "greatmaceDragon");
/*  753 */     GameRegistry.registerItem(waraxeSteel, "waraxeSteel");
/*  754 */     GameRegistry.registerItem(warpickDragon, "warpickDragon");
/*  755 */     GameRegistry.registerItem(waraxeEncrusted, "waraxeEncrusted");
/*  756 */     GameRegistry.registerItem(greatmaceOrnate, "greatmaceOrnate");
/*  757 */     GameRegistry.registerItem(waraxeDragon, "waraxeDragon");
/*  758 */     GameRegistry.registerItem(maceEncrusted, "maceEncrusted");
/*  759 */     GameRegistry.registerItem(knifeBronze, "knifeBronze");
/*  760 */     GameRegistry.registerItem(knifeIron, "knifeIron");
/*  761 */     GameRegistry.registerItem(hammerOrnate, "hammerPower");
/*  762 */     GameRegistry.registerItem(axePrim, "axePrim");
/*      */     
/*  764 */     GameRegistry.registerItem(helmetDragonPlate, "dragonforgePlateHelmet");
/*  765 */     GameRegistry.registerItem(plateDragonPlate, "dragonforgePlateChest");
/*  766 */     GameRegistry.registerItem(legsDragonPlate, "dragonforgePlateLegs");
/*  767 */     GameRegistry.registerItem(bootsDragonPlate, "dragonforgePlateBoots");
/*      */     
/*  769 */     GameRegistry.registerItem(greatmaceEncrusted, "greatmaceEncrusted");
/*  770 */     GameRegistry.registerItem(tongsIron, "tongsIron");
/*  771 */     GameRegistry.registerItem(arrowMF, "arrowMF");
/*  772 */     GameRegistry.registerItem(tongsSteel, "tongsSteel");
/*  773 */     GameRegistry.registerItem(tongsMithril, "tongsMithril");
/*      */     
/*  775 */     GameRegistry.registerItem(pickTin, "pickTin");
/*  776 */     GameRegistry.registerItem(spadeTin, "spadeTin");
/*  777 */     GameRegistry.registerItem(hoeTin, "hoeTin");
/*  778 */     GameRegistry.registerItem(knifeTin, "knifeTin");
/*  779 */     GameRegistry.registerItem(axeTin, "axeTin");
/*      */     
/*  781 */     GameRegistry.registerItem(hammerBronze, "hammerBronze");
/*  782 */     GameRegistry.registerItem(pickBronze, "pickBronze");
/*  783 */     GameRegistry.registerItem(spadeBronze, "spadeBronze");
/*  784 */     GameRegistry.registerItem(hoeBronze, "hoeBronze");
/*  785 */     GameRegistry.registerItem(swordBronze, "swordBronze");
/*  786 */     GameRegistry.registerItem(axeBronze, "axeBronze");
/*  787 */     GameRegistry.registerItem(broadBronze, "broadswordBronze");
/*  788 */     GameRegistry.registerItem(morningstarBronze, "greatmaceBronze");
/*  789 */     GameRegistry.registerItem(warpickBronze, "warpickBronze");
/*      */     
/*  791 */     GameRegistry.registerItem(hammerSteel, "hammerSteel");
/*      */     
/*  793 */     GameRegistry.registerItem(pickMithril, "pickMithril");
/*  794 */     GameRegistry.registerItem(spadeMithril, "spadeMithril");
/*  795 */     GameRegistry.registerItem(hoeMithril, "hoeMithril");
/*  796 */     GameRegistry.registerItem(swordMithril, "swordMithril");
/*  797 */     GameRegistry.registerItem(axeMithril, "axeMithril");
/*  798 */     GameRegistry.registerItem(broadMithril, "broadswordMithril");
/*  799 */     GameRegistry.registerItem(morningstarMithril, "greatmaceMithril");
/*  800 */     GameRegistry.registerItem(warpickMithril, "warpickMithril");
/*      */     
/*  802 */     GameRegistry.registerItem(bowComposite, "bowComposite");
/*  803 */     GameRegistry.registerItem(bowIronbark, "bowIronbark");
/*  804 */     GameRegistry.registerItem(longbow, "longbow");
/*  805 */     GameRegistry.registerItem(warhammerEncrusted, "warhammerEncrusted");
/*      */     
/*  807 */     GameRegistry.registerItem(pickEncrusted, "pickEncrusted");
/*  808 */     GameRegistry.registerItem(spadeEncrusted, "spadeEncrusted");
/*  809 */     GameRegistry.registerItem(mattockBronze, "mattockBronze");
/*  810 */     GameRegistry.registerItem(swordEncrusted, "swordEncrusted");
/*  811 */     GameRegistry.registerItem(axeEncrusted, "axeEncrusted");
/*  812 */     GameRegistry.registerItem(broadEncrusted, "broadswordEncrusted");
/*  813 */     GameRegistry.registerItem(mattockIron, "mattockIron");
/*  814 */     GameRegistry.registerItem(warpickEncrusted, "warpickEncrusted");
/*      */     
/*  816 */     GameRegistry.registerItem(helmetBronzeChain, "bronzeChainHelmet");
/*  817 */     GameRegistry.registerItem(plateBronzeChain, "bronzeChainChest");
/*  818 */     GameRegistry.registerItem(legsBronzeChain, "bronzeChainLegs");
/*  819 */     GameRegistry.registerItem(bootsBronzeChain, "bronzeChainBoots");
/*      */     
/*  821 */     GameRegistry.registerItem(helmetBronzePlate, "bronzePlateHelmet");
/*  822 */     GameRegistry.registerItem(plateBronzePlate, "bronzePlateChest");
/*  823 */     GameRegistry.registerItem(legsBronzePlate, "bronzePlateLegs");
/*  824 */     GameRegistry.registerItem(bootsBronzePlate, "bronzePlateBoots");
/*      */     
/*  826 */     GameRegistry.registerItem(doorIronbark, "doorIronbarkItem");
/*  827 */     GameRegistry.registerItem(doorHard, "doorHardItem");
/*  828 */     GameRegistry.registerItem(doorSteel, "doorSteelItem");
/*  829 */     GameRegistry.registerItem(axeDragon, "axeDragon");
/*      */     
/*  831 */     GameRegistry.registerItem(hammerDragon, "hammerDragon");
/*  832 */     GameRegistry.registerItem(hoeDragon, "hoeDragon");
/*  833 */     GameRegistry.registerItem(knifeDragon, "knifeDragon");
/*  834 */     GameRegistry.registerItem(mattockDragon, "mattockDragon");
/*  835 */     GameRegistry.registerItem(rakeDragon, "rakeDragon");
/*  836 */     GameRegistry.registerItem(pickDragon, "pickDragon");
/*      */     
/*  838 */     GameRegistry.registerItem(helmetEncrustedPlate, "encrustedPlateHelmet");
/*  839 */     GameRegistry.registerItem(plateEncrustedPlate, "encrustedPlateChest");
/*  840 */     GameRegistry.registerItem(legsEncrustedPlate, "encrustedPlateLegs");
/*  841 */     GameRegistry.registerItem(bootsEncrustedPlate, "encrustedPlateBoots");
/*      */     
/*  843 */     GameRegistry.registerItem(helmetSteelSplint, "steelSplintHelmet");
/*  844 */     GameRegistry.registerItem(plateSteelSplint, "steelSplintChest");
/*  845 */     GameRegistry.registerItem(legsSteelSplint, "steelSplintLegs");
/*  846 */     GameRegistry.registerItem(bootsSteelSplint, "steelSplintBoots");
/*      */     
/*  848 */     GameRegistry.registerItem(helmetSteelScale, "steelScaleHelmet");
/*  849 */     GameRegistry.registerItem(plateSteelScale, "steelScaleChest");
/*  850 */     GameRegistry.registerItem(legsSteelScale, "steelScaleLegs");
/*  851 */     GameRegistry.registerItem(bootsSteelScale, "steelScaleBoots");
/*      */     
/*  853 */     GameRegistry.registerItem(helmetMithrilSplint, "mithrilSplintHelmet");
/*  854 */     GameRegistry.registerItem(plateMithrilSplint, "mithrilSplintChest");
/*  855 */     GameRegistry.registerItem(legsMithrilSplint, "mithrilSplintLegs");
/*  856 */     GameRegistry.registerItem(bootsMithrilSplint, "mithrilSplintBoots");
/*      */     
/*  858 */     GameRegistry.registerItem(helmetIronHvyChain, "ironHvyHelmet");
/*  859 */     GameRegistry.registerItem(plateIronHvyChain, "ironHvyChest");
/*  860 */     GameRegistry.registerItem(legsIronHvyChain, "ironHvyLegs");
/*  861 */     GameRegistry.registerItem(bootsIronHvyChain, "ironHvyBoots");
/*      */     
/*  863 */     GameRegistry.registerItem(drakeRaw, "drakeRaw");
/*  864 */     GameRegistry.registerItem(drakeCooked, "drakeCooked");
/*      */     
/*  866 */     GameRegistry.registerItem(maceCopper, "maceCopper");
/*  867 */     GameRegistry.registerItem(maceBronze, "maceBronze");
/*  868 */     GameRegistry.registerItem(maceIron, "maceIron");
/*  869 */     GameRegistry.registerItem(maceSteel, "maceSteel");
/*  870 */     GameRegistry.registerItem(maceMithril, "maceMithril");
/*  871 */     GameRegistry.registerItem(maceDragon, "maceDragon");
/*  872 */     GameRegistry.registerItem(maceOrnate, "maceOrnate");
/*  873 */     GameRegistry.registerItem(waraxeBronze, "waraxeBronze");
/*      */     
/*  875 */     GameRegistry.registerItem(hammerMithril, "hammerMithril");
/*  876 */     GameRegistry.registerItem(scytheMithril, "scytheMithril");
/*  877 */     GameRegistry.registerItem(hound_Iplate, "hound_Iplate");
/*  878 */     GameRegistry.registerItem(hound_IplateH, "hound_IplateH");
/*  879 */     GameRegistry.registerItem(sawDragon, "sawDragon");
/*      */     
/*  881 */     GameRegistry.registerItem(hound_feed, "hound_feed");
/*  882 */     GameRegistry.registerItem(hound_sPack, "hound_sPack");
/*  883 */     GameRegistry.registerItem(hound_bPack, "hound_bPack");
/*      */     
/*  885 */     GameRegistry.registerItem(hammerTin, "hammerTin");
/*  886 */     GameRegistry.registerItem(shearsTin, "shearsTin");
/*      */     
/*  888 */     GameRegistry.registerItem(hound_BMail, "hound_BMail");
/*  889 */     GameRegistry.registerItem(hound_BMailH, "hound_BMailH");
/*  890 */     GameRegistry.registerItem(hound_IMail, "hound_IMail");
/*  891 */     GameRegistry.registerItem(hound_IMailH, "hound_IMailH");
/*  892 */     GameRegistry.registerItem(hound_SMail, "hound_SMail");
/*  893 */     GameRegistry.registerItem(hound_SMailH, "hound_SMailH");
/*  894 */     GameRegistry.registerItem(hound_MMail, "hound_MMail");
/*  895 */     GameRegistry.registerItem(hound_MMailH, "hound_MMailH");
/*      */     
/*  897 */     GameRegistry.registerItem(hound_Bplate, "hound_Bplate");
/*  898 */     GameRegistry.registerItem(hound_BplateH, "hound_BplateH");
/*  899 */     GameRegistry.registerItem(hound_Splate, "hound_Splate");
/*  900 */     GameRegistry.registerItem(hound_SplateH, "hound_SplateH");
/*  901 */     GameRegistry.registerItem(hound_Dplate, "hound_Dplate");
/*  902 */     GameRegistry.registerItem(hound_DplateH, "hound_DplateH");
/*  903 */     GameRegistry.registerItem(hound_Eplate, "hound_Eplate");
/*  904 */     GameRegistry.registerItem(hound_EplateH, "hound_EplateH");
/*      */     
/*  906 */     GameRegistry.registerItem(hound_Bteeth, "hound_Bteeth");
/*  907 */     GameRegistry.registerItem(hound_Iteeth, "hound_Iteeth");
/*  908 */     GameRegistry.registerItem(hound_Steeth, "hound_Steeth");
/*  909 */     GameRegistry.registerItem(hound_Eteeth, "hound_Eteeth");
/*  910 */     GameRegistry.registerItem(hound_Mteeth, "hound_Mteeth");
/*  911 */     GameRegistry.registerItem(hound_Dteeth, "hound_Dteeth");
/*      */     
/*  913 */     GameRegistry.registerItem(spearBronze, "spearBronze");
/*  914 */     GameRegistry.registerItem(spearIron, "spearIron");
/*  915 */     GameRegistry.registerItem(spearSteel, "spearSteel");
/*  916 */     GameRegistry.registerItem(spearEncrusted, "spearEncrusted");
/*  917 */     GameRegistry.registerItem(spearMithril, "spearMithril");
/*  918 */     GameRegistry.registerItem(waraxeMithril, "waraxeMithril");
/*  919 */     GameRegistry.registerItem(spearDragon, "spearDragon");
/*  920 */     GameRegistry.registerItem(waraxeOrnate, "waraxeOrnate");
/*  921 */     GameRegistry.registerItem(spearOrnate, "spearOrnate");
/*      */     
/*  923 */     GameRegistry.registerItem(battleaxeBronze, "battleaxeBronze");
/*  924 */     GameRegistry.registerItem(battleaxeIron, "battleaxeIron");
/*  925 */     GameRegistry.registerItem(battleaxeSteel, "battleaxeSteel");
/*  926 */     GameRegistry.registerItem(battleaxeEncrusted, "battleaxeEncrusted");
/*  927 */     GameRegistry.registerItem(battleaxeMithril, "battleaxeMithril");
/*  928 */     GameRegistry.registerItem(battleaxeOrnate, "battleaxeOrnate");
/*  929 */     GameRegistry.registerItem(mattockSteel, "mattockSteel");
/*  930 */     GameRegistry.registerItem(battleaxeDragon, "battleaxeDragon");
/*  931 */     GameRegistry.registerItem(sawBronze, "sawBronze");
/*      */     
/*  933 */     GameRegistry.registerItem(scytheBronze, "scytheBronze");
/*  934 */     GameRegistry.registerItem(scytheIron, "scytheIron");
/*  935 */     GameRegistry.registerItem(scytheSteel, "scytheSteel");
/*  936 */     GameRegistry.registerItem(hammerStone, "hammerStone");
/*      */     
/*  938 */     GameRegistry.registerItem(greatswordBronze, "greatswordBronze");
/*  939 */     GameRegistry.registerItem(greatswordIron, "greatswordIron");
/*  940 */     GameRegistry.registerItem(greatswordSteel, "greatswordSteel");
/*  941 */     GameRegistry.registerItem(greatswordEncrusted, "greatswordEncrusted");
/*  942 */     GameRegistry.registerItem(greatswordMithril, "greatswordMithril");
/*  943 */     GameRegistry.registerItem(greatswordDragon, "greatswordDragon");
/*  944 */     GameRegistry.registerItem(sawIron, "sawIron");
/*  945 */     GameRegistry.registerItem(greatswordOrnate, "greatswordOrnate");
/*  946 */     GameRegistry.registerItem(sawSteel, "sawSteel");
/*      */     
/*  948 */     GameRegistry.registerItem(hammerRepair, "hammerRepair");
/*  949 */     GameRegistry.registerItem(hammerRepairOrnate, "hammerRepairOrnate");
/*      */     
/*  951 */     GameRegistry.registerItem(hammerRepair2, "hammerRepair2");
/*  952 */     GameRegistry.registerItem(hammerRepairOrnate2, "hammerRepairOrnate2");
/*      */     
/*  954 */     GameRegistry.registerItem(hammerRepairArtisan, "hammerRepairArtisan");
/*  955 */     GameRegistry.registerItem(hammerRepairOrnateArtisan, "hammerRepairOrnateArtisan");
/*      */     
/*  957 */     GameRegistry.registerItem(daggerBronze, "daggerBronze");
/*  958 */     GameRegistry.registerItem(daggerIron, "daggerIron");
/*  959 */     GameRegistry.registerItem(daggerSteel, "daggerSteel");
/*  960 */     GameRegistry.registerItem(daggerEncrusted, "daggerEncrusted");
/*  961 */     GameRegistry.registerItem(daggerMithril, "daggerMithril");
/*  962 */     GameRegistry.registerItem(daggerDragon, "daggerDragon");
/*  963 */     GameRegistry.registerItem(pickCopperForged, "pickCopperForged");
/*  964 */     GameRegistry.registerItem(daggerOrnate, "daggerOrnate");
/*  965 */     GameRegistry.registerItem(axeCopperForged, "axeCopperForged");
/*      */     
/*  967 */     GameRegistry.registerItem(scytheDragon, "scytheDragon");
/*  968 */     GameRegistry.registerItem(shearsDragon, "shearsDragon");
/*  969 */     GameRegistry.registerItem(spadeDragon, "spadeDragon");
/*  970 */     GameRegistry.registerItem(tongsDragon, "tongsDragon");
/*  971 */     GameRegistry.registerItem(bowDragon, "bowDragonforge");
/*  972 */     GameRegistry.registerItem(bowOrnate, "bowOrnate");
/*  973 */     GameRegistry.registerItem(spadeCopperForged, "spadeCopper");
/*  974 */     GameRegistry.registerItem(malletEbony, "malletEbony");
/*  975 */     GameRegistry.registerItem(hoeCopperForged, "hoeCopperForged");
/*      */     
/*  977 */     GameRegistry.registerItem(helmetStealth, "stealthHelmet");
/*  978 */     GameRegistry.registerItem(plateStealth, "stealthChest");
/*  979 */     GameRegistry.registerItem(legsStealth, "stealthLegs");
/*  980 */     GameRegistry.registerItem(bootsStealth, "stealthBoots");
/*      */     
/*  982 */     GameRegistry.registerItem(crossbowHand, "crossbowHand");
/*  983 */     GameRegistry.registerItem(crossbowLight, "crossbowLight");
/*  984 */     GameRegistry.registerItem(crossbowRepeat, "crossbowRepeat");
/*  985 */     GameRegistry.registerItem(crossbowHeavy, "crossbowHeavy");
/*      */     
/*  987 */     GameRegistry.registerItem(tongsStone, "tongsStone");
/*  988 */     GameRegistry.registerItem(boltMF, "boltMF");
/*      */     
/*  990 */     GameRegistry.registerItem(spearStone, "spearStonePrim");
/*  991 */     GameRegistry.registerItem(spearCopper, "spearCopperPrim");
/*      */     
/*  993 */     GameRegistry.registerItem(pickStonePrim, "pickStonePrim");
/*  994 */     GameRegistry.registerItem(pickCopperPrim, "pickCopperPrim");
/*  995 */     GameRegistry.registerItem(rocks, "flintAndRock");
/*  996 */     GameRegistry.registerItem(javelin, "javelin");
/*  997 */     GameRegistry.registerItem(armourRawhide, "rawhideChest");
/*  998 */     GameRegistry.registerItem(legsRawhide, "rawhideLegs");
/*  999 */     GameRegistry.registerItem(clubWood, "clubPrim");
/* 1000 */     GameRegistry.registerItem(clubStone, "clubStonePrim");
/*      */     
/* 1002 */     GameRegistry.registerItem(bowEbony, "bowEbony");
/*      */     
/* 1004 */     GameRegistry.registerItem(waraxeIron, "waraxeIron");
/*      */     
/* 1006 */     GameRegistry.registerItem(shearsCopper, "shearsCopper");
/* 1007 */     GameRegistry.registerItem(shearsBronze, "shearsBronze");
/* 1008 */     GameRegistry.registerItem(shearsIron, "shearsIron");
/* 1009 */     GameRegistry.registerItem(shearsSteel, "shearsSteel");
/*      */     
/* 1011 */     GameRegistry.registerItem(warhammerBronze, "warhammerBronze");
/* 1012 */     GameRegistry.registerItem(warhammerIron, "warhammerIron");
/* 1013 */     GameRegistry.registerItem(warhammerSteel, "warhammerSteel");
/* 1014 */     GameRegistry.registerItem(warhammerOrnate, "warhammerOrnate");
/* 1015 */     GameRegistry.registerItem(warhammerMithril, "warhammerMithril");
/* 1016 */     GameRegistry.registerItem(warhammerDragon, "warhammerDragon");
/*      */     
/* 1018 */     GameRegistry.registerItem(helmetIronScale, "ironScaleHelmet");
/* 1019 */     GameRegistry.registerItem(plateIronScale, "ironScaleChest");
/* 1020 */     GameRegistry.registerItem(legsIronScale, "ironScaleLegs");
/* 1021 */     GameRegistry.registerItem(bootsIronScale, "ironScaleBoots");
/* 1022 */     GameRegistry.registerItem(transferHound, "petChange");
/* 1023 */     GameRegistry.registerItem(hound_Igteeth, "hound_Igteeth");
/* 1024 */     GameRegistry.registerItem(hound_Oteeth, "hound_Oteeth");
/*      */     
/* 1026 */     GameRegistry.registerItem(halbeardBronze, "halbeardBronze");
/* 1027 */     GameRegistry.registerItem(halbeardIron, "halbeardIron");
/* 1028 */     GameRegistry.registerItem(halbeardSteel, "halbeardSteel");
/* 1029 */     GameRegistry.registerItem(halbeardOrnate, "halbeardOrnate");
/* 1030 */     GameRegistry.registerItem(halbeardEncrusted, "halbeardEncrusted");
/* 1031 */     GameRegistry.registerItem(halbeardMithril, "halbeardMithril");
/* 1032 */     GameRegistry.registerItem(halbeardDragon, "halbeardDragon");
/*      */     
/* 1034 */     GameRegistry.registerItem(bloom, "bloom");
/* 1035 */     GameRegistry.registerItem(sling, "sling");
/*      */     
/* 1037 */     GameRegistry.registerItem(basiliskRaw, "basiliskRaw");
/* 1038 */     GameRegistry.registerItem(basiliskCooked, "basiliskCooked");
/*      */     
/* 1040 */     GameRegistry.registerItem(helmetMithrilScale, "mithrilScaleHelmet");
/* 1041 */     GameRegistry.registerItem(plateMithrilScale, "mithrilScaleChest");
/* 1042 */     GameRegistry.registerItem(legsMithrilScale, "mithrilScaleLegs");
/* 1043 */     GameRegistry.registerItem(bootsMithrilScale, "mithrilScaleBoots");
/* 1044 */     GameRegistry.registerItem(helmetDragonScale, "dragonforgeScaleHelmet");
/* 1045 */     GameRegistry.registerItem(plateDragonScale, "dragonforgeScaleChest");
/* 1046 */     GameRegistry.registerItem(legsDragonScale, "dragonforgeScaleLegs");
/* 1047 */     GameRegistry.registerItem(bootsDragonScale, "dragonforgeScaleBoots");
/*      */     
/* 1049 */     GameRegistry.registerItem(helmetSteelChain, "steelChainHelmet");
/* 1050 */     GameRegistry.registerItem(plateSteelChain, "steelChainChest");
/* 1051 */     GameRegistry.registerItem(legsSteelChain, "steelChainLegs");
/* 1052 */     GameRegistry.registerItem(bootsSteelChain, "steelChainBoots");
/* 1053 */     GameRegistry.registerItem(helmetMithrilChain, "mithrilChainHelmet");
/* 1054 */     GameRegistry.registerItem(plateMithrilChain, "mithrilChainChest");
/* 1055 */     GameRegistry.registerItem(legsMithrilChain, "mithrilChainLegs");
/* 1056 */     GameRegistry.registerItem(bootsMithrilChain, "mithrilChainBoots");
/* 1057 */     GameRegistry.registerItem(helmetDragonChain, "dragonforgeChainHelmet");
/* 1058 */     GameRegistry.registerItem(plateDragonChain, "dragonforgeChainChest");
/* 1059 */     GameRegistry.registerItem(legsDragonChain, "dragonforgeChainLegs");
/* 1060 */     GameRegistry.registerItem(bootsDragonChain, "dragonforgeChainBoots");
/*      */     
/* 1062 */     GameRegistry.registerItem(helmetBronzeSplint, "bronzeSplintHelmet");
/* 1063 */     GameRegistry.registerItem(plateBronzeSplint, "bronzeSplintChest");
/* 1064 */     GameRegistry.registerItem(legsBronzeSplint, "bronzeSplintLegs");
/* 1065 */     GameRegistry.registerItem(bootsBronzeSplint, "bronzeSplintBoots");
/* 1066 */     GameRegistry.registerItem(helmetIronSplint, "ironSplintHelmet");
/* 1067 */     GameRegistry.registerItem(plateIronSplint, "ironSplintChest");
/* 1068 */     GameRegistry.registerItem(legsIronSplint, "ironSplintLegs");
/* 1069 */     GameRegistry.registerItem(bootsIronSplint, "ironSplintBoots");
/* 1070 */     GameRegistry.registerItem(helmetDragonSplint, "dragonforgeSplintHelmet");
/* 1071 */     GameRegistry.registerItem(plateDragonSplint, "dragonforgeSplintChest");
/* 1072 */     GameRegistry.registerItem(legsDragonSplint, "dragonforgeSplintLegs");
/* 1073 */     GameRegistry.registerItem(bootsDragonSplint, "dragonforgeSplintBoots");
/*      */     
/* 1075 */     GameRegistry.registerItem(helmetBronzeHvyChain, "bronzeHvyHelmet");
/* 1076 */     GameRegistry.registerItem(plateBronzeHvyChain, "bronzeHvyChest");
/* 1077 */     GameRegistry.registerItem(legsBronzeHvyChain, "bronzeHvyLegs");
/* 1078 */     GameRegistry.registerItem(bootsBronzeHvyChain, "bronzeHvyBoots");
/* 1079 */     GameRegistry.registerItem(helmetSteelHvyChain, "steelHvyHelmet");
/* 1080 */     GameRegistry.registerItem(plateSteelHvyChain, "steelHvyChest");
/* 1081 */     GameRegistry.registerItem(legsSteelHvyChain, "steelHvyLegs");
/* 1082 */     GameRegistry.registerItem(bootsSteelHvyChain, "steelHvyBoots");
/* 1083 */     GameRegistry.registerItem(helmetMithrilHvyChain, "mithrilHvyHelmet");
/* 1084 */     GameRegistry.registerItem(plateMithrilHvyChain, "mithrilHvyChest");
/* 1085 */     GameRegistry.registerItem(legsMithrilHvyChain, "mithrilHvyLegs");
/* 1086 */     GameRegistry.registerItem(bootsMithrilHvyChain, "mithrilHvyBoots");
/* 1087 */     GameRegistry.registerItem(helmetDragonHvyChain, "dragonforgeHvyHelmet");
/* 1088 */     GameRegistry.registerItem(plateDragonHvyChain, "dragonforgeHvyChest");
/* 1089 */     GameRegistry.registerItem(legsDragonHvyChain, "dragonforgeHvyLegs");
/* 1090 */     GameRegistry.registerItem(bootsDragonHvyChain, "dragonforgeHvyBoots");
/*      */     
/* 1092 */     GameRegistry.registerItem(helmetIronPlate, "ironPlateHelmet");
/* 1093 */     GameRegistry.registerItem(plateIronPlate, "ironPlateChest");
/* 1094 */     GameRegistry.registerItem(legsIronPlate, "ironPlateLegs");
/* 1095 */     GameRegistry.registerItem(bootsIronPlate, "ironPlateBoots");
/* 1096 */     GameRegistry.registerItem(helmetMithrilPlate, "mithrilPlateHelmet");
/* 1097 */     GameRegistry.registerItem(plateMithrilPlate, "mithrilPlateChest");
/* 1098 */     GameRegistry.registerItem(legsMithrilPlate, "mithrilPlateLegs");
/* 1099 */     GameRegistry.registerItem(bootsMithrilPlate, "mithrilPlateBoots");
/*      */     
/* 1101 */     GameRegistry.registerItem(hound_Mplate, "hound_Mplate");
/* 1102 */     GameRegistry.registerItem(hound_MplateH, "hound_MplateH");
/* 1103 */     GameRegistry.registerItem(hound_DMail, "hound_DMail");
/* 1104 */     GameRegistry.registerItem(hound_DMailH, "hound_DMailH");
/*      */     
/* 1106 */     GameRegistry.registerItem(needleBone, "needleBone");
/* 1107 */     GameRegistry.registerItem(needleBronze, "needleBronze");
/* 1108 */     GameRegistry.registerItem(needleIron, "needleIron");
/* 1109 */     GameRegistry.registerItem(needleSteel, "needleSteel");
/* 1110 */     GameRegistry.registerItem(needleMithril, "needleMithril");
/*      */     
/* 1112 */     GameRegistry.registerItem(shortbow, "shortbow");
/* 1113 */     GameRegistry.registerItem(bowBronze, "bowBronze");
/* 1114 */     GameRegistry.registerItem(bowIron, "bowIron");
/* 1115 */     GameRegistry.registerItem(bowSteel, "bowSteel");
/* 1116 */     GameRegistry.registerItem(bowMithril, "bowMithril");
/*      */     
/* 1118 */     GameRegistry.registerItem(tongsTin, "tongsTin");
/* 1119 */     GameRegistry.registerItem(tongsCopper, "tongsCopper");
/*      */     
/* 1121 */     GameRegistry.registerItem(lanceBronze, "lanceBronze");
/* 1122 */     GameRegistry.registerItem(lanceIron, "lanceIron");
/* 1123 */     GameRegistry.registerItem(lanceSteel, "lanceSteel");
/* 1124 */     GameRegistry.registerItem(lanceEncrusted, "lanceEncrusted");
/* 1125 */     GameRegistry.registerItem(lanceMithril, "lanceMithril");
/* 1126 */     GameRegistry.registerItem(lanceDragon, "lanceDragonforge");
/* 1127 */     GameRegistry.registerItem(lanceOrnate, "lanceOrnate");
/*      */     
/* 1129 */     GameRegistry.registerItem(helmetGuildedPlate, "guildedPlateHelmet");
/* 1130 */     GameRegistry.registerItem(plateGuildedPlate, "guildedPlateChest");
/* 1131 */     GameRegistry.registerItem(legsGuildedPlate, "guildedPlateLegs");
/* 1132 */     GameRegistry.registerItem(bootsGuildedPlate, "guildedPlateBoots");
/*      */     
/* 1134 */     GameRegistry.registerItem(helmetGuildedChain, "guildedChainHelmet");
/* 1135 */     GameRegistry.registerItem(plateGuildedChain, "guildedChainChest");
/* 1136 */     GameRegistry.registerItem(legsGuildedChain, "guildedChainLegs");
/* 1137 */     GameRegistry.registerItem(bootsGuildedChain, "guildedChainBoots");
/*      */     
/* 1139 */     GameRegistry.registerItem(helmetGuildedSplint, "guildedSplintHelmet");
/* 1140 */     GameRegistry.registerItem(plateGuildedSplint, "guildedSplintChest");
/* 1141 */     GameRegistry.registerItem(legsGuildedSplint, "guildedSplintLegs");
/* 1142 */     GameRegistry.registerItem(bootsGuildedSplint, "guildedSplintBoots");
/*      */     
/* 1144 */     GameRegistry.registerItem(helmetGuildedHvyChain, "guildedHvyHelmet");
/* 1145 */     GameRegistry.registerItem(plateGuildedHvyChain, "guildedHvyChest");
/* 1146 */     GameRegistry.registerItem(legsGuildedHvyChain, "guildedHvyLegs");
/* 1147 */     GameRegistry.registerItem(bootsGuildedHvyChain, "guildedHvyBoots");
/*      */     
/* 1149 */     GameRegistry.registerItem(helmetGuildedScale, "guildedScaleHelmet");
/* 1150 */     GameRegistry.registerItem(plateGuildedScale, "guildedScaleChest");
/* 1151 */     GameRegistry.registerItem(legsGuildedScale, "guildedScaleLegs");
/* 1152 */     GameRegistry.registerItem(bootsGuildedScale, "guildedScaleBoots");
/*      */     
/* 1154 */     GameRegistry.registerItem(handpickBronze, "handpickBronze");
/* 1155 */     GameRegistry.registerItem(handpickIron, "handpickIron");
/* 1156 */     GameRegistry.registerItem(handpickSteel, "handpickSteel");
/* 1157 */     GameRegistry.registerItem(handpickEncrusted, "handpickEncrusted");
/* 1158 */     GameRegistry.registerItem(handpickMithril, "handpickMithril");
/* 1159 */     GameRegistry.registerItem(handpickDragonforge, "handpickDragonforge");
/* 1160 */     GameRegistry.registerItem(handpickIgnotumite, "handpickIgnotumite");
/*      */     
/* 1162 */     GameRegistry.registerItem(helmetLeatherRough, "roughLeatherHelmet");
/* 1163 */     GameRegistry.registerItem(plateLeatherRough, "roughLeatherChest");
/* 1164 */     GameRegistry.registerItem(legsLeatherRough, "roughLeatherLegs");
/* 1165 */     GameRegistry.registerItem(bootsLeatherRough, "roughLeatherBoots");
/*      */     
/* 1167 */     GameRegistry.registerItem(waraxeCopper, "waraxeCopper");
/* 1168 */     GameRegistry.registerItem(waraxeTin, "waraxeTin");
/* 1169 */     GameRegistry.registerItem(swordCopper, "swordCopper");
/* 1170 */     GameRegistry.registerItem(maceTin, "maceTin");
/*      */     
/* 1172 */     GameRegistry.registerItem(daggerIgnotumite, "daggerIgnotumite");
/* 1173 */     GameRegistry.registerItem(waraxeIgnotumite, "waraxeIgnotumite");
/* 1174 */     GameRegistry.registerItem(maceIgnotumite, "maceIgnotumite");
/* 1175 */     GameRegistry.registerItem(broadIgnotumite, "broadswordIgnotumite");
/* 1176 */     GameRegistry.registerItem(warpickIgnotumite, "warpickIgnotumite");
/* 1177 */     GameRegistry.registerItem(greatswordIgnotumite, "greatswordIgnotumite");
/* 1178 */     GameRegistry.registerItem(morningstarIgnotumite, "greatmaceIgnotumite");
/* 1179 */     GameRegistry.registerItem(battleaxeIgnotumite, "battleaxeIgnotumite");
/* 1180 */     GameRegistry.registerItem(warhammerIgnotumite, "warhammerIgnotumite");
/* 1181 */     GameRegistry.registerItem(spearIgnotumite, "spearIgnotumite");
/* 1182 */     GameRegistry.registerItem(halbeardIgnotumite, "halbeardIgnotumite");
/* 1183 */     GameRegistry.registerItem(lanceIgnotumite, "lanceIgnotumite");
/* 1184 */     GameRegistry.registerItem(warpickOrnate, "warpickOrnate");
/*      */     
/* 1186 */     GameRegistry.registerItem(hound_GMail, "hound_GMail");
/* 1187 */     GameRegistry.registerItem(hound_GMailH, "hound_GMailH");
/*      */     
/* 1189 */     GameRegistry.registerItem(hound_Gplate, "hound_Gplate");
/* 1190 */     GameRegistry.registerItem(hound_GplateH, "hound_GplateH");
/*      */     
/* 1192 */     GameRegistry.registerItem(muttonRaw, "muttonRaw");
/* 1193 */     GameRegistry.registerItem(muttonCooked, "muttonCooked");
/*      */     
/* 1195 */     GameRegistry.registerItem(kiteBronze, "kiteBronze");
/* 1196 */     GameRegistry.registerItem(kiteIron, "kiteIron");
/* 1197 */     GameRegistry.registerItem(kiteSteel, "kiteSteel");
/* 1198 */     GameRegistry.registerItem(kiteMithril, "kiteMithril");
/* 1199 */     GameRegistry.registerItem(kiteGuilded, "kiteGuilded");
/* 1200 */     GameRegistry.registerItem(kiteEncrusted, "kiteEncrusted");
/* 1201 */     GameRegistry.registerItem(kiteDragonforge, "kiteDragonforge");
/*      */     
/* 1203 */     GameRegistry.registerItem(towerBronze, "towerBronze");
/* 1204 */     GameRegistry.registerItem(towerIron, "towerIron");
/* 1205 */     GameRegistry.registerItem(towerSteel, "towerSteel");
/* 1206 */     GameRegistry.registerItem(towerMithril, "towerMithril");
/* 1207 */     GameRegistry.registerItem(towerGuilded, "towerGuilded");
/* 1208 */     GameRegistry.registerItem(towerEncrusted, "towerEncrusted");
/* 1209 */     GameRegistry.registerItem(towerDragonforge, "towerDragonforge");
/*      */     
/* 1211 */     GameRegistry.registerItem(bucklerBronze, "bucklerBronze");
/* 1212 */     GameRegistry.registerItem(bucklerIron, "bucklerIron");
/* 1213 */     GameRegistry.registerItem(bucklerSteel, "bucklerSteel");
/* 1214 */     GameRegistry.registerItem(bucklerMithril, "bucklerMithril");
/* 1215 */     GameRegistry.registerItem(bucklerGuilded, "bucklerGuilded");
/* 1216 */     GameRegistry.registerItem(bucklerEncrusted, "bucklerEncrusted");
/* 1217 */     GameRegistry.registerItem(bucklerDragonforge, "bucklerDragonforge");
/*      */     
/* 1219 */     GameRegistry.registerItem(shieldWood, "shieldWood");
/* 1220 */     GameRegistry.registerItem(shieldIronbark, "shieldIronbark");
/* 1221 */     GameRegistry.registerItem(shieldEbony, "shieldEbony");
/*      */     
/* 1223 */     GameRegistry.registerItem(bandage, "bandage");
/*      */     
/* 1225 */     GameRegistry.registerItem(bowDeepIron, "bowDeepIron");
/*      */     
/* 1227 */     GameRegistry.registerItem(hammerDeepIron, "hammerDeepIron");
/* 1228 */     GameRegistry.registerItem(tongsDeepIron, "tongsDeepIron");
/* 1229 */     GameRegistry.registerItem(knifeDeepIron, "knifeDeepIron");
/* 1230 */     GameRegistry.registerItem(shearsDeepIron, "shearsDeepIron");
/* 1231 */     GameRegistry.registerItem(needleDeepIron, "needleDeepIron");
/* 1232 */     GameRegistry.registerItem(pickDeepIron, "pickDeepIron");
/* 1233 */     GameRegistry.registerItem(handpickDeepIron, "handpickDeepIron");
/* 1234 */     GameRegistry.registerItem(axeDeepIron, "axeDeepIron");
/* 1235 */     GameRegistry.registerItem(sawDeepIron, "sawDeepIron");
/* 1236 */     GameRegistry.registerItem(spadeDeepIron, "spadeDeepIron");
/* 1237 */     GameRegistry.registerItem(mattockDeepIron, "mattockDeepIron");
/* 1238 */     GameRegistry.registerItem(hoeDeepIron, "hoeDeepIron");
/* 1239 */     GameRegistry.registerItem(scytheDeepIron, "scytheDeepIron");
/* 1240 */     GameRegistry.registerItem(rakeDeepIron, "rakeDeepIron");
/*      */     
/* 1242 */     GameRegistry.registerItem(daggerDeepIron, "daggerDeepIron");
/* 1243 */     GameRegistry.registerItem(swordDeepIron, "swordDeepIron");
/* 1244 */     GameRegistry.registerItem(broadswordDeepIron, "broadswordDeepIron");
/* 1245 */     GameRegistry.registerItem(greatswordDeepIron, "greatswordDeepIron");
/* 1246 */     GameRegistry.registerItem(maceDeepIron, "maceDeepIron");
/* 1247 */     GameRegistry.registerItem(warpickDeepIron, "warpickDeepIron");
/* 1248 */     GameRegistry.registerItem(greatmaceDeepIron, "greatmaceDeepIron");
/* 1249 */     GameRegistry.registerItem(warhammerDeepIron, "warhammerDeepIron");
/* 1250 */     GameRegistry.registerItem(waraxeDeepIron, "waraxeDeepIron");
/* 1251 */     GameRegistry.registerItem(battleaxeDeepIron, "battleaxeDeepIron");
/* 1252 */     GameRegistry.registerItem(spearDeepIron, "spearDeepIron");
/* 1253 */     GameRegistry.registerItem(halbeardDeepIron, "halbeardDeepIron");
/* 1254 */     GameRegistry.registerItem(lanceDeepIron, "lanceDeepIron");
/*      */     
/* 1256 */     GameRegistry.registerItem(bucklerDeepIron, "bucklerDeepIron");
/* 1257 */     GameRegistry.registerItem(kiteDeepIron, "kiteDeepIron");
/* 1258 */     GameRegistry.registerItem(towerDeepIron, "towerDeepIron");
/*      */     
/* 1260 */     GameRegistry.registerItem(hound_DImail, "hound_DImail");
/* 1261 */     GameRegistry.registerItem(hound_DImailH, "hound_DImailH");
/* 1262 */     GameRegistry.registerItem(hound_DIplate, "hound_DIplate");
/* 1263 */     GameRegistry.registerItem(hound_DIplateH, "hound_DIplateH");
/* 1264 */     GameRegistry.registerItem(hound_DIteeth, "hound_DIteeth");
/*      */     
/* 1266 */     GameRegistry.registerItem(helmetDeepIronPlate, "deepIronPlateHelmet");
/* 1267 */     GameRegistry.registerItem(plateDeepIronPlate, "deepIronPlateChest");
/* 1268 */     GameRegistry.registerItem(legsDeepIronPlate, "deepIronPlateLegs");
/* 1269 */     GameRegistry.registerItem(bootsDeepIronPlate, "deepIronPlateBoots");
/*      */     
/* 1271 */     GameRegistry.registerItem(helmetDeepIronChain, "deepIronChainHelmet");
/* 1272 */     GameRegistry.registerItem(plateDeepIronChain, "deepIronChainChest");
/* 1273 */     GameRegistry.registerItem(legsDeepIronChain, "deepIronChainLegs");
/* 1274 */     GameRegistry.registerItem(bootsDeepIronChain, "deepIronChainBoots");
/*      */     
/* 1276 */     GameRegistry.registerItem(helmetDeepIronSplint, "deepIronSplintHelmet");
/* 1277 */     GameRegistry.registerItem(plateDeepIronSplint, "deepIronSplintChest");
/* 1278 */     GameRegistry.registerItem(legsDeepIronSplint, "deepIronSplintLegs");
/* 1279 */     GameRegistry.registerItem(bootsDeepIronSplint, "deepIronSplintBoots");
/*      */     
/* 1281 */     GameRegistry.registerItem(helmetDeepIronHvyChain, "deepIronHvyHelmet");
/* 1282 */     GameRegistry.registerItem(plateDeepIronHvyChain, "deepIronHvyChest");
/* 1283 */     GameRegistry.registerItem(legsDeepIronHvyChain, "deepIronHvyLegs");
/* 1284 */     GameRegistry.registerItem(bootsDeepIronHvyChain, "deepIronHvyBoots");
/*      */     
/* 1286 */     GameRegistry.registerItem(helmetDeepIronScale, "deepIronScaleHelmet");
/* 1287 */     GameRegistry.registerItem(plateDeepIronScale, "deepIronScaleChest");
/* 1288 */     GameRegistry.registerItem(legsDeepIronScale, "deepIronScaleLegs");
/* 1289 */     GameRegistry.registerItem(bootsDeepIronScale, "deepIronScaleBoots");
/*      */     
/* 1291 */     GameRegistry.registerItem(Item.field_77707_k, "bow");
/* 1292 */     GameRegistry.registerItem(Item.field_77694_Z, "ironChainHelmet");
/* 1293 */     GameRegistry.registerItem(Item.field_77814_aa, "ironChainChest");
/* 1294 */     GameRegistry.registerItem(Item.field_77816_ab, "ironChainLegs");
/* 1295 */     GameRegistry.registerItem(Item.field_77810_ac, "ironChainBoots");
/* 1296 */     GameRegistry.registerItem(Item.field_77759_aK, "paper"); }
/*      */   
/*      */   public static final int scaleMithril = 38;
/*      */   public static final int scaleDragonforge = 39; public static final int linkSteel = 40; public static final int chainSteel = 41; public static final int linkMithril = 42; public static final int chainMithril = 43; public static final int linkDragonforge = 44; public static final int chainDragon = 45; public static final int splintIron = 46; public static final int splintDragon = 47; public static final int coinGold = 48; public static final int coinSilver = 49; public static final int ignotDust = 50; public static final int IgnotImpure = 52; public static final int mithOre = 53; public static final int mithRefined = 54; public static final int ingotMithril = 55; public static final int ingotCopper = 56; public static final int ingotTin = 57; public static final int ingotBronze = 58; public static final int haft = 59; public static final int ingotWroughtIron = 60; public static final int platingIron = 61; public static final int splintMithril = 62;
/* 1300 */   public static void init() { addChestGen();
/* 1301 */     minefantasy.api.weapon.CrossbowAmmo.addArrow(Item.field_77704_l.field_77779_bT);
/*      */     
/* 1303 */     addDispenserBehavior(arrowMF, new minefantasy.entity.dispense.DispenseArrowMF());
/* 1304 */     addDispenserBehavior(boltMF, new minefantasy.entity.dispense.DispenseBoltMF());
/* 1305 */     addDispenserBehavior(bombMF, new minefantasy.entity.dispense.DispenseBombMF());
/*      */     
/* 1307 */     MineFantasyAPI.addFlux(component(0));
/*      */     
/*      */ 
/* 1310 */     MineFantasyAPI.addCarbon(Item.field_77705_m.field_77779_bT);
/* 1311 */     MineFantasyAPI.addCarbon(component(14));
/*      */     
/*      */ 
/* 1314 */     MineFantasyAPI.addBlastFuel(component(15), 5.0F);
/* 1315 */     MineFantasyAPI.addBlastFuel(component(14), 6.0F);
/* 1316 */     MineFantasyAPI.addBlastFuel(Item.field_77705_m.field_77779_bT, 0, 8.0F);
/* 1317 */     MineFantasyAPI.addBlastFuel(Block.field_111034_cE.field_71990_ca, 0, 80.0F);
/* 1318 */     MineFantasyAPI.addBlastFuel(Item.field_77705_m.field_77779_bT, 1, 8.0F);
/* 1319 */     MineFantasyAPI.addBlastFuel(misc.field_77779_bT, 92, 16.0F);
/* 1320 */     MineFantasyAPI.addBlastFuel(misc.field_77779_bT, 90, 32.0F);
/* 1321 */     MineFantasyAPI.addBlastFuel(misc.field_77779_bT, 91, 64.0F);
/* 1322 */     MineFantasyAPI.addBlastFuel(Item.field_77775_ay.field_77779_bT, 256.0F);
/*      */     
/*      */ 
/* 1325 */     MineFantasyAPI.addForgeFuel(misc.field_77779_bT, 15, 600.0F, 300);
/* 1326 */     MineFantasyAPI.addForgeFuel(misc.field_77779_bT, 14, 800.0F, 400);
/* 1327 */     MineFantasyAPI.addForgeFuel(misc.field_77779_bT, 92, 6000.0F, 400);
/* 1328 */     MineFantasyAPI.addForgeFuel(Item.field_77705_m.field_77779_bT, 1200.0F, 400);
/* 1329 */     MineFantasyAPI.addForgeFuel(misc.field_77779_bT, 90, 1600.0F, 1300);
/* 1330 */     MineFantasyAPI.addForgeFuel(Item.field_77722_bw.field_77779_bT, 1200.0F, 800, true);
/*      */     
/* 1332 */     MineFantasyAPI.addForgeFuel(misc.field_77779_bT, 91, 2400.0F, 1500, true);
/*      */     
/* 1334 */     MineFantasyAPI.addForgeFuel(Item.field_77775_ay.field_77779_bT, 12000.0F, 1000, true);
/*      */     
/*      */ 
/*      */ 
/* 1338 */     MineFantasyAPI.addRandomOre(component(177), 0.03F);
/* 1339 */     MineFantasyAPI.addRandomOre(component(0), 0.02F);
/* 1340 */     MineFantasyAPI.addRandomOre(new ItemStack(Item.field_77804_ap), 0.05F);
/*      */     
/* 1342 */     MineFantasyAPI.addRandomOre(component(0), 0.1F, 0, minefantasy.MineFantasyBase.MFBlockLimestone, false);
/*      */     
/* 1344 */     MineFantasyAPI.addRandomOre(component(24), 0.05F, 0, Block.field_72012_bb, false);
/*      */     
/* 1346 */     MineFantasyAPI.addRandomOre(new ItemStack(Item.field_77722_bw), 0.07F, 0, Block.field_72012_bb, false);
/*      */     
/* 1348 */     MineFantasyAPI.addRandomOre(component(24), 0.02F, 3, Block.field_71981_t, 0, 32, false);
/*      */     
/* 1350 */     MineFantasyAPI.addRandomOre(new ItemStack(Item.field_77705_m), 0.06F);
/*      */     
/* 1352 */     MineFantasyAPI.addRandomOre(new ItemStack(Item.field_77705_m), 0.75F, 0, Block.field_71950_I, true);
/*      */     
/* 1354 */     MineFantasyAPI.addRandomOre(new ItemStack(Item.field_77702_n), 0.2F, 0, Block.field_72073_aw, true);
/*      */     
/* 1356 */     MineFantasyAPI.addRandomOre(new ItemStack(Item.field_77767_aC), 1.0F, 0, Block.field_72047_aN, true);
/*      */     
/* 1358 */     MineFantasyAPI.addRandomOre(new ItemStack(Item.field_77767_aC), 1.0F, 0, Block.field_72048_aO, true);
/*      */     
/* 1360 */     MineFantasyAPI.addRandomOre(new ItemStack(Item.field_77756_aW, 4), 1.0F, 0, Block.field_71947_N, true);
/*      */     
/* 1362 */     MineFantasyAPI.addRandomOre(new ItemStack(Item.field_77817_bH), 0.15F, 0, Block.field_72068_bR, true);
/*      */     
/* 1364 */     assignItemOverrides(); }
/*      */   
/*      */   public static final int smlPlateIron = 63;
/*      */   public static final int coinCopper = 64; public static final int haftStrong = 65; public static final int limestoneHunk = 66; public static final int curvedPlateIron = 67; public static final int platingEncrusted = 68; public static final int smlPlateEncrusted = 69; public static final int curvedPlateEncrusted = 70; public static final int platingBronze = 72; public static final int smlPlateBronze = 73; public static final int curvedPlateBronze = 74; public static final int chainBronze = 76; public static final int haftIronbark = 77; public static final int haftOrnate = 81; public static final int haftEbony = 83; public static final int stickIronbark = 87; public static final int glueWeak = 88; public static final int glueStrong = 89; public static final int infernoCoal = 90; public static final int HellCoal = 91; public static final int longCoal = 92; public static final int platingMithril = 95; public static final int smlPlateMithril = 96;
/* 1368 */   private static void assignItemOverrides() { System.out.println("MineFantasy: Assigning Item Overrides ignore slot conflict messages");
/*      */     
/* 1370 */     Item.field_77698_e[Item.field_77759_aK.field_77779_bT] = null;
/* 1371 */     Item.field_77698_e[Item.field_77810_ac.field_77779_bT] = null;
/* 1372 */     Item.field_77698_e[Item.field_77694_Z.field_77779_bT] = null;
/* 1373 */     Item.field_77698_e[Item.field_77814_aa.field_77779_bT] = null;
/* 1374 */     Item.field_77698_e[Item.field_77816_ab.field_77779_bT] = null;
/* 1375 */     Item.field_77698_e[Item.field_77810_ac.field_77779_bT] = null;
/*      */     
/* 1377 */     Item.field_77759_aK = new ItemPaper(83).func_77655_b("paper").func_111206_d("paper");
/* 1378 */     Item.field_77694_Z = (ItemArmor)new ItemArmourMF(46, ArmourDesign.CHAIN, EnumArmourMF.IRON, 1, 0, "chain_1").func_77655_b("ironChainHelmet");
/* 1379 */     Item.field_77814_aa = (ItemArmor)new ItemArmourMF(47, ArmourDesign.CHAIN, EnumArmourMF.IRON, 1, 1, "chain_1").func_77655_b("ironChainChest");
/* 1380 */     Item.field_77816_ab = (ItemArmor)new ItemArmourMF(48, ArmourDesign.CHAIN, EnumArmourMF.IRON, 1, 2, "chain_2").func_77655_b("ironChainLegs");
/* 1381 */     Item.field_77810_ac = (ItemArmor)new ItemArmourMF(49, ArmourDesign.CHAIN, EnumArmourMF.IRON, 1, 3, "chain_1").func_77655_b("ironChainBoots");
/* 1382 */     Item.field_77707_k = (net.minecraft.item.ItemBow)new minefantasy.item.weapon.ItemVanillaBow(5).func_77655_b("bow").func_111206_d("bow");
/*      */     
/* 1384 */     System.out.println("MineFantasy: Finished Item Overrides"); }
/*      */   
/*      */   public static final int curvedPlateMithril = 97;
/*      */   public static final int hideMinotaur = 98; public static final int hideDrake = 101; public static final int blackLeather = 104; public static final int crossbowMech = 105; public static final int crossbowMechRepeat = 106; public static final int boltBox = 107; public static final int rock = 108; public static final int tendon = 109; public static final int vine = 110; public static final int shale = 111; public static final int shardCopper = 113; public static final int plankEbony = 114; public static final int chainIron = 116;
/* 1388 */   public static ItemStack component(int id) { if ((minefantasy.system.cfg.hardcoreHafts) && ((id == 59) || (id == 65) || (id == 81) || (id == 83) || (id == 77))) {
/* 1389 */       return new ItemStack(misc, 1, 59);
/*      */     }
/* 1391 */     return new ItemStack(misc, 1, id); }
/*      */   
/*      */   public static final int platingSteel = 117;
/*      */   public static final int platingDragon = 118;
/*      */   public static final int smlPlateDragon = 119; public static final int curvedPlateDragon = 120; public static final int lumpBronze = 122; public static final int lumpSteel = 123; public static final int lumpMithril = 124; public static final int buckle = 125; public static final int stickEbony = 126; public static final int arrowheadBronze = 127; public static final int arrowheadIron = 128; public static final int arrowheadSteel = 129; public static final int arrowheadMithril = 130;
/* 1396 */   public static ItemStack component(int id, int val) { return new ItemStack(misc, val, id); }
/*      */   
/*      */   public static final int arrowheadSilver = 131;
/*      */   public static final int arrowheadEncrusted = 132;
/*      */   public static final int arrowheadDragonforge = 133; public static final int arrowheadIgnotumite = 134; public static final int broadheadBronze = 135; public static final int broadheadIron = 136; public static final int broadheadSteel = 137; public static final int broadheadMithril = 138; public static final int broadheadSilver = 139; public static final int broadheadEncrusted = 140; public static final int broadheadDragonforge = 141;
/* 1401 */   private static void addChestGen() { ChestGenHooks.addItem("bonusChest", new WeightedRandomChestContent(new ItemStack(pickBronze), 1, 1, 10));
/* 1402 */     ChestGenHooks.addItem("bonusChest", new WeightedRandomChestContent(new ItemStack(sawBronze), 1, 1, 20));
/*      */     
/* 1404 */     ChestGenHooks.addItem("villageBlacksmith", new WeightedRandomChestContent(new ItemStack(apronSmithy), 1, 1, 30));
/* 1405 */     ChestGenHooks.addItem("villageBlacksmith", new WeightedRandomChestContent(component(60), 1, 4, 30));
/*      */     
/* 1407 */     ChestGenHooks.addItem("mineshaftCorridor", new WeightedRandomChestContent(new ItemStack(pickIronForged), 1, 1, 2));
/* 1408 */     ChestGenHooks.addItem("mineshaftCorridor", new WeightedRandomChestContent(component(56), 1, 4, 5));
/* 1409 */     ChestGenHooks.addItem("mineshaftCorridor", new WeightedRandomChestContent(component(57), 1, 4, 3));
/* 1410 */     ChestGenHooks.addItem("mineshaftCorridor", new WeightedRandomChestContent(new ItemStack(minefantasy.MineFantasyBase.MFBlockOreCopper), 1, 4, 6));
/* 1411 */     ChestGenHooks.addItem("mineshaftCorridor", new WeightedRandomChestContent(new ItemStack(minefantasy.MineFantasyBase.MFBlockOreTin), 1, 4, 3));
/*      */     
/* 1413 */     ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(swordOrnate), 1, 1, 2));
/* 1414 */     ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(daggerOrnate), 1, 1, 1));
/* 1415 */     ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(broadOrnate), 1, 1, 1));
/* 1416 */     ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(greatswordOrnate), 1, 1, 1));
/* 1417 */     ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(waraxeOrnate), 1, 1, 1));
/* 1418 */     ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(battleaxeOrnate), 1, 1, 1));
/* 1419 */     ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(maceOrnate), 1, 1, 1));
/* 1420 */     ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(greatmaceOrnate), 1, 1, 1));
/* 1421 */     ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(spearOrnate), 1, 1, 1));
/* 1422 */     ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(lanceOrnate), 1, 1, 1));
/*      */     
/* 1424 */     ChestGenHooks.addItem("pyramidDesertyChest", new WeightedRandomChestContent(component(167), 1, 4, 2));
/* 1425 */     ChestGenHooks.addItem("pyramidJungleChest", new WeightedRandomChestContent(component(167), 1, 4, 1));
/* 1426 */     ChestGenHooks.addItem("strongholdCrossing", new WeightedRandomChestContent(component(167), 1, 4, 2)); }
/*      */   
/*      */   public static final int broadheadIgnotumite = 142;
/*      */   public static final int bodkinheadBronze = 143; public static final int bodkinheadIron = 144; public static final int bodkinheadSteel = 145; public static final int bodkinheadMithril = 146; public static final int bodkinheadSilver = 147; public static final int bodkinheadEncrusted = 148; public static final int bodkinheadDragonforge = 149;
/* 1430 */   public static void addDispenserBehavior(Item item, net.minecraft.dispenser.IBehaviorDispenseItem behavior) { net.minecraft.block.BlockDispenser.field_82527_a.func_82595_a(item, behavior); }
/*      */   
/*      */   public static final int bodkinheadIgnotumite = 150;
/*      */   public static final int twine = 151;
/*      */   public static final int hunkIgnotumite = 152;
/*      */   public static final int ingotIgnotumite = 153;
/*      */   public static final int hideHorse = 154;
/*      */   public static final int hideBasiliskBlue = 157;
/*      */   public static final int hideBasiliskBrown = 160;
/*      */   public static final int hideBasiliskBlack = 163;
/*      */   public static final int nuggetSteel = 166;
/*      */   public static final int ingotGoldPure = 167;
/*      */   public static final int scaleGuilded = 168;
/*      */   public static final int linkGuilded = 169;
/*      */   public static final int chainGuilded = 170;
/*      */   public static final int splintGuilded = 171;
/*      */   public static final int smlPlateSilver = 172;
/*      */   public static final int platingSilver = 173;
/*      */   public static final int curvedPlateSilver = 174;
/*      */   public static final int shrapnel = 176;
/*      */   public static final int nitre = 177;
/*      */   public static final int scaleDeepIron = 178;
/*      */   public static final int linkDeepIron = 179;
/*      */   public static final int chainDeepIron = 180;
/*      */   public static final int splintDeepIron = 181;
/*      */   public static final int platingDeepIron = 182;
/*      */   public static final int curvedPlateDeepIron = 183;
/*      */   public static final int smlPlateDeepIron = 184;
/*      */   public static final int ingotDeepIron = 185;
/*      */   public static final int lumpDeepIron = 186;
/*      */   public static final int bodkinheadDeepIron = 187;
/*      */   public static final int broadheadDeepIron = 188;
/*      */   public static final int arrowheadDeepIron = 189;
/*      */   public static final int hideGeneric = 190;
/*      */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/ItemListMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */