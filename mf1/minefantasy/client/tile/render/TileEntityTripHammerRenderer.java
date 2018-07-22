/*     */ package minefantasy.client.tile.render;
/*     */ 
/*     */ import minefantasy.client.MFTextureHelper;
/*     */ import minefantasy.client.tile.TileEntityTripHammer;
/*     */ import minefantasy.client.tile.model.ModelTripHammer;
/*     */ import minefantasy.client.tile.model.ModelTripHammerBack;
/*     */ import minefantasy.system.MFResource;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.ItemRenderer;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ public class TileEntityTripHammerRenderer
/*     */   extends TileEntitySpecialRenderer
/*     */ {
/*     */   private ModelTripHammerBack model2;
/*     */   private ModelTripHammer model;
/*     */   
/*     */   public TileEntityTripHammerRenderer()
/*     */   {
/*  25 */     this.model = new ModelTripHammer();
/*  26 */     this.model2 = new ModelTripHammerBack();
/*     */   }
/*     */   
/*     */   public void renderAModelAt(TileEntityTripHammer tile, double d, double d1, double d2, float f) {
/*  30 */     int tiledirection = 1;int tileangle = 90 * tiledirection;
/*     */     
/*  32 */     if (tile.field_70331_k != null) {
/*  33 */       tiledirection = tile.direction;
/*     */     }
/*     */     
/*  36 */     switch (tiledirection) {
/*     */     case 0: 
/*  38 */       tileangle = 90;
/*  39 */       break;
/*     */     
/*     */     case 1: 
/*  42 */       tileangle = 0;
/*  43 */       break;
/*     */     
/*     */     case 2: 
/*  46 */       tileangle = 270;
/*  47 */       break;
/*     */     
/*     */     case 3: 
/*  50 */       tileangle = 180;
/*     */     }
/*     */     
/*     */     
/*     */ 
/*  55 */     float p = tile.getArmValue();
/*  56 */     if (tile.getType() == 0) {
/*  57 */       this.model.rotate(p);
/*     */     }
/*     */     
/*  60 */     String type = "TripHammer";
/*  61 */     if (tile.getType() == 1) {
/*  62 */       type = "TripHammerBack";
/*     */     }
/*  64 */     Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.getResource(MFResource.image("/item/" + type + ".png")));
/*  65 */     GL11.glPushMatrix();
/*  66 */     GL11.glTranslated(d + 0.5D, d1 + 1.525D, d2 + 0.5D);
/*  67 */     GL11.glRotatef(tileangle, 0.0F, 1.0F, 0.0F);
/*  68 */     GL11.glScalef(1.0F, -1.0F, -1.0F);
/*     */     
/*  70 */     if (tile.getType() == 1) {
/*  71 */       this.model2.renderModel(p, 0.0625F);
/*     */     } else {
/*  73 */       this.model.renderModel(p, 0.0625F);
/*     */     }
/*     */     
/*  76 */     GL11.glPushMatrix();
/*  77 */     GL11.glTranslatef(-pixel(1.0F), pixel(11.0F), 0.35F);
/*  78 */     GL11.glPushMatrix();
/*  79 */     GL11.glScalef(0.75F, 0.75F, 0.75F);
/*  80 */     GL11.glRotatef(p * 360.0F, 0.0F, 0.0F, 1.0F);
/*  81 */     renderWheel(tile, 86, 24, 20, 20, 128, 64);
/*  82 */     GL11.glPopMatrix();
/*  83 */     GL11.glPopMatrix();
/*     */     
/*  85 */     GL11.glPushMatrix();
/*  86 */     GL11.glTranslatef(-pixel(1.0F), pixel(11.0F), -0.35F);
/*  87 */     GL11.glPushMatrix();
/*  88 */     GL11.glScalef(0.75F, 0.75F, 0.75F);
/*  89 */     GL11.glRotatef(p * 360.0F, 0.0F, 0.0F, 1.0F);
/*  90 */     renderWheel(tile, 86, 24, 20, 20, 128, 64);
/*  91 */     GL11.glPopMatrix();
/*  92 */     GL11.glPopMatrix();
/*     */     
/*  94 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_76894_a(TileEntity tileentity, double d, double d1, double d2, float f)
/*     */   {
/* 100 */     renderAModelAt((TileEntityTripHammer)tileentity, d, d1, d2, f);
/*     */   }
/*     */   
/*     */   private void renderWheel(TileEntityTripHammer tile, int x, int y, int w, int h, int tw, int th) {
/* 104 */     float f = 0.01F / tw;
/* 105 */     float f1 = 0.01F / th;
/*     */     
/* 107 */     float x1 = x / tw + f;
/* 108 */     float x2 = (x + w) / tw - f;
/* 109 */     float y1 = y / th + f1;
/* 110 */     float y2 = (y + h) / th - f1;
/*     */     
/* 112 */     Tessellator image = Tessellator.field_78398_a;
/* 113 */     float xPos = 0.5F;
/* 114 */     float yPos = 0.5F;
/* 115 */     GL11.glEnable(32826);
/* 116 */     GL11.glTranslatef(-xPos, -yPos, pixel(0.5F));
/* 117 */     float var13 = 1.0F;
/* 118 */     GL11.glScalef(var13, var13, var13);
/* 119 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 120 */     GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
/* 121 */     ItemRenderer.func_78439_a(image, x2, y1, x1, y2, tw, th, 0.0625F);
/*     */   }
/*     */   
/*     */   public float pixel(float count)
/*     */   {
/* 126 */     return count * 0.0625F;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/render/TileEntityTripHammerRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */