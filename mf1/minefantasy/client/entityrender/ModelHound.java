/*     */ package minefantasy.client.entityrender;
/*     */ 
/*     */ import minefantasy.entity.EntityHound;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.util.MathHelper;
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
/*     */ public class ModelHound
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer WolfHead;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer Leg1;
/*     */   public ModelRenderer Leg2;
/*     */   public ModelRenderer Leg3;
/*     */   public ModelRenderer Leg4;
/*     */   ModelRenderer Tail;
/*     */   ModelRenderer Mane;
/*     */   ModelRenderer Collar;
/*     */   ModelRenderer Jaw;
/*     */   ModelRenderer Ear1;
/*     */   ModelRenderer Ear2;
/*     */   ModelRenderer Nose;
/*     */   
/*     */   public ModelHound()
/*     */   {
/*  38 */     this(0.0F);
/*     */   }
/*     */   
/*     */   public ModelHound(float scale) {
/*  42 */     float var1 = 0.0F;
/*  43 */     float var2 = 13.5F;
/*  44 */     this.field_78090_t = 64;
/*  45 */     this.field_78089_u = 32;
/*     */     
/*  47 */     this.Collar = new ModelRenderer(this, 20, 24);
/*  48 */     this.Collar.func_78790_a(-3.5F, -3.5F, 0.5F, 7, 7, 1, scale);
/*  49 */     this.Collar.func_78793_a(-1.0F, 12.5F, -7.0F);
/*  50 */     this.Collar.func_78787_b(64, 32);
/*  51 */     this.Collar.field_78809_i = true;
/*  52 */     setRotation(this.Collar, 0.0F, 0.0F, 0.0F);
/*  53 */     this.Body = new ModelRenderer(this, 38, 17);
/*  54 */     this.Body.func_78790_a(-4.0F, -2.0F, -3.0F, 6, 8, 7, scale);
/*  55 */     this.Body.func_78793_a(-1.0F, 15.0F, 3.0F);
/*  56 */     this.Body.func_78787_b(64, 32);
/*  57 */     this.Body.field_78809_i = true;
/*  58 */     setRotation(this.Body, 1.570796F, 0.0F, 0.0F);
/*  59 */     this.Mane = new ModelRenderer(this, 32, 0);
/*  60 */     this.Mane.func_78790_a(-4.0F, -3.0F, -4.0F, 8, 8, 8, scale);
/*  61 */     this.Mane.func_78793_a(0.0F, 14.0F, -3.0F);
/*  62 */     this.Mane.func_78787_b(64, 32);
/*  63 */     this.Mane.field_78809_i = true;
/*  64 */     setRotation(this.Mane, 1.570796F, 0.0F, 0.0F);
/*  65 */     this.Leg1 = new ModelRenderer(this, 0, 18);
/*  66 */     this.Leg1.func_78790_a(-3.0F, 0.0F, -2.0F, 3, 8, 3, scale);
/*  67 */     this.Leg1.func_78793_a(-1.5F, 16.0F, 7.0F);
/*  68 */     this.Leg1.func_78787_b(64, 32);
/*  69 */     this.Leg1.field_78809_i = true;
/*  70 */     setRotation(this.Leg1, 0.0F, 0.0F, 0.0F);
/*  71 */     this.Leg2 = new ModelRenderer(this, 0, 18);
/*  72 */     this.Leg2.func_78790_a(0.0F, 0.0F, -2.0F, 3, 8, 3, scale);
/*  73 */     this.Leg2.func_78793_a(-0.5F, 16.0F, 7.0F);
/*  74 */     this.Leg2.func_78787_b(64, 32);
/*  75 */     this.Leg2.field_78809_i = true;
/*  76 */     setRotation(this.Leg2, 0.0F, 0.0F, 0.0F);
/*  77 */     this.Leg3 = new ModelRenderer(this, 0, 18);
/*  78 */     this.Leg3.func_78790_a(-3.0F, 0.0F, -1.0F, 3, 8, 3, scale);
/*  79 */     this.Leg3.func_78793_a(-1.5F, 16.0F, -4.0F);
/*  80 */     this.Leg3.func_78787_b(64, 32);
/*  81 */     this.Leg3.field_78809_i = true;
/*  82 */     setRotation(this.Leg3, 0.0F, 0.0F, 0.0F);
/*  83 */     this.Leg4 = new ModelRenderer(this, 0, 18);
/*  84 */     this.Leg4.func_78790_a(0.0F, 0.0F, -1.0F, 3, 8, 3, scale);
/*  85 */     this.Leg4.func_78793_a(-0.5F, 16.0F, -4.0F);
/*  86 */     this.Leg4.func_78787_b(64, 32);
/*  87 */     this.Leg4.field_78809_i = true;
/*  88 */     setRotation(this.Leg4, 0.0F, 0.0F, 0.0F);
/*  89 */     this.Tail = new ModelRenderer(this, 12, 27);
/*  90 */     this.Tail.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 3, 2, scale);
/*  91 */     this.Tail.func_78793_a(-1.0F, 13.0F, 8.0F);
/*  92 */     this.Tail.func_78787_b(64, 32);
/*  93 */     this.Tail.field_78809_i = true;
/*  94 */     setRotation(this.Tail, 1.130069F, 0.0F, 0.0F);
/*  95 */     this.Ear1 = new ModelRenderer(this, 16, 11);
/*  96 */     this.Ear1.func_78790_a(-3.0F, -6.0F, 0.0F, 2, 5, 1, scale);
/*  97 */     this.Ear1.func_78793_a(-1.0F, 12.5F, -7.0F);
/*  98 */     this.Ear1.func_78787_b(64, 32);
/*  99 */     this.Ear1.field_78809_i = true;
/* 100 */     setRotation(this.Ear1, 0.0F, 0.0F, 0.0F);
/* 101 */     this.Ear2 = new ModelRenderer(this, 16, 11);
/* 102 */     this.Ear2.field_78809_i = true;
/* 103 */     this.Ear2.func_78790_a(1.0F, -6.0F, 0.0F, 2, 5, 1, scale);
/* 104 */     this.Ear2.func_78793_a(-1.0F, 12.5F, -7.0F);
/* 105 */     this.Ear2.func_78787_b(64, 32);
/* 106 */     this.Ear2.field_78809_i = true;
/* 107 */     setRotation(this.Ear2, 0.0F, 0.0F, 0.0F);
/* 108 */     this.Ear2.field_78809_i = false;
/* 109 */     this.Jaw = new ModelRenderer(this, 12, 17);
/* 110 */     this.Jaw.func_78790_a(-1.5F, 2.0F, -7.0F, 3, 1, 4, scale);
/* 111 */     this.Jaw.func_78793_a(-1.0F, 12.5F, -7.0F);
/* 112 */     this.Jaw.func_78787_b(64, 32);
/* 113 */     this.Jaw.field_78809_i = true;
/* 114 */     setRotation(this.Jaw, 0.0F, 0.0F, 0.0F);
/* 115 */     this.Nose = new ModelRenderer(this, 0, 11);
/* 116 */     this.Nose.func_78790_a(-1.5F, 0.0F, -7.0F, 3, 2, 4, scale);
/* 117 */     this.Nose.func_78793_a(-1.0F, 12.5F, -7.0F);
/* 118 */     this.Nose.func_78787_b(64, 32);
/* 119 */     this.Nose.field_78809_i = true;
/* 120 */     setRotation(this.Nose, 0.0F, 0.0F, 0.0F);
/* 121 */     this.WolfHead = new ModelRenderer(this, 0, 0);
/* 122 */     this.WolfHead.func_78790_a(-3.0F, -3.0F, -3.0F, 6, 6, 5, scale);
/* 123 */     this.WolfHead.func_78793_a(-1.0F, 12.5F, -7.0F);
/* 124 */     this.WolfHead.func_78787_b(64, 32);
/* 125 */     this.WolfHead.field_78809_i = true;
/* 126 */     setRotation(this.WolfHead, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 130 */     model.field_78795_f = x;
/* 131 */     model.field_78796_g = y;
/* 132 */     model.field_78808_h = z;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_78088_a(Entity entity, float f1, float f2, float f3, float f4, float f5, float f6)
/*     */   {
/* 140 */     super.func_78088_a(entity, f1, f2, f3, f4, f5, f6);
/* 141 */     EntityHound var5 = (EntityHound)entity;
/* 142 */     setRotationAngles(var5, f1, f2, f3, f4, f5, f6);
/* 143 */     if (this.field_78091_s) {
/* 144 */       float var8 = 2.0F;
/* 145 */       GL11.glPushMatrix();
/* 146 */       GL11.glTranslatef(0.0F, 5.0F * f6, 2.0F * f6);
/* 147 */       this.WolfHead.func_78791_b(f6);
/* 148 */       this.Collar.func_78791_b(f6);
/* 149 */       this.Ear1.func_78791_b(f6);
/* 150 */       this.Ear2.func_78791_b(f6);
/* 151 */       this.Jaw.func_78791_b(f6);
/* 152 */       this.Nose.func_78791_b(f6);
/* 153 */       GL11.glPopMatrix();
/* 154 */       GL11.glPushMatrix();
/* 155 */       GL11.glScalef(1.0F / var8, 1.0F / var8, 1.0F / var8);
/* 156 */       GL11.glTranslatef(0.0F, 24.0F * f6, 0.0F);
/* 157 */       this.Body.func_78785_a(f6);
/* 158 */       this.Leg1.func_78785_a(f6);
/* 159 */       this.Leg2.func_78785_a(f6);
/* 160 */       this.Leg3.func_78785_a(f6);
/* 161 */       this.Leg4.func_78785_a(f6);
/* 162 */       this.Tail.func_78791_b(f6);
/* 163 */       this.Mane.func_78785_a(f6);
/* 164 */       GL11.glPopMatrix();
/*     */     } else {
/* 166 */       this.WolfHead.func_78791_b(f6);
/* 167 */       this.Collar.func_78791_b(f6);
/* 168 */       this.Ear1.func_78791_b(f6);
/* 169 */       this.Ear2.func_78791_b(f6);
/* 170 */       this.Jaw.func_78791_b(f6);
/* 171 */       this.Nose.func_78791_b(f6);
/* 172 */       this.Body.func_78785_a(f6);
/* 173 */       this.Leg1.func_78785_a(f6);
/* 174 */       this.Leg2.func_78785_a(f6);
/* 175 */       this.Leg3.func_78785_a(f6);
/* 176 */       this.Leg4.func_78785_a(f6);
/* 177 */       this.Tail.func_78791_b(f6);
/* 178 */       this.Mane.func_78785_a(f6);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_78086_a(EntityLivingBase living, float step1, float step2, float z)
/*     */   {
/* 189 */     EntityHound var5 = (EntityHound)living;
/*     */     
/* 191 */     if (var5.isAngry()) {
/* 192 */       this.Tail.field_78796_g = 0.0F;
/*     */     } else {
/* 194 */       this.Tail.field_78796_g = (MathHelper.func_76134_b(step1 * 0.6662F) * 1.4F * step2);
/*     */     }
/*     */     
/* 197 */     if (var5.func_70906_o()) {
/* 198 */       float dig = 0.0F;
/* 199 */       this.Mane.func_78793_a(-1.0F, 16.0F, -3.0F);
/* 200 */       this.Mane.field_78795_f = 1.2566371F;
/* 201 */       this.Mane.field_78796_g = 0.0F;
/* 202 */       this.Body.func_78793_a(0.0F, 18.0F, 0.0F);
/* 203 */       this.Body.field_78795_f = 0.7853982F;
/* 204 */       this.Tail.func_78793_a(-1.0F, 21.0F, 6.0F);
/* 205 */       this.Leg1.func_78793_a(-2.5F, 22.0F, 2.0F);
/* 206 */       this.Leg1.field_78795_f = 4.712389F;
/* 207 */       this.Leg2.func_78793_a(0.5F, 22.0F, 2.0F);
/* 208 */       this.Leg2.field_78795_f = 4.712389F;
/* 209 */       this.Leg3.field_78795_f = (5.811947F + dig);
/* 210 */       this.Leg3.func_78793_a(-2.49F, 17.0F, -4.0F);
/* 211 */       this.Leg4.field_78795_f = (5.811947F - dig);
/* 212 */       this.Leg4.func_78793_a(0.51F, 17.0F, -4.0F);
/*     */     } else {
/* 214 */       this.Body.func_78793_a(0.0F, 14.0F, 2.0F);
/* 215 */       this.Body.field_78795_f = 1.5707964F;
/* 216 */       this.Mane.func_78793_a(-1.0F, 14.0F, -3.0F);
/* 217 */       this.Mane.field_78795_f = this.Body.field_78795_f;
/* 218 */       this.Tail.func_78793_a(-1.0F, 12.0F, 8.0F);
/* 219 */       this.Leg1.func_78793_a(-2.5F, 16.0F, 7.0F);
/* 220 */       this.Leg2.func_78793_a(0.5F, 16.0F, 7.0F);
/* 221 */       this.Leg3.func_78793_a(-2.5F, 16.0F, -4.0F);
/* 222 */       this.Leg4.func_78793_a(0.5F, 16.0F, -4.0F);
/*     */       
/* 224 */       this.Leg1.field_78795_f = (MathHelper.func_76134_b(step1 * 0.6662F) * 1.4F * step2);
/* 225 */       this.Leg2.field_78795_f = (MathHelper.func_76134_b(step1 * 0.6662F + 3.1415927F) * 1.4F * step2);
/* 226 */       this.Leg3.field_78795_f = (MathHelper.func_76134_b(step1 * 0.6662F + 3.1415927F) * 1.4F * step2);
/* 227 */       this.Leg4.field_78795_f = (MathHelper.func_76134_b(step1 * 0.6662F) * 1.4F * step2);
/*     */     }
/*     */     
/* 230 */     this.WolfHead.field_78808_h = (var5.getInterestedAngle(z) + var5.getShakeAngle(z, 0.0F));
/* 231 */     this.Collar.field_78808_h = (var5.getInterestedAngle(z) + var5.getShakeAngle(z, 0.0F));
/* 232 */     this.Ear1.field_78808_h = (var5.getInterestedAngle(z) + var5.getShakeAngle(z, 0.0F));
/* 233 */     this.Ear2.field_78808_h = (var5.getInterestedAngle(z) + var5.getShakeAngle(z, 0.0F));
/* 234 */     this.Jaw.field_78808_h = (var5.getInterestedAngle(z) + var5.getShakeAngle(z, 0.0F));
/* 235 */     this.Nose.field_78808_h = (var5.getInterestedAngle(z) + var5.getShakeAngle(z, 0.0F));
/* 236 */     this.Mane.field_78808_h = var5.getShakeAngle(z, -0.08F);
/* 237 */     this.Body.field_78808_h = var5.getShakeAngle(z, -0.16F);
/* 238 */     this.Tail.field_78808_h = var5.getShakeAngle(z, -0.2F);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRotationAngles(EntityHound wolf, float f1, float f2, float f3, float f4, float f5, float f6)
/*     */   {
/* 245 */     super.func_78087_a(f1, f2, f3, f4, f5, f6, wolf);
/* 246 */     int neck = wolf.eatAnimation;
/* 247 */     if (neck < -15) {
/* 248 */       neck = -15;
/*     */     }
/* 250 */     float neckAngle = f5 + 4.0F * neck;
/* 251 */     float jawAngle = neckAngle + 1.5F * wolf.jawMove;
/* 252 */     this.WolfHead.field_78795_f = (neckAngle / 57.295776F);
/* 253 */     this.WolfHead.field_78796_g = (f4 / 57.295776F);
/*     */     
/* 255 */     this.Collar.field_78795_f = (neckAngle / 57.295776F);
/* 256 */     this.Collar.field_78796_g = (f4 / 57.295776F);
/*     */     
/* 258 */     this.Ear1.field_78795_f = (neckAngle / 57.295776F);
/* 259 */     this.Ear1.field_78796_g = (f4 / 57.295776F);
/*     */     
/* 261 */     this.Ear2.field_78795_f = (neckAngle / 57.295776F);
/* 262 */     this.Ear2.field_78796_g = (f4 / 57.295776F);
/*     */     
/* 264 */     this.Jaw.field_78795_f = (jawAngle / 57.295776F);
/* 265 */     this.Jaw.field_78796_g = (f4 / 57.295776F);
/*     */     
/* 267 */     this.Nose.field_78795_f = (neckAngle / 57.295776F);
/* 268 */     this.Nose.field_78796_g = (f4 / 57.295776F);
/*     */     
/* 270 */     this.Tail.field_78795_f = f3;
/*     */   }
/*     */   
/*     */   private void rotateSleeping() {
/* 274 */     this.Leg1.field_78797_d = 23.0F;
/* 275 */     this.Leg2.field_78797_d = 23.0F;
/* 276 */     this.Leg3.field_78797_d = 23.0F;
/* 277 */     this.Leg4.field_78797_d = 23.0F;
/*     */     
/* 279 */     this.Leg1.field_78798_e = 9.0F;
/* 280 */     this.Leg2.field_78798_e = 9.0F;
/* 281 */     this.Leg3.field_78798_e = -1.0F;
/* 282 */     this.Leg4.field_78798_e = -1.0F;
/* 283 */     this.Leg1.field_78795_f = -1.5707964F;
/* 284 */     this.Leg2.field_78795_f = -1.5707964F;
/* 285 */     this.Leg3.field_78795_f = -1.5707964F;
/* 286 */     this.Leg4.field_78795_f = -1.5707964F;
/* 287 */     this.Body.field_78795_f = 1.0F;
/* 288 */     this.Mane.field_78795_f = 0.0F;
/* 289 */     this.Tail.field_78795_f = 0.0F;
/*     */     
/* 291 */     this.Body.field_78798_e = 5.0F;
/* 292 */     this.Collar.field_78797_d = 17.5F;
/* 293 */     this.Ear1.field_78797_d = 17.5F;
/* 294 */     this.Ear2.field_78797_d = 17.5F;
/* 295 */     this.WolfHead.field_78797_d = 17.5F;
/* 296 */     this.Nose.field_78797_d = 17.5F;
/* 297 */     this.Jaw.field_78797_d = 17.5F;
/*     */     
/* 299 */     this.WolfHead.field_78795_f = (this.Ear1.field_78795_f = this.Ear2.field_78795_f = this.Nose.field_78795_f = this.Collar.field_78795_f = this.Jaw.field_78795_f = 0.5F);
/* 300 */     this.WolfHead.field_78796_g = (this.Ear1.field_78796_g = this.Ear2.field_78796_g = this.Nose.field_78796_g = this.Collar.field_78796_g = this.Jaw.field_78796_g = 0.0F);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/entityrender/ModelHound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */