/*     */ package minefantasy.client.tile.render;
/*     */ 
/*     */ import minefantasy.client.MFTextureHelper;
/*     */ import minefantasy.client.tile.TileEntityFurnaceMF;
/*     */ import minefantasy.client.tile.model.ModelFurnaceMF;
/*     */ import minefantasy.system.MFResource;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.ItemRenderer;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class TileEntityFurnaceRendererMF extends TileEntitySpecialRenderer
/*     */ {
/*     */   private ModelFurnaceMF model;
/*     */   
/*     */   public TileEntityFurnaceRendererMF()
/*     */   {
/*  21 */     this.model = new ModelFurnaceMF();
/*     */   }
/*     */   
/*     */   public void renderAModelAt(TileEntityFurnaceMF tile, double d, double d1, double d2, float f) {
/*  25 */     int tiledirection = 1;int tileangle = 90 * tiledirection;
/*     */     
/*  27 */     if (tile.field_70331_k != null) {
/*  28 */       tiledirection = tile.direction;
/*     */     }
/*     */     
/*  31 */     switch (tiledirection) {
/*     */     case 0: 
/*  33 */       tileangle = 0;
/*  34 */       break;
/*     */     
/*     */     case 1: 
/*  37 */       tileangle = 270;
/*  38 */       break;
/*     */     
/*     */     case 2: 
/*  41 */       tileangle = 180;
/*  42 */       break;
/*     */     
/*     */     case 3: 
/*     */     case 4: 
/*  46 */       tileangle = 90;
/*     */     }
/*     */     
/*     */     
/*     */ 
/*  51 */     String type = tile.getTexture();
/*     */     
/*  53 */     Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.getResource(MFResource.image("/item/" + type + ".png")));
/*     */     
/*  55 */     boolean display = tile.isBurning();
/*     */     
/*  57 */     GL11.glPushMatrix();
/*  58 */     float scale = 1.0F;
/*     */     
/*  60 */     float offset = 0.9375F;
/*  61 */     GL11.glTranslatef((float)d + 0.5F, (float)d1 + 0.127F, (float)d2 + 0.5F);
/*  62 */     GL11.glRotatef(tileangle - 90, 0.0F, 1.0F, 0.0F);
/*  63 */     GL11.glScalef(scale, -scale, -scale);
/*  64 */     this.model.renderModel(display, 0.0625F);
/*     */     
/*  66 */     float sc = 0.75F;
/*  67 */     float angle = 4.5F * tile.doorAngle;
/*  68 */     GL11.glPushMatrix();
/*  69 */     GL11.glTranslatef(-pixel(8.0F), -pixel(12.0F), 0.0F);
/*  70 */     if (tile.isHeater()) {
/*  71 */       GL11.glTranslatef(0.0F, pixel(12.0F), 0.0F);
/*     */     }
/*  73 */     GL11.glPushMatrix();
/*  74 */     GL11.glScalef(sc, sc, sc);
/*  75 */     GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
/*  76 */     if (tile.isHeater()) {
/*  77 */       GL11.glRotatef(angle, 1.0F, 0.0F, 0.0F);
/*  78 */       renderDoorHeater(tile, 0, 54, 12, 8, 128, 64);
/*     */     } else {
/*  80 */       GL11.glRotatef(-angle, 1.0F, 0.0F, 0.0F);
/*  81 */       renderDoor(tile, 0, 54, 12, 8, 128, 64);
/*     */     }
/*  83 */     GL11.glPopMatrix();
/*  84 */     GL11.glPopMatrix();
/*     */     
/*  86 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_76894_a(TileEntity tileentity, double d, double d1, double d2, float f)
/*     */   {
/*  92 */     renderAModelAt((TileEntityFurnaceMF)tileentity, d, d1, d2, f);
/*     */   }
/*     */   
/*     */   private void renderDoor(TileEntityFurnaceMF tile, int x, int y, int w, int h, int tw, int th) {
/*  96 */     float f = 0.01F / tw;
/*  97 */     float f1 = 0.01F / th;
/*     */     
/*  99 */     float x1 = x / tw + f;
/* 100 */     float x2 = (x + w) / tw - f;
/* 101 */     float y1 = y / th + f1;
/* 102 */     float y2 = (y + h) / th - f1;
/*     */     
/* 104 */     Tessellator image = Tessellator.field_78398_a;
/* 105 */     float xPos = 0.5F;
/* 106 */     float yPos = 0.0F;
/* 107 */     GL11.glEnable(32826);
/* 108 */     GL11.glTranslatef(-xPos, -yPos, pixel(0.5F));
/* 109 */     float var13 = 1.0F;
/* 110 */     GL11.glScalef(var13, var13, var13);
/* 111 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 112 */     GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
/* 113 */     ItemRenderer.func_78439_a(image, x2, y1, x1, y2, tw, th, 0.0625F);
/*     */   }
/*     */   
/*     */   private void renderDoorHeater(TileEntityFurnaceMF tile, int x, int y, int w, int h, int tw, int th)
/*     */   {
/* 118 */     float f = 0.01F / tw;
/* 119 */     float f1 = 0.01F / th;
/*     */     
/* 121 */     float x1 = x / tw + f;
/* 122 */     float x2 = (x + w) / tw - f;
/* 123 */     float y1 = y / th + f1;
/* 124 */     float y2 = (y + h) / th - f1;
/*     */     
/* 126 */     Tessellator image = Tessellator.field_78398_a;
/* 127 */     float xPos = 0.5F;
/* 128 */     float yPos = 1.0F;
/* 129 */     GL11.glEnable(32826);
/* 130 */     GL11.glTranslatef(-xPos, -yPos, pixel(0.5F));
/* 131 */     float var13 = 1.0F;
/* 132 */     GL11.glScalef(var13, var13, var13);
/* 133 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 134 */     GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
/* 135 */     ItemRenderer.func_78439_a(image, x2, y1, x1, y2, tw, th, 0.0625F);
/*     */   }
/*     */   
/*     */   public float pixel(float count)
/*     */   {
/* 140 */     return count * 0.0625F;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/render/TileEntityFurnaceRendererMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */