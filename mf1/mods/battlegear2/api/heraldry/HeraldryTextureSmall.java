/*    */ package mods.battlegear2.api.heraldry;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import net.minecraft.client.renderer.texture.AbstractTexture;
/*    */ import net.minecraft.client.renderer.texture.TextureUtil;
/*    */ import net.minecraft.client.resources.ResourceManager;
/*    */ 
/*    */ public class HeraldryTextureSmall extends AbstractTexture
/*    */ {
/*    */   private HeraldryData heraldryData;
/*    */   
/*    */   public HeraldryTextureSmall(HeraldryData crest)
/*    */   {
/* 14 */     this.heraldryData = crest;
/*    */   }
/*    */   
/*    */   public void func_110551_a(ResourceManager resourcemanager)
/*    */   {
/* 19 */     int[][][][] patt = (int[][][][])PatternStore.DEFAULT.patterns.get(this.heraldryData.getPatternIndex());
/* 20 */     BufferedImage image = new BufferedImage(patt[this.heraldryData.getPattern()][0].length, patt[this.heraldryData.getPattern()][0][0].length, 6);
/*    */     
/* 22 */     for (int x = 0; x < image.getWidth(); x++) {
/* 23 */       for (int y = 0; y < image.getHeight(); y++) {
/* 24 */         image.setRGB(x, y, PatternStore.getBlendedSmallPixel(patt, this.heraldryData.getPattern(), x, y, this.heraldryData.getColour(0), this.heraldryData.getColour(1), this.heraldryData.getColour(2)));
/*    */       }
/*    */     }
/* 27 */     TextureUtil.func_110987_a(func_110552_b(), image);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/heraldry/HeraldryTextureSmall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */