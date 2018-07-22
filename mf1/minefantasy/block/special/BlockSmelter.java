/*     */ package minefantasy.block.special;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.client.tile.TileEntitySmelter;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.system.cfg;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AABBPool;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
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
/*     */ 
/*     */ public class BlockSmelter
/*     */   extends BlockContainer
/*     */ {
/*  44 */   private Random rand = new Random();
/*  45 */   public int metaBlockSmelter = 0;
/*     */   
/*  47 */   private static boolean keepFurnaceInventory = false;
/*     */   
/*     */   public BlockSmelter(int id) {
/*  50 */     super(id, Material.field_76246_e);
/*  51 */     float scale = 1.2F;
/*  52 */     float offset = (scale - 1.0F) / 2.0F;
/*  53 */     func_71849_a(ItemListMF.tabSmellting);
/*     */   }
/*     */   
/*     */ 
/*     */   public Icon func_71858_a(int side, int meta)
/*     */   {
/*  59 */     if (meta >= 2) {
/*  60 */       return Block.field_71981_t.func_71858_a(side, meta);
/*     */     }
/*     */     
/*  63 */     return MineFantasyBase.MFBlockCobbBrick.func_71858_a(side, 0);
/*     */   }
/*     */   
/*     */   public boolean func_71926_d() {
/*  67 */     return false;
/*     */   }
/*     */   
/*     */   public void addCreativeItems(ArrayList itemList)
/*     */   {
/*  72 */     itemList.add(new ItemStack(this));
/*     */   }
/*     */   
/*     */   public boolean func_71886_c() {
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int getLightValue(IBlockAccess world, int x, int y, int z)
/*     */   {
/*  81 */     int meta = world.func_72805_g(x, y, z);
/*  82 */     if (meta == 1) {
/*  83 */       return 5;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  88 */     if (meta == 3) {
/*  89 */       return 5;
/*     */     }
/*  91 */     return super.getLightValue(world, x, y, z);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_71861_g(World world, int x, int y, int z)
/*     */   {
/*  98 */     super.func_71861_g(world, x, y, z);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_71857_b() {
/* 103 */     return cfg.renderId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_71862_a(World world, int x, int y, int z, Random rand)
/*     */   {
/* 111 */     TileEntitySmelter tile = (TileEntitySmelter)world.func_72796_p(x, y, z);
/* 112 */     if (tile.isBurning()) {
/* 113 */       int var6 = tile.direction;
/* 114 */       float var7 = x + 0.5F;
/* 115 */       float var8 = y + 0.0F + rand.nextFloat() * 6.0F / 16.0F;
/* 116 */       float var9 = z + 0.5F;
/* 117 */       float var10 = 0.52F;
/* 118 */       float f1 = rand.nextFloat() * 0.6F - 0.3F;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_71903_a(World world, int x, int y, int z, EntityPlayer player, int i, float f, float f1, float f2)
/*     */   {
/* 124 */     if (world.field_72995_K) {
/* 125 */       return true;
/*     */     }
/* 127 */     TileEntitySmelter tile = (TileEntitySmelter)world.func_72796_p(x, y, z);
/*     */     
/* 129 */     if (tile != null)
/*     */     {
/* 131 */       if (tile.tryTakeItem(player)) {
/* 132 */         return true;
/*     */       }
/*     */       
/* 135 */       player.openGui(MineFantasyBase.instance, 1, world, x, y, z);
/*     */     }
/*     */     
/* 138 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public TileEntity func_72274_a(World w)
/*     */   {
/* 146 */     return new TileEntitySmelter();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_71860_a(World world, int x, int y, int z, EntityLivingBase entity, ItemStack item)
/*     */   {
/* 154 */     int dir = MathHelper.func_76128_c(entity.field_70177_z * 4.0F / 360.0F + 0.5D) & 0x3;
/*     */     
/* 156 */     TileEntitySmelter tile = (TileEntitySmelter)world.func_72796_p(x, y, z);
/* 157 */     tile.direction = dir;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_71852_a(World world, int x, int y, int z, int i1, int i2)
/*     */   {
/* 165 */     if (!keepFurnaceInventory) {
/* 166 */       TileEntitySmelter tile = (TileEntitySmelter)world.func_72796_p(x, y, z);
/*     */       
/* 168 */       if (tile != null) {
/* 169 */         for (int var6 = 0; var6 < tile.func_70302_i_(); var6++) {
/* 170 */           ItemStack var7 = tile.func_70301_a(var6);
/*     */           
/* 172 */           if (var7 != null) {
/* 173 */             float var8 = this.rand.nextFloat() * 0.8F + 0.1F;
/* 174 */             float var9 = this.rand.nextFloat() * 0.8F + 0.1F;
/* 175 */             float var10 = this.rand.nextFloat() * 0.8F + 0.1F;
/*     */             
/* 177 */             while (var7.field_77994_a > 0) {
/* 178 */               int var11 = this.rand.nextInt(21) + 10;
/*     */               
/* 180 */               if (var11 > var7.field_77994_a) {
/* 181 */                 var11 = var7.field_77994_a;
/*     */               }
/*     */               
/* 184 */               var7.field_77994_a -= var11;
/* 185 */               EntityItem var12 = new EntityItem(world, x + var8, y + var9, z + var10, new ItemStack(var7.field_77993_c, var11, var7.func_77960_j()));
/*     */               
/* 187 */               if (var7.func_77942_o()) {
/* 188 */                 var12.func_92059_d().func_77982_d((NBTTagCompound)var7.func_77978_p().func_74737_b());
/*     */               }
/*     */               
/* 191 */               float var13 = 0.05F;
/* 192 */               var12.field_70159_w = ((float)this.rand.nextGaussian() * var13);
/* 193 */               var12.field_70181_x = ((float)this.rand.nextGaussian() * var13 + 0.2F);
/* 194 */               var12.field_70179_y = ((float)this.rand.nextGaussian() * var13);
/* 195 */               world.func_72838_d(var12);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 202 */     super.func_71852_a(world, x, y, z, i1, i2);
/*     */   }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94332_a(IconRegister reg) {}
/*     */   
/*     */ 
/*     */   public int func_71899_b(int meta)
/*     */   {
/* 212 */     return (int)Math.floor(meta / 2);
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_71872_e(World world, int x, int y, int z)
/*     */   {
/* 217 */     return AxisAlignedBB.func_72332_a().func_72299_a(x, y, z, x + 1, y + 0.9D, z + 1);
/*     */   }
/*     */   
/*     */   public void func_71869_a(World world, int x, int y, int z, Entity entity)
/*     */   {
/* 222 */     if (world.field_72995_K) {
/* 223 */       return;
/*     */     }
/*     */     
/* 226 */     TileEntitySmelter tile = (TileEntitySmelter)world.func_72796_p(x, y, z);
/* 227 */     if ((entity == null) || (tile == null)) {
/* 228 */       return;
/*     */     }
/* 230 */     boolean bloomery = tile.getTier() == 0;
/*     */     
/* 232 */     if (!tile.isBurning()) {
/* 233 */       return;
/*     */     }
/*     */     
/* 236 */     if ((entity instanceof EntityItem)) {
/* 237 */       if (!bloomery) {
/* 238 */         entity.field_70181_x = 0.20000000298023224D;
/* 239 */         entity.func_85030_a("random.fizz", 0.4F, 2.0F + this.rand.nextFloat() * 0.4F);
/*     */       }
/*     */     } else {
/* 242 */       entity.func_70097_a(DamageSource.field_76372_a, 1.0F);
/*     */     }
/*     */     
/* 245 */     if (!bloomery) {
/* 246 */       entity.func_70015_d(30);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/BlockSmelter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */