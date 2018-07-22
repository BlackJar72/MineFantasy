/*     */ package minefantasy.block.special;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import minefantasy.api.leatherwork.EnumToolType;
/*     */ import minefantasy.api.leatherwork.ITanningItem;
/*     */ import minefantasy.client.tile.TileEntityTanningRack;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.system.cfg;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.item.EnumToolMaterial;
/*     */ import net.minecraft.item.ItemShears;
/*     */ import net.minecraft.item.ItemStack;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockTanningRack
/*     */   extends BlockContainer
/*     */ {
/*  45 */   private Random rand = new Random();
/*     */   
/*     */   public BlockTanningRack(int i, int n, Material m) {
/*  48 */     super(i, m);
/*  49 */     func_71849_a(ItemListMF.tabTailor);
/*     */   }
/*     */   
/*     */   public boolean func_71926_d() {
/*  53 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_71857_b() {
/*  58 */     return cfg.renderId;
/*     */   }
/*     */   
/*     */   public Icon func_71858_a(int side, int meta)
/*     */   {
/*  63 */     return Block.field_71988_x.func_71858_a(side, 0);
/*     */   }
/*     */   
/*     */   public void addCreativeItems(ArrayList itemList)
/*     */   {
/*  68 */     itemList.add(new ItemStack(this));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_71886_c()
/*     */   {
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public void func_71921_a(World world, int x, int y, int z, EntityPlayer player)
/*     */   {
/*  81 */     ItemStack itemstack = player.field_71071_by.func_70448_g();
/*  82 */     TileEntityTanningRack tile = (TileEntityTanningRack)world.func_72796_p(x, y, z);
/*     */     
/*  84 */     use(tile, player);
/*     */   }
/*     */   
/*     */   public TileEntity func_72274_a(World w)
/*     */   {
/*  89 */     return new TileEntityTanningRack();
/*     */   }
/*     */   
/*     */   public void func_71860_a(World world, int x, int y, int z, EntityLivingBase entity, ItemStack item)
/*     */   {
/*  94 */     int dir = MathHelper.func_76128_c(entity.field_70177_z * 4.0F / 360.0F + 0.5D) & 0x3;
/*     */     
/*  96 */     TileEntityTanningRack tile = (TileEntityTanningRack)world.func_72796_p(x, y, z);
/*  97 */     tile.direction = dir;
/*     */   }
/*     */   
/*     */   public boolean func_71903_a(World world, int x, int y, int z, EntityPlayer player, int i, float f, float f1, float f2) {
/* 101 */     TileEntityTanningRack tile = (TileEntityTanningRack)world.func_72796_p(x, y, z);
/*     */     
/* 103 */     ItemStack itemstack = player.field_71071_by.func_70448_g();
/* 104 */     ItemStack hang = tile.getHung();
/*     */     
/* 106 */     if (use(tile, player)) {
/* 107 */       return true;
/*     */     }
/* 109 */     if ((!world.field_72995_K) && (hang == null) && (itemstack != null) && 
/* 110 */       (tile.canHang(itemstack))) {
/* 111 */       ItemStack placed = itemstack.func_77946_l();
/* 112 */       placed.field_77994_a = 1;
/* 113 */       tile.hang(placed);
/*     */       
/* 115 */       itemstack.field_77994_a -= 1;
/* 116 */       if (itemstack.field_77994_a <= 0) {
/* 117 */         player.func_70062_b(0, null);
/*     */       }
/*     */     }
/*     */     
/* 121 */     if (hang != null) {
/* 122 */       tile.retrieveItem(player);
/*     */     }
/*     */     
/* 125 */     return true;
/*     */   }
/*     */   
/*     */   public void func_71852_a(World world, int x, int y, int z, int i1, int i2) {
/* 129 */     TileEntityTanningRack tile = (TileEntityTanningRack)world.func_72796_p(x, y, z);
/*     */     
/* 131 */     super.func_71852_a(world, x, y, z, i1, i2);
/*     */   }
/*     */   
/*     */   private boolean use(TileEntityTanningRack tile, EntityPlayer player) {
/* 135 */     ItemStack held = player.func_70694_bm();
/* 136 */     ItemStack hung = tile.getHung();
/*     */     
/* 138 */     EnumToolType tool = null;
/* 139 */     float efficiency = 1.0F;
/* 140 */     if ((held != null) && (hung != null)) {
/* 141 */       if ((held.func_77973_b() instanceof ItemShears)) {
/* 142 */         tool = EnumToolType.CUTTER;
/* 143 */         efficiency = EnumToolMaterial.IRON.func_77998_b();
/*     */       }
/* 145 */       if ((held.func_77973_b() instanceof ITanningItem)) {
/* 146 */         tool = ((ITanningItem)held.func_77973_b()).getType();
/* 147 */         efficiency = ((ITanningItem)held.func_77973_b()).getQuality();
/*     */       }
/*     */       
/* 150 */       if (tool != null) {
/* 151 */         tile.use(player, tool, efficiency);
/* 152 */         return true;
/*     */       }
/*     */     }
/* 155 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94332_a(IconRegister reg) {}
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/BlockTanningRack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */