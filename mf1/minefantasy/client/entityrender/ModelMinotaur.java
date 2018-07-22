/*     */ package minefantasy.client.entityrender;
/*     */ 
/*     */ import minefantasy.entity.EntityMinotaur;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelMinotaur
/*     */   extends ModelBiped
/*     */ {
/*     */   public ModelRenderer bipedNose;
/*     */   public int swing;
/*     */   public ModelRenderer bipedTail;
/*     */   public ModelRenderer bipedRhorn;
/*     */   public ModelRenderer bipedRhorn2;
/*     */   public ModelRenderer bipedLhorn;
/*     */   public ModelRenderer bipedLhorn2;
/*     */   public ModelRenderer field_78116_c;
/*     */   public ModelRenderer field_78115_e;
/*     */   public ModelRenderer field_78123_h;
/*     */   public ModelRenderer field_78124_i;
/*     */   public ModelRenderer shoulders;
/*     */   public ModelRenderer tailEnd;
/*     */   public ModelRenderer bipedRightThigh;
/*     */   public ModelRenderer bipedLeftThigh;
/*     */   public ModelRenderer bipedRightFoot;
/*     */   public ModelRenderer bipedLeftFoot;
/*     */   public ModelRenderer Mane2;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer Mane;
/*     */   
/*     */   public ModelMinotaur()
/*     */   {
/*  37 */     this.field_78090_t = 128;
/*  38 */     this.field_78089_u = 128;
/*     */     
/*  40 */     float headPos = 6.0F;
/*     */     
/*  42 */     this.bipedNose = new ModelRenderer(this, 0, 54);
/*  43 */     this.bipedNose.func_78789_a(-2.0F, -1.0F, -6.0F, 4, 4, 4);
/*  44 */     this.bipedNose.func_78793_a(0.0F, -4.0F, -headPos);
/*  45 */     this.bipedNose.func_78787_b(128, 128);
/*  46 */     this.bipedNose.field_78809_i = true;
/*  47 */     this.shoulders = new ModelRenderer(this, 86, 50);
/*  48 */     this.shoulders.func_78789_a(-8.0F, -1.0F, -4.0F, 15, 7, 6);
/*  49 */     this.shoulders.func_78793_a(0.0F, -8.0F, 1.0F);
/*  50 */     this.shoulders.func_78787_b(128, 128);
/*  51 */     this.shoulders.field_78809_i = true;
/*  52 */     this.field_78113_g = new ModelRenderer(this, 38, 33);
/*  53 */     this.field_78113_g.func_78789_a(-1.0F, -2.0F, -2.0F, 5, 16, 5);
/*  54 */     this.field_78113_g.func_78793_a(7.0F, -6.0F, 0.0F);
/*  55 */     this.field_78113_g.func_78787_b(128, 128);
/*  56 */     this.field_78113_g.field_78809_i = true;
/*  57 */     this.tailEnd = new ModelRenderer(this, 64, 0);
/*  58 */     this.tailEnd.func_78789_a(-1.0F, 4.0F, 10.0F, 2, 2, 11);
/*  59 */     this.tailEnd.func_78793_a(0.0F, 4.0F, 0.0F);
/*  60 */     this.tailEnd.func_78787_b(128, 128);
/*  61 */     this.tailEnd.field_78809_i = true;
/*  62 */     this.bipedRightThigh = new ModelRenderer(this, 38, 0);
/*  63 */     this.bipedRightThigh.func_78789_a(-3.0F, 0.0F, -3.0F, 5, 10, 8);
/*  64 */     this.bipedRightThigh.func_78793_a(-3.0F, 4.0F, 0.0F);
/*  65 */     this.bipedRightThigh.func_78787_b(128, 128);
/*  66 */     this.bipedRightThigh.field_78809_i = true;
/*  67 */     this.field_78116_c = new ModelRenderer(this, 0, 0);
/*  68 */     this.field_78116_c.func_78789_a(-2.0F, -3.0F, -2.0F, 4, 6, 6);
/*  69 */     this.field_78116_c.func_78793_a(0.0F, -4.0F, -headPos);
/*  70 */     this.field_78116_c.func_78787_b(128, 128);
/*  71 */     this.field_78116_c.field_78809_i = true;
/*  72 */     this.bipedLhorn = new ModelRenderer(this, 20, 5);
/*  73 */     this.bipedLhorn.func_78789_a(2.0F, -2.0F, 1.0F, 5, 2, 2);
/*  74 */     this.bipedLhorn.func_78793_a(0.0F, -4.0F, -headPos);
/*  75 */     this.bipedLhorn.func_78787_b(128, 128);
/*  76 */     this.bipedLhorn.field_78809_i = true;
/*  77 */     this.bipedLhorn2 = new ModelRenderer(this, 20, 0);
/*  78 */     this.bipedLhorn2.func_78789_a(6.0F, -6.0F, 1.0F, 1, 4, 1);
/*  79 */     this.bipedLhorn2.func_78793_a(0.0F, -4.0F, -headPos);
/*  80 */     this.bipedLhorn2.func_78787_b(128, 128);
/*  81 */     this.bipedLhorn2.field_78809_i = true;
/*  82 */     this.bipedRhorn = new ModelRenderer(this, 20, 5);
/*  83 */     this.bipedRhorn.func_78789_a(-7.0F, -2.0F, 1.0F, 5, 2, 2);
/*  84 */     this.bipedRhorn.func_78793_a(0.0F, -4.0F, -headPos);
/*  85 */     this.bipedRhorn.func_78787_b(128, 128);
/*  86 */     this.bipedRhorn.field_78809_i = true;
/*  87 */     this.bipedRhorn2 = new ModelRenderer(this, 20, 0);
/*  88 */     this.bipedRhorn2.func_78789_a(-7.0F, -6.0F, 1.0F, 1, 4, 1);
/*  89 */     this.bipedRhorn2.func_78793_a(0.0F, -4.0F, -headPos);
/*  90 */     this.bipedRhorn2.func_78787_b(128, 128);
/*  91 */     this.bipedRhorn2.field_78809_i = true;
/*  92 */     this.field_78124_i = new ModelRenderer(this, 20, 50);
/*  93 */     this.field_78124_i.func_78789_a(-1.0F, 10.0F, 0.0F, 4, 6, 5);
/*  94 */     this.field_78124_i.func_78793_a(3.0F, 4.0F, 0.0F);
/*  95 */     this.field_78124_i.func_78787_b(128, 128);
/*  96 */     this.field_78124_i.field_78809_i = true;
/*  97 */     this.bipedLeftThigh = new ModelRenderer(this, 38, 0);
/*  98 */     this.bipedLeftThigh.func_78789_a(-2.0F, 0.0F, -3.0F, 5, 10, 8);
/*  99 */     this.bipedLeftThigh.func_78793_a(3.0F, 4.0F, 0.0F);
/* 100 */     this.bipedLeftThigh.func_78787_b(128, 128);
/* 101 */     this.bipedLeftThigh.field_78809_i = true;
/* 102 */     this.bipedLeftFoot = new ModelRenderer(this, 20, 38);
/* 103 */     this.bipedLeftFoot.func_78789_a(-1.0F, 13.0F, -2.0F, 4, 7, 5);
/* 104 */     this.bipedLeftFoot.func_78793_a(3.0F, 4.0F, 0.0F);
/* 105 */     this.bipedLeftFoot.func_78787_b(128, 128);
/* 106 */     this.bipedLeftFoot.field_78809_i = true;
/* 107 */     this.field_78123_h = new ModelRenderer(this, 20, 50);
/* 108 */     this.field_78123_h.func_78789_a(-3.0F, 10.0F, 0.0F, 4, 6, 5);
/* 109 */     this.field_78123_h.func_78793_a(-3.0F, 4.0F, 0.0F);
/* 110 */     this.field_78123_h.func_78787_b(128, 128);
/* 111 */     this.field_78123_h.field_78809_i = true;
/* 112 */     this.bipedRightFoot = new ModelRenderer(this, 20, 38);
/* 113 */     this.bipedRightFoot.func_78789_a(-3.0F, 13.0F, -2.0F, 4, 7, 5);
/* 114 */     this.bipedRightFoot.func_78793_a(-3.0F, 4.0F, 0.0F);
/* 115 */     this.bipedRightFoot.func_78787_b(128, 128);
/* 116 */     this.bipedRightFoot.field_78809_i = true;
/* 117 */     this.field_78115_e = new ModelRenderer(this, 0, 12);
/* 118 */     this.field_78115_e.func_78789_a(-5.0F, 0.0F, -5.0F, 10, 14, 9);
/* 119 */     this.field_78115_e.func_78793_a(0.0F, -8.0F, 1.0F);
/* 120 */     this.field_78115_e.func_78787_b(128, 128);
/* 121 */     this.field_78115_e.field_78809_i = true;
/* 122 */     this.bipedTail = new ModelRenderer(this, 64, 17);
/* 123 */     this.bipedTail.func_78789_a(-2.0F, -3.0F, 2.0F, 4, 3, 11);
/* 124 */     this.bipedTail.func_78793_a(0.0F, 4.0F, 0.0F);
/* 125 */     this.bipedTail.func_78787_b(128, 128);
/* 126 */     this.bipedTail.field_78809_i = true;
/* 127 */     this.field_78112_f = new ModelRenderer(this, 38, 33);
/* 128 */     this.field_78112_f.func_78789_a(-4.0F, -2.0F, -2.0F, 5, 16, 5);
/* 129 */     this.field_78112_f.func_78793_a(-7.0F, -6.0F, 1.0F);
/* 130 */     this.field_78112_f.func_78787_b(128, 128);
/* 131 */     this.field_78112_f.field_78809_i = true;
/*     */     
/* 133 */     this.Mane2 = new ModelRenderer(this, 0, 88);
/* 134 */     this.Mane2.func_78789_a(-3.0F, -3.0F, -2.0F, 6, 12, 8);
/* 135 */     this.Mane2.func_78793_a(0.0F, -8.0F, 1.0F);
/* 136 */     this.Mane2.func_78787_b(128, 128);
/* 137 */     this.Neck = new ModelRenderer(this, 39, 64);
/* 138 */     this.Neck.func_78789_a(-3.0F, -1.0F, -9.0F, 6, 8, 3);
/* 139 */     this.Neck.func_78793_a(0.0F, -8.0F, 3.0F);
/* 140 */     this.Neck.func_78787_b(128, 128);
/* 141 */     this.Mane = new ModelRenderer(this, 0, 64);
/* 142 */     this.Mane.func_78789_a(-4.0F, -2.0F, -4.0F, 8, 13, 9);
/* 143 */     this.Mane.func_78793_a(0.0F, -8.0F, 1.0F);
/* 144 */     this.Mane.func_78787_b(128, 128);
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 148 */     setRotationAngles((EntityMinotaur)entity, f, f1, f2, f3, f4, f5);
/* 149 */     this.bipedNose.func_78785_a(f5);
/* 150 */     this.tailEnd.func_78785_a(f5);
/* 151 */     this.bipedLeftFoot.func_78785_a(f5);
/* 152 */     this.bipedRightFoot.func_78785_a(f5);
/* 153 */     this.shoulders.func_78785_a(f5);
/* 154 */     this.bipedLeftThigh.func_78785_a(f5);
/* 155 */     this.bipedRightThigh.func_78785_a(f5);
/* 156 */     this.bipedTail.func_78785_a(f5);
/* 157 */     this.bipedRhorn.func_78785_a(f5);
/* 158 */     this.bipedRhorn2.func_78785_a(f5);
/* 159 */     this.bipedLhorn.func_78785_a(f5);
/* 160 */     this.bipedLhorn2.func_78785_a(f5);
/* 161 */     this.field_78116_c.func_78785_a(f5);
/* 162 */     this.field_78124_i.func_78785_a(f5);
/* 163 */     this.field_78123_h.func_78785_a(f5);
/* 164 */     this.field_78115_e.func_78785_a(f5);
/* 165 */     this.field_78112_f.func_78785_a(f5);
/* 166 */     this.field_78113_g.func_78785_a(f5);
/* 167 */     this.field_78123_h.func_78785_a(f5);
/* 168 */     this.field_78124_i.func_78785_a(f5);
/* 169 */     this.Mane.func_78785_a(f5);
/* 170 */     this.Mane2.func_78785_a(f5);
/* 171 */     this.Neck.func_78785_a(f5);
/*     */   }
/*     */   
/*     */   public void setRotationAngles(EntityMinotaur mino, float f, float f1, float f2, float f3, float f4, float f5) {
/* 175 */     int swingAngle = 28 * mino.swing;
/* 176 */     double swingRad = Math.toRadians(swingAngle);
/*     */     
/* 178 */     int swingAngleY = 9 * mino.swing;
/* 179 */     double swingRadY = Math.toRadians(swingAngleY);
/* 180 */     this.field_78116_c.field_78796_g = (f3 / 57.29578F);
/* 181 */     this.field_78116_c.field_78795_f = (f4 / 57.29578F + (float)Math.toRadians(mino.getHeadChargeAngle()));
/* 182 */     if (mino.swing <= 0) {
/* 183 */       this.field_78112_f.field_78795_f = (MathHelper.func_76134_b(f * 0.6662F + 3.141593F) * 2.0F * f1 * 0.5F);
/* 184 */       this.field_78113_g.field_78795_f = (MathHelper.func_76134_b(f * 0.6662F) * 2.0F * f1 * 0.5F);
/* 185 */       this.field_78112_f.field_78796_g = 0.0F;
/* 186 */       this.field_78113_g.field_78796_g = 0.0F;
/*     */     } else {
/* 188 */       this.field_78112_f.field_78795_f = ((float)-swingRad);
/* 189 */       this.field_78113_g.field_78795_f = ((float)-swingRad);
/* 190 */       this.field_78112_f.field_78796_g = ((float)swingRadY);
/* 191 */       this.field_78113_g.field_78796_g = ((float)-swingRadY);
/*     */     }
/* 193 */     this.field_78112_f.field_78808_h = 0.0F;
/* 194 */     this.field_78113_g.field_78808_h = 0.0F;
/* 195 */     this.field_78123_h.field_78795_f = (MathHelper.func_76134_b(f * 0.6662F) * 1.4F * f1);
/* 196 */     this.field_78124_i.field_78795_f = (MathHelper.func_76134_b(f * 0.6662F + 3.141593F) * 1.4F * f1);
/* 197 */     this.field_78123_h.field_78796_g = 0.0F;
/* 198 */     this.field_78124_i.field_78796_g = 0.0F;
/*     */     
/* 200 */     this.bipedTail.field_78795_f = -1.182165F;
/* 201 */     this.tailEnd.field_78795_f = -0.5363927F;
/* 202 */     this.bipedNose.field_78795_f = this.field_78116_c.field_78795_f;
/* 203 */     this.bipedNose.field_78796_g = this.field_78116_c.field_78796_g;
/* 204 */     this.bipedRhorn.field_78795_f = this.field_78116_c.field_78795_f;
/* 205 */     this.bipedRhorn.field_78796_g = this.field_78116_c.field_78796_g;
/* 206 */     this.bipedRhorn2.field_78795_f = this.field_78116_c.field_78795_f;
/* 207 */     this.bipedRhorn2.field_78796_g = this.field_78116_c.field_78796_g;
/* 208 */     this.bipedLhorn.field_78795_f = this.field_78116_c.field_78795_f;
/* 209 */     this.bipedLhorn.field_78796_g = this.field_78116_c.field_78796_g;
/* 210 */     this.bipedLhorn2.field_78795_f = this.field_78116_c.field_78795_f;
/* 211 */     this.bipedLhorn2.field_78796_g = this.field_78116_c.field_78796_g;
/*     */     
/* 213 */     joinBlocks(this.Mane, this.field_78115_e);
/* 214 */     joinBlocks(this.Mane2, this.field_78115_e);
/* 215 */     joinBlocks(this.Neck, this.field_78115_e);
/*     */     
/* 217 */     if (this.field_78095_p > -9990.0F) {
/* 218 */       float f6 = this.field_78095_p;
/* 219 */       this.field_78115_e.field_78796_g = (MathHelper.func_76126_a(MathHelper.func_76129_c(f6) * 3.141593F * 2.0F) * 0.2F);
/* 220 */       this.field_78112_f.field_78798_e = (MathHelper.func_76126_a(this.field_78115_e.field_78796_g) * 5.0F);
/* 221 */       this.field_78112_f.field_78800_c = (-MathHelper.func_76134_b(this.field_78115_e.field_78796_g) * 5.0F);
/* 222 */       this.field_78113_g.field_78798_e = (-MathHelper.func_76126_a(this.field_78115_e.field_78796_g) * 5.0F);
/* 223 */       this.field_78113_g.field_78800_c = (MathHelper.func_76134_b(this.field_78115_e.field_78796_g) * 5.0F);
/* 224 */       this.field_78112_f.field_78796_g += this.field_78115_e.field_78796_g;
/* 225 */       this.field_78113_g.field_78796_g += this.field_78115_e.field_78796_g;
/* 226 */       this.field_78113_g.field_78795_f += this.field_78115_e.field_78796_g;
/* 227 */       f6 = 1.0F - this.field_78095_p;
/* 228 */       f6 *= f6;
/* 229 */       f6 *= f6;
/* 230 */       f6 = 1.0F - f6;
/* 231 */       float f8 = MathHelper.func_76126_a(f6 * 3.141593F);
/* 232 */       float f10 = MathHelper.func_76126_a(this.field_78095_p * 3.141593F) * -(this.field_78116_c.field_78795_f - 0.7F) * 0.75F; ModelRenderer 
/* 233 */         tmp695_692 = this.field_78112_f;tmp695_692.field_78795_f = ((float)(tmp695_692.field_78795_f - (tmp695_692 * 1.2D + f10)));
/* 234 */       this.field_78112_f.field_78796_g += this.field_78115_e.field_78796_g * 2.0F;
/* 235 */       this.field_78112_f.field_78808_h = (MathHelper.func_76126_a(this.field_78095_p * 3.141593F) * -0.4F);
/*     */     }
/* 237 */     this.field_78112_f.field_78808_h += MathHelper.func_76134_b(f2 * 0.09F) * 0.05F + 0.05F;
/* 238 */     this.field_78113_g.field_78808_h -= MathHelper.func_76134_b(f2 * 0.09F) * 0.05F + 0.05F;
/* 239 */     this.field_78112_f.field_78795_f += MathHelper.func_76126_a(f2 * 0.067F) * 0.05F;
/* 240 */     this.field_78113_g.field_78795_f -= MathHelper.func_76126_a(f2 * 0.067F) * 0.05F;
/*     */     
/* 242 */     this.bipedLeftThigh.field_78795_f = (this.bipedLeftFoot.field_78795_f = this.field_78124_i.field_78795_f);
/* 243 */     this.bipedRightThigh.field_78795_f = (this.bipedRightFoot.field_78795_f = this.field_78123_h.field_78795_f);
/*     */   }
/*     */   
/*     */   private void joinBlocks(ModelRenderer model, ModelRenderer anchor)
/*     */   {
/* 248 */     joinBlocks(model, anchor, 1.0F);
/*     */   }
/*     */   
/*     */   private void joinBlocks(ModelRenderer model, ModelRenderer anchor, float ratio) {
/* 252 */     anchor.field_78795_f *= ratio;
/* 253 */     anchor.field_78796_g *= ratio;
/* 254 */     anchor.field_78808_h *= ratio;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/entityrender/ModelMinotaur.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */