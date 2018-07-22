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
/*     */ 
/*     */ public class ModelFurnaceMF
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer Wall4t;
/*     */   ModelRenderer Wall1;
/*     */   ModelRenderer Wall2;
/*     */   ModelRenderer Top;
/*     */   ModelRenderer Wall3;
/*     */   ModelRenderer Wall4;
/*     */   ModelRenderer lava;
/*     */   ModelRenderer Base;
/*     */   ModelRenderer contents;
/*     */   
/*     */   public ModelFurnaceMF()
/*     */   {
/*  28 */     this.field_78090_t = 128;
/*  29 */     this.field_78089_u = 64;
/*     */     
/*  31 */     this.Wall4t = new ModelRenderer(this, 76, 50);
/*  32 */     this.Wall1 = new ModelRenderer(this, 0, 27);
/*  33 */     this.Wall2 = new ModelRenderer(this, 0, 27);
/*  34 */     this.Top = new ModelRenderer(this, 0, 0);
/*  35 */     this.Wall3 = new ModelRenderer(this, 48, 50);
/*  36 */     this.Wall4 = new ModelRenderer(this, 76, 60);
/*  37 */     this.lava = new ModelRenderer(this, 26, 27);
/*  38 */     this.Base = new ModelRenderer(this, 0, 0);
/*  39 */     this.contents = new ModelRenderer(this, 0, 41);
/*     */     
/*  41 */     this.Wall4t.func_78789_a(-6.0F, -12.0F, -8.0F, 12, 3, 2);
/*  42 */     this.Wall4t.func_78793_a(0.0F, 0.0F, 0.0F);
/*  43 */     this.Wall4t.func_78787_b(128, 64);
/*  44 */     this.Wall4t.field_78809_i = true;
/*  45 */     setRotation(this.Wall4t, 0.0F, 1.570796F, 0.0F);
/*     */     
/*  47 */     this.Wall1.func_78789_a(-8.0F, -12.0F, 6.0F, 16, 12, 2);
/*  48 */     this.Wall1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  49 */     this.Wall1.func_78787_b(128, 64);
/*  50 */     this.Wall1.field_78809_i = true;
/*  51 */     setRotation(this.Wall1, 0.0F, 3.141593F, 0.0F);
/*     */     
/*  53 */     this.Wall2.func_78789_a(-8.0F, -12.0F, 6.0F, 16, 12, 2);
/*  54 */     this.Wall2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  55 */     this.Wall2.func_78787_b(128, 64);
/*  56 */     this.Wall2.field_78809_i = true;
/*  57 */     setRotation(this.Wall2, 0.0F, 0.0F, 0.0F);
/*     */     
/*  59 */     this.Top.func_78789_a(-8.0F, -14.0F, -8.0F, 16, 2, 16);
/*  60 */     this.Top.func_78793_a(0.0F, 0.0F, 0.0F);
/*  61 */     this.Top.func_78787_b(128, 64);
/*  62 */     this.Top.field_78809_i = true;
/*  63 */     setRotation(this.Top, 0.0F, 0.0F, 0.0F);
/*     */     
/*  65 */     this.Wall3.func_78789_a(-6.0F, -12.0F, 6.0F, 12, 12, 2);
/*  66 */     this.Wall3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  67 */     this.Wall3.func_78787_b(128, 64);
/*  68 */     this.Wall3.field_78809_i = true;
/*  69 */     setRotation(this.Wall3, 0.0F, 1.570796F, 0.0F);
/*     */     
/*  71 */     this.Wall4.func_78789_a(-6.0F, -2.0F, -8.0F, 12, 2, 2);
/*  72 */     this.Wall4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  73 */     this.Wall4.func_78787_b(128, 64);
/*  74 */     this.Wall4.field_78809_i = true;
/*  75 */     setRotation(this.Wall4, 0.0F, 1.570796F, 0.0F);
/*     */     
/*  77 */     this.lava.func_78789_a(-5.0F, -2.0F, -5.0F, 10, 0, 10);
/*  78 */     this.lava.func_78793_a(0.0F, 0.0F, 0.0F);
/*  79 */     this.lava.func_78787_b(128, 64);
/*  80 */     this.lava.field_78809_i = true;
/*  81 */     setRotation(this.lava, 0.0F, 0.0F, 0.0F);
/*     */     
/*  83 */     this.Base.func_78789_a(-8.0F, -2.0F, -8.0F, 16, 2, 16);
/*  84 */     this.Base.func_78793_a(0.0F, 0.0F, 0.0F);
/*  85 */     this.Base.func_78787_b(128, 64);
/*  86 */     this.Base.field_78809_i = true;
/*  87 */     setRotation(this.Base, 3.141593F, 0.0F, 0.0F);
/*     */     
/*  89 */     this.contents.func_78789_a(-6.0F, -1.0F, -6.0F, 12, 1, 12);
/*  90 */     this.contents.func_78793_a(0.0F, 0.0F, 0.0F);
/*  91 */     this.contents.func_78787_b(128, 64);
/*  92 */     this.contents.field_78809_i = true;
/*  93 */     setRotation(this.contents, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  97 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/*  98 */     renderModel(false, f5);
/*     */   }
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 102 */     model.field_78795_f = x;
/* 103 */     model.field_78796_g = y;
/* 104 */     model.field_78808_h = z;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void renderModel(boolean lit, float f)
/*     */   {
/* 113 */     if (lit) {
/* 114 */       this.lava.func_78785_a(f);
/*     */     }
/* 116 */     this.Top.func_78785_a(f);
/* 117 */     this.contents.func_78785_a(f);
/* 118 */     this.Base.func_78785_a(f);
/* 119 */     this.Wall4t.func_78785_a(f);
/* 120 */     this.Wall1.func_78785_a(f);
/* 121 */     this.Wall2.func_78785_a(f);
/* 122 */     this.Wall3.func_78785_a(f);
/* 123 */     this.Wall4.func_78785_a(f);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/model/ModelFurnaceMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */