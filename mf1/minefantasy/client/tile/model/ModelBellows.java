/*     */ package minefantasy.client.tile.model;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelBellows
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer Flap4;
/*     */   ModelRenderer Handle;
/*     */   ModelRenderer Flap1;
/*     */   ModelRenderer Flap2;
/*     */   ModelRenderer Flap3;
/*     */   ModelRenderer Base;
/*     */   ModelRenderer Top;
/*     */   
/*     */   public ModelBellows()
/*     */   {
/*  25 */     this.field_78090_t = 64;
/*  26 */     this.field_78089_u = 32;
/*     */     
/*  28 */     this.Flap4 = new ModelRenderer(this, 0, 23);
/*  29 */     this.Flap4.func_78789_a(0.0F, 0.0F, -4.0F, 10, 1, 8);
/*  30 */     this.Flap4.func_78793_a(-8.0F, 23.0F, 0.0F);
/*  31 */     this.Flap4.func_78787_b(64, 32);
/*  32 */     this.Flap4.field_78809_i = true;
/*  33 */     setRotation(this.Flap4, 0.0F, 0.0F, -0.418879F);
/*  34 */     this.Handle = new ModelRenderer(this, 40, 0);
/*  35 */     this.Handle.func_78789_a(7.0F, -1.0F, -1.0F, 10, 2, 2);
/*  36 */     this.Handle.func_78793_a(-8.0F, 23.0F, 0.0F);
/*  37 */     this.Handle.func_78787_b(64, 32);
/*  38 */     this.Handle.field_78809_i = true;
/*  39 */     setRotation(this.Handle, 0.0F, 0.0F, -0.5235988F);
/*  40 */     this.Flap1 = new ModelRenderer(this, 34, 23);
/*  41 */     this.Flap1.func_78789_a(0.0F, 0.0F, -3.0F, 9, 1, 6);
/*  42 */     this.Flap1.func_78793_a(-8.0F, 23.0F, 0.0F);
/*  43 */     this.Flap1.func_78787_b(64, 32);
/*  44 */     this.Flap1.field_78809_i = true;
/*  45 */     setRotation(this.Flap1, 0.0F, 0.0F, -0.1047198F);
/*  46 */     this.Flap2 = new ModelRenderer(this, 0, 23);
/*  47 */     this.Flap2.func_78789_a(0.0F, 0.0F, -4.0F, 10, 1, 8);
/*  48 */     this.Flap2.func_78793_a(-8.0F, 23.0F, 0.0F);
/*  49 */     this.Flap2.func_78787_b(64, 32);
/*  50 */     this.Flap2.field_78809_i = true;
/*  51 */     setRotation(this.Flap2, 0.0F, 0.0F, -0.2094395F);
/*  52 */     this.Flap3 = new ModelRenderer(this, 34, 23);
/*  53 */     this.Flap3.func_78789_a(0.0F, 0.0F, -3.0F, 9, 1, 6);
/*  54 */     this.Flap3.func_78793_a(-8.0F, 23.0F, 0.0F);
/*  55 */     this.Flap3.func_78787_b(64, 32);
/*  56 */     this.Flap3.field_78809_i = true;
/*  57 */     setRotation(this.Flap3, 0.0F, 0.0F, -0.3141593F);
/*  58 */     this.Base = new ModelRenderer(this, 0, 0);
/*  59 */     this.Base.func_78789_a(0.0F, 0.0F, -5.0F, 11, 1, 10);
/*  60 */     this.Base.func_78793_a(-8.0F, 23.0F, 0.0F);
/*  61 */     this.Base.func_78787_b(64, 32);
/*  62 */     this.Base.field_78809_i = true;
/*  63 */     setRotation(this.Base, 0.0F, 0.0F, 0.0F);
/*  64 */     this.Top = new ModelRenderer(this, 0, 14);
/*  65 */     this.Top.func_78789_a(0.0F, 0.0F, -4.0F, 11, 1, 8);
/*  66 */     this.Top.func_78793_a(-8.0F, 23.0F, 0.0F);
/*  67 */     this.Top.func_78787_b(64, 32);
/*  68 */     this.Top.field_78809_i = true;
/*  69 */     setRotation(this.Top, 0.0F, 0.0F, -0.5235988F);
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  73 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/*  74 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*  75 */     this.Flap4.func_78785_a(f5);
/*  76 */     this.Handle.func_78785_a(f5);
/*  77 */     this.Flap1.func_78785_a(f5);
/*  78 */     this.Flap2.func_78785_a(f5);
/*  79 */     this.Flap3.func_78785_a(f5);
/*  80 */     this.Base.func_78785_a(f5);
/*  81 */     this.Top.func_78785_a(f5);
/*     */   }
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/*  85 */     model.field_78795_f = x;
/*  86 */     model.field_78796_g = y;
/*  87 */     model.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void renderModel(int press, float f) {
/*  91 */     this.Flap4.func_78785_a(f);
/*  92 */     this.Handle.func_78785_a(f);
/*  93 */     this.Flap1.func_78785_a(f);
/*  94 */     this.Flap2.func_78785_a(f);
/*  95 */     this.Flap3.func_78785_a(f);
/*  96 */     this.Base.func_78785_a(f);
/*  97 */     this.Top.func_78785_a(f);
/*     */   }
/*     */   
/*     */   public void rotate(int p) {
/* 101 */     this.Top.field_78808_h = (this.Handle.field_78808_h = -getRotationForPart(p, 5));
/* 102 */     this.Flap4.field_78808_h = (-getRotationForPart(p, 4));
/* 103 */     this.Flap3.field_78808_h = (-getRotationForPart(p, 3));
/* 104 */     this.Flap2.field_78808_h = (-getRotationForPart(p, 2));
/* 105 */     this.Flap1.field_78808_h = (-getRotationForPart(p, 1));
/*     */   }
/*     */   
/*     */   public float getRotationForPart(int press, int part) {
/* 109 */     float angle = (float)Math.toRadians(50 - press);
/* 110 */     return angle / 5.0F * part;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/model/ModelBellows.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */