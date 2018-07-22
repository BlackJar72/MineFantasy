/*    */ package minefantasy.block.special;
/*    */ 
/*    */ import net.minecraftforge.common.ForgeDirection;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockClickHelper
/*    */ {
/*    */   public static int[] getCoordsFor(float clickX, float clickY, float xBound, float xBound2, float yBound, float yBound2, int xSlots, int ySlots, int dir)
/*    */   {
/* 29 */     if ((clickX < xBound) || (clickX > xBound2) || (clickY < yBound) || (clickY > yBound2)) {
/* 30 */       return null;
/*    */     }
/*    */     
/* 33 */     clickX -= xBound;
/* 34 */     clickY -= yBound;
/*    */     
/* 36 */     float xMax = xBound2 - xBound;
/* 37 */     float yMax = yBound2 - yBound;
/*    */     
/* 39 */     int xSlot = 0;
/* 40 */     int ySlot = 0;
/*    */     
/* 42 */     float xSpace = xMax / xSlots;
/* 43 */     float ySpace = yMax / ySlots;
/*    */     
/* 45 */     for (int xT = 0; xT < xSlots; xT++) {
/* 46 */       float MinSpace = xSpace * xT;
/* 47 */       float MaxSpace = xSpace * (xT + 1);
/* 48 */       if ((clickX < MaxSpace) && (clickX > MinSpace)) {
/* 49 */         xSlot = xT;
/*    */       }
/*    */     }
/*    */     
/* 53 */     for (int yT = 0; yT < ySlots; yT++) {
/* 54 */       float MinSpace = ySpace * yT;
/* 55 */       float MaxSpace = ySpace * (yT + 1);
/* 56 */       if ((clickY < MaxSpace) && (clickY > MinSpace)) {
/* 57 */         ySlot = yT;
/*    */       }
/*    */     }
/* 60 */     return translateCoords(xSlot, ySlot, xSlots, ySlots, dir);
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int[] translateCoords(int x, int y, int maxX, int maxY, int direction)
/*    */   {
/* 78 */     ForgeDirection dir = FD[direction];
/* 79 */     if (dir == ForgeDirection.SOUTH) {
/* 80 */       int newX = maxX - x - 1;
/* 81 */       int newY = maxY - y - 1;
/* 82 */       return new int[] { newX, newY };
/*    */     }
/*    */     
/* 85 */     if (dir == ForgeDirection.EAST) {
/* 86 */       int newX = y;
/* 87 */       int newY = maxX - x - 1;
/* 88 */       return new int[] { newX, newY };
/*    */     }
/* 90 */     if (dir == ForgeDirection.WEST) {
/* 91 */       int newY = x;
/* 92 */       int newX = maxY - y - 1;
/* 93 */       return new int[] { newX, newY };
/*    */     }
/*    */     
/* 96 */     return new int[] { x, y };
/*    */   }
/*    */   
/* 99 */   public static ForgeDirection[] FD = { ForgeDirection.SOUTH, ForgeDirection.WEST, ForgeDirection.NORTH, ForgeDirection.EAST };
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/BlockClickHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */