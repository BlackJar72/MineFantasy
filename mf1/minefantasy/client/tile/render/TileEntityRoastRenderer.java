/*     */ package minefantasy.client.tile.render;
/*     */ 
/*     */ import minefantasy.client.MFTextureHelper;
/*     */ import minefantasy.client.tile.TileEntityRoast;
/*     */ import minefantasy.client.tile.model.ModelRoast;
/*     */ import minefantasy.system.MFResource;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.ItemRenderer;
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
/*     */ public class TileEntityRoastRenderer extends TileEntitySpecialRenderer
/*     */ {
/*     */   private ModelRoast model;
/*     */   
/*     */   public TileEntityRoastRenderer()
/*     */   {
/*  25 */     this.model = new ModelRoast();
/*     */   }
/*     */   
/*     */   public void renderAModelAt(TileEntityRoast tile, double d, double d1, double d2, float f) {
/*  29 */     int tiledirection = 1;int tileangle = 90 * tiledirection;
/*     */     
/*  31 */     if (tile.field_70331_k != null) {
/*  32 */       tiledirection = tile.direction;
/*     */     }
/*     */     
/*  35 */     switch (tiledirection) {
/*     */     case 0: 
/*  37 */       tileangle = 0;
/*  38 */       break;
/*     */     
/*     */     case 1: 
/*  41 */       tileangle = 270;
/*  42 */       break;
/*     */     
/*     */     case 2: 
/*  45 */       tileangle = 180;
/*  46 */       break;
/*     */     
/*     */     case 3: 
/*     */     case 4: 
/*  50 */       tileangle = 90;
/*     */     }
/*     */     
/*     */     
/*     */ 
/*  55 */     Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.getResource(MFResource.image("/item/SpitRoast.png")));
/*     */     
/*  57 */     GL11.glPushMatrix();
/*  58 */     GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
/*  59 */     GL11.glRotatef(tiledirection + 180, 0.0F, 1.0F, 0.0F);
/*  60 */     GL11.glScalef(1.0F, -1.0F, -1.0F);
/*     */     
/*  62 */     float itemsGap = 0.17175F;
/*  63 */     float itemsStart = -0.5F + itemsGap;
/*  64 */     this.model.renderModel(tile.renderLeft(), tile.renderRight(), 0.0625F, tile.willShowBase());
/*  65 */     for (int a = 0; a < 5; a++) {
/*  66 */       GL11.glPushMatrix();
/*  67 */       ItemStack itemstack = tile.func_70301_a(a);
/*  68 */       if ((itemstack != null) && (itemstack.func_77973_b() != null)) {
/*  69 */         float x = itemsStart + a * itemsGap;
/*  70 */         float y = 1.0F;
/*  71 */         float z = 0.0F;
/*  72 */         float r = getRotationForItem(itemstack.func_77973_b());
/*  73 */         float scale = 1.0F;
/*     */         
/*  75 */         GL11.glTranslatef(x, y, z);
/*     */         
/*  77 */         GL11.glPushMatrix();
/*  78 */         GL11.glRotatef(r + 180.0F, 1.0F, 0.0F, 0.0F);
/*  79 */         GL11.glScalef(scale, scale, 1.0F);
/*  80 */         Icon icon = itemstack.func_77954_c();
/*  81 */         if (icon != null) {
/*  82 */           GL11.glPushMatrix();
/*  83 */           GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
/*  84 */           renderItem(tile, itemstack, icon, a);
/*  85 */           GL11.glPopMatrix();
/*     */         }
/*  87 */         GL11.glPopMatrix();
/*     */       }
/*     */       
/*  90 */       GL11.glPopMatrix();
/*     */     }
/*  92 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private float getRotationForItem(Item item)
/*     */   {
/*  97 */     String classname = item.getClass().getName();
/*  98 */     if ((classname.endsWith("ItemSpade")) || (classname.endsWith("ItemCrossbow")) || (classname.endsWith("ItemBlunderbuss")) || (classname.endsWith("ItemBlowgun")) || (classname.endsWith("ItemMusket"))) {
/*  99 */       return 45.0F;
/*     */     }
/* 101 */     return -45.0F;
/*     */   }
/*     */   
/*     */   public void func_76894_a(TileEntity tileentity, double d, double d1, double d2, float f)
/*     */   {
/* 106 */     renderAModelAt((TileEntityRoast)tileentity, d, d1, d2, f);
/*     */   }
/*     */   
/*     */   private void renderItem(TileEntityRoast tile, ItemStack itemstack, Icon icon, int slot) {
/* 110 */     Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110576_c);
/*     */     
/* 112 */     GL11.glColor3f(255.0F, 255.0F, 255.0F);
/* 113 */     Tessellator image = Tessellator.field_78398_a;
/* 114 */     float x1 = icon.func_94209_e();
/* 115 */     float x2 = icon.func_94212_f();
/* 116 */     float y1 = icon.func_94206_g();
/* 117 */     float y2 = icon.func_94210_h();
/* 118 */     float xPos = 0.3F;
/* 119 */     float yPos = 0.3F;
/* 120 */     GL11.glEnable(32826);
/* 121 */     GL11.glTranslatef(-xPos, -yPos, 0.0F);
/* 122 */     float scale = 0.6F;
/* 123 */     GL11.glScalef(scale, scale, scale);
/* 124 */     ItemRenderer.func_78439_a(image, x2, y1, x1, y2, icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
/*     */     
/* 126 */     GL11.glPushMatrix();
/* 127 */     if ((itemstack != null) && (tile.isEnchanted(slot))) {
/* 128 */       GL11.glDepthFunc(514);
/* 129 */       GL11.glDisable(2896);
/* 130 */       Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.ITEM_GLINT);
/* 131 */       GL11.glEnable(3042);
/* 132 */       GL11.glBlendFunc(768, 1);
/* 133 */       float f13 = 0.76F;float f14 = 0.125F;float f15 = (float)(Minecraft.func_71386_F() % 3000L) / 3000.0F * 8.0F;
/* 134 */       GL11.glColor4f(0.5F * f13, 0.25F * f13, 0.8F * f13, 1.0F);
/* 135 */       GL11.glMatrixMode(5890);
/* 136 */       GL11.glPushMatrix();
/*     */       
/* 138 */       GL11.glScalef(f14, f14, f14);
/*     */       
/* 140 */       GL11.glTranslatef(f15, 0.0F, 0.0F);
/* 141 */       GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
/* 142 */       ItemRenderer.func_78439_a(image, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, 0.0625F);
/* 143 */       GL11.glPopMatrix();
/* 144 */       GL11.glPushMatrix();
/* 145 */       GL11.glScalef(f14, f14, f14);
/* 146 */       f15 = (float)(Minecraft.func_71386_F() % 4873L) / 4873.0F * 8.0F;
/* 147 */       GL11.glTranslatef(-f15, 0.0F, 0.0F);
/* 148 */       GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
/* 149 */       ItemRenderer.func_78439_a(image, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, 0.0625F);
/* 150 */       GL11.glPopMatrix();
/* 151 */       GL11.glMatrixMode(5888);
/* 152 */       GL11.glDisable(3042);
/* 153 */       GL11.glEnable(2896);
/* 154 */       GL11.glDepthFunc(515);
/*     */     }
/* 156 */     GL11.glPopMatrix();
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/render/TileEntityRoastRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */