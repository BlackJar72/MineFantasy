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
/*     */ public class BlockWoodSlabMF
/*     */   extends BlockHalfSlab
/*     */ {
/*  21 */   public static final String[] woodType = { "ironbark", "ebony", "rePlanks", "hay" };
/*     */   
/*     */   public BlockWoodSlabMF(int id, boolean fullSize) {
/*  24 */     super(id, fullSize, Material.field_76245_d);
/*  25 */     func_71849_a(ItemListMF.tabDeco);
/*  26 */     func_71868_h(0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Icon func_71858_a(int side, int metadata)
/*     */   {
/*  34 */     if ((metadata & 0x7) < 2) {
/*  35 */       return MineFantasyBase.MFBlockPlanks.func_71858_a(side, metadata & 0x7);
/*     */     }
/*  37 */     if ((metadata & 0x7) == 2) {
/*  38 */       return MineFantasyBase.MFBlockRePlanks.func_71858_a(0, 0);
/*     */     }
/*  40 */     if ((metadata & 0x7) == 3) {
/*  41 */       return MineFantasyBase.MFBlockHayRoof.func_71858_a(0, 0);
/*     */     }
/*  43 */     return MineFantasyBase.MFBlockPlanks.func_71858_a(side, 0);
/*     */   }
/*     */   
/*     */   public int func_71922_a(World world, int x, int y, int z)
/*     */   {
/*  48 */     return MineFantasyBase.MFBlockWoodSingleSlab.field_71990_ca;
/*     */   }
/*     */   
/*     */   public float func_71934_m(World world, int x, int y, int z)
/*     */   {
/*  53 */     float f = super.func_71934_m(world, x, y, z);
/*  54 */     int meta = world.func_72805_g(x, y, z);
/*  55 */     meta &= 0x7;
/*     */     
/*  57 */     if (meta == 1)
/*  58 */       f *= 2.0F;
/*  59 */     if (meta == 2)
/*  60 */       f = MineFantasyBase.MFBlockRePlanks.func_71934_m(world, x, y, z);
/*  61 */     if (meta == 3) {
/*  62 */       f = MineFantasyBase.MFBlockHayRoof.func_71934_m(world, x, y, z);
/*     */     }
/*  64 */     return f;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int func_71885_a(int id, Random rand, int meta)
/*     */   {
/*  72 */     return MineFantasyBase.MFBlockWoodSingleSlab.field_71990_ca;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected ItemStack func_71880_c_(int meta)
/*     */   {
/*  82 */     return new ItemStack(MineFantasyBase.MFBlockWoodSingleSlab.field_71990_ca, 2, meta & 0x7);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String func_72240_d(int meta)
/*     */   {
/*  89 */     if ((meta < 0) || (meta >= woodType.length)) {
/*  90 */       meta = 0;
/*     */     }
/*     */     
/*  93 */     return super.func_71917_a() + "." + woodType[meta];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_71879_a(int id, CreativeTabs tab, List list)
/*     */   {
/* 101 */     if (id != MineFantasyBase.MFBlockWoodDoubleSlab.field_71990_ca) {
/* 102 */       for (int j = 0; j < woodType.length; j++) {
/* 103 */         list.add(new ItemStack(id, 1, j));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94332_a(IconRegister reg) {}
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/BlockWoodSlabMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */