/*     */ package minefantasy.client.entityrender;
/*     */ 
/*     */ import minefantasy.entity.EntityDrake;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelDrake
/*     */   extends ModelBiped
/*     */ {
/*     */   ModelRenderer Lthigh;
/*     */   ModelRenderer LToe2;
/*     */   ModelRenderer Lleg;
/*     */   ModelRenderer LFoot;
/*     */   ModelRenderer LToe1;
/*     */   ModelRenderer Rthigh;
/*     */   ModelRenderer RToe2;
/*     */   ModelRenderer Rleg;
/*     */   ModelRenderer RFoot;
/*     */   ModelRenderer RToe1;
/*     */   ModelRenderer TailEnd;
/*     */   ModelRenderer Belly;
/*     */   ModelRenderer Body;
/*     */   ModelRenderer Mouth;
/*     */   ModelRenderer Tail;
/*     */   ModelRenderer TailTip;
/*     */   ModelRenderer Neck;
/*     */   ModelRenderer Head;
/*     */   ModelRenderer Jaw;
/*     */   ModelRenderer RThumb;
/*     */   ModelRenderer RArm;
/*     */   ModelRenderer RClaw;
/*     */   ModelRenderer LArm;
/*     */   ModelRenderer LThumb;
/*     */   ModelRenderer LClaw;
/*     */   ModelRenderer Back;
/*     */   
/*     */   public ModelDrake()
/*     */   {
/*  42 */     this.field_78090_t = 128;
/*  43 */     this.field_78089_u = 128;
/*     */     
/*  45 */     this.Lthigh = new ModelRenderer(this, 0, 0);
/*  46 */     this.LToe2 = new ModelRenderer(this, 0, 55);
/*  47 */     this.Lleg = new ModelRenderer(this, 0, 20);
/*  48 */     this.LFoot = new ModelRenderer(this, 0, 34);
/*  49 */     this.LToe1 = new ModelRenderer(this, 0, 55);
/*  50 */     this.Rthigh = new ModelRenderer(this, 0, 0);
/*  51 */     this.RToe2 = new ModelRenderer(this, 0, 55);
/*  52 */     this.Rleg = new ModelRenderer(this, 0, 20);
/*  53 */     this.RFoot = new ModelRenderer(this, 0, 34);
/*  54 */     this.RToe1 = new ModelRenderer(this, 0, 55);
/*  55 */     this.TailEnd = new ModelRenderer(this, 70, 45);
/*  56 */     this.Belly = new ModelRenderer(this, 108, 105);
/*  57 */     this.Body = new ModelRenderer(this, 84, 0);
/*  58 */     this.Mouth = new ModelRenderer(this, 0, 77);
/*  59 */     this.Tail = new ModelRenderer(this, 102, 41);
/*  60 */     this.TailTip = new ModelRenderer(this, 82, 45);
/*  61 */     this.Neck = new ModelRenderer(this, 52, 0);
/*  62 */     this.Head = new ModelRenderer(this, 44, 21);
/*  63 */     this.Jaw = new ModelRenderer(this, 0, 64);
/*  64 */     this.RThumb = new ModelRenderer(this, 0, 102);
/*  65 */     this.RArm = new ModelRenderer(this, 12, 90);
/*  66 */     this.RClaw = new ModelRenderer(this, 0, 110);
/*  67 */     this.LArm = new ModelRenderer(this, 12, 90);
/*  68 */     this.LThumb = new ModelRenderer(this, 0, 102);
/*  69 */     this.LClaw = new ModelRenderer(this, 0, 110);
/*  70 */     this.Back = new ModelRenderer(this, 108, 64);
/*     */     
/*  72 */     this.Lthigh.field_78809_i = true;
/*     */     
/*  74 */     this.Lthigh.func_78789_a(-1.0F, -2.0F, -4.0F, 5, 11, 9);
/*  75 */     this.Lthigh.func_78793_a(4.0F, 2.0F, 0.0F);
/*  76 */     this.Lthigh.func_78787_b(128, 128);
/*  77 */     this.Lthigh.field_78809_i = true;
/*  78 */     setRotation(this.Lthigh, 0.0F, 0.0F, 0.0F);
/*  79 */     this.Lthigh.field_78809_i = false;
/*  80 */     this.LToe2.field_78809_i = true;
/*     */     
/*  82 */     this.LToe2.func_78789_a(2.5F, 19.0F, -8.0F, 3, 3, 6);
/*  83 */     this.LToe2.func_78793_a(4.0F, 2.0F, 0.0F);
/*  84 */     this.LToe2.func_78787_b(128, 128);
/*  85 */     this.LToe2.field_78809_i = true;
/*  86 */     setRotation(this.LToe2, 0.0F, 0.0F, 0.0F);
/*  87 */     this.LToe2.field_78809_i = false;
/*  88 */     this.Lleg.field_78809_i = true;
/*     */     
/*  90 */     this.Lleg.func_78789_a(2.0F, 9.0F, 1.0F, 4, 9, 5);
/*  91 */     this.Lleg.func_78793_a(3.0F, 2.0F, 0.0F);
/*  92 */     this.Lleg.func_78787_b(128, 128);
/*  93 */     this.Lleg.field_78809_i = true;
/*  94 */     setRotation(this.Lleg, 0.0F, 0.0F, 0.0F);
/*  95 */     this.Lleg.field_78809_i = false;
/*  96 */     this.LFoot.field_78809_i = true;
/*     */     
/*  98 */     this.LFoot.func_78789_a(-0.5F, 18.0F, -2.0F, 5, 4, 8);
/*  99 */     this.LFoot.func_78793_a(4.0F, 2.0F, 0.0F);
/* 100 */     this.LFoot.func_78787_b(128, 128);
/* 101 */     this.LFoot.field_78809_i = true;
/* 102 */     setRotation(this.LFoot, 0.0F, 0.0F, 0.0F);
/* 103 */     this.LFoot.field_78809_i = false;
/* 104 */     this.LToe1.field_78809_i = true;
/*     */     
/* 106 */     this.LToe1.func_78789_a(-1.5F, 19.0F, -8.0F, 3, 3, 6);
/* 107 */     this.LToe1.func_78793_a(4.0F, 2.0F, 0.0F);
/* 108 */     this.LToe1.func_78787_b(128, 128);
/* 109 */     this.LToe1.field_78809_i = true;
/* 110 */     setRotation(this.LToe1, 0.0F, 0.0F, 0.0F);
/* 111 */     this.LToe1.field_78809_i = false;
/*     */     
/* 113 */     this.Rthigh.func_78789_a(-5.0F, -2.0F, -4.0F, 5, 11, 9);
/* 114 */     this.Rthigh.func_78793_a(-4.0F, 2.0F, 0.0F);
/* 115 */     this.Rthigh.func_78787_b(128, 128);
/* 116 */     this.Rthigh.field_78809_i = true;
/* 117 */     setRotation(this.Rthigh, 0.0F, 0.0F, 0.0F);
/*     */     
/* 119 */     this.RToe2.func_78789_a(-1.5F, 19.0F, -8.0F, 3, 3, 6);
/* 120 */     this.RToe2.func_78793_a(-4.0F, 2.0F, 0.0F);
/* 121 */     this.RToe2.func_78787_b(128, 128);
/* 122 */     this.RToe2.field_78809_i = true;
/* 123 */     setRotation(this.RToe2, 0.0F, 0.0F, 0.0F);
/*     */     
/* 125 */     this.Rleg.func_78789_a(-4.0F, 9.0F, 1.0F, 4, 9, 5);
/* 126 */     this.Rleg.func_78793_a(-6.0F, 2.0F, 0.0F);
/* 127 */     this.Rleg.func_78787_b(128, 128);
/* 128 */     this.Rleg.field_78809_i = true;
/* 129 */     setRotation(this.Rleg, 0.0F, 0.0F, 0.0F);
/*     */     
/* 131 */     this.RFoot.func_78789_a(-4.5F, 18.0F, -2.0F, 5, 4, 8);
/* 132 */     this.RFoot.func_78793_a(-4.0F, 2.0F, 0.0F);
/* 133 */     this.RFoot.func_78787_b(128, 128);
/* 134 */     this.RFoot.field_78809_i = true;
/* 135 */     setRotation(this.RFoot, 0.0F, 0.0F, 0.0F);
/*     */     
/* 137 */     this.RToe1.func_78789_a(-5.5F, 19.0F, -8.0F, 3, 3, 6);
/* 138 */     this.RToe1.func_78793_a(-4.0F, 2.0F, 0.0F);
/* 139 */     this.RToe1.func_78787_b(128, 128);
/* 140 */     this.RToe1.field_78809_i = true;
/* 141 */     setRotation(this.RToe1, 0.0F, 0.0F, 0.0F);
/*     */     
/* 143 */     this.TailEnd.func_78789_a(-1.0F, 30.0F, -18.0F, 2, 15, 4);
/* 144 */     this.TailEnd.func_78793_a(0.0F, 2.0F, 0.0F);
/* 145 */     this.TailEnd.func_78787_b(128, 128);
/* 146 */     this.TailEnd.field_78809_i = true;
/* 147 */     setRotation(this.TailEnd, 1.570796F, 0.0F, 0.0F);
/*     */     
/* 149 */     this.Belly.func_78789_a(-4.0F, -10.0F, -7.0F, 8, 21, 2);
/* 150 */     this.Belly.func_78793_a(0.0F, 2.0F, 0.0F);
/* 151 */     this.Belly.func_78787_b(128, 128);
/* 152 */     this.Belly.field_78809_i = true;
/* 153 */     setRotation(this.Belly, 0.8726646F, 0.0F, 0.0F);
/*     */     
/* 155 */     this.Body.func_78789_a(-5.0F, -12.0F, -5.0F, 10, 25, 12);
/* 156 */     this.Body.func_78793_a(0.0F, 2.0F, 0.0F);
/* 157 */     this.Body.func_78787_b(128, 128);
/* 158 */     this.Body.field_78809_i = true;
/* 159 */     setRotation(this.Body, 0.8726646F, 0.0F, 0.0F);
/*     */     
/* 161 */     this.Mouth.func_78789_a(-3.0F, -2.0F, -14.0F, 6, 4, 9);
/* 162 */     this.Mouth.func_78793_a(0.0F, -10.0F, -16.0F);
/* 163 */     this.Mouth.func_78787_b(128, 128);
/* 164 */     this.Mouth.field_78809_i = true;
/* 165 */     setRotation(this.Mouth, 0.0F, 0.0F, 0.0F);
/*     */     
/* 167 */     this.Tail.func_78789_a(-2.0F, 8.0F, -8.0F, 4, 14, 9);
/* 168 */     this.Tail.func_78793_a(0.0F, 2.0F, 0.0F);
/* 169 */     this.Tail.func_78787_b(128, 128);
/* 170 */     this.Tail.field_78809_i = true;
/* 171 */     setRotation(this.Tail, 1.22173F, 0.0F, 0.0F);
/*     */     
/* 173 */     this.TailTip.func_78789_a(-1.5F, 22.0F, -8.0F, 3, 12, 7);
/* 174 */     this.TailTip.func_78793_a(0.0F, 2.0F, 0.0F);
/* 175 */     this.TailTip.func_78787_b(128, 128);
/* 176 */     this.TailTip.field_78809_i = true;
/* 177 */     setRotation(this.TailTip, 1.22173F, 0.0F, 0.0F);
/*     */     
/* 179 */     this.Neck.func_78789_a(-2.0F, -20.0F, 2.0F, 4, 11, 8);
/* 180 */     this.Neck.func_78793_a(0.0F, 2.0F, 0.0F);
/* 181 */     this.Neck.func_78787_b(128, 128);
/* 182 */     this.Neck.field_78809_i = true;
/* 183 */     setRotation(this.Neck, 1.22173F, 0.0F, 0.0F);
/*     */     
/* 185 */     this.Head.func_78789_a(-3.0F, -6.0F, -6.0F, 6, 10, 9);
/* 186 */     this.Head.func_78793_a(0.0F, -10.0F, -16.0F);
/* 187 */     this.Head.func_78787_b(128, 128);
/* 188 */     this.Head.field_78809_i = true;
/* 189 */     setRotation(this.Head, 0.0F, 0.0F, 0.0F);
/*     */     
/* 191 */     this.Jaw.func_78789_a(-2.0F, 2.0F, -12.0F, 4, 2, 7);
/* 192 */     this.Jaw.func_78793_a(0.0F, -10.0F, -16.0F);
/* 193 */     this.Jaw.func_78787_b(128, 128);
/* 194 */     this.Jaw.field_78809_i = true;
/* 195 */     setRotation(this.Jaw, 0.0F, 0.0F, 0.0F);
/*     */     
/* 197 */     this.RThumb.func_78789_a(0.0F, 6.0F, -4.0F, 2, 5, 2);
/* 198 */     this.RThumb.func_78793_a(-3.0F, 5.0F, -9.0F);
/* 199 */     this.RThumb.func_78787_b(128, 128);
/* 200 */     this.RThumb.field_78809_i = true;
/* 201 */     setRotation(this.RThumb, 0.0F, 0.0F, 0.0F);
/*     */     
/* 203 */     this.RArm.func_78789_a(-2.0F, -2.0F, -2.0F, 3, 9, 3);
/* 204 */     this.RArm.func_78793_a(-3.0F, 5.0F, -9.0F);
/* 205 */     this.RArm.func_78787_b(128, 128);
/* 206 */     this.RArm.field_78809_i = true;
/* 207 */     setRotation(this.RArm, -0.418879F, 0.0F, 0.0F);
/*     */     
/* 209 */     this.RClaw.func_78789_a(-3.0F, 6.0F, -4.0F, 2, 6, 2);
/* 210 */     this.RClaw.func_78793_a(-3.0F, 5.0F, -9.0F);
/* 211 */     this.RClaw.func_78787_b(128, 128);
/* 212 */     this.RClaw.field_78809_i = true;
/* 213 */     setRotation(this.RClaw, 0.0F, 0.0F, 0.0F);
/* 214 */     this.LArm.field_78809_i = true;
/*     */     
/* 216 */     this.LArm.func_78789_a(-1.0F, -2.0F, -2.0F, 3, 9, 3);
/* 217 */     this.LArm.func_78793_a(3.0F, 5.0F, -9.0F);
/* 218 */     this.LArm.func_78787_b(128, 128);
/* 219 */     this.LArm.field_78809_i = true;
/* 220 */     setRotation(this.LArm, -0.418879F, 0.0F, 0.0F);
/* 221 */     this.LArm.field_78809_i = false;
/* 222 */     this.LThumb.field_78809_i = true;
/*     */     
/* 224 */     this.LThumb.func_78789_a(-2.0F, 6.0F, -4.0F, 2, 5, 2);
/* 225 */     this.LThumb.func_78793_a(3.0F, 5.0F, -9.0F);
/* 226 */     this.LThumb.func_78787_b(128, 128);
/* 227 */     this.LThumb.field_78809_i = true;
/* 228 */     setRotation(this.LThumb, 0.0F, 0.0F, 0.0F);
/* 229 */     this.LThumb.field_78809_i = false;
/* 230 */     this.LClaw.field_78809_i = true;
/*     */     
/* 232 */     this.LClaw.func_78789_a(1.0F, 6.0F, -4.0F, 2, 6, 2);
/* 233 */     this.LClaw.func_78793_a(3.0F, 5.0F, -9.0F);
/* 234 */     this.LClaw.func_78787_b(128, 128);
/* 235 */     this.LClaw.field_78809_i = true;
/* 236 */     setRotation(this.LClaw, 0.0F, 0.0F, 0.0F);
/* 237 */     this.LClaw.field_78809_i = false;
/*     */     
/* 239 */     this.Back.func_78789_a(-4.0F, -12.0F, 7.0F, 8, 25, 2);
/* 240 */     this.Back.func_78793_a(0.0F, 2.0F, 0.0F);
/* 241 */     this.Back.func_78787_b(128, 128);
/* 242 */     this.Back.field_78809_i = true;
/* 243 */     setRotation(this.Back, 0.8726646F, 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 247 */     setRotationAngles(f, f1, f2, f3, f4, f5, (EntityDrake)entity);
/* 248 */     this.Lthigh.func_78785_a(f5);
/* 249 */     this.LToe2.func_78785_a(f5);
/* 250 */     this.Lleg.func_78785_a(f5);
/* 251 */     this.LFoot.func_78785_a(f5);
/* 252 */     this.LToe1.func_78785_a(f5);
/* 253 */     this.Rthigh.func_78785_a(f5);
/* 254 */     this.RToe2.func_78785_a(f5);
/* 255 */     this.Rleg.func_78785_a(f5);
/* 256 */     this.RFoot.func_78785_a(f5);
/* 257 */     this.RToe1.func_78785_a(f5);
/* 258 */     this.TailEnd.func_78785_a(f5);
/* 259 */     this.Belly.func_78785_a(f5);
/* 260 */     this.Body.func_78785_a(f5);
/* 261 */     this.Mouth.func_78785_a(f5);
/* 262 */     this.Tail.func_78785_a(f5);
/* 263 */     this.TailTip.func_78785_a(f5);
/* 264 */     this.Neck.func_78785_a(f5);
/* 265 */     this.Head.func_78785_a(f5);
/* 266 */     this.Jaw.func_78785_a(f5);
/* 267 */     this.RThumb.func_78785_a(f5);
/* 268 */     this.RArm.func_78785_a(f5);
/* 269 */     this.RClaw.func_78785_a(f5);
/* 270 */     this.LArm.func_78785_a(f5);
/* 271 */     this.LThumb.func_78785_a(f5);
/* 272 */     this.LClaw.func_78785_a(f5);
/* 273 */     this.Back.func_78785_a(f5);
/*     */   }
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 277 */     model.field_78795_f = x;
/* 278 */     model.field_78796_g = y;
/* 279 */     model.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, EntityDrake entity) {
/* 283 */     float headX = this.field_78116_c.field_78795_f;
/* 284 */     float mouth = (float)Math.toRadians(entity.getMouthAngle());
/* 285 */     float tailY = (float)Math.toRadians(entity.getTailYAngle());
/* 286 */     float tailY1 = (float)Math.toRadians(entity.getTailYAngle());
/* 287 */     float tailY2 = (float)Math.toRadians(entity.getTailYAngle());
/* 288 */     super.func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 289 */     this.Rthigh.field_78795_f = (this.Rleg.field_78795_f = this.RFoot.field_78795_f = this.RToe1.field_78795_f = this.RToe2.field_78795_f = this.field_78123_h.field_78795_f);
/* 290 */     this.Lthigh.field_78795_f = (this.Lleg.field_78795_f = this.LFoot.field_78795_f = this.LToe1.field_78795_f = this.LToe2.field_78795_f = this.field_78124_i.field_78795_f);
/*     */     
/* 292 */     this.Head.field_78795_f = headX;
/* 293 */     this.Mouth.field_78795_f = (headX - mouth);
/* 294 */     this.Jaw.field_78795_f = (headX + mouth);
/*     */     
/* 296 */     this.Head.field_78796_g = (this.Mouth.field_78796_g = this.Jaw.field_78796_g = this.field_78116_c.field_78796_g);
/*     */     
/* 298 */     if (tailY < -6.0F)
/* 299 */       tailY = -6.0F;
/* 300 */     if (tailY > 6.0F)
/* 301 */       tailY = 6.0F;
/* 302 */     if (tailY1 < -12.0F)
/* 303 */       tailY1 = -12.0F;
/* 304 */     if (tailY1 > 12.0F)
/* 305 */       tailY1 = 12.0F;
/* 306 */     this.Tail.field_78796_g = tailY;
/* 307 */     this.TailEnd.field_78796_g = tailY1;
/* 308 */     this.TailTip.field_78796_g = tailY2;
/*     */     
/* 310 */     if (entity.scratchTime > 0) {
/* 311 */       float armS = 30.0F - (float)Math.toRadians(entity.getScratchForDisplay());
/* 312 */       this.Head.field_78796_g = (this.Mouth.field_78796_g = this.Jaw.field_78796_g = (float)Math.toRadians(0.0D));
/* 313 */       this.Head.field_78795_f = (this.Mouth.field_78795_f = this.Jaw.field_78795_f = (float)Math.toRadians(90.0D));
/* 314 */       this.RArm.field_78795_f = (this.RClaw.field_78795_f = this.RThumb.field_78795_f = armS);
/*     */     } else {
/* 316 */       this.RArm.field_78795_f = -0.418879F;
/* 317 */       this.RClaw.field_78795_f = (this.RThumb.field_78795_f = 0.0F);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/entityrender/ModelDrake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */