/*      */ package minefantasy.system;
/*      */ 
/*      */ import cpw.mods.fml.common.registry.GameRegistry;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import minefantasy.MineFantasyBase;
/*      */ import minefantasy.api.MineFantasyAPI;
/*      */ import minefantasy.api.forge.ItemHandler;
/*      */ import minefantasy.api.refine.FluxItem;
/*      */ import minefantasy.item.ItemListMF;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraftforge.oredict.OreDictionary;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class AnvilRecipesMF
/*      */ {
/*      */   public static void initiate()
/*      */   {
/*   28 */     addArmour();
/*   29 */     addRepair();
/*   30 */     addMisc();
/*   31 */     MineFantasyAPI.addCrushRecipe(new RecipeBloom());
/*   32 */     addTools();
/*   33 */     addFurnaces();
/*   34 */     addHound();
/*   35 */     addBows();
/*   36 */     addCrossbows();
/*      */     
/*      */ 
/*   39 */     for (ItemStack ore : OreDictionary.getOres("ingotTin")) {
/*   40 */       MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.tinderbox), 0, -1, 200, new Object[] { "WFW", " I ", Character.valueOf('I'), ore, Character.valueOf('W'), Item.field_77669_D, Character.valueOf('F'), Item.field_77804_ap });
/*      */     }
/*      */     
/*      */ 
/*   44 */     for (ItemStack ore : OreDictionary.getOres("ingotBronze")) {
/*   45 */       addBronze(ore);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*   50 */     ItemStack ore = com(60);
/*   51 */     addIron(com(60));
/*      */     
/*      */ 
/*   54 */     ArrayList<ItemStack> Steel = OreDictionary.getOres("ingotSteel");
/*   55 */     for (int a = 0; a < Steel.size(); a++) {
/*   56 */       addSteel((ItemStack)Steel.get(a));
/*      */     }
/*      */     
/*      */ 
/*   60 */     for (ItemStack silver : OreDictionary.getOres("ingotSilver")) {
/*   61 */       addSilver(silver);
/*      */     }
/*      */     
/*      */ 
/*   65 */     for (ItemStack deep : OreDictionary.getOres("ingotDeepIron")) {
/*   66 */       addDeepIron(deep);
/*      */     }
/*      */     
/*   69 */     for (ItemStack mith : OreDictionary.getOres("ingotMithril")) {
/*   70 */       addMithril(mith);
/*      */     }
/*      */     
/*   73 */     addDragonforge(com(22));
/*   74 */     MineFantasyAPI.addCraftableFlux(com(66), 4);
/*   75 */     MineFantasyAPI.addCraftableFlux(new ItemStack(Item.field_94583_ca), 8);
/*   76 */     for (int a = 0; a < ItemHandler.fluxes.size(); a++) {
/*   77 */       FluxItem flux = (FluxItem)ItemHandler.fluxes.get(a);
/*   78 */       MineFantasyAPI.addCrushRecipe(flux.fluxItem, com(0, flux.fluxOut));
/*      */     }
/*   80 */     MineFantasyAPI.addCrushRecipe(com(152), com(50));
/*   81 */     MineFantasyAPI.addCrushRecipe(new ItemStack(Item.field_77804_ap), com(176));
/*      */   }
/*      */   
/*      */   private static ItemStack com(int id)
/*      */   {
/*   86 */     return com(id, 1);
/*      */   }
/*      */   
/*      */   private static ItemStack com(int id, int num) {
/*   90 */     return new ItemStack(ItemListMF.misc, num, id);
/*      */   }
/*      */   
/*      */   private static void addArmour()
/*      */   {
/*   95 */     MineFantasyAPI.addAnvilRecipe(com(116), 0, 1, ironTime, new Object[] { "CC", "CC", Character.valueOf('C'), com(13) });
/*   96 */     MineFantasyAPI.addAnvilRecipe(com(170), 0, 1, steelTime, new Object[] { "CC", "CC", Character.valueOf('C'), com(169) });
/*   97 */     MineFantasyAPI.addAnvilRecipe(com(41), 0, 2, steelTime, new Object[] { "CC", "CC", Character.valueOf('C'), com(40) });
/*   98 */     MineFantasyAPI.addAnvilRecipe(com(180), 0, 3, deepIronTime, new Object[] { "CC", "CC", Character.valueOf('C'), com(179) });
/*   99 */     MineFantasyAPI.addAnvilRecipe(com(43), 0, 3, mithrilTime, new Object[] { "CC", "CC", Character.valueOf('C'), com(42) });
/*  100 */     MineFantasyAPI.addAnvilRecipe(com(45), 1, 2, dragonforgeTime, new Object[] { "CC", "CC", Character.valueOf('C'), com(44) });
/*      */     
/*      */ 
/*  103 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.helmetBronzeChain), 0, 0, bronzeTime * 2, new Object[] { "CCC", "C C", Character.valueOf('C'), com(76) });
/*  104 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.plateBronzeChain), 0, 0, bronzeTime * 4, new Object[] { "C C", "CCC", "CCC", Character.valueOf('C'), com(76) });
/*  105 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.legsBronzeChain), 0, 0, bronzeTime * 3, new Object[] { "CCC", "C C", "C C", Character.valueOf('C'), com(76) });
/*  106 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bootsBronzeChain), 0, 0, bronzeTime * 1, new Object[] { "C C", "C C", Character.valueOf('C'), com(76) });
/*      */     
/*      */ 
/*  109 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(Item.field_77694_Z), 0, 1, ironTime * 2, new Object[] { "CCC", "C C", Character.valueOf('C'), com(116) });
/*  110 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(Item.field_77814_aa), 0, 1, ironTime * 4, new Object[] { "C C", "CCC", "CCC", Character.valueOf('C'), com(116) });
/*  111 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(Item.field_77816_ab), 0, 1, ironTime * 3, new Object[] { "CCC", "C C", "C C", Character.valueOf('C'), com(116) });
/*  112 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(Item.field_77810_ac), 0, 1, ironTime * 1, new Object[] { "C C", "C C", Character.valueOf('C'), com(116) });
/*      */     
/*      */ 
/*  115 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.helmetGuildedChain), 0, 1, ironTime * 2, new Object[] { "CCC", "C C", Character.valueOf('C'), com(170) });
/*  116 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.plateGuildedChain), 0, 1, ironTime * 4, new Object[] { "C C", "CCC", "CCC", Character.valueOf('C'), com(170) });
/*  117 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.legsGuildedChain), 0, 1, ironTime * 3, new Object[] { "CCC", "C C", "C C", Character.valueOf('C'), com(170) });
/*  118 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bootsGuildedChain), 0, 1, ironTime * 1, new Object[] { "C C", "C C", Character.valueOf('C'), com(170) });
/*      */     
/*      */ 
/*  121 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.helmetSteelChain), 0, 2, steelTime * 2, new Object[] { "CCC", "C C", Character.valueOf('C'), com(41) });
/*  122 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.plateSteelChain), 0, 2, steelTime * 4, new Object[] { "C C", "CCC", "CCC", Character.valueOf('C'), com(41) });
/*  123 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.legsSteelChain), 0, 2, steelTime * 3, new Object[] { "CCC", "C C", "C C", Character.valueOf('C'), com(41) });
/*  124 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bootsSteelChain), 0, 2, steelTime * 1, new Object[] { "C C", "C C", Character.valueOf('C'), com(41) });
/*      */     
/*      */ 
/*  127 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.helmetDeepIronChain), 0, 3, deepIronTime * 2, new Object[] { "CCC", "C C", Character.valueOf('C'), com(180) });
/*  128 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.plateDeepIronChain), 0, 3, deepIronTime * 4, new Object[] { "C C", "CCC", "CCC", Character.valueOf('C'), com(180) });
/*  129 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.legsDeepIronChain), 0, 3, deepIronTime * 3, new Object[] { "CCC", "C C", "C C", Character.valueOf('C'), com(180) });
/*  130 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bootsDeepIronChain), 0, 3, deepIronTime * 1, new Object[] { "C C", "C C", Character.valueOf('C'), com(180) });
/*      */     
/*      */ 
/*  133 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.helmetMithrilChain), 0, 3, mithrilTime * 2, new Object[] { "CCC", "C C", Character.valueOf('C'), com(43) });
/*  134 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.plateMithrilChain), 0, 3, mithrilTime * 4, new Object[] { "C C", "CCC", "CCC", Character.valueOf('C'), com(43) });
/*  135 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.legsMithrilChain), 0, 3, mithrilTime * 3, new Object[] { "CCC", "C C", "C C", Character.valueOf('C'), com(43) });
/*  136 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bootsMithrilChain), 0, 3, mithrilTime * 1, new Object[] { "C C", "C C", Character.valueOf('C'), com(43) });
/*      */     
/*      */ 
/*  139 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.helmetDragonChain), 1, 2, dragonforgeTime * 2, new Object[] { "CCC", "C C", Character.valueOf('C'), com(45) });
/*  140 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.plateDragonChain), 1, 2, dragonforgeTime * 4, new Object[] { "C C", "CCC", "CCC", Character.valueOf('C'), com(45) });
/*  141 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.legsDragonChain), 1, 2, dragonforgeTime * 3, new Object[] { "CCC", "C C", "C C", Character.valueOf('C'), com(45) });
/*  142 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bootsDragonChain), 1, 2, dragonforgeTime * 1, new Object[] { "C C", "C C", Character.valueOf('C'), com(45) });
/*      */     
/*      */ 
/*  145 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.plateBronzeScale), 0, 0, (int)(bronzeTime * 0.75D * 2.0D), new Object[] { "AL LA", "ALLLA", "ALLLA", "AAAAA", Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('A'), com(36) });
/*  146 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.legsBronzeScale), 0, 0, (int)(bronzeTime * 0.75D * 4.0D), new Object[] { " AAA ", "AIIIA", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(36) });
/*  147 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bootsBronzeScale), 0, 0, (int)(bronzeTime * 0.75D * 3.0D), new Object[] { "A   A", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(36) });
/*  148 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.helmetBronzeScale), 0, 0, (int)(bronzeTime * 0.75D * 1.0D), new Object[] { "A   A", "AIIIA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(36) });
/*      */     
/*      */ 
/*  151 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.plateIronScale), 0, 1, (int)(ironTime * 0.75D * 2.0D), new Object[] { "AL LA", "ALLLA", "ALLLA", "AAAAA", Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('A'), com(37) });
/*  152 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.legsIronScale), 0, 1, (int)(ironTime * 0.75D * 4.0D), new Object[] { " AAA ", "AIIIA", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(37) });
/*  153 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bootsIronScale), 0, 1, (int)(ironTime * 0.75D * 3.0D), new Object[] { "A   A", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(37) });
/*  154 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.helmetIronScale), 0, 1, (int)(ironTime * 0.75D * 1.0D), new Object[] { "A   A", "AIIIA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(37) });
/*      */     
/*      */ 
/*  157 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.plateGuildedScale), 0, 1, (int)(ironTime * 0.75D * 2.0D), new Object[] { "AL LA", "ALLLA", "ALLLA", "AAAAA", Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('A'), com(168) });
/*  158 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.legsGuildedScale), 0, 1, (int)(ironTime * 0.75D * 4.0D), new Object[] { " AAA ", "AIIIA", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(168) });
/*  159 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bootsGuildedScale), 0, 1, (int)(ironTime * 0.75D * 3.0D), new Object[] { "A   A", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(168) });
/*  160 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.helmetGuildedScale), 0, 1, (int)(ironTime * 0.75D * 1.0D), new Object[] { "A   A", "AIIIA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(168) });
/*      */     
/*      */ 
/*  163 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.plateSteelScale), 0, 2, (int)(steelTime * 0.75D * 2.0D), new Object[] { "AL LA", "ALLLA", "ALLLA", "AAAAA", Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('A'), com(31) });
/*  164 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.legsSteelScale), 0, 2, (int)(steelTime * 0.75D * 4.0D), new Object[] { " AAA ", "AIIIA", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(31) });
/*  165 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bootsSteelScale), 0, 2, (int)(steelTime * 0.75D * 3.0D), new Object[] { "A   A", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(31) });
/*  166 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.helmetSteelScale), 0, 2, (int)(steelTime * 0.75D * 1.0D), new Object[] { "A   A", "AIIIA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(31) });
/*      */     
/*      */ 
/*  169 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.plateDeepIronScale), 0, 3, (int)(deepIronTime * 0.75D * 2.0D), new Object[] { "AL LA", "ALLLA", "ALLLA", "AAAAA", Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('A'), com(178) });
/*  170 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.legsDeepIronScale), 0, 3, (int)(deepIronTime * 0.75D * 4.0D), new Object[] { " AAA ", "AIIIA", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(178) });
/*  171 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bootsDeepIronScale), 0, 3, (int)(deepIronTime * 0.75D * 3.0D), new Object[] { "A   A", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(178) });
/*  172 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.helmetDeepIronScale), 0, 3, (int)(deepIronTime * 0.75D * 1.0D), new Object[] { "A   A", "AIIIA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(178) });
/*      */     
/*      */ 
/*  175 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.plateMithrilScale), 0, 3, (int)(mithrilTime * 0.75D * 2.0D), new Object[] { "AL LA", "ALLLA", "ALLLA", "AAAAA", Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('A'), com(38) });
/*  176 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.legsMithrilScale), 0, 3, (int)(mithrilTime * 0.75D * 4.0D), new Object[] { " AAA ", "AIIIA", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(38) });
/*  177 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bootsMithrilScale), 0, 3, (int)(mithrilTime * 0.75D * 3.0D), new Object[] { "A   A", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(38) });
/*  178 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.helmetMithrilScale), 0, 3, (int)(mithrilTime * 0.75D * 1.0D), new Object[] { "A   A", "AIIIA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(38) });
/*      */     
/*      */ 
/*  181 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.plateDragonScale), 1, 2, (int)(dragonforgeTime * 0.75D * 2.0D), new Object[] { "AL LA", "ALLLA", "ALLLA", "AAAAA", Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('A'), com(39) });
/*  182 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.legsDragonScale), 1, 2, (int)(dragonforgeTime * 0.75D * 4.0D), new Object[] { " AAA ", "AIIIA", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(39) });
/*  183 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bootsDragonScale), 1, 2, (int)(dragonforgeTime * 0.75D * 3.0D), new Object[] { "A   A", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(39) });
/*  184 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.helmetDragonScale), 1, 2, (int)(dragonforgeTime * 0.75D * 1.0D), new Object[] { "A   A", "AIIIA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(39) });
/*      */     
/*      */ 
/*  187 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.plateBronzeSplint), 0, 0, (int)(bronzeTime * 1.2F * 2.0F), new Object[] { "AL LA", "ALLLA", "ALLLA", "AAAAA", Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('A'), com(1) });
/*  188 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.legsBronzeSplint), 0, 0, (int)(bronzeTime * 1.2F * 4.0F), new Object[] { " AAA ", "AIIIA", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(1) });
/*  189 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bootsBronzeSplint), 0, 0, (int)(bronzeTime * 1.2F * 3.0F), new Object[] { "A   A", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(1) });
/*  190 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.helmetBronzeSplint), 0, 0, (int)(bronzeTime * 1.2F * 1.0F), new Object[] { "A   A", "AIIIA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(1) });
/*      */     
/*      */ 
/*  193 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.plateIronSplint), 0, 1, (int)(ironTime * 1.2F * 2.0F), new Object[] { "AL LA", "ALLLA", "ALLLA", "AAAAA", Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('A'), com(46) });
/*  194 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.legsIronSplint), 0, 1, (int)(ironTime * 1.2F * 4.0F), new Object[] { " AAA ", "AIIIA", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(46) });
/*  195 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bootsIronSplint), 0, 1, (int)(ironTime * 1.2F * 3.0F), new Object[] { "A   A", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(46) });
/*  196 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.helmetIronSplint), 0, 1, (int)(ironTime * 1.2F * 1.0F), new Object[] { "A   A", "AIIIA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(46) });
/*      */     
/*      */ 
/*  199 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.plateGuildedSplint), 0, 1, (int)(ironTime * 1.2F * 2.0F), new Object[] { "AL LA", "ALLLA", "ALLLA", "AAAAA", Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('A'), com(171) });
/*  200 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.legsGuildedSplint), 0, 1, (int)(ironTime * 1.2F * 4.0F), new Object[] { " AAA ", "AIIIA", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(171) });
/*  201 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bootsGuildedSplint), 0, 1, (int)(ironTime * 1.2F * 3.0F), new Object[] { "A   A", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(171) });
/*  202 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.helmetGuildedSplint), 0, 1, (int)(ironTime * 1.2F * 1.0F), new Object[] { "A   A", "AIIIA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(171) });
/*      */     
/*      */ 
/*  205 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.plateSteelSplint), 0, 2, (int)(steelTime * 1.2F * 2.0F), new Object[] { "AL LA", "ALLLA", "ALLLA", "AAAAA", Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('A'), com(30) });
/*  206 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.legsSteelSplint), 0, 2, (int)(steelTime * 1.2F * 4.0F), new Object[] { " AAA ", "AIIIA", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(30) });
/*  207 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bootsSteelSplint), 0, 2, (int)(steelTime * 1.2F * 3.0F), new Object[] { "A   A", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(30) });
/*  208 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.helmetSteelSplint), 0, 2, (int)(steelTime * 1.2F * 1.0F), new Object[] { "A   A", "AIIIA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(30) });
/*      */     
/*      */ 
/*  211 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.plateDeepIronSplint), 0, 3, (int)(deepIronTime * 1.2F * 2.0F), new Object[] { "AL LA", "ALLLA", "ALLLA", "AAAAA", Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('A'), com(181) });
/*  212 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.legsDeepIronSplint), 0, 3, (int)(deepIronTime * 1.2F * 4.0F), new Object[] { " AAA ", "AIIIA", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(181) });
/*  213 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bootsDeepIronSplint), 0, 3, (int)(deepIronTime * 1.2F * 3.0F), new Object[] { "A   A", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(181) });
/*  214 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.helmetDeepIronSplint), 0, 3, (int)(deepIronTime * 1.2F * 1.0F), new Object[] { "A   A", "AIIIA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(181) });
/*      */     
/*      */ 
/*  217 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.plateMithrilSplint), 0, 3, (int)(mithrilTime * 1.2F * 2.0F), new Object[] { "AL LA", "ALLLA", "ALLLA", "AAAAA", Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('A'), com(62) });
/*  218 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.legsMithrilSplint), 0, 3, (int)(mithrilTime * 1.2F * 4.0F), new Object[] { " AAA ", "AIIIA", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(62) });
/*  219 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bootsMithrilSplint), 0, 3, (int)(mithrilTime * 1.2F * 3.0F), new Object[] { "A   A", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(62) });
/*  220 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.helmetMithrilSplint), 0, 3, (int)(mithrilTime * 1.2F * 1.0F), new Object[] { "A   A", "AIIIA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(62) });
/*      */     
/*      */ 
/*  223 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.plateDragonSplint), 1, 2, (int)(dragonforgeTime * 1.2F * 2.0F), new Object[] { "AL LA", "ALLLA", "ALLLA", "AAAAA", Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('A'), com(47) });
/*  224 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.legsDragonSplint), 1, 2, (int)(dragonforgeTime * 1.2F * 4.0F), new Object[] { " AAA ", "AIIIA", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(47) });
/*  225 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bootsDragonSplint), 1, 2, (int)(dragonforgeTime * 1.2F * 3.0F), new Object[] { "A   A", "AI IA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(47) });
/*  226 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.helmetDragonSplint), 1, 2, (int)(dragonforgeTime * 1.2F * 1.0F), new Object[] { "A   A", "AIIIA", "AI IA", Character.valueOf('I'), Item.field_77770_aF, Character.valueOf('A'), com(47) });
/*      */     
/*      */ 
/*  229 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.plateBronzeHvyChain), 0, 0, (int)(bronzeTime * 1.5F * 2.0F), new Object[] { "AL LA", "ALLLA", " LLL ", Character.valueOf('L'), com(76), Character.valueOf('A'), com(72) });
/*  230 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.legsBronzeHvyChain), 0, 0, (int)(bronzeTime * 1.5F * 4.0F), new Object[] { "AIIIA", "AI IA", " I I ", Character.valueOf('I'), com(76), Character.valueOf('A'), com(72) });
/*  231 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bootsBronzeHvyChain), 0, 0, (int)(bronzeTime * 1.5F * 3.0F), new Object[] { "AI IA", "AI IA", Character.valueOf('I'), com(76), Character.valueOf('A'), com(72) });
/*  232 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.helmetBronzeHvyChain), 0, 0, (int)(bronzeTime * 1.5F * 1.0F), new Object[] { "AIIIA", "AI IA", Character.valueOf('I'), com(76), Character.valueOf('A'), com(72) });
/*      */     
/*      */ 
/*  235 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.plateIronHvyChain), 0, 1, (int)(ironTime * 1.5F * 2.0F), new Object[] { "AL LA", "ALLLA", " LLL ", Character.valueOf('L'), com(116), Character.valueOf('A'), com(61) });
/*  236 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.legsIronHvyChain), 0, 1, (int)(ironTime * 1.5F * 4.0F), new Object[] { "AIIIA", "AI IA", " I I ", Character.valueOf('I'), com(116), Character.valueOf('A'), com(61) });
/*  237 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bootsIronHvyChain), 0, 1, (int)(ironTime * 1.5F * 3.0F), new Object[] { "AI IA", "AI IA", Character.valueOf('I'), com(116), Character.valueOf('A'), com(61) });
/*  238 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.helmetIronHvyChain), 0, 1, (int)(ironTime * 1.5F * 1.0F), new Object[] { "AIIIA", "AI IA", Character.valueOf('I'), com(116), Character.valueOf('A'), com(61) });
/*      */     
/*      */ 
/*  241 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.plateSteelHvyChain), 0, 2, (int)(steelTime * 1.5F * 2.0F), new Object[] { "AL LA", "ALLLA", " LLL ", Character.valueOf('L'), com(41), Character.valueOf('A'), com(117) });
/*  242 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.legsSteelHvyChain), 0, 2, (int)(steelTime * 1.5F * 4.0F), new Object[] { "AIIIA", "AI IA", " I I ", Character.valueOf('I'), com(41), Character.valueOf('A'), com(117) });
/*  243 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bootsSteelHvyChain), 0, 2, (int)(steelTime * 1.5F * 3.0F), new Object[] { "AI IA", "AI IA", Character.valueOf('I'), com(41), Character.valueOf('A'), com(117) });
/*  244 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.helmetSteelHvyChain), 0, 2, (int)(steelTime * 1.5F * 1.0F), new Object[] { "AIIIA", "AI IA", Character.valueOf('I'), com(41), Character.valueOf('A'), com(117) });
/*      */     
/*      */ 
/*  247 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.plateGuildedHvyChain), 0, 1, (int)(ironTime * 1.5F * 2.0F), new Object[] { "AL LA", "ALLLA", " LLL ", Character.valueOf('L'), com(170), Character.valueOf('A'), com(173) });
/*  248 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.legsGuildedHvyChain), 0, 1, (int)(ironTime * 1.5F * 4.0F), new Object[] { "AIIIA", "AI IA", " I I ", Character.valueOf('I'), com(170), Character.valueOf('A'), com(173) });
/*  249 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bootsGuildedHvyChain), 0, 1, (int)(ironTime * 1.5F * 3.0F), new Object[] { "AI IA", "AI IA", Character.valueOf('I'), com(170), Character.valueOf('A'), com(173) });
/*  250 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.helmetGuildedHvyChain), 0, 1, (int)(ironTime * 1.5F * 1.0F), new Object[] { "AIIIA", "AI IA", Character.valueOf('I'), com(170), Character.valueOf('A'), com(173) });
/*      */     
/*      */ 
/*  253 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.plateDeepIronHvyChain), 0, 3, (int)(deepIronTime * 1.5F * 2.0F), new Object[] { "AL LA", "ALLLA", " LLL ", Character.valueOf('L'), com(180), Character.valueOf('A'), com(182) });
/*  254 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.legsDeepIronHvyChain), 0, 3, (int)(deepIronTime * 1.5F * 4.0F), new Object[] { "AIIIA", "AI IA", " I I ", Character.valueOf('I'), com(180), Character.valueOf('A'), com(182) });
/*  255 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bootsDeepIronHvyChain), 0, 3, (int)(deepIronTime * 1.5F * 3.0F), new Object[] { "AI IA", "AI IA", Character.valueOf('I'), com(180), Character.valueOf('A'), com(182) });
/*  256 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.helmetDeepIronHvyChain), 0, 3, (int)(deepIronTime * 1.5F * 1.0F), new Object[] { "AIIIA", "AI IA", Character.valueOf('I'), com(180), Character.valueOf('A'), com(182) });
/*      */     
/*      */ 
/*  259 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.plateMithrilHvyChain), 0, 3, (int)(mithrilTime * 1.5F * 2.0F), new Object[] { "AL LA", "ALLLA", " LLL ", Character.valueOf('L'), com(43), Character.valueOf('A'), com(95) });
/*  260 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.legsMithrilHvyChain), 0, 3, (int)(mithrilTime * 1.5F * 4.0F), new Object[] { "AIIIA", "AI IA", " I I ", Character.valueOf('I'), com(43), Character.valueOf('A'), com(95) });
/*  261 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bootsMithrilHvyChain), 0, 3, (int)(mithrilTime * 1.5F * 3.0F), new Object[] { "AI IA", "AI IA", Character.valueOf('I'), com(43), Character.valueOf('A'), com(95) });
/*  262 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.helmetMithrilHvyChain), 0, 3, (int)(mithrilTime * 1.5F * 1.0F), new Object[] { "AIIIA", "AI IA", Character.valueOf('I'), com(43), Character.valueOf('A'), com(95) });
/*      */     
/*      */ 
/*  265 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.plateDragonHvyChain), 1, 2, (int)(dragonforgeTime * 1.5F * 2.0F), new Object[] { "AL LA", "ALLLA", " LLL ", Character.valueOf('L'), com(45), Character.valueOf('A'), com(118) });
/*  266 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.legsDragonHvyChain), 1, 2, (int)(dragonforgeTime * 1.5F * 4.0F), new Object[] { "AIIIA", "AI IA", " I I ", Character.valueOf('I'), com(45), Character.valueOf('A'), com(118) });
/*  267 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bootsDragonHvyChain), 1, 2, (int)(dragonforgeTime * 1.5F * 3.0F), new Object[] { "AI IA", "AI IA", Character.valueOf('I'), com(45), Character.valueOf('A'), com(118) });
/*  268 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.helmetDragonHvyChain), 1, 2, (int)(dragonforgeTime * 1.5F * 1.0F), new Object[] { "AIIIA", "AI IA", Character.valueOf('I'), com(45), Character.valueOf('A'), com(118) });
/*      */   }
/*      */   
/*      */   private static void addSilver(ItemStack silver)
/*      */   {
/*  273 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.misc, 16, 168), 0, 1, 1100, new Object[] { "MGM", " M ", Character.valueOf('G'), com(167), Character.valueOf('M'), silver });
/*      */     
/*  275 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.misc, 8, 171), 0, 1, 1200, new Object[] { "G", "M", "M", "M", Character.valueOf('G'), com(167), Character.valueOf('M'), silver });
/*      */     
/*  277 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.misc, 24, 169), 0, 1, 1100, new Object[] { " M ", "MGM", " M ", Character.valueOf('G'), com(167), Character.valueOf('M'), silver });
/*      */     
/*  279 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hammerOrnate), true, 0, 1, 1200, new Object[] { "L", "S", "I", Character.valueOf('I'), com(81), Character.valueOf('S'), silver, Character.valueOf('L'), new ItemStack(Item.field_77756_aW, 1, 4) });
/*      */     
/*  281 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.maceOrnate), true, 0, 1, 4500, new Object[] { "AAMM", "PPDM", "AAAA", Character.valueOf('P'), haft(5), Character.valueOf('M'), silver, Character.valueOf('D'), new ItemStack(Item.field_77756_aW, 1, 4) });
/*      */     
/*  283 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.maceOrnate), true, 0, 1, 4500, new Object[] { "AAAA", "PPDM", "AAMM", Character.valueOf('P'), haft(5), Character.valueOf('M'), silver, Character.valueOf('D'), new ItemStack(Item.field_77756_aW, 1, 4) });
/*      */     
/*  285 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.warpickOrnate), true, 0, 1, 4500, new Object[] { "AAMM", "PPDM", "AAAM", Character.valueOf('P'), haft(5), Character.valueOf('M'), silver, Character.valueOf('D'), new ItemStack(Item.field_77756_aW, 1, 4) });
/*  286 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.warpickOrnate), true, 0, 1, 4500, new Object[] { "AAAM", "PPDM", "AAMM", Character.valueOf('P'), haft(5), Character.valueOf('M'), silver, Character.valueOf('D'), new ItemStack(Item.field_77756_aW, 1, 4) });
/*      */     
/*  288 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.spearOrnate), true, 0, 1, 4500, new Object[] { "AAAAMA", "PPPPPD", "AAAAMA", Character.valueOf('P'), haft(5), Character.valueOf('M'), silver, Character.valueOf('G'), Item.field_77717_p, Character.valueOf('D'), new ItemStack(Item.field_77756_aW, 1, 4) });
/*      */     
/*  290 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.halbeardOrnate), true, 0, 1, 5000, new Object[] { "AAAAMA", "PPPPPD", "AAAAMM", Character.valueOf('P'), haft(5), Character.valueOf('M'), silver, Character.valueOf('G'), Item.field_77717_p, Character.valueOf('D'), new ItemStack(Item.field_77756_aW, 1, 4) });
/*  291 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.halbeardOrnate), true, 0, 1, 5000, new Object[] { "AAAAMM", "PPPPPD", "AAAAMA", Character.valueOf('P'), haft(5), Character.valueOf('M'), silver, Character.valueOf('G'), Item.field_77717_p, Character.valueOf('D'), new ItemStack(Item.field_77756_aW, 1, 4) });
/*      */     
/*  293 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.waraxeOrnate), true, 0, 1, 4000, new Object[] { "AMM", "PPD", "AAG", Character.valueOf('P'), haft(5), Character.valueOf('M'), silver, Character.valueOf('G'), Item.field_77717_p, Character.valueOf('D'), new ItemStack(Item.field_77756_aW, 1, 4) });
/*  294 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.waraxeOrnate), true, 0, 1, 4000, new Object[] { "AAG", "PPD", "AMM", Character.valueOf('P'), haft(5), Character.valueOf('M'), silver, Character.valueOf('G'), Item.field_77717_p, Character.valueOf('D'), new ItemStack(Item.field_77756_aW, 1, 4) });
/*      */     
/*  296 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.broadOrnate), true, 0, 1, 3000, new Object[] { "AGMM", "PDMM", "AGAA", Character.valueOf('P'), haft(5), Character.valueOf('M'), silver, Character.valueOf('G'), Item.field_77717_p, Character.valueOf('D'), new ItemStack(Item.field_77756_aW, 1, 4) });
/*      */     
/*  298 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.broadOrnate), true, 0, 1, 4000, new Object[] { "AGAA", "PDMM", "AGMM", Character.valueOf('P'), haft(5), Character.valueOf('M'), silver, Character.valueOf('G'), Item.field_77717_p, Character.valueOf('D'), new ItemStack(Item.field_77756_aW, 1, 4) });
/*      */     
/*  300 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.swordOrnate), true, 0, 1, 4000, new Object[] { "AGAA", "PDMM", "AGAA", Character.valueOf('P'), haft(5), Character.valueOf('M'), silver, Character.valueOf('G'), Item.field_77717_p, Character.valueOf('D'), new ItemStack(Item.field_77756_aW, 1, 4) });
/*      */     
/*  302 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.daggerOrnate), true, 0, 1, 1500, new Object[] { "PDMA", Character.valueOf('P'), haft(5), Character.valueOf('M'), silver, Character.valueOf('G'), Item.field_77717_p, Character.valueOf('D'), new ItemStack(Item.field_77756_aW, 1, 4) });
/*      */     
/*  304 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.lanceOrnate), true, 0, 1, 12000, new Object[] { "  G     ", "GGPDMMMM", "  G     ", Character.valueOf('P'), haft(5), Character.valueOf('M'), silver, Character.valueOf('G'), Item.field_77717_p, Character.valueOf('D'), new ItemStack(Item.field_77756_aW, 1, 4) });
/*      */     
/*  306 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.greatswordOrnate), true, 0, 1, 6000, new Object[] { " G    ", "PDMMMM", " G    ", Character.valueOf('P'), haft(5), Character.valueOf('M'), silver, Character.valueOf('G'), Item.field_77717_p, Character.valueOf('D'), new ItemStack(Item.field_77756_aW, 1, 4) });
/*      */     
/*  308 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.greatmaceOrnate), true, 0, 1, 1500, new Object[] { "AAAAAAA", "GPPPPDM", "AAAAAMM", Character.valueOf('P'), haft(5), Character.valueOf('M'), silver, Character.valueOf('G'), Item.field_77717_p, Character.valueOf('D'), new ItemStack(Item.field_77756_aW, 1, 4) });
/*      */     
/*  310 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.greatmaceOrnate), true, 0, 1, 1500, new Object[] { "AAAAAMM", "GPPPPDM", "AAAAAAA", Character.valueOf('P'), haft(5), Character.valueOf('M'), silver, Character.valueOf('G'), Item.field_77717_p, Character.valueOf('D'), new ItemStack(Item.field_77756_aW, 1, 4) });
/*      */     
/*  312 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.warhammerOrnate), true, 0, 1, 2000, new Object[] { "AAAAAAM", "GPPPPDM", "AAAAAMM", Character.valueOf('P'), haft(5), Character.valueOf('M'), silver, Character.valueOf('G'), Item.field_77717_p, Character.valueOf('D'), new ItemStack(Item.field_77756_aW, 1, 4) });
/*      */     
/*  314 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.warhammerOrnate), true, 0, 1, 2000, new Object[] { "AAAAAMM", "GPPPPDM", "AAAAAAM", Character.valueOf('P'), haft(5), Character.valueOf('M'), silver, Character.valueOf('G'), Item.field_77717_p, Character.valueOf('D'), new ItemStack(Item.field_77756_aW, 1, 4) });
/*      */     
/*  316 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.battleaxeOrnate), true, 0, 1, 2500, new Object[] { "AAAAMM", "GPPPPD", "AAAAMM", Character.valueOf('P'), haft(5), Character.valueOf('M'), silver, Character.valueOf('G'), Item.field_77717_p, Character.valueOf('D'), new ItemStack(Item.field_77756_aW, 1, 4) });
/*      */     
/*  318 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hound_Oteeth), true, 0, 1, 1500, new Object[] { "SB ", " GD", "SB ", Character.valueOf('B'), com(27), Character.valueOf('S'), silver, Character.valueOf('G'), Item.field_77717_p, Character.valueOf('D'), new ItemStack(Item.field_77756_aW, 1, 4) });
/*      */     
/*  320 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bowOrnate), true, 0, 1, 1250, new Object[] { "GSSG", "M  M", "DLLD", Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('S'), Item.field_77683_K, Character.valueOf('M'), silver, Character.valueOf('G'), Item.field_77717_p, Character.valueOf('D'), new ItemStack(Item.field_77756_aW, 1, 4) });
/*      */     
/*  322 */     if (bg()) {
/*  323 */       MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bucklerGuilded), true, 0, 2, ironTime, new Object[] { " G ", "SLS", " S ", Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('S'), silver, Character.valueOf('G'), com(167) });
/*      */       
/*  325 */       MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.kiteGuilded), true, 0, 2, ironTime * 3, new Object[] { "G G", "SWS", " S ", Character.valueOf('W'), new ItemStack(MineFantasyBase.MFBlockPlanks, 1, 1), Character.valueOf('S'), silver, Character.valueOf('G'), com(167) });
/*      */       
/*  327 */       MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.towerGuilded), true, 0, 2, ironTime * 5, new Object[] { "SSS", "GWG", "GWG", "SSS", Character.valueOf('W'), new ItemStack(MineFantasyBase.MFBlockPlanks, 1, 1), Character.valueOf('S'), silver, Character.valueOf('G'), com(167) });
/*      */     }
/*      */   }
/*      */   
/*      */   private static void addSteel(ItemStack ore) {
/*  332 */     addEncrusted(ore);
/*      */     
/*  334 */     MineFantasyAPI.addAnvilRecipe(com(123, 4), false, 0, 2, 400, new Object[] { "I", Character.valueOf('I'), ore });
/*      */     
/*  336 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(MineFantasyBase.MFBlockDogbowl, 1, 2), false, 0, 2, 1000, new Object[] { "IBI", " I ", Character.valueOf('I'), ore, Character.valueOf('B'), Item.field_77670_E });
/*      */     
/*  338 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hammerRepair2), true, 0, 1, 500, new Object[] { "PLMM", "AAMM", Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('P'), ItemListMF.plank, Character.valueOf('M'), ore });
/*      */     
/*  340 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hammerRepair2), true, 0, 1, 500, new Object[] { "AAMM", "PLMM", Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('P'), ItemListMF.plank, Character.valueOf('M'), ore });
/*      */     
/*  342 */     for (ItemStack block : OreDictionary.getOres("blockSteel")) {
/*  343 */       MineFantasyAPI.addAnvilRecipe(new ItemStack(MineFantasyBase.MFBlockAnvil, 1, 6), true, 0, 1, 1800, new Object[] { " BB", "III", " I ", Character.valueOf('I'), ore, Character.valueOf('B'), block });
/*      */     }
/*      */     
/*  346 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.misc, 16, 31), 0, 2, 1600, new Object[] { "MMM", " M ", Character.valueOf('M'), ore });
/*      */     
/*  348 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.misc, 8, 30), 0, 2, 1600, new Object[] { "M", "M", "M", "M", Character.valueOf('M'), ore });
/*      */     
/*  350 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.misc, 24, 40), 0, 2, 1200, new Object[] { " M ", "M M", " M ", Character.valueOf('M'), ore });
/*      */   }
/*      */   
/*      */   private static void addEncrusted(ItemStack steel)
/*      */   {
/*  355 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.axeEncrusted), true, 0, 2, 2700, new Object[] { "ADDA", "AMMD", "PPMA", "AAAA", Character.valueOf('P'), haft(2), Character.valueOf('M'), steel, Character.valueOf('D'), Item.field_77702_n });
/*      */     
/*  357 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.waraxeEncrusted), true, 0, 2, 3600, new Object[] { "ADD", "PPM", "AAM", Character.valueOf('P'), haft(2), Character.valueOf('D'), Item.field_77702_n, Character.valueOf('M'), steel });
/*  358 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.waraxeEncrusted), true, 0, 2, 3600, new Object[] { "AAM", "PPM", "ADD", Character.valueOf('P'), haft(2), Character.valueOf('D'), Item.field_77702_n, Character.valueOf('M'), steel });
/*      */     
/*  360 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.spearEncrusted), true, 0, 2, 2700, new Object[] { "AAAAMD", "PPPPPM", "AAAAMD", Character.valueOf('P'), haft(2), Character.valueOf('M'), steel, Character.valueOf('D'), Item.field_77702_n });
/*      */     
/*  362 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.halbeardEncrusted), true, 0, 2, 3100, new Object[] { "AAAAMD", "PPPPPM", "AAAADD", Character.valueOf('P'), haft(2), Character.valueOf('M'), steel, Character.valueOf('D'), Item.field_77702_n });
/*  363 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.halbeardEncrusted), true, 0, 2, 3100, new Object[] { "AAAADD", "PPPPPM", "AAAAMD", Character.valueOf('P'), haft(2), Character.valueOf('M'), steel, Character.valueOf('D'), Item.field_77702_n });
/*      */     
/*  365 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.axeEncrusted), true, 0, 2, 2700, new Object[] { "AAAA", "PPMA", "AMMD", "ADDA", Character.valueOf('P'), haft(2), Character.valueOf('M'), steel, Character.valueOf('D'), Item.field_77702_n });
/*      */     
/*      */ 
/*  368 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.spadeEncrusted), true, 0, 2, 900, new Object[] { "AAAA", "PPMD", "AAAA", Character.valueOf('P'), haft(2), Character.valueOf('M'), steel, Character.valueOf('D'), Item.field_77702_n });
/*      */     
/*  370 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hound_Eteeth), true, 0, 2, (int)(encrustedTime * 1.5F), new Object[] { "DMB", "  M", "DMB", Character.valueOf('D'), Item.field_77702_n, Character.valueOf('B'), com(27), Character.valueOf('M'), steel });
/*      */     
/*      */ 
/*  373 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.pickEncrusted), true, 0, 2, 2700, new Object[] { "AAMD", "PPMD", "AAMD", Character.valueOf('P'), haft(2), Character.valueOf('M'), steel, Character.valueOf('D'), Item.field_77702_n });
/*      */     
/*  375 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.handpickEncrusted), true, 0, 2, 900, new Object[] { "AMD", "PMD", Character.valueOf('P'), haft(2), Character.valueOf('M'), steel, Character.valueOf('D'), Item.field_77702_n });
/*  376 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.handpickEncrusted), true, 0, 2, 900, new Object[] { "PMD", "AMD", Character.valueOf('P'), haft(2), Character.valueOf('M'), steel, Character.valueOf('D'), Item.field_77702_n });
/*      */     
/*      */ 
/*  379 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.swordEncrusted), true, 0, 2, 1800, new Object[] { "AMAA", "PMDD", "AMAA", Character.valueOf('P'), haft(2), Character.valueOf('M'), steel, Character.valueOf('D'), Item.field_77702_n });
/*      */     
/*      */ 
/*  382 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.broadEncrusted), true, 0, 2, 2000, new Object[] { "AMAA", "PMDD", "AMDD", Character.valueOf('P'), haft(2), Character.valueOf('M'), steel, Character.valueOf('D'), Item.field_77702_n });
/*  383 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.broadEncrusted), true, 0, 2, 2000, new Object[] { "AMDD", "PMDD", "AMAA", Character.valueOf('P'), haft(2), Character.valueOf('M'), steel, Character.valueOf('D'), Item.field_77702_n });
/*      */     
/*  385 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.daggerEncrusted), true, 0, 2, 900, new Object[] { "AAAA", "PMDA", "AAAA", Character.valueOf('P'), haft(2), Character.valueOf('M'), steel, Character.valueOf('D'), Item.field_77702_n });
/*  386 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.greatswordEncrusted), true, 0, 2, 3600, new Object[] { " M    ", "PMMMDD", " M    ", Character.valueOf('P'), haft(2), Character.valueOf('M'), steel, Character.valueOf('D'), Item.field_77702_n });
/*      */     
/*  388 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.lanceEncrusted), true, 0, 2, 7200, new Object[] { "  M     ", "MMPMMDDD", "  M     ", Character.valueOf('P'), haft(2), Character.valueOf('M'), steel, Character.valueOf('D'), Item.field_77702_n });
/*      */     
/*      */ 
/*  391 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.warpickEncrusted), true, 0, 2, 1350, new Object[] { "AAAD", "PPMD", "AAMM", Character.valueOf('P'), haft(2), Character.valueOf('M'), steel, Character.valueOf('D'), Item.field_77702_n });
/*  392 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.warpickEncrusted), true, 0, 2, 1350, new Object[] { "AAMM", "PPMD", "AAAD", Character.valueOf('P'), haft(2), Character.valueOf('M'), steel, Character.valueOf('D'), Item.field_77702_n });
/*      */     
/*      */ 
/*  395 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.battleaxeEncrusted), true, 0, 2, 5400, new Object[] { "AAAADD", "MPPPPM", "AAAADD", Character.valueOf('P'), haft(2), Character.valueOf('M'), steel, Character.valueOf('D'), Item.field_77702_n });
/*      */     
/*  397 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.boltMF, 8, 6), false, 0, 2, 2000, new Object[] { "D", "M", "F", Character.valueOf('D'), Item.field_77702_n, Character.valueOf('F'), com(23), Character.valueOf('M'), steel });
/*      */     
/*  399 */     MineFantasyAPI.addAnvilRecipe(com(132, 16), false, 0, 2, 800, new Object[] { "M  ", " MD", "M  ", Character.valueOf('D'), Item.field_77702_n, Character.valueOf('M'), steel });
/*      */     
/*  401 */     MineFantasyAPI.addAnvilRecipe(com(148, 16), false, 0, 2, 800, new Object[] { "M   ", " MMD", "M   ", Character.valueOf('D'), Item.field_77702_n, Character.valueOf('M'), steel });
/*      */     
/*  403 */     MineFantasyAPI.addAnvilRecipe(com(140, 16), false, 0, 2, 800, new Object[] { "  MD ", "MMMMD", "  MD ", Character.valueOf('D'), Item.field_77702_n, Character.valueOf('M'), steel });
/*      */     
/*      */ 
/*  406 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.maceEncrusted), true, 0, 2, 1200, new Object[] { "AADD", "PPMM", "AAAA", Character.valueOf('P'), com(65), Character.valueOf('M'), steel, Character.valueOf('D'), Item.field_77702_n });
/*      */     
/*  408 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.maceEncrusted), true, 0, 2, 1200, new Object[] { "AAAA", "PPMM", "AADD", Character.valueOf('P'), com(65), Character.valueOf('M'), steel, Character.valueOf('D'), Item.field_77702_n });
/*      */     
/*      */ 
/*      */ 
/*  412 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.greatmaceEncrusted), true, 0, 2, 1440, new Object[] { "AAAAADD", "MPPPPMM", "AAAAAAA", Character.valueOf('P'), com(65), Character.valueOf('M'), steel, Character.valueOf('D'), Item.field_77702_n });
/*      */     
/*  414 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.greatmaceEncrusted), true, 0, 2, 1440, new Object[] { "AAAAAAA", "MPPPPMM", "AAAAADD", Character.valueOf('P'), com(65), Character.valueOf('M'), steel, Character.valueOf('D'), Item.field_77702_n });
/*      */     
/*      */ 
/*  417 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.warhammerEncrusted), true, 0, 2, 1600, new Object[] { "AAAAAAM", "MPPPPMM", "AAAAADD", Character.valueOf('P'), com(65), Character.valueOf('M'), steel, Character.valueOf('D'), Item.field_77702_n });
/*      */     
/*  419 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.warhammerEncrusted), true, 0, 2, 1600, new Object[] { "AAAAADD", "MPPPPMM", "AAAAAAM", Character.valueOf('P'), com(65), Character.valueOf('M'), steel, Character.valueOf('D'), Item.field_77702_n });
/*      */     
/*  421 */     if (bg()) {
/*  422 */       MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bucklerEncrusted), true, 0, 2, encrustedTime, new Object[] { " D ", "SLS", " S ", Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('S'), steel, Character.valueOf('D'), Item.field_77702_n });
/*      */       
/*  424 */       MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.kiteEncrusted), true, 0, 2, encrustedTime * 3, new Object[] { "D D", "SWS", " S ", Character.valueOf('W'), Block.field_71988_x, Character.valueOf('S'), steel, Character.valueOf('D'), Item.field_77702_n });
/*      */       
/*  426 */       MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.towerEncrusted), true, 0, 2, encrustedTime * 5, new Object[] { "SSS", "DWD", "DWD", "SSS", Character.valueOf('W'), Block.field_71988_x, Character.valueOf('S'), steel, Character.valueOf('D'), Item.field_77702_n });
/*      */     }
/*      */   }
/*      */   
/*      */   private static void addHound()
/*      */   {
/*  432 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hound_BMail), 0, 0, bronzeTime * 2, new Object[] { "   CC", "CCCC ", " C C ", Character.valueOf('C'), com(76) });
/*      */     
/*  434 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hound_BMailH), 0, 0, bronzeTime, new Object[] { " CC", "CC ", Character.valueOf('C'), com(76) });
/*      */     
/*  436 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hound_IMail), 0, 1, ironTime * 2, new Object[] { "   CC", "CCCC ", " C C ", Character.valueOf('C'), com(116) });
/*      */     
/*  438 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hound_IMailH), 0, 1, ironTime, new Object[] { " CC", "CC ", Character.valueOf('C'), com(116) });
/*      */     
/*  440 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hound_GMail), 0, 1, steelTime * 2, new Object[] { "   CC", "CCCC ", " C C ", Character.valueOf('C'), com(170) });
/*      */     
/*  442 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hound_GMailH), 0, 1, steelTime, new Object[] { " CC", "CC ", Character.valueOf('C'), com(170) });
/*      */     
/*  444 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hound_SMail), 0, 2, steelTime * 2, new Object[] { "   CC", "CCCC ", " C C ", Character.valueOf('C'), com(41) });
/*      */     
/*  446 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hound_SMailH), 0, 2, steelTime, new Object[] { " CC", "CC ", Character.valueOf('C'), com(41) });
/*      */     
/*  448 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hound_DMail), 1, 2, dragonforgeTime * 2, new Object[] { "   CC", "CCCC ", " C C ", Character.valueOf('C'), com(45) });
/*      */     
/*  450 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hound_DMailH), 1, 2, dragonforgeTime, new Object[] { " CC", "CC ", Character.valueOf('C'), com(45) });
/*      */     
/*  452 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hound_DImail), 0, 3, deepIronTime * 2, new Object[] { "   CC", "CCCC ", " C C ", Character.valueOf('C'), com(180) });
/*      */     
/*  454 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hound_DImailH), 0, 3, deepIronTime, new Object[] { " CC", "CC ", Character.valueOf('C'), com(180) });
/*      */     
/*  456 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hound_MMail), 0, 3, mithrilTime * 2, new Object[] { "   CC", "CCCC ", " C C ", Character.valueOf('C'), com(43) });
/*      */     
/*  458 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hound_MMailH), 0, 3, mithrilTime, new Object[] { " CC", "CC ", Character.valueOf('C'), com(43) });
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  463 */     addHoundPlate(72, 73, new Item[] { ItemListMF.hound_Bplate, ItemListMF.hound_BplateH }, 0, 0, bronzeTime);
/*      */     
/*      */ 
/*  466 */     addHoundPlate(61, 63, new Item[] { ItemListMF.hound_Iplate, ItemListMF.hound_IplateH }, 0, 1, ironTime);
/*      */     
/*      */ 
/*  469 */     addHoundPlate(173, 172, new Item[] { ItemListMF.hound_Gplate, ItemListMF.hound_GplateH }, 0, 1, ironTime);
/*      */     
/*      */ 
/*  472 */     addHoundPlate(117, 28, new Item[] { ItemListMF.hound_Splate, ItemListMF.hound_SplateH }, 0, 2, steelTime);
/*      */     
/*      */ 
/*  475 */     addHoundPlate(68, 69, new Item[] { ItemListMF.hound_Eplate, ItemListMF.hound_EplateH }, 0, 2, encrustedTime);
/*      */     
/*      */ 
/*  478 */     addHoundPlate(118, 119, new Item[] { ItemListMF.hound_Dplate, ItemListMF.hound_DplateH }, 1, 2, dragonforgeTime);
/*      */     
/*      */ 
/*  481 */     addHoundPlate(182, 184, new Item[] { ItemListMF.hound_DIplate, ItemListMF.hound_DIplateH }, 0, 3, mithrilTime);
/*      */     
/*      */ 
/*  484 */     addHoundPlate(95, 96, new Item[] { ItemListMF.hound_Mplate, ItemListMF.hound_MplateH }, 0, 3, mithrilTime);
/*      */   }
/*      */   
/*      */   private static void addCrossbows() {
/*  488 */     MineFantasyAPI.addAnvilRecipe(com(105), 0, 1, 800, new Object[] { "ASAAA", "PPIPP", "AAASS", Character.valueOf('I'), com(60), Character.valueOf('S'), Item.field_77669_D, Character.valueOf('P'), ItemListMF.plank });
/*      */     
/*  490 */     for (ItemStack steel : OreDictionary.getOres("ingotSteel")) {
/*  491 */       MineFantasyAPI.addAnvilRecipe(com(106), 0, 2, 1200, new Object[] { "AIAIA", "IPMPP", "AAAPA", Character.valueOf('I'), steel, Character.valueOf('M'), com(105), Character.valueOf('P'), ItemListMF.plank });
/*      */       
/*  493 */       MineFantasyAPI.addAnvilRecipe(com(107), 0, 2, 600, new Object[] { "APAPA", "APAPA", "APAPA", "AIIPP", Character.valueOf('I'), steel, Character.valueOf('P'), ItemListMF.plank });
/*      */       
/*  495 */       MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.crossbowHeavy), 0, 2, 5000, new Object[] { "AAAABA", "PPPMSB", "PPPISB", "AAAABA", Character.valueOf('S'), Item.field_77683_K, Character.valueOf('M'), com(105), Character.valueOf('B'), com(25), Character.valueOf('P'), ItemListMF.plank, Character.valueOf('I'), steel });
/*      */     }
/*      */     
/*  498 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.crossbowHand), 0, 0, 1500, new Object[] { "AAAPA", "PPMSP", "AAAPA", Character.valueOf('S'), Item.field_77683_K, Character.valueOf('M'), com(105), Character.valueOf('P'), ItemListMF.plank });
/*      */     
/*  500 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.crossbowLight), 0, 0, 2000, new Object[] { "AAAPA", "AAMSP", "PPPSP", "AAAPA", Character.valueOf('S'), Item.field_77683_K, Character.valueOf('M'), com(105), Character.valueOf('P'), ItemListMF.plank });
/*      */     
/*  502 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.crossbowRepeat), 0, 2, 2000, new Object[] { "AABPA", "AAMSP", "PPPSP", "AAAPA", Character.valueOf('S'), Item.field_77683_K, Character.valueOf('M'), com(106), Character.valueOf('B'), com(107), Character.valueOf('P'), ItemListMF.plank });
/*      */   }
/*      */   
/*      */ 
/*      */   private static void addBronze(ItemStack ore)
/*      */   {
/*  508 */     MineFantasyAPI.addAnvilRecipe(com(122, 4), false, 0, 0, 200, new Object[] { "I", Character.valueOf('I'), ore });
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  517 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(MineFantasyBase.MFBlockTripHammer, 1, 0), 0, 1, 1200, new Object[] { "HIIIB", "W  BB", "S  SS", Character.valueOf('H'), ItemListMF.hammerBronze, Character.valueOf('I'), com(60), Character.valueOf('B'), ore, Character.valueOf('W'), block(7), Character.valueOf('S'), Block.field_71981_t });
/*      */     
/*  519 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(MineFantasyBase.MFBlockTripHammer, 1, 1), 0, 1, 1200, new Object[] { "  B ", " BIB", "BWB ", "S S ", Character.valueOf('I'), com(60), Character.valueOf('B'), ore, Character.valueOf('W'), block(3), Character.valueOf('S'), Block.field_71981_t });
/*      */     
/*  521 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.misc, 16, 36), 0, 0, 800, new Object[] { "MMM", " M ", Character.valueOf('M'), ore });
/*  522 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.misc, 8, 1), 0, 0, 800, new Object[] { "M", "M", "M", "M", Character.valueOf('M'), ore });
/*      */     
/*  524 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.misc, 24, 18), 0, 0, 600, new Object[] { " M ", "M M", " M ", Character.valueOf('M'), ore });
/*  525 */     MineFantasyAPI.addAnvilRecipe(com(76), 0, 0, bronzeTime, new Object[] { "CC", "CC", Character.valueOf('C'), com(18) });
/*      */     
/*  527 */     for (ItemStack block : OreDictionary.getOres("blockBronze")) {
/*  528 */       MineFantasyAPI.addAnvilRecipe(new ItemStack(MineFantasyBase.MFBlockAnvil, 1, 2), true, 0, -1, 900, new Object[] { " BB", "III", " I ", Character.valueOf('I'), ore, Character.valueOf('B'), block });
/*      */     }
/*      */   }
/*      */   
/*      */   private static void addIron(ItemStack ore)
/*      */   {
/*  534 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(MineFantasyBase.MFBlockDogbowl, 1, 1), false, 0, 1, 500, new Object[] { "IBI", " I ", Character.valueOf('I'), ore, Character.valueOf('B'), Item.field_77670_E });
/*      */     
/*  536 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(MineFantasyBase.MFBlockAnvil, 1, 4), true, 0, 0, 1000, new Object[] { " BB", "III", " I ", Character.valueOf('I'), ore, Character.valueOf('B'), new ItemStack(MineFantasyBase.MFBlockStorage, 1, 7) });
/*      */     
/*  538 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(MineFantasyBase.MFBlockBlast, 1, 0), 1000, new Object[] { "G G", "G G", "GIG", Character.valueOf('I'), ore, Character.valueOf('G'), Block.field_72007_bm });
/*  539 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(MineFantasyBase.MFBlockBlast, 1, 1), 1000, new Object[] { "G G", "GFG", "GIG", Character.valueOf('I'), ore, Character.valueOf('F'), new ItemStack(MineFantasyBase.MFBlockFurnace, 1, 0), Character.valueOf('G'), Block.field_72007_bm });
/*  540 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(MineFantasyBase.MFBlockBlast, 1, 2), 1000, new Object[] { "III", "IFI", "III", Character.valueOf('I'), ore, Character.valueOf('F'), new ItemStack(MineFantasyBase.MFBlockFurnace, 1, 0) });
/*      */     
/*  542 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(MineFantasyBase.MFBlockBlast, 1, 3), 1000, new Object[] { "I I", "G G", "GGG", Character.valueOf('I'), ore, Character.valueOf('G'), Block.field_72007_bm });
/*      */     
/*  544 */     MineFantasyAPI.addAnvilRecipe(com(2, 4), false, 0, 1, 300, new Object[] { "I", Character.valueOf('I'), ore });
/*      */     
/*  546 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.misc, 24, 13), 0, 1, 800, new Object[] { " M ", "M M", " M ", Character.valueOf('M'), ore });
/*      */     
/*  548 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.misc, 16, 37), 0, 1, 1200, new Object[] { "MMM", " M ", Character.valueOf('M'), ore });
/*      */     
/*  550 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.misc, 8, 46), 0, 1, 1200, new Object[] { "M", "M", "M", "M", Character.valueOf('M'), ore });
/*      */   }
/*      */   
/*      */   private static void addDeepIron(ItemStack ore) {
/*  554 */     for (ItemStack block : OreDictionary.getOres("blockDeepIron")) {
/*  555 */       MineFantasyAPI.addAnvilRecipe(new ItemStack(MineFantasyBase.MFBlockAnvil, 1, 8), true, 0, 2, 1800, new Object[] { " BB", "III", " I ", Character.valueOf('I'), ore, Character.valueOf('B'), block });
/*      */     }
/*  557 */     MineFantasyAPI.addAnvilRecipe(com(186, 4), false, 0, 3, 600, new Object[] { "I", Character.valueOf('I'), ore });
/*      */     
/*  559 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.misc, 16, 178), 0, 3, 2000, new Object[] { "MMM", " M ", Character.valueOf('M'), ore });
/*  560 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.misc, 24, 179), 0, 3, 1500, new Object[] { " M ", "M M", " M ", Character.valueOf('M'), ore });
/*  561 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.misc, 8, 181), 0, 3, 2000, new Object[] { "M", "M", "M", "M", Character.valueOf('M'), ore });
/*      */   }
/*      */   
/*      */   private static void addMithril(ItemStack ore)
/*      */   {
/*  566 */     MineFantasyAPI.addAnvilRecipe(com(124, 4), false, 0, 3, 800, new Object[] { "I", Character.valueOf('I'), ore });
/*      */     
/*  568 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.misc, 8, 62), 0, 3, 2400, new Object[] { "M", "M", "M", "M", Character.valueOf('M'), ore });
/*      */     
/*  570 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hammerRepairArtisan), true, 0, 3, 1000, new Object[] { "AAAMA", "PLPMM", "AAAMM", Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('P'), ItemListMF.plank, Character.valueOf('M'), ore });
/*      */     
/*  572 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hammerRepairArtisan), true, 0, 3, 1000, new Object[] { "AAAMM", "PLPMM", "AAAMA", Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('P'), ItemListMF.plank, Character.valueOf('M'), ore });
/*      */     
/*  574 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hammerRepairOrnateArtisan), true, 0, 3, 1500, new Object[] { "AAAMA", "GLPMM", "AAAMM", Character.valueOf('G'), Item.field_77717_p, Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('P'), com(60), Character.valueOf('M'), ore });
/*      */     
/*  576 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hammerRepairOrnateArtisan), true, 0, 3, 1500, new Object[] { "AAAMM", "GLPMM", "AAAMA", Character.valueOf('G'), Item.field_77717_p, Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('P'), com(60), Character.valueOf('M'), ore });
/*      */     
/*  578 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.misc, 16, 38), 0, 3, 2400, new Object[] { "MMM", " M ", Character.valueOf('M'), ore });
/*  579 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.misc, 24, 42), 0, 3, 1800, new Object[] { " M ", "M M", " M ", Character.valueOf('M'), ore });
/*  580 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.misc, 8, 62), 0, 3, 2400, new Object[] { "M", "M", "M", "M", Character.valueOf('M'), ore });
/*      */   }
/*      */   
/*      */   private static void addDragonforge(ItemStack ore)
/*      */   {
/*  585 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.misc, 16, 39), 1, 2, 3200, new Object[] { "MMM", " M ", Character.valueOf('M'), ore });
/*  586 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.misc, 24, 44), 1, 2, 2400, new Object[] { " M ", "M M", " M ", Character.valueOf('M'), ore });
/*  587 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.misc, 8, 47), 1, 2, 3200, new Object[] { "M", "M", "M", "M", Character.valueOf('M'), ore });
/*      */   }
/*      */   
/*      */   private static ItemStack block(int i) {
/*  591 */     return new ItemStack(MineFantasyBase.MFBlockStorage, 1, i);
/*      */   }
/*      */   
/*  594 */   private static int bronzeTime = 400;
/*  595 */   private static int ironTime = 500;
/*  596 */   private static int steelTime = 750;
/*  597 */   private static int encrustedTime = 1000;
/*      */   
/*  599 */   private static int deepIronTime = 1100;
/*  600 */   private static int mithrilTime = 1500;
/*  601 */   private static int dragonforgeTime = 1500;
/*  602 */   private static int ignotumiteTime = 1800;
/*      */   
/*      */   private static void addTools() {
/*  605 */     addKnife(0, "ingotTin", new ItemStack(ItemListMF.knifeTin), 0, -1, bronzeTime);
/*  606 */     addKnife(0, "ingotCopper", new ItemStack(ItemListMF.knifeCopper), 0, -1, bronzeTime);
/*  607 */     addKnife(1, "ingotBronze", new ItemStack(ItemListMF.knifeBronze), 0, 0, bronzeTime);
/*  608 */     addKnife(1, com(60), new ItemStack(ItemListMF.knifeIron), 0, 1, ironTime);
/*  609 */     addKnife(2, "ingotSteel", new ItemStack(ItemListMF.knifeSteel), 0, 2, steelTime);
/*  610 */     addKnife(2, com(22), new ItemStack(ItemListMF.knifeDragon), 1, 2, dragonforgeTime);
/*  611 */     addKnife(3, "ingotDeepIron", new ItemStack(ItemListMF.knifeDeepIron), 0, 3, deepIronTime);
/*  612 */     addKnife(3, "ingotMithril", new ItemStack(ItemListMF.knifeMithril), 0, 3, mithrilTime);
/*      */     
/*  614 */     addShears(0, "ingotTin", new ItemStack(ItemListMF.shearsTin), 0, -1, bronzeTime);
/*  615 */     addShears(0, "ingotCopper", new ItemStack(ItemListMF.shearsCopper), 0, -1, bronzeTime);
/*  616 */     addShears(1, "ingotBronze", new ItemStack(ItemListMF.shearsBronze), 0, 0, bronzeTime);
/*  617 */     addShears(1, com(60), new ItemStack(ItemListMF.shearsIron), 0, 1, ironTime);
/*  618 */     addShears(2, "ingotSteel", new ItemStack(ItemListMF.shearsSteel), 0, 2, steelTime);
/*  619 */     addShears(3, "ingotMithril", new ItemStack(ItemListMF.shearsMithril), 0, 3, mithrilTime);
/*  620 */     addShears(2, com(22), new ItemStack(ItemListMF.shearsDragon), 1, 2, dragonforgeTime);
/*  621 */     addShears(3, "ingotDeepIron", new ItemStack(ItemListMF.shearsDeepIron), 0, 3, deepIronTime);
/*      */     
/*  623 */     addPick(0, "ingotTin", new ItemStack(ItemListMF.pickTin), 0, -1, bronzeTime);
/*  624 */     addPick(0, "ingotCopper", new ItemStack(ItemListMF.pickCopperForged), 0, -1, bronzeTime);
/*  625 */     addPick(1, "ingotBronze", new ItemStack(ItemListMF.pickBronze), 0, 0, bronzeTime);
/*  626 */     addPick(1, com(60), new ItemStack(ItemListMF.pickIronForged), 0, 1, ironTime);
/*  627 */     addPick(2, "ingotSteel", new ItemStack(ItemListMF.pickSteelForged), 0, 2, steelTime);
/*  628 */     addPick(2, com(22), new ItemStack(ItemListMF.pickDragon), 1, 2, dragonforgeTime);
/*  629 */     addPick(3, "ingotDeepIron", new ItemStack(ItemListMF.pickDeepIron), 0, 3, deepIronTime);
/*  630 */     addPick(3, "ingotMithril", new ItemStack(ItemListMF.pickMithril), 0, 3, mithrilTime);
/*  631 */     addPick(4, com(153), new ItemStack(ItemListMF.pickIgnotumiteForged), 1, 3, ignotumiteTime);
/*      */     
/*  633 */     addHandpick(1, "ingotBronze", new ItemStack(ItemListMF.handpickBronze), 0, 0, bronzeTime);
/*  634 */     addHandpick(1, com(60), new ItemStack(ItemListMF.handpickIron), 0, 1, ironTime);
/*  635 */     addHandpick(2, "ingotSteel", new ItemStack(ItemListMF.handpickSteel), 0, 2, steelTime);
/*  636 */     addHandpick(2, com(22), new ItemStack(ItemListMF.handpickDragonforge), 1, 2, dragonforgeTime);
/*  637 */     addHandpick(3, "ingotMithril", new ItemStack(ItemListMF.handpickMithril), 0, 3, mithrilTime);
/*  638 */     addHandpick(3, "ingotDeepIron", new ItemStack(ItemListMF.handpickDeepIron), 0, 3, deepIronTime);
/*  639 */     addHandpick(4, com(153), new ItemStack(ItemListMF.handpickIgnotumite), 1, 3, ignotumiteTime);
/*      */     
/*  641 */     addSpade(0, "ingotTin", new ItemStack(ItemListMF.spadeTin), 0, -1, bronzeTime);
/*  642 */     addSpade(0, "ingotCopper", new ItemStack(ItemListMF.spadeCopperForged), 0, -1, bronzeTime);
/*  643 */     addSpade(1, "ingotBronze", new ItemStack(ItemListMF.spadeBronze), 0, 0, bronzeTime);
/*  644 */     addSpade(1, com(60), new ItemStack(ItemListMF.spadeIronForged), 0, 1, ironTime);
/*  645 */     addSpade(2, "ingotSteel", new ItemStack(ItemListMF.spadeSteelForged), 0, 2, steelTime);
/*  646 */     addSpade(2, com(22), new ItemStack(ItemListMF.spadeDragon), 1, 2, dragonforgeTime);
/*  647 */     addSpade(3, "ingotMithril", new ItemStack(ItemListMF.spadeMithril), 0, 3, mithrilTime);
/*  648 */     addSpade(3, "ingotDeepIron", new ItemStack(ItemListMF.spadeDeepIron), 0, 3, deepIronTime);
/*  649 */     addSpade(4, com(153), new ItemStack(ItemListMF.spadeIgnotumiteForged), 1, 3, ignotumiteTime);
/*      */     
/*  651 */     addAxe(0, "ingotTin", new ItemStack(ItemListMF.axeTin), 0, -1, bronzeTime);
/*  652 */     addAxe(0, "ingotCopper", new ItemStack(ItemListMF.axeCopperForged), 0, -1, bronzeTime);
/*  653 */     addAxe(1, "ingotBronze", new ItemStack(ItemListMF.axeBronze), 0, 0, bronzeTime);
/*  654 */     addAxe(1, com(60), new ItemStack(ItemListMF.axeIronForged), 0, 1, ironTime);
/*  655 */     addAxe(2, "ingotSteel", new ItemStack(ItemListMF.axeSteelForged), 0, 2, steelTime);
/*  656 */     addAxe(3, "ingotMithril", new ItemStack(ItemListMF.axeMithril), 0, 3, mithrilTime);
/*  657 */     addAxe(3, "ingotDeepIron", new ItemStack(ItemListMF.axeDeepIron), 0, 3, deepIronTime);
/*  658 */     addAxe(4, com(153), new ItemStack(ItemListMF.axeIgnotumiteForged), 1, 3, ignotumiteTime);
/*  659 */     addAxe(2, com(22), new ItemStack(ItemListMF.axeDragon), 1, 2, dragonforgeTime);
/*      */     
/*  661 */     addHoe(0, "ingotTin", new ItemStack(ItemListMF.hoeTin), 0, -1, bronzeTime);
/*  662 */     addHoe(0, "ingotCopper", new ItemStack(ItemListMF.hoeCopperForged), 0, -1, bronzeTime);
/*  663 */     addHoe(1, "ingotBronze", new ItemStack(ItemListMF.hoeBronze), 0, 0, bronzeTime);
/*  664 */     addHoe(1, com(60), new ItemStack(ItemListMF.hoeIronForged), 0, 1, ironTime);
/*  665 */     addHoe(2, "ingotSteel", new ItemStack(ItemListMF.hoeSteelForged), 0, 2, steelTime);
/*  666 */     addHoe(2, com(22), new ItemStack(ItemListMF.hoeDragon), 1, 2, dragonforgeTime);
/*  667 */     addHoe(3, "ingotMithril", new ItemStack(ItemListMF.hoeMithril), 0, 3, mithrilTime);
/*  668 */     addHoe(3, "ingotDeepIron", new ItemStack(ItemListMF.hoeDeepIron), 0, 3, deepIronTime);
/*      */     
/*  670 */     addDagger(1, "ingotBronze", new ItemStack(ItemListMF.daggerBronze), 0, 0, bronzeTime);
/*  671 */     addDagger(1, com(60), new ItemStack(ItemListMF.daggerIron), 0, 1, ironTime);
/*  672 */     addDagger(2, "ingotSteel", new ItemStack(ItemListMF.daggerSteel), 0, 2, steelTime);
/*  673 */     addDagger(3, "ingotMithril", new ItemStack(ItemListMF.daggerMithril), 0, 3, mithrilTime);
/*  674 */     addDagger(3, "ingotDeepIron", new ItemStack(ItemListMF.daggerDeepIron), 0, 3, deepIronTime);
/*  675 */     addDagger(2, com(22), new ItemStack(ItemListMF.daggerDragon), 1, 2, dragonforgeTime);
/*  676 */     addDagger(4, com(153), new ItemStack(ItemListMF.daggerIgnotumite), 1, 3, ignotumiteTime);
/*      */     
/*  678 */     addSword(0, "ingotCopper", new ItemStack(ItemListMF.swordCopper), 0, -1, bronzeTime);
/*  679 */     addSword(0, "ingotTin", new ItemStack(ItemListMF.swordTin), 0, -1, bronzeTime);
/*  680 */     addSword(1, "ingotBronze", new ItemStack(ItemListMF.swordBronze), 0, 0, bronzeTime);
/*  681 */     addSword(1, com(60), new ItemStack(ItemListMF.swordIronForged), 0, 1, ironTime);
/*  682 */     addSword(2, "ingotSteel", new ItemStack(ItemListMF.swordSteelForged), 0, 2, steelTime);
/*  683 */     addSword(3, "ingotMithril", new ItemStack(ItemListMF.swordMithril), 0, 3, mithrilTime);
/*  684 */     addSword(3, "ingotDeepIron", new ItemStack(ItemListMF.swordDeepIron), 0, 3, deepIronTime);
/*  685 */     addSword(2, com(22), new ItemStack(ItemListMF.swordDragon), 1, 2, dragonforgeTime);
/*  686 */     addSword(4, com(153), new ItemStack(ItemListMF.swordIgnotumite), 1, 3, ignotumiteTime);
/*      */     
/*  688 */     addBroadsword(1, com(60), new ItemStack(ItemListMF.broadIron), 0, 1, ironTime);
/*  689 */     addBroadsword(2, "ingotSteel", new ItemStack(ItemListMF.broadSteel), 0, 2, steelTime);
/*  690 */     addBroadsword(1, "ingotBronze", new ItemStack(ItemListMF.broadBronze), 0, 0, bronzeTime);
/*  691 */     addBroadsword(3, "ingotMithril", new ItemStack(ItemListMF.broadMithril), 0, 3, mithrilTime);
/*  692 */     addBroadsword(3, "ingotDeepIron", new ItemStack(ItemListMF.broadswordDeepIron), 0, 3, deepIronTime);
/*  693 */     addBroadsword(2, com(22), new ItemStack(ItemListMF.broadDragon), 1, 2, dragonforgeTime);
/*  694 */     addBroadsword(4, com(153), new ItemStack(ItemListMF.broadIgnotumite), 1, 3, ignotumiteTime);
/*      */     
/*  696 */     addGreatmace(1, "ingotBronze", new ItemStack(ItemListMF.morningstarBronze), 0, 0, bronzeTime);
/*  697 */     addGreatmace(1, com(60), new ItemStack(ItemListMF.morningstarIron), 0, 1, ironTime);
/*  698 */     addGreatmace(2, "ingotSteel", new ItemStack(ItemListMF.morningstarSteel), 0, 2, steelTime);
/*  699 */     addGreatmace(3, "ingotMithril", new ItemStack(ItemListMF.morningstarMithril), 0, 3, mithrilTime);
/*  700 */     addGreatmace(3, "ingotDeepIron", new ItemStack(ItemListMF.greatmaceDeepIron), 0, 3, deepIronTime);
/*  701 */     addGreatmace(2, com(22), new ItemStack(ItemListMF.morningstarDragon), 1, 2, dragonforgeTime);
/*  702 */     addGreatmace(4, com(153), new ItemStack(ItemListMF.morningstarIgnotumite), 1, 3, ignotumiteTime);
/*      */     
/*  704 */     addWarhammer(1, "ingotBronze", new ItemStack(ItemListMF.warhammerBronze), 0, 0, bronzeTime);
/*  705 */     addWarhammer(1, com(60), new ItemStack(ItemListMF.warhammerIron), 0, 1, ironTime);
/*  706 */     addWarhammer(2, "ingotSteel", new ItemStack(ItemListMF.warhammerSteel), 0, 2, steelTime);
/*  707 */     addWarhammer(3, "ingotMithril", new ItemStack(ItemListMF.warhammerMithril), 0, 3, mithrilTime);
/*  708 */     addWarhammer(3, "ingotDeepIron", new ItemStack(ItemListMF.warhammerDeepIron), 0, 3, deepIronTime);
/*  709 */     addWarhammer(2, com(22), new ItemStack(ItemListMF.warhammerDragon), 1, 2, dragonforgeTime);
/*  710 */     addWarhammer(4, com(153), new ItemStack(ItemListMF.warhammerIgnotumite), 1, 3, ignotumiteTime);
/*      */     
/*  712 */     addGreatsword(1, "ingotBronze", new ItemStack(ItemListMF.greatswordBronze), 0, 0, bronzeTime);
/*  713 */     addGreatsword(1, com(60), new ItemStack(ItemListMF.greatswordIron), 0, 1, ironTime);
/*  714 */     addGreatsword(2, "ingotSteel", new ItemStack(ItemListMF.greatswordSteel), 0, 2, steelTime);
/*  715 */     addGreatsword(3, "ingotMithril", new ItemStack(ItemListMF.greatswordMithril), 0, 3, mithrilTime);
/*  716 */     addGreatsword(3, "ingotDeepIron", new ItemStack(ItemListMF.greatswordDeepIron), 0, 3, deepIronTime);
/*  717 */     addGreatsword(2, com(22), new ItemStack(ItemListMF.greatswordDragon), 1, 2, dragonforgeTime);
/*  718 */     addGreatsword(4, com(153), new ItemStack(ItemListMF.greatswordIgnotumite), 1, 3, ignotumiteTime);
/*      */     
/*  720 */     addSpear(1, "ingotBronze", new ItemStack(ItemListMF.spearBronze), 0, 0, bronzeTime);
/*  721 */     addSpear(1, com(60), new ItemStack(ItemListMF.spearIron), 0, 1, ironTime);
/*  722 */     addSpear(2, "ingotSteel", new ItemStack(ItemListMF.spearSteel), 0, 2, steelTime);
/*  723 */     addSpear(3, "ingotMithril", new ItemStack(ItemListMF.spearMithril), 0, 3, mithrilTime);
/*  724 */     addSpear(3, "ingotDeepIron", new ItemStack(ItemListMF.spearDeepIron), 0, 3, deepIronTime);
/*  725 */     addSpear(2, com(22), new ItemStack(ItemListMF.spearDragon), 1, 2, dragonforgeTime);
/*  726 */     addSpear(4, com(153), new ItemStack(ItemListMF.spearIgnotumite), 1, 3, ignotumiteTime);
/*      */     
/*  728 */     addHalbeard(1, "ingotBronze", new ItemStack(ItemListMF.halbeardBronze), 0, 0, bronzeTime);
/*  729 */     addHalbeard(1, com(60), new ItemStack(ItemListMF.halbeardIron), 0, 1, ironTime);
/*  730 */     addHalbeard(2, "ingotSteel", new ItemStack(ItemListMF.halbeardSteel), 0, 2, steelTime);
/*  731 */     addHalbeard(3, "ingotMithril", new ItemStack(ItemListMF.halbeardMithril), 0, 3, mithrilTime);
/*  732 */     addHalbeard(3, "ingotDeepIron", new ItemStack(ItemListMF.halbeardDeepIron), 0, 3, deepIronTime);
/*  733 */     addHalbeard(2, com(22), new ItemStack(ItemListMF.halbeardDragon), 1, 2, dragonforgeTime);
/*  734 */     addHalbeard(4, com(153), new ItemStack(ItemListMF.halbeardIgnotumite), 1, 3, ignotumiteTime);
/*      */     
/*  736 */     addMace(0, "ingotCopper", new ItemStack(ItemListMF.maceCopper), 0, -1, bronzeTime);
/*  737 */     addMace(0, "ingotTin", new ItemStack(ItemListMF.maceTin), 0, -1, bronzeTime);
/*  738 */     addMace(1, "ingotBronze", new ItemStack(ItemListMF.maceBronze), 0, 0, bronzeTime);
/*  739 */     addMace(1, com(60), new ItemStack(ItemListMF.maceIron), 0, 1, ironTime);
/*  740 */     addMace(2, "ingotSteel", new ItemStack(ItemListMF.maceSteel), 0, 2, steelTime);
/*  741 */     addMace(2, com(22), new ItemStack(ItemListMF.maceDragon), 0, 2, dragonforgeTime);
/*  742 */     addMace(3, "ingotMithril", new ItemStack(ItemListMF.maceMithril), 0, 3, mithrilTime);
/*  743 */     addMace(3, "ingotDeepIron", new ItemStack(ItemListMF.maceDeepIron), 0, 3, deepIronTime);
/*  744 */     addMace(4, com(153), new ItemStack(ItemListMF.maceIgnotumite), 1, 3, ignotumiteTime);
/*      */     
/*  746 */     addWaraxe(0, "ingotCopper", new ItemStack(ItemListMF.waraxeCopper), 0, -1, bronzeTime);
/*  747 */     addWaraxe(0, "ingotTin", new ItemStack(ItemListMF.waraxeTin), 0, -1, bronzeTime);
/*  748 */     addWaraxe(1, "ingotBronze", new ItemStack(ItemListMF.waraxeBronze), 0, 0, bronzeTime);
/*  749 */     addWaraxe(1, com(60), new ItemStack(ItemListMF.waraxeIron), 0, 1, ironTime);
/*  750 */     addWaraxe(2, "ingotSteel", new ItemStack(ItemListMF.waraxeSteel), 0, 2, steelTime);
/*  751 */     addWaraxe(2, com(22), new ItemStack(ItemListMF.waraxeDragon), 1, 2, dragonforgeTime);
/*  752 */     addWaraxe(3, "ingotDeepIron", new ItemStack(ItemListMF.waraxeDeepIron), 0, 3, deepIronTime);
/*  753 */     addWaraxe(3, "ingotMithril", new ItemStack(ItemListMF.waraxeMithril), 0, 3, mithrilTime);
/*  754 */     addWaraxe(4, com(153), new ItemStack(ItemListMF.waraxeIgnotumite), 1, 3, ignotumiteTime);
/*      */     
/*  756 */     addBattleaxe(1, "ingotBronze", new ItemStack(ItemListMF.battleaxeBronze), 0, 0, bronzeTime);
/*  757 */     addBattleaxe(1, com(60), new ItemStack(ItemListMF.battleaxeIron), 0, 1, ironTime);
/*  758 */     addBattleaxe(2, "ingotSteel", new ItemStack(ItemListMF.battleaxeSteel), 0, 2, steelTime);
/*  759 */     addBattleaxe(2, com(22), new ItemStack(ItemListMF.battleaxeDragon), 1, 2, dragonforgeTime);
/*  760 */     addBattleaxe(3, "ingotMithril", new ItemStack(ItemListMF.battleaxeMithril), 0, 3, mithrilTime);
/*  761 */     addBattleaxe(3, "ingotDeepIron", new ItemStack(ItemListMF.battleaxeDeepIron), 0, 3, deepIronTime);
/*  762 */     addBattleaxe(4, com(153), new ItemStack(ItemListMF.battleaxeIgnotumite), 1, 3, ignotumiteTime);
/*      */     
/*  764 */     addWarpick(1, "ingotBronze", new ItemStack(ItemListMF.warpickBronze), 0, 0, bronzeTime);
/*  765 */     addWarpick(1, com(60), new ItemStack(ItemListMF.warpickIron), 0, 1, ironTime);
/*  766 */     addWarpick(2, "ingotSteel", new ItemStack(ItemListMF.warpickSteel), 0, 2, steelTime);
/*  767 */     addWarpick(2, com(22), new ItemStack(ItemListMF.warpickDragon), 1, 2, dragonforgeTime);
/*  768 */     addWarpick(3, "ingotMithril", new ItemStack(ItemListMF.warpickMithril), 0, 3, mithrilTime);
/*  769 */     addWarpick(3, "ingotDeepIron", new ItemStack(ItemListMF.warpickDeepIron), 0, 3, deepIronTime);
/*  770 */     addWarpick(4, com(153), new ItemStack(ItemListMF.warpickIgnotumite), 1, 3, ignotumiteTime);
/*      */     
/*  772 */     addScythe(1, "ingotBronze", new ItemStack(ItemListMF.scytheBronze), 0, 0, bronzeTime);
/*  773 */     addScythe(1, com(60), new ItemStack(ItemListMF.scytheIron), 0, 1, ironTime);
/*  774 */     addScythe(2, "ingotSteel", new ItemStack(ItemListMF.scytheSteel), 0, 2, steelTime);
/*  775 */     addScythe(2, com(22), new ItemStack(ItemListMF.scytheDragon), 1, 2, dragonforgeTime);
/*  776 */     addScythe(3, "ingotMithril", new ItemStack(ItemListMF.scytheMithril), 0, 3, mithrilTime);
/*  777 */     addScythe(3, "ingotDeepIron", new ItemStack(ItemListMF.scytheDeepIron), 0, 3, deepIronTime);
/*      */     
/*  779 */     addRake(1, "ingotBronze", new ItemStack(ItemListMF.rakeBronze), 0, 0, bronzeTime);
/*  780 */     addRake(1, com(60), new ItemStack(ItemListMF.rakeIron), 0, 1, ironTime);
/*  781 */     addRake(2, "ingotSteel", new ItemStack(ItemListMF.rakeSteel), 0, 2, steelTime);
/*  782 */     addRake(2, com(22), new ItemStack(ItemListMF.rakeDragon), 1, 2, dragonforgeTime);
/*  783 */     addRake(3, "ingotMithril", new ItemStack(ItemListMF.rakeMithril), 0, 3, mithrilTime);
/*  784 */     addRake(3, "ingotDeepIron", new ItemStack(ItemListMF.rakeDeepIron), 0, 3, deepIronTime);
/*      */     
/*  786 */     addMattock(1, "ingotBronze", new ItemStack(ItemListMF.mattockBronze), 0, 0, bronzeTime);
/*  787 */     addMattock(1, com(60), new ItemStack(ItemListMF.mattockIron), 0, 1, ironTime);
/*  788 */     addMattock(2, "ingotSteel", new ItemStack(ItemListMF.mattockSteel), 0, 2, steelTime);
/*  789 */     addMattock(3, "ingotMithril", new ItemStack(ItemListMF.mattockMithril), 0, 3, mithrilTime);
/*  790 */     addMattock(3, "ingotDeepIron", new ItemStack(ItemListMF.mattockDeepIron), 0, 3, deepIronTime);
/*  791 */     addMattock(2, com(22), new ItemStack(ItemListMF.mattockDragon), 1, 2, dragonforgeTime);
/*      */     
/*  793 */     addSaw(1, "ingotBronze", new ItemStack(ItemListMF.sawBronze), 0, 0, bronzeTime);
/*  794 */     addSaw(1, com(60), new ItemStack(ItemListMF.sawIron), 0, 1, ironTime);
/*  795 */     addSaw(2, "ingotSteel", new ItemStack(ItemListMF.sawSteel), 0, 2, steelTime);
/*  796 */     addSaw(2, com(22), new ItemStack(ItemListMF.sawDragon), 1, 2, dragonforgeTime);
/*  797 */     addSaw(3, "ingotDeepIron", new ItemStack(ItemListMF.sawDeepIron), 0, 3, deepIronTime);
/*  798 */     addSaw(3, "ingotMithril", new ItemStack(ItemListMF.sawMithril), 0, 3, mithrilTime);
/*      */     
/*  800 */     addTeeth("ingotBronze", new ItemStack(ItemListMF.hound_Bteeth), 0, 0, bronzeTime);
/*  801 */     addTeeth(com(60), new ItemStack(ItemListMF.hound_Iteeth), 0, 1, ironTime);
/*  802 */     addTeeth("ingotSteel", new ItemStack(ItemListMF.hound_Steeth), 0, 2, steelTime);
/*  803 */     addTeeth(com(22), new ItemStack(ItemListMF.hound_Dteeth), 0, 2, steelTime);
/*  804 */     addTeeth("ingotDeepIron", new ItemStack(ItemListMF.hound_DIteeth), 0, 3, deepIronTime);
/*  805 */     addTeeth("ingotMithril", new ItemStack(ItemListMF.hound_Mteeth), 0, 3, mithrilTime);
/*  806 */     addTeeth(com(153), new ItemStack(ItemListMF.hound_Igteeth), 1, 3, ignotumiteTime);
/*      */     
/*  808 */     addRecurve("ingotBronze", new ItemStack(ItemListMF.bowBronze), 0, 0, bronzeTime);
/*  809 */     addRecurve(com(60), new ItemStack(ItemListMF.bowIron), 0, 1, ironTime);
/*  810 */     addRecurve("ingotSteel", new ItemStack(ItemListMF.bowSteel), 0, 2, steelTime);
/*  811 */     addRecurve(com(22), new ItemStack(ItemListMF.bowDragon), 1, 2, dragonforgeTime);
/*  812 */     addRecurve("ingotDeepIron", new ItemStack(ItemListMF.bowDeepIron), 0, 3, deepIronTime);
/*  813 */     addRecurve("ingotMithril", new ItemStack(ItemListMF.bowMithril), 0, 3, mithrilTime);
/*      */     
/*      */ 
/*  816 */     addBolt("ingotBronze", 1, 0, 0, bronzeTime);
/*  817 */     addBolt(com(60), 2, 0, 1, ironTime);
/*  818 */     addBolt("ingotSteel", 3, 0, 2, steelTime);
/*  819 */     addBolt("ingotMithril", 4, 0, 3, mithrilTime);
/*  820 */     addBolt("ingotSilver", 5, 0, 1, ironTime);
/*  821 */     addBolt(com(22), 7, 1, 2, dragonforgeTime);
/*  822 */     addBolt(com(153), 8, 1, 3, ignotumiteTime);
/*  823 */     addBolt("ingotDeepIron", 9, 0, 3, deepIronTime);
/*      */     
/*      */ 
/*  826 */     addArrowhead("ingotBronze", 127, 0, 0, bronzeTime);
/*  827 */     addArrowhead(com(60), 128, 0, 1, ironTime);
/*  828 */     addArrowhead("ingotSteel", 129, 0, 2, steelTime);
/*  829 */     addArrowhead("ingotMithril", 130, 0, 3, mithrilTime);
/*  830 */     addArrowhead("ingotSilver", 131, 0, 1, ironTime);
/*  831 */     addArrowhead(com(22), 133, 1, 2, dragonforgeTime);
/*  832 */     addArrowhead(com(153), 134, 1, 3, ignotumiteTime);
/*  833 */     addArrowhead("ingotDeepIron", 189, 0, 3, deepIronTime);
/*      */     
/*  835 */     addBodkinhead("ingotBronze", 143, 0, 0, bronzeTime);
/*  836 */     addBodkinhead(com(60), 144, 0, 1, ironTime);
/*  837 */     addBodkinhead("ingotSteel", 145, 0, 2, steelTime);
/*  838 */     addBodkinhead("ingotMithril", 146, 0, 3, mithrilTime);
/*  839 */     addBodkinhead("ingotSilver", 147, 0, 1, ironTime);
/*  840 */     addBodkinhead(com(22), 149, 1, 2, dragonforgeTime);
/*  841 */     addBodkinhead(com(153), 150, 1, 3, ignotumiteTime);
/*  842 */     addBodkinhead("ingotDeepIron", 187, 0, 3, deepIronTime);
/*      */     
/*  844 */     addBroadhead("ingotBronze", 135, 0, 0, bronzeTime);
/*  845 */     addBroadhead(com(60), 136, 0, 1, ironTime);
/*  846 */     addBroadhead("ingotSteel", 137, 0, 2, steelTime);
/*  847 */     addBroadhead("ingotMithril", 138, 0, 3, mithrilTime);
/*  848 */     addBroadhead("ingotSilver", 139, 0, 1, ironTime);
/*  849 */     addBroadhead(com(22), 141, 1, 2, dragonforgeTime);
/*  850 */     addBroadhead(com(153), 142, 1, 3, ignotumiteTime);
/*  851 */     addBroadhead("ingotDeepIron", 188, 0, 3, deepIronTime);
/*      */     
/*  853 */     addTongs("ingotTin", new ItemStack(ItemListMF.tongsTin), 0, -1, bronzeTime);
/*  854 */     addTongs("ingotCopper", new ItemStack(ItemListMF.tongsCopper), 0, -1, bronzeTime);
/*  855 */     addTongs("ingotBronze", new ItemStack(ItemListMF.tongsBronze), 0, 0, bronzeTime);
/*  856 */     addTongs(com(60), new ItemStack(ItemListMF.tongsIron), 0, 1, ironTime);
/*  857 */     addTongs("ingotSteel", new ItemStack(ItemListMF.tongsSteel), 0, 2, steelTime);
/*  858 */     addTongs(com(22), new ItemStack(ItemListMF.tongsDragon), 1, 2, dragonforgeTime);
/*  859 */     addTongs("ingotMithril", new ItemStack(ItemListMF.tongsMithril), 0, 3, mithrilTime);
/*  860 */     addTongs("ingotDeepIron", new ItemStack(ItemListMF.tongsDeepIron), 0, 3, deepIronTime);
/*      */     
/*  862 */     addHammer(0, "ingotTin", new ItemStack(ItemListMF.hammerTin), 0, -1, bronzeTime);
/*  863 */     addHammer(0, "ingotCopper", new ItemStack(ItemListMF.hammerCopper), 0, -1, bronzeTime);
/*  864 */     addHammer(1, "ingotBronze", new ItemStack(ItemListMF.hammerBronze), 0, 0, bronzeTime);
/*  865 */     addHammer(1, com(60), new ItemStack(ItemListMF.hammerIron), 0, 1, ironTime);
/*  866 */     addHammer(2, "ingotSteel", new ItemStack(ItemListMF.hammerSteel), 0, 2, steelTime);
/*  867 */     addHammer(2, com(22), new ItemStack(ItemListMF.hammerDragon), 1, 2, dragonforgeTime);
/*  868 */     addHammer(3, "ingotMithril", new ItemStack(ItemListMF.hammerMithril), 0, 3, mithrilTime);
/*  869 */     addHammer(3, "ingotDeepIron", new ItemStack(ItemListMF.hammerDeepIron), 0, 3, deepIronTime);
/*      */     
/*  871 */     addLance(1, "ingotBronze", new ItemStack(ItemListMF.lanceBronze), 0, 0, bronzeTime);
/*  872 */     addLance(1, com(60), new ItemStack(ItemListMF.lanceIron), 0, 1, ironTime);
/*  873 */     addLance(2, "ingotSteel", new ItemStack(ItemListMF.lanceSteel), 0, 2, steelTime);
/*  874 */     addLance(3, "ingotMithril", new ItemStack(ItemListMF.lanceMithril), 0, 3, mithrilTime);
/*  875 */     addLance(2, com(22), new ItemStack(ItemListMF.lanceDragon), 1, 2, dragonforgeTime);
/*  876 */     addLance(4, com(153), new ItemStack(ItemListMF.lanceIgnotumite), 1, 3, ignotumiteTime);
/*      */     
/*  878 */     addOven("ingotBronze", new ItemStack(MineFantasyBase.MFBlockOven, 1, 0), 0, 0, bronzeTime);
/*  879 */     addOven(com(60), new ItemStack(MineFantasyBase.MFBlockOven, 1, 2), 0, 1, ironTime);
/*  880 */     addOven("ingotSteel", new ItemStack(MineFantasyBase.MFBlockOven, 1, 4), 0, 2, steelTime);
/*  881 */     addOven("ingotDeepIron", new ItemStack(MineFantasyBase.MFBlockOven, 1, 6), 0, 3, deepIronTime);
/*      */     
/*  883 */     addPlating("ingotBronze", com(72, 4), 0, 0, bronzeTime);
/*  884 */     addPlating(com(60), com(61, 4), 0, 1, ironTime);
/*  885 */     addPlating("ingotSteel", com(117, 4), 0, 2, steelTime);
/*  886 */     addPlating2("ingotSteel", Item.field_77702_n, com(68, 4), 0, 2, encrustedTime);
/*  887 */     addPlating("ingotMithril", com(95, 4), 0, 3, mithrilTime);
/*  888 */     addPlating("ingotDeepIron", com(182, 4), 0, 3, deepIronTime);
/*  889 */     addPlating2("ingotSilver", com(167), com(173, 4), 0, 1, ironTime);
/*  890 */     addPlating(com(22), com(118, 4), 1, 2, dragonforgeTime);
/*      */     
/*  892 */     addPlatingPadded(com(72), com(73), 0, 0, bronzeTime);
/*  893 */     addPlatingPadded(com(61), com(63), 0, 1, ironTime);
/*  894 */     addPlatingPadded(com(117), com(28), 0, 2, steelTime);
/*  895 */     addPlatingPadded(com(95), com(96), 0, 3, mithrilTime);
/*  896 */     addPlatingPadded(com(182), com(184), 0, 3, deepIronTime);
/*  897 */     addPlatingPadded(com(173), com(172), 0, 1, ironTime);
/*  898 */     addPlatingPadded(com(118), com(119), 1, 2, dragonforgeTime);
/*  899 */     addPlatingPadded(com(68), com(69), 0, 2, encrustedTime);
/*      */     
/*  901 */     addPlatingCurved(com(72), com(74), 0, 0, bronzeTime);
/*  902 */     addPlatingCurved(com(61), com(67), 0, 1, ironTime);
/*  903 */     addPlatingCurved(com(117), com(29), 0, 2, steelTime);
/*  904 */     addPlatingCurved(com(95), com(97), 0, 3, mithrilTime);
/*  905 */     addPlatingCurved(com(182), com(183), 0, 3, deepIronTime);
/*  906 */     addPlatingCurved(com(173), com(174), 0, 1, ironTime);
/*  907 */     addPlatingCurved(com(118), com(120), 1, 2, dragonforgeTime);
/*  908 */     addPlatingCurved(com(68), com(70), 0, 2, encrustedTime);
/*      */     
/*  910 */     if (bg()) {
/*  911 */       addBuckler("ingotBronze", new ItemStack(ItemListMF.bucklerBronze), 0, 0, bronzeTime);
/*  912 */       addBuckler(com(60), new ItemStack(ItemListMF.bucklerIron), 0, 1, ironTime);
/*  913 */       addBuckler("ingotSteel", new ItemStack(ItemListMF.bucklerSteel), 0, 2, steelTime);
/*  914 */       addBuckler("ingotDeepIron", new ItemStack(ItemListMF.bucklerDeepIron), 0, 3, deepIronTime);
/*  915 */       addBuckler("ingotMithril", new ItemStack(ItemListMF.bucklerMithril), 0, 3, mithrilTime);
/*  916 */       addBuckler(com(22), new ItemStack(ItemListMF.bucklerDragonforge), 1, 2, dragonforgeTime);
/*      */       
/*  918 */       addKite(0, "ingotBronze", new ItemStack(ItemListMF.kiteBronze), 0, 0, bronzeTime);
/*  919 */       addKite(0, com(60), new ItemStack(ItemListMF.kiteIron), 0, 1, ironTime);
/*  920 */       addKite(0, "ingotSteel", new ItemStack(ItemListMF.kiteSteel), 0, 2, steelTime);
/*  921 */       addKite(1, "ingotMithril", new ItemStack(ItemListMF.kiteMithril), 0, 3, mithrilTime);
/*  922 */       addKite(1, "ingotDeepIron", new ItemStack(ItemListMF.kiteDeepIron), 0, 3, deepIronTime);
/*  923 */       addKite(0, com(22), new ItemStack(ItemListMF.kiteDragonforge), 1, 2, dragonforgeTime);
/*      */       
/*  925 */       addTower(0, "ingotBronze", new ItemStack(ItemListMF.towerBronze), 0, 0, bronzeTime);
/*  926 */       addTower(0, com(60), new ItemStack(ItemListMF.towerIron), 0, 1, ironTime);
/*  927 */       addTower(0, "ingotSteel", new ItemStack(ItemListMF.towerSteel), 0, 2, steelTime);
/*  928 */       addTower(1, "ingotMithril", new ItemStack(ItemListMF.towerMithril), 0, 3, mithrilTime);
/*  929 */       addTower(1, "ingotDeepIron", new ItemStack(ItemListMF.towerDeepIron), 0, 3, deepIronTime);
/*  930 */       addTower(0, com(22), new ItemStack(ItemListMF.towerDragonforge), 1, 2, dragonforgeTime);
/*      */       
/*  932 */       addRound(0, new ItemStack(ItemListMF.plank), new ItemStack(ItemListMF.shieldWood), 0, 0, bronzeTime);
/*  933 */       addRound(1, com(25), new ItemStack(ItemListMF.shieldIronbark), 0, 1, bronzeTime * 2);
/*  934 */       addRound(1, com(114), new ItemStack(ItemListMF.shieldEbony), 0, 1, bronzeTime * 3);
/*      */     }
/*      */     
/*      */ 
/*  938 */     addPlateAssembly(72, 74, 73, new Item[] { ItemListMF.helmetBronzePlate, ItemListMF.plateBronzePlate, ItemListMF.legsBronzePlate, ItemListMF.bootsBronzePlate }, 0, 0, bronzeTime);
/*      */     
/*      */ 
/*  941 */     addPlateAssembly(61, 67, 63, new Item[] { ItemListMF.helmetIronPlate, ItemListMF.plateIronPlate, ItemListMF.legsIronPlate, ItemListMF.bootsIronPlate }, 0, 1, ironTime);
/*      */     
/*      */ 
/*  944 */     addPlateAssembly(173, 174, 172, new Item[] { ItemListMF.helmetGuildedPlate, ItemListMF.plateGuildedPlate, ItemListMF.legsGuildedPlate, ItemListMF.bootsGuildedPlate }, 0, 1, ironTime);
/*      */     
/*      */ 
/*  947 */     addPlateAssembly(117, 29, 28, new Item[] { ItemListMF.helmetSteelPlate, ItemListMF.plateSteelPlate, ItemListMF.legsSteelPlate, ItemListMF.bootsSteelPlate }, 0, 2, steelTime);
/*      */     
/*      */ 
/*  950 */     addPlateAssembly(68, 70, 69, new Item[] { ItemListMF.helmetEncrustedPlate, ItemListMF.plateEncrustedPlate, ItemListMF.legsEncrustedPlate, ItemListMF.bootsEncrustedPlate }, 0, 2, encrustedTime);
/*      */     
/*      */ 
/*      */ 
/*  954 */     addPlateAssembly(118, 120, 119, new Item[] { ItemListMF.helmetDragonPlate, ItemListMF.plateDragonPlate, ItemListMF.legsDragonPlate, ItemListMF.bootsDragonPlate }, 1, 2, dragonforgeTime);
/*      */     
/*      */ 
/*  957 */     addPlateAssembly(182, 183, 184, new Item[] { ItemListMF.helmetDeepIronPlate, ItemListMF.plateDeepIronPlate, ItemListMF.legsDeepIronPlate, ItemListMF.bootsDeepIronPlate }, 0, 3, deepIronTime);
/*      */     
/*      */ 
/*  960 */     addPlateAssembly(95, 97, 96, new Item[] { ItemListMF.helmetMithrilPlate, ItemListMF.plateMithrilPlate, ItemListMF.legsMithrilPlate, ItemListMF.bootsMithrilPlate }, 0, 3, mithrilTime);
/*      */   }
/*      */   
/*      */   private static boolean bg() {
/*  964 */     return (MineFantasyBase.isBGLoaded()) || (MineFantasyBase.isDebug());
/*      */   }
/*      */   
/*      */   private static void addPlating2(String ore, Object material2, ItemStack output, int hammer, int anvil, int matTime) {
/*  968 */     for (ItemStack material : OreDictionary.getOres(ore))
/*  969 */       addPlating2(material, material2, output, hammer, anvil, matTime);
/*      */   }
/*      */   
/*      */   private static void addPlating2(Object material, Object material2, ItemStack output, int hammer, int anvil, int matTime) {
/*  973 */     MineFantasyAPI.addAnvilRecipe(output, false, hammer, anvil, (int)(matTime * 0.5F), new Object[] { "A ", "MM", Character.valueOf('A'), material2, Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addPlating(String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/*  978 */     for (ItemStack material : OreDictionary.getOres(ore))
/*  979 */       addPlating(material, output, hammer, anvil, matTime);
/*      */   }
/*      */   
/*      */   private static void addPlating(Object material, ItemStack output, int hammer, int anvil, int matTime) {
/*  983 */     MineFantasyAPI.addAnvilRecipe(output, false, hammer, anvil, (int)(matTime * 0.5F), new Object[] { "MM", Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addPlatingPadded(Object material, ItemStack output, int hammer, int anvil, int matTime) {
/*  987 */     MineFantasyAPI.addAnvilRecipe(output, false, hammer, anvil, (int)(matTime * 0.5F), new Object[] { "M", "P", Character.valueOf('P'), com(9), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addPlatingCurved(Object material, ItemStack output, int hammer, int anvil, int matTime) {
/*  991 */     MineFantasyAPI.addAnvilRecipe(output, false, hammer, anvil, (int)(matTime * 0.25F), new Object[] { "M", Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addSpade(int lvl, String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/*  996 */     for (ItemStack material : OreDictionary.getOres(ore))
/*  997 */       addSpade(lvl, material, output, hammer, anvil, matTime);
/*      */   }
/*      */   
/*      */   private static void addSpade(int lvl, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1001 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, matTime, new Object[] { "AAA", "PPM", "AAA", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addAxe(int lvl, String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1006 */     for (ItemStack material : OreDictionary.getOres(ore)) {
/* 1007 */       addAxe(lvl, material, output, hammer, anvil, matTime);
/*      */     }
/*      */   }
/*      */   
/*      */   private static void addAxe(int lvl, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1012 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 3.2F), new Object[] { "AMM", "PPM", "AAA", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/* 1013 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 3.2F), new Object[] { "AAA", "PPM", "AMM", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addHoe(int lvl, String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1018 */     for (ItemStack material : OreDictionary.getOres(ore)) {
/* 1019 */       addHoe(lvl, material, output, hammer, anvil, matTime);
/*      */     }
/*      */   }
/*      */   
/*      */   private static void addHoe(int lvl, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1024 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 3.2F), new Object[] { "AAM", "PPM", "AAA", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/* 1025 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 3.2F), new Object[] { "AAA", "PPM", "AAM", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addPick(int lvl, String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1030 */     for (ItemStack material : OreDictionary.getOres(ore))
/* 1031 */       addPick(lvl, material, output, hammer, anvil, matTime);
/*      */   }
/*      */   
/*      */   private static void addPick(int lvl, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1035 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, matTime * 3, new Object[] { "AAM", "PPM", "AAM", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addHandpick(int lvl, String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1040 */     for (ItemStack material : OreDictionary.getOres(ore))
/* 1041 */       addHandpick(lvl, material, output, hammer, anvil, matTime);
/*      */   }
/*      */   
/*      */   private static void addHandpick(int lvl, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1045 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, matTime, new Object[] { "AM", "PM", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/* 1046 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, matTime, new Object[] { "PM", "AM", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addKnife(int lvl, String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1051 */     for (ItemStack material : OreDictionary.getOres(ore))
/* 1052 */       addKnife(lvl, material, output, hammer, anvil, matTime);
/*      */   }
/*      */   
/*      */   private static void addKnife(int lvl, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1056 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 0.5F), new Object[] { "M", "M", "P", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addShears(int lvl, String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1061 */     for (ItemStack material : OreDictionary.getOres(ore))
/* 1062 */       addShears(lvl, material, output, hammer, anvil, matTime);
/*      */   }
/*      */   
/*      */   private static void addShears(int lvl, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1066 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, matTime, new Object[] { "PM", "MA", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/* 1067 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, matTime, new Object[] { "MA", "PM", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addDagger(int lvl, String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1072 */     for (ItemStack material : OreDictionary.getOres(ore))
/* 1073 */       addDagger(lvl, material, output, hammer, anvil, matTime);
/*      */   }
/*      */   
/*      */   private static void addDagger(int lvl, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1077 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 0.6F), new Object[] { "PMM", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addMace(int lvl, String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1082 */     for (ItemStack material : OreDictionary.getOres(ore)) {
/* 1083 */       addMace(lvl, material, output, hammer, anvil, matTime);
/*      */     }
/*      */   }
/*      */   
/*      */   private static void addMace(int lvl, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1088 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 1.5F), new Object[] { "AAMM", "PPMM", "AAAA", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */     
/* 1090 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 1.5F), new Object[] { "AAAA", "PPMM", "AAMM", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addWaraxe(int lvl, String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1095 */     for (ItemStack material : OreDictionary.getOres(ore)) {
/* 1096 */       addWaraxe(lvl, material, output, hammer, anvil, matTime);
/*      */     }
/*      */   }
/*      */   
/*      */   private static void addWaraxe(int lvl, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1101 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 1.5F), new Object[] { "AMM", "PPM", "AAM", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/* 1102 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 1.5F), new Object[] { "AAM", "PPM", "AMM", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addSword(int lvl, String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1107 */     for (ItemStack material : OreDictionary.getOres(ore))
/* 1108 */       addSword(lvl, material, output, hammer, anvil, matTime);
/*      */   }
/*      */   
/*      */   private static void addSword(int lvl, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1112 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 2.0F), new Object[] { "AMAA", "PMMM", "AMAA", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addGreatsword(int lvl, String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1117 */     for (ItemStack material : OreDictionary.getOres(ore))
/* 1118 */       addGreatsword(lvl, material, output, hammer, anvil, matTime);
/*      */   }
/*      */   
/*      */   private static void addGreatsword(int lvl, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1122 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 3.5F), new Object[] { "AMAAAA", "PMMMMM", "AMAAAA", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addLance(int lvl, String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1127 */     for (ItemStack material : OreDictionary.getOres(ore))
/* 1128 */       addLance(lvl, material, output, hammer, anvil, matTime);
/*      */   }
/*      */   
/*      */   private static void addLance(int lvl, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1132 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 7.0F), new Object[] { "  M     ", "MMPMMMMM", "  M     ", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addBroadsword(int lvl, String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1137 */     for (ItemStack material : OreDictionary.getOres(ore)) {
/* 1138 */       addBroadsword(lvl, material, output, hammer, anvil, matTime);
/*      */     }
/*      */   }
/*      */   
/*      */   private static void addBroadsword(int lvl, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1143 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 2.5F), new Object[] { "AMMM", "PMMM", "AMAA", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/* 1144 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 2.5F), new Object[] { "AMAA", "PMMM", "AMMM", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addGreatmace(int lvl, String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1149 */     for (ItemStack material : OreDictionary.getOres(ore)) {
/* 1150 */       addGreatmace(lvl, material, output, hammer, anvil, matTime);
/*      */     }
/*      */   }
/*      */   
/*      */   private static void addGreatmace(int lvl, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1155 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 1.8F), new Object[] { "AAAAAAA", "MPPPPMM", "AAAAAMM", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */     
/* 1157 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 1.2F), new Object[] { "AAAAAMM", "MPPPPMM", "AAAAAAA", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addWarhammer(int lvl, String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1162 */     for (ItemStack material : OreDictionary.getOres(ore)) {
/* 1163 */       addWarhammer(lvl, material, output, hammer, anvil, matTime);
/*      */     }
/*      */   }
/*      */   
/*      */   private static void addWarhammer(int lvl, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1168 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 2.0F), new Object[] { "AAAAAAM", "MPPPPMM", "AAAAAMM", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */     
/* 1170 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 1.5F), new Object[] { "AAAAAMM", "MPPPPMM", "AAAAAAM", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addSpear(int lvl, String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1175 */     for (ItemStack material : OreDictionary.getOres(ore)) {
/* 1176 */       addSpear(lvl, material, output, hammer, anvil, matTime);
/*      */     }
/*      */   }
/*      */   
/*      */   private static void addSpear(int lvl, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1181 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 2.5F), new Object[] { "AAAAMA", "PPPPPM", "AAAAMA", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addHalbeard(int lvl, String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1186 */     for (ItemStack material : OreDictionary.getOres(ore)) {
/* 1187 */       addHalbeard(lvl, material, output, hammer, anvil, matTime);
/*      */     }
/*      */   }
/*      */   
/*      */   private static void addHalbeard(int lvl, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1192 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 3.0F), new Object[] { "AAAAMM", "PPPPPM", "AAAAMA", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/* 1193 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 3.0F), new Object[] { "AAAAMA", "PPPPPM", "AAAAMM", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addBattleaxe(int lvl, String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1198 */     for (ItemStack material : OreDictionary.getOres(ore)) {
/* 1199 */       addBattleaxe(lvl, material, output, hammer, anvil, matTime);
/*      */     }
/*      */   }
/*      */   
/*      */   private static void addBattleaxe(int lvl, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1204 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 4.0F), new Object[] { "AAAAMM", "MPPPPM", "AAAAMM", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addScythe(int lvl, String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1209 */     for (ItemStack material : OreDictionary.getOres(ore)) {
/* 1210 */       addScythe(lvl, material, output, hammer, anvil, matTime);
/*      */     }
/*      */   }
/*      */   
/*      */   private static void addScythe(int lvl, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1215 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 3.3F), new Object[] { "AAAMA", "AAAAM", "AAPAM", "PPPPM", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */     
/* 1217 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 3.3F), new Object[] { "PPPPM", "AAPAM", "AAAAM", "AAAMA", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addRake(int lvl, String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1222 */     for (ItemStack material : OreDictionary.getOres(ore)) {
/* 1223 */       addRake(lvl, material, output, hammer, anvil, matTime);
/*      */     }
/*      */   }
/*      */   
/*      */   private static void addRake(int lvl, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1228 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 1.5F), new Object[] { "AAAM", "PPMA", "AAAM", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addMattock(int lvl, String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1233 */     for (ItemStack material : OreDictionary.getOres(ore)) {
/* 1234 */       addMattock(lvl, material, output, hammer, anvil, matTime);
/*      */     }
/*      */   }
/*      */   
/*      */   private static void addMattock(int lvl, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1239 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 2.0F), new Object[] { "AMA", "PPM", "AAM", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */     
/* 1241 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 2.0F), new Object[] { "AAM", "PPM", "AMA", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addSaw(int lvl, String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1246 */     for (ItemStack material : OreDictionary.getOres(ore)) {
/* 1247 */       addSaw(lvl, material, output, hammer, anvil, matTime);
/*      */     }
/*      */   }
/*      */   
/*      */   private static void addSaw(int lvl, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1252 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 2.2F), new Object[] { "PMMMM", "PMMMA", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addWarpick(int lvl, String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1257 */     for (ItemStack material : OreDictionary.getOres(ore)) {
/* 1258 */       addWarpick(lvl, material, output, hammer, anvil, matTime);
/*      */     }
/*      */   }
/*      */   
/*      */   private static void addWarpick(int lvl, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1263 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 2.8F), new Object[] { "AAMM", "PPMM", "AAAM", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */     
/* 1265 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 2.8F), new Object[] { "AAAM", "PPMM", "AAMM", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addTeeth(String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1270 */     for (ItemStack material : OreDictionary.getOres(ore))
/* 1271 */       addTeeth(material, output, hammer, anvil, matTime);
/*      */   }
/*      */   
/*      */   private static void addTeeth(Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1275 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 1.5F), new Object[] { "MB", " M", "MB", Character.valueOf('B'), com(27), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addRecurve(String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1280 */     for (ItemStack material : OreDictionary.getOres(ore))
/* 1281 */       addRecurve(material, output, hammer, anvil, matTime);
/*      */   }
/*      */   
/*      */   private static void addRecurve(Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1285 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 2.0F), new Object[] { "MSSM", "M  M", " LL ", Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('S'), Item.field_77683_K, Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addBolt(String ore, int output, int hammer, int anvil, int matTime)
/*      */   {
/* 1290 */     for (ItemStack material : OreDictionary.getOres(ore))
/* 1291 */       addBolt(material, output, hammer, anvil, matTime);
/*      */   }
/*      */   
/*      */   private static void addBolt(Object material, int output, int hammer, int anvil, int matTime) {
/* 1295 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.boltMF, 8, output), false, hammer, anvil, (int)(matTime * 2.5F), new Object[] { "M", "F", Character.valueOf('F'), com(23), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addArrowhead(String ore, int output, int hammer, int anvil, int matTime)
/*      */   {
/* 1300 */     for (ItemStack material : OreDictionary.getOres(ore))
/* 1301 */       addArrowhead(material, output, hammer, anvil, matTime);
/*      */   }
/*      */   
/*      */   private static void addArrowhead(Object material, int output, int hammer, int anvil, int matTime) {
/* 1305 */     MineFantasyAPI.addAnvilRecipe(com(output, 16), false, hammer, anvil, (int)(matTime * 1.0F), new Object[] { "M ", " M", "M ", Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addBroadhead(String ore, int output, int hammer, int anvil, int matTime)
/*      */   {
/* 1310 */     for (ItemStack material : OreDictionary.getOres(ore))
/* 1311 */       addBroadhead(material, output, hammer, anvil, matTime);
/*      */   }
/*      */   
/*      */   private static void addBroadhead(Object material, int output, int hammer, int anvil, int matTime) {
/* 1315 */     MineFantasyAPI.addAnvilRecipe(com(output, 16), false, hammer, anvil, (int)(matTime * 2.0F), new Object[] { "  M ", "MMMM", "  M ", Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addBodkinhead(String ore, int output, int hammer, int anvil, int matTime)
/*      */   {
/* 1320 */     for (ItemStack material : OreDictionary.getOres(ore))
/* 1321 */       addBodkinhead(material, output, hammer, anvil, matTime);
/*      */   }
/*      */   
/*      */   private static void addBodkinhead(Object material, int output, int hammer, int anvil, int matTime) {
/* 1325 */     MineFantasyAPI.addAnvilRecipe(com(output, 16), false, hammer, anvil, (int)(matTime * 1.5F), new Object[] { "M  ", " MM", "M  ", Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addTongs(String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1330 */     for (ItemStack material : OreDictionary.getOres(ore))
/* 1331 */       addTongs(material, output, hammer, anvil, matTime);
/*      */   }
/*      */   
/*      */   private static void addTongs(Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1335 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 0.5F), new Object[] { " M", "M ", Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addHammer(int lvl, String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1340 */     for (ItemStack material : OreDictionary.getOres(ore))
/* 1341 */       addHammer(lvl, material, output, hammer, anvil, matTime);
/*      */   }
/*      */   
/*      */   private static void addHammer(int lvl, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1345 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 0.5F), new Object[] { "M", "P", Character.valueOf('P'), haft(lvl), Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static ItemStack haft(int level) {
/* 1349 */     int type = 0;
/* 1350 */     switch (level) {
/*      */     case 0: 
/* 1352 */       return new ItemStack(ItemListMF.plank);
/*      */     case 1: 
/* 1354 */       type = 59;
/* 1355 */       break;
/*      */     case 2: 
/* 1357 */       type = 65;
/* 1358 */       break;
/*      */     case 3: 
/* 1360 */       type = 77;
/* 1361 */       break;
/*      */     case 4: 
/* 1363 */       type = 83;
/* 1364 */       break;
/*      */     case 5: 
/* 1366 */       type = 81;
/*      */     }
/*      */     
/* 1369 */     return com(type);
/*      */   }
/*      */   
/*      */   private static void addFurnaces() {
/* 1373 */     GameRegistry.addRecipe(new ItemStack(MineFantasyBase.MFBlockFurnace, 1, 0), new Object[] { "SSS", "S S", "SFS", Character.valueOf('S'), Block.field_71978_w, Character.valueOf('F'), MineFantasyBase.MFBlockForge });
/*      */     
/* 1375 */     addFurnace(0, "ingotBronze", new ItemStack(MineFantasyBase.MFBlockFurnace, 1, 1), 0, 0, bronzeTime);
/* 1376 */     addFurnace(1, com(60), new ItemStack(MineFantasyBase.MFBlockFurnace, 1, 2), 0, 1, ironTime);
/* 1377 */     addFurnace(2, "ingotSteel", new ItemStack(MineFantasyBase.MFBlockFurnace, 1, 3), 0, 2, steelTime);
/* 1378 */     addFurnace(3, "ingotDeepIron", new ItemStack(MineFantasyBase.MFBlockFurnace, 1, 4), 0, 3, deepIronTime);
/* 1379 */     if (cfg.hardcoreObsidianForge) {
/* 1380 */       MineFantasyAPI.addAnvilRecipe(new ItemStack(MineFantasyBase.MFBlockForge, 1, 2), 0, 1, 1500, new Object[] { " DDD ", "O C O", "OCCCO", "IOOOI", Character.valueOf('D'), Item.field_77702_n, Character.valueOf('O'), Block.field_72089_ap, Character.valueOf('C'), com(91) });
/*      */     } else {
/* 1382 */       MineFantasyAPI.addAnvilRecipe(new ItemStack(MineFantasyBase.MFBlockForge, 1, 2), 0, 1, 1500, new Object[] { " DDD ", "O C O", "OCCCO", "IOOOI", Character.valueOf('D'), Item.field_77702_n, Character.valueOf('O'), Block.field_72089_ap, Character.valueOf('C'), com(90) });
/*      */     }
/*      */   }
/*      */   
/*      */   private static void addMisc() {
/* 1387 */     MineFantasyAPI.addAnvilRecipe(com(58), 0, 0, bronzeTime, new Object[] { "II", "II", Character.valueOf('I'), com(122) });
/* 1388 */     MineFantasyAPI.addAnvilRecipe(com(60), 0, 1, ironTime, new Object[] { "II", "II", Character.valueOf('I'), com(2) });
/* 1389 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.ingotSteel), 0, 2, steelTime, new Object[] { "II", "II", Character.valueOf('I'), com(123) });
/* 1390 */     MineFantasyAPI.addAnvilRecipe(com(185), 0, 3, deepIronTime, new Object[] { "II", "II", Character.valueOf('I'), com(186) });
/* 1391 */     MineFantasyAPI.addAnvilRecipe(com(55), 0, 3, mithrilTime, new Object[] { "II", "II", Character.valueOf('I'), com(124) });
/*      */     
/* 1393 */     MineFantasyAPI.addShapelessAnvilRecipe(new ItemStack(ItemListMF.ingotSteel), true, 0, 0, 400, new Object[] { com(166), com(166), com(166) });
/*      */     
/* 1395 */     MineFantasyAPI.addAnvilRecipe(com(125, 4), 0, 0, 400, new Object[] { " I ", "I I", " I ", Character.valueOf('I'), com(122) });
/*      */     
/* 1397 */     MineFantasyAPI.addAnvilRecipe(com(125, 6), 0, 1, 400, new Object[] { " I ", "I I", " I ", Character.valueOf('I'), com(2) });
/*      */     
/* 1399 */     MineFantasyAPI.addAnvilRecipe(com(125, 8), 0, 2, 400, new Object[] { " I ", "I I", " I ", Character.valueOf('I'), com(123) });
/* 1400 */     MineFantasyAPI.addAnvilRecipe(com(125, 10), 0, 3, 400, new Object[] { " I ", "I I", " I ", Character.valueOf('I'), com(186) });
/* 1401 */     MineFantasyAPI.addAnvilRecipe(com(125, 12), 0, 3, 400, new Object[] { " I ", "I I", " I ", Character.valueOf('I'), com(124) });
/*      */     
/* 1403 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.needleBronze), true, 0, 0, bronzeTime, new Object[] { "I", "I", "I", "I", Character.valueOf('I'), com(122) });
/*      */     
/* 1405 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.needleIron), true, 0, 1, ironTime, new Object[] { "I", "I", "I", "I", Character.valueOf('I'), com(2) });
/*      */     
/* 1407 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.needleSteel), true, 0, 2, steelTime, new Object[] { "I", "I", "I", "I", Character.valueOf('I'), com(123) });
/* 1408 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.needleDeepIron), true, 0, 3, deepIronTime, new Object[] { "I", "I", "I", "I", Character.valueOf('I'), com(186) });
/* 1409 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.needleMithril), true, 0, 3, mithrilTime, new Object[] { "I", "I", "I", "I", Character.valueOf('I'), com(124) });
/*      */   }
/*      */   
/*      */   private static void addBows() {
/* 1413 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.shortbow), 0, 0, 500, new Object[] { "PSSP", " PP ", Character.valueOf('S'), Item.field_77683_K, Character.valueOf('P'), ItemListMF.plank });
/*      */     
/* 1415 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bowComposite), 0, 1, 1000, new Object[] { "BSSB", "P  P", " LL ", Character.valueOf('B'), Item.field_77755_aX, Character.valueOf('S'), Item.field_77683_K, Character.valueOf('P'), ItemListMF.plank, Character.valueOf('L'), Item.field_77770_aF });
/* 1416 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bowIronbark), 0, 1, 1500, new Object[] { "PSSP", "P  P", " LL ", Character.valueOf('S'), Item.field_77683_K, Character.valueOf('P'), com(25), Character.valueOf('L'), Item.field_77770_aF });
/*      */     
/* 1418 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.bowEbony), 0, 1, 2000, new Object[] { "PSSP", "P  P", " LL ", Character.valueOf('S'), Item.field_77683_K, Character.valueOf('P'), com(114), Character.valueOf('L'), Item.field_77770_aF });
/*      */     
/* 1420 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.longbow), 0, 0, 800, new Object[] { "PSSSP", "P   P", " PLP ", Character.valueOf('S'), Item.field_77683_K, Character.valueOf('P'), ItemListMF.plank, Character.valueOf('L'), Item.field_77770_aF });
/*      */   }
/*      */   
/*      */   private static void addOven(String ore, ItemStack output, int hammer, int anvil, int matTime) {
/* 1424 */     for (ItemStack material : OreDictionary.getOres(ore))
/* 1425 */       addOven(material, output, hammer, anvil, matTime);
/*      */   }
/*      */   
/*      */   private static void addOven(Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1429 */     MineFantasyAPI.addAnvilRecipe(output, false, hammer, anvil, matTime * 5, new Object[] { "MMM", "M M", "MMM", Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addFurnace(int stonelvl, String ore, ItemStack output, int hammer, int anvil, int matTime) {
/* 1433 */     for (ItemStack material : OreDictionary.getOres(ore))
/* 1434 */       addFurnace(stonelvl, material, output, hammer, anvil, matTime);
/*      */   }
/*      */   
/*      */   private static void addFurnace(int stonelvl, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1438 */     Block[] stone = { Block.field_71978_w, MineFantasyBase.MFBlockSlate, MineFantasyBase.MFBlockGranite, Block.field_72089_ap };
/* 1439 */     MineFantasyAPI.addAnvilRecipe(output, false, hammer, anvil, matTime * 8, new Object[] { "MMM", "M M", "MMM", "SFS", Character.valueOf('F'), MineFantasyBase.MFBlockForge, Character.valueOf('S'), stone[stonelvl], Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addRepair() {
/* 1443 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hammerRepair), true, 0, 1, ironTime * 2, new Object[] { "SM", "H ", Character.valueOf('M'), com(60), Character.valueOf('S'), Item.field_77761_aM, Character.valueOf('H'), haft(1) });
/*      */     
/* 1445 */     for (ItemStack metal : OreDictionary.getOres("ingotSteel")) {
/* 1446 */       MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hammerRepair2), true, 0, 2, steelTime * 2, new Object[] { "SM", "H ", Character.valueOf('M'), metal, Character.valueOf('S'), Item.field_77761_aM, Character.valueOf('H'), haft(2) });
/*      */     }
/* 1448 */     for (ItemStack metal : OreDictionary.getOres("ingotMithril")) {
/* 1449 */       MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hammerRepairArtisan), true, 0, 3, mithrilTime * 2, new Object[] { "SM", "H ", Character.valueOf('M'), metal, Character.valueOf('S'), Item.field_77761_aM, Character.valueOf('H'), haft(3) });
/*      */     }
/* 1451 */     for (ItemStack silver : OreDictionary.getOres("ingotSilver")) {
/* 1452 */       MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hammerRepairOrnate), true, 1, 1, 700, new Object[] { " L ", "SHS", " G ", Character.valueOf('S'), silver, Character.valueOf('G'), Item.field_77717_p, Character.valueOf('L'), new ItemStack(Item.field_77756_aW, 1, 4), Character.valueOf('H'), ItemListMF.hammerRepair });
/* 1453 */       MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hammerRepairOrnate2), true, 1, 2, 1400, new Object[] { " L ", "SHS", " G ", Character.valueOf('S'), silver, Character.valueOf('G'), Item.field_77717_p, Character.valueOf('L'), new ItemStack(Item.field_77756_aW, 1, 4), Character.valueOf('H'), ItemListMF.hammerRepair2 });
/* 1454 */       MineFantasyAPI.addAnvilRecipe(new ItemStack(ItemListMF.hammerRepairOrnateArtisan), true, 1, 3, 2100, new Object[] { " L ", "SHS", " G ", Character.valueOf('S'), silver, Character.valueOf('G'), Item.field_77717_p, Character.valueOf('L'), new ItemStack(Item.field_77756_aW, 1, 4), Character.valueOf('H'), ItemListMF.hammerRepairArtisan });
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static void addPlateAssembly(int plate, int curve, int padding, Item[] output, int hammer, int anvil, int time)
/*      */   {
/* 1462 */     addPlateAssembly(com(plate), com(curve), com(padding), output, hammer, anvil, time);
/*      */   }
/*      */   
/*      */   public static void addPlateAssembly(ItemStack plate, ItemStack curve, ItemStack padding, Item[] output, int hammer, int anvil, int time)
/*      */   {
/* 1467 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(output[0]), hammer, anvil, (int)(time * 2.5F), new Object[] { " pPp ", "PCCCP", " C C ", Character.valueOf('P'), plate, Character.valueOf('p'), curve, Character.valueOf('C'), padding });
/*      */     
/* 1469 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(output[1]), hammer, anvil, (int)(time * 4.0F), new Object[] { " p p ", "PC CP", "PCCCP", "PCCCP", Character.valueOf('P'), plate, Character.valueOf('p'), curve, Character.valueOf('C'), padding });
/*      */     
/* 1471 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(output[2]), hammer, anvil, (int)(time * 3.5F), new Object[] { " pPp ", "PCCCP", "PC CP", " C C ", Character.valueOf('P'), plate, Character.valueOf('p'), curve, Character.valueOf('C'), padding });
/*      */     
/* 1473 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(output[3]), hammer, anvil, (int)(time * 2.0F), new Object[] { " C C ", " C C ", "Pp pP", Character.valueOf('P'), plate, Character.valueOf('p'), curve, Character.valueOf('C'), padding });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static void addHoundPlate(int plate, int padding, Item[] output, int hammer, int anvil, int time)
/*      */   {
/* 1480 */     addHoundPlate(com(plate), com(padding), output, hammer, anvil, time);
/*      */   }
/*      */   
/*      */   public static void addHoundPlate(ItemStack plate, ItemStack padding, Item[] output, int hammer, int anvil, int time)
/*      */   {
/* 1485 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(output[1]), hammer, anvil, (int)(time * 3.0F), new Object[] { "  PP", " PCC", "PCC ", Character.valueOf('P'), plate, Character.valueOf('C'), padding });
/*      */     
/*      */ 
/* 1488 */     MineFantasyAPI.addAnvilRecipe(new ItemStack(output[0]), hammer, anvil, (int)(time * 5.0F), new Object[] { "   PP", " PPCC", "CCCC ", " C C ", Character.valueOf('P'), plate, Character.valueOf('C'), padding });
/*      */   }
/*      */   
/*      */   private static void addBuckler(String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1493 */     for (ItemStack material : OreDictionary.getOres(ore)) {
/* 1494 */       addBuckler(material, output, hammer, anvil, matTime);
/*      */     }
/*      */   }
/*      */   
/*      */   private static void addBuckler(Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1499 */     MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 1.0F), new Object[] { " M ", "MLM", " M ", Character.valueOf('L'), Item.field_77770_aF, Character.valueOf('M'), material });
/*      */   }
/*      */   
/*      */   private static void addKite(int tier, String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1504 */     for (ItemStack material : OreDictionary.getOres(ore)) {
/* 1505 */       addKite(tier, material, output, hammer, anvil, matTime);
/*      */     }
/*      */   }
/*      */   
/*      */   private static void addKite(int tier, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1510 */     if (tier == 0) {
/* 1511 */       for (int a = 0; a < 16; a++)
/* 1512 */         MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 3.0F), new Object[] { "M M", "MWM", " M ", Character.valueOf('W'), new ItemStack(Block.field_71988_x, 1, a), Character.valueOf('M'), material });
/*      */     } else {
/* 1514 */       MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 3.0F), new Object[] { "M M", "MWM", " M ", Character.valueOf('W'), new ItemStack(MineFantasyBase.MFBlockPlanks, 1, tier - 1), Character.valueOf('M'), material });
/*      */     }
/*      */   }
/*      */   
/*      */   private static void addTower(int tier, String ore, ItemStack output, int hammer, int anvil, int matTime)
/*      */   {
/* 1520 */     for (ItemStack material : OreDictionary.getOres(ore)) {
/* 1521 */       addTower(tier, material, output, hammer, anvil, matTime);
/*      */     }
/*      */   }
/*      */   
/*      */   private static void addTower(int tier, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1526 */     if (tier == 0) {
/* 1527 */       for (int a = 0; a < 16; a++)
/* 1528 */         MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 5.0F), new Object[] { "MMM", "MWM", "MWM", "MMM", Character.valueOf('W'), new ItemStack(Block.field_71988_x, 1, a), Character.valueOf('M'), material });
/*      */     } else {
/* 1530 */       MineFantasyAPI.addAnvilRecipe(output, true, hammer, anvil, (int)(matTime * 5.0F), new Object[] { "MMM", "MWM", "MWM", "MMM", Character.valueOf('W'), new ItemStack(MineFantasyBase.MFBlockPlanks, 1, tier - 1), Character.valueOf('M'), material });
/*      */     }
/*      */   }
/*      */   
/*      */   private static void addRound(int tier, Object material, ItemStack output, int hammer, int anvil, int matTime) {
/* 1535 */     Object[] glue = { com(88), com(89) };
/*      */     
/* 1537 */     MineFantasyAPI.addAnvilRecipe(output, false, hammer, anvil, (int)(matTime * 5.0F), new Object[] { "PPP", "PGP", "PPP", Character.valueOf('P'), material, Character.valueOf('G'), glue[tier] });
/*      */   }
/*      */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/AnvilRecipesMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */