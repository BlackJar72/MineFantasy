/*     */ package mods.battlegear2.api.heraldry;
/*     */ 
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.imageio.ImageIO;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.resources.Resource;
/*     */ import net.minecraft.client.resources.ResourceManager;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ public class PatternStore
/*     */ {
/*  16 */   public static final ResourceManager rm = Minecraft.func_71410_x().func_110442_L();
/*  17 */   public static final PatternStore DEFAULT = new PatternStore(8, 4);
/*     */   private final int IMAGES_X;
/*     */   private final int IMAGES_Y;
/*  20 */   public List<int[][][][]> patterns = new ArrayList();
/*     */   
/*     */   public PatternStore(int xSections, int ySections) {
/*  23 */     this.IMAGES_X = xSections;
/*  24 */     this.IMAGES_Y = ySections;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int buildPatternAndStore(ResourceLocation image)
/*     */   {
/*     */     try
/*     */     {
/*  34 */       if (this.patterns.add(buildPatternFrom(image))) {
/*  35 */         return this.patterns.size() - 1;
/*     */       }
/*  37 */       return -1;
/*     */     }
/*     */     catch (IOException io) {}
/*  40 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int[][][][] buildPatternFrom(ResourceLocation image)
/*     */     throws IOException
/*     */   {
/*  49 */     return buildPatternFrom(rm.func_110536_a(image).func_110527_b());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int[][][][] buildPatternFrom(InputStream resourceStream)
/*     */     throws IOException
/*     */   {
/*  57 */     return buildPatternFrom(ImageIO.read(resourceStream));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int[][][][] buildPatternFrom(BufferedImage image)
/*     */   {
/*  66 */     int[][][][] rgbs = new int[this.IMAGES_X * this.IMAGES_Y][3][image.getWidth() / this.IMAGES_X][image.getHeight() / this.IMAGES_Y];
/*     */     
/*  68 */     int imageRes = image.getWidth() / this.IMAGES_X;
/*  69 */     for (int x = 0; x < image.getWidth(); x++) {
/*  70 */       for (int y = 0; y < image.getHeight(); y++) {
/*  71 */         int imageNo = x / imageRes + this.IMAGES_X * (y / imageRes);
/*  72 */         int rgb = image.getRGB(x, y);
/*  73 */         int red = rgb >> 16 & 0xFF;
/*  74 */         int green = rgb >> 8 & 0xFF;
/*  75 */         int blue = rgb & 0xFF;
/*     */         
/*  77 */         int total = red + green + blue;
/*     */         
/*  79 */         if (total == 0) {
/*  80 */           rgbs[imageNo][0][(x % imageRes)][(y % imageRes)] = 'ÿ';
/*  81 */           rgbs[imageNo][1][(x % imageRes)][(y % imageRes)] = 0;
/*  82 */           rgbs[imageNo][2][(x % imageRes)][(y % imageRes)] = 0;
/*     */         } else {
/*  84 */           rgbs[imageNo][0][(x % imageRes)][(y % imageRes)] = (255 * red / total);
/*  85 */           rgbs[imageNo][1][(x % imageRes)][(y % imageRes)] = (255 * green / total);
/*  86 */           rgbs[imageNo][2][(x % imageRes)][(y % imageRes)] = (255 * blue / total);
/*     */         }
/*     */       }
/*     */     }
/*  90 */     return rgbs;
/*     */   }
/*     */   
/*     */   public int getBlendedSmallPixel(int index, byte imageNo, int x, int y, int col1, int col2, int col3) {
/*  94 */     return getBlendedSmallPixel(((int[][][][])this.patterns.get(index))[imageNo][0][x][y], ((int[][][][])this.patterns.get(index))[imageNo][1][x][y], ((int[][][][])this.patterns.get(index))[imageNo][2][x][y], col1, col2, col3);
/*     */   }
/*     */   
/*     */   public static int getBlendedSmallPixel(int[][][][] rgbs, byte imageNo, int x, int y, int col1, int col2, int col3) {
/*  98 */     return getBlendedSmallPixel(rgbs[imageNo][0][x][y], rgbs[imageNo][1][x][y], rgbs[imageNo][2][x][y], col1, col2, col3);
/*     */   }
/*     */   
/*     */   public static int getBlendedSmallPixel(int a, int b, int c, int col1, int col2, int col3) {
/* 102 */     int red = (col1 >> 16 & 0xFF) * a / 255 + (col2 >> 16 & 0xFF) * b / 255 + (col3 >> 16 & 0xFF) * c / 255;
/*     */     
/*     */ 
/*     */ 
/* 106 */     int green = (col1 >> 8 & 0xFF) * a / 255 + (col2 >> 8 & 0xFF) * b / 255 + (col3 >> 8 & 0xFF) * c / 255;
/*     */     
/*     */ 
/*     */ 
/* 110 */     int blue = (col1 & 0xFF) * a / 255 + (col2 & 0xFF) * b / 255 + (col3 & 0xFF) * c / 255;
/*     */     
/*     */ 
/*     */ 
/* 114 */     return 0xFF000000 | red << 16 & 0xFF0000 | green << 8 & 0xFF00 | blue & 0xFF;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/heraldry/PatternStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */