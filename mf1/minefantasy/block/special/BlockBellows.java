/*    */ package minefantasy.block.special;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Random;
/*    */ import minefantasy.client.tile.TileEntityBellows;
/*    */ import minefantasy.item.ItemListMF;
/*    */ import minefantasy.system.cfg;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockContainer;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IconRegister;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.Icon;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
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
/*    */ 
/*    */ 
/*    */ public class BlockBellows
/*    */   extends BlockContainer
/*    */ {
/* 36 */   private Random rand = new Random();
/*    */   
/*    */   public BlockBellows(int i) {
/* 39 */     super(i, Material.field_76245_d);
/* 40 */     func_71849_a(ItemListMF.tabSmellting);
/*    */   }
/*    */   
/*    */   public boolean func_71926_d() {
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public Icon func_71858_a(int side, int meta)
/*    */   {
/* 49 */     return Block.field_71988_x.func_71858_a(side, 0);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_71857_b() {
/* 54 */     return cfg.renderId;
/*    */   }
/*    */   
/*    */   public void addCreativeItems(ArrayList itemList)
/*    */   {
/* 59 */     itemList.add(new ItemStack(this));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean func_71886_c()
/*    */   {
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public void func_71860_a(World world, int x, int y, int z, EntityLivingBase entity, ItemStack item)
/*    */   {
/* 72 */     int dir = MathHelper.func_76128_c(entity.field_70177_z * 4.0F / 360.0F + 0.5D) & 0x3;
/*    */     
/* 74 */     TileEntityBellows bellows = (TileEntityBellows)world.func_72796_p(x, y, z);
/* 75 */     bellows.direction = ((byte)dir);
/*    */   }
/*    */   
/*    */   public boolean func_71903_a(World world, int x, int y, int z, EntityPlayer player, int i, float f, float f1, float f2)
/*    */   {
/* 80 */     TileEntityBellows bellows = (TileEntityBellows)world.func_72796_p(x, y, z);
/* 81 */     if (bellows != null) {
/* 82 */       bellows.interact(player, 2.0F);
/*    */     }
/* 84 */     return true;
/*    */   }
/*    */   
/*    */   public TileEntity func_72274_a(World var1)
/*    */   {
/* 89 */     return new TileEntityBellows();
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_94332_a(IconRegister reg) {}
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/BlockBellows.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */