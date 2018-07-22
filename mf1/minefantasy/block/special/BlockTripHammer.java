/*     */ package minefantasy.block.special;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.api.anvil.ITongs;
/*     */ import minefantasy.api.forge.TongsHelper;
/*     */ import minefantasy.client.tile.TileEntityTripHammer;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.system.cfg;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.BlockPistonBase;
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
/*     */ public class BlockTripHammer
/*     */   extends BlockContainer
/*     */ {
/*  40 */   private Random rand = new Random();
/*     */   
/*     */   public BlockTripHammer(int i) {
/*  43 */     super(i, Material.field_76243_f);
/*  44 */     func_71849_a(ItemListMF.tabSmith);
/*     */   }
/*     */   
/*     */   public boolean func_71926_d() {
/*  48 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_71857_b() {
/*  53 */     return cfg.renderId;
/*     */   }
/*     */   
/*     */   public Icon func_71858_a(int side, int meta)
/*     */   {
/*  58 */     return Block.field_71963_Z.func_71858_a(2, 0);
/*     */   }
/*     */   
/*     */   public void addCreativeItems(ArrayList itemList)
/*     */   {
/*  63 */     itemList.add(new ItemStack(this));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_71886_c()
/*     */   {
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   public void func_71860_a(World world, int x, int y, int z, EntityLivingBase entity, ItemStack item)
/*     */   {
/*  76 */     int dir = MathHelper.func_76128_c(entity.field_70177_z * 4.0F / 360.0F + 0.5D) & 0x3;
/*     */     
/*  78 */     TileEntityTripHammer hammer = (TileEntityTripHammer)world.func_72796_p(x, y, z);
/*  79 */     hammer.direction = ((byte)dir);
/*     */   }
/*     */   
/*     */   public boolean func_71903_a(World world, int x, int y, int z, EntityPlayer player, int i, float f, float f1, float f2)
/*     */   {
/*  84 */     TileEntityTripHammer hammer = (TileEntityTripHammer)world.func_72796_p(x, y, z);
/*  85 */     if (hammer != null) {
/*  86 */       if (hammer.getType() == 0) {
/*  87 */         if ((!interact(hammer, world, player)) && (!world.field_72995_K)) {
/*  88 */           player.openGui(MineFantasyBase.instance, 9, world, x, y, z);
/*     */         }
/*     */       } else {
/*  91 */         hammer.force = 10;
/*     */       }
/*     */     }
/*  94 */     return true;
/*     */   }
/*     */   
/*     */   private boolean interact(TileEntityTripHammer tile, World world, EntityPlayer player) {
/*  98 */     ItemStack tongs = player.func_70694_bm();
/*     */     
/* 100 */     if ((tongs != null) && ((tongs.func_77973_b() instanceof ITongs))) {
/* 101 */       if (world.field_72995_K) {
/* 102 */         return true;
/*     */       }
/*     */       
/* 105 */       ItemStack holding = TongsHelper.getHeldItem(tongs);
/* 106 */       if (holding == null) {
/* 107 */         ItemStack inHammer = tile.func_70301_a(0);
/* 108 */         if ((inHammer != null) && 
/* 109 */           (TongsHelper.trySetHeldItem(tongs, inHammer))) {
/* 110 */           tile.func_70298_a(0, 1);
/* 111 */           tile.func_70296_d();
/* 112 */           return true;
/*     */         }
/*     */       }
/*     */       else {
/* 116 */         ItemStack out = tile.func_70301_a(0);
/* 117 */         if (out == null) {
/* 118 */           tile.func_70299_a(0, holding);
/* 119 */           TongsHelper.clearHeldItem(tongs, player);
/* 120 */           return true;
/*     */         }
/*     */       }
/* 123 */       return true;
/*     */     }
/* 125 */     return false;
/*     */   }
/*     */   
/*     */   public TileEntity func_72274_a(World var1)
/*     */   {
/* 130 */     return new TileEntityTripHammer();
/*     */   }
/*     */   
/*     */   public void func_71852_a(World world, int x, int y, int z, int i1, int i2)
/*     */   {
/* 135 */     TileEntityTripHammer tile = (TileEntityTripHammer)world.func_72796_p(x, y, z);
/*     */     
/* 137 */     if (tile != null) {
/* 138 */       for (int var6 = 0; var6 < tile.func_70302_i_(); var6++) {
/* 139 */         ItemStack var7 = tile.func_70301_a(var6);
/*     */         
/* 141 */         if (var7 != null) {
/* 142 */           float var8 = this.rand.nextFloat() * 0.8F + 0.1F;
/* 143 */           float var9 = this.rand.nextFloat() * 0.8F + 0.1F;
/* 144 */           float var10 = this.rand.nextFloat() * 0.8F + 0.1F;
/*     */           
/* 146 */           while (var7.field_77994_a > 0) {
/* 147 */             int var11 = this.rand.nextInt(21) + 10;
/*     */             
/* 149 */             if (var11 > var7.field_77994_a) {
/* 150 */               var11 = var7.field_77994_a;
/*     */             }
/*     */             
/* 153 */             var7.field_77994_a -= var11;
/* 154 */             EntityItem var12 = new EntityItem(world, x + var8, y + var9, z + var10, new ItemStack(var7.field_77993_c, var11, var7.func_77960_j()));
/*     */             
/* 156 */             if (var7.func_77942_o()) {
/* 157 */               var12.func_92059_d().func_77982_d((NBTTagCompound)var7.func_77978_p().func_74737_b());
/*     */             }
/*     */             
/* 160 */             float var13 = 0.05F;
/* 161 */             var12.field_70159_w = ((float)this.rand.nextGaussian() * var13);
/* 162 */             var12.field_70181_x = ((float)this.rand.nextGaussian() * var13 + 0.2F);
/* 163 */             var12.field_70179_y = ((float)this.rand.nextGaussian() * var13);
/* 164 */             world.func_72838_d(var12);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 170 */     super.func_71852_a(world, x, y, z, i1, i2);
/*     */   }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94332_a(IconRegister reg) {}
/*     */   
/*     */ 
/*     */   public int func_71899_b(int meta)
/*     */   {
/* 180 */     return (int)Math.floor(meta);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/BlockTripHammer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */