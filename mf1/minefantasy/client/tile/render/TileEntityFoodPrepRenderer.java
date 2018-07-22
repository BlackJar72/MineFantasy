/*     */ package minefantasy.client.tile.render;
/*     */ 
/*     */ import java.util.Random;
/*     */ import minefantasy.client.MFTextureHelper;
/*     */ import minefantasy.client.tile.TileEntityFoodPrep;
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
/*     */ 
/*     */ 
/*     */ public class TileEntityFoodPrepRenderer
/*     */   extends TileEntitySpecialRenderer
/*     */ {
/*  29 */   private Random random = new Random();
/*     */   
/*     */ 
/*     */ 
/*     */   public void renderAModelAt(TileEntityFoodPrep tile, double d, double d1, double d2, float f)
/*     */   {
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
/*     */ 
/*     */ 
/*     */ 
/*  64 */     GL11.glPushMatrix();
/*     */     
/*  66 */     GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.45F, (float)d2 + 0.5F);
/*  67 */     GL11.glRotatef(tileangle, 0.0F, 1.0F, 0.0F);
/*  68 */     GL11.glScalef(1.0F, -1.0F, -1.0F);
/*  69 */     GL11.glTranslatef(0.0F, 1.3125F, 0.0F);
/*  70 */     GL11.glPushMatrix();
/*  71 */     GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
/*     */     try
/*     */     {
/*  74 */       renderItem(tile, d, d1, d2, f);
/*     */     } catch (Exception Ex) {
/*  76 */       if (cfg.renderWarnings) {
/*  77 */         Minecraft.func_71410_x().field_71439_g.func_71035_c("Don't put that on the benchtop");
/*     */       }
/*     */     }
/*     */     
/*  81 */     GL11.glPopMatrix();
/*  82 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_76894_a(TileEntity tileentity, double d, double d1, double d2, float f)
/*     */   {
/*  88 */     renderAModelAt((TileEntityFoodPrep)tileentity, d, d1, d2, f);
/*     */   }
/*     */   
/*     */   private void renderItem(TileEntityFoodPrep tile, double d, double d1, double d2, float f) {
/*  92 */     ItemStack itemstack = tile.func_70301_a(0);
/*  93 */     if ((itemstack != null) && (itemstack.func_77973_b() != null))
/*     */     {
/*  95 */       Block block = null;
/*  96 */       if (itemstack.field_77993_c < Block.field_71973_m.length) {
/*  97 */         block = Block.field_71973_m[itemstack.field_77993_c];
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 102 */       if ((itemstack.func_94608_d() == 0) && (block != null)) {
/* 103 */         if (block.func_71857_b() == cfg.renderId) {
/* 104 */           GL11.glTranslatef(-0.25F, 0.25F, -0.25F);
/*     */         }
/* 106 */         GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
/* 107 */         GL11.glTranslatef(0.0F, 0.15625F, 0.0F);
/* 108 */         Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110575_b);
/* 109 */         float f7 = 0.5F;
/*     */         
/* 111 */         GL11.glScalef(f7, f7, f7);
/*     */         
/* 113 */         byte b0 = 1;
/* 114 */         for (int i = 0; i < b0; i++) {
/* 115 */           GL11.glPushMatrix();
/*     */           
/* 117 */           if (i > 0) {
/* 118 */             float f5 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
/* 119 */             float f4 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
/* 120 */             float f6 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
/* 121 */             GL11.glTranslatef(f5, f4, f6);
/*     */           }
/*     */           
/* 124 */           float f5 = 1.0F;
/* 125 */           new RenderBlocks().func_78600_a(block, itemstack.func_77960_j(), f5);
/* 126 */           GL11.glPopMatrix();
/*     */         }
/*     */       } else {
/* 129 */         Item item = itemstack.func_77973_b();
/* 130 */         Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110576_c);
/*     */         
/* 132 */         Tessellator image = Tessellator.field_78398_a;
/* 133 */         Icon index = item.func_77617_a(itemstack.func_77960_j());
/* 134 */         float x1 = index.func_94209_e();
/* 135 */         float x2 = index.func_94212_f();
/* 136 */         float y1 = index.func_94206_g();
/* 137 */         float y2 = index.func_94210_h();
/* 138 */         float xPos = 0.5F;
/* 139 */         float yPos = 0.5F;
/* 140 */         GL11.glEnable(32826);
/* 141 */         GL11.glTranslatef(-xPos, -yPos, 0.0F);
/* 142 */         float var13 = 1.0F;
/* 143 */         GL11.glScalef(var13, var13, var13);
/*     */         
/* 145 */         GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 146 */         GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
/* 147 */         ItemRenderer.func_78439_a(image, x2, y1, x1, y2, index.func_94211_a(), index.func_94216_b(), 0.0625F);
/*     */         
/* 149 */         GL11.glPushMatrix();
/* 150 */         if ((itemstack != null) && (tile.displayGlint)) {
/* 151 */           GL11.glDepthFunc(514);
/* 152 */           GL11.glDisable(2896);
/* 153 */           Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.ITEM_GLINT);
/* 154 */           GL11.glEnable(3042);
/* 155 */           GL11.glBlendFunc(768, 1);
/* 156 */           float f13 = 0.76F;
/* 157 */           GL11.glColor4f(0.5F * f13, 0.25F * f13, 0.8F * f13, 1.0F);
/* 158 */           GL11.glMatrixMode(5890);
/* 159 */           GL11.glPushMatrix();
/* 160 */           float f14 = 0.125F;
/* 161 */           GL11.glScalef(f14, f14, f14);
/* 162 */           float f15 = (float)(Minecraft.func_71386_F() % 3000L) / 3000.0F * 8.0F;
/* 163 */           GL11.glTranslatef(f15, 0.0F, 0.0F);
/* 164 */           GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
/* 165 */           ItemRenderer.func_78439_a(image, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, 0.0625F);
/* 166 */           GL11.glPopMatrix();
/* 167 */           GL11.glPushMatrix();
/* 168 */           GL11.glScalef(f14, f14, f14);
/* 169 */           f15 = (float)(Minecraft.func_71386_F() % 4873L) / 4873.0F * 8.0F;
/* 170 */           GL11.glTranslatef(-f15, 0.0F, 0.0F);
/* 171 */           GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
/* 172 */           ItemRenderer.func_78439_a(image, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, 0.0625F);
/* 173 */           GL11.glPopMatrix();
/* 174 */           GL11.glMatrixMode(5888);
/* 175 */           GL11.glDisable(3042);
/* 176 */           GL11.glEnable(2896);
/* 177 */           GL11.glDepthFunc(515);
/*     */         }
/* 179 */         GL11.glPopMatrix();
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/render/TileEntityFoodPrepRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */