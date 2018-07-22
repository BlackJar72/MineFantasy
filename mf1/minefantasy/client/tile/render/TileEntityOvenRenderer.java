/*     */ package minefantasy.client.tile.render;
/*     */ 
/*     */ import java.util.Random;
/*     */ import minefantasy.client.MFTextureHelper;
/*     */ import minefantasy.client.tile.TileEntityOven;
/*     */ import minefantasy.client.tile.model.ModelOven;
/*     */ import minefantasy.system.MFResource;
/*     */ import minefantasy.system.cfg;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*     */ import net.minecraft.client.renderer.ItemRenderer;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.Icon;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TileEntityOvenRenderer
/*     */   extends TileEntitySpecialRenderer
/*     */ {
/*     */   private ModelOven model;
/*  30 */   private Random random = new Random();
/*     */   
/*     */   public TileEntityOvenRenderer() {
/*  33 */     this.model = new ModelOven();
/*     */   }
/*     */   
/*     */   public void renderAModelAt(TileEntityOven tile, double d, double d1, double d2, float f)
/*     */   {
/*  38 */     int tiledirection = 1;int tileangle = 90 * tiledirection;
/*     */     
/*  40 */     if (tile.field_70331_k != null) {
/*  41 */       tiledirection = tile.direction;
/*     */     }
/*     */     
/*  44 */     switch (tiledirection) {
/*     */     case 0: 
/*  46 */       tileangle = 0;
/*  47 */       break;
/*     */     
/*     */     case 1: 
/*  50 */       tileangle = 270;
/*  51 */       break;
/*     */     
/*     */     case 2: 
/*  54 */       tileangle = 180;
/*  55 */       break;
/*     */     
/*     */     case 3: 
/*     */     case 4: 
/*  59 */       tileangle = 90;
/*     */     }
/*     */     
/*     */     
/*     */ 
/*  64 */     String type = tile.getTexture();
/*     */     
/*  66 */     Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.getResource(MFResource.image("/item/" + type + ".png")));
/*     */     
/*  68 */     boolean display = tile.isBurningClient;
/*     */     
/*  70 */     GL11.glPushMatrix();
/*  71 */     float scale = 1.0F;
/*     */     
/*  73 */     float offset = 0.9375F;
/*  74 */     GL11.glTranslatef((float)d + 0.5F, (float)d1 + 0.25F, (float)d2 + 0.5F);
/*  75 */     GL11.glRotatef(tileangle + 180.0F, 0.0F, 1.0F, 0.0F);
/*     */     
/*  77 */     GL11.glScalef(scale, -scale, -scale);
/*  78 */     this.model.renderModel(display, 0.0625F);
/*     */     
/*  80 */     float sc = 0.625F;
/*  81 */     float openPixels = 0.6666667F * tile.doorAngle;
/*  82 */     float angle = 6.0F * tile.doorAngle;
/*     */     
/*  84 */     GL11.glPushMatrix();
/*     */     
/*  86 */     GL11.glTranslatef(pixel(0.0F), pixel(2.0F), -pixel(6.0F));
/*  87 */     GL11.glPushMatrix();
/*  88 */     GL11.glScalef(sc, sc, sc);
/*     */     
/*  90 */     GL11.glRotatef(angle, 1.0F, 0.0F, 0.0F);
/*  91 */     renderHatch(tile, 0, 0, 12, 8, 128, 64);
/*     */     
/*  93 */     GL11.glPopMatrix();
/*     */     
/*  95 */     GL11.glTranslatef(pixel(0.0F), -pixel(4.5F), -pixel(openPixels));
/*  96 */     GL11.glPushMatrix();
/*  97 */     GL11.glScalef(sc, sc, sc);
/*     */     
/*  99 */     GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
/* 100 */     renderRack(tile, 0, 37, 9, 9, 128, 64);
/*     */     
/* 102 */     GL11.glPopMatrix();
/* 103 */     GL11.glPopMatrix();
/*     */     
/* 105 */     GL11.glTranslatef(0.0F, -pixel(3.5F), -pixel(openPixels));
/* 106 */     GL11.glPushMatrix();
/* 107 */     GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
/*     */     try
/*     */     {
/* 110 */       renderItem(tile, d, d1, d2, f);
/*     */     } catch (Exception Ex) {
/* 112 */       if (cfg.renderWarnings) {
/* 113 */         Minecraft.func_71410_x().field_71439_g.func_71035_c("Don't put that in the oven.");
/*     */       }
/*     */     }
/*     */     
/* 117 */     GL11.glPopMatrix();
/* 118 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_76894_a(TileEntity tileentity, double d, double d1, double d2, float f)
/*     */   {
/* 124 */     renderAModelAt((TileEntityOven)tileentity, d, d1, d2, f);
/*     */   }
/*     */   
/*     */   private void renderRack(TileEntityOven tile, int x, int y, int w, int h, int tw, int th) {
/* 128 */     float f = 0.01F / tw;
/* 129 */     float f1 = 0.01F / th;
/*     */     
/* 131 */     float x1 = x / tw + f;
/* 132 */     float x2 = (x + w) / tw - f;
/* 133 */     float y1 = y / th + f1;
/* 134 */     float y2 = (y + h) / th - f1;
/*     */     
/* 136 */     Tessellator image = Tessellator.field_78398_a;
/* 137 */     float xPos = 0.5F;
/* 138 */     float yPos = 0.0F;
/* 139 */     GL11.glEnable(32826);
/* 140 */     GL11.glTranslatef(-xPos, -yPos, pixel(0.5F));
/* 141 */     float var13 = 1.0F;
/* 142 */     GL11.glScalef(var13, var13, var13);
/* 143 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 144 */     GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
/* 145 */     ItemRenderer.func_78439_a(image, x2, y1, x1, y2, tw, th, 0.0625F);
/*     */   }
/*     */   
/*     */   private void renderHatch(TileEntityOven tile, int x, int y, int w, int h, int tw, int th) {
/* 149 */     float f = 0.01F / tw;
/* 150 */     float f1 = 0.01F / th;
/*     */     
/* 152 */     float x1 = x / tw + f;
/* 153 */     float x2 = (x + w) / tw - f;
/* 154 */     float y1 = y / th + f1;
/* 155 */     float y2 = (y + h) / th - f1;
/*     */     
/* 157 */     Tessellator image = Tessellator.field_78398_a;
/* 158 */     float xPos = 0.5F;
/* 159 */     float yPos = 1.0F;
/* 160 */     GL11.glEnable(32826);
/* 161 */     GL11.glTranslatef(-xPos, -yPos, pixel(0.5F));
/* 162 */     float var13 = 1.0F;
/* 163 */     GL11.glScalef(var13, var13, var13);
/* 164 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 165 */     GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
/* 166 */     ItemRenderer.func_78439_a(image, x2, y1, x1, y2, tw, th, 0.0625F);
/*     */   }
/*     */   
/*     */   public float pixel(float count) {
/* 170 */     return count * 0.0625F;
/*     */   }
/*     */   
/*     */   private void renderItem(TileEntityOven tile, double d, double d1, double d2, float f) {
/* 174 */     ItemStack itemstack = tile.func_70301_a(2);
/* 175 */     if (itemstack == null) {
/* 176 */       itemstack = tile.func_70301_a(0);
/*     */     }
/* 178 */     if ((itemstack != null) && (itemstack.func_77973_b() != null))
/*     */     {
/* 180 */       Block block = null;
/* 181 */       if (itemstack.field_77993_c < Block.field_71973_m.length) {
/* 182 */         block = Block.field_71973_m[itemstack.field_77993_c];
/*     */       }
/*     */       
/* 185 */       if ((itemstack.func_94608_d() == 0) && (block != null))
/*     */       {
/* 187 */         if (block.func_71857_b() == cfg.renderId) {
/* 188 */           GL11.glTranslatef(-0.25F, 0.25F, -0.25F);
/*     */         }
/* 190 */         GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
/* 191 */         GL11.glTranslatef(0.0F, 0.15625F, 0.0F);
/* 192 */         Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110575_b);
/* 193 */         float f7 = 0.5F;
/*     */         
/* 195 */         GL11.glScalef(f7, f7, f7);
/*     */         
/* 197 */         byte b0 = 1;
/* 198 */         for (int i = 0; i < b0; i++) {
/* 199 */           GL11.glPushMatrix();
/*     */           
/* 201 */           if (i > 0) {
/* 202 */             float f5 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
/* 203 */             float f4 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
/* 204 */             float f6 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
/* 205 */             GL11.glTranslatef(f5, f4, f6);
/*     */           }
/*     */           
/* 208 */           float f5 = 1.0F;
/* 209 */           new RenderBlocks().func_78600_a(block, itemstack.func_77960_j(), f5);
/* 210 */           GL11.glPopMatrix();
/*     */         }
/*     */       } else {
/* 213 */         Item item = itemstack.func_77973_b();
/* 214 */         Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110576_c);
/*     */         
/* 216 */         Tessellator image = Tessellator.field_78398_a;
/* 217 */         Icon index = item.func_77617_a(itemstack.func_77960_j());
/* 218 */         float x1 = index.func_94209_e();
/* 219 */         float x2 = index.func_94212_f();
/* 220 */         float y1 = index.func_94206_g();
/* 221 */         float y2 = index.func_94210_h();
/* 222 */         float xPos = 0.5F;
/* 223 */         float yPos = 0.5F;
/* 224 */         GL11.glEnable(32826);
/* 225 */         GL11.glTranslatef(-xPos, -yPos, 0.0F);
/* 226 */         float var13 = 1.0F;
/* 227 */         GL11.glScalef(var13, var13, var13);
/* 228 */         GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 229 */         GL11.glTranslatef(-0.75F, -0.75F, 0.0F);
/* 230 */         GL11.glScalef(0.5F, 0.5F, 0.5F);
/* 231 */         ItemRenderer.func_78439_a(image, x2, y1, x1, y2, index.func_94211_a(), index.func_94216_b(), 0.0625F);
/* 232 */         GL11.glPushMatrix();
/* 233 */         GL11.glPopMatrix();
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/render/TileEntityOvenRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */