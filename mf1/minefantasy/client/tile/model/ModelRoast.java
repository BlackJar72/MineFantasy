/*    */ package minefantasy.client.tile.model;
/*    */ 
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ public class ModelRoast extends net.minecraft.client.model.ModelBase
/*    */ {
/*    */   ModelRenderer side2B;
/*    */   ModelRenderer side1B;
/*    */   ModelRenderer Top;
/*    */   ModelRenderer side2;
/*    */   ModelRenderer side1;
/*    */   
/*    */   public ModelRoast()
/*    */   {
/* 16 */     this.field_78090_t = 64;
/* 17 */     this.field_78089_u = 32;
/*    */     
/* 19 */     this.side2B = new ModelRenderer(this, 10, 4);
/* 20 */     this.side1B = new ModelRenderer(this, 10, 4);
/* 21 */     this.Top = new ModelRenderer(this, 0, 0);
/* 22 */     this.side2 = new ModelRenderer(this, 0, 4);
/* 23 */     this.side1 = new ModelRenderer(this, 0, 4);
/*    */     
/* 25 */     this.side2B.func_78789_a(7.0F, 22.0F, -1.5F, 2, 17, 3);
/* 26 */     this.side2B.func_78793_a(0.0F, 2.0F, 0.0F);
/* 27 */     this.side2B.func_78787_b(64, 32);
/* 28 */     this.side2B.field_78809_i = true;
/* 29 */     this.side1B.field_78809_i = true;
/* 30 */     this.side1B.func_78789_a(-9.0F, 22.0F, -1.5F, 2, 17, 3);
/* 31 */     this.side1B.func_78793_a(0.0F, 2.0F, 0.0F);
/* 32 */     this.side1B.func_78787_b(64, 32);
/* 33 */     this.side1B.field_78809_i = true;
/* 34 */     this.side1B.field_78809_i = false;
/* 35 */     this.Top.func_78789_a(-8.0F, 12.0F, -1.0F, 16, 2, 2);
/* 36 */     this.Top.func_78793_a(0.0F, 2.0F, 0.0F);
/* 37 */     this.Top.func_78787_b(64, 32);
/* 38 */     this.Top.field_78809_i = true;
/* 39 */     this.side2.func_78789_a(7.0F, 5.0F, -1.5F, 2, 17, 3);
/* 40 */     this.side2.func_78793_a(0.0F, 2.0F, 0.0F);
/* 41 */     this.side2.func_78787_b(64, 32);
/* 42 */     this.side2.field_78809_i = true;
/* 43 */     this.side1.func_78789_a(-9.0F, 5.0F, -1.5F, 2, 17, 3);
/* 44 */     this.side1.func_78793_a(0.0F, 2.0F, 0.0F);
/* 45 */     this.side1.func_78787_b(64, 32);
/* 46 */     this.side1.field_78809_i = true;
/*    */   }
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 50 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/* 51 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 52 */     this.Top.func_78785_a(f5);
/* 53 */     this.side1.func_78785_a(f5);
/* 54 */     this.side2.func_78785_a(f5);
/*    */   }
/*    */   
/*    */   public void renderModel(boolean L, boolean R, float scale, boolean base) {
/* 58 */     this.Top.func_78785_a(scale);
/* 59 */     if (L)
/* 60 */       this.side1.func_78785_a(scale);
/* 61 */     if (R)
/* 62 */       this.side2.func_78785_a(scale);
/* 63 */     if (base) {
/* 64 */       if (L)
/* 65 */         this.side1B.func_78785_a(scale);
/* 66 */       if (R) {
/* 67 */         this.side2B.func_78785_a(scale);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/model/ModelRoast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */