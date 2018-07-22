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
/*     */ public class BlockUtilOre
/*     */   extends BlockMedieval
/*     */ {
/*  20 */   public Icon[] types = new Icon[3];
/*     */   
/*     */   public BlockUtilOre(int i) {
/*  23 */     super(i, Material.field_76246_e);
/*  24 */     func_71849_a(ItemListMF.tabDeco);
/*     */   }
/*     */   
/*     */   public Icon func_71858_a(int side, int meta)
/*     */   {
/*  29 */     if (meta > this.types.length - 1) {
/*  30 */       meta = this.types.length - 1;
/*     */     }
/*  32 */     return this.types[meta];
/*     */   }
/*     */   
/*     */   public void func_94332_a(IconRegister reg) {
/*  36 */     this.types[0] = reg.func_94245_a("MineFantasy:Basic/oreSilver");
/*  37 */     this.types[1] = reg.func_94245_a("MineFantasy:Basic/oreNitre");
/*  38 */     this.types[2] = reg.func_94245_a("MineFantasy:Basic/oreSulfur");
/*     */   }
/*     */   
/*     */   public float func_71934_m(World world, int x, int y, int z)
/*     */   {
/*  43 */     int meta = world.func_72805_g(x, y, z);
/*     */     
/*  45 */     if (meta == 1)
/*  46 */       return 2.0F;
/*  47 */     if (meta == 2) {
/*  48 */       return 3.0F;
/*     */     }
/*  50 */     return 2.0F;
/*     */   }
/*     */   
/*     */   public int func_71885_a(int meta, Random rand, int fortune)
/*     */   {
/*  55 */     if (meta == 0) {
/*  56 */       return this.field_71990_ca;
/*     */     }
/*  58 */     return ItemListMF.misc.field_77779_bT;
/*     */   }
/*     */   
/*     */   public int func_71899_b(int m)
/*     */   {
/*  63 */     if (m == 1) {
/*  64 */       return 177;
/*     */     }
/*  66 */     if (m == 2) {
/*  67 */       return 24;
/*     */     }
/*  69 */     return super.func_71899_b(m);
/*     */   }
/*     */   
/*     */   public int getExpDrop(World world, int meta, int fortune)
/*     */   {
/*  74 */     if (func_71885_a(meta, world.field_73012_v, fortune) != this.field_71990_ca) {
/*  75 */       int j1 = 0;
/*     */       
/*  77 */       if (meta == 177) {
/*  78 */         j1 = MathHelper.func_76136_a(world.field_73012_v, 0, 5);
/*     */       }
/*  80 */       if (meta == 24) {
/*  81 */         j1 = MathHelper.func_76136_a(world.field_73012_v, 0, 6);
/*     */       }
/*  83 */       return j1;
/*     */     }
/*     */     
/*  86 */     return 0;
/*     */   }
/*     */   
/*     */   public int func_71910_a(int fortune, Random random)
/*     */   {
/*  91 */     if ((fortune > 0) && (this.field_71990_ca != func_71885_a(0, random, fortune))) {
/*  92 */       int j = random.nextInt(fortune + 2) - 1;
/*     */       
/*  94 */       if (j < 0) {
/*  95 */         j = 0;
/*     */       }
/*     */       
/*  98 */       return func_71925_a(random) * (j + 1);
/*     */     }
/* 100 */     return func_71925_a(random);
/*     */   }
/*     */   
/*     */ 
/*     */   public float getExplosionResistance(Entity explosion, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ)
/*     */   {
/* 106 */     int meta = world.func_72805_g(x, y, z);
/*     */     
/* 108 */     if (meta == 1)
/* 109 */       return 1.0F;
/* 110 */     if (meta == 2) {
/* 111 */       return 0.5F;
/*     */     }
/* 113 */     return 5.0F;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_71922_a(World world, int x, int y, int z)
/*     */   {
/* 122 */     return this.field_71990_ca;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int func_71873_h(World world, int x, int y, int z)
/*     */   {
/* 130 */     return world.func_72805_g(x, y, z);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/BlockUtilOre.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */