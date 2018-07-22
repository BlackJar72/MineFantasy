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
/*    */ public class ModelTripHammer
/*    */   extends ModelBase
/*    */ {
/*    */   ModelRenderer Legs;
/*    */   ModelRenderer Head;
/*    */   ModelRenderer TableTip;
/*    */   ModelRenderer Table;
/*    */   ModelRenderer Wheel;
/*    */   ModelRenderer Arm;
/*    */   
/*    */   public ModelTripHammer()
/*    */   {
/* 24 */     this.field_78090_t = 64;
/* 25 */     this.field_78089_u = 32;
/*    */     
/* 27 */     this.Legs = new ModelRenderer(this, 22, 11);
/* 28 */     this.Legs.func_78789_a(-6.0F, 1.0F, -4.0F, 2, 8, 8);
/* 29 */     this.Legs.func_78793_a(8.0F, 15.0F, 0.0F);
/* 30 */     this.Legs.func_78787_b(64, 32);
/* 31 */     setRotation(this.Legs, 0.0F, 0.0F, 0.0F);
/* 32 */     this.Head = new ModelRenderer(this, 34, 27);
/* 33 */     this.Head.func_78789_a(-15.5F, -1.25F, -1.0F, 3, 3, 2);
/* 34 */     this.Head.func_78793_a(6.0F, 12.0F, 0.0F);
/* 35 */     this.Head.func_78787_b(64, 32);
/* 36 */     setRotation(this.Head, 0.0F, 0.0F, 0.0F);
/* 37 */     this.TableTip = new ModelRenderer(this, 0, 11);
/* 38 */     this.TableTip.func_78789_a(-18.0F, -1.0F, -3.0F, 5, 10, 6);
/* 39 */     this.TableTip.func_78793_a(8.0F, 15.0F, 0.0F);
/* 40 */     this.TableTip.func_78787_b(64, 32);
/* 41 */     setRotation(this.TableTip, 0.0F, 0.0F, 0.0F);
/* 42 */     this.Table = new ModelRenderer(this, 20, 0);
/* 43 */     this.Table.func_78789_a(-7.0F, -1.0F, -4.0F, 14, 3, 8);
/* 44 */     this.Table.func_78793_a(2.0F, 15.0F, 0.0F);
/* 45 */     this.Table.func_78787_b(64, 32);
/* 46 */     setRotation(this.Table, 0.0F, 0.0F, 0.0F);
/* 47 */     this.Wheel = new ModelRenderer(this, 0, 0);
/* 48 */     this.Wheel.func_78789_a(2.0F, -6.0F, -2.0F, 6, 6, 4);
/* 49 */     this.Wheel.func_78793_a(2.0F, 15.0F, 0.0F);
/* 50 */     this.Wheel.func_78787_b(64, 32);
/* 51 */     setRotation(this.Wheel, 0.0F, 0.0F, 0.0F);
/* 52 */     this.Arm = new ModelRenderer(this, 0, 27);
/* 53 */     this.Arm.func_78789_a(-15.0F, -1.0F, -0.5F, 16, 2, 1);
/* 54 */     this.Arm.func_78793_a(6.0F, 12.0F, 0.0F);
/* 55 */     this.Arm.func_78787_b(64, 32);
/* 56 */     setRotation(this.Arm, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 60 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/* 61 */     this.Legs.func_78785_a(f5);
/* 62 */     this.Head.func_78785_a(f5);
/* 63 */     this.TableTip.func_78785_a(f5);
/* 64 */     this.Table.func_78785_a(f5);
/* 65 */     this.Wheel.func_78785_a(f5);
/* 66 */     this.Arm.func_78785_a(f5);
/*    */   }
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 70 */     model.field_78795_f = x;
/* 71 */     model.field_78796_g = y;
/* 72 */     model.field_78808_h = z;
/*    */   }
/*    */   
/*    */   public void renderModel(float p, float f) {
/* 76 */     this.Wheel.func_78785_a(f);
/* 77 */     this.Legs.func_78785_a(f);
/* 78 */     this.Head.func_78785_a(f);
/* 79 */     this.TableTip.func_78785_a(f);
/* 80 */     this.Table.func_78785_a(f);
/* 81 */     this.Wheel.func_78785_a(f);
/* 82 */     this.Arm.func_78785_a(f);
/*    */   }
/*    */   
/*    */   public void rotate(float f) {
/* 86 */     int s = (int)(45.0F * f);
/* 87 */     float rot = (float)Math.toRadians(s);
/* 88 */     this.Arm.field_78808_h = (this.Head.field_78808_h = rot);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/model/ModelTripHammer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */