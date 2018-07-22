/*     */ package minefantasy.client.entityrender;
/*     */ 
/*     */ import minefantasy.entity.EntitySkeletalKnight;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelSkeletalKnight
/*     */   extends ModelBiped
/*     */ {
/*     */   public ModelSkeletalKnight()
/*     */   {
/*  18 */     this.field_78090_t = 128;
/*  19 */     this.field_78089_u = 64;
/*     */     
/*  21 */     this.field_78116_c = new ModelRenderer(this, 46, 0);
/*  22 */     this.field_78115_e = new ModelRenderer(this, 0, 46);
/*  23 */     this.field_78112_f = new ModelRenderer(this, 28, 32);
/*  24 */     this.field_78123_h = new ModelRenderer(this, 28, 51);
/*  25 */     this.field_78113_g = new ModelRenderer(this, 40, 16);
/*  26 */     this.field_78124_i = new ModelRenderer(this, 28, 51);
/*     */     
/*  28 */     this.field_78116_c.func_78784_a(46, 0).func_78789_a(-4.5F, -8.4F, -4.4F, 9, 9, 9);
/*  29 */     this.field_78116_c.func_78793_a(0.0F, 0.0F, 0.0F);
/*  30 */     this.field_78116_c.func_78787_b(128, 64);
/*  31 */     this.field_78116_c.field_78809_i = true;
/*  32 */     setRotation(this.field_78116_c, 0.0F, 0.0F, 0.0F);
/*     */     
/*  34 */     this.field_78115_e.func_78784_a(0, 46).func_78789_a(-4.0F, 0.0F, -3.0F, 8, 12, 6);
/*  35 */     this.field_78115_e.func_78793_a(0.0F, 0.0F, 0.0F);
/*  36 */     this.field_78115_e.func_78787_b(128, 64);
/*  37 */     this.field_78115_e.field_78809_i = true;
/*  38 */     setRotation(this.field_78115_e, 0.0F, 0.0F, 0.0F);
/*     */     
/*  40 */     this.field_78112_f.func_78784_a(28, 32).func_78789_a(-1.5F, -3.0F, -1.5F, 3, 3, 3);
/*  41 */     this.field_78112_f.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  42 */     this.field_78112_f.func_78787_b(128, 64);
/*  43 */     this.field_78112_f.field_78809_i = true;
/*     */     
/*  45 */     this.field_78123_h.func_78784_a(28, 51).func_78789_a(-1.5F, 2.0F, -1.5F, 3, 10, 3);
/*  46 */     this.field_78123_h.func_78793_a(-2.0F, 12.0F, 0.0F);
/*  47 */     this.field_78123_h.func_78787_b(128, 64);
/*  48 */     this.field_78123_h.field_78809_i = true;
/*  49 */     setRotation(this.field_78123_h, 0.0F, 0.0F, 0.0F);
/*     */     
/*  51 */     this.field_78113_g.func_78784_a(40, 16).func_78789_a(-1.0F, -2.0F, -1.0F, 2, 12, 2);
/*  52 */     this.field_78113_g.func_78793_a(5.0F, 2.0F, 0.0F);
/*  53 */     this.field_78113_g.func_78787_b(128, 64);
/*  54 */     this.field_78113_g.field_78809_i = true;
/*  55 */     setRotation(this.field_78113_g, 0.0F, 0.0F, 0.0F);
/*     */     
/*  57 */     this.field_78124_i.func_78784_a(28, 51).func_78789_a(-1.5F, 2.0F, -1.5F, 3, 10, 3);
/*  58 */     this.field_78124_i.func_78793_a(2.0F, 12.0F, 0.0F);
/*  59 */     this.field_78124_i.func_78787_b(128, 64);
/*  60 */     this.field_78124_i.field_78809_i = true;
/*  61 */     setRotation(this.field_78124_i, 0.0F, 0.0F, 0.0F);
/*  62 */     this.field_78113_g.func_78784_a(12, 32).func_78789_a(-1.5F, -3.5F, -1.5F, 4, 5, 4);
/*  63 */     this.field_78113_g.func_78793_a(5.0F, 2.0F, 0.0F);
/*  64 */     this.field_78113_g.func_78787_b(128, 64);
/*  65 */     this.field_78113_g.field_78809_i = true;
/*  66 */     setRotation(this.field_78113_g, 0.0F, 0.0F, 0.0F);
/*  67 */     this.field_78113_g.func_78784_a(0, 30).func_78789_a(-1.5F, 4.5F, -1.5F, 3, 6, 3);
/*  68 */     this.field_78113_g.func_78793_a(5.0F, 2.0F, 0.0F);
/*  69 */     this.field_78113_g.func_78787_b(128, 64);
/*  70 */     this.field_78113_g.field_78809_i = true;
/*  71 */     setRotation(this.field_78113_g, 0.0F, 0.0F, 0.0F);
/*  72 */     this.field_78112_f.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  73 */     this.field_78112_f.func_78787_b(128, 64);
/*  74 */     this.field_78112_f.field_78809_i = true;
/*  75 */     setRotation(this.field_78112_f, 0.0F, 0.0F, 0.0F);
/*  76 */     this.field_78112_f.func_78784_a(40, 30).func_78789_a(-1.5F, 1.0F, -1.5F, 3, 7, 3);
/*  77 */     this.field_78112_f.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  78 */     this.field_78112_f.func_78787_b(128, 64);
/*  79 */     this.field_78112_f.field_78809_i = true;
/*  80 */     this.field_78115_e.func_78784_a(16, 16).func_78789_a(-4.0F, 0.0F, -2.0F, 8, 12, 4);
/*  81 */     this.field_78115_e.func_78793_a(0.0F, 0.0F, 0.0F);
/*  82 */     this.field_78115_e.func_78787_b(128, 64);
/*  83 */     this.field_78115_e.field_78809_i = true;
/*  84 */     setRotation(this.field_78115_e, 0.0F, 0.0F, 0.0F);
/*  85 */     this.field_78123_h.func_78784_a(0, 16).func_78789_a(-1.0F, 0.0F, -1.0F, 2, 12, 2);
/*  86 */     this.field_78123_h.func_78793_a(-2.0F, 12.0F, 0.0F);
/*  87 */     this.field_78123_h.func_78787_b(128, 64);
/*  88 */     this.field_78123_h.field_78809_i = true;
/*  89 */     setRotation(this.field_78123_h, 0.0F, 0.0F, 0.0F);
/*  90 */     this.field_78124_i.func_78784_a(0, 16).func_78789_a(-1.0F, 0.0F, -1.0F, 2, 12, 2);
/*  91 */     this.field_78124_i.func_78793_a(2.0F, 12.0F, 0.0F);
/*  92 */     this.field_78124_i.func_78787_b(128, 64);
/*  93 */     this.field_78124_i.field_78809_i = true;
/*  94 */     setRotation(this.field_78124_i, 0.0F, 0.0F, 0.0F);
/*  95 */     this.field_78116_c.func_78784_a(0, 0).func_78789_a(-4.0F, -8.0F, -4.0F, 8, 8, 8);
/*  96 */     this.field_78116_c.func_78793_a(0.0F, 0.0F, 0.0F);
/*  97 */     this.field_78116_c.func_78787_b(128, 64);
/*  98 */     this.field_78116_c.field_78809_i = true;
/*  99 */     setRotation(this.field_78116_c, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 103 */     model.field_78795_f = x;
/* 104 */     model.field_78796_g = y;
/* 105 */     model.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 109 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/*     */     
/* 111 */     if ((entity instanceof EntitySkeletalKnight)) {
/* 112 */       this.field_78118_o = ((EntitySkeletalKnight)entity).useRanged();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setRotationAngles(EntitySkeletalKnight skele, float f, float f1, float f2, float f3, float f4, float f5) {
/* 117 */     super.func_78087_a(f, f1, f2, f3, f4, f5, skele);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/entityrender/ModelSkeletalKnight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */