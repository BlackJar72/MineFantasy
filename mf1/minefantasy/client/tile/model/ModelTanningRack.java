/*    */ package minefantasy.client.tile.model;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModelTanningRack
/*    */   extends ModelBase
/*    */ {
/*    */   ModelRenderer Base;
/*    */   ModelRenderer side2;
/*    */   ModelRenderer side1;
/*    */   ModelRenderer Top;
/*    */   
/*    */   public ModelTanningRack()
/*    */   {
/* 22 */     this.field_78090_t = 64;
/* 23 */     this.field_78089_u = 64;
/*    */     
/* 25 */     this.Base = new ModelRenderer(this, 0, 0);
/* 26 */     this.Base.func_78789_a(-8.0F, 22.0F, -2.5F, 16, 2, 5);
/* 27 */     this.Base.func_78793_a(0.0F, 0.0F, 0.0F);
/* 28 */     this.Base.func_78787_b(64, 32);
/* 29 */     this.Base.field_78809_i = true;
/* 30 */     setRotation(this.Base, 0.0F, 0.0F, 0.0F);
/* 31 */     this.side2 = new ModelRenderer(this, 54, 0);
/* 32 */     this.side2.func_78789_a(6.0F, 5.0F, -1.5F, 2, 17, 3);
/* 33 */     this.side2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 34 */     this.side2.func_78787_b(64, 32);
/* 35 */     this.side2.field_78809_i = true;
/* 36 */     setRotation(this.side2, 0.0F, 0.0F, 0.0F);
/* 37 */     this.side1 = new ModelRenderer(this, 54, 0);
/* 38 */     this.side1.field_78809_i = true;
/* 39 */     this.side1.func_78789_a(-8.0F, 5.0F, -1.5F, 2, 17, 3);
/* 40 */     this.side1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 41 */     this.side1.func_78787_b(64, 32);
/* 42 */     this.side1.field_78809_i = true;
/* 43 */     setRotation(this.side1, 0.0F, 0.0F, 0.0F);
/* 44 */     this.side1.field_78809_i = false;
/* 45 */     this.Top = new ModelRenderer(this, 0, 27);
/* 46 */     this.Top.func_78789_a(-6.0F, 6.0F, -0.5F, 12, 3, 2);
/* 47 */     this.Top.func_78793_a(0.0F, 0.0F, 0.0F);
/* 48 */     this.Top.func_78787_b(64, 32);
/* 49 */     this.Top.field_78809_i = true;
/* 50 */     setRotation(this.Top, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 54 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/* 55 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 56 */     this.Base.func_78785_a(f5);
/* 57 */     this.Top.func_78785_a(f5);
/* 58 */     this.side1.func_78785_a(f5);
/* 59 */     this.side2.func_78785_a(f5);
/*    */   }
/*    */   
/*    */   public void renderModel(float f5) {
/* 63 */     this.Base.func_78785_a(f5);
/* 64 */     this.Top.func_78785_a(f5);
/* 65 */     this.side1.func_78785_a(f5);
/* 66 */     this.side2.func_78785_a(f5);
/*    */   }
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 70 */     model.field_78795_f = x;
/* 71 */     model.field_78796_g = y;
/* 72 */     model.field_78808_h = z;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/model/ModelTanningRack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */