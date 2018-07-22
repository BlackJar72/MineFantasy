/*     */ package minefantasy.client.tile.render;
/*     */ 
/*     */ import java.util.Random;
/*     */ import minefantasy.client.MFTextureHelper;
/*     */ import minefantasy.client.tile.TileEntityForge;
/*     */ import minefantasy.client.tile.model.ModelForge;
/*     */ import minefantasy.system.MFResource;
/*     */ import minefantasy.system.cfg;
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
/*     */ public class TileEntityForgeRenderer
/*     */   extends TileEntitySpecialRenderer
/*     */ {
/*     */   private ModelForge model;
/*     */   
/*     */   public TileEntityForgeRenderer()
/*     */   {
/*  31 */     this.model = new ModelForge();
/*     */   }
/*     */   
/*     */   public void renderAModelAt(TileEntityForge tile, double d, double d1, double d2, float f)
/*     */   {
/*  36 */     int i = 0;
/*  37 */     if (tile.field_70331_k != null) {
/*  38 */       i = tile.direction;
/*     */     }
/*     */     
/*  41 */     Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.getResource(MFResource.image("/item/" + tile.getTexture() + ".png")));
/*  42 */     GL11.glPushMatrix();
/*  43 */     GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
/*  44 */     GL11.glScalef(1.0F, -1.0F, -1.0F);
/*  45 */     GL11.glPushMatrix();
/*  46 */     GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
/*  47 */     this.model.renderModel(tile, 0.0625F);
/*  48 */     GL11.glRotatef(i * 90 + 90, 0.0F, 1.0F, 0.0F);
/*  49 */     renderItems(tile);
/*  50 */     GL11.glPopMatrix();
/*  51 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void renderItems(TileEntityForge tile)
/*     */   {
/*  56 */     float xStart = -0.25F;
/*  57 */     float yStart = 0.25F;
/*  58 */     float xGap = 0.25F;
/*  59 */     float yGap = -0.25F;
/*  60 */     for (int x = 0; x < 3; x++) {
/*  61 */       for (int y = 0; y < 3; y++) {
/*  62 */         GL11.glPushMatrix();
/*  63 */         GL11.glTranslatef(xStart + xGap * x, 1.1F, yStart + yGap * y);
/*  64 */         renderItem(tile.func_70301_a(1 + y * 3 + x));
/*  65 */         GL11.glPopMatrix();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_76894_a(TileEntity tileentity, double d, double d1, double d2, float f)
/*     */   {
/*  72 */     renderAModelAt((TileEntityForge)tileentity, d, d1, d2, f);
/*     */   }
/*     */   
/*     */ 
/*  76 */   private Random random = new Random();
/*     */   
/*     */   private void renderItem(ItemStack itemstack) {
/*  79 */     GL11.glPushMatrix();
/*  80 */     GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
/*  81 */     GL11.glScalef(0.27F, 0.27F, 0.27F);
/*     */     
/*  83 */     if ((itemstack != null) && (itemstack.func_77973_b() != null)) {
/*  84 */       if ((itemstack.func_77973_b() instanceof ItemBlock)) {
/*  85 */         GL11.glTranslatef(0.0F, -0.3F, 0.0F);
/*     */       }
/*     */       
/*  88 */       for (int k = 0; k < itemstack.func_77973_b().getRenderPasses(itemstack.func_77960_j()); k++) {
/*  89 */         GL11.glPushMatrix();
/*  90 */         Icon index = itemstack.func_77973_b().getIcon(itemstack, k);
/*  91 */         int colour = Item.field_77698_e[itemstack.field_77993_c].func_82790_a(itemstack, k);
/*  92 */         float red = (colour >> 16 & 0xFF) / 255.0F;
/*  93 */         float green = (colour >> 8 & 0xFF) / 255.0F;
/*  94 */         float blue = (colour & 0xFF) / 255.0F;
/*  95 */         float shade = 1.0F;
/*  96 */         GL11.glColor4f(red * shade, green * shade, blue * shade, 1.0F);
/*     */         
/*  98 */         Block block = null;
/*  99 */         if (itemstack.field_77993_c < Block.field_71973_m.length) {
/* 100 */           block = Block.field_71973_m[itemstack.field_77993_c];
/*     */         }
/*     */         
/* 103 */         if ((itemstack.func_94608_d() == 0) && (block != null))
/*     */         {
/* 105 */           GL11.glTranslatef(0.0F, 0.15625F, 0.0F);
/* 106 */           Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110575_b);
/* 107 */           float f7 = 0.5F;
/*     */           
/* 109 */           GL11.glScalef(f7, f7, f7);
/*     */           
/* 111 */           byte b0 = 1;
/* 112 */           for (int i = 0; i < b0; i++) {
/* 113 */             GL11.glPushMatrix();
/*     */             
/* 115 */             if (i > 0) {
/* 116 */               float f5 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
/* 117 */               float f4 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
/* 118 */               float f6 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
/* 119 */               GL11.glTranslatef(f5, f4, f6);
/*     */             }
/*     */             
/* 122 */             float f5 = 1.0F;
/* 123 */             new RenderBlocks().func_78600_a(block, itemstack.func_77960_j(), f5);
/* 124 */             GL11.glPopMatrix();
/*     */           }
/*     */         } else {
/* 127 */           Item item = itemstack.func_77973_b();
/* 128 */           Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110576_c);
/*     */           
/* 130 */           Tessellator image = Tessellator.field_78398_a;
/* 131 */           float x1 = index.func_94209_e();
/* 132 */           float x2 = index.func_94212_f();
/* 133 */           float y1 = index.func_94206_g();
/* 134 */           float y2 = index.func_94210_h();
/* 135 */           float xPos = 0.5F;
/* 136 */           float yPos = 0.5F;
/* 137 */           GL11.glEnable(32826);
/* 138 */           GL11.glTranslatef(-xPos, -yPos, 0.0F);
/* 139 */           float var13 = 1.0F;
/* 140 */           GL11.glScalef(var13, var13, var13);
/*     */           
/* 142 */           GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 143 */           GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
/* 144 */           ItemRenderer.func_78439_a(image, x2, y1, x1, y2, index.func_94211_a(), index.func_94216_b(), 0.0625F);
/*     */           
/* 146 */           if (cfg.renderHot) {
/* 147 */             GL11.glPushMatrix();
/* 148 */             if ((itemstack != null) && (TileEntityForge.isProperlyHeated(itemstack))) {
/* 149 */               GL11.glDepthFunc(514);
/* 150 */               GL11.glDisable(2896);
/* 151 */               Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.ITEM_GLINT);
/* 152 */               GL11.glEnable(3042);
/* 153 */               GL11.glBlendFunc(768, 1);
/* 154 */               float f13 = 0.76F;
/* 155 */               GL11.glColor4f(0.5F * f13, 0.25F * f13, 0.8F * f13, 1.0F);
/* 156 */               GL11.glMatrixMode(5890);
/* 157 */               GL11.glPushMatrix();
/* 158 */               float f14 = 0.125F;
/* 159 */               GL11.glScalef(f14, f14, f14);
/* 160 */               float f15 = (float)(Minecraft.func_71386_F() % 3000L) / 3000.0F * 8.0F;
/* 161 */               GL11.glTranslatef(f15, 0.0F, 0.0F);
/* 162 */               GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
/* 163 */               ItemRenderer.func_78439_a(image, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, 0.0625F);
/* 164 */               GL11.glPopMatrix();
/* 165 */               GL11.glPushMatrix();
/* 166 */               GL11.glScalef(f14, f14, f14);
/* 167 */               f15 = (float)(Minecraft.func_71386_F() % 4873L) / 4873.0F * 8.0F;
/* 168 */               GL11.glTranslatef(-f15, 0.0F, 0.0F);
/* 169 */               GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
/* 170 */               ItemRenderer.func_78439_a(image, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, 0.0625F);
/* 171 */               GL11.glPopMatrix();
/* 172 */               GL11.glMatrixMode(5888);
/* 173 */               GL11.glDisable(3042);
/* 174 */               GL11.glEnable(2896);
/* 175 */               GL11.glDepthFunc(515);
/*     */             }
/* 177 */             GL11.glPopMatrix();
/*     */           }
/*     */         }
/* 180 */         GL11.glPopMatrix();
/*     */       }
/*     */     }
/* 183 */     GL11.glPopMatrix();
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/render/TileEntityForgeRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */