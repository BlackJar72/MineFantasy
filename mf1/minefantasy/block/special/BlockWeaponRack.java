/*     */ package minefantasy.block.special;
/*     */ 
/*     */ import cpw.mods.fml.common.network.PacketDispatcher;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.client.tile.TileEntityWeaponRack;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.system.cfg;
/*     */ import minefantasy.system.network.PacketManagerMF;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.packet.Packet;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.Icon;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockWeaponRack
/*     */   extends BlockContainer
/*     */ {
/*  47 */   private Random rand = new Random();
/*     */   private static final float thickness = 0.3125F;
/*     */   
/*     */   public BlockWeaponRack(int id)
/*     */   {
/*  52 */     super(id, Material.field_76245_d);
/*  53 */     func_71849_a(ItemListMF.tabWeapon);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public AxisAlignedBB func_71872_e(World par1World, int par2, int par3, int par4)
/*     */   {
/*  61 */     func_71902_a(par1World, par2, par3, par4);
/*  62 */     return super.func_71872_e(par1World, par2, par3, par4);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB func_71911_a_(World par1World, int par2, int par3, int par4)
/*     */   {
/*  70 */     func_71902_a(par1World, par2, par3, par4);
/*  71 */     return super.func_71911_a_(par1World, par2, par3, par4);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_71902_a(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
/*     */   {
/*  79 */     updateLadderBounds(par1IBlockAccess.func_72805_g(par2, par3, par4));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void updateLadderBounds(int par1)
/*     */   {
/*  86 */     float f = 0.3125F;
/*     */     
/*  88 */     if (par1 == 2) {
/*  89 */       func_71905_a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
/*     */     }
/*     */     
/*  92 */     if (par1 == 3) {
/*  93 */       func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
/*     */     }
/*     */     
/*  96 */     if (par1 == 4) {
/*  97 */       func_71905_a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */     }
/*     */     
/* 100 */     if (par1 == 5) {
/* 101 */       func_71905_a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_71926_d()
/*     */   {
/* 111 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_71886_c()
/*     */   {
/* 119 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int func_71857_b()
/*     */   {
/* 126 */     return cfg.renderId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_71930_b(World par1World, int par2, int par3, int par4)
/*     */   {
/* 134 */     return (par1World.isBlockSolidOnSide(par2 - 1, par3, par4, ForgeDirection.EAST)) || (par1World.isBlockSolidOnSide(par2 + 1, par3, par4, ForgeDirection.WEST)) || (par1World.isBlockSolidOnSide(par2, par3, par4 - 1, ForgeDirection.SOUTH)) || (par1World.isBlockSolidOnSide(par2, par3, par4 + 1, ForgeDirection.NORTH));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int func_85104_a(World world, int x, int y, int z, int side, float xo, float yo, float zr, int meta)
/*     */   {
/* 142 */     int j1 = meta;
/*     */     
/* 144 */     if (((j1 == 0) || (side == 2)) && (world.isBlockSolidOnSide(x, y, z + 1, ForgeDirection.NORTH))) {
/* 145 */       j1 = 2;
/*     */     }
/*     */     
/* 148 */     if (((j1 == 0) || (side == 3)) && (world.isBlockSolidOnSide(x, y, z - 1, ForgeDirection.SOUTH))) {
/* 149 */       j1 = 3;
/*     */     }
/*     */     
/* 152 */     if (((j1 == 0) || (side == 4)) && (world.isBlockSolidOnSide(x + 1, y, z, ForgeDirection.WEST))) {
/* 153 */       j1 = 4;
/*     */     }
/*     */     
/* 156 */     if (((j1 == 0) || (side == 5)) && (world.isBlockSolidOnSide(x - 1, y, z, ForgeDirection.EAST))) {
/* 157 */       j1 = 5;
/*     */     }
/*     */     
/* 160 */     return j1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_71863_a(World par1World, int par2, int par3, int par4, int par5)
/*     */   {
/* 169 */     int i1 = par1World.func_72805_g(par2, par3, par4);
/* 170 */     boolean flag = false;
/*     */     
/* 172 */     if ((i1 == 2) && (par1World.isBlockSolidOnSide(par2, par3, par4 + 1, ForgeDirection.NORTH))) {
/* 173 */       flag = true;
/*     */     }
/*     */     
/* 176 */     if ((i1 == 3) && (par1World.isBlockSolidOnSide(par2, par3, par4 - 1, ForgeDirection.SOUTH))) {
/* 177 */       flag = true;
/*     */     }
/*     */     
/* 180 */     if ((i1 == 4) && (par1World.isBlockSolidOnSide(par2 + 1, par3, par4, ForgeDirection.WEST))) {
/* 181 */       flag = true;
/*     */     }
/*     */     
/* 184 */     if ((i1 == 5) && (par1World.isBlockSolidOnSide(par2 - 1, par3, par4, ForgeDirection.EAST))) {
/* 185 */       flag = true;
/*     */     }
/*     */     
/* 188 */     if (!flag) {
/* 189 */       func_71897_c(par1World, par2, par3, par4, i1, 0);
/* 190 */       par1World.func_94571_i(par2, par3, par4);
/*     */     }
/*     */     
/* 193 */     super.func_71863_a(par1World, par2, par3, par4, par5);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int func_71925_a(Random par1Random)
/*     */   {
/* 200 */     return 1;
/*     */   }
/*     */   
/*     */   public Icon func_71858_a(int side, int meta)
/*     */   {
/* 205 */     return Block.field_71988_x.func_71858_a(side, 0);
/*     */   }
/*     */   
/*     */   public void addCreativeItems(ArrayList itemList)
/*     */   {
/* 210 */     itemList.add(new ItemStack(this));
/*     */   }
/*     */   
/*     */   public TileEntity func_72274_a(World w)
/*     */   {
/* 215 */     return new TileEntityWeaponRack();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_71852_a(World world, int x, int y, int z, int i1, int i2)
/*     */   {
/* 222 */     TileEntityWeaponRack tile = (TileEntityWeaponRack)world.func_72796_p(x, y, z);
/*     */     
/* 224 */     if (tile != null) {
/* 225 */       for (int var6 = 0; var6 < tile.func_70302_i_(); var6++) {
/* 226 */         ItemStack var7 = tile.func_70301_a(var6);
/*     */         
/* 228 */         if (var7 != null) {
/* 229 */           float var8 = this.rand.nextFloat() * 0.8F + 0.1F;
/* 230 */           float var9 = this.rand.nextFloat() * 0.8F + 0.1F;
/* 231 */           float var10 = this.rand.nextFloat() * 0.8F + 0.1F;
/*     */           
/* 233 */           while (var7.field_77994_a > 0) {
/* 234 */             int var11 = this.rand.nextInt(21) + 10;
/*     */             
/* 236 */             if (var11 > var7.field_77994_a) {
/* 237 */               var11 = var7.field_77994_a;
/*     */             }
/*     */             
/* 240 */             var7.field_77994_a -= var11;
/* 241 */             EntityItem var12 = new EntityItem(world, x + var8, y + var9, z + var10, new ItemStack(var7.field_77993_c, var11, var7.func_77960_j()));
/*     */             
/* 243 */             if (var7.func_77942_o()) {
/* 244 */               var12.func_92059_d().func_77982_d((NBTTagCompound)var7.func_77978_p().func_74737_b());
/*     */             }
/*     */             
/* 247 */             float var13 = 0.05F;
/* 248 */             var12.field_70159_w = ((float)this.rand.nextGaussian() * var13);
/* 249 */             var12.field_70181_x = ((float)this.rand.nextGaussian() * var13 + 0.2F);
/* 250 */             var12.field_70179_y = ((float)this.rand.nextGaussian() * var13);
/* 251 */             world.func_72838_d(var12);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 257 */     super.func_71852_a(world, x, y, z, i1, i2);
/*     */   }
/*     */   
/*     */   public boolean func_71903_a(World world, int x, int y, int z, EntityPlayer player, int i, float f, float f1, float f2)
/*     */   {
/* 262 */     TileEntityWeaponRack tile = (TileEntityWeaponRack)world.func_72796_p(x, y, z);
/*     */     
/* 264 */     if (world.field_72995_K) {
/* 265 */       int slot = tile.getSlotFor(f, f2);
/* 266 */       if ((slot >= 0) && (slot < 4)) {
/* 267 */         tryPlaceItem(slot, world, tile, player);
/*     */       }
/*     */       
/* 270 */       Packet packet = PacketManagerMF.getPacketIntegerArray(tile, new int[] { 1, player.field_70157_k, i, slot });
/*     */       try {
/* 272 */         PacketDispatcher.sendPacketToServer(packet);
/*     */       } catch (NullPointerException e) {
/* 274 */         System.out.println("MineFantasy: Client connection lost");
/*     */       }
/*     */     }
/*     */     
/* 278 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94332_a(IconRegister reg) {}
/*     */   
/*     */   public void func_71860_a(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
/*     */   {
/* 287 */     int dir = 0;
/* 288 */     int m = world.func_72805_g(x, y, z);
/* 289 */     TileEntityWeaponRack tile = (TileEntityWeaponRack)world.func_72796_p(x, y, z);
/*     */     
/* 291 */     if (m == 4)
/* 292 */       dir = 3;
/* 293 */     if (m == 2)
/* 294 */       dir = 0;
/* 295 */     if (m == 5)
/* 296 */       dir = 1;
/* 297 */     if (m == 3) {
/* 298 */       dir = 2;
/*     */     }
/* 300 */     if (!world.field_72995_K) {
/* 301 */       System.out.println("meta: " + m + "dir: " + dir);
/*     */     }
/*     */     
/* 304 */     tile.direction = dir;
/*     */   }
/*     */   
/*     */   public static boolean tryPlaceItem(int slot, World world, TileEntityWeaponRack tile, EntityPlayer player) {
/* 308 */     if (player.func_70093_af()) {
/* 309 */       player.openGui(MineFantasyBase.instance, 4, world, tile.field_70329_l, tile.field_70330_m, tile.field_70327_n);
/* 310 */       return false;
/*     */     }
/*     */     
/* 313 */     ItemStack held = player.func_70694_bm();
/* 314 */     if (held == null) {
/* 315 */       ItemStack hung = tile.func_70301_a(slot);
/* 316 */       if (hung != null) {
/* 317 */         if (!world.field_72995_K) {
/* 318 */           player.func_70062_b(0, hung);
/* 319 */           tile.func_70299_a(slot, null);
/* 320 */           tile.syncItems();
/*     */         }
/* 322 */         player.func_71038_i();
/* 323 */         return true;
/*     */       }
/*     */     } else {
/* 326 */       ItemStack hung = tile.func_70301_a(slot);
/*     */       
/* 328 */       if ((hung == null) && (TileEntityWeaponRack.canHang(player.func_70694_bm()))) {
/* 329 */         if (!world.field_72995_K) {
/* 330 */           tile.func_70299_a(slot, player.func_70694_bm().func_77946_l());
/* 331 */           player.func_70062_b(0, null);
/* 332 */           tile.syncItems();
/*     */         }
/* 334 */         player.func_71038_i();
/* 335 */         return true; }
/* 336 */       if ((held != null) && (hung != null) && 
/* 337 */         (hung.func_77969_a(held))) {
/* 338 */         int space = hung.func_77976_d() - hung.field_77994_a;
/*     */         
/* 340 */         if (held.field_77994_a > space) {
/* 341 */           if (!world.field_72995_K) {
/* 342 */             held.field_77994_a -= space;
/* 343 */             hung.field_77994_a += space;
/*     */           }
/* 345 */           player.func_71038_i();
/* 346 */           return true;
/*     */         }
/* 348 */         if (!world.field_72995_K) {
/* 349 */           hung.field_77994_a += held.field_77994_a;
/* 350 */           player.func_70062_b(0, null);
/*     */         }
/* 352 */         player.func_71038_i();
/* 353 */         return true;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 358 */     player.openGui(MineFantasyBase.instance, 4, world, tile.field_70329_l, tile.field_70330_m, tile.field_70327_n);
/* 359 */     return false;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/BlockWeaponRack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */