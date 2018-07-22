/*     */ package minefantasy.block.special;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import minefantasy.api.aesthetic.IChimney;
/*     */ import minefantasy.client.tile.TileEntityBlastFurnace;
/*     */ import minefantasy.item.ItemListMF;
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
/*     */ import net.minecraftforge.common.ForgeDirection;
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
/*     */ public class BlockBlastFurnace
/*     */   extends BlockContainer
/*     */   implements IChimney
/*     */ {
/*  36 */   private Random rand = new Random();
/*     */   private Icon[] icon;
/*     */   
/*     */   public BlockBlastFurnace(int i, int n, Material m) {
/*  40 */     super(i, m);
/*  41 */     func_71849_a(ItemListMF.tabSmellting);
/*     */   }
/*     */   
/*     */   public Icon func_71895_b(IBlockAccess world, int x, int y, int z, int side)
/*     */   {
/*  46 */     int ic = getBlockTextureInt(world, x, y, z, side);
/*  47 */     return this.icon[ic];
/*     */   }
/*     */   
/*     */   public int getBlockTextureInt(IBlockAccess world, int x, int y, int z, int side) {
/*  51 */     TileEntityBlastFurnace tile = (TileEntityBlastFurnace)world.func_72796_p(x, y, z);
/*  52 */     if (tile != null) {
/*  53 */       byte facing = tile.direction;
/*  54 */       int meta = tile.func_70322_n();
/*  55 */       if (meta == 2)
/*     */       {
/*  57 */         if (side == 0)
/*  58 */           return 0;
/*     */       }
/*  60 */       if ((meta == 1) || (meta == 2))
/*     */       {
/*  62 */         if (side != facing) {
/*  63 */           return 0;
/*     */         }
/*  65 */         return 2;
/*     */       }
/*     */     }
/*  68 */     if ((side == 0) || (side == 1))
/*  69 */       return 1;
/*  70 */     return 0;
/*     */   }
/*     */   
/*     */   public Icon func_71858_a(int side, int meta)
/*     */   {
/*  75 */     int ic = getBlockTextureFromSideAndMetadataInt(side, meta);
/*  76 */     return this.icon[ic];
/*     */   }
/*     */   
/*     */   public int getBlockTextureFromSideAndMetadataInt(int side, int meta) {
/*  80 */     int facing = 3;
/*  81 */     if (meta == 2)
/*     */     {
/*  83 */       if (side == 0)
/*  84 */         return 0;
/*     */     }
/*  86 */     if ((meta == 1) || (meta == 2))
/*     */     {
/*  88 */       if (side != facing) {
/*  89 */         return 0;
/*     */       }
/*  91 */       return 2;
/*     */     }
/*  93 */     if ((side == 0) || (side == 1))
/*  94 */       return 1;
/*  95 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void addCreativeItems(ArrayList itemList) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_71921_a(World world, int x, int y, int z, EntityPlayer player) {}
/*     */   
/*     */ 
/*     */   public TileEntity func_72274_a(World w)
/*     */   {
/* 109 */     return new TileEntityBlastFurnace();
/*     */   }
/*     */   
/*     */   public void func_71860_a(World world, int x, int y, int z, EntityLivingBase entity, ItemStack item)
/*     */   {
/* 114 */     int dir = MathHelper.func_76128_c(entity.field_70177_z * 4.0F / 360.0F + 0.5D) & 0x3;
/* 115 */     TileEntityBlastFurnace tile = (TileEntityBlastFurnace)world.func_72796_p(x, y, z);
/* 116 */     tile.direction = getFacingOnMeta(dir);
/* 117 */     if (item.func_82837_s()) {
/* 118 */       tile.setCustomName(item.func_82833_r());
/*     */     }
/*     */   }
/*     */   
/*     */   private byte getFacingOnMeta(int dir) {
/* 123 */     switch (dir) {
/*     */     case 0: 
/* 125 */       return 2;
/*     */     case 1: 
/* 127 */       return 5;
/*     */     case 2: 
/* 129 */       return 3;
/*     */     case 3: 
/* 131 */       return 4;
/*     */     }
/* 133 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_71852_a(World world, int x, int y, int z, int i1, int i2)
/*     */   {
/* 141 */     TileEntityBlastFurnace tile = (TileEntityBlastFurnace)world.func_72796_p(x, y, z);
/*     */     
/* 143 */     if (tile != null) {
/* 144 */       for (int var6 = 0; var6 < tile.func_70302_i_(); var6++) {
/* 145 */         ItemStack var7 = tile.func_70301_a(var6);
/*     */         
/* 147 */         if (var7 != null) {
/* 148 */           float var8 = this.rand.nextFloat() * 0.8F + 0.1F;
/* 149 */           float var9 = this.rand.nextFloat() * 0.8F + 0.1F;
/* 150 */           float var10 = this.rand.nextFloat() * 0.8F + 0.1F;
/*     */           
/* 152 */           while (var7.field_77994_a > 0) {
/* 153 */             int var11 = this.rand.nextInt(21) + 10;
/*     */             
/* 155 */             if (var11 > var7.field_77994_a) {
/* 156 */               var11 = var7.field_77994_a;
/*     */             }
/*     */             
/* 159 */             var7.field_77994_a -= var11;
/* 160 */             EntityItem var12 = new EntityItem(world, x + var8, y + var9, z + var10, new ItemStack(var7.field_77993_c, var11, var7.func_77960_j()));
/*     */             
/* 162 */             if (var7.func_77942_o()) {
/* 163 */               var12.func_92059_d().func_77982_d((NBTTagCompound)var7.func_77978_p().func_74737_b());
/*     */             }
/*     */             
/* 166 */             float var13 = 0.05F;
/* 167 */             var12.field_70159_w = ((float)this.rand.nextGaussian() * var13);
/* 168 */             var12.field_70181_x = ((float)this.rand.nextGaussian() * var13 + 0.2F);
/* 169 */             var12.field_70179_y = ((float)this.rand.nextGaussian() * var13);
/* 170 */             world.func_72838_d(var12);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 175 */     super.func_71852_a(world, x, y, z, i1, i2);
/*     */   }
/*     */   
/*     */   public boolean func_71903_a(World world, int x, int y, int z, EntityPlayer player, int i, float f, float f1, float f2)
/*     */   {
/* 180 */     TileEntityBlastFurnace tile = (TileEntityBlastFurnace)world.func_72796_p(x, y, z);
/* 181 */     if ((tile == null) || (tile.func_70322_n() == 0))
/* 182 */       return false;
/* 183 */     if (((tile.func_70322_n() == 1) || (tile.func_70322_n() == 2)) && (tile.direction != i))
/* 184 */       return false;
/* 185 */     return tile.interact(player);
/*     */   }
/*     */   
/*     */   public int getLightValue(IBlockAccess world, int x, int y, int z)
/*     */   {
/* 190 */     boolean power = false;
/* 191 */     TileEntityBlastFurnace bfurn = getFurnaceInstance(world, x, y, z);
/* 192 */     if (bfurn == null) {
/* 193 */       return 0;
/*     */     }
/* 195 */     power = bfurn.isBurning();
/* 196 */     if (power) {
/* 197 */       return 15;
/*     */     }
/* 199 */     return super.getLightValue(world, x, y, z);
/*     */   }
/*     */   
/*     */   private TileEntityBlastFurnace getFurnaceInstance(IBlockAccess world, int x, int y, int z) {
/* 203 */     if (world.func_72796_p(x, y, z) == null) {
/* 204 */       return null;
/*     */     }
/* 206 */     TileEntityBlastFurnace bfurn = getBFurnAt(world, x, y, z);
/* 207 */     if (bfurn == null) {
/* 208 */       return null;
/*     */     }
/* 210 */     return bfurn;
/*     */   }
/*     */   
/*     */   public int func_71899_b(int meta)
/*     */   {
/* 215 */     return meta;
/*     */   }
/*     */   
/*     */   public void func_94332_a(IconRegister reg) {
/* 219 */     this.icon = new Icon[3];
/* 220 */     this.icon[0] = reg.func_94245_a("MineFantasy:Furn/Blast_Furnace_Side");
/* 221 */     this.icon[1] = reg.func_94245_a("MineFantasy:Furn/Blast_Furnace_Top");
/* 222 */     this.icon[2] = reg.func_94245_a("MineFantasy:Furn/Blast_Furnace_Face");
/*     */   }
/*     */   
/*     */   private TileEntityBlastFurnace getBFurnAt(IBlockAccess world, int x, int y, int z) {
/* 226 */     TileEntity tile = world.func_72796_p(x, y, z);
/* 227 */     if (tile == null) {
/* 228 */       return null;
/*     */     }
/* 230 */     if ((tile instanceof TileEntityBlastFurnace)) {
/* 231 */       return (TileEntityBlastFurnace)tile;
/*     */     }
/* 233 */     return null;
/*     */   }
/*     */   
/*     */   public boolean puffSmoke(World world, int x, int y, int z, float num, float speedX, float speedY)
/*     */   {
/* 238 */     if (world.func_72805_g(x, y, z) > 0) {
/* 239 */       return false;
/*     */     }
/* 241 */     IChimney chimney = (IChimney)net.minecraft.block.Block.field_71973_m[world.func_72798_a(x, y, z)];
/* 242 */     if (chimney == null) {
/* 243 */       return false;
/*     */     }
/*     */     
/* 246 */     Random rand = new Random();
/*     */     
/* 248 */     if ((net.minecraft.block.Block.field_71973_m[world.func_72798_a(x, y + 1, z)] instanceof IChimney)) {
/* 249 */       IChimney chimney2 = (IChimney)net.minecraft.block.Block.field_71973_m[world.func_72798_a(x, y + 1, z)];
/* 250 */       return chimney2.puffSmoke(world, x, y + 1, z, num, speedX, speedY);
/*     */     }
/*     */     
/* 253 */     for (int a = 0; a < 30.0F * num; a++) {
/* 254 */       if (!world.isBlockSolidOnSide(x, y + 1, z, ForgeDirection.DOWN)) {
/* 255 */         world.func_72869_a("largesmoke", x + 0.5F, y + 1, z + 0.5F, (rand.nextFloat() - 0.5F) / 6.0F * speedX, 0.065F * speedY, (rand.nextFloat() - 0.5F) / 6.0F * speedX);
/*     */       }
/*     */     }
/* 258 */     return true;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/BlockBlastFurnace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */