/*     */ package minefantasy.client.entityrender;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelBox;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.client.renderer.entity.RendererLivingEntity;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntityArrow;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.EventBus;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(cpw.mods.fml.relauncher.Side.CLIENT)
/*     */ public abstract class RendererLivingEntityMF extends RendererLivingEntity
/*     */ {
/*  30 */   private static final ResourceLocation RES_ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");
/*     */   
/*     */   protected ModelBase field_77045_g;
/*     */   
/*     */   protected ModelBase field_77046_h;
/*     */   
/*  36 */   public static float NAME_TAG_RANGE = 64.0F;
/*  37 */   public static float NAME_TAG_RANGE_SNEAK = 32.0F;
/*     */   
/*     */   public RendererLivingEntityMF(ModelBase base, float shadow) {
/*  40 */     super(base, shadow);
/*  41 */     this.field_77045_g = base;
/*  42 */     this.field_76989_e = shadow;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_77042_a(ModelBase par1ModelBase)
/*     */   {
/*  50 */     this.field_77046_h = par1ModelBase;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private float interpolateRotation(float par1, float par2, float par3)
/*     */   {
/*  63 */     for (float f3 = par2 - par1; f3 < -180.0F; f3 += 360.0F) {}
/*     */     
/*     */ 
/*     */ 
/*  67 */     while (f3 >= 180.0F) {
/*  68 */       f3 -= 360.0F;
/*     */     }
/*     */     
/*  71 */     return par1 + par3 * f3;
/*     */   }
/*     */   
/*     */   public void func_130000_a(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9) {
/*  75 */     if (MinecraftForge.EVENT_BUS.post(new net.minecraftforge.client.event.RenderLivingEvent.Pre(par1EntityLivingBase, this)))
/*  76 */       return;
/*  77 */     GL11.glPushMatrix();
/*  78 */     GL11.glDisable(2884);
/*  79 */     this.field_77045_g.field_78095_p = func_77040_d(par1EntityLivingBase, par9);
/*     */     
/*  81 */     if (this.field_77046_h != null) {
/*  82 */       this.field_77046_h.field_78095_p = this.field_77045_g.field_78095_p;
/*     */     }
/*     */     
/*  85 */     this.field_77045_g.field_78093_q = par1EntityLivingBase.func_70115_ae();
/*     */     
/*  87 */     if (this.field_77046_h != null) {
/*  88 */       this.field_77046_h.field_78093_q = this.field_77045_g.field_78093_q;
/*     */     }
/*     */     
/*  91 */     this.field_77045_g.field_78091_s = par1EntityLivingBase.func_70631_g_();
/*     */     
/*  93 */     if (this.field_77046_h != null) {
/*  94 */       this.field_77046_h.field_78091_s = this.field_77045_g.field_78091_s;
/*     */     }
/*     */     try
/*     */     {
/*  98 */       float f2 = interpolateRotation(par1EntityLivingBase.field_70760_ar, par1EntityLivingBase.field_70761_aq, par9);
/*  99 */       float f3 = interpolateRotation(par1EntityLivingBase.field_70758_at, par1EntityLivingBase.field_70759_as, par9);
/*     */       
/*     */ 
/* 102 */       if ((par1EntityLivingBase.func_70115_ae()) && ((par1EntityLivingBase.field_70154_o instanceof EntityLivingBase))) {
/* 103 */         EntityLivingBase entitylivingbase1 = (EntityLivingBase)par1EntityLivingBase.field_70154_o;
/* 104 */         f2 = interpolateRotation(entitylivingbase1.field_70760_ar, entitylivingbase1.field_70761_aq, par9);
/* 105 */         float f4 = MathHelper.func_76142_g(f3 - f2);
/*     */         
/* 107 */         if (f4 < -85.0F) {
/* 108 */           f4 = -85.0F;
/*     */         }
/*     */         
/* 111 */         if (f4 >= 85.0F) {
/* 112 */           f4 = 85.0F;
/*     */         }
/*     */         
/* 115 */         f2 = f3 - f4;
/*     */         
/* 117 */         if (f4 * f4 > 2500.0F) {
/* 118 */           f2 += f4 * 0.2F;
/*     */         }
/*     */       }
/*     */       
/* 122 */       float f5 = par1EntityLivingBase.field_70127_C + (par1EntityLivingBase.field_70125_A - par1EntityLivingBase.field_70127_C) * par9;
/* 123 */       func_77039_a(par1EntityLivingBase, par2, par4, par6);
/* 124 */       float f4 = func_77044_a(par1EntityLivingBase, par9);
/* 125 */       func_77043_a(par1EntityLivingBase, f4, f2, par9);
/* 126 */       float f6 = 0.0625F;
/* 127 */       GL11.glEnable(32826);
/* 128 */       GL11.glScalef(-1.0F, -1.0F, 1.0F);
/* 129 */       func_77041_b(par1EntityLivingBase, par9);
/* 130 */       GL11.glTranslatef(0.0F, -24.0F * f6 - 0.0078125F, 0.0F);
/* 131 */       float f7 = par1EntityLivingBase.field_70722_aY + (par1EntityLivingBase.field_70721_aZ - par1EntityLivingBase.field_70722_aY) * par9;
/* 132 */       float f8 = par1EntityLivingBase.field_70754_ba - par1EntityLivingBase.field_70721_aZ * (1.0F - par9);
/*     */       
/* 134 */       if (par1EntityLivingBase.func_70631_g_()) {
/* 135 */         f8 *= 3.0F;
/*     */       }
/*     */       
/* 138 */       if (f7 > 1.0F) {
/* 139 */         f7 = 1.0F;
/*     */       }
/*     */       
/* 142 */       GL11.glEnable(3008);
/* 143 */       this.field_77045_g.func_78086_a(par1EntityLivingBase, f8, f7, par9);
/* 144 */       func_77036_a(par1EntityLivingBase, f8, f7, f4, f3 - f2, f5, f6);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 150 */       for (int j = 0; j < getRenderPasses(); j++) {
/* 151 */         int i = func_77032_a(par1EntityLivingBase, j, par9);
/*     */         
/* 153 */         if (i > 0) {
/* 154 */           this.field_77046_h.func_78086_a(par1EntityLivingBase, f8, f7, par9);
/* 155 */           this.field_77046_h.func_78088_a(par1EntityLivingBase, f8, f7, f4, f3 - f2, f5, f6);
/*     */           
/* 157 */           if ((i & 0xF0) == 16) {
/* 158 */             func_82408_c(par1EntityLivingBase, j, par9);
/* 159 */             this.field_77046_h.func_78088_a(par1EntityLivingBase, f8, f7, f4, f3 - f2, f5, f6);
/*     */           }
/*     */           
/* 162 */           if ((i & 0xF) == 15) {
/* 163 */             float f9 = par1EntityLivingBase.field_70173_aa + par9;
/* 164 */             func_110776_a(RES_ITEM_GLINT);
/* 165 */             GL11.glEnable(3042);
/* 166 */             float f10 = 0.5F;
/* 167 */             GL11.glColor4f(f10, f10, f10, 1.0F);
/* 168 */             GL11.glDepthFunc(514);
/* 169 */             GL11.glDepthMask(false);
/*     */             
/* 171 */             for (int k = 0; k < 2; k++) {
/* 172 */               GL11.glDisable(2896);
/* 173 */               float f11 = 0.76F;
/* 174 */               GL11.glColor4f(0.5F * f11, 0.25F * f11, 0.8F * f11, 1.0F);
/* 175 */               GL11.glBlendFunc(768, 1);
/* 176 */               GL11.glMatrixMode(5890);
/* 177 */               GL11.glLoadIdentity();
/* 178 */               float f12 = f9 * (0.001F + k * 0.003F) * 20.0F;
/* 179 */               float f13 = 0.33333334F;
/* 180 */               GL11.glScalef(f13, f13, f13);
/* 181 */               GL11.glRotatef(30.0F - k * 60.0F, 0.0F, 0.0F, 1.0F);
/* 182 */               GL11.glTranslatef(0.0F, f12, 0.0F);
/* 183 */               GL11.glMatrixMode(5888);
/* 184 */               this.field_77046_h.func_78088_a(par1EntityLivingBase, f8, f7, f4, f3 - f2, f5, f6);
/*     */             }
/*     */             
/* 187 */             GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 188 */             GL11.glMatrixMode(5890);
/* 189 */             GL11.glDepthMask(true);
/* 190 */             GL11.glLoadIdentity();
/* 191 */             GL11.glMatrixMode(5888);
/* 192 */             GL11.glEnable(2896);
/* 193 */             GL11.glDisable(3042);
/* 194 */             GL11.glDepthFunc(515);
/*     */           }
/*     */           
/* 197 */           GL11.glDisable(3042);
/* 198 */           GL11.glEnable(3008);
/*     */         }
/*     */       }
/*     */       
/* 202 */       GL11.glDepthMask(true);
/* 203 */       func_77029_c(par1EntityLivingBase, par9);
/* 204 */       float f14 = par1EntityLivingBase.func_70013_c(par9);
/* 205 */       int i = func_77030_a(par1EntityLivingBase, f14, par9);
/* 206 */       OpenGlHelper.func_77473_a(OpenGlHelper.field_77476_b);
/* 207 */       GL11.glDisable(3553);
/* 208 */       OpenGlHelper.func_77473_a(OpenGlHelper.field_77478_a);
/*     */       
/* 210 */       if (((i >> 24 & 0xFF) > 0) || (par1EntityLivingBase.field_70737_aN > 0) || (par1EntityLivingBase.field_70725_aQ > 0)) {
/* 211 */         GL11.glDisable(3553);
/* 212 */         GL11.glDisable(3008);
/* 213 */         GL11.glEnable(3042);
/* 214 */         GL11.glBlendFunc(770, 771);
/* 215 */         GL11.glDepthFunc(514);
/*     */         
/* 217 */         if ((par1EntityLivingBase.field_70737_aN > 0) || (par1EntityLivingBase.field_70725_aQ > 0)) {
/* 218 */           GL11.glColor4f(f14, 0.0F, 0.0F, 0.4F);
/* 219 */           this.field_77045_g.func_78088_a(par1EntityLivingBase, f8, f7, f4, f3 - f2, f5, f6);
/*     */           
/* 221 */           for (int l = 0; l < getRenderPasses(); l++) {
/* 222 */             if (func_77035_b(par1EntityLivingBase, l, par9) >= 0) {
/* 223 */               GL11.glColor4f(f14, 0.0F, 0.0F, 0.4F);
/* 224 */               this.field_77046_h.func_78088_a(par1EntityLivingBase, f8, f7, f4, f3 - f2, f5, f6);
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 229 */         if ((i >> 24 & 0xFF) > 0) {
/* 230 */           float f9 = (i >> 16 & 0xFF) / 255.0F;
/* 231 */           float f10 = (i >> 8 & 0xFF) / 255.0F;
/* 232 */           float f15 = (i & 0xFF) / 255.0F;
/* 233 */           float f11 = (i >> 24 & 0xFF) / 255.0F;
/* 234 */           GL11.glColor4f(f9, f10, f15, f11);
/* 235 */           this.field_77045_g.func_78088_a(par1EntityLivingBase, f8, f7, f4, f3 - f2, f5, f6);
/*     */           
/* 237 */           for (int i1 = 0; i1 < getRenderPasses(); i1++) {
/* 238 */             if (func_77035_b(par1EntityLivingBase, i1, par9) >= 0) {
/* 239 */               GL11.glColor4f(f9, f10, f15, f11);
/* 240 */               this.field_77046_h.func_78088_a(par1EntityLivingBase, f8, f7, f4, f3 - f2, f5, f6);
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 245 */         GL11.glDepthFunc(515);
/* 246 */         GL11.glDisable(3042);
/* 247 */         GL11.glEnable(3008);
/* 248 */         GL11.glEnable(3553);
/*     */       }
/*     */       
/* 251 */       GL11.glDisable(32826);
/*     */     } catch (Exception exception) {
/* 253 */       exception.printStackTrace();
/*     */     }
/*     */     
/* 256 */     OpenGlHelper.func_77473_a(OpenGlHelper.field_77476_b);
/* 257 */     GL11.glEnable(3553);
/* 258 */     OpenGlHelper.func_77473_a(OpenGlHelper.field_77478_a);
/* 259 */     GL11.glEnable(2884);
/* 260 */     GL11.glPopMatrix();
/* 261 */     func_77033_b(par1EntityLivingBase, par2, par4, par6);
/* 262 */     MinecraftForge.EVENT_BUS.post(new net.minecraftforge.client.event.RenderLivingEvent.Post(par1EntityLivingBase, this));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void func_77036_a(EntityLivingBase living, float par2, float par3, float par4, float par5, float par6, float par7)
/*     */   {
/* 269 */     func_110777_b(living);
/*     */     
/* 271 */     if (!living.func_82150_aj()) {
/* 272 */       this.field_77045_g.func_78088_a(living, par2, par3, par4, par5, par6, par7);
/* 273 */     } else if (!living.func_98034_c(Minecraft.func_71410_x().field_71439_g)) {
/* 274 */       GL11.glPushMatrix();
/* 275 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.15F);
/* 276 */       GL11.glDepthMask(false);
/* 277 */       GL11.glEnable(3042);
/* 278 */       GL11.glBlendFunc(770, 771);
/* 279 */       GL11.glAlphaFunc(516, 0.003921569F);
/* 280 */       this.field_77045_g.func_78088_a(living, par2, par3, par4, par5, par6, par7);
/* 281 */       GL11.glDisable(3042);
/* 282 */       GL11.glAlphaFunc(516, 0.1F);
/* 283 */       GL11.glPopMatrix();
/* 284 */       GL11.glDepthMask(true);
/*     */     } else {
/* 286 */       this.field_77045_g.func_78087_a(par2, par3, par4, par5, par6, par7, living);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void func_77039_a(EntityLivingBase living, double x, double y, double z)
/*     */   {
/* 294 */     GL11.glTranslatef((float)x, (float)y, (float)z);
/*     */   }
/*     */   
/*     */   protected void func_77043_a(EntityLivingBase living, float x, float y, float z) {
/* 298 */     GL11.glRotatef(180.0F - y, 0.0F, 1.0F, 0.0F);
/*     */     
/* 300 */     if (living.field_70725_aQ > 0) {
/* 301 */       float f3 = (living.field_70725_aQ + z - 1.0F) / 20.0F * 1.6F;
/* 302 */       f3 = MathHelper.func_76129_c(f3);
/*     */       
/* 304 */       if (f3 > 1.0F) {
/* 305 */         f3 = 1.0F;
/*     */       }
/*     */       
/* 308 */       GL11.glRotatef(f3 * func_77037_a(living), 0.0F, 0.0F, 1.0F);
/*     */     } else {
/* 310 */       String s = EnumChatFormatting.func_110646_a(living.func_70023_ak());
/*     */       
/* 312 */       if (((s.equals("Dinnerbone")) || (s.equals("Grumm"))) && ((!(living instanceof EntityPlayer)) || (!((EntityPlayer)living).func_82238_cc()))) {
/* 313 */         GL11.glTranslatef(0.0F, living.field_70131_O + 0.1F, 0.0F);
/* 314 */         GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   protected float func_77040_d(EntityLivingBase living, float f) {
/* 320 */     return living.func_70678_g(f);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected float func_77044_a(EntityLivingBase living, float f)
/*     */   {
/* 327 */     return living.field_70173_aa + f;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void func_77029_c(EntityLivingBase living, float f) {}
/*     */   
/*     */ 
/*     */   protected void func_85093_e(EntityLivingBase living, float f)
/*     */   {
/* 337 */     int i = living.func_85035_bI();
/*     */     
/* 339 */     if (i > 0) {
/* 340 */       EntityArrow entityarrow = new EntityArrow(living.field_70170_p, living.field_70165_t, living.field_70163_u, living.field_70161_v);
/* 341 */       Random random = new Random(living.field_70157_k);
/* 342 */       RenderHelper.func_74518_a();
/*     */       
/* 344 */       for (int j = 0; j < i; j++) {
/* 345 */         GL11.glPushMatrix();
/* 346 */         ModelRenderer modelrenderer = this.field_77045_g.func_85181_a(random);
/* 347 */         ModelBox modelbox = (ModelBox)modelrenderer.field_78804_l.get(random.nextInt(modelrenderer.field_78804_l.size()));
/* 348 */         modelrenderer.func_78794_c(0.0625F);
/* 349 */         float f1 = random.nextFloat();
/* 350 */         float f2 = random.nextFloat();
/* 351 */         float f3 = random.nextFloat();
/* 352 */         float f4 = (modelbox.field_78252_a + (modelbox.field_78248_d - modelbox.field_78252_a) * f1) / 16.0F;
/* 353 */         float f5 = (modelbox.field_78250_b + (modelbox.field_78249_e - modelbox.field_78250_b) * f2) / 16.0F;
/* 354 */         float f6 = (modelbox.field_78251_c + (modelbox.field_78246_f - modelbox.field_78251_c) * f3) / 16.0F;
/* 355 */         GL11.glTranslatef(f4, f5, f6);
/* 356 */         f1 = f1 * 2.0F - 1.0F;
/* 357 */         f2 = f2 * 2.0F - 1.0F;
/* 358 */         f3 = f3 * 2.0F - 1.0F;
/* 359 */         f1 *= -1.0F;
/* 360 */         f2 *= -1.0F;
/* 361 */         f3 *= -1.0F;
/* 362 */         float f7 = MathHelper.func_76129_c(f1 * f1 + f3 * f3);
/* 363 */         entityarrow.field_70126_B = (entityarrow.field_70177_z = (float)(Math.atan2(f1, f3) * 180.0D / 3.141592653589793D));
/* 364 */         entityarrow.field_70127_C = (entityarrow.field_70125_A = (float)(Math.atan2(f2, f7) * 180.0D / 3.141592653589793D));
/* 365 */         double d0 = 0.0D;
/* 366 */         double d1 = 0.0D;
/* 367 */         double d2 = 0.0D;
/* 368 */         float f8 = 0.0F;
/* 369 */         this.field_76990_c.func_78719_a(entityarrow, d0, d1, d2, f8, f);
/* 370 */         GL11.glPopMatrix();
/*     */       }
/*     */       
/* 373 */       RenderHelper.func_74519_b();
/*     */     }
/*     */   }
/*     */   
/*     */   protected int func_77035_b(EntityLivingBase living, int pass, float f) {
/* 378 */     return func_77032_a(living, pass, f);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected int func_77032_a(EntityLivingBase living, int pass, float f)
/*     */   {
/* 385 */     return -1;
/*     */   }
/*     */   
/*     */   protected void func_82408_c(EntityLivingBase par1EntityLivingBase, int par2, float par3) {}
/*     */   
/*     */   protected float func_77037_a(EntityLivingBase living)
/*     */   {
/* 392 */     return 90.0F;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected int func_77030_a(EntityLivingBase living, float f, float f1)
/*     */   {
/* 400 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void func_77041_b(EntityLivingBase living, float f) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void func_77033_b(EntityLivingBase living, double x, double y, double z)
/*     */   {
/* 414 */     if (MinecraftForge.EVENT_BUS.post(new net.minecraftforge.client.event.RenderLivingEvent.Specials.Pre(living, this)))
/* 415 */       return;
/* 416 */     if (func_110813_b(living)) {
/* 417 */       float f = 1.6F;
/* 418 */       float f1 = 0.016666668F * f;
/* 419 */       double d3 = living.func_70068_e(this.field_76990_c.field_78734_h);
/* 420 */       float f2 = living.func_70093_af() ? NAME_TAG_RANGE_SNEAK : NAME_TAG_RANGE;
/*     */       
/* 422 */       if (d3 < f2 * f2) {
/* 423 */         String s = living.func_96090_ax();
/*     */         
/* 425 */         if (living.func_70093_af()) {
/* 426 */           FontRenderer fontrenderer = func_76983_a();
/* 427 */           GL11.glPushMatrix();
/* 428 */           GL11.glTranslatef((float)x + 0.0F, (float)y + living.field_70131_O + 0.5F, (float)z);
/* 429 */           GL11.glNormal3f(0.0F, 1.0F, 0.0F);
/* 430 */           GL11.glRotatef(-this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
/* 431 */           GL11.glRotatef(this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
/* 432 */           GL11.glScalef(-f1, -f1, f1);
/* 433 */           GL11.glDisable(2896);
/* 434 */           GL11.glTranslatef(0.0F, 0.25F / f1, 0.0F);
/* 435 */           GL11.glDepthMask(false);
/* 436 */           GL11.glEnable(3042);
/* 437 */           GL11.glBlendFunc(770, 771);
/* 438 */           Tessellator tessellator = Tessellator.field_78398_a;
/* 439 */           GL11.glDisable(3553);
/* 440 */           tessellator.func_78382_b();
/* 441 */           int i = fontrenderer.func_78256_a(s) / 2;
/* 442 */           tessellator.func_78369_a(0.0F, 0.0F, 0.0F, 0.25F);
/* 443 */           tessellator.func_78377_a(-i - 1, -1.0D, 0.0D);
/* 444 */           tessellator.func_78377_a(-i - 1, 8.0D, 0.0D);
/* 445 */           tessellator.func_78377_a(i + 1, 8.0D, 0.0D);
/* 446 */           tessellator.func_78377_a(i + 1, -1.0D, 0.0D);
/* 447 */           tessellator.func_78381_a();
/* 448 */           GL11.glEnable(3553);
/* 449 */           GL11.glDepthMask(true);
/* 450 */           fontrenderer.func_78276_b(s, -fontrenderer.func_78256_a(s) / 2, 0, 553648127);
/* 451 */           GL11.glEnable(2896);
/* 452 */           GL11.glDisable(3042);
/* 453 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 454 */           GL11.glPopMatrix();
/*     */         } else {
/* 456 */           func_96449_a(living, x, y, z, s, f1, d3);
/*     */         }
/*     */       }
/*     */     }
/* 460 */     MinecraftForge.EVENT_BUS.post(new net.minecraftforge.client.event.RenderLivingEvent.Specials.Post(living, this));
/*     */   }
/*     */   
/*     */   protected boolean func_110813_b(EntityLivingBase par1EntityLivingBase) {
/* 464 */     return (Minecraft.func_71382_s()) && (par1EntityLivingBase != this.field_76990_c.field_78734_h) && (!par1EntityLivingBase.func_98034_c(Minecraft.func_71410_x().field_71439_g)) && (par1EntityLivingBase.field_70153_n == null);
/*     */   }
/*     */   
/*     */   protected void func_96449_a(EntityLivingBase living, double x, double y, double z, String name, float f, double d) {
/* 468 */     if (living.func_70608_bn()) {
/* 469 */       func_77038_a(living, name, x, y - 1.5D, z, 64);
/*     */     } else {
/* 471 */       func_77038_a(living, name, x, y, z, 64);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void func_77038_a(EntityLivingBase living, String name, double x, double y, double z, int size)
/*     */   {
/* 479 */     double d3 = living.func_70068_e(this.field_76990_c.field_78734_h);
/*     */     
/* 481 */     if (d3 <= size * size) {
/* 482 */       FontRenderer fontrenderer = func_76983_a();
/* 483 */       float f = 1.6F;
/* 484 */       float f1 = 0.016666668F * f;
/* 485 */       GL11.glPushMatrix();
/* 486 */       GL11.glTranslatef((float)x + 0.0F, (float)y + living.field_70131_O + 0.5F, (float)z);
/* 487 */       GL11.glNormal3f(0.0F, 1.0F, 0.0F);
/* 488 */       GL11.glRotatef(-this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
/* 489 */       GL11.glRotatef(this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
/* 490 */       GL11.glScalef(-f1, -f1, f1);
/* 491 */       GL11.glDisable(2896);
/* 492 */       GL11.glDepthMask(false);
/* 493 */       GL11.glDisable(2929);
/* 494 */       GL11.glEnable(3042);
/* 495 */       GL11.glBlendFunc(770, 771);
/* 496 */       Tessellator tessellator = Tessellator.field_78398_a;
/* 497 */       byte b0 = 0;
/*     */       
/* 499 */       if (name.equals("deadmau5")) {
/* 500 */         b0 = -10;
/*     */       }
/*     */       
/* 503 */       GL11.glDisable(3553);
/* 504 */       tessellator.func_78382_b();
/* 505 */       int j = fontrenderer.func_78256_a(name) / 2;
/* 506 */       tessellator.func_78369_a(0.0F, 0.0F, 0.0F, 0.25F);
/* 507 */       tessellator.func_78377_a(-j - 1, -1 + b0, 0.0D);
/* 508 */       tessellator.func_78377_a(-j - 1, 8 + b0, 0.0D);
/* 509 */       tessellator.func_78377_a(j + 1, 8 + b0, 0.0D);
/* 510 */       tessellator.func_78377_a(j + 1, -1 + b0, 0.0D);
/* 511 */       tessellator.func_78381_a();
/* 512 */       GL11.glEnable(3553);
/* 513 */       fontrenderer.func_78276_b(name, -fontrenderer.func_78256_a(name) / 2, b0, 553648127);
/* 514 */       GL11.glEnable(2929);
/* 515 */       GL11.glDepthMask(true);
/* 516 */       fontrenderer.func_78276_b(name, -fontrenderer.func_78256_a(name) / 2, b0, -1);
/* 517 */       GL11.glEnable(2896);
/* 518 */       GL11.glDisable(3042);
/* 519 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 520 */       GL11.glPopMatrix();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_76986_a(Entity entity, double x, double y, double z, float f, float f1)
/*     */   {
/* 533 */     func_130000_a((EntityLivingBase)entity, x, y, z, f, f1);
/*     */   }
/*     */   
/*     */   public int getRenderPasses() {
/* 537 */     return 4;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/entityrender/RendererLivingEntityMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */