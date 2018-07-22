/*     */ package minefantasy.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockLogMedieval
/*     */   extends Block
/*     */ {
/*  25 */   public static final String[] woodType = { "Ironbark, Ebony" };
/*  26 */   public static final String[] treeTextureTypes = { "Ironbark_tree", "Ebony_tree" };
/*     */   @SideOnly(Side.CLIENT)
/*     */   private Icon[] iconArray;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private Icon[] tree_top;
/*     */   
/*     */   public BlockLogMedieval(int id) {
/*  33 */     super(id, Material.field_76245_d);
/*  34 */     func_71849_a(ItemListMF.tabDeco);
/*  35 */     setBurnProperties(id, 4, 3);
/*     */   }
/*     */   
/*     */   public float func_71934_m(World world, int x, int y, int z)
/*     */   {
/*  40 */     float f = super.func_71934_m(world, x, y, z);
/*  41 */     int meta = world.func_72805_g(x, y, z);
/*     */     
/*  43 */     if (meta == 1) {
/*  44 */       f *= 2.0F;
/*     */     }
/*  46 */     return f;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int func_71857_b()
/*     */   {
/*  54 */     return 31;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int func_71925_a(Random rand)
/*     */   {
/*  61 */     return 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int func_71885_a(int id, Random rand, int meta)
/*     */   {
/*  68 */     return MineFantasyBase.MFBlockLog.field_71990_ca;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_71852_a(World world, int x, int y, int z, int side, int meta)
/*     */   {
/*  76 */     byte var7 = 4;
/*  77 */     int var8 = var7 + 1;
/*     */     
/*  79 */     if (world.func_72904_c(x - var8, y - var8, z - var8, x + var8, y + var8, z + var8)) {
/*  80 */       for (int var9 = -var7; var9 <= var7; var9++) {
/*  81 */         for (int var10 = -var7; var10 <= var7; var10++) {
/*  82 */           for (int var11 = -var7; var11 <= var7; var11++) {
/*  83 */             int var12 = world.func_72798_a(x + var9, y + var10, z + var11);
/*     */             
/*  85 */             if (Block.field_71973_m[var12] != null) {
/*  86 */               Block.field_71973_m[var12].beginLeavesDecay(world, x + var9, y + var10, z + var11);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int func_85104_a(World world, int x, int y, int z, int meta, float pitch, float pan, float yaw, int side)
/*     */   {
/* 100 */     int var10 = side & 0x3;
/* 101 */     byte var11 = 0;
/*     */     
/* 103 */     switch (meta) {
/*     */     case 0: 
/*     */     case 1: 
/* 106 */       var11 = 0;
/* 107 */       break;
/*     */     case 2: 
/*     */     case 3: 
/* 110 */       var11 = 8;
/* 111 */       break;
/*     */     case 4: 
/*     */     case 5: 
/* 114 */       var11 = 4;
/*     */     }
/*     */     
/* 117 */     return var10 | var11;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Icon func_71858_a(int side, int meta)
/*     */   {
/* 126 */     int k = meta & 0xC;
/* 127 */     int l = meta & 0x3;
/* 128 */     return (k == 8) && ((side == 2) || (side == 3)) ? this.tree_top[l] : (k == 4) && ((side == 5) || (side == 4)) ? this.tree_top[l] : (k == 0) && ((side == 1) || (side == 0)) ? this.tree_top[l] : this.iconArray[l];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int func_71899_b(int meta)
/*     */   {
/* 136 */     return meta & 0x3;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static int limitToValidMetadata(int meta)
/*     */   {
/* 143 */     return meta & 0x3;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_71879_a(int id, CreativeTabs tab, List list)
/*     */   {
/* 151 */     for (int a = 0; a < 2; a++) {
/* 152 */       list.add(new ItemStack(id, 1, a));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected ItemStack func_71880_c_(int id)
/*     */   {
/* 163 */     return new ItemStack(this.field_71990_ca, 1, limitToValidMetadata(id));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94332_a(IconRegister reg)
/*     */   {
/* 172 */     this.tree_top = new Icon[treeTextureTypes.length];
/*     */     
/* 174 */     for (int i = 0; i < this.tree_top.length; i++) {
/* 175 */       this.tree_top[i] = reg.func_94245_a("MineFantasy:Tree/" + treeTextureTypes[i] + "_top");
/*     */     }
/* 177 */     this.iconArray = new Icon[treeTextureTypes.length];
/*     */     
/* 179 */     for (int i = 0; i < this.iconArray.length; i++) {
/* 180 */       this.iconArray[i] = reg.func_94245_a("MineFantasy:Tree/" + treeTextureTypes[i] + "_side");
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean canSustainLeaves(World world, int x, int y, int z)
/*     */   {
/* 186 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isWood(World world, int x, int y, int z)
/*     */   {
/* 191 */     return true;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/BlockLogMedieval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */