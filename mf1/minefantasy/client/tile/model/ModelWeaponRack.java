/*    */ package minefantasy.client.tile.model;
/*    */ 
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ public class ModelWeaponRack extends net.minecraft.client.model.ModelBase
/*    */ {
/*    */   ModelRenderer rStrut;
/*    */   ModelRenderer beam;
/*    */   ModelRenderer rack1;
/*    */   ModelRenderer lStrut;
/*    */   ModelRenderer divider3;
/*    */   ModelRenderer divider1;
/*    */   ModelRenderer dividerR;
/*    */   ModelRenderer divider2;
/*    */   ModelRenderer dividerL;
/*    */   
/*    */   public ModelWeaponRack()
/*    */   {
/* 20 */     this.field_78090_t = 64;
/* 21 */     this.field_78089_u = 32;
/*    */     
/* 23 */     this.rStrut = new ModelRenderer(this, 0, 0);
/* 24 */     this.rStrut.func_78789_a(7.0F, 0.0F, 6.0F, 1, 16, 2);
/* 25 */     this.rStrut.func_78793_a(0.0F, 0.0F, 0.0F);
/*    */     
/* 27 */     this.beam = new ModelRenderer(this, 0, 29);
/* 28 */     this.beam.func_78789_a(-8.0F, 13.0F, 5.0F, 16, 1, 1);
/* 29 */     this.beam.func_78793_a(0.0F, 0.0F, 0.0F);
/*    */     
/* 31 */     this.rack1 = new ModelRenderer(this, 0, 29);
/* 32 */     this.rack1.func_78789_a(-8.0F, 3.0F, 5.0F, 16, 2, 1);
/* 33 */     this.rack1.func_78793_a(0.0F, 0.0F, 0.0F);
/*    */     
/* 35 */     this.lStrut = new ModelRenderer(this, 0, 0);
/* 36 */     this.lStrut.func_78789_a(-8.0F, 0.0F, 6.0F, 1, 16, 2);
/* 37 */     this.lStrut.func_78793_a(0.0F, 0.0F, 0.0F);
/*    */     
/* 39 */     this.divider3 = new ModelRenderer(this, 0, 29);
/* 40 */     this.divider3.func_78789_a(3.0F, 4.0F, 3.0F, 2, 1, 2);
/* 41 */     this.divider3.func_78793_a(0.0F, 0.0F, 0.0F);
/*    */     
/* 43 */     this.divider1 = new ModelRenderer(this, 0, 29);
/* 44 */     this.divider1.func_78789_a(-1.0F, 4.0F, 3.0F, 2, 1, 2);
/* 45 */     this.divider1.func_78793_a(0.0F, 0.0F, 0.0F);
/*    */     
/* 47 */     this.dividerR = new ModelRenderer(this, 1, 29);
/* 48 */     this.dividerR.func_78789_a(7.0F, 4.0F, 3.0F, 1, 1, 2);
/* 49 */     this.dividerR.func_78793_a(0.0F, 0.0F, 0.0F);
/*    */     
/* 51 */     this.divider2 = new ModelRenderer(this, 0, 29);
/* 52 */     this.divider2.func_78789_a(-5.0F, 4.0F, 3.0F, 2, 1, 2);
/* 53 */     this.divider2.func_78793_a(0.0F, 0.0F, 0.0F);
/*    */     
/* 55 */     this.dividerL = new ModelRenderer(this, 0, 29);
/* 56 */     this.dividerL.func_78789_a(-8.0F, 4.0F, 3.0F, 1, 1, 2);
/* 57 */     this.dividerL.func_78793_a(0.0F, 0.0F, 0.0F);
/*    */   }
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 61 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/* 62 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 63 */     this.rStrut.func_78785_a(f5);
/* 64 */     this.beam.func_78785_a(f5);
/* 65 */     this.rack1.func_78785_a(f5);
/* 66 */     this.lStrut.func_78785_a(f5);
/* 67 */     this.divider3.func_78785_a(f5);
/* 68 */     this.divider1.func_78785_a(f5);
/* 69 */     this.dividerR.func_78785_a(f5);
/* 70 */     this.divider2.func_78785_a(f5);
/* 71 */     this.dividerL.func_78785_a(f5);
/*    */   }
/*    */   
/*    */   public void renderModel(float scale) {
/* 75 */     this.rStrut.func_78785_a(scale);
/* 76 */     this.beam.func_78785_a(scale);
/* 77 */     this.rack1.func_78785_a(scale);
/* 78 */     this.lStrut.func_78785_a(scale);
/* 79 */     this.divider3.func_78785_a(scale);
/* 80 */     this.divider1.func_78785_a(scale);
/* 81 */     this.dividerR.func_78785_a(scale);
/* 82 */     this.divider2.func_78785_a(scale);
/* 83 */     this.dividerL.func_78785_a(scale);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/model/ModelWeaponRack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */