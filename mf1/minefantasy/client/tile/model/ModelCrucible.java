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
/*     */ public class ModelCrucible
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer sides3;
/*     */   ModelRenderer sides;
/*     */   ModelRenderer sides2;
/*     */   ModelRenderer sides1;
/*     */   ModelRenderer contents;
/*     */   ModelRenderer base;
/*     */   ModelRenderer armR;
/*     */   ModelRenderer armL;
/*     */   ModelRenderer armLBase;
/*     */   ModelRenderer armRBase;
/*     */   
/*     */   public ModelCrucible()
/*     */   {
/*  28 */     this.field_78090_t = 64;
/*  29 */     this.field_78089_u = 64;
/*     */     
/*  31 */     this.sides3 = new ModelRenderer(this, 0, 0);
/*  32 */     this.sides3.func_78789_a(-6.0F, 0.0F, -7.0F, 12, 10, 1);
/*  33 */     this.sides3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  34 */     this.sides3.func_78787_b(64, 64);
/*  35 */     this.sides3.field_78809_i = true;
/*  36 */     setRotation(this.sides3, 0.0F, 1.570796F, 0.0F);
/*  37 */     this.sides = new ModelRenderer(this, 0, 0);
/*  38 */     this.sides.func_78789_a(-6.0F, 0.0F, 6.0F, 12, 10, 1);
/*  39 */     this.sides.func_78793_a(0.0F, 0.0F, 0.0F);
/*  40 */     this.sides.func_78787_b(64, 64);
/*  41 */     this.sides.field_78809_i = true;
/*  42 */     setRotation(this.sides, 0.0F, 0.0F, 0.0F);
/*  43 */     this.sides2 = new ModelRenderer(this, 0, 0);
/*  44 */     this.sides2.func_78789_a(-6.0F, 0.0F, -7.0F, 12, 10, 1);
/*  45 */     this.sides2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  46 */     this.sides2.func_78787_b(64, 64);
/*  47 */     this.sides2.field_78809_i = true;
/*  48 */     setRotation(this.sides2, 0.0F, 0.0F, 0.0F);
/*  49 */     this.sides1 = new ModelRenderer(this, 0, 0);
/*  50 */     this.sides1.func_78789_a(-6.0F, 0.0F, 6.0F, 12, 10, 1);
/*  51 */     this.sides1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  52 */     this.sides1.func_78787_b(64, 64);
/*  53 */     this.sides1.field_78809_i = true;
/*  54 */     setRotation(this.sides1, 0.0F, 1.570796F, 0.0F);
/*  55 */     this.contents = new ModelRenderer(this, -12, 18);
/*  56 */     this.contents.func_78789_a(-6.0F, 2.0F, -6.0F, 12, 0, 12);
/*  57 */     this.contents.func_78793_a(0.0F, 0.0F, 0.0F);
/*  58 */     this.contents.func_78787_b(64, 64);
/*  59 */     this.contents.field_78809_i = true;
/*  60 */     setRotation(this.contents, 0.0F, 0.0F, 0.0F);
/*  61 */     this.base = new ModelRenderer(this, 14, 0);
/*  62 */     this.base.func_78789_a(-6.0F, 10.0F, -6.0F, 12, 6, 12);
/*  63 */     this.base.func_78793_a(0.0F, 0.0F, 0.0F);
/*  64 */     this.base.func_78787_b(64, 64);
/*  65 */     this.base.field_78809_i = true;
/*  66 */     setRotation(this.base, 0.0F, 0.0F, 0.0F);
/*     */     
/*  68 */     this.armR = new ModelRenderer(this, 0, 30);
/*  69 */     this.armR.func_78789_a(7.0F, 1.0F, 0.0F, 2, 19, 2);
/*  70 */     this.armR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  71 */     this.armR.func_78787_b(64, 64);
/*  72 */     this.armR.field_78809_i = true;
/*  73 */     setRotation(this.armR, 0.0F, 0.0F, 0.0F);
/*     */     
/*  75 */     this.armL = new ModelRenderer(this, 0, 30);
/*  76 */     this.armL.func_78789_a(-9.0F, 1.0F, 0.0F, 2, 19, 2);
/*  77 */     this.armL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  78 */     this.armL.func_78787_b(64, 64);
/*  79 */     this.armL.field_78809_i = true;
/*  80 */     setRotation(this.armL, 0.0F, 0.0F, 0.0F);
/*     */     
/*  82 */     this.armLBase = new ModelRenderer(this, 8, 30);
/*  83 */     this.armLBase.func_78789_a(-9.0F, 20.0F, 0.0F, 2, 12, 2);
/*  84 */     this.armLBase.func_78793_a(0.0F, 0.0F, 0.0F);
/*  85 */     this.armLBase.func_78787_b(64, 64);
/*  86 */     this.armLBase.field_78809_i = true;
/*  87 */     setRotation(this.armLBase, 0.0F, 0.0F, 0.0F);
/*     */     
/*  89 */     this.armRBase = new ModelRenderer(this, 8, 30);
/*  90 */     this.armRBase.func_78789_a(7.0F, 20.0F, 0.0F, 2, 12, 2);
/*  91 */     this.armRBase.func_78793_a(0.0F, 0.0F, 0.0F);
/*  92 */     this.armRBase.func_78787_b(64, 64);
/*  93 */     this.armRBase.field_78809_i = true;
/*  94 */     setRotation(this.armRBase, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  98 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/*  99 */     this.sides.func_78785_a(f5);
/* 100 */     this.sides1.func_78785_a(f5);
/* 101 */     this.sides2.func_78785_a(f5);
/* 102 */     this.sides3.func_78785_a(f5);
/* 103 */     this.contents.func_78785_a(f5);
/* 104 */     this.base.func_78785_a(f5);
/*     */   }
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 108 */     model.field_78795_f = x;
/* 109 */     model.field_78796_g = y;
/* 110 */     model.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void renderModel(float scale, boolean lit, boolean stand) {
/* 114 */     this.sides.func_78785_a(scale);
/* 115 */     this.sides1.func_78785_a(scale);
/* 116 */     this.sides2.func_78785_a(scale);
/* 117 */     this.sides3.func_78785_a(scale);
/* 118 */     this.base.func_78785_a(scale);
/*     */     
/* 120 */     if (lit) {
/* 121 */       this.contents.func_78785_a(scale);
/*     */     }
/* 123 */     if (stand) {
/* 124 */       this.armL.func_78785_a(scale);
/* 125 */       this.armR.func_78785_a(scale);
/* 126 */       this.armLBase.func_78785_a(scale);
/* 127 */       this.armRBase.func_78785_a(scale);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/model/ModelCrucible.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */