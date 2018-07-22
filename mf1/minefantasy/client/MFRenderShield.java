/*     */ package minefantasy.client;
/*     */ 
/*     */ import cpw.mods.fml.client.FMLClientHandler;
/*     */ import minefantasy.item.mabShield.ItemShield;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.ItemRenderer;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.client.IItemRenderer.ItemRenderType;
/*     */ import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class MFRenderShield implements net.minecraftforge.client.IItemRenderer
/*     */ {
/*     */   private Minecraft mc;
/*     */   private RenderItem itemRenderer;
/*     */   
/*     */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
/*     */   {
/*  24 */     return type != IItemRenderer.ItemRenderType.FIRST_PERSON_MAP;
/*     */   }
/*     */   
/*     */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
/*     */   {
/*  29 */     return (type == IItemRenderer.ItemRenderType.ENTITY) && ((helper == IItemRenderer.ItemRendererHelper.ENTITY_BOBBING) || (helper == IItemRenderer.ItemRendererHelper.ENTITY_ROTATION));
/*     */   }
/*     */   
/*     */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data)
/*     */   {
/*  34 */     if ((item.func_77973_b() instanceof ItemShield)) {
/*  35 */       if (this.mc == null) {
/*  36 */         this.mc = FMLClientHandler.instance().getClient();
/*  37 */         this.itemRenderer = new RenderItem();
/*     */       }
/*     */       
/*  40 */       ItemShield shield = (ItemShield)item.func_77973_b();
/*     */       
/*  42 */       GL11.glPushMatrix();
/*     */       
/*  44 */       float sc = shield.getScale(item);
/*     */       
/*  46 */       Tessellator tessellator = Tessellator.field_78398_a;
/*     */       
/*  48 */       int col = shield.getColor(item);
/*  49 */       float red = (col >> 16 & 0xFF) / 255.0F;
/*  50 */       float green = (col >> 8 & 0xFF) / 255.0F;
/*  51 */       float blue = (col & 0xFF) / 255.0F;
/*     */       
/*  53 */       Icon icon = shield.func_77650_f(item);
/*     */       
/*  55 */       if (type == IItemRenderer.ItemRenderType.ENTITY) {
/*  56 */         GL11.glTranslatef(-0.5F, -0.25F, 0.0F);
/*     */         
/*  58 */         GL11.glColor3f(1.0F, 1.0F, 1.0F);
/*  59 */         ItemRenderer.func_78439_a(tessellator, icon.func_94212_f(), icon.func_94206_g(), icon.func_94209_e(), icon.func_94210_h(), icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
/*     */         
/*  61 */         if (shield.hasColor(item)) {
/*  62 */           icon = shield.getPaintIcon();
/*  63 */           GL11.glColor3f(red, green, blue);
/*  64 */           ItemRenderer.func_78439_a(tessellator, icon.func_94212_f(), icon.func_94206_g(), icon.func_94209_e(), icon.func_94210_h(), icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
/*     */         }
/*     */         
/*  67 */         GL11.glTranslatef(0.0F, 0.0F, -0.0625F);
/*  68 */         icon = shield.getBackIcon();
/*  69 */         GL11.glColor3f(1.0F, 1.0F, 1.0F);
/*  70 */         ItemRenderer.func_78439_a(tessellator, icon.func_94212_f(), icon.func_94206_g(), icon.func_94209_e(), icon.func_94210_h(), icon.func_94211_a(), icon.func_94216_b(), 0.00390625F);
/*     */         
/*  72 */         GL11.glTranslatef(0.0F, 0.0F, 0.09375F);
/*  73 */         icon = shield.getTrimIcon();
/*  74 */         GL11.glColor3f(1.0F, 1.0F, 1.0F);
/*  75 */         ItemRenderer.func_78439_a(tessellator, icon.func_94212_f(), icon.func_94206_g(), icon.func_94209_e(), icon.func_94210_h(), icon.func_94211_a(), icon.func_94216_b(), 0.09375F);
/*     */         
/*  77 */         if (item.func_77948_v())
/*  78 */           MFTextureHelper.renderEnchantmentEffects(tessellator);
/*  79 */       } else if ((type == IItemRenderer.ItemRenderType.EQUIPPED) || (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON)) {
/*  80 */         EntityLivingBase user = null;
/*     */         
/*  82 */         if ((data.length >= 2) && ((data[1] instanceof EntityLivingBase))) {
/*  83 */           user = (EntityLivingBase)data[1];
/*     */         }
/*  85 */         if (user == null) {
/*  86 */           GL11.glRotatef(-135.0F, 0.0F, 0.0F, 1.0F);
/*  87 */           GL11.glTranslatef(-1.203125F, -0.25F, 0.0F);
/*     */         }
/*     */         
/*  90 */         GL11.glScalef(sc, sc, sc);
/*  91 */         GL11.glTranslatef(-(sc - 1.0F) * 0.25F, -(sc - 1.0F) * 0.5F, 0.0F);
/*     */         
/*  93 */         GL11.glColor3f(1.0F, 1.0F, 1.0F);
/*  94 */         ItemRenderer.func_78439_a(tessellator, icon.func_94212_f(), icon.func_94206_g(), icon.func_94209_e(), icon.func_94210_h(), icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
/*     */         
/*  96 */         if (shield.hasColor(item)) {
/*  97 */           icon = shield.getPaintIcon();
/*  98 */           GL11.glColor3f(red, green, blue);
/*  99 */           ItemRenderer.func_78439_a(tessellator, icon.func_94212_f(), icon.func_94206_g(), icon.func_94209_e(), icon.func_94210_h(), icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
/*     */         }
/*     */         
/* 102 */         GL11.glColor3f(1.0F, 1.0F, 1.0F);
/* 103 */         GL11.glTranslatef(0.0F, 0.0F, 0.00390625F);
/* 104 */         icon = shield.getBackIcon();
/* 105 */         ItemRenderer.func_78439_a(tessellator, icon.func_94212_f(), icon.func_94206_g(), icon.func_94209_e(), icon.func_94210_h(), icon.func_94211_a(), icon.func_94216_b(), 0.00390625F);
/*     */         
/* 107 */         GL11.glColor3f(1.0F, 1.0F, 1.0F);
/*     */         
/* 109 */         GL11.glTranslatef(0.0F, 0.0F, -0.00390625F);
/* 110 */         icon = shield.getTrimIcon();
/* 111 */         ItemRenderer.func_78439_a(tessellator, icon.func_94212_f(), icon.func_94206_g(), icon.func_94209_e(), icon.func_94210_h(), icon.func_94211_a(), icon.func_94216_b(), 0.09375F);
/*     */         
/* 113 */         if (item.func_77948_v()) {
/* 114 */           MFTextureHelper.renderEnchantmentEffects(tessellator);
/*     */         }
/* 116 */       } else if (type == IItemRenderer.ItemRenderType.INVENTORY)
/*     */       {
/* 118 */         GL11.glPushMatrix();
/* 119 */         GL11.glColor3f(1.0F, 1.0F, 1.0F);
/* 120 */         this.itemRenderer.func_94149_a(0, 0, icon, 16, 16);
/*     */         
/* 122 */         if (shield.hasColor(item)) {
/* 123 */           GL11.glColor3f(red, green, blue);
/* 124 */           icon = shield.getPaintIcon();
/* 125 */           this.itemRenderer.func_94149_a(0, 0, icon, 16, 16);
/*     */         }
/*     */         
/* 128 */         GL11.glColor3f(1.0F, 1.0F, 1.0F);
/* 129 */         icon = shield.getTrimIcon();
/* 130 */         this.itemRenderer.func_94149_a(0, 0, icon, 16, 16);
/*     */         
/* 132 */         GL11.glPopMatrix();
/*     */       }
/*     */       
/* 135 */       int arrowCount = shield.getArrowCount(item);
/*     */       
/*     */ 
/* 138 */       if (arrowCount > 64) {
/* 139 */         arrowCount = 64;
/*     */       }
/* 141 */       for (int i = 0; i < arrowCount; i++) {
/* 142 */         renderArrow(type == IItemRenderer.ItemRenderType.ENTITY, ItemShield.arrowX[i], ItemShield.arrowY[i], ItemShield.arrowDepth[i], ItemShield.pitch[i] + 90.0F, ItemShield.yaw[i] + 45.0F);
/*     */       }
/* 144 */       GL11.glPopMatrix();
/*     */     }
/*     */   }
/*     */   
/*     */   public static void renderArrow(boolean isEntity, float x, float y, float depth, float pitch, float yaw)
/*     */   {
/* 150 */     GL11.glPushMatrix();
/*     */     
/*     */ 
/*     */ 
/* 154 */     Minecraft.func_71410_x().field_71446_o.func_110577_a(arrowTex);
/* 155 */     Tessellator tessellator = Tessellator.field_78398_a;
/*     */     
/* 157 */     byte b0 = 0;
/* 158 */     float f2 = 0.375F * depth;
/* 159 */     float f3 = 0.0F;
/* 160 */     float f4 = (0 + b0 * 10) / 32.0F;
/* 161 */     float f5 = (5 + b0 * 10) / 32.0F;
/* 162 */     float f10 = 0.05F;
/*     */     
/* 164 */     GL11.glScalef(f10, f10, f10);
/* 165 */     if (isEntity) {
/* 166 */       GL11.glScalef(1.0F, 1.0F, -1.0F);
/*     */     }
/*     */     
/* 169 */     GL11.glTranslatef(x + 8.0F + 2.5F, y + 8.0F + 1.5F, 0.0F);
/*     */     
/* 171 */     GL11.glRotatef(pitch, 0.0F, 1.0F, 0.0F);
/* 172 */     GL11.glRotatef(yaw, 1.0F, 0.0F, 0.0F);
/* 173 */     GL11.glNormal3f(f10, 0.0F, 0.0F);
/*     */     
/* 175 */     for (int i = 0; i < 2; i++) {
/* 176 */       GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
/* 177 */       GL11.glNormal3f(0.0F, 0.0F, f10);
/* 178 */       tessellator.func_78382_b();
/* 179 */       tessellator.func_78374_a(0.0D * depth, -2.0D, 0.0D, f2, f4);
/* 180 */       tessellator.func_78374_a(16.0D * depth, -2.0D, 0.0D, f3, f4);
/* 181 */       tessellator.func_78374_a(16.0D * depth, 2.0D, 0.0D, f3, f5);
/* 182 */       tessellator.func_78374_a(0.0D * depth, 2.0D, 0.0D, f2, f5);
/* 183 */       tessellator.func_78381_a();
/*     */       
/* 185 */       tessellator.func_78382_b();
/* 186 */       tessellator.func_78374_a(0.0D * depth, 2.0D, 0.0D, f2, f5);
/* 187 */       tessellator.func_78374_a(16.0D * depth, 2.0D, 0.0D, f3, f5);
/* 188 */       tessellator.func_78374_a(16.0D * depth, -2.0D, 0.0D, f3, f4);
/* 189 */       tessellator.func_78374_a(0.0D * depth, -2.0D, 0.0D, f2, f4);
/* 190 */       tessellator.func_78381_a();
/*     */     }
/* 192 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/* 195 */   private static final ResourceLocation arrowTex = new ResourceLocation("textures/entity/arrow.png");
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/MFRenderShield.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */