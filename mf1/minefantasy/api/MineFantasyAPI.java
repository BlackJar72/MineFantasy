/*     */ package minefantasy.api;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import minefantasy.api.anvil.CraftingManagerAnvil;
/*     */ import minefantasy.api.armour.ArmourWeightClass;
/*     */ import minefantasy.api.cooking.FoodPrepRecipe;
/*     */ import minefantasy.api.cooking.OvenRecipes;
/*     */ import minefantasy.api.forge.ForgeFuel;
/*     */ import minefantasy.api.forge.HeatableItem;
/*     */ import minefantasy.api.forge.IHotItem;
/*     */ import minefantasy.api.forge.ItemHandler;
/*     */ import minefantasy.api.mining.RandomOre;
/*     */ import minefantasy.api.refine.Alloy;
/*     */ import minefantasy.api.refine.AlloyRecipes;
/*     */ import minefantasy.api.refine.BlastFurnaceFuel;
/*     */ import minefantasy.api.refine.BlastRecipes;
/*     */ import minefantasy.api.refine.BloomRecipe;
/*     */ import minefantasy.api.refine.CrushRecipes;
/*     */ import minefantasy.api.refine.ICustomCrushRecipe;
/*     */ import minefantasy.api.refine.SpecialFurnaceRecipes;
/*     */ import minefantasy.api.tailor.CraftingManagerTailor;
/*     */ import minefantasy.api.tailor.StringRecipes;
/*     */ import minefantasy.api.tanner.LeathercuttingRecipes;
/*     */ import minefantasy.api.tanner.TanningRecipes;
/*     */ import minefantasy.api.targeting.ITargetAllyMF;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MineFantasyAPI
/*     */ {
/*  39 */   public static boolean modLoaded = false;
/*  40 */   private static List<IMineFantasyPlugin> plugins = new ArrayList();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addPlugin(IMineFantasyPlugin plugin)
/*     */   {
/*  49 */     plugins.add(plugin);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void initAllPlugins()
/*     */   {
/*  56 */     System.out.println("MineFantasy: Loading plugins...");
/*  57 */     for (IMineFantasyPlugin plugin : plugins) {
/*  58 */       plugin.initWithMineFantasy();
/*  59 */       System.out.println("MineFantasy: plugin " + plugin.pluginName() + " loaded");
/*     */     }
/*  61 */     System.out.println("MineFantasy: Finished loading plugins: " + plugins.size() + " plugins loaded");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isModLoaded()
/*     */   {
/*  70 */     return modLoaded;
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
/*     */ 
/*     */   public static void addAnvilRecipe(ItemStack result, boolean hot, int hammerType, int anvil, int forgeTime, Object... input)
/*     */   {
/*  92 */     CraftingManagerAnvil.getInstance().addRecipe(result, hot, 0.0F, hammerType, anvil, forgeTime, input);
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
/*     */   public static void addAnvilRecipe(ItemStack result, int hammerType, int anvil, int forgeTime, Object... input)
/*     */   {
/* 112 */     CraftingManagerAnvil.getInstance().addRecipe(result, false, 0.0F, hammerType, anvil, forgeTime, input);
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
/*     */   public static void addAnvilRecipe(ItemStack result, int hammerType, int forgeTime, Object... input)
/*     */   {
/* 130 */     CraftingManagerAnvil.getInstance().addRecipe(result, false, 0.0F, hammerType, 1, forgeTime, input);
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
/*     */   public static void addAnvilRecipe(ItemStack result, int forgeTime, Object... input)
/*     */   {
/* 146 */     CraftingManagerAnvil.getInstance().addRecipe(result, false, 0.0F, 0, 1, forgeTime, input);
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
/*     */   public static void addShapelessAnvilRecipe(ItemStack result, boolean hot, int anvil, int hammerType, int forgeTime, Object... input)
/*     */   {
/* 166 */     CraftingManagerAnvil.getInstance().addShapelessRecipe(result, hot, 0.0F, hammerType, anvil, forgeTime, input);
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
/*     */   public static void addShapelessAnvilRecipe(ItemStack result, int anvil, int hammerType, int forgeTime, Object... input)
/*     */   {
/* 184 */     CraftingManagerAnvil.getInstance().addShapelessRecipe(result, false, 0.0F, hammerType, anvil, forgeTime, input);
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
/*     */   public static void addShapelessAnvilRecipe(ItemStack result, int hammerType, int forgeTime, Object... input)
/*     */   {
/* 201 */     CraftingManagerAnvil.getInstance().addShapelessRecipe(result, false, 0.0F, hammerType, 1, forgeTime, input);
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
/*     */   public static void addShapelessAnvilRecipe(ItemStack result, int forgeTime, Object... input)
/*     */   {
/* 217 */     CraftingManagerAnvil.getInstance().addShapelessRecipe(result, false, 0.0F, 0, 1, forgeTime, input);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isEntityAlly(Object entity)
/*     */   {
/* 227 */     if ((entity instanceof ITargetAllyMF)) {
/* 228 */       ITargetAllyMF tar = (ITargetAllyMF)entity;
/* 229 */       return tar.isAlly();
/*     */     }
/* 231 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isEntityNeutral(Object entity)
/*     */   {
/* 241 */     return (!isEntityEnemy(entity)) && (!isEntityAlly(entity));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isEntityEnemy(Object entity)
/*     */   {
/* 251 */     if ((entity instanceof ITargetAllyMF)) {
/* 252 */       ITargetAllyMF tar = (ITargetAllyMF)entity;
/* 253 */       return tar.isEnemy();
/*     */     }
/* 255 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addTanningRecipe(int input, ItemStack output)
/*     */   {
/* 267 */     TanningRecipes.instance().addTanning(input, output, 0.0F);
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
/*     */   public static void addTanningRecipe(int input, int metadata, ItemStack output)
/*     */   {
/* 281 */     TanningRecipes.instance().addTanning(input, metadata, output);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addLeathercuttingRecipe(int input, ItemStack output)
/*     */   {
/* 293 */     LeathercuttingRecipes.instance().addCutting(input, output, 0.0F);
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
/*     */   public static void addLeathercuttingRecipe(int input, int metadata, ItemStack output)
/*     */   {
/* 307 */     LeathercuttingRecipes.instance().addCutting(input, metadata, output);
/*     */   }
/*     */   
/*     */   public static void addBloomRecipe(ItemStack input, ItemStack output) {
/* 311 */     BloomRecipe.add(new BloomRecipe(input, output));
/*     */   }
/*     */   
/*     */   public static void addBloomRecipe(ItemStack input, ItemStack output, int time) {
/* 315 */     BloomRecipe.add(new BloomRecipe(input, output, time));
/*     */   }
/*     */   
/*     */   public static void addBloomRecipe(Item input, ItemStack output) {
/* 319 */     BloomRecipe.add(new BloomRecipe(new ItemStack(input), output));
/*     */   }
/*     */   
/*     */   public static void addBloomRecipe(int input, ItemStack output) {
/* 323 */     BloomRecipe.add(new BloomRecipe(new ItemStack(input, 1, 0), output));
/*     */   }
/*     */   
/*     */   public static void addBlastRecipe(ItemStack input, ItemStack output) {
/* 327 */     BlastRecipes.add(new BlastRecipes(input, output));
/*     */   }
/*     */   
/*     */   public static void addBlastRecipe(int in, ItemStack output) {
/* 331 */     addBlastRecipe(new ItemStack(in, 1, 0), output);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addCraftableFlux(ItemStack item, int result)
/*     */   {
/* 343 */     ItemHandler.addFluxRecipe(item, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addFlux(ItemStack item)
/*     */   {
/* 353 */     if (item != null) {
/* 354 */       ItemHandler.flux.add(item);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addFlux(int id)
/*     */   {
/* 364 */     ItemHandler.flux.add(new ItemStack(id, 1, 0));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addCarbon(ItemStack item)
/*     */   {
/* 374 */     ItemHandler.carbon.add(item);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addCarbon(int id)
/*     */   {
/* 384 */     ItemHandler.carbon.add(new ItemStack(id, 1, 32767));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addBlastFuel(ItemStack item, float uses)
/*     */   {
/* 396 */     ItemHandler.BlastFuel.add(new BlastFurnaceFuel(item, uses));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addBlastFuel(int id, float uses)
/*     */   {
/* 408 */     ItemHandler.BlastFuel.add(new BlastFurnaceFuel(new ItemStack(id, 2, 0), uses));
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
/*     */   public static void addBlastFuel(int id, int meta, float uses)
/*     */   {
/* 422 */     ItemHandler.BlastFuel.add(new BlastFurnaceFuel(new ItemStack(id, 1, meta), uses));
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
/*     */   public static void addForgeFuel(int item, int meta, float dura, int temperature, boolean willLight)
/*     */   {
/* 440 */     addForgeFuel(new ItemStack(item, 1, meta), dura, temperature, willLight);
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
/*     */   public static void addForgeFuel(int item, int meta, float dura, int temperature)
/*     */   {
/* 456 */     addForgeFuel(item, meta, dura, temperature, false);
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
/*     */   public static void addForgeFuel(ItemStack item, float dura, int temperature, boolean willLight)
/*     */   {
/* 472 */     ItemHandler.forgeFuel.add(new ForgeFuel(item, dura, temperature, willLight));
/* 473 */     if ((int)(temperature * 1.25D) > ItemHandler.forgeMaxTemp) {
/* 474 */       ItemHandler.forgeMaxTemp = (int)(temperature * 1.25D);
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
/*     */   public static void addForgeFuel(int id, float dura, int temperature, boolean willLight)
/*     */   {
/* 491 */     addForgeFuel(new ItemStack(id, 2, 32767), dura, temperature, willLight);
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
/*     */   public static void addForgeFuel(ItemStack item, float dura, int temperature)
/*     */   {
/* 505 */     addForgeFuel(item, dura, temperature, false);
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
/*     */   public static void addForgeFuel(int id, float dura, int temperature)
/*     */   {
/* 519 */     addForgeFuel(id, dura, temperature, false);
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
/*     */   public static void addHeatableItem(ItemStack item, int min, int unstable, int max)
/*     */   {
/* 533 */     HeatableItem.addItem(item, min, unstable, max);
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
/*     */   public static void addHeatableItem(int id, int min, int unstable, int max)
/*     */   {
/* 547 */     HeatableItem.addItem(new ItemStack(id, 1, 32767), min, unstable, max);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addAlloy(ItemStack out, Object... in)
/*     */   {
/* 559 */     AlloyRecipes.addAlloy(out, convertList(in));
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
/*     */   public static void addAlloy(ItemStack out, int level, Object... in)
/*     */   {
/* 573 */     AlloyRecipes.addAlloy(out, level, convertList(in));
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
/*     */   public static void addRatioAlloy(int dupe, ItemStack out, int level, Object... in)
/*     */   {
/* 589 */     AlloyRecipes.addRatioRecipe(out, level, convertList(in), dupe);
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
/*     */   public static void addRatioAlloy(int dupe, ItemStack out, Object... in)
/*     */   {
/* 605 */     AlloyRecipes.addRatioRecipe(out, 0, convertList(in), dupe);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addAlloy(Alloy alloy)
/*     */   {
/* 617 */     AlloyRecipes.addAlloy(alloy);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addCrushRecipe(ItemStack in, ItemStack out)
/*     */   {
/* 629 */     CrushRecipes.addRecipe(in, out);
/*     */   }
/*     */   
/*     */   public static void addCrushRecipe(ICustomCrushRecipe recipe) {
/* 633 */     CrushRecipes.addRecipe(recipe);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addCrushRecipe(int in, ItemStack out)
/*     */   {
/* 645 */     CrushRecipes.addRecipe(new ItemStack(in, 1, 32767), out);
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
/*     */   public static void addFoodPrep(ItemStack input, ItemStack output, float time, String utensil, String sound)
/*     */   {
/* 664 */     FoodPrepRecipe.addFoodPrepRecipe(input, output, time, utensil, sound);
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
/*     */   public static void addFoodPrep(int input, ItemStack output, float time, String utensil, String sound)
/*     */   {
/* 683 */     FoodPrepRecipe.addFoodPrepRecipe(input, output, time, utensil, sound);
/*     */   }
/*     */   
/*     */   private static List convertList(Object[] in) {
/* 687 */     ArrayList arraylist = new ArrayList();
/* 688 */     Object[] aobject = in;
/* 689 */     int i = in.length;
/*     */     
/* 691 */     for (int j = 0; j < i; j++) {
/* 692 */       Object object1 = aobject[j];
/*     */       
/* 694 */       if ((object1 instanceof ItemStack)) {
/* 695 */         arraylist.add(((ItemStack)object1).func_77946_l());
/* 696 */       } else if ((object1 instanceof Item)) {
/* 697 */         arraylist.add(new ItemStack((Item)object1));
/*     */       } else {
/* 699 */         if (!(object1 instanceof Block)) {
/* 700 */           throw new RuntimeException("MineFantasy: Invalid alloy!");
/*     */         }
/*     */         
/* 703 */         arraylist.add(new ItemStack((Block)object1));
/*     */       }
/*     */     }
/*     */     
/* 707 */     return arraylist;
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
/*     */   public static void addTailorRecipe(ItemStack result, int stitches, float time, int string, Object... input)
/*     */   {
/* 725 */     addTailorRecipe(result, 0, stitches, time, string, input);
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
/*     */   public static void addTailorRecipe(ItemStack result, int tier, int stitches, float time, int string, Object... input)
/*     */   {
/* 745 */     CraftingManagerTailor.getInstance().addRecipe(result, tier, string, stitches, time, input);
/*     */   }
/*     */   
/*     */   public static boolean isHotToPickup(ItemStack item) {
/* 749 */     if ((item != null) && (item.func_77973_b() != null) && ((item.func_77973_b() instanceof IHotItem))) {
/* 750 */       return ((IHotItem)item.func_77973_b()).isHot(item);
/*     */     }
/* 752 */     return false;
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
/*     */   public static void addStringRecipe(ItemStack input, ItemStack output, int time)
/*     */   {
/* 766 */     StringRecipes.addRecipe(input, output, time);
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
/*     */   public static void addStringRecipe(Item input, ItemStack output, int time)
/*     */   {
/* 780 */     addStringRecipe(input.field_77779_bT, output, time);
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
/*     */   public static void addStringRecipe(Block input, ItemStack output, int time)
/*     */   {
/* 794 */     addStringRecipe(input.field_71990_ca, output, time);
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
/*     */   public static void addStringRecipe(int input, ItemStack output, int time)
/*     */   {
/* 808 */     StringRecipes.addRecipe(new ItemStack(input, 1, 32767), output, time);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addSpecialSmelt(ItemStack out, Object... in)
/*     */   {
/* 820 */     SpecialFurnaceRecipes.addAlloy(out, convertList(in));
/*     */   }
/*     */   
/*     */   public static void addSpecialSmelt(ItemStack out, int level, Object in) {
/* 824 */     if ((in instanceof ItemStack)) {
/* 825 */       SpecialFurnaceRecipes.addSmelting(((ItemStack)in).field_77993_c, ((ItemStack)in).func_77960_j(), out, level);
/*     */     }
/* 827 */     if ((in instanceof Item)) {
/* 828 */       SpecialFurnaceRecipes.addSmelting(((Item)in).field_77779_bT, out, level);
/*     */     }
/* 830 */     if ((in instanceof Block)) {
/* 831 */       SpecialFurnaceRecipes.addSmelting(((Block)in).field_71990_ca, out, level);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void addSpecialSmelt(ItemStack out, Object in) {
/* 836 */     addSpecialSmelt(out, in);
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
/*     */   public static void addSpecialSmelt(ItemStack out, int level, Object... in)
/*     */   {
/* 850 */     SpecialFurnaceRecipes.addAlloy(out, level, convertList(in));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addRandomOre(ItemStack drop, float chance)
/*     */   {
/* 862 */     addRandomOre(drop, chance, 0, Block.field_71981_t, false);
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
/*     */   public static void addRandomOre(ItemStack drop, float chance, int harvestLvl)
/*     */   {
/* 876 */     addRandomOre(drop, chance, harvestLvl, Block.field_71981_t, false);
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
/*     */   public static void addRandomOre(ItemStack drop, float chance, int harvestLvl, Object block, boolean silkDisable)
/*     */   {
/* 892 */     addRandomOre(drop, chance, harvestLvl, block, -1, -1, silkDisable);
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
/*     */   public static void addRandomOre(ItemStack drop, float chance, int harvestLvl, Object block, int min, int max, boolean silkDisable)
/*     */   {
/* 912 */     RandomOre.addOre(drop, chance, block, harvestLvl, min, max, silkDisable);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addOvenRecipe(ItemStack input, ItemStack output)
/*     */   {
/* 924 */     OvenRecipes.addSmelting(input.field_77993_c, input.func_77960_j(), output, 0.0F);
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
/*     */   public static void addOvenRecipe(ItemStack input, ItemStack output, float exp)
/*     */   {
/* 938 */     OvenRecipes.addSmelting(input.field_77993_c, input.func_77960_j(), output, exp);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addOvenRecipe(int input, ItemStack output)
/*     */   {
/* 950 */     OvenRecipes.addSmelting(input, output, 0.0F);
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
/*     */   public static void addOvenRecipe(int input, ItemStack output, float exp)
/*     */   {
/* 964 */     OvenRecipes.addSmelting(input, output, exp);
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
/*     */   public static void registerArmourClass(ItemStack armourItem, int armourClass)
/*     */   {
/* 977 */     ArmourWeightClass.add(armourItem.field_77993_c, armourClass);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/MineFantasyAPI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */