/*    */ package minefantasy.client.tile.model;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModelSpinningWheel
/*    */   extends ModelBase
/*    */ {
/*    */   ModelRenderer postR;
/*    */   ModelRenderer Base;
/*    */   ModelRenderer twine;
/*    */   ModelRenderer post;
/*    */   ModelRenderer leg3;
/*    */   ModelRenderer postL;
/*    */   ModelRenderer leg1;
/*    */   ModelRenderer leg2;
/*    */   ModelRenderer back;
/*    */   
/*    */   public ModelSpinningWheel()
/*    */   {
/* 28 */     this.field_78090_t = 64;
/* 29 */     this.field_78089_u = 32;
/*    */     
/* 31 */     this.postR = new ModelRenderer(this, 0, 0);
/* 32 */     this.postR.func_78789_a(1.0F, -3.0F, -1.0F, 2, 6, 2);
/* 33 */     this.postR.func_78793_a(0.0F, 8.0F, 0.0F);
/*    */     
/* 35 */     this.back = new ModelRenderer(this, 0, 15);
/* 36 */     this.back.func_78789_a(-4.0F, 2.0F, 2.0F, 8, 4, 5);
/* 37 */     this.back.func_78793_a(0.0F, 8.0F, 0.0F);
/*    */     
/* 39 */     this.twine = new ModelRenderer(this, 0, 13);
/* 40 */     this.twine.func_78789_a(-1.5F, -2.0F, -7.0F, 3, 1, 1);
/* 41 */     this.twine.func_78793_a(0.0F, 8.0F, 0.0F);
/*    */     
/* 43 */     this.post = new ModelRenderer(this, 0, 0);
/* 44 */     this.post.func_78789_a(-0.5F, -1.0F, -7.0F, 1, 4, 1);
/* 45 */     this.post.func_78793_a(0.0F, 8.0F, 0.0F);
/*    */     
/* 47 */     this.leg3 = new ModelRenderer(this, 0, 0);
/* 48 */     this.leg3.func_78789_a(-1.0F, 6.0F, -7.0F, 2, 6, 2);
/* 49 */     this.leg3.func_78793_a(0.0F, 8.0F, 0.0F);
/*    */     
/* 51 */     this.postL = new ModelRenderer(this, 0, 0);
/* 52 */     this.postL.func_78789_a(-3.0F, -3.0F, -1.0F, 2, 6, 2);
/* 53 */     this.postL.func_78793_a(0.0F, 8.0F, 0.0F);
/*    */     
/* 55 */     this.leg1 = new ModelRenderer(this, 0, 0);
/* 56 */     this.leg1.func_78789_a(-4.0F, 6.0F, 0.0F, 2, 6, 2);
/* 57 */     this.leg1.func_78793_a(0.0F, 8.0F, 3.0F);
/*    */     
/* 59 */     this.leg2 = new ModelRenderer(this, 0, 0);
/* 60 */     this.leg2.func_78789_a(2.0F, 6.0F, 0.0F, 2, 6, 2);
/* 61 */     this.leg2.func_78793_a(0.0F, 8.0F, 3.0F);
/*    */     
/* 63 */     this.Base = new ModelRenderer(this, 0, 0);
/* 64 */     this.Base.func_78789_a(-4.0F, 3.0F, -8.0F, 8, 3, 10);
/* 65 */     this.Base.func_78793_a(0.0F, 8.0F, 0.0F);
/*    */   }
/*    */   
/*    */   public void renderModel(float f) {
/* 69 */     this.postR.func_78785_a(f);
/* 70 */     this.Base.func_78785_a(f);
/* 71 */     this.twine.func_78785_a(f);
/* 72 */     this.post.func_78785_a(f);
/* 73 */     this.leg3.func_78785_a(f);
/* 74 */     this.postL.func_78785_a(f);
/* 75 */     this.leg1.func_78785_a(f);
/* 76 */     this.leg2.func_78785_a(f);
/* 77 */     this.back.func_78785_a(f);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/model/ModelSpinningWheel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */