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
/*     */ public class ModelOven
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer sideRight;
/*     */   ModelRenderer Top;
/*     */   ModelRenderer leg2;
/*     */   ModelRenderer Front;
/*     */   ModelRenderer Base;
/*     */   ModelRenderer Back;
/*     */   ModelRenderer sideLeft;
/*     */   ModelRenderer leg4;
/*     */   ModelRenderer leg1;
/*     */   ModelRenderer leg3;
/*     */   ModelRenderer Heat;
/*     */   
/*     */   public ModelOven()
/*     */   {
/*  30 */     this.field_78090_t = 128;
/*  31 */     this.field_78089_u = 64;
/*     */     
/*  33 */     this.Heat = new ModelRenderer(this, 40, 37);
/*  34 */     this.Heat.func_78789_a(-4.0F, 1.5F, -4.0F, 8, 1, 8);
/*  35 */     this.Heat.func_78793_a(0.0F, -3.0F, 0.0F);
/*  36 */     this.Heat.func_78787_b(128, 64);
/*  37 */     this.Heat.field_78809_i = true;
/*     */     
/*  39 */     this.sideRight = new ModelRenderer(this, 0, 0);
/*  40 */     this.sideRight.func_78789_a(5.0F, -11.0F, -7.0F, 2, 11, 14);
/*  41 */     this.sideRight.func_78793_a(0.0F, 0.0F, 0.0F);
/*  42 */     this.sideRight.field_78809_i = true;
/*  43 */     this.Top = new ModelRenderer(this, 0, 25);
/*  44 */     this.Top.func_78789_a(-5.0F, -13.0F, -5.0F, 10, 2, 10);
/*  45 */     this.Top.func_78793_a(0.0F, 0.0F, 0.0F);
/*  46 */     this.Top.field_78809_i = true;
/*  47 */     this.leg2 = new ModelRenderer(this, 32, 13);
/*  48 */     this.leg2.func_78789_a(3.0F, 0.0F, -6.0F, 3, 5, 3);
/*  49 */     this.leg2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  50 */     this.leg2.field_78809_i = true;
/*  51 */     this.Front = new ModelRenderer(this, 32, 0);
/*  52 */     this.Front.func_78789_a(-5.0F, -11.0F, -7.0F, 10, 3, 2);
/*  53 */     this.Front.func_78793_a(0.0F, 0.0F, 0.0F);
/*  54 */     this.Front.field_78809_i = true;
/*  55 */     this.Base = new ModelRenderer(this, 0, 25);
/*  56 */     this.Base.func_78789_a(-5.0F, 0.0F, -5.0F, 10, 2, 10);
/*  57 */     this.Base.func_78793_a(0.0F, 0.0F, 0.0F);
/*  58 */     this.Base.field_78809_i = true;
/*  59 */     this.Back = new ModelRenderer(this, 32, 0);
/*  60 */     this.Back.func_78789_a(-5.0F, -11.0F, 5.0F, 10, 11, 2);
/*  61 */     this.Back.func_78793_a(0.0F, 0.0F, 0.0F);
/*  62 */     this.Back.field_78809_i = true;
/*  63 */     this.sideLeft = new ModelRenderer(this, 0, 0);
/*  64 */     this.sideLeft.func_78789_a(-7.0F, -11.0F, -7.0F, 2, 11, 14);
/*  65 */     this.sideLeft.func_78793_a(0.0F, 0.0F, 0.0F);
/*  66 */     this.sideLeft.field_78809_i = true;
/*  67 */     this.leg4 = new ModelRenderer(this, 32, 13);
/*  68 */     this.leg4.func_78789_a(3.0F, 0.0F, 3.0F, 3, 5, 3);
/*  69 */     this.leg4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  70 */     this.leg4.field_78809_i = true;
/*  71 */     this.leg1 = new ModelRenderer(this, 32, 13);
/*  72 */     this.leg1.func_78789_a(-6.0F, 0.0F, -6.0F, 3, 5, 3);
/*  73 */     this.leg1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  74 */     this.leg1.field_78809_i = true;
/*  75 */     this.leg3 = new ModelRenderer(this, 32, 13);
/*  76 */     this.leg3.func_78789_a(-6.0F, 0.0F, 3.0F, 3, 5, 3);
/*  77 */     this.leg3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  78 */     this.leg3.field_78809_i = true;
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  82 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/*  83 */     renderModel(false, f5);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void renderModel(boolean lit, float f)
/*     */   {
/*  92 */     this.sideRight.func_78785_a(f);
/*  93 */     this.Top.func_78785_a(f);
/*  94 */     this.leg2.func_78785_a(f);
/*  95 */     this.Front.func_78785_a(f);
/*  96 */     this.Base.func_78785_a(f);
/*  97 */     this.Back.func_78785_a(f);
/*  98 */     this.sideLeft.func_78785_a(f);
/*  99 */     this.leg4.func_78785_a(f);
/* 100 */     this.leg1.func_78785_a(f);
/* 101 */     this.leg3.func_78785_a(f);
/*     */     
/* 103 */     if (lit) {
/* 104 */       this.Heat.func_78785_a(f);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/model/ModelOven.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */