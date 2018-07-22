/*     */ package minefantasy.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockHellCoal
/*     */   extends BlockMedieval
/*     */ {
/*  20 */   public Icon[] types = new Icon[2];
/*     */   
/*     */   public BlockHellCoal(int i) {
/*  23 */     super(i, Material.field_76246_e);
/*  24 */     func_71849_a(ItemListMF.tabDeco);
/*     */   }
/*     */   
/*     */   public Icon func_71858_a(int side, int meta)
/*     */   {
/*  29 */     return this.types[meta];
/*     */   }
/*     */   
/*     */   public void func_94332_a(IconRegister reg) {
/*  33 */     this.types[0] = reg.func_94245_a("MineFantasy:Basic/oreInferno");
/*  34 */     this.types[1] = reg.func_94245_a("MineFantasy:Basic/oreHellfire");
/*     */   }
/*     */   
/*     */   public float func_71934_m(World world, int x, int y, int z)
/*     */   {
/*  39 */     int meta = world.func_72805_g(x, y, z);
/*     */     
/*  41 */     if (meta == 1) {
/*  42 */       return 5.0F;
/*     */     }
/*  44 */     return 2.0F;
/*     */   }
/*     */   
/*     */   public float getExplosionResistance(Entity explosion, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ)
/*     */   {
/*  49 */     int meta = world.func_72805_g(x, y, z);
/*     */     
/*  51 */     if (meta == 1) {
/*  52 */       return 5000.0F;
/*     */     }
/*  54 */     return 2.0F;
/*     */   }
/*     */   
/*     */   public int func_71885_a(int meta, Random rand, int fortune)
/*     */   {
/*  59 */     return ItemListMF.misc.field_77779_bT;
/*     */   }
/*     */   
/*     */   public int func_71899_b(int m)
/*     */   {
/*  64 */     if (m == 1) {
/*  65 */       return 91;
/*     */     }
/*  67 */     return 90;
/*     */   }
/*     */   
/*     */   public int getExpDrop(World world, int meta, int fortune)
/*     */   {
/*  72 */     if (func_71885_a(meta, world.field_73012_v, fortune) != this.field_71990_ca) {
/*  73 */       int j1 = 0;
/*     */       
/*  75 */       if (meta == 90) {
/*  76 */         j1 = MathHelper.func_76136_a(world.field_73012_v, 0, 5);
/*     */       }
/*  78 */       if (meta == 91) {
/*  79 */         j1 = MathHelper.func_76136_a(world.field_73012_v, 0, 6);
/*     */       }
/*  81 */       return j1;
/*     */     }
/*     */     
/*  84 */     return 0;
/*     */   }
/*     */   
/*     */   public int func_71910_a(int fortune, Random random)
/*     */   {
/*  89 */     if ((fortune > 0) && (this.field_71990_ca != func_71885_a(0, random, fortune))) {
/*  90 */       int j = random.nextInt(fortune + 2) - 1;
/*     */       
/*  92 */       if (j < 0) {
/*  93 */         j = 0;
/*     */       }
/*     */       
/*  96 */       return func_71925_a(random) * (j + 1);
/*     */     }
/*  98 */     return func_71925_a(random);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_71922_a(World world, int x, int y, int z)
/*     */   {
/* 108 */     return this.field_71990_ca;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int func_71873_h(World world, int x, int y, int z)
/*     */   {
/* 116 */     return world.func_72805_g(x, y, z);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/BlockHellCoal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */