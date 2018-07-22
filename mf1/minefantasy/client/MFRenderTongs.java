/*     */ package minefantasy.client;
/*     */ 
/*     */ import cpw.mods.fml.client.FMLClientHandler;
/*     */ import minefantasy.api.forge.TongsHelper;
/*     */ import minefantasy.item.ItemHotItem;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.ItemRenderer;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraftforge.client.IItemRenderer;
/*     */ import net.minecraftforge.client.IItemRenderer.ItemRenderType;
/*     */ import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MFRenderTongs
/*     */   implements IItemRenderer
/*     */ {
/*  40 */   RenderItem renderItem = new RenderItem();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
/*     */   {
/*  47 */     return (type.equals(IItemRenderer.ItemRenderType.EQUIPPED)) || (type.equals(IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON));
/*     */   }
/*     */   
/*     */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack tongs, Object... data)
/*     */   {
/*  52 */     Minecraft mc = FMLClientHandler.instance().getClient();
/*     */     
/*  54 */     for (int a = 0; a < tongs.func_77973_b().getRenderPasses(0); a++) {
/*  55 */       Icon ic = tongs.func_77973_b().getIcon(tongs, a);
/*  56 */       int colour = tongs.func_77973_b().func_82790_a(tongs, a);
/*  57 */       if ((ic != null) && ((a == 1) || (TongsHelper.getHeldItem(tongs) != null))) {
/*  58 */         renderItemIn3D(tongs, ic, colour, a == 0);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void renderItemIn3D(ItemStack stack, Icon icon, int colour, boolean held) {
/*  64 */     GL11.glPushMatrix();
/*     */     
/*  66 */     float red = (colour >> 16 & 0xFF) / 255.0F;
/*  67 */     float green = (colour >> 8 & 0xFF) / 255.0F;
/*  68 */     float blue = (colour & 0xFF) / 255.0F;
/*     */     
/*  70 */     GL11.glColor4f(red, green, blue, 1.0F);
/*     */     
/*  72 */     ItemStack item = stack;
/*  73 */     if (ItemHotItem.getItem(stack) != null) {
/*  74 */       item = ItemHotItem.getItem(stack);
/*     */     }
/*     */     
/*  77 */     float scale = 1.0F;
/*  78 */     Minecraft mc = FMLClientHandler.instance().getClient();
/*  79 */     mc.field_71446_o.func_110577_a(TextureMap.field_110576_c);
/*  80 */     Tessellator tessellator = Tessellator.field_78398_a;
/*  81 */     float x1 = icon.func_94209_e();
/*  82 */     float x2 = icon.func_94212_f();
/*  83 */     float y1 = icon.func_94206_g();
/*  84 */     float y2 = icon.func_94210_h();
/*     */     
/*  86 */     float xOffset = 0.15F + 0.5F * (scale - 1.0F);
/*  87 */     float yOffset = 0.15F - 0.5F * (scale - 1.0F);
/*     */     
/*  89 */     if (held) {
/*  90 */       xOffset += 0.5F;
/*     */     }
/*  92 */     float xPos = 0.0F + xOffset - yOffset;
/*  93 */     float yPos = 0.3F - xOffset - yOffset;
/*  94 */     GL11.glEnable(32826);
/*  95 */     GL11.glTranslatef(-xPos, -yPos, 0.0F);
/*  96 */     GL11.glScalef(scale, scale, 1.0F);
/*  97 */     ItemRenderer.func_78439_a(tessellator, x2, y1, x1, y2, icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
/*     */     
/*  99 */     if ((item != null) && (item.func_77948_v())) {
/* 100 */       GL11.glDepthFunc(514);
/* 101 */       GL11.glDisable(2896);
/* 102 */       mc.field_71446_o.func_110577_a(MFTextureHelper.ITEM_GLINT);
/* 103 */       GL11.glEnable(3042);
/* 104 */       GL11.glBlendFunc(768, 1);
/* 105 */       float var13 = 0.76F;
/* 106 */       GL11.glColor4f(0.5F * var13, 0.25F * var13, 0.8F * var13, 1.0F);
/* 107 */       GL11.glMatrixMode(5890);
/* 108 */       GL11.glPushMatrix();
/* 109 */       float var14 = 0.125F;
/* 110 */       GL11.glScalef(var14, var14, var14);
/* 111 */       float var15 = (float)(System.currentTimeMillis() % 3000L) / 3000.0F * 8.0F;
/* 112 */       GL11.glTranslatef(var15, 0.0F, 0.0F);
/* 113 */       GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
/* 114 */       ItemRenderer.func_78439_a(tessellator, x2, y1, x1, y2, icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
/* 115 */       GL11.glPopMatrix();
/* 116 */       GL11.glPushMatrix();
/* 117 */       GL11.glScalef(var14, var14, var14);
/* 118 */       var15 = (float)(System.currentTimeMillis() % 4873L) / 4873.0F * 8.0F;
/* 119 */       GL11.glTranslatef(-var15, 0.0F, 0.0F);
/* 120 */       GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
/* 121 */       ItemRenderer.func_78439_a(tessellator, x2, y1, x1, y2, icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
/* 122 */       GL11.glPopMatrix();
/* 123 */       GL11.glMatrixMode(5888);
/* 124 */       GL11.glDisable(3042);
/* 125 */       GL11.glEnable(2896);
/* 126 */       GL11.glDepthFunc(515);
/*     */     }
/* 128 */     GL11.glDisable(32826);
/*     */     
/* 130 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
/*     */   {
/* 136 */     return false;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/MFRenderTongs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */