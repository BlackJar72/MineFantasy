/*     */ package minefantasy.block.special;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.client.tile.TileEntityRoast;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.system.cfg;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraft.util.MathHelper;
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
/*     */ public class BlockRoast
/*     */   extends BlockContainer
/*     */ {
/*  41 */   private Random rand = new Random();
/*     */   
/*     */   public BlockRoast(int i) {
/*  44 */     super(i, Material.field_76245_d);
/*  45 */     func_71849_a(ItemListMF.tabCook);
/*     */   }
/*     */   
/*     */   public boolean func_71926_d() {
/*  49 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_71857_b() {
/*  54 */     return cfg.renderId;
/*     */   }
/*     */   
/*     */   public Icon func_71858_a(int side, int meta)
/*     */   {
/*  59 */     return Block.field_71988_x.func_71858_a(side, 0);
/*     */   }
/*     */   
/*     */   public void addCreativeItems(ArrayList itemList)
/*     */   {
/*  64 */     itemList.add(new ItemStack(this));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_71886_c()
/*     */   {
/*  72 */     return false;
/*     */   }
/*     */   
/*     */   public TileEntity func_72274_a(World w)
/*     */   {
/*  77 */     return new TileEntityRoast();
/*     */   }
/*     */   
/*     */   public void func_71860_a(World world, int x, int y, int z, EntityLivingBase entity, ItemStack item)
/*     */   {
/*  82 */     int dir = MathHelper.func_76128_c(entity.field_70177_z * 4.0F / 360.0F + 0.5D) & 0x3;
/*     */     
/*  84 */     TileEntityRoast tile = (TileEntityRoast)world.func_72796_p(x, y, z);
/*  85 */     tile.direction = dir;
/*  86 */     tile.sendPacketToServer();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_71852_a(World world, int x, int y, int z, int i1, int i2)
/*     */   {
/*  93 */     TileEntityRoast tile = (TileEntityRoast)world.func_72796_p(x, y, z);
/*     */     
/*  95 */     if (tile != null) {
/*  96 */       for (int var6 = 0; var6 < tile.func_70302_i_(); var6++) {
/*  97 */         ItemStack var7 = tile.func_70301_a(var6);
/*     */         
/*  99 */         if (var7 != null) {
/* 100 */           float var8 = this.rand.nextFloat() * 0.8F + 0.1F;
/* 101 */           float var9 = this.rand.nextFloat() * 0.8F + 0.1F;
/* 102 */           float var10 = this.rand.nextFloat() * 0.8F + 0.1F;
/*     */           
/* 104 */           while (var7.field_77994_a > 0) {
/* 105 */             int var11 = this.rand.nextInt(21) + 10;
/*     */             
/* 107 */             if (var11 > var7.field_77994_a) {
/* 108 */               var11 = var7.field_77994_a;
/*     */             }
/*     */             
/* 111 */             var7.field_77994_a -= var11;
/* 112 */             EntityItem var12 = new EntityItem(world, x + var8, y + var9, z + var10, new ItemStack(var7.field_77993_c, var11, var7.func_77960_j()));
/*     */             
/* 114 */             if (var7.func_77942_o()) {
/* 115 */               var12.func_92059_d().func_77982_d((NBTTagCompound)var7.func_77978_p().func_74737_b());
/*     */             }
/*     */             
/* 118 */             float var13 = 0.05F;
/* 119 */             var12.field_70159_w = ((float)this.rand.nextGaussian() * var13);
/* 120 */             var12.field_70181_x = ((float)this.rand.nextGaussian() * var13 + 0.2F);
/* 121 */             var12.field_70179_y = ((float)this.rand.nextGaussian() * var13);
/* 122 */             world.func_72838_d(var12);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 128 */     super.func_71852_a(world, x, y, z, i1, i2);
/*     */   }
/*     */   
/*     */   public boolean func_71903_a(World world, int x, int y, int z, EntityPlayer player, int i, float f, float f1, float f2)
/*     */   {
/* 133 */     if (world.field_72995_K) {
/* 134 */       return true;
/*     */     }
/* 136 */     TileEntityRoast tile = (TileEntityRoast)world.func_72796_p(x, y, z);
/*     */     
/* 138 */     if (tile != null) {
/* 139 */       if (canPlaceFood(tile, player, i)) {
/* 140 */         ItemStack item = player.func_70694_bm();
/*     */         
/*     */ 
/* 143 */         if (tile.tryTakeItem(player)) {
/* 144 */           return true;
/*     */         }
/*     */         
/* 147 */         if (tile.tryAddItem(item)) {
/* 148 */           if (!player.field_71075_bZ.field_75098_d) {
/* 149 */             item.field_77994_a -= 1;
/*     */           }
/*     */           
/* 152 */           return true;
/*     */         }
/*     */       }
/*     */       
/* 156 */       player.openGui(MineFantasyBase.instance, 11, world, x, y, z);
/*     */     }
/*     */     
/* 159 */     return true;
/*     */   }
/*     */   
/*     */   private boolean canPlaceFood(TileEntityRoast tile, EntityPlayer player, int i)
/*     */   {
/* 164 */     ForgeDirection tileFace = BlockClickHelper.FD[tile.direction];
/* 165 */     ForgeDirection face = ForgeDirection.getOrientation(i);
/*     */     
/* 167 */     if (player.func_70093_af()) {
/* 168 */       return false;
/*     */     }
/* 170 */     if ((tileFace == ForgeDirection.NORTH) || (tileFace == ForgeDirection.SOUTH)) {
/* 171 */       return (face == ForgeDirection.NORTH) || (face == ForgeDirection.SOUTH);
/*     */     }
/* 173 */     if ((tileFace == ForgeDirection.EAST) || (tileFace == ForgeDirection.WEST)) {
/* 174 */       return (face == ForgeDirection.EAST) || (face == ForgeDirection.WEST);
/*     */     }
/* 176 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94332_a(IconRegister reg) {}
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/BlockRoast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */