/*    */ package minefantasy.client.tile;
/*    */ 
/*    */ import minefantasy.MineFantasyBase;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TileEntityLantern
/*    */   extends TileEntity
/*    */ {
/* 13 */   public boolean[] neighbourBlock = new boolean[4];
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void func_70316_g()
/*    */   {
/* 21 */     super.func_70316_g();
/* 22 */     getNeighbourBlock(this.field_70331_k, this.field_70329_l, this.field_70330_m, this.field_70327_n);
/*    */   }
/*    */   
/*    */   private boolean updateBlockInfo(World world, int x, int y, int z) {
/* 26 */     int id = world.func_72798_a(x, y, z);
/* 27 */     if ((id != 0) && 
/* 28 */       (Block.field_71973_m[id].func_71926_d()) && (id != MineFantasyBase.MFBlockLantern.field_71990_ca)) {
/* 29 */       return true;
/*    */     }
/*    */     
/* 32 */     return false;
/*    */   }
/*    */   
/*    */   public void getNeighbourBlock(World world, int x, int y, int z) {
/* 36 */     this.neighbourBlock[1] = updateBlockInfo(world, x + 1, y, z);
/* 37 */     this.neighbourBlock[2] = updateBlockInfo(world, x, y, z + 1);
/* 38 */     this.neighbourBlock[0] = updateBlockInfo(world, x - 1, y, z);
/* 39 */     this.neighbourBlock[3] = updateBlockInfo(world, x, y, z - 1);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/TileEntityLantern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */