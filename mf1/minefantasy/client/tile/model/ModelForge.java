/*     */ package minefantasy.client.tile.model;
/*     */ 
/*     */ import minefantasy.client.tile.TileEntityForge;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelForge
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer Back;
/*     */   ModelRenderer lava;
/*     */   ModelRenderer coal;
/*     */   ModelRenderer Right;
/*     */   ModelRenderer cornerBR;
/*     */   ModelRenderer Left;
/*     */   ModelRenderer Base;
/*     */   ModelRenderer front;
/*     */   ModelRenderer cornerBL;
/*     */   ModelRenderer cornerFR;
/*     */   ModelRenderer cornerFL;
/*     */   
/*     */   public ModelForge()
/*     */   {
/*  30 */     this.field_78090_t = 64;
/*  31 */     this.field_78089_u = 64;
/*     */     
/*  33 */     this.Back = new ModelRenderer(this, 0, 0);
/*  34 */     this.Back.func_78789_a(-6.0F, -6.0F, -8.0F, 12, 7, 2);
/*  35 */     this.Back.func_78793_a(0.0F, 22.0F, 0.0F);
/*  36 */     this.Back.field_78809_i = true;
/*  37 */     setRotation(this.Back, 0.0F, 1.570796F, 0.0F);
/*  38 */     this.lava = new ModelRenderer(this, 32, 0);
/*     */     
/*  40 */     this.coal = new ModelRenderer(this, 0, 44);
/*  41 */     this.coal.func_78789_a(-8.0F, -0.1F, -8.0F, 16, 0, 16);
/*  42 */     this.coal.func_78789_a(-8.0F, -0.5F, -8.0F, 16, 0, 16);
/*  43 */     this.coal.func_78789_a(-8.0F, -1.0F, -8.0F, 16, 0, 16);
/*     */     
/*  45 */     this.lava.func_78789_a(-8.0F, -1.5F, -8.0F, 16, 0, 16);
/*  46 */     this.lava.func_78793_a(0.0F, 22.0F, 0.0F);
/*  47 */     this.coal.func_78793_a(0.0F, 22.0F, 0.0F);
/*  48 */     this.lava.field_78809_i = true;
/*  49 */     setRotation(this.lava, 0.0F, 0.0F, 0.0F);
/*  50 */     this.Right = new ModelRenderer(this, 0, 0);
/*  51 */     this.Right.func_78789_a(-6.0F, -6.0F, 6.0F, 12, 7, 2);
/*  52 */     this.Right.func_78793_a(0.0F, 22.0F, 0.0F);
/*  53 */     this.Right.field_78809_i = true;
/*  54 */     setRotation(this.Right, 0.0F, 0.0F, 0.0F);
/*  55 */     this.cornerBR = new ModelRenderer(this, 0, 0);
/*  56 */     this.cornerBR.func_78789_a(-8.0F, -6.0F, -8.0F, 2, 7, 2);
/*  57 */     this.cornerBR.func_78793_a(0.0F, 22.0F, 0.0F);
/*  58 */     this.cornerBR.field_78809_i = true;
/*  59 */     setRotation(this.cornerBR, 0.0F, 1.570796F, 0.0F);
/*  60 */     this.Left = new ModelRenderer(this, 0, 0);
/*  61 */     this.Left.func_78789_a(-6.0F, -6.0F, -8.0F, 12, 7, 2);
/*  62 */     this.Left.func_78793_a(0.0F, 22.0F, 0.0F);
/*  63 */     this.Left.field_78809_i = true;
/*  64 */     setRotation(this.Left, 0.0F, 0.0F, 0.0F);
/*  65 */     this.Base = new ModelRenderer(this, 0, 15);
/*  66 */     this.Base.func_78789_a(-8.0F, 1.0F, -8.0F, 16, 1, 16);
/*  67 */     this.Base.func_78793_a(0.0F, 22.0F, 0.0F);
/*  68 */     this.Base.field_78809_i = true;
/*  69 */     setRotation(this.Base, 0.0F, 0.0F, 0.0F);
/*  70 */     this.front = new ModelRenderer(this, 0, 0);
/*  71 */     this.front.func_78789_a(-6.0F, -6.0F, 6.0F, 12, 7, 2);
/*  72 */     this.front.func_78793_a(0.0F, 22.0F, 0.0F);
/*  73 */     this.front.field_78809_i = true;
/*  74 */     setRotation(this.front, 0.0F, 1.570796F, 0.0F);
/*  75 */     this.cornerBL = new ModelRenderer(this, 0, 0);
/*  76 */     this.cornerBL.func_78789_a(6.0F, -6.0F, -8.0F, 2, 7, 2);
/*  77 */     this.cornerBL.func_78793_a(0.0F, 22.0F, 0.0F);
/*  78 */     this.cornerBL.field_78809_i = true;
/*  79 */     setRotation(this.cornerBL, 0.0F, 1.570796F, 0.0F);
/*  80 */     this.cornerFR = new ModelRenderer(this, 0, 0);
/*  81 */     this.cornerFR.func_78789_a(-8.0F, -6.0F, 6.0F, 2, 7, 2);
/*  82 */     this.cornerFR.func_78793_a(0.0F, 22.0F, 0.0F);
/*  83 */     this.cornerFR.field_78809_i = true;
/*  84 */     setRotation(this.cornerFR, 0.0F, 1.570796F, 0.0F);
/*  85 */     this.cornerFL = new ModelRenderer(this, 0, 0);
/*  86 */     this.cornerFL.func_78789_a(6.0F, -6.0F, 6.0F, 2, 7, 2);
/*  87 */     this.cornerFL.func_78793_a(0.0F, 22.0F, 0.0F);
/*  88 */     this.cornerFL.field_78809_i = true;
/*  89 */     setRotation(this.cornerFL, 0.0F, 1.570796F, 0.0F);
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  93 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/*  94 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*  95 */     this.Back.func_78785_a(f5);
/*  96 */     this.lava.func_78785_a(f5);
/*  97 */     this.Right.func_78785_a(f5);
/*  98 */     this.cornerBR.func_78785_a(f5);
/*  99 */     this.Left.func_78785_a(f5);
/* 100 */     this.Base.func_78785_a(f5);
/* 101 */     this.front.func_78785_a(f5);
/* 102 */     this.cornerBL.func_78785_a(f5);
/* 103 */     this.cornerFR.func_78785_a(f5);
/* 104 */     this.cornerFL.func_78785_a(f5);
/*     */   }
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 108 */     model.field_78795_f = x;
/* 109 */     model.field_78796_g = y;
/* 110 */     model.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void renderModel(TileEntityForge forge, float scale) {
/* 114 */     boolean[] sides = forge.showSides();
/*     */     
/* 116 */     if (sides[0] != 0) {
/* 117 */       this.front.func_78785_a(scale);
/*     */     }
/* 119 */     if (sides[1] != 0) {
/* 120 */       this.Left.func_78785_a(scale);
/*     */     }
/* 122 */     if (sides[2] != 0) {
/* 123 */       this.Right.func_78785_a(scale);
/*     */     }
/* 125 */     if (sides[3] != 0) {
/* 126 */       this.Back.func_78785_a(scale);
/*     */     }
/* 128 */     if ((sides[3] != 0) || (sides[2] != 0)) {
/* 129 */       this.cornerBR.func_78785_a(scale);
/*     */     }
/* 131 */     if ((sides[3] != 0) || (sides[1] != 0)) {
/* 132 */       this.cornerBL.func_78785_a(scale);
/*     */     }
/* 134 */     if ((sides[0] != 0) || (sides[2] != 0)) {
/* 135 */       this.cornerFR.func_78785_a(scale);
/*     */     }
/* 137 */     if ((sides[0] != 0) || (sides[1] != 0)) {
/* 138 */       this.cornerFL.func_78785_a(scale);
/*     */     }
/* 140 */     this.Base.func_78785_a(scale);
/* 141 */     if (forge.fuel > 0) {
/* 142 */       this.coal.func_78785_a(scale);
/*     */     }
/* 144 */     if (forge.isBurning()) {
/* 145 */       this.lava.func_78785_a(scale);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/model/ModelForge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */