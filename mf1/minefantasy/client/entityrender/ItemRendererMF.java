/*     */ package minefantasy.client.entityrender;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import minefantasy.client.MFTextureHelper;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.ItemRenderer;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemBlock;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.Icon;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ItemRendererMF
/*     */ {
/*  27 */   private static RenderBlocks renderBlocksInstance = new RenderBlocks();
/*     */   
/*     */   public static void renderItem(ItemStack item, int renderPass) {
/*  30 */     GL11.glPushMatrix();
/*     */     
/*  32 */     Block block = null;
/*  33 */     if (((item.func_77973_b() instanceof ItemBlock)) && (item.field_77993_c < Block.field_71973_m.length)) {
/*  34 */       block = Block.field_71973_m[item.field_77993_c];
/*     */     }
/*  36 */     if ((block != null) && (item.func_94608_d() == 0) && (RenderBlocks.func_78597_b(Block.field_71973_m[item.field_77993_c].func_71857_b()))) {
/*  37 */       Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110575_b);
/*  38 */       renderBlocksInstance.func_78600_a(Block.field_71973_m[item.field_77993_c], item.func_77960_j(), 1.0F);
/*     */     } else {
/*  40 */       Icon icon = item.func_77973_b().getIcon(item, renderPass);
/*     */       
/*  42 */       if (icon == null) {
/*  43 */         GL11.glPopMatrix();
/*  44 */         return;
/*     */       }
/*     */       
/*  47 */       if (item.func_94608_d() == 0) {
/*  48 */         Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110575_b);
/*     */       } else {
/*  50 */         Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110576_c);
/*     */       }
/*     */       
/*  53 */       Tessellator tessellator = Tessellator.field_78398_a;
/*  54 */       float f = icon.func_94209_e();
/*  55 */       float f1 = icon.func_94212_f();
/*  56 */       float f2 = icon.func_94206_g();
/*  57 */       float f3 = icon.func_94210_h();
/*  58 */       float f4 = 0.0F;
/*  59 */       float f5 = 0.3F;
/*  60 */       GL11.glEnable(32826);
/*  61 */       GL11.glTranslatef(-f4, -f5, 0.0F);
/*  62 */       float f6 = 1.5F;
/*  63 */       GL11.glScalef(f6, f6, f6);
/*  64 */       GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
/*  65 */       GL11.glRotatef(335.0F, 0.0F, 0.0F, 1.0F);
/*  66 */       GL11.glTranslatef(-0.9375F, -0.0625F, 0.0F);
/*  67 */       ItemRenderer.func_78439_a(tessellator, f1, f2, f, f3, icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
/*     */       
/*  69 */       if ((item != null) && (item.func_77948_v()) && (renderPass == 0)) {
/*  70 */         GL11.glDepthFunc(514);
/*  71 */         GL11.glDisable(2896);
/*  72 */         Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.ITEM_GLINT);
/*  73 */         GL11.glEnable(3042);
/*  74 */         GL11.glBlendFunc(768, 1);
/*  75 */         float f7 = 0.76F;
/*  76 */         GL11.glColor4f(0.5F * f7, 0.25F * f7, 0.8F * f7, 1.0F);
/*  77 */         GL11.glMatrixMode(5890);
/*  78 */         GL11.glPushMatrix();
/*  79 */         float f8 = 0.125F;
/*  80 */         GL11.glScalef(f8, f8, f8);
/*  81 */         float f9 = (float)(Minecraft.func_71386_F() % 3000L) / 3000.0F * 8.0F;
/*  82 */         GL11.glTranslatef(f9, 0.0F, 0.0F);
/*  83 */         GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
/*  84 */         ItemRenderer.func_78439_a(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 256, 256, 0.0625F);
/*  85 */         GL11.glPopMatrix();
/*  86 */         GL11.glPushMatrix();
/*  87 */         GL11.glScalef(f8, f8, f8);
/*  88 */         f9 = (float)(Minecraft.func_71386_F() % 4873L) / 4873.0F * 8.0F;
/*  89 */         GL11.glTranslatef(-f9, 0.0F, 0.0F);
/*  90 */         GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
/*  91 */         ItemRenderer.func_78439_a(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 256, 256, 0.0625F);
/*  92 */         GL11.glPopMatrix();
/*  93 */         GL11.glMatrixMode(5888);
/*  94 */         GL11.glDisable(3042);
/*  95 */         GL11.glEnable(2896);
/*  96 */         GL11.glDepthFunc(515);
/*     */       }
/*     */       
/*  99 */       GL11.glDisable(32826);
/*     */     }
/*     */     
/* 102 */     GL11.glPopMatrix();
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/entityrender/ItemRendererMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */