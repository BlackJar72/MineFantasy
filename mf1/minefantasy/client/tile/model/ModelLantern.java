/*     */ package minefantasy.client.tile.model;
/*     */ 
/*     */ import minefantasy.client.tile.TileEntityLantern;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelLantern
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer Lamp;
/*     */   ModelRenderer BarZP;
/*     */   ModelRenderer BarXP;
/*     */   ModelRenderer BarXM;
/*     */   ModelRenderer BarZM;
/*     */   ModelRenderer BarZT;
/*     */   
/*     */   public ModelLantern()
/*     */   {
/*  25 */     this.field_78090_t = 64;
/*  26 */     this.field_78089_u = 32;
/*     */     
/*  28 */     this.Lamp = new ModelRenderer(this, 32, 0);
/*  29 */     this.Lamp.func_78784_a(32, 0).func_78789_a(-1.0F, 6.0F, -1.0F, 2, 6, 2);
/*  30 */     this.Lamp.func_78784_a(32, 0).func_78789_a(-4.0F, 0.0F, -4.0F, 8, 4, 8);
/*  31 */     this.Lamp.func_78784_a(32, 0).func_78789_a(-4.0F, 12.0F, -4.0F, 8, 4, 8);
/*  32 */     this.Lamp.func_78784_a(32, 16).func_78789_a(-4.0F, 4.0F, -4.0F, 8, 8, 8);
/*  33 */     this.Lamp.func_78793_a(0.0F, 0.0F, 0.0F);
/*  34 */     this.Lamp.func_78787_b(64, 32);
/*  35 */     this.Lamp.field_78809_i = true;
/*  36 */     setRotation(this.Lamp, 0.0F, 0.0F, 0.0F);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  45 */     this.BarXM = new ModelRenderer(this, 0, 0);
/*  46 */     this.BarXM.func_78789_a(-8.0F, 10.0F, -2.0F, 2, 2, 4);
/*  47 */     this.BarXM.func_78793_a(0.0F, 0.0F, 0.0F);
/*  48 */     this.BarXM.func_78787_b(64, 32);
/*  49 */     this.BarXM.field_78809_i = true;
/*  50 */     setRotation(this.BarXM, 0.0F, 0.0F, 0.0F);
/*     */     
/*  52 */     this.BarXM.func_78789_a(-8.0F, 2.0F, -2.0F, 2, 2, 4);
/*  53 */     this.BarXM.func_78793_a(0.0F, 0.0F, 0.0F);
/*  54 */     this.BarXM.func_78787_b(64, 32);
/*  55 */     this.BarXM.field_78809_i = true;
/*  56 */     setRotation(this.BarXM, 0.0F, 0.0F, 0.0F);
/*     */     
/*  58 */     this.BarZP = new ModelRenderer(this, 0, 0);
/*  59 */     this.BarZP.func_78789_a(-2.0F, 10.0F, 4.0F, 2, 2, 4);
/*  60 */     this.BarZP.func_78793_a(0.0F, 0.0F, 0.0F);
/*  61 */     this.BarZP.func_78787_b(64, 32);
/*  62 */     this.BarZP.field_78809_i = true;
/*  63 */     setRotation(this.BarZP, 0.0F, 0.0F, 0.0F);
/*     */     
/*  65 */     this.BarZP.func_78789_a(-2.0F, 2.0F, 4.0F, 2, 2, 4);
/*  66 */     this.BarZP.func_78793_a(0.0F, 0.0F, 0.0F);
/*  67 */     this.BarZP.func_78787_b(64, 32);
/*  68 */     this.BarZP.field_78809_i = true;
/*  69 */     setRotation(this.BarZP, 0.0F, 0.0F, 0.0F);
/*     */     
/*  71 */     this.BarXP = new ModelRenderer(this, 0, 0);
/*  72 */     this.BarXP.func_78789_a(4.0F, 10.0F, -2.0F, 2, 2, 4);
/*  73 */     this.BarXP.func_78793_a(0.0F, 0.0F, 0.0F);
/*  74 */     this.BarXP.func_78787_b(64, 32);
/*  75 */     this.BarXP.field_78809_i = true;
/*  76 */     setRotation(this.BarXP, 0.0F, 0.0F, 0.0F);
/*     */     
/*  78 */     this.BarXP.func_78789_a(4.0F, 2.0F, -2.0F, 2, 2, 4);
/*  79 */     this.BarXP.func_78793_a(0.0F, 0.0F, 0.0F);
/*  80 */     this.BarXP.func_78787_b(64, 32);
/*  81 */     this.BarXP.field_78809_i = true;
/*  82 */     setRotation(this.BarXP, 0.0F, 0.0F, 0.0F);
/*     */     
/*  84 */     this.BarZM = new ModelRenderer(this, 0, 0);
/*  85 */     this.BarZM.func_78789_a(-2.0F, 10.0F, -8.0F, 2, 2, 4);
/*  86 */     this.BarZM.func_78793_a(0.0F, 0.0F, 0.0F);
/*  87 */     this.BarZM.func_78787_b(64, 32);
/*  88 */     this.BarZM.field_78809_i = true;
/*  89 */     setRotation(this.BarZM, 0.0F, 0.0F, 0.0F);
/*     */     
/*  91 */     this.BarZM.func_78789_a(-2.0F, 2.0F, -8.0F, 2, 2, 4);
/*  92 */     this.BarZM.func_78793_a(0.0F, 0.0F, 0.0F);
/*  93 */     this.BarZM.func_78787_b(64, 32);
/*  94 */     this.BarZM.field_78809_i = true;
/*  95 */     setRotation(this.BarZM, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  99 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/* 100 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 101 */     this.Lamp.func_78785_a(f5);
/*     */   }
/*     */   
/*     */   public void renderModel(TileEntityLantern te, float f5) {
/* 105 */     this.Lamp.func_78785_a(f5);
/*     */     
/* 107 */     if (te.neighbourBlock[0] != 0) {
/* 108 */       this.BarXM.func_78785_a(f5);
/* 109 */     } else if (te.neighbourBlock[1] != 0) {
/* 110 */       this.BarXP.func_78785_a(f5);
/* 111 */     } else if (te.neighbourBlock[2] != 0) {
/* 112 */       this.BarZM.func_78785_a(f5);
/* 113 */     } else if (te.neighbourBlock[3] != 0) {
/* 114 */       this.BarZP.func_78785_a(f5);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z)
/*     */   {
/* 121 */     model.field_78795_f = x;
/* 122 */     model.field_78796_g = y;
/* 123 */     model.field_78808_h = z;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/model/ModelLantern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */