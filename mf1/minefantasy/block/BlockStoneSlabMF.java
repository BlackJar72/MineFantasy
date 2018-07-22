/*     */ package minefantasy.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockHalfSlab;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class BlockStoneSlabMF
/*     */   extends BlockHalfSlab
/*     */ {
/*  22 */   public static final String[] stoneType = { "cobbBrick", "granite", "graniteBrick", "stone", "mudbrick", "cobbBrickRough", "mudBrickRough" };
/*     */   
/*     */   public BlockStoneSlabMF(int id, boolean fullSize) {
/*  25 */     super(id, fullSize, Material.field_76246_e);
/*  26 */     func_71849_a(ItemListMF.tabDeco);
/*  27 */     func_71868_h(0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Icon func_71858_a(int side, int metadata)
/*     */   {
/*  35 */     int meta = metadata & 0x7;
/*  36 */     switch (meta) {
/*     */     case 0: 
/*  38 */       return MineFantasyBase.MFBlockCobbBrick.func_71858_a(0, 0);
/*     */     case 1: 
/*  40 */       return MineFantasyBase.MFBlockGranite.func_71858_a(0, 0);
/*     */     case 2: 
/*  42 */       return MineFantasyBase.MFBlockGraniteBrick.func_71858_a(0, 0);
/*     */     case 3: 
/*  44 */       return Block.field_71981_t.func_71858_a(0, 0);
/*     */     case 4: 
/*  46 */       return MineFantasyBase.MFBlockMudBrick.func_71858_a(0, 0);
/*     */     case 5: 
/*  48 */       return MineFantasyBase.MFBlockCobbBrick.func_71858_a(0, 3);
/*     */     case 6: 
/*  50 */       return MineFantasyBase.MFBlockMudBrick.func_71858_a(0, 1);
/*     */     }
/*  52 */     return Block.field_71981_t.func_71858_a(0, 0);
/*     */   }
/*     */   
/*     */   public int func_71922_a(World world, int x, int y, int z)
/*     */   {
/*  57 */     return MineFantasyBase.MFBlockStoneSingleSlab.field_71990_ca;
/*     */   }
/*     */   
/*     */   public float func_71934_m(World world, int x, int y, int z)
/*     */   {
/*  62 */     float f = 3.0F;
/*     */     
/*  64 */     int meta = world.func_72805_g(x, y, z);
/*  65 */     meta &= 0x7;
/*     */     
/*  67 */     if (meta == 1)
/*  68 */       f = 5.0F;
/*  69 */     if (meta == 2)
/*  70 */       f = 8.0F;
/*  71 */     if (meta == 3)
/*  72 */       f = 1.0F;
/*  73 */     if (meta == 4)
/*  74 */       f = 0.7F;
/*  75 */     if (meta == 5)
/*  76 */       f = 5.0F;
/*  77 */     if (meta == 6) {
/*  78 */       f = 0.7F;
/*     */     }
/*  80 */     return f;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int func_71885_a(int id, Random rand, int meta)
/*     */   {
/*  88 */     return MineFantasyBase.MFBlockStoneSingleSlab.field_71990_ca;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected ItemStack func_71880_c_(int meta)
/*     */   {
/*  98 */     return new ItemStack(MineFantasyBase.MFBlockStoneSingleSlab.field_71990_ca, 2, meta & 0x7);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String func_72240_d(int meta)
/*     */   {
/* 105 */     if ((meta < 0) || (meta >= stoneType.length)) {
/* 106 */       meta = 0;
/*     */     }
/*     */     
/* 109 */     return super.func_71917_a() + "." + stoneType[meta];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_71879_a(int id, CreativeTabs tab, List list)
/*     */   {
/* 117 */     if (id != MineFantasyBase.MFBlockStoneDoubleSlab.field_71990_ca) {
/* 118 */       for (int j = 0; j < stoneType.length; j++) {
/* 119 */         list.add(new ItemStack(id, 1, j));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94332_a(IconRegister reg) {}
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/BlockStoneSlabMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */