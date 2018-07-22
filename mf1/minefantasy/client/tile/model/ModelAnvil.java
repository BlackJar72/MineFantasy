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
/*     */ public class ModelAnvil
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer End;
/*     */   ModelRenderer Post;
/*     */   ModelRenderer Body;
/*     */   ModelRenderer Tip;
/*     */   ModelRenderer Back;
/*     */   ModelRenderer log;
/*     */   ModelRenderer floor;
/*     */   ModelRenderer Base;
/*     */   
/*     */   public ModelAnvil()
/*     */   {
/*  27 */     this.field_78090_t = 64;
/*  28 */     this.field_78089_u = 32;
/*     */     
/*  30 */     this.End = new ModelRenderer(this, 0, 24);
/*  31 */     this.End.func_78789_a(-10.0F, -3.0F, -2.0F, 3, 4, 4);
/*  32 */     this.End.func_78793_a(0.0F, -5.0F, 0.0F);
/*  33 */     this.End.func_78787_b(64, 32);
/*  34 */     this.End.field_78809_i = true;
/*     */     
/*  36 */     setRotation(this.End, 0.0F, 0.0F, 0.0F);
/*  37 */     this.Post = new ModelRenderer(this, 48, 24);
/*  38 */     this.Post.func_78789_a(-2.0F, 0.0F, -2.0F, 4, 4, 4);
/*  39 */     this.Post.func_78793_a(0.0F, -4.0F, 0.0F);
/*  40 */     this.Post.func_78787_b(64, 32);
/*  41 */     this.Post.field_78809_i = true;
/*     */     
/*  43 */     setRotation(this.Post, 0.0F, 0.0F, 0.0F);
/*  44 */     this.Body = new ModelRenderer(this, 32, 0);
/*  45 */     this.Body.func_78789_a(-5.0F, -3.0F, -3.0F, 10, 4, 6);
/*  46 */     this.Body.func_78793_a(0.0F, -5.0F, 0.0F);
/*  47 */     this.Body.func_78787_b(64, 32);
/*  48 */     this.Body.field_78809_i = true;
/*     */     
/*  50 */     setRotation(this.Body, 0.0F, 0.0F, 0.0F);
/*  51 */     this.Tip = new ModelRenderer(this, 0, 10);
/*  52 */     this.Tip.func_78789_a(5.0F, -2.0F, -1.0F, 3, 2, 2);
/*  53 */     this.Tip.func_78793_a(0.0F, -5.0F, 0.0F);
/*  54 */     this.Tip.func_78787_b(64, 32);
/*  55 */     this.Tip.field_78809_i = true;
/*     */     
/*  57 */     setRotation(this.Tip, 0.0F, 0.0F, 0.0F);
/*  58 */     this.Back = new ModelRenderer(this, 0, 19);
/*  59 */     this.Back.func_78789_a(-7.0F, -2.0F, -1.0F, 2, 3, 2);
/*  60 */     this.Back.func_78793_a(0.0F, -5.0F, 0.0F);
/*  61 */     this.Back.func_78787_b(64, 32);
/*  62 */     this.Back.field_78809_i = true;
/*     */     
/*  64 */     setRotation(this.Back, 0.0F, 0.0F, 0.0F);
/*  65 */     this.Base = new ModelRenderer(this, 0, 0);
/*  66 */     this.Base.func_78789_a(-3.0F, 0.0F, -3.0F, 6, 2, 6);
/*  67 */     this.Base.func_78793_a(0.0F, 0.0F, 0.0F);
/*  68 */     this.Base.func_78787_b(64, 32);
/*  69 */     this.Base.field_78809_i = true;
/*     */     
/*  71 */     setRotation(this.Base, 0.0F, 0.0F, 0.0F);
/*  72 */     this.floor = new ModelRenderer(this, 14, 21);
/*  73 */     this.floor.func_78789_a(-4.0F, 2.0F, -4.0F, 8, 3, 8);
/*  74 */     this.floor.func_78793_a(0.0F, 0.0F, 0.0F);
/*  75 */     this.floor.func_78787_b(64, 32);
/*  76 */     this.floor.field_78809_i = true;
/*     */     
/*  78 */     this.log = new ModelRenderer(this, 0, 0);
/*  79 */     this.log.func_78789_a(-8.0F, 2.0F, -8.0F, 16, 16, 16);
/*  80 */     this.log.func_78793_a(0.0F, 0.0F, 0.0F);
/*  81 */     this.log.func_78787_b(64, 32);
/*  82 */     this.log.field_78809_i = true;
/*  83 */     setRotation(this.log, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  87 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/*  88 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*  89 */     this.End.func_78785_a(f5);
/*  90 */     this.Base.func_78785_a(f5);
/*  91 */     this.Post.func_78785_a(f5);
/*  92 */     this.Body.func_78785_a(f5);
/*  93 */     this.Tip.func_78785_a(f5);
/*  94 */     this.Back.func_78785_a(f5);
/*  95 */     this.log.func_78785_a(f5);
/*     */   }
/*     */   
/*     */   public void renderLog(float f) {
/*  99 */     this.log.func_78785_a(f);
/*     */   }
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 103 */     model.field_78795_f = x;
/* 104 */     model.field_78796_g = y;
/* 105 */     model.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void renderModel(boolean big, float f) {
/* 109 */     this.End.func_78785_a(f);
/* 110 */     this.Base.func_78785_a(f);
/* 111 */     this.Post.func_78785_a(f);
/* 112 */     this.Body.func_78785_a(f);
/* 113 */     this.Tip.func_78785_a(f);
/* 114 */     this.Back.func_78785_a(f);
/* 115 */     if (big) {
/* 116 */       this.floor.func_78785_a(f);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/model/ModelAnvil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */