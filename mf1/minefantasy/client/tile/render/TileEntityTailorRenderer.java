/*     */ package minefantasy.client.tile.render;
/*     */ 
/*     */ import java.util.Random;
/*     */ import minefantasy.client.MFTextureHelper;
/*     */ import minefantasy.client.tile.TileEntityTailor;
/*     */ import minefantasy.client.tile.model.ModelTailorBench;
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
/*     */ public class TileEntityTailorRenderer
/*     */   extends TileEntitySpecialRenderer
/*     */ {
/*     */   private ModelTailorBench model;
/*  30 */   private Random random = new Random();
/*     */   
/*     */   public TileEntityTailorRenderer() {
/*  33 */     this.model = new ModelTailorBench();
/*     */   }
/*     */   
/*     */   public void renderAModelAt(TileEntityTailor tile, double d, double d1, double d2, float f) {
/*  37 */     int tiledirection = 1;int tileangle = 90 * tiledirection;
/*     */     
/*  39 */     if (tile.field_70331_k != null) {
/*  40 */       tiledirection = tile.direction;
/*     */     }
/*     */     
/*  43 */     switch (tiledirection) {
/*     */     case 0: 
/*  45 */       tileangle = 0;
/*  46 */       break;
/*     */     
/*     */     case 1: 
/*  49 */       tileangle = 270;
/*  50 */       break;
/*     */     
/*     */     case 2: 
/*  53 */       tileangle = 180;
/*  54 */       break;
/*     */     
/*     */     case 3: 
/*     */     case 4: 
/*  58 */       tileangle = 90;
/*     */     }
/*     */     
/*     */     
/*     */ 
/*  63 */     Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.getResource(MFResource.image("/item/TailorBench.png")));
/*  64 */     GL11.glPushMatrix();
/*  65 */     float yOffset = 1.25F;
/*  66 */     GL11.glTranslatef((float)d + 0.5F, (float)d1 + yOffset, (float)d2 + 0.5F);
/*  67 */     GL11.glRotatef(tileangle + 180, 0.0F, 1.0F, 0.0F);
/*     */     
/*  69 */     GL11.glScalef(1.0F, -1.0F, -1.0F);
/*  70 */     this.model.renderModel(0.0625F);
/*  71 */     GL11.glPushMatrix();
/*  72 */     GL11.glScalef(0.75F, 0.75F, 0.75F);
/*     */     try
/*     */     {
/*  75 */       renderItems(tile);
/*     */     } catch (Exception Ex) {
/*  77 */       if (cfg.renderWarnings) {
/*  78 */         Minecraft.func_71410_x().field_71439_g.func_71035_c("Don't put that on the tailor bench");
/*     */       }
/*     */     }
/*     */     
/*  82 */     GL11.glPopMatrix();
/*  83 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void renderItems(TileEntityTailor tile)
/*     */   {
/*  88 */     double xStart = -0.5625D;double yStart = 0.15D;double xGap = 0.22499999403953552D;double yGap = -0.22499999403953552D;
/*     */     
/*  90 */     for (int y = 0; y < 4; y++) {
/*  91 */       GL11.glPushMatrix();
/*  92 */       GL11.glTranslated(xStart, 0.325D, yStart + yGap * y);
/*  93 */       renderItem(tile.getRenderItem(y));
/*  94 */       GL11.glPopMatrix();
/*     */     }
/*     */     
/*  97 */     for (int x = 0; x < 4; x++) {
/*  98 */       for (int y = 0; y < 4; y++) {
/*  99 */         GL11.glPushMatrix();
/* 100 */         GL11.glTranslated(xStart + xGap * (x + 2), 0.325D, yStart + yGap * y);
/* 101 */         renderItem(tile.getRenderItem(y * 4 + x + 4));
/* 102 */         GL11.glPopMatrix();
/*     */       }
/*     */     }
/* 105 */     if (tile.getRenderItem(tile.getOutputSlot()) != null) {
/* 106 */       boolean move = (tile.canCraft()) && (tile.canFitResult());
/* 107 */       renderBigItem(move, tile.getRenderItem(tile.getOutputSlot()), 0.0D, 1.0D, 0.0D);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_76894_a(TileEntity tileentity, double d, double d1, double d2, float f)
/*     */   {
/* 113 */     renderAModelAt((TileEntityTailor)tileentity, d, d1, d2, f);
/*     */   }
/*     */   
/*     */   private void renderItem(ItemStack itemstack) {
/* 117 */     GL11.glPushMatrix();
/* 118 */     GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
/* 119 */     GL11.glScalef(0.22500001F, 0.22500001F, 0.22500001F);
/* 120 */     if ((itemstack != null) && (itemstack.func_77973_b() != null)) {
/* 121 */       if ((itemstack.func_77973_b() instanceof ItemBlock)) {
/* 122 */         GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
/* 123 */         GL11.glTranslatef(0.0F, -0.2F, -0.3F);
/*     */       }
/* 125 */       for (int k = 0; k < itemstack.func_77973_b().getRenderPasses(itemstack.func_77960_j()); k++) {
/* 126 */         GL11.glPushMatrix();
/* 127 */         Icon index = itemstack.func_77973_b().getIcon(itemstack, k);
/* 128 */         int colour = Item.field_77698_e[itemstack.field_77993_c].func_82790_a(itemstack, k);
/* 129 */         float red = (colour >> 16 & 0xFF) / 255.0F;
/* 130 */         float green = (colour >> 8 & 0xFF) / 255.0F;
/* 131 */         float blue = (colour & 0xFF) / 255.0F;
/* 132 */         float shade = 1.0F;
/* 133 */         GL11.glColor4f(red * shade, green * shade, blue * shade, 1.0F);
/*     */         
/* 135 */         Block block = null;
/* 136 */         if (itemstack.field_77993_c < Block.field_71973_m.length) {
/* 137 */           block = Block.field_71973_m[itemstack.field_77993_c];
/*     */         }
/*     */         
/* 140 */         if ((itemstack.func_94608_d() == 0) && (block != null)) {
/* 141 */           float f7 = 0.5F;
/* 142 */           GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
/* 143 */           GL11.glTranslatef(0.0F, 0.15625F, 0.0F);
/* 144 */           Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110575_b);
/*     */           
/* 146 */           GL11.glScalef(f7, f7, f7);
/*     */           
/* 148 */           byte b0 = 1;
/* 149 */           for (int i = 0; i < b0; i++) {
/* 150 */             GL11.glPushMatrix();
/*     */             
/* 152 */             if (i > 0) {
/* 153 */               float f5 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
/* 154 */               float f4 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
/* 155 */               float f6 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
/* 156 */               GL11.glTranslatef(f5, f4, f6);
/*     */             }
/*     */             
/* 159 */             float f5 = 1.0F;
/* 160 */             new RenderBlocks().func_78600_a(block, itemstack.func_77960_j(), f5);
/* 161 */             GL11.glPopMatrix();
/*     */           }
/*     */         } else {
/* 164 */           Item item = itemstack.func_77973_b();
/* 165 */           Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110576_c);
/*     */           
/* 167 */           Tessellator image = Tessellator.field_78398_a;
/* 168 */           float x1 = index.func_94209_e();
/* 169 */           float x2 = index.func_94212_f();
/* 170 */           float y1 = index.func_94206_g();
/* 171 */           float y2 = index.func_94210_h();
/* 172 */           float xPos = 0.5F;
/* 173 */           float yPos = 0.5F;
/* 174 */           GL11.glEnable(32826);
/* 175 */           GL11.glTranslatef(-xPos, -yPos, 0.0F);
/* 176 */           float var13 = 1.0F;
/* 177 */           GL11.glScalef(var13, var13, var13);
/*     */           
/* 179 */           GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 180 */           GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
/* 181 */           ItemRenderer.func_78439_a(image, x2, y1, x1, y2, index.func_94211_a(), index.func_94216_b(), 0.0625F);
/*     */           
/* 183 */           GL11.glPushMatrix();
/* 184 */           if ((itemstack != null) && (itemstack.func_77948_v())) {
/* 185 */             GL11.glDepthFunc(514);
/* 186 */             GL11.glDisable(2896);
/* 187 */             Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.ITEM_GLINT);
/* 188 */             GL11.glEnable(3042);
/* 189 */             GL11.glBlendFunc(768, 1);
/* 190 */             float f13 = 0.76F;
/* 191 */             GL11.glColor4f(0.5F * f13, 0.25F * f13, 0.8F * f13, 1.0F);
/* 192 */             GL11.glMatrixMode(5890);
/* 193 */             GL11.glPushMatrix();
/* 194 */             float f14 = 0.125F;
/* 195 */             GL11.glScalef(f14, f14, f14);
/* 196 */             float f15 = (float)(Minecraft.func_71386_F() % 3000L) / 3000.0F * 8.0F;
/* 197 */             GL11.glTranslatef(f15, 0.0F, 0.0F);
/* 198 */             GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
/* 199 */             ItemRenderer.func_78439_a(image, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, 0.0625F);
/* 200 */             GL11.glPopMatrix();
/* 201 */             GL11.glPushMatrix();
/* 202 */             GL11.glScalef(f14, f14, f14);
/* 203 */             f15 = (float)(Minecraft.func_71386_F() % 4873L) / 4873.0F * 8.0F;
/* 204 */             GL11.glTranslatef(-f15, 0.0F, 0.0F);
/* 205 */             GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
/* 206 */             ItemRenderer.func_78439_a(image, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, 0.0625F);
/* 207 */             GL11.glPopMatrix();
/* 208 */             GL11.glMatrixMode(5888);
/* 209 */             GL11.glDisable(3042);
/* 210 */             GL11.glEnable(2896);
/* 211 */             GL11.glDepthFunc(515);
/*     */           }
/* 213 */           GL11.glPopMatrix();
/*     */         }
/* 215 */         GL11.glPopMatrix();
/*     */       }
/*     */     }
/* 218 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void renderBigItem(boolean move, ItemStack itemstack, double d, double d1, double d2) {
/* 222 */     GL11.glPushMatrix();
/* 223 */     GL11.glScalef(0.75F, 0.75F, 0.75F);
/*     */     
/* 225 */     if (move) {
/* 226 */       GL11.glTranslatef(0.0F, 1.0F, 0.0F);
/*     */     } else {
/* 228 */       GL11.glTranslatef(0.0F, 0.15F, 0.0F);
/*     */     }
/*     */     
/* 231 */     if ((itemstack != null) && (itemstack.func_77973_b() != null)) {
/* 232 */       if (!(itemstack.func_77973_b() instanceof ItemBlock)) {
/* 233 */         GL11.glTranslatef(0.0F, 0.3F, 0.0F);
/* 234 */         GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
/*     */       }
/* 236 */       for (int k = 0; k < itemstack.func_77973_b().getRenderPasses(itemstack.func_77960_j()); k++) {
/* 237 */         GL11.glPushMatrix();
/* 238 */         Icon index = itemstack.func_77973_b().getIcon(itemstack, k);
/* 239 */         int colour = Item.field_77698_e[itemstack.field_77993_c].func_82790_a(itemstack, k);
/* 240 */         float red = (colour >> 16 & 0xFF) / 255.0F;
/* 241 */         float green = (colour >> 8 & 0xFF) / 255.0F;
/* 242 */         float blue = (colour & 0xFF) / 255.0F;
/* 243 */         float shade = 1.0F;
/* 244 */         GL11.glColor4f(red * shade, green * shade, blue * shade, 1.0F);
/*     */         
/* 246 */         Block block = null;
/* 247 */         if (itemstack.field_77993_c < Block.field_71973_m.length) {
/* 248 */           block = Block.field_71973_m[itemstack.field_77993_c];
/*     */         }
/*     */         
/* 251 */         if ((itemstack.func_94608_d() == 0) && (block != null)) {
/* 252 */           float f7 = 0.5F;
/* 253 */           GL11.glTranslatef(0.0F, 0.15625F, 0.0F);
/* 254 */           Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110575_b);
/* 255 */           GL11.glScalef(f7, f7, f7);
/*     */           
/* 257 */           byte b0 = 1;
/* 258 */           for (int i = 0; i < b0; i++) {
/* 259 */             GL11.glPushMatrix();
/*     */             
/* 261 */             if (i > 0) {
/* 262 */               float f5 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
/* 263 */               float f4 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
/* 264 */               float f6 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
/* 265 */               GL11.glTranslatef(f5, f4, f6);
/*     */             }
/*     */             
/* 268 */             float f5 = 1.0F;
/* 269 */             new RenderBlocks().func_78600_a(block, itemstack.func_77960_j(), f5);
/* 270 */             GL11.glPopMatrix();
/*     */           }
/*     */         } else {
/* 273 */           Item item = itemstack.func_77973_b();
/* 274 */           Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110576_c);
/*     */           
/* 276 */           Tessellator image = Tessellator.field_78398_a;
/* 277 */           float x1 = index.func_94209_e();
/* 278 */           float x2 = index.func_94212_f();
/* 279 */           float y1 = index.func_94206_g();
/* 280 */           float y2 = index.func_94210_h();
/* 281 */           float xPos = 0.5F;
/* 282 */           float yPos = 0.5F;
/* 283 */           GL11.glEnable(32826);
/* 284 */           GL11.glTranslatef(-xPos, -yPos, 0.0F);
/* 285 */           float var13 = 1.0F;
/* 286 */           GL11.glScalef(var13, var13, var13);
/*     */           
/* 288 */           GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 289 */           GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
/* 290 */           ItemRenderer.func_78439_a(image, x2, y1, x1, y2, index.func_94211_a(), index.func_94216_b(), 0.0625F);
/*     */           
/* 292 */           GL11.glPushMatrix();
/* 293 */           if ((itemstack != null) && (itemstack.func_77948_v())) {
/* 294 */             GL11.glDepthFunc(514);
/* 295 */             GL11.glDisable(2896);
/* 296 */             Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.ITEM_GLINT);
/* 297 */             GL11.glEnable(3042);
/* 298 */             GL11.glBlendFunc(768, 1);
/* 299 */             float f13 = 0.76F;
/* 300 */             GL11.glColor4f(0.5F * f13, 0.25F * f13, 0.8F * f13, 1.0F);
/* 301 */             GL11.glMatrixMode(5890);
/* 302 */             GL11.glPushMatrix();
/* 303 */             float f14 = 0.125F;
/* 304 */             GL11.glScalef(f14, f14, f14);
/* 305 */             float f15 = (float)(Minecraft.func_71386_F() % 3000L) / 3000.0F * 8.0F;
/* 306 */             GL11.glTranslatef(f15, 0.0F, 0.0F);
/* 307 */             GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
/* 308 */             ItemRenderer.func_78439_a(image, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, 0.0625F);
/* 309 */             GL11.glPopMatrix();
/* 310 */             GL11.glPushMatrix();
/* 311 */             GL11.glScalef(f14, f14, f14);
/* 312 */             f15 = (float)(Minecraft.func_71386_F() % 4873L) / 4873.0F * 8.0F;
/* 313 */             GL11.glTranslatef(-f15, 0.0F, 0.0F);
/* 314 */             GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
/* 315 */             ItemRenderer.func_78439_a(image, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, 0.0625F);
/* 316 */             GL11.glPopMatrix();
/* 317 */             GL11.glMatrixMode(5888);
/* 318 */             GL11.glDisable(3042);
/* 319 */             GL11.glEnable(2896);
/* 320 */             GL11.glDepthFunc(515);
/*     */           }
/* 322 */           GL11.glPopMatrix();
/*     */         }
/* 324 */         GL11.glPopMatrix();
/*     */       }
/*     */     }
/* 327 */     GL11.glPopMatrix();
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/render/TileEntityTailorRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */