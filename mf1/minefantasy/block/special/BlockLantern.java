/*    */ package minefantasy.block.special;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Random;
/*    */ import minefantasy.client.tile.TileEntityLantern;
/*    */ import minefantasy.item.ItemListMF;
/*    */ import minefantasy.system.cfg;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockContainer;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IconRegister;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.Icon;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class BlockLantern
/*    */   extends BlockContainer
/*    */ {
/*    */   public BlockLantern(int i, Material m)
/*    */   {
/* 25 */     super(i, m);
/*    */     
/*    */ 
/* 28 */     func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/* 29 */     func_71849_a(ItemListMF.tabDeco);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Icon func_71858_a(int side, int meta)
/*    */   {
/* 43 */     return Block.field_72069_aq.func_71858_a(side, meta);
/*    */   }
/*    */   
/*    */   public void func_71862_a(World world, int x, int y, int z, Random rand) {
/* 47 */     float partX = x + 0.5F;
/* 48 */     float partY = y + 0.5F + rand.nextFloat() * 6.0F / 16.0F;
/* 49 */     float partZ = z + 0.5F;
/* 50 */     float zRand = rand.nextFloat() * 0.6F - 0.3F;
/* 51 */     float xRand = rand.nextFloat() * 0.6F - 0.3F;
/* 52 */     world.func_72869_a("smoke", partX + xRand, partY, partZ + zRand, 0.0D, 0.0D, 0.0D);
/* 53 */     world.func_72869_a("flame", partX + xRand, partY, partZ + zRand, 0.0D, 0.0D, 0.0D);
/*    */   }
/*    */   
/*    */   public boolean func_71926_d()
/*    */   {
/* 58 */     return false;
/*    */   }
/*    */   
/*    */   public boolean func_71886_c() {
/* 62 */     return false;
/*    */   }
/*    */   
/*    */   public void addCreativeItems(ArrayList itemList)
/*    */   {
/* 67 */     itemList.add(new ItemStack(this));
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_71857_b() {
/* 72 */     return cfg.renderId;
/*    */   }
/*    */   
/*    */   public TileEntity func_72274_a(World w)
/*    */   {
/* 77 */     return new TileEntityLantern();
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_94332_a(IconRegister reg) {}
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/BlockLantern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */