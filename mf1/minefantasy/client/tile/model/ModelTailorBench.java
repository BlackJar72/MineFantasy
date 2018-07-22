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
/*    */ public class ModelTailorBench
/*    */   extends ModelBase
/*    */ {
/*    */   ModelRenderer Right;
/*    */   ModelRenderer Left;
/*    */   ModelRenderer bottomShelf;
/*    */   ModelRenderer Top;
/*    */   
/*    */   public ModelTailorBench()
/*    */   {
/* 23 */     this.field_78090_t = 128;
/* 24 */     this.field_78089_u = 64;
/*    */     
/* 26 */     this.Right = new ModelRenderer(this, 48, 0);
/* 27 */     this.Right.func_78789_a(6.0F, 5.0F, -8.0F, 2, 15, 16);
/* 28 */     this.Right.func_78793_a(0.0F, 0.0F, 0.0F);
/* 29 */     this.Right.func_78787_b(128, 64);
/*    */     
/* 31 */     this.Left = new ModelRenderer(this, 48, 0);
/* 32 */     this.Left.func_78789_a(-8.0F, 5.0F, -8.0F, 2, 15, 16);
/* 33 */     this.Left.func_78793_a(0.0F, 0.0F, 0.0F);
/* 34 */     this.Left.func_78787_b(128, 64);
/*    */     
/* 36 */     this.Top = new ModelRenderer(this, 0, 27);
/* 37 */     this.Top.func_78789_a(-8.0F, 4.0F, -8.0F, 16, 1, 16);
/* 38 */     this.Top.func_78793_a(0.0F, 0.0F, 0.0F);
/* 39 */     this.Top.func_78787_b(128, 64);
/*    */     
/* 41 */     this.bottomShelf = new ModelRenderer(this, 45, 48);
/* 42 */     this.bottomShelf.func_78789_a(-6.0F, 13.0F, -7.0F, 12, 1, 15);
/* 43 */     this.bottomShelf.func_78793_a(0.0F, 0.0F, 0.0F);
/* 44 */     this.bottomShelf.func_78787_b(128, 64);
/*    */   }
/*    */   
/*    */   public void renderModel(float f) {
/* 48 */     this.Right.func_78785_a(f);
/* 49 */     this.Left.func_78785_a(f);
/* 50 */     this.Top.func_78785_a(f);
/* 51 */     this.bottomShelf.func_78785_a(f);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/model/ModelTailorBench.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */