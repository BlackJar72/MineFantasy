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
/*    */ public class ModelTripHammerBack
/*    */   extends ModelBase
/*    */ {
/*    */   ModelRenderer Legs;
/*    */   ModelRenderer Head;
/*    */   ModelRenderer TableTip;
/*    */   ModelRenderer Table;
/*    */   ModelRenderer Wheel1B;
/*    */   ModelRenderer Axle;
/*    */   ModelRenderer Joint;
/*    */   ModelRenderer Wheel1;
/*    */   
/*    */   public ModelTripHammerBack()
/*    */   {
/* 26 */     this.field_78090_t = 64;
/* 27 */     this.field_78089_u = 32;
/*    */     
/* 29 */     this.Legs = new ModelRenderer(this, 22, 11);
/* 30 */     this.Legs.func_78789_a(-5.0F, 1.0F, -4.0F, 2, 8, 8);
/* 31 */     this.Legs.func_78793_a(8.0F, 15.0F, 0.0F);
/* 32 */     this.Legs.func_78787_b(64, 32);
/* 33 */     setRotation(this.Legs, 0.0F, 0.0F, 0.0F);
/* 34 */     this.Head = new ModelRenderer(this, 34, 27);
/* 35 */     this.Head.func_78789_a(-15.0F, -1.25F, -1.0F, 3, 3, 2);
/* 36 */     this.Head.func_78793_a(6.0F, 12.0F, 0.0F);
/* 37 */     this.Head.func_78787_b(64, 32);
/* 38 */     setRotation(this.Head, 0.0F, 0.0F, 0.0F);
/* 39 */     this.TableTip = new ModelRenderer(this, 0, 11);
/* 40 */     this.TableTip.func_78789_a(-13.0F, 1.0F, -3.0F, 5, 8, 6);
/* 41 */     this.TableTip.func_78793_a(8.0F, 15.0F, 0.0F);
/* 42 */     this.TableTip.func_78787_b(64, 32);
/* 43 */     setRotation(this.TableTip, 0.0F, 0.0F, 0.0F);
/* 44 */     this.Table = new ModelRenderer(this, 20, 0);
/* 45 */     this.Table.func_78789_a(-10.0F, -1.0F, -4.0F, 14, 3, 8);
/* 46 */     this.Table.func_78793_a(2.0F, 15.0F, 0.0F);
/* 47 */     this.Table.func_78787_b(64, 32);
/* 48 */     setRotation(this.Table, 0.0F, 0.0F, 0.0F);
/* 49 */     this.Wheel1B = new ModelRenderer(this, 42, 11);
/* 50 */     this.Wheel1B.func_78789_a(-5.0F, -5.0F, 4.0F, 10, 10, 1);
/* 51 */     this.Wheel1B.func_78793_a(-1.0F, 11.0F, 0.0F);
/* 52 */     this.Wheel1B.func_78787_b(64, 32);
/* 53 */     setRotation(this.Wheel1B, 0.0F, 0.0F, 0.0F);
/* 54 */     this.Axle = new ModelRenderer(this, 0, 27);
/* 55 */     this.Axle.func_78789_a(-6.0F, -0.5F, -0.5F, 12, 1, 1);
/* 56 */     this.Axle.func_78793_a(-1.0F, 11.0F, 0.0F);
/* 57 */     this.Axle.func_78787_b(64, 32);
/* 58 */     setRotation(this.Axle, 0.0F, 1.570796F, 0.0F);
/* 59 */     this.Joint = new ModelRenderer(this, 0, 0);
/* 60 */     this.Joint.func_78789_a(-8.0F, -6.0F, -2.0F, 6, 6, 4);
/* 61 */     this.Joint.func_78793_a(2.0F, 15.0F, 0.0F);
/* 62 */     this.Joint.func_78787_b(64, 32);
/* 63 */     setRotation(this.Joint, 0.0F, 0.0F, 0.0F);
/* 64 */     this.Wheel1 = new ModelRenderer(this, 42, 11);
/* 65 */     this.Wheel1.func_78789_a(-5.0F, -5.0F, -5.0F, 10, 10, 1);
/* 66 */     this.Wheel1.func_78793_a(-1.0F, 11.0F, 0.0F);
/* 67 */     this.Wheel1.func_78787_b(64, 32);
/* 68 */     setRotation(this.Wheel1, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 72 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/* 73 */     this.Legs.func_78785_a(f5);
/* 74 */     this.Head.func_78785_a(f5);
/* 75 */     this.TableTip.func_78785_a(f5);
/* 76 */     this.Table.func_78785_a(f5);
/* 77 */     this.Wheel1B.func_78785_a(f5);
/* 78 */     this.Axle.func_78785_a(f5);
/* 79 */     this.Joint.func_78785_a(f5);
/* 80 */     this.Wheel1.func_78785_a(f5);
/*    */   }
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 84 */     model.field_78795_f = x;
/* 85 */     model.field_78796_g = y;
/* 86 */     model.field_78808_h = z;
/*    */   }
/*    */   
/*    */   public void renderModel(float p, float f) {
/* 90 */     this.Legs.func_78785_a(f);
/* 91 */     this.Head.func_78785_a(f);
/* 92 */     this.TableTip.func_78785_a(f);
/* 93 */     this.Table.func_78785_a(f);
/*    */     
/* 95 */     this.Axle.func_78785_a(f);
/* 96 */     this.Joint.func_78785_a(f);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/model/ModelTripHammerBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */