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
/*    */ public class ModelDogbowl
/*    */   extends ModelBase
/*    */ {
/*    */   ModelRenderer Wall;
/*    */   ModelRenderer Wall1;
/*    */   ModelRenderer Wall2;
/*    */   ModelRenderer Wall3;
/*    */   ModelRenderer Food;
/*    */   ModelRenderer Base;
/*    */   
/*    */   public ModelDogbowl()
/*    */   {
/* 24 */     this.field_78090_t = 64;
/* 25 */     this.field_78089_u = 32;
/*    */     
/* 27 */     this.Wall = new ModelRenderer(this, 18, 0);
/* 28 */     this.Wall.func_78789_a(3.0F, -4.0F, -4.0F, 1, 4, 8);
/*    */     
/* 30 */     this.Wall1 = new ModelRenderer(this, 0, 0);
/* 31 */     this.Wall1.func_78789_a(-3.0F, -4.0F, 3.0F, 6, 4, 1);
/*    */     
/* 33 */     this.Wall2 = new ModelRenderer(this, 18, 0);
/* 34 */     this.Wall2.func_78789_a(-4.0F, -4.0F, -4.0F, 1, 4, 8);
/*    */     
/* 36 */     this.Wall3 = new ModelRenderer(this, 0, 0);
/* 37 */     this.Wall3.func_78789_a(-3.0F, -4.0F, -4.0F, 6, 4, 1);
/*    */     
/* 39 */     this.Food = new ModelRenderer(this, 0, 22);
/* 40 */     this.Food.func_78789_a(-3.0F, 0.5F, -3.0F, 6, 0, 6);
/* 41 */     this.Food.func_78793_a(0.0F, 0.0F, 0.0F);
/* 42 */     this.Food.func_78787_b(64, 32);
/* 43 */     this.Food.field_78809_i = true;
/*    */     
/* 45 */     this.Base = new ModelRenderer(this, 0, 12);
/* 46 */     this.Base.func_78789_a(-4.5F, 0.0F, -4.5F, 9, 1, 9);
/* 47 */     this.Base.func_78793_a(0.0F, 0.0F, 0.0F);
/* 48 */     this.Base.func_78787_b(64, 32);
/* 49 */     this.Base.field_78809_i = true;
/*    */   }
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 53 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/*    */   }
/*    */   
/*    */   public void renderModel(int food, float foodMax, float f) {
/* 57 */     this.Base.func_78785_a(f);
/* 58 */     this.Wall.func_78785_a(f);
/* 59 */     this.Wall1.func_78785_a(f);
/* 60 */     this.Wall2.func_78785_a(f);
/* 61 */     this.Wall3.func_78785_a(f);
/*    */     
/* 63 */     float start = 0.6F;
/*    */     
/* 65 */     float fill = (3.5F - start) / foodMax * food;
/*    */     
/* 67 */     this.Food.field_78797_d = (-start - Math.min(fill, 4.0F - start));
/*    */     
/* 69 */     if (food > 0) {
/* 70 */       this.Food.func_78785_a(f);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/model/ModelDogbowl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */