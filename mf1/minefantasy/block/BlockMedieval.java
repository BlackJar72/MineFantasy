/*     */ package minefantasy.block;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.system.AchivementMF;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.MinecraftForge;
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
/*     */ public class BlockMedieval
/*     */   extends Block
/*     */ {
/*  32 */   private ItemStack drop = null;
/*  33 */   private int maxDrop = 0;
/*  34 */   private int minDrop = 0;
/*  35 */   private int damDrop = 0;
/*     */   
/*     */   public BlockMedieval(int i, Material m, int d) {
/*  38 */     this(i, m, new ItemStack(d, 1, 0));
/*  39 */     func_71849_a(ItemListMF.tabDeco);
/*     */   }
/*     */   
/*     */   public BlockMedieval(int i, Material m, ItemStack droppedItem) {
/*  43 */     super(i, m);
/*  44 */     this.drop = droppedItem;
/*  45 */     this.maxDrop = 0;
/*  46 */     this.minDrop = 0;
/*  47 */     this.damDrop = 0;
/*  48 */     func_71849_a(CreativeTabs.field_78030_b);
/*  49 */     if (m == Material.field_76245_d) {
/*  50 */       setBurnProperties(i, 4, 16);
/*     */     }
/*  52 */     if (m == Material.field_76246_e) {
/*  53 */       MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 0);
/*     */     }
/*  55 */     func_71849_a(ItemListMF.tabDeco);
/*     */   }
/*     */   
/*     */   public BlockMedieval(int i, Material m) {
/*  59 */     this(i, m, i);
/*  60 */     func_71849_a(ItemListMF.tabDeco);
/*     */   }
/*     */   
/*     */   public void addCreativeItems(ArrayList itemList)
/*     */   {
/*  65 */     itemList.add(new ItemStack(this));
/*     */   }
/*     */   
/*     */   public int func_71885_a(int meta, Random rand, int fortune)
/*     */   {
/*  70 */     if (this.field_71990_ca == MineFantasyBase.MFBlockOreUmite.field_71990_ca) {
/*  71 */       return ItemListMF.misc.field_77779_bT;
/*     */     }
/*  73 */     return this.drop != null ? this.drop.field_77993_c : 0;
/*     */   }
/*     */   
/*     */   public int func_71899_b(int m)
/*     */   {
/*  78 */     if (this.field_71990_ca == MineFantasyBase.MFBlockOreUmite.field_71990_ca) {
/*  79 */       return 152;
/*     */     }
/*  81 */     return this.drop != null ? this.drop.func_77960_j() : 0;
/*     */   }
/*     */   
/*     */   public void func_71914_a(World world, int x, int y, int z, int meta, float f, int side) {
/*  85 */     super.func_71914_a(world, x, y, z, meta, f, side);
/*     */     
/*  87 */     if (func_71885_a(meta, world.field_73012_v, side) != this.field_71990_ca) {
/*  88 */       int var8 = 0;
/*  89 */       func_71923_g(world, x, y, z, var8);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_71893_a(World world, EntityPlayer player, int x, int y, int z, int metadata)
/*     */   {
/*  95 */     if (this.field_71990_ca == MineFantasyBase.MFBlockOreUmite.field_71990_ca) {
/*  96 */       player.func_71064_a(AchivementMF.AchievementUmite, 1);
/*     */     }
/*  98 */     if (this.field_71990_ca == MineFantasyBase.MFBlockGranite.field_71990_ca) {
/*  99 */       player.func_71064_a(AchivementMF.AchievementGranite, 1);
/*     */     }
/* 101 */     if ((this.field_71990_ca == MineFantasyBase.MFBlockOreMythic.field_71990_ca) && (metadata == 0)) {
/* 102 */       player.func_71064_a(AchivementMF.AchievementMithril, 1);
/*     */     }
/* 104 */     super.func_71893_a(world, player, x, y, z, metadata);
/*     */   }
/*     */   
/*     */   public void func_71921_a(World world, int x, int y, int z, EntityPlayer player)
/*     */   {
/* 109 */     if (world.func_72798_a(x, y, z) == MineFantasyBase.MFBlockOreUmite.field_71990_ca) {
/* 110 */       player.func_71064_a(AchivementMF.AchievementUmite, 1);
/*     */     }
/* 112 */     super.func_71921_a(world, x, y, z, player);
/*     */   }
/*     */   
/*     */   public Block func_71864_b(String name)
/*     */   {
/* 117 */     func_111022_d("minefantasy:Basic/" + name);
/* 118 */     return super.func_71864_b(name);
/*     */   }
/*     */   
/*     */   public int func_71910_a(int level, Random rand)
/*     */   {
/* 123 */     if ((level > 0) && (this.field_71990_ca != func_71885_a(0, rand, level))) {
/* 124 */       int j = rand.nextInt(level + 2) - 1;
/*     */       
/* 126 */       if (j < 0) {
/* 127 */         j = 0;
/*     */       }
/*     */       
/* 130 */       return func_71925_a(rand) * (j + 1);
/*     */     }
/* 132 */     return func_71925_a(rand);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/BlockMedieval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */