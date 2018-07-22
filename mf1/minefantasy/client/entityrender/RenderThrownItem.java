/*     */ package minefantasy.client.entityrender;
/*     */ 
/*     */ import minefantasy.client.MFTextureHelper;
/*     */ import minefantasy.entity.IThrownItem;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.ItemRenderer;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.entity.Render;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RenderThrownItem
/*     */   extends Render
/*     */ {
/*     */   public RenderThrownItem()
/*     */   {
/*  27 */     this.field_76989_e = 0.5F;
/*     */   }
/*     */   
/*     */   public void renderArrow(Entity arrow, double x, double y, double z, float xr, float yr) {
/*  31 */     boolean isEnchanted = false;
/*  32 */     Minecraft mc = Minecraft.func_71410_x();
/*  33 */     mc.field_71446_o.func_110577_a(TextureMap.field_110576_c);
/*  34 */     GL11.glPushMatrix();
/*  35 */     GL11.glTranslatef((float)x, (float)y, (float)z);
/*  36 */     GL11.glRotatef(arrow.field_70126_B + (arrow.field_70177_z - arrow.field_70126_B) * yr - 90.0F, 0.0F, 1.0F, 0.0F);
/*  37 */     GL11.glRotatef(arrow.field_70127_C + (arrow.field_70125_A - arrow.field_70127_C) * yr, 0.0F, 0.0F, 1.0F);
/*  38 */     Tessellator image = Tessellator.field_78398_a;
/*  39 */     Icon icon = null;
/*  40 */     ItemStack itemstack = null;
/*  41 */     float scale = 1.0F;
/*  42 */     float spin = 0.0F;
/*  43 */     float rotate = 0.0F;
/*  44 */     if ((arrow instanceof IThrownItem)) {
/*  45 */       IThrownItem t = (IThrownItem)arrow;
/*  46 */       ItemStack is = ((IThrownItem)arrow).getRenderItem();
/*  47 */       if ((is != null) && (is.func_77973_b() != null)) {
/*  48 */         icon = is.func_77954_c();
/*  49 */         itemstack = is;
/*     */       }
/*  51 */       isEnchanted = t.isEnchanted();
/*  52 */       scale = t.getScale();
/*  53 */       spin = t.getSpin();
/*  54 */       rotate = t.getRotate();
/*     */     }
/*     */     
/*  57 */     GL11.glPushMatrix();
/*  58 */     GL11.glRotatef(spin - 135.0F, 0.0F, 0.0F, 1.0F);
/*  59 */     if (icon != null) {
/*  60 */       float x1 = icon.func_94209_e();
/*  61 */       float x2 = icon.func_94212_f();
/*  62 */       float y1 = icon.func_94206_g();
/*  63 */       float y2 = icon.func_94210_h();
/*  64 */       float xPos = 0.5F * scale;
/*  65 */       float yPos = 0.5F * scale;
/*  66 */       GL11.glEnable(32826);
/*  67 */       GL11.glTranslatef(-xPos, -yPos, 0.0F);
/*  68 */       GL11.glScalef(scale, scale, 1.0F);
/*     */       
/*  70 */       ItemRenderer.func_78439_a(image, x2, y1, x1, y2, icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
/*     */       
/*  72 */       if ((itemstack != null) && (isEnchanted)) {
/*  73 */         GL11.glDepthFunc(514);
/*  74 */         GL11.glDisable(2896);
/*  75 */         this.field_76990_c.field_78724_e.func_110577_a(MFTextureHelper.ITEM_GLINT);
/*  76 */         GL11.glEnable(3042);
/*  77 */         GL11.glBlendFunc(768, 1);
/*  78 */         float f13 = 0.76F;
/*  79 */         GL11.glColor4f(0.5F * f13, 0.25F * f13, 0.8F * f13, 1.0F);
/*  80 */         GL11.glMatrixMode(5890);
/*  81 */         GL11.glPushMatrix();
/*  82 */         float f14 = 0.125F;
/*  83 */         GL11.glScalef(f14, f14, f14);
/*  84 */         float f15 = (float)(Minecraft.func_71386_F() % 3000L) / 3000.0F * 8.0F;
/*  85 */         GL11.glTranslatef(f15, 0.0F, 0.0F);
/*  86 */         GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
/*  87 */         ItemRenderer.func_78439_a(image, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, 0.0625F);
/*  88 */         GL11.glPopMatrix();
/*  89 */         GL11.glPushMatrix();
/*  90 */         GL11.glScalef(f14, f14, f14);
/*  91 */         f15 = (float)(Minecraft.func_71386_F() % 4873L) / 4873.0F * 8.0F;
/*  92 */         GL11.glTranslatef(-f15, 0.0F, 0.0F);
/*  93 */         GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
/*  94 */         ItemRenderer.func_78439_a(image, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, 0.0625F);
/*  95 */         GL11.glPopMatrix();
/*  96 */         GL11.glMatrixMode(5888);
/*  97 */         GL11.glDisable(3042);
/*  98 */         GL11.glEnable(2896);
/*  99 */         GL11.glDepthFunc(515);
/*     */       }
/*     */     }
/*     */     
/* 103 */     GL11.glPopMatrix();
/* 104 */     GL11.glDisable(32826);
/* 105 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_76986_a(Entity entity, double x, double y, double z, float xr, float yr)
/*     */   {
/* 117 */     renderArrow(entity, x, y, z, xr, yr);
/*     */   }
/*     */   
/*     */   protected ResourceLocation func_110775_a(Entity entity)
/*     */   {
/* 122 */     return null;
/*     */   }
/*     */   
/*     */   private void loadTexture(String image) {
/* 126 */     func_110776_a(MFTextureHelper.getResource(image));
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/entityrender/RenderThrownItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */