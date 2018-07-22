/*    */ package minefantasy.system;
/*    */ 
/*    */ import minefantasy.MineFantasyBase;
/*    */ import minefantasy.api.Components;
/*    */ import minefantasy.item.ItemListMF;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.stats.Achievement;
/*    */ import net.minecraftforge.common.AchievementPage;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AchivementMF
/*    */ {
/* 19 */   public static final Achievement AchievementCopper = new Achievement(cfg.achCopper, "minefantasy.copper", 0, 1, new ItemStack(ItemListMF.misc, 1, 56), null).func_75985_c();
/* 20 */   public static final Achievement AchievementTin = new Achievement(cfg.achTin, "minefantasy.tin", 0, -1, new ItemStack(ItemListMF.misc, 1, 57), AchievementCopper).func_75985_c();
/* 21 */   public static final Achievement AchievementBronze = new Achievement(cfg.achBronze, "minefantasy.bronze", 2, 0, new ItemStack(ItemListMF.misc, 1, 58), AchievementCopper).func_75985_c();
/* 22 */   public static final Achievement AchievementIron = new Achievement(cfg.achIron, "minefantasy.iron", 4, 0, new ItemStack(ItemListMF.misc, 1, 60), AchievementBronze).func_75985_c();
/* 23 */   public static final Achievement AchievementGranite = new Achievement(cfg.achGranite, "minefantasy.granite", 5, -1, MineFantasyBase.MFBlockGranite, AchievementIron).func_75985_c();
/* 24 */   public static final Achievement AchievementSteel = new Achievement(cfg.achSteel, "minefantasy.steel", 6, 0, ItemListMF.ingotSteel, AchievementGranite).func_75985_c();
/* 25 */   public static final Achievement AchievementEncrust = new Achievement(cfg.achEncrust, "minefantasy.encrust", 7, 1, ItemListMF.pickEncrusted, AchievementSteel).func_75985_c();
/* 26 */   public static final Achievement AchievementMithril = new Achievement(cfg.achMithril, "minefantasy.mithril", 8, -1, MineFantasyBase.MFBlockOreMythic, AchievementEncrust).func_75985_c();
/*    */   
/* 28 */   public static final Achievement AchievementTanner = new Achievement(cfg.achTanner, "minefantasy.tanner", 0, 3, MineFantasyBase.MFBlockTanner, null).func_75985_c();
/* 29 */   public static final Achievement AchievementAlloy = new Achievement(cfg.achAlloy, "minefantasy.alloy", 2, 3, new ItemStack(MineFantasyBase.MFBlockSmelter, 1, 1), null).func_75985_c();
/* 30 */   public static final Achievement AchievementAnvil = new Achievement(cfg.achAnvil, "minefantasy.anvil", 4, 3, new ItemStack(MineFantasyBase.MFBlockAnvil), null).func_75985_c();
/*    */   
/* 32 */   public static final Achievement AchievementForged = new Achievement(cfg.achForge, "minefantasy.forged", 3, 5, ItemListMF.hammerIron, AchievementAnvil).func_75985_c();
/* 33 */   public static final Achievement AchievementBomb = new Achievement(cfg.achBomb, "minefantasy.bomb", 3, 6, ItemListMF.bombMF, AchievementAnvil).func_75985_c();
/* 34 */   public static final Achievement AchievementPlate = new Achievement(cfg.achPlate, "minefantasy.plate", 3, 7, ItemListMF.helmetSteelPlate, AchievementAnvil).func_75985_c();
/* 35 */   public static final Achievement AchievementArrow = new Achievement(cfg.achArrow, "minefantasy.arrow", 3, 8, new ItemStack(ItemListMF.arrowMF, 1, 9), AchievementAnvil).func_75985_c();
/* 36 */   public static final Achievement AchievementTripleKill = new Achievement(cfg.achTriplekill, "minefantasy.triplekill", 1, 8, new ItemStack(ItemListMF.arrowMF, 1, 9), AchievementAnvil).func_75985_c().func_75987_b();
/*    */   
/* 38 */   public static final Achievement AchievementUmite = new Achievement(cfg.achSuperore, "minefantasy.ignotumite", 8, -3, Components.component(152), AchievementMithril).func_75985_c();
/* 39 */   public static final Achievement AchievementDragonslayer = new Achievement(cfg.achDragon, "minefantasy.dragonslayer", -2, 0, new ItemStack(ItemListMF.misc, 1, 19), null).func_75985_c();
/* 40 */   public static final Achievement AchievementDragonforger = new Achievement(cfg.achDragoningot, "minefantasy.dragonforger", -2, -2, new ItemStack(ItemListMF.misc, 1, 22), AchievementDragonslayer).func_75985_c();
/*    */   
/* 42 */   public static final Achievement[] AchievementListMinefantast = { AchievementCopper, AchievementTin, AchievementAlloy, AchievementBronze, AchievementTanner, AchievementAnvil, AchievementForged, AchievementPlate, AchievementMithril, AchievementEncrust, AchievementBomb, AchievementArrow, AchievementIron, AchievementSteel, AchievementGranite, AchievementUmite, AchievementDragonslayer, AchievementDragonforger, AchievementTripleKill };
/*    */   
/*    */ 
/*    */   public static void init() {}
/*    */   
/*    */ 
/*    */   public static void register()
/*    */   {
/* 50 */     AchievementPage AchievementPageMinefantasy = new AchievementPage("MineFantasy", AchievementListMinefantast);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/AchivementMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */