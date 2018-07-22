/*     */ package minefantasy.client.entityrender;
/*     */ 
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ 
/*     */ public class ModelHoundPack extends net.minecraft.client.model.ModelBase
/*     */ {
/*     */   ModelRenderer smlPack;
/*     */   ModelRenderer PackBand;
/*     */   ModelRenderer PaxkBase;
/*     */   ModelRenderer pack2;
/*     */   ModelRenderer bigPack;
/*     */   ModelRenderer pack4;
/*     */   ModelRenderer pack1;
/*     */   ModelRenderer feedbag;
/*     */   ModelRenderer pack3;
/*     */   
/*     */   public ModelHoundPack()
/*     */   {
/*  19 */     this.field_78090_t = 64;
/*  20 */     this.field_78089_u = 32;
/*     */     
/*  22 */     this.smlPack = new ModelRenderer(this, 28, 23);
/*  23 */     this.PackBand = new ModelRenderer(this, 0, 9);
/*  24 */     this.PaxkBase = new ModelRenderer(this, 0, 0);
/*  25 */     this.pack2 = new ModelRenderer(this, 46, 0);
/*  26 */     this.bigPack = new ModelRenderer(this, 0, 21);
/*  27 */     this.pack1 = new ModelRenderer(this, 28, 0);
/*  28 */     this.pack4 = new ModelRenderer(this, 46, 11);
/*  29 */     this.feedbag = new ModelRenderer(this, 50, 20);
/*  30 */     this.pack3 = new ModelRenderer(this, 32, 11);
/*     */     
/*  32 */     this.smlPack.func_78789_a(-4.5F, -8.0F, 3.5F, 7, 4, 5);
/*  33 */     this.smlPack.func_78793_a(0.0F, 14.0F, -3.0F);
/*  34 */     this.smlPack.func_78787_b(64, 32);
/*  35 */     this.smlPack.field_78809_i = true;
/*  36 */     setRotation(this.smlPack, 0.0F, 0.0F, 0.0F);
/*     */     
/*  38 */     this.PackBand.func_78789_a(-5.5F, -4.0F, -2.5F, 9, 9, 2);
/*  39 */     this.PackBand.func_78793_a(0.0F, 14.0F, -3.0F);
/*  40 */     this.PackBand.func_78787_b(64, 32);
/*  41 */     this.PackBand.field_78809_i = true;
/*  42 */     setRotation(this.PackBand, 0.0F, 0.0F, 0.0F);
/*     */     
/*  44 */     this.PaxkBase.func_78789_a(-4.0F, -4.0F, -0.5F, 6, 2, 7);
/*  45 */     this.PaxkBase.func_78793_a(0.0F, 14.0F, -3.0F);
/*  46 */     this.PaxkBase.func_78787_b(64, 32);
/*  47 */     this.PaxkBase.field_78809_i = true;
/*  48 */     setRotation(this.PaxkBase, 0.0F, 0.0F, 0.0F);
/*     */     
/*  50 */     this.pack2.func_78789_a(-8.0F, -8.0F, -1.5F, 4, 6, 5);
/*  51 */     this.pack2.func_78793_a(0.0F, 14.0F, -3.0F);
/*  52 */     this.pack2.func_78787_b(64, 32);
/*  53 */     this.pack2.field_78809_i = true;
/*  54 */     setRotation(this.pack2, 0.0F, 0.0F, 0.0F);
/*     */     
/*  56 */     this.bigPack.func_78789_a(-5.0F, -9.0F, -2.5F, 8, 5, 6);
/*  57 */     this.bigPack.func_78793_a(0.0F, 14.0F, -3.0F);
/*  58 */     this.bigPack.func_78787_b(64, 32);
/*  59 */     this.bigPack.field_78809_i = true;
/*  60 */     setRotation(this.bigPack, 0.0F, 0.0F, 0.0F);
/*     */     
/*  62 */     this.pack4.func_78789_a(-7.0F, -7.0F, -1.5F, 3, 5, 4);
/*  63 */     this.pack4.func_78793_a(0.0F, 14.0F, 3.0F);
/*  64 */     this.pack4.func_78787_b(64, 32);
/*  65 */     this.pack4.field_78809_i = true;
/*  66 */     setRotation(this.pack4, 0.0F, 0.0F, 0.0F);
/*     */     
/*  68 */     this.pack1.func_78789_a(2.0F, -8.0F, -1.5F, 4, 6, 5);
/*  69 */     this.pack1.func_78793_a(0.0F, 14.0F, -3.0F);
/*  70 */     this.pack1.func_78787_b(64, 32);
/*  71 */     this.pack1.field_78809_i = true;
/*  72 */     setRotation(this.pack1, 0.0F, 0.0F, 0.0F);
/*     */     
/*  74 */     this.feedbag.func_78789_a(-3.0F, 4.0F, -10.5F, 4, 4, 3);
/*  75 */     this.feedbag.func_78793_a(0.0F, 14.0F, 3.0F);
/*  76 */     this.feedbag.func_78787_b(64, 32);
/*  77 */     this.feedbag.field_78809_i = true;
/*  78 */     setRotation(this.feedbag, 0.0F, 0.0F, 0.0F);
/*     */     
/*  80 */     this.pack3.func_78789_a(2.0F, -7.0F, -1.5F, 3, 5, 4);
/*  81 */     this.pack3.func_78793_a(0.0F, 14.0F, 3.0F);
/*  82 */     this.pack3.func_78787_b(64, 32);
/*  83 */     this.pack3.field_78809_i = true;
/*  84 */     setRotation(this.pack3, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public void func_78088_a(net.minecraft.entity.Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  88 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/*  89 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*  90 */     this.smlPack.func_78785_a(f5);
/*  91 */     this.PackBand.func_78785_a(f5);
/*  92 */     this.PaxkBase.func_78785_a(f5);
/*  93 */     this.pack2.func_78785_a(f5);
/*  94 */     this.bigPack.func_78785_a(f5);
/*  95 */     this.pack4.func_78785_a(f5);
/*  96 */     this.pack1.func_78785_a(f5);
/*  97 */     this.feedbag.func_78785_a(f5);
/*  98 */     this.pack3.func_78785_a(f5);
/*     */   }
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 102 */     model.field_78795_f = x;
/* 103 */     model.field_78796_g = y;
/* 104 */     model.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, net.minecraft.entity.Entity entity) {
/* 108 */     super.func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/entityrender/ModelHoundPack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */