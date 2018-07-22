/*    */ package mods.battlegear2.api.heraldry;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import net.minecraft.client.renderer.texture.DynamicTexture;
/*    */ 
/*    */ public class RefreshableTexture extends DynamicTexture
/*    */ {
/*    */   private int width;
/*    */   private int height;
/*    */   
/*    */   public RefreshableTexture(BufferedImage par1BufferedImage)
/*    */   {
/* 13 */     super(par1BufferedImage);
/* 14 */     this.width = par1BufferedImage.getWidth();
/* 15 */     this.height = par1BufferedImage.getHeight();
/*    */   }
/*    */   
/*    */   public RefreshableTexture(int par1, int par2) {
/* 19 */     super(par1, par2);
/* 20 */     this.width = par1;
/* 21 */     this.height = par2;
/*    */   }
/*    */   
/*    */   public void refreshWith(HeraldryData data, boolean scale) {
/* 25 */     refreshWith(data.getPatternIndex(), data, scale);
/*    */   }
/*    */   
/*    */   public void refreshWith(int patternIndex, HeraldryData data, boolean scale) {
/* 29 */     if ((patternIndex >= 0) && (patternIndex < PatternStore.DEFAULT.patterns.size())) {
/* 30 */       refreshWith((int[][][][])PatternStore.DEFAULT.patterns.get(patternIndex), data, scale);
/*    */     }
/*    */   }
/*    */   
/*    */   public void refreshWith(int[][][][] pattern, HeraldryData data, boolean scale) {
/* 35 */     BufferedImage image = new BufferedImage(pattern[data.getPattern()][0].length, pattern[data.getPattern()][0][0].length, 6);
/* 36 */     for (int x = 0; x < image.getWidth(); x++) {
/* 37 */       for (int y = 0; y < image.getHeight(); y++) {
/* 38 */         image.setRGB(x, y, PatternStore.getBlendedSmallPixel(pattern, data.getPattern(), x, y, data.getColour(0), data.getColour(1), data.getColour(2)));
/*    */       }
/*    */     }
/* 41 */     if ((scale) && ((image.getHeight() != this.height) || (image.getWidth() != this.width))) {
/* 42 */       image = (BufferedImage)image.getScaledInstance(this.width, this.height, 4);
/*    */     }
/* 44 */     int[] pixels = func_110565_c();
/* 45 */     for (int x = 0; x < image.getWidth(); x++) {
/* 46 */       for (int y = 0; y < image.getHeight(); y++) {
/* 47 */         pixels[(x + y * image.getWidth())] = image.getRGB(x, y);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/heraldry/RefreshableTexture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */