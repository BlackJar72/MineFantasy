/*     */ package minefantasy.block.special;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.client.tile.TileEntityFurnaceMF;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.system.cfg;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
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
/*     */ public class BlockFurnaceMF
/*     */   extends BlockContainer
/*     */ {
/*  38 */   private Random rand = new Random();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  45 */   private static boolean keepFurnaceInventory = false;
/*     */   
/*     */   public BlockFurnaceMF(int id) {
/*  48 */     super(id, Material.field_76243_f);
/*  49 */     func_71849_a(ItemListMF.tabSmellting);
/*     */   }
/*     */   
/*     */   public Icon func_71858_a(int side, int meta)
/*     */   {
/*  54 */     int type = (int)Math.floor(meta / 2);
/*  55 */     if (type == 1) {
/*  56 */       return MineFantasyBase.MFBlockStorage.func_71858_a(side, 3);
/*     */     }
/*  58 */     if (type == 2) {
/*  59 */       return MineFantasyBase.MFBlockStorage.func_71858_a(side, 7);
/*     */     }
/*  61 */     if (type == 3) {
/*  62 */       return MineFantasyBase.MFBlockStorage.func_71858_a(side, 0);
/*     */     }
/*  64 */     if (type == 4) {
/*  65 */       return MineFantasyBase.MFBlockStorage.func_71858_a(side, 8);
/*     */     }
/*  67 */     return Block.field_72051_aB.func_71858_a(side, 0);
/*     */   }
/*     */   
/*     */   public boolean func_71926_d() {
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_71886_c() {
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int getLightValue(IBlockAccess world, int x, int y, int z)
/*     */   {
/*  80 */     int meta = world.func_72805_g(x, y, z);
/*  81 */     if (meta % 2 == 1) {
/*  82 */       return 10;
/*     */     }
/*  84 */     return super.getLightValue(world, x, y, z);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_71861_g(World world, int x, int y, int z)
/*     */   {
/*  91 */     super.func_71861_g(world, x, y, z);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_71857_b()
/*     */   {
/*  97 */     return cfg.renderId;
/*     */   }
/*     */   
/*     */   public boolean func_71903_a(World world, int x, int y, int z, EntityPlayer player, int i, float f, float f1, float f2)
/*     */   {
/* 102 */     if (world.field_72995_K) {
/* 103 */       return true;
/*     */     }
/* 105 */     TileEntityFurnaceMF tile = (TileEntityFurnaceMF)world.func_72796_p(x, y, z);
/*     */     
/* 107 */     ItemStack item = player.func_70694_bm();
/*     */     
/* 109 */     if (tile != null) {
/* 110 */       player.openGui(MineFantasyBase.instance, 12, world, x, y, z);
/*     */     }
/*     */     
/* 113 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public TileEntity func_72274_a(World w)
/*     */   {
/* 121 */     return new TileEntityFurnaceMF();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_71860_a(World world, int x, int y, int z, EntityLivingBase entity, ItemStack item)
/*     */   {
/* 129 */     int dir = MathHelper.func_76128_c(entity.field_70177_z * 4.0F / 360.0F + 0.5D) & 0x3;
/*     */     
/* 131 */     TileEntityFurnaceMF tile = (TileEntityFurnaceMF)world.func_72796_p(x, y, z);
/* 132 */     tile.direction = dir;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_71852_a(World world, int x, int y, int z, int i1, int i2)
/*     */   {
/* 140 */     if (!keepFurnaceInventory) {
/* 141 */       TileEntityFurnaceMF tile = (TileEntityFurnaceMF)world.func_72796_p(x, y, z);
/*     */       
/* 143 */       if (tile != null) {
/* 144 */         for (int var6 = 0; var6 < tile.func_70302_i_(); var6++) {
/* 145 */           ItemStack var7 = tile.func_70301_a(var6);
/*     */           
/* 147 */           if (var7 != null) {
/* 148 */             float var8 = this.rand.nextFloat() * 0.8F + 0.1F;
/* 149 */             float var9 = this.rand.nextFloat() * 0.8F + 0.1F;
/* 150 */             float var10 = this.rand.nextFloat() * 0.8F + 0.1F;
/*     */             
/* 152 */             while (var7.field_77994_a > 0) {
/* 153 */               int var11 = this.rand.nextInt(21) + 10;
/*     */               
/* 155 */               if (var11 > var7.field_77994_a) {
/* 156 */                 var11 = var7.field_77994_a;
/*     */               }
/*     */               
/* 159 */               var7.field_77994_a -= var11;
/* 160 */               EntityItem var12 = new EntityItem(world, x + var8, y + var9, z + var10, new ItemStack(var7.field_77993_c, var11, var7.func_77960_j()));
/*     */               
/* 162 */               if (var7.func_77942_o()) {
/* 163 */                 var12.func_92059_d().func_77982_d((NBTTagCompound)var7.func_77978_p().func_74737_b());
/*     */               }
/*     */               
/* 166 */               float var13 = 0.05F;
/* 167 */               var12.field_70159_w = ((float)this.rand.nextGaussian() * var13);
/* 168 */               var12.field_70181_x = ((float)this.rand.nextGaussian() * var13 + 0.2F);
/* 169 */               var12.field_70179_y = ((float)this.rand.nextGaussian() * var13);
/* 170 */               world.func_72838_d(var12);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 177 */     super.func_71852_a(world, x, y, z, i1, i2);
/*     */   }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94332_a(IconRegister reg) {}
/*     */   
/*     */ 
/*     */   public int func_71899_b(int meta)
/*     */   {
/* 187 */     return (int)Math.floor(meta / 2);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/BlockFurnaceMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */