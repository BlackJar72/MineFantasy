/*     */ package minefantasy.block.special;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.client.tile.TileEntityDogBowl;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.system.cfg;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.item.ItemFood;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.Icon;
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
/*     */ public class BlockDogBowl
/*     */   extends BlockContainer
/*     */ {
/*  36 */   private Random rand = new Random();
/*     */   
/*     */   public BlockDogBowl(int i) {
/*  39 */     super(i, Material.field_76245_d);
/*  40 */     func_71905_a(0.2F, 0.0F, 0.2F, 0.8F, 0.5F, 0.8F);
/*  41 */     func_71849_a(ItemListMF.tabPets);
/*     */   }
/*     */   
/*     */   public boolean func_71926_d()
/*     */   {
/*  46 */     return false;
/*     */   }
/*     */   
/*     */   public void addCreativeItems(ArrayList itemList)
/*     */   {
/*  51 */     for (int m = 0; m < 3; m++) {
/*  52 */       itemList.add(new ItemStack(this, 1, m));
/*     */     }
/*     */   }
/*     */   
/*     */   public Icon func_71858_a(int side, int meta) {
/*  57 */     if (meta == 1) {
/*  58 */       return MineFantasyBase.MFBlockStorage.func_71858_a(0, 7);
/*     */     }
/*  60 */     if (meta == 2) {
/*  61 */       return MineFantasyBase.MFBlockStorage.func_71858_a(0, 0);
/*     */     }
/*  63 */     return Block.field_71988_x.func_71858_a(0, 0);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_71857_b()
/*     */   {
/*  69 */     return cfg.renderId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_71886_c()
/*     */   {
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public TileEntity func_72274_a(World w)
/*     */   {
/*  84 */     return new TileEntityDogBowl();
/*     */   }
/*     */   
/*     */   public int func_71899_b(int meta)
/*     */   {
/*  89 */     return meta;
/*     */   }
/*     */   
/*     */   public boolean func_71903_a(World world, int x, int y, int z, EntityPlayer player, int i1, float f1, float f2, float f3)
/*     */   {
/*  94 */     ItemStack itemstack = player.field_71071_by.func_70448_g();
/*  95 */     TileEntityDogBowl tile = (TileEntityDogBowl)world.func_72796_p(x, y, z);
/*     */     
/*  97 */     if ((!world.field_72995_K) && (tile != null) && (itemstack != null) && ((itemstack.func_77973_b() instanceof ItemFood))) {
/*  98 */       ItemFood food = (ItemFood)itemstack.func_77973_b();
/*  99 */       if ((food.func_77845_h()) && (tile.canPutFood())) {
/* 100 */         tile.addFood(food.func_77847_f());
/* 101 */         if (!player.field_71075_bZ.field_75098_d)
/* 102 */           itemstack.field_77994_a -= 1;
/* 103 */         player.func_71038_i();
/* 104 */         return true;
/*     */       }
/*     */     }
/* 107 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94332_a(IconRegister reg) {}
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/BlockDogBowl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */