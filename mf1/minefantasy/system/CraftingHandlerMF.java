/*     */ package minefantasy.system;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.api.armour.EnumArmourClass;
/*     */ import minefantasy.block.special.ItemBlockAnvil;
/*     */ import minefantasy.item.ItemArmourMFOld;
/*     */ import minefantasy.item.ItemArrowMF;
/*     */ import minefantasy.item.ItemBombMF;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.stats.AchievementList;
/*     */ import net.minecraftforge.oredict.OreDictionary;
/*     */ 
/*     */ public class CraftingHandlerMF implements cpw.mods.fml.common.ICraftingHandler
/*     */ {
/*     */   public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix)
/*     */   {
/*  22 */     if ((item == null) || (item.func_77973_b() == null)) {
/*  23 */       return;
/*     */     }
/*     */     
/*  26 */     for (ItemStack copper : OreDictionary.getOres("ingotCopper")) {
/*  27 */       if (item.func_77969_a(copper)) {
/*  28 */         player.func_71064_a(AchivementMF.AchievementCopper, 1);
/*     */       }
/*     */     }
/*  31 */     if ((item.func_77973_b() instanceof net.minecraft.item.ItemHoe)) {
/*  32 */       player.func_71064_a(AchievementList.field_76013_l, 1);
/*     */     }
/*  34 */     if ((item.func_77973_b() instanceof net.minecraft.item.ItemPickaxe)) {
/*  35 */       player.func_71064_a(AchievementList.field_76018_i, 1);
/*     */     }
/*  37 */     if ((item.func_77973_b() instanceof minefantasy.item.tool.ItemPrimitivePick)) {
/*  38 */       player.func_71064_a(AchievementList.field_76018_i, 1);
/*     */     }
/*  40 */     if ((item.func_77973_b() instanceof net.minecraft.item.ItemSword)) {
/*  41 */       player.func_71064_a(AchievementList.field_76024_r, 1);
/*     */     }
/*     */     
/*  44 */     if (item.func_77969_a(new ItemStack(MineFantasyBase.MFBlockSmelter, 1, 1))) {
/*  45 */       player.func_71064_a(AchivementMF.AchievementAlloy, 1);
/*     */     }
/*  47 */     if (item.func_77969_a(new ItemStack(MineFantasyBase.MFBlockTanner))) {
/*  48 */       player.func_71064_a(AchivementMF.AchievementTanner, 1);
/*     */     }
/*  50 */     if ((item.func_77973_b() instanceof ItemBlockAnvil)) {
/*  51 */       player.func_71064_a(AchivementMF.AchievementAnvil, 1);
/*     */     }
/*  53 */     if ((item.func_77973_b() instanceof ItemBombMF)) {
/*  54 */       player.func_71064_a(AchivementMF.AchievementBomb, 1);
/*     */     }
/*  56 */     if (item.func_77969_a(new ItemStack(ItemListMF.misc, 1, 22))) {
/*  57 */       player.func_71064_a(AchivementMF.AchievementDragonforger, 1);
/*     */     }
/*  59 */     if (((item.func_77973_b() instanceof ItemArmourMFOld)) && 
/*  60 */       (((ItemArmourMFOld)item.func_77973_b()).getArmourClass() == EnumArmourClass.PLATE)) {
/*  61 */       player.func_71064_a(AchivementMF.AchievementPlate, 1);
/*     */     }
/*  63 */     if (((item.func_77973_b() instanceof IPublicMaterialItem)) && 
/*  64 */       (((IPublicMaterialItem)item.func_77973_b()).getMaterial() == minefantasy.item.ToolMaterialMedieval.ENCRUSTED)) {
/*  65 */       player.func_71064_a(AchivementMF.AchievementEncrust, 1);
/*     */     }
/*  67 */     if ((item.func_77973_b() instanceof ItemArrowMF)) {
/*  68 */       if (MineFantasyBase.isDebug()) {
/*  69 */         System.out.println("Arrow Craft");
/*     */       }
/*  71 */       if (((ItemArrowMF)item.func_77973_b()).isBroad(item)) {
/*  72 */         if (MineFantasyBase.isDebug()) {
/*  73 */           System.out.println("Broad Arrow Craft");
/*     */         }
/*  75 */         player.func_71064_a(AchivementMF.AchievementArrow, 1);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private ItemStack getCopyBook(IInventory craftMatrix)
/*     */   {
/*  82 */     return null;
/*     */   }
/*     */   
/*     */   public void onSmelting(EntityPlayer player, ItemStack item)
/*     */   {
/*  87 */     if (item.func_77969_a(new ItemStack(ItemListMF.misc, 1, 56))) {
/*  88 */       player.func_71064_a(AchivementMF.AchievementCopper, 1);
/*     */     }
/*  90 */     if (item.func_77969_a(new ItemStack(ItemListMF.misc, 1, 57))) {
/*  91 */       player.func_71064_a(AchivementMF.AchievementTin, 1);
/*     */     }
/*  93 */     if (item.func_77969_a(new ItemStack(ItemListMF.misc, 1, 58))) {
/*  94 */       player.func_71064_a(AchivementMF.AchievementBronze, 1);
/*     */     }
/*  96 */     if (item.field_77993_c == Item.field_77703_o.field_77779_bT) {
/*  97 */       player.func_71064_a(AchivementMF.AchievementIron, 1);
/*     */     }
/*  99 */     if (item.field_77993_c == ItemListMF.ingotSteel.field_77779_bT) {
/* 100 */       player.func_71064_a(AchivementMF.AchievementSteel, 1);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/CraftingHandlerMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */