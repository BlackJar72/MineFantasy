/*     */ package minefantasy.client.tile.render;
/*     */ 
/*     */ import java.util.Random;
/*     */ import minefantasy.client.MFTextureHelper;
/*     */ import minefantasy.client.tile.TileEntitySpinningWheel;
/*     */ import minefantasy.client.tile.model.ModelSpinningWheel;
/*     */ import minefantasy.system.MFResource;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.ItemRenderer;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemBlock;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.Icon;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ public class TileEntitySpinningWheelRenderer
/*     */   extends TileEntitySpecialRenderer
/*     */ {
/*     */   private ModelSpinningWheel model;
/*  28 */   private Random random = new Random();
/*     */   
/*     */   public TileEntitySpinningWheelRenderer() {
/*  31 */     this.model = new ModelSpinningWheel();
/*     */   }
/*     */   
/*     */   public void renderAModelAt(TileEntitySpinningWheel tile, double d, double d1, double d2, float f) {
/*  35 */     int tiledirection = 1;int tileangle = 90 * tiledirection;
/*     */     
/*  37 */     if (tile.field_70331_k != null) {
/*  38 */       tiledirection = tile.direction;
/*     */     }
/*     */     
/*  41 */     switch (tiledirection) {
/*     */     case 0: 
/*  43 */       tileangle = 0;
/*  44 */       break;
/*     */     
/*     */     case 1: 
/*  47 */       tileangle = 270;
/*  48 */       break;
/*     */     
/*     */     case 2: 
/*  51 */       tileangle = 180;
/*  52 */       break;
/*     */     
/*     */     case 3: 
/*     */     case 4: 
/*  56 */       tileangle = 90;
/*     */     }
/*     */     
/*     */     
/*     */ 
/*  61 */     GL11.glPushMatrix();
/*  62 */     Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.getResource(MFResource.image("/item/SpinningWheel.png")));
/*  63 */     float yOffset = 1.25F;
/*  64 */     GL11.glTranslatef((float)d + 0.5F, (float)d1 + yOffset, (float)d2 + 0.5F);
/*  65 */     GL11.glRotatef(tileangle + 180, 0.0F, 1.0F, 0.0F);
/*     */     
/*  67 */     GL11.glScalef(1.0F, -1.0F, -1.0F);
/*     */     
/*  69 */     GL11.glPushMatrix();
/*  70 */     GL11.glTranslatef(0.0F, -0.0125F, 0.0F);
/*  71 */     this.model.renderModel(0.0625F);
/*     */     
/*  73 */     GL11.glPopMatrix();
/*  74 */     GL11.glPushMatrix();
/*  75 */     GL11.glScalef(0.75F, 0.75F, 0.75F);
/*  76 */     renderItems(tile);
/*  77 */     GL11.glPopMatrix();
/*     */     
/*  79 */     GL11.glPushMatrix();
/*  80 */     Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.getResource(MFResource.image("/item/SpinningWheel.png")));
/*  81 */     GL11.glTranslatef(0.0F, pixel(5.5F), pixel(0.0F));
/*  82 */     GL11.glPushMatrix();
/*  83 */     GL11.glScalef(0.75F, 0.75F, 0.75F);
/*  84 */     GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
/*  85 */     GL11.glRotatef(tile.getArmValue() * 360.0F, 0.0F, 0.0F, 1.0F);
/*  86 */     renderWheel(tile, 52, 22, 10, 10, 64, 32);
/*  87 */     GL11.glPopMatrix();
/*  88 */     GL11.glPopMatrix();
/*     */     
/*  90 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void renderItems(TileEntitySpinningWheel tile)
/*     */   {
/*  95 */     double xStart = -0.5D;
/*  96 */     double yStart = -0.5D;
/*  97 */     double height = 0.5D;
/*     */     
/*  99 */     GL11.glPushMatrix();
/* 100 */     GL11.glTranslated(xStart + 0.5D, height + 0.25D, yStart + 0.05000000074505806D);
/* 101 */     renderItem(tile.func_70301_a(0), false);
/* 102 */     GL11.glPopMatrix();
/*     */     
/* 104 */     float offset = 0.03125F;
/*     */     
/* 106 */     GL11.glPushMatrix();
/* 107 */     GL11.glTranslated(xStart + 0.20000000298023224D + offset, height - 0.10000000149011612D, yStart + 1.149999976158142D);
/* 108 */     GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
/* 109 */     renderItem(tile.func_70301_a(1), true);
/* 110 */     GL11.glPopMatrix();
/*     */     
/* 112 */     GL11.glPushMatrix();
/* 113 */     GL11.glTranslated(xStart + 0.800000011920929D + offset, height - 0.10000000149011612D, yStart + 1.149999976158142D);
/* 114 */     GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
/* 115 */     renderItem(tile.func_70301_a(2), true);
/* 116 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public void func_76894_a(TileEntity tileentity, double d, double d1, double d2, float f)
/*     */   {
/* 121 */     renderAModelAt((TileEntitySpinningWheel)tileentity, d, d1, d2, f);
/*     */   }
/*     */   
/*     */   private void renderItem(ItemStack itemstack, boolean rotate) {
/* 125 */     float scale = 2.0F;
/* 126 */     float offset = -0.009375F * scale;
/* 127 */     GL11.glPushMatrix();
/* 128 */     GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
/* 129 */     GL11.glScalef(0.3F * scale, 0.3F * scale, 0.3F * scale);
/* 130 */     GL11.glTranslatef(offset, 0.0F, offset);
/* 131 */     if ((itemstack != null) && (itemstack.func_77973_b() != null)) {
/* 132 */       if ((itemstack.func_77973_b() instanceof ItemBlock)) {
/* 133 */         GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
/* 134 */         GL11.glTranslatef(0.0F, -0.2F, -0.3F);
/* 135 */         rotate = false;
/*     */       }
/* 137 */       for (int k = 0; k < itemstack.func_77973_b().getRenderPasses(itemstack.func_77960_j()); k++) {
/* 138 */         GL11.glPushMatrix();
/* 139 */         Icon index = itemstack.func_77973_b().getIcon(itemstack, k);
/* 140 */         int colour = Item.field_77698_e[itemstack.field_77993_c].func_82790_a(itemstack, k);
/* 141 */         float red = (colour >> 16 & 0xFF) / 255.0F;
/* 142 */         float green = (colour >> 8 & 0xFF) / 255.0F;
/* 143 */         float blue = (colour & 0xFF) / 255.0F;
/* 144 */         float shade = 1.0F;
/* 145 */         GL11.glColor4f(red * shade, green * shade, blue * shade, 1.0F);
/*     */         
/* 147 */         Block block = null;
/* 148 */         if (itemstack.field_77993_c < Block.field_71973_m.length) {
/* 149 */           block = Block.field_71973_m[itemstack.field_77993_c];
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 157 */         if ((itemstack.func_94608_d() == 0) && (block != null)) {
/* 158 */           GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
/* 159 */           GL11.glTranslatef(0.0F, 0.15625F, 0.0F);
/* 160 */           Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110575_b);
/* 161 */           float f7 = 0.5F;
/*     */           
/* 163 */           GL11.glScalef(f7, f7, f7);
/*     */           
/* 165 */           byte b0 = 1;
/* 166 */           for (int i = 0; i < b0; i++) {
/* 167 */             GL11.glPushMatrix();
/*     */             
/* 169 */             if (i > 0) {
/* 170 */               float f5 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
/* 171 */               float f4 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
/* 172 */               float f6 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
/* 173 */               GL11.glTranslatef(f5, f4, f6);
/*     */             }
/*     */             
/* 176 */             float f5 = 1.0F;
/* 177 */             new RenderBlocks().func_78600_a(block, itemstack.func_77960_j(), f5);
/* 178 */             GL11.glPopMatrix();
/*     */           }
/*     */         } else {
/* 181 */           Item item = itemstack.func_77973_b();
/* 182 */           Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110576_c);
/*     */           
/* 184 */           Tessellator image = Tessellator.field_78398_a;
/* 185 */           float x1 = index.func_94209_e();
/* 186 */           float x2 = index.func_94212_f();
/* 187 */           float y1 = index.func_94206_g();
/* 188 */           float y2 = index.func_94210_h();
/* 189 */           float xPos = 0.5F;
/* 190 */           float yPos = 0.5F;
/* 191 */           GL11.glEnable(32826);
/* 192 */           GL11.glTranslatef(-xPos, -yPos, 0.0F);
/* 193 */           float var13 = 1.0F;
/* 194 */           GL11.glScalef(var13, var13, var13);
/* 195 */           float r = 180.0F;
/* 196 */           if (rotate) {
/* 197 */             r += 45.0F;
/*     */           }
/* 199 */           GL11.glRotatef(r, 0.0F, 0.0F, 1.0F);
/* 200 */           GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
/* 201 */           ItemRenderer.func_78439_a(image, x2, y1, x1, y2, index.func_94211_a(), index.func_94216_b(), 0.0625F);
/*     */           
/* 203 */           GL11.glPushMatrix();
/* 204 */           if ((itemstack != null) && (itemstack.func_77948_v())) {
/* 205 */             GL11.glDepthFunc(514);
/* 206 */             GL11.glDisable(2896);
/* 207 */             Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.ITEM_GLINT);
/* 208 */             GL11.glEnable(3042);
/* 209 */             GL11.glBlendFunc(768, 1);
/* 210 */             float f13 = 0.76F;
/* 211 */             GL11.glColor4f(0.5F * f13, 0.25F * f13, 0.8F * f13, 1.0F);
/* 212 */             GL11.glMatrixMode(5890);
/* 213 */             GL11.glPushMatrix();
/* 214 */             float f14 = 0.125F;
/* 215 */             GL11.glScalef(f14, f14, f14);
/* 216 */             float f15 = (float)(Minecraft.func_71386_F() % 3000L) / 3000.0F * 8.0F;
/* 217 */             GL11.glTranslatef(f15, 0.0F, 0.0F);
/* 218 */             GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
/* 219 */             ItemRenderer.func_78439_a(image, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, 0.0625F);
/* 220 */             GL11.glPopMatrix();
/* 221 */             GL11.glPushMatrix();
/* 222 */             GL11.glScalef(f14, f14, f14);
/* 223 */             f15 = (float)(Minecraft.func_71386_F() % 4873L) / 4873.0F * 8.0F;
/* 224 */             GL11.glTranslatef(-f15, 0.0F, 0.0F);
/* 225 */             GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
/* 226 */             ItemRenderer.func_78439_a(image, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, 0.0625F);
/* 227 */             GL11.glPopMatrix();
/* 228 */             GL11.glMatrixMode(5888);
/* 229 */             GL11.glDisable(3042);
/* 230 */             GL11.glEnable(2896);
/* 231 */             GL11.glDepthFunc(515);
/*     */           }
/* 233 */           GL11.glPopMatrix();
/*     */         }
/* 235 */         GL11.glPopMatrix();
/*     */       }
/*     */     }
/* 238 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void renderBigItem(boolean move, ItemStack itemstack, double d, double d1, double d2) {
/* 242 */     GL11.glPushMatrix();
/* 243 */     GL11.glScalef(0.75F, 0.75F, 0.75F);
/* 244 */     if (move) {
/* 245 */       GL11.glTranslatef(0.0F, 1.25F, 0.0F);
/*     */     } else {
/* 247 */       GL11.glTranslatef(0.0F, 0.15F, 0.0F);
/*     */     }
/*     */     
/* 250 */     if ((itemstack != null) && (itemstack.func_77973_b() != null)) {
/* 251 */       if (!(itemstack.func_77973_b() instanceof ItemBlock)) {
/* 252 */         GL11.glTranslatef(0.0F, 0.3F, 0.0F);
/* 253 */         GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
/*     */       }
/* 255 */       for (int k = 0; k < itemstack.func_77973_b().getRenderPasses(itemstack.func_77960_j()); k++) {
/* 256 */         GL11.glPushMatrix();
/* 257 */         Icon index = itemstack.func_77973_b().getIcon(itemstack, k);
/* 258 */         int colour = Item.field_77698_e[itemstack.field_77993_c].func_82790_a(itemstack, k);
/* 259 */         float red = (colour >> 16 & 0xFF) / 255.0F;
/* 260 */         float green = (colour >> 8 & 0xFF) / 255.0F;
/* 261 */         float blue = (colour & 0xFF) / 255.0F;
/* 262 */         float shade = 1.0F;
/* 263 */         GL11.glColor4f(red * shade, green * shade, blue * shade, 1.0F);
/*     */         
/* 265 */         Block block = null;
/* 266 */         if (itemstack.field_77993_c < Block.field_71973_m.length) {
/* 267 */           block = Block.field_71973_m[itemstack.field_77993_c];
/*     */         }
/*     */         
/* 270 */         if ((itemstack.func_94608_d() == 0) && (block != null)) {
/* 271 */           float f7 = 0.5F;
/* 272 */           GL11.glTranslatef(0.0F, 0.15625F, 0.0F);
/* 273 */           Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110575_b);
/*     */           
/* 275 */           GL11.glScalef(f7, f7, f7);
/*     */           
/* 277 */           byte b0 = 1;
/* 278 */           for (int i = 0; i < b0; i++) {
/* 279 */             GL11.glPushMatrix();
/*     */             
/* 281 */             if (i > 0) {
/* 282 */               float f5 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
/* 283 */               float f4 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
/* 284 */               float f6 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
/* 285 */               GL11.glTranslatef(f5, f4, f6);
/*     */             }
/*     */             
/* 288 */             float f5 = 1.0F;
/* 289 */             new RenderBlocks().func_78600_a(block, itemstack.func_77960_j(), f5);
/* 290 */             GL11.glPopMatrix();
/*     */           }
/*     */         } else {
/* 293 */           Item item = itemstack.func_77973_b();
/* 294 */           Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110576_c);
/*     */           
/* 296 */           Tessellator image = Tessellator.field_78398_a;
/* 297 */           float x1 = index.func_94209_e();
/* 298 */           float x2 = index.func_94212_f();
/* 299 */           float y1 = index.func_94206_g();
/* 300 */           float y2 = index.func_94210_h();
/* 301 */           float xPos = 0.5F;
/* 302 */           float yPos = 0.5F;
/* 303 */           GL11.glEnable(32826);
/* 304 */           GL11.glTranslatef(-xPos, -yPos, 0.0F);
/* 305 */           float var13 = 1.0F;
/* 306 */           GL11.glScalef(var13, var13, var13);
/*     */           
/* 308 */           GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 309 */           GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
/* 310 */           ItemRenderer.func_78439_a(image, x2, y1, x1, y2, index.func_94211_a(), index.func_94216_b(), 0.0625F);
/*     */           
/* 312 */           GL11.glPushMatrix();
/* 313 */           if ((itemstack != null) && (itemstack.func_77948_v())) {
/* 314 */             GL11.glDepthFunc(514);
/* 315 */             GL11.glDisable(2896);
/* 316 */             Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.ITEM_GLINT);
/* 317 */             GL11.glEnable(3042);
/* 318 */             GL11.glBlendFunc(768, 1);
/* 319 */             float f13 = 0.76F;
/* 320 */             GL11.glColor4f(0.5F * f13, 0.25F * f13, 0.8F * f13, 1.0F);
/* 321 */             GL11.glMatrixMode(5890);
/* 322 */             GL11.glPushMatrix();
/* 323 */             float f14 = 0.125F;
/* 324 */             GL11.glScalef(f14, f14, f14);
/* 325 */             float f15 = (float)(Minecraft.func_71386_F() % 3000L) / 3000.0F * 8.0F;
/* 326 */             GL11.glTranslatef(f15, 0.0F, 0.0F);
/* 327 */             GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
/* 328 */             ItemRenderer.func_78439_a(image, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, 0.0625F);
/* 329 */             GL11.glPopMatrix();
/* 330 */             GL11.glPushMatrix();
/* 331 */             GL11.glScalef(f14, f14, f14);
/* 332 */             f15 = (float)(Minecraft.func_71386_F() % 4873L) / 4873.0F * 8.0F;
/* 333 */             GL11.glTranslatef(-f15, 0.0F, 0.0F);
/* 334 */             GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
/* 335 */             ItemRenderer.func_78439_a(image, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, 0.0625F);
/* 336 */             GL11.glPopMatrix();
/* 337 */             GL11.glMatrixMode(5888);
/* 338 */             GL11.glDisable(3042);
/* 339 */             GL11.glEnable(2896);
/* 340 */             GL11.glDepthFunc(515);
/*     */           }
/* 342 */           GL11.glPopMatrix();
/*     */         }
/* 344 */         GL11.glPopMatrix();
/*     */       }
/*     */     }
/* 347 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void renderWheel(TileEntitySpinningWheel tile, int x, int y, int w, int h, int tw, int th) {
/* 351 */     float f = 0.01F / tw;
/* 352 */     float f1 = 0.01F / th;
/*     */     
/* 354 */     float x1 = x / tw + f;
/* 355 */     float x2 = (x + w) / tw - f;
/* 356 */     float y1 = y / th + f1;
/* 357 */     float y2 = (y + h) / th - f1;
/*     */     
/* 359 */     Tessellator image = Tessellator.field_78398_a;
/* 360 */     float xPos = 0.5F;
/* 361 */     float yPos = 0.5F;
/* 362 */     GL11.glEnable(32826);
/* 363 */     GL11.glTranslatef(-xPos, -yPos, pixel(0.5F));
/* 364 */     float var13 = 1.0F;
/* 365 */     GL11.glScalef(var13, var13, var13);
/* 366 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 367 */     GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
/* 368 */     ItemRenderer.func_78439_a(image, x2, y1, x1, y2, tw, th, 0.0625F);
/*     */   }
/*     */   
/*     */   public float pixel(float count)
/*     */   {
/* 373 */     return count * 0.0625F;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/render/TileEntitySpinningWheelRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */