/*     */ package minefantasy.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import minefantasy.block.special.WorldGenIronbarkTree;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.system.WorldGenEbony;
/*     */ import net.minecraft.block.BlockFlower;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.feature.WorldGenerator;
/*     */ import net.minecraftforge.event.terraingen.TerrainGen;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockSaplingMF
/*     */   extends BlockFlower
/*     */ {
/*  27 */   public static final String[] WOOD_TYPES = { "ironbark", "ebony" };
/*  28 */   private static final String[] iconNames = { "saplingIronbark", "saplingEbony" };
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Icon[] saplingIcon;
/*     */   
/*     */   public BlockSaplingMF(int id) {
/*  33 */     super(id);
/*  34 */     float f = 0.4F;
/*  35 */     func_71905_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
/*  36 */     func_71849_a(ItemListMF.tabDeco);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_71847_b(World world, int x, int y, int z, Random rand)
/*     */   {
/*  43 */     if (!world.field_72995_K) {
/*  44 */       int meta = world.func_72805_g(x, y, z);
/*     */       
/*  46 */       super.func_71847_b(world, x, y, z, rand);
/*     */       
/*  48 */       if ((world.func_72957_l(x, y + 1, z) >= getMinimalLight(meta)) && (rand.nextInt(getGrowthRate(meta)) == 0)) {
/*  49 */         markOrGrowMarked(world, x, y, z, rand);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private int getMinimalLight(int type) {
/*  55 */     if (type == 1)
/*  56 */       return 11;
/*  57 */     return 9;
/*     */   }
/*     */   
/*     */   private int getGrowthRate(int meta) {
/*  61 */     int type = meta & 0x3;
/*  62 */     if (type == 1)
/*  63 */       return 60;
/*  64 */     return 10;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Icon func_71858_a(int side, int meta)
/*     */   {
/*  72 */     meta &= 0x3;
/*  73 */     if (meta >= this.saplingIcon.length) {
/*  74 */       meta = this.saplingIcon.length - 1;
/*     */     }
/*  76 */     return this.saplingIcon[meta];
/*     */   }
/*     */   
/*     */   public void markOrGrowMarked(World world, int x, int y, int z, Random rand) {
/*  80 */     int l = world.func_72805_g(x, y, z);
/*     */     
/*  82 */     if ((l & 0x8) == 0) {
/*  83 */       world.func_72921_c(x, y, z, l | 0x8, 4);
/*     */     } else {
/*  85 */       growTree(world, x, y, z, rand);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void growTree(World world, int x, int y, int z, Random rand)
/*     */   {
/*  93 */     if (!TerrainGen.saplingGrowTree(world, rand, x, y, z)) {
/*  94 */       return;
/*     */     }
/*  96 */     int l = world.func_72805_g(x, y, z) & 0x3;
/*  97 */     Object object = null;
/*  98 */     int i1 = 0;
/*  99 */     int j1 = 0;
/* 100 */     boolean flag = false;
/*     */     
/* 102 */     if (l == 1) {
/* 103 */       object = new WorldGenEbony(true);
/*     */     } else {
/* 105 */       object = new WorldGenIronbarkTree(true);
/*     */     }
/* 107 */     world.func_72832_d(x, y, z, 0, 0, 4);
/*     */     
/* 109 */     if (!((WorldGenerator)object).func_76484_a(world, rand, x + i1, y, z + j1)) {
/* 110 */       world.func_72832_d(x, y, z, this.field_71990_ca, l, 4);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isSameSapling(World world, int x, int y, int z, int meta)
/*     */   {
/* 118 */     return (world.func_72798_a(x, y, z) == this.field_71990_ca) && ((world.func_72805_g(x, y, z) & 0x3) == meta);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int func_71899_b(int id)
/*     */   {
/* 126 */     return id & 0x3;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_71879_a(int id, CreativeTabs tab, List list)
/*     */   {
/* 134 */     list.add(new ItemStack(id, 1, 0));
/* 135 */     list.add(new ItemStack(id, 1, 1));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94332_a(IconRegister reg)
/*     */   {
/* 145 */     this.saplingIcon = new Icon[iconNames.length];
/* 146 */     for (int i = 0; i < this.saplingIcon.length; i++) {
/* 147 */       this.saplingIcon[i] = reg.func_94245_a("MineFantasy:Tree/" + iconNames[i]);
/*     */     }
/*     */   }
/*     */   
/*     */   public float getBonemealChance(int type) {
/* 152 */     if (type == 1) {
/* 153 */       return 0.05F;
/*     */     }
/* 155 */     return 0.45F;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/BlockSaplingMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */