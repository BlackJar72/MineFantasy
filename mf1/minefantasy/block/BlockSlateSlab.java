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
/*     */ public class BlockSlateSlab
/*     */   extends BlockHalfSlab
/*     */ {
/*  22 */   public static final String[] stoneType = { "slate", "slateTile", "slateDTile", "slateBrick" };
/*     */   
/*     */   public BlockSlateSlab(int id, boolean fullSize) {
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
/*     */     
/*  37 */     return MineFantasyBase.MFBlockSlate.func_71858_a(side, metadata);
/*     */   }
/*     */   
/*     */   public int func_71922_a(World world, int x, int y, int z)
/*     */   {
/*  42 */     return MineFantasyBase.MFBlockStoneSingleSlab.field_71990_ca;
/*     */   }
/*     */   
/*     */   public float func_71934_m(World world, int x, int y, int z)
/*     */   {
/*  47 */     float f = 3.0F;
/*     */     
/*  49 */     int meta = world.func_72805_g(x, y, z);
/*  50 */     meta &= 0x7;
/*     */     
/*  52 */     if (meta == 1)
/*  53 */       f = 5.0F;
/*  54 */     if (meta == 2)
/*  55 */       f = 8.0F;
/*  56 */     if (meta == 3)
/*  57 */       f = 1.0F;
/*  58 */     if (meta == 4) {
/*  59 */       f = 0.7F;
/*     */     }
/*  61 */     return f;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int func_71885_a(int id, Random rand, int meta)
/*     */   {
/*  69 */     return MineFantasyBase.MFBlockSlateSingleSlab.field_71990_ca;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected ItemStack func_71880_c_(int meta)
/*     */   {
/*  79 */     return new ItemStack(MineFantasyBase.MFBlockSlateSingleSlab.field_71990_ca, 2, meta & 0x7);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String func_72240_d(int meta)
/*     */   {
/*  86 */     if ((meta < 0) || (meta >= stoneType.length)) {
/*  87 */       meta = 0;
/*     */     }
/*     */     
/*  90 */     return super.func_71917_a() + "." + stoneType[meta];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_71879_a(int id, CreativeTabs tab, List list)
/*     */   {
/*  99 */     if (id != MineFantasyBase.MFBlockSlateDoubleSlab.field_71990_ca) {
/* 100 */       for (int j = 0; j < stoneType.length; j++) {
/* 101 */         list.add(new ItemStack(id, 1, j));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94332_a(IconRegister reg) {}
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/BlockSlateSlab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */