/*     */ package minefantasy.block.special;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import minefantasy.client.tile.TileEntityFoodPrep;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.BlockFence;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemBlock;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockFoodPrep
/*     */   extends BlockContainer
/*     */ {
/*  44 */   private Random rand = new Random();
/*     */   
/*     */   public BlockFoodPrep(int i, Material m) {
/*  47 */     super(i, m);
/*  48 */     func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
/*  49 */     func_71849_a(ItemListMF.tabCook);
/*     */   }
/*     */   
/*     */   public boolean func_71926_d() {
/*  53 */     return false;
/*     */   }
/*     */   
/*     */   public Icon func_71858_a(int side, int meta)
/*     */   {
/*  58 */     return Block.field_71988_x.func_71858_a(side, 0);
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
/*     */   public void func_71921_a(World world, int x, int y, int z, EntityPlayer player)
/*     */   {
/*  76 */     TileEntityFoodPrep tile = (TileEntityFoodPrep)world.func_72796_p(x, y, z);
/*  77 */     tile.interact(player, true);
/*     */   }
/*     */   
/*     */   public Icon func_71895_b(IBlockAccess world, int x, int y, int z, int side)
/*     */   {
/*  82 */     TileEntityFoodPrep tile = (TileEntityFoodPrep)world.func_72796_p(x, y, z);
/*     */     
/*  84 */     ItemStack tex = tile.func_70301_a(1);
/*  85 */     if ((tex != null) && 
/*  86 */       (tex.func_77973_b() != null) && ((tex.func_77973_b() instanceof ItemBlock))) {
/*  87 */       Block block = Block.field_71973_m[tex.field_77993_c];
/*  88 */       if (block != null) {
/*  89 */         return block.func_71858_a(side, tex.func_77960_j());
/*     */       }
/*     */     }
/*     */     
/*  93 */     return null;
/*     */   }
/*     */   
/*     */   public TileEntity func_72274_a(World w)
/*     */   {
/*  98 */     return new TileEntityFoodPrep();
/*     */   }
/*     */   
/*     */   public void func_71860_a(World world, int x, int y, int z, EntityLivingBase entity, ItemStack item)
/*     */   {
/* 103 */     int dir = MathHelper.func_76128_c(entity.field_70177_z * 4.0F / 360.0F + 0.5D) & 0x3;
/*     */     
/* 105 */     TileEntityFoodPrep tile = (TileEntityFoodPrep)world.func_72796_p(x, y, z);
/* 106 */     tile.direction = dir;
/*     */   }
/*     */   
/*     */   public boolean func_71903_a(World world, int x, int y, int z, EntityPlayer player, int i, float f, float f1, float f2)
/*     */   {
/* 111 */     TileEntityFoodPrep tile = (TileEntityFoodPrep)world.func_72796_p(x, y, z);
/* 112 */     return tile.interact(player, false);
/*     */   }
/*     */   
/*     */   public void func_71852_a(World world, int x, int y, int z, int i1, int i2) {
/* 116 */     TileEntityFoodPrep tile = (TileEntityFoodPrep)world.func_72796_p(x, y, z);
/* 117 */     dropItem(tile.func_70301_a(0), world, x, y, z, true);
/*     */     
/* 119 */     super.func_71852_a(world, x, y, z, i1, i2);
/*     */   }
/*     */   
/*     */   private void dropItem(ItemStack drop, World world, int x, int y, int z, boolean move)
/*     */   {
/* 124 */     if (drop != null) {
/* 125 */       float var8 = this.rand.nextFloat() * 0.8F + 0.1F;
/* 126 */       float var9 = this.rand.nextFloat() * 0.8F + 0.1F;
/* 127 */       float var10 = this.rand.nextFloat() * 0.8F + 0.1F;
/*     */       
/* 129 */       while (drop.field_77994_a > 0) {
/* 130 */         int var11 = this.rand.nextInt(21) + 10;
/*     */         
/* 132 */         if (var11 > drop.field_77994_a) {
/* 133 */           var11 = drop.field_77994_a;
/*     */         }
/*     */         
/* 136 */         drop.field_77994_a -= var11;
/* 137 */         EntityItem var12 = new EntityItem(world, x + var8, y + var9, z + var10, new ItemStack(drop.field_77993_c, var11, drop.func_77960_j()));
/*     */         
/* 139 */         if (drop.func_77942_o()) {
/* 140 */           var12.func_92059_d().func_77982_d((NBTTagCompound)drop.func_77978_p().func_74737_b());
/*     */         }
/*     */         
/* 143 */         if (move) {
/* 144 */           float var13 = 0.05F;
/* 145 */           var12.field_70159_w = ((float)this.rand.nextGaussian() * var13);
/* 146 */           var12.field_70181_x = ((float)this.rand.nextGaussian() * var13 + 0.2F);
/* 147 */           var12.field_70179_y = ((float)this.rand.nextGaussian() * var13);
/*     */         }
/* 149 */         world.func_72838_d(var12);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_71930_b(World world, int x, int y, int z) {
/* 155 */     return (world.func_72797_t(x, y - 1, z)) || (BlockFence.func_72249_c(world.func_72798_a(x, y - 1, z)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_71863_a(World world, int x, int y, int z, int neighbor)
/*     */   {
/* 164 */     boolean flag = false;
/*     */     
/* 166 */     if ((!world.func_72797_t(x, y - 1, z)) && (!BlockFence.func_72249_c(world.func_72798_a(x, y - 1, z)))) {
/* 167 */       flag = true;
/*     */     }
/*     */     
/* 170 */     if (flag) {
/* 171 */       func_71897_c(world, x, y, z, world.func_72805_g(x, y, z), 0);
/* 172 */       world.func_94571_i(x, y, z);
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94332_a(IconRegister reg) {}
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/BlockFoodPrep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */