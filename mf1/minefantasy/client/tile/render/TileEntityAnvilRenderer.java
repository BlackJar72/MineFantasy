/*     */ package minefantasy.client.tile.render;
/*     */ 
/*     */ import java.util.Random;
/*     */ import minefantasy.api.anvil.ITongs;
/*     */ import minefantasy.client.MFTextureHelper;
/*     */ import minefantasy.client.tile.TileEntityAnvil;
/*     */ import minefantasy.client.tile.model.ModelAnvil;
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
/*     */ import net.minecraft.item.ItemBlock;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.Icon;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TileEntityAnvilRenderer
/*     */   extends TileEntitySpecialRenderer
/*     */ {
/*     */   private int metadata;
/*     */   private ModelAnvil model;
/*  35 */   private Random random = new Random();
/*     */   
/*     */   public TileEntityAnvilRenderer() {
/*  38 */     this.model = new ModelAnvil();
/*     */   }
/*     */   
/*     */   public void renderAModelAt(TileEntityAnvil tile, double d, double d1, double d2, float f) {
/*  42 */     if (tile.fromItemRenderer) {
/*  43 */       renderAModelAt(tile, d, d1, d2, f, 0);
/*     */     } else {
/*  45 */       for (int a = 0; a < 2; a++) {
/*  46 */         if (shouldRender(tile, a)) {
/*  47 */           renderAModelAt(tile, d, d1, d2, f, a);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void renderAModelAt(TileEntityAnvil tile, double d, double d1, double d2, float f, int renderPass)
/*     */   {
/*  55 */     int tiledirection = 1;int tileangle = 90 * tiledirection;
/*     */     
/*  57 */     if (tile.field_70331_k != null) {
/*  58 */       tiledirection = tile.direction;
/*     */     }
/*     */     
/*     */ 
/*  62 */     this.metadata = tile.func_70322_n();
/*     */     
/*  64 */     switch (tiledirection) {
/*     */     case 0: 
/*  66 */       tileangle = 0;
/*  67 */       break;
/*     */     
/*     */     case 1: 
/*  70 */       tileangle = 270;
/*  71 */       break;
/*     */     
/*     */     case 2: 
/*  74 */       tileangle = 180;
/*  75 */       break;
/*     */     
/*     */     case 3: 
/*     */     case 4: 
/*  79 */       tileangle = 90;
/*     */     }
/*     */     
/*     */     
/*     */ 
/*  84 */     if (renderPass == 1) {
/*  85 */       String texture = tile.isBig() ? "anvilGrid_big" : "anvilGrid_sml";
/*  86 */       Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.getResource(MFResource.image("/models/" + texture + ".png")));
/*     */     } else {
/*  88 */       Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.getResource(MFResource.image("/models/" + getTexture(this.metadata) + ".png")));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  96 */     GL11.glPushMatrix();
/*  97 */     float scale = 1.0F;
/*  98 */     float yOffset = 0.0F;
/*  99 */     if (!tile.isBig()) {
/* 100 */       scale = 0.75F;
/* 101 */       yOffset = 0.625F;
/*     */     }
/* 103 */     GL11.glTranslated(d + 0.5D, d1 + 0.3D * scale + yOffset, d2 + 0.5D);
/* 104 */     GL11.glRotatef(tileangle, 0.0F, 1.0F, 0.0F);
/* 105 */     GL11.glScalef(scale, -scale, -scale);
/*     */     
/* 107 */     GL11.glPushMatrix();
/* 108 */     if (!tile.isBig()) {
/* 109 */       GL11.glTranslatef(0.0F, 0.55F, 0.0F);
/*     */     }
/* 111 */     this.model.renderModel(tile.isBig(), 0.0625F);
/* 112 */     if ((renderPass == 0) && (!tile.fromItemRenderer)) {
/* 113 */       renderItems(tile);
/*     */     }
/*     */     
/* 116 */     GL11.glPopMatrix();
/*     */     
/* 118 */     if ((renderPass == 0) && (!tile.isBig())) {
/* 119 */       GL11.glPushMatrix();
/* 120 */       GL11.glColor3f(255.0F, 255.0F, 255.0F);
/*     */       
/* 122 */       float scale2 = 1.0F;
/* 123 */       GL11.glScalef(scale2, scale2 * 0.55F, scale2);
/* 124 */       GL11.glTranslatef(0.0F, 1.0625F, 0.0F);
/* 125 */       Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.getResource(MFResource.image("/item/anvilBase.png")));
/* 126 */       this.model.renderLog(0.0625F);
/* 127 */       GL11.glPopMatrix();
/*     */     }
/*     */     
/* 130 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private String getTexture(int meta) {
/* 134 */     switch (meta) {
/*     */     case 0: 
/* 136 */       return "anvil_stone";
/*     */     
/*     */     case 1: 
/*     */     case 2: 
/* 140 */       return "anvil_bronze";
/*     */     
/*     */     case 3: 
/*     */     case 4: 
/* 144 */       return "anvil_iron";
/*     */     
/*     */     case 5: 
/*     */     case 6: 
/* 148 */       return "anvil_steel";
/*     */     
/*     */     case 7: 
/*     */     case 8: 
/* 152 */       return "anvil_deep";
/*     */     }
/*     */     
/* 155 */     return "anvil_iron";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_76894_a(TileEntity tileentity, double x, double y, double z, float scale)
/*     */   {
/* 162 */     renderAModelAt((TileEntityAnvil)tileentity, x, y, z, scale);
/*     */   }
/*     */   
/*     */   private void renderItems(TileEntityAnvil tile) {
/* 166 */     GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
/* 167 */     int mX = tile.gridSize()[0];
/* 168 */     int mY = tile.gridSize()[1];
/* 169 */     double xStart = (tile.isBig() ? -4.5F : -4.0F) * 0.0625D;
/* 170 */     double yStart = 0.15625D;
/* 171 */     float scaleBase = 0.5F;
/*     */     
/* 173 */     double xGap = 0.3125D * scaleBase * 4.0D / mX;
/* 174 */     double yGap = -(0.1875D * scaleBase) * 4.0D / mY;
/* 175 */     double yPos = -0.5D;
/* 176 */     float scale = scaleBase * 4.0F / Math.max(mX, mY);
/* 177 */     for (int x = 0; x < mX; x++) {
/* 178 */       for (int y = 0; y < mY; y++) {
/* 179 */         GL11.glPushMatrix();
/* 180 */         GL11.glTranslated(xStart + xGap * x, yPos, yStart + yGap * y);
/*     */         try
/*     */         {
/* 183 */           renderItem(tile.func_70301_a(y * mX + x), scale);
/*     */         } catch (Exception Ex) {
/* 185 */           if (cfg.renderWarnings) {
/* 186 */             Minecraft.func_71410_x().field_71439_g.func_71035_c("Don't put that on the anvil");
/*     */           }
/*     */         }
/*     */         
/* 190 */         GL11.glPopMatrix();
/*     */       }
/*     */     }
/* 193 */     if (tile.func_70301_a(tile.getGridSize()) != null) {
/* 194 */       boolean move = (tile.canCraft()) && (tile.canFitResult());
/* 195 */       renderBigItem(tile, move, tile.func_70301_a(tile.getGridSize()), 0.0D, 1.0D, 0.0D);
/*     */     }
/*     */   }
/*     */   
/*     */   private void renderItem(ItemStack itemstack, float scale) {
/* 200 */     GL11.glPushMatrix();
/* 201 */     GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
/* 202 */     GL11.glScalef(0.3F * scale, 0.3F * scale, 0.3F * scale);
/* 203 */     if ((itemstack != null) && (itemstack.func_77973_b() != null)) {
/* 204 */       if ((itemstack.func_77973_b() instanceof ItemBlock)) {
/* 205 */         GL11.glTranslatef(0.0F, -0.1F, 0.0F);
/* 206 */         GL11.glRotatef(-180.0F, 1.0F, 0.0F, 0.0F);
/*     */         try
/*     */         {
/* 209 */           Block bl = Block.field_71973_m[itemstack.field_77993_c];
/* 210 */           if ((bl != null) && (bl.func_71857_b() == cfg.renderId)) {
/* 211 */             GL11.glTranslatef(-0.25F, -0.0F, -0.25F);
/*     */           }
/*     */         }
/*     */         catch (Exception localException) {}
/*     */       }
/* 216 */       for (int k = 0; k < itemstack.func_77973_b().getRenderPasses(itemstack.func_77960_j()); k++) {
/* 217 */         GL11.glPushMatrix();
/* 218 */         Icon index = itemstack.func_77973_b().getIcon(itemstack, k);
/* 219 */         int colour = Item.field_77698_e[itemstack.field_77993_c].func_82790_a(itemstack, k);
/* 220 */         float red = (colour >> 16 & 0xFF) / 255.0F;
/* 221 */         float green = (colour >> 8 & 0xFF) / 255.0F;
/* 222 */         float blue = (colour & 0xFF) / 255.0F;
/* 223 */         float shade = 1.0F;
/* 224 */         GL11.glColor4f(red * shade, green * shade, blue * shade, 1.0F);
/*     */         
/* 226 */         Block block = null;
/* 227 */         if (itemstack.field_77993_c < Block.field_71973_m.length) {
/* 228 */           block = Block.field_71973_m[itemstack.field_77993_c];
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 233 */         if ((itemstack.func_94608_d() == 0) && (block != null)) {
/* 234 */           GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
/* 235 */           GL11.glTranslatef(0.0F, 0.15625F, 0.0F);
/* 236 */           Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110575_b);
/* 237 */           float f7 = 0.5F;
/*     */           
/* 239 */           GL11.glScalef(f7, f7, f7);
/*     */           
/* 241 */           byte b0 = 1;
/* 242 */           for (int i = 0; i < b0; i++) {
/* 243 */             GL11.glPushMatrix();
/*     */             
/* 245 */             if (i > 0) {
/* 246 */               float f5 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
/* 247 */               float f4 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
/* 248 */               float f6 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
/* 249 */               GL11.glTranslatef(f5, f4, f6);
/*     */             }
/*     */             
/* 252 */             float f5 = 1.0F;
/* 253 */             new RenderBlocks().func_78600_a(block, itemstack.func_77960_j(), f5);
/* 254 */             GL11.glPopMatrix();
/*     */           }
/*     */         } else {
/* 257 */           Item item = itemstack.func_77973_b();
/* 258 */           Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110576_c);
/*     */           
/* 260 */           Tessellator image = Tessellator.field_78398_a;
/* 261 */           float x1 = index.func_94209_e();
/* 262 */           float x2 = index.func_94212_f();
/* 263 */           float y1 = index.func_94206_g();
/* 264 */           float y2 = index.func_94210_h();
/* 265 */           float xPos = 0.5F;
/* 266 */           float yPos = 0.5F;
/* 267 */           GL11.glEnable(32826);
/* 268 */           GL11.glTranslatef(-xPos, -yPos, 0.0F);
/* 269 */           float var13 = 1.0F;
/* 270 */           GL11.glScalef(var13, var13, var13);
/* 271 */           GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 272 */           GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
/* 273 */           ItemRenderer.func_78439_a(image, x2, y1, x1, y2, index.func_94211_a(), index.func_94216_b(), 0.0625F);
/*     */           
/* 275 */           GL11.glPushMatrix();
/* 276 */           if ((itemstack != null) && (itemstack.func_77948_v())) {
/* 277 */             GL11.glDepthFunc(514);
/* 278 */             GL11.glDisable(2896);
/* 279 */             Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.ITEM_GLINT);
/* 280 */             GL11.glEnable(3042);
/* 281 */             GL11.glBlendFunc(768, 1);
/* 282 */             float f13 = 0.76F;
/* 283 */             GL11.glColor4f(0.5F * f13, 0.25F * f13, 0.8F * f13, 1.0F);
/* 284 */             GL11.glMatrixMode(5890);
/* 285 */             GL11.glPushMatrix();
/* 286 */             float f14 = 0.125F;
/* 287 */             GL11.glScalef(f14, f14, f14);
/* 288 */             float f15 = (float)(Minecraft.func_71386_F() % 3000L) / 3000.0F * 8.0F;
/* 289 */             GL11.glTranslatef(f15, 0.0F, 0.0F);
/* 290 */             GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
/* 291 */             ItemRenderer.func_78439_a(image, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, 0.0625F);
/* 292 */             GL11.glPopMatrix();
/* 293 */             GL11.glPushMatrix();
/* 294 */             GL11.glScalef(f14, f14, f14);
/* 295 */             f15 = (float)(Minecraft.func_71386_F() % 4873L) / 4873.0F * 8.0F;
/* 296 */             GL11.glTranslatef(-f15, 0.0F, 0.0F);
/* 297 */             GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
/* 298 */             ItemRenderer.func_78439_a(image, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, 0.0625F);
/* 299 */             GL11.glPopMatrix();
/* 300 */             GL11.glMatrixMode(5888);
/* 301 */             GL11.glDisable(3042);
/* 302 */             GL11.glEnable(2896);
/* 303 */             GL11.glDepthFunc(515);
/*     */           }
/* 305 */           GL11.glPopMatrix();
/*     */         }
/* 307 */         GL11.glPopMatrix();
/*     */       }
/*     */     }
/* 310 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void renderBigItem(TileEntityAnvil tile, boolean move, ItemStack itemstack, double d, double d1, double d2) {
/* 314 */     GL11.glPushMatrix();
/* 315 */     GL11.glTranslatef(0.0F, -0.7F, 0.0F);
/* 316 */     GL11.glScalef(0.7F, 0.7F, 0.7F);
/* 317 */     if (move) {
/* 318 */       GL11.glTranslatef(0.0F, 0.5F, -0.7F);
/* 319 */       GL11.glRotatef(65.0F, 1.0F, 0.0F, 0.0F);
/*     */     }
/* 321 */     if ((itemstack != null) && (itemstack.func_77973_b() != null)) {
/* 322 */       if (tile.isItem3D(itemstack)) {
/* 323 */         GL11.glRotatef(tile.getItemRotate(itemstack), 0.0F, 1.0F, 0.0F);
/*     */       }
/* 325 */       if (!(itemstack.func_77973_b() instanceof ItemBlock)) {
/* 326 */         GL11.glTranslatef(0.0F, 0.3F, 0.0F);
/* 327 */         GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
/*     */       } else {
/* 329 */         GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/*     */         try {
/* 331 */           Block bl = Block.field_71973_m[itemstack.field_77993_c];
/* 332 */           if ((bl != null) && (bl.func_71857_b() == cfg.renderId)) {
/* 333 */             GL11.glTranslatef(-0.25F, -0.4F, -0.25F);
/*     */           }
/*     */         }
/*     */         catch (Exception localException) {}
/*     */       }
/* 338 */       for (int k = 0; k < itemstack.func_77973_b().getRenderPasses(itemstack.func_77960_j()); k++) {
/* 339 */         GL11.glPushMatrix();
/* 340 */         Icon index = itemstack.func_77973_b().getIcon(itemstack, k);
/* 341 */         int colour = Item.field_77698_e[itemstack.field_77993_c].func_82790_a(itemstack, k);
/* 342 */         float red = (colour >> 16 & 0xFF) / 255.0F;
/* 343 */         float green = (colour >> 8 & 0xFF) / 255.0F;
/* 344 */         float blue = (colour & 0xFF) / 255.0F;
/* 345 */         float shade = 1.0F;
/* 346 */         GL11.glColor4f(red * shade, green * shade, blue * shade, 1.0F);
/*     */         
/* 348 */         Block block = null;
/* 349 */         if (itemstack.field_77993_c < Block.field_71973_m.length) {
/* 350 */           block = Block.field_71973_m[itemstack.field_77993_c];
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 358 */         if ((itemstack.func_94608_d() == 0) && (block != null)) {
/* 359 */           GL11.glTranslatef(0.0F, 0.15625F, 0.0F);
/* 360 */           Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110575_b);
/* 361 */           float f7 = 0.5F;
/*     */           
/* 363 */           GL11.glScalef(f7, f7, f7);
/*     */           
/* 365 */           byte b0 = 1;
/* 366 */           for (int i = 0; i < b0; i++) {
/* 367 */             GL11.glPushMatrix();
/*     */             
/* 369 */             if (i > 0) {
/* 370 */               float f5 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
/* 371 */               float f4 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
/* 372 */               float f6 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
/* 373 */               GL11.glTranslatef(f5, f4, f6);
/*     */             }
/*     */             
/* 376 */             float f5 = 1.0F;
/* 377 */             new RenderBlocks().func_78600_a(block, itemstack.func_77960_j(), f5);
/* 378 */             GL11.glPopMatrix();
/*     */           }
/*     */         } else {
/* 381 */           Item item = itemstack.func_77973_b();
/* 382 */           Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110576_c);
/*     */           
/* 384 */           Tessellator image = Tessellator.field_78398_a;
/* 385 */           float x1 = index.func_94209_e();
/* 386 */           float x2 = index.func_94212_f();
/* 387 */           float y1 = index.func_94206_g();
/* 388 */           float y2 = index.func_94210_h();
/* 389 */           float xPos = 0.5F;
/* 390 */           float yPos = 0.5F;
/* 391 */           GL11.glEnable(32826);
/* 392 */           GL11.glTranslatef(-xPos, -yPos, 0.0F);
/* 393 */           float var13 = 1.0F;
/* 394 */           GL11.glScalef(var13, var13, var13);
/*     */           
/* 396 */           GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 397 */           GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
/* 398 */           ItemRenderer.func_78439_a(image, x2, y1, x1, y2, index.func_94211_a(), index.func_94216_b(), 0.0625F);
/*     */           
/* 400 */           GL11.glPushMatrix();
/* 401 */           if ((itemstack != null) && (itemstack.func_77948_v())) {
/* 402 */             GL11.glDepthFunc(514);
/* 403 */             GL11.glDisable(2896);
/* 404 */             Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.ITEM_GLINT);
/* 405 */             GL11.glEnable(3042);
/* 406 */             GL11.glBlendFunc(768, 1);
/* 407 */             float f13 = 0.76F;
/* 408 */             GL11.glColor4f(0.5F * f13, 0.25F * f13, 0.8F * f13, 1.0F);
/* 409 */             GL11.glMatrixMode(5890);
/* 410 */             GL11.glPushMatrix();
/* 411 */             float f14 = 0.125F;
/* 412 */             GL11.glScalef(f14, f14, f14);
/* 413 */             float f15 = (float)(Minecraft.func_71386_F() % 3000L) / 3000.0F * 8.0F;
/* 414 */             GL11.glTranslatef(f15, 0.0F, 0.0F);
/* 415 */             GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
/* 416 */             ItemRenderer.func_78439_a(image, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, 0.0625F);
/* 417 */             GL11.glPopMatrix();
/* 418 */             GL11.glPushMatrix();
/* 419 */             GL11.glScalef(f14, f14, f14);
/* 420 */             f15 = (float)(Minecraft.func_71386_F() % 4873L) / 4873.0F * 8.0F;
/* 421 */             GL11.glTranslatef(-f15, 0.0F, 0.0F);
/* 422 */             GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
/* 423 */             ItemRenderer.func_78439_a(image, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, 0.0625F);
/* 424 */             GL11.glPopMatrix();
/* 425 */             GL11.glMatrixMode(5888);
/* 426 */             GL11.glDisable(3042);
/* 427 */             GL11.glEnable(2896);
/* 428 */             GL11.glDepthFunc(515);
/*     */           }
/* 430 */           GL11.glPopMatrix();
/*     */         }
/* 432 */         GL11.glPopMatrix();
/*     */       }
/*     */     }
/* 435 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private boolean shouldRender(TileEntityAnvil te, int p) {
/* 439 */     if (p == 1) {
/* 440 */       return (te.field_70331_k != null) && ((te.gridTime > 0) || ((Minecraft.func_71410_x().field_71439_g.func_70694_bm() != null) && ((Minecraft.func_71410_x().field_71439_g.func_70694_bm().func_77973_b() instanceof ITongs))));
/*     */     }
/* 442 */     return true;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/render/TileEntityAnvilRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */