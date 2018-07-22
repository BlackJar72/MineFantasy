/*     */ package minefantasy.client.entityrender;
/*     */ 
/*     */ import minefantasy.entity.EntityDragonSmall;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelSmallDragon extends ModelBase
/*     */ {
/*     */   ModelRenderer footBL;
/*     */   ModelRenderer legBL;
/*     */   ModelRenderer legFR;
/*     */   ModelRenderer footBR;
/*     */   ModelRenderer legBR;
/*     */   ModelRenderer thighBR;
/*     */   ModelRenderer mouth;
/*     */   ModelRenderer tail2;
/*     */   ModelRenderer neck;
/*     */   ModelRenderer horn2;
/*     */   ModelRenderer nose;
/*     */   ModelRenderer horn1;
/*     */   ModelRenderer head;
/*     */   ModelRenderer thighBL;
/*     */   ModelRenderer legFL;
/*     */   ModelRenderer wing2L;
/*     */   ModelRenderer tail1;
/*     */   ModelRenderer body;
/*     */   ModelRenderer wing2R;
/*     */   ModelRenderer wingCR;
/*     */   ModelRenderer wingCL;
/*     */   ModelRenderer wing1L;
/*     */   ModelRenderer wing1R;
/*     */   
/*     */   public ModelSmallDragon()
/*     */   {
/*  37 */     this.field_78090_t = 128;
/*  38 */     this.field_78089_u = 128;
/*     */     
/*  40 */     this.footBL = new ModelRenderer(this, 102, 29);
/*  41 */     this.legBL = new ModelRenderer(this, 108, 16);
/*  42 */     this.legFR = new ModelRenderer(this, 86, 0);
/*  43 */     this.footBR = new ModelRenderer(this, 102, 29);
/*  44 */     this.legBR = new ModelRenderer(this, 108, 16);
/*  45 */     this.thighBR = new ModelRenderer(this, 102, 0);
/*  46 */     this.mouth = new ModelRenderer(this, 0, 64);
/*  47 */     this.tail2 = new ModelRenderer(this, 0, 106);
/*  48 */     this.neck = new ModelRenderer(this, 52, 46);
/*  49 */     this.wing1R = new ModelRenderer(this, 0, 84);
/*  50 */     this.wing1L = new ModelRenderer(this, 0, 84);
/*  51 */     this.wingCL = new ModelRenderer(this, 48, 103);
/*  52 */     this.wingCR = new ModelRenderer(this, 48, 103);
/*  53 */     this.tail1 = new ModelRenderer(this, 47, 19);
/*  54 */     this.wing2L = new ModelRenderer(this, 0, 88);
/*  55 */     this.legFL = new ModelRenderer(this, 86, 0);
/*  56 */     this.thighBL = new ModelRenderer(this, 102, 0);
/*  57 */     this.head = new ModelRenderer(this, 24, 48);
/*  58 */     this.horn1 = new ModelRenderer(this, 104, 52);
/*  59 */     this.nose = new ModelRenderer(this, 0, 74);
/*  60 */     this.horn2 = new ModelRenderer(this, 104, 52);
/*  61 */     this.wing2R = new ModelRenderer(this, 0, 88);
/*     */     
/*  63 */     this.footBL.func_78789_a(-3.0F, 8.0F, -6.0F, 5, 1, 8);
/*  64 */     this.footBL.func_78793_a(6.0F, 15.0F, 8.0F);
/*  65 */     this.footBL.func_78787_b(128, 128);
/*  66 */     this.footBL.field_78809_i = true;
/*  67 */     setRotation(this.footBL, 0.0F, 0.0F, 0.0F);
/*  68 */     this.footBL.field_78809_i = false;
/*  69 */     this.legBL.field_78809_i = true;
/*     */     
/*  71 */     this.legBL.func_78789_a(-3.0F, 0.0F, -2.0F, 5, 8, 5);
/*  72 */     this.legBL.func_78793_a(6.0F, 15.0F, 8.0F);
/*  73 */     this.legBL.func_78787_b(128, 128);
/*  74 */     this.legBL.field_78809_i = true;
/*  75 */     setRotation(this.legBL, 0.0F, 0.0F, 0.0F);
/*  76 */     this.legBL.field_78809_i = false;
/*     */     
/*  78 */     this.legFR.func_78789_a(0.0F, -2.0F, -2.0F, 4, 12, 4);
/*  79 */     this.legFR.func_78793_a(-6.0F, 14.0F, -4.0F);
/*  80 */     this.legFR.func_78787_b(128, 128);
/*  81 */     this.legFR.field_78809_i = true;
/*  82 */     setRotation(this.legFR, 0.0F, 0.0F, 0.0F);
/*     */     
/*  84 */     this.footBR.func_78789_a(-2.0F, 8.0F, -6.0F, 5, 1, 8);
/*  85 */     this.footBR.func_78793_a(-6.0F, 15.0F, 8.0F);
/*  86 */     this.footBR.func_78787_b(128, 128);
/*  87 */     this.footBR.field_78809_i = true;
/*  88 */     setRotation(this.footBR, 0.0F, 0.0F, 0.0F);
/*     */     
/*  90 */     this.legBR.func_78789_a(-2.0F, 0.0F, -2.0F, 5, 8, 5);
/*  91 */     this.legBR.func_78793_a(-6.0F, 15.0F, 8.0F);
/*  92 */     this.legBR.func_78787_b(128, 128);
/*  93 */     this.legBR.field_78809_i = true;
/*  94 */     setRotation(this.legBR, 0.0F, 0.0F, 0.0F);
/*     */     
/*  96 */     this.thighBR.func_78789_a(-2.0F, -8.0F, -4.0F, 5, 8, 8);
/*  97 */     this.thighBR.func_78793_a(-6.0F, 15.0F, 8.0F);
/*  98 */     this.thighBR.func_78787_b(128, 128);
/*  99 */     this.thighBR.field_78809_i = true;
/* 100 */     setRotation(this.thighBR, 0.0F, 0.0F, 0.0F);
/*     */     
/* 102 */     this.mouth.func_78789_a(-1.5F, 1.0F, -14.0F, 3, 1, 7);
/* 103 */     this.mouth.func_78793_a(0.0F, 6.0F, -14.0F);
/* 104 */     this.mouth.func_78787_b(128, 128);
/* 105 */     this.mouth.field_78809_i = true;
/* 106 */     setRotation(this.mouth, 0.0F, 0.0F, 0.0F);
/*     */     
/* 108 */     this.tail2.func_78789_a(-2.0F, 2.0F, 12.0F, 4, 4, 18);
/* 109 */     this.tail2.func_78793_a(0.0F, 13.0F, 14.0F);
/* 110 */     this.tail2.func_78787_b(128, 128);
/* 111 */     this.tail2.field_78809_i = true;
/* 112 */     setRotation(this.tail2, -0.0174533F, 0.0F, 0.0F);
/*     */     
/* 114 */     this.neck.func_78789_a(-3.0F, -3.0F, -14.0F, 6, 8, 10);
/* 115 */     this.neck.func_78793_a(0.0F, 7.0F, 0.0F);
/* 116 */     this.neck.func_78787_b(128, 128);
/* 117 */     this.neck.field_78809_i = true;
/* 118 */     setRotation(this.neck, -0.122173F, 0.0F, 0.0F);
/* 119 */     this.horn2.field_78809_i = true;
/*     */     
/* 121 */     this.horn2.func_78789_a(3.0F, -6.0F, -3.0F, 1, 1, 11);
/* 122 */     this.horn2.func_78793_a(0.0F, 6.0F, -14.0F);
/* 123 */     this.horn2.func_78787_b(128, 128);
/* 124 */     this.horn2.field_78809_i = true;
/* 125 */     setRotation(this.horn2, 0.6108652F, 0.0F, 0.0F);
/* 126 */     this.horn2.field_78809_i = false;
/*     */     
/* 128 */     this.nose.func_78789_a(-2.0F, 2.0F, -15.0F, 4, 2, 8);
/* 129 */     this.nose.func_78793_a(0.0F, 6.0F, -14.0F);
/* 130 */     this.nose.func_78787_b(128, 128);
/* 131 */     this.nose.field_78809_i = true;
/* 132 */     setRotation(this.nose, 0.0F, 0.0F, 0.0F);
/*     */     
/* 134 */     this.horn1.func_78789_a(-4.0F, -6.0F, -3.0F, 1, 1, 11);
/* 135 */     this.horn1.func_78793_a(0.0F, 6.0F, -14.0F);
/* 136 */     this.horn1.func_78787_b(128, 128);
/* 137 */     this.horn1.field_78809_i = true;
/* 138 */     setRotation(this.horn1, 0.6108652F, 0.0F, 0.0F);
/*     */     
/* 140 */     this.head.func_78789_a(-3.0F, -4.0F, -7.0F, 6, 8, 8);
/* 141 */     this.head.func_78793_a(0.0F, 6.0F, -14.0F);
/* 142 */     this.head.func_78787_b(128, 128);
/* 143 */     this.head.field_78809_i = true;
/* 144 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/* 145 */     this.thighBL.field_78809_i = true;
/*     */     
/* 147 */     this.thighBL.func_78789_a(-3.0F, -8.0F, -4.0F, 5, 8, 8);
/* 148 */     this.thighBL.func_78793_a(6.0F, 15.0F, 8.0F);
/* 149 */     this.thighBL.func_78787_b(128, 128);
/* 150 */     this.thighBL.field_78809_i = true;
/* 151 */     setRotation(this.thighBL, 0.0F, 0.0F, 0.0F);
/* 152 */     this.thighBL.field_78809_i = false;
/* 153 */     this.legFL.field_78809_i = true;
/*     */     
/* 155 */     this.legFL.func_78789_a(-4.0F, -2.0F, -2.0F, 4, 12, 4);
/* 156 */     this.legFL.func_78793_a(6.0F, 14.0F, -4.0F);
/* 157 */     this.legFL.func_78787_b(128, 128);
/* 158 */     this.legFL.field_78809_i = true;
/* 159 */     setRotation(this.legFL, 0.0F, 0.0F, 0.0F);
/* 160 */     this.legFL.field_78809_i = false;
/* 161 */     this.wing2L.field_78809_i = true;
/*     */     
/* 163 */     this.wing2L.func_78789_a(13.0F, -1.0F, 1.0F, 2, 2, 16);
/* 164 */     this.wing2L.func_78793_a(5.0F, 4.0F, -2.0F);
/* 165 */     this.wing2L.func_78787_b(128, 128);
/* 166 */     this.wing2L.field_78809_i = true;
/* 167 */     setRotation(this.wing2L, 0.0F, 0.5235988F, -0.3490659F);
/* 168 */     this.wing2L.field_78809_i = false;
/*     */     
/* 170 */     this.tail1.func_78789_a(-3.0F, -2.0F, -1.0F, 6, 7, 14);
/* 171 */     this.tail1.func_78793_a(0.0F, 13.0F, 14.0F);
/* 172 */     this.tail1.func_78787_b(128, 128);
/* 173 */     this.tail1.field_78809_i = true;
/* 174 */     setRotation(this.tail1, -0.1745329F, 0.0F, 0.0F);
/* 175 */     this.body = new ModelRenderer(this, 0, 0);
/* 176 */     this.body.func_78789_a(-5.0F, -4.0F, -5.0F, 10, 12, 20);
/* 177 */     this.body.func_78793_a(0.0F, 7.0F, 0.0F);
/* 178 */     this.body.func_78787_b(128, 128);
/* 179 */     this.body.field_78809_i = true;
/* 180 */     setRotation(this.body, -0.296706F, 0.0F, 0.0F);
/*     */     
/* 182 */     this.wing2R.func_78789_a(-15.0F, -1.0F, 1.0F, 2, 2, 16);
/* 183 */     this.wing2R.func_78793_a(-5.0F, 4.0F, -2.0F);
/* 184 */     this.wing2R.func_78787_b(128, 128);
/* 185 */     this.wing2R.field_78809_i = true;
/* 186 */     setRotation(this.wing2R, 0.0F, -0.5235988F, 0.3490659F);
/*     */     
/* 188 */     this.wingCR.func_78789_a(-13.0F, -1.0F, 1.0F, 16, 1, 24);
/* 189 */     this.wingCR.func_78793_a(-5.0F, 4.0F, -2.0F);
/* 190 */     this.wingCR.func_78787_b(128, 128);
/* 191 */     this.wingCR.field_78809_i = true;
/* 192 */     setRotation(this.wingCR, 0.0F, -0.5235988F, 0.3490659F);
/* 193 */     this.wingCL.field_78809_i = true;
/*     */     
/* 195 */     this.wingCL.func_78789_a(-3.0F, -1.0F, 1.0F, 16, 1, 24);
/* 196 */     this.wingCL.func_78793_a(5.0F, 4.0F, -2.0F);
/* 197 */     this.wingCL.func_78787_b(128, 128);
/* 198 */     this.wingCL.field_78809_i = true;
/* 199 */     setRotation(this.wingCL, 0.0F, 0.5235988F, -0.3490659F);
/* 200 */     this.wingCL.field_78809_i = false;
/* 201 */     this.wing1L.field_78809_i = true;
/*     */     
/* 203 */     this.wing1L.func_78789_a(-1.0F, -1.0F, -1.0F, 16, 2, 2);
/* 204 */     this.wing1L.func_78793_a(5.0F, 4.0F, -2.0F);
/* 205 */     this.wing1L.func_78787_b(128, 128);
/* 206 */     this.wing1L.field_78809_i = true;
/* 207 */     setRotation(this.wing1L, 0.0F, 0.5235988F, -0.3490659F);
/* 208 */     this.wing1L.field_78809_i = false;
/*     */     
/* 210 */     this.wing1R.func_78789_a(-15.0F, -1.0F, -1.0F, 16, 2, 2);
/* 211 */     this.wing1R.func_78793_a(-5.0F, 4.0F, -2.0F);
/* 212 */     this.wing1R.func_78787_b(128, 128);
/* 213 */     this.wing1R.field_78809_i = true;
/* 214 */     setRotation(this.wing1R, 0.0F, -0.5235988F, 0.3490659F);
/* 215 */     this.mouth.func_78784_a(0, 55).func_78789_a(-1.5F, 2.0F, -14.0F, 3, 2, 7);
/* 216 */     this.mouth.func_78793_a(0.0F, 6.0F, -14.0F);
/* 217 */     this.mouth.func_78787_b(128, 128);
/* 218 */     this.mouth.field_78809_i = true;
/* 219 */     setRotation(this.mouth, 0.0F, 0.0F, 0.0F);
/* 220 */     this.nose.func_78784_a(0, 43).func_78789_a(-2.0F, -2.0F, -15.0F, 4, 4, 8);
/* 221 */     this.nose.func_78793_a(0.0F, 6.0F, -14.0F);
/* 222 */     this.nose.func_78787_b(128, 128);
/* 223 */     this.nose.field_78809_i = true;
/* 224 */     setRotation(this.nose, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 228 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/* 229 */     setRotationAngles((EntityDragonSmall)entity, f, f1, f2, f3, f4, f5);
/* 230 */     this.footBL.func_78785_a(f5);
/* 231 */     this.legBL.func_78785_a(f5);
/* 232 */     this.legFR.func_78785_a(f5);
/* 233 */     this.footBR.func_78785_a(f5);
/* 234 */     this.legBR.func_78785_a(f5);
/* 235 */     this.thighBR.func_78785_a(f5);
/* 236 */     this.tail2.func_78785_a(f5);
/* 237 */     this.neck.func_78785_a(f5);
/* 238 */     this.horn2.func_78785_a(f5);
/* 239 */     this.horn1.func_78785_a(f5);
/* 240 */     this.head.func_78785_a(f5);
/* 241 */     this.thighBL.func_78785_a(f5);
/* 242 */     this.legFL.func_78785_a(f5);
/* 243 */     this.wing2L.func_78785_a(f5);
/* 244 */     this.tail1.func_78785_a(f5);
/* 245 */     this.body.func_78785_a(f5);
/* 246 */     this.wing2R.func_78785_a(f5);
/* 247 */     this.wingCR.func_78785_a(f5);
/* 248 */     this.wingCL.func_78785_a(f5);
/* 249 */     this.wing1L.func_78785_a(f5);
/* 250 */     this.wing1R.func_78785_a(f5);
/* 251 */     this.mouth.func_78785_a(f5);
/* 252 */     this.nose.func_78785_a(f5);
/*     */   }
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 256 */     model.field_78795_f = x;
/* 257 */     model.field_78796_g = y;
/* 258 */     model.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void setRotationAngles(EntityDragonSmall dragon, float step1, float step2, float head1, float head2, float head3, float head4) {
/* 262 */     super.func_78087_a(step1, step2, head1, head2, head3, head4, dragon);
/* 263 */     float wingFlap = (float)Math.toRadians(dragon.wingFlap());
/* 264 */     float jawAngle = (float)Math.toRadians(dragon.getJawMove());
/* 265 */     float neckAngle = -(float)Math.toRadians(4.5F * dragon.getNeckAngle());
/*     */     
/* 267 */     this.head.field_78795_f = (head4 / 57.295776F + neckAngle);
/* 268 */     this.head.field_78796_g = (head3 / 57.295776F);
/*     */     
/* 270 */     if (!dragon.isTerrestrial()) {
/* 271 */       if ((dragon.field_70159_w == 0.0D) && (dragon.field_70179_y == 0.0D)) {
/* 272 */         wingFlap = (float)Math.toRadians(dragon.wingFlap());
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 277 */       wingFlap = (float)Math.toRadians(-40.0D);
/* 278 */       this.legBR.field_78795_f = (MathHelper.func_76134_b(step1 * 0.6662F) * 1.4F * step2);
/* 279 */       this.legBL.field_78795_f = (MathHelper.func_76134_b(step1 * 0.6662F + 3.1415927F) * 1.4F * step2);
/* 280 */       this.legFR.field_78795_f = (MathHelper.func_76134_b(step1 * 0.6662F + 3.1415927F) * 1.4F * step2);
/* 281 */       this.legFL.field_78795_f = (MathHelper.func_76134_b(step1 * 0.6662F) * 1.4F * step2);
/*     */     }
/* 283 */     this.wing1R.field_78808_h = wingFlap;
/* 284 */     this.wing2R.field_78808_h = wingFlap;
/* 285 */     this.wingCR.field_78808_h = wingFlap;
/*     */     
/* 287 */     this.wing1L.field_78808_h = (-wingFlap);
/* 288 */     this.wing2L.field_78808_h = (-wingFlap);
/* 289 */     this.wingCL.field_78808_h = (-wingFlap);
/*     */     
/* 291 */     this.footBL.field_78795_f = this.legBL.field_78795_f;
/* 292 */     this.footBR.field_78795_f = this.legBR.field_78795_f;
/* 293 */     this.thighBL.field_78795_f = this.legBL.field_78795_f;
/* 294 */     this.thighBR.field_78795_f = this.legBR.field_78795_f;
/*     */     
/* 296 */     double wingSpread = Math.toRadians(dragon.wingAngle());
/* 297 */     this.wing1R.field_78796_g = ((float)-wingSpread);
/* 298 */     this.wing2R.field_78796_g = ((float)-wingSpread);
/* 299 */     this.wingCR.field_78796_g = ((float)-wingSpread);
/*     */     
/* 301 */     this.wing1L.field_78796_g = ((float)wingSpread);
/* 302 */     this.wing2L.field_78796_g = ((float)wingSpread);
/* 303 */     this.wingCL.field_78796_g = ((float)wingSpread);
/*     */     
/* 305 */     this.nose.field_78795_f = (this.head.field_78795_f - jawAngle / 2.0F);
/* 306 */     this.mouth.field_78795_f = (this.head.field_78795_f + jawAngle);
/*     */     
/* 308 */     this.nose.field_78796_g = this.head.field_78796_g;
/* 309 */     this.mouth.field_78796_g = this.head.field_78796_g;
/*     */     
/* 311 */     this.horn1.field_78795_f = (this.horn2.field_78795_f = this.head.field_78795_f + 0.6108652F);
/* 312 */     this.horn1.field_78796_g = (this.horn2.field_78796_g = this.head.field_78796_g);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/entityrender/ModelSmallDragon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */