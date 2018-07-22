/*    */ package minefantasy.client.tile.model;
/*    */ 
/*    */ import minefantasy.client.tile.TileEntityFirepit;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModelFirepit
/*    */   extends ModelBase
/*    */ {
/*    */   ModelRenderer Base;
/*    */   ModelRenderer Plank1;
/*    */   ModelRenderer Plank2;
/*    */   ModelRenderer Plank3;
/*    */   ModelRenderer Plank4;
/*    */   ModelRenderer Pile;
/*    */   
/*    */   public ModelFirepit()
/*    */   {
/* 26 */     this.field_78090_t = 64;
/* 27 */     this.field_78089_u = 32;
/*    */     
/* 29 */     this.Base = new ModelRenderer(this, 0, 15);
/* 30 */     this.Pile = new ModelRenderer(this, 0, 6);
/*    */     
/* 32 */     this.Plank1 = new ModelRenderer(this, 24, 0);
/* 33 */     this.Plank2 = new ModelRenderer(this, 24, 0);
/* 34 */     this.Plank3 = new ModelRenderer(this, 0, 0);
/* 35 */     this.Plank4 = new ModelRenderer(this, 0, 0);
/*    */     
/* 37 */     this.Base.func_78789_a(-5.0F, 3.0F, -5.0F, 10, 3, 10);
/* 38 */     this.Base.func_78793_a(0.0F, 0.0F, 0.0F);
/* 39 */     this.Base.func_78787_b(64, 32);
/* 40 */     this.Base.field_78809_i = true;
/* 41 */     setRotation(this.Base, 0.0F, 0.0F, 0.0F);
/* 42 */     this.Plank2.func_78789_a(-1.5F, -1.5F, -4.5F, 3, 3, 9);
/* 43 */     this.Plank2.func_78793_a(0.0F, 3.0F, 5.0F);
/* 44 */     this.Plank2.func_78787_b(64, 32);
/* 45 */     this.Plank2.field_78809_i = true;
/* 46 */     this.Plank1.func_78789_a(-1.5F, -1.5F, -4.5F, 3, 3, 9);
/* 47 */     this.Plank1.func_78793_a(0.0F, 3.0F, -5.0F);
/* 48 */     this.Plank1.func_78787_b(64, 32);
/* 49 */     this.Plank1.field_78809_i = true;
/* 50 */     this.Plank3.func_78789_a(-4.5F, -1.5F, -1.5F, 9, 3, 3);
/* 51 */     this.Plank3.func_78793_a(-5.0F, 3.0F, 0.0F);
/* 52 */     this.Plank3.func_78787_b(64, 32);
/* 53 */     this.Plank3.field_78809_i = true;
/* 54 */     this.Plank4.func_78789_a(-4.5F, -1.5F, -1.5F, 9, 3, 3);
/* 55 */     this.Plank4.func_78793_a(5.0F, 3.0F, 0.0F);
/* 56 */     this.Plank4.func_78787_b(64, 32);
/* 57 */     this.Plank4.field_78809_i = true;
/* 58 */     this.Pile.func_78789_a(-3.0F, 0.0F, -3.0F, 6, 3, 6);
/* 59 */     this.Pile.func_78793_a(0.0F, 0.0F, 0.0F);
/* 60 */     this.Pile.func_78787_b(64, 32);
/* 61 */     this.Pile.field_78809_i = true;
/* 62 */     setRotation(this.Pile, 0.0F, 0.0F, 0.0F);
/*    */     
/* 64 */     float angle = 0.7853982F;
/*    */     
/* 66 */     setRotation(this.Plank1, angle, 0.0F, 0.0F);
/* 67 */     setRotation(this.Plank2, -angle, 0.0F, 0.0F);
/* 68 */     setRotation(this.Plank3, 0.0F, 0.0F, -angle);
/* 69 */     setRotation(this.Plank4, 0.0F, 0.0F, angle);
/*    */   }
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 73 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/*    */   }
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 77 */     model.field_78795_f = x;
/* 78 */     model.field_78796_g = y;
/* 79 */     model.field_78808_h = z;
/*    */   }
/*    */   
/*    */   public void renderModel(TileEntityFirepit pit, float f) {
/* 83 */     this.Base.func_78785_a(f);
/*    */     
/* 85 */     if ((pit != null) && (
/* 86 */       (pit.fuel > 0) || (pit.field_70331_k == null))) {
/* 87 */       this.Plank1.func_78785_a(f);
/* 88 */       this.Plank2.func_78785_a(f);
/* 89 */       this.Plank3.func_78785_a(f);
/* 90 */       this.Plank4.func_78785_a(f);
/* 91 */       this.Pile.func_78785_a(f);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/model/ModelFirepit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */