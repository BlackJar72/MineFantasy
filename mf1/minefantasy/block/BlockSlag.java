/*     */ package minefantasy.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AABBPool;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockSlag
/*     */   extends Block
/*     */ {
/*  26 */   private Random rand = new Random();
/*     */   
/*     */   public BlockSlag(int id) {
/*  29 */     super(id, Material.field_76251_o);
/*  30 */     func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
/*  31 */     func_71849_a(ItemListMF.tabDeco);
/*  32 */     setBlockBoundsForSlagDepth(0);
/*  33 */     MinecraftForge.setBlockHarvestLevel(this, "shovel", 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94332_a(IconRegister reg)
/*     */   {
/*  43 */     this.field_94336_cN = reg.func_94245_a("minefantasy:Basic/Slag_MF");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public AxisAlignedBB func_71872_e(World world, int x, int y, int z)
/*     */   {
/*  51 */     int l = world.func_72805_g(x, y, z) & 0xF;
/*  52 */     float f = 0.125F;
/*  53 */     return AxisAlignedBB.func_72332_a().func_72299_a(x + this.field_72026_ch, y + this.field_72023_ci, z + this.field_72024_cj, x + this.field_72021_ck, y + l * f, z + this.field_72019_cm);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_71926_d()
/*     */   {
/*  62 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_71886_c()
/*     */   {
/*  70 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_71919_f()
/*     */   {
/*  77 */     setBlockBoundsForSlagDepth(0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_71902_a(IBlockAccess world, int x, int y, int z)
/*     */   {
/*  85 */     setBlockBoundsForSlagDepth(world.func_72805_g(x, y, z));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void setBlockBoundsForSlagDepth(int meta)
/*     */   {
/*  93 */     int j = meta & 0xF;
/*  94 */     float f = 1 * (1 + j) / 16.0F;
/*  95 */     func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int func_71885_a(int id, Random rand, int meta)
/*     */   {
/* 103 */     return 0;
/*     */   }
/*     */   
/*     */   public int func_71899_b(int meta)
/*     */   {
/* 108 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_71877_c(IBlockAccess world, int x, int y, int z, int meta)
/*     */   {
/* 118 */     return meta == 1 ? true : super.func_71877_c(world, x, y, z, meta);
/*     */   }
/*     */   
/*     */   public int quantityDropped(int meta, int fortune, Random random)
/*     */   {
/* 123 */     return 1;
/*     */   }
/*     */   
/*     */   public void func_71852_a(World world, int x, int y, int z, int i1, int i2)
/*     */   {
/* 128 */     super.func_71852_a(world, x, y, z, i1, i2);
/* 129 */     int meta = world.func_72805_g(x, y, z);
/* 130 */     for (int a = 0; a <= meta; a++) {
/* 131 */       ItemStack drop = getDrop();
/*     */       
/* 133 */       if (drop != null) {
/* 134 */         float var8 = this.rand.nextFloat() * 0.8F + 0.1F;
/* 135 */         float var9 = this.rand.nextFloat() * 0.8F + 0.1F;
/* 136 */         float var10 = this.rand.nextFloat() * 0.8F + 0.1F;
/*     */         
/* 138 */         while (drop.field_77994_a > 0) {
/* 139 */           int var11 = this.rand.nextInt(21) + 10;
/*     */           
/* 141 */           if (var11 > drop.field_77994_a) {
/* 142 */             var11 = drop.field_77994_a;
/*     */           }
/*     */           
/* 145 */           drop.field_77994_a -= var11;
/* 146 */           EntityItem var12 = new EntityItem(world, x + var8, y + var9, z + var10, new ItemStack(drop.field_77993_c, var11, drop.func_77960_j()));
/*     */           
/* 148 */           if (drop.func_77942_o()) {
/* 149 */             var12.func_92059_d().func_77982_d((NBTTagCompound)drop.func_77978_p().func_74737_b());
/*     */           }
/*     */           
/* 152 */           float var13 = 0.05F;
/* 153 */           var12.field_70159_w = ((float)this.rand.nextGaussian() * var13);
/* 154 */           var12.field_70181_x = ((float)this.rand.nextGaussian() * var13 + 0.2F);
/* 155 */           var12.field_70179_y = ((float)this.rand.nextGaussian() * var13);
/* 156 */           world.func_72838_d(var12);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private ItemStack getDrop() {
/* 163 */     int meta = 11;
/* 164 */     if (this.rand.nextInt(10) == 0) {
/* 165 */       meta = 0;
/*     */     }
/* 167 */     if (this.rand.nextInt(20) == 0) {
/* 168 */       return new ItemStack(Item.field_77705_m, 1, 1);
/*     */     }
/* 170 */     return ItemListMF.component(meta);
/*     */   }
/*     */   
/*     */   public void func_71869_a(World world, int x, int y, int z, Entity e) {
/* 174 */     e.field_70159_w *= 0.4D;
/* 175 */     e.field_70179_y *= 0.4D;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/BlockSlag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */