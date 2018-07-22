/*     */ package minefantasy.client;
/*     */ 
/*     */ import cpw.mods.fml.client.FMLClientHandler;
/*     */ import minefantasy.api.weapon.EnumAmmo;
/*     */ import minefantasy.item.weapon.ItemCrossbow;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.ItemRenderer;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumAction;
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
/*     */ public class MFRenderCrossbow
/*     */   implements IItemRenderer
/*     */ {
/*     */   private float scale;
/*  34 */   RenderItem renderItem = new RenderItem();
/*     */   
/*     */   public MFRenderCrossbow(float sc) {
/*  37 */     this.scale = sc;
/*     */   }
/*     */   
/*     */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
/*     */   {
/*  42 */     return (type.equals(IItemRenderer.ItemRenderType.EQUIPPED)) || (type.equals(IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON));
/*     */   }
/*     */   
/*     */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
/*     */   {
/*  47 */     return false;
/*     */   }
/*     */   
/*     */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data)
/*     */   {
/*  52 */     Minecraft mc = FMLClientHandler.instance().getClient();
/*  53 */     if (type.equals(IItemRenderer.ItemRenderType.EQUIPPED)) {
/*  54 */       EntityLivingBase player = null;
/*  55 */       for (int a = 0; a < data.length; a++) {
/*  56 */         if ((data[a] instanceof EntityLivingBase)) {
/*  57 */           player = (EntityLivingBase)data[a];
/*     */         }
/*     */       }
/*  60 */       for (int ic = 0; ic < 2; ic++) {
/*  61 */         renderWeapon(item, player, ic);
/*     */       }
/*     */     }
/*  64 */     if (type.equals(IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON)) {
/*  65 */       EntityLivingBase player = null;
/*  66 */       for (int a = 0; a < data.length; a++) {
/*  67 */         if ((data[a] instanceof EntityLivingBase)) {
/*  68 */           player = (EntityLivingBase)data[a];
/*     */         }
/*     */       }
/*  71 */       for (int ic = 0; ic < 2; ic++) {
/*  72 */         renderWeapon(item, player, ic);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void renderFirstPerson(ItemStack item, EntityPlayer player, int ic) {
/*  78 */     GL11.glPushMatrix();
/*     */     
/*     */ 
/*  81 */     GL11.glTranslatef(-0.4F, 0.2F, 0.0F);
/*  82 */     if ((player.func_71039_bw()) && (item.func_77975_n() == EnumAction.bow))
/*  83 */       GL11.glTranslatef(0.1F, -0.1F, 0.0F);
/*  84 */     if ((player.func_71039_bw()) && (item.func_77975_n() == EnumAction.block)) {
/*  85 */       GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
/*  86 */       GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
/*     */     }
/*  88 */     renderWeapon(item, player, ic);
/*  89 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void renderWeapon(ItemStack item, EntityLivingBase player, int ic)
/*     */   {
/*  94 */     GL11.glPushMatrix();
/*     */     
/*  96 */     GL11.glTranslatef(0.75F, -0.25F, 0.0F);
/*  97 */     GL11.glTranslatef(0.0F, 0.0F, 0.0F);
/*     */     
/*  99 */     if (player == null) {
/* 100 */       GL11.glRotatef(-90.0F, 1.0F, 1.0F, 0.0F);
/* 101 */       GL11.glTranslatef(0.75F, -0.125F, 0.5F);
/*     */     }
/* 103 */     renderWeaponAsItem(item, ic);
/*     */     
/* 105 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void renderWeaponAsItem(ItemStack item, int ic)
/*     */   {
/* 110 */     GL11.glPushMatrix();
/* 111 */     float x = -0.35F;
/* 112 */     float y = 0.5F;
/*     */     
/* 114 */     ItemCrossbow bow = (ItemCrossbow)item.func_77973_b();
/* 115 */     if (this.scale == 2.0F) {
/* 116 */       x -= 0.625F;
/* 117 */       y -= 0.425F;
/*     */     }
/* 119 */     if (ic == 1) {
/* 120 */       y += bow.headYoffset();
/* 121 */       x += bow.headXoffset();
/*     */     }
/* 123 */     GL11.glTranslatef(x, y, 0.0F);
/* 124 */     if (ic == 1) {
/* 125 */       GL11.glTranslatef(0.0F, -0.1F, 0.0F);
/* 126 */       GL11.glScalef(this.scale, this.scale, this.scale);
/*     */     } else {
/* 128 */       GL11.glScalef(this.scale, this.scale, 1.0F);
/* 129 */       GL11.glTranslatef(0.0F, 0.0F, 0.03125F);
/*     */     }
/* 131 */     Minecraft mc = FMLClientHandler.instance().getClient();
/* 132 */     if (item != null) {
/* 133 */       mc.field_71446_o.func_110577_a(TextureMap.field_110576_c);
/*     */     }
/* 135 */     if (ic == 1) {
/* 136 */       GL11.glRotatef(90.0F, 1.0F, 1.0F, 0.0F);
/*     */     }
/*     */     
/* 139 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 140 */     ItemCrossbow crossbow = (ItemCrossbow)item.func_77973_b();
/* 141 */     Icon icon = ic == 0 ? crossbow.getStockItem(item) : crossbow.getHeadItem(item);
/* 142 */     renderIcon(mc, item, tessellator, icon);
/*     */     
/* 144 */     if (ic == 1) {
/* 145 */       for (int slot = 0; slot <= crossbow.cap; slot++) {
/* 146 */         GL11.glPushMatrix();
/* 147 */         float m = 0.01F;
/* 148 */         if (slot % 2 == 0) {
/* 149 */           m = 0.0F;
/*     */         }
/*     */         
/* 152 */         if (crossbow.ammoItem == EnumAmmo.ARROW) {
/* 153 */           GL11.glTranslatef(0.2F - m, 0.7F - m, -(slot + 1) / 64.0F - 0.03125F);
/*     */         } else {
/* 155 */           GL11.glTranslatef(0.1F - m + 0.25F, 0.35F - m + 0.25F, -(slot + 1) / 64.0F - 0.03125F);
/*     */         }
/*     */         
/* 158 */         float ammoSize = crossbow.ammoItem == EnumAmmo.ARROW ? 1.0F : 0.5F;
/*     */         
/* 160 */         GL11.glScalef(0.5F, 0.5F, 0.5F);
/* 161 */         GL11.glRotatef(90.0F, 0.0F, 0.0F, -1.0F);
/* 162 */         ItemStack loaded = crossbow.getNextShot(item, slot);
/*     */         
/* 164 */         if (loaded != null) {
/* 165 */           Icon bolt = loaded.func_77954_c();
/* 166 */           renderIcon(mc, item, tessellator, bolt, ammoSize);
/*     */         }
/* 168 */         GL11.glPopMatrix();
/*     */       }
/*     */     }
/* 171 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void renderIcon(Minecraft mc, ItemStack item, Tessellator tessellator, Icon icon)
/*     */   {
/* 176 */     renderIcon(mc, item, tessellator, icon, 1.0F);
/*     */   }
/*     */   
/*     */   private void renderIcon(Minecraft mc, ItemStack item, Tessellator tessellator, Icon icon, float scale) {
/* 180 */     float x1 = icon.func_94209_e();
/* 181 */     float x2 = icon.func_94212_f();
/* 182 */     float y1 = icon.func_94206_g();
/* 183 */     float y2 = icon.func_94210_h();
/* 184 */     float var10 = 0.0F;
/* 185 */     float var11 = 0.3F;
/* 186 */     GL11.glEnable(32826);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 194 */     GL11.glScalef(scale, scale, scale);
/* 195 */     ItemRenderer.func_78439_a(tessellator, x2, y1, x1, y2, icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
/*     */     
/* 197 */     if ((item != null) && (item.func_77948_v())) {
/* 198 */       GL11.glDepthFunc(514);
/* 199 */       GL11.glDisable(2896);
/* 200 */       mc.field_71446_o.func_110577_a(MFTextureHelper.ITEM_GLINT);
/* 201 */       GL11.glEnable(3042);
/* 202 */       GL11.glBlendFunc(768, 1);
/* 203 */       float var13 = 0.76F;
/* 204 */       GL11.glColor4f(0.5F * var13, 0.25F * var13, 0.8F * var13, 1.0F);
/* 205 */       GL11.glMatrixMode(5890);
/* 206 */       GL11.glPushMatrix();
/* 207 */       float var14 = 0.125F;
/* 208 */       GL11.glScalef(var14, var14, var14);
/* 209 */       float var15 = (float)(System.currentTimeMillis() % 3000L) / 3000.0F * 8.0F;
/* 210 */       GL11.glTranslatef(var15, 0.0F, 0.0F);
/* 211 */       GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
/* 212 */       ItemRenderer.func_78439_a(tessellator, x2, y1, x1, y2, (int)(icon.func_94211_a() * scale), (int)(icon.func_94216_b() * scale), 0.0625F);
/* 213 */       GL11.glPopMatrix();
/* 214 */       GL11.glPushMatrix();
/* 215 */       GL11.glScalef(var14, var14, var14);
/* 216 */       var15 = (float)(System.currentTimeMillis() % 4873L) / 4873.0F * 8.0F;
/* 217 */       GL11.glTranslatef(-var15, 0.0F, 0.0F);
/* 218 */       GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
/* 219 */       ItemRenderer.func_78439_a(tessellator, x2, y1, x1, y2, (int)(icon.func_94211_a() * scale), (int)(icon.func_94216_b() * scale), 0.0625F);
/* 220 */       GL11.glPopMatrix();
/* 221 */       GL11.glMatrixMode(5888);
/* 222 */       GL11.glDisable(3042);
/* 223 */       GL11.glEnable(2896);
/* 224 */       GL11.glDepthFunc(515);
/*     */     }
/*     */     
/* 227 */     GL11.glDisable(32826);
/*     */   }
/*     */   
/*     */   public static void draw2dItem(Tessellator tessellator, float f, float f1, float f2, float f3, float thickness, float res, float resSq)
/*     */   {
/* 232 */     float f4 = 1.0F;
/* 233 */     float f5 = 0.0625F * thickness;
/* 234 */     tessellator.func_78382_b();
/* 235 */     tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
/* 236 */     tessellator.func_78374_a(0.0D, 0.0D, 0.0D, f, f3);
/* 237 */     tessellator.func_78374_a(f4, 0.0D, 0.0D, f2, f3);
/* 238 */     tessellator.func_78374_a(f4, 1.0D, 0.0D, f2, f1);
/* 239 */     tessellator.func_78374_a(0.0D, 1.0D, 0.0D, f, f1);
/* 240 */     tessellator.func_78381_a();
/* 241 */     tessellator.func_78382_b();
/* 242 */     tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
/* 243 */     tessellator.func_78374_a(0.0D, 1.0D, 0.0F - f5, f, f1);
/* 244 */     tessellator.func_78374_a(f4, 1.0D, 0.0F - f5, f2, f1);
/* 245 */     tessellator.func_78374_a(f4, 0.0D, 0.0F - f5, f2, f3);
/* 246 */     tessellator.func_78374_a(0.0D, 0.0D, 0.0F - f5, f, f3);
/* 247 */     tessellator.func_78381_a();
/*     */     
/* 249 */     tessellator.func_78382_b();
/* 250 */     tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 251 */     for (int i = 0; i < res; i++) {
/* 252 */       float f6 = i / res;
/* 253 */       float f10 = f + (f2 - f) * f6 - 1.0F / (2.0F * resSq);
/* 254 */       float f14 = f4 * f6;
/* 255 */       tessellator.func_78374_a(f14, 0.0D, 0.0F - f5, f10, f3);
/* 256 */       tessellator.func_78374_a(f14, 0.0D, 0.0D, f10, f3);
/* 257 */       tessellator.func_78374_a(f14, 1.0D, 0.0D, f10, f1);
/* 258 */       tessellator.func_78374_a(f14, 1.0D, 0.0F - f5, f10, f1);
/*     */     }
/*     */     
/* 261 */     tessellator.func_78381_a();
/*     */     
/* 263 */     tessellator.func_78382_b();
/* 264 */     tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
/* 265 */     for (int j = 0; j < res; j++) {
/* 266 */       float f7 = j / res;
/* 267 */       float f11 = f + (f2 - f) * f7 - 1.0F / (2.0F * resSq);
/* 268 */       float f15 = f4 * f7 + 1.0F / (res - 0.01F);
/* 269 */       tessellator.func_78374_a(f15, 1.0D, 0.0F - f5, f11, f1);
/* 270 */       tessellator.func_78374_a(f15, 1.0D, 0.0D, f11, f1);
/* 271 */       tessellator.func_78374_a(f15, 0.0D, 0.0D, f11, f3);
/* 272 */       tessellator.func_78374_a(f15, 0.0D, 0.0F - f5, f11, f3);
/*     */     }
/*     */     
/* 275 */     tessellator.func_78381_a();
/*     */     
/* 277 */     tessellator.func_78382_b();
/* 278 */     tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/* 279 */     for (int k = 0; k < res; k++) {
/* 280 */       float f8 = k / res;
/* 281 */       float f12 = f3 + (f1 - f3) * f8 - 1.0F / (2.0F * resSq);
/* 282 */       float f16 = f4 * f8 + 1.0F / (res - 0.01F);
/* 283 */       tessellator.func_78374_a(0.0D, f16, 0.0D, f, f12);
/* 284 */       tessellator.func_78374_a(f4, f16, 0.0D, f2, f12);
/* 285 */       tessellator.func_78374_a(f4, f16, 0.0F - f5, f2, f12);
/* 286 */       tessellator.func_78374_a(0.0D, f16, 0.0F - f5, f, f12);
/*     */     }
/*     */     
/* 289 */     tessellator.func_78381_a();
/*     */     
/* 291 */     tessellator.func_78382_b();
/* 292 */     tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
/* 293 */     for (int l = 0; l < res; l++) {
/* 294 */       float f9 = l / res;
/* 295 */       float f13 = f3 + (f1 - f3) * f9 - 1.0F / (2.0F * resSq);
/* 296 */       float f17 = f4 * f9;
/* 297 */       tessellator.func_78374_a(f4, f17, 0.0D, f2, f13);
/* 298 */       tessellator.func_78374_a(0.0D, f17, 0.0D, f, f13);
/* 299 */       tessellator.func_78374_a(0.0D, f17, 0.0F - f5, f, f13);
/* 300 */       tessellator.func_78374_a(f4, f17, 0.0F - f5, f2, f13);
/*     */     }
/*     */     
/* 303 */     tessellator.func_78381_a();
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/MFRenderCrossbow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */