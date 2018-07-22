/*     */ package minefantasy.client.entityrender;
/*     */ 
/*     */ import minefantasy.entity.EntityBasilisk;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelBasilisk
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer LFoot3;
/*     */   ModelRenderer LLeg3;
/*     */   ModelRenderer LLeg4;
/*     */   ModelRenderer LFoot4;
/*     */   ModelRenderer LFoot2;
/*     */   ModelRenderer LLeg2;
/*     */   ModelRenderer LFoot1;
/*     */   ModelRenderer LLeg1;
/*     */   ModelRenderer RFoot3;
/*     */   ModelRenderer RLeg3;
/*     */   ModelRenderer RLeg4;
/*     */   ModelRenderer RFoot4;
/*     */   ModelRenderer RFoot2;
/*     */   ModelRenderer RLeg2;
/*     */   ModelRenderer RFoot1;
/*     */   ModelRenderer RLeg1;
/*     */   ModelRenderer Body;
/*     */   ModelRenderer Back;
/*     */   ModelRenderer Belly;
/*     */   ModelRenderer Tail2;
/*     */   ModelRenderer Tail1;
/*     */   ModelRenderer Nose;
/*     */   ModelRenderer Neck;
/*     */   ModelRenderer Top;
/*     */   ModelRenderer Mouth;
/*     */   ModelRenderer TeethTop;
/*     */   ModelRenderer Head;
/*     */   ModelRenderer Jaw;
/*     */   ModelRenderer TeethBottom;
/*     */   
/*     */   public ModelBasilisk()
/*     */   {
/*  44 */     this.field_78090_t = 128;
/*  45 */     this.field_78089_u = 128;
/*     */     
/*  47 */     this.LFoot3 = new ModelRenderer(this, 34, 0);
/*  48 */     this.LLeg3 = new ModelRenderer(this, 0, 0);
/*  49 */     this.LLeg4 = new ModelRenderer(this, 0, 0);
/*  50 */     this.LFoot4 = new ModelRenderer(this, 34, 0);
/*  51 */     this.LFoot2 = new ModelRenderer(this, 34, 0);
/*  52 */     this.LLeg2 = new ModelRenderer(this, 0, 0);
/*  53 */     this.LFoot1 = new ModelRenderer(this, 34, 0);
/*  54 */     this.LLeg1 = new ModelRenderer(this, 0, 0);
/*  55 */     this.RFoot3 = new ModelRenderer(this, 34, 0);
/*  56 */     this.RLeg3 = new ModelRenderer(this, 0, 0);
/*  57 */     this.RLeg4 = new ModelRenderer(this, 0, 0);
/*  58 */     this.RFoot4 = new ModelRenderer(this, 34, 0);
/*  59 */     this.RFoot2 = new ModelRenderer(this, 34, 0);
/*  60 */     this.RLeg2 = new ModelRenderer(this, 0, 0);
/*  61 */     this.RFoot1 = new ModelRenderer(this, 34, 0);
/*  62 */     this.RLeg1 = new ModelRenderer(this, 0, 0);
/*  63 */     this.Body = new ModelRenderer(this, 0, 45);
/*  64 */     this.Body.func_78789_a(-26.0F, -2.0F, -6.0F, 44, 7, 12);
/*  65 */     this.Back = new ModelRenderer(this, 28, 0);
/*  66 */     this.Belly = new ModelRenderer(this, 28, 0);
/*  67 */     this.Tail2 = new ModelRenderer(this, 42, 64);
/*  68 */     this.Tail1 = new ModelRenderer(this, 0, 64);
/*  69 */     this.Nose = new ModelRenderer(this, 20, 83);
/*  70 */     this.Neck = new ModelRenderer(this, 88, 0);
/*  71 */     this.Top = new ModelRenderer(this, 80, 86);
/*  72 */     this.Mouth = new ModelRenderer(this, 0, 83);
/*  73 */     this.Head = new ModelRenderer(this, 80, 64);
/*  74 */     this.Jaw = new ModelRenderer(this, 80, 99);
/*  75 */     this.TeethBottom = new ModelRenderer(this, 0, 112);
/*  76 */     this.TeethTop = new ModelRenderer(this, 0, 112);
/*     */     
/*  78 */     this.LFoot3.field_78809_i = true;
/*  79 */     this.LFoot3.func_78789_a(-0.5F, 8.0F, -6.0F, 7, 4, 8);
/*  80 */     this.LFoot3.func_78793_a(4.0F, 12.0F, 11.0F);
/*  81 */     this.LFoot3.func_78787_b(128, 128);
/*  82 */     this.LFoot3.field_78809_i = true;
/*  83 */     setRotation(this.LFoot3, 0.0F, 0.0F, 0.0F);
/*  84 */     this.LFoot3.field_78809_i = false;
/*  85 */     this.LLeg3.field_78809_i = true;
/*  86 */     this.LLeg3.func_78789_a(-1.0F, -2.0F, -5.0F, 7, 10, 7);
/*  87 */     this.LLeg3.func_78793_a(4.0F, 12.0F, 11.0F);
/*  88 */     this.LLeg3.func_78787_b(128, 128);
/*  89 */     this.LLeg3.field_78809_i = true;
/*  90 */     setRotation(this.LLeg3, 0.0F, 0.0F, 0.0F);
/*  91 */     this.LLeg3.field_78809_i = false;
/*  92 */     this.LLeg4.field_78809_i = true;
/*  93 */     this.LLeg4.func_78789_a(-1.0F, -2.0F, -4.0F, 7, 10, 7);
/*  94 */     this.LLeg4.func_78793_a(4.0F, 12.0F, 20.0F);
/*  95 */     this.LLeg4.func_78787_b(128, 128);
/*  96 */     this.LLeg4.field_78809_i = true;
/*  97 */     setRotation(this.LLeg4, 0.0F, 0.0F, 0.0F);
/*  98 */     this.LLeg4.field_78809_i = false;
/*  99 */     this.LFoot4.field_78809_i = true;
/* 100 */     this.LFoot4.func_78789_a(-0.5F, 8.0F, -5.0F, 7, 4, 8);
/* 101 */     this.LFoot4.func_78793_a(4.0F, 12.0F, 20.0F);
/* 102 */     this.LFoot4.func_78787_b(128, 128);
/* 103 */     this.LFoot4.field_78809_i = true;
/* 104 */     setRotation(this.LFoot4, 0.0F, 0.0F, 0.0F);
/* 105 */     this.LFoot4.field_78809_i = false;
/* 106 */     this.LFoot2.field_78809_i = true;
/* 107 */     this.LFoot2.func_78789_a(-0.5F, 8.0F, -5.0F, 7, 4, 8);
/* 108 */     this.LFoot2.func_78793_a(4.0F, 12.0F, 0.0F);
/* 109 */     this.LFoot2.func_78787_b(128, 128);
/* 110 */     this.LFoot2.field_78809_i = true;
/* 111 */     setRotation(this.LFoot2, 0.0F, 0.0F, 0.0F);
/* 112 */     this.LFoot2.field_78809_i = false;
/* 113 */     this.LLeg2.field_78809_i = true;
/* 114 */     this.LLeg2.func_78789_a(-1.0F, -2.0F, -4.0F, 7, 10, 7);
/* 115 */     this.LLeg2.func_78793_a(4.0F, 12.0F, 0.0F);
/* 116 */     this.LLeg2.func_78787_b(128, 128);
/* 117 */     this.LLeg2.field_78809_i = true;
/* 118 */     setRotation(this.LLeg2, 0.0F, 0.0F, 0.0F);
/* 119 */     this.LLeg2.field_78809_i = false;
/* 120 */     this.LFoot1.field_78809_i = true;
/* 121 */     this.LFoot1.func_78789_a(-0.5F, 8.0F, -6.0F, 7, 4, 8);
/* 122 */     this.LFoot1.func_78793_a(4.0F, 12.0F, -9.0F);
/* 123 */     this.LFoot1.func_78787_b(128, 128);
/* 124 */     this.LFoot1.field_78809_i = true;
/* 125 */     setRotation(this.LFoot1, 0.0F, 0.0F, 0.0F);
/* 126 */     this.LFoot1.field_78809_i = false;
/* 127 */     this.LLeg1.field_78809_i = true;
/* 128 */     this.LLeg1.func_78789_a(-1.0F, -2.0F, -5.0F, 7, 10, 7);
/* 129 */     this.LLeg1.func_78793_a(4.0F, 12.0F, -9.0F);
/* 130 */     this.LLeg1.func_78787_b(128, 128);
/* 131 */     this.LLeg1.field_78809_i = true;
/* 132 */     setRotation(this.LLeg1, 0.0F, 0.0F, 0.0F);
/* 133 */     this.LLeg1.field_78809_i = false;
/* 134 */     this.RFoot3.func_78789_a(-6.5F, 8.0F, -6.0F, 7, 4, 8);
/* 135 */     this.RFoot3.func_78793_a(-4.0F, 12.0F, 11.0F);
/* 136 */     this.RFoot3.func_78787_b(128, 128);
/* 137 */     this.RFoot3.field_78809_i = true;
/* 138 */     setRotation(this.RFoot3, 0.0F, 0.0F, 0.0F);
/* 139 */     this.RLeg3.func_78789_a(-6.0F, -2.0F, -5.0F, 7, 10, 7);
/* 140 */     this.RLeg3.func_78793_a(-4.0F, 12.0F, 11.0F);
/* 141 */     this.RLeg3.func_78787_b(128, 128);
/* 142 */     this.RLeg3.field_78809_i = true;
/* 143 */     setRotation(this.RLeg3, 0.0F, 0.0F, 0.0F);
/* 144 */     this.RLeg4.func_78789_a(-6.0F, -2.0F, -4.0F, 7, 10, 7);
/* 145 */     this.RLeg4.func_78793_a(-4.0F, 12.0F, 20.0F);
/* 146 */     this.RLeg4.func_78787_b(128, 128);
/* 147 */     this.RLeg4.field_78809_i = true;
/* 148 */     setRotation(this.RLeg4, 0.0F, 0.0F, 0.0F);
/* 149 */     this.RFoot4.func_78789_a(-6.5F, 8.0F, -5.0F, 7, 4, 8);
/* 150 */     this.RFoot4.func_78793_a(-4.0F, 12.0F, 20.0F);
/* 151 */     this.RFoot4.func_78787_b(128, 128);
/* 152 */     this.RFoot4.field_78809_i = true;
/* 153 */     setRotation(this.RFoot4, 0.0F, 0.0F, 0.0F);
/* 154 */     this.RFoot2.func_78789_a(-6.5F, 8.0F, -5.0F, 7, 4, 8);
/* 155 */     this.RFoot2.func_78793_a(-4.0F, 12.0F, 0.0F);
/* 156 */     this.RFoot2.func_78787_b(128, 128);
/* 157 */     this.RFoot2.field_78809_i = true;
/* 158 */     setRotation(this.RFoot2, 0.0F, 0.0F, 0.0F);
/* 159 */     this.RLeg2.func_78789_a(-6.0F, -2.0F, -4.0F, 7, 10, 7);
/* 160 */     this.RLeg2.func_78793_a(-4.0F, 12.0F, 0.0F);
/* 161 */     this.RLeg2.func_78787_b(128, 128);
/* 162 */     this.RLeg2.field_78809_i = true;
/* 163 */     setRotation(this.RLeg2, 0.0F, 0.0F, 0.0F);
/* 164 */     this.RFoot1.func_78789_a(-6.5F, 8.0F, -6.0F, 7, 4, 8);
/* 165 */     this.RFoot1.func_78793_a(-4.0F, 12.0F, -9.0F);
/* 166 */     this.RFoot1.func_78787_b(128, 128);
/* 167 */     this.RFoot1.field_78809_i = true;
/* 168 */     setRotation(this.RFoot1, 0.0F, 0.0F, 0.0F);
/* 169 */     this.RLeg1.func_78789_a(-6.0F, -2.0F, -5.0F, 7, 10, 7);
/* 170 */     this.RLeg1.func_78793_a(-4.0F, 12.0F, -9.0F);
/* 171 */     this.RLeg1.func_78787_b(128, 128);
/* 172 */     this.RLeg1.field_78809_i = true;
/* 173 */     setRotation(this.RLeg1, 0.0F, 0.0F, 0.0F);
/* 174 */     this.Body.func_78793_a(0.0F, 9.0F, 0.0F);
/* 175 */     this.Body.func_78787_b(128, 128);
/* 176 */     this.Body.field_78809_i = true;
/* 177 */     setRotation(this.Body, 0.0F, 1.570796F, 0.0F);
/* 178 */     this.Back.func_78789_a(-5.0F, -4.0F, -16.0F, 10, 3, 40);
/* 179 */     this.Back.func_78793_a(0.0F, 9.0F, 0.0F);
/* 180 */     this.Back.func_78787_b(128, 128);
/* 181 */     this.Back.field_78809_i = true;
/* 182 */     setRotation(this.Back, 0.0F, 0.0F, 0.0F);
/* 183 */     this.Belly.func_78789_a(-5.0F, 5.0F, -15.0F, 10, 3, 40);
/* 184 */     this.Belly.func_78793_a(0.0F, 9.0F, 0.0F);
/* 185 */     this.Belly.func_78787_b(128, 128);
/* 186 */     this.Belly.field_78809_i = true;
/* 187 */     setRotation(this.Belly, 0.0F, 0.0F, 0.0F);
/* 188 */     this.Tail2.func_78789_a(-3.0F, 5.0F, 9.0F, 6, 4, 13);
/* 189 */     this.Tail2.func_78793_a(0.0F, 10.0F, 24.0F);
/* 190 */     this.Tail2.func_78787_b(128, 128);
/* 191 */     this.Tail2.field_78809_i = true;
/* 192 */     setRotation(this.Tail2, -0.0698132F, 0.0F, 0.0F);
/* 193 */     this.Tail1.func_78789_a(-4.0F, -3.0F, 0.0F, 8, 6, 13);
/* 194 */     this.Tail1.func_78793_a(0.0F, 10.0F, 24.0F);
/* 195 */     this.Tail1.func_78787_b(128, 128);
/* 196 */     this.Tail1.field_78809_i = true;
/* 197 */     setRotation(this.Tail1, -0.6457718F, 0.0F, 0.0F);
/* 198 */     this.Nose.func_78789_a(-4.0F, 0.0F, -20.0F, 8, 4, 4);
/* 199 */     this.Nose.func_78793_a(0.0F, 8.0F, -15.0F);
/* 200 */     this.Nose.func_78787_b(128, 128);
/* 201 */     this.Nose.field_78809_i = true;
/* 202 */     setRotation(this.Nose, 0.0F, 0.0F, 0.0F);
/* 203 */     this.Neck.func_78789_a(-5.0F, -1.0F, -8.0F, 10, 8, 10);
/* 204 */     this.Neck.func_78793_a(0.0F, 8.0F, -15.0F);
/* 205 */     this.Neck.func_78787_b(128, 128);
/* 206 */     this.Neck.field_78809_i = true;
/* 207 */     setRotation(this.Neck, 0.0F, 0.0F, 0.0F);
/* 208 */     this.Top.func_78789_a(-5.0F, -5.0F, -16.0F, 10, 2, 11);
/* 209 */     this.Top.func_78793_a(0.0F, 8.0F, -15.0F);
/* 210 */     this.Top.func_78787_b(128, 128);
/* 211 */     this.Top.field_78809_i = true;
/* 212 */     setRotation(this.Top, 0.0F, 0.0F, 0.0F);
/* 213 */     this.Mouth.func_78789_a(-3.5F, 4.0F, -19.0F, 7, 3, 3);
/* 214 */     this.Mouth.func_78793_a(0.0F, 8.0F, -15.0F);
/* 215 */     this.Mouth.func_78787_b(128, 128);
/* 216 */     this.Mouth.field_78809_i = true;
/* 217 */     setRotation(this.Mouth, 0.0F, 0.0F, 0.0F);
/* 218 */     this.TeethTop.field_78809_i = true;
/* 219 */     this.TeethTop.func_78789_a(-5.0F, 4.0F, -16.0F, 10, 2, 10);
/* 220 */     this.TeethTop.func_78793_a(0.0F, 8.0F, -15.0F);
/* 221 */     this.TeethTop.func_78787_b(128, 128);
/* 222 */     this.TeethTop.field_78809_i = true;
/* 223 */     setRotation(this.TeethTop, 0.0F, 0.0F, 0.0F);
/* 224 */     this.TeethTop.field_78809_i = false;
/* 225 */     this.Head.func_78789_a(-6.0F, -3.0F, -16.0F, 12, 7, 12);
/* 226 */     this.Head.func_78793_a(0.0F, 8.0F, -15.0F);
/* 227 */     this.Head.func_78787_b(128, 128);
/* 228 */     this.Head.field_78809_i = true;
/* 229 */     setRotation(this.Head, 0.0F, 0.0F, 0.0F);
/* 230 */     this.Jaw.func_78789_a(-6.0F, 4.0F, -16.0F, 12, 4, 12);
/* 231 */     this.Jaw.func_78793_a(0.0F, 8.0F, -15.0F);
/* 232 */     this.Jaw.func_78787_b(128, 128);
/* 233 */     this.Jaw.field_78809_i = true;
/* 234 */     setRotation(this.Jaw, 0.0F, 0.0F, 0.0F);
/* 235 */     this.TeethBottom.func_78789_a(-5.0F, 2.0F, -16.0F, 10, 2, 10);
/* 236 */     this.TeethBottom.func_78793_a(0.0F, 8.0F, -15.0F);
/* 237 */     this.TeethBottom.func_78787_b(128, 128);
/* 238 */     this.TeethBottom.field_78809_i = true;
/* 239 */     setRotation(this.TeethBottom, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 243 */     model.field_78795_f = x;
/* 244 */     model.field_78796_g = y;
/* 245 */     model.field_78808_h = z;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_78088_a(Entity entity, float f1, float f2, float f3, float f4, float f5, float f6)
/*     */   {
/* 253 */     super.func_78088_a(entity, f1, f2, f3, f4, f5, f6);
/* 254 */     func_78087_a(f1, f2, f3, f4, f5, f6, entity);
/* 255 */     this.LFoot3.func_78785_a(f6);
/* 256 */     this.LLeg3.func_78785_a(f6);
/* 257 */     this.LLeg4.func_78785_a(f6);
/* 258 */     this.LFoot4.func_78785_a(f6);
/* 259 */     this.LFoot2.func_78785_a(f6);
/* 260 */     this.LLeg2.func_78785_a(f6);
/* 261 */     this.LFoot1.func_78785_a(f6);
/* 262 */     this.LLeg1.func_78785_a(f6);
/* 263 */     this.RFoot3.func_78785_a(f6);
/* 264 */     this.RLeg3.func_78785_a(f6);
/* 265 */     this.RLeg4.func_78785_a(f6);
/* 266 */     this.RFoot4.func_78785_a(f6);
/* 267 */     this.RFoot2.func_78785_a(f6);
/* 268 */     this.RLeg2.func_78785_a(f6);
/* 269 */     this.RFoot1.func_78785_a(f6);
/* 270 */     this.RLeg1.func_78785_a(f6);
/* 271 */     this.Body.func_78785_a(f6);
/* 272 */     this.Back.func_78785_a(f6);
/* 273 */     this.Belly.func_78785_a(f6);
/* 274 */     this.Tail2.func_78785_a(f6);
/* 275 */     this.Tail1.func_78785_a(f6);
/* 276 */     this.Nose.func_78785_a(f6);
/* 277 */     this.Neck.func_78785_a(f6);
/* 278 */     this.Top.func_78785_a(f6);
/* 279 */     this.Mouth.func_78785_a(f6);
/* 280 */     this.TeethTop.func_78785_a(f6);
/* 281 */     this.Head.func_78785_a(f6);
/* 282 */     this.Jaw.func_78785_a(f6);
/* 283 */     this.TeethBottom.func_78785_a(f6);
/*     */   }
/*     */   
/*     */   public void func_78087_a(float f1, float f2, float f3, float f4, float f5, float f6, Entity entity)
/*     */   {
/* 288 */     EntityBasilisk basilisk = (EntityBasilisk)entity;
/* 289 */     float mouth = basilisk.getMouthAngle();
/* 290 */     float noseMove = -10.0F * mouth;
/* 291 */     float mouthMove = 8.0F * mouth;
/*     */     
/* 293 */     this.Top.field_78795_f = ((f5 + noseMove) / 57.295776F);
/* 294 */     this.Top.field_78796_g = (f4 / 57.295776F);
/* 295 */     this.Head.field_78795_f = ((f5 + noseMove) / 57.295776F);
/* 296 */     this.Head.field_78796_g = (f4 / 57.295776F);
/* 297 */     this.Jaw.field_78795_f = ((f5 + mouthMove) / 57.295776F);
/* 298 */     this.Jaw.field_78796_g = (f4 / 57.295776F);
/* 299 */     this.Nose.field_78795_f = ((f5 + noseMove) / 57.295776F);
/* 300 */     this.Nose.field_78796_g = (f4 / 57.295776F);
/* 301 */     this.Mouth.field_78795_f = ((f5 + mouthMove) / 57.295776F);
/* 302 */     this.Mouth.field_78796_g = (f4 / 57.295776F);
/* 303 */     this.TeethBottom.field_78795_f = ((f5 + mouthMove) / 57.295776F);
/* 304 */     this.TeethBottom.field_78796_g = (f4 / 57.295776F);
/* 305 */     this.TeethTop.field_78795_f = ((f5 + noseMove) / 57.295776F);
/* 306 */     this.TeethTop.field_78796_g = (f4 / 57.295776F);
/*     */     
/* 308 */     this.Neck.field_78795_f = (f5 / 2.0F / 57.295776F);
/* 309 */     this.Neck.field_78796_g = (f4 / 2.0F / 57.295776F);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 317 */     this.RLeg4.field_78795_f = (MathHelper.func_76134_b(f1 * 0.6662F) * 1.4F * f2);
/* 318 */     this.LLeg4.field_78795_f = (MathHelper.func_76134_b(f1 * 0.6662F + 3.1415927F) * 1.4F * f2);
/* 319 */     this.RLeg3.field_78795_f = (MathHelper.func_76134_b(f1 * 0.6662F + 3.1415927F) * 1.4F * f2);
/* 320 */     this.LLeg3.field_78795_f = (MathHelper.func_76134_b(f1 * 0.6662F) * 1.4F * f2);
/* 321 */     this.RLeg2.field_78795_f = (MathHelper.func_76134_b(f1 * 0.6662F) * 1.4F * f2);
/* 322 */     this.LLeg2.field_78795_f = (MathHelper.func_76134_b(f1 * 0.6662F + 3.1415927F) * 1.4F * f2);
/* 323 */     this.RLeg1.field_78795_f = (MathHelper.func_76134_b(f1 * 0.6662F + 3.1415927F) * 1.4F * f2);
/* 324 */     this.LLeg1.field_78795_f = (MathHelper.func_76134_b(f1 * 0.6662F) * 1.4F * f2);
/*     */     
/* 326 */     this.RFoot4.field_78795_f = (MathHelper.func_76134_b(f1 * 0.6662F) * 1.4F * f2);
/* 327 */     this.LFoot4.field_78795_f = (MathHelper.func_76134_b(f1 * 0.6662F + 3.1415927F) * 1.4F * f2);
/* 328 */     this.RFoot3.field_78795_f = (MathHelper.func_76134_b(f1 * 0.6662F + 3.1415927F) * 1.4F * f2);
/* 329 */     this.LFoot3.field_78795_f = (MathHelper.func_76134_b(f1 * 0.6662F) * 1.4F * f2);
/* 330 */     this.RFoot2.field_78795_f = (MathHelper.func_76134_b(f1 * 0.6662F) * 1.4F * f2);
/* 331 */     this.LFoot2.field_78795_f = (MathHelper.func_76134_b(f1 * 0.6662F + 3.1415927F) * 1.4F * f2);
/* 332 */     this.RFoot1.field_78795_f = (MathHelper.func_76134_b(f1 * 0.6662F + 3.1415927F) * 1.4F * f2);
/* 333 */     this.LFoot1.field_78795_f = (MathHelper.func_76134_b(f1 * 0.6662F) * 1.4F * f2);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/entityrender/ModelBasilisk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */